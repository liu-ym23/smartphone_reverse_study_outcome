package com.bytedance.android.shopping.anchorv4.voavhs.base.elements;

import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\t\n\u0002\b\u0007\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/bytedance/android/shopping/anchorv4/voavhs/base/elements/KolReviewStyle;", "", "", "type", "J", "getType", "()J", "STYLE_SPLIT", "STYLE_WHOLE", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum KolReviewStyle extends Enum<KolReviewStyle> {
    public static final KolReviewStyle STYLE_SPLIT = null;
    public static final KolReviewStyle STYLE_WHOLE = null;
    public static final /* synthetic */ KolReviewStyle[] a = null;
    private final long type;

    static {
        KolReviewStyle r1 = new KolReviewStyle("STYLE_SPLIT", 0, 0);
        STYLE_SPLIT = r1;
        KolReviewStyle r2 = new KolReviewStyle("STYLE_WHOLE", 1, 1);
        STYLE_WHOLE = r2;
        a = new KolReviewStyle[]{r1, r2};
    }

    public static KolReviewStyle valueOf(String r1) {
        return (KolReviewStyle) r27.a.a(KolReviewStyle.class, r1);
    }

    public static KolReviewStyle[] values() {
        return (KolReviewStyle[]) a.clone();
    }

    public final long getType() {
        return this.type;
    }

    public KolReviewStyle(String r1, int r2, long r3) {
        super(r1, r2);
        this.type = r3;
    }
}
