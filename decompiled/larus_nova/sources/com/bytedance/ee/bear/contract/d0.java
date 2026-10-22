package com.bytedance.ee.bear.contract;

import android.content.Context;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
public final class d0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f216956a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f216957b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f216958c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f216959d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f216960e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f216961f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f216962g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final String f216963h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final boolean f216964i;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof d0) == true) goto L8;
        return false;
    L8:
        d0 r101 = (d0) r100;
        if (Intrinsics.areEqual(this.f216956a, r101.f216956a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f216957b, r101.f216957b) == true) goto L15;
        return false;
    L15:
        if (this.f216958c == r101.f216958c) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f216959d, r101.f216959d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f216960e, r101.f216960e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f216961f, r101.f216961f) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.f216962g, r101.f216962g) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.f216963h, r101.f216963h) == true) goto L33;
        return false;
    L33:
        if (this.f216964i == r101.f216964i) goto L35;
        return false;
    L35:
        return true;
    }

    public final int hashCode() {
        Context r100 = this.f216956a;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.f216957b;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (((r103 + r105) * 31) + this.f216958c) * 31;
        String r107 = this.f216959d;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        String r110 = this.f216960e;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        String r113 = this.f216961f;
        if (r113 != null) goto L21;
        int r114 = 0;
    L22:
        int r115 = (r112 + r114) * 31;
        String r116 = this.f216962g;
        if (r116 != null) goto L25;
        int r117 = 0;
    L26:
        int r118 = (r115 + r117) * 31;
        String r119 = this.f216963h;
        if (r119 == null) goto L30;
        r101 = r119.hashCode();
    L30:
        int r120 = (r118 + r101) * 31;
        if (this.f216964i == false) goto L33;
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
        return "ListMakeCopyBean(context=" + this.f216956a + ", objToken=" + this.f216957b + ", type=" + this.f216958c + ", subType=" + this.f216959d + ", parentToken=" + this.f216960e + ", title=" + this.f216961f + ", module=" + this.f216962g + ", source=" + this.f216963h + ", isSpaceV2=" + this.f216964i + ')';
    }

    public final Context getContext() {
        return this.f216956a;
    }

    public final int getType() {
        return this.f216958c;
    }

    public d0(Context r100, String r101, int r102, String r103, String r104, String r105, String r106, String r107, boolean r108) {
        this.f216956a = r100;
        this.f216957b = r101;
        this.f216958c = r102;
        this.f216959d = r103;
        this.f216960e = r104;
        this.f216961f = r105;
        this.f216962g = r106;
        this.f216963h = r107;
        this.f216964i = r108;
    }
}
