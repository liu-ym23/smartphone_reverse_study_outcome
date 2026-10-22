package com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability;

import com.bytedance.android.shopping.anchorv4.dto.base.VideoModel;
import com.bytedance.android.shopping.anchorv4.voavhs.headv2.AnchorV4HeadV2VO;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class i extends com.bytedance.android.ec.core.anchorv3.q {
    public final /* synthetic */ e e;
    public final /* synthetic */ int f;

    public final void c() {
        AnchorV4HeadV2VO r0 = this.e.e;
        if (r0 == null) goto L5;
        VideoModel r1 = AnchorV4HeadV2VO.getVideoData$default(r0, this.f, null, 2, null);
    L6:
        if (r1 == null) goto L16;
        a r2 = this.e.i;
        r2.getClass();
        if (com.bytedance.android.shopping.anchorv4.voavhs.headv2.gallery.i.c() == true) goto L10;
    L12:
        boolean r3 = false;
    L13:
        if (r3 == true) goto L17;
        r2.j(null);
        return;
    L17:
        return;
    L10:
        if (r2.b.a() == false) goto L12;
        r3 = true;
        goto L13
    L16:
        return;
    L5:
        r1 = null;
        goto L6
    }

    public i(e r1, int r2) {
        this.e = r1;
        this.f = r2;
        super(3);
    }
}
