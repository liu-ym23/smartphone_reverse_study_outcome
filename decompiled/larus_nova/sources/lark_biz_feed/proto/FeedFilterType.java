package lark_biz_feed.proto;

import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.WireEnum;
import r27.a;

/* JADX INFO: loaded from: classes42.dex */
public final enum FeedFilterType extends Enum<FeedFilterType> implements WireEnum {
    private static final /* synthetic */ FeedFilterType[] $VALUES = null;
    public static final ProtoAdapter<FeedFilterType> ADAPTER = null;
    public static final FeedFilterType VAR_FEED_FILTER_TYPE_ALL_MESSAGE = null;
    public static final FeedFilterType VAR_FEED_FILTER_TYPE_AT_ME = null;
    public static final FeedFilterType VAR_FEED_FILTER_TYPE_BOT = null;
    public static final FeedFilterType VAR_FEED_FILTER_TYPE_CALENDAR_GROUP = null;
    public static final FeedFilterType VAR_FEED_FILTER_TYPE_COLLAPSED = null;
    public static final FeedFilterType VAR_FEED_FILTER_TYPE_CRYPTO_CHAT = null;
    public static final FeedFilterType VAR_FEED_FILTER_TYPE_DELAYED = null;
    public static final FeedFilterType VAR_FEED_FILTER_TYPE_DEPRECATED_AT_ME_ONLY = null;
    public static final FeedFilterType VAR_FEED_FILTER_TYPE_DOC = null;
    public static final FeedFilterType VAR_FEED_FILTER_TYPE_DONE = null;
    public static final FeedFilterType VAR_FEED_FILTER_TYPE_EXPIRED_FOLD = null;
    public static final FeedFilterType VAR_FEED_FILTER_TYPE_FLAG = null;
    public static final FeedFilterType VAR_FEED_FILTER_TYPE_GROUP = null;
    public static final FeedFilterType VAR_FEED_FILTER_TYPE_GROUP_CHAT = null;
    public static final FeedFilterType VAR_FEED_FILTER_TYPE_HELP_DESK = null;
    public static final FeedFilterType VAR_FEED_FILTER_TYPE_INBOX = null;
    public static final FeedFilterType VAR_FEED_FILTER_TYPE_INSTANT_MEETING_GROUP = null;
    public static final FeedFilterType VAR_FEED_FILTER_TYPE_MARK_AS_DELETED = null;
    public static final FeedFilterType VAR_FEED_FILTER_TYPE_MESSAGE = null;
    public static final FeedFilterType VAR_FEED_FILTER_TYPE_MESSAGE_WITHOUT_DOUBAO = null;
    public static final FeedFilterType VAR_FEED_FILTER_TYPE_MUTE = null;
    public static final FeedFilterType VAR_FEED_FILTER_TYPE_P2P_CHAT = null;
    public static final FeedFilterType VAR_FEED_FILTER_TYPE_TAG = null;
    public static final FeedFilterType VAR_FEED_FILTER_TYPE_TEAM = null;
    public static final FeedFilterType VAR_FEED_FILTER_TYPE_THREAD = null;
    public static final FeedFilterType VAR_FEED_FILTER_TYPE_TOPIC_GROUP = null;
    public static final FeedFilterType VAR_FEED_FILTER_TYPE_UNKNOWN = null;
    public static final FeedFilterType VAR_FEED_FILTER_TYPE_UNREAD = null;
    public static final FeedFilterType VAR_FEED_FILTER_TYPE_UNREAD_OVER_DAYS = null;
    private final int value;

    static {
        FeedFilterType r100 = new FeedFilterType("VAR_FEED_FILTER_TYPE_UNKNOWN", 0, 0);
        VAR_FEED_FILTER_TYPE_UNKNOWN = r100;
        FeedFilterType r101 = new FeedFilterType("VAR_FEED_FILTER_TYPE_INBOX", 1, 1);
        VAR_FEED_FILTER_TYPE_INBOX = r101;
        FeedFilterType r102 = new FeedFilterType("VAR_FEED_FILTER_TYPE_AT_ME", 2, 2);
        VAR_FEED_FILTER_TYPE_AT_ME = r102;
        FeedFilterType r103 = new FeedFilterType("VAR_FEED_FILTER_TYPE_UNREAD", 3, 3);
        VAR_FEED_FILTER_TYPE_UNREAD = r103;
        FeedFilterType r104 = new FeedFilterType("VAR_FEED_FILTER_TYPE_DELAYED", 4, 4);
        VAR_FEED_FILTER_TYPE_DELAYED = r104;
        FeedFilterType r105 = new FeedFilterType("VAR_FEED_FILTER_TYPE_DOC", 5, 5);
        VAR_FEED_FILTER_TYPE_DOC = r105;
        FeedFilterType r110 = new FeedFilterType("VAR_FEED_FILTER_TYPE_P2P_CHAT", 6, 6);
        VAR_FEED_FILTER_TYPE_P2P_CHAT = r110;
        FeedFilterType r111 = new FeedFilterType("VAR_FEED_FILTER_TYPE_GROUP_CHAT", 7, 7);
        VAR_FEED_FILTER_TYPE_GROUP_CHAT = r111;
        FeedFilterType r112 = new FeedFilterType("VAR_FEED_FILTER_TYPE_BOT", 8, 8);
        VAR_FEED_FILTER_TYPE_BOT = r112;
        FeedFilterType r113 = new FeedFilterType("VAR_FEED_FILTER_TYPE_HELP_DESK", 9, 9);
        VAR_FEED_FILTER_TYPE_HELP_DESK = r113;
        FeedFilterType r114 = new FeedFilterType("VAR_FEED_FILTER_TYPE_TOPIC_GROUP", 10, 10);
        VAR_FEED_FILTER_TYPE_TOPIC_GROUP = r114;
        FeedFilterType r115 = new FeedFilterType("VAR_FEED_FILTER_TYPE_DONE", 11, 11);
        VAR_FEED_FILTER_TYPE_DONE = r115;
        FeedFilterType r106 = new FeedFilterType("VAR_FEED_FILTER_TYPE_CRYPTO_CHAT", 12, 12);
        VAR_FEED_FILTER_TYPE_CRYPTO_CHAT = r106;
        FeedFilterType r107 = new FeedFilterType("VAR_FEED_FILTER_TYPE_MESSAGE", 13, 13);
        VAR_FEED_FILTER_TYPE_MESSAGE = r107;
        FeedFilterType r108 = new FeedFilterType("VAR_FEED_FILTER_TYPE_MUTE", 14, 14);
        VAR_FEED_FILTER_TYPE_MUTE = r108;
        FeedFilterType r109 = new FeedFilterType("VAR_FEED_FILTER_TYPE_GROUP", 15, 15);
        VAR_FEED_FILTER_TYPE_GROUP = r109;
        FeedFilterType r116 = new FeedFilterType("VAR_FEED_FILTER_TYPE_TEAM", 16, 16);
        VAR_FEED_FILTER_TYPE_TEAM = r116;
        FeedFilterType r117 = new FeedFilterType("VAR_FEED_FILTER_TYPE_DEPRECATED_AT_ME_ONLY", 17, 17);
        VAR_FEED_FILTER_TYPE_DEPRECATED_AT_ME_ONLY = r117;
        FeedFilterType r118 = new FeedFilterType("VAR_FEED_FILTER_TYPE_TAG", 18, 18);
        VAR_FEED_FILTER_TYPE_TAG = r118;
        FeedFilterType r119 = new FeedFilterType("VAR_FEED_FILTER_TYPE_FLAG", 19, 19);
        VAR_FEED_FILTER_TYPE_FLAG = r119;
        FeedFilterType r120 = new FeedFilterType("VAR_FEED_FILTER_TYPE_THREAD", 20, 20);
        VAR_FEED_FILTER_TYPE_THREAD = r120;
        FeedFilterType r121 = new FeedFilterType("VAR_FEED_FILTER_TYPE_UNREAD_OVER_DAYS", 21, 21);
        VAR_FEED_FILTER_TYPE_UNREAD_OVER_DAYS = r121;
        FeedFilterType r122 = new FeedFilterType("VAR_FEED_FILTER_TYPE_CALENDAR_GROUP", 22, 22);
        VAR_FEED_FILTER_TYPE_CALENDAR_GROUP = r122;
        FeedFilterType r123 = new FeedFilterType("VAR_FEED_FILTER_TYPE_INSTANT_MEETING_GROUP", 23, 23);
        VAR_FEED_FILTER_TYPE_INSTANT_MEETING_GROUP = r123;
        FeedFilterType r124 = new FeedFilterType("VAR_FEED_FILTER_TYPE_COLLAPSED", 24, 24);
        VAR_FEED_FILTER_TYPE_COLLAPSED = r124;
        FeedFilterType r125 = new FeedFilterType("VAR_FEED_FILTER_TYPE_ALL_MESSAGE", 25, 25);
        VAR_FEED_FILTER_TYPE_ALL_MESSAGE = r125;
        FeedFilterType r126 = new FeedFilterType("VAR_FEED_FILTER_TYPE_EXPIRED_FOLD", 26, 26);
        VAR_FEED_FILTER_TYPE_EXPIRED_FOLD = r126;
        FeedFilterType r127 = new FeedFilterType("VAR_FEED_FILTER_TYPE_MARK_AS_DELETED", 27, 27);
        VAR_FEED_FILTER_TYPE_MARK_AS_DELETED = r127;
        FeedFilterType r128 = new FeedFilterType("VAR_FEED_FILTER_TYPE_MESSAGE_WITHOUT_DOUBAO", 28, 28);
        VAR_FEED_FILTER_TYPE_MESSAGE_WITHOUT_DOUBAO = r128;
        $VALUES = new FeedFilterType[]{r100, r101, r102, r103, r104, r105, r110, r111, r112, r113, r114, r115, r106, r107, r108, r109, r116, r117, r118, r119, r120, r121, r122, r123, r124, r125, r126, r127, r128};
        ADAPTER = ProtoAdapter.newEnumAdapter(FeedFilterType.class);
    }

    public static FeedFilterType[] values() {
        return (FeedFilterType[]) $VALUES.clone();
    }

    @Override // com.squareup.wire.WireEnum
    public final int getValue() {
        return this.value;
    }

    public static FeedFilterType fromValue(int r100) {
        switch(r100) {
            case 0: goto L62;
            case 1: goto L60;
            case 2: goto L58;
            case 3: goto L56;
            case 4: goto L54;
            case 5: goto L52;
            case 6: goto L50;
            case 7: goto L48;
            case 8: goto L46;
            case 9: goto L44;
            case 10: goto L42;
            case 11: goto L40;
            case 12: goto L38;
            case 13: goto L36;
            case 14: goto L34;
            case 15: goto L32;
            case 16: goto L30;
            case 17: goto L28;
            case 18: goto L26;
            case 19: goto L24;
            case 20: goto L22;
            case 21: goto L20;
            case 22: goto L18;
            case 23: goto L16;
            case 24: goto L14;
            case 25: goto L12;
            case 26: goto L10;
            case 27: goto L8;
            case 28: goto L6;
            default: goto L3;
        };
    L3:
        return null;
    L6:
        return VAR_FEED_FILTER_TYPE_MESSAGE_WITHOUT_DOUBAO;
    L8:
        return VAR_FEED_FILTER_TYPE_MARK_AS_DELETED;
    L10:
        return VAR_FEED_FILTER_TYPE_EXPIRED_FOLD;
    L12:
        return VAR_FEED_FILTER_TYPE_ALL_MESSAGE;
    L14:
        return VAR_FEED_FILTER_TYPE_COLLAPSED;
    L16:
        return VAR_FEED_FILTER_TYPE_INSTANT_MEETING_GROUP;
    L18:
        return VAR_FEED_FILTER_TYPE_CALENDAR_GROUP;
    L20:
        return VAR_FEED_FILTER_TYPE_UNREAD_OVER_DAYS;
    L22:
        return VAR_FEED_FILTER_TYPE_THREAD;
    L24:
        return VAR_FEED_FILTER_TYPE_FLAG;
    L26:
        return VAR_FEED_FILTER_TYPE_TAG;
    L28:
        return VAR_FEED_FILTER_TYPE_DEPRECATED_AT_ME_ONLY;
    L30:
        return VAR_FEED_FILTER_TYPE_TEAM;
    L32:
        return VAR_FEED_FILTER_TYPE_GROUP;
    L34:
        return VAR_FEED_FILTER_TYPE_MUTE;
    L36:
        return VAR_FEED_FILTER_TYPE_MESSAGE;
    L38:
        return VAR_FEED_FILTER_TYPE_CRYPTO_CHAT;
    L40:
        return VAR_FEED_FILTER_TYPE_DONE;
    L42:
        return VAR_FEED_FILTER_TYPE_TOPIC_GROUP;
    L44:
        return VAR_FEED_FILTER_TYPE_HELP_DESK;
    L46:
        return VAR_FEED_FILTER_TYPE_BOT;
    L48:
        return VAR_FEED_FILTER_TYPE_GROUP_CHAT;
    L50:
        return VAR_FEED_FILTER_TYPE_P2P_CHAT;
    L52:
        return VAR_FEED_FILTER_TYPE_DOC;
    L54:
        return VAR_FEED_FILTER_TYPE_DELAYED;
    L56:
        return VAR_FEED_FILTER_TYPE_UNREAD;
    L58:
        return VAR_FEED_FILTER_TYPE_AT_ME;
    L60:
        return VAR_FEED_FILTER_TYPE_INBOX;
    L62:
        return VAR_FEED_FILTER_TYPE_UNKNOWN;
    }

    public static FeedFilterType valueOf(String r100) {
        return (FeedFilterType) a.a(FeedFilterType.class, r100);
    }

    private FeedFilterType(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
