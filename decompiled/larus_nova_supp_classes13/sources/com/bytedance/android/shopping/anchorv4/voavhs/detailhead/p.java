package com.bytedance.android.shopping.anchorv4.voavhs.detailhead;

import com.bytedance.android.shopping.anchorv3.repository.dto.AttrItem;
import com.bytedance.android.shopping.anchorv3.repository.dto.ProductFormat;
import com.bytedance.android.shopping.anchorv3.view.AnchorV3ProductFormatItemView;
import com.bytedance.commerce.uikit.flowlayout.FlowLayout;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class p extends fg4.a<AttrItem> {
    public final /* synthetic */ AnchorV4DetailSkuPropertiesFragment c;
    public final /* synthetic */ ProductFormat d;
    public final /* synthetic */ String e;
    public final /* synthetic */ q f;

    public final AnchorV3ProductFormatItemView a(FlowLayout r5, Object r6) {
        AttrItem r7 = (AttrItem) r6;
        if (r5 == null) goto L6;
        AnchorV3ProductFormatItemView r1 = new AnchorV3ProductFormatItemView(r5.getContext(), null, 6, 0);
        r1.d(r7, this.d, this.e, this.f);
        ((ArrayList) this.c.l).add(r1);
        return r1;
    L6:
        return null;
    }

    public p(AnchorV4DetailSkuPropertiesFragment r1, ProductFormat r2, String r3, q r4, List r5) {
        this.c = r1;
        this.d = r2;
        this.e = r3;
        this.f = r4;
        super(r5);
    }
}
