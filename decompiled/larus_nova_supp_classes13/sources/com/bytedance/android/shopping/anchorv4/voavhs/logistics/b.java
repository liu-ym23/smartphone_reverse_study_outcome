package com.bytedance.android.shopping.anchorv4.voavhs.logistics;

import com.bytedance.android.shopping.anchorv4.voavhs.base.components.LongContentLabelComponentView;
import com.bytedance.android.shopping.anchorv4.voavhs.base.design.c;
import com.bytedance.common.utility.UIUtils;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class b implements c {
    public final /* synthetic */ LongContentLabelComponentView a;
    public final /* synthetic */ AnchorV4LogisticsServiceDetailView b;

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.base.design.c
    public final int a() {
        return UIUtils.px2dip(this.a.getContext(), this.b.getTivDetailButton().getMeasuredWidth());
    }

    public b(LongContentLabelComponentView r1, AnchorV4LogisticsServiceDetailView r2) {
        this.a = r1;
        this.b = r2;
    }
}
