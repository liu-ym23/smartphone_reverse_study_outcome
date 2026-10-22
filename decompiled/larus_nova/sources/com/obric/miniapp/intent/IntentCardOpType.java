package com.obric.miniapp.intent;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes33.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u001c\b\u0086\u0081\u0002\u0018\u0000 \u001c2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u001cB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018j\u0002\b\u0019j\u0002\b\u001aj\u0002\b\u001b¨\u0006\u001d"}, d2 = {"Lcom/obric/miniapp/intent/IntentCardOpType;", "", "<init>", "(Ljava/lang/String;I)V", "QUERY_APP_ICON", "QUERY_PRIVILEGED_IMAGE", "OPEN_APP", "OPEN_APP_DETAIL", "SET_ALARM", "TURN_ON_OFF_ALARM", "DELETE_ALARM", "DELETE_CONTACTS", "DELETE_CALL_HISTORY", "DELETE_MESSAGES", "DELETE_MEMORIES", "OPEN_VIEW_ALL_SHEET", "SHOW_ENTITY", "CALL_PHONE", "SEND_SMS", "OPEN_SMS_COMPOSER", "CONFIRM_MESSAGE_SEND", "PLAY_MUSIC", "PAUSE_MUSIC", "QUERY_MUSIC_STATE", "OPEN_MUSIC_PAGE", "SHOW_PHOTO_GROUP", "DELETE_RECORDINGS", "SHOW_WEATHER", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum IntentCardOpType extends Enum<IntentCardOpType> {
    public static final IntentCardOpType CALL_PHONE = null;
    public static final IntentCardOpType CONFIRM_MESSAGE_SEND = null;
    public static final a Companion = null;
    public static final IntentCardOpType DELETE_ALARM = null;
    public static final IntentCardOpType DELETE_CALL_HISTORY = null;
    public static final IntentCardOpType DELETE_CONTACTS = null;
    public static final IntentCardOpType DELETE_MEMORIES = null;
    public static final IntentCardOpType DELETE_MESSAGES = null;
    public static final IntentCardOpType DELETE_RECORDINGS = null;
    public static final IntentCardOpType OPEN_APP = null;
    public static final IntentCardOpType OPEN_APP_DETAIL = null;
    public static final IntentCardOpType OPEN_MUSIC_PAGE = null;
    public static final IntentCardOpType OPEN_SMS_COMPOSER = null;
    public static final IntentCardOpType OPEN_VIEW_ALL_SHEET = null;
    public static final IntentCardOpType PAUSE_MUSIC = null;
    public static final IntentCardOpType PLAY_MUSIC = null;
    public static final IntentCardOpType QUERY_APP_ICON = null;
    public static final IntentCardOpType QUERY_MUSIC_STATE = null;
    public static final IntentCardOpType QUERY_PRIVILEGED_IMAGE = null;
    public static final IntentCardOpType SEND_SMS = null;
    public static final IntentCardOpType SET_ALARM = null;
    public static final IntentCardOpType SHOW_ENTITY = null;
    public static final IntentCardOpType SHOW_PHOTO_GROUP = null;
    public static final IntentCardOpType SHOW_WEATHER = null;
    public static final IntentCardOpType TURN_ON_OFF_ALARM = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ IntentCardOpType[] f397679a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f397680b = null;

    public static final class a {
        public a() {
        }
    }

    public static EnumEntries<IntentCardOpType> getEntries() {
        return f397680b;
    }

    static {
        IntentCardOpType r100 = new IntentCardOpType("QUERY_APP_ICON", 0);
        QUERY_APP_ICON = r100;
        IntentCardOpType r101 = new IntentCardOpType("QUERY_PRIVILEGED_IMAGE", 1);
        QUERY_PRIVILEGED_IMAGE = r101;
        IntentCardOpType r102 = new IntentCardOpType("OPEN_APP", 2);
        OPEN_APP = r102;
        IntentCardOpType r103 = new IntentCardOpType("OPEN_APP_DETAIL", 3);
        OPEN_APP_DETAIL = r103;
        IntentCardOpType r104 = new IntentCardOpType("SET_ALARM", 4);
        SET_ALARM = r104;
        IntentCardOpType r105 = new IntentCardOpType("TURN_ON_OFF_ALARM", 5);
        TURN_ON_OFF_ALARM = r105;
        IntentCardOpType r110 = new IntentCardOpType("DELETE_ALARM", 6);
        DELETE_ALARM = r110;
        IntentCardOpType r111 = new IntentCardOpType("DELETE_CONTACTS", 7);
        DELETE_CONTACTS = r111;
        IntentCardOpType r112 = new IntentCardOpType("DELETE_CALL_HISTORY", 8);
        DELETE_CALL_HISTORY = r112;
        IntentCardOpType r113 = new IntentCardOpType("DELETE_MESSAGES", 9);
        DELETE_MESSAGES = r113;
        IntentCardOpType r114 = new IntentCardOpType("DELETE_MEMORIES", 10);
        DELETE_MEMORIES = r114;
        IntentCardOpType r115 = new IntentCardOpType("OPEN_VIEW_ALL_SHEET", 11);
        OPEN_VIEW_ALL_SHEET = r115;
        IntentCardOpType r106 = new IntentCardOpType("SHOW_ENTITY", 12);
        SHOW_ENTITY = r106;
        IntentCardOpType r107 = new IntentCardOpType("CALL_PHONE", 13);
        CALL_PHONE = r107;
        IntentCardOpType r108 = new IntentCardOpType("SEND_SMS", 14);
        SEND_SMS = r108;
        IntentCardOpType r109 = new IntentCardOpType("OPEN_SMS_COMPOSER", 15);
        OPEN_SMS_COMPOSER = r109;
        IntentCardOpType r116 = new IntentCardOpType("CONFIRM_MESSAGE_SEND", 16);
        CONFIRM_MESSAGE_SEND = r116;
        IntentCardOpType r117 = new IntentCardOpType("PLAY_MUSIC", 17);
        PLAY_MUSIC = r117;
        IntentCardOpType r118 = new IntentCardOpType("PAUSE_MUSIC", 18);
        PAUSE_MUSIC = r118;
        IntentCardOpType r119 = new IntentCardOpType("QUERY_MUSIC_STATE", 19);
        QUERY_MUSIC_STATE = r119;
        IntentCardOpType r120 = new IntentCardOpType("OPEN_MUSIC_PAGE", 20);
        OPEN_MUSIC_PAGE = r120;
        IntentCardOpType r121 = new IntentCardOpType("SHOW_PHOTO_GROUP", 21);
        SHOW_PHOTO_GROUP = r121;
        IntentCardOpType r122 = new IntentCardOpType("DELETE_RECORDINGS", 22);
        DELETE_RECORDINGS = r122;
        IntentCardOpType r123 = new IntentCardOpType("SHOW_WEATHER", 23);
        SHOW_WEATHER = r123;
        IntentCardOpType[] r124 = {r100, r101, r102, r103, r104, r105, r110, r111, r112, r113, r114, r115, r106, r107, r108, r109, r116, r117, r118, r119, r120, r121, r122, r123};
        f397679a = r124;
        f397680b = EnumEntriesKt.enumEntries(r124);
        Companion = new a();
    }

    public static IntentCardOpType[] values() {
        return (IntentCardOpType[]) f397679a.clone();
    }

    public static IntentCardOpType valueOf(String r100) {
        return (IntentCardOpType) r27.a.a(IntentCardOpType.class, r100);
    }

    public IntentCardOpType(String r100, int r101) {
        super(r100, r101);
    }
}
