package com.ss.android.lark.chat.entity.chat;

import com.bytedance.lark.pb.basic.v1.TnsBlockedFeature;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes35.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u000f\b\u0086\u0081\u0002\u0018\u0000 \u00112\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0011B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010¨\u0006\u0012"}, d2 = {"Lcom/ss/android/lark/chat/entity/chat/ChatTnsBlockedFeature;", "", "feature", "", "<init>", "(Ljava/lang/String;II)V", "getFeature", "()I", "UNKNOWN_BLOCKED_FEATURE", "BLOCKED_ADD_MEMBER", "BLOCKED_REMOVE_MEMBER", "BLOCKED_CHAT_TAB", "BLOCKED_CHAT_MENU_TNS", "BLOCKED_MESSAGE_MENU", "BLOCKED_BOT_POST", "BLOCKED_MANAGE_BOT", "BLOCKED_GROUP_TASK", "Companion", "im-sdk-base_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum ChatTnsBlockedFeature extends Enum<ChatTnsBlockedFeature> {
    public static final ChatTnsBlockedFeature BLOCKED_ADD_MEMBER = null;
    public static final ChatTnsBlockedFeature BLOCKED_BOT_POST = null;
    public static final ChatTnsBlockedFeature BLOCKED_CHAT_MENU_TNS = null;
    public static final ChatTnsBlockedFeature BLOCKED_CHAT_TAB = null;
    public static final ChatTnsBlockedFeature BLOCKED_GROUP_TASK = null;
    public static final ChatTnsBlockedFeature BLOCKED_MANAGE_BOT = null;
    public static final ChatTnsBlockedFeature BLOCKED_MESSAGE_MENU = null;
    public static final ChatTnsBlockedFeature BLOCKED_REMOVE_MEMBER = null;
    public static final a Companion = null;
    public static final ChatTnsBlockedFeature UNKNOWN_BLOCKED_FEATURE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ChatTnsBlockedFeature[] f415159a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f415160b = null;
    private final int feature;

    public static final class a {

        /* JADX INFO: renamed from: com.ss.android.lark.chat.entity.chat.ChatTnsBlockedFeature$a$a, reason: collision with other inner class name */
        public /* synthetic */ class C4855a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ int[] f415161a = null;

            static {
                int[] r100 = new int[TnsBlockedFeature.values().length];
                r100[TnsBlockedFeature.UNKNOWN_BLOCKED_FEATURE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L14
            L25:
                r100[TnsBlockedFeature.BLOCKED_ADD_MEMBER.ordinal()] = 2;     // Catch: NoSuchFieldError -> L15
            L39:
                r100[TnsBlockedFeature.BLOCKED_REMOVE_MEMBER.ordinal()] = 3;     // Catch: NoSuchFieldError -> L16
            L29:
                r100[TnsBlockedFeature.BLOCKED_CHAT_TAB.ordinal()] = 4;     // Catch: NoSuchFieldError -> L17
            L31:
                r100[TnsBlockedFeature.BLOCKED_CHAT_MENU_TNS.ordinal()] = 5;     // Catch: NoSuchFieldError -> L18
            L23:
                r100[TnsBlockedFeature.BLOCKED_MESSAGE_MENU.ordinal()] = 6;     // Catch: NoSuchFieldError -> L19
            L33:
                r100[TnsBlockedFeature.BLOCKED_BOT_POST.ordinal()] = 7;     // Catch: NoSuchFieldError -> L20
            L35:
                r100[TnsBlockedFeature.BLOCKED_MANAGE_BOT.ordinal()] = 8;     // Catch: NoSuchFieldError -> L21
            L27:
                r100[TnsBlockedFeature.BLOCKED_GROUP_TASK.ordinal()] = 9;     // Catch: NoSuchFieldError -> L22
            L12:
                f415161a = r100;
            }
        }

        public a() {
        }
    }

    public static EnumEntries<ChatTnsBlockedFeature> getEntries() {
        return f415160b;
    }

    static {
        ChatTnsBlockedFeature r100 = new ChatTnsBlockedFeature("UNKNOWN_BLOCKED_FEATURE", 0, 0);
        UNKNOWN_BLOCKED_FEATURE = r100;
        ChatTnsBlockedFeature r101 = new ChatTnsBlockedFeature("BLOCKED_ADD_MEMBER", 1, 1);
        BLOCKED_ADD_MEMBER = r101;
        ChatTnsBlockedFeature r102 = new ChatTnsBlockedFeature("BLOCKED_REMOVE_MEMBER", 2, 2);
        BLOCKED_REMOVE_MEMBER = r102;
        ChatTnsBlockedFeature r103 = new ChatTnsBlockedFeature("BLOCKED_CHAT_TAB", 3, 3);
        BLOCKED_CHAT_TAB = r103;
        ChatTnsBlockedFeature r104 = new ChatTnsBlockedFeature("BLOCKED_CHAT_MENU_TNS", 4, 4);
        BLOCKED_CHAT_MENU_TNS = r104;
        ChatTnsBlockedFeature r105 = new ChatTnsBlockedFeature("BLOCKED_MESSAGE_MENU", 5, 5);
        BLOCKED_MESSAGE_MENU = r105;
        ChatTnsBlockedFeature r110 = new ChatTnsBlockedFeature("BLOCKED_BOT_POST", 6, 6);
        BLOCKED_BOT_POST = r110;
        ChatTnsBlockedFeature r111 = new ChatTnsBlockedFeature("BLOCKED_MANAGE_BOT", 7, 7);
        BLOCKED_MANAGE_BOT = r111;
        ChatTnsBlockedFeature r112 = new ChatTnsBlockedFeature("BLOCKED_GROUP_TASK", 8, 8);
        BLOCKED_GROUP_TASK = r112;
        ChatTnsBlockedFeature[] r113 = {r100, r101, r102, r103, r104, r105, r110, r111, r112};
        f415159a = r113;
        f415160b = EnumEntriesKt.enumEntries(r113);
        Companion = new a();
    }

    public static ChatTnsBlockedFeature[] values() {
        return (ChatTnsBlockedFeature[]) f415159a.clone();
    }

    public final int getFeature() {
        return this.feature;
    }

    public static ChatTnsBlockedFeature valueOf(String r100) {
        return (ChatTnsBlockedFeature) r27.a.a(ChatTnsBlockedFeature.class, r100);
    }

    public ChatTnsBlockedFeature(String r100, int r101, int r102) {
        super(r100, r101);
        this.feature = r102;
    }
}
