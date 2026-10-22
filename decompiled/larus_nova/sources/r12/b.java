package r12;

import com.bytedance.ies.web.jsbridge2.g;
import java.util.Map;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import wy0.h;

/* JADX INFO: loaded from: classes9.dex */
public final class b implements wy0.f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f535612a = null;

    public static final class a implements com.bytedance.ies.web.jsbridge2.f.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f535613a = null;

        static {
            f535613a = new a();
        }

        public a() {
        }

        @Override // com.bytedance.ies.web.jsbridge2.f.b
        public final com.bytedance.ies.web.jsbridge2.f<Object, Object> a() {
            return new e();
        }
    }

    public b() {
    }

    static {
        f535612a = new b();
    }

    @Override // wy0.f
    public final Map<String, com.bytedance.ies.web.jsbridge2.f.b> a(y6.c r100) {
        Intrinsics.checkNotNullParameter(r100, "manager");
        return MapsKt.mapOf(TuplesKt.to("format.sendGift", a.f535613a));
    }

    @Override // wy0.d
    public final Map<String, h<Object, ?>> c(y6.c r100) {
        Intrinsics.checkNotNullParameter(r100, "manager");
        return wy0.f.a.a(r100);
    }

    @Override // wy0.f
    public final Map<String, g<?, ?>> d(y6.c r100) {
        Intrinsics.checkNotNullParameter(r100, "manager");
        Intrinsics.checkNotNullParameter(r100, "manager");
        return MapsKt.emptyMap();
    }

    @Override // wy0.d
    public final Map<String, g<Object, ?>> f(y6.c r100) {
        Intrinsics.checkNotNullParameter(r100, "manager");
        return wy0.f.a.b(r100);
    }
}
