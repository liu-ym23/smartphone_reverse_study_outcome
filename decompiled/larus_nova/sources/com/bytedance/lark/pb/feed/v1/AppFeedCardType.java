package com.bytedance.lark.pb.feed.v1;

import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.WireEnum;
import r27.a;

/* JADX INFO: loaded from: classes20.dex */
public final enum AppFeedCardType extends Enum<AppFeedCardType> implements WireEnum {
    private static final /* synthetic */ AppFeedCardType[] $VALUES = null;
    public static final ProtoAdapter<AppFeedCardType> ADAPTER = null;
    public static final AppFeedCardType AI_UNREAD_SUMMARY = null;
    public static final AppFeedCardType CALENDAR = null;
    public static final AppFeedCardType CONTACT = null;
    public static final AppFeedCardType DOUBAO = null;
    public static final AppFeedCardType MAIL = null;
    public static final AppFeedCardType MINUTES = null;
    public static final AppFeedCardType OPEN = null;
    public static final AppFeedCardType UNKNOWN_APP_FEED_CARD_TYPE = null;
    private final int value;

    static {
        AppFeedCardType r100 = new AppFeedCardType("UNKNOWN_APP_FEED_CARD_TYPE", 0, 0);
        UNKNOWN_APP_FEED_CARD_TYPE = r100;
        AppFeedCardType r101 = new AppFeedCardType("MAIL", 1, 1);
        MAIL = r101;
        AppFeedCardType r102 = new AppFeedCardType("CALENDAR", 2, 2);
        CALENDAR = r102;
        AppFeedCardType r103 = new AppFeedCardType("OPEN", 3, 3);
        OPEN = r103;
        AppFeedCardType r104 = new AppFeedCardType("AI_UNREAD_SUMMARY", 4, 4);
        AI_UNREAD_SUMMARY = r104;
        AppFeedCardType r105 = new AppFeedCardType("MINUTES", 5, 5);
        MINUTES = r105;
        AppFeedCardType r110 = new AppFeedCardType("CONTACT", 6, 6);
        CONTACT = r110;
        AppFeedCardType r111 = new AppFeedCardType("DOUBAO", 7, 7);
        DOUBAO = r111;
        $VALUES = new AppFeedCardType[]{r100, r101, r102, r103, r104, r105, r110, r111};
        ADAPTER = ProtoAdapter.newEnumAdapter(AppFeedCardType.class);
    }

    public static AppFeedCardType[] values() {
        return (AppFeedCardType[]) $VALUES.clone();
    }

    @Override // com.squareup.wire.WireEnum
    public final int getValue() {
        return this.value;
    }

    public static AppFeedCardType fromValue(int r100) {
        switch(r100) {
            case 0: goto L20;
            case 1: goto L18;
            case 2: goto L16;
            case 3: goto L14;
            case 4: goto L12;
            case 5: goto L10;
            case 6: goto L8;
            case 7: goto L6;
            default: goto L3;
        };
    L3:
        return null;
    L6:
        return DOUBAO;
    L8:
        return CONTACT;
    L10:
        return MINUTES;
    L12:
        return AI_UNREAD_SUMMARY;
    L14:
        return OPEN;
    L16:
        return CALENDAR;
    L18:
        return MAIL;
    L20:
        return UNKNOWN_APP_FEED_CARD_TYPE;
    }

    public static AppFeedCardType valueOf(String r100) {
        return (AppFeedCardType) a.a(AppFeedCardType.class, r100);
    }

    private AppFeedCardType(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
