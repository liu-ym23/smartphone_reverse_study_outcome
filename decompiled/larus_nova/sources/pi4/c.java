package pi4;

import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
public final class c implements ki4.n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Lazy f529326a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Lazy f529327b;

    public c() {
        this.f529326a = LazyKt.lazy(new a(this));
        this.f529327b = LazyKt.lazy(new b(this));
    }

    @Override // ki4.n
    public final ki4.m a(Class<? extends ki4.m> r100) {
        Intrinsics.checkNotNullParameter(r100, "clazz");
        if (Intrinsics.areEqual(r100, qi4.f.class) == false) goto L6;
        ki4.m r101 = (ki4.m) this.f529326a.getValue();
    L9:
        if (r101 == null) goto L12;
        return r101;
    L12:
        throw new IllegalArgumentException(("AlbumSDK: GroupStrategyProvider error, current clazz is " + r100).toString());
    L6:
        if (Intrinsics.areEqual(r100, qi4.g.class) == false) goto L8;
        r101 = (ki4.m) this.f529327b.getValue();
        goto L9
    L8:
        r101 = null;
        goto L9
    }
}
