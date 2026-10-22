package fx0;

import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class n implements wy0.f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final n f479084a = null;

    public static final class a implements com.bytedance.ies.web.jsbridge2.f.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f479085a = null;

        static {
            f479085a = new a();
        }

        public a() {
        }

        @Override // com.bytedance.ies.web.jsbridge2.f.b
        public final com.bytedance.ies.web.jsbridge2.f<Object, Object> a() {
            return new fx0.b();
        }
    }

    public static final class b implements com.bytedance.ies.web.jsbridge2.f.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b f479086a = null;

        static {
            f479086a = new b();
        }

        public b() {
        }

        @Override // com.bytedance.ies.web.jsbridge2.f.b
        public final com.bytedance.ies.web.jsbridge2.f<Object, Object> a() {
            return new p();
        }
    }

    public static final class c implements com.bytedance.ies.web.jsbridge2.f.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final c f479087a = null;

        static {
            f479087a = new c();
        }

        public c() {
        }

        @Override // com.bytedance.ies.web.jsbridge2.f.b
        public final com.bytedance.ies.web.jsbridge2.f<Object, Object> a() {
            return new fx0.f();
        }
    }

    public static final class d implements com.bytedance.ies.web.jsbridge2.f.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final d f479088a = null;

        static {
            f479088a = new d();
        }

        public d() {
        }

        @Override // com.bytedance.ies.web.jsbridge2.f.b
        public final com.bytedance.ies.web.jsbridge2.f<Object, Object> a() {
            return new l();
        }
    }

    public static final class e implements com.bytedance.ies.web.jsbridge2.f.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final e f479089a = null;

        static {
            f479089a = new e();
        }

        public e() {
        }

        @Override // com.bytedance.ies.web.jsbridge2.f.b
        public final com.bytedance.ies.web.jsbridge2.f<Object, Object> a() {
            return new j();
        }
    }

    public static final class f implements com.bytedance.ies.web.jsbridge2.f.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final f f479090a = null;

        static {
            f479090a = new f();
        }

        public f() {
        }

        @Override // com.bytedance.ies.web.jsbridge2.f.b
        public final com.bytedance.ies.web.jsbridge2.f<Object, Object> a() {
            return new fx0.a();
        }
    }

    public static final class g implements com.bytedance.ies.web.jsbridge2.f.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final g f479091a = null;

        static {
            f479091a = new g();
        }

        public g() {
        }

        @Override // com.bytedance.ies.web.jsbridge2.f.b
        public final com.bytedance.ies.web.jsbridge2.f<Object, Object> a() {
            return new ta0.b();
        }
    }

    public n() {
    }

    static {
        f479084a = new n();
    }

    @Override // wy0.f
    public final Map<String, com.bytedance.ies.web.jsbridge2.f.b> a(y6.c r100) {
        Intrinsics.checkNotNullParameter(r100, "manager");
        return MapsKt.mapOf(new Pair[]{TuplesKt.to("showIncomeExchangeDialog", a.f479085a), TuplesKt.to("updateWalletInfo", b.f479086a), TuplesKt.to("openCJCounter", c.f479087a), TuplesKt.to("openRechargeWhenSwitchScreen", d.f479088a), TuplesKt.to("openLiveRecharge", e.f479089a), TuplesKt.to("dismissRechargeDialog", f.f479090a), TuplesKt.to("revenue.notifyIncomeExchangeResult", g.f479091a)});
    }

    @Override // wy0.d
    public final Map<String, wy0.h<Object, ?>> c(y6.c r100) {
        Intrinsics.checkNotNullParameter(r100, "manager");
        return wy0.f.a.a(r100);
    }

    @Override // wy0.f
    public final Map<String, com.bytedance.ies.web.jsbridge2.g<?, ?>> d(y6.c r100) {
        Intrinsics.checkNotNullParameter(r100, "manager");
        Intrinsics.checkNotNullParameter(r100, "manager");
        return MapsKt.emptyMap();
    }

    @Override // wy0.d
    public final Map<String, com.bytedance.ies.web.jsbridge2.g<Object, ?>> f(y6.c r100) {
        Intrinsics.checkNotNullParameter(r100, "manager");
        return wy0.f.a.b(r100);
    }
}
