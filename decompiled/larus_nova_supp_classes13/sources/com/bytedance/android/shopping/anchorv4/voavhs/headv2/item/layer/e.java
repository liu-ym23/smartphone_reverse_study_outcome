package com.bytedance.android.shopping.anchorv4.voavhs.headv2.item.layer;

import com.bytedance.android.ec.core.anchorv3.q;
import com.bytedance.android.shopping.anchorv4.dto.base.VideoModel;
import com.bytedance.android.shopping.anchorv4.voavhs.headv2.AnchorV4HeadV2VO;
import com.bytedance.android.shopping.anchorv4.voavhs.headv2.HeaderMediaModel;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class e extends q {
    public final /* synthetic */ ItemMediaLayer e;
    public final /* synthetic */ int f;
    public final /* synthetic */ Integer g;
    public final /* synthetic */ HeaderMediaModel h;

    public final void c() {
        ItemMediaLayer r0 = this.e;
        int r1 = this.f;
        Integer r2 = r0.a;
        if (r2 != null) goto L6;
    L8:
        boolean r3 = false;
    L9:
        if (r3 == false) goto L21;
        AnchorV4HeadV2VO r4 = this.e.k.K10();
        if (r4 == null) goto L17;
        int r5 = this.f;
        Integer r6 = this.g;
        if (r6 == null) goto L15;
        int r7 = r6.intValue();
    L16:
        VideoModel r8 = r4.getVideoData(r5, Integer.valueOf(r7));
    L18:
        if (r8 == null) goto L22;
        this.e.b(this.h, this.f, this.g);
        return;
    L22:
        return;
    L15:
        r7 = -1;
        goto L16
    L17:
        r8 = null;
        goto L18
    L21:
        return;
    L6:
        if (r1 != r2.intValue()) goto L8;
        r3 = true;
        goto L9
    }

    public e(ItemMediaLayer r1, int r2, Integer r3, HeaderMediaModel r4) {
        this.e = r1;
        this.f = r2;
        this.g = r3;
        this.h = r4;
        super(3);
    }
}
