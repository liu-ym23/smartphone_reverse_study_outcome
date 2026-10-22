package com.ss.android.lark.pb.usearch;

import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.WireEnum;
import r27.a;

/* JADX INFO: loaded from: classes37.dex */
public final enum SearchTabName extends Enum<SearchTabName> implements WireEnum {
    private static final /* synthetic */ SearchTabName[] $VALUES = null;
    public static final ProtoAdapter<SearchTabName> ADAPTER = null;
    public static final SearchTabName APP_TAB = null;
    public static final SearchTabName CALENDAR_TAB = null;
    public static final SearchTabName CHATTER_TAB = null;
    public static final SearchTabName CHAT_TAB = null;
    public static final SearchTabName DOCS_TAB = null;
    public static final SearchTabName EMAIL_TAB = null;
    public static final SearchTabName HELPDESK_TAB = null;
    public static final SearchTabName MESSAGE_TAB = null;
    public static final SearchTabName OPEN_SEARCH_TAB = null;
    public static final SearchTabName PANO_TAB = null;
    public static final SearchTabName SMART_SEARCH_TAB = null;
    public static final SearchTabName UNKNOWN_TAB = null;
    public static final SearchTabName WIKI_TAB = null;
    private final int value;

    static {
        SearchTabName r100 = new SearchTabName("UNKNOWN_TAB", 0, 0);
        UNKNOWN_TAB = r100;
        SearchTabName r101 = new SearchTabName("MESSAGE_TAB", 1, 1);
        MESSAGE_TAB = r101;
        SearchTabName r102 = new SearchTabName("DOCS_TAB", 2, 2);
        DOCS_TAB = r102;
        SearchTabName r103 = new SearchTabName("WIKI_TAB", 3, 3);
        WIKI_TAB = r103;
        SearchTabName r104 = new SearchTabName("CHAT_TAB", 4, 4);
        CHAT_TAB = r104;
        SearchTabName r105 = new SearchTabName("CALENDAR_TAB", 5, 5);
        CALENDAR_TAB = r105;
        SearchTabName r110 = new SearchTabName("APP_TAB", 6, 6);
        APP_TAB = r110;
        SearchTabName r111 = new SearchTabName("EMAIL_TAB", 7, 7);
        EMAIL_TAB = r111;
        SearchTabName r112 = new SearchTabName("CHATTER_TAB", 8, 8);
        CHATTER_TAB = r112;
        SearchTabName r113 = new SearchTabName("PANO_TAB", 9, 9);
        PANO_TAB = r113;
        SearchTabName r114 = new SearchTabName("HELPDESK_TAB", 10, 10);
        HELPDESK_TAB = r114;
        SearchTabName r115 = new SearchTabName("OPEN_SEARCH_TAB", 11, 255);
        OPEN_SEARCH_TAB = r115;
        SearchTabName r106 = new SearchTabName("SMART_SEARCH_TAB", 12, 11);
        SMART_SEARCH_TAB = r106;
        $VALUES = new SearchTabName[]{r100, r101, r102, r103, r104, r105, r110, r111, r112, r113, r114, r115, r106};
        ADAPTER = ProtoAdapter.newEnumAdapter(SearchTabName.class);
    }

    public static SearchTabName[] values() {
        return (SearchTabName[]) $VALUES.clone();
    }

    @Override // com.squareup.wire.WireEnum
    public final int getValue() {
        return this.value;
    }

    public static SearchTabName fromValue(int r100) {
        if (r100 == 255) goto L32;
        switch(r100) {
            case 0: goto L30;
            case 1: goto L28;
            case 2: goto L26;
            case 3: goto L24;
            case 4: goto L22;
            case 5: goto L20;
            case 6: goto L18;
            case 7: goto L16;
            case 8: goto L14;
            case 9: goto L12;
            case 10: goto L10;
            case 11: goto L8;
            default: goto L5;
        };
    L5:
        return null;
    L8:
        return SMART_SEARCH_TAB;
    L10:
        return HELPDESK_TAB;
    L12:
        return PANO_TAB;
    L14:
        return CHATTER_TAB;
    L16:
        return EMAIL_TAB;
    L18:
        return APP_TAB;
    L20:
        return CALENDAR_TAB;
    L22:
        return CHAT_TAB;
    L24:
        return WIKI_TAB;
    L26:
        return DOCS_TAB;
    L28:
        return MESSAGE_TAB;
    L30:
        return UNKNOWN_TAB;
    L32:
        return OPEN_SEARCH_TAB;
    }

    public static SearchTabName valueOf(String r100) {
        return (SearchTabName) a.a(SearchTabName.class, r100);
    }

    private SearchTabName(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
