package com.larus.common_ui.dialog;

import android.graphics.Typeface;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes27.dex */
public final class j1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Integer f327355a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Integer f327356b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Typeface f327357c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Integer f327358d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Integer f327359e;

    public j1() {
        this(null, null, null, null, 31);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof j1) == true) goto L8;
        return false;
    L8:
        j1 r101 = (j1) r100;
        if (Intrinsics.areEqual(this.f327355a, r101.f327355a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f327356b, r101.f327356b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f327357c, r101.f327357c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f327358d, r101.f327358d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f327359e, r101.f327359e) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public final int hashCode() {
        Integer r100 = this.f327355a;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        Integer r104 = this.f327356b;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        Typeface r107 = this.f327357c;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        Integer r110 = this.f327358d;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        Integer r113 = this.f327359e;
        if (r113 == null) goto L23;
        r101 = r113.hashCode();
    L23:
        return r112 + r101;
    L17:
        r111 = r110.hashCode();
        goto L18
    L13:
        r108 = r107.hashCode();
        goto L14
    L9:
        r105 = r104.hashCode();
        goto L10
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "SpannableDialogMessageTextStyleConfig(textSize=" + this.f327355a + ", textColor=" + this.f327356b + ", textTypeface=" + this.f327357c + ", linkTextColor=" + this.f327358d + ", textGravity=" + this.f327359e + ')';
    }

    public j1(Integer r100, Integer r101, Integer r102, Integer r103, int r104) {
        if ((r104 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r101 = null;
    L9:
        if ((r104 & 8) == 0) goto L12;
        r102 = null;
    L12:
        if ((r104 & 16) == 0) goto L14;
        r103 = null;
    L14:
        this.f327355a = r100;
        this.f327356b = r101;
        this.f327357c = null;
        this.f327358d = r102;
        this.f327359e = r103;
    }
}
