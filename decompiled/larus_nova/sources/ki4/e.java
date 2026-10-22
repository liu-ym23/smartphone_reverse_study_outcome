package ki4;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
public interface e<DATA> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f503623a = null;

    public static final class a implements e<r> {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ a f503624b = null;

        static {
            f503624b = new a();
        }

        public a() {
        }

        @Override // ki4.e
        public final void a(Object r100) {
            Intrinsics.checkNotNullParameter((r) r100, "data");
        }
    }

    static {
        f503623a = a.f503624b;
    }

    void a(Object r100);
}
