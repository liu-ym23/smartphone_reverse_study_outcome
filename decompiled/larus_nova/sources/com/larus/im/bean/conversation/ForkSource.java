package com.larus.im.bean.conversation;

import com.larus.network.http.ServiceType;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes29.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u00002\u00020\u0001:\u0002\b\tB\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003R\u0012\u0010\u0004\u001a\u00020\u0005X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007\u0082\u0001\u0002\n\u000b¨\u0006\f"}, d2 = {"Lcom/larus/im/bean/conversation/ForkSource;", "", "<init>", "()V", "conversationId", "", "getConversationId", "()Ljava/lang/String;", ServiceType.IM, "Conversation", "Lcom/larus/im/bean/conversation/ForkSource$Conversation;", "Lcom/larus/im/bean/conversation/ForkSource$Message;", "imsdkkmp_api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public abstract class ForkSource {

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0003HÖ\u0001R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lcom/larus/im/bean/conversation/ForkSource$Conversation;", "Lcom/larus/im/bean/conversation/ForkSource;", "conversationId", "", "<init>", "(Ljava/lang/String;)V", "getConversationId", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "imsdkkmp_api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Conversation extends ForkSource {
        private final String conversationId;

        public static /* synthetic */ Conversation copy$default(Conversation r100, String r101, int r102, Object r103) {
            if ((r102 & 1) == 0) goto L6;
            r101 = r100.conversationId;
        L6:
            return r100.copy(r101);
        }

        public final String component1() {
            return this.conversationId;
        }

        public final Conversation copy(String r100) {
            Intrinsics.checkNotNullParameter(r100, "conversationId");
            return new Conversation(r100);
        }

        public boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof Conversation) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.conversationId, ((Conversation) r100).conversationId) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public int hashCode() {
            return this.conversationId.hashCode();
        }

        public String toString() {
            return "Conversation(conversationId=" + this.conversationId + ')';
        }

        @Override // com.larus.im.bean.conversation.ForkSource
        public String getConversationId() {
            return this.conversationId;
        }

        public Conversation(String r100) {
            Intrinsics.checkNotNullParameter(r100, "conversationId");
            super(null);
            this.conversationId = r100;
        }
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0003HÖ\u0001R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\u0014"}, d2 = {"Lcom/larus/im/bean/conversation/ForkSource$Message;", "Lcom/larus/im/bean/conversation/ForkSource;", "conversationId", "", "messageId", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "getConversationId", "()Ljava/lang/String;", "getMessageId", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "imsdkkmp_api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Message extends ForkSource {
        private final String conversationId;
        private final String messageId;

        public static /* synthetic */ Message copy$default(Message r100, String r101, String r102, int r103, Object r104) {
            if ((r103 & 1) == 0) goto L6;
            r101 = r100.conversationId;
        L6:
            if ((r103 & 2) == 0) goto L9;
            r102 = r100.messageId;
        L9:
            return r100.copy(r101, r102);
        }

        public final String component1() {
            return this.conversationId;
        }

        public final String component2() {
            return this.messageId;
        }

        public final Message copy(String r100, String r101) {
            Intrinsics.checkNotNullParameter(r100, "conversationId");
            Intrinsics.checkNotNullParameter(r101, "messageId");
            return new Message(r100, r101);
        }

        public boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof Message) == true) goto L8;
            return false;
        L8:
            Message r101 = (Message) r100;
            if (Intrinsics.areEqual(this.conversationId, r101.conversationId) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.messageId, r101.messageId) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public int hashCode() {
            return (this.conversationId.hashCode() * 31) + this.messageId.hashCode();
        }

        public String toString() {
            return "Message(conversationId=" + this.conversationId + ", messageId=" + this.messageId + ')';
        }

        @Override // com.larus.im.bean.conversation.ForkSource
        public String getConversationId() {
            return this.conversationId;
        }

        public final String getMessageId() {
            return this.messageId;
        }

        public Message(String r100, String r101) {
            Intrinsics.checkNotNullParameter(r100, "conversationId");
            Intrinsics.checkNotNullParameter(r101, "messageId");
            super(null);
            this.conversationId = r100;
            this.messageId = r101;
        }
    }

    private ForkSource() {
    }

    public /* synthetic */ ForkSource(DefaultConstructorMarker r100) {
        this();
    }

    public abstract String getConversationId();
}
