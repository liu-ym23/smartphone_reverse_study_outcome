package com.bytedance.mira.hook.proxy;

import android.R;
import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.ActivityInfo;
import android.content.pm.ProviderInfo;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.os.Process;
import android.text.TextUtils;
import android.util.Pair;
import com.alipay.sdk.m.u.i;
import com.bytedance.mira.Mira;
import com.bytedance.mira.MiraManager;
import com.bytedance.mira.MiraProxyActivityCallback;
import com.bytedance.mira.MiraProxyReceiverCallback;
import com.bytedance.mira.am.PluginActivityManager;
import com.bytedance.mira.compat.p.HackHelper;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.bytedance.mira.helper.ProcessHelper;
import com.bytedance.mira.hook.MiraHookManager;
import com.bytedance.mira.hook.delegate.MiraInstrumentation;
import com.bytedance.mira.log.MiraLogger;
import com.bytedance.mira.plugin.PluginManager;
import com.bytedance.mira.pm.PluginPackageManager;
import com.bytedance.mira.stub.BaseStubActivity;
import com.bytedance.mira.stub.MiraDefaultProvider;
import com.bytedance.mira.stub.RedirectActivity;
import com.bytedance.mira.stub.RedirectService;
import com.bytedance.mira.util.ArrayUtils;
import com.bytedance.mira.util.ClassUtil;
import com.bytedance.mira.util.FieldUtils;
import com.bytedance.mira.util.MethodUtils;
import com.bytedance.mira.util.OSUtil;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import el9.a;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes3.dex */
public class MiraActivityManagerProxy extends AbsObjectProxy {
    private static final String TAG = "MiraActivityManagerProxy";

    /* JADX INFO: renamed from: com.bytedance.mira.hook.proxy.MiraActivityManagerProxy$1, reason: invalid class name */
    /* JADX INFO: loaded from: classes21.dex */
    public static /* synthetic */ class AnonymousClass1 {
    }

    public static class BroadcastIntent extends AbsMethodDelegate {
        private BroadcastIntent() {
        }

        public /* synthetic */ BroadcastIntent(AnonymousClass1 r100) {
            this();
        }

        @Override // com.bytedance.mira.hook.proxy.AbsMethodDelegate
        public Object beforeInvoke(Object r100, Method r110, Object[] r111) {
            Intent r101 = MiraActivityManagerProxy.access$800(r111);
            String r102 = "MiraActivityManagerProxy << " + r110.getName() + ", ";
            MiraLogger.d(MiraLogger.TAG_RECEIVER, r102 + r101);
            if (r101 == null) goto L16;
            if (r101.getBooleanExtra("start_only_for_android", false) == true) goto L16;
            String r103 = Mira.getAppContext().getPackageName();
            String r104 = r101.getPackage();
            if (PluginPackageManager.isPluginPackage(r104) == false) goto L16;
            if (PluginManager.getInstance().isLoaded(r104) == true) goto L14;
            MiraLogger.w(MiraLogger.TAG_RECEIVER, r102 + "then loadPlugin : " + r104);
            if (PluginManager.getInstance().loadPlugin(r104) == true) goto L14;
            MiraLogger.w(MiraLogger.TAG_RECEIVER, r102 + "loadPlugin failed, cannot send plugin Broadcast");
            return super.beforeInvoke(r100, r110, r111);
        L14:
            r101.setPackage(r103);
            MiraLogger.w(MiraLogger.TAG_RECEIVER, r102 + String.format("replace intent.pkgName[%s]=host, ", new Object[]{r104}) + r101);
        L16:
            return super.beforeInvoke(r100, r110, r111);
        }
    }

    public static class GetContentProviderDelegate extends AbsMethodDelegate {
        private static final List<String> mAuthList = null;
        private ThreadLocal<Pair<String, String>> mAuthsLocal;
        private ThreadLocal<Boolean> mUserDefaultLocal;

        static {
            String[] r100 = new String[2];
            Object[] r101 = new Object[1];
            String r102 = "";
            if (Mira.getAppContext() != null) goto L5;
            String r103 = "";
        L6:
            r101[0] = r103;
            r100[0] = String.format("%s.pm.PPMP", r101);
            Object[] r104 = new Object[1];
            if (Mira.getAppContext() == null) goto L10;
            r102 = Mira.getAppContext().getPackageName();
        L10:
            r104[0] = r102;
            r100[1] = String.format("%s.am.PAMP", r104);
            mAuthList = Arrays.asList(r100);
            return;
        L5:
            r103 = Mira.getAppContext().getPackageName();
            goto L6
        }

        private GetContentProviderDelegate() {
            this.mAuthsLocal = new ThreadLocal();
            this.mUserDefaultLocal = new ThreadLocal();
        }

        public /* synthetic */ GetContentProviderDelegate(AnonymousClass1 r100) {
            this();
        }

        private int getAuthIndex(Object[] r100) {
            if (r100 != null) goto L4;
            return -1;
        L4:
            if (r100.length > 0) goto L6;
            return -1;
        L6:
            if (OSUtil.isAndroidQHigher() == false) goto L9;
            return 2;
        L9:
            int r101 = 0;
        L11:
            if (r101 >= r100.length) goto L28;
            Object r102 = r100[r101];
            if (r102 == null) goto L19;
            if ((r102 instanceof String) == false) goto L19;
            if (((String) r102).length() <= 0) goto L19;
            return r101;
        L19:
            r101 = r101 + 1;
            goto L11
        L28:
            return -1;
        }

        private String getPPMPOrPAMPAuth(Object[] r100) {
            int r101 = r100.length;
            int r102 = 0;
        L3:
            if (r102 >= r101) goto L10;
            Object r103 = r100[r102];
            if ((r103 instanceof String) == false) goto L9;
            String r104 = (String) r103;
            if (mAuthList.contains(r104) == false) goto L9;
            return r104;
        L9:
            r102 = r102 + 1;
            goto L3
        L10:
            return null;
        }

        @Override // com.bytedance.mira.hook.proxy.AbsMethodDelegate
        public Object beforeInvoke(Object r110, Method r111, Object[] r112) {
            String r100 = "MiraActivityManagerProxy << " + r111.getName() + ", ";
            this.mAuthsLocal.set(null);
            this.mUserDefaultLocal.set(Boolean.FALSE);
            int r101 = getAuthIndex(r112);
            if (r101 >= 0) goto L5;
        L44:
            MiraLogger.w(MiraLogger.TAG_PROVIDER, r100 + " authIndex invalid");
            return super.beforeInvoke(r110, r111, r112);
        L5:
            if (r101 >= r112.length) goto L44;
            String r102 = getPPMPOrPAMPAuth(r112);
            if (r102 == null) goto L10;
            boolean r103 = true;
        L11:
            if (r103 == true) goto L14;
            r102 = (String) r112[r101];
        L14:
            ProviderInfo r104 = Mira.getAppContext().getPackageManager().resolveContentProvider(r102, 16777216);
            if (r103 == false) goto L19;
            return super.beforeInvoke(r110, r111, r112);
        L19:
            if (r104 != null) goto L21;
            ProviderInfo r105 = PluginPackageManager.resolveContentProvider(r102, 0);
            if (r105 == null) goto L41;
            ProviderInfo r106 = PluginActivityManager.selectStubProvider(r105);
            if (r106 == null) goto L40;
            r112[r101] = r106.authority;
            this.mAuthsLocal.set(new Pair(r102, r106.authority));
            MiraLogger.w(MiraLogger.TAG_PROVIDER, r100 + String.format("Target[%s] >>> Stub[%s]", new Object[]{r102, r106.authority}));
        L43:
            return super.beforeInvoke(r110, r111, r112);
        L40:
            MiraLogger.w(MiraLogger.TAG_PROVIDER, r100 + "selectStubProvider null, auth = " + r102);
            goto L43
        L41:
            MiraLogger.w(MiraLogger.TAG_PROVIDER, r100 + "resolveContentProvider null, auth = " + r102);
            goto L43
        L21:
            if (TextUtils.equals(r104.packageName, Mira.getAppContext().getPackageName()) == true) goto L25;
            MiraLogger.w(MiraLogger.TAG_PROVIDER, r100 + " providerInfo.packageName[" + r104.packageName + "] invalid");
            return super.beforeInvoke(r110, r111, r112);
        L25:
            if (ClassUtil.isExist(r104.name) == true) goto L27;
            MiraLogger.w(MiraLogger.TAG_PROVIDER, r100 + " providerInfo.name[" + r104.name + "] ClassNotFound in host");
            if (TextUtils.equals(ProcessHelper.getCurrentProcessName(Mira.getAppContext()), r104.processName) == true) goto L34;
            ProviderInfo r107 = PluginActivityManager.selectStubProvider(r104);
            if (r107 == null) goto L33;
            r112[r101] = r107.authority;
            this.mAuthsLocal.set(new Pair(r102, r107.authority));
            MiraLogger.w(MiraLogger.TAG_PROVIDER, r100 + "provider run in host other process, " + String.format("Target[%s] >>> Stub[%s]", new Object[]{r102, r107.authority}));
            goto L43
        L33:
            MiraLogger.w(MiraLogger.TAG_PROVIDER, r100 + "selectStubProvider null");
            goto L43
        L34:
            this.mUserDefaultLocal.set(Boolean.TRUE);
            MiraLogger.i(MiraLogger.TAG_PROVIDER, r100 + "provider run in main process");
            goto L43
        L27:
            return super.beforeInvoke(r110, r111, r112);
        L10:
            r103 = false;
            goto L11
        }

        @Override // com.bytedance.mira.hook.proxy.AbsMethodDelegate
        public Object afterInvoke(Object r100, Method r101, Object[] r102, Object r103) {
            if (r103 == null) goto L5;
            new MiraContentProviderProxy(r103, this.mAuthsLocal.get()).onHookInstall();
            if (this.mUserDefaultLocal.get().booleanValue() == false) goto L16;
            String r104 = "MiraActivityManagerProxy >> " + r101.getName() + ", ";
            ProviderInfo r105 = (ProviderInfo) FieldUtils.readField(r103, "info");     // Catch: Exception -> L13
            if (r105 == null) goto L16;
            r105.name = MiraDefaultProvider.class.getName();     // Catch: Exception -> L13
            MiraLogger.w(MiraLogger.TAG_PROVIDER, r104 + "ClassNotFound in host use " + r105);     // Catch: Exception -> L13
        L13:
            e = move-exception;
            MiraLogger.e(MiraLogger.TAG_PROVIDER, r104 + "reflect invokeResult.info failed.", e);
        L16:
            return super.afterInvoke(r100, r101, r102, r103);
        L5:
            return super.afterInvoke(r100, r101, r102, r103);
        }
    }

    public static final class GetIntentSender extends AbsMethodDelegate {
        static final int INTENT_SENDER_ACTIVITY = 2;
        static final int INTENT_SENDER_ACTIVITY_RESULT = 3;
        static final int INTENT_SENDER_BROADCAST = 1;
        static final int INTENT_SENDER_SERVICE = 4;

        private GetIntentSender() {
        }

        public /* synthetic */ GetIntentSender(AnonymousClass1 r100) {
            this();
        }

        @Override // com.bytedance.mira.hook.proxy.AbsMethodDelegate
        public Object beforeInvoke(Object r100, Method r110, Object[] r111) {
            if (r111 != null) goto L5;
        L9:
            int r101 = 0;
        L11:
            if (r111 != null) goto L13;
        L19:
            int r102 = 2;
        L20:
            Intent r103 = null;
            if (r111 == null) goto L30;
            if (r102 >= r111.length) goto L30;
            Object r104 = r111[r102];
            if (r104 == null) goto L29;
            if ((r104 instanceof Intent[]) == false) goto L29;
            Intent[] r105 = (Intent[]) r104;
        L31:
            if (r105 != null) goto L33;
        L35:
            if (r103 == null) goto L52;
            if (r102 < 0) goto L52;
            if (r101 != 2) goto L45;
            List<ResolveInfo> r106 = PluginPackageManager.queryIntentActivities(r103, 0);
            if (r106 == null) goto L52;
            if (r106.size() <= 0) goto L52;
            Intent r107 = new Intent(r103);
            r107.setClassName(Mira.getAppContext().getPackageName(), RedirectActivity.class.getName());
            r107.putExtra("target_intent", r103);
            r111[r102] = new Intent[]{r107};
            goto L52
        L45:
            if (r101 != 4) goto L52;
            List<ResolveInfo> r108 = PluginPackageManager.queryIntentServices(r103, 0);
            if (r108 == null) goto L52;
            if (r108.size() <= 0) goto L52;
            Intent r109 = new Intent(r103);
            r109.setClassName(Mira.getAppContext().getPackageName(), RedirectService.class.getName());
            r109.putExtra("target_intent", r103);
            r111[r102] = new Intent[]{r109};
        L52:
            return super.beforeInvoke(r100, r110, r111);
        L33:
            if (r105.length <= 0) goto L35;
            r103 = r105[0];
        L29:
            r102 = r102 + 1;
        L30:
            r102 = -1;
            r105 = null;
            goto L31
        L13:
            if (r111.length <= 1) goto L19;
            Object r112 = r111[1];
            if ((r112 instanceof String) == false) goto L19;
            if (PluginPackageManager.isPluginPackage((String) r112) == false) goto L19;
            r111[1] = Mira.getAppContext().getPackageName();
            goto L19
        L5:
            if (r111.length <= 0) goto L9;
            Object r113 = r111[0];
            if ((r113 instanceof Integer) == false) goto L9;
            r101 = ((Integer) r113).intValue();
            goto L11
        }
    }

    public static class OverridePendingTransition extends AbsMethodDelegate {
        private OverridePendingTransition() {
        }

        public /* synthetic */ OverridePendingTransition(AnonymousClass1 r100) {
            this();
        }

        @Override // com.bytedance.mira.hook.proxy.AbsMethodDelegate
        public Object beforeInvoke(Object r100, Method r101, Object[] r102) {
            int r103 = 0;
        L3:
            if (r102 == null) goto L13;
            if (r103 >= r102.length) goto L13;
            Object r104 = r102[r103];
            if (r104 == null) goto L11;
            if ((r104 instanceof String) == false) goto L11;
            r102[r103] = Mira.getAppContext().getPackageName();
            MiraLogger.i(MiraLogger.TAG_ACTIVITY, ("MiraActivityManagerProxy <<" + r101.getName() + ", ") + "set pkgName as hostPkgName");
        L11:
            r103 = r103 + 1;
        L13:
            return super.beforeInvoke(r100, r101, r102);
        }
    }

    public static class RegisterReceiver extends AbsMethodDelegate {
        private RegisterReceiver() {
        }

        public /* synthetic */ RegisterReceiver(AnonymousClass1 r100) {
            this();
        }

        @Override // com.bytedance.mira.hook.proxy.AbsMethodDelegate
        public Object beforeInvoke(Object r110, Method r111, Object[] r112) {
            if (r112 == null) goto L23;
            if (r112.length <= 0) goto L23;
            String r100 = "MiraActivityManagerProxy << " + r111.getName() + ", ";
            String r101 = MiraActivityManagerProxy.access$900(r112);
            MiraLogger.d(MiraLogger.TAG_RECEIVER, r100 + r101);
            List<MiraProxyReceiverCallback> r102 = MiraManager.getInstance().getMiraProxyReceiverCallback();
            if (ArrayUtils.isEmpty(r102) == true) goto L11;
            BroadcastReceiver r103 = MiraActivityManagerProxy.access$1000(r112, r100);
            IntentFilter r104 = MiraActivityManagerProxy.access$1100(r112, 0);
            Iterator<MiraProxyReceiverCallback> r105 = r102.iterator();
        L9:
            if (r105.hasNext() == false) goto L11;
            MiraProxyReceiverCallback r106 = r105.next();
            MiraLogger.i(MiraLogger.TAG_RECEIVER, r100 + "sendCallback.onRegisterReceiver");
            r106.onRegisterReceiver(r103, r104);
        L11:
            int r107 = 0;
        L13:
            if (r107 >= r112.length) goto L23;
            Object r108 = r112[r107];
            if (r108 == null) goto L21;
            if ((r108 instanceof String) == false) goto L21;
            String r109 = Mira.getAppContext().getPackageName();
            String r113 = (String) r112[r107];
            if (PluginPackageManager.isPluginPackage(r113) == false) goto L23;
            r112[r107] = r109;
            MiraLogger.w(MiraLogger.TAG_RECEIVER, r100 + String.format("replace pkgName[%s]=host, ", new Object[]{r113}) + r101);
        L21:
            r107 = r107 + 1;
        L23:
            return super.beforeInvoke(r110, r111, r112);
        }
    }

    public static class StartActivity extends AbsMethodDelegate {
        private StartActivity() {
        }

        public /* synthetic */ StartActivity(AnonymousClass1 r100) {
            this();
        }

        @Override // com.bytedance.mira.hook.proxy.AbsMethodDelegate
        public Object beforeInvoke(Object r110, Method r111, Object[] r112) {
            String r100 = "MiraActivityManagerProxy << " + r111.getName() + ", ";
            int r101 = 0;
        L3:
            if (r112 == null) goto L12;
            if (r101 >= r112.length) goto L12;
            Object r102 = r112[r101];
            if (r102 == null) goto L11;
            if ((r102 instanceof Intent) == false) goto L11;
            Intent r103 = (Intent) r102;
        L13:
            MiraLogger.i(MiraLogger.TAG_ACTIVITY, r100 + r103);
            List<MiraProxyActivityCallback> r104 = MiraManager.getInstance().getMiraProxyActivityCallback();
            if (ArrayUtils.isEmpty(r104) == true) goto L19;
            Iterator<MiraProxyActivityCallback> r105 = r104.iterator();
        L17:
            if (r105.hasNext() == false) goto L19;
            MiraProxyActivityCallback r106 = r105.next();
            MiraLogger.i(MiraLogger.TAG_ACTIVITY, r100 + "sendCallback.onActivityStart");
            r106.onActivityStart(r112);
        L19:
            MiraLogger.d(MiraLogger.TAG_ACTIVITY, r100 + "ensure MiraInstrumentation hook");
            MiraHookManager.getInstance().installMiraInstrumentation();
            if (r103 != null) goto L22;
        L48:
            MiraLogger.w(MiraLogger.TAG_ACTIVITY, r100 + "targetIntent is null or MiraInstrumentaion has wrapped intent");
            return super.beforeInvoke(r110, r111, r112);
        L22:
            if (r103.getBooleanExtra(MiraInstrumentation.INSTRUMENTAION_HAS_WRAP_INTENT, false) == true) goto L48;
            List<ResolveInfo> r107 = Mira.getAppContext().getPackageManager().queryIntentActivities(r103, R.attr.theme);
            if (r107 == null) goto L31;
            if (r107.size() <= 0) goto L31;
            MiraLogger.i(MiraLogger.TAG_ACTIVITY, r100 + "activity declare in host Manifest");
            return super.beforeInvoke(r110, r111, r112);
        L31:
            if (r103.getBooleanExtra("start_only_for_android", false) == true) goto L47;
            List<ResolveInfo> r108 = PluginPackageManager.queryIntentActivities(r103, 0);
            if (r108 != null) goto L35;
        L45:
            MiraLogger.w(MiraLogger.TAG_ACTIVITY, r100 + "queryIntentActivities from plugin empty");
            goto L47
        L35:
            if (r108.size() <= 0) goto L45;
            ActivityInfo r109 = ((ResolveInfo) ListProtector.get(r108, 0)).activityInfo;
            if (r109 == null) goto L47;
            ActivityInfo r113 = PluginActivityManager.selectStubActivity(r109);
            if (r113 == null) goto L44;
            r103.putExtra("target_activityinfo", r109);
            r103.putExtra("stub_activityinfo", r113);
            Intent r114 = new Intent();
            r114.setClassName(r113.packageName, r113.name);
            r114.setFlags(r103.getFlags());
            r114.putExtra("target_intent", r103);
            r114.putExtra("target_activityinfo", r109);
            r114.putExtra("stub_activityinfo", r113);
            r114.putExtra(BaseStubActivity.CodeConst.EXTRA_STUB_CREATE_INFO, System.currentTimeMillis() + "#" + Process.myPid() + "#" + Mira.getAppContext().getApplicationInfo().processName);
            r112[r101] = r114;
            if (OSUtil.isAndroidJ_MR2Higher() == false) goto L43;
            r112[1] = r113.packageName;
        L43:
            MiraLogger.w(MiraLogger.TAG_ACTIVITY, r100 + String.format("Target[%s] >>> Stub[%s]", new Object[]{r109.name, r113.name}));
            goto L47
        L44:
            MiraLogger.w(MiraLogger.TAG_ACTIVITY, r100 + "selectStubActivityInfo null");
        L47:
            return super.beforeInvoke(r110, r111, r112);
        L11:
            r101 = r101 + 1;
        L12:
            r103 = null;
            r101 = 0;
            goto L13
        }
    }

    public static class StartStopService extends AbsMethodDelegate {
        private boolean mStartOrStopFlag;

        private StartStopService(boolean r100) {
            this.mStartOrStopFlag = r100;
        }

        public /* synthetic */ StartStopService(boolean r100, AnonymousClass1 r101) {
            this(r100);
        }

        @Override // com.bytedance.mira.hook.proxy.AbsMethodDelegate
        public Object beforeInvoke(Object r110, Method r111, Object[] r112) {
            String r100 = "MiraActivityManagerProxy << " + r111.getName() + ", ";
            Intent r101 = MiraActivityManagerProxy.access$800(r112);
            MiraLogger.i(MiraLogger.TAG_SERVICE, r100 + "intent=" + r101);
            if (this.mStartOrStopFlag == false) goto L20;
            List<ResolveInfo> r102 = Mira.getAppContext().getPackageManager().queryIntentServices(r101, R.attr.theme);
            if (r102 == null) goto L20;
            if (r102.size() <= 0) goto L20;
            Iterator<ResolveInfo> r103 = r102.iterator();
        L10:
            if (r103.hasNext() == false) goto L16;
            ServiceInfo r104 = r103.next().serviceInfo;
            if (r104 == null) goto L10;
            if (ClassUtil.isExist(r104.name) == true) goto L10;
            boolean r105 = false;
        L17:
            if (r105 == false) goto L20;
            MiraLogger.i(MiraLogger.TAG_SERVICE, r100 + "service declare in host Manifest, " + r101);
            return super.beforeInvoke(r110, r111, r112);
        L16:
            r105 = true;
        L20:
            if (r101 == null) goto L65;
            if (r101.getBooleanExtra("start_only_for_android", false) == true) goto L65;
            if (r101.getComponent() == null) goto L26;
            String r106 = r101.getComponent().getPackageName();
        L28:
            if (TextUtils.isEmpty(r106) == false) goto L31;
            r106 = r101.getPackage();
        L31:
            if (TextUtils.isEmpty(r106) == false) goto L35;
            MiraLogger.w(MiraLogger.TAG_SERVICE, r100 + "service component pkgName null");
            return super.beforeInvoke(r110, r111, r112);
        L35:
            if (PluginPackageManager.isPluginPackage(r106) == true) goto L37;
        L45:
            List<ResolveInfo> r107 = PluginPackageManager.queryIntentServices(r101, 0);
            if (r107 != null) goto L48;
        L63:
            MiraLogger.w(MiraLogger.TAG_SERVICE, r100 + "queryIntentServices empty, " + r101.getComponent());
            goto L65
        L48:
            if (r107.size() <= 0) goto L63;
            if (r107.size() != 1) goto L61;
            if (((ResolveInfo) ListProtector.get(r107, 0)).serviceInfo == null) goto L61;
            ServiceInfo r108 = ((ResolveInfo) ListProtector.get(r107, 0)).serviceInfo;
            ServiceInfo r109 = PluginActivityManager.selectStubService(r108);
            if (r109 != null) goto L56;
            MiraLogger.e(MiraLogger.TAG_SERVICE, r100 + "there is no other stub services to use.");
            goto L65
        L56:
            if (this.mStartOrStopFlag == false) goto L58;
            PluginActivityManager.serviceCreated(r109, r108);
        L58:
            r101.setClassName(r109.packageName, r109.name);
            MiraLogger.w(MiraLogger.TAG_SERVICE, r100 + String.format("Target[%s] >>> Stub[%s]", new Object[]{r108.name, r109.name}));
        L61:
            if (r107.size() <= 1) goto L65;
            MiraLogger.e(MiraLogger.TAG_SERVICE, r100 + "there are more than one Services registered in Manifest: " + r101.getComponent());
            goto L65
        L37:
            if (PluginManager.getInstance().isLoaded(r106) == true) goto L45;
            MiraLogger.w(MiraLogger.TAG_SERVICE, r100 + "then loadPlugin " + r106 + ", " + r101.getComponent());
            if (PluginManager.getInstance().loadPlugin(r106) == true) goto L43;
            MiraLogger.w(MiraLogger.TAG_SERVICE, r100 + "loadPlugin failed, cannot start plugin service, " + r101.getComponent());
            return super.beforeInvoke(r110, r111, r112);
        L43:
            if (r101.getComponent() == null) goto L45;
            r101.setPackage(Mira.getAppContext().getPackageName());
            r101.setClassName(Mira.getAppContext().getPackageName(), r101.getComponent().getClassName());
            goto L45
        L26:
            r106 = null;
        L65:
            return super.beforeInvoke(r110, r111, r112);
        }
    }

    public static class UnregisterReceiver extends AbsMethodDelegate {
        private UnregisterReceiver() {
        }

        public /* synthetic */ UnregisterReceiver(AnonymousClass1 r100) {
            this();
        }

        @Override // com.bytedance.mira.hook.proxy.AbsMethodDelegate
        public Object beforeInvoke(Object r100, Method r101, Object[] r110) {
            String r102 = "MiraActivityManagerProxy << " + r101.getName();
            MiraLogger.d(MiraLogger.TAG_RECEIVER, r102);
            List<MiraProxyReceiverCallback> r103 = MiraManager.getInstance().getMiraProxyReceiverCallback();
            if (ArrayUtils.isEmpty(r103) == true) goto L9;
            BroadcastReceiver r104 = MiraActivityManagerProxy.access$1000(r110, r102);
            Iterator<MiraProxyReceiverCallback> r105 = r103.iterator();
        L6:
            if (r105.hasNext() == false) goto L9;
            MiraProxyReceiverCallback r106 = r105.next();
            MiraLogger.i(MiraLogger.TAG_RECEIVER, r102 + ", sendCallback.onUnregisterReceiver");
            r106.onUnregisterReceiver(r104);
        L9:
            return super.beforeInvoke(r100, r101, r110);
        }
    }

    public static /* synthetic */ Class access$000(String r100) throws ClassNotFoundException {
        return Class.forName(r100);
    }

    static {
        AnonymousClass1 r100 = null;
        StartActivity r101 = new StartActivity(r100);
        AbsObjectProxy.sDelegateMethods.put("startActivity", r101);
        AbsObjectProxy.sDelegateMethods.put("startActivityAsUser", r101);
        AbsObjectProxy.sDelegateMethods.put("startActivityAsCaller", r101);
        AbsObjectProxy.sDelegateMethods.put("startActivityAndWait", r101);
        AbsObjectProxy.sDelegateMethods.put("startActivityWithConfig", r101);
        AbsObjectProxy.sDelegateMethods.put("overridePendingTransition", new OverridePendingTransition(r100));
        AbsObjectProxy.sDelegateMethods.put("getIntentSender", new GetIntentSender(r100));
        boolean r102 = true;
        AbsObjectProxy.sDelegateMethods.put("startService", new StartStopService(r102, r100));
        boolean r103 = false;
        AbsObjectProxy.sDelegateMethods.put("stopService", new StartStopService(r103, r100));
        AbsObjectProxy.sDelegateMethods.put("bindService", new StartStopService(r102, r100));
        AbsObjectProxy.sDelegateMethods.put("bindIsolatedService", new StartStopService(r102, r100));
        AbsObjectProxy.sDelegateMethods.put("bindServiceInstance", new StartStopService(r102, r100));
        AbsObjectProxy.sDelegateMethods.put("unbindService", new StartStopService(r103, r100));
        RegisterReceiver r104 = new RegisterReceiver(r100);
        AbsObjectProxy.sDelegateMethods.put("registerReceiver", r104);
        if (OSUtil.isAndroidRHigher() == false) goto L5;
        AbsObjectProxy.sDelegateMethods.put("registerReceiverWithFeature", r104);
    L5:
        BroadcastIntent r105 = new BroadcastIntent(r100);
        AbsObjectProxy.sDelegateMethods.put("broadcastIntent", r105);
        if (OSUtil.isAndroidRHigher() == false) goto L8;
        AbsObjectProxy.sDelegateMethods.put("broadcastIntentWithFeature", r105);
    L8:
        AbsObjectProxy.sDelegateMethods.put("unregisterReceiver", new UnregisterReceiver(r100));
        AbsObjectProxy.sDelegateMethods.put("getContentProvider", new GetContentProviderDelegate(r100));
    }

    @Override // com.bytedance.mira.hook.MiraHook
    public void onHookInstall() {
    L15:
        e = move-exception;
        MiraLogger.e(MiraLogger.TAG_INIT, "MiraActivityManagerProxy hook failed.", e);
        return;
    L4:
        if (OSUtil.isAndroidNOHigher() == false) goto L6;
        Object r100 = FieldUtils.readStaticField(INVOKESTATIC_com_bytedance_mira_hook_proxy_MiraActivityManagerProxy_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName("android.app.ActivityManager"), "IActivityManagerSingleton");     // Catch: Exception -> L15
    L8:
        if (INVOKESTATIC_com_bytedance_mira_hook_proxy_MiraActivityManagerProxy_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName("android.util.Singleton").isInstance(r100) == false) goto L20;
        Object r101 = FieldUtils.readField(r100, "mInstance");     // Catch: Exception -> L15
        if (r101 != null) goto L12;
        r101 = MethodUtils.invokeMethod(r100, MonitorConstants.CONNECT_TYPE_GET, new Object[0]);     // Catch: Exception -> L15
    L12:
        if (r101 == null) goto L21;
        setTarget(r101);     // Catch: Exception -> L15
        FieldUtils.writeField(r100, "mInstance", ProxyHelper.createProxy(r101, this));     // Catch: Exception -> L15
        MiraLogger.w(MiraLogger.TAG_INIT, "MiraActivityManagerProxy.hook");     // Catch: Exception -> L15
        return;
    L21:
        return;
    L20:
        return;
    L6:
        r100 = FieldUtils.readStaticField(INVOKESTATIC_com_bytedance_mira_hook_proxy_MiraActivityManagerProxy_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName("android.app.ActivityManagerNative"), "gDefault");     // Catch: Exception -> L15
        goto L8
    }

    public MiraActivityManagerProxy() {
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class INVOKESTATIC_com_bytedance_mira_hook_proxy_MiraActivityManagerProxy_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(String r100) throws ClassNotFoundException {
        ConcurrentHashMap<String, FastClassNotFoundHandler.Status> r101 = FastClassNotFoundHandler.f359329a;
        FastClassNotFoundHandler.Status r102 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (a.a() == true) goto L34;
        Class r103 = access$000(r100);     // Catch: Throwable -> L8
        if (r102 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L7;
        FastClassNotFoundHandler.a(r100);     // Catch: Throwable -> L8
    L7:
        return r103;
    L8:
        th = move-exception;
        if (r102 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L12;
        FastClassNotFoundHandler.b(r100);
    L12:
        throw th;
    L34:
        Class r104 = access$000(r100);     // Catch: Throwable -> L17
        if (r102 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L16;
        FastClassNotFoundHandler.a(r100);     // Catch: Throwable -> L17
    L16:
        return r104;
    L17:
        th = move-exception;
        if (r102 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L22;
        FastClassNotFoundHandler.b(r100);
    L22:
        if ((th instanceof PluginClassNotFoundException) == false) goto L24;
        throw th;
    L24:
        if ((th instanceof ClassNotFoundException) == true) goto L30;
        if ((th instanceof NoClassDefFoundError) == true) goto L30;
        throw th;
    L30:
        return MiraPluginFix.forName(r100);
    }

    public static /* synthetic */ Intent access$800(Object[] r100) {
        return extractIntent(r100);
    }

    public static /* synthetic */ String access$900(Object[] r100) {
        return extractIntentFilter(r100);
    }

    private static Intent extractIntent(Object[] r100) {
        if (r100 != null) goto L4;
        return null;
    L4:
        if (r100.length <= 0) goto L16;
        int r101 = r100.length;
        int r102 = 0;
    L6:
        if (r102 >= r101) goto L17;
        Object r103 = r100[r102];
        if ((r103 instanceof Intent) == true) goto L10;
        r102 = r102 + 1;
        goto L6
    L10:
        return (Intent) r103;
    L17:
        return null;
    L16:
        return null;
    }

    private static String extractIntentFilter(Object[] r100) {
        if (r100 != null) goto L4;
        return null;
    L4:
        if (r100.length <= 0) goto L40;
        int r101 = r100.length;
        int r102 = 0;
    L6:
        if (r102 >= r101) goto L41;
        Object r103 = r100[r102];
        if ((r103 instanceof IntentFilter) == true) goto L9;
        r102 = r102 + 1;
        goto L6
    L9:
        IntentFilter r104 = (IntentFilter) r103;
        StringBuilder r105 = new StringBuilder("IntentFilter{");
        r105.append("priority = " + r104.getPriority());
        Iterator<String> r106 = r104.actionsIterator();
        if (r106 == null) goto L16;
        r105.append(", actions = [");
    L13:
        if (r106.hasNext() == false) goto L15;
        r105.append(r106.next());
        goto L13
    L15:
        r105.append("]");
    L16:
        Iterator<String> r107 = r104.typesIterator();
        if (r107 == null) goto L23;
        r105.append(", dataTypes = [");
    L20:
        if (r107.hasNext() == false) goto L22;
        r105.append(r107.next());
        goto L20
    L22:
        r105.append("]");
    L23:
        Iterator<String> r108 = r104.schemesIterator();
        if (r108 == null) goto L30;
        r105.append(", schemes = [");
    L27:
        if (r108.hasNext() == false) goto L29;
        r105.append(r108.next());
        goto L27
    L29:
        r105.append("]");
    L30:
        r105.append(i.f25855d);
        return r105.toString();
    L41:
        return null;
    L40:
        return null;
    }

    @Override // com.bytedance.mira.hook.proxy.AbsObjectProxy
    public boolean isCatchInvokeThrowable(Method r100) {
        if (r100 == null) goto L8;
        if ("startActivity".equals(r100.getName()) == false) goto L8;
        return false;
    L8:
        return super.isCatchInvokeThrowable(r100);
    }

    public static /* synthetic */ BroadcastReceiver access$1000(Object[] r100, String r101) {
        return extractReceiver(r100, r101);
    }

    public static /* synthetic */ IntentFilter access$1100(Object[] r100, int r101) {
        return extractIntentFilter(r100, r101);
    }

    private static IntentFilter extractIntentFilter(Object[] r100, int r101) {
        if (r100 != null) goto L4;
        return null;
    L4:
        if (r100.length <= 0) goto L16;
        int r102 = r100.length;
        int r103 = 0;
    L6:
        if (r103 >= r102) goto L17;
        Object r104 = r100[r103];
        if ((r104 instanceof IntentFilter) == true) goto L10;
        r103 = r103 + 1;
        goto L6
    L10:
        return (IntentFilter) r104;
    L17:
        return null;
    L16:
        return null;
    }

    private static BroadcastReceiver extractReceiver(Object[] r100, String r101) {
        if (r100 != null) goto L4;
        return null;
    L4:
        if (r100.length <= 0) goto L29;
        int r102 = r100.length;
        int r103 = 0;
    L6:
        if (r103 >= r102) goto L34;
        Object r104 = r100[r103];
        if (r104 == null) goto L21;
        if ("android.app.LoadedApk$ReceiverDispatcher$InnerReceiver".equals(r104.getClass().getName()) == false) goto L21;
        Field r105 = HackHelper.getField(r104.getClass(), "mDispatcher");     // Catch: Exception -> L19
        if (r105 == null) goto L30;
        WeakReference r106 = (WeakReference) r105.get(r104);     // Catch: Exception -> L19
        if (r106 == null) goto L31;
        Object r107 = r106.get();     // Catch: Exception -> L19
        if (r107 == null) goto L32;
        return (BroadcastReceiver) FieldUtils.readField(r107, "mReceiver");
    L32:
        return null;
    L31:
        return null;
    L30:
        return null;
    L19:
        e = move-exception;
        MiraLogger.w(MiraLogger.TAG_RECEIVER, r101 + e.getMessage());
        return null;
    L21:
        r103 = r103 + 1;
        goto L6
    L34:
        return null;
    L29:
        return null;
    }

    @Override // com.bytedance.mira.hook.proxy.AbsObjectProxy, java.lang.reflect.InvocationHandler
    public Object invoke(Object r100, Method r101, Object[] r102) throws InvocationTargetException, IllegalAccessException {
        return super.invoke(r100, r101, r102);
    }
}
