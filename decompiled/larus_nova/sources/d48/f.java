package d48;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes24.dex */
public interface f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f466833a = null;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ a f466834a = null;

        /* JADX INFO: renamed from: d48.f$a$a, reason: collision with other inner class name */
        public static final class C5631a implements f {
            public C5631a() {
            }
        }

        public static final class b implements b {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final b f466835a = null;

            static {
                f466835a = new b();
            }

            public b() {
            }

            @Override // d48.f.b
            public final long getLong(String r100) {
                Intrinsics.checkNotNullParameter(r100, "key");
                return 0;
            }

            @Override // d48.f.b
            public final String getString(String r100) {
                Intrinsics.checkNotNullParameter(r100, "key");
                Intrinsics.checkNotNullParameter("", "defValue");
                return "";
            }

            @Override // d48.f.b
            public final void putLong(String r100, long r101) {
                Intrinsics.checkNotNullParameter(r100, "key");
            }

            @Override // d48.f.b
            public final void putString(String r100, String r101) {
                Intrinsics.checkNotNullParameter(r100, "key");
                Intrinsics.checkNotNullParameter(r101, "value");
            }

            @Override // d48.f.b
            public final void remove(String r100) {
                Intrinsics.checkNotNullParameter(r100, "key");
            }
        }

        public a() {
        }

        static {
            f466834a = new a();
            new C5631a();
        }
    }

    public interface b {
        long getLong(String r100);

        String getString(String r100);

        void putLong(String r100, long r101);

        void putString(String r100, String r101);

        void remove(String r100);
    }

    static {
        f466833a = a.f466834a;
    }
}
