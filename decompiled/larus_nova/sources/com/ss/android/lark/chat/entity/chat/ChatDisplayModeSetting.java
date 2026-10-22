package com.ss.android.lark.chat.entity.chat;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes35.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u0000 \u000b2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u000bB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\f"}, d2 = {"Lcom/ss/android/lark/chat/entity/chat/ChatDisplayModeSetting;", "", "number", "", "<init>", "(Ljava/lang/String;II)V", "getNumber", "()I", "UNKNOWN", "DEFAULT", "THREAD", "Companion", "im-sdk-base_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum ChatDisplayModeSetting extends Enum<ChatDisplayModeSetting> {
    public static final a Companion = null;
    public static final ChatDisplayModeSetting DEFAULT = null;
    public static final ChatDisplayModeSetting THREAD = null;
    public static final ChatDisplayModeSetting UNKNOWN = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ChatDisplayModeSetting[] f415140a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f415141b = null;
    private final int number;

    public static final class a {
        public a() {
        }

        public static ChatDisplayModeSetting a(int r100) {
            ChatDisplayModeSetting[] r101 = ChatDisplayModeSetting.values();
            int r102 = r101.length;
            int r103 = 0;
        L3:
            if (r103 >= r102) goto L9;
            ChatDisplayModeSetting r104 = r101[r103];
            if (r104.getNumber() == r100) goto L6;
            r103 = r103 + 1;
            goto L3
        L6:
            return r104;
        L9:
            return ChatDisplayModeSetting.UNKNOWN;
        }
    }

    public static EnumEntries<ChatDisplayModeSetting> getEntries() {
        return f415141b;
    }

    static {
        ChatDisplayModeSetting r100 = new ChatDisplayModeSetting("UNKNOWN", 0, 0);
        UNKNOWN = r100;
        ChatDisplayModeSetting r101 = new ChatDisplayModeSetting("DEFAULT", 1, 1);
        DEFAULT = r101;
        ChatDisplayModeSetting r102 = new ChatDisplayModeSetting("THREAD", 2, 2);
        THREAD = r102;
        ChatDisplayModeSetting[] r103 = {r100, r101, r102};
        f415140a = r103;
        f415141b = EnumEntriesKt.enumEntries(r103);
        Companion = new a();
    }

    public static ChatDisplayModeSetting[] values() {
        return (ChatDisplayModeSetting[]) f415140a.clone();
    }

    public final int getNumber() {
        return this.number;
    }

    public static ChatDisplayModeSetting valueOf(String r100) {
        return (ChatDisplayModeSetting) r27.a.a(ChatDisplayModeSetting.class, r100);
    }

    public ChatDisplayModeSetting(String r100, int r101, int r102) {
        super(r100, r101);
        this.number = r102;
    }
}
