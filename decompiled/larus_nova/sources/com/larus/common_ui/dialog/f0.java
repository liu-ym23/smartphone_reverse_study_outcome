package com.larus.common_ui.dialog;

import android.graphics.Typeface;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes27.dex */
public final class f0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Integer f327305a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Integer f327306b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Typeface f327307c;

    public f0() {
        this(null, null, null, 7);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof f0) == true) goto L8;
        return false;
    L8:
        f0 r101 = (f0) r100;
        if (Intrinsics.areEqual(this.f327305a, r101.f327305a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f327306b, r101.f327306b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f327307c, r101.f327307c) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        Integer r100 = this.f327305a;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        Integer r104 = this.f327306b;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        Typeface r107 = this.f327307c;
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
        return "CommonDialogTextStyleConfig(textSize=" + this.f327305a + ", textColor=" + this.f327306b + ", textTypeface=" + this.f327307c + ')';
    }

    public f0(Integer r100, Integer r101, Typeface r102, int r103) {
        if ((r103 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r101 = null;
    L9:
        if ((r103 & 4) == 0) goto L11;
        r102 = null;
    L11:
        this.f327305a = r100;
        this.f327306b = r101;
        this.f327307c = r102;
    }
}
