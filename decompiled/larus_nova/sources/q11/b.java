package q11;

import com.bytedance.android.live.link.data.RevPkState;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public abstract class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f531271a;

    public static final class a extends b {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final a f531272b = null;

        static {
            f531272b = new a();
        }

        public a() {
            super("DISABLE");
        }
    }

    /* JADX INFO: renamed from: q11.b$b, reason: collision with other inner class name */
    public static final class C7265b extends b {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final C7265b f531273b = null;

        static {
            f531273b = new C7265b();
        }

        public C7265b() {
            super("FINISHED");
        }
    }

    public static final class c extends b {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final c f531274b = null;

        static {
            f531274b = new c();
        }

        public c() {
            super("PENAL");
        }
    }

    public static final class d extends b {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final d f531275b = null;

        static {
            f531275b = new d();
        }

        public d() {
            super("PK");
        }
    }

    public final RevPkState a() {
        if (Intrinsics.areEqual(this, a.f531272b) == false) goto L6;
        return RevPkState.DISABLE;
    L6:
        if (Intrinsics.areEqual(this, d.f531275b) == false) goto L9;
        return RevPkState.PK;
    L9:
        if (Intrinsics.areEqual(this, c.f531274b) == false) goto L12;
        return RevPkState.PENAL;
    L12:
        if (Intrinsics.areEqual(this, C7265b.f531273b) == false) goto L16;
        return RevPkState.FINISHED;
    L16:
        throw new NoWhenBranchMatchedException();
    }

    public final String toString() {
        return this.f531271a;
    }

    public b(String r100) {
        this.f531271a = r100;
    }
}
