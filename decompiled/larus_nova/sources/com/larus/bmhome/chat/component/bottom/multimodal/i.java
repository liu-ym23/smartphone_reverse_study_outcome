package com.larus.bmhome.chat.component.bottom.multimodal;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<Boolean> f299789a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<Boolean> f299790b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List<Boolean> f299791c;

    public i() {
        this(null, 7);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof i) == true) goto L8;
        return false;
    L8:
        i r101 = (i) r100;
        if (Intrinsics.areEqual(this.f299789a, r101.f299789a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f299790b, r101.f299790b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f299791c, r101.f299791c) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        List<Boolean> r100 = this.f299789a;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        List<Boolean> r104 = this.f299790b;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        List<Boolean> r107 = this.f299791c;
        if (r107 == null) goto L15;
        r101 = r107.hashCode();
    L15:
        return r106 + r101;
    L9:
        r105 = r104.hashCode();
        goto L10
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "ImageEditData(isImagesMarked=" + this.f299789a + ", isImagesCropped=" + this.f299790b + ", isImagesAiCreation=" + this.f299791c + ')';
    }

    public /* synthetic */ i(List r100, int r101) {
        if ((r101 & 4) == 0) goto L5;
        r100 = null;
    L5:
        this(null, null, r100);
    }

    public i(List<Boolean> r100, List<Boolean> r101, List<Boolean> r102) {
        this.f299789a = r100;
        this.f299790b = r101;
        this.f299791c = r102;
    }
}
