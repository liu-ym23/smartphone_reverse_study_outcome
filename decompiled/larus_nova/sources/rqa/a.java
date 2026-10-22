package rqa;

import a87.h;
import android.app.Notification;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageInfo;
import android.content.pm.ProviderInfo;
import android.content.pm.ServiceInfo;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import com.bytedance.android.service.manager.PushServiceManager;
import com.bytedance.android.service.manager.alive.monitor.IMonitorCallback;
import com.bytedance.common.model.ProcessEnum;
import com.bytedance.common.model.PushCommonConfiguration;
import com.bytedance.common.push.ThreadPlus;
import com.bytedance.common.push.interfaze.IPushCommonConfiguration;
import com.bytedance.common.support.PushCommonSupport;
import com.bytedance.common.utility.android.ManifestData;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.push.settings.LocalSettings;
import com.bytedance.push.settings.LocalSettings$$SettingImpl;
import com.bytedance.push.settings.PushOnlineSettings;
import com.bytedance.push.settings.PushOnlineSettings$$SettingImpl;
import com.bytedance.push.utils.f;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.alive.monitor.model.StartType;
import com.ss.android.message.PushThreadHandlerManager;
import com.ss.android.message.util.ToolUtils;
import com.ttnet.org.chromium.base.TTProcessUtils;
import j77.i;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes5.dex */
public final class a extends g77.a implements sqa.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f538935a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f538936b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final AtomicBoolean f538937c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ProcessEnum f538938d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public k77.b f538939e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f538940f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Map<String, String> f538941g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f538942h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f538943i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f538944j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public IMonitorCallback f538945k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final long f538946l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final List<String> f538947m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final List<String> f538948n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final List<String> f538949o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final Handler f538950p;

    /* JADX INFO: renamed from: rqa.a$a, reason: collision with other inner class name */
    public class C7522a implements Handler.Callback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a f538951a;

        public C7522a(a r100) {
            this.f538951a = r100;
        }

        @Override // android.os.Handler.Callback
        public final boolean handleMessage(Message r100) {
            f.b("AssociationStartMonitorService", "handle msg:" + r100.what);
            switch(r100.what) {
                case 10141757: goto L10;
                case 10141758: goto L6;
                default: goto L4;
            };
        L4:
            return false;
        L6:
            a r101 = this.f538951a;
            r101.f538943i = true;
            IMonitorCallback r102 = r101.f538945k;
            if (r102 == null) goto L9;
            r102.onHookActivityTaskManagerResult(true);
        L9:
            return true;
        L10:
            a r103 = this.f538951a;
            r103.f538942h = true;
            IMonitorCallback r104 = r103.f538945k;
            if (r104 == null) goto L13;
            r104.onHookActivityManagerResult(true);
        L13:
            return true;
        }
    }

    /* JADX INFO: loaded from: classes34.dex */
    public class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ pqa.a f538952a;

        @Override // java.lang.Runnable
        public final void run() {
            PushServiceManager.get().getPushExternalService().getMultiProcessEventSenderService().onEventV3("alliance_process_isolation_error", this.f538952a.b());     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public b(pqa.a r100) {
            this.f538952a = r100;
        }
    }

    public final void c() {
        if (g77.c.f480245e != null) goto L15;
        monitor-enter(g77.c.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (g77.c.f480245e != null) goto L9;
        g77.c.f480245e = new g77.c();     // Catch: Throwable -> L11
    L9:
        monitor-exit(g77.c.class);     // Catch: Throwable -> L11
    L15:
        if (g77.c.f480245e.a(this) == false) goto L17;
        ((tqa.a) tqa.a.c()).a().onHookResult("ActivityTaskManager", true, "success", ToolUtils.currentTimeMillis() - this.f538946l);
        this.f538950p.sendEmptyMessage(10141758);
        return;
    L17:
        ((tqa.a) tqa.a.c()).a().onHookResult("ActivityTaskManager", false, "hook failed", ToolUtils.currentTimeMillis() - this.f538946l);
    }

    public final void i() {
        if (this.f538937c.getAndSet(true) == false) goto L5;
        return;
    L5:
        ProcessEnum r100 = ToolUtils.getCurProcess(this.f538935a);
        if (this.f538940f == false) goto L8;
        PushOnlineSettings r101 = new PushOnlineSettings$$SettingImpl(new h(this.f538935a, "push_multi_process_config"));
    L9:
        this.f538939e = r101.I();
        f.b("AssociationStartMonitorService", "[" + r100.processSuffix + "] on monitorAssociationStart enableAssociationHook is " + this.f538939e.f502025a + " enableAssociationStartMonitor is " + this.f538939e.f502026b + " enableAssociationStartIntercept is " + this.f538939e.f502028d + " interceptComponentWhiteList is " + this.f538939e.f502031g + " interceptComponentBlackList is " + this.f538939e.f502030f + " isolationInterceptComponentBlackList is " + this.f538939e.f502029e + " monitorComponentWhiteList is " + this.f538939e.f502027c + " smpRedirectMap is " + this.f538939e.f502032h);
        if (this.f538939e.f502026b == false) goto L15;
        if (this.f538940f == true) goto L15;
        ((tqa.a) tqa.a.c()).a().enableReport(true);
    L15:
        if (this.f538940f == false) goto L18;
        ((HashMap) this.f538941g).putAll(this.f538939e.f502032h);
    L18:
        if (this.f538940f == false) goto L23;
        if (PushServiceManager.get().getIAllianceService().allowStartOthersProcessFromSmp() == true) goto L23;
        f.b("AssociationStartMonitorService", "[" + r100.processSuffix + "] enable hook because mCurIsSmpProcess and allowStartOthersProcessFromSmp is false");
        this.f538939e.f502025a = true;
    L23:
        if (ToolUtils.isMainProcess(this.f538935a) == false) goto L28;
        if (PushServiceManager.get().getPushExternalService().allowStartNonMainProcess() == true) goto L28;
        f.b("AssociationStartMonitorService", "[" + r100.processSuffix + "] enable hook because allowStartNonMainProcess is false");
        this.f538939e.f502025a = true;
    L28:
        if (this.f538940f == true) goto L31;
        this.f538944j = r101.p().f549045a;
    L31:
        if (this.f538944j == false) goto L34;
        f.b("AssociationStartMonitorService", "[" + r100.processSuffix + "] enable hook because enableMonitorNotificationShow is true");
        this.f538939e.f502025a = true;
    L34:
        if (this.f538939e.f502025a == true) goto L36;
        return;
    L36:
        if (g77.b.f480244e != null) goto L48;
        monitor-enter(g77.b.class);
    L44:
        th = move-exception;
        throw th;
    L40:
        if (g77.b.f480244e != null) goto L42;
        g77.b.f480244e = new g77.b();     // Catch: Throwable -> L44
    L42:
        monitor-exit(g77.b.class);     // Catch: Throwable -> L44
    L48:
        if (g77.b.f480244e.a(this) == false) goto L50;
        ((tqa.a) tqa.a.c()).a().onHookResult("ActivityManager", true, "success", ToolUtils.currentTimeMillis() - this.f538946l);
        this.f538950p.sendEmptyMessage(10141757);
    L51:
        c();
        return;
    L50:
        f.e("AssociationStartMonitorService", "error when hook IActivityManager for AssociationStartMonitor");
        ((tqa.a) tqa.a.c()).a().onHookResult("ActivityManager", false, "hook failed", ToolUtils.currentTimeMillis() - this.f538946l);
        goto L51
    L8:
        r101 = (PushOnlineSettings) i.a(this.f538935a, PushOnlineSettings.class);
        goto L9
    }

    public static boolean d() {
        PushCommonConfiguration r100 = PushCommonSupport.getInstance().getPushConfigurationService().getPushCommonConfiguration();
        if (r100 == null) goto L9;
        IPushCommonConfiguration r101 = r100.mIPushCommonConfiguration;
        if (r101 == null) goto L9;
        if (r101.fixAssociationStartMonitorServiceAnr() == true) goto L9;
        boolean r102 = true;
    L10:
        f.b("AssociationStartMonitorService", "[isForeGround]allowReadFile:" + r102);
        if (r102 == false) goto L13;
        boolean r103 = m67.a.d();
    L15:
        return !r103;
    L13:
        r103 = m67.a.f512287g;
    L9:
        r102 = false;
        goto L10
    }

    public a(Context r100) {
        this.f538937c = new AtomicBoolean(false);
        HashMap r101 = new HashMap();
        this.f538941g = r101;
        this.f538942h = false;
        this.f538943i = false;
        this.f538944j = false;
        this.f538947m = new ArrayList();
        this.f538948n = new ArrayList();
        this.f538949o = new ArrayList();
        this.f538950p = new Handler(PushThreadHandlerManager.inst().getLooper(), new C7522a(this));
        this.f538935a = r100;
        this.f538936b = r100.getPackageName();
        ProcessEnum r102 = ToolUtils.getCurProcess(r100);
        this.f538938d = r102;
        this.f538946l = ToolUtils.currentTimeMillis();
        this.f538940f = ToolUtils.isSmpProcess(r100);
        String r103 = ToolUtils.getCurProcessName(r100);
        if (TextUtils.isEmpty(r103) == true) goto L11;
        if (r103.endsWith(ToolUtils.SMP_PROCESS_SUFFIX) == false) goto L8;
        r101.put("com.xiaomi.mipush.sdk.MessageHandleService", "com.xiaomi.mipush.sdk.SmpMessageHandleService");
        r101.put("com.xiaomi.mipush.sdk.MIPushMessageHandler", "com.xiaomi.mipush.sdk.SmpMIPushMessageHandler");
        r101.put("com.xiaomi.mipush.sdk.PushMessageHandler", "com.xiaomi.mipush.sdk.SmpPushMessageHandler");
        this.f538947m = b(ToolUtils.SMP_PROCESS_SUFFIX);
        goto L11
    L8:
        if (r103.endsWith(ToolUtils.SMP_PROCESS_SUFFIX_V2) == false) goto L11;
        r101.put("com.xiaomi.mipush.sdk.MessageHandleService", "com.xiaomi.mipush.sdk.WidgetProviderMessageHandleService");
        r101.put("com.xiaomi.mipush.sdk.MIPushMessageHandler", "com.xiaomi.mipush.sdk.WidgetProviderMIPushMessageHandler");
        r101.put("com.xiaomi.mipush.sdk.PushMessageHandler", "com.xiaomi.mipush.sdk.WidgetProviderPushMessageHandler");
        this.f538947m = b(ToolUtils.SMP_PROCESS_SUFFIX_V2);
    L11:
        if (ToolUtils.isMainProcess(r100) == true) goto L13;
        return;
    L13:
        if (PushServiceManager.get().getPushExternalService().allowStartNonMainProcess() == false) goto L16;
        return;
    L16:
        if (r102 == ProcessEnum.PUSH) goto L19;
        this.f538948n = b(TTProcessUtils.MESSAGE_PROCESS_SUFFIX);
    L19:
        if (r102 == ProcessEnum.PUSH_SERVICE) goto L23;
        this.f538949o = b(TTProcessUtils.MESSAGE_PROCESS_SERVICE_SUFFIX);
        return;
    }

    public final List<String> b(String r110) {
        ArrayList r100 = new ArrayList();
        String r101 = "[get " + r110 + " ProcessComponent]";
    L57:
        th = move-exception;
        f.f("AssociationStartMonitorService", r101 + " exception ", th);
    L59:
        return r100;
    L4:
        if (this.f538940f == false) goto L6;
        final Context r102 = this.f538935a;     // Catch: Throwable -> L57
        final h r103 = new h(r102, "push_multi_process_config");     // Catch: Throwable -> L57
        LocalSettings r104 = new LocalSettings$$SettingImpl(r102, r103);     // Catch: Throwable -> L57
    L7:
        k77.c r105 = r104.V();     // Catch: Throwable -> L57
        int r106 = ManifestData.getInt(this.f538935a, "UPDATE_VERSION_CODE");     // Catch: Throwable -> L57
        f.b("AssociationStartMonitorService", r101 + " updateVersionCode:" + r106 + " componentProcessInfo：" + r105);     // Catch: Throwable -> L57
        if (r106 != r105.f502034b) goto L19;
        Map<String, String> r107 = r105.f502033a;     // Catch: Throwable -> L57
        List<String> r108 = null;
        if (r107 == null) goto L16;
        String r109 = r107.get(r110);     // Catch: Throwable -> L57
        if (r109 == null) goto L16;
        r108 = ToolUtils.stringDividedByCommaToList(r109);     // Catch: Throwable -> L57
    L16:
        if (r108 == null) goto L20;
        f.b("AssociationStartMonitorService", r101 + " use cache component info,component size:" + r108.size());     // Catch: Throwable -> L57
        return r108;
    L20:
        PackageInfo r111 = this.f538935a.getPackageManager().getPackageInfo(this.f538935a.getPackageName(), 15);     // Catch: Throwable -> L57
        ServiceInfo[] r112 = r111.services;     // Catch: Throwable -> L57
        int r113 = 0;
        if (r112 == null) goto L28;
        int r114 = r112.length;     // Catch: Throwable -> L57
        int r115 = 0;
    L23:
        if (r115 >= r114) goto L28;
        ServiceInfo r116 = r112[r115];     // Catch: Throwable -> L57
        if (r116.processName.endsWith(r110) == false) goto L27;
        f.b("AssociationStartMonitorService", r101 + " service:" + r116.name);     // Catch: Throwable -> L57
        r100.add(r116.name);     // Catch: Throwable -> L57
    L27:
        r115 = r115 + 1;     // Catch: Throwable -> L57
    L28:
        ActivityInfo[] r117 = r111.activities;     // Catch: Throwable -> L57
        if (r117 == null) goto L36;
        int r118 = r117.length;     // Catch: Throwable -> L57
        int r119 = 0;
    L31:
        if (r119 >= r118) goto L36;
        ActivityInfo r120 = r117[r119];     // Catch: Throwable -> L57
        if (r120.processName.endsWith(r110) == false) goto L35;
        f.b("AssociationStartMonitorService", r101 + " activity: " + r120.name);     // Catch: Throwable -> L57
        r100.add(r120.name);     // Catch: Throwable -> L57
    L35:
        r119 = r119 + 1;     // Catch: Throwable -> L57
    L36:
        ActivityInfo[] r121 = r111.receivers;     // Catch: Throwable -> L57
        if (r121 == null) goto L44;
        int r122 = r121.length;     // Catch: Throwable -> L57
        int r123 = 0;
    L39:
        if (r123 >= r122) goto L44;
        ActivityInfo r124 = r121[r123];     // Catch: Throwable -> L57
        if (r124.processName.endsWith(r110) == false) goto L43;
        f.b("AssociationStartMonitorService", r101 + " receiver: " + r124.name);     // Catch: Throwable -> L57
        r100.add(r124.name);     // Catch: Throwable -> L57
    L43:
        r123 = r123 + 1;     // Catch: Throwable -> L57
    L44:
        ProviderInfo[] r125 = r111.providers;     // Catch: Throwable -> L57
        if (r125 == null) goto L52;
        int r126 = r125.length;     // Catch: Throwable -> L57
    L47:
        if (r113 >= r126) goto L52;
        ProviderInfo r127 = r125[r113];     // Catch: Throwable -> L57
        if (r127.processName.endsWith(r110) == false) goto L51;
        f.b("AssociationStartMonitorService", r101 + " provider: " + r127.authority);     // Catch: Throwable -> L57
        r100.add(r127.authority);     // Catch: Throwable -> L57
    L51:
        r113 = r113 + 1;     // Catch: Throwable -> L57
    L52:
        String r128 = ToolUtils.listToStringDivideByComma(r100);     // Catch: Throwable -> L57
        f.b("AssociationStartMonitorService", r101 + " save cur component info,updateVersionCode:" + r106 + " componentInfo size:" + r100.size());     // Catch: Throwable -> L57
        if (r105.f502033a != null) goto L55;
        r105.f502033a = new HashMap();     // Catch: Throwable -> L57
    L55:
        r105.f502033a.put(r110, r128);     // Catch: Throwable -> L57
        r105.f502034b = r106;     // Catch: Throwable -> L57
        r104.X(r105);     // Catch: Throwable -> L57
        goto L59
    L19:
        f.b("AssociationStartMonitorService", r101 + "update version code changed,get new component info");     // Catch: Throwable -> L57
        goto L20
    L6:
        r104 = (LocalSettings) i.a(this.f538935a, LocalSettings.class);     // Catch: Throwable -> L57
        goto L7
    }

    public final void e(pqa.a r100) {
        if (r100 == null) goto L29;
        String r101 = r100.f530311f;     // Catch: Throwable -> L25
        if (TextUtils.equals(r100.f530308c, this.f538936b) == false) goto L7;
        f.e("AssociationStartMonitorService", "[onComponentStartInternal]not invoke onAssociationStartEvent because cur startRecord is not cross app");     // Catch: Throwable -> L25
    L14:
        if (ToolUtils.isMainProcess(this.f538935a) == true) goto L16;
        return;
    L16:
        if (PushServiceManager.get().getPushExternalService().allowStartNonMainProcess() == false) goto L19;
        return;
    L19:
        if (this.f538948n.contains(r100.f530309d) == false) goto L22;
        ThreadPlus.submitRunnable(new c(this, r100, ProcessEnum.PUSH.processSuffix));     // Catch: Throwable -> L25
        return;
    L22:
        if (this.f538949o.contains(r100.f530309d) == false) goto L33;
        ThreadPlus.submitRunnable(new c(this, r100, ProcessEnum.PUSH_SERVICE.processSuffix));     // Catch: Throwable -> L25
        return;
    L33:
        return;
    L7:
        if (TextUtils.isEmpty(r101) == false) goto L9;
    L11:
        f.e("AssociationStartMonitorService", "[onComponentStartInternal]not invoke onAssociationStartEvent because loop invoke");     // Catch: Throwable -> L25
        goto L14
    L9:
        if (r101.contains("com.ss.alive.monitor.services.impl.AssociationStartMonitorEventServiceImpl.onAssociationStartEvent") == true) goto L11;
        ((tqa.a) tqa.a.c()).a().onAssociationStartEvent(r100);     // Catch: Throwable -> L25
    L25:
        th = move-exception;
        f.e("AssociationStartMonitorService", "onComponentStart error:" + th.getMessage());
        f.e("AssociationStartMonitorService", Log.getStackTraceString(th));
        return;
    }

    public final pqa.a f(StartType r100, Intent r101) {
        if (r101 == null) goto L9;
        String r102 = r101.getPackage();
        ComponentName r103 = r101.getComponent();
        if (r103 == null) goto L7;
        pqa.a r104 = new pqa.a();
        r104.f530306a = r100;
        StackTraceElement[] r105 = new Throwable().getStackTrace();
        String r106 = Log.getStackTraceString(new Throwable());
        r104.f530312g = ToolUtils.currentTimeMillis();
        r104.f530307b = d();
        r104.f530308c = r102;
        r104.f530309d = r103.getClassName();
        r104.f530313h = this.f538938d.processSuffix;
        r104.f530310e = r105;
        r104.f530311f = r106;
        return r104;
    L7:
        if (TextUtils.isEmpty(r101.getAction()) == true) goto L9;
        pqa.a r107 = new pqa.a();
        r107.f530306a = r100;
        StackTraceElement[] r108 = new Throwable().getStackTrace();
        String r109 = Log.getStackTraceString(new Throwable());
        r107.f530312g = ToolUtils.currentTimeMillis();
        r107.f530307b = d();
        r107.f530308c = r102;
        r107.f530309d = r101.getAction();
        r107.f530313h = this.f538938d.processSuffix;
        r107.f530310e = r108;
        r107.f530311f = r109;
        return r107;
    L9:
        return null;
    }

    public final pqa.a g(StartType r100, String r101) {
        pqa.a r102 = new pqa.a();
        r102.f530306a = r100;
        StackTraceElement[] r103 = new Throwable().getStackTrace();
        String r104 = Log.getStackTraceString(new Throwable());
        r102.f530312g = ToolUtils.currentTimeMillis();
        r102.f530309d = r101;
        r102.f530313h = this.f538938d.processSuffix;
        r102.f530310e = r103;
        r102.f530311f = r104;
        return r102;
    }

    public final pqa.a h(StartType r100, Uri r101) {
        if (r101 == null) goto L4;
        r101.getHost();
        pqa.a r102 = new pqa.a();
        r102.f530306a = r100;
        StackTraceElement[] r103 = new Throwable().getStackTrace();
        String r104 = Log.getStackTraceString(new Throwable());
        r102.f530312g = ToolUtils.currentTimeMillis();
        r102.f530307b = d();
        r102.f530309d = r101.toString();
        r102.f530313h = this.f538938d.processSuffix;
        r102.f530310e = r103;
        r102.f530311f = r104;
        return r102;
    L4:
        return null;
    }

    @Override // g77.a
    public final g77.f a(Object r110, Method r111, Object[] r112) throws InvocationTargetException, IllegalAccessException {
        String r100 = "";
        String r101 = r111.getName();
        StartType r113 = StartType.START_SERVICE;     // Catch: Throwable -> L48
        if (TextUtils.equals(r101, r113.methodName) == false) goto L6;
        pqa.a r102 = f(r113, (Intent) r112[1]);     // Catch: Throwable -> L48
    L52:
        if (r102 != null) goto L54;
    L56:
        pqa.a r114 = r102;
    L58:
        if (Looper.getMainLooper() != Looper.myLooper()) goto L60;
        ThreadPlus.submitRunnable(new rqa.b(this, r114));
    L61:
        g77.f r115 = new g77.f();
        if (r114 == null) goto L206;
        if (this.f538940f == false) goto L193;
        if (PushServiceManager.get().getIAllianceService().allowStartOthersProcessFromSmp() == true) goto L193;
        List<String> r103 = this.f538947m;
        if (r103 != null) goto L70;
    L73:
        f.b("AssociationStartMonitorService", "find non smp component on smp process:" + r111.getName() + " " + r114.f530309d + " " + Log.getStackTraceString(new Throwable()));
        Boolean r104 = ToolUtils.isMainProcessStart(this.f538935a);
        if (r104 != null) goto L76;
    L77:
        String r105 = r111.getName();
    L160:
        th = move-exception;
        f.f("AssociationStartMonitorService", "error when redirect ", th);
    L162:
        boolean r106 = false;
    L163:
        if (r106 == false) goto L166;
        return r115;
    L166:
        if (((ArrayList) this.f538939e.f502029e).contains(r114.f530309d) == false) goto L191;
        f.b("AssociationStartMonitorService", "intercept ：" + r114.f530309d + " because it's in smpInterceptComponentBlackList");
        String r107 = r111.getName();
        if (TextUtils.equals(r107, StartType.START_SERVICE.methodName) == false) goto L171;
        Intent r108 = (Intent) r112[1];
        r115.f480256a = true;
        r115.f480257b = r108.getComponent();
        goto L191
    L171:
        if (TextUtils.equals(r107, StartType.BIND_SERVICE.methodName) == false) goto L175;
        r115.f480257b = 1;
        r115.f480256a = true;
        return r115;
    L175:
        if (TextUtils.equals(r107, StartType.PROVIDER_GET_TYPE.methodName) == false) goto L179;
        r115.f480257b = null;
        r115.f480256a = true;
        return r115;
    L179:
        if (TextUtils.equals(r107, StartType.PROVIDER_QUERY.methodName) == false) goto L183;
        r115.f480257b = null;
        r115.f480256a = true;
        return r115;
    L183:
        if (TextUtils.equals(r107, StartType.SEND_BROADCAST.methodName) == false) goto L187;
        r115.f480257b = 0;
        r115.f480256a = true;
        return r115;
    L187:
        if (TextUtils.equals(r107, StartType.START_ACTIVITY.methodName) == false) goto L190;
        r115.f480257b = 0;
        r115.f480256a = true;
        return r115;
    L190:
        f.e("AssociationStartMonitorService", "intercept ：" + r114.f530309d + " failed");
    L191:
        f.b("AssociationStartMonitorService", "smpProcessMonitor: redirectSuccess is false , report alliance_process_isolation_error event");
        ThreadPlus.submitRunnable(new b(r114));
        goto L193
    L80:
        if (TextUtils.equals(r105, StartType.START_SERVICE.methodName) == false) goto L91;
        Intent r109 = (Intent) r112[1];     // Catch: Throwable -> L160
        if (r109 == null) goto L162;
        ComponentName r116 = r109.getComponent();     // Catch: Throwable -> L160
        if (r116 == null) goto L162;
        String r117 = (String) ((HashMap) this.f538941g).get(r116.getClassName());     // Catch: Throwable -> L160
        if (r117 == null) goto L162;
        if (TextUtils.isEmpty(r117) == true) goto L162;
        r109.setComponent(new ComponentName(this.f538935a.getPackageName(), r117));     // Catch: Throwable -> L160
        r112[1] = r109;     // Catch: Throwable -> L160
        f.b("AssociationStartMonitorService", "smpProcessMonitor: replace " + r116.getClassName() + " to " + r117);     // Catch: Throwable -> L160
    L159:
        r106 = true;
        goto L163
    L91:
        if (TextUtils.equals(r105, StartType.BIND_SERVICE.methodName) == false) goto L102;
        Intent r118 = (Intent) r112[2];     // Catch: Throwable -> L160
        if (r118 == null) goto L162;
        ComponentName r119 = r118.getComponent();     // Catch: Throwable -> L160
        if (r119 == null) goto L162;
        String r120 = (String) ((HashMap) this.f538941g).get(r119.getClassName());     // Catch: Throwable -> L160
        if (r120 == null) goto L162;
        if (TextUtils.isEmpty(r120) == true) goto L162;
        r118.setComponent(new ComponentName(this.f538935a.getPackageName(), r120));     // Catch: Throwable -> L160
        r112[2] = r118;     // Catch: Throwable -> L160
        f.b("AssociationStartMonitorService", "smpProcessMonitor: replace " + r119.getClassName() + " to " + r120);     // Catch: Throwable -> L160
        goto L159
    L102:
        if (TextUtils.equals(r105, StartType.PROVIDER_GET_TYPE.methodName) == false) goto L109;
        Uri r121 = (Uri) r112[0];     // Catch: Throwable -> L160
        if (r121 == null) goto L162;
        String r122 = (String) ((HashMap) this.f538941g).get(r121.toString());     // Catch: Throwable -> L160
        if (TextUtils.isEmpty(r122) == true) goto L162;
        r112[0] = UriProtector.parse(r122).buildUpon().build();     // Catch: Throwable -> L160
        f.b("AssociationStartMonitorService", "smpProcessMonitor: replace " + r121 + " to " + r122);     // Catch: Throwable -> L160
        goto L159
    L109:
        if (TextUtils.equals(r105, StartType.PROVIDER_QUERY.methodName) == false) goto L128;
        Object r123 = r112[2];     // Catch: Throwable -> L160
        if ((r123 instanceof String) == false) goto L113;
        r100 = (String) r123;     // Catch: Throwable -> L160
    L117:
        if (TextUtils.isEmpty(r100) == true) goto L162;
        String r124 = (String) ((HashMap) this.f538941g).get(r100);     // Catch: Throwable -> L160
        if (TextUtils.isEmpty(r124) == true) goto L162;
        if ((r112[2] instanceof String) == false) goto L124;
        r112[2] = r124;     // Catch: Throwable -> L160
    L126:
        f.b("AssociationStartMonitorService", "smpProcessMonitor: replace " + r100 + " to " + r124);     // Catch: Throwable -> L160
        goto L159
    L124:
        if ((r112[1] instanceof String) == false) goto L126;
        r112[1] = r124;     // Catch: Throwable -> L160
        goto L126
    L113:
        Object r125 = r112[1];     // Catch: Throwable -> L160
        if ((r125 instanceof String) == false) goto L117;
        r100 = (String) r125;     // Catch: Throwable -> L160
        goto L117
    L128:
        if (TextUtils.equals(r105, StartType.SEND_BROADCAST.methodName) == false) goto L137;
        Intent r126 = (Intent) r112[1];     // Catch: Throwable -> L160
        ComponentName r127 = r126.getComponent();     // Catch: Throwable -> L160
        if (r127 == null) goto L162;
        String r128 = (String) ((HashMap) this.f538941g).get(r127.getClassName());     // Catch: Throwable -> L160
        if (r128 == null) goto L162;
        if (TextUtils.isEmpty(r128) == true) goto L162;
        r126.setComponent(new ComponentName(this.f538935a.getPackageName(), r128));     // Catch: Throwable -> L160
        r112[1] = r126;     // Catch: Throwable -> L160
        f.b("AssociationStartMonitorService", "smpProcessMonitor: replace " + r127.getClassName() + " to " + r128);     // Catch: Throwable -> L160
        goto L159
    L137:
        if (TextUtils.equals(r105, StartType.START_ACTIVITY.methodName) == false) goto L162;
        Object r129 = r112[3];     // Catch: Throwable -> L160
        if ((r129 instanceof Intent) == false) goto L141;
        Intent r130 = (Intent) r129;     // Catch: Throwable -> L160
    L145:
        if (r130 == null) goto L162;
        ComponentName r131 = r130.getComponent();     // Catch: Throwable -> L160
        if (r131 == null) goto L162;
        String r132 = (String) ((HashMap) this.f538941g).get(r131.getClassName());     // Catch: Throwable -> L160
        if (r132 == null) goto L162;
        if (TextUtils.isEmpty(r132) == true) goto L162;
        r130.setComponent(new ComponentName(this.f538935a.getPackageName(), r132));     // Catch: Throwable -> L160
        if ((r112[3] instanceof Intent) == false) goto L156;
        r112[3] = r130;     // Catch: Throwable -> L160
    L158:
        f.b("AssociationStartMonitorService", "smpProcessMonitor: replace " + r131.getClassName() + " to " + r132);     // Catch: Throwable -> L160
        goto L159
    L156:
        if ((r112[2] instanceof Intent) == false) goto L158;
        r112[2] = r130;     // Catch: Throwable -> L160
        goto L158
    L141:
        Object r133 = r112[2];     // Catch: Throwable -> L160
        if ((r133 instanceof Intent) == false) goto L144;
        r130 = (Intent) r133;     // Catch: Throwable -> L160
        goto L145
    L144:
        r130 = null;
        goto L145
    L76:
        if (r104.booleanValue() == true) goto L193;
    L70:
        if (r103.size() == 0) goto L73;
        if (this.f538947m.contains(r114.f530309d) == false) goto L73;
    L193:
        if (((ArrayList) this.f538939e.f502030f).contains(r114.f530309d) == false) goto L197;
        f.b("AssociationStartMonitorService", "intercept ：" + r114.f530309d + " because it's in interceptComponentBlackList");
        return null;
    L197:
        if (this.f538939e.f502028d == true) goto L199;
        return r115;
    L199:
        f.b("AssociationStartMonitorService", "enableAssociationStartIntercept is true, try intercept it: " + r114.f530309d);
        if (((ArrayList) this.f538939e.f502031g).contains(r114.f530309d) == false) goto L203;
        f.b("AssociationStartMonitorService", "try intercept it：" + r114.f530309d + " is in interceptComponentWhiteList so not intercept");
        return r115;
    L203:
        f.b("AssociationStartMonitorService", "try intercept it：" + r114.f530309d + " is not in interceptComponentWhiteList so intercept");
        r115.f480256a = true;
        return r115;
    L206:
        if (TextUtils.equals(r111.getName(), "setServiceForeground") == false) goto L228;
        if (this.f538944j == false) goto L243;
        if (r112 == null) goto L243;
        int r134 = r112.length;
        Notification r135 = null;
        ComponentName r136 = null;
        int r137 = 0;
    L211:
        if (r137 >= r134) goto L222;
        Object r138 = r112[r137];
        if (r136 == null) goto L215;
    L217:
        if (r135 != null) goto L221;
        if ((r138 instanceof Notification) == false) goto L221;
        r135 = (Notification) r138;
    L221:
        r137 = r137 + 1;
        goto L211
    L215:
        if ((r138 instanceof ComponentName) == false) goto L217;
        r136 = (ComponentName) r138;
        goto L217
    L222:
        if (r135 == null) goto L243;
        if (PushServiceManager.get().getPushExternalService().getNotificationMonitorService().onForeGroundNotificationShow(r136, r135) == true) goto L243;
        return null;
    L243:
        return r115;
    L228:
        if (TextUtils.equals(r111.getName(), "getIntentSenderWithFeature") == false) goto L243;
        if (this.f538944j == false) goto L243;
        if (r112 != null) goto L244;
    L239:
        Intent r139 = null;
    L240:
        if (r139 == null) goto L243;
        if (r110 == null) goto L243;
        Object r140 = r111.invoke(r110, r112);
        PushServiceManager.get().getPushExternalService().getNotificationMonitorService().onPendingIntent(r140, r139);
        r115.f480256a = true;
        r115.f480257b = r140;
        goto L243
    L244:
        Intent[] r141 = (Intent[]) r112[6];     // Catch: Throwable -> L237
        if (r141.length <= 0) goto L239;
        r139 = r141[0];     // Catch: Throwable -> L237
    L237:
        th = move-exception;
        f.f("AssociationStartMonitorService", "error when parse intent ", th);
        goto L239
    L60:
        e(r114);
        goto L61
    L54:
        if (((ArrayList) this.f538939e.f502027c).contains(r102.f530309d) == false) goto L56;
        f.b("AssociationStartMonitorService", r102.f530309d + " is in monitorComponentWhiteList so not monitor it , monitorComponentWhiteList is " + this.f538939e.f502027c.toString());
        r114 = null;
        goto L58
    L6:
        StartType r142 = StartType.BIND_SERVICE;     // Catch: Throwable -> L48
        if (TextUtils.equals(r101, r142.methodName) == false) goto L9;
        r102 = f(r142, (Intent) r112[2]);     // Catch: Throwable -> L48
        goto L52
    L9:
        StartType r143 = StartType.PROVIDER_GET_TYPE;     // Catch: Throwable -> L48
        if (TextUtils.equals(r101, r143.methodName) == false) goto L12;
        r102 = h(r143, (Uri) r112[0]);     // Catch: Throwable -> L48
        goto L52
    L12:
        StartType r144 = StartType.PROVIDER_QUERY;     // Catch: Throwable -> L48
        if (TextUtils.equals(r101, r144.methodName) == false) goto L33;
        Object r145 = r112[2];     // Catch: Throwable -> L48
        if ((r145 instanceof String) == false) goto L19;
        String r146 = (String) r145;     // Catch: Throwable -> L48
        if (TextUtils.equals(r146, this.f538936b) == false) goto L22;
        String r147 = this.f538936b;     // Catch: Throwable -> L48
    L25:
        if (TextUtils.isEmpty(r146) == true) goto L47;
        pqa.a r148 = g(r144, r146);     // Catch: Throwable -> L48
    L31:
        th = th;
    L50:
        f.f("AssociationStartMonitorService", "error when parse startRecord ", th);
    L51:
        r102 = r148;
        goto L52
    L28:
        if (TextUtils.isEmpty(r147) == true) goto L51;
        r148.f530308c = r147;     // Catch: Throwable -> L31
    L47:
        r102 = null;
    L22:
        r147 = "";
        goto L25
    L19:
        Object r149 = r112[1];     // Catch: Throwable -> L48
        if ((r149 instanceof String) == false) goto L23;
        r146 = (String) r149;     // Catch: Throwable -> L48
        goto L22
    L23:
        r146 = "";
        r147 = r146;
        goto L25
    L33:
        StartType r150 = StartType.SEND_BROADCAST;     // Catch: Throwable -> L48
        if (TextUtils.equals(r101, r150.methodName) == false) goto L36;
        r102 = f(r150, (Intent) r112[1]);     // Catch: Throwable -> L48
        goto L52
    L36:
        StartType r151 = StartType.START_ACTIVITY;     // Catch: Throwable -> L48
        if (TextUtils.equals(r101, r151.methodName) == false) goto L47;
        Object r152 = r112[3];     // Catch: Throwable -> L48
        if ((r152 instanceof Intent) == false) goto L41;
        Intent r153 = (Intent) r152;     // Catch: Throwable -> L48
    L45:
        r102 = f(r151, r153);     // Catch: Throwable -> L48
        goto L52
    L41:
        Object r154 = r112[2];     // Catch: Throwable -> L48
        if ((r154 instanceof Intent) == false) goto L44;
        r153 = (Intent) r154;     // Catch: Throwable -> L48
        goto L45
    L44:
        r153 = null;
    L48:
        th = th;
        r148 = null;
        goto L50
    }
}
