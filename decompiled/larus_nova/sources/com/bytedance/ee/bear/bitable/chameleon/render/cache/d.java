package com.bytedance.ee.bear.bitable.chameleon.render.cache;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final c f209702a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f209703b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f209704c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f209705d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f209706e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Boolean f209707f;

    public d() {
        this(null, null, null, null, null, null, 63);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof d) == true) goto L8;
        return false;
    L8:
        d r101 = (d) r100;
        if (Intrinsics.areEqual(this.f209702a, r101.f209702a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f209703b, r101.f209703b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f209704c, r101.f209704c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f209705d, r101.f209705d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f209706e, r101.f209706e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f209707f, r101.f209707f) == true) goto L26;
        return false;
    L26:
        return true;
    }

    public final int hashCode() {
        c r100 = this.f209702a;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.f209703b;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.f209704c;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        String r110 = this.f209705d;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        String r113 = this.f209706e;
        if (r113 != null) goto L21;
        int r114 = 0;
    L22:
        int r115 = (r112 + r114) * 31;
        Boolean r116 = this.f209707f;
        if (r116 == null) goto L27;
        r101 = r116.hashCode();
    L27:
        return r115 + r101;
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
        return "BitableCacheLoadResult(firstBlock=" + this.f209702a + ", cacheClientVars=" + this.f209703b + ", mainPage=" + this.f209704c + ", recordData=" + this.f209705d + ", addRecordPage=" + this.f209706e + ", nativeLocalCSReady=" + this.f209707f + ')';
    }

    public d(c r100, String r101, String r102, String r103, String r104, Boolean r105, int r106) {
        if ((r106 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r106 & 2) == 0) goto L9;
        r101 = null;
    L9:
        if ((r106 & 4) == 0) goto L12;
        r102 = null;
    L12:
        if ((r106 & 8) == 0) goto L15;
        r103 = null;
    L15:
        if ((r106 & 16) == 0) goto L18;
        r104 = null;
    L18:
        if ((r106 & 32) == 0) goto L20;
        r105 = null;
    L20:
        this.f209702a = r100;
        this.f209703b = r101;
        this.f209704c = r102;
        this.f209705d = r103;
        this.f209706e = r104;
        this.f209707f = r105;
    }
}
