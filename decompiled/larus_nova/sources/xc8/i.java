package xc8;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class i implements ei9.g<c, b> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final g f563244a;

    public i(g r100) {
        Intrinsics.checkNotNullParameter(r100, "innerTransformer");
        this.f563244a = r100;
    }

    @Override // ei9.g
    public final boolean a(c r100) {
        c r101 = r100;
        Intrinsics.checkNotNullParameter(r101, "sourceData");
        g r102 = this.f563244a;
        r101.getClass();
        return r102.a(null);
    }

    @Override // ei9.g
    public final ei9.f b(c r100) {
        c r101 = r100;
        Intrinsics.checkNotNullParameter(r101, "sourceData");
        g r102 = this.f563244a;
        r101.getClass();
        return r102.b(null);
    }
}
