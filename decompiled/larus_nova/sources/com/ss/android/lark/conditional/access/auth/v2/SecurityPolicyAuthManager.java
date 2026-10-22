package com.ss.android.lark.conditional.access.auth.v2;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Handler;
import androidx.core.content.ContextCompat;
import com.bytedance.lark.policy.decision.PolicyDecision;
import com.bytedance.lark.policy.event.Event;
import com.bytedance.lark.policy.event.EventManager;
import com.bytedance.lark.policy.model.ValidateRequest;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.sysoptimizer.ReceiverRegisterAnrOptimizer;
import com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer;
import com.bytedance.sysoptimizer.ReceiverRegisterLancet;
import com.larus.dora.obric.device_management.device_home.DoraObricDeviceHomeViewModel;
import com.ss.android.lark.appcontext.applifecycle.AppLifecycle;
import com.ss.android.lark.conditional.access.auth.v2.handler.RefreshNotifyHandler;
import com.ss.android.lark.conditional.access.auth.v2.service.DeviceControlService;
import com.ss.android.lark.conditional.access.auth.v2.service.PolicyValidateService;
import com.ss.android.lark.conditional.access.auth.v2.service.SecurityLabelControlService;
import com.ss.android.lark.conditional.access.network.easynetwork.EasyNetworkState;
import com.ss.android.lark.conditional.access.network.easynetwork.EasyNetworkType;
import com.ss.android.lark.conditional.access.network.easynetwork.NetworkTypeDetector;
import com.ss.android.lark.conditional.access.utils.FileAuthMonitor;
import com.ss.android.lark.passport.signinsdk_api.account.User;
import com.ss.android.lark.security.compliance.api.model.filepolicy.CCMFileEntity;
import com.ss.android.lark.security.compliance.api.model.filepolicy.CalendarFileEntity;
import com.ss.android.lark.security.compliance.api.model.filepolicy.FileBizDomain;
import com.ss.android.lark.security.compliance.api.model.filepolicy.PolicyEntity;
import com.ss.android.lark.security.compliance.api.model.filepolicy.PolicyModel;
import com.ss.android.lark.security.compliance.api.model.filepolicy.ResultType;
import com.ss.android.lark.security.compliance.api.model.filepolicy.VCFileEntity;
import com.ss.android.lark.security.compliance.api.model.filepolicy.ValidateResultSource;
import com.ss.android.lark.security.compliance.infra.log.ScsLogger;
import com.ss.android.lark.utils.LarkContext;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArraySet;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes35.dex */
public final class SecurityPolicyAuthManager implements i8b.q {

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static final /* synthetic */ int f417747x = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f417748a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f417749b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f417750c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Context f417751d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final b f417752e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f417753f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public EasyNetworkState f417754g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final c f417755h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Lazy<Handler> f417756i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final com.ss.android.lark.conditional.access.auth.v2.service.m f417757j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final com.ss.android.lark.conditional.access.auth.v2.service.a f417758k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final DeviceControlService f417759l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final SecurityLabelControlService f417760m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final com.ss.android.lark.conditional.access.auth.v2.service.f f417761n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final Lazy f417762o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final PolicyValidateService f417763p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final com.ss.android.lark.conditional.access.auth.v2.service.d f417764q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final com.ss.android.lark.conditional.access.auth.v2.handler.b f417765r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final com.ss.android.lark.conditional.access.auth.v2.handler.f f417766s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public boolean f417767t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final d f417768u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final Lazy f417769v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final ArrayList<i8b.a> f417770w;

    public static final class a {
    }

    public static final class b implements com.ss.android.lark.appcontext.applifecycle.y {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ SecurityPolicyAuthManager f417771a;

        public b(SecurityPolicyAuthManager r100) {
            this.f417771a = r100;
        }

        @Override // com.ss.android.lark.appcontext.applifecycle.y
        public final void f(com.ss.android.lark.appcontext.applifecycle.y.a r100, com.ss.android.lark.appcontext.applifecycle.y.a r101) {
            Intrinsics.checkNotNullParameter(r100, "oldState");
            Intrinsics.checkNotNullParameter(r101, "newState");
            if (r100.f408860c == true) goto L16;
            boolean r102 = r101.f408860c;
            if (r102 == false) goto L17;
            SecurityPolicyAuthManager r103 = this.f417771a;
            Context r104 = r103.f417751d;
            if (r104 != null) goto L9;
            Intrinsics.throwUninitializedPropertyAccessException(PerfLog.PARAM_KEY_CONTEXT_ID);
            r104 = null;
        L9:
            EasyNetworkState r105 = NetworkTypeDetector.a(r104);
            if (r102 == true) goto L12;
            return;
        L12:
            if (r103.f417754g.sameAs(r105) == true) goto L14;
            ArrayList<String> r106 = com.ss.android.lark.conditional.access.utils.c.f418483a;
            com.ss.android.lark.conditional.access.utils.c.b("SecurityPolicy_SecurityPolicyAuthManager", "Back to front, and network state changed", true);
            r103.f417754g = new EasyNetworkState(r105.getEasyNetworkType(), r105.getNetworkId());
            r103.c(new i8b.r(FileAuthMonitor.UpdateTrigger.NetworkChange));
        L14:
            r103.k(FileAuthMonitor.UpdateTrigger.BackToFront);
            return;
        L17:
            return;
        }
    }

    public static final class c implements l8b.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ SecurityPolicyAuthManager f417772a;

        public c(SecurityPolicyAuthManager r100) {
            this.f417772a = r100;
        }

        @Override // l8b.a
        public final void a(EasyNetworkState r100) {
            if (this.f417772a.f417748a == false) goto L6;
            SecurityPolicyAuthManager r101 = this.f417772a;
            Intrinsics.checkNotNull(r100);
            r101.getClass();
            Intrinsics.checkNotNullParameter(r100, "networkState");
            r101.f417754g = r100;
            ArrayList<String> r102 = com.ss.android.lark.conditional.access.utils.c.f418483a;
            com.ss.android.lark.conditional.access.utils.c.b("SecurityPolicy_SecurityPolicyAuthManager", "[onNetTypeChanged] currNetworkState = " + r100, false);
            Event r103 = Event.EVENT_NETWORK_CHANGE;
            ke6.d r104 = ke6.d.f503032a;
            Intrinsics.checkNotNullParameter(r103, "event");
            EventManager.a(r103);
            r101.c(new i8b.r(FileAuthMonitor.UpdateTrigger.NetworkChange));
            return;
        }
    }

    public static final class d implements jdb.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ SecurityPolicyAuthManager f417773a;

        public d(SecurityPolicyAuthManager r100) {
            this.f417773a = r100;
        }

        @Override // jdb.c
        public final void a(boolean r100) {
            if (r100 == false) goto L7;
            SecurityPolicyAuthManager r101 = this.f417773a;
            if (r101.f417767t == true) goto L8;
            r101.k(FileAuthMonitor.UpdateTrigger.UIdChange);
            this.f417773a.n();
            return;
        L8:
            return;
        }
    }

    static {
    }

    @Override // i8b.q
    public final Map<String, com.ss.android.lark.conditional.access.auth.v2.service.i> i() {
        return this.f417761n.f417902d;
    }

    public final void l() {
        RefreshNotifyHandler.f417802b.clear();
        RefreshNotifyHandler.f417803c.clear();
        Handler r100 = com.ss.android.lark.conditional.access.auth.v2.handler.a.f417807b;
        if (r100 == null) goto L5;
        r100.removeCallbacksAndMessages(null);
    L5:
        ((LinkedHashMap) com.ss.android.lark.conditional.access.auth.v2.handler.a.f417808c).clear();
        com.ss.android.lark.conditional.access.auth.v2.handler.b r101 = this.f417765r;
        Handler r102 = r101.f417812b;
        if (r102 == null) goto L8;
        r102.removeCallbacksAndMessages(null);
    L8:
        ((LinkedHashMap) r101.f417813c).clear();
        if (this.f417756i.isInitialized() == false) goto L11;
        this.f417756i.getValue().removeCallbacksAndMessages(null);
    L11:
        Iterator<T> r103 = this.f417770w.iterator();
    L13:
        if (r103.hasNext() == false) goto L16;
        ((i8b.a) r103.next()).a();
        goto L13
    L16:
        if (this.f417767t == false) goto L20;
        idb.f.a().removeFeatureGatingUpdateListener(this.f417768u, "_normal_fg");
        this.f417753f = false;
        c r104 = this.f417755h;
        NetworkTypeDetector.f418072b.remove(r104);
        AppLifecycle r105 = AppLifecycle.a.f408803a;
        b r106 = this.f417752e;
        r105.f408785h.remove(r106);
        com.bytedance.lark.policy.event.a r107 = (com.bytedance.lark.policy.event.a) this.f417769v.getValue();
        ke6.d r108 = ke6.d.f503032a;
        Intrinsics.checkNotNullParameter(r107, "observer");
        CopyOnWriteArraySet<com.bytedance.lark.policy.event.a> r109 = EventManager.f253801a;
        Intrinsics.checkNotNullParameter(r107, "eventObserver");
        EventManager.f253801a.remove(r107);
        this.f417767t = false;
        return;
    }

    public final void m() {
        qqb.a.h("onUserIdChanged");     // Catch: Throwable -> L30
        this.f417749b = ((yzb.b) LarkContext.spiByDwarf(yzb.b.class)).d();     // Catch: Throwable -> L30
        User r100 = ((yzb.b) LarkContext.spiByDwarf(yzb.b.class)).getForegroundUser();     // Catch: Throwable -> L30
        if (r100 == null) goto L7;
        String r101 = r100.getTenantId();     // Catch: Throwable -> L30
        if (r101 == null) goto L7;
    L8:
        this.f417750c = r101;     // Catch: Throwable -> L30
        l();     // Catch: Throwable -> L30
        com.ss.android.lark.storage.kv.repo.a r102 = y.f417932a;     // Catch: Throwable -> L30
        y.c();     // Catch: Throwable -> L30
        if (this.f417749b.length() != 0) goto L12;
        boolean r103 = true;
    L13:
        if (r103 == false) goto L16;
        qqb.a.a();
        return;
    L16:
        z r104 = z.f417940a;     // Catch: Throwable -> L30
        long r105 = System.currentTimeMillis();     // Catch: Throwable -> L30
        r104.getClass();     // Catch: Throwable -> L30
        z.f417941b = r105;     // Catch: Throwable -> L30
        ArrayList<String> r106 = com.ss.android.lark.conditional.access.utils.c.f418483a;     // Catch: Throwable -> L30
        com.ss.android.lark.conditional.access.utils.c.b("SecurityPolicy_SecurityPolicyAuthManager", "User info changed", false);     // Catch: Throwable -> L30
        Iterator<T> r107 = this.f417770w.iterator();     // Catch: Throwable -> L30
    L18:
        if (r107.hasNext() == false) goto L21;
        ((i8b.a) r107.next()).d(this.f417749b, this.f417750c);     // Catch: Throwable -> L30
        goto L18
    L21:
        if (this.f417767t == true) goto L24;
        idb.f.a().addFeatureGatingUpdateListener("lark.security.file_protection_client", this.f417768u, "_normal_fg");     // Catch: Throwable -> L30
    L24:
        if (com.ss.android.lark.conditional.access.utils.f.a() == true) goto L26;
    L28:
        qqb.a.a();
        return;
    L26:
        if (this.f417767t == true) goto L28;
        n();     // Catch: Throwable -> L30
        goto L28
    L12:
        r103 = false;
    L7:
        r101 = "";
    L30:
        th = move-exception;
        qqb.a.a();
        throw th;
    }

    public final void n() {
        AppLifecycle.a.f408803a.c(this.f417752e);
        if (this.f417753f == true) goto L41;
        this.f417753f = true;
        NetworkTypeDetector.f418072b.add(this.f417755h);
        Context r100 = this.f417751d;
        if (r100 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException(PerfLog.PARAM_KEY_CONTEXT_ID);
        r100 = null;
    L8:
        if (NetworkTypeDetector.f418071a != null) goto L10;
        NetworkTypeDetector.f418071a = new NetworkTypeDetector();
    L10:
        NetworkTypeDetector.f418075e = NetworkTypeDetector.a(r100);
        IntentFilter r110 = new IntentFilter();
        r110.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        NetworkTypeDetector r111 = NetworkTypeDetector.f418071a;
        if (ReceiverRegisterCrashOptimizer.fixedOpen() == false) goto L44;
        ReceiverRegisterCrashOptimizer.doHWReceiverFix();
    L44:
    L36:
        e = move-exception;
        e.toString();
        e.printStackTrace();
        if (ReceiverRegisterCrashOptimizer.fixedOpen() == false) goto L40;
        ReceiverRegisterCrashOptimizer.registerReceiver(r111, r110);
        goto L41
    L40:
        throw e;
    L14:
        if (ReceiverRegisterAnrOptimizer.isEnableScreenReceiverOptimize() == false) goto L27;
        if (ReceiverRegisterAnrOptimizer.hasScreenActions(r110) == false) goto L27;
        int r101 = ReceiverRegisterAnrOptimizer.handleScreenActionRegistration(r111, r110, 0, null, null, 2, r100).result;     // Catch: Exception -> L36
        if (r101 != 1) goto L20;
        r100.registerReceiver(r111, r110);     // Catch: Exception -> L36
    L43:
        goto L41
    L20:
        if (r101 != 2) goto L22;
        new Intent();     // Catch: Exception -> L36
        goto L43
    L22:
        if (r101 == 3) goto L43;
        r100.registerReceiver(r111, r110);     // Catch: Exception -> L36
    L27:
        if (ReceiverRegisterCrashOptimizer.doRegisterHandler() == false) goto L30;
        ReceiverRegisterLancet.initHandler();     // Catch: Exception -> L36
        r100.registerReceiver(r111, r110, null, ReceiverRegisterLancet.sReceiverHandler);     // Catch: Exception -> L36
        goto L43
    L30:
        if (ReceiverRegisterCrashOptimizer.getReceiverRegisterHandler() != null) goto L32;
    L34:
        r100.registerReceiver(r111, r110);     // Catch: Exception -> L36
        goto L43
    L32:
        if (ReceiverRegisterCrashOptimizer.getReceiverRegisterHandler().needHookFilter(r110) == false) goto L34;
        ReceiverRegisterLancet.initProxyHandler();     // Catch: Exception -> L36
        ContextCompat.registerReceiver(r100, r111, r110, null, ReceiverRegisterLancet.sProxyHandler, 2);     // Catch: Exception -> L36
    L41:
        com.bytedance.lark.policy.event.a r102 = (com.bytedance.lark.policy.event.a) this.f417769v.getValue();
        ke6.d r103 = ke6.d.f503032a;
        Intrinsics.checkNotNullParameter(r102, "observer");
        CopyOnWriteArraySet<com.bytedance.lark.policy.event.a> r104 = EventManager.f253801a;
        Intrinsics.checkNotNullParameter(r102, "eventObserver");
        EventManager.f253801a.add(r102);
        this.f417767t = true;
    }

    public SecurityPolicyAuthManager() {
        this.f417749b = "";
        this.f417750c = "";
        this.f417752e = new b(this);
        this.f417754g = new EasyNetworkState(EasyNetworkType.NO_INTERNET_CONNECTION, "1");
        this.f417755h = new c(this);
        Lazy<Handler> r100 = LazyKt.lazy(SecurityPolicyAuthManager$timerHandler$1.INSTANCE);
        this.f417756i = r100;
        com.ss.android.lark.conditional.access.auth.v2.service.m r101 = new com.ss.android.lark.conditional.access.auth.v2.service.m(this);
        this.f417757j = r101;
        com.ss.android.lark.conditional.access.auth.v2.service.a r102 = new com.ss.android.lark.conditional.access.auth.v2.service.a(this);
        this.f417758k = r102;
        com.ss.android.lark.conditional.access.auth.v2.service.j r103 = new com.ss.android.lark.conditional.access.auth.v2.service.j(this);
        DeviceControlService r104 = new DeviceControlService(this);
        this.f417759l = r104;
        com.ss.android.lark.conditional.access.auth.v2.service.e r105 = new com.ss.android.lark.conditional.access.auth.v2.service.e(this);
        SecurityLabelControlService r106 = new SecurityLabelControlService(this);
        this.f417760m = r106;
        com.ss.android.lark.conditional.access.auth.v2.service.f r107 = new com.ss.android.lark.conditional.access.auth.v2.service.f(this);
        this.f417761n = r107;
        Lazy r108 = LazyKt.lazy(new SecurityPolicyAuthManager$mCacheService$2(this));
        this.f417762o = r108;
        PolicyValidateService r109 = new PolicyValidateService(this);
        this.f417763p = r109;
        com.ss.android.lark.conditional.access.auth.v2.service.d r110 = new com.ss.android.lark.conditional.access.auth.v2.service.d(this);
        this.f417764q = r110;
        com.ss.android.lark.conditional.access.auth.v2.service.k r111 = new com.ss.android.lark.conditional.access.auth.v2.service.k(this);
        this.f417765r = new com.ss.android.lark.conditional.access.auth.v2.handler.b(this);
        this.f417766s = new com.ss.android.lark.conditional.access.auth.v2.handler.f(this, r100);
        this.f417768u = new d(this);
        this.f417769v = LazyKt.lazy(new SecurityPolicyAuthManager$policyUpdateObserver$2(this));
        this.f417770w = CollectionsKt.arrayListOf(new i8b.a[]{r101, r102, (i8b.m) r108.getValue(), r109, r110, r111, r103, r104, r106, r107, r105});
    }

    @Override // i8b.q
    public final com.ss.android.lark.conditional.access.auth.v2.c a(PolicyModel r100) {
        Intrinsics.checkNotNullParameter(r100, "policyModel");
        this.f417763p.getClass();
        Intrinsics.checkNotNullParameter(r100, "policyModel");
        ScsLogger.d("SecurityPolicy_PolicyValidateService", "do downgradeCheck.");
        if (com.ss.android.lark.security.compliance.api.model.filepolicy.f.f440407a.values().contains(r100.getPointKey()) == true) goto L7;
        ValidateRequest r101 = new ValidateRequest("PC:CLIENT:android:" + r100.getPointKey(), new JSONObject(com.ss.android.lark.security.compliance.infra.util.f.c(r100.getEntity())), true);
        ke6.d r102 = ke6.d.f503032a;
        Intrinsics.checkNotNullParameter(r101, "request");
        int r103 = PolicyDecision.f253787a;
        return com.ss.android.lark.conditional.access.auth.v2.b.a(PolicyDecision.e(r101), ValidateResultSource.DOWNGRADE);
    L7:
        return new com.ss.android.lark.conditional.access.auth.v2.c(ResultType.ALLOW, ValidateResultSource.DOWNGRADE, null, null, 1016);
    }

    @Override // i8b.q
    public final boolean b(PolicyModel r100) {
        Intrinsics.checkNotNullParameter(r100, DoraObricDeviceHomeViewModel.PARAM_PRODUCT_MODEL);
        PolicyEntity r101 = r100.getEntity();
        if ((r101 instanceof CCMFileEntity) == false) goto L35;
        if (w4c.c.a().n() == true) goto L12;
        if (((CCMFileEntity) r101).getFileBizDomain() != FileBizDomain.FileBizDomainCCM) goto L12;
        if (Intrinsics.areEqual(r100.getPointKey(), "PointKey_CCM_FILE_UPLOAD") == true) goto L12;
        return true;
    L12:
        if (w4c.c.a().K() == false) goto L17;
        if (((CCMFileEntity) r101).getFileBizDomain() != FileBizDomain.FileBizDomainMeetingMinutes) goto L17;
        return true;
    L17:
        if (w4c.c.a().y() == false) goto L52;
        CCMFileEntity r102 = (CCMFileEntity) r101;
        FileBizDomain r103 = r102.getFileBizDomain();
        FileBizDomain r104 = FileBizDomain.FileBizDomainCALENDAR;
        if (r103 != r104) goto L26;
        if (Intrinsics.areEqual(r100.getPointKey(), "PointKey_CCM_FILE_DOWNLOAD") == false) goto L23;
    L24:
        return true;
    L23:
        if (Intrinsics.areEqual(r100.getPointKey(), "PointKey_CCM_FILE_PREVIEW") == true) goto L24;
    L26:
        if (r102.getFileBizDomain() != FileBizDomain.FileBizDomainCCM) goto L52;
        if (Intrinsics.areEqual(r100.getPointKey(), "PointKey_CCM_FILE_UPLOAD") == false) goto L52;
        if (r102.getScopedFileBizDomain() != FileBizDomain.FileBizDomainIM) goto L32;
    L33:
        return true;
    L32:
        if (r102.getScopedFileBizDomain() == r104) goto L33;
    L52:
        return this.f417760m.e(com.ss.android.lark.security.compliance.api.model.filepolicy.h.i(r100));
    L35:
        if ((r101 instanceof CalendarFileEntity) == false) goto L48;
        if (((CalendarFileEntity) r101).getFileBizDomain() == FileBizDomain.FileBizDomainCALENDAR) goto L39;
    L45:
        return false;
    L39:
        if (w4c.c.a().y() == false) goto L45;
        if (Intrinsics.areEqual(r100.getPointKey(), "PointKey_CCM_FILE_DOWNLOAD") == false) goto L43;
        return true;
    L43:
        if (Intrinsics.areEqual(r100.getPointKey(), "PointKey_CALENDAR_FILE_PREVIEW") == false) goto L45;
        return true;
    L48:
        if ((r101 instanceof VCFileEntity) == false) goto L52;
        return w4c.c.a().M();
    }

    @Override // com.ss.android.lark.conditional.access.auth.v2.handler.c
    public final void c(com.ss.android.lark.security.compliance.api.model.filepolicy.l r100) {
        Intrinsics.checkNotNullParameter(r100, "event");
        if ((r100 instanceof com.ss.android.lark.security.compliance.api.model.filepolicy.k) == false) goto L8;
        Iterator<T> r101 = this.f417770w.iterator();
    L6:
        if (r101.hasNext() == false) goto L10;
        ((i8b.a) r101.next()).b((com.ss.android.lark.security.compliance.api.model.filepolicy.k) r100);
    L10:
        if (w4c.c.a().V() == false) goto L12;
        this.f417765r.c(r100);
    L12:
        com.ss.android.lark.conditional.access.auth.v2.handler.a.f417806a.c(r100);
        if (w4c.c.a().N() == false) goto L16;
        this.f417766s.c(r100);
    L16:
        if (w4c.c.a().T() == false) goto L20;
        RefreshNotifyHandler.f417801a.c(r100);
        return;
    L20:
        return;
    L8:
        ScsLogger.d("SecurityPolicy_SecurityPolicyAuthManager", "handleEvent(), but event do not handle.");
        goto L10
    }

    @Override // i8b.q
    public final com.ss.android.lark.conditional.access.auth.v2.c d(PolicyModel r100) {
        Intrinsics.checkNotNullParameter(r100, "policyModel");
        return ((i8b.m) this.f417762o.getValue()).f(r100);
    }

    @Override // i8b.q
    public final boolean f(PolicyModel r100) {
        Intrinsics.checkNotNullParameter(r100, DoraObricDeviceHomeViewModel.PARAM_PRODUCT_MODEL);
        com.ss.android.lark.conditional.access.auth.v2.service.f r101 = this.f417761n;
        String r102 = com.ss.android.lark.security.compliance.api.model.filepolicy.h.i(r100);
        r101.getClass();
        Intrinsics.checkNotNullParameter(r102, DBDefinition.TASK_ID);
        com.ss.android.lark.conditional.access.auth.v2.service.i r103 = r101.f417902d.get(r102);
        if (r103 != null) goto L7;
        return false;
    L7:
        return r103.f417909a;
    }

    @Override // i8b.q
    public final boolean h(PolicyModel r100) {
        Intrinsics.checkNotNullParameter(r100, "policyModel");
        String r101 = com.ss.android.lark.security.compliance.api.model.filepolicy.h.i(r100);
        DeviceControlService r102 = this.f417759l;
        r102.getClass();
        Intrinsics.checkNotNullParameter(r101, DBDefinition.TASK_ID);
        if (idb.f.a().isEnable("lark.security.file_protection_policy_device") == false) goto L13;
        Integer r103 = r102.f417847c.getDeviceConfigInfo().get(r101);
        if (r103 == null) goto L8;
        Integer r104 = Integer.valueOf(r103.intValue() & 15);
    L9:
        if (r104 == null) goto L13;
        if (r104.intValue() == 0) goto L13;
        boolean r105 = true;
    L14:
        if (r105 == true) goto L23;
        com.ss.android.lark.conditional.access.auth.v2.service.f r106 = this.f417761n;
        r106.getClass();
        Intrinsics.checkNotNullParameter(r101, DBDefinition.TASK_ID);
        com.ss.android.lark.conditional.access.auth.v2.service.i r107 = r106.f417902d.get(r101);
        if (r107 == null) goto L18;
        boolean r108 = r107.f417909a;
    L19:
        if (r108 == true) goto L23;
        if (this.f417760m.e(r101) == true) goto L23;
        return true;
    L18:
        r108 = false;
    L23:
        return false;
    L8:
        r104 = null;
    L13:
        r105 = false;
        goto L14
    }

    public final void k(FileAuthMonitor.UpdateTrigger r100) {
        if (com.ss.android.lark.conditional.access.utils.f.a() == false) goto L6;
        int r101 = ScsLogger.f440428a;
        ScsLogger.d("SecurityPolicy_SecurityPolicyAuthManager", "start batchPolicyValidate,fileProtect FG is active, validateRequestFrom is " + r100.name());
        com.ss.android.lark.conditional.access.auth.v2.service.a r102 = this.f417758k;
        r102.getClass();
        Intrinsics.checkNotNullParameter(r100, "validateFrom");
        r102.f417867h.execute(new com.ss.android.lark.conditional.access.auth.v2.service.b(r102, r100));
        return;
    }

    @Override // i8b.q
    public final void g(List<PolicyModel> r100, FileAuthMonitor.UpdateTrigger r101) {
        Intrinsics.checkNotNullParameter(r100, "policyModelList");
        Intrinsics.checkNotNullParameter(r101, "requestFrom");
        if (ArraysKt.contains(FileAuthMonitor.f418450a, r101) == false) goto L5;
        return;
    L5:
        if ((!r100.isEmpty()) == true) goto L7;
        return;
    L7:
        if (com.ss.android.lark.conditional.access.auth.v2.b.f417782d.contains(((PolicyModel) ListProtector.get(r100, 0)).getPointKey()) == false) goto L12;
        ArrayList<String> r102 = com.ss.android.lark.conditional.access.utils.c.f418483a;
        com.ss.android.lark.conditional.access.utils.c.b("SecurityPolicy_SecurityPolicyAuthManager", "Remove retry task", true);
        this.f417757j.f();
        return;
    }

    @Override // i8b.q
    public final e j(PolicyModel r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "policyModel");
        return ((i8b.m) this.f417762o.getValue()).e(r100, r101);
    }

    @Override // i8b.q
    public final Object e(List<PolicyModel> r100, FileAuthMonitor.UpdateTrigger r101, Continuation<? super Map<String, com.bytedance.lark.policy.model.b0>> r102) {
        int r103 = ScsLogger.f440428a;
        ScsLogger.d("SecurityPolicy_SecurityPolicyAuthManager", "start validatePolicy, validateRequestFrom is " + r101.name());
        return this.f417763p.e(r100, new FileAuthMonitor.a(r101, null), r102);
    }
}
