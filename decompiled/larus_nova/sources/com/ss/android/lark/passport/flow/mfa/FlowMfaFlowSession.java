package com.ss.android.lark.passport.flow.mfa;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Base64;
import com.alibaba.fastjson.JSONObject;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.sdk.account.platform.api.ITiktokService;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.openplatform.common.constant.AppbrandHostConstants;
import com.ss.android.lark.passport.PassportApmEvent;
import com.ss.android.lark.passport.base.core.log.PassportLog;
import com.ss.android.lark.passport.flow.core.router.FlowStep;
import com.ss.android.lark.passport.flow.core.router.PassportRouterResult;
import com.ss.android.lark.passport.flow.idp_auth.FlowIdpLoginResult;
import com.ss.android.lark.utils.Contexts;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.security.MessageDigest;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CompletableDeferred;
import kotlinx.coroutines.CompletableDeferredKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.SupervisorKt;

/* JADX INFO: loaded from: classes37.dex */
public final class FlowMfaFlowSession {

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static final List<String> f437828x = null;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public static final List<String> f437829y = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f437830a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f437831b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f437832c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final FlowMfaRepository f437833d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final CompletableDeferred<q> f437834e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final AtomicReference<FlowStep> f437835f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final AtomicBoolean f437836g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final CoroutineScope f437837h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final AtomicReference<Function1<j, Unit>> f437838i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final AtomicReference<String> f437839j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final AtomicReference<String> f437840k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final AtomicReference<WeakReference<Activity>> f437841l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final AtomicReference<WeakReference<Activity>> f437842m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final AtomicReference<WeakReference<Activity>> f437843n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final AtomicReference<WeakReference<Activity>> f437844o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final AtomicBoolean f437845p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final AtomicBoolean f437846q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final AtomicReference<z> f437847r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final AtomicReference<Long> f437848s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final AtomicReference<a0> f437849t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final AtomicReference<syb.b> f437850u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final AtomicReference<com.ss.android.lark.passport.flow.mfa.a> f437851v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final d f437852w;

    public static final class a {
    }

    public /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f437853a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ int[] f437854b = null;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final /* synthetic */ int[] f437855c = null;

        static {
            int[] r100 = new int[ExternalBidpCallbackPhase.values().length];
            r100[ExternalBidpCallbackPhase.IDLE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L24
        L45:
            r100[ExternalBidpCallbackPhase.WAITING_CALLBACK.ordinal()] = 2;     // Catch: NoSuchFieldError -> L25
        L61:
            r100[ExternalBidpCallbackPhase.RESUMED_WAITING_CALLBACK.ordinal()] = 3;     // Catch: NoSuchFieldError -> L26
        L47:
            r100[ExternalBidpCallbackPhase.DISPATCHING.ordinal()] = 4;     // Catch: NoSuchFieldError -> L27
        L49:
            r100[ExternalBidpCallbackPhase.TIMED_OUT.ordinal()] = 5;     // Catch: NoSuchFieldError -> L28
        L12:
            f437853a = r100;
            int[] r101 = new int[FlowVerifyFactor.values().length];
            r101[FlowVerifyFactor.PHONE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L29
        L39:
            r101[FlowVerifyFactor.EMAIL.ordinal()] = 2;     // Catch: NoSuchFieldError -> L30
        L53:
            r101[FlowVerifyFactor.BIDP.ordinal()] = 3;     // Catch: NoSuchFieldError -> L31
        L37:
            r101[FlowVerifyFactor.SPARE.ordinal()] = 4;     // Catch: NoSuchFieldError -> L32
        L51:
            r101[FlowVerifyFactor.OTP.ordinal()] = 5;     // Catch: NoSuchFieldError -> L33
        L41:
            r101[FlowVerifyFactor.PASSWORD.ordinal()] = 6;     // Catch: NoSuchFieldError -> L34
        L19:
            f437854b = r101;
            int[] r102 = new int[FlowMfaBidpWebActivityType.values().length];
            r102[FlowMfaBidpWebActivityType.INTERNAL_AUTH.ordinal()] = 1;     // Catch: NoSuchFieldError -> L35
        L57:
            r102[FlowMfaBidpWebActivityType.EXTERNAL_BROWSER_LOADING.ordinal()] = 2;     // Catch: NoSuchFieldError -> L36
        L22:
            f437855c = r102;
        }
    }

    public static final class c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ FlowMfaFlowSession f437856a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Activity f437857b;

        public c(FlowMfaFlowSession r100, Activity r101) {
            this.f437856a = r100;
            this.f437857b = r101;
        }

        @Override // java.lang.Runnable
        public final void run() {
            FlowMfaFlowSession r100 = this.f437856a;     // Catch: Throwable -> L6
            Activity r101 = this.f437857b;     // Catch: Throwable -> L6
            r100.getClass();     // Catch: Throwable -> L6
            if (FlowMfaFlowSession.p(r101) == false) goto L9;
            this.f437857b.finish();     // Catch: Throwable -> L6
            return;
        L9:
            return;
        L6:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L13;
            throw th;
        }
    }

    public static final class d implements syb.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ FlowMfaFlowSession f437858a;

        public d(FlowMfaFlowSession r100) {
            this.f437858a = r100;
        }

        @Override // syb.b
        public final boolean a(Context r100, String r101, JSONObject r102) {
            Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
            Intrinsics.checkNotNullParameter(r101, "nextStep");
            FlowMfaFlowSession r103 = this.f437858a;
            if (r103.q() == true) goto L28;
            boolean r104 = r100 instanceof Activity;
            if (r104 == false) goto L8;
            Activity r105 = (Activity) r100;
        L9:
            if (r105 != null) goto L30;
            if (r104 == false) goto L12;
            Activity r106 = Contexts.requireActivity(r100);
        L24:
            r105 = r106;
        L27:
            if (r105 != null) goto L30;
        L12:
            if (r100 == null) goto L20;
            if (TextUtils.equals("com.android.internal.policy.DecorContext", r100.getClass().getName()) == false) goto L20;
            Field r107 = r100.getClass().getDeclaredField("mActivityContext");     // Catch: Exception -> L17
            r107.setAccessible(true);     // Catch: Exception -> L17
            r105 = (Activity) ((WeakReference) r107.get(r100)).get();     // Catch: Exception -> L17
        L17:
            e = move-exception;
            e.printStackTrace();
        L20:
            if ((r100 instanceof ContextWrapper) == false) goto L26;
            if ((r100 instanceof Activity) == true) goto L23;
            r100 = ((ContextWrapper) r100).getBaseContext();
            goto L20
        L23:
            r106 = Contexts.requireActivity(r100);
            goto L24
        L26:
            r105 = null;
        L30:
            if (r102 != null) goto L33;
            r102 = new JSONObject();
        L33:
            return r103.A(r105, new FlowStep(r101, r102, null)).a();
        L8:
            r105 = null;
        L28:
            return false;
        }
    }

    static {
        f437828x = CollectionsKt.listOf(new String[]{"uri", "auth_url", "url", "web_url", ITiktokService.ResponseConstants.REDIRECT_URL});
        f437829y = CollectionsKt.listOf(new String[]{"tenant_domain", "tenantDomain"});
    }

    public final void e() {
    L2:
        com.ss.android.lark.passport.flow.mfa.a r100 = this.f437851v.get();
        if (r100.f437883a != ExternalBidpCallbackPhase.DISPATCHING) goto L4;
        com.ss.android.lark.passport.flow.mfa.a r101 = com.ss.android.lark.passport.flow.mfa.a.a(r100, ExternalBidpCallbackPhase.IDLE);
        AtomicReference<com.ss.android.lark.passport.flow.mfa.a> r102 = this.f437851v;
    L7:
        if (r102.compareAndSet(r100, r101) == true) goto L8;
        if (r102.get() == r100) goto L7;
        boolean r103 = false;
    L12:
        if (r103 == false) goto L2;
        PassportLog.d("FlowMfaSession", "consume external BIDP dispatch result: attempt=" + r100.f437884b);
        return;
    L8:
        r103 = true;
        goto L12
    }

    public final z f() {
        z r100 = this.f437847r.get();
        if (r100 != null) goto L13;
        FlowStep r101 = g();
        if (r101 == null) goto L9;
        JSONObject r102 = r101.getStepInfo();
        if (r102 == null) goto L9;
        z r103 = D(r102);
    L10:
        if (r103 == null) goto L12;
        return r103;
    L12:
        return new z("bidp", null);
    L9:
        r103 = null;
        goto L10
    L13:
        return r100;
    }

    public final FlowStep g() {
        return this.f437835f.get();
    }

    public final void l() {
        Activity r100 = null;
        WeakReference<Activity> r101 = this.f437841l.getAndSet(null);
        if (r101 == null) goto L5;
        r100 = r101.get();
    L5:
        j(r100);
    }

    public final boolean q() {
        if (this.f437836g.get() == false) goto L5;
    L8:
        return true;
    L5:
        if (this.f437834e.isCompleted() == true) goto L8;
        return false;
    }

    public static FlowMfaError C(Throwable r100) {
        if ((r100 instanceof FlowMfaException) == false) goto L5;
        FlowMfaException r101 = (FlowMfaException) r100;
    L6:
        if (r101 == null) goto L10;
        FlowMfaError r102 = r101.getError();
        if (r102 == null) goto L10;
        return r102;
    L10:
        return g.a(r100);
    L5:
        r101 = null;
        goto L6
    }

    public static z D(JSONObject r100) {
        Set<String> r101 = wyb.a.f561896b;
        String r102 = wyb.a.C8175a.a(r100).f561897a;
        Boolean r103 = null;
        if (r102 != null) goto L5;
    L9:
        r102 = "bidp";
    L10:
        Boolean r104 = r100.getBoolean("has_tenant_domain");
        if (r104 == null) goto L13;
        Boolean r105 = Boolean.valueOf(r104.booleanValue());
    L27:
        return new z(r102, r105);
    L13:
        Boolean r106 = r100.getBoolean("hasTenantDomain");
        if (r106 == null) goto L16;
        r105 = Boolean.valueOf(r106.booleanValue());
        goto L27
    L16:
        Iterator<T> r107 = f437829y.iterator();
    L18:
        if (r107.hasNext() == false) goto L25;
        String r108 = r100.getString((String) r107.next());
        if (r108 == null) goto L22;
        Boolean r109 = Boolean.valueOf(!StringsKt.isBlank(r108));
    L23:
        if (r109 == null) goto L18;
        r103 = r109;
        goto L25
    L22:
        r109 = null;
    L25:
        r105 = r103;
        goto L27
    L5:
        if ((!StringsKt.isBlank(r102)) == true) goto L8;
        r102 = null;
    L8:
        if (r102 != null) goto L10;
        goto L9
    }

    public static boolean p(Activity r100) {
        if (r100.isFinishing() == false) goto L5;
    L7:
        return false;
    L5:
        if (r100.isDestroyed() == true) goto L7;
        return true;
    }

    public final a0 E(y r100) {
        String r101 = r100.f437927a.getWireKey();
        String r102 = r100.f437930d;
        FlowStep r103 = g();
        if (r103 == null) goto L5;
        String r104 = r103.getNextStep();
    L7:
        return new a0(r101, r102, r104, "user_action", this.f437832c);
    L5:
        r104 = null;
        goto L7
    }

    public final AtomicReference<WeakReference<Activity>> c(FlowMfaBidpWebActivityType r100) {
        int r101 = b.f437855c[r100.ordinal()];
        if (r101 == 1) goto L10;
        if (r101 != 2) goto L8;
        return this.f437843n;
    L8:
        throw new NoWhenBranchMatchedException();
    L10:
        return this.f437842m;
    }

    public final void h(FlowMfaError r100) {
        Intrinsics.checkNotNullParameter(r100, "error");
        if (this.f437836g.compareAndSet(false, true) == false) goto L6;
        m(FlowMfaBidpWebActivityType.INTERNAL_AUTH);
        w(r100);
        t(null, false);
        this.f437834e.completeExceptionally(new FlowMfaException(r100));
        return;
    }

    public final void i(FlowMfaError r100) {
        Intrinsics.checkNotNullParameter(r100, "error");
        h(r100);
        r(new j.c(r100, true));
    }

    public final void j(Activity r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        if (p(r100) == true) goto L7;
        r100 = null;
    L7:
        if (r100 != null) goto L10;
        return;
    L10:
        if (Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper()) == false) goto L13;
        r100.finish();
        return;
    L13:
        new Handler(Looper.getMainLooper()).post(new c(this, r100));
    }

    public final AtomicBoolean k(FlowMfaBidpWebActivityType r100) {
        int r101 = b.f437855c[r100.ordinal()];
        if (r101 == 1) goto L10;
        if (r101 != 2) goto L8;
        return this.f437846q;
    L8:
        throw new NoWhenBranchMatchedException();
    L10:
        return this.f437845p;
    }

    public final void m(FlowMfaBidpWebActivityType r100) {
        Intrinsics.checkNotNullParameter(r100, "type");
        boolean r101 = true;
        k(r100).set(true);
        String r102 = null;
        WeakReference<Activity> r103 = c(r100).getAndSet(null);
        if (r103 == null) goto L5;
        Activity r104 = r103.get();
    L6:
        StringBuilder r105 = new StringBuilder("finish pending BIDP web activity: type=");
        r105.append(r100);
        r105.append(", hasActivity=");
        if (r104 != null) goto L10;
        r101 = false;
    L10:
        r105.append(r101);
        r105.append(", activity=");
        if (r104 == null) goto L13;
        r102 = r104.getClass().getSimpleName();
    L13:
        r105.append(r102);
        PassportLog.d("FlowMfaSession", r105.toString());
        j(r104);
        return;
    L5:
        r104 = null;
        goto L6
    }

    public final j o(final FlowStep r100) {
        final long r101 = System.currentTimeMillis();
        PassportApmEvent r102 = PassportApmEvent.f437675a;
        r102.q(new FlowMfaFlowSession$handleStep$2(r100));
        if (q() == false) goto L7;
        r102.q(new FlowMfaFlowSession$handleStep$3(r101, r100));
        return j.b.f437899a;
    L7:
        if (StringsKt.isBlank(r100.getNextStep()) == false) goto L10;
        r102.q(new FlowMfaFlowSession$handleStep$4(r101, r100));
        int r103 = g.f437896a;
        FlowMfaError r104 = g.e(r100.getNextStep());
        h(r104);
        return new j.c(r104, true);
    L10:
        y(r100);
        r102.q(new FlowMfaFlowSession$handleStep$5(r101, r100));
        return new j.d(r100);
    }

    public final void r(j r100) {
        Function1<j, Unit> r101 = this.f437838i.get();
        if (r101 == null) goto L6;
        r101.invoke(r100);
        return;
    }

    public final void s(FlowStep r110) {
        Intrinsics.checkNotNullParameter(r110, "step");
        JSONObject r100 = r110.getStepInfo();
        Iterator<T> r101 = f437828x.iterator();
    L3:
        String r102 = null;
        if (r101.hasNext() == false) goto L13;
        String r103 = r100.getString((String) r101.next());
        if (r103 != null) goto L8;
    L10:
        r103 = null;
    L11:
        if (r103 == null) goto L3;
    L14:
        if (r103 != null) goto L16;
    L19:
        boolean r104 = true;
    L21:
        if (r104 == true) goto L67;
        JSONObject r111 = r110.getStepInfo();
        Set<String> r105 = wyb.a.f561896b;
        boolean r106 = wyb.a.C8175a.a(r111).a();
        Result.Companion r107 = Result.Companion;     // Catch: Throwable -> L25
        Object r108 = Result.m9449constructorimpl(UriProtector.parse(r103));     // Catch: Throwable -> L25
    L27:
        Throwable r109 = Result.m9452exceptionOrNullimpl(r108);
        if (r109 != null) goto L65;
        Uri r112 = (Uri) r108;
        Intrinsics.checkNotNull(r112);
        String r113 = i.a(r112, ITiktokService.ResponseConstants.REDIRECT_URL);
        if (r113 != null) goto L32;
    L37:
        Uri r114 = null;
    L38:
        String r115 = i.a(r112, "state");
        if (r115 != null) goto L41;
    L47:
        if (r114 == null) goto L53;
        String r116 = i.a(r114, "state");
        if (r116 == null) goto L53;
        if ((!StringsKt.isBlank(r116)) == false) goto L53;
    L54:
        if (r116 != null) goto L60;
        String r117 = r111.getString("state");
        if (r117 != null) goto L58;
    L61:
        if (r102 == null) goto L63;
        this.f437839j.set(r102);
        PassportLog.d("FlowMfaSession", "prepare BIDP callback success: scheme=" + r112.getScheme() + ", host=" + r112.getHost() + ", path=" + r112.getPath() + ", state saved");
        return;
    L63:
        if (r106 == false) goto L79;
        PassportLog.b("FlowMfaSession", "prepare BIDP callback failed: state is blank");
        return;
    L79:
        return;
    L58:
        if ((true ^ StringsKt.isBlank(r117)) == false) goto L61;
        r102 = r117;
        goto L61
    L60:
        r102 = r116;
    L53:
        r116 = null;
        goto L54
    L41:
        if ((!StringsKt.isBlank(r115)) == true) goto L44;
        r115 = null;
    L44:
        if (r115 == null) goto L47;
        r102 = r115;
        goto L61
    L32:
        if ((!StringsKt.isBlank(r113)) == true) goto L35;
        r113 = null;
    L35:
        if (r113 == null) goto L37;
        r114 = UriProtector.parse(r113);
        goto L38
    L65:
        if (r106 == false) goto L81;
        PassportLog.c("FlowMfaSession", "parse BIDP callback url failed", r109);
        return;
    L81:
        return;
    L25:
        th = move-exception;
        Result.Companion r118 = Result.Companion;
        r108 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L27
    L67:
        Set<String> r119 = wyb.a.f561896b;
        if (wyb.a.C8175a.a(r110.getStepInfo()).a() == false) goto L83;
        PassportLog.b("FlowMfaSession", "prepare BIDP callback failed: auth url is blank");
        return;
    L83:
        return;
    L16:
        if (StringsKt.isBlank(r103) == true) goto L19;
        r104 = false;
        goto L21
    L8:
        if ((!StringsKt.isBlank(r103)) == false) goto L10;
    L13:
        r103 = null;
        goto L14
    }

    public final void u(JSONObject r100) {
        Intrinsics.checkNotNullParameter(r100, "stepInfo");
        final z r101 = D(r100);
        this.f437847r.set(r101);
        this.f437848s.set(Long.valueOf(System.currentTimeMillis()));
        PassportApmEvent.f437675a.q(new FlowMfaFlowSession$reportBidpVerifyStart$1(r101));
    }

    public final void w(final FlowMfaError r100) {
        PassportApmEvent.f437675a.q(new FlowMfaFlowSession$reportRuntimeAnomaly$1(this, r100));
    }

    public final void y(FlowStep r100) {
        Intrinsics.checkNotNullParameter(r100, "step");
        this.f437835f.set(r100);
    }

    public final PassportRouterResult A(Activity r100, final FlowStep r101) {
        Intrinsics.checkNotNullParameter(r100, "activity");
        Intrinsics.checkNotNullParameter(r101, "step");
        final long r102 = System.currentTimeMillis();
        PassportApmEvent.f437675a.q(new FlowMfaFlowSession$startStep$1(r101));
        com.ss.android.lark.passport.flow.core.router.a<m> r103 = l.f437904a;
        Intrinsics.checkNotNullParameter(r100, "activity");
        Intrinsics.checkNotNullParameter(this, AppbrandHostConstants.SCHEMA_INSPECT.SESSION);
        Intrinsics.checkNotNullParameter(r101, "step");
        com.ss.android.lark.passport.flow.core.router.a<m> r104 = l.f437904a;
        String r105 = r101.getNextStep();
        m r106 = new m(r100, this, r101);
        r104.getClass();
        if (r105 != null) goto L5;
    L8:
        boolean r107 = true;
    L10:
        if (r107 == false) goto L13;
        final PassportRouterResult r108 = new PassportRouterResult(PassportRouterResult.Status.INVALID_NEXT_STEP, r105, null);
    L26:
        PassportApmEvent.f437675a.q(new FlowMfaFlowSession$startStep$2$1(r108, r102, r101));
        if (r108.a() == true) goto L29;
        int r109 = g.f437896a;
        w(g.e(r108.f437786b));
    L29:
        return r108;
    L13:
        if (r104.f437792b.contains(r105) == false) goto L15;
        r108 = new PassportRouterResult(PassportRouterResult.Status.TERMINAL, r105, null);
        goto L26
    L15:
        Iterator<T> r110 = r104.f437791a.iterator();
    L17:
        if (r110.hasNext() == false) goto L21;
        Object r111 = r110.next();
        if (((syb.a) r111).b(r105, r106) == false) goto L17;
    L22:
        syb.a r112 = (syb.a) r111;
        if (r112 == null) goto L25;
        r112.a(r105, r106);
        r108 = new PassportRouterResult(PassportRouterResult.Status.DISPATCHED, r105, r112.getName());
        goto L26
    L25:
        r108 = new PassportRouterResult(PassportRouterResult.Status.UNSUPPORTED, r105, null);
        goto L26
    L21:
        r111 = null;
        goto L22
    L5:
        if (r105.length() == 0) goto L8;
        r107 = false;
        goto L10
    }

    public final Object b(y r100, Continuation<? super j> r110) {
        if ((r110 instanceof FlowMfaFlowSession$applyCode$1) == false) goto L7;
        FlowMfaFlowSession$applyCode$1 r101 = (FlowMfaFlowSession$applyCode$1) r110;
        int r102 = r101.label;
        if ((r102 & Integer.MIN_VALUE) == 0) goto L7;
        r101.label = r102 - Integer.MIN_VALUE;
    L8:
        Object r111 = r101.result;
        Object r103 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r104 = r101.label;
        final boolean r105 = true;
        if (r104 == 0) goto L18;
        if (r104 != 1) goto L17;
        final long r106 = r101.J$0;
        final a0 r107 = (a0) r101.L$0;
        ResultKt.throwOnFailure(r111);     // Catch: Throwable -> L14
    L27:
        Object r112 = Result.m9449constructorimpl((com.ss.android.lark.passport.flow.mfa.b) r111);     // Catch: Throwable -> L14
    L33:
        Throwable r108 = Result.m9452exceptionOrNullimpl(r112);
        if (r108 != null) goto L36;
        PassportApmEvent.f437675a.q(new FlowMfaFlowSession$reportChallengeResult$1(r107, r105, r106));
        return new j.a((com.ss.android.lark.passport.flow.mfa.b) r112);
    L36:
        PassportLog.e("FlowMfaSession", "apply MFA code failed: ".concat(r108.getClass().getSimpleName()));
        FlowMfaError r113 = C(r108);
        final boolean r109 = false;
        PassportApmEvent.f437675a.q(new FlowMfaFlowSession$reportChallengeResult$1(r107, r109, r106));
        w(r113);
        return new j.c(r113, false);
    L14:
        Throwable th10 = th;
        long r114 = r106;
    L32:
        Result.Companion r115 = Result.Companion;
        r112 = Result.m9449constructorimpl(ResultKt.createFailure(th10));
        r106 = r114;
        goto L33
    L17:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L18:
        ResultKt.throwOnFailure(r111);
        if (q() == true) goto L21;
        final a0 r116 = E(r100);
        r114 = System.currentTimeMillis();
        PassportApmEvent.f437675a.q(new FlowMfaFlowSession$reportChallengeStart$1(r116));
        Result.Companion r117 = Result.Companion;     // Catch: Throwable -> L30
        FlowMfaRepository r118 = this.f437833d;     // Catch: Throwable -> L30
        String r119 = this.f437831b;     // Catch: Throwable -> L30
        r101.L$0 = r116;     // Catch: Throwable -> L30
        r101.J$0 = r114;     // Catch: Throwable -> L30
        r101.label = 1;     // Catch: Throwable -> L30
        Object r120 = r118.a(r119, r100, r101);     // Catch: Throwable -> L30
        if (r120 != r103) goto L26;
        return r103;
    L26:
        r106 = r114;
        r111 = r120;
        r107 = r116;
    L30:
        th = move-exception;
        th10 = th;
        r107 = r116;
        goto L32
    L21:
        return j.b.f437899a;
    L7:
        r101 = new FlowMfaFlowSession$applyCode$1(this, r110);
        goto L8
    }

    public final void d(Activity r100, FlowMfaBidpWebActivityType r101) {
        Intrinsics.checkNotNullParameter(r101, "type");
        if (r100 != null) goto L5;
    L18:
        PassportLog.b("FlowMfaSession", "bind BIDP web activity failed: type=" + r101 + ", activity unavailable");
        return;
    L5:
        if (p(r100) == false) goto L18;
        AtomicBoolean r102 = k(r101);
        AtomicReference<WeakReference<Activity>> r103 = c(r101);
        if (r102.get() == false) goto L11;
        PassportLog.d("FlowMfaSession", "bind BIDP web activity after close requested: type=" + r101 + ", activity=" + r100.getClass().getSimpleName());
        j(r100);
        return;
    L11:
        r103.set(new WeakReference(r100));
        PassportLog.d("FlowMfaSession", "bind BIDP web activity success: type=" + r101 + ", activity=" + r100.getClass().getSimpleName());
        if (r102.get() == false) goto L20;
        PassportLog.d("FlowMfaSession", "close BIDP web activity after concurrent bind: type=" + r101);
        Activity r104 = null;
        WeakReference<Activity> r105 = r103.getAndSet(null);
        if (r105 == null) goto L16;
        r104 = r105.get();
    L16:
        j(r104);
        return;
    }

    public final void t(JSONObject r100, final boolean r101) {
        if (r100 == null) goto L4;
        final z r102 = D(r100);
    L5:
        final Long r103 = this.f437848s.getAndSet(null);
        if (r103 != null) goto L8;
        return;
    L8:
        PassportApmEvent.f437675a.q(new FlowMfaFlowSession$reportBidpVerifyResult$1(r102, r101, r103));
        return;
    L4:
        r102 = f();
        goto L5
    }

    public final void v(int r100, String r101) {
        Intrinsics.checkNotNullParameter("verify_list", "stepOrigin");
        FlowVerifyFactor.Companion.getClass();
        FlowVerifyFactor r102 = FlowVerifyFactor.a.a(r100);
        if (r102 != null) goto L5;
        return;
    L5:
        String r103 = r102.getWireKey();
        FlowStep r104 = g();
        if (r104 == null) goto L8;
        String r105 = r104.getNextStep();
    L9:
        final a0 r106 = new a0(r103, r101, r105, "verify_list", this.f437832c);
        a0 r107 = this.f437849t.getAndSet(r106);
        if (r107 != null) goto L12;
    L14:
        PassportApmEvent.f437675a.q(new FlowMfaFlowSession$reportFactorEnter$1(r106));
        return;
    L12:
        if (Intrinsics.areEqual(r107.f437885a, r106.f437885a) == true) goto L14;
        PassportApmEvent.f437675a.q(new FlowMfaFlowSession$reportFactorCancel$1(r107));
        goto L14
    L8:
        r105 = null;
        goto L9
    }

    public final void z(FlowStep r100, Activity r101) {
        Intrinsics.checkNotNullParameter(r100, "step");
        if (q() == false) goto L5;
        return;
    L5:
        y(r100);
        if (r101 != null) goto L8;
    L13:
        this.f437841l.set(null);
    L14:
        BuildersKt.launch$default(this.f437837h, null, null, new FlowMfaFlowSession$startBidpAuthUrlStep$1(this, r100, null), 3, null);
        return;
    L8:
        if ((r101 instanceof FlowMfaTransparentActivity) == true) goto L13;
        if (p(r101) == false) goto L13;
        this.f437841l.set(new WeakReference(r101));
        goto L14
    }

    public final Object B(y r110, String r111, Continuation<? super j> r112) {
        if ((r112 instanceof FlowMfaFlowSession$submitFactor$1) == false) goto L7;
        FlowMfaFlowSession$submitFactor$1 r100 = (FlowMfaFlowSession$submitFactor$1) r112;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        Object r113 = r100.result;
        Object r102 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r103 = r100.label;
        if (r103 == 0) goto L22;
        if (r103 == 1) goto L21;
        if (r103 == 2) goto L16;
        if (r103 != 3) goto L15;
        long r114 = r100.J$0;
        a0 r104 = (a0) r100.L$0;
        ResultKt.throwOnFailure(r113);
    L69:
        j r115 = (j) r113;
        boolean r105 = r115 instanceof j.c;
        x(r104, !r105, r114);
        if (r105 == false) goto L77;
        w(((j.c) r115).f437900a);
        return r115;
    L77:
        return r115;
    L15:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L16:
        r114 = r100.J$0;
        a0 r106 = (a0) r100.L$0;
        ResultKt.throwOnFailure(r113);     // Catch: Throwable -> L19
    L55:
        Object r116 = Result.m9449constructorimpl((FlowStep) r113);     // Catch: Throwable -> L19
    L63:
        Throwable r107 = Result.m9452exceptionOrNullimpl(r116);
        if (r107 != null) goto L72;
        r100.L$0 = r106;
        r100.J$0 = r114;
        r100.label = 3;
        r113 = o((FlowStep) r116);
        if (r113 != r102) goto L68;
        return r102;
    L68:
        r104 = r106;
        goto L69
    L72:
        PassportLog.e("FlowMfaSession", "submit MFA factor failed: ".concat(r107.getClass().getSimpleName()));
        FlowMfaError r117 = C(r107);
        x(r106, false, r114);
        w(r117);
        return new j.c(r117, false);
    L19:
        Throwable th10 = th;
        long r108 = r114;
    L62:
        Result.Companion r118 = Result.Companion;
        r116 = Result.m9449constructorimpl(ResultKt.createFailure(th10));
        r114 = r108;
        goto L63
    L21:
        long r119 = r100.J$0;
        a0 r109 = (a0) r100.L$0;
        ResultKt.throwOnFailure(r113);
    L40:
        j r120 = (j) r113;
        boolean r121 = r120 instanceof j.c;
        x(r109, !r121, r119);
        if (r121 == false) goto L43;
        w(((j.c) r120).f437900a);
    L43:
        return r113;
    L22:
        ResultKt.throwOnFailure(r113);
        if (q() == true) goto L25;
        final a0 r122 = E(r110);
        r108 = System.currentTimeMillis();
        this.f437849t.set(r122);
        PassportApmEvent.f437675a.q(new FlowMfaFlowSession$reportVerifyStart$1(r122));
        FlowVerifyFactor r123 = r110.f437927a;
        FlowVerifyFactor r124 = FlowVerifyFactor.BIDP;
        if (r123 != r124) goto L74;
        r100.L$0 = r122;
        r100.J$0 = r108;
        r100.label = 1;
        if (r123 == r124) goto L31;
        int r125 = g.f437896a;
        FlowMfaError r126 = g.e(r123.getWireKey());
        h(r126);
        j r127 = new j.c(r126, true);
    L37:
        if (r127 != r102) goto L39;
        return r102;
    L39:
        r109 = r122;
        r113 = r127;
        r119 = r108;
        goto L40
    L31:
        FlowStep r128 = r110.f437936j;
        if (r128 != null) goto L34;
    L36:
        r127 = o(new FlowStep("get_auth_url", r110.f437938l, null));
        goto L37
    L34:
        if (r128.getStepInfo().isEmpty() == true) goto L36;
        r127 = o(r128);
        goto L37
    L74:
        Result.Companion r129 = Result.Companion;     // Catch: Throwable -> L60
        switch(b.f437854b[r123.ordinal()]) {
            case 1: goto L51;
            case 2: goto L51;
            case 3: goto L50;
            case 4: goto L47;
            case 5: goto L47;
            case 6: goto L47;
            default: goto L59;
        };     // Catch: Throwable -> L60
    L47:
        int r130 = g.f437896a;     // Catch: Throwable -> L60
        throw new FlowMfaException(g.e(r110.f437927a.getWireKey()));     // Catch: Throwable -> L60
    L51:
        FlowMfaRepository r131 = this.f437833d;     // Catch: Throwable -> L60
        String r132 = this.f437831b;     // Catch: Throwable -> L60
        r100.L$0 = r122;     // Catch: Throwable -> L60
        r100.J$0 = r108;     // Catch: Throwable -> L60
        r100.label = 2;     // Catch: Throwable -> L60
        Object r133 = r131.k(r132, r111, r110, r100);     // Catch: Throwable -> L60
        if (r133 != r102) goto L54;
        return r102;
    L54:
        r106 = r122;
        r113 = r133;
        r114 = r108;
        goto L55
    L59:
        throw new NoWhenBranchMatchedException();     // Catch: Throwable -> L60
    L50:
        throw new IllegalStateException("BIDP is handled before submit".toString());     // Catch: Throwable -> L60
    L60:
        th = move-exception;
        r106 = r122;
        th10 = th;
        goto L62
    L25:
        return j.b.f437899a;
    L7:
        r100 = new FlowMfaFlowSession$submitFactor$1(this, r112);
        goto L8
    }

    public final void x(final a0 r100, final boolean r101, final long r102) {
        PassportApmEvent.f437675a.q(new FlowMfaFlowSession$reportVerifyResult$1(r100, r101, r102));
        if (r101 == false) goto L10;
        AtomicReference<a0> r103 = this.f437849t;
    L6:
        if (r103.compareAndSet(r100, null) == true) goto L14;
        if (r103.get() == r100) goto L6;
        return;
    L14:
        return;
    }

    public FlowMfaFlowSession(String r100, String r101, String r102, FlowMfaRepository r103) {
        Intrinsics.checkNotNullParameter(r100, "flowId");
        Intrinsics.checkNotNullParameter(r101, "userId");
        Intrinsics.checkNotNullParameter(r102, "scope");
        Intrinsics.checkNotNullParameter(r103, "repository");
        this.f437830a = r100;
        this.f437831b = r101;
        this.f437832c = r102;
        this.f437833d = r103;
        this.f437834e = CompletableDeferredKt.CompletableDeferred$default(null, 1, null);
        this.f437835f = new AtomicReference();
        this.f437836g = new AtomicBoolean(false);
        this.f437837h = CoroutineScopeKt.CoroutineScope(SupervisorKt.SupervisorJob$default(null, 1, null).plus(Dispatchers.getIO()));
        this.f437838i = new AtomicReference();
        this.f437839j = new AtomicReference();
        this.f437840k = new AtomicReference();
        this.f437841l = new AtomicReference();
        this.f437842m = new AtomicReference();
        this.f437843n = new AtomicReference();
        this.f437844o = new AtomicReference();
        this.f437845p = new AtomicBoolean(false);
        this.f437846q = new AtomicBoolean(false);
        this.f437847r = new AtomicReference();
        this.f437848s = new AtomicReference();
        this.f437849t = new AtomicReference();
        this.f437850u = new AtomicReference();
        this.f437851v = new AtomicReference(new com.ss.android.lark.passport.flow.mfa.a(ExternalBidpCallbackPhase.IDLE, 0));
        this.f437852w = new d(this);
    }

    public static final Object a(FlowMfaFlowSession r100, JSONObject r110, boolean r111, Continuation r112) {
        r100.getClass();
        if ((r112 instanceof FlowMfaFlowSession$fetchBidpAuthUrl$1) == false) goto L7;
        FlowMfaFlowSession$fetchBidpAuthUrl$1 r101 = (FlowMfaFlowSession$fetchBidpAuthUrl$1) r112;
        int r102 = r101.label;
        if ((r102 & Integer.MIN_VALUE) == 0) goto L7;
        r101.label = r102 - Integer.MIN_VALUE;
    L8:
        Object r113 = r101.result;
        Object r103 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r104 = r101.label;
        if (r104 == 0) goto L20;
        if (r104 == 1) goto L15;
        if (r104 != 2) goto L14;
        final long r114 = r101.J$0;
        final z r105 = (z) r101.L$0;
        ResultKt.throwOnFailure(r113);
    L37:
        j r106 = (j) r113;
        boolean r115 = r106 instanceof j.c;
        final boolean r107 = !r115;
        PassportApmEvent.f437675a.q(new FlowMfaFlowSession$reportBidpPrepareResult$1(r105, r107, r114));
        if (r115 == false) goto L50;
        r100.w(((j.c) r106).f437900a);
        return r106;
    L50:
        return r106;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        r114 = r101.J$0;
        boolean r108 = r101.Z$0;
        final z r109 = (z) r101.L$0;
        ResultKt.throwOnFailure(r113);     // Catch: Throwable -> L18
    L25:
        Object r116 = Result.m9449constructorimpl((FlowStep) r113);     // Catch: Throwable -> L18
    L31:
        Throwable r117 = Result.m9452exceptionOrNullimpl(r116);
        if (r117 != null) goto L40;
        r101.L$0 = r109;
        r101.J$0 = r114;
        r101.label = 2;
        r113 = r100.o((FlowStep) r116);
        if (r113 == r103) goto L53;
        r105 = r109;
        goto L37
    L53:
        return r103;
    L40:
        PassportLog.e("FlowMfaSession", "fetch BIDP auth url failed: ".concat(r117.getClass().getSimpleName()));
        r100.f437840k.set(null);
        FlowMfaError r118 = C(r117);
        final boolean r119 = false;
        PassportApmEvent.f437675a.q(new FlowMfaFlowSession$reportBidpPrepareResult$1(r109, r119, r114));
        if (r108 == false) goto L43;
        r100.h(r118);
        r100.l();
    L45:
        return new j.c(r118, r108);
    L43:
        r100.w(r118);
    L18:
        Throwable th10 = th;
        long r120 = r114;
        r111 = r108;
    L30:
        Result.Companion r121 = Result.Companion;
        r116 = Result.m9449constructorimpl(ResultKt.createFailure(th10));
        r108 = r111;
        r114 = r120;
        goto L31
    L20:
        ResultKt.throwOnFailure(r113);
        byte[] r122 = new byte[32];
        k.f437903a.nextBytes(r122);
        String r123 = Base64.encodeToString(r122, 11);
        MessageDigest r124 = MessageDigest.getInstance("SHA-256");
        Intrinsics.checkNotNull(r123);
        String r125 = Base64.encodeToString(r124.digest(r123.getBytes(Charsets.US_ASCII)), 11);
        Intrinsics.checkNotNull(r125);
        Intrinsics.checkNotNullParameter(r123, "verifier");
        Intrinsics.checkNotNullParameter(r125, "challenge");
        r100.f437840k.set(r123);
        final z r126 = D(r110);
        r100.f437847r.set(r126);
        r120 = System.currentTimeMillis();
        PassportApmEvent.f437675a.q(new FlowMfaFlowSession$reportBidpPrepareStart$1(r126));
        Result.Companion r127 = Result.Companion;     // Catch: Throwable -> L28
        FlowMfaRepository r128 = r100.f437833d;     // Catch: Throwable -> L28
        String r129 = r100.f437831b;     // Catch: Throwable -> L28
        r101.L$0 = r126;     // Catch: Throwable -> L28
        r101.Z$0 = r111;     // Catch: Throwable -> L28
        r101.J$0 = r120;     // Catch: Throwable -> L28
        r101.label = 1;     // Catch: Throwable -> L28
        Object r130 = r128.g(r129, r110, r125, r101);     // Catch: Throwable -> L28
        if (r130 == r103) goto L52;
        r108 = r111;
        r109 = r126;
        r113 = r130;
        r114 = r120;
        goto L25
    L52:
        return r103;
    L28:
        th = move-exception;
        r109 = r126;
        th10 = th;
    L7:
        r101 = new FlowMfaFlowSession$fetchBidpAuthUrl$1(r100, r112);
        goto L8
    }

    public final boolean n(FlowIdpLoginResult r210, Activity r211, FlowMfaBidpWebActivityType r212, String r213) {
        PassportLog.d("FlowMfaSession", "handle BIDP login result start: source=" + r213 + ", code=" + r210.getCode());
        boolean r100 = false;
        if (q() == false) goto L6;
        PassportLog.b("FlowMfaSession", "handle BIDP login result failed: source=" + r213 + ", session is terminal");
        return false;
    L6:
        if (r211 == null) goto L9;
        d(r211, r212);
    L9:
        if (r210.getCode() == 0) goto L19;
        FlowMfaErrorCategory r110 = FlowMfaErrorCategory.SERVER;
        String r101 = r210.getMessage();
        if (r101 != null) goto L13;
    L17:
        r101 = "BIDP login result failed";
    L18:
        FlowMfaError r102 = new FlowMfaError(r110, r101, null, null, Integer.valueOf(r210.getCode()), r210.getLogId(), 12, null);
    L40:
        if (r102 == null) goto L43;
        PassportLog.b("FlowMfaSession", "validate BIDP login result failed: source=" + r213 + ", category=" + r102.getCategory() + ", serverCode=" + r102.getServerCode());
        t(null, false);
        h(r102);
        m(r212);
        r(new j.c(r102, true));
        return true;
    L43:
        t(null, true);
        String r103 = r210.getState();
        if (r103 != null) goto L46;
        r103 = "";
    L46:
        String r104 = r103;
        String r105 = this.f437840k.getAndSet(null);
        String r106 = this.f437839j.get();
        if (r106 != null) goto L49;
    L52:
        boolean r107 = true;
    L53:
        this.f437839j.set(null);
        StringBuilder r108 = new StringBuilder("validate BIDP login result success: source=");
        r108.append(r213);
        r108.append(", hasExpectedState=");
        r108.append(!r107);
        r108.append(", hasCodeVerifier=");
        if (r105 == null) goto L56;
        r100 = true;
    L56:
        r108.append(r100);
        PassportLog.d("FlowMfaSession", r108.toString());
        BuildersKt.launch$default(this.f437837h, null, null, new FlowMfaFlowSession$handleBidpLoginResultInternal$1(this, r213, r104, r105, null), 3, null);
        PassportLog.d("FlowMfaSession", "BIDP login result accepted for dispatch: source=".concat(r213));
        return true;
    L49:
        if (StringsKt.isBlank(r106) == true) goto L52;
        r107 = false;
        goto L53
    L13:
        if ((!StringsKt.isBlank(r101)) == true) goto L16;
        r101 = null;
    L16:
        if (r101 != null) goto L18;
    L19:
        String r109 = r210.getState();
        if (r109 != null) goto L22;
    L25:
        boolean r111 = true;
    L26:
        if (r111 == false) goto L28;
        r102 = g.b("BIDP login result state is empty", null);
        goto L40
    L28:
        String r112 = this.f437839j.get();
        if (r112 != null) goto L31;
    L34:
        boolean r113 = true;
    L35:
        if (r113 == false) goto L37;
    L39:
        r102 = null;
        goto L40
    L37:
        if (Intrinsics.areEqual(r112, r109) == true) goto L39;
        r102 = g.b("BIDP login result state mismatch", null);
        goto L40
    L31:
        if (StringsKt.isBlank(r112) == true) goto L34;
        r113 = false;
        goto L35
    L22:
        if (StringsKt.isBlank(r109) == true) goto L25;
        r111 = false;
        goto L26
    }
}
