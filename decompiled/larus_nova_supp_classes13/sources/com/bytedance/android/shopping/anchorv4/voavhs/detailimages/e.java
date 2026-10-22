package com.bytedance.android.shopping.anchorv4.voavhs.detailimages;

import android.view.View;
import com.bytedance.android.ec.model.ECUrlModel;
import com.facebook.drawee.view.SimpleDraweeView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class e implements View.OnClickListener {
    public final /* synthetic */ AnchorV4DetailImageView a;
    public final /* synthetic */ com.bytedance.android.shopping.anchorv4.voavhs.car.f b;
    public final /* synthetic */ d c;

    public e(AnchorV4DetailImageView r1, com.bytedance.android.shopping.anchorv4.voavhs.car.f r2, d r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r11) {
        com.bytedance.android.shopping.anchorv4.voavhs.car.f r0 = this.b;
        d r2 = this.c;
        List<String> r3 = r2.g;
        if (r3 == null) goto L5;
        String r4 = (String) CollectionsKt.getOrNull(r3, r2.c);
    L6:
        com.bytedance.android.shopping.anchorv4.voavhs.car.f.a.a(r0, "pd_picture_click", MapsKt.mapOf(TuplesKt.to("pic_type", r4)), false, null, null, null, null, 252);
        SimpleDraweeView r1 = this.a;
        d r5 = this.c;
        ECUrlModel r6 = r5.b;
        List<ECUrlModel> r7 = r5.f;
        int r8 = r5.c;
        int r9 = AnchorV4DetailImageView.b;
        r1.getClass();
        if (r7 == null) goto L16;
        AnchorV4DetailImageGalleryViewer r10 = new AnchorV4DetailImageGalleryViewer(r1.getContext());
        r10.c.a = 2;
        ArrayList r12 = new ArrayList();
        Iterator<T> r13 = r7.iterator();
    L11:
        if (r13.hasNext() == false) goto L13;
        ECUrlModel r14 = (ECUrlModel) r13.next();
        int r15 = com.bytedance.android.ec.model.k.n;
        r12.add(com.bytedance.android.ec.model.k.a.a(r14, false, null, null));
        goto L11
    L13:
        Unit r16 = Unit.INSTANCE;
        r10.a(r12, false);
        r10.showAnimated(r8, r11);
        return;
    L16:
        return;
    L5:
        r4 = null;
        goto L6
    }
}
