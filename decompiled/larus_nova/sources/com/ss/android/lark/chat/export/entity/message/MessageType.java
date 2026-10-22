package com.ss.android.lark.chat.export.entity.message;

import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import com.bytedance.ee.bear.middleground.comment.adapter.CardAdapter;
import com.huawei.hms.support.api.entity.common.CommonConstant;
import com.larus.media.MediaScene;
import com.obric.miniapp.alarm.AlarmSessionType;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.JvmStatic;

/* JADX INFO: loaded from: classes35.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b \b\u0086\u0081\u0002\u0018\u0000 \"2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\"B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018j\u0002\b\u0019j\u0002\b\u001aj\u0002\b\u001bj\u0002\b\u001cj\u0002\b\u001dj\u0002\b\u001ej\u0002\b\u001fj\u0002\b j\u0002\b!¨\u0006#"}, d2 = {"Lcom/ss/android/lark/chat/export/entity/message/MessageType;", "", "number", "", "<init>", "(Ljava/lang/String;II)V", "getNumber", "()I", "UNKNOWN", "TEXT_IMAGE", "POST", "FILE", CardAdapter.TEXT, "IMAGE", MediaScene.SYSTEM, "AUDIO", CommonConstant.RETKEY.EMAIL, "SHARE_GROUP_CHAT", "STICKER", "MERGE_FORWARD", "CALENDAR", "CARD", "MEDIA", "SHARE_CALENDAR_EVENT", "RED_PACKET", "GENERAL_CALENDAR", "VIDEO_CHAT", HTTP.LOCATION, "COMMERCIALIZED_HONGBAO", "PROFILE", AlarmSessionType.TODO, "FOLDER", "VOTE", "DOUBAO", "Companion", "open-im-base_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum MessageType extends Enum<MessageType> {
    public static final MessageType AUDIO = null;
    public static final MessageType CALENDAR = null;
    public static final MessageType CARD = null;
    public static final MessageType COMMERCIALIZED_HONGBAO = null;
    public static final a Companion = null;
    public static final MessageType DOUBAO = null;
    public static final MessageType EMAIL = null;
    public static final MessageType FILE = null;
    public static final MessageType FOLDER = null;
    public static final MessageType GENERAL_CALENDAR = null;
    public static final MessageType IMAGE = null;
    public static final MessageType LOCATION = null;
    public static final MessageType MEDIA = null;
    public static final MessageType MERGE_FORWARD = null;
    public static final MessageType POST = null;
    public static final MessageType PROFILE = null;
    public static final MessageType RED_PACKET = null;
    public static final MessageType SHARE_CALENDAR_EVENT = null;
    public static final MessageType SHARE_GROUP_CHAT = null;
    public static final MessageType STICKER = null;
    public static final MessageType SYSTEM = null;
    public static final MessageType TEXT = null;
    public static final MessageType TEXT_IMAGE = null;
    public static final MessageType TODO = null;
    public static final MessageType UNKNOWN = null;
    public static final MessageType VIDEO_CHAT = null;
    public static final MessageType VOTE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ MessageType[] f415392a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f415393b = null;
    private final int number;

    public static final class a {
        public a() {
        }

        @JvmStatic
        public static MessageType a(int r100) {
            switch(r100) {
                case 1: goto L54;
                case 2: goto L52;
                case 3: goto L50;
                case 4: goto L48;
                case 5: goto L46;
                case 6: goto L44;
                case 7: goto L42;
                case 8: goto L40;
                case 9: goto L38;
                case 10: goto L36;
                case 11: goto L34;
                case 12: goto L32;
                case 13: goto L30;
                case 14: goto L4;
                case 15: goto L28;
                case 16: goto L26;
                case 17: goto L24;
                case 18: goto L22;
                case 19: goto L20;
                case 20: goto L18;
                case 21: goto L4;
                case 22: goto L16;
                case 23: goto L14;
                case 24: goto L12;
                case 25: goto L10;
                case 26: goto L4;
                case 27: goto L8;
                case 28: goto L4;
                case 29: goto L6;
                default: goto L4;
            };
        L4:
            return MessageType.UNKNOWN;
        L6:
            return MessageType.DOUBAO;
        L8:
            return MessageType.VOTE;
        L10:
            return MessageType.FOLDER;
        L12:
            return MessageType.TODO;
        L14:
            return MessageType.PROFILE;
        L16:
            return MessageType.COMMERCIALIZED_HONGBAO;
        L18:
            return MessageType.LOCATION;
        L20:
            return MessageType.VIDEO_CHAT;
        L22:
            return MessageType.GENERAL_CALENDAR;
        L24:
            return MessageType.RED_PACKET;
        L26:
            return MessageType.SHARE_CALENDAR_EVENT;
        L28:
            return MessageType.MEDIA;
        L30:
            return MessageType.CARD;
        L32:
            return MessageType.CALENDAR;
        L34:
            return MessageType.MERGE_FORWARD;
        L36:
            return MessageType.STICKER;
        L38:
            return MessageType.SHARE_GROUP_CHAT;
        L40:
            return MessageType.EMAIL;
        L42:
            return MessageType.AUDIO;
        L44:
            return MessageType.SYSTEM;
        L46:
            return MessageType.IMAGE;
        L48:
            return MessageType.TEXT;
        L50:
            return MessageType.FILE;
        L52:
            return MessageType.POST;
        L54:
            return MessageType.TEXT_IMAGE;
        }
    }

    @JvmStatic
    public static final MessageType forNumber(int r100) {
        Companion.getClass();
        return a.a(r100);
    }

    public static EnumEntries<MessageType> getEntries() {
        return f415393b;
    }

    static {
        MessageType r100 = new MessageType("UNKNOWN", 0, -1);
        UNKNOWN = r100;
        MessageType r101 = new MessageType("TEXT_IMAGE", 1, 1);
        TEXT_IMAGE = r101;
        MessageType r102 = new MessageType("POST", 2, 2);
        POST = r102;
        MessageType r103 = new MessageType("FILE", 3, 3);
        FILE = r103;
        MessageType r104 = new MessageType(CardAdapter.TEXT, 4, 4);
        TEXT = r104;
        MessageType r105 = new MessageType("IMAGE", 5, 5);
        IMAGE = r105;
        MessageType r110 = new MessageType(MediaScene.SYSTEM, 6, 6);
        SYSTEM = r110;
        MessageType r111 = new MessageType("AUDIO", 7, 7);
        AUDIO = r111;
        MessageType r112 = new MessageType(CommonConstant.RETKEY.EMAIL, 8, 8);
        EMAIL = r112;
        MessageType r113 = new MessageType("SHARE_GROUP_CHAT", 9, 9);
        SHARE_GROUP_CHAT = r113;
        MessageType r114 = new MessageType("STICKER", 10, 10);
        STICKER = r114;
        MessageType r115 = new MessageType("MERGE_FORWARD", 11, 11);
        MERGE_FORWARD = r115;
        MessageType r106 = new MessageType("CALENDAR", 12, 12);
        CALENDAR = r106;
        MessageType r107 = new MessageType("CARD", 13, 13);
        CARD = r107;
        MessageType r108 = new MessageType("MEDIA", 14, 15);
        MEDIA = r108;
        MessageType r109 = new MessageType("SHARE_CALENDAR_EVENT", 15, 16);
        SHARE_CALENDAR_EVENT = r109;
        MessageType r116 = new MessageType("RED_PACKET", 16, 17);
        RED_PACKET = r116;
        MessageType r117 = new MessageType("GENERAL_CALENDAR", 17, 18);
        GENERAL_CALENDAR = r117;
        MessageType r118 = new MessageType("VIDEO_CHAT", 18, 19);
        VIDEO_CHAT = r118;
        MessageType r119 = new MessageType(HTTP.LOCATION, 19, 20);
        LOCATION = r119;
        MessageType r120 = new MessageType("COMMERCIALIZED_HONGBAO", 20, 22);
        COMMERCIALIZED_HONGBAO = r120;
        MessageType r121 = new MessageType("PROFILE", 21, 23);
        PROFILE = r121;
        MessageType r122 = new MessageType(AlarmSessionType.TODO, 22, 24);
        TODO = r122;
        MessageType r123 = new MessageType("FOLDER", 23, 25);
        FOLDER = r123;
        MessageType r124 = new MessageType("VOTE", 24, 27);
        VOTE = r124;
        MessageType r125 = new MessageType("DOUBAO", 25, 29);
        DOUBAO = r125;
        MessageType[] r126 = {r100, r101, r102, r103, r104, r105, r110, r111, r112, r113, r114, r115, r106, r107, r108, r109, r116, r117, r118, r119, r120, r121, r122, r123, r124, r125};
        f415392a = r126;
        f415393b = EnumEntriesKt.enumEntries(r126);
        Companion = new a();
    }

    public static MessageType[] values() {
        return (MessageType[]) f415392a.clone();
    }

    public final int getNumber() {
        return this.number;
    }

    @JvmStatic
    public static final MessageType valueOf(int r100) {
        Companion.getClass();
        return a.a(r100);
    }

    public static MessageType valueOf(String r100) {
        return (MessageType) r27.a.a(MessageType.class, r100);
    }

    public MessageType(String r100, int r101, int r102) {
        super(r100, r101);
        this.number = r102;
    }
}
