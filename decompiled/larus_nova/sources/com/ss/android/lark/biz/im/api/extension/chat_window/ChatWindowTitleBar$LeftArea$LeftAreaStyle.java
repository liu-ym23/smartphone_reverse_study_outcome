package com.ss.android.lark.biz.im.api.extension.chat_window;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/ss/android/lark/biz/im/api/extension/chat_window/ChatWindowTitleBar$LeftArea$LeftAreaStyle;", "", "<init>", "(Ljava/lang/String;I)V", "STYLE_CLOSE", "STYLE_BACK", "STYLE_BACK_SPLIT_WINDOW", "STYLE_SHOW_SIDEBAR", "im-api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum ChatWindowTitleBar$LeftArea$LeftAreaStyle extends Enum<ChatWindowTitleBar$LeftArea$LeftAreaStyle> {
    public static final ChatWindowTitleBar$LeftArea$LeftAreaStyle STYLE_BACK = null;
    public static final ChatWindowTitleBar$LeftArea$LeftAreaStyle STYLE_BACK_SPLIT_WINDOW = null;
    public static final ChatWindowTitleBar$LeftArea$LeftAreaStyle STYLE_CLOSE = null;
    public static final ChatWindowTitleBar$LeftArea$LeftAreaStyle STYLE_SHOW_SIDEBAR = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ChatWindowTitleBar$LeftArea$LeftAreaStyle[] f410086a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f410087b = null;

    public static EnumEntries<ChatWindowTitleBar$LeftArea$LeftAreaStyle> getEntries() {
        return f410087b;
    }

    static {
        ChatWindowTitleBar$LeftArea$LeftAreaStyle r100 = new ChatWindowTitleBar$LeftArea$LeftAreaStyle("STYLE_CLOSE", 0);
        STYLE_CLOSE = r100;
        ChatWindowTitleBar$LeftArea$LeftAreaStyle r101 = new ChatWindowTitleBar$LeftArea$LeftAreaStyle("STYLE_BACK", 1);
        STYLE_BACK = r101;
        ChatWindowTitleBar$LeftArea$LeftAreaStyle r102 = new ChatWindowTitleBar$LeftArea$LeftAreaStyle("STYLE_BACK_SPLIT_WINDOW", 2);
        STYLE_BACK_SPLIT_WINDOW = r102;
        ChatWindowTitleBar$LeftArea$LeftAreaStyle r103 = new ChatWindowTitleBar$LeftArea$LeftAreaStyle("STYLE_SHOW_SIDEBAR", 3);
        STYLE_SHOW_SIDEBAR = r103;
        ChatWindowTitleBar$LeftArea$LeftAreaStyle[] r104 = {r100, r101, r102, r103};
        f410086a = r104;
        f410087b = EnumEntriesKt.enumEntries(r104);
    }

    public static ChatWindowTitleBar$LeftArea$LeftAreaStyle[] values() {
        return (ChatWindowTitleBar$LeftArea$LeftAreaStyle[]) f410086a.clone();
    }

    public static ChatWindowTitleBar$LeftArea$LeftAreaStyle valueOf(String r100) {
        return (ChatWindowTitleBar$LeftArea$LeftAreaStyle) r27.a.a(ChatWindowTitleBar$LeftArea$LeftAreaStyle.class, r100);
    }

    public ChatWindowTitleBar$LeftArea$LeftAreaStyle(String r100, int r101) {
        super(r100, r101);
    }
}
