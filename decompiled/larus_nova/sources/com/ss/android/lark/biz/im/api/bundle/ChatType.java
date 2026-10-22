package com.ss.android.lark.biz.im.api.bundle;

import android.text.TextUtils;
import com.ss.android.lark.notification.export.entity.INotificationHitPoint;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.JvmStatic;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u000e\b\u0086\u0081\u0002\u0018\u0000 \u00122\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0012B\u0019\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007R\u0012\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011¨\u0006\u0013"}, d2 = {"Lcom/ss/android/lark/biz/im/api/bundle/ChatType;", "", "value", "", "index", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;I)V", "GROUP", "SINGLE", "SINGLE_BOT", "DOCS", "MEETING", "THREAD", "THREAD_DETAIL", "THREAD_TAB", "CHAT_DETAIL", "EDU_CHAT", "Companion", "chat-export_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum ChatType extends Enum<ChatType> {
    public static final ChatType CHAT_DETAIL = null;
    public static final a Companion = null;
    public static final ChatType DOCS = null;
    public static final ChatType EDU_CHAT = null;
    public static final ChatType GROUP = null;
    public static final ChatType MEETING = null;
    public static final ChatType SINGLE = null;
    public static final ChatType SINGLE_BOT = null;
    public static final ChatType THREAD = null;
    public static final ChatType THREAD_DETAIL = null;
    public static final ChatType THREAD_TAB = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ChatType[] f409962a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f409963b = null;
    public int index;
    public String value;

    public static final class a {
        public a() {
        }

        @JvmStatic
        public static ChatType a(String r100) {
            ChatType[] r101 = ChatType.values();
            int r102 = r101.length;
            int r103 = 0;
        L3:
            if (r103 >= r102) goto L8;
            ChatType r104 = r101[r103];
            if (TextUtils.equals(r104.value, r100) == true) goto L6;
            r103 = r103 + 1;
            goto L3
        L6:
            return r104;
        L8:
            return null;
        }
    }

    @JvmStatic
    public static final ChatType fromValue(String r100) {
        Companion.getClass();
        return a.a(r100);
    }

    public static EnumEntries<ChatType> getEntries() {
        return f409963b;
    }

    static {
        ChatType r100 = new ChatType("GROUP", 0, "group", 2);
        GROUP = r100;
        ChatType r101 = new ChatType("SINGLE", 1, "single", 1);
        SINGLE = r101;
        ChatType r102 = new ChatType("SINGLE_BOT", 2, INotificationHitPoint.ChatType.CHAT_TYPE_SINGLE_BOT, 1);
        SINGLE_BOT = r102;
        ChatType r103 = new ChatType("DOCS", 3, "docs", 0);
        DOCS = r103;
        ChatType r104 = new ChatType("MEETING", 4, "meeting", 2);
        MEETING = r104;
        ChatType r105 = new ChatType("THREAD", 5, "thread", 5);
        THREAD = r105;
        ChatType r110 = new ChatType("THREAD_DETAIL", 6, "thread_detail", 3);
        THREAD_DETAIL = r110;
        ChatType r111 = new ChatType("THREAD_TAB", 7, "thread_tab", 5);
        THREAD_TAB = r111;
        ChatType r106 = new ChatType("CHAT_DETAIL", 8, "Chat_Detail", 4);
        CHAT_DETAIL = r106;
        ChatType r112 = new ChatType("EDU_CHAT", 9, "edu_chat", 2);
        EDU_CHAT = r112;
        ChatType[] r113 = {r100, r101, r102, r103, r104, r105, r110, r111, r106, r112};
        f409962a = r113;
        f409963b = EnumEntriesKt.enumEntries(r113);
        Companion = new a();
    }

    public static ChatType[] values() {
        return (ChatType[]) f409962a.clone();
    }

    public static ChatType valueOf(String r100) {
        return (ChatType) r27.a.a(ChatType.class, r100);
    }

    public ChatType(String r100, int r101, String r102, int r103) {
        super(r100, r101);
        this.value = r102;
        this.index = r103;
    }
}
