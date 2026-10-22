package com.ss.android.lark.chat.entity.chat;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes35.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0011\b\u0086\u0081\u0002\u0018\u0000 \u00132\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0013B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012¨\u0006\u0014"}, d2 = {"Lcom/ss/android/lark/chat/entity/chat/AddChatChatterApply$Ways;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "UNKNOWN_WAY", "VIA_SHARE", "VIA_INVITATION", "VIA_QR_CODE", "VIA_SEARCH", "VIA_DEPARTMENT_STRUCTURE", "VIA_LINK", "VIA_TEAM_OPEN_CHAT", "VIA_CALENDER", "VIA_TEAM_PRIVATE_DISCOVERABLE", "VIA_CHAT_LINKED_PAGE", "Companion", "chat-export_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum AddChatChatterApply$Ways extends Enum<AddChatChatterApply$Ways> {
    public static final a Companion = null;
    public static final AddChatChatterApply$Ways UNKNOWN_WAY = null;
    public static final AddChatChatterApply$Ways VIA_CALENDER = null;
    public static final AddChatChatterApply$Ways VIA_CHAT_LINKED_PAGE = null;
    public static final AddChatChatterApply$Ways VIA_DEPARTMENT_STRUCTURE = null;
    public static final AddChatChatterApply$Ways VIA_INVITATION = null;
    public static final AddChatChatterApply$Ways VIA_LINK = null;
    public static final AddChatChatterApply$Ways VIA_QR_CODE = null;
    public static final AddChatChatterApply$Ways VIA_SEARCH = null;
    public static final AddChatChatterApply$Ways VIA_SHARE = null;
    public static final AddChatChatterApply$Ways VIA_TEAM_OPEN_CHAT = null;
    public static final AddChatChatterApply$Ways VIA_TEAM_PRIVATE_DISCOVERABLE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ AddChatChatterApply$Ways[] f415099a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f415100b = null;
    private final int value;

    public static final class a {
        public a() {
        }
    }

    public static EnumEntries<AddChatChatterApply$Ways> getEntries() {
        return f415100b;
    }

    static {
        AddChatChatterApply$Ways r100 = new AddChatChatterApply$Ways("UNKNOWN_WAY", 0, 0);
        UNKNOWN_WAY = r100;
        AddChatChatterApply$Ways r101 = new AddChatChatterApply$Ways("VIA_SHARE", 1, 1);
        VIA_SHARE = r101;
        AddChatChatterApply$Ways r102 = new AddChatChatterApply$Ways("VIA_INVITATION", 2, 2);
        VIA_INVITATION = r102;
        AddChatChatterApply$Ways r103 = new AddChatChatterApply$Ways("VIA_QR_CODE", 3, 3);
        VIA_QR_CODE = r103;
        AddChatChatterApply$Ways r104 = new AddChatChatterApply$Ways("VIA_SEARCH", 4, 4);
        VIA_SEARCH = r104;
        AddChatChatterApply$Ways r105 = new AddChatChatterApply$Ways("VIA_DEPARTMENT_STRUCTURE", 5, 5);
        VIA_DEPARTMENT_STRUCTURE = r105;
        AddChatChatterApply$Ways r110 = new AddChatChatterApply$Ways("VIA_LINK", 6, 6);
        VIA_LINK = r110;
        AddChatChatterApply$Ways r111 = new AddChatChatterApply$Ways("VIA_TEAM_OPEN_CHAT", 7, 7);
        VIA_TEAM_OPEN_CHAT = r111;
        AddChatChatterApply$Ways r112 = new AddChatChatterApply$Ways("VIA_CALENDER", 8, 8);
        VIA_CALENDER = r112;
        AddChatChatterApply$Ways r113 = new AddChatChatterApply$Ways("VIA_TEAM_PRIVATE_DISCOVERABLE", 9, 9);
        VIA_TEAM_PRIVATE_DISCOVERABLE = r113;
        AddChatChatterApply$Ways r114 = new AddChatChatterApply$Ways("VIA_CHAT_LINKED_PAGE", 10, 10);
        VIA_CHAT_LINKED_PAGE = r114;
        AddChatChatterApply$Ways[] r115 = {r100, r101, r102, r103, r104, r105, r110, r111, r112, r113, r114};
        f415099a = r115;
        f415100b = EnumEntriesKt.enumEntries(r115);
        Companion = new a();
    }

    public static AddChatChatterApply$Ways[] values() {
        return (AddChatChatterApply$Ways[]) f415099a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public static AddChatChatterApply$Ways valueOf(String r100) {
        return (AddChatChatterApply$Ways) r27.a.a(AddChatChatterApply$Ways.class, r100);
    }

    public AddChatChatterApply$Ways(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
