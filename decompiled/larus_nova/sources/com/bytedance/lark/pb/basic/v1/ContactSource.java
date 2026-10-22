package com.bytedance.lark.pb.basic.v1;

import com.huawei.hms.support.api.entity.common.CommonConstant;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.WireEnum;
import r27.a;

/* JADX INFO: loaded from: classes20.dex */
public final enum ContactSource extends Enum<ContactSource> implements WireEnum {
    private static final /* synthetic */ ContactSource[] $VALUES = null;
    public static final ProtoAdapter<ContactSource> ADAPTER = null;
    public static final ContactSource CALENDAR = null;
    public static final ContactSource CHAT = null;
    public static final ContactSource COMMUNITY = null;
    public static final ContactSource CONTACTCARDS = null;
    public static final ContactSource DOCS = null;
    public static final ContactSource EMAIL = null;
    public static final ContactSource EXTERNAL_CONTACT = null;
    public static final ContactSource LINK = null;
    public static final ContactSource MINUTES = null;
    public static final ContactSource NAME_CARD = null;
    public static final ContactSource NEW_CONTACT = null;
    public static final ContactSource SEARCH_CONTACT = null;
    public static final ContactSource SEARCH_DOUBAO_ID = null;
    public static final ContactSource SEARCH_EMAIL = null;
    public static final ContactSource SEARCH_PHONE = null;
    public static final ContactSource SPECIAL_FOCUS = null;
    public static final ContactSource UNKNOWN_SOURCE = null;
    public static final ContactSource VC = null;
    private final int value;

    static {
        ContactSource r100 = new ContactSource("UNKNOWN_SOURCE", 0, 0);
        UNKNOWN_SOURCE = r100;
        ContactSource r101 = new ContactSource("LINK", 1, 1);
        LINK = r101;
        ContactSource r102 = new ContactSource("CHAT", 2, 2);
        CHAT = r102;
        ContactSource r103 = new ContactSource("CALENDAR", 3, 3);
        CALENDAR = r103;
        ContactSource r104 = new ContactSource("DOCS", 4, 4);
        DOCS = r104;
        ContactSource r105 = new ContactSource("VC", 5, 5);
        VC = r105;
        ContactSource r110 = new ContactSource(CommonConstant.RETKEY.EMAIL, 6, 6);
        EMAIL = r110;
        ContactSource r111 = new ContactSource("NAME_CARD", 7, 7);
        NAME_CARD = r111;
        ContactSource r112 = new ContactSource("SEARCH_PHONE", 8, 8);
        SEARCH_PHONE = r112;
        ContactSource r113 = new ContactSource("SEARCH_EMAIL", 9, 9);
        SEARCH_EMAIL = r113;
        ContactSource r114 = new ContactSource("SEARCH_CONTACT", 10, 10);
        SEARCH_CONTACT = r114;
        ContactSource r115 = new ContactSource("COMMUNITY", 11, 11);
        COMMUNITY = r115;
        ContactSource r106 = new ContactSource("EXTERNAL_CONTACT", 12, 17);
        EXTERNAL_CONTACT = r106;
        ContactSource r107 = new ContactSource("NEW_CONTACT", 13, 18);
        NEW_CONTACT = r107;
        ContactSource r108 = new ContactSource("SPECIAL_FOCUS", 14, 19);
        SPECIAL_FOCUS = r108;
        ContactSource r109 = new ContactSource("MINUTES", 15, 20);
        MINUTES = r109;
        ContactSource r116 = new ContactSource("SEARCH_DOUBAO_ID", 16, 21);
        SEARCH_DOUBAO_ID = r116;
        ContactSource r117 = new ContactSource("CONTACTCARDS", 17, 1000);
        CONTACTCARDS = r117;
        $VALUES = new ContactSource[]{r100, r101, r102, r103, r104, r105, r110, r111, r112, r113, r114, r115, r106, r107, r108, r109, r116, r117};
        ADAPTER = ProtoAdapter.newEnumAdapter(ContactSource.class);
    }

    public static ContactSource[] values() {
        return (ContactSource[]) $VALUES.clone();
    }

    @Override // com.squareup.wire.WireEnum
    public final int getValue() {
        return this.value;
    }

    public static ContactSource fromValue(int r100) {
        if (r100 == 1000) goto L43;
        switch(r100) {
            case 0: goto L41;
            case 1: goto L39;
            case 2: goto L37;
            case 3: goto L35;
            case 4: goto L33;
            case 5: goto L31;
            case 6: goto L29;
            case 7: goto L27;
            case 8: goto L25;
            case 9: goto L23;
            case 10: goto L21;
            case 11: goto L19;
            default: goto L5;
        };
    L5:
        switch(r100) {
            case 17: goto L17;
            case 18: goto L15;
            case 19: goto L13;
            case 20: goto L11;
            case 21: goto L9;
            default: goto L6;
        };
    L6:
        return null;
    L9:
        return SEARCH_DOUBAO_ID;
    L11:
        return MINUTES;
    L13:
        return SPECIAL_FOCUS;
    L15:
        return NEW_CONTACT;
    L17:
        return EXTERNAL_CONTACT;
    L19:
        return COMMUNITY;
    L21:
        return SEARCH_CONTACT;
    L23:
        return SEARCH_EMAIL;
    L25:
        return SEARCH_PHONE;
    L27:
        return NAME_CARD;
    L29:
        return EMAIL;
    L31:
        return VC;
    L33:
        return DOCS;
    L35:
        return CALENDAR;
    L37:
        return CHAT;
    L39:
        return LINK;
    L41:
        return UNKNOWN_SOURCE;
    L43:
        return CONTACTCARDS;
    }

    public static ContactSource valueOf(String r100) {
        return (ContactSource) a.a(ContactSource.class, r100);
    }

    private ContactSource(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
