package com.larus.common_ui.dialog;

import android.graphics.Typeface;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes27.dex */
public final class i1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Integer f327317a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Integer f327318b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Typeface f327319c;

    public i1() {
        this(null, null, 7);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof i1) == true) goto L8;
        return false;
    L8:
        i1 r101 = (i1) r100;
        if (Intrinsics.areEqual(this.f327317a, r101.f327317a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f327318b, r101.f327318b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f327319c, r101.f327319c) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        Integer r100 = this.f327317a;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        Integer r104 = this.f327318b;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        Typeface r107 = this.f327319c;
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
        return "SpannableDialogButtonTextStyleConfig(textSize=" + this.f327317a + ", textColor=" + this.f327318b + ", textTypeface=" + this.f327319c + ')';
    }

    public i1(Integer r100, Integer r101, int r102) {
        if ((r102 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r102 & 2) == 0) goto L8;
        r101 = null;
    L8:
        this.f327317a = r100;
        this.f327318b = r101;
        this.f327319c = null;
    }
}
