package lark_biz_feed.proto;

import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.WireEnum;
import r27.a;

/* JADX INFO: loaded from: classes42.dex */
public final enum FeedCardType extends Enum<FeedCardType> implements WireEnum {
    private static final /* synthetic */ FeedCardType[] $VALUES = null;
    public static final ProtoAdapter<FeedCardType> ADAPTER = null;
    public static final FeedCardType VAR_FEED_CARD_TYPE_APP_CHAT = null;
    public static final FeedCardType VAR_FEED_CARD_TYPE_APP_FEED = null;
    public static final FeedCardType VAR_FEED_CARD_TYPE_BOX = null;
    public static final FeedCardType VAR_FEED_CARD_TYPE_CHAT = null;
    public static final FeedCardType VAR_FEED_CARD_TYPE_DEPRECATED9 = null;
    public static final FeedCardType VAR_FEED_CARD_TYPE_DOC = null;
    public static final FeedCardType VAR_FEED_CARD_TYPE_DOUBAO_CUSTOM = null;
    public static final FeedCardType VAR_FEED_CARD_TYPE_KNOWLEDGE_AI = null;
    public static final FeedCardType VAR_FEED_CARD_TYPE_MAIL = null;
    public static final FeedCardType VAR_FEED_CARD_TYPE_MSG_THREAD = null;
    public static final FeedCardType VAR_FEED_CARD_TYPE_MY_AI = null;
    public static final FeedCardType VAR_FEED_CARD_TYPE_OPENAPP = null;
    public static final FeedCardType VAR_FEED_CARD_TYPE_SUBSCRIPTION = null;
    public static final FeedCardType VAR_FEED_CARD_TYPE_THREAD = null;
    public static final FeedCardType VAR_FEED_CARD_TYPE_TOPIC = null;
    public static final FeedCardType VAR_FEED_CARD_TYPE_UNKNOWN_TYPE = null;
    private final int value;

    static {
        FeedCardType r100 = new FeedCardType("VAR_FEED_CARD_TYPE_UNKNOWN_TYPE", 0, 0);
        VAR_FEED_CARD_TYPE_UNKNOWN_TYPE = r100;
        FeedCardType r101 = new FeedCardType("VAR_FEED_CARD_TYPE_CHAT", 1, 1);
        VAR_FEED_CARD_TYPE_CHAT = r101;
        FeedCardType r102 = new FeedCardType("VAR_FEED_CARD_TYPE_MAIL", 2, 2);
        VAR_FEED_CARD_TYPE_MAIL = r102;
        FeedCardType r103 = new FeedCardType("VAR_FEED_CARD_TYPE_DOC", 3, 3);
        VAR_FEED_CARD_TYPE_DOC = r103;
        FeedCardType r104 = new FeedCardType("VAR_FEED_CARD_TYPE_THREAD", 4, 4);
        VAR_FEED_CARD_TYPE_THREAD = r104;
        FeedCardType r105 = new FeedCardType("VAR_FEED_CARD_TYPE_BOX", 5, 5);
        VAR_FEED_CARD_TYPE_BOX = r105;
        FeedCardType r110 = new FeedCardType("VAR_FEED_CARD_TYPE_OPENAPP", 6, 6);
        VAR_FEED_CARD_TYPE_OPENAPP = r110;
        FeedCardType r111 = new FeedCardType("VAR_FEED_CARD_TYPE_TOPIC", 7, 7);
        VAR_FEED_CARD_TYPE_TOPIC = r111;
        FeedCardType r112 = new FeedCardType("VAR_FEED_CARD_TYPE_APP_CHAT", 8, 8);
        VAR_FEED_CARD_TYPE_APP_CHAT = r112;
        FeedCardType r113 = new FeedCardType("VAR_FEED_CARD_TYPE_DEPRECATED9", 9, 9);
        VAR_FEED_CARD_TYPE_DEPRECATED9 = r113;
        FeedCardType r114 = new FeedCardType("VAR_FEED_CARD_TYPE_SUBSCRIPTION", 10, 10);
        VAR_FEED_CARD_TYPE_SUBSCRIPTION = r114;
        FeedCardType r115 = new FeedCardType("VAR_FEED_CARD_TYPE_MSG_THREAD", 11, 11);
        VAR_FEED_CARD_TYPE_MSG_THREAD = r115;
        FeedCardType r106 = new FeedCardType("VAR_FEED_CARD_TYPE_MY_AI", 12, 12);
        VAR_FEED_CARD_TYPE_MY_AI = r106;
        FeedCardType r107 = new FeedCardType("VAR_FEED_CARD_TYPE_APP_FEED", 13, 13);
        VAR_FEED_CARD_TYPE_APP_FEED = r107;
        FeedCardType r108 = new FeedCardType("VAR_FEED_CARD_TYPE_KNOWLEDGE_AI", 14, 14);
        VAR_FEED_CARD_TYPE_KNOWLEDGE_AI = r108;
        FeedCardType r109 = new FeedCardType("VAR_FEED_CARD_TYPE_DOUBAO_CUSTOM", 15, 15);
        VAR_FEED_CARD_TYPE_DOUBAO_CUSTOM = r109;
        $VALUES = new FeedCardType[]{r100, r101, r102, r103, r104, r105, r110, r111, r112, r113, r114, r115, r106, r107, r108, r109};
        ADAPTER = ProtoAdapter.newEnumAdapter(FeedCardType.class);
    }

    public static FeedCardType[] values() {
        return (FeedCardType[]) $VALUES.clone();
    }

    @Override // com.squareup.wire.WireEnum
    public final int getValue() {
        return this.value;
    }

    public static FeedCardType fromValue(int r100) {
        switch(r100) {
            case 0: goto L36;
            case 1: goto L34;
            case 2: goto L32;
            case 3: goto L30;
            case 4: goto L28;
            case 5: goto L26;
            case 6: goto L24;
            case 7: goto L22;
            case 8: goto L20;
            case 9: goto L18;
            case 10: goto L16;
            case 11: goto L14;
            case 12: goto L12;
            case 13: goto L10;
            case 14: goto L8;
            case 15: goto L6;
            default: goto L3;
        };
    L3:
        return null;
    L6:
        return VAR_FEED_CARD_TYPE_DOUBAO_CUSTOM;
    L8:
        return VAR_FEED_CARD_TYPE_KNOWLEDGE_AI;
    L10:
        return VAR_FEED_CARD_TYPE_APP_FEED;
    L12:
        return VAR_FEED_CARD_TYPE_MY_AI;
    L14:
        return VAR_FEED_CARD_TYPE_MSG_THREAD;
    L16:
        return VAR_FEED_CARD_TYPE_SUBSCRIPTION;
    L18:
        return VAR_FEED_CARD_TYPE_DEPRECATED9;
    L20:
        return VAR_FEED_CARD_TYPE_APP_CHAT;
    L22:
        return VAR_FEED_CARD_TYPE_TOPIC;
    L24:
        return VAR_FEED_CARD_TYPE_OPENAPP;
    L26:
        return VAR_FEED_CARD_TYPE_BOX;
    L28:
        return VAR_FEED_CARD_TYPE_THREAD;
    L30:
        return VAR_FEED_CARD_TYPE_DOC;
    L32:
        return VAR_FEED_CARD_TYPE_MAIL;
    L34:
        return VAR_FEED_CARD_TYPE_CHAT;
    L36:
        return VAR_FEED_CARD_TYPE_UNKNOWN_TYPE;
    }

    public static FeedCardType valueOf(String r100) {
        return (FeedCardType) a.a(FeedCardType.class, r100);
    }

    private FeedCardType(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
