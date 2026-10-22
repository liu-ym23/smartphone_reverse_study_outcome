package com.ss.android.lark.biz.im.api.page;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/ss/android/lark/biz/im/api/page/ChatDestination;", "", "<init>", "(Ljava/lang/String;I)V", "BOT_CHAT", "FAKE_CHAT", "SECRET_CHAT", "CHAT_WINDOW", "im-api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum ChatDestination extends Enum<ChatDestination> {
    public static final ChatDestination BOT_CHAT = null;
    public static final ChatDestination CHAT_WINDOW = null;
    public static final ChatDestination FAKE_CHAT = null;
    public static final ChatDestination SECRET_CHAT = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ChatDestination[] f410429a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f410430b = null;

    public static EnumEntries<ChatDestination> getEntries() {
        return f410430b;
    }

    static {
        ChatDestination r100 = new ChatDestination("BOT_CHAT", 0);
        BOT_CHAT = r100;
        ChatDestination r101 = new ChatDestination("FAKE_CHAT", 1);
        FAKE_CHAT = r101;
        ChatDestination r102 = new ChatDestination("SECRET_CHAT", 2);
        SECRET_CHAT = r102;
        ChatDestination r103 = new ChatDestination("CHAT_WINDOW", 3);
        CHAT_WINDOW = r103;
        ChatDestination[] r104 = {r100, r101, r102, r103};
        f410429a = r104;
        f410430b = EnumEntriesKt.enumEntries(r104);
    }

    public static ChatDestination[] values() {
        return (ChatDestination[]) f410429a.clone();
    }

    public static ChatDestination valueOf(String r100) {
        return (ChatDestination) a.a(ChatDestination.class, r100);
    }

    public ChatDestination(String r100, int r101) {
        super(r100, r101);
    }
}
