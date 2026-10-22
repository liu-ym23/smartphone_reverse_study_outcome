package com.bytedance.common.process.cross;

import android.app.ActivityManager;
import android.app.Application;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.ServiceInfo;
import android.os.IBinder;
import android.os.Looper;
import android.text.TextUtils;
import com.bytedance.common.model.MethodCallRecord;
import com.bytedance.common.model.ProcessEnum;
import com.bytedance.common.process.service.CrossProcessServiceForMain;
import com.bytedance.common.process.service.CrossProcessServiceForPush;
import com.bytedance.common.process.service.CrossProcessServiceForPushService;
import com.bytedance.common.process.service.CrossProcessServiceForSmp;
import com.bytedance.common.push.ThreadPlus;
import com.bytedance.common.push.interfaze.IPushCommonInitConfigProvider;
import com.bytedance.common.support.PushCommonSupport;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.bytedance.push.utils.f;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import com.ss.android.message.AppProvider;
import com.ss.android.message.PushThreadHandlerManager;
import com.ss.android.message.util.ToolUtils;
import com.ss.android.push_common_lib.ICrossProcessAIDL;
import el9.a;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import me.ele.lancet.base.annotations.Skip;
import rgc.b;

/* JADX INFO: loaded from: classes3.dex */
public class CrossProcessHelper {
    private static volatile CrossProcessHelper instance = null;
    private static boolean sEnableCrossProcess = true;
    private final String TAG;
    private final Map<ProcessEnum, Set<ICrossProcessAbilityInitListener>> crossProcessAbilityInitListenerMap;
    private Context mContext;
    private ProcessEnum mCurProcess;
    private Map<ProcessEnum, ICrossProcessAIDL> mICrossProcessAIDLMap;
    private final AtomicBoolean mInit;
    private volatile Map<String, IMethodObserver> mMethodObserverMap;
    private Map<ProcessEnum, List<MethodCallRecord>> mNeedToCallMethod;
    private ServiceConnection mServiceConnection;
    private Map<ProcessEnum, String> mTargetProcessServiceMap;

    public class DefaultServiceConnection implements ServiceConnection {
        final /* synthetic */ CrossProcessHelper this$0;

        public DefaultServiceConnection(CrossProcessHelper r100) {
            this.this$0 = r100;
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName r100) {
            String r101 = CrossProcessHelper.access$100(this.this$0, r100);
            Iterator r102 = CrossProcessHelper.access$200(this.this$0).entrySet().iterator();
        L4:
            if (r102.hasNext() == false) goto L12;
            Map.Entry r103 = (Map.Entry) r102.next();
            if (TextUtils.equals((CharSequence) r103.getValue(), r101) == false) goto L4;
            f.b("CrossProcessHelper", CrossProcessHelper.access$300(this.this$0) + " process delete" + r103.getKey() + " process handle");
            CrossProcessHelper.access$400(this.this$0).remove(r103.getKey());
            return;
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(final ComponentName r100, final IBinder r101) {
            if (Looper.getMainLooper() != Looper.myLooper()) goto L5;
            ThreadPlus.submitRunnable(new AnonymousClass1(this, r100, r101));
            return;
        L5:
            CrossProcessHelper.access$000(this.this$0, r100, r101);
        }
    }

    public static /* synthetic */ Class access$001(String r100) throws ClassNotFoundException {
        return Class.forName(r100);
    }

    public static CrossProcessHelper getInstance() {
        if (instance != null) goto L15;
        monitor-enter(CrossProcessHelper.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (instance != null) goto L9;
        instance = new CrossProcessHelper();     // Catch: Throwable -> L11
    L9:
        monitor-exit(CrossProcessHelper.class);     // Catch: Throwable -> L11
    L15:
        return instance;
    }

    private Map<String, IMethodObserver> getMethodObserverMap() {
        if (this.mMethodObserverMap != null) goto L21;
        monitor-enter(this);
    L17:
        th = move-exception;
        throw th;
    L6:
        if (this.mMethodObserverMap != null) goto L15;
        this.mMethodObserverMap = new HashMap();     // Catch: Throwable -> L17
        IPushCommonInitConfigProvider r100 = (IPushCommonInitConfigProvider) b.a(IPushCommonInitConfigProvider.class);     // Catch: Throwable -> L17
        if (r100 == null) goto L15;
        if (r100.getMethodObservers() == null) goto L15;
        Iterator<IMethodObserver> r101 = r100.getMethodObservers().iterator();     // Catch: Throwable -> L17
    L13:
        if (r101.hasNext() == false) goto L15;
        IMethodObserver r102 = r101.next();     // Catch: Throwable -> L17
        this.mMethodObserverMap.put(r102.getMethodName(), r102);     // Catch: Throwable -> L17
    L15:
        monitor-exit(this);     // Catch: Throwable -> L17
    L21:
        return this.mMethodObserverMap;
    }

    private void init() {
        if (this.mInit.getAndSet(true) == false) goto L5;
        return;
    L5:
        f.b("CrossProcessHelper", "init is called in " + this.mCurProcess);
        if (sEnableCrossProcess == true) goto L10;
        f.b("CrossProcessHelper", "sEnableCrossProcess is false,do nothing");
        return;
    L10:
        if (this.mTargetProcessServiceMap.keySet().contains(this.mCurProcess) == true) goto L12;
        return;
    L12:
        List<String> r100 = getProcessList(PushCommonSupport.getInstance().getPushConfigurationService().getPushCommonConfiguration().mApplication);
        String r101 = this.mContext.getPackageName();
        f.b("CrossProcessHelper", "process list size:" + r100.size());
        Iterator<String> r102 = r100.iterator();
    L14:
        if (r102.hasNext() == false) goto L18;
        ProcessEnum r103 = ProcessEnum.parseProcess(r102.next(), r101);
        f.b("CrossProcessHelper", "itemProcess is " + r103);
        if (this.mCurProcess == r103) goto L14;
        bindTargetProcess(r103, false);
        goto L14
    }

    private CrossProcessHelper() {
        this.TAG = "CrossProcessHelper";
        this.mInit = new AtomicBoolean(false);
        this.mServiceConnection = new DefaultServiceConnection(this);
        this.crossProcessAbilityInitListenerMap = new HashMap();
        this.mICrossProcessAIDLMap = new HashMap();
        this.mNeedToCallMethod = new HashMap();
        HashMap r100 = new HashMap();
        this.mTargetProcessServiceMap = r100;
        r100.put(ProcessEnum.MAIN, CrossProcessServiceForMain.class.getName());
        this.mTargetProcessServiceMap.put(ProcessEnum.PUSH, CrossProcessServiceForPush.class.getName());
        this.mTargetProcessServiceMap.put(ProcessEnum.PUSH_SERVICE, CrossProcessServiceForPushService.class.getName());
        this.mTargetProcessServiceMap.put(ProcessEnum.SMP, CrossProcessServiceForSmp.class.getName());
        Application r101 = AppProvider.getApp();
        this.mContext = r101;
        this.mCurProcess = ToolUtils.getCurProcess(r101);
        PushThreadHandlerManager.inst().postRunnable(new AnonymousClass1(this));
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class INVOKESTATIC_com_bytedance_common_process_cross_CrossProcessHelper_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(String r100) throws ClassNotFoundException {
        ConcurrentHashMap<String, FastClassNotFoundHandler.Status> r101 = FastClassNotFoundHandler.f359329a;
        FastClassNotFoundHandler.Status r102 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (a.a() == true) goto L34;
        Class r103 = access$001(r100);     // Catch: Throwable -> L8
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
        Class r104 = access$001(r100);     // Catch: Throwable -> L17
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

    public static /* synthetic */ Map access$200(CrossProcessHelper r100) {
        return r100.mTargetProcessServiceMap;
    }

    public static /* synthetic */ ProcessEnum access$300(CrossProcessHelper r100) {
        return r100.mCurProcess;
    }

    public static /* synthetic */ Map access$400(CrossProcessHelper r100) {
        return r100.mICrossProcessAIDLMap;
    }

    public static /* synthetic */ void access$500(CrossProcessHelper r100) {
        r100.init();
    }

    public static /* synthetic */ Context access$600(CrossProcessHelper r100) {
        return r100.mContext;
    }

    private String getActualComponentName(ComponentName r100) {
        String r101 = r100.getClassName();
        if (this.mTargetProcessServiceMap.values().contains(r101) == false) goto L17;
        return r101;
    L17:
        ServiceInfo[] r102 = this.mContext.getPackageManager().getPackageInfo(this.mContext.getPackageName(), 4).services;     // Catch: Throwable -> L14
        if (r102 == null) goto L16;
        int r103 = r102.length;     // Catch: Throwable -> L14
        int r104 = 0;
    L8:
        if (r104 >= r103) goto L16;
        ServiceInfo r105 = r102[r104];     // Catch: Throwable -> L14
        if (TextUtils.equals(r101, r105.name) == true) goto L11;
        r104 = r104 + 1;
        goto L8
    L11:
        ProcessEnum r106 = ProcessEnum.parseProcess(r105.processName, this.mContext.getPackageName());     // Catch: Throwable -> L14
        String r107 = this.mTargetProcessServiceMap.get(r106);     // Catch: Throwable -> L14
        f.b("CrossProcessHelper", "[getActualComponentName]actualComponent process:" + r106 + " actualComponentName:" + r107);     // Catch: Throwable -> L14
        return r107;
    L16:
        return r101;
    L14:
        th = move-exception;
        f.e("CrossProcessHelper", "[getActualComponentName]exception:" + th.getLocalizedMessage());
        goto L16
    }

    public List<String> getProcessList(Context r100) {
        ArrayList r101 = new ArrayList();
    L15:
        th = move-exception;
        f.f("CrossProcessHelper", "[getProcessList]exception ", th);
        th.printStackTrace();
    L17:
        return r101;
    L4:
        if (ToolUtils.isActiveUser(r100) == true) goto L7;
        f.b("CrossProcessHelper", "[getProcessList]return empty list because cur is not active user");     // Catch: Throwable -> L15
        return r101;
    L7:
        List<ActivityManager.RunningAppProcessInfo> r102 = ToolUtils.getRunningAppProcesses();     // Catch: Throwable -> L15
        if (r102 != null) goto L10;
        return r101;
    L10:
        Iterator<ActivityManager.RunningAppProcessInfo> r103 = r102.iterator();     // Catch: Throwable -> L15
    L12:
        if (r103.hasNext() == false) goto L17;
        r101.add(r103.next().processName);     // Catch: Throwable -> L15
        goto L12
    }

    public void onServiceBind(String r100) {
        ProcessEnum r101 = ProcessEnum.parseProcess(r100);
        boolean r102 = this.mTargetProcessServiceMap.keySet().contains(r101);
        f.b("CrossProcessHelper", this.mCurProcess.processSuffix + " process be bind by " + r100 + " processEnumsContainsOriginProcess is " + r102 + " aidl is " + this.mICrossProcessAIDLMap.get(r101));
        if (r102 == true) goto L5;
        return;
    L5:
        if (this.mICrossProcessAIDLMap.get(r101) != null) goto L9;
        bindTargetProcess(r101, true);
        return;
    }

    public void registerMethodObserver(IMethodObserver r100) {
        f.b("CrossProcessHelper", this.mCurProcess + " register " + r100.getMethodName() + " observer:" + r100.toString());
        getMethodObserverMap().put(r100.getMethodName(), r100);
    }

    public static /* synthetic */ String access$100(CrossProcessHelper r100, ComponentName r101) {
        return r100.getActualComponentName(r101);
    }

    private void bindTargetProcess(ProcessEnum r100, boolean r101) {
        String r102 = this.mTargetProcessServiceMap.get(r100);     // Catch: Throwable -> L19
        if (TextUtils.isEmpty(r102) == true) goto L25;
        boolean r103 = false;
        if (INVOKESTATIC_com_bytedance_common_process_cross_CrossProcessHelper_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(r102) == null) goto L11;
        r103 = true;
    L11:
        if (r103 == true) goto L14;
        f.e("CrossProcessHelper", r102 + " is invalid,not bind");     // Catch: Throwable -> L19
        return;
    L14:
        ServiceConnection r104 = this.mServiceConnection;     // Catch: Throwable -> L19
        if (r100 != ProcessEnum.MAIN) goto L17;
        r104 = new AnonymousClass2(this);     // Catch: Throwable -> L19
    L17:
        f.b("CrossProcessHelper", this.mCurProcess + " process bind the " + r100 + " of service , targetService is " + r102);     // Catch: Throwable -> L19
        Intent r105 = new Intent();     // Catch: Throwable -> L19
        r105.setComponent(new ComponentName(this.mContext.getPackageName(), r102));     // Catch: Throwable -> L19
        r105.putExtra("process", this.mCurProcess.processSuffix);     // Catch: Throwable -> L19
        r105.putExtra("is_from_on_bind", r101);     // Catch: Throwable -> L19
        r105.setType(this.mCurProcess.processSuffix);     // Catch: Throwable -> L19
        this.mContext.bindService(r105, r104, 1);     // Catch: Throwable -> L19
        return;
    L25:
        return;
    L19:
        th = move-exception;
        f.e("CrossProcessHelper", "error to bindTargetProcess" + th.getMessage());
    }

    private void handlePreMethodCall(ProcessEnum r100, ProcessEnum r101) {
        List<MethodCallRecord> r102 = CrossProcessDatabaseHelper.getInstance(this.mContext).getNextBatchRecords(r100, r101);
        String r103 = "error";
    L3:
        if (r102 == null) goto L16;
        if (r102.size() <= 0) goto L22;
        Iterator<MethodCallRecord> r104 = r102.iterator();
    L8:
        if (r104.hasNext() == false) goto L14;
        MethodCallRecord r105 = r104.next();
        f.b("CrossProcessHelper", "handlePreMethodCall :" + r105.toString());
        String r106 = callMethod(r101, r105.getMethodName(), r105.getListArgs());
        if (TextUtils.equals(r106, "error") == true) goto L12;
        CrossProcessDatabaseHelper.getInstance(this.mContext).deleteRecord(r105.getId());
        r103 = r106;
        goto L8
    L12:
        r103 = r106;
    L14:
        if (TextUtils.equals(r103, "error") == true) goto L23;
        r102 = CrossProcessDatabaseHelper.getInstance(this.mContext).getNextBatchRecords(r100, r101);
        goto L3
    L23:
        return;
    L22:
        return;
    }

    private void handleServiceConnectedOnChildThread(ComponentName r100, IBinder r101) {
        String r102 = getActualComponentName(r100);
        Iterator<Map.Entry<ProcessEnum, String>> r103 = this.mTargetProcessServiceMap.entrySet().iterator();
    L4:
        if (r103.hasNext() == false) goto L32;
        Map.Entry<ProcessEnum, String> r104 = r103.next();
        if (TextUtils.equals(r104.getValue(), r102) == false) goto L4;
        ProcessEnum r105 = r104.getKey();
        f.b("CrossProcessHelper", this.mCurProcess + " process holds " + r105 + " process handle");
        this.mICrossProcessAIDLMap.put(r105, ICrossProcessAIDL.Stub.asInterface(r101));
        Map<ProcessEnum, Set<ICrossProcessAbilityInitListener>> r106 = this.crossProcessAbilityInitListenerMap;
        monitor-enter(r106);
        Set<ICrossProcessAbilityInitListener> r107 = this.crossProcessAbilityInitListenerMap.get(r105);     // Catch: Throwable -> L22
        StringBuilder r108 = new StringBuilder();     // Catch: Throwable -> L22
        r108.append("callback InitListener for ");     // Catch: Throwable -> L22
        r108.append(r105);     // Catch: Throwable -> L22
        r108.append(",listener size:");     // Catch: Throwable -> L22
        if (r107 != null) goto L12;
        int r109 = 0;
    L13:
        r108.append(r109);     // Catch: Throwable -> L22
        f.b("CrossProcessHelper", r108.toString());     // Catch: Throwable -> L22
        if (r107 == null) goto L19;
        Iterator<ICrossProcessAbilityInitListener> r110 = r107.iterator();     // Catch: Throwable -> L22
    L17:
        if (r110.hasNext() == false) goto L19;
        r110.next().initFinished();     // Catch: Throwable -> L22
    L19:
        this.crossProcessAbilityInitListenerMap.remove(r105);     // Catch: Throwable -> L22
        monitor-exit(r106);     // Catch: Throwable -> L22
        handlePreMethodCall(this.mCurProcess, r105);
        return;
    L12:
        r109 = r107.size();     // Catch: Throwable -> L22
    L22:
        th = move-exception;
        throw th;
    }

    public void addTargetProcessAbilityInitListener(ProcessEnum r100, ICrossProcessAbilityInitListener r101) {
        f.b("CrossProcessHelper", "addTargetProcessAbilityInitListener for " + r100);
        if (this.mICrossProcessAIDLMap.get(r100) == null) goto L6;
        r101.initFinished();
        return;
    L6:
        Map<ProcessEnum, Set<ICrossProcessAbilityInitListener>> r102 = this.crossProcessAbilityInitListenerMap;
        monitor-enter(r102);
        Set<ICrossProcessAbilityInitListener> r103 = this.crossProcessAbilityInitListenerMap.get(r100);     // Catch: Throwable -> L14
        if (r103 != null) goto L11;
        r103 = new HashSet();     // Catch: Throwable -> L14
    L11:
        r103.add(r101);     // Catch: Throwable -> L14
        this.crossProcessAbilityInitListenerMap.put(r100, r103);     // Catch: Throwable -> L14
        monitor-exit(r102);     // Catch: Throwable -> L14
        return;
    L14:
        th = move-exception;
        throw th;
    }

    public static /* synthetic */ void access$000(CrossProcessHelper r100, ComponentName r101, IBinder r102) {
        r100.handleServiceConnectedOnChildThread(r101, r102);
    }

    public String callMethod(ProcessEnum r100, String r101, List r102) {
        if (r100 != this.mCurProcess) goto L6;
        f.b("CrossProcessHelper", "[callMethod]targetProcess==mCurProcess,invoke onMethodCall,method:" + r101);
        return onMethodCall(this.mCurProcess, r101, r102);
    L6:
        ICrossProcessAIDL r103 = this.mICrossProcessAIDLMap.get(r100);
        if (r103 != null) goto L15;
        f.i("CrossProcessHelper", this.mCurProcess + " process callMethod failed because iCrossProcessAIDL is null, targetProcess is " + r100 + " method is " + r101);
        return "error";
    L15:
        return r103.invoke(r101, this.mCurProcess.processSuffix, r102);
    L12:
        e = move-exception;
        e.printStackTrace();
        return "error";
    }

    public String onMethodCall(ProcessEnum r100, String r101, List r102) {
        f.b("CrossProcessHelper", this.mCurProcess + " receive method call " + r101 + " from " + r100);
        IMethodObserver r103 = getMethodObserverMap().get(r101);
        if (r103 != null) goto L5;
        return "error";
    L5:
        return r103.onMethodCall(r100, r102);
    }

    private String callMethodInternal(ProcessEnum r100, String r101, List r102, boolean r103) {
        String r104 = callMethod(r100, r101, r102);
        if (r103 == true) goto L5;
    L8:
        return r104;
    L5:
        if (TextUtils.equals(r104, "error") == false) goto L8;
        f.b("CrossProcessHelper", "callMethod Failed , write it to database");
        MethodCallRecord r105 = new MethodCallRecord(this.mCurProcess.processSuffix, r100.processSuffix, r101, r102);
        CrossProcessDatabaseHelper.getInstance(this.mContext).insertMethodRecord(r105);
        return "later_success";
    }

    public String callMethod(ProcessEnum r100, String r101, List r102, boolean r103) {
        return callMethodInternal(r100, r101, r102, r103);
    }
}
