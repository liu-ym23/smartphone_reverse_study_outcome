package k54;

import java.util.Map;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: classes44.dex */
public abstract class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f501834a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f501835b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Map<String, ? extends Object> f501836c;

    public static final class a {
    }

    /* JADX INFO: renamed from: k54.b$b, reason: collision with other inner class name */
    public static final class C6508b extends b {
        public C6508b(String r100) {
            Intrinsics.checkNotNullParameter(r100, "awemeId");
            super(r100, 1, null);
        }
    }

    public static final class c extends b {
        public c(String r100) {
            Intrinsics.checkNotNullParameter(r100, "awemeId");
            super(r100, 1, null);
        }
    }

    public static final class d extends b {
        public d(String r100, int r101, int r102) {
            Intrinsics.checkNotNullParameter(r100, "awemeId");
            super(r100, r101, MapsKt.mapOf(TuplesKt.to("reason", Integer.valueOf(r102))));
        }
    }

    public static final class e extends b {
        public e(String r100) {
            Intrinsics.checkNotNullParameter(r100, "awemeId");
            super(r100, 1, null);
        }
    }

    public static final class f extends b {
        public f(String r100) {
            Intrinsics.checkNotNullParameter(r100, "awemeId");
            super(r100, 1, null);
        }
    }

    public static final class g extends b {
        public g(String r100, int r101, int r102) {
            Intrinsics.checkNotNullParameter(r100, "awemeId");
            super(r100, r101, MapsKt.mapOf(TuplesKt.to("reason", Integer.valueOf(r102))));
        }
    }

    public static final class h extends b {
        public h(String r100, int r101) {
            Intrinsics.checkNotNullParameter(r100, "awemeId");
            super(r100, r101, null);
        }
    }

    public static final class i extends b {
        public i(String r100, int r101) {
            Intrinsics.checkNotNullParameter(r100, "awemeId");
            super(r100, r101, null);
        }
    }

    static {
    }

    public final String toString() {
        return Reflection.getOrCreateKotlinClass(getClass()).getSimpleName() + ": id=" + this.f501834a + ", type=" + this.f501835b + ", extra=" + this.f501836c;
    }

    public b(String r100, int r101, Map r102) {
        this.f501834a = r100;
        this.f501835b = r101;
        this.f501836c = r102;
    }
}
