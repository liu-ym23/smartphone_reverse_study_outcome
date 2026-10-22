package com.bytedance.android.shopping.orderlist.common.widgets.bubble;

import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0003\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/shopping/orderlist/common/widgets/bubble/BubbleOrientation;", "", "TOP", "BOTTOM", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum BubbleOrientation extends Enum<BubbleOrientation> {
    public static final BubbleOrientation BOTTOM = null;
    public static final BubbleOrientation TOP = null;
    public static final /* synthetic */ BubbleOrientation[] a = null;

    static {
        BubbleOrientation r1 = new BubbleOrientation("TOP", 0);
        TOP = r1;
        BubbleOrientation r2 = new BubbleOrientation("BOTTOM", 1);
        BOTTOM = r2;
        a = new BubbleOrientation[]{r1, r2};
    }

    public static BubbleOrientation valueOf(String r1) {
        return (BubbleOrientation) r27.a.a(BubbleOrientation.class, r1);
    }

    public static BubbleOrientation[] values() {
        return (BubbleOrientation[]) a.clone();
    }

    public BubbleOrientation(String r1, int r2) {
        super(r1, r2);
    }
}
