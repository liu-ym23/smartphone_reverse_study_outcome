package com.bytedance.ee.bear.document.feed;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
public final class p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f219881a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f219882b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f219883c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f219884d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f219885e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f219886f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Long f219887g;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof p) == true) goto L8;
        return false;
    L8:
        p r101 = (p) r100;
        if (Intrinsics.areEqual(this.f219881a, r101.f219881a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f219882b, r101.f219882b) == true) goto L15;
        return false;
    L15:
        if (this.f219883c == r101.f219883c) goto L18;
        return false;
    L18:
        if (this.f219884d == r101.f219884d) goto L21;
        return false;
    L21:
        if (this.f219885e == r101.f219885e) goto L24;
        return false;
    L24:
        if (this.f219886f == r101.f219886f) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.f219887g, r101.f219887g) == true) goto L29;
        return false;
    L29:
        return true;
    }

    public final int hashCode() {
        String r100 = this.f219881a;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.f219882b;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        int r107 = 1231;
        if (this.f219883c == false) goto L13;
        int r108 = 1231;
    L14:
        int r109 = (r106 + r108) * 31;
        if (this.f219884d == false) goto L17;
        int r110 = 1231;
    L18:
        int r111 = (r109 + r110) * 31;
        if (this.f219885e == false) goto L21;
        int r112 = 1231;
    L22:
        int r113 = (r111 + r112) * 31;
        if (this.f219886f == true) goto L26;
        r107 = 1237;
    L26:
        int r114 = (r113 + r107) * 31;
        Long r115 = this.f219887g;
        if (r115 == null) goto L31;
        r101 = r115.hashCode();
    L31:
        return r114 + r101;
    L21:
        r112 = 1237;
        goto L22
    L17:
        r110 = 1237;
        goto L18
    L13:
        r108 = 1237;
        goto L14
    L9:
        r105 = r104.hashCode();
        goto L10
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "JsConfig2MsgConfigParams(token=" + this.f219881a + ", type=" + this.f219882b + ", owner=" + this.f219883c + ", auto=" + this.f219884d + ", supportMute=" + this.f219885e + ", supportReadAll=" + this.f219886f + ", filterTimeStamp=" + this.f219887g + ')';
    }

    public final String getType() {
        return this.f219882b;
    }

    public p(String r100, String r101, boolean r102, boolean r103, Long r104) {
        this.f219881a = r100;
        this.f219882b = r101;
        this.f219883c = r102;
        this.f219884d = r103;
        this.f219885e = true;
        this.f219886f = true;
        this.f219887g = r104;
    }
}
