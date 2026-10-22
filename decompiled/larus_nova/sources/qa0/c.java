package qa0;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
public final class c implements b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static b f532211a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final c f532212b = null;

    public c() {
    }

    static {
        f532212b = new c();
    }

    @Override // qa0.b
    public final <T extends a> T getService(Class<T> r100) {
        Intrinsics.checkNotNullParameter(r100, "serviceCls");
        b r101 = f532211a;
        if (r101 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("impl");
    L6:
        return (T) r101.getService(r100);
    }
}
