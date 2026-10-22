package com.bytedance.locallife.live.goodsshelves.bean;

import com.byted.cast.common.Constants;
import com.ss.android.lark.batterymonitor.stragety.AbsBatteryStrategy;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\f\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\r¨\u0006\u000e"}, d2 = {"Lcom/bytedance/locallife/live/goodsshelves/bean/ClueSourceId;", "", "", "value", "Ljava/lang/String;", "getValue", "()Ljava/lang/String;", "SHELF_IM", "SHELF_CARD_FORM", "SHELF_CARD_IM", "SHELF_CARD_GROUP", "LIVE_CARD_FORM", "LIVE_CARD_IM", "LIVE_CARD_GROUP", "locallife-live-impl_release"}, k = 1, mv = {1, 4, 3})
public final enum ClueSourceId extends Enum<ClueSourceId> {
    public static final ClueSourceId LIVE_CARD_FORM = null;
    public static final ClueSourceId LIVE_CARD_GROUP = null;
    public static final ClueSourceId LIVE_CARD_IM = null;
    public static final ClueSourceId SHELF_CARD_FORM = null;
    public static final ClueSourceId SHELF_CARD_GROUP = null;
    public static final ClueSourceId SHELF_CARD_IM = null;
    public static final ClueSourceId SHELF_IM = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ClueSourceId[] f259550a = null;
    private final String value;

    public static ClueSourceId valueOf(String r100) {
        return (ClueSourceId) r27.a.a(ClueSourceId.class, r100);
    }

    public static ClueSourceId[] values() {
        return (ClueSourceId[]) f259550a.clone();
    }

    static {
        ClueSourceId r100 = new ClueSourceId("SHELF_IM", 0, "1008");
        SHELF_IM = r100;
        ClueSourceId r101 = new ClueSourceId("SHELF_CARD_FORM", 1, "1009");
        SHELF_CARD_FORM = r101;
        ClueSourceId r102 = new ClueSourceId("SHELF_CARD_IM", 2, AbsBatteryStrategy.AppBgCombination.APP_BG__CHARGE_IN__NETWORK_NOT_WIFI__SCREEN_ON);
        SHELF_CARD_IM = r102;
        ClueSourceId r103 = new ClueSourceId("SHELF_CARD_GROUP", 3, AbsBatteryStrategy.AppBgCombination.APP_BG__CHARGE_IN__NETWORK_NOT_WIFI__SCREEN_OFF);
        SHELF_CARD_GROUP = r103;
        ClueSourceId r104 = new ClueSourceId("LIVE_CARD_FORM", 4, AbsBatteryStrategy.AppBgCombination.APP_BG__CHARGE_IN__NETWORK_NOT_WIFI__SCREEN_OFF_3M);
        LIVE_CARD_FORM = r104;
        ClueSourceId r105 = new ClueSourceId("LIVE_CARD_IM", 5, Constants.DEMO_HOST_AID);
        LIVE_CARD_IM = r105;
        ClueSourceId r110 = new ClueSourceId("LIVE_CARD_GROUP", 6, "1014");
        LIVE_CARD_GROUP = r110;
        f259550a = new ClueSourceId[]{r100, r101, r102, r103, r104, r105, r110};
    }

    public final String getValue() {
        return this.value;
    }

    public ClueSourceId(String r100, int r101, String r102) {
        super(r100, r101);
        this.value = r102;
    }
}
