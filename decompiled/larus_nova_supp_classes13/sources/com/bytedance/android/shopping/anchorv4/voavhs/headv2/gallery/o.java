package com.bytedance.android.shopping.anchorv4.voavhs.headv2.gallery;

import com.bytedance.android.ec.model.ECUrlModel;
import com.bytedance.android.shopping.anchorv4.dto.business.GalleryConfig;
import com.bytedance.android.shopping.anchorv4.dto.business.GalleryVO;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class o implements com.bytedance.android.shopping.anchorv4.components.n {
    public final /* synthetic */ GalleryFragment a;

    public final boolean a() {
        return true;
    }

    public final String c() {
        return null;
    }

    public final Boolean b() {
        GalleryFragment r0 = this.a;
        int r1 = r0.h;
        Integer r2 = GalleryFragment.M;
        q r3 = r0.fa0(r1);
        if (r3 == null) goto L10;
        GalleryFragment.N.getClass();
        Integer r4 = GalleryFragment.b.a(r3);
        if (r4 == null) goto L10;
        if (r4.intValue() != 2) goto L10;
        boolean r5 = true;
    L12:
        return Boolean.valueOf(r5);
    L10:
        r5 = false;
        goto L12
    }

    public final String d() {
        GalleryFragment r0 = this.a;
        int r1 = r0.h;
        Integer r2 = GalleryFragment.M;
        q r3 = r0.fa0(r1);
        String r4 = null;
        if (r3 == null) goto L47;
        boolean r5 = false;
        if (r3.i != null) goto L7;
        boolean r6 = true;
    L8:
        if (r6 != true) goto L52;
        GalleryFragment.N.getClass();
        Integer r7 = GalleryFragment.b.a(r3);
        if (r7 != null) goto L14;
    L22:
        String r8 = r3.f;
        if (r8 != null) goto L46;
        GalleryVO r9 = this.a.K.s0();
        if (r9 == null) goto L48;
        com.bytedance.android.shopping.anchorv4.dto.business.b r10 = r9.getMeta();
        if (r10 == null) goto L49;
        r8 = r10.b();
        if (r8 != null) goto L31;
        return null;
    L31:
        if (r3.i == null) goto L33;
    L35:
        if (r5 == false) goto L40;
        ECUrlModel r11 = r3.a;
        if (r11 == null) goto L40;
        r4 = r11.getFirstUrl();
    L40:
        if (com.bytedance.android.shopping.extensions.k.c(r4) == false) goto L46;
        int r12 = com.bytedance.android.ec.core.utils.p0.a;
        if (r4 != null) goto L51;
        r4 = "";
    L51:
        return com.bytedance.android.ec.core.utils.p0.d(r8, "search_image_url", r4);
    L33:
        if (r3.d != null) goto L35;
        r5 = true;
        goto L35
    L49:
        return null;
    L48:
        return null;
    L46:
        return r8;
    L14:
        if (r7.intValue() != 2) goto L22;
        GalleryVO r13 = this.a.K.s0();
        if (r13 == null) goto L22;
        GalleryConfig r14 = r13.getConfig();
        if (r14 == null) goto L22;
        if (r14.getScreenShotHideVideo() != true) goto L22;
        return null;
    L52:
        return null;
    L7:
        r6 = false;
        goto L8
    L47:
        return null;
    }

    public o(GalleryFragment r1) {
        this.a = r1;
    }
}
