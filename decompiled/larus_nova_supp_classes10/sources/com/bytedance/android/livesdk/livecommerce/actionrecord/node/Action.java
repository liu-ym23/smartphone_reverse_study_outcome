package com.bytedance.android.livesdk.livecommerce.actionrecord.node;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\u0011\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0017\u0010\u0007\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006j\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012¨\u0006\u0013"}, d2 = {"Lcom/bytedance/android/livesdk/livecommerce/actionrecord/node/Action;", "", "", "module", "Ljava/lang/String;", "getModule", "()Ljava/lang/String;", "action", "getAction", "SHOP_LIST_OPEN", "SHOP_LIST_PIC_FAIL", "SHOP_LIST_HOT_ATMOSPHERE_DATA_ERR", "SHOP_LIST_DATA_FROM", "GOODS_CARD_PIC_FAIL", "GOODS_CARD_HOT_ATMOSPHERE_DATA_ERR", "GOODS_CARD_RELATED_INFO", "GOODS_CARD_RELATED_INFO_FAIL", "ENTER_FROM_RELATED_INFO", "ENTER_FROM_RELATED_INFO_FAIL", "livecommerce_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum Action extends Enum<Action> {
    public static final Action ENTER_FROM_RELATED_INFO = null;
    public static final Action ENTER_FROM_RELATED_INFO_FAIL = null;
    public static final Action GOODS_CARD_HOT_ATMOSPHERE_DATA_ERR = null;
    public static final Action GOODS_CARD_PIC_FAIL = null;
    public static final Action GOODS_CARD_RELATED_INFO = null;
    public static final Action GOODS_CARD_RELATED_INFO_FAIL = null;
    public static final Action SHOP_LIST_DATA_FROM = null;
    public static final Action SHOP_LIST_HOT_ATMOSPHERE_DATA_ERR = null;
    public static final Action SHOP_LIST_OPEN = null;
    public static final Action SHOP_LIST_PIC_FAIL = null;
    public static final /* synthetic */ Action[] a = null;
    private final String action;
    private final String module;

    public static Action valueOf(String r1) {
        return (Action) a.a(Action.class, r1);
    }

    public static Action[] values() {
        return (Action[]) a.clone();
    }

    static {
        Action r1 = new Action("SHOP_LIST_OPEN", 0, "shop_list", "open_list");
        SHOP_LIST_OPEN = r1;
        Action r2 = new Action("SHOP_LIST_PIC_FAIL", 1, "shop_list", "pic_fail");
        SHOP_LIST_PIC_FAIL = r2;
        Action r3 = new Action("SHOP_LIST_HOT_ATMOSPHERE_DATA_ERR", 2, "shop_list", "hot_atmosphere_data_err");
        SHOP_LIST_HOT_ATMOSPHERE_DATA_ERR = r3;
        Action r4 = new Action("SHOP_LIST_DATA_FROM", 3, "shop_list", "data_from");
        SHOP_LIST_DATA_FROM = r4;
        Action r5 = new Action("GOODS_CARD_PIC_FAIL", 4, "goods_card", "pic_fail");
        GOODS_CARD_PIC_FAIL = r5;
        Action r6 = new Action("GOODS_CARD_HOT_ATMOSPHERE_DATA_ERR", 5, "goods_card", "hot_atmosphere_data_err");
        GOODS_CARD_HOT_ATMOSPHERE_DATA_ERR = r6;
        Action r7 = new Action("GOODS_CARD_RELATED_INFO", 6, "goods_card", "request_related_info");
        GOODS_CARD_RELATED_INFO = r7;
        Action r8 = new Action("GOODS_CARD_RELATED_INFO_FAIL", 7, "goods_card", "request_related_info_exceed_max_length");
        GOODS_CARD_RELATED_INFO_FAIL = r8;
        Action r9 = new Action("ENTER_FROM_RELATED_INFO", 8, "enter_room", "request_related_info");
        ENTER_FROM_RELATED_INFO = r9;
        Action r10 = new Action("ENTER_FROM_RELATED_INFO_FAIL", 9, "enter_room", "request_related_info_exceed_max_length");
        ENTER_FROM_RELATED_INFO_FAIL = r10;
        a = new Action[]{r1, r2, r3, r4, r5, r6, r7, r8, r9, r10};
    }

    public final String getAction() {
        return this.action;
    }

    public final String getModule() {
        return this.module;
    }

    public Action(String r1, int r2, String r3, String r4) {
        super(r1, r2);
        this.module = r3;
        this.action = r4;
    }
}
