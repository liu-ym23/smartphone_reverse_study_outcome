package eb9;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes29.dex */
public final class a implements v {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f471852a = null;

    static {
        f471852a = new a();
    }

    public a() {
    }

    @Override // eb9.v
    public final boolean a(o<?> r100, o<?> r101) {
        Intrinsics.checkNotNullParameter(r100, "oldItem");
        Intrinsics.checkNotNullParameter(r101, "newItem");
        return Intrinsics.areEqual(r100, r101);
    }

    @Override // eb9.v
    public final boolean b(o<?> r100, o<?> r101) {
        Intrinsics.checkNotNullParameter(r100, "oldItem");
        Intrinsics.checkNotNullParameter(r101, "newItem");
        return Intrinsics.areEqual(r100.f471907a, r101.f471907a);
    }
}
