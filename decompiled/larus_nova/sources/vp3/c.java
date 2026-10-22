package vp3;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public final class c extends d {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final /* synthetic */ int f556620k = 0;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public wp3.b f556621i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public wp3.f f556622j;

    public static final class a {
    }

    static {
    }

    public c() {
        super(2);
    }

    @Override // vp3.d
    public final boolean c() {
        if (super.c() == true) goto L5;
    L9:
        return false;
    L5:
        if (this.f556621i != null) goto L9;
        if (this.f556622j != null) goto L9;
        return true;
    }

    @Override // vp3.d, yp3.f
    public final <T> T b(yp3.e<T> r100) {
        Intrinsics.checkNotNullParameter(r100, "elementKey");
        if (Intrinsics.areEqual(r100, yp3.b.f568700a) == false) goto L9;
        Object r101 = this.f556621i;
        if ((r101 instanceof Object) == true) goto L15;
        return null;
    L15:
        return (T) r101;
    L9:
        if (Intrinsics.areEqual(r100, yp3.d.f568702a) == false) goto L14;
        r101 = this.f556622j;
        if ((r101 instanceof Object) == true) goto L15;
        return null;
    L14:
        return (T) super.b(r100);
    }
}
