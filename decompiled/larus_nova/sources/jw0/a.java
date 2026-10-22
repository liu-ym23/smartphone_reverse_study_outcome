package jw0;

import com.bytedance.android.live.recharge.model.ExchangeType;
import com.bytedance.android.live.recharge.order.Order;

/* JADX INFO: loaded from: classes47.dex */
public final /* synthetic */ class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f500647a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ int[] f500648b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ int[] f500649c = null;

    static {
        int[] r100 = new int[ExchangeType.values().length];
        f500647a = r100;
        r100[ExchangeType.EXCHANGE_TYPE_FANS.ordinal()] = 1;
        r100[ExchangeType.EXCHANGE_TYPE_RED_PACKET.ordinal()] = 2;
        r100[ExchangeType.EXCHANGE_TYPE_LOTTERY.ordinal()] = 3;
        ExchangeType r101 = ExchangeType.EXCHANGE_TYPE_GIFT;
        r100[r101.ordinal()] = 4;
        ExchangeType r102 = ExchangeType.EXCHANGE_TYPE_FAST_GIFT;
        r100[r102.ordinal()] = 5;
        ExchangeType r103 = ExchangeType.EXCHANGE_TYPE_GIFT_GUIDE;
        r100[r103.ordinal()] = 6;
        r100[ExchangeType.EXCHANGE_TYPE_BARRAGE.ordinal()] = 7;
        int[] r104 = new int[ExchangeType.values().length];
        f500648b = r104;
        r104[r101.ordinal()] = 1;
        r104[r102.ordinal()] = 2;
        r104[r103.ordinal()] = 3;
        int[] r105 = new int[Order.State.values().length];
        f500649c = r105;
        r105[Order.State.Successful.ordinal()] = 1;
        r105[Order.State.Failed.ordinal()] = 2;
    }
}
