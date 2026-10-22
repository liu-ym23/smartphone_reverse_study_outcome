package ud0;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
public abstract class c {

    public static final class a extends c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f549712a = null;

        static {
            f549712a = new a();
        }

        public a() {
        }
    }

    public static final class b extends c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final sd0.a f549713a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f549714b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final boolean f549715c;

        public final int getType() {
            return this.f549714b;
        }

        public b(sd0.a r100, int r101) {
            Intrinsics.checkNotNullParameter(r100, "selectVideo");
            this.f549713a = r100;
            this.f549714b = r101;
            this.f549715c = false;
        }
    }

    public c() {
    }
}
