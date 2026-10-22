package com.bytedance.android.shopping.anchorv4.voavhs.headv2.gallery;

import androidx.fragment.app.FragmentActivity;
import com.bytedance.android.ecom.arch.slice.action.SlcCommonAction;
import com.bytedance.android.shopping.anchorv4.dto.business.GalleryBottom;
import com.bytedance.android.shopping.anchorv4.dto.business.GalleryBottomConfig;
import com.bytedance.android.shopping.anchorv4.dto.business.GalleryPendants;
import com.bytedance.android.shopping.anchorv4.dto.business.GallerySliceVisibilityConfig;
import com.bytedance.android.shopping.anchorv4.dto.business.GalleryVO;
import com.bytedance.kmp.ec.yata.chain.core.EventChain;
import java.util.List;
import java.util.Map;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class w0 {
    public static final /* synthetic */ int k = 0;
    public final v0 a;
    public c b;
    public x0 c;
    public t0 d;
    public GalleryVO e;
    public String f;
    public final FragmentActivity g;
    public final GalleryLayerItemStateManager h;
    public final l i;
    public final l0 j;

    public static final class a {
    }

    static {
    }

    public final void b(GalleryVO r12) {
        if (this.e != null) goto L5;
        boolean r0 = true;
    L6:
        this.e = r12;
        c r2 = this.b;
        x0 r3 = null;
        if (r2 == null) goto L16;
        if (r12 == null) goto L10;
        GalleryBottom r4 = r12.getBottom();
    L11:
        com.bytedance.android.shopping.anchorv4.helper.n r5 = r2.b;
        if (r4 == null) goto L14;
        List r6 = r4.getSlices();
    L15:
        r5.a(r6, r2.c);
        goto L16
    L14:
        r6 = null;
        goto L15
    L10:
        r4 = null;
    L16:
        l r7 = this.i;
        if (r7 != null) goto L19;
    L30:
        x0 r13 = this.c;
        if (r13 == null) goto L35;
        GalleryLayerItemStateManager r1 = this.h;
        if (r1 == null) goto L35;
        r1.h(r13);
    L35:
        c r14 = this.b;
        if (r14 == null) goto L50;
        GalleryVO r8 = this.e;
        if (r8 == null) goto L50;
        GalleryBottom r9 = r8.getBottom();
        if (r9 == null) goto L50;
        GalleryBottomConfig r10 = r9.getConfig();
        if (r10 == null) goto L50;
        Map r11 = r10.getVisibility();
        if (r11 == null) goto L50;
        GallerySliceVisibilityConfig r15 = (GallerySliceVisibilityConfig) r11.get("bottom");
        if (r15 == null) goto L50;
        r3 = new x0(this, r15, r14.a, new m0(false, true, false, r15.getAnimType(), false, 52));
    L50:
        if (r3 == null) goto L54;
        this.c = r3;
        GalleryLayerItemStateManager r16 = this.h;
        if (r16 == null) goto L54;
        r16.c(r3);
    L54:
        if (r0 == false) goto L60;
        String r17 = this.j.a();
        if (r17 != null) goto L58;
        r17 = "";
    L58:
        c(r17);
        return;
    L60:
        return;
    L19:
        if (r7.a() != true) goto L30;
        t0 r18 = this.d;
        if (r18 == null) goto L30;
        if (r12 == null) goto L24;
        GalleryPendants r19 = r12.getPendants();
    L25:
        com.bytedance.android.shopping.anchorv4.helper.n r20 = r18.b;
        if (r19 == null) goto L28;
        List r110 = r19.getSlices();
    L29:
        int r21 = com.bytedance.android.shopping.anchorv4.helper.n.f;
        r20.a(r110, null);
        goto L30
    L28:
        r110 = null;
        goto L29
    L24:
        r19 = null;
        goto L25
    L5:
        r0 = false;
        goto L6
    }

    public final void c(String r12) {
        if (Intrinsics.areEqual(this.f, r12) == false) goto L5;
        return;
    L5:
        this.f = r12;
        int r0 = fi3.c0.e;
        SlcCommonAction r6 = fi3.c0.a.a("gallery_sku_preview", MapsKt.mapOf(TuplesKt.to("spec_id", r12)), null, 10);
        int r13 = com.bytedance.android.shopping.anchorv4.event_chain.c.a;
        l r14 = this.i;
        if (r14 == null) goto L8;
        EventChain r3 = r14.l;
    L9:
        com.bytedance.android.shopping.anchorv4.event_chain.c.a(r3, null, this.a.a, r6, null, null, null, new com.bytedance.android.ecom.arch.slice.action.c(null, null));
        return;
    L8:
        r3 = null;
        goto L9
    }

    public static final boolean a(w0 r1, GallerySliceVisibilityConfig r2, int r3) {
        r1.getClass();
        List r4 = r2.getShow();
        if (r4 != null) goto L5;
    L7:
        List r5 = r2.getHide();
        if (r5 != null) goto L10;
        return true;
    L10:
        if ((!r5.isEmpty()) == true) goto L12;
        return true;
    L12:
        if (r2.getHide().contains(Integer.valueOf(r3)) == false) goto L19;
        return false;
    L19:
        return true;
    L5:
        if ((!r4.isEmpty()) != true) goto L7;
        return r2.getShow().contains(Integer.valueOf(r3));
    }

    public w0(FragmentActivity r2, GalleryLayerItemStateManager r3, l r4, GalleryFragment.k r5) {
        Intrinsics.checkNotNullParameter(r2, "activity");
        Intrinsics.checkNotNullParameter(r5, "callback");
        this.g = r2;
        this.h = r3;
        this.i = r4;
        this.j = r5;
        this.a = new v0(r2, r5, r5.d(), r4);
    }
}
