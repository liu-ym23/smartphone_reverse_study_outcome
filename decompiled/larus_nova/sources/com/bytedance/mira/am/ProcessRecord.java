package com.bytedance.mira.am;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.ComponentInfo;
import android.content.pm.ProviderInfo;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.os.IBinder;
import android.text.TextUtils;
import com.bytedance.mira.Mira;
import com.bytedance.mira.log.MiraLogger;
import com.bytedance.mira.util.ResUtil;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/* JADX INFO: loaded from: classes3.dex */
class ProcessRecord {
    private static final String PLUGIN_PROCESS_PATTERN = ".+:plugin[0-9]+";
    private static final String PLUGIN_PROCESS_TAG = ":plugin";
    private static final String STUB_ACTIVITY_NAME_REG = "com.bytedance.mira.stub.[_a-zA-Z0-9]+.Stub[a-zA-Z]+Activity[0-9]+";
    private static final String STUB_PROVIDER_NAME_REG = "com.bytedance.mira.stub.[_a-zA-Z0-9]+.StubContentProvider";
    private static final String STUB_SERVICE_NAME_REG = "com.bytedance.mira.stub.[_a-zA-Z0-9]+.StubReceiver";
    private static final String STUB_TRANSLUCENT_ACTIVITY = "com.bytedance.mira.stub.%s.StubTranslucentActivity";
    private static final String TAG = "ProcessRecord";
    IBinder.DeathRecipient mDeathRecipient;
    boolean mIsMainProcess;
    int mPid;
    List<String> mPluginPackages;
    List<String> mPluginProcesses;
    String mProcessName;
    String mProcessTag;
    HashMap<String, ActivityInfo> mRunningActivities;
    HashMap<String, ArrayList<ProviderInfo>> mRunningProviders;
    HashMap<String, ArrayList<ActivityInfo>> mRunningReceivers;
    HashMap<String, ArrayList<ServiceInfo>> mRunningServices;
    TreeMap<String, ActivityInfo> mStubActivities;
    TreeMap<String, ProviderInfo> mStubProviders;
    TreeMap<String, ActivityInfo> mStubReceivers;
    TreeMap<String, ServiceInfo> mStubServices;
    private Map<String, ServiceInfo> mUsedServices;

    public synchronized void reset() {
        monitor-enter(this);
        this.mPid = 0;     // Catch: Throwable -> L7
        this.mPluginProcesses.clear();     // Catch: Throwable -> L7
        this.mPluginPackages.clear();     // Catch: Throwable -> L7
        this.mRunningActivities.clear();     // Catch: Throwable -> L7
        this.mRunningServices.clear();     // Catch: Throwable -> L7
        this.mRunningProviders.clear();     // Catch: Throwable -> L7
        this.mRunningReceivers.clear();     // Catch: Throwable -> L7
        this.mDeathRecipient = null;     // Catch: Throwable -> L7
        monitor-exit(this);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public ProcessRecord(String r100) {
        this.mPluginProcesses = new ArrayList();
        this.mPluginPackages = new ArrayList();
        this.mStubActivities = new TreeMap();
        this.mStubServices = new TreeMap();
        this.mStubReceivers = new TreeMap();
        this.mStubProviders = new TreeMap();
        this.mRunningActivities = new HashMap();
        this.mRunningServices = new HashMap();
        this.mRunningReceivers = new HashMap();
        this.mRunningProviders = new HashMap();
        this.mUsedServices = new HashMap();
        this.mProcessName = r100;
        this.mIsMainProcess = TextUtils.equals(r100, Mira.getAppContext().getApplicationInfo().processName);
        if (this.mProcessName.matches(PLUGIN_PROCESS_PATTERN) == false) goto L5;
        StringBuilder r101 = new StringBuilder("p");
        String r102 = this.mProcessName;
        r101.append(r102.substring(r102.lastIndexOf(PLUGIN_PROCESS_TAG) + 7));
        this.mProcessTag = r101.toString();
        return;
    L5:
        this.mProcessTag = "p0";
    }

    public synchronized boolean hasRunningActivity(ActivityInfo r100) {
        monitor-enter(this);
        HashMap<String, ActivityInfo> r101 = this.mRunningActivities;     // Catch: Throwable -> L22
        if (r101 != null) goto L8;
        monitor-exit(this);
        return false;
    L8:
        Iterator<ActivityInfo> r102 = r101.values().iterator();     // Catch: Throwable -> L22
    L10:
        if (r102.hasNext() == false) goto L20;
        ActivityInfo r103 = r102.next();     // Catch: Throwable -> L22
        if (r103 == null) goto L10;
        if (TextUtils.equals(r103.packageName, r100.packageName) == false) goto L10;
        if (TextUtils.equals(r103.name, r100.name) == false) goto L10;
        monitor-exit(this);
        return true;
    L20:
        monitor-exit(this);
        return false;
    L22:
        th = move-exception;
        throw th;
    }

    public synchronized boolean hasRunningService(ServiceInfo r100) {
        monitor-enter(this);
        HashMap<String, ArrayList<ServiceInfo>> r101 = this.mRunningServices;     // Catch: Throwable -> L27
        if (r101 != null) goto L8;
        monitor-exit(this);
        return false;
    L8:
        Iterator<ArrayList<ServiceInfo>> r102 = r101.values().iterator();     // Catch: Throwable -> L27
    L10:
        if (r102.hasNext() == false) goto L25;
        ArrayList<ServiceInfo> r103 = r102.next();     // Catch: Throwable -> L27
        int r104 = 0;
    L12:
        if (r103 == null) goto L10;
        if (r104 >= r103.size()) goto L10;
        ServiceInfo r105 = (ServiceInfo) ListProtector.get(r103, r104);     // Catch: Throwable -> L27
        if (r105 == null) goto L24;
        if (TextUtils.equals(r105.packageName, r100.packageName) == false) goto L24;
        if (TextUtils.equals(r105.name, r100.name) == false) goto L24;
        monitor-exit(this);
        return true;
    L24:
        r104 = r104 + 1;
        goto L12
    L25:
        monitor-exit(this);
        return false;
    L27:
        th = move-exception;
        throw th;
    }

    public synchronized ActivityInfo selectStubActivity(ActivityInfo r100) {
        monitor-enter(this);
        if (r100 != null) goto L59;
    L53:
        MiraLogger.w(MiraLogger.TAG_PAM, "ProcessRecord selectStubActivity, targetInfo illegal, " + r100);     // Catch: Throwable -> L56
        monitor-exit(this);
        return null;
    L59:
    L56:
        th = move-exception;
        throw th;
    L7:
        if (TextUtils.isEmpty(r100.packageName) == true) goto L53;
        if (TextUtils.isEmpty(r100.name) == true) goto L53;
        if (this.mStubActivities.size() != 0) goto L14;
        MiraLogger.w(MiraLogger.TAG_PAM, "ProcessRecordreFill empty mStubActivities, process = " + this.mProcessName);     // Catch: Throwable -> L56
        reFillStubActivities(this.mStubActivities, this.mProcessName);     // Catch: Throwable -> L56
    L14:
        ActivityInfo r101 = this.mStubActivities.get(r100.name);     // Catch: Throwable -> L56
        if (r101 == null) goto L19;
        addActivity(r101, r100);     // Catch: Throwable -> L56
        MiraLogger.i(MiraLogger.TAG_PAM, "ProcessRecord selectStubActivity from self mStubActivities, " + r100 + " <<< " + r101);     // Catch: Throwable -> L56
        monitor-exit(this);
        return r101;
    L19:
        Iterator<Map.Entry<String, ActivityInfo>> r102 = this.mRunningActivities.entrySet().iterator();     // Catch: Throwable -> L56
    L21:
        if (r102.hasNext() == false) goto L32;
        Map.Entry<String, ActivityInfo> r103 = r102.next();     // Catch: Throwable -> L56
        if (r103 == null) goto L21;
        ActivityInfo r104 = r103.getValue();     // Catch: Throwable -> L56
        if (TextUtils.equals(r104.packageName, r100.packageName) == false) goto L21;
        if (TextUtils.equals(r104.name, r100.name) == false) goto L21;
        ActivityInfo r105 = this.mStubActivities.get(r103.getKey());     // Catch: Throwable -> L56
        MiraLogger.i(MiraLogger.TAG_PAM, "ProcessRecord selectStubActivity from mRunningActivities, " + r100 + " <<< " + r105);     // Catch: Throwable -> L56
        monitor-exit(this);
        return r105;
    L32:
        if (ResUtil.isTranslucent(r100) == false) goto L38;
        ActivityInfo r106 = this.mStubActivities.get(String.format(STUB_TRANSLUCENT_ACTIVITY, new Object[]{this.mProcessTag}));     // Catch: Throwable -> L56
        if (r106 == null) goto L38;
        addActivity(r106, r100);     // Catch: Throwable -> L56
        MiraLogger.i(MiraLogger.TAG_PAM, "ProcessRecord selectStubActivity from translucent, " + r100 + " <<< " + r106);     // Catch: Throwable -> L56
        monitor-exit(this);
        return r106;
    L38:
        Iterator<ActivityInfo> r107 = this.mStubActivities.values().iterator();     // Catch: Throwable -> L56
    L40:
        if (r107.hasNext() == false) goto L50;
        ActivityInfo r108 = r107.next();     // Catch: Throwable -> L56
        if (r108.name.matches(STUB_ACTIVITY_NAME_REG) == false) goto L40;
        if (r108.launchMode != r100.launchMode) goto L40;
        if (canUse(r108, r100) == false) goto L40;
        addActivity(r108, r100);     // Catch: Throwable -> L56
        MiraLogger.i(MiraLogger.TAG_PAM, "ProcessRecord selectStubActivity from match mStubActivities, " + r100 + " <<< " + r108);     // Catch: Throwable -> L56
        monitor-exit(this);
        return r108;
    L50:
        MiraLogger.w(MiraLogger.TAG_PAM, "ProcessRecord selectStubActivity null");     // Catch: Throwable -> L56
        monitor-exit(this);
        return null;
    }

    public synchronized ProviderInfo selectStubProvider(ProviderInfo r100) {
        monitor-enter(this);
        if (r100 != null) goto L33;
    L27:
        MiraLogger.w(MiraLogger.TAG_PAM, "ProcessRecord selectStubProvider, targetInfo illegal, " + r100);     // Catch: Throwable -> L30
        monitor-exit(this);
        return null;
    L33:
    L30:
        th = move-exception;
        throw th;
    L7:
        if (TextUtils.isEmpty(r100.packageName) == true) goto L27;
        if (TextUtils.isEmpty(r100.name) == true) goto L27;
        ProviderInfo r101 = this.mStubProviders.get(r100.name);     // Catch: Throwable -> L30
        if (r101 == null) goto L16;
        addProvider(r101, r100);     // Catch: Throwable -> L30
        MiraLogger.i(MiraLogger.TAG_PAM, "ProcessRecord selectStubProvider from self mStubProviders, " + r100 + " <<< " + r101);     // Catch: Throwable -> L30
        monitor-exit(this);
        return r101;
    L16:
        Iterator<ProviderInfo> r102 = this.mStubProviders.values().iterator();     // Catch: Throwable -> L30
    L18:
        if (r102.hasNext() == false) goto L24;
        ProviderInfo r103 = r102.next();     // Catch: Throwable -> L30
        if (r103.name.matches(STUB_PROVIDER_NAME_REG) == false) goto L18;
        addProvider(r103, r100);     // Catch: Throwable -> L30
        MiraLogger.i(MiraLogger.TAG_PAM, "ProcessRecord selectStubProvider from match mStubProviders, " + r100 + " <<< " + r103);     // Catch: Throwable -> L30
        monitor-exit(this);
        return r103;
    L24:
        MiraLogger.w(MiraLogger.TAG_PAM, "ProcessRecord selectStubProvider null");     // Catch: Throwable -> L30
        monitor-exit(this);
        return null;
    }

    public synchronized ActivityInfo selectStubReceiver(ActivityInfo r100) {
        monitor-enter(this);
        if (r100 != null) goto L33;
    L27:
        MiraLogger.w(MiraLogger.TAG_PAM, "ProcessRecord selectStubReceiver, targetInfo illegal, " + r100);     // Catch: Throwable -> L30
        monitor-exit(this);
        return null;
    L33:
    L30:
        th = move-exception;
        throw th;
    L7:
        if (TextUtils.isEmpty(r100.packageName) == true) goto L27;
        if (TextUtils.isEmpty(r100.name) == true) goto L27;
        ActivityInfo r101 = this.mStubReceivers.get(r100.name);     // Catch: Throwable -> L30
        if (r101 == null) goto L16;
        addReceiver(r101, r100);     // Catch: Throwable -> L30
        MiraLogger.i(MiraLogger.TAG_PAM, "ProcessRecord selectStubReceiver from self mStubReceivers, " + r100 + " <<< " + r101);     // Catch: Throwable -> L30
        monitor-exit(this);
        return r101;
    L16:
        Iterator<ActivityInfo> r102 = this.mStubActivities.values().iterator();     // Catch: Throwable -> L30
    L18:
        if (r102.hasNext() == false) goto L24;
        ActivityInfo r103 = r102.next();     // Catch: Throwable -> L30
        if (r103.name.matches(STUB_SERVICE_NAME_REG) == false) goto L18;
        addReceiver(r103, r100);     // Catch: Throwable -> L30
        MiraLogger.i(MiraLogger.TAG_PAM, "ProcessRecord selectStubReceiver from match mStubReceivers, " + r100 + " <<< " + r103);     // Catch: Throwable -> L30
        monitor-exit(this);
        return r103;
    L24:
        MiraLogger.w(MiraLogger.TAG_PAM, "ProcessRecord selectStubReceiver null");     // Catch: Throwable -> L30
        monitor-exit(this);
        return null;
    }

    public synchronized ServiceInfo selectStubService(ServiceInfo r100) {
        monitor-enter(this);
        if (r100 != null) goto L33;
    L27:
        MiraLogger.w(MiraLogger.TAG_PAM, "ProcessRecord selectStubService, targetInfo illegal, " + r100);     // Catch: Throwable -> L30
        monitor-exit(this);
        return null;
    L33:
    L30:
        th = move-exception;
        throw th;
    L7:
        if (TextUtils.isEmpty(r100.packageName) == true) goto L27;
        if (TextUtils.isEmpty(r100.name) == true) goto L27;
        if (this.mUsedServices.containsKey(r100.name) == false) goto L16;
        MiraLogger.i(MiraLogger.TAG_PAM, "ProcessRecord selectStubReceiver from mUsedServices, " + r100 + " <<< " + this.mUsedServices.get(r100.name));     // Catch: Throwable -> L30
        ServiceInfo r101 = this.mUsedServices.get(r100.name);     // Catch: Throwable -> L30
        monitor-exit(this);
        return r101;
    L16:
        Iterator<ServiceInfo> r102 = this.mStubServices.values().iterator();     // Catch: Throwable -> L30
    L18:
        if (r102.hasNext() == false) goto L24;
        ServiceInfo r103 = r102.next();     // Catch: Throwable -> L30
        if (this.mRunningServices.containsKey(r103.name) == true) goto L18;
        addService(r103, r100);     // Catch: Throwable -> L30
        MiraLogger.i(MiraLogger.TAG_PAM, "ProcessRecord selectStubReceiver from match mStubReceivers, " + r100 + " <<< " + r103);     // Catch: Throwable -> L30
        monitor-exit(this);
        return r103;
    L24:
        MiraLogger.w(MiraLogger.TAG_PAM, "ProcessRecord selectStubReceiver null");     // Catch: Throwable -> L30
        monitor-exit(this);
        return null;
    }

    private void reFillStubActivities(TreeMap<String, ActivityInfo> r100, String r101) {
        Intent r102 = new Intent();
        r102.setAction("com.intent.action.ACTION_STUB_PLUGIN");
        r102.addCategory("com.intent.category.PLUGIN_DEFAULT");
        r102.setPackage(Mira.getAppContext().getPackageName());
        List<ResolveInfo> r103 = Mira.getAppContext().getPackageManager().queryIntentActivities(r102, 0);
        if (r103 != null) goto L5;
        return;
    L5:
        if (r103.size() <= 0) goto L18;
        Iterator<ResolveInfo> r104 = r103.iterator();
    L8:
        if (r104.hasNext() == false) goto L19;
        ActivityInfo r105 = r104.next().activityInfo;
        if (r105.processName.equals(r101) == false) goto L8;
        r100.put(r105.name, r105);
        goto L8
    L19:
        return;
    }

    public synchronized void addActivity(ActivityInfo r100, ActivityInfo r101) {
        monitor-enter(this);
    L14:
        th = move-exception;
        throw th;
    L4:
        if (this.mPluginPackages.contains(r101.packageName) == true) goto L7;
        this.mPluginPackages.add(r101.packageName);     // Catch: Throwable -> L14
    L7:
        if (this.mPluginProcesses.contains(r101.processName) == true) goto L10;
        this.mPluginProcesses.add(r101.processName);     // Catch: Throwable -> L14
    L10:
        if (this.mRunningActivities.get(r100.name) != null) goto L12;
        this.mRunningActivities.put(r100.name, r101);     // Catch: Throwable -> L14
    L12:
        monitor-exit(this);
    }

    public synchronized void addProvider(ProviderInfo r100, ProviderInfo r101) {
        monitor-enter(this);
    L25:
        th = move-exception;
        throw th;
    L4:
        if (this.mPluginPackages.contains(r101.packageName) == true) goto L7;
        this.mPluginPackages.add(r101.packageName);     // Catch: Throwable -> L25
    L7:
        if (this.mPluginProcesses.contains(r101.processName) == true) goto L9;
        this.mPluginProcesses.add(r101.processName);     // Catch: Throwable -> L25
    L9:
        ArrayList<ProviderInfo> r102 = this.mRunningProviders.get(r101.name);     // Catch: Throwable -> L25
        if (r102 != null) goto L12;
        r102 = new ArrayList();     // Catch: Throwable -> L25
        this.mRunningProviders.put(r100.name, r102);     // Catch: Throwable -> L25
    L12:
        Iterator<ProviderInfo> r103 = r102.iterator();     // Catch: Throwable -> L25
    L14:
        if (r103.hasNext() == false) goto L20;
        ProviderInfo r104 = r103.next();     // Catch: Throwable -> L25
        if (TextUtils.equals(r104.packageName, r101.packageName) == false) goto L14;
        if (TextUtils.equals(r104.name, r101.name) == false) goto L14;
        boolean r105 = true;
    L21:
        if (r105 == true) goto L23;
        r102.add(r101);     // Catch: Throwable -> L25
    L23:
        monitor-exit(this);
        return;
    L20:
        r105 = false;
        goto L21
    }

    public synchronized void addReceiver(ActivityInfo r100, ActivityInfo r101) {
        monitor-enter(this);
    L25:
        th = move-exception;
        throw th;
    L4:
        if (this.mPluginPackages.contains(r101.packageName) == true) goto L7;
        this.mPluginPackages.add(r101.packageName);     // Catch: Throwable -> L25
    L7:
        if (this.mPluginProcesses.contains(r101.processName) == true) goto L9;
        this.mPluginProcesses.add(r101.processName);     // Catch: Throwable -> L25
    L9:
        ArrayList<ActivityInfo> r102 = this.mRunningReceivers.get(r100.name);     // Catch: Throwable -> L25
        if (r102 != null) goto L12;
        r102 = new ArrayList();     // Catch: Throwable -> L25
        this.mRunningReceivers.put(r100.name, r102);     // Catch: Throwable -> L25
    L12:
        Iterator<ActivityInfo> r103 = r102.iterator();     // Catch: Throwable -> L25
    L14:
        if (r103.hasNext() == false) goto L20;
        ActivityInfo r104 = r103.next();     // Catch: Throwable -> L25
        if (TextUtils.equals(r104.packageName, r101.packageName) == false) goto L14;
        if (TextUtils.equals(r104.name, r101.name) == false) goto L14;
        boolean r105 = true;
    L21:
        if (r105 == true) goto L23;
        r102.add(r101);     // Catch: Throwable -> L25
    L23:
        monitor-exit(this);
        return;
    L20:
        r105 = false;
        goto L21
    }

    public synchronized void addService(ServiceInfo r100, ServiceInfo r101) {
        monitor-enter(this);
    L28:
        th = move-exception;
        throw th;
    L4:
        if (this.mPluginPackages.contains(r101.packageName) == true) goto L7;
        this.mPluginPackages.add(r101.packageName);     // Catch: Throwable -> L28
    L7:
        if (this.mPluginProcesses.contains(r101.processName) == true) goto L10;
        this.mPluginProcesses.add(r101.processName);     // Catch: Throwable -> L28
    L10:
        if (this.mUsedServices.containsKey(r101.name) == true) goto L12;
        this.mUsedServices.put(r101.name, r100);     // Catch: Throwable -> L28
    L12:
        ArrayList<ServiceInfo> r102 = this.mRunningServices.get(r100.name);     // Catch: Throwable -> L28
        if (r102 != null) goto L15;
        r102 = new ArrayList();     // Catch: Throwable -> L28
        this.mRunningServices.put(r100.name, r102);     // Catch: Throwable -> L28
    L15:
        Iterator<ServiceInfo> r103 = r102.iterator();     // Catch: Throwable -> L28
    L17:
        if (r103.hasNext() == false) goto L23;
        ServiceInfo r104 = r103.next();     // Catch: Throwable -> L28
        if (TextUtils.equals(r104.packageName, r101.packageName) == false) goto L17;
        if (TextUtils.equals(r104.name, r101.name) == false) goto L17;
        boolean r105 = true;
    L24:
        if (r105 == true) goto L26;
        r102.add(r101);     // Catch: Throwable -> L28
    L26:
        monitor-exit(this);
        return;
    L23:
        r105 = false;
        goto L24
    }

    public synchronized boolean canRunHere(ComponentInfo r100, PluginActivityManagerProvider.ProcessMap r101) {
        monitor-enter(this);
        if (r100 != null) goto L37;
    L35:
        monitor-exit(this);
        return false;
    L37:
    L32:
        th = move-exception;
        throw th;
    L6:
        if (TextUtils.isEmpty(r100.processName) == true) goto L35;
        if (r101 == null) goto L35;
        if (this.mPluginPackages.isEmpty() == false) goto L21;
        if (this.mPluginProcesses.isEmpty() == false) goto L21;
        if (this.mIsMainProcess == false) goto L18;
        boolean r102 = r101.isMatch(new String[]{this.mProcessName, r100.processName});     // Catch: Throwable -> L32
        monitor-exit(this);
        return r102;
    L18:
        monitor-exit(this);
        return true;
    L21:
        if (this.mPluginPackages.contains(r100.packageName) == true) goto L23;
    L26:
        ArrayList r103 = new ArrayList();     // Catch: Throwable -> L32
        r103.add(r100.processName);     // Catch: Throwable -> L32
        r103.addAll(this.mPluginProcesses);     // Catch: Throwable -> L32
        if (r101.isMatch(r103) == false) goto L30;
        monitor-exit(this);
        return true;
    L30:
        monitor-exit(this);
        return false;
    L23:
        if (this.mPluginProcesses.contains(r100.processName) == false) goto L26;
        monitor-exit(this);
        return true;
    }

    public synchronized boolean canUse(ActivityInfo r100, ActivityInfo r101) {
        monitor-enter(this);
        ActivityInfo r102 = this.mRunningActivities.get(r100.name);     // Catch: Throwable -> L15
        if (r102 != null) goto L6;
    L12:
        monitor-exit(this);
        return true;
    L6:
        if (TextUtils.equals(r102.packageName, r101.packageName) == false) goto L9;
        if (TextUtils.equals(r102.name, r101.name) == true) goto L12;
    L9:
        monitor-exit(this);
        return false;
    L15:
        th = move-exception;
        throw th;
    }

    public synchronized void removeActivity(ActivityInfo r100, ActivityInfo r101) {
        monitor-enter(this);
    L8:
        th = move-exception;
        throw th;
    L4:
        if (this.mRunningActivities.get(r100.name) == null) goto L6;
        this.mRunningActivities.remove(r100.name);     // Catch: Throwable -> L8
    L6:
        monitor-exit(this);
    }

    public synchronized void removeReceiver(ActivityInfo r100, ActivityInfo r101) {
        monitor-enter(this);
        ArrayList<ActivityInfo> r102 = this.mRunningReceivers.get(r100.name);     // Catch: Throwable -> L21
        if (r102 != null) goto L6;
    L15:
        if (r102 != null) goto L17;
    L19:
        monitor-exit(this);
        return;
    L17:
        if (r102.size() != 0) goto L19;
        this.mRunningReceivers.remove(r100.name);     // Catch: Throwable -> L21
        goto L19
    L6:
        if (r102.size() <= 0) goto L15;
        Iterator<ActivityInfo> r103 = r102.iterator();     // Catch: Throwable -> L21
    L9:
        if (r103.hasNext() == false) goto L15;
        ActivityInfo r104 = r103.next();     // Catch: Throwable -> L21
        if (TextUtils.equals(r104.packageName, r101.packageName) == false) goto L9;
        if (TextUtils.equals(r104.name, r101.name) == false) goto L9;
        r103.remove();     // Catch: Throwable -> L21
    L21:
        th = move-exception;
        throw th;
    }

    public synchronized void removeService(ServiceInfo r100, ServiceInfo r101) {
        monitor-enter(this);
        ArrayList<ServiceInfo> r102 = this.mRunningServices.get(r100.name);     // Catch: Throwable -> L24
        if (r102 != null) goto L6;
    L15:
        if (r102 == null) goto L20;
        if (r102.size() != 0) goto L20;
        this.mRunningServices.remove(r100.name);     // Catch: Throwable -> L24
    L20:
        if (this.mUsedServices.containsKey(r101.name) == false) goto L22;
        this.mUsedServices.remove(r101.name);     // Catch: Throwable -> L24
    L22:
        monitor-exit(this);
        return;
    L6:
        if (r102.size() <= 0) goto L15;
        Iterator<ServiceInfo> r103 = r102.iterator();     // Catch: Throwable -> L24
    L9:
        if (r103.hasNext() == false) goto L15;
        ServiceInfo r104 = r103.next();     // Catch: Throwable -> L24
        if (TextUtils.equals(r104.packageName, r101.packageName) == false) goto L9;
        if (TextUtils.equals(r104.name, r101.name) == false) goto L9;
        r103.remove();     // Catch: Throwable -> L24
    L24:
        th = move-exception;
        throw th;
    }
}
