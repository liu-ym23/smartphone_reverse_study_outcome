package com.bytedance.android.livesdk.livecommerce.promotion.card;

import kotlin.Deprecated;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\t\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/bytedance/android/livesdk/livecommerce/promotion/card/Decision;", "", "DEGRADE_HOT_ATMOSPHERE", "HIDE_EXPLAINING_ANIM", "DEGRADE_SALE_POINT_LOOP", "PROMOTION_CARD_CLOSE_STYLE", "DISPLAY_TWO_LINE_TITLE", "ADJUST_INSTANT_FUSION", "SHORTEN_BTN_INSTANT_FUSION", "IS_IN_SPLIT_SCREEN", "ec-common-api_release"}, k = 1, mv = {1, 4, 3})
public final enum Decision extends Enum<Decision> {
    public static final Decision ADJUST_INSTANT_FUSION = null;
    public static final Decision DEGRADE_HOT_ATMOSPHERE = null;
    public static final Decision DEGRADE_SALE_POINT_LOOP = null;
    public static final Decision DISPLAY_TWO_LINE_TITLE = null;
    public static final Decision HIDE_EXPLAINING_ANIM = null;
    public static final Decision IS_IN_SPLIT_SCREEN = null;

    @Deprecated(message = "暂时兼容")
    public static final Decision PROMOTION_CARD_CLOSE_STYLE = null;
    public static final Decision SHORTEN_BTN_INSTANT_FUSION = null;
    public static final /* synthetic */ Decision[] a = null;

    static {
        Decision r1 = new Decision("DEGRADE_HOT_ATMOSPHERE", 0);
        DEGRADE_HOT_ATMOSPHERE = r1;
        Decision r2 = new Decision("HIDE_EXPLAINING_ANIM", 1);
        HIDE_EXPLAINING_ANIM = r2;
        Decision r3 = new Decision("DEGRADE_SALE_POINT_LOOP", 2);
        DEGRADE_SALE_POINT_LOOP = r3;
        Decision r4 = new Decision("PROMOTION_CARD_CLOSE_STYLE", 3);
        PROMOTION_CARD_CLOSE_STYLE = r4;
        Decision r5 = new Decision("DISPLAY_TWO_LINE_TITLE", 4);
        DISPLAY_TWO_LINE_TITLE = r5;
        Decision r6 = new Decision("ADJUST_INSTANT_FUSION", 5);
        ADJUST_INSTANT_FUSION = r6;
        Decision r7 = new Decision("SHORTEN_BTN_INSTANT_FUSION", 6);
        SHORTEN_BTN_INSTANT_FUSION = r7;
        Decision r8 = new Decision("IS_IN_SPLIT_SCREEN", 7);
        IS_IN_SPLIT_SCREEN = r8;
        a = new Decision[]{r1, r2, r3, r4, r5, r6, r7, r8};
    }

    public static Decision valueOf(String r1) {
        return (Decision) r27.a.a(Decision.class, r1);
    }

    public static Decision[] values() {
        return (Decision[]) a.clone();
    }

    public Decision(String r1, int r2) {
        super(r1, r2);
    }
}
