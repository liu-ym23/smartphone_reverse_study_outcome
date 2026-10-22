package com.ss.android.lark.chat.chatwindow.chat.v2.component.message.visibility.params;

import com.ss.android.lark.chat.entity.chat.AutoMuteConfig;
import com.ss.android.lark.chat.entity.chat.Chat;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001BC\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012*\u0010\u0006\u001a&\u0012\u0004\u0012\u00020\b\u0012\u0006\u0012\u0004\u0018\u00010\t\u0018\u00010\u0007j\u0012\u0012\u0004\u0012\u00020\b\u0012\u0006\u0012\u0004\u0018\u00010\t\u0018\u0001`\n¢\u0006\u0004\b\u000b\u0010\fJ\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0005HÆ\u0003J-\u0010\u0015\u001a&\u0012\u0004\u0012\u00020\b\u0012\u0006\u0012\u0004\u0018\u00010\t\u0018\u00010\u0007j\u0012\u0012\u0004\u0012\u00020\b\u0012\u0006\u0012\u0004\u0018\u00010\t\u0018\u0001`\nHÆ\u0003JK\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052,\b\u0002\u0010\u0006\u001a&\u0012\u0004\u0012\u00020\b\u0012\u0006\u0012\u0004\u0018\u00010\t\u0018\u00010\u0007j\u0012\u0012\u0004\u0012\u00020\b\u0012\u0006\u0012\u0004\u0018\u00010\t\u0018\u0001`\nHÆ\u0001J\u0013\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aHÖ\u0003J\t\u0010\u001b\u001a\u00020\u0005HÖ\u0001J\t\u0010\u001c\u001a\u00020\u001dHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R5\u0010\u0006\u001a&\u0012\u0004\u0012\u00020\b\u0012\u0006\u0012\u0004\u0018\u00010\t\u0018\u00010\u0007j\u0012\u0012\u0004\u0012\u00020\b\u0012\u0006\u0012\u0004\u0018\u00010\t\u0018\u0001`\n¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u001e"}, d2 = {"Lcom/ss/android/lark/chat/chatwindow/chat/v2/component/message/visibility/params/AutoMuteMessageVisibleParams;", "Lcom/ss/android/lark/chat/chatwindow/chat/v2/component/message/visibility/params/MessageVisibleBizParams;", "chatType", "Lcom/ss/android/lark/chat/entity/chat/Chat$Type;", "chatUserNum", "", "chatAutoMuteBots", "Ljava/util/HashMap;", "", "Lcom/ss/android/lark/chat/entity/chat/AutoMuteConfig;", "Lkotlin/collections/HashMap;", "<init>", "(Lcom/ss/android/lark/chat/entity/chat/Chat$Type;ILjava/util/HashMap;)V", "getChatType", "()Lcom/ss/android/lark/chat/entity/chat/Chat$Type;", "getChatUserNum", "()I", "getChatAutoMuteBots", "()Ljava/util/HashMap;", "component1", "component2", "component3", "copy", "equals", "", "other", "", "hashCode", "toString", "", "chat-core_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AutoMuteMessageVisibleParams implements MessageVisibleBizParams {
    private final HashMap<Long, AutoMuteConfig> chatAutoMuteBots;
    private final Chat.Type chatType;
    private final int chatUserNum;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ AutoMuteMessageVisibleParams copy$default(AutoMuteMessageVisibleParams r100, Chat.Type r101, int r102, HashMap r103, int r104, Object r105) {
        if ((r104 & 1) == 0) goto L6;
        r101 = r100.chatType;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r102 = r100.chatUserNum;
    L9:
        if ((r104 & 4) == 0) goto L12;
        r103 = r100.chatAutoMuteBots;
    L12:
        return r100.copy(r101, r102, r103);
    }

    public final Chat.Type component1() {
        return this.chatType;
    }

    public final int component2() {
        return this.chatUserNum;
    }

    public final HashMap<Long, AutoMuteConfig> component3() {
        return this.chatAutoMuteBots;
    }

    public final AutoMuteMessageVisibleParams copy(Chat.Type r100, int r101, HashMap<Long, AutoMuteConfig> r102) {
        Intrinsics.checkNotNullParameter(r100, "chatType");
        return new AutoMuteMessageVisibleParams(r100, r101, r102);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof AutoMuteMessageVisibleParams) == true) goto L8;
        return false;
    L8:
        AutoMuteMessageVisibleParams r101 = (AutoMuteMessageVisibleParams) r100;
        if (this.chatType == r101.chatType) goto L12;
        return false;
    L12:
        if (this.chatUserNum == r101.chatUserNum) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.chatAutoMuteBots, r101.chatAutoMuteBots) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        int r100 = ((this.chatType.hashCode() * 31) + this.chatUserNum) * 31;
        HashMap<Long, AutoMuteConfig> r101 = this.chatAutoMuteBots;
        if (r101 != null) goto L5;
        int r102 = 0;
    L7:
        return r100 + r102;
    L5:
        r102 = r101.hashCode();
        goto L7
    }

    public String toString() {
        return "AutoMuteMessageVisibleParams(chatType=" + this.chatType + ", chatUserNum=" + this.chatUserNum + ", chatAutoMuteBots=" + this.chatAutoMuteBots + ')';
    }

    public final HashMap<Long, AutoMuteConfig> getChatAutoMuteBots() {
        return this.chatAutoMuteBots;
    }

    public final Chat.Type getChatType() {
        return this.chatType;
    }

    public final int getChatUserNum() {
        return this.chatUserNum;
    }

    public AutoMuteMessageVisibleParams(Chat.Type r100, int r101, HashMap<Long, AutoMuteConfig> r102) {
        Intrinsics.checkNotNullParameter(r100, "chatType");
        this.chatType = r100;
        this.chatUserNum = r101;
        this.chatAutoMuteBots = r102;
    }
}
