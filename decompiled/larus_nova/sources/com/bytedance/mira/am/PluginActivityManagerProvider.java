package com.bytedance.mira.am;

import android.app.ActivityManager;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.ProviderInfo;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.os.Build;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.Process;
import android.os.RemoteException;
import android.text.TextUtils;
import com.bytedance.android.livesdkapi.app.AppConstants;
import com.bytedance.mira.Mira;
import com.bytedance.mira.core.BinderProvider;
import com.bytedance.mira.helper.MiraThreadPoolHelper;
import com.bytedance.mira.log.MiraLogger;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes3.dex */
public class PluginActivityManagerProvider extends BinderProvider {
    private static final int KILL_PROCESS_DELAY = 30000;
    private static final int MESSAGE_KILL_PROCESS = 1;
    private static final int SHIFT = 24;
    private static final String TAG = "PluginActivityManagerProvider";
    final TreeMap<String, ProcessRecord> mBusyProcesses;
    Handler mHandler;
    AtomicBoolean mInited;
    final ProcessMap mProcessMap;
    final TreeMap<String, ProcessRecord> mSpareProcesses;
    final Object mWaitLock;

    public class PluginAMBinder extends IPluginActivityManager.Stub {
        private static final String TAG = "PluginAMBinder";
        final /* synthetic */ PluginActivityManagerProvider this$0;

        /* JADX INFO: loaded from: classes21.dex */
        public final class AppDeathRecipient implements IBinder.DeathRecipient {
            private IApplicationThread mAppThread;
            private int mPid;
            private String mProcessName;
            final /* synthetic */ PluginAMBinder this$1;

            @Override // android.os.IBinder.DeathRecipient
            public void binderDied() {
                PluginActivityManagerProvider r100 = this.this$1.this$0;
                monitor-enter(r100);
                Iterator<Map.Entry<String, ProcessRecord>> r101 = this.this$1.this$0.mBusyProcesses.entrySet().iterator();     // Catch: Throwable -> L20
                int r102 = 0;
            L6:
                if (r101.hasNext() == false) goto L14;
                Map.Entry<String, ProcessRecord> r103 = r101.next();     // Catch: Throwable -> L20
                ProcessRecord r104 = r103.getValue();     // Catch: Throwable -> L20
                if (r104.mPid == this.mPid) goto L13;
                if (TextUtils.equals(r104.mProcessName, this.mProcessName) == true) goto L13;
                r102 = r102 + r104.mRunningActivities.size();     // Catch: Throwable -> L20
            L13:
                MiraLogger.w(MiraLogger.TAG_PAM, "PluginAMBinderprocess has died, pid = " + this.mPid);     // Catch: Throwable -> L20
                r104.reset();     // Catch: Throwable -> L20
                r101.remove();     // Catch: Throwable -> L20
                this.this$1.this$0.mSpareProcesses.put(r103.getKey(), r104);     // Catch: Throwable -> L20
                goto L6
            L14:
                if (r102 == 0) goto L16;
            L18:
                monitor-exit(r100);     // Catch: Throwable -> L20
                return;
            L16:
                if (Build.VERSION.SDK_INT >= 29) goto L18;
                KeepAlive.stop();     // Catch: Throwable -> L20
            L20:
                th = move-exception;
                throw th;
            }

            public AppDeathRecipient(PluginAMBinder r100, IApplicationThread r101, String r102, int r103) {
                this.this$1 = r100;
                this.mAppThread = r101;
                this.mProcessName = r102;
                this.mPid = r103;
            }
        }

        private void ensureStubProcessAlive() {
            MiraLogger.d(MiraLogger.TAG_PAM, "PluginAMBinder ensureStubProcessAlive");
            if (this.this$0.mBusyProcesses.isEmpty() == false) goto L5;
            return;
        L5:
            ActivityManager r100 = (ActivityManager) this.this$0.getContext().getSystemService("activity");
            if (r100 != null) goto L8;
            return;
        L8:
            HashSet r101 = new HashSet();
            Iterator<ActivityManager.RunningAppProcessInfo> r102 = r100.getRunningAppProcesses().iterator();
        L10:
            if (r102.hasNext() == false) goto L12;
            r101.add(r102.next().processName);
            goto L10
        L12:
            Iterator<Map.Entry<String, ProcessRecord>> r103 = this.this$0.mBusyProcesses.entrySet().iterator();
        L14:
            if (r103.hasNext() == false) goto L22;
            Map.Entry<String, ProcessRecord> r104 = r103.next();
            if (r101.contains(r104.getKey()) == true) goto L14;
            ProcessRecord r105 = r104.getValue();
            r105.reset();
            r103.remove();
            this.this$0.mSpareProcesses.put(r104.getKey(), r105);
            if (this.this$0.mBusyProcesses.size() != 0) goto L14;
            if (Build.VERSION.SDK_INT >= 29) goto L14;
            KeepAlive.stop();
            goto L14
        }

        private void scheduleGc() {
            MiraLogger.d(MiraLogger.TAG_PAM, "PluginAMBinder scheduleGc");
            ActivityManager r100 = (ActivityManager) this.this$0.getContext().getSystemService("activity");
            if (r100 != null) goto L5;
            return;
        L5:
            List<ActivityManager.RunningAppProcessInfo> r101 = r100.getRunningAppProcesses();
            Iterator<ActivityManager.RunningAppProcessInfo> r102 = r101.iterator();
        L7:
            if (r102.hasNext() == false) goto L15;
            ActivityManager.RunningAppProcessInfo r103 = r102.next();
            Set<String> r104 = this.this$0.mBusyProcesses.keySet();
            if (r103.uid != Process.myUid()) goto L14;
            if (r104.contains(r103.processName) == false) goto L14;
            if (r103.pid != Process.myPid()) goto L7;
        L14:
            r102.remove();
            goto L7
        L15:
            Iterator<ActivityManager.RunningAppProcessInfo> r105 = r101.iterator();
        L17:
            if (r105.hasNext() == false) goto L27;
            ActivityManager.RunningAppProcessInfo r106 = r105.next();
            int r107 = r106.importance;
            if (r107 == 1000) goto L26;
            if (r107 == 500) goto L26;
            if (r107 == 400) goto L26;
            if (r107 != 300) goto L17;
        L26:
            doGc(r106);
            goto L17
        }

        private PluginAMBinder(PluginActivityManagerProvider r100) {
            this.this$0 = r100;
        }

        private void doGc(ActivityManager.RunningAppProcessInfo r100) {
            MiraLogger.d(MiraLogger.TAG_PAM, "PluginAMBinder doGc");
            ProcessRecord r101 = this.this$0.mBusyProcesses.get(r100.processName);
            if (r101 == null) goto L42;
            Iterator r102 = new HashSet(r101.mRunningServices.entrySet()).iterator();
        L6:
            if (r102.hasNext() == false) goto L18;
            Map.Entry r103 = (Map.Entry) r102.next();
            if (r103 == null) goto L6;
            if (((ArrayList) r103.getValue()).size() != 0) goto L6;
            r102.remove();
            Iterator<ServiceInfo> r104 = r101.mStubServices.values().iterator();
        L13:
            if (r104.hasNext() == false) goto L6;
            ServiceInfo r105 = r104.next();
            if (TextUtils.equals(r105.name, (CharSequence) r103.getKey()) == false) goto L13;
            Intent r106 = new Intent();
            r106.setClassName(r105.packageName, r105.name);
            this.this$0.getContext().stopService(r106);
            goto L13
        L18:
            if (r101.mRunningActivities.size() == 0) goto L20;
            return;
        L20:
            if (r101.mRunningServices.size() == 0) goto L22;
            return;
        L22:
            if (r101.mRunningReceivers.size() == 0) goto L24;
            return;
        L24:
            if (r101.mRunningProviders.size() != 0) goto L46;
            Message r107 = Message.obtain();
            int r108 = r101.mPid;
            if (r108 != 0) goto L29;
            r108 = r100.pid;
        L29:
            r107.what = 16777216 | r108;
            this.this$0.mHandler.sendMessageDelayed(r107, 30000);
            return;
        L46:
            return;
        }

        private void ensureStubProcessDied(ProcessRecord r100) {
            MiraLogger.d(MiraLogger.TAG_PAM, "PluginAMBinder ensureStubProcessDied");
            ActivityManager r101 = (ActivityManager) this.this$0.getContext().getSystemService("activity");
            if (r101 != null) goto L5;
            return;
        L5:
            if (r100.mIsMainProcess == true) goto L27;
            Iterator<ActivityManager.RunningAppProcessInfo> r102 = r101.getRunningAppProcesses().iterator();
        L9:
            if (r102.hasNext() == false) goto L28;
            ActivityManager.RunningAppProcessInfo r103 = r102.next();
            if (TextUtils.equals(r103.processName, r100.mProcessName) == false) goto L9;
            if (Build.BRAND.toLowerCase().equals(AppConstants.CHANNEL_OPPO) == true) goto L9;
            Process.killProcess(r103.pid);     // Catch: Exception -> L16
            Thread.sleep(50);     // Catch: Exception -> L16
            goto L9
        L28:
            return;
        }

        @Override // com.bytedance.mira.am.IPluginActivityManager
        public synchronized ServiceInfo getTargetService(ServiceInfo r100) {
            monitor-enter(this);
            ProcessRecord r101 = this.this$0.mBusyProcesses.get(r100.processName);     // Catch: Throwable -> L19
            if (r101 != null) goto L7;
        L15:
            MiraLogger.i(MiraLogger.TAG_PAM, "PluginAMBinder getTargetService, " + r100 + " >>> null");     // Catch: Throwable -> L19
            monitor-exit(this);
            return null;
        L7:
            if (r101.mRunningServices.containsKey(r100.name) == false) goto L15;
            ArrayList<ServiceInfo> r102 = r101.mRunningServices.get(r100.name);     // Catch: Throwable -> L19
            if (r102 == null) goto L15;
            if (r102.size() <= 0) goto L15;
            MiraLogger.i(MiraLogger.TAG_PAM, "PluginAMBinder getTargetService, " + r100 + " >>> " + ListProtector.get(r102, 0));     // Catch: Throwable -> L19
            ServiceInfo r103 = (ServiceInfo) ListProtector.get(r102, 0);     // Catch: Throwable -> L19
            monitor-exit(this);
            return r103;
        L19:
            th = move-exception;
            throw th;
        }

        @Override // com.bytedance.mira.am.IPluginActivityManager
        public synchronized boolean isStubActivity(ActivityInfo r100) {
            monitor-enter(this);
            Iterator<ProcessRecord> r101 = this.this$0.mBusyProcesses.values().iterator();     // Catch: Throwable -> L23
        L5:
            if (r101.hasNext() == false) goto L11;
            if (r101.next().mStubActivities.get(r100.name) == null) goto L5;
            MiraLogger.d(MiraLogger.TAG_PAM, "PluginAMBinder isStubActivity, " + r100.name + "=true");     // Catch: Throwable -> L23
            monitor-exit(this);
            return true;
        L11:
            Iterator<ProcessRecord> r102 = this.this$0.mSpareProcesses.values().iterator();     // Catch: Throwable -> L23
        L13:
            if (r102.hasNext() == false) goto L19;
            if (r102.next().mStubActivities.get(r100.name) == null) goto L13;
            MiraLogger.d(MiraLogger.TAG_PAM, "PluginAMBinder isStubActivity, " + r100.name + "=true");     // Catch: Throwable -> L23
            monitor-exit(this);
            return true;
        L19:
            MiraLogger.d(MiraLogger.TAG_PAM, "PluginAMBinder isStubActivity, " + r100.name + "=false");     // Catch: Throwable -> L23
            monitor-exit(this);
            return false;
        L23:
            th = move-exception;
            throw th;
        }

        @Override // com.bytedance.mira.am.IPluginActivityManager
        public boolean isStubProvider(ProviderInfo r100) {
            Iterator<ProcessRecord> r101 = this.this$0.mBusyProcesses.values().iterator();
        L4:
            if (r101.hasNext() == false) goto L9;
            if (r101.next().mStubProviders.get(r100.name) == null) goto L4;
            MiraLogger.d(MiraLogger.TAG_PAM, "PluginAMBinder isStubProvider, " + r100.name + "=true");
            return true;
        L9:
            Iterator<ProcessRecord> r102 = this.this$0.mSpareProcesses.values().iterator();
        L11:
            if (r102.hasNext() == false) goto L16;
            if (r102.next().mStubProviders.get(r100.name) == null) goto L11;
            MiraLogger.d(MiraLogger.TAG_PAM, "PluginAMBinder isStubProvider, " + r100.name + "=true");
            return true;
        L16:
            MiraLogger.d(MiraLogger.TAG_PAM, "PluginAMBinder isStubProvider, " + r100.name + "=false");
            return false;
        }

        @Override // com.bytedance.mira.am.IPluginActivityManager
        public boolean isStubReceiver(ActivityInfo r100) {
            Iterator<ProcessRecord> r101 = this.this$0.mBusyProcesses.values().iterator();
        L4:
            if (r101.hasNext() == false) goto L9;
            if (r101.next().mStubReceivers.get(r100.name) == null) goto L4;
            MiraLogger.d(MiraLogger.TAG_PAM, "PluginAMBinder isStubReceiver, " + r100.name + "=true");
            return true;
        L9:
            Iterator<ProcessRecord> r102 = this.this$0.mSpareProcesses.values().iterator();
        L11:
            if (r102.hasNext() == false) goto L16;
            if (r102.next().mStubReceivers.get(r100.name) == null) goto L11;
            MiraLogger.d(MiraLogger.TAG_PAM, "PluginAMBinder isStubReceiver, " + r100.name + "=true");
            return true;
        L16:
            MiraLogger.d(MiraLogger.TAG_PAM, "PluginAMBinder isStubReceiver, " + r100.name + "=false");
            return false;
        }

        @Override // com.bytedance.mira.am.IPluginActivityManager
        public synchronized boolean isStubService(ServiceInfo r100) {
            monitor-enter(this);
            Iterator<ProcessRecord> r101 = this.this$0.mBusyProcesses.values().iterator();     // Catch: Throwable -> L23
        L5:
            if (r101.hasNext() == false) goto L11;
            if (r101.next().mStubServices.get(r100.name) == null) goto L5;
            MiraLogger.d(MiraLogger.TAG_PAM, "PluginAMBinder isStubService, " + r100.name + "=true");     // Catch: Throwable -> L23
            monitor-exit(this);
            return true;
        L11:
            Iterator<ProcessRecord> r102 = this.this$0.mSpareProcesses.values().iterator();     // Catch: Throwable -> L23
        L13:
            if (r102.hasNext() == false) goto L19;
            if (r102.next().mStubServices.get(r100.name) == null) goto L13;
            MiraLogger.d(MiraLogger.TAG_PAM, "PluginAMBinder isStubService, " + r100.name + "=true");     // Catch: Throwable -> L23
            monitor-exit(this);
            return true;
        L19:
            MiraLogger.d(MiraLogger.TAG_PAM, "PluginAMBinder isStubService, " + r100.name + "=false");     // Catch: Throwable -> L23
            monitor-exit(this);
            return false;
        L23:
            th = move-exception;
            throw th;
        }

        @Override // com.bytedance.mira.am.IPluginActivityManager
        public synchronized ActivityInfo selectStubActivity(ActivityInfo r100) {
            monitor-enter(this);
            PluginActivityManagerProvider.access$200(this.this$0);     // Catch: Throwable -> L43
            scheduleGc();     // Catch: Throwable -> L43
            ensureStubProcessAlive();     // Catch: Throwable -> L43
            String r101 = this.this$0.mProcessMap.bestMatch(r100.processName);     // Catch: Throwable -> L43
            if (TextUtils.isEmpty(r101) == false) goto L8;
            r101 = r100.processName;     // Catch: Throwable -> L43
        L8:
            if (TextUtils.isEmpty(r101) == true) goto L21;
            ProcessRecord r102 = this.this$0.mBusyProcesses.get(r101);     // Catch: Throwable -> L43
            if (r102 == null) goto L16;
            ActivityInfo r103 = r102.selectStubActivity(r100);     // Catch: Throwable -> L43
            if (r103 == null) goto L16;
            this.this$0.mHandler.removeMessages(r102.mPid | 16777216);     // Catch: Throwable -> L43
            MiraLogger.d(MiraLogger.TAG_PAM, "PluginAMBinder selectStubActivity from mBusyProcesses, " + r100 + " <<< " + r103);     // Catch: Throwable -> L43
            monitor-exit(this);
            return r103;
        L16:
            ProcessRecord r104 = this.this$0.mSpareProcesses.get(r101);     // Catch: Throwable -> L43
            if (r104 == null) goto L21;
            ActivityInfo r105 = r104.selectStubActivity(r100);     // Catch: Throwable -> L43
            ensureStubProcessDied(r104);     // Catch: Throwable -> L43
            this.this$0.mSpareProcesses.remove(r104.mProcessName);     // Catch: Throwable -> L43
            this.this$0.mBusyProcesses.put(r104.mProcessName, r104);     // Catch: Throwable -> L43
            MiraLogger.d(MiraLogger.TAG_PAM, "PluginAMBinder selectStubActivity from mSpareProcesses, " + r100 + " <<< " + r105);     // Catch: Throwable -> L43
            monitor-exit(this);
            return r105;
        L21:
            Iterator<ProcessRecord> r106 = this.this$0.mBusyProcesses.values().iterator();     // Catch: Throwable -> L43
        L23:
            if (r106.hasNext() == false) goto L31;
            ProcessRecord r107 = r106.next();     // Catch: Throwable -> L43
            if (r107.canRunHere(r100, this.this$0.mProcessMap) == false) goto L23;
            ActivityInfo r108 = r107.selectStubActivity(r100);     // Catch: Throwable -> L43
            if (r108 == null) goto L23;
            this.this$0.mHandler.removeMessages(r107.mPid | 16777216);     // Catch: Throwable -> L43
            MiraLogger.d(MiraLogger.TAG_PAM, "PluginAMBinder selectStubActivity from mBusyProcesses canRunHere, " + r100 + " <<< " + r108);     // Catch: Throwable -> L43
            monitor-exit(this);
            return r108;
        L31:
            Iterator<Map.Entry<String, ProcessRecord>> r109 = this.this$0.mSpareProcesses.entrySet().iterator();     // Catch: Throwable -> L43
        L33:
            if (r109.hasNext() == false) goto L39;
            ProcessRecord r110 = r109.next().getValue();     // Catch: Throwable -> L43
            if (r110.canRunHere(r100, this.this$0.mProcessMap) == false) goto L33;
            ActivityInfo r111 = r110.selectStubActivity(r100);     // Catch: Throwable -> L43
            ensureStubProcessDied(r110);     // Catch: Throwable -> L43
            r109.remove();     // Catch: Throwable -> L43
            this.this$0.mBusyProcesses.put(r110.mProcessName, r110);     // Catch: Throwable -> L43
            MiraLogger.d(MiraLogger.TAG_PAM, "PluginAMBinder selectStubActivity from mSpareProcesses to mBusyProcesses, " + r100 + " <<< " + r111);     // Catch: Throwable -> L43
            monitor-exit(this);
            return r111;
        L39:
            MiraLogger.d(MiraLogger.TAG_PAM, "PluginAMBinder selectStubActivity null, " + r100);     // Catch: Throwable -> L43
            monitor-exit(this);
            return null;
        L43:
            th = move-exception;
            throw th;
        }

        @Override // com.bytedance.mira.am.IPluginActivityManager
        public synchronized ProviderInfo selectStubProvider(ProviderInfo r100) {
            monitor-enter(this);
            PluginActivityManagerProvider.access$200(this.this$0);     // Catch: Throwable -> L43
            scheduleGc();     // Catch: Throwable -> L43
            ensureStubProcessAlive();     // Catch: Throwable -> L43
            String r101 = this.this$0.mProcessMap.bestMatch(r100.processName);     // Catch: Throwable -> L43
            if (TextUtils.isEmpty(r101) == false) goto L8;
            r101 = r100.processName;     // Catch: Throwable -> L43
        L8:
            if (TextUtils.isEmpty(r101) == true) goto L21;
            ProcessRecord r102 = this.this$0.mBusyProcesses.get(r101);     // Catch: Throwable -> L43
            if (r102 == null) goto L16;
            ProviderInfo r103 = r102.selectStubProvider(r100);     // Catch: Throwable -> L43
            if (r103 == null) goto L16;
            this.this$0.mHandler.removeMessages(r102.mPid | 16777216);     // Catch: Throwable -> L43
            MiraLogger.d(MiraLogger.TAG_PAM, "PluginAMBinder selectStubProvider from mBusyProcesses, " + r100 + " <<< " + r103);     // Catch: Throwable -> L43
            monitor-exit(this);
            return r103;
        L16:
            ProcessRecord r104 = this.this$0.mSpareProcesses.get(r101);     // Catch: Throwable -> L43
            if (r104 == null) goto L21;
            ProviderInfo r105 = r104.selectStubProvider(r100);     // Catch: Throwable -> L43
            ensureStubProcessDied(r104);     // Catch: Throwable -> L43
            this.this$0.mSpareProcesses.remove(r104.mProcessName);     // Catch: Throwable -> L43
            this.this$0.mBusyProcesses.put(r104.mProcessName, r104);     // Catch: Throwable -> L43
            MiraLogger.d(MiraLogger.TAG_PAM, "PluginAMBinder selectStubProvider from mSpareProcesses, " + r100 + " <<< " + r105);     // Catch: Throwable -> L43
            monitor-exit(this);
            return r105;
        L21:
            Iterator<ProcessRecord> r106 = this.this$0.mBusyProcesses.values().iterator();     // Catch: Throwable -> L43
        L23:
            if (r106.hasNext() == false) goto L31;
            ProcessRecord r107 = r106.next();     // Catch: Throwable -> L43
            if (r107.canRunHere(r100, this.this$0.mProcessMap) == false) goto L23;
            ProviderInfo r108 = r107.selectStubProvider(r100);     // Catch: Throwable -> L43
            if (r108 == null) goto L23;
            this.this$0.mHandler.removeMessages(r107.mPid | 16777216);     // Catch: Throwable -> L43
            MiraLogger.d(MiraLogger.TAG_PAM, "PluginAMBinder selectStubProvider from mBusyProcesses canRunHere, " + r100 + " <<< " + r108);     // Catch: Throwable -> L43
            monitor-exit(this);
            return r108;
        L31:
            Iterator<Map.Entry<String, ProcessRecord>> r109 = this.this$0.mSpareProcesses.entrySet().iterator();     // Catch: Throwable -> L43
        L33:
            if (r109.hasNext() == false) goto L39;
            ProcessRecord r110 = r109.next().getValue();     // Catch: Throwable -> L43
            if (r110.canRunHere(r100, this.this$0.mProcessMap) == false) goto L33;
            ProviderInfo r111 = r110.selectStubProvider(r100);     // Catch: Throwable -> L43
            ensureStubProcessDied(r110);     // Catch: Throwable -> L43
            r109.remove();     // Catch: Throwable -> L43
            this.this$0.mBusyProcesses.put(r110.mProcessName, r110);     // Catch: Throwable -> L43
            MiraLogger.d(MiraLogger.TAG_PAM, "PluginAMBinder selectStubProvider from mSpareProcesses to mBusyProcesses, " + r100 + " <<< " + r111);     // Catch: Throwable -> L43
            monitor-exit(this);
            return r111;
        L39:
            MiraLogger.d(MiraLogger.TAG_PAM, "PluginAMBinder selectStubProvider null, " + r100);     // Catch: Throwable -> L43
            monitor-exit(this);
            return null;
        L43:
            th = move-exception;
            throw th;
        }

        @Override // com.bytedance.mira.am.IPluginActivityManager
        public synchronized ActivityInfo selectStubReceiver(ActivityInfo r100) {
            monitor-enter(this);
            PluginActivityManagerProvider.access$200(this.this$0);     // Catch: Throwable -> L43
            scheduleGc();     // Catch: Throwable -> L43
            ensureStubProcessAlive();     // Catch: Throwable -> L43
            String r101 = this.this$0.mProcessMap.bestMatch(r100.processName);     // Catch: Throwable -> L43
            if (TextUtils.isEmpty(r101) == false) goto L8;
            r101 = r100.processName;     // Catch: Throwable -> L43
        L8:
            if (TextUtils.isEmpty(r101) == true) goto L21;
            ProcessRecord r102 = this.this$0.mBusyProcesses.get(r101);     // Catch: Throwable -> L43
            if (r102 == null) goto L16;
            ActivityInfo r103 = r102.selectStubReceiver(r100);     // Catch: Throwable -> L43
            if (r103 == null) goto L16;
            this.this$0.mHandler.removeMessages(r102.mPid | 16777216);     // Catch: Throwable -> L43
            MiraLogger.d(MiraLogger.TAG_PAM, "PluginAMBinder selectStubReceiver from mBusyStubProcesses, " + r100 + " <<< " + r103);     // Catch: Throwable -> L43
            monitor-exit(this);
            return r103;
        L16:
            ProcessRecord r104 = this.this$0.mSpareProcesses.get(r101);     // Catch: Throwable -> L43
            if (r104 == null) goto L21;
            ActivityInfo r105 = r104.selectStubReceiver(r100);     // Catch: Throwable -> L43
            ensureStubProcessDied(r104);     // Catch: Throwable -> L43
            this.this$0.mSpareProcesses.remove(r104.mProcessName);     // Catch: Throwable -> L43
            this.this$0.mBusyProcesses.put(r104.mProcessName, r104);     // Catch: Throwable -> L43
            MiraLogger.d(MiraLogger.TAG_PAM, "PluginAMBinder selectStubReceiver from mSpareProcesses, " + r100 + " <<< " + r105);     // Catch: Throwable -> L43
            monitor-exit(this);
            return r105;
        L21:
            Iterator<ProcessRecord> r106 = this.this$0.mBusyProcesses.values().iterator();     // Catch: Throwable -> L43
        L23:
            if (r106.hasNext() == false) goto L31;
            ProcessRecord r107 = r106.next();     // Catch: Throwable -> L43
            if (r107.canRunHere(r100, this.this$0.mProcessMap) == false) goto L23;
            ActivityInfo r108 = r107.selectStubReceiver(r100);     // Catch: Throwable -> L43
            if (r108 == null) goto L23;
            this.this$0.mHandler.removeMessages(r107.mPid | 16777216);     // Catch: Throwable -> L43
            MiraLogger.d(MiraLogger.TAG_PAM, "PluginAMBinder selectStubReceiver from mBusyProcesses canRunHere, " + r100 + " <<< " + r108);     // Catch: Throwable -> L43
            monitor-exit(this);
            return r108;
        L31:
            Iterator<Map.Entry<String, ProcessRecord>> r109 = this.this$0.mSpareProcesses.entrySet().iterator();     // Catch: Throwable -> L43
        L33:
            if (r109.hasNext() == false) goto L39;
            ProcessRecord r110 = r109.next().getValue();     // Catch: Throwable -> L43
            if (r110.canRunHere(r100, this.this$0.mProcessMap) == false) goto L33;
            ActivityInfo r111 = r110.selectStubReceiver(r100);     // Catch: Throwable -> L43
            ensureStubProcessDied(r110);     // Catch: Throwable -> L43
            r109.remove();     // Catch: Throwable -> L43
            this.this$0.mBusyProcesses.put(r110.mProcessName, r110);     // Catch: Throwable -> L43
            MiraLogger.d(MiraLogger.TAG_PAM, "PluginAMBinder selectStubReceiver from mSpareProcesses to mBusyProcesses, " + r100 + " <<< " + r111);     // Catch: Throwable -> L43
            monitor-exit(this);
            return r111;
        L39:
            MiraLogger.d(MiraLogger.TAG_PAM, "PluginAMBinder selectStubReceiver null, " + r100);     // Catch: Throwable -> L43
            monitor-exit(this);
            return null;
        L43:
            th = move-exception;
            throw th;
        }

        @Override // com.bytedance.mira.am.IPluginActivityManager
        public synchronized ServiceInfo selectStubService(ServiceInfo r100) {
            monitor-enter(this);
            PluginActivityManagerProvider.access$200(this.this$0);     // Catch: Throwable -> L43
            scheduleGc();     // Catch: Throwable -> L43
            ensureStubProcessAlive();     // Catch: Throwable -> L43
            String r101 = this.this$0.mProcessMap.bestMatch(r100.processName);     // Catch: Throwable -> L43
            if (TextUtils.isEmpty(r101) == false) goto L8;
            r101 = r100.processName;     // Catch: Throwable -> L43
        L8:
            if (TextUtils.isEmpty(r101) == true) goto L21;
            ProcessRecord r102 = this.this$0.mBusyProcesses.get(r101);     // Catch: Throwable -> L43
            if (r102 == null) goto L16;
            ServiceInfo r103 = r102.selectStubService(r100);     // Catch: Throwable -> L43
            if (r103 == null) goto L16;
            this.this$0.mHandler.removeMessages(r102.mPid | 16777216);     // Catch: Throwable -> L43
            MiraLogger.d(MiraLogger.TAG_PAM, "PluginAMBinder selectStubService from mBusyProcesses, " + r100 + " <<< " + r103);     // Catch: Throwable -> L43
            monitor-exit(this);
            return r103;
        L16:
            ProcessRecord r104 = this.this$0.mSpareProcesses.get(r101);     // Catch: Throwable -> L43
            if (r104 == null) goto L21;
            ServiceInfo r105 = r104.selectStubService(r100);     // Catch: Throwable -> L43
            ensureStubProcessDied(r104);     // Catch: Throwable -> L43
            this.this$0.mSpareProcesses.remove(r104.mProcessName);     // Catch: Throwable -> L43
            this.this$0.mBusyProcesses.put(r104.mProcessName, r104);     // Catch: Throwable -> L43
            MiraLogger.d(MiraLogger.TAG_PAM, "PluginAMBinder selectStubService from mSpareProcesses, " + r100 + " <<< " + r105);     // Catch: Throwable -> L43
            monitor-exit(this);
            return r105;
        L21:
            Iterator<ProcessRecord> r106 = this.this$0.mBusyProcesses.values().iterator();     // Catch: Throwable -> L43
        L23:
            if (r106.hasNext() == false) goto L31;
            ProcessRecord r107 = r106.next();     // Catch: Throwable -> L43
            if (r107.canRunHere(r100, this.this$0.mProcessMap) == false) goto L23;
            ServiceInfo r108 = r107.selectStubService(r100);     // Catch: Throwable -> L43
            if (r108 == null) goto L23;
            this.this$0.mHandler.removeMessages(r107.mPid | 16777216);     // Catch: Throwable -> L43
            MiraLogger.d(MiraLogger.TAG_PAM, "PluginAMBinder selectStubService from mBusyProcesses canRunHere, " + r100 + " <<< " + r108);     // Catch: Throwable -> L43
            monitor-exit(this);
            return r108;
        L31:
            Iterator<Map.Entry<String, ProcessRecord>> r109 = this.this$0.mSpareProcesses.entrySet().iterator();     // Catch: Throwable -> L43
        L33:
            if (r109.hasNext() == false) goto L39;
            ProcessRecord r110 = r109.next().getValue();     // Catch: Throwable -> L43
            if (r110.canRunHere(r100, this.this$0.mProcessMap) == false) goto L33;
            ServiceInfo r111 = r110.selectStubService(r100);     // Catch: Throwable -> L43
            ensureStubProcessDied(r110);     // Catch: Throwable -> L43
            r109.remove();     // Catch: Throwable -> L43
            this.this$0.mBusyProcesses.put(r110.mProcessName, r110);     // Catch: Throwable -> L43
            MiraLogger.d(MiraLogger.TAG_PAM, "PluginAMBinder selectStubService from mSpareProcesses to mBusyProcesses, " + r100 + " <<< " + r111);     // Catch: Throwable -> L43
            monitor-exit(this);
            return r111;
        L39:
            MiraLogger.d(MiraLogger.TAG_PAM, "PluginAMBinder selectStubService null, " + r100);     // Catch: Throwable -> L43
            monitor-exit(this);
            return null;
        L43:
            th = move-exception;
            throw th;
        }

        @Override // com.bytedance.mira.am.IPluginActivityManager
        public void shareStubProcess(List<String> r100) {
            MiraLogger.d(MiraLogger.TAG_PAM, "PluginAMBinder shareStubProcess");
            this.this$0.mProcessMap.shareStubProcess(r100);
        }

        public /* synthetic */ PluginAMBinder(PluginActivityManagerProvider r100, AnonymousClass1 r101) {
            this(r100);
        }

        @Override // com.bytedance.mira.am.IPluginActivityManager
        public synchronized void activityCreated(ActivityInfo r100, ActivityInfo r101) {
            monitor-enter(this);
            MiraLogger.d(MiraLogger.TAG_PAM, "PluginAMBinder activityCreated, " + r101 + " <<< " + r100);     // Catch: Throwable -> L17
            ProcessRecord r102 = this.this$0.mBusyProcesses.get(r100.processName);     // Catch: Throwable -> L17
            if (r102 != null) goto L7;
        L9:
            if (r102 != null) goto L11;
        L15:
            monitor-exit(this);
            return;
        L11:
            if (r102.mIsMainProcess == true) goto L15;
            if (Build.VERSION.SDK_INT >= 29) goto L15;
            KeepAlive.start();     // Catch: Throwable -> L17
            goto L15
        L7:
            if (r102.hasRunningActivity(r101) == true) goto L9;
            r102.addActivity(r100, r101);     // Catch: Throwable -> L17
        L17:
            th = move-exception;
            throw th;
        }

        @Override // com.bytedance.mira.am.IPluginActivityManager
        public synchronized void activityDestroy(ActivityInfo r100, ActivityInfo r101) {
            monitor-enter(this);
            MiraLogger.d(MiraLogger.TAG_PAM, "PluginAMBinder activityDestroy, " + r101 + " <<< " + r100);     // Catch: Throwable -> L20
            ProcessRecord r102 = this.this$0.mBusyProcesses.get(r100.processName);     // Catch: Throwable -> L20
            if (r102 == null) goto L7;
            r102.removeActivity(r100, r101);     // Catch: Throwable -> L20
        L7:
            Iterator<ProcessRecord> r103 = this.this$0.mBusyProcesses.values().iterator();     // Catch: Throwable -> L20
            int r104 = 0;
        L9:
            if (r103.hasNext() == false) goto L13;
            ProcessRecord r105 = r103.next();     // Catch: Throwable -> L20
            if (r105.mIsMainProcess == true) goto L9;
            r104 = r104 + r105.mRunningActivities.size();     // Catch: Throwable -> L20
            goto L9
        L13:
            if (r104 == 0) goto L15;
        L17:
            scheduleGc();     // Catch: Throwable -> L20
            monitor-exit(this);
            return;
        L15:
            if (Build.VERSION.SDK_INT >= 29) goto L17;
            KeepAlive.stop();     // Catch: Throwable -> L20
        L20:
            th = move-exception;
            throw th;
        }

        @Override // com.bytedance.mira.am.IPluginActivityManager
        public synchronized void receiverFinished(ActivityInfo r100, ActivityInfo r101) {
            monitor-enter(this);
            MiraLogger.d(MiraLogger.TAG_PAM, "PluginAMBinder receiverFinished, " + r101 + " <<< " + r100);     // Catch: Throwable -> L10
            ProcessRecord r102 = this.this$0.mBusyProcesses.get(r100.processName);     // Catch: Throwable -> L10
            if (r102 == null) goto L7;
            r102.removeReceiver(r100, r101);     // Catch: Throwable -> L10
        L7:
            scheduleGc();     // Catch: Throwable -> L10
            monitor-exit(this);
            return;
        L10:
            th = move-exception;
            throw th;
        }

        @Override // com.bytedance.mira.am.IPluginActivityManager
        public void runInStubProcess(String r100, String r101) {
            this.this$0.mProcessMap.runInStubProcess(r100, r101);
            MiraLogger.d(MiraLogger.TAG_PAM, "PluginAMBinder runInStubProcess, targetProcess = " + r100 + ", stubProcess = " + r101);
        }

        @Override // com.bytedance.mira.am.IPluginActivityManager
        public synchronized void serviceCreated(ServiceInfo r100, ServiceInfo r101) {
            monitor-enter(this);
            MiraLogger.d(MiraLogger.TAG_PAM, "PluginAMBinder serviceCreated, " + r101 + " <<< " + r100);     // Catch: Throwable -> L11
            ProcessRecord r102 = this.this$0.mBusyProcesses.get(r100.processName);     // Catch: Throwable -> L11
            if (r102 != null) goto L7;
        L9:
            monitor-exit(this);
            return;
        L7:
            if (r102.hasRunningService(r101) == true) goto L9;
            r102.addService(r100, r101);     // Catch: Throwable -> L11
        L11:
            th = move-exception;
            throw th;
        }

        @Override // com.bytedance.mira.am.IPluginActivityManager
        public synchronized void serviceDestroy(ServiceInfo r100, ServiceInfo r101) {
            monitor-enter(this);
            MiraLogger.d(MiraLogger.TAG_PAM, "PluginAMBinder serviceDestroy, " + r101 + " <<< " + r100);     // Catch: Throwable -> L10
            ProcessRecord r102 = this.this$0.mBusyProcesses.get(r100.processName);     // Catch: Throwable -> L10
            if (r102 == null) goto L7;
            r102.removeService(r100, r101);     // Catch: Throwable -> L10
        L7:
            scheduleGc();     // Catch: Throwable -> L10
            monitor-exit(this);
            return;
        L10:
            th = move-exception;
            throw th;
        }

        @Override // com.bytedance.mira.am.IPluginActivityManager
        public synchronized void activityOnNewIntent(ActivityInfo r100, ActivityInfo r101, Intent r102) {
            monitor-enter(this);
            MiraLogger.d(MiraLogger.TAG_PAM, "PluginAMBinder activityOnNewIntent, " + r101.name);     // Catch: Throwable -> L7
            monitor-exit(this);
            return;
        L7:
            th = move-exception;
            throw th;
        }

        @Override // com.bytedance.mira.am.IPluginActivityManager
        public synchronized void applicationCreated(ApplicationInfo r100, String r101, int r102, IApplicationThread r103) {
            monitor-enter(this);
            MiraLogger.d(MiraLogger.TAG_PAM, "PluginAMBinder applicationCreated, pid = " + r102 + ", " + r100.packageName);     // Catch: Throwable -> L37
            PluginActivityManagerProvider.access$200(this.this$0);     // Catch: Throwable -> L37
            Iterator<ProcessRecord> r104 = this.this$0.mBusyProcesses.values().iterator();     // Catch: Throwable -> L37
        L6:
            if (r104.hasNext() == false) goto L23;
            ProcessRecord r105 = r104.next();     // Catch: Throwable -> L37
            if (r105.mPluginPackages.contains(r100.packageName) == false) goto L6;
            if (TextUtils.equals(r101, r105.mProcessName) == false) goto L6;
            r105.mPid = r102;     // Catch: Throwable -> L37
            if (r103 != null) goto L14;
        L21:
            monitor-exit(this);
            return;
        L14:
            if (r102 == Process.myPid()) goto L21;
            if (r105.mDeathRecipient != null) goto L21;
            AppDeathRecipient r106 = new AppDeathRecipient(this, r103, r101, r102);     // Catch: RemoteException -> L19 Throwable -> L37
            r103.asBinder().linkToDeath(r106, 0);     // Catch: RemoteException -> L19 Throwable -> L37
            r105.mDeathRecipient = r106;     // Catch: RemoteException -> L19 Throwable -> L37
            MiraLogger.i(MiraLogger.TAG_PAM, "PluginAMBinder applicationCreated, linkToDeath from busyProcess, pid = " + r102 + ", " + r100.packageName);     // Catch: RemoteException -> L19 Throwable -> L37
        L19:
            e = move-exception;
            MiraLogger.e(MiraLogger.TAG_PAM, "PluginAMBinder applicationCreated linkToDeath failed, processRecord = " + r105, e);     // Catch: Throwable -> L37
            goto L21
        L23:
            ProcessRecord r107 = this.this$0.mSpareProcesses.get(r101);     // Catch: Throwable -> L37
            if (r107 == null) goto L35;
            r107.mPid = r102;     // Catch: Throwable -> L37
            this.this$0.mSpareProcesses.remove(r101);     // Catch: Throwable -> L37
            this.this$0.mBusyProcesses.put(r107.mProcessName, r107);     // Catch: Throwable -> L37
            if (r103 == null) goto L35;
            if (r102 == Process.myPid()) goto L35;
            if (r107.mDeathRecipient != null) goto L35;
            AppDeathRecipient r108 = new AppDeathRecipient(this, r103, r101, r102);     // Catch: RemoteException -> L33 Throwable -> L37
            r103.asBinder().linkToDeath(r108, 0);     // Catch: RemoteException -> L33 Throwable -> L37
            r107.mDeathRecipient = r108;     // Catch: RemoteException -> L33 Throwable -> L37
            MiraLogger.i(MiraLogger.TAG_PAM, "PluginAMBinder applicationCreated, linkToDeath from stubProcess, pid = " + r102 + ", " + r100.packageName);     // Catch: RemoteException -> L33 Throwable -> L37
        L33:
            e = move-exception;
            MiraLogger.e(MiraLogger.TAG_PAM, "PluginAMBinder applicationCreated from mSpareProcesses linkToDeath failed, processRecord = " + r107, e);     // Catch: Throwable -> L37
        L35:
            monitor-exit(this);
            return;
        L37:
            th = move-exception;
            throw th;
        }
    }

    public static final class ProcessMap {
        private final List<Collection<String>> mSharedProcessList;
        private final HashMap<String, String> mTargetToStub;

        public ProcessMap() {
            this.mTargetToStub = new HashMap();
            this.mSharedProcessList = new ArrayList();
        }

        public synchronized String bestMatch(String r100) {
            monitor-enter(this);
        L11:
            th = move-exception;
            throw th;
        L4:
            if (TextUtils.isEmpty(r100) == false) goto L8;
            monitor-exit(this);
            return null;
        L8:
            String r101 = this.mTargetToStub.get(r100);     // Catch: Throwable -> L11
            monitor-exit(this);
            return r101;
        }

        public synchronized boolean isMatch(List<String> r100) {
            monitor-enter(this);
            if (r100 != null) goto L30;
        L28:
            monitor-exit(this);
            return false;
        L30:
        L25:
            th = move-exception;
            throw th;
        L6:
            if (r100.size() < 2) goto L28;
            if (this.mSharedProcessList.isEmpty() == true) goto L28;
            Iterator<Collection<String>> r101 = this.mSharedProcessList.iterator();     // Catch: Throwable -> L25
        L12:
            if (r101.hasNext() == false) goto L23;
            Collection<String> r102 = r101.next();     // Catch: Throwable -> L25
            if (r102 == null) goto L12;
            if (r102.size() < 2) goto L12;
            if (r102.containsAll(r100) == false) goto L12;
            monitor-exit(this);
            return true;
        L23:
            monitor-exit(this);
            return false;
        }

        public synchronized void shareStubProcess(List<String> r100) {
            monitor-enter(this);
            if (r100 != null) goto L15;
        L13:
            monitor-exit(this);
            return;
        L15:
        L10:
            th = move-exception;
            throw th;
        L5:
            if (r100.size() < 2) goto L13;
            this.mSharedProcessList.add(r100);     // Catch: Throwable -> L10
            monitor-exit(this);
        }

        public synchronized boolean isMatch(String... r100) {
            monitor-enter(this);
            if (r100 != null) goto L16;
        L13:
            monitor-exit(this);
            return false;
        L16:
        L10:
            th = move-exception;
            throw th;
        L5:
            if (r100.length < 2) goto L13;
            boolean r101 = isMatch(Arrays.asList(r100));     // Catch: Throwable -> L10
            monitor-exit(this);
            return r101;
        }

        public synchronized void runInStubProcess(String r100, String r101) {
            monitor-enter(this);
        L13:
            th = move-exception;
            throw th;
        L4:
            if (TextUtils.isEmpty(r100) == false) goto L6;
        L11:
            monitor-exit(this);
            return;
        L6:
            if (TextUtils.isEmpty(r101) == true) goto L11;
            this.mTargetToStub.put(r100, r101);     // Catch: Throwable -> L13
            monitor-exit(this);
        }
    }

    private void init() {
        Intent r100 = new Intent();
        r100.setAction("com.intent.action.ACTION_STUB_PLUGIN");
        r100.addCategory("com.intent.category.PLUGIN_DEFAULT");
        r100.setPackage(getContext().getPackageName());
        int r101 = 0;
        List<ResolveInfo> r102 = getContext().getPackageManager().queryIntentActivities(r100, 0);
        if (r102 != null) goto L5;
    L17:
        List<ResolveInfo> r103 = getContext().getPackageManager().queryIntentServices(r100, 0);
        if (r103 != null) goto L20;
    L66:
        ProviderInfo[] r104 = getContext().getPackageManager().getPackageInfo(getContext().getPackageName(), 8).providers;     // Catch: PackageManager.NameNotFoundException -> L54
        if (r104 != null) goto L35;
    L56:
        this.mInited.set(true);
        MiraLogger.d(MiraLogger.TAG_INIT, "PluginActivityManagerProvider init, mSpareProcesses : " + this.mSpareProcesses.size());
        Object r105 = this.mWaitLock;
        monitor-enter(r105);
        this.mWaitLock.notifyAll();     // Catch: Throwable -> L61
        monitor-exit(r105);     // Catch: Throwable -> L61
        return;
    L61:
        th = move-exception;
        throw th;
    L35:
        if (r104.length <= 0) goto L56;
        String r106 = getContext().getPackageName() + ".stub.[_a-zA-Z0-9]+.STUB_AUTHORITY";     // Catch: PackageManager.NameNotFoundException -> L54
        int r107 = r104.length;     // Catch: PackageManager.NameNotFoundException -> L54
    L37:
        if (r101 >= r107) goto L56;
        ProviderInfo r108 = r104[r101];     // Catch: PackageManager.NameNotFoundException -> L54
        String r109 = r108.authority;     // Catch: PackageManager.NameNotFoundException -> L54
        if (r109 == null) goto L43;
        if (r109.matches(r106) == false) goto L43;
    L47:
        ProcessRecord r110 = this.mSpareProcesses.get(r108.processName);     // Catch: PackageManager.NameNotFoundException -> L54
        if (r110 != null) goto L51;
        r110 = new ProcessRecord(r108.processName);     // Catch: PackageManager.NameNotFoundException -> L54
        this.mSpareProcesses.put(r108.processName, r110);     // Catch: PackageManager.NameNotFoundException -> L54
    L51:
        if (r110.mStubProviders.containsKey(r108.name) == true) goto L53;
        r110.mStubProviders.put(r108.name, r108);     // Catch: PackageManager.NameNotFoundException -> L54
    L53:
        r101 = r101 + 1;
    L43:
        if (r108.descriptionRes == 0) goto L53;
        if (TextUtils.equals(getContext().getString(r108.descriptionRes), "com.bytedance.mira.stub.StubContentProvider") == true) goto L47;
    L54:
        e = move-exception;
        MiraLogger.e(MiraLogger.TAG_INIT, "PluginActivityManagerProvider init StubProvider failed.", e);
        goto L56
    L20:
        if (r103.size() <= 0) goto L66;
        Iterator<ResolveInfo> r111 = r103.iterator();
    L23:
        if (r111.hasNext() == false) goto L66;
        ServiceInfo r112 = r111.next().serviceInfo;
        if (r112.name.matches("\\bcom.bytedance.mira.stub.p[0-9]+.StubService[0-9]+\\b") == false) goto L23;
        ProcessRecord r113 = this.mSpareProcesses.get(r112.processName);
        if (r113 != null) goto L30;
        r113 = new ProcessRecord(r112.processName);
        this.mSpareProcesses.put(r112.processName, r113);
    L30:
        if (r113.mStubServices.containsKey(r112.name) == true) goto L23;
        r113.mStubServices.put(r112.name, r112);
        goto L23
    L5:
        if (r102.size() <= 0) goto L17;
        Iterator<ResolveInfo> r114 = r102.iterator();
    L8:
        if (r114.hasNext() == false) goto L17;
        ActivityInfo r115 = r114.next().activityInfo;
        if (r115.name.matches("\\bcom.bytedance.mira.stub.p[0-9].Stub\\S+Activity[0-9]*\\b") == false) goto L8;
        ProcessRecord r116 = this.mSpareProcesses.get(r115.processName);
        if (r116 != null) goto L15;
        r116 = new ProcessRecord(r115.processName);
        this.mSpareProcesses.put(r115.processName, r116);
    L15:
        if (r116.mStubActivities.containsKey(r115.name) == true) goto L8;
        r116.mStubActivities.put(r115.name, r115);
        goto L8
    }

    private void waitFor() {
        if (this.mInited.get() == true) goto L16;
        Object r100 = this.mWaitLock;
        monitor-enter(r100);
        this.mWaitLock.wait();     // Catch: Throwable -> L8 InterruptedException -> L10
    L12:
        monitor-exit(r100);     // Catch: Throwable -> L8
        return;
    L8:
        th = move-exception;
        throw th;
    L10:
        e = move-exception;
        MiraLogger.e(MiraLogger.TAG_PAM, "PluginActivityManagerProvider waitFor failed.", e);     // Catch: Throwable -> L8
        goto L12
    }

    @Override // com.bytedance.mira.core.BinderProvider
    public IBinder onBind() {
        return new PluginAMBinder(this, null);
    }

    public PluginActivityManagerProvider() {
        this.mSpareProcesses = new TreeMap();
        this.mBusyProcesses = new TreeMap();
        this.mProcessMap = new ProcessMap();
        this.mWaitLock = new Object();
        this.mInited = new AtomicBoolean(false);
        this.mHandler = new AnonymousClass1(this);
    }

    @Override // com.bytedance.mira.core.BinderProvider, android.content.ContentProvider
    public boolean onCreate() {
        if (Mira.getAppContext() != null) goto L5;
        Mira.setAppContext(getContext());
    L5:
        MiraThreadPoolHelper.sMiraFastExecutor.execute(new AnonymousClass2(this));
        MiraLogger.d(MiraLogger.TAG_INIT, "PluginActivityManagerProvider onCreate");
        return super.onCreate();
    }

    public static /* synthetic */ void access$000(PluginActivityManagerProvider r100) {
        r100.init();
    }

    public static /* synthetic */ void access$200(PluginActivityManagerProvider r100) {
        r100.waitFor();
    }
}
