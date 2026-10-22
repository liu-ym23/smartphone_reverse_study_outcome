package n0a;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes31.dex */
public abstract class d {

    public static final class a extends d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f516625a = null;

        static {
            f516625a = new a();
        }

        public a() {
        }
    }

    public static final class b extends d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b f516626a = null;

        static {
            f516626a = new b();
        }

        public b() {
        }
    }

    public static final class c extends d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f516627a;

        public c() {
            this(0);
        }

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof c) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.f516627a, ((c) r100).f516627a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            String r100 = this.f516627a;
            if (r100 != null) goto L6;
            return 0;
        L6:
            return r100.hashCode();
        }

        public final String toString() {
            return "Error(message=" + this.f516627a + ')';
        }

        public c(int r100) {
            this.f516627a = null;
        }
    }

    /* JADX INFO: renamed from: n0a.d$d, reason: collision with other inner class name */
    public static final class C6880d extends d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final C6880d f516628a = null;

        static {
            f516628a = new C6880d();
        }

        public C6880d() {
        }
    }

    public static final class e extends d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final e f516629a = null;

        static {
            f516629a = new e();
        }

        public e() {
        }
    }

    public static final class f extends d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final f f516630a = null;

        static {
            f516630a = new f();
        }

        public f() {
        }
    }

    public d() {
    }
}
