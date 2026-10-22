package com.larus.bmhome.share.panel;

import android.text.TextUtils;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f313953a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final n f313954b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Integer f313955c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Integer f313956d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Integer f313957e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Integer f313958f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final TextUtils.TruncateAt f313959g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Float f313960h;

    public i() {
        this(null, null, null, null, null, null, null, 255);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof i) == true) goto L8;
        return false;
    L8:
        i r101 = (i) r100;
        if (Intrinsics.areEqual(this.f313953a, r101.f313953a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f313954b, r101.f313954b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f313955c, r101.f313955c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f313956d, r101.f313956d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f313957e, r101.f313957e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f313958f, r101.f313958f) == true) goto L27;
        return false;
    L27:
        if (this.f313959g == r101.f313959g) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.f313960h, r101.f313960h) == true) goto L32;
        return false;
    L32:
        return true;
    }

    public final int hashCode() {
        String r100 = this.f313953a;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        n r104 = this.f313954b;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        Integer r107 = this.f313955c;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        Integer r110 = this.f313956d;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        Integer r113 = this.f313957e;
        if (r113 != null) goto L21;
        int r114 = 0;
    L22:
        int r115 = (r112 + r114) * 31;
        Integer r116 = this.f313958f;
        if (r116 != null) goto L25;
        int r117 = 0;
    L26:
        int r118 = (r115 + r117) * 31;
        TextUtils.TruncateAt r119 = this.f313959g;
        if (r119 != null) goto L29;
        int r120 = 0;
    L30:
        int r121 = (r118 + r120) * 31;
        Float r122 = this.f313960h;
        if (r122 == null) goto L35;
        r101 = r122.hashCode();
    L35:
        return r121 + r101;
    L29:
        r120 = r119.hashCode();
        goto L30
    L25:
        r117 = r116.hashCode();
        goto L26
    L21:
        r114 = r113.hashCode();
        goto L22
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
        return "SharePanelHeaderConfig(title=" + this.f313953a + ", subTitle=" + this.f313954b + ", titleMaxEms=" + this.f313955c + ", titleGravity=" + this.f313956d + ", titleStartMargin=" + this.f313957e + ", titleMaxLines=" + this.f313958f + ", titleEllipsize=" + this.f313959g + ", titleTextSize=" + this.f313960h + ')';
    }

    public i(String r100, n r101, Integer r102, Integer r103, Integer r104, Integer r105, TextUtils.TruncateAt r106, int r110) {
        if ((r110 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r110 & 2) == 0) goto L9;
        r101 = null;
    L9:
        if ((r110 & 4) == 0) goto L12;
        r102 = null;
    L12:
        if ((r110 & 8) == 0) goto L15;
        r103 = null;
    L15:
        if ((r110 & 16) == 0) goto L18;
        r104 = null;
    L18:
        if ((r110 & 32) == 0) goto L21;
        r105 = null;
    L21:
        if ((r110 & 64) == 0) goto L23;
        r106 = null;
    L23:
        this.f313953a = r100;
        this.f313954b = r101;
        this.f313955c = r102;
        this.f313956d = r103;
        this.f313957e = r104;
        this.f313958f = r105;
        this.f313959g = r106;
        this.f313960h = null;
    }
}
