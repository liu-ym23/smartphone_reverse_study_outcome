package com.ss.android.lark.biz.im.api.message.params;

import android.graphics.drawable.Drawable;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes34.dex */
public final class j implements l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f410355a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f410356b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f410357c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f410358d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Drawable f410359e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f410360f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Integer f410361g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Integer f410362h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final boolean f410363i;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof j) == true) goto L8;
        return false;
    L8:
        j r101 = (j) r100;
        if (this.f410355a == r101.f410355a) goto L12;
        return false;
    L12:
        if (this.f410356b == r101.f410356b) goto L15;
        return false;
    L15:
        if (this.f410357c == r101.f410357c) goto L18;
        return false;
    L18:
        if (this.f410358d == r101.f410358d) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f410359e, r101.f410359e) == true) goto L24;
        return false;
    L24:
        if (this.f410360f == r101.f410360f) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.f410361g, r101.f410361g) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.f410362h, r101.f410362h) == true) goto L33;
        return false;
    L33:
        if (this.f410363i == r101.f410363i) goto L35;
        return false;
    L35:
        return true;
    }

    public final int hashCode() {
        int r100 = 1231;
        if (this.f410355a == false) goto L5;
        int r101 = 1231;
    L6:
        int r102 = r101 * 31;
        if (this.f410356b == false) goto L9;
        int r103 = 1231;
    L10:
        int r104 = (((r102 + r103) * 31) + this.f410357c) * 31;
        if (this.f410358d == false) goto L13;
        int r105 = 1231;
    L14:
        int r106 = (r104 + r105) * 31;
        Drawable r107 = this.f410359e;
        int r108 = 0;
        if (r107 != null) goto L17;
        int r109 = 0;
    L18:
        int r110 = (r106 + r109) * 31;
        if (this.f410360f == false) goto L21;
        int r111 = 1231;
    L22:
        int r112 = (r110 + r111) * 31;
        Integer r113 = this.f410361g;
        if (r113 != null) goto L25;
        int r114 = 0;
    L26:
        int r115 = (r112 + r114) * 31;
        Integer r116 = this.f410362h;
        if (r116 == null) goto L30;
        r108 = r116.hashCode();
    L30:
        int r117 = (r115 + r108) * 31;
        if (this.f410363i == true) goto L35;
        r100 = 1237;
    L35:
        return r117 + r100;
    L25:
        r114 = r113.hashCode();
        goto L26
    L21:
        r111 = 1237;
        goto L22
    L17:
        r109 = r107.hashCode();
        goto L18
    L13:
        r105 = 1237;
        goto L14
    L9:
        r103 = 1237;
        goto L10
    L5:
        r101 = 1237;
        goto L6
    }

    public final String toString() {
        return "MediaContentBlockParam(disablePlayView=" + this.f410355a + ", disableDurationIcon=" + this.f410356b + ", durationMarginEnd=" + this.f410357c + ", showDurationShadow=" + this.f410358d + ", durationShadowDrawable=" + this.f410359e + ", disableShowToastWhenClick=" + this.f410360f + ", borderColor=" + this.f410361g + ", borderStrokeWidthDp=" + this.f410362h + ", enableLoadingView=" + this.f410363i + ')';
    }

    public /* synthetic */ j(int r100, sgb.a r110, Integer r111, Integer r112) {
        this(r100, true, r110, true, r111, r112, false);
    }

    public j(int r100, boolean r101, Drawable r102, boolean r103, Integer r104, Integer r105, boolean r106) {
        this.f410355a = true;
        this.f410356b = true;
        this.f410357c = r100;
        this.f410358d = r101;
        this.f410359e = r102;
        this.f410360f = r103;
        this.f410361g = r104;
        this.f410362h = r105;
        this.f410363i = r106;
    }
}
