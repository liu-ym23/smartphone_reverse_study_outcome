package com.larus.bmhome.chat.bean;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes25.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/larus/bmhome/chat/bean/ChatMsgDeleteScene;", "", "<init>", "(Ljava/lang/String;I)V", "unknown", "longPressMenu", "bridgeMenu", "shareSheet", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum ChatMsgDeleteScene extends Enum<ChatMsgDeleteScene> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ChatMsgDeleteScene[] f297405a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f297406b = null;
    public static final ChatMsgDeleteScene bridgeMenu = null;
    public static final ChatMsgDeleteScene longPressMenu = null;
    public static final ChatMsgDeleteScene shareSheet = null;
    public static final ChatMsgDeleteScene unknown = null;

    public static EnumEntries<ChatMsgDeleteScene> getEntries() {
        return f297406b;
    }

    static {
        ChatMsgDeleteScene r100 = new ChatMsgDeleteScene("unknown", 0);
        unknown = r100;
        ChatMsgDeleteScene r101 = new ChatMsgDeleteScene("longPressMenu", 1);
        longPressMenu = r101;
        ChatMsgDeleteScene r102 = new ChatMsgDeleteScene("bridgeMenu", 2);
        bridgeMenu = r102;
        ChatMsgDeleteScene r103 = new ChatMsgDeleteScene("shareSheet", 3);
        shareSheet = r103;
        ChatMsgDeleteScene[] r104 = {r100, r101, r102, r103};
        f297405a = r104;
        f297406b = EnumEntriesKt.enumEntries(r104);
    }

    public static ChatMsgDeleteScene[] values() {
        return (ChatMsgDeleteScene[]) f297405a.clone();
    }

    public static ChatMsgDeleteScene valueOf(String r100) {
        return (ChatMsgDeleteScene) r27.a.a(ChatMsgDeleteScene.class, r100);
    }

    public ChatMsgDeleteScene(String r100, int r101) {
        super(r100, r101);
    }
}
