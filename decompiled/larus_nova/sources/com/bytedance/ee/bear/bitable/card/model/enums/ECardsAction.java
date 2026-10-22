package com.bytedance.ee.bear.bitable.card.model.enums;

import android.text.TextUtils;
import cu5.a;

/* JADX INFO: loaded from: classes15.dex */
public final enum ECardsAction extends Enum<ECardsAction> {
    public static final ECardsAction ADD_RECORD_RESULT = null;
    public static final ECardsAction BITABLE_IS_READY = null;
    public static final ECardsAction CLOSE_CARD = null;
    public static final ECardsAction CLOSE_FORM_GRID_CARD = null;
    public static final ECardsAction FIELDS_VALIDATE = null;
    public static final ECardsAction FORM_FIELDS_VALIDATE = null;
    public static final ECardsAction LINK_TABLE_CHANGED = null;
    public static final ECardsAction SCROLL_CARD = null;
    public static final ECardsAction SET_CARD_HIDDEN = null;
    public static final ECardsAction SET_CARD_VISIBLE = null;
    public static final ECardsAction SHOW_ADD_RECORD = null;
    public static final ECardsAction SHOW_CARD = null;
    public static final ECardsAction SHOW_IND_RECORD = null;
    public static final ECardsAction SHOW_LINK_CARD = null;
    public static final ECardsAction SHOW_MANUAL_SUBMIT_CARD = null;
    public static final ECardsAction SUBMIT_RESULT = null;
    public static final ECardsAction SWITCH_CARD = null;
    public static final ECardsAction TABLE_CREATE_RECORD_DATA_LOADED = null;
    public static final ECardsAction TABLE_RECORDS_DATA_LOADED = null;
    public static final ECardsAction TABLE_SWITCHED = null;
    public static final ECardsAction UNKNOWN = null;
    public static final ECardsAction UPDATE_FIELD = null;
    public static final ECardsAction UPDATE_RECORD = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ECardsAction[] f207087a = null;

    static {
        ECardsAction r100 = new ECardsAction("SHOW_CARD", 0);
        SHOW_CARD = r100;
        ECardsAction r101 = new ECardsAction("UPDATE_RECORD", 1);
        UPDATE_RECORD = r101;
        ECardsAction r102 = new ECardsAction("UPDATE_FIELD", 2);
        UPDATE_FIELD = r102;
        ECardsAction r103 = new ECardsAction("CLOSE_CARD", 3);
        CLOSE_CARD = r103;
        ECardsAction r104 = new ECardsAction("CLOSE_FORM_GRID_CARD", 4);
        CLOSE_FORM_GRID_CARD = r104;
        ECardsAction r105 = new ECardsAction("LINK_TABLE_CHANGED", 5);
        LINK_TABLE_CHANGED = r105;
        ECardsAction r110 = new ECardsAction("TABLE_RECORDS_DATA_LOADED", 6);
        TABLE_RECORDS_DATA_LOADED = r110;
        ECardsAction r111 = new ECardsAction("TABLE_CREATE_RECORD_DATA_LOADED", 7);
        TABLE_CREATE_RECORD_DATA_LOADED = r111;
        ECardsAction r112 = new ECardsAction("FORM_FIELDS_VALIDATE", 8);
        FORM_FIELDS_VALIDATE = r112;
        ECardsAction r113 = new ECardsAction("FIELDS_VALIDATE", 9);
        FIELDS_VALIDATE = r113;
        ECardsAction r114 = new ECardsAction("SHOW_MANUAL_SUBMIT_CARD", 10);
        SHOW_MANUAL_SUBMIT_CARD = r114;
        ECardsAction r115 = new ECardsAction("SWITCH_CARD", 11);
        SWITCH_CARD = r115;
        ECardsAction r106 = new ECardsAction("SCROLL_CARD", 12);
        SCROLL_CARD = r106;
        ECardsAction r107 = new ECardsAction("SUBMIT_RESULT", 13);
        SUBMIT_RESULT = r107;
        ECardsAction r108 = new ECardsAction("BITABLE_IS_READY", 14);
        BITABLE_IS_READY = r108;
        ECardsAction r109 = new ECardsAction("TABLE_SWITCHED", 15);
        TABLE_SWITCHED = r109;
        ECardsAction r116 = new ECardsAction("SHOW_LINK_CARD", 16);
        SHOW_LINK_CARD = r116;
        ECardsAction r117 = new ECardsAction("SET_CARD_HIDDEN", 17);
        SET_CARD_HIDDEN = r117;
        ECardsAction r118 = new ECardsAction("SET_CARD_VISIBLE", 18);
        SET_CARD_VISIBLE = r118;
        ECardsAction r119 = new ECardsAction("SHOW_IND_RECORD", 19);
        SHOW_IND_RECORD = r119;
        ECardsAction r120 = new ECardsAction("SHOW_ADD_RECORD", 20);
        SHOW_ADD_RECORD = r120;
        ECardsAction r121 = new ECardsAction("ADD_RECORD_RESULT", 21);
        ADD_RECORD_RESULT = r121;
        ECardsAction r122 = new ECardsAction("UNKNOWN", 22);
        UNKNOWN = r122;
        f207087a = new ECardsAction[]{r100, r101, r102, r103, r104, r105, r110, r111, r112, r113, r114, r115, r106, r107, r108, r109, r116, r117, r118, r119, r120, r121, r122};
    }

    public static ECardsAction[] values() {
        return (ECardsAction[]) f207087a.clone();
    }

    @Override // java.lang.Enum
    public String toString() {
        return a.a(name().toLowerCase());
    }

    public static ECardsAction valueOf(String r100) {
        return (ECardsAction) r27.a.a(ECardsAction.class, r100);
    }

    public static ECardsAction valueOfCamelName(String r100) {
        ECardsAction[] r101 = values();
        int r102 = r101.length;
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L8;
        ECardsAction r104 = r101[r103];
        if (TextUtils.equals(r100, a.a(r104.name())) == true) goto L6;
        r103 = r103 + 1;
        goto L3
    L6:
        return r104;
    L8:
        return null;
    }

    public ECardsAction(String r100, int r101) {
        super(r100, r101);
    }
}
