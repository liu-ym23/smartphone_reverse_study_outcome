package vp3;

import kotlin.jvm.internal.Intrinsics;
import wp3.g;
import yp3.h;

/* JADX INFO: loaded from: classes14.dex */
public abstract class d extends b {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public g f556623e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public wp3.e f556624f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public wp3.d f556625g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public wp3.a f556626h;

    public boolean c() {
        if (this.f556623e != null) goto L5;
    L9:
        return false;
    L5:
        if (this.f556624f != null) goto L9;
        if (this.f556625g != null) goto L9;
        return true;
    }

    public d(int r100) {
        super(r100);
    }

    public <T> T b(yp3.e<T> r100) {
        Intrinsics.checkNotNullParameter(r100, "elementKey");
        if (Intrinsics.areEqual(r100, h.f568704a) == false) goto L9;
        Object r101 = this.f556623e;
        if ((r101 instanceof Object) == true) goto L22;
        return null;
    L22:
        return (T) r101;
    L9:
        if (Intrinsics.areEqual(r100, yp3.g.f568703a) == false) goto L14;
        r101 = this.f556624f;
        if ((r101 instanceof Object) == true) goto L22;
        return null;
    L14:
        if (Intrinsics.areEqual(r100, yp3.c.f568701a) == false) goto L19;
        r101 = this.f556625g;
        if ((r101 instanceof Object) == true) goto L22;
        return null;
    L19:
        if (Intrinsics.areEqual(r100, yp3.a.f568699a) == false) goto L23;
        r101 = this.f556626h;
        if ((r101 instanceof Object) == true) goto L22;
        return null;
    L23:
        return null;
    }
}
