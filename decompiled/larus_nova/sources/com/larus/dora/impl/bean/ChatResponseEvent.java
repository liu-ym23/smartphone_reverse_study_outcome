package com.larus.dora.impl.bean;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes27.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B9\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\u0012\b\u0002\u0010\u0006\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\b\u0018\u00010\u0007¢\u0006\u0004\b\t\u0010\nJ\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\u0014\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\b\u0018\u00010\u0007HÆ\u0003J;\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\u0012\b\u0002\u0010\u0006\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\b\u0018\u00010\u0007HÆ\u0001J\u0013\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001J\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0016\u0010\u0005\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\fR \u0010\u0006\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\b\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u001d"}, d2 = {"Lcom/larus/dora/impl/bean/ChatResponseEvent;", "", "seqId", "", "replyType", "conversationId", "commandList", "", "Lcom/larus/dora/impl/bean/Command;", "<init>", "(JJJLjava/util/List;)V", "getSeqId", "()J", "getReplyType", "getConversationId", "getCommandList", "()Ljava/util/List;", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ChatResponseEvent {

    @SerializedName("command_list")
    private final List<Command> commandList;

    @SerializedName("conversation_id")
    private final long conversationId;

    @SerializedName("reply_type")
    private final long replyType;

    @SerializedName("seq_id")
    private final long seqId;

    public ChatResponseEvent() {
        this(0, 0, 0, null, 15, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ChatResponseEvent copy$default(ChatResponseEvent r100, long r101, long r110, long r111, List r112, int r113, Object r114) {
        if ((r113 & 1) == 0) goto L5;
        long r102 = r100.seqId;
    L7:
        if ((r113 & 2) == 0) goto L9;
        long r103 = r100.replyType;
    L11:
        if ((r113 & 4) == 0) goto L13;
        long r104 = r100.conversationId;
    L15:
        if ((r113 & 8) == 0) goto L17;
        List r105 = r100.commandList;
    L19:
        return r100.copy(r102, r103, r104, r105);
    L17:
        r105 = r112;
        goto L19
    L13:
        r104 = r111;
        goto L15
    L9:
        r103 = r110;
        goto L11
    L5:
        r102 = r101;
        goto L7
    }

    public final long component1() {
        return this.seqId;
    }

    public final long component2() {
        return this.replyType;
    }

    public final long component3() {
        return this.conversationId;
    }

    public final List<Command> component4() {
        return this.commandList;
    }

    public final ChatResponseEvent copy(long r110, long r111, long r112, List<Command> r113) {
        return new ChatResponseEvent(r110, r111, r112, r113);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof ChatResponseEvent) == true) goto L8;
        return false;
    L8:
        ChatResponseEvent r101 = (ChatResponseEvent) r100;
        if (this.seqId == r101.seqId) goto L12;
        return false;
    L12:
        if (this.replyType == r101.replyType) goto L15;
        return false;
    L15:
        if (this.conversationId == r101.conversationId) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.commandList, r101.commandList) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public int hashCode() {
        long r100 = this.seqId;
        int r101 = ((int) (r100 ^ (r100 >>> 32))) * 31;
        long r102 = this.replyType;
        int r103 = (r101 + ((int) (r102 ^ (r102 >>> 32)))) * 31;
        long r104 = this.conversationId;
        int r105 = (r103 + ((int) (r104 ^ (r104 >>> 32)))) * 31;
        List<Command> r106 = this.commandList;
        if (r106 != null) goto L5;
        int r107 = 0;
    L7:
        return r105 + r107;
    L5:
        r107 = r106.hashCode();
        goto L7
    }

    public String toString() {
        return "ChatResponseEvent(seqId=" + this.seqId + ", replyType=" + this.replyType + ", conversationId=" + this.conversationId + ", commandList=" + this.commandList + ')';
    }

    public final List<Command> getCommandList() {
        return this.commandList;
    }

    public final long getConversationId() {
        return this.conversationId;
    }

    public final long getReplyType() {
        return this.replyType;
    }

    public final long getSeqId() {
        return this.seqId;
    }

    public ChatResponseEvent(long r100, long r101, long r102, List<Command> r103) {
        this.seqId = r100;
        this.replyType = r101;
        this.conversationId = r102;
        this.commandList = r103;
    }

    public /* synthetic */ ChatResponseEvent(long r100, long r101, long r110, List r111, int r112, DefaultConstructorMarker r113) {
        long r102 = 0;
        if ((r112 & 1) == 0) goto L5;
        long r103 = 0;
    L7:
        if ((r112 & 2) == 0) goto L9;
        long r104 = 0;
    L11:
        if ((r112 & 4) != 0) goto L15;
        r102 = r110;
    L15:
        if ((r112 & 8) == 0) goto L17;
        r111 = null;
    L17:
        this(r103, r104, r102, r111);
        return;
    L9:
        r104 = r101;
        goto L11
    L5:
        r103 = r100;
        goto L7
    }
}
