package com.bytedance.locallife.pdp.container.view.lynx;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
public final class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final h f261330a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final LynxLoadDispatcher.LoadType f261331b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f261332c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final j f261333d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final LynxLoadDispatcher.a f261334e;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof l) == true) goto L8;
        return false;
    L8:
        l r101 = (l) r100;
        if (Intrinsics.areEqual(this.f261330a, r101.f261330a) == true) goto L12;
        return false;
    L12:
        if (this.f261331b == r101.f261331b) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f261332c, r101.f261332c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f261333d, r101.f261333d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f261334e, r101.f261334e) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public final int hashCode() {
        int r100 = ((((this.f261330a.hashCode() * 31) + this.f261331b.hashCode()) * 31) + this.f261332c.hashCode()) * 31;
        j r101 = this.f261333d;
        int r102 = 0;
        if (r101 != null) goto L5;
        int r103 = 0;
    L6:
        int r104 = (r100 + r103) * 31;
        LynxLoadDispatcher.a r105 = this.f261334e;
        if (r105 == null) goto L11;
        r102 = r105.hashCode();
    L11:
        return r104 + r102;
    L5:
        r103 = r101.hashCode();
        goto L6
    }

    public final String toString() {
        return "LynxLoadTask(loadRequestParams=" + this.f261330a + ", loadType=" + this.f261331b + ", loadUniqueTag=" + this.f261332c + ", loaderConfig=" + this.f261333d + ", dispatchResultCallback=" + this.f261334e + ')';
    }

    public l(h r100, LynxLoadDispatcher.LoadType r101, String r102, j r103, LynxLoadDispatcher.a r104) {
        Intrinsics.checkNotNullParameter(r100, "loadRequestParams");
        Intrinsics.checkNotNullParameter(r101, "loadType");
        Intrinsics.checkNotNullParameter(r102, "loadUniqueTag");
        this.f261330a = r100;
        this.f261331b = r101;
        this.f261332c = r102;
        this.f261333d = r103;
        this.f261334e = r104;
    }
}
