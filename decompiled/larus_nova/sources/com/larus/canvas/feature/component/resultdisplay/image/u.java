package com.larus.canvas.feature.component.resultdisplay.image;

import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public final class u implements com.larus.canvas.feature.component.base.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<y> f323574a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final v f323575b;

    public u() {
        this(0);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof u) == true) goto L8;
        return false;
    L8:
        u r101 = (u) r100;
        if (Intrinsics.areEqual(this.f323574a, r101.f323574a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f323575b, r101.f323575b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        return (this.f323574a.hashCode() * 31) + this.f323575b.hashCode();
    }

    public final String toString() {
        return "ImagePagerUIState(pageList=" + this.f323574a + ", saveAction=" + this.f323575b + ')';
    }

    public /* synthetic */ u(int r100) {
        this(CollectionsKt.emptyList(), new v(0));
    }

    public u(List<y> r100, v r101) {
        Intrinsics.checkNotNullParameter(r100, "pageList");
        Intrinsics.checkNotNullParameter(r101, "saveAction");
        this.f323574a = r100;
        this.f323575b = r101;
    }

    public static u a(u r100, List r101, v r102, int r103) {
        if ((r103 & 1) == 0) goto L6;
        r101 = r100.f323574a;
    L6:
        if ((r103 & 2) == 0) goto L8;
        r102 = r100.f323575b;
    L8:
        r100.getClass();
        Intrinsics.checkNotNullParameter(r101, "pageList");
        Intrinsics.checkNotNullParameter(r102, "saveAction");
        return new u(r101, r102);
    }
}
