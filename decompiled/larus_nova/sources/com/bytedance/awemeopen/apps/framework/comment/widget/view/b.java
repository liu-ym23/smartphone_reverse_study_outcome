package com.bytedance.awemeopen.apps.framework.comment.widget.view;

import com.bytedance.awemeopen.apps.framework.comment.write.model.TextExtraStruct;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f194354a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f194355b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f194356c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f194357d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f194358e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f194359f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f194360g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final TextExtraStruct f194361h;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof b) == true) goto L8;
        return false;
    L8:
        b r101 = (b) r100;
        if (this.f194354a == r101.f194354a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f194355b, r101.f194355b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f194356c, r101.f194356c) == true) goto L18;
        return false;
    L18:
        if (this.f194357d == r101.f194357d) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f194358e, r101.f194358e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f194359f, r101.f194359f) == true) goto L27;
        return false;
    L27:
        if (this.f194360g == r101.f194360g) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.f194361h, r101.f194361h) == true) goto L32;
        return false;
    L32:
        return true;
    }

    public final int hashCode() {
        int r100 = this.f194354a * 31;
        String r101 = this.f194355b;
        int r102 = 0;
        if (r101 != null) goto L5;
        int r103 = 0;
    L6:
        int r104 = (r100 + r103) * 31;
        String r105 = this.f194356c;
        if (r105 != null) goto L9;
        int r106 = 0;
    L10:
        int r107 = (((r104 + r106) * 31) + this.f194357d) * 31;
        String r108 = this.f194358e;
        if (r108 != null) goto L13;
        int r109 = 0;
    L14:
        int r110 = (r107 + r109) * 31;
        String r111 = this.f194359f;
        if (r111 != null) goto L17;
        int r112 = 0;
    L18:
        int r113 = (((r110 + r112) * 31) + this.f194360g) * 31;
        TextExtraStruct r114 = this.f194361h;
        if (r114 == null) goto L23;
        r102 = r114.hashCode();
    L23:
        return r113 + r102;
    L17:
        r112 = r111.hashCode();
        goto L18
    L13:
        r109 = r108.hashCode();
        goto L14
    L9:
        r106 = r105.hashCode();
        goto L10
    L5:
        r103 = r101.hashCode();
        goto L6
    }

    public final String toString() {
        return "MentionSpanParam(color=" + this.f194354a + ", text=" + this.f194355b + ", id=" + this.f194356c + ", type=" + this.f194357d + ", atUserType=" + this.f194358e + ", secid=" + this.f194359f + ", followStatus=" + this.f194360g + ", textExtra=" + this.f194361h + ')';
    }

    public final int getType() {
        return this.f194357d;
    }

    public b(int r100, String r101, String r102, int r103, String r104, String r105, int r106, TextExtraStruct r107) {
        this.f194354a = r100;
        this.f194355b = r101;
        this.f194356c = r102;
        this.f194357d = r103;
        this.f194358e = r104;
        this.f194359f = r105;
        this.f194360g = r106;
        this.f194361h = r107;
    }
}
