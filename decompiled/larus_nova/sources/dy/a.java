package dy;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
public abstract class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f470512a;

    /* JADX INFO: renamed from: dy.a$a, reason: collision with other inner class name */
    public static final class C5722a extends a {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final C5722a f470513b = null;

        static {
            f470513b = new C5722a();
        }

        public C5722a() {
            super("JoinFailed");
        }
    }

    public static final class b extends a {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f470514b;

        @Override // dy.a
        public final String toString() {
            return this.f470512a + '_' + this.f470514b;
        }

        public b(String r100) {
            Intrinsics.checkNotNullParameter(r100, "reqSrc");
            super("RTCEndSuccess");
            this.f470514b = r100;
        }
    }

    public static final class c extends a {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f470515b;

        @Override // dy.a
        public final String toString() {
            return this.f470512a + '_' + this.f470515b;
        }

        public c(String r100) {
            Intrinsics.checkNotNullParameter(r100, "endReason");
            super("StopLiveBroadcast");
            this.f470515b = r100;
        }
    }

    public static final class d extends a {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f470516b;

        @Override // dy.a
        public final String toString() {
            return this.f470512a + '_' + this.f470516b;
        }

        public d(String r100) {
            Intrinsics.checkNotNullParameter(r100, "reqSrc");
            super("UnExceptUnload");
            this.f470516b = r100;
        }
    }

    public static final class e extends a {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final e f470517b = null;

        static {
            f470517b = new e();
        }

        public e() {
            super("Unknown");
        }
    }

    public String toString() {
        return this.f470512a;
    }

    public a(String r100) {
        this.f470512a = r100;
    }
}
