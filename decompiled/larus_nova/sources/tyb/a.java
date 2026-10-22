package tyb;

import android.app.Activity;
import android.app.Application;
import android.content.ComponentCallbacks2;
import android.content.res.Configuration;
import android.graphics.Color;
import android.os.SystemClock;
import com.bytedance.bdturing.BdTuringConfig;
import com.larksuite.component.universe_design.color.UDColorUtils;
import com.larksuite.framework.callback.UICallbackExecutor;
import com.larus.nova.R;
import com.ss.android.lark.appcontext.applifecycle.AppLifecycle;
import com.ss.android.lark.dynamicconfig.interfaces.IDomainConfigService;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.passport.base.core.log.PassportLog;
import com.ss.android.lark.passport.signinsdk_api.entity.EnvConst$UNIT;
import com.ss.android.lark.statistics.Statistics;
import com.ss.android.lark.utils.ApiUtils;
import com.ss.android.lark.utils.LarkContext;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import jc4.g;
import jc4.m;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.SequencesKt;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes37.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f548019a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static volatile boolean f548020b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Object f548021c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final AtomicBoolean f548022d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static b f548023e;

    /* JADX INFO: renamed from: tyb.a$a, reason: collision with other inner class name */
    public static final class C7805a implements com.bytedance.bdturing.setting.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final com.bytedance.bdturing.setting.b f548024a;

        public C7805a(com.bytedance.bdturing.setting.b r100) {
            this.f548024a = r100;
        }

        @Override // com.bytedance.bdturing.setting.b
        public final JSONObject a(String r110, JSONObject r111) {
            Intrinsics.checkNotNullParameter(r110, "service");
            Intrinsics.checkNotNullParameter(r111, "jsonObj");
            com.bytedance.bdturing.setting.b r100 = this.f548024a;
            if (r100 == null) goto L8;
            JSONObject r101 = r100.a(r110, r111);
            if (r101 == null) goto L8;
            r111 = r101;
        L8:
            a.f548019a.getClass();
            if (Intrinsics.areEqual("verify", r110) == false) goto L67;
            JSONObject r112 = r111.optJSONObject("host");
            if (r112 != null) goto L14;
            PassportLog.b("n_action_bdturing", "UpdateServiceUrl, opt host failed");
            goto L67
        L14:
            gpb.a r102 = (gpb.a) ApiUtils.getApi(gpb.a.class);
            int r103 = 0;
            String r104 = null;
            if (com.ss.android.lark.passport.a.a() == true) goto L70;
            Integer r105 = null;
        L32:
            if (r105 == null) goto L34;
            int r106 = r105.intValue();
        L36:
            if (r106 != 2) goto L38;
            String r107 = EnvConst$UNIT.BOE_CN;
        L39:
            List<String> r108 = jcb.b.c().p0(IDomainConfigService.DomainAlias.PASSPORT_TURING_VERIFY, r106, r107, "feishu");
            if (r108 == null) goto L42;
            r104 = (String) CollectionsKt.firstOrNull(r108);
        L42:
            if (r104 != null) goto L44;
            r104 = "";
        L44:
            String r109 = StringsKt.trimEnd(StringsKt.trim(r104).toString(), new char[]{'/'});
            if (StringsKt.startsWith(r109, "http://", true) == false) goto L47;
        L50:
            Log.i("n_action_bdturing", "turing page host:" + r109);
            if (StringsKt.isBlank(r109) == false) goto L53;
            PassportLog.b("n_action_bdturing", "UpdateServiceUrl, turing's host is blank");
            goto L67
        L53:
            LinkedHashSet r113 = new LinkedHashSet();
            BdTuringConfig.RegionType[] r114 = BdTuringConfig.RegionType.values();
            ArrayList r115 = new ArrayList(r114.length);
            int r116 = r114.length;
        L54:
            if (r103 >= r116) goto L56;
            r115.add(r114[r103].getName());
            r103 = r103 + 1;
            goto L54
        L56:
            r113.addAll(r115);
            CollectionsKt.addAll(r113, SequencesKt.asSequence(r112.keys()));
            PassportLog.d("n_action_bdturing", "UpdateServiceUrl, turing's host is " + r109);
            Iterator r117 = r113.iterator();
        L58:
            if (r117.hasNext() == false) goto L67;
            String r118 = (String) r117.next();
            Result.Companion r119 = Result.Companion;     // Catch: Throwable -> L62
            r112.put(r118, r109);     // Catch: Throwable -> L62
            PassportLog.d("n_action_bdturing", "UpdateServiceUrl, update " + r118 + "'s host");     // Catch: Throwable -> L62
            Object r120 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L62
        L64:
            Throwable r121 = Result.m9452exceptionOrNullimpl(r120);
            if (r121 == null) goto L58;
            PassportLog.c("n_action_bdturing", "UpdateServiceUrl, put region " + r118 + " failed", r121);
        L62:
            th = move-exception;
            Result.Companion r122 = Result.Companion;
            r120 = Result.m9449constructorimpl(ResultKt.createFailure(th));
            goto L64
        L47:
            if (StringsKt.startsWith(r109, "https://", true) == true) goto L50;
            r109 = "https://" + r109;
            goto L50
        L38:
            r107 = "eu_nc";
            goto L39
        L34:
            r106 = r102.envType();
            goto L36
        L70:
            Result.Companion r123 = Result.Companion;     // Catch: Throwable -> L26
            Integer r124 = Integer.valueOf(LarkContext.getApplication().getSharedPreferences("office_sdk_env_prefs", 0).getInt("custom_env_value", -1));     // Catch: Throwable -> L26
            if (r124.intValue() == (-1)) goto L20;
            boolean r125 = true;
        L21:
            if (r125 == true) goto L24;
            r124 = null;
        L24:
            Object r126 = Result.m9449constructorimpl(r124);     // Catch: Throwable -> L26
        L29:
            if (Result.m9455isFailureimpl(r126) == false) goto L31;
            r126 = null;
        L31:
            r105 = (Integer) r126;
            goto L32
        L20:
            r125 = false;
        L26:
            th = move-exception;
            Result.Companion r127 = Result.Companion;
            r126 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        L67:
            return r111;
        }
    }

    public static abstract class b {

        /* JADX INFO: renamed from: tyb.a$b$a, reason: collision with other inner class name */
        public static final class C7806a extends b {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final int f548025a;

            public final boolean equals(Object r100) {
                if (this != r100) goto L6;
                return true;
            L6:
                if ((r100 instanceof C7806a) == true) goto L9;
                return false;
            L9:
                if (this.f548025a == ((C7806a) r100).f548025a) goto L11;
                return false;
            L11:
                return true;
            }

            public final int hashCode() {
                return this.f548025a;
            }

            public final String toString() {
                return "Challenge(challengeId=" + this.f548025a + ')';
            }

            public C7806a(int r100) {
                this.f548025a = r100;
            }
        }

        /* JADX INFO: renamed from: tyb.a$b$b, reason: collision with other inner class name */
        public static final class C7807b extends b {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final String f548026a;

            public final boolean equals(Object r100) {
                if (this != r100) goto L6;
                return true;
            L6:
                if ((r100 instanceof C7807b) == true) goto L9;
                return false;
            L9:
                if (Intrinsics.areEqual(this.f548026a, ((C7807b) r100).f548026a) == true) goto L11;
                return false;
            L11:
                return true;
            }

            public final int hashCode() {
                return this.f548026a.hashCode();
            }

            public final String toString() {
                return "Decision(riskInfo=" + this.f548026a + ')';
            }

            public C7807b(String r100) {
                Intrinsics.checkNotNullParameter(r100, "riskInfo");
                this.f548026a = r100;
            }
        }

        public b() {
        }
    }

    public static final class c implements ComponentCallbacks2 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a f548027a;

        @Override // android.content.ComponentCallbacks
        public final void onLowMemory() {
        }

        @Override // android.content.ComponentCallbacks2
        public final void onTrimMemory(int r100) {
        }

        public c(a r100) {
            this.f548027a = r100;
        }

        @Override // android.content.ComponentCallbacks
        public final void onConfigurationChanged(Configuration r100) {
            Intrinsics.checkNotNullParameter(r100, "newConfig");
            this.f548027a.getClass();
            a.e();
        }
    }

    public a() {
    }

    static {
        f548019a = new a();
        f548021c = new Object();
        f548022d = new AtomicBoolean(false);
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public static void e() {
        BdTuringConfig r100 = qb4.b.c.f532315a.f532302a;
        if (r100 != null) goto L5;
        return;
    L5:
        JSONObject r101 = new JSONObject();
        JSONObject r102 = new JSONObject();
        f548019a.getClass();
        String r103 = d(R.color.primary_fill_solid_03);
        if (r103 == null) goto L8;
        r102.put("slidingSlotBgColor", r103);
    L8:
        String r104 = d(R.color.primary_fill_default);
        if (r104 == null) goto L11;
        r102.put("feedbackBtnBgColor", r104);
    L11:
        r102.put("feedbackBtnBgOpacity", "0.34");
        String r105 = d(R.color.primary_fill_default);
        if (r105 == null) goto L14;
        r102.put("feedbackOnSelectedIconColor", r105);
    L14:
        Unit r106 = Unit.INSTANCE;
        r101.put("theme", r102);
        r100.setTheme(r101, 2);
    }

    public static boolean f() {
        if (f548020b == false) goto L5;
        return true;
    L5:
        qb4.b r100 = qb4.b.c.f532315a;
        Intrinsics.checkNotNull(r100);
        monitor-enter(r100);
        BdTuringConfig r101 = r100.f532302a;     // Catch: Throwable -> L44
        if (r101 == null) goto L12;
        if (r100.f532303b == false) goto L12;
    L13:
        monitor-exit(r100);
        if (r101 != null) goto L17;
        return false;
    L17:
        Object r102 = f548021c;
        monitor-enter(r102);
    L41:
        th = move-exception;
        throw th;
    L20:
        if (f548020b == false) goto L23;
        monitor-exit(r102);
        return true;
    L23:
        a r103 = f548019a;     // Catch: Throwable -> L41
        Result.Companion r104 = Result.Companion;     // Catch: Throwable -> L30
        r103.getClass();     // Catch: Throwable -> L30
        com.bytedance.bdturing.setting.b r105 = r101.getServiceInterceptor();     // Catch: Throwable -> L30
        if ((r105 instanceof C7805a) == true) goto L28;
        r101.setServiceInterceptor(new C7805a(r105));     // Catch: Throwable -> L30
    L28:
        r103.c();     // Catch: Throwable -> L30
        Object r106 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L30
    L33:
        if (Result.m9456isSuccessimpl(r106) == false) goto L35;
        Unit r107 = (Unit) r106;     // Catch: Throwable -> L41
        f548020b = true;     // Catch: Throwable -> L41
        PassportLog.d("n_action_bdturing", "bound to host BDTuring instance");     // Catch: Throwable -> L41
    L35:
        Throwable r108 = Result.m9452exceptionOrNullimpl(r106);     // Catch: Throwable -> L41
        if (r108 == null) goto L38;
        PassportLog.c("n_action_bdturing", "bind to host BDTuring instance failed", r108);     // Catch: Throwable -> L41
    L38:
        boolean r109 = f548020b;     // Catch: Throwable -> L41
        monitor-exit(r102);
        return r109;
    L30:
        th = move-exception;
        Result.Companion r110 = Result.Companion;     // Catch: Throwable -> L41
        r106 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L41
    L12:
        r101 = null;
    L44:
        th = move-exception;
        throw th;
    }

    public final void c() {
        Application r100 = LarkContext.getApplication();
        if (f548022d.compareAndSet(false, true) == true) goto L15;
    L13:
        e();
        return;
    L15:
        Result.Companion r101 = Result.Companion;     // Catch: Throwable -> L6
        r100.registerComponentCallbacks(new c(this));     // Catch: Throwable -> L6
        Object r102 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L6
    L8:
        Throwable r103 = Result.m9452exceptionOrNullimpl(r102);
        if (r103 == null) goto L13;
        f548022d.set(false);
        throw r103;
    L6:
        th = move-exception;
        Result.Companion r104 = Result.Companion;
        r102 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L8
    }

    public static String d(int r100) {
        Application r101 = LarkContext.getApplication();
        Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L5
        Object r103 = Result.m9449constructorimpl(Integer.valueOf(UDColorUtils.getColor(r101, r100)));     // Catch: Throwable -> L5
    L8:
        if (Result.m9455isFailureimpl(r103) == false) goto L10;
        r103 = null;
    L10:
        Integer r104 = (Integer) r103;
        if (r104 == null) goto L14;
        int r105 = r104.intValue();
        return "#" + String.format("%02x", Arrays.copyOf(new Object[]{Integer.valueOf(Color.red(r105))}, 1)) + String.format("%02x", Arrays.copyOf(new Object[]{Integer.valueOf(Color.green(r105))}, 1)) + String.format("%02x", Arrays.copyOf(new Object[]{Integer.valueOf(Color.blue(r105))}, 1));
    L14:
        return null;
    L5:
        th = move-exception;
        Result.Companion r106 = Result.Companion;
        r103 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L8
    }

    public static final void a(a r100, String r101) {
        r100.getClass();
        JSONObject r102 = new JSONObject();     // Catch: Throwable -> L5
        r102.put("result_value", r101);     // Catch: Throwable -> L5
        Statistics.sendEvent("turing_verify_result", r102);     // Catch: Throwable -> L5
        return;
    L5:
        th = move-exception;
        PassportLog.b("n_action_bdturing", "turingVerifyResult " + th.getMessage());
    }

    public static final void b(a r100, b r101, long r110) {
        if (f548023e == r101) goto L5;
        r100.getClass();
        return;
    L5:
        r100.getClass();
        String r102 = null;
        if (f() == false) goto L78;
        f548023e = null;
        Result.Companion r103 = Result.Companion;     // Catch: Throwable -> L17
        if ((r101 instanceof b.C7807b) == false) goto L12;
        Object r104 = new m(((b.C7807b) r101).f548026a);     // Catch: Throwable -> L17
    L14:
        Object r105 = Result.m9449constructorimpl(r104);     // Catch: Throwable -> L17
    L20:
        if (Result.m9456isSuccessimpl(r105) == false) goto L75;
        jc4.a r106 = (jc4.a) r105;
        a r111 = f548019a;
        r111.getClass();
        Activity r112 = AppLifecycle.a.f408803a.f();
        if (r112 == null) goto L74;
        Statistics.sendEvent("passport_turing_show");
        qb4.b r107 = qb4.b.c.f532315a;
        BdTuringConfig r108 = r107.f532302a;
        if (r108 == null) goto L83;
        epb.a r109 = (epb.a) ApiUtils.getApi(epb.a.class);
        if (r109 == null) goto L29;
        String r113 = r109.getInstallId();
    L30:
        String r114 = "";
        if (r113 != null) goto L33;
        r113 = "";
    L33:
        if (r109 == null) goto L35;
        r102 = r109.getDeviceId();
    L35:
        if (r102 == null) goto L38;
        r114 = r102;
    L38:
        String r115 = r108.getDeviceId();
        boolean r116 = true;
        if (r115 != null) goto L41;
    L44:
        boolean r117 = true;
    L45:
        if (r117 == true) goto L47;
    L52:
        String r118 = r108.getInstallId();
        if (r118 != null) goto L55;
    L58:
        boolean r119 = true;
    L59:
        if (r119 == true) goto L61;
    L66:
        yob.e.a().getClass();
        int r120 = com.ss.android.lark.language.service.impl.a.f431092f;
        r108.setLanguage(com.ss.android.lark.language.service.impl.a.b.f431098a.getLanguageSetting().getLanguage());
        goto L83
    L61:
        if (r113.length() > 0) goto L64;
        r116 = false;
    L64:
        if (r116 == false) goto L66;
        r108.setInstallId(r113);
        goto L66
    L55:
        if (r118.length() == 0) goto L58;
        r119 = false;
        goto L59
    L47:
        if (r114.length() <= 0) goto L49;
        boolean r121 = true;
    L50:
        if (r121 == false) goto L52;
        r108.setDeviceId(r114);
        goto L52
    L49:
        r121 = false;
        goto L50
    L41:
        if (r115.length() == 0) goto L44;
        r117 = false;
        goto L45
    L29:
        r113 = null;
    L83:
        r107.i(r112, r106, new d(r111, r112, r107));     // Catch: Throwable -> L69
        Object r122 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L69
    L71:
        Throwable r123 = Result.m9452exceptionOrNullimpl(r122);
        if (r123 == null) goto L75;
        PassportLog.c("n_action_bdturing", "show turing dialog failed", r123);
    L69:
        th = move-exception;
        Result.Companion r124 = Result.Companion;
        r122 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L71
    L74:
        PassportLog.b("n_action_bdturing", "async get last top activity is null");
    L75:
        Throwable r125 = Result.m9452exceptionOrNullimpl(r105);
        if (r125 == null) goto L87;
        PassportLog.c("n_action_bdturing", "create turing request failed", r125);
        return;
    L87:
        return;
    L12:
        if ((r101 instanceof b.C7806a) == false) goto L16;
        r104 = new g(((b.C7806a) r101).f548025a);     // Catch: Throwable -> L17
        goto L14
    L16:
        throw new NoWhenBranchMatchedException();     // Catch: Throwable -> L17
    L17:
        th = move-exception;
        Result.Companion r126 = Result.Companion;
        r105 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L20
    L78:
        long r127 = SystemClock.elapsedRealtime() - r110;
        if (r127 < 5000) goto L81;
        f548023e = null;
        PassportLog.b("n_action_bdturing", "wait for host BDTuring initialization timeout, request: " + r101.getClass().getSimpleName() + ", elapsedTime: " + r127);
        return;
    L81:
        UICallbackExecutor.executeDelayed(new e(r101, r110), 100);
    }
}
