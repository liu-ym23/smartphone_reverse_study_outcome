package com.larus.im.internal.network.link.impl.rtc;

import com.larus.media.MediaScene;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes30.dex */
public final class p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f349330a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f349331b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final RTCConnectionType f349332c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f349333d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f349334e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f349335f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f349336g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Boolean f349337h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final boolean f349338i;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof p) == true) goto L8;
        return false;
    L8:
        p r101 = (p) r100;
        if (Intrinsics.areEqual(this.f349330a, r101.f349330a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f349331b, r101.f349331b) == true) goto L15;
        return false;
    L15:
        if (this.f349332c == r101.f349332c) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f349333d, r101.f349333d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f349334e, r101.f349334e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f349335f, r101.f349335f) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.f349336g, r101.f349336g) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.f349337h, r101.f349337h) == true) goto L33;
        return false;
    L33:
        if (this.f349338i == r101.f349338i) goto L35;
        return false;
    L35:
        return true;
    }

    public final int hashCode() {
        String r100 = this.f349330a;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.f349331b;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (((r103 + r105) * 31) + this.f349332c.hashCode()) * 31;
        String r107 = this.f349333d;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        String r110 = this.f349334e;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        String r113 = this.f349335f;
        if (r113 != null) goto L21;
        int r114 = 0;
    L22:
        int r115 = (r112 + r114) * 31;
        String r116 = this.f349336g;
        if (r116 != null) goto L25;
        int r117 = 0;
    L26:
        int r118 = (r115 + r117) * 31;
        Boolean r119 = this.f349337h;
        if (r119 == null) goto L30;
        r101 = r119.hashCode();
    L30:
        int r120 = (r118 + r101) * 31;
        if (this.f349338i == false) goto L33;
        int r121 = 1231;
    L35:
        return r120 + r121;
    L33:
        r121 = 1237;
        goto L35
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
        return "RTCSessionInitConfig(rtcUserId=" + this.f349330a + ", ppe=" + this.f349331b + ", connectionType=" + this.f349332c + ", business=" + this.f349333d + ", subBusiness=" + this.f349334e + ", streamApp=" + this.f349335f + ", rtcAppId=" + this.f349336g + ", enableUplinkBurstMode=" + this.f349337h + ", enableAudioEncodeStereo=" + this.f349338i + ')';
    }

    public final boolean a() {
        return Intrinsics.areEqual(this.f349333d, MediaScene.DORA);
    }

    public p(String r100, String r101, RTCConnectionType r102, String r103, String r104, String r105, String r106, Boolean r107, boolean r110) {
        Intrinsics.checkNotNullParameter(r102, "connectionType");
        this.f349330a = r100;
        this.f349331b = r101;
        this.f349332c = r102;
        this.f349333d = r103;
        this.f349334e = r104;
        this.f349335f = r105;
        this.f349336g = r106;
        this.f349337h = r107;
        this.f349338i = r110;
    }
}
