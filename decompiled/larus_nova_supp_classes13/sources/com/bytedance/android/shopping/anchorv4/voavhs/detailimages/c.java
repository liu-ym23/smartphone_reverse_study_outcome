package com.bytedance.android.shopping.anchorv4.voavhs.detailimages;

import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.bytedance.android.ec.model.ECUrlModel;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class c implements View.OnClickListener {
    public final /* synthetic */ AnchorV4DetailImageMoreInfoView a;
    public final /* synthetic */ com.bytedance.android.shopping.anchorv4.voavhs.car.f b;
    public final /* synthetic */ d c;

    public c(AnchorV4DetailImageMoreInfoView r1, com.bytedance.android.shopping.anchorv4.voavhs.car.f r2, d r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r11) {
        com.bytedance.android.shopping.anchorv4.voavhs.car.f r0 = this.b;
        d r12 = this.c;
        List<String> r2 = r12.g;
        if (r2 == null) goto L5;
        String r13 = (String) CollectionsKt.getOrNull(r2, r12.c);
    L6:
        com.bytedance.android.shopping.anchorv4.voavhs.car.f.a.a(r0, "pd_picture_click", MapsKt.mapOf(TuplesKt.to("pic_type", r13)), false, null, null, null, null, 252);
        ConstraintLayout r14 = this.a;
        d r1 = this.c;
        ECUrlModel r3 = r1.b;
        List<ECUrlModel> r4 = r1.f;
        int r5 = r1.c;
        int r6 = AnchorV4DetailImageMoreInfoView.d;
        r14.getClass();
        if (r4 == null) goto L16;
        AnchorV4DetailImageGalleryViewer r7 = new AnchorV4DetailImageGalleryViewer(r14.getContext());
        r7.c.a = 2;
        ArrayList r8 = new ArrayList();
        Iterator<T> r9 = r4.iterator();
    L11:
        if (r9.hasNext() == false) goto L13;
        ECUrlModel r10 = (ECUrlModel) r9.next();
        com.bytedance.android.ec.model.k r15 = new com.bytedance.android.ec.model.k();
        r15.a = 10;
        r15.b = r10.getFirstUrl();
        r15.g = Integer.valueOf(r10.getWidth());
        r15.h = Integer.valueOf(r10.getHeight());
        r15.l = null;
        r15.m = null;
        Unit r16 = Unit.INSTANCE;
        r8.add(r15);
        goto L11
    L13:
        Unit r17 = Unit.INSTANCE;
        r7.a(r8, false);
        r7.showAnimated(r5, r14);
        return;
    L16:
        return;
    L5:
        r13 = null;
        goto L6
    }
}
