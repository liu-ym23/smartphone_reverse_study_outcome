package wu0;

import com.bytedance.ies.web.jsbridge2.g;
import java.util.Map;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import wy0.f;
import wy0.h;
import y6.c;

/* JADX INFO: loaded from: classes47.dex */
public final class b implements f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f561429a = null;

    public static final class a implements com.bytedance.ies.web.jsbridge2.f.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f561430a = null;

        static {
            f561430a = new a();
        }

        public a() {
        }

        @Override // com.bytedance.ies.web.jsbridge2.f.b
        public final com.bytedance.ies.web.jsbridge2.f<Object, Object> a() {
            return new wu0.a();
        }
    }

    public b() {
    }

    static {
        f561429a = new b();
    }

    @Override // wy0.f
    public final Map<String, com.bytedance.ies.web.jsbridge2.f.b> a(c r100) {
        Intrinsics.checkNotNullParameter(r100, "manager");
        return MapsKt.mapOf(TuplesKt.to("live.update_fansclub_info", a.f561430a));
    }

    @Override // wy0.d
    public final Map<String, h<Object, ?>> c(c r100) {
        Intrinsics.checkNotNullParameter(r100, "manager");
        return f.a.a(r100);
    }

    @Override // wy0.f
    public final Map<String, g<?, ?>> d(c r100) {
        Intrinsics.checkNotNullParameter(r100, "manager");
        Intrinsics.checkNotNullParameter(r100, "manager");
        return MapsKt.emptyMap();
    }

    @Override // wy0.d
    public final Map<String, g<Object, ?>> f(c r100) {
        Intrinsics.checkNotNullParameter(r100, "manager");
        return f.a.b(r100);
    }
}
