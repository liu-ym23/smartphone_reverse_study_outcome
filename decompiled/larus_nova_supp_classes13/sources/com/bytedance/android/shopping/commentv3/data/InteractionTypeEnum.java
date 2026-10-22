package com.bytedance.android.shopping.commentv3.data;

import com.bytedance.android.shopping.mall.feed.help.GYLFetchType;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\r\b\u0086\u0001\u0018\u0000 \u00072\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\bR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000e¨\u0006\u000f"}, d2 = {"Lcom/bytedance/android/shopping/commentv3/data/InteractionTypeEnum;", "", "", "type", "Ljava/lang/String;", "getType", "()Ljava/lang/String;", "Companion", "a", "CLICK_IMPRESSION", "CLICK_SKU", "CLICK_LATEST_BTN", "CLICK_COMPLEX_BTN", "LOAD_MORE", "CLICK_MEANINGLESS", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum InteractionTypeEnum extends Enum<InteractionTypeEnum> {
    public static final InteractionTypeEnum CLICK_COMPLEX_BTN = null;
    public static final InteractionTypeEnum CLICK_IMPRESSION = null;
    public static final InteractionTypeEnum CLICK_LATEST_BTN = null;
    public static final InteractionTypeEnum CLICK_MEANINGLESS = null;
    public static final InteractionTypeEnum CLICK_SKU = null;
    public static final a Companion = null;
    public static final InteractionTypeEnum LOAD_MORE = null;
    public static final /* synthetic */ InteractionTypeEnum[] a = null;
    private final String type;

    public static final class a {
        public a() {
        }
    }

    static {
        InteractionTypeEnum r1 = new InteractionTypeEnum("CLICK_IMPRESSION", 0, "click_impression");
        CLICK_IMPRESSION = r1;
        InteractionTypeEnum r2 = new InteractionTypeEnum("CLICK_SKU", 1, "click_sku");
        CLICK_SKU = r2;
        InteractionTypeEnum r3 = new InteractionTypeEnum("CLICK_LATEST_BTN", 2, "click_latest_button");
        CLICK_LATEST_BTN = r3;
        InteractionTypeEnum r4 = new InteractionTypeEnum("CLICK_COMPLEX_BTN", 3, "click_complex_button");
        CLICK_COMPLEX_BTN = r4;
        InteractionTypeEnum r5 = new InteractionTypeEnum("LOAD_MORE", 4, GYLFetchType.LOAD_MORE);
        LOAD_MORE = r5;
        InteractionTypeEnum r6 = new InteractionTypeEnum("CLICK_MEANINGLESS", 5, "click_meaningless");
        CLICK_MEANINGLESS = r6;
        a = new InteractionTypeEnum[]{r1, r2, r3, r4, r5, r6};
        Companion = new a();
    }

    public static InteractionTypeEnum valueOf(String r1) {
        return (InteractionTypeEnum) r27.a.a(InteractionTypeEnum.class, r1);
    }

    public static InteractionTypeEnum[] values() {
        return (InteractionTypeEnum[]) a.clone();
    }

    public final String getType() {
        return this.type;
    }

    public InteractionTypeEnum(String r1, int r2, String r3) {
        super(r1, r2);
        this.type = r3;
    }
}
