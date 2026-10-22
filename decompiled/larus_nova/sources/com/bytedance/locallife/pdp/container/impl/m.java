package com.bytedance.locallife.pdp.container.impl;

import com.bytedance.locallife.pdp.settings.l0;
import com.ss.android.ugc.aweme.trade.goods.entity.PoiTradeSettingEntity;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
public final class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f261191a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f261192b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f261193c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final List<String> f261194d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f261195e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f261196f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final List<n> f261197g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final com.bytedance.locallife.pdp.container.view.lynx.k f261198h;

    public m() {
        this(0, null, false, false, null, null, 255);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof m) == true) goto L8;
        return false;
    L8:
        m r101 = (m) r100;
        if (this.f261191a == r101.f261191a) goto L12;
        return false;
    L12:
        if (this.f261192b == r101.f261192b) goto L15;
        return false;
    L15:
        if (this.f261193c == r101.f261193c) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f261194d, r101.f261194d) == true) goto L21;
        return false;
    L21:
        if (this.f261195e == r101.f261195e) goto L24;
        return false;
    L24:
        if (this.f261196f == r101.f261196f) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.f261197g, r101.f261197g) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.f261198h, r101.f261198h) == true) goto L32;
        return false;
    L32:
        return true;
    }

    public final int hashCode() {
        int r100 = 1231;
        if (this.f261191a == false) goto L5;
        int r101 = 1231;
    L6:
        int r102 = ((((r101 * 31) + this.f261192b) * 31) + this.f261193c) * 31;
        List<String> r103 = this.f261194d;
        int r104 = 0;
        if (r103 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r102 + r105) * 31;
        if (this.f261195e == false) goto L13;
        int r107 = 1231;
    L14:
        int r108 = (r106 + r107) * 31;
        if (this.f261196f == true) goto L18;
        r100 = 1237;
    L18:
        int r109 = (r108 + r100) * 31;
        List<n> r110 = this.f261197g;
        if (r110 == null) goto L23;
        r104 = r110.hashCode();
    L23:
        return ((r109 + r104) * 31) + this.f261198h.hashCode();
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
        return "PreloadManagerConfig(doLoadWhileDitoRequest=" + this.f261191a + ", preCreatedViewSizeWhenAsync=" + this.f261192b + ", preCreatedViewSizeWhenSync=" + this.f261193c + ", v1SchemaList=" + this.f261194d + ", cacheBizData=" + this.f261195e + ", enablePreloadOnPoi=" + this.f261196f + ", v2SchemaInfoList=" + this.f261197g + ", lynxLoadConfig=" + this.f261198h + ')';
    }

    public m(int r100, List r110, boolean r111, boolean r112, List r113, com.bytedance.locallife.pdp.container.view.lynx.k r114, int r115) {
        int r101 = 0;
        if ((r115 & 1) == 0) goto L11;
        PoiTradeSettingEntity r102 = l0.f261737a;
        if (r102 == null) goto L7;
        int r103 = r102.U();
    L9:
        if ((r103 & 1) == 0) goto L11;
        boolean r104 = true;
    L13:
        if ((r115 & 2) == 0) goto L16;
        r100 = 6;
    L16:
        if ((r115 & 4) == 0) goto L19;
        r101 = 4;
    L19:
        if ((r115 & 8) == 0) goto L22;
        r110 = null;
    L22:
        if ((r115 & 16) == 0) goto L25;
        r111 = true;
    L25:
        if ((r115 & 32) == 0) goto L28;
        r112 = true;
    L28:
        if ((r115 & 64) == 0) goto L31;
        r113 = null;
    L31:
        if ((r115 & 128) == 0) goto L33;
        r114 = new com.bytedance.locallife.pdp.container.view.lynx.k(null, null, null, null, 31);
    L33:
        Intrinsics.checkNotNullParameter(r114, "lynxLoadConfig");
        this.f261191a = r104;
        this.f261192b = r100;
        this.f261193c = r101;
        this.f261194d = r110;
        this.f261195e = r111;
        this.f261196f = r112;
        this.f261197g = r113;
        this.f261198h = r114;
        return;
    L7:
        r103 = 0;
    L11:
        r104 = false;
        goto L13
    }
}
