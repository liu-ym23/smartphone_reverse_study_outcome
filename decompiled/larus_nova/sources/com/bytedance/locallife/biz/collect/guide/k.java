package com.bytedance.locallife.biz.collect.guide;

import android.view.View;
import com.bytedance.locallife.cube.api.i.IPoiLynxKitDelegate;
import com.bytedance.locallife.dito.data.DitoPage;
import com.lynx.tasm.LynxView;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
public final class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f256606a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f256607b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f256608c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final DitoPage f256609d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final IPoiLynxKitDelegate f256610e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final View f256611f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final LynxView f256612g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Map<String, Object> f256613h;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof k) == true) goto L8;
        return false;
    L8:
        k r101 = (k) r100;
        if (Intrinsics.areEqual(this.f256606a, r101.f256606a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f256607b, r101.f256607b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f256608c, r101.f256608c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f256609d, r101.f256609d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f256610e, r101.f256610e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f256611f, r101.f256611f) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.f256612g, r101.f256612g) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.f256613h, r101.f256613h) == true) goto L32;
        return false;
    L32:
        return true;
    }

    public final int hashCode() {
        String r100 = this.f256606a;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.f256607b;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (((r103 + r105) * 31) + this.f256608c.hashCode()) * 31;
        DitoPage r107 = this.f256609d;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        IPoiLynxKitDelegate r110 = this.f256610e;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        View r113 = this.f256611f;
        if (r113 != null) goto L21;
        int r114 = 0;
    L22:
        int r115 = (r112 + r114) * 31;
        LynxView r116 = this.f256612g;
        if (r116 != null) goto L25;
        int r117 = 0;
    L26:
        int r118 = (r115 + r117) * 31;
        Map<String, Object> r119 = this.f256613h;
        if (r119 == null) goto L31;
        r101 = r119.hashCode();
    L31:
        return r118 + r101;
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
        return "GoodsDetailViewWrapper(traceSessionId=" + this.f256606a + ", productId=" + this.f256607b + ", pageUrlBundle=" + this.f256608c + ", ditoData=" + this.f256609d + ", lynxDelegate=" + this.f256610e + ", rootContainerView=" + this.f256611f + ", lynxView=" + this.f256612g + ", passParamMap=" + this.f256613h + ')';
    }

    public k(String r100, String r101, String r102, DitoPage r103, IPoiLynxKitDelegate r104, View r105, LynxView r106, Map<String, ? extends Object> r107) {
        Intrinsics.checkNotNullParameter(r102, "pageUrlBundle");
        this.f256606a = r100;
        this.f256607b = r101;
        this.f256608c = r102;
        this.f256609d = r103;
        this.f256610e = r104;
        this.f256611f = r105;
        this.f256612g = r106;
        this.f256613h = r107;
    }
}
