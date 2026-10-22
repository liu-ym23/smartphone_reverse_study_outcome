package p71;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public abstract class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f527977a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f527978b;

    /* JADX INFO: renamed from: p71.a$a, reason: collision with other inner class name */
    public static final class C7158a extends a {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final C7158a f527979c = null;

        public C7158a() {
            super(7, "卡片已经在展示了，重复调用show时被拦截");
        }

        static {
            f527979c = new C7158a();
        }
    }

    public static final class b extends a {
        public b() {
            super(1);
        }
    }

    public static final class c extends a {
        public c(String r100) {
            Intrinsics.checkNotNullParameter(r100, "id");
            super(3);
        }
    }

    public static final class d extends a {
        public d() {
            super(2);
        }
    }

    public static final class e extends a {
        public e() {
            super(5);
        }
    }

    public static final class f extends a {
        public f() {
            super(6);
        }
    }

    public static final class g extends a {
        public g(String r100) {
            Intrinsics.checkNotNullParameter(r100, "winnerId");
            super(4);
        }
    }

    public static final class h extends a {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final h f527980c = null;

        static {
            f527980c = new h();
        }

        public h() {
            super(8, "卡片已经在展示了，在真正展示时被拦截");
        }
    }

    public /* synthetic */ a() {
        throw null;
    }

    public /* synthetic */ a(int r100) {
        this(r100, "");
    }

    public a(int r100, String r101) {
        this.f527977a = r100;
        this.f527978b = r101;
    }
}
