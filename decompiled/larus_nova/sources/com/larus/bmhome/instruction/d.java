package com.larus.bmhome.instruction;

import android.graphics.drawable.Drawable;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Integer f312061a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Drawable f312062b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f312063c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Integer f312064d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f312065e;

    public d() {
        this(null, null, null, null, null);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof d) == true) goto L8;
        return false;
    L8:
        d r101 = (d) r100;
        if (Intrinsics.areEqual(this.f312061a, r101.f312061a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f312062b, r101.f312062b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f312063c, r101.f312063c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f312064d, r101.f312064d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f312065e, r101.f312065e) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public final int hashCode() {
        Integer r100 = this.f312061a;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        Drawable r104 = this.f312062b;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.f312063c;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        Integer r110 = this.f312064d;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        String r113 = this.f312065e;
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
        return "EmptyViewConfig(emptyPlaceholderResId=" + this.f312061a + ", emptyContainerBackground=" + this.f312062b + ", emptyTextContent=" + this.f312063c + ", emptyTextColorResId=" + this.f312064d + ", emptyContentDescription=" + this.f312065e + ')';
    }

    public d(Integer r100, Drawable r101, String r102, Integer r103, String r104) {
        this.f312061a = r100;
        this.f312062b = r101;
        this.f312063c = r102;
        this.f312064d = r103;
        this.f312065e = r104;
    }
}
