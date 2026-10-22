package com.larus.bmhome.share.panel;

import com.larus.bmhome.share.ShareScene;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f313889a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Integer f313890b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f313891c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ShareScene f313892d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final h f313893e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final by7.e f313894f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final boolean f313895g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Function1<Continuation<? super g>, Object> f313896h;

    public e() {
        throw null;
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof e) == true) goto L8;
        return false;
    L8:
        e r101 = (e) r100;
        if (this.f313889a == r101.f313889a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f313890b, r101.f313890b) == true) goto L15;
        return false;
    L15:
        if (this.f313891c == r101.f313891c) goto L18;
        return false;
    L18:
        if (this.f313892d == r101.f313892d) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f313893e, r101.f313893e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f313894f, r101.f313894f) == true) goto L27;
        return false;
    L27:
        if (this.f313895g == r101.f313895g) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.f313896h, r101.f313896h) == true) goto L32;
        return false;
    L32:
        return true;
    }

    public final int hashCode() {
        int r100 = 1231;
        if (this.f313889a == false) goto L5;
        int r101 = 1231;
    L6:
        int r102 = r101 * 31;
        Integer r103 = this.f313890b;
        int r104 = 0;
        if (r103 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r102 + r105) * 31;
        if (this.f313891c == false) goto L13;
        int r107 = 1231;
    L14:
        int r108 = (((r106 + r107) * 31) + this.f313892d.hashCode()) * 31;
        h r109 = this.f313893e;
        if (r109 != null) goto L17;
        int r110 = 0;
    L18:
        int r111 = (r108 + r110) * 31;
        by7.e r112 = this.f313894f;
        if (r112 == null) goto L22;
        r104 = r112.hashCode();
    L22:
        int r113 = (r111 + r104) * 31;
        if (this.f313895g == true) goto L27;
        r100 = 1237;
    L27:
        return ((r113 + r100) * 31) + this.f313896h.hashCode();
    L17:
        r110 = r109.hashCode();
        goto L18
    L13:
        r107 = 1237;
        goto L14
    L9:
        r105 = r103.hashCode();
        goto L10
    L5:
        r101 = 1237;
        goto L6
    }

    public final String toString() {
        return "LongImageShareParams(isImmersive=" + this.f313889a + ", immersiveBgColor=" + this.f313890b + ", autoDismiss=" + this.f313891c + ", shareScene=" + this.f313892d + ", eventParam=" + this.f313893e + ", trackNode=" + this.f313894f + ", needChangeShareContent=" + this.f313895g + ", newShareDataGetter=" + this.f313896h + ')';
    }

    public e(boolean r100, Integer r101, h r102, by7.e r103, boolean r104, Function1 r105, int r110) {
        if ((r110 & 2) == 0) goto L6;
        r101 = null;
    L6:
        if ((r110 & 8) == 0) goto L8;
        ShareScene r106 = ShareScene.SHOW_LONG_IMAGE;
    L10:
        if ((r110 & 16) == 0) goto L13;
        r102 = null;
    L13:
        if ((r110 & 32) == 0) goto L16;
        r103 = null;
    L16:
        if ((r110 & 64) == 0) goto L19;
        r104 = false;
    L19:
        if ((r110 & 128) == 0) goto L21;
        r105 = new LongImageShareParams$1(null);
    L21:
        Intrinsics.checkNotNullParameter(r106, "shareScene");
        Intrinsics.checkNotNullParameter(r105, "newShareDataGetter");
        this.f313889a = r100;
        this.f313890b = r101;
        this.f313891c = true;
        this.f313892d = r106;
        this.f313893e = r102;
        this.f313894f = r103;
        this.f313895g = r104;
        this.f313896h = r105;
        return;
    L8:
        r106 = null;
        goto L10
    }
}
