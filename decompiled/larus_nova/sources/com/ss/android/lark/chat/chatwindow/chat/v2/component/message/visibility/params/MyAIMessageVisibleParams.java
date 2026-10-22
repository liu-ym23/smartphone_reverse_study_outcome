package com.ss.android.lark.chat.chatwindow.chat.v2.component.message.visibility.params;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes35.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u000b\u001a\u00020\u00032\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0007R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/ss/android/lark/chat/chatwindow/chat/v2/component/message/visibility/params/MyAIMessageVisibleParams;", "Lcom/ss/android/lark/chat/chatwindow/chat/v2/component/message/visibility/params/MessageVisibleBizParams;", "isAIChat", "", "isP2PChat", "<init>", "(ZZ)V", "()Z", "component1", "component2", "copy", "equals", "other", "", "hashCode", "", "toString", "", "chat-core_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class MyAIMessageVisibleParams implements MessageVisibleBizParams {
    private final boolean isAIChat;
    private final boolean isP2PChat;

    public static /* synthetic */ MyAIMessageVisibleParams copy$default(MyAIMessageVisibleParams r100, boolean r101, boolean r102, int r103, Object r104) {
        if ((r103 & 1) == 0) goto L6;
        r101 = r100.isAIChat;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r102 = r100.isP2PChat;
    L9:
        return r100.copy(r101, r102);
    }

    public final boolean component1() {
        return this.isAIChat;
    }

    public final boolean component2() {
        return this.isP2PChat;
    }

    public final MyAIMessageVisibleParams copy(boolean r100, boolean r101) {
        return new MyAIMessageVisibleParams(r100, r101);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof MyAIMessageVisibleParams) == true) goto L8;
        return false;
    L8:
        MyAIMessageVisibleParams r101 = (MyAIMessageVisibleParams) r100;
        if (this.isAIChat == r101.isAIChat) goto L12;
        return false;
    L12:
        if (this.isP2PChat == r101.isP2PChat) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        int r100 = 1231;
        if (this.isAIChat == false) goto L5;
        int r101 = 1231;
    L6:
        int r102 = r101 * 31;
        if (this.isP2PChat == true) goto L11;
        r100 = 1237;
    L11:
        return r102 + r100;
    L5:
        r101 = 1237;
        goto L6
    }

    public String toString() {
        return "MyAIMessageVisibleParams(isAIChat=" + this.isAIChat + ", isP2PChat=" + this.isP2PChat + ')';
    }

    public final boolean isAIChat() {
        return this.isAIChat;
    }

    public final boolean isP2PChat() {
        return this.isP2PChat;
    }

    public MyAIMessageVisibleParams(boolean r100, boolean r101) {
        this.isAIChat = r100;
        this.isP2PChat = r101;
    }
}
