package com.bytedance.android.shopping.prepurchase.business.pdp.components.layer.pendent;

import android.view.View;
import com.bytedance.android.ec.model.ECUrlModel;
import com.bytedance.android.shopping.anchorv4.dto.base.ImageModel;
import com.bytedance.android.shopping.anchorv4.dto.business.HeadMoreVideo;
import com.bytedance.android.shopping.anchorv4.dto.business.VideoHolderItem;
import com.bytedance.android.shopping.anchorv4.voavhs.headv2.gallery.c0;
import com.bytedance.android.shopping.anchorv4.voavhs.headv2.gallery.q;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class f implements View.OnClickListener {
    public final /* synthetic */ MoreVideoComponent a;
    public final /* synthetic */ HeadMoreVideo b;

    public f(MoreVideoComponent r1, HeadMoreVideo r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r30) {
        MoreVideoComponent r1 = this.a;
        HeadMoreVideo r2 = this.b;
        r1.getClass();
        if (r2 == null) goto L5;
        Map r3 = r2.getTrack();
    L6:
        MoreVideoComponent.j2(r1, "pdp_module_click", r3);
        MoreVideoComponent r4 = this.a;
        HeadMoreVideo r5 = this.b;
        r4.getClass();
        ArrayList r6 = new ArrayList();
        Ref.IntRef r8 = new Ref.IntRef();
        int r7 = 0;
        r8.element = 0;
        ArrayList r14 = new ArrayList();
        List r9 = r5.getVideoHolderList();
        if (r9 == null) goto L24;
        Iterator r10 = r9.iterator();
    L10:
        if (r10.hasNext() == false) goto L24;
        Object r11 = r10.next();
        int r12 = r7 + 1;
        if (r7 >= 0) goto L14;
        CollectionsKt.throwIndexOverflow();
    L14:
        VideoHolderItem r13 = (VideoHolderItem) r11;
        if (r13.getVideo() == null) goto L23;
        ImageModel r15 = r13.getVideo().getPosterImage();
        if (r15 == null) goto L19;
        ECUrlModel r16 = r15.getRemote();
    L20:
        r6.add(new q(r16, null, null, new j(r13), null, null, null, r7, null, 0, null, true, 6006));
        r14.add(r13.getTabName());
        if (r7 != r5.getAnchorIndex()) goto L23;
        r8.element = r7;
        goto L23
    L19:
        r16 = null;
    L23:
        r7 = r12;
    L24:
        c0 r17 = new c0(0, r6.size(), "视频", "videos", r14);
        Iterator r18 = r6.iterator();
    L26:
        if (r18.hasNext() == false) goto L28;
        ((q) r18.next()).m = r17;
        goto L26
    L28:
        List r19 = CollectionsKt.listOf(r17);
        if (r6.isEmpty() == true) goto L38;
        r4.Z1(vg3.l.class, new MoreVideoComponent$openGallery$2(r6, r19, r30, r8, null));
        return;
    L38:
        return;
    L5:
        r3 = null;
        goto L6
    }
}
