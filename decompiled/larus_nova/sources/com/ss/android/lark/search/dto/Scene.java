package com.ss.android.lark.search.dto;

import java.io.Serializable;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u00002\u00020\u0001:\u0001\u0010B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u0011"}, d2 = {"Lcom/ss/android/lark/search/dto/Scene;", "Ljava/io/Serializable;", "sceneId", "", "type", "Lcom/ss/android/lark/search/dto/Scene$Type;", "<init>", "(Ljava/lang/String;Lcom/ss/android/lark/search/dto/Scene$Type;)V", "getSceneId", "()Ljava/lang/String;", "setSceneId", "(Ljava/lang/String;)V", "getType", "()Lcom/ss/android/lark/search/dto/Scene$Type;", "setType", "(Lcom/ss/android/lark/search/dto/Scene$Type;)V", "Type", "search-dto_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class Scene implements Serializable {
    private String sceneId;
    private Type type;

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b3\b\u0086\u0081\u0002\u0018\u0000 62\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002:\u00016B\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018j\u0002\b\u0019j\u0002\b\u001aj\u0002\b\u001bj\u0002\b\u001cj\u0002\b\u001dj\u0002\b\u001ej\u0002\b\u001fj\u0002\b j\u0002\b!j\u0002\b\"j\u0002\b#j\u0002\b$j\u0002\b%j\u0002\b&j\u0002\b'j\u0002\b(j\u0002\b)j\u0002\b*j\u0002\b+j\u0002\b,j\u0002\b-j\u0002\b.j\u0002\b/j\u0002\b0j\u0002\b1j\u0002\b2j\u0002\b3j\u0002\b4j\u0002\b5¨\u00067"}, d2 = {"Lcom/ss/android/lark/search/dto/Scene$Type;", "Ljava/io/Serializable;", "", "number", "", "<init>", "(Ljava/lang/String;II)V", "getNumber", "()I", "UNKNOWN", "ADD_CHAT_CHATTERS", "TRANSMIT_MESSAGES", "SMART_SEARCH", "SEARCH_MESSAGES", "SEARCH_CHATS", "SEARCH_CHATTERS", "SEARCH_USERS", "SEARCH_SPACE", "SEARCH_DOC", "SEARCH_IN_CALENDAR_SCENE", "SEARCH_HAD_CHAT_HISTORY_SCENE", "SEARCH_HELP_DESK", "SEARCH_THREAD", "SEARCH_OPEN_APP_SCENE", "SEARCH_LINK", "SEARCH_FILE", "SEARCH_WIKI_SCENE", "SEARCH_CALENDAR_EVENT", "SEARCH_CHATS_IN_ADVANCE_SCENE", "SEARCH_GLOBAL", "SEARCH_OPEN_SEARCH_SCENE", "SEARCH_DOCS_WIKI_IN_CHAT_SCENE", "SEARCH_FILE_AND_FOLDER", "RECOMMEND", "SEARCH_CARDS", "IN_CHAT_PICTURE", "SEARCH_WIKI_SPACE", "SEARCH_EMAIL", "SEARCH_DOC_COLLABORATOR", "SEARCH_PLATFORM_FILTER_SCENE", "SPOTLIGHT", "SPOTLIGHT_CHATTER", "SPOTLIGHT_CHAT", "SEARCH_MESSAGE_FILE", "SPOTLIGHT_OPEN_APP", "SPOTLIGHT_ONCALL", "SPOTLIGHT_DOC", "SPOTLIGHT_OPEN_SEARCH", "SPOTLIGHT_CHATTER_IN_MESSAGE", "SEARCH_RESOURCE_IN_CHAT_SCENE", "SPOTLIGHT_TRANSMIT_MESSAGES", "EMAIL_PICKER_SEARCH", "SPOTLIGHT_MESSAGE", "DOUBAO_SEARCH", "Companion", "search-dto_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum Type extends Enum<Type> implements Serializable {
        public static final Type ADD_CHAT_CHATTERS = null;
        public static final a Companion = null;
        public static final Type DOUBAO_SEARCH = null;
        public static final Type EMAIL_PICKER_SEARCH = null;
        public static final Type IN_CHAT_PICTURE = null;
        public static final Type RECOMMEND = null;
        public static final Type SEARCH_CALENDAR_EVENT = null;
        public static final Type SEARCH_CARDS = null;
        public static final Type SEARCH_CHATS = null;
        public static final Type SEARCH_CHATS_IN_ADVANCE_SCENE = null;
        public static final Type SEARCH_CHATTERS = null;
        public static final Type SEARCH_DOC = null;
        public static final Type SEARCH_DOCS_WIKI_IN_CHAT_SCENE = null;
        public static final Type SEARCH_DOC_COLLABORATOR = null;
        public static final Type SEARCH_EMAIL = null;
        public static final Type SEARCH_FILE = null;
        public static final Type SEARCH_FILE_AND_FOLDER = null;
        public static final Type SEARCH_GLOBAL = null;
        public static final Type SEARCH_HAD_CHAT_HISTORY_SCENE = null;
        public static final Type SEARCH_HELP_DESK = null;
        public static final Type SEARCH_IN_CALENDAR_SCENE = null;
        public static final Type SEARCH_LINK = null;
        public static final Type SEARCH_MESSAGES = null;
        public static final Type SEARCH_MESSAGE_FILE = null;
        public static final Type SEARCH_OPEN_APP_SCENE = null;
        public static final Type SEARCH_OPEN_SEARCH_SCENE = null;
        public static final Type SEARCH_PLATFORM_FILTER_SCENE = null;
        public static final Type SEARCH_RESOURCE_IN_CHAT_SCENE = null;
        public static final Type SEARCH_SPACE = null;
        public static final Type SEARCH_THREAD = null;
        public static final Type SEARCH_USERS = null;
        public static final Type SEARCH_WIKI_SCENE = null;
        public static final Type SEARCH_WIKI_SPACE = null;
        public static final Type SMART_SEARCH = null;
        public static final Type SPOTLIGHT = null;
        public static final Type SPOTLIGHT_CHAT = null;
        public static final Type SPOTLIGHT_CHATTER = null;
        public static final Type SPOTLIGHT_CHATTER_IN_MESSAGE = null;
        public static final Type SPOTLIGHT_DOC = null;
        public static final Type SPOTLIGHT_MESSAGE = null;
        public static final Type SPOTLIGHT_ONCALL = null;
        public static final Type SPOTLIGHT_OPEN_APP = null;
        public static final Type SPOTLIGHT_OPEN_SEARCH = null;
        public static final Type SPOTLIGHT_TRANSMIT_MESSAGES = null;
        public static final Type TRANSMIT_MESSAGES = null;
        public static final Type UNKNOWN = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ Type[] f440124a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ EnumEntries f440125b = null;
        private final int number;

        public static final class a {
            public a() {
            }
        }

        public static EnumEntries<Type> getEntries() {
            return f440125b;
        }

        static {
            Type r100 = new Type("UNKNOWN", 0, 0);
            UNKNOWN = r100;
            Type r101 = new Type("ADD_CHAT_CHATTERS", 1, 2);
            ADD_CHAT_CHATTERS = r101;
            Type r102 = new Type("TRANSMIT_MESSAGES", 2, 3);
            TRANSMIT_MESSAGES = r102;
            Type r103 = new Type("SMART_SEARCH", 3, 4);
            SMART_SEARCH = r103;
            Type r104 = new Type("SEARCH_MESSAGES", 4, 5);
            SEARCH_MESSAGES = r104;
            Type r110 = new Type("SEARCH_CHATS", 5, 6);
            SEARCH_CHATS = r110;
            Type r111 = new Type("SEARCH_CHATTERS", 6, 7);
            SEARCH_CHATTERS = r111;
            Type r112 = new Type("SEARCH_USERS", 7, 8);
            SEARCH_USERS = r112;
            Type r113 = new Type("SEARCH_SPACE", 8, 12);
            SEARCH_SPACE = r113;
            Type r114 = new Type("SEARCH_DOC", 9, 13);
            SEARCH_DOC = r114;
            Type r105 = new Type("SEARCH_IN_CALENDAR_SCENE", 10, 15);
            SEARCH_IN_CALENDAR_SCENE = r105;
            Type r106 = new Type("SEARCH_HAD_CHAT_HISTORY_SCENE", 11, 16);
            SEARCH_HAD_CHAT_HISTORY_SCENE = r106;
            Type r107 = new Type("SEARCH_HELP_DESK", 12, 23);
            SEARCH_HELP_DESK = r107;
            Type r108 = new Type("SEARCH_THREAD", 13, 25);
            SEARCH_THREAD = r108;
            Type r109 = new Type("SEARCH_OPEN_APP_SCENE", 14, 27);
            SEARCH_OPEN_APP_SCENE = r109;
            Type r115 = new Type("SEARCH_LINK", 15, 30);
            SEARCH_LINK = r115;
            Type r116 = new Type("SEARCH_FILE", 16, 31);
            SEARCH_FILE = r116;
            Type r117 = new Type("SEARCH_WIKI_SCENE", 17, 33);
            SEARCH_WIKI_SCENE = r117;
            Type r118 = new Type("SEARCH_CALENDAR_EVENT", 18, 36);
            SEARCH_CALENDAR_EVENT = r118;
            Type r119 = new Type("SEARCH_CHATS_IN_ADVANCE_SCENE", 19, 37);
            SEARCH_CHATS_IN_ADVANCE_SCENE = r119;
            Type r120 = new Type("SEARCH_GLOBAL", 20, 38);
            SEARCH_GLOBAL = r120;
            Type r121 = new Type("SEARCH_OPEN_SEARCH_SCENE", 21, 44);
            SEARCH_OPEN_SEARCH_SCENE = r121;
            Type r122 = new Type("SEARCH_DOCS_WIKI_IN_CHAT_SCENE", 22, 45);
            SEARCH_DOCS_WIKI_IN_CHAT_SCENE = r122;
            Type r123 = new Type("SEARCH_FILE_AND_FOLDER", 23, 47);
            SEARCH_FILE_AND_FOLDER = r123;
            Type r124 = new Type("RECOMMEND", 24, 48);
            RECOMMEND = r124;
            Type r125 = new Type("SEARCH_CARDS", 25, 49);
            SEARCH_CARDS = r125;
            Type r126 = new Type("IN_CHAT_PICTURE", 26, 50);
            IN_CHAT_PICTURE = r126;
            Type r127 = new Type("SEARCH_WIKI_SPACE", 27, 51);
            SEARCH_WIKI_SPACE = r127;
            Type r128 = new Type("SEARCH_EMAIL", 28, 52);
            SEARCH_EMAIL = r128;
            Type r129 = new Type("SEARCH_DOC_COLLABORATOR", 29, 53);
            SEARCH_DOC_COLLABORATOR = r129;
            Type r130 = new Type("SEARCH_PLATFORM_FILTER_SCENE", 30, 54);
            SEARCH_PLATFORM_FILTER_SCENE = r130;
            Type r131 = new Type("SPOTLIGHT", 31, 55);
            SPOTLIGHT = r131;
            Type r132 = new Type("SPOTLIGHT_CHATTER", 32, 56);
            SPOTLIGHT_CHATTER = r132;
            Type r133 = new Type("SPOTLIGHT_CHAT", 33, 57);
            SPOTLIGHT_CHAT = r133;
            Type r134 = new Type("SEARCH_MESSAGE_FILE", 34, 58);
            SEARCH_MESSAGE_FILE = r134;
            Type r135 = new Type("SPOTLIGHT_OPEN_APP", 35, 59);
            SPOTLIGHT_OPEN_APP = r135;
            Type r136 = new Type("SPOTLIGHT_ONCALL", 36, 60);
            SPOTLIGHT_ONCALL = r136;
            Type r137 = new Type("SPOTLIGHT_DOC", 37, 61);
            SPOTLIGHT_DOC = r137;
            Type r138 = new Type("SPOTLIGHT_OPEN_SEARCH", 38, 62);
            SPOTLIGHT_OPEN_SEARCH = r138;
            Type r139 = new Type("SPOTLIGHT_CHATTER_IN_MESSAGE", 39, 63);
            SPOTLIGHT_CHATTER_IN_MESSAGE = r139;
            Type r140 = new Type("SEARCH_RESOURCE_IN_CHAT_SCENE", 40, 64);
            SEARCH_RESOURCE_IN_CHAT_SCENE = r140;
            Type r141 = new Type("SPOTLIGHT_TRANSMIT_MESSAGES", 41, 65);
            SPOTLIGHT_TRANSMIT_MESSAGES = r141;
            Type r142 = new Type("EMAIL_PICKER_SEARCH", 42, 66);
            EMAIL_PICKER_SEARCH = r142;
            Type r143 = new Type("SPOTLIGHT_MESSAGE", 43, 67);
            SPOTLIGHT_MESSAGE = r143;
            Type r144 = new Type("DOUBAO_SEARCH", 44, 68);
            DOUBAO_SEARCH = r144;
            Type[] r145 = {r100, r101, r102, r103, r104, r110, r111, r112, r113, r114, r105, r106, r107, r108, r109, r115, r116, r117, r118, r119, r120, r121, r122, r123, r124, r125, r126, r127, r128, r129, r130, r131, r132, r133, r134, r135, r136, r137, r138, r139, r140, r141, r142, r143, r144};
            f440124a = r145;
            f440125b = EnumEntriesKt.enumEntries(r145);
            Companion = new a();
        }

        public static Type[] values() {
            return (Type[]) f440124a.clone();
        }

        public final int getNumber() {
            return this.number;
        }

        @JvmStatic
        public static final Type valueOf(int r100) {
            Companion.getClass();
            if (r100 == 12) goto L74;
            if (r100 == 13) goto L118;
            if (r100 == 15) goto L117;
            if (r100 == 16) goto L116;
            if (r100 == 23) goto L115;
            if (r100 == 25) goto L114;
            if (r100 == 27) goto L113;
            if (r100 == 33) goto L112;
            if (r100 == 30) goto L111;
            if (r100 == 31) goto L110;
            if (r100 == 44) goto L109;
            if (r100 == 45) goto L108;
            switch(r100) {
                case 2: goto L82;
                case 3: goto L81;
                case 4: goto L80;
                case 5: goto L79;
                case 6: goto L78;
                case 7: goto L77;
                case 8: goto L76;
                default: goto L27;
            };
        L27:
            switch(r100) {
                case 36: goto L85;
                case 37: goto L84;
                case 38: goto L83;
                default: goto L28;
            };
        L28:
            switch(r100) {
                case 47: goto L107;
                case 48: goto L106;
                case 49: goto L105;
                case 50: goto L104;
                case 51: goto L103;
                case 52: goto L102;
                case 53: goto L101;
                case 54: goto L100;
                case 55: goto L99;
                case 56: goto L98;
                case 57: goto L97;
                case 58: goto L96;
                case 59: goto L95;
                case 60: goto L94;
                case 61: goto L93;
                case 62: goto L92;
                case 63: goto L91;
                case 64: goto L90;
                case 65: goto L89;
                case 66: goto L88;
                case 67: goto L87;
                case 68: goto L86;
                default: goto L75;
            };
        L75:
            return UNKNOWN;
        L86:
            return DOUBAO_SEARCH;
        L87:
            return SPOTLIGHT_MESSAGE;
        L88:
            return EMAIL_PICKER_SEARCH;
        L89:
            return SPOTLIGHT_TRANSMIT_MESSAGES;
        L90:
            return SEARCH_RESOURCE_IN_CHAT_SCENE;
        L91:
            return SPOTLIGHT_CHATTER_IN_MESSAGE;
        L92:
            return SPOTLIGHT_OPEN_SEARCH;
        L93:
            return SPOTLIGHT_DOC;
        L94:
            return SPOTLIGHT_ONCALL;
        L95:
            return SPOTLIGHT_OPEN_APP;
        L96:
            return SEARCH_MESSAGE_FILE;
        L97:
            return SPOTLIGHT_CHAT;
        L98:
            return SPOTLIGHT_CHATTER;
        L99:
            return SPOTLIGHT;
        L100:
            return SEARCH_PLATFORM_FILTER_SCENE;
        L101:
            return SEARCH_DOC_COLLABORATOR;
        L102:
            return SEARCH_EMAIL;
        L103:
            return SEARCH_WIKI_SPACE;
        L104:
            return IN_CHAT_PICTURE;
        L105:
            return SEARCH_CARDS;
        L106:
            return RECOMMEND;
        L107:
            return SEARCH_FILE_AND_FOLDER;
        L83:
            return SEARCH_GLOBAL;
        L84:
            return SEARCH_CHATS_IN_ADVANCE_SCENE;
        L85:
            return SEARCH_CALENDAR_EVENT;
        L76:
            return SEARCH_USERS;
        L77:
            return SEARCH_CHATTERS;
        L78:
            return SEARCH_CHATS;
        L79:
            return SEARCH_MESSAGES;
        L80:
            return SMART_SEARCH;
        L81:
            return TRANSMIT_MESSAGES;
        L82:
            return ADD_CHAT_CHATTERS;
        L108:
            return SEARCH_DOCS_WIKI_IN_CHAT_SCENE;
        L109:
            return SEARCH_OPEN_SEARCH_SCENE;
        L110:
            return SEARCH_FILE;
        L111:
            return SEARCH_LINK;
        L112:
            return SEARCH_WIKI_SCENE;
        L113:
            return SEARCH_OPEN_APP_SCENE;
        L114:
            return SEARCH_THREAD;
        L115:
            return SEARCH_HELP_DESK;
        L116:
            return SEARCH_HAD_CHAT_HISTORY_SCENE;
        L117:
            return SEARCH_IN_CALENDAR_SCENE;
        L118:
            return SEARCH_DOC;
        L74:
            return SEARCH_SPACE;
        }

        public static Type valueOf(String r100) {
            return (Type) r27.a.a(Type.class, r100);
        }

        public Type(String r100, int r101, int r102) {
            super(r100, r101);
            this.number = r102;
        }
    }

    public final String getSceneId() {
        return this.sceneId;
    }

    public final Type getType() {
        return this.type;
    }

    public final void setSceneId(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.sceneId = r100;
    }

    public final void setType(Type r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.type = r100;
    }

    public Scene(String r100, Type r101) {
        Intrinsics.checkNotNullParameter(r100, "sceneId");
        Intrinsics.checkNotNullParameter(r101, "type");
        this.sceneId = r100;
        this.type = r101;
    }
}
