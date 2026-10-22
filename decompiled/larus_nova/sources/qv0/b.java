package qv0;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public abstract class b implements Comparable<b> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f534870a;

    public static final class a extends b {
        public a() {
            super("Creating", 1);
        }

        static {
            new a();
        }
    }

    /* JADX INFO: renamed from: qv0.b$b, reason: collision with other inner class name */
    public static final class C7395b extends b {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final C7395b f534871b = null;

        public C7395b() {
            super("Idle", 2);
        }

        static {
            f534871b = new C7395b();
        }
    }

    public static final class c extends b {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final c f534872b = null;

        public c() {
            super("Initial", 0);
        }

        static {
            f534872b = new c();
        }
    }

    public static final class d extends b {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final d f534873b = null;

        public d() {
            super("Paused", 4);
        }

        static {
            f534873b = new d();
        }
    }

    public static final class e extends b {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final e f534874b = null;

        public e() {
            super("Running", 3);
        }

        static {
            f534874b = new e();
        }
    }

    public static final class f extends b {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final f f534875b = null;

        public f() {
            super("Terminated", -1);
        }

        static {
            f534875b = new f();
        }
    }

    @Override // java.lang.Comparable
    public final int compareTo(b r100) {
        b r101 = r100;
        Intrinsics.checkNotNullParameter(r101, "other");
        return Intrinsics.compare(this.f534870a, r101.f534870a);
    }

    public b(String r100, int r101) {
        this.f534870a = r101;
    }
}
