package com.larus.platform.exp;

import com.bytedance.keva.Keva;
import com.larus.platform.api.IForwardCapabilityService;
import com.larus.platform.model.LarkSocialImModuleState;
import com.larus.platform.service.AccountService;
import com.larus.platform.service.z2;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import hq9.m2;
import hq9.n2;
import hq9.p2;
import hq9.s2;
import hq9.v2;
import hq9.x2;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Triple;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.flow.StateFlowImpl;
import kotlinx.coroutines.flow.j1;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes31.dex */
public final class LarkSocialExp {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final LarkSocialExp f365340a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Object f365341b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final CopyOnWriteArrayList<Function2<Boolean, Boolean, Unit>> f365342c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final CopyOnWriteArrayList<Function2<Boolean, Boolean, Unit>> f365343d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final StateFlowImpl f365344e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static volatile v2 f365345f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static volatile LarkSocialImModuleState f365346g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static volatile v2 f365347h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static volatile v2 f365348i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static volatile com.larus.platform.api.c f365349j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static volatile com.larus.platform.api.c f365350k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static volatile Function2<? super String, ? super JSONObject, Unit> f365351l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final Lazy f365352m = null;

    public static final class a implements com.larus.platform.api.b {
        public a() {
        }

        @Override // com.larus.platform.api.b
        public final void a(com.larus.platform.api.c r100) {
            Intrinsics.checkNotNullParameter(r100, "event");
            LarkSocialExp r101 = LarkSocialExp.f365340a;
            LarkSocialExp.f365349j = r100;
            LarkSocialExp.f365340a.n("onUserDidOnline");
        }

        @Override // com.larus.platform.api.b
        public final void b(com.larus.platform.api.c r100) {
            Intrinsics.checkNotNullParameter(r100, "event");
            LarkSocialExp r101 = LarkSocialExp.f365340a;
            r101.getClass();
            v2 r102 = LarkSocialExp.a();
            if (r102 != null) goto L5;
        L8:
            LarkSocialExp.f365350k = r100;
            LarkSocialExp.f365345f = null;
            LarkSocialExp.f365347h = null;
            r101.n("office_user_unavailable");
            r101.n("onUserDidOffline");
            return;
        L5:
            if (Intrinsics.areEqual(r102.f486794a, r100.f364876b) == true) goto L8;
            FLogger.f375446a.w("LarkSocialExp", "ignore stale account offline currentGeneration=" + r102.f486795b);
        }
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final boolean f365353a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f365354b;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof b) == true) goto L8;
            return false;
        L8:
            b r101 = (b) r100;
            if (this.f365353a == r101.f365353a) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f365354b, r101.f365354b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            if (this.f365353a == false) goto L5;
            int r100 = 1231;
        L6:
            int r101 = r100 * 31;
            String r102 = this.f365354b;
            if (r102 != null) goto L9;
            int r103 = 0;
        L11:
            return r101 + r103;
        L9:
            r103 = r102.hashCode();
            goto L11
        L5:
            r100 = 1237;
            goto L6
        }

        public final String toString() {
            return "EligibilityEvaluation(desiredEnabled=" + this.f365353a + ", cachedSnapshotUid=" + this.f365354b + ')';
        }

        public b(boolean r100, String r101) {
            this.f365353a = r100;
            this.f365354b = r101;
        }
    }

    public static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f365355a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f365356b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final boolean f365357c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final boolean f365358d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final String f365359e;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof c) == true) goto L8;
            return false;
        L8:
            c r101 = (c) r100;
            if (Intrinsics.areEqual(this.f365355a, r101.f365355a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f365356b, r101.f365356b) == true) goto L15;
            return false;
        L15:
            if (this.f365357c == r101.f365357c) goto L18;
            return false;
        L18:
            if (this.f365358d == r101.f365358d) goto L21;
            return false;
        L21:
            if (Intrinsics.areEqual(this.f365359e, r101.f365359e) == true) goto L23;
            return false;
        L23:
            return true;
        }

        public final int hashCode() {
            int r100 = ((this.f365355a.hashCode() * 31) + this.f365356b.hashCode()) * 31;
            int r101 = 1231;
            if (this.f365357c == false) goto L5;
            int r102 = 1231;
        L6:
            int r103 = (r100 + r102) * 31;
            if (this.f365358d == true) goto L10;
            r101 = 1237;
        L10:
            int r104 = (r103 + r101) * 31;
            String r105 = this.f365359e;
            if (r105 != null) goto L13;
            int r106 = 0;
        L15:
            return r104 + r106;
        L13:
            r106 = r105.hashCode();
            goto L15
        L5:
            r102 = 1237;
            goto L6
        }

        public final String toString() {
            return "ImInitializationContext(uid=" + this.f365355a + ", secUid=" + this.f365356b + ", isLogin=" + this.f365357c + ", isEnterpriseAccount=" + this.f365358d + ", tenantId=" + this.f365359e + ')';
        }

        public c(String r100, String r101, boolean r102, boolean r103, String r104) {
            Intrinsics.checkNotNullParameter(r100, "uid");
            Intrinsics.checkNotNullParameter(r101, "secUid");
            this.f365355a = r100;
            this.f365356b = r101;
            this.f365357c = r102;
            this.f365358d = r103;
            this.f365359e = r104;
        }
    }

    public LarkSocialExp() {
    }

    static {
        f365340a = new LarkSocialExp();
        f365341b = new Object();
        f365342c = new CopyOnWriteArrayList();
        f365343d = new CopyOnWriteArrayList();
        f365344e = j1.a(new m2(0));
        f365346g = LarkSocialImModuleState.NOT_LOADED;
        f365352m = LazyKt.lazy(new j());
        AccountService.f365697a.E(new a());
    }

    public static v2 a() {
        v2 r100 = z2.f365865a.c0();
        if (r100 != null) goto L5;
        return null;
    L5:
        AccountService r101 = AccountService.f365697a;
        if (r101.isLogin().booleanValue() == true) goto L8;
    L10:
        boolean r102 = false;
    L11:
        if (r102 == false) goto L14;
        return r100;
    L14:
        return null;
    L8:
        if (Intrinsics.areEqual(r100.f486794a, r101.getUserId()) == false) goto L10;
        r102 = true;
        goto L11
    }

    public static boolean b() {
        IForwardCapabilityService r100 = (IForwardCapabilityService) ServiceManager.get().getService(IForwardCapabilityService.class);
        if (r100 == null) goto L6;
        r100.d();
    L6:
        return e();
    }

    public static Keva d() {
        return (Keva) f365352m.getValue();
    }

    public static boolean e() {
        return ((m2) f365344e.getValue()).f486675d;
    }

    public static boolean f() {
        return ((m2) f365344e.getValue()).f486674c;
    }

    public final boolean c() {
        int r100 = p2.f486745a;
        s2 r101 = (s2) p2.a(f365341b, new LarkSocialExp$enableInitIM$decision$1(this), new m(), new n());
        FLogger.f375446a.d("LarkSocialExp", "enableInitIM enabled=" + r101.f486771c + " settings=" + r101.f486769a + " fg=" + r101.f486770b);
        return r101.f486771c;
    }

    public final int m() {
        if (c() == true) goto L5;
        return 0;
    L5:
        if (d().contains("key_lark_social_im_prewarm_boot_type_device") == false) goto L7;
        int r100 = d().getInt("key_lark_social_im_prewarm_boot_type_device", 0);
    L9:
        return r100;
    L7:
        r100 = z2.f365865a.q1().a();
        d().storeInt("key_lark_social_im_prewarm_boot_type_device", r100);
        FLogger.f375446a.i("LarkSocialExp", "migrate legacy IM boot type to device prewarm=" + r100);
        goto L9
    }

    public static boolean g(String r100) {
        Intrinsics.checkNotNullParameter(r100, "doubaoUid");
        if (StringsKt.isBlank(r100) == false) goto L6;
        FLogger.f375446a.w("LarkSocialExp", "isImFeatureOpenedByFg doubaoUid is blank");
        return false;
    L6:
        e.f365377a.getClass();
        boolean r101 = e.a(r100);
        FLogger.f375446a.d("LarkSocialExp", "isImFeatureOpenedByFg return " + r101);
        return r101;
    }

    public final void i(v2 r100) {
        v2 r101 = a();
        long r102 = -1;
        if (r100 != null) goto L5;
    L15:
        f365346g = LarkSocialImModuleState.FAILED;
        v2 r103 = null;
        f365347h = null;
        if (r100 != null) goto L18;
    L20:
        f365348i = r103;
        StringBuilder r104 = new StringBuilder("im_failed generation=");
        if (r100 == null) goto L23;
        r102 = r100.f486795b;
    L23:
        r104.append(r102);
        n(r104.toString());
        return;
    L18:
        if (Intrinsics.areEqual(r100, r101) == false) goto L20;
        r103 = r100;
        goto L20
    L5:
        if (Intrinsics.areEqual(r100, r101) == true) goto L15;
        if (f365346g != LarkSocialImModuleState.READY) goto L15;
        if (Intrinsics.areEqual(f365347h, r101) == false) goto L15;
        FLogger r105 = FLogger.f375446a;
        StringBuilder r106 = new StringBuilder("ignore stale IM failure generation=");
        r106.append(r100.f486795b);
        r106.append(" currentGeneration=");
        if (r101 == null) goto L13;
        r102 = r101.f486795b;
    L13:
        r106.append(r102);
        r105.w("LarkSocialExp", r106.toString());
    }

    public final void j(v2 r100) {
        f365346g = LarkSocialImModuleState.LOADING;
        f365347h = null;
        f365348i = null;
        StringBuilder r101 = new StringBuilder("im_loading generation=");
        if (r100 == null) goto L5;
        long r102 = r100.f486795b;
    L6:
        r101.append(r102);
        n(r101.toString());
        return;
    L5:
        r102 = -1;
        goto L6
    }

    public final void k(v2 r100) {
        f365346g = LarkSocialImModuleState.READY;
        f365340a.getClass();
        if (Intrinsics.areEqual(r100, a()) == false) goto L5;
        v2 r101 = r100;
    L6:
        f365347h = r101;
        f365348i = null;
        n("im_ready generation=" + r100.f486795b);
        return;
    L5:
        r101 = null;
        goto L6
    }

    public final void l(v2 r100) {
        if (r100 != null) goto L4;
    L8:
        FLogger r101 = FLogger.f375446a;
        StringBuilder r102 = new StringBuilder("ignore stale Office user ready generation=");
        long r103 = -1;
        if (r100 == null) goto L11;
        long r104 = r100.f486795b;
    L12:
        r102.append(r104);
        r102.append(" currentGeneration=");
        v2 r105 = a();
        if (r105 == null) goto L15;
        r103 = r105.f486795b;
    L15:
        r102.append(r103);
        r101.w("LarkSocialExp", r102.toString());
        return;
    L11:
        r104 = -1;
        goto L12
    L4:
        if (Intrinsics.areEqual(r100, a()) == false) goto L8;
        f365345f = r100;
        n("office_user_ready");
    }

    public final m2 n(String r110) {
        int r100 = p2.f486745a;
        Triple r101 = (Triple) p2.a(f365341b, new LarkSocialExp$recomputeState$transition$1(this), new k(), new l());
        m2 r102 = (m2) r101.component1();
        m2 r103 = (m2) r101.component2();
        x2 r104 = (x2) r101.component3();
        boolean r105 = true;
        if (r102.f486674c == false) goto L12;
        if (r104 == null) goto L12;
        if (d().getBoolean("key_lark_social_im_prewarm_device", false) == true) goto L9;
        d().storeBoolean("key_lark_social_im_prewarm_device", true);
    L9:
        int r106 = r104.f486806b.a();
        if (d().getInt("key_lark_social_im_prewarm_boot_type_device", 0) == r106) goto L12;
        d().storeInt("key_lark_social_im_prewarm_boot_type_device", r106);
    L12:
        if (r103 == null) goto L102;
        FLogger r107 = FLogger.f375446a;
        StringBuilder r108 = new StringBuilder("state changed reason=");
        r108.append(r110);
        r108.append(" desired=");
        r108.append(r103.f486674c);
        r108.append("->");
        r108.append(r102.f486674c);
        r108.append(" active=");
        r108.append(r103.f486675d);
        r108.append("->");
        r108.append(r102.f486675d);
        r108.append(" sessionGeneration=");
        v2 r109 = r102.f486673b;
        long r111 = -1;
        if (r109 == null) goto L16;
        long r112 = r109.f486795b;
    L17:
        r108.append(r112);
        r108.append(" officeGeneration=");
        v2 r113 = r102.f486676e;
        if (r113 == null) goto L20;
        long r114 = r113.f486795b;
    L21:
        r108.append(r114);
        r108.append(" im=");
        r108.append(r102.f486677f);
        r108.append(" imReadyGeneration=");
        v2 r115 = r102.f486678g;
        if (r115 == null) goto L24;
        long r116 = r115.f486795b;
    L25:
        r108.append(r116);
        r108.append(" imFailureGeneration=");
        v2 r117 = r102.f486679h;
        if (r117 == null) goto L28;
        long r118 = r117.f486795b;
    L29:
        r108.append(r118);
        r107.i("LarkSocialExp", r108.toString());
        boolean r119 = r103.f486674c;
        boolean r120 = r102.f486674c;
        if (r119 == r120) goto L99;
        h(f365342c, r119, r120, "desired");
        JSONObject r121 = new JSONObject();
        r121.put("enable_change", r103.f486674c + "->" + r102.f486674c);
        r121.put("active_enabled", r102.f486675d);
        v2 r122 = r102.f486673b;
        String r123 = null;
        if (r122 == null) goto L34;
        String r124 = r122.f486794a;
    L35:
        String r125 = "";
        if (r124 != null) goto L38;
        r124 = "";
    L38:
        r121.put("uid", r124);
        v2 r126 = r102.f486673b;
        if (r126 == null) goto L41;
        long r127 = r126.f486795b;
    L42:
        r121.put("generation", r127);
        r121.put("snapshot_state", r102.f486672a.name());
        if (r104 == null) goto L45;
        String r128 = r104.f486809e;
    L46:
        if (r128 != null) goto L48;
        r128 = "";
    L48:
        r121.put("settings_revision", r128);
        if (r104 == null) goto L51;
        r111 = r104.f486810f;
    L51:
        r121.put("settings_request_id", r111);
        if (r104 == null) goto L54;
        Boolean r129 = Boolean.valueOf(r104.f486808d);
    L55:
        r121.put("social_next_feature_gating", r129);
        if (r104 == null) goto L60;
        n2 r130 = r104.f486806b;
        if (r130 == null) goto L60;
        Boolean r131 = Boolean.valueOf(r130.b());
    L61:
        r121.put("lark_social_config_enable", r131);
        v2 r132 = r102.f486673b;
        if (r132 == null) goto L68;
        String r133 = r132.f486794a;
        if (r133 == null) goto L68;
        f365340a.getClass();
        if (d().getBoolean(o("key_lark_social_im_invited", r133), false) != true) goto L68;
        boolean r134 = true;
    L69:
        r121.put("has_passive_invite_cache", r134);
        v2 r135 = r102.f486673b;
        if (r135 == null) goto L76;
        String r136 = r135.f486794a;
        if (r136 == null) goto L76;
        f365340a.getClass();
        if (d().getBoolean(o("key_lark_social_contact_schema", r136), false) != true) goto L76;
    L77:
        r121.put("has_contact_schema_cache", r105);
        com.larus.platform.api.c r137 = f365349j;
        if (r137 == null) goto L80;
        String r138 = r137.f364876b;
    L81:
        if (r138 != null) goto L83;
        r138 = "";
    L83:
        r121.put("last_online_account", r138);
        com.larus.platform.api.c r139 = f365350k;
        if (r139 == null) goto L86;
        r123 = r139.f364876b;
    L86:
        if (r123 == null) goto L89;
        r125 = r123;
    L89:
        r121.put("last_offline_account", r125);
        Function2<? super String, ? super JSONObject, Unit> r140 = f365351l;
        if (r140 != null) goto L103;
        r107.w("LarkSocialExp", "monitorEnableStateChanged skipped, monitorReporter is null");
        goto L99
    L103:
        Result.Companion r141 = Result.Companion;     // Catch: Throwable -> L94
        r140.invoke("dev_lark_im_switch_change_event", r121);     // Catch: Throwable -> L94
        Object r142 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L94
    L96:
        Throwable r143 = Result.m9452exceptionOrNullimpl(r142);
        if (r143 == null) goto L99;
        FLogger.f375446a.e("LarkSocialExp", "monitorEnableStateChanged report failed", r143);
    L94:
        th = move-exception;
        Result.Companion r144 = Result.Companion;
        r142 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L96
    L80:
        r138 = null;
    L76:
        r105 = false;
    L68:
        r134 = false;
    L60:
        r131 = null;
        goto L61
    L54:
        r129 = null;
        goto L55
    L45:
        r128 = null;
        goto L46
    L41:
        r127 = -1;
        goto L42
    L34:
        r124 = null;
    L99:
        boolean r145 = r103.f486675d;
        boolean r146 = r102.f486675d;
        if (r145 == r146) goto L102;
        h(f365343d, r145, r146, "active");
        goto L102
    L28:
        r118 = -1;
        goto L29
    L24:
        r116 = -1;
        goto L25
    L20:
        r114 = -1;
        goto L21
    L16:
        r112 = -1;
    L102:
        return r102;
    }

    public static String o(String r100, String r101) {
        return r100 + '_' + r101;
    }

    public static void h(List r100, boolean r101, boolean r102, String r103) {
        Iterator r104 = r100.iterator();
    L4:
        if (r104.hasNext() == false) goto L13;
        Function2 r105 = (Function2) r104.next();
        Result.Companion r106 = Result.Companion;     // Catch: Throwable -> L8
        r105.invoke(Boolean.valueOf(r101), Boolean.valueOf(r102));     // Catch: Throwable -> L8
        Object r107 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L8
    L10:
        Throwable r108 = Result.m9452exceptionOrNullimpl(r107);
        if (r108 == null) goto L4;
        FLogger.f375446a.e("LarkSocialExp", "notify " + r103 + " state failed", r108);
    L8:
        th = move-exception;
        Result.Companion r109 = Result.Companion;
        r107 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L10
    }
}
