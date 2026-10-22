package me9;

/* JADX INFO: loaded from: classes30.dex */
public abstract class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f513573a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f513574b;

    public static final class a extends b {
        public a(long r100) {
            super(true, r100);
        }
    }

    /* JADX INFO: renamed from: me9.b$b, reason: collision with other inner class name */
    public static final class C6811b extends b {
        public C6811b(long r100) {
            super(false, r100);
        }
    }

    public static final class c extends b {
        public c(long r100) {
            super(false, r100);
        }
    }

    public static final class d extends b {
        public d(long r100) {
            super(true, r100);
        }
    }

    public b(boolean r100, long r101) {
        this.f513573a = r100;
        this.f513574b = r101;
    }
}
