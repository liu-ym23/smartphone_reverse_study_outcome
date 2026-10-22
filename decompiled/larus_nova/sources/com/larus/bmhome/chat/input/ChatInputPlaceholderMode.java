package com.larus.bmhome.chat.input;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes25.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/larus/bmhome/chat/input/ChatInputPlaceholderMode;", "", "<init>", "(Ljava/lang/String;I)V", "KEYBOARD", "VOICE", "api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum ChatInputPlaceholderMode extends Enum<ChatInputPlaceholderMode> {
    public static final ChatInputPlaceholderMode KEYBOARD = null;
    public static final ChatInputPlaceholderMode VOICE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ChatInputPlaceholderMode[] f303325a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f303326b = null;

    public static EnumEntries<ChatInputPlaceholderMode> getEntries() {
        return f303326b;
    }

    static {
        ChatInputPlaceholderMode r100 = new ChatInputPlaceholderMode("KEYBOARD", 0);
        KEYBOARD = r100;
        ChatInputPlaceholderMode r101 = new ChatInputPlaceholderMode("VOICE", 1);
        VOICE = r101;
        ChatInputPlaceholderMode[] r102 = {r100, r101};
        f303325a = r102;
        f303326b = EnumEntriesKt.enumEntries(r102);
    }

    public static ChatInputPlaceholderMode[] values() {
        return (ChatInputPlaceholderMode[]) f303325a.clone();
    }

    public static ChatInputPlaceholderMode valueOf(String r100) {
        return (ChatInputPlaceholderMode) a.a(ChatInputPlaceholderMode.class, r100);
    }

    public ChatInputPlaceholderMode(String r100, int r101) {
        super(r100, r101);
    }
}
