package com.larus.im.service.audio;

import android.content.Intent;
import com.larus.nova.R;
import com.ss.bytertc.base.media.screen.RXScreenCaptureService;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes30.dex */
public final class f1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f350744a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f350745b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f350746c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f350747d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Intent f350748e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f350749f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f350750g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final int f350751h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final boolean f350752i;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof f1) == true) goto L8;
        return false;
    L8:
        f1 r101 = (f1) r100;
        if (this.f350744a == r101.f350744a) goto L12;
        return false;
    L12:
        if (this.f350745b == r101.f350745b) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f350746c, r101.f350746c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f350747d, r101.f350747d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f350748e, r101.f350748e) == true) goto L24;
        return false;
    L24:
        if (this.f350749f == r101.f350749f) goto L27;
        return false;
    L27:
        if (this.f350750g == r101.f350750g) goto L30;
        return false;
    L30:
        if (this.f350751h == r101.f350751h) goto L33;
        return false;
    L33:
        if (this.f350752i == r101.f350752i) goto L35;
        return false;
    L35:
        return true;
    }

    public final int hashCode() {
        int r100 = ((((((((((((((this.f350744a * 31) + this.f350745b) * 31) + this.f350746c.hashCode()) * 31) + this.f350747d.hashCode()) * 31) + this.f350748e.hashCode()) * 31) + this.f350749f) * 31) + this.f350750g) * 31) + this.f350751h) * 31;
        if (this.f350752i == false) goto L5;
        int r101 = 1231;
    L7:
        return r100 + r101;
    L5:
        r101 = 1237;
        goto L7
    }

    public final String toString() {
        return "ScreenShareRtcConfig(bigIconResourceId=" + this.f350744a + ", smallIconResourceId=" + this.f350745b + ", activityCanonicalName=" + this.f350746c + ", contentText=" + this.f350747d + ", permissionResult=" + this.f350748e + ", encoderFrameRate=" + this.f350749f + ", encoderWidth=" + this.f350750g + ", encoderHeight=" + this.f350751h + ", needCheckToCallMode=" + this.f350752i + ')';
    }

    public f1(String r100, String r101, Intent r102, int r103, int r104, int r105, boolean r106) {
        Intrinsics.checkNotNullParameter(r100, "activityCanonicalName");
        Intrinsics.checkNotNullParameter(r101, RXScreenCaptureService.KEY_CONTENT_TEXT);
        Intrinsics.checkNotNullParameter(r102, "permissionResult");
        this.f350744a = R.drawable.larus_ic_screen_share;
        this.f350745b = R.drawable.larus_ic_screen_share;
        this.f350746c = r100;
        this.f350747d = r101;
        this.f350748e = r102;
        this.f350749f = r103;
        this.f350750g = r104;
        this.f350751h = r105;
        this.f350752i = r106;
    }
}
