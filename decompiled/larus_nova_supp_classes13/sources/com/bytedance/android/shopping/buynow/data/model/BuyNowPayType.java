package com.bytedance.android.shopping.buynow.data.model;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\u0012\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013¨\u0006\u0014"}, d2 = {"Lcom/bytedance/android/shopping/buynow/data/model/BuyNowPayType;", "", "", "type", "I", "getType", "()I", "COD", "WECHAT", "ALIPAY", "CARD", "BALANCE", "ZEROBUY", "CREDIT", "NEWCARD", "BYTEPAY", "PAY_AFTER_USE", "COMBINE_PAY", "QUICK_PAY", "LARGE_AMOUNT", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum BuyNowPayType extends Enum<BuyNowPayType> {
    public static final BuyNowPayType ALIPAY = null;
    public static final BuyNowPayType BALANCE = null;
    public static final BuyNowPayType BYTEPAY = null;
    public static final BuyNowPayType CARD = null;
    public static final BuyNowPayType COD = null;
    public static final BuyNowPayType COMBINE_PAY = null;
    public static final BuyNowPayType CREDIT = null;
    public static final BuyNowPayType LARGE_AMOUNT = null;
    public static final BuyNowPayType NEWCARD = null;
    public static final BuyNowPayType PAY_AFTER_USE = null;
    public static final BuyNowPayType QUICK_PAY = null;
    public static final BuyNowPayType WECHAT = null;
    public static final BuyNowPayType ZEROBUY = null;
    public static final /* synthetic */ BuyNowPayType[] a = null;
    private final int type;

    public static BuyNowPayType valueOf(String r1) {
        return (BuyNowPayType) a.a(BuyNowPayType.class, r1);
    }

    public static BuyNowPayType[] values() {
        return (BuyNowPayType[]) a.clone();
    }

    static {
        BuyNowPayType r2 = new BuyNowPayType("COD", 0, 0);
        COD = r2;
        BuyNowPayType r3 = new BuyNowPayType("WECHAT", 1, 1);
        WECHAT = r3;
        BuyNowPayType r4 = new BuyNowPayType("ALIPAY", 2, 2);
        ALIPAY = r4;
        BuyNowPayType r5 = new BuyNowPayType("CARD", 3, 4);
        CARD = r5;
        BuyNowPayType r6 = new BuyNowPayType("BALANCE", 4, 5);
        BALANCE = r6;
        BuyNowPayType r7 = new BuyNowPayType("ZEROBUY", 5, 7);
        ZEROBUY = r7;
        BuyNowPayType r8 = new BuyNowPayType("CREDIT", 6, 8);
        CREDIT = r8;
        BuyNowPayType r9 = new BuyNowPayType("NEWCARD", 7, 9);
        NEWCARD = r9;
        BuyNowPayType r10 = new BuyNowPayType("BYTEPAY", 8, 10);
        BYTEPAY = r10;
        BuyNowPayType r11 = new BuyNowPayType("PAY_AFTER_USE", 9, 12);
        PAY_AFTER_USE = r11;
        BuyNowPayType r12 = new BuyNowPayType("COMBINE_PAY", 10, 13);
        COMBINE_PAY = r12;
        BuyNowPayType r0 = new BuyNowPayType("QUICK_PAY", 11, 14);
        QUICK_PAY = r0;
        BuyNowPayType r1 = new BuyNowPayType("LARGE_AMOUNT", 12, 17);
        LARGE_AMOUNT = r1;
        a = new BuyNowPayType[]{r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r0, r1};
    }

    public final int getType() {
        return this.type;
    }

    public BuyNowPayType(String r1, int r2, int r3) {
        super(r1, r2);
        this.type = r3;
    }
}
