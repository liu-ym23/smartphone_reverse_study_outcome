package q11;

import com.bytedance.android.live.link.data.RevPkResult;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public abstract class a {

    /* JADX INFO: renamed from: q11.a$a, reason: collision with other inner class name */
    public static final class C7264a extends a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final C7264a f531267a = null;

        static {
            f531267a = new C7264a();
        }

        public C7264a() {
        }
    }

    public static final class b extends a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b f531268a = null;

        static {
            f531268a = new b();
        }

        public b() {
        }
    }

    public static final class c extends a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final c f531269a = null;

        static {
            f531269a = new c();
        }

        public c() {
        }
    }

    public static final class d extends a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final d f531270a = null;

        static {
            f531270a = new d();
        }

        public d() {
        }
    }

    public final RevPkResult a() {
        if (Intrinsics.areEqual(this, d.f531270a) == false) goto L6;
        return RevPkResult.UNFINISHED;
    L6:
        if (Intrinsics.areEqual(this, b.f531268a) == false) goto L9;
        return RevPkResult.LEFT_WON;
    L9:
        if (Intrinsics.areEqual(this, c.f531269a) == false) goto L12;
        return RevPkResult.RIGHT_WON;
    L12:
        if (Intrinsics.areEqual(this, C7264a.f531267a) == false) goto L16;
        return RevPkResult.EVEN;
    L16:
        throw new NoWhenBranchMatchedException();
    }

    public a() {
    }
}
