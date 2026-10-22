package com.bytedance.android.shopping.store.mall.follows;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/shopping/store/mall/follows/DisplayType;", "", "", "value", "I", "getValue", "()I", "NORMAL", "FILTER_CARD_FIRST", "CONTENT_CARD_BOTTOM_WITH_FILTER", "CONTENT_CARD_LAST", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum DisplayType extends Enum<DisplayType> {
    public static final DisplayType CONTENT_CARD_BOTTOM_WITH_FILTER = null;
    public static final DisplayType CONTENT_CARD_LAST = null;
    public static final DisplayType FILTER_CARD_FIRST = null;
    public static final DisplayType NORMAL = null;
    public static final /* synthetic */ DisplayType[] a = null;
    private final int value;

    static {
        DisplayType r1 = new DisplayType("NORMAL", 0, 0);
        NORMAL = r1;
        DisplayType r2 = new DisplayType("FILTER_CARD_FIRST", 1, 1);
        FILTER_CARD_FIRST = r2;
        DisplayType r3 = new DisplayType("CONTENT_CARD_BOTTOM_WITH_FILTER", 2, 2);
        CONTENT_CARD_BOTTOM_WITH_FILTER = r3;
        DisplayType r4 = new DisplayType("CONTENT_CARD_LAST", 3, 3);
        CONTENT_CARD_LAST = r4;
        a = new DisplayType[]{r1, r2, r3, r4};
    }

    public static DisplayType valueOf(String r1) {
        return (DisplayType) a.a(DisplayType.class, r1);
    }

    public static DisplayType[] values() {
        return (DisplayType[]) a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public DisplayType(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }
}
