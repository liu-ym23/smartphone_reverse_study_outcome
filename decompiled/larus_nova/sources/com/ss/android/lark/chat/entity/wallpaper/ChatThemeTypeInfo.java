package com.ss.android.lark.chat.entity.wallpaper;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.JvmStatic;

/* JADX INFO: loaded from: classes35.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\u0081\u0002\u0018\u0000 \r2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\rB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\u000b\u001a\u00020\fH\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000e"}, d2 = {"Lcom/ss/android/lark/chat/entity/wallpaper/ChatThemeTypeInfo;", "", "number", "", "<init>", "(Ljava/lang/String;II)V", "getNumber", "()I", "UNKNOWN_CHAT_THEME_TYPE", "PERSONAL_CHAT_THEME", "GROUP_CHAT_THEME", "toString", "", "Companion", "im-sdk-base_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum ChatThemeTypeInfo extends Enum<ChatThemeTypeInfo> {
    public static final a Companion = null;
    public static final ChatThemeTypeInfo GROUP_CHAT_THEME = null;
    public static final ChatThemeTypeInfo PERSONAL_CHAT_THEME = null;
    public static final ChatThemeTypeInfo UNKNOWN_CHAT_THEME_TYPE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ChatThemeTypeInfo[] f415380a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f415381b = null;
    private final int number;

    public static final class a {
        public a() {
        }
    }

    public static EnumEntries<ChatThemeTypeInfo> getEntries() {
        return f415381b;
    }

    static {
        ChatThemeTypeInfo r100 = new ChatThemeTypeInfo("UNKNOWN_CHAT_THEME_TYPE", 0, 0);
        UNKNOWN_CHAT_THEME_TYPE = r100;
        ChatThemeTypeInfo r101 = new ChatThemeTypeInfo("PERSONAL_CHAT_THEME", 1, 1);
        PERSONAL_CHAT_THEME = r101;
        ChatThemeTypeInfo r102 = new ChatThemeTypeInfo("GROUP_CHAT_THEME", 2, 2);
        GROUP_CHAT_THEME = r102;
        ChatThemeTypeInfo[] r103 = {r100, r101, r102};
        f415380a = r103;
        f415381b = EnumEntriesKt.enumEntries(r103);
        Companion = new a();
    }

    public static ChatThemeTypeInfo[] values() {
        return (ChatThemeTypeInfo[]) f415380a.clone();
    }

    @Override // java.lang.Enum
    public String toString() {
        return name();
    }

    public final int getNumber() {
        return this.number;
    }

    @JvmStatic
    public static final ChatThemeTypeInfo fromValue(int r100) {
        Companion.getClass();
        if (r100 == 0) goto L12;
        if (r100 == 1) goto L15;
        if (r100 == 2) goto L14;
        return null;
    L14:
        return GROUP_CHAT_THEME;
    L15:
        return PERSONAL_CHAT_THEME;
    L12:
        return UNKNOWN_CHAT_THEME_TYPE;
    }

    public static ChatThemeTypeInfo valueOf(String r100) {
        return (ChatThemeTypeInfo) r27.a.a(ChatThemeTypeInfo.class, r100);
    }

    public ChatThemeTypeInfo(String r100, int r101, int r102) {
        super(r100, r101);
        this.number = r102;
    }
}
