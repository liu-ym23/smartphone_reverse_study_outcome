package com.ss.android.lark.todo.impl.features.detail.create.richtext;

import com.ss.android.lark.chat.entity.message.Message;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u0019"}, d2 = {"Lcom/ss/android/lark/todo/impl/features/detail/create/richtext/RichTextMessage;", "Ljava/io/Serializable;", "messageType", "Lcom/ss/android/lark/chat/entity/message/Message$Type;", "messageContent", "Lcom/ss/android/lark/todo/impl/features/detail/create/richtext/MessageContentEntity;", "<init>", "(Lcom/ss/android/lark/chat/entity/message/Message$Type;Lcom/ss/android/lark/todo/impl/features/detail/create/richtext/MessageContentEntity;)V", "getMessageType", "()Lcom/ss/android/lark/chat/entity/message/Message$Type;", "setMessageType", "(Lcom/ss/android/lark/chat/entity/message/Message$Type;)V", "getMessageContent", "()Lcom/ss/android/lark/todo/impl/features/detail/create/richtext/MessageContentEntity;", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "todo_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class RichTextMessage implements Serializable {
    private final MessageContentEntity messageContent;
    private Message.Type messageType;

    public static /* synthetic */ RichTextMessage copy$default(RichTextMessage r100, Message.Type r101, MessageContentEntity r102, int r103, Object r104) {
        if ((r103 & 1) == 0) goto L6;
        r101 = r100.messageType;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r102 = r100.messageContent;
    L9:
        return r100.copy(r101, r102);
    }

    public final Message.Type component1() {
        return this.messageType;
    }

    public final MessageContentEntity component2() {
        return this.messageContent;
    }

    public final RichTextMessage copy(Message.Type r100, MessageContentEntity r101) {
        Intrinsics.checkNotNullParameter(r100, "messageType");
        Intrinsics.checkNotNullParameter(r101, "messageContent");
        return new RichTextMessage(r100, r101);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof RichTextMessage) == true) goto L8;
        return false;
    L8:
        RichTextMessage r101 = (RichTextMessage) r100;
        if (this.messageType == r101.messageType) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.messageContent, r101.messageContent) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        return (this.messageType.hashCode() * 31) + this.messageContent.hashCode();
    }

    public String toString() {
        return "RichTextMessage(messageType=" + this.messageType + ", messageContent=" + this.messageContent + ')';
    }

    public final MessageContentEntity getMessageContent() {
        return this.messageContent;
    }

    public final Message.Type getMessageType() {
        return this.messageType;
    }

    public final void setMessageType(Message.Type r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.messageType = r100;
    }

    public RichTextMessage(Message.Type r100, MessageContentEntity r101) {
        Intrinsics.checkNotNullParameter(r100, "messageType");
        Intrinsics.checkNotNullParameter(r101, "messageContent");
        this.messageType = r100;
        this.messageContent = r101;
    }
}
