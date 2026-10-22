package com.bytedance.lark.pb.search.v1;

import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.WireEnum;
import r27.a;

/* JADX INFO: loaded from: classes20.dex */
public final enum FilterInTab extends Enum<FilterInTab> implements WireEnum {
    private static final /* synthetic */ FilterInTab[] $VALUES = null;
    public static final ProtoAdapter<FilterInTab> ADAPTER = null;
    public static final FilterInTab DOC_CHAT = null;
    public static final FilterInTab DOC_FORMAT = null;
    public static final FilterInTab DOC_FROM = null;
    public static final FilterInTab DOC_MATCH_SCOPE = null;
    public static final FilterInTab DOC_MINE = null;
    public static final FilterInTab DOC_OWNER = null;
    public static final FilterInTab DOC_SHARER = null;
    public static final FilterInTab DOC_SORT = null;
    public static final FilterInTab DOC_TYPE = null;
    public static final FilterInTab DOC_VIEW_TIME = null;
    public static final FilterInTab GROUP_MEMBER = null;
    public static final FilterInTab GROUP_SORT = null;
    public static final FilterInTab GROUP_TYPE = null;
    public static final FilterInTab MSG_AT_ME = null;
    public static final FilterInTab MSG_CHAT = null;
    public static final FilterInTab MSG_HIDE_BOT = null;
    public static final FilterInTab MSG_SENDER = null;
    public static final FilterInTab MSG_SEND_TIME = null;
    public static final FilterInTab MSG_TYPE = null;
    public static final FilterInTab SMART_CHAT = null;
    public static final FilterInTab SMART_MAIL_USER = null;
    public static final FilterInTab SMART_TIME = null;
    public static final FilterInTab SMART_USER = null;
    private final int value;

    static {
        FilterInTab r100 = new FilterInTab("SMART_USER", 0, 1);
        SMART_USER = r100;
        FilterInTab r101 = new FilterInTab("SMART_CHAT", 1, 2);
        SMART_CHAT = r101;
        FilterInTab r102 = new FilterInTab("SMART_TIME", 2, 3);
        SMART_TIME = r102;
        FilterInTab r103 = new FilterInTab("SMART_MAIL_USER", 3, 4);
        SMART_MAIL_USER = r103;
        FilterInTab r104 = new FilterInTab("MSG_SENDER", 4, 10);
        MSG_SENDER = r104;
        FilterInTab r110 = new FilterInTab("MSG_CHAT", 5, 11);
        MSG_CHAT = r110;
        FilterInTab r111 = new FilterInTab("MSG_TYPE", 6, 12);
        MSG_TYPE = r111;
        FilterInTab r112 = new FilterInTab("MSG_SEND_TIME", 7, 13);
        MSG_SEND_TIME = r112;
        FilterInTab r113 = new FilterInTab("MSG_AT_ME", 8, 14);
        MSG_AT_ME = r113;
        FilterInTab r105 = new FilterInTab("MSG_HIDE_BOT", 9, 15);
        MSG_HIDE_BOT = r105;
        FilterInTab r106 = new FilterInTab("DOC_MINE", 10, 30);
        DOC_MINE = r106;
        FilterInTab r107 = new FilterInTab("DOC_OWNER", 11, 31);
        DOC_OWNER = r107;
        FilterInTab r108 = new FilterInTab("DOC_SHARER", 12, 32);
        DOC_SHARER = r108;
        FilterInTab r114 = new FilterInTab("DOC_CHAT", 13, 33);
        DOC_CHAT = r114;
        FilterInTab r109 = new FilterInTab("DOC_TYPE", 14, 34);
        DOC_TYPE = r109;
        FilterInTab r115 = new FilterInTab("DOC_FORMAT", 15, 35);
        DOC_FORMAT = r115;
        FilterInTab r116 = new FilterInTab("DOC_VIEW_TIME", 16, 36);
        DOC_VIEW_TIME = r116;
        FilterInTab r117 = new FilterInTab("DOC_MATCH_SCOPE", 17, 37);
        DOC_MATCH_SCOPE = r117;
        FilterInTab r118 = new FilterInTab("DOC_SORT", 18, 38);
        DOC_SORT = r118;
        FilterInTab r119 = new FilterInTab("DOC_FROM", 19, 39);
        DOC_FROM = r119;
        FilterInTab r120 = new FilterInTab("GROUP_TYPE", 20, 50);
        GROUP_TYPE = r120;
        FilterInTab r121 = new FilterInTab("GROUP_MEMBER", 21, 51);
        GROUP_MEMBER = r121;
        FilterInTab r122 = new FilterInTab("GROUP_SORT", 22, 52);
        GROUP_SORT = r122;
        $VALUES = new FilterInTab[]{r100, r101, r102, r103, r104, r110, r111, r112, r113, r105, r106, r107, r108, r114, r109, r115, r116, r117, r118, r119, r120, r121, r122};
        ADAPTER = ProtoAdapter.newEnumAdapter(FilterInTab.class);
    }

    public static FilterInTab[] values() {
        return (FilterInTab[]) $VALUES.clone();
    }

    @Override // com.squareup.wire.WireEnum
    public final int getValue() {
        return this.value;
    }

    public static FilterInTab fromValue(int r100) {
        if (r100 == 1) goto L60;
        if (r100 == 2) goto L58;
        if (r100 == 3) goto L56;
        if (r100 == 4) goto L54;
        switch(r100) {
            case 10: goto L52;
            case 11: goto L50;
            case 12: goto L48;
            case 13: goto L46;
            case 14: goto L44;
            case 15: goto L42;
            default: goto L11;
        };
    L11:
        switch(r100) {
            case 30: goto L40;
            case 31: goto L38;
            case 32: goto L36;
            case 33: goto L34;
            case 34: goto L32;
            case 35: goto L30;
            case 36: goto L28;
            case 37: goto L26;
            case 38: goto L24;
            case 39: goto L22;
            default: goto L12;
        };
    L12:
        switch(r100) {
            case 50: goto L20;
            case 51: goto L18;
            case 52: goto L16;
            default: goto L13;
        };
    L13:
        return null;
    L16:
        return GROUP_SORT;
    L18:
        return GROUP_MEMBER;
    L20:
        return GROUP_TYPE;
    L22:
        return DOC_FROM;
    L24:
        return DOC_SORT;
    L26:
        return DOC_MATCH_SCOPE;
    L28:
        return DOC_VIEW_TIME;
    L30:
        return DOC_FORMAT;
    L32:
        return DOC_TYPE;
    L34:
        return DOC_CHAT;
    L36:
        return DOC_SHARER;
    L38:
        return DOC_OWNER;
    L40:
        return DOC_MINE;
    L42:
        return MSG_HIDE_BOT;
    L44:
        return MSG_AT_ME;
    L46:
        return MSG_SEND_TIME;
    L48:
        return MSG_TYPE;
    L50:
        return MSG_CHAT;
    L52:
        return MSG_SENDER;
    L54:
        return SMART_MAIL_USER;
    L56:
        return SMART_TIME;
    L58:
        return SMART_CHAT;
    L60:
        return SMART_USER;
    }

    public static FilterInTab valueOf(String r100) {
        return (FilterInTab) a.a(FilterInTab.class, r100);
    }

    private FilterInTab(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
