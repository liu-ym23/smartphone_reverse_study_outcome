package com.larus.bmhome.chat.setting.bean;

import com.larus.bmhome.auth.feature_config.model.FeatureKitDelegate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b)\b\u0086\u0081\u0002\u0018\u0000 +2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001+B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018j\u0002\b\u0019j\u0002\b\u001aj\u0002\b\u001bj\u0002\b\u001cj\u0002\b\u001dj\u0002\b\u001ej\u0002\b\u001fj\u0002\b j\u0002\b!j\u0002\b\"j\u0002\b#j\u0002\b$j\u0002\b%j\u0002\b&j\u0002\b'j\u0002\b(j\u0002\b)j\u0002\b*¨\u0006,"}, d2 = {"Lcom/larus/bmhome/chat/setting/bean/UserConfigKey;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "ANSWER_WITH_SUGGEST", "ANSWER_WITH_VIDEO", "HIGHLIGHT_KEYWORD", "OPT_OUT_VOICE", "PERSONAL_RECOMMEND", "SAVE_CHAT_HISTORY", "PICTURE_LOCATION_SWITCH", "INPUT_SUGGEST", "USE_OFG_SWITCH", "EXPERT_SWITCH", "ALLOW_TRAIN_SWITCH", "ALLOW_TRAIN_BY_TEXT", "ALLOW_TRAIN_BY_VIDEO", "ALLOW_TRAIN_BY_UPLOAD", "RELATED_VIDEO", "FACE_MEMORY_SWITCH", "DEFAULT_REPLY_MODE", "DEFAULT_REPLY_MODE_MENU", "DEFAULT_MODEL_ITEM_KEY", "DEFAULT_REPLY_MODE_MENU_V2", "DEFAULT_REPLY_OPTION", "REALTIME_VOICE_FEATURE", "FIND_BY_PHONE", "FIND_BY_DOUBAO_USER_NAME", "SYSTEM_PUSH_SWITCH", "IN_APP_BANNER_SWITCH", "IN_APP_BANNER_SHOW_DETAIL", "SCHEDULED_JOB_NOTIFICATION_SWITCH", "ORDER_MESSAGE_NOTIFICATION_SWITCH", "STARTUP_OPEN_NEW_CHAT", "IN_APP_BANNER_SHOW_DETAIL_ADMIN_SWITCH", "DEFAULT_ACTIVE_MODE_MENU", "DEFAULT_ACTIVE_MODE_APP", "DEFAULT_ACTIVE_MODEL_MENU", "DEFAULT_ACTIVE_MODEL_APP", "Companion", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum UserConfigKey extends Enum<UserConfigKey> {
    public static final UserConfigKey ALLOW_TRAIN_BY_TEXT = null;
    public static final UserConfigKey ALLOW_TRAIN_BY_UPLOAD = null;
    public static final UserConfigKey ALLOW_TRAIN_BY_VIDEO = null;
    public static final UserConfigKey ALLOW_TRAIN_SWITCH = null;
    public static final UserConfigKey ANSWER_WITH_SUGGEST = null;
    public static final UserConfigKey ANSWER_WITH_VIDEO = null;
    public static final a Companion = null;
    public static final UserConfigKey DEFAULT_ACTIVE_MODEL_APP = null;
    public static final UserConfigKey DEFAULT_ACTIVE_MODEL_MENU = null;
    public static final UserConfigKey DEFAULT_ACTIVE_MODE_APP = null;
    public static final UserConfigKey DEFAULT_ACTIVE_MODE_MENU = null;
    public static final UserConfigKey DEFAULT_MODEL_ITEM_KEY = null;
    public static final UserConfigKey DEFAULT_REPLY_MODE = null;
    public static final UserConfigKey DEFAULT_REPLY_MODE_MENU = null;
    public static final UserConfigKey DEFAULT_REPLY_MODE_MENU_V2 = null;
    public static final UserConfigKey DEFAULT_REPLY_OPTION = null;
    public static final UserConfigKey EXPERT_SWITCH = null;
    public static final UserConfigKey FACE_MEMORY_SWITCH = null;
    public static final UserConfigKey FIND_BY_DOUBAO_USER_NAME = null;
    public static final UserConfigKey FIND_BY_PHONE = null;
    public static final UserConfigKey HIGHLIGHT_KEYWORD = null;
    public static final UserConfigKey INPUT_SUGGEST = null;
    public static final UserConfigKey IN_APP_BANNER_SHOW_DETAIL = null;
    public static final UserConfigKey IN_APP_BANNER_SHOW_DETAIL_ADMIN_SWITCH = null;
    public static final UserConfigKey IN_APP_BANNER_SWITCH = null;
    public static final UserConfigKey OPT_OUT_VOICE = null;
    public static final UserConfigKey ORDER_MESSAGE_NOTIFICATION_SWITCH = null;
    public static final UserConfigKey PERSONAL_RECOMMEND = null;
    public static final UserConfigKey PICTURE_LOCATION_SWITCH = null;
    public static final UserConfigKey REALTIME_VOICE_FEATURE = null;
    public static final UserConfigKey RELATED_VIDEO = null;
    public static final UserConfigKey SAVE_CHAT_HISTORY = null;
    public static final UserConfigKey SCHEDULED_JOB_NOTIFICATION_SWITCH = null;
    public static final UserConfigKey STARTUP_OPEN_NEW_CHAT = null;
    public static final UserConfigKey SYSTEM_PUSH_SWITCH = null;
    public static final UserConfigKey USE_OFG_SWITCH = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ UserConfigKey[] f308903a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f308904b = null;
    private final int value;

    public static final class a {
        public static List b() {
            if (FeatureKitDelegate.f295792b.W().b() == false) goto L19;
            EnumEntries<UserConfigKey> r100 = UserConfigKey.getEntries();
            ArrayList r101 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r100, 10));
            Iterator<UserConfigKey> r102 = r100.iterator();
        L6:
            if (r102.hasNext() == false) goto L8;
            r101.add(Integer.valueOf(r102.next().getValue()));
            goto L6
        L8:
            ArrayList r103 = new ArrayList();
            Iterator r104 = r101.iterator();
        L10:
            if (r104.hasNext() == false) goto L38;
            Object r105 = r104.next();
            int r106 = ((Number) r105).intValue();
            if (r106 != UserConfigKey.DEFAULT_REPLY_MODE_MENU.getValue()) goto L14;
        L16:
            boolean r107 = false;
        L17:
            if (r107 == false) goto L10;
            r103.add(r105);
            goto L10
        L14:
            if (r106 == UserConfigKey.DEFAULT_REPLY_MODE_MENU_V2.getValue()) goto L16;
            r107 = true;
        L38:
            return r103;
        L19:
            EnumEntries<UserConfigKey> r108 = UserConfigKey.getEntries();
            ArrayList r109 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r108, 10));
            Iterator<UserConfigKey> r110 = r108.iterator();
        L21:
            if (r110.hasNext() == false) goto L23;
            r109.add(Integer.valueOf(r110.next().getValue()));
            goto L21
        L23:
            r103 = new ArrayList();
            Iterator r111 = r109.iterator();
        L25:
            if (r111.hasNext() == false) goto L38;
            Object r112 = r111.next();
            int r113 = ((Number) r112).intValue();
            if (r113 != UserConfigKey.DEFAULT_ACTIVE_MODE_MENU.getValue()) goto L29;
        L35:
            boolean r114 = false;
        L36:
            if (r114 == false) goto L25;
            r103.add(r112);
            goto L25
        L29:
            if (r113 == UserConfigKey.DEFAULT_ACTIVE_MODE_APP.getValue()) goto L35;
            if (r113 == UserConfigKey.DEFAULT_ACTIVE_MODEL_MENU.getValue()) goto L35;
            if (r113 == UserConfigKey.DEFAULT_ACTIVE_MODEL_APP.getValue()) goto L35;
            r114 = true;
            goto L36
        }

        public a() {
        }

        public static UserConfigKey a(int r100) {
            if (r100 != 1) goto L6;
            return UserConfigKey.ANSWER_WITH_SUGGEST;
        L6:
            if (r100 != 2) goto L9;
            return UserConfigKey.ANSWER_WITH_VIDEO;
        L9:
            if (r100 != 3) goto L12;
            return UserConfigKey.HIGHLIGHT_KEYWORD;
        L12:
            if (r100 != 4) goto L15;
            return UserConfigKey.OPT_OUT_VOICE;
        L15:
            if (r100 != 5) goto L18;
            return UserConfigKey.PERSONAL_RECOMMEND;
        L18:
            if (r100 != 6) goto L21;
            return UserConfigKey.SAVE_CHAT_HISTORY;
        L21:
            if (r100 != 7) goto L24;
            return UserConfigKey.PICTURE_LOCATION_SWITCH;
        L24:
            if (r100 != 10) goto L27;
            return UserConfigKey.INPUT_SUGGEST;
        L27:
            if (r100 != 50) goto L30;
            return UserConfigKey.USE_OFG_SWITCH;
        L30:
            if (r100 != 60) goto L33;
            return UserConfigKey.EXPERT_SWITCH;
        L33:
            if (r100 != 70) goto L36;
            return UserConfigKey.ALLOW_TRAIN_SWITCH;
        L36:
            if (r100 != 71) goto L39;
            return UserConfigKey.ALLOW_TRAIN_BY_TEXT;
        L39:
            if (r100 != 73) goto L42;
            return UserConfigKey.ALLOW_TRAIN_BY_VIDEO;
        L42:
            if (r100 != 74) goto L45;
            return UserConfigKey.ALLOW_TRAIN_BY_UPLOAD;
        L45:
            if (r100 != 80) goto L48;
            return UserConfigKey.RELATED_VIDEO;
        L48:
            if (r100 == 90) goto L124;
            UserConfigKey r101 = UserConfigKey.DEFAULT_REPLY_MODE;
            if (r100 == r101.getValue()) goto L125;
            r101 = UserConfigKey.DEFAULT_REPLY_MODE_MENU;
            if (r100 == r101.getValue()) goto L125;
            r101 = UserConfigKey.DEFAULT_MODEL_ITEM_KEY;
            if (r100 == r101.getValue()) goto L125;
            r101 = UserConfigKey.DEFAULT_REPLY_OPTION;
            if (r100 == r101.getValue()) goto L125;
            r101 = UserConfigKey.DEFAULT_REPLY_MODE_MENU_V2;
            if (r100 == r101.getValue()) goto L125;
            r101 = UserConfigKey.REALTIME_VOICE_FEATURE;
            if (r100 == r101.getValue()) goto L125;
            r101 = UserConfigKey.FIND_BY_PHONE;
            if (r100 == r101.getValue()) goto L125;
            r101 = UserConfigKey.FIND_BY_DOUBAO_USER_NAME;
            if (r100 == r101.getValue()) goto L125;
            r101 = UserConfigKey.SYSTEM_PUSH_SWITCH;
            if (r100 == r101.getValue()) goto L125;
            r101 = UserConfigKey.IN_APP_BANNER_SWITCH;
            if (r100 == r101.getValue()) goto L125;
            r101 = UserConfigKey.IN_APP_BANNER_SHOW_DETAIL;
            if (r100 == r101.getValue()) goto L125;
            r101 = UserConfigKey.SCHEDULED_JOB_NOTIFICATION_SWITCH;
            if (r100 == r101.getValue()) goto L125;
            r101 = UserConfigKey.ORDER_MESSAGE_NOTIFICATION_SWITCH;
            if (r100 == r101.getValue()) goto L125;
            r101 = UserConfigKey.STARTUP_OPEN_NEW_CHAT;
            if (r100 == r101.getValue()) goto L125;
            r101 = UserConfigKey.IN_APP_BANNER_SHOW_DETAIL_ADMIN_SWITCH;
            if (r100 == r101.getValue()) goto L125;
            r101 = UserConfigKey.DEFAULT_ACTIVE_MODE_MENU;
            if (r100 == r101.getValue()) goto L125;
            r101 = UserConfigKey.DEFAULT_ACTIVE_MODE_APP;
            if (r100 == r101.getValue()) goto L125;
            r101 = UserConfigKey.DEFAULT_ACTIVE_MODEL_MENU;
            if (r100 == r101.getValue()) goto L125;
            r101 = UserConfigKey.DEFAULT_ACTIVE_MODEL_APP;
            if (r100 == r101.getValue()) goto L125;
            return null;
        L125:
            return r101;
        L124:
            return UserConfigKey.FACE_MEMORY_SWITCH;
        }
    }

    public static EnumEntries<UserConfigKey> getEntries() {
        return f308904b;
    }

    static {
        UserConfigKey r100 = new UserConfigKey("ANSWER_WITH_SUGGEST", 0, 1);
        ANSWER_WITH_SUGGEST = r100;
        UserConfigKey r101 = new UserConfigKey("ANSWER_WITH_VIDEO", 1, 2);
        ANSWER_WITH_VIDEO = r101;
        UserConfigKey r102 = new UserConfigKey("HIGHLIGHT_KEYWORD", 2, 3);
        HIGHLIGHT_KEYWORD = r102;
        UserConfigKey r103 = new UserConfigKey("OPT_OUT_VOICE", 3, 4);
        OPT_OUT_VOICE = r103;
        UserConfigKey r104 = new UserConfigKey("PERSONAL_RECOMMEND", 4, 5);
        PERSONAL_RECOMMEND = r104;
        UserConfigKey r110 = new UserConfigKey("SAVE_CHAT_HISTORY", 5, 6);
        SAVE_CHAT_HISTORY = r110;
        UserConfigKey r111 = new UserConfigKey("PICTURE_LOCATION_SWITCH", 6, 7);
        PICTURE_LOCATION_SWITCH = r111;
        UserConfigKey r112 = new UserConfigKey("INPUT_SUGGEST", 7, 10);
        INPUT_SUGGEST = r112;
        UserConfigKey r113 = new UserConfigKey("USE_OFG_SWITCH", 8, 50);
        USE_OFG_SWITCH = r113;
        UserConfigKey r105 = new UserConfigKey("EXPERT_SWITCH", 9, 60);
        EXPERT_SWITCH = r105;
        UserConfigKey r106 = new UserConfigKey("ALLOW_TRAIN_SWITCH", 10, 70);
        ALLOW_TRAIN_SWITCH = r106;
        UserConfigKey r107 = new UserConfigKey("ALLOW_TRAIN_BY_TEXT", 11, 71);
        ALLOW_TRAIN_BY_TEXT = r107;
        UserConfigKey r108 = new UserConfigKey("ALLOW_TRAIN_BY_VIDEO", 12, 73);
        ALLOW_TRAIN_BY_VIDEO = r108;
        UserConfigKey r109 = new UserConfigKey("ALLOW_TRAIN_BY_UPLOAD", 13, 74);
        ALLOW_TRAIN_BY_UPLOAD = r109;
        UserConfigKey r114 = new UserConfigKey("RELATED_VIDEO", 14, 80);
        RELATED_VIDEO = r114;
        UserConfigKey r115 = new UserConfigKey("FACE_MEMORY_SWITCH", 15, 90);
        FACE_MEMORY_SWITCH = r115;
        UserConfigKey r116 = new UserConfigKey("DEFAULT_REPLY_MODE", 16, 110);
        DEFAULT_REPLY_MODE = r116;
        UserConfigKey r117 = new UserConfigKey("DEFAULT_REPLY_MODE_MENU", 17, 112);
        DEFAULT_REPLY_MODE_MENU = r117;
        UserConfigKey r118 = new UserConfigKey("DEFAULT_MODEL_ITEM_KEY", 18, 113);
        DEFAULT_MODEL_ITEM_KEY = r118;
        UserConfigKey r119 = new UserConfigKey("DEFAULT_REPLY_MODE_MENU_V2", 19, 116);
        DEFAULT_REPLY_MODE_MENU_V2 = r119;
        UserConfigKey r120 = new UserConfigKey("DEFAULT_REPLY_OPTION", 20, 117);
        DEFAULT_REPLY_OPTION = r120;
        UserConfigKey r121 = new UserConfigKey("REALTIME_VOICE_FEATURE", 21, 120);
        REALTIME_VOICE_FEATURE = r121;
        UserConfigKey r122 = new UserConfigKey("FIND_BY_PHONE", 22, 130);
        FIND_BY_PHONE = r122;
        UserConfigKey r123 = new UserConfigKey("FIND_BY_DOUBAO_USER_NAME", 23, 131);
        FIND_BY_DOUBAO_USER_NAME = r123;
        UserConfigKey r124 = new UserConfigKey("SYSTEM_PUSH_SWITCH", 24, 140);
        SYSTEM_PUSH_SWITCH = r124;
        UserConfigKey r125 = new UserConfigKey("IN_APP_BANNER_SWITCH", 25, 141);
        IN_APP_BANNER_SWITCH = r125;
        UserConfigKey r126 = new UserConfigKey("IN_APP_BANNER_SHOW_DETAIL", 26, 142);
        IN_APP_BANNER_SHOW_DETAIL = r126;
        UserConfigKey r127 = new UserConfigKey("SCHEDULED_JOB_NOTIFICATION_SWITCH", 27, 143);
        SCHEDULED_JOB_NOTIFICATION_SWITCH = r127;
        UserConfigKey r128 = new UserConfigKey("ORDER_MESSAGE_NOTIFICATION_SWITCH", 28, 144);
        ORDER_MESSAGE_NOTIFICATION_SWITCH = r128;
        UserConfigKey r129 = new UserConfigKey("STARTUP_OPEN_NEW_CHAT", 29, 147);
        STARTUP_OPEN_NEW_CHAT = r129;
        UserConfigKey r130 = new UserConfigKey("IN_APP_BANNER_SHOW_DETAIL_ADMIN_SWITCH", 30, 149);
        IN_APP_BANNER_SHOW_DETAIL_ADMIN_SWITCH = r130;
        UserConfigKey r131 = new UserConfigKey("DEFAULT_ACTIVE_MODE_MENU", 31, 1001);
        DEFAULT_ACTIVE_MODE_MENU = r131;
        UserConfigKey r132 = new UserConfigKey("DEFAULT_ACTIVE_MODE_APP", 32, 1002);
        DEFAULT_ACTIVE_MODE_APP = r132;
        UserConfigKey r133 = new UserConfigKey("DEFAULT_ACTIVE_MODEL_MENU", 33, 1004);
        DEFAULT_ACTIVE_MODEL_MENU = r133;
        UserConfigKey r134 = new UserConfigKey("DEFAULT_ACTIVE_MODEL_APP", 34, 1005);
        DEFAULT_ACTIVE_MODEL_APP = r134;
        UserConfigKey[] r135 = {r100, r101, r102, r103, r104, r110, r111, r112, r113, r105, r106, r107, r108, r109, r114, r115, r116, r117, r118, r119, r120, r121, r122, r123, r124, r125, r126, r127, r128, r129, r130, r131, r132, r133, r134};
        f308903a = r135;
        f308904b = EnumEntriesKt.enumEntries(r135);
        Companion = new a();
    }

    public static UserConfigKey[] values() {
        return (UserConfigKey[]) f308903a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public static UserConfigKey valueOf(String r100) {
        return (UserConfigKey) r27.a.a(UserConfigKey.class, r100);
    }

    public UserConfigKey(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
