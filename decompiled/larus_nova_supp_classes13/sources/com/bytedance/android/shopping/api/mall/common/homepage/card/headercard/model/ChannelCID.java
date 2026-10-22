package com.bytedance.android.shopping.api.mall.common.homepage.card.headercard.model;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\u0010\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011¨\u0006\u0012"}, d2 = {"Lcom/bytedance/android/shopping/api/mall/common/homepage/card/headercard/model/ChannelCID;", "", "", "value", "Ljava/lang/String;", "getValue", "()Ljava/lang/String;", "LIVE_SQUARE", "CYCLE_ACTIVITY", "BRAND", "SUBSIDE", "SECKILL", "CHANNEL_ALL", "Hours", "COIN_CHANNEL", "NEW_COIN_CHANNEL", "DELIVERY", "DAY_DAY_BUY", "mall-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum ChannelCID extends Enum<ChannelCID> {
    public static final ChannelCID BRAND = null;
    public static final ChannelCID CHANNEL_ALL = null;
    public static final ChannelCID COIN_CHANNEL = null;
    public static final ChannelCID CYCLE_ACTIVITY = null;
    public static final ChannelCID DAY_DAY_BUY = null;
    public static final ChannelCID DELIVERY = null;
    public static final ChannelCID Hours = null;
    public static final ChannelCID LIVE_SQUARE = null;
    public static final ChannelCID NEW_COIN_CHANNEL = null;
    public static final ChannelCID SECKILL = null;
    public static final ChannelCID SUBSIDE = null;
    public static final /* synthetic */ ChannelCID[] a = null;
    private final String value;

    public static ChannelCID valueOf(String r1) {
        return (ChannelCID) a.a(ChannelCID.class, r1);
    }

    public static ChannelCID[] values() {
        return (ChannelCID[]) a.clone();
    }

    static {
        ChannelCID r1 = new ChannelCID("LIVE_SQUARE", 0, "1");
        LIVE_SQUARE = r1;
        ChannelCID r2 = new ChannelCID("CYCLE_ACTIVITY", 1, "1");
        CYCLE_ACTIVITY = r2;
        ChannelCID r3 = new ChannelCID("BRAND", 2, "2");
        BRAND = r3;
        ChannelCID r4 = new ChannelCID("SUBSIDE", 3, "3");
        SUBSIDE = r4;
        ChannelCID r5 = new ChannelCID("SECKILL", 4, "4");
        SECKILL = r5;
        ChannelCID r6 = new ChannelCID("CHANNEL_ALL", 5, "200");
        CHANNEL_ALL = r6;
        ChannelCID r7 = new ChannelCID("Hours", 6, "10");
        Hours = r7;
        ChannelCID r8 = new ChannelCID("COIN_CHANNEL", 7, "33");
        COIN_CHANNEL = r8;
        ChannelCID r9 = new ChannelCID("NEW_COIN_CHANNEL", 8, "35");
        NEW_COIN_CHANNEL = r9;
        ChannelCID r10 = new ChannelCID("DELIVERY", 9, "36");
        DELIVERY = r10;
        ChannelCID r11 = new ChannelCID("DAY_DAY_BUY", 10, "30");
        DAY_DAY_BUY = r11;
        a = new ChannelCID[]{r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11};
    }

    public final String getValue() {
        return this.value;
    }

    public ChannelCID(String r1, int r2, String r3) {
        super(r1, r2);
        this.value = r3;
    }
}
