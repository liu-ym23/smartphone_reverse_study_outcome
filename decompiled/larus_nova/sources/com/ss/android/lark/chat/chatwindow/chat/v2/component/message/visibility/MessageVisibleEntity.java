package com.ss.android.lark.chat.chatwindow.chat.v2.component.message.visibility;

import com.ss.android.lark.chat.chatwindow.chat.v2.component.message.visibility.params.MessageVisibleHintPointParams;
import java.io.Serializable;
import java.util.LinkedList;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import y6b.c;

/* JADX INFO: loaded from: classes35.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B3\u0012 \u0010\u0002\u001a\u001c\u0012\u0016\u0012\u0014\u0012\n\u0012\b\u0012\u0002\b\u0003\u0018\u00010\u0005\u0012\u0004\u0012\u00020\u00060\u0004\u0018\u00010\u0003\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\t\u0010\nB\t\b\u0016¢\u0006\u0004\b\t\u0010\u000bJ\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0096\u0002J\b\u0010\u0018\u001a\u00020\u0019H\u0016J\b\u0010\u001a\u001a\u00020\u001bH\u0016J#\u0010\u001c\u001a\u001c\u0012\u0016\u0012\u0014\u0012\n\u0012\b\u0012\u0002\b\u0003\u0018\u00010\u0005\u0012\u0004\u0012\u00020\u00060\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\bHÆ\u0003J9\u0010\u001e\u001a\u00020\u00002\"\b\u0002\u0010\u0002\u001a\u001c\u0012\u0016\u0012\u0014\u0012\n\u0012\b\u0012\u0002\b\u0003\u0018\u00010\u0005\u0012\u0004\u0012\u00020\u00060\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\bHÆ\u0001R4\u0010\u0002\u001a\u001c\u0012\u0016\u0012\u0014\u0012\n\u0012\b\u0012\u0002\b\u0003\u0018\u00010\u0005\u0012\u0004\u0012\u00020\u00060\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013¨\u0006\u001f"}, d2 = {"Lcom/ss/android/lark/chat/chatwindow/chat/v2/component/message/visibility/MessageVisibleEntity;", "Ljava/io/Serializable;", "visibleMessageWithDurationPairs", "Ljava/util/LinkedList;", "Lkotlin/Pair;", "Lcom/ss/android/lark/chat/vo/ChatMessageVO;", "", "messageVisibleHintPointParams", "Lcom/ss/android/lark/chat/chatwindow/chat/v2/component/message/visibility/params/MessageVisibleHintPointParams;", "<init>", "(Ljava/util/LinkedList;Lcom/ss/android/lark/chat/chatwindow/chat/v2/component/message/visibility/params/MessageVisibleHintPointParams;)V", "()V", "getVisibleMessageWithDurationPairs", "()Ljava/util/LinkedList;", "setVisibleMessageWithDurationPairs", "(Ljava/util/LinkedList;)V", "getMessageVisibleHintPointParams", "()Lcom/ss/android/lark/chat/chatwindow/chat/v2/component/message/visibility/params/MessageVisibleHintPointParams;", "setMessageVisibleHintPointParams", "(Lcom/ss/android/lark/chat/chatwindow/chat/v2/component/message/visibility/params/MessageVisibleHintPointParams;)V", "equals", "", "other", "", "hashCode", "", "toString", "", "component1", "component2", "copy", "chat-core_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class MessageVisibleEntity implements Serializable {
    private MessageVisibleHintPointParams messageVisibleHintPointParams;
    private LinkedList<Pair<c<?>, Long>> visibleMessageWithDurationPairs;

    public MessageVisibleEntity() {
        this(null, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ MessageVisibleEntity copy$default(MessageVisibleEntity r100, LinkedList r101, MessageVisibleHintPointParams r102, int r103, Object r104) {
        if ((r103 & 1) == 0) goto L6;
        r101 = r100.visibleMessageWithDurationPairs;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r102 = r100.messageVisibleHintPointParams;
    L9:
        return r100.copy(r101, r102);
    }

    public final LinkedList<Pair<c<?>, Long>> component1() {
        return this.visibleMessageWithDurationPairs;
    }

    public final MessageVisibleHintPointParams component2() {
        return this.messageVisibleHintPointParams;
    }

    public final MessageVisibleEntity copy(LinkedList<Pair<c<?>, Long>> r100, MessageVisibleHintPointParams r101) {
        return new MessageVisibleEntity(r100, r101);
    }

    public int hashCode() {
        LinkedList<Pair<c<?>, Long>> r100 = this.visibleMessageWithDurationPairs;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        MessageVisibleHintPointParams r104 = this.messageVisibleHintPointParams;
        if (r104 == null) goto L10;
        r101 = r104.hashCode();
    L10:
        return r103 + r101;
    L5:
        r102 = 0;
        goto L6
    }

    public String toString() {
        return "MessageVisibleEntity(visibleMessageWithDurationPairs=" + this.visibleMessageWithDurationPairs + ", messageVisibleHitpointParams=" + this.messageVisibleHintPointParams + ')';
    }

    public final MessageVisibleHintPointParams getMessageVisibleHintPointParams() {
        return this.messageVisibleHintPointParams;
    }

    public final LinkedList<Pair<c<?>, Long>> getVisibleMessageWithDurationPairs() {
        return this.visibleMessageWithDurationPairs;
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if (r100 == null) goto L8;
        Class<?> r101 = r100.getClass();
    L10:
        if (Intrinsics.areEqual(MessageVisibleEntity.class, r101) == true) goto L12;
        return false;
    L12:
        Intrinsics.checkNotNull(r100, "null cannot be cast to non-null type com.ss.android.lark.chat.chatwindow.chat.v2.component.message.visibility.MessageVisibleEntity");
        MessageVisibleEntity r102 = (MessageVisibleEntity) r100;
        if (Intrinsics.areEqual(this.visibleMessageWithDurationPairs, r102.visibleMessageWithDurationPairs) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.messageVisibleHintPointParams, r102.messageVisibleHintPointParams) == true) goto L18;
        return false;
    L18:
        return true;
    L8:
        r101 = null;
        goto L10
    }

    public final void setMessageVisibleHintPointParams(MessageVisibleHintPointParams r100) {
        this.messageVisibleHintPointParams = r100;
    }

    public final void setVisibleMessageWithDurationPairs(LinkedList<Pair<c<?>, Long>> r100) {
        this.visibleMessageWithDurationPairs = r100;
    }

    public MessageVisibleEntity(LinkedList<Pair<c<?>, Long>> r100, MessageVisibleHintPointParams r101) {
        this.visibleMessageWithDurationPairs = r100;
        this.messageVisibleHintPointParams = r101;
    }
}
