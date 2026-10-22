package com.bytedance.android.window.shop.repository.dto;

import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\r\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000e¨\u0006\u000f"}, d2 = {"Lcom/bytedance/android/window/shop/repository/dto/BubbleTypes;", "", "", "type", "I", "getType", "()I", "GRASS_BUBBLE", "LIVE_BUBBLE", "INVENTORY_BUBBLE", "INVENTORY_LIST_BUBBLE", "GREAT_BUBBLE", "SECKILL_BUBBLE", "BRAND_BUBBLE", "BOOK_LIST_BUBBLE", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum BubbleTypes extends Enum<BubbleTypes> {
    public static final BubbleTypes BOOK_LIST_BUBBLE = null;
    public static final BubbleTypes BRAND_BUBBLE = null;
    public static final BubbleTypes GRASS_BUBBLE = null;
    public static final BubbleTypes GREAT_BUBBLE = null;
    public static final BubbleTypes INVENTORY_BUBBLE = null;
    public static final BubbleTypes INVENTORY_LIST_BUBBLE = null;
    public static final BubbleTypes LIVE_BUBBLE = null;
    public static final BubbleTypes SECKILL_BUBBLE = null;
    public static final /* synthetic */ BubbleTypes[] a = null;
    private final int type;

    public static BubbleTypes valueOf(String r1) {
        return (BubbleTypes) r27.a.a(BubbleTypes.class, r1);
    }

    public static BubbleTypes[] values() {
        return (BubbleTypes[]) a.clone();
    }

    static {
        BubbleTypes r1 = new BubbleTypes("GRASS_BUBBLE", 0, 1);
        GRASS_BUBBLE = r1;
        BubbleTypes r2 = new BubbleTypes("LIVE_BUBBLE", 1, 2);
        LIVE_BUBBLE = r2;
        BubbleTypes r3 = new BubbleTypes("INVENTORY_BUBBLE", 2, 3);
        INVENTORY_BUBBLE = r3;
        BubbleTypes r4 = new BubbleTypes("INVENTORY_LIST_BUBBLE", 3, 4);
        INVENTORY_LIST_BUBBLE = r4;
        BubbleTypes r5 = new BubbleTypes("GREAT_BUBBLE", 4, 5);
        GREAT_BUBBLE = r5;
        BubbleTypes r6 = new BubbleTypes("SECKILL_BUBBLE", 5, 6);
        SECKILL_BUBBLE = r6;
        BubbleTypes r7 = new BubbleTypes("BRAND_BUBBLE", 6, 7);
        BRAND_BUBBLE = r7;
        BubbleTypes r8 = new BubbleTypes("BOOK_LIST_BUBBLE", 7, 9);
        BOOK_LIST_BUBBLE = r8;
        a = new BubbleTypes[]{r1, r2, r3, r4, r5, r6, r7, r8};
    }

    public final int getType() {
        return this.type;
    }

    public BubbleTypes(String r1, int r2, int r3) {
        super(r1, r2);
        this.type = r3;
    }
}
