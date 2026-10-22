package com.bytedance.android.shopping.buynow.data.model;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\u000e\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000f¨\u0006\u0010"}, d2 = {"Lcom/bytedance/android/shopping/buynow/data/model/BuyNowShape;", "", "", "shape", "I", "getShape", "()I", "DEFAULT", "HALF", "FINAL", "ZERO_BUY", "REFUEL", "AUCTION", "DIRECT", "SUPERMARKET_HOUR", "RECHARGE", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum BuyNowShape extends Enum<BuyNowShape> {
    public static final BuyNowShape AUCTION = null;
    public static final BuyNowShape DEFAULT = null;
    public static final BuyNowShape DIRECT = null;
    public static final BuyNowShape FINAL = null;
    public static final BuyNowShape HALF = null;
    public static final BuyNowShape RECHARGE = null;
    public static final BuyNowShape REFUEL = null;
    public static final BuyNowShape SUPERMARKET_HOUR = null;
    public static final BuyNowShape ZERO_BUY = null;
    public static final /* synthetic */ BuyNowShape[] a = null;
    private final int shape;

    public static BuyNowShape valueOf(String r1) {
        return (BuyNowShape) a.a(BuyNowShape.class, r1);
    }

    public static BuyNowShape[] values() {
        return (BuyNowShape[]) a.clone();
    }

    static {
        BuyNowShape r2 = new BuyNowShape("DEFAULT", 0, 0);
        DEFAULT = r2;
        BuyNowShape r3 = new BuyNowShape("HALF", 1, 1);
        HALF = r3;
        BuyNowShape r4 = new BuyNowShape("FINAL", 2, 2);
        FINAL = r4;
        BuyNowShape r5 = new BuyNowShape("ZERO_BUY", 3, 3);
        ZERO_BUY = r5;
        BuyNowShape r6 = new BuyNowShape("REFUEL", 4, 4);
        REFUEL = r6;
        BuyNowShape r7 = new BuyNowShape("AUCTION", 5, 5);
        AUCTION = r7;
        BuyNowShape r8 = new BuyNowShape("DIRECT", 6, 6);
        DIRECT = r8;
        BuyNowShape r9 = new BuyNowShape("SUPERMARKET_HOUR", 7, 8);
        SUPERMARKET_HOUR = r9;
        BuyNowShape r10 = new BuyNowShape("RECHARGE", 8, 9);
        RECHARGE = r10;
        a = new BuyNowShape[]{r2, r3, r4, r5, r6, r7, r8, r9, r10};
    }

    public final int getShape() {
        return this.shape;
    }

    public BuyNowShape(String r1, int r2, int r3) {
        super(r1, r2);
        this.shape = r3;
    }
}
