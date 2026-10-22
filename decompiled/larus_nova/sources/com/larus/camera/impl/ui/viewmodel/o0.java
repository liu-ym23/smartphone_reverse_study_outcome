package com.larus.camera.impl.ui.viewmodel;

import android.graphics.Bitmap;
import com.larus.camera.api.params.OutputParam;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public final class o0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Bitmap f322669a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final OutputParam f322670b;

    public o0() {
        this(null, null);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof o0) == true) goto L8;
        return false;
    L8:
        o0 r101 = (o0) r100;
        if (Intrinsics.areEqual(this.f322669a, r101.f322669a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f322670b, r101.f322670b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        Bitmap r100 = this.f322669a;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        OutputParam r104 = this.f322670b;
        if (r104 == null) goto L11;
        r101 = r104.hashCode();
    L11:
        return r103 + r101;
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "PreviewBitmapState(bitmap=" + this.f322669a + ", outputParam=" + this.f322670b + ')';
    }

    public o0(Bitmap r100, OutputParam r101) {
        this.f322669a = r100;
        this.f322670b = r101;
    }
}
