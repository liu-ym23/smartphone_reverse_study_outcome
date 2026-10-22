package com.larus.voicecall.impl.video;

import android.view.ViewGroup;
import java.util.Arrays;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes32.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f379608a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f379609b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int[] f379610c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ViewGroup f379611d;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof h) == true) goto L8;
        return false;
    L8:
        h r101 = (h) r100;
        if (this.f379608a == r101.f379608a) goto L12;
        return false;
    L12:
        if (this.f379609b == r101.f379609b) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f379610c, r101.f379610c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f379611d, r101.f379611d) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        return (((((this.f379608a * 31) + this.f379609b) * 31) + Arrays.hashCode(this.f379610c)) * 31) + this.f379611d.hashCode();
    }

    public final String toString() {
        return "OriginParams(contentOriginWidth=" + this.f379608a + ", contentOriginHeight=" + this.f379609b + ", contentOriginLocation=" + Arrays.toString(this.f379610c) + ", originParent=" + this.f379611d + ')';
    }

    public h(int r100, int r101, int[] r102, ViewGroup r103) {
        Intrinsics.checkNotNullParameter(r102, "contentOriginLocation");
        Intrinsics.checkNotNullParameter(r103, "originParent");
        this.f379608a = r100;
        this.f379609b = r101;
        this.f379610c = r102;
        this.f379611d = r103;
    }
}
