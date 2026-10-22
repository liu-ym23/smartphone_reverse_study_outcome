package com.larus.home.impl.main.side_bar.view.adapter;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes29.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f344972a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f344973b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f344974c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f344975d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f344976e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Integer f344977f;

    public e() {
        this(0);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof e) == true) goto L8;
        return false;
    L8:
        e r101 = (e) r100;
        if (Intrinsics.areEqual(this.f344972a, r101.f344972a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f344973b, r101.f344973b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f344974c, r101.f344974c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f344975d, r101.f344975d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f344976e, r101.f344976e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f344977f, r101.f344977f) == true) goto L26;
        return false;
    L26:
        return true;
    }

    public final int hashCode() {
        String r100 = this.f344972a;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.f344973b;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.f344974c;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        String r110 = this.f344975d;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        String r113 = this.f344976e;
        if (r113 != null) goto L21;
        int r114 = 0;
    L22:
        int r115 = (r112 + r114) * 31;
        Integer r116 = this.f344977f;
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
        return "ItemMobInfo(showFrom=" + this.f344972a + ", botId=" + this.f344973b + ", isDeleteIcon=" + this.f344974c + ", isBlueHighlight=" + this.f344975d + ", noticeType=" + this.f344976e + ", noticeCnt=" + this.f344977f + ')';
    }

    public e(int r100) {
        this.f344972a = null;
        this.f344973b = null;
        this.f344974c = null;
        this.f344975d = null;
        this.f344976e = null;
        this.f344977f = null;
    }
}
