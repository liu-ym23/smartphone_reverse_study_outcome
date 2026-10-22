package com.bytedance.android.shopping.deepfeed.weights;

import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/shopping/deepfeed/weights/MarqueeViewItemType;", "", "HAS_COUNTDOWN_VIEW", "HAS_QCPX_VIEW", "TWO_REC_REASON_VIEW", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum MarqueeViewItemType extends Enum<MarqueeViewItemType> {
    public static final MarqueeViewItemType HAS_COUNTDOWN_VIEW = null;
    public static final MarqueeViewItemType HAS_QCPX_VIEW = null;
    public static final MarqueeViewItemType TWO_REC_REASON_VIEW = null;
    public static final /* synthetic */ MarqueeViewItemType[] a = null;

    static {
        MarqueeViewItemType r1 = new MarqueeViewItemType("HAS_COUNTDOWN_VIEW", 0);
        HAS_COUNTDOWN_VIEW = r1;
        MarqueeViewItemType r2 = new MarqueeViewItemType("HAS_QCPX_VIEW", 1);
        HAS_QCPX_VIEW = r2;
        MarqueeViewItemType r3 = new MarqueeViewItemType("TWO_REC_REASON_VIEW", 2);
        TWO_REC_REASON_VIEW = r3;
        a = new MarqueeViewItemType[]{r1, r2, r3};
    }

    public static MarqueeViewItemType valueOf(String r1) {
        return (MarqueeViewItemType) r27.a.a(MarqueeViewItemType.class, r1);
    }

    public static MarqueeViewItemType[] values() {
        return (MarqueeViewItemType[]) a.clone();
    }

    public MarqueeViewItemType(String r1, int r2) {
        super(r1, r2);
    }
}
