package com.ss.android.lark.biz.im.api.message.params;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes34.dex */
public final class v implements l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final o f410381a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final o f410382b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Float f410383c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Float f410384d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Float f410385e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Boolean f410386f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Boolean f410387g;

    public v() {
        this(null, null, null, null, null, null, null);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof v) == true) goto L8;
        return false;
    L8:
        v r101 = (v) r100;
        if (Intrinsics.areEqual(this.f410381a, r101.f410381a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f410382b, r101.f410382b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f410383c, r101.f410383c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f410384d, r101.f410384d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f410385e, r101.f410385e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f410386f, r101.f410386f) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.f410387g, r101.f410387g) == true) goto L29;
        return false;
    L29:
        return true;
    }

    public final int hashCode() {
        o r100 = this.f410381a;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        o r104 = this.f410382b;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        Float r107 = this.f410383c;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        Float r110 = this.f410384d;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        Float r113 = this.f410385e;
        if (r113 != null) goto L21;
        int r114 = 0;
    L22:
        int r115 = (r112 + r114) * 31;
        Boolean r116 = this.f410386f;
        if (r116 != null) goto L25;
        int r117 = 0;
    L26:
        int r118 = (r115 + r117) * 31;
        Boolean r119 = this.f410387g;
        if (r119 == null) goto L31;
        r101 = r119.hashCode();
    L31:
        return r118 + r101;
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
        return "ReplyBlockCellParam(textColorConfig=" + this.f410381a + ", iconColorConfig=" + this.f410382b + ", iconAlpha=" + this.f410383c + ", textAlpha=" + this.f410384d + ", replyImageSizeDp=" + this.f410385e + ", replyImageCenterVertical=" + this.f410386f + ", replyImageFitCenter=" + this.f410387g + ')';
    }

    public v(o r100, o r101, Float r102, Float r103, Float r104, Boolean r105, Boolean r106) {
        this.f410381a = r100;
        this.f410382b = r101;
        this.f410383c = r102;
        this.f410384d = r103;
        this.f410385e = r104;
        this.f410386f = r105;
        this.f410387g = r106;
    }
}
