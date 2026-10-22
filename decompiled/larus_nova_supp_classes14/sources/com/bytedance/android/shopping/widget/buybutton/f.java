package com.bytedance.android.shopping.widget.buybutton;

import com.bytedance.android.ec.model.ButtonType;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final /* synthetic */ class f {
    public static final /* synthetic */ int[] a = null;

    static {
        int[] r0 = new int[ButtonType.values().length];
        a = r0;
        r0[ButtonType.Presale.ordinal()] = 1;
        r0[ButtonType.TimingSale.ordinal()] = 2;
        r0[ButtonType.TimingSaleAppointed.ordinal()] = 3;
        r0[ButtonType.TimingSaleNotAppointed.ordinal()] = 4;
        r0[ButtonType.DepositPresale.ordinal()] = 5;
        r0[ButtonType.DepositPresaleAppointed.ordinal()] = 6;
        r0[ButtonType.DepositPresaleNotAppointed.ordinal()] = 7;
        r0[ButtonType.DepositFindGoods.ordinal()] = 8;
        r0[ButtonType.GroupBuy.ordinal()] = 9;
        r0[ButtonType.GroupBuyAlone.ordinal()] = 10;
        r0[ButtonType.Auction.ordinal()] = 11;
        r0[ButtonType.Seckill.ordinal()] = 12;
    }
}
