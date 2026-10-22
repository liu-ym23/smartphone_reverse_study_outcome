package hw0;

import java.util.Map;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class c implements wy0.f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final c f487400a = null;

    public static final class a implements com.bytedance.ies.web.jsbridge2.f.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f487401a = null;

        static {
            f487401a = new a();
        }

        public a() {
        }

        @Override // com.bytedance.ies.web.jsbridge2.f.b
        public final com.bytedance.ies.web.jsbridge2.f<Object, Object> a() {
            return new f();
        }
    }

    public c() {
    }

    static {
        f487400a = new c();
    }

    @Override // wy0.f
    public final Map<String, com.bytedance.ies.web.jsbridge2.f.b> a(y6.c r100) {
        Intrinsics.checkNotNullParameter(r100, "manager");
        return MapsKt.mapOf(TuplesKt.to("live.incomeExchange", a.f487401a));
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
