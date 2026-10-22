package com.bytedance.locallife.pdp.container;

import android.net.Uri;
import android.view.View;
import com.bytedance.locallife.dito.core.DitoInteractDialogFragment;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
public final class y {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f261362a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f261363b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f261364c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Uri f261365d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final com.bytedance.locallife.pdp.c<View> f261366e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final DitoInteractDialogFragment f261367f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final com.bytedance.locallife.pdp.a f261368g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final String f261369h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Boolean f261370i;

    public y() {
        throw null;
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof y) == true) goto L8;
        return false;
    L8:
        y r101 = (y) r100;
        if (this.f261362a == r101.f261362a) goto L12;
        return false;
    L12:
        if (this.f261363b == r101.f261363b) goto L15;
        return false;
    L15:
        if (this.f261364c == r101.f261364c) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f261365d, r101.f261365d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f261366e, r101.f261366e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f261367f, r101.f261367f) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.f261368g, r101.f261368g) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.f261369h, r101.f261369h) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.f261370i, r101.f261370i) == true) goto L35;
        return false;
    L35:
        return true;
    }

    public final int hashCode() {
        long r100 = this.f261362a;
        int r101 = ((int) (r100 ^ (r100 >>> 32))) * 31;
        int r102 = 1231;
        if (this.f261363b == false) goto L5;
        int r103 = 1231;
    L6:
        int r104 = (r101 + r103) * 31;
        if (this.f261364c == true) goto L10;
        r102 = 1237;
    L10:
        int r105 = (r104 + r102) * 31;
        Uri r106 = this.f261365d;
        int r107 = 0;
        if (r106 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r105 + r108) * 31;
        com.bytedance.locallife.pdp.c<View> r110 = this.f261366e;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        DitoInteractDialogFragment r113 = this.f261367f;
        if (r113 != null) goto L21;
        int r114 = 0;
    L22:
        int r115 = (r112 + r114) * 31;
        com.bytedance.locallife.pdp.a r116 = this.f261368g;
        if (r116 != null) goto L25;
        int r117 = 0;
    L26:
        int r118 = (r115 + r117) * 31;
        String r119 = this.f261369h;
        if (r119 != null) goto L29;
        int r120 = 0;
    L30:
        int r121 = (r118 + r120) * 31;
        Boolean r122 = this.f261370i;
        if (r122 == null) goto L35;
        r107 = r122.hashCode();
    L35:
        return r121 + r107;
    L29:
        r120 = r119.hashCode();
        goto L30
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
        r108 = r106.hashCode();
        goto L14
    L5:
        r103 = 1237;
        goto L6
    }

    public final String toString() {
        return "GoodsDetailFragmentBuildParams(launchTimestamps=" + this.f261362a + ", isFull=" + this.f261363b + ", includeFullPageInCoordinatorLayout=" + this.f261364c + ", passParams=" + this.f261365d + ", behaviorProvider=" + this.f261366e + ", dialogFragment=" + this.f261367f + ", pageContainer=" + this.f261368g + ", sessionId=" + this.f261369h + ", isSplitPage=" + this.f261370i + ')';
    }

    public y(long r100, boolean r101, boolean r102, Uri r103, com.bytedance.locallife.pdp.c r104, DitoInteractDialogFragment r105, com.bytedance.locallife.pdp.a r110, String r111, int r112) {
        Boolean r106 = null;
        if ((r112 & 8) == 0) goto L6;
        r103 = null;
    L6:
        if ((r112 & 16) == 0) goto L9;
        r104 = null;
    L9:
        if ((r112 & 32) == 0) goto L12;
        r105 = null;
    L12:
        if ((r112 & 64) == 0) goto L15;
        r110 = null;
    L15:
        if ((r112 & 128) == 0) goto L18;
        r111 = null;
    L18:
        if ((r112 & 256) == 0) goto L20;
        r106 = Boolean.FALSE;
    L20:
        this.f261362a = r100;
        this.f261363b = r101;
        this.f261364c = r102;
        this.f261365d = r103;
        this.f261366e = r104;
        this.f261367f = r105;
        this.f261368g = r110;
        this.f261369h = r111;
        this.f261370i = r106;
    }
}
