package ry9;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes31.dex */
public abstract class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final i f539935a;

    public static final class a extends j {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final a f539936b = null;

        static {
            f539936b = new a();
        }

        public a() {
            super(null);
        }
    }

    public static final class b extends j {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final b f539937b = null;

        static {
            f539937b = new b();
        }

        public b() {
            super(null);
        }
    }

    public static final class c extends j {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final i f539938b;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof c) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.f539938b, ((c) r100).f539938b) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            i r100 = this.f539938b;
            if (r100 != null) goto L6;
            return 0;
        L6:
            return r100.hashCode();
        }

        public final String toString() {
            return "Filled(data=" + this.f539938b + ')';
        }

        @Override // ry9.j
        public final i a() {
            return this.f539938b;
        }

        public c(i r100) {
            super(r100);
            this.f539938b = r100;
        }
    }

    public static final class d extends j {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final d f539939b = null;

        static {
            f539939b = new d();
        }

        public d() {
            super(null);
        }
    }

    public static final class e extends j {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final e f539940b = null;

        static {
            f539940b = new e();
        }

        public e() {
            super(null);
        }
    }

    public static final class f extends j {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final f f539941b = null;

        static {
            f539941b = new f();
        }

        public f() {
            super(null);
        }
    }

    public static final class g extends j {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final g f539942b = null;

        static {
            f539942b = new g();
        }

        public g() {
            super(null);
        }
    }

    public static final class h extends j {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final h f539943b = null;

        static {
            f539943b = new h();
        }

        public h() {
            super(null);
        }
    }

    public i a() {
        return this.f539935a;
    }

    public j(i r100) {
        this.f539935a = r100;
    }
}
