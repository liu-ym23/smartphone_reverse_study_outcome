package com.ss.android.lark.chat.entity.message.content;

import com.ss.android.lark.widget.richtext.RichText;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0003\u0007\b\tB\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0000\u0082\u0001\u0003\n\u000b\f¨\u0006\r"}, d2 = {"Lcom/ss/android/lark/chat/entity/message/content/UnreadAIReplyQueryState;", "Ljava/io/Serializable;", "<init>", "()V", "differ", "", "other", "WaitSdkResponse", "WaitServerResponse", "Reply", "Lcom/ss/android/lark/chat/entity/message/content/UnreadAIReplyQueryState$Reply;", "Lcom/ss/android/lark/chat/entity/message/content/UnreadAIReplyQueryState$WaitSdkResponse;", "Lcom/ss/android/lark/chat/entity/message/content/UnreadAIReplyQueryState$WaitServerResponse;", "im-sdk-base_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public abstract class UnreadAIReplyQueryState implements Serializable {

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/ss/android/lark/chat/entity/message/content/UnreadAIReplyQueryState$Reply;", "Lcom/ss/android/lark/chat/entity/message/content/UnreadAIReplyQueryState;", "reply", "Lcom/ss/android/lark/chat/entity/message/content/AtKnowledgeReplyQueryState;", "<init>", "(Lcom/ss/android/lark/chat/entity/message/content/AtKnowledgeReplyQueryState;)V", "getReply", "()Lcom/ss/android/lark/chat/entity/message/content/AtKnowledgeReplyQueryState;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "im-sdk-base_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Reply extends UnreadAIReplyQueryState {
        private final AtKnowledgeReplyQueryState reply;

        public static /* synthetic */ Reply copy$default(Reply r100, AtKnowledgeReplyQueryState r101, int r102, Object r103) {
            if ((r102 & 1) == 0) goto L6;
            r101 = r100.reply;
        L6:
            return r100.copy(r101);
        }

        public final AtKnowledgeReplyQueryState component1() {
            return this.reply;
        }

        public final Reply copy(AtKnowledgeReplyQueryState r100) {
            Intrinsics.checkNotNullParameter(r100, "reply");
            return new Reply(r100);
        }

        public boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof Reply) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.reply, ((Reply) r100).reply) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public int hashCode() {
            return this.reply.hashCode();
        }

        public String toString() {
            return "Reply(reply=" + this.reply + ')';
        }

        public final AtKnowledgeReplyQueryState getReply() {
            return this.reply;
        }

        public Reply(AtKnowledgeReplyQueryState r100) {
            Intrinsics.checkNotNullParameter(r100, "reply");
            super(null);
            this.reply = r100;
        }
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/ss/android/lark/chat/entity/message/content/UnreadAIReplyQueryState$WaitSdkResponse;", "Lcom/ss/android/lark/chat/entity/message/content/UnreadAIReplyQueryState;", "queryId", "", "<init>", "(J)V", "getQueryId", "()J", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "im-sdk-base_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class WaitSdkResponse extends UnreadAIReplyQueryState {
        private final long queryId;

        public static /* synthetic */ WaitSdkResponse copy$default(WaitSdkResponse r100, long r101, int r102, Object r103) {
            if ((r102 & 1) == 0) goto L6;
            r101 = r100.queryId;
        L6:
            return r100.copy(r101);
        }

        public final long component1() {
            return this.queryId;
        }

        public final WaitSdkResponse copy(long r100) {
            return new WaitSdkResponse(r100);
        }

        public boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof WaitSdkResponse) == true) goto L9;
            return false;
        L9:
            if (this.queryId == ((WaitSdkResponse) r100).queryId) goto L11;
            return false;
        L11:
            return true;
        }

        public int hashCode() {
            long r100 = this.queryId;
            return (int) (r100 ^ (r100 >>> 32));
        }

        public String toString() {
            return "WaitSdkResponse(queryId=" + this.queryId + ')';
        }

        public final long getQueryId() {
            return this.queryId;
        }

        public WaitSdkResponse(long r100) {
            super(null);
            this.queryId = r100;
        }
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/ss/android/lark/chat/entity/message/content/UnreadAIReplyQueryState$WaitServerResponse;", "Lcom/ss/android/lark/chat/entity/message/content/UnreadAIReplyQueryState;", "query", "Lcom/ss/android/lark/widget/richtext/RichText;", "<init>", "(Lcom/ss/android/lark/widget/richtext/RichText;)V", "getQuery", "()Lcom/ss/android/lark/widget/richtext/RichText;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "im-sdk-base_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class WaitServerResponse extends UnreadAIReplyQueryState {
        private final RichText query;

        public static /* synthetic */ WaitServerResponse copy$default(WaitServerResponse r100, RichText r101, int r102, Object r103) {
            if ((r102 & 1) == 0) goto L6;
            r101 = r100.query;
        L6:
            return r100.copy(r101);
        }

        public final RichText component1() {
            return this.query;
        }

        public final WaitServerResponse copy(RichText r100) {
            Intrinsics.checkNotNullParameter(r100, "query");
            return new WaitServerResponse(r100);
        }

        public boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof WaitServerResponse) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.query, ((WaitServerResponse) r100).query) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public int hashCode() {
            return this.query.hashCode();
        }

        public String toString() {
            return "WaitServerResponse(query=" + this.query + ')';
        }

        public final RichText getQuery() {
            return this.query;
        }

        public WaitServerResponse(RichText r100) {
            Intrinsics.checkNotNullParameter(r100, "query");
            super(null);
            this.query = r100;
        }
    }

    private UnreadAIReplyQueryState() {
    }

    public /* synthetic */ UnreadAIReplyQueryState(DefaultConstructorMarker r100) {
        this();
    }

    public final boolean differ(UnreadAIReplyQueryState r100) {
        Intrinsics.checkNotNullParameter(r100, "other");
        if (Intrinsics.areEqual(this, r100) == false) goto L6;
        return true;
    L6:
        if ((this instanceof WaitServerResponse) == false) goto L13;
        if ((r100 instanceof WaitServerResponse) == false) goto L13;
        if (Intrinsics.areEqual(((WaitServerResponse) this).getQuery(), ((WaitServerResponse) r100).getQuery()) == false) goto L13;
        return true;
    L13:
        if ((this instanceof WaitSdkResponse) == false) goto L20;
        if ((r100 instanceof WaitSdkResponse) == false) goto L20;
        if (((WaitSdkResponse) this).getQueryId() != ((WaitSdkResponse) r100).getQueryId()) goto L20;
        return true;
    L20:
        if ((this instanceof Reply) == true) goto L22;
    L42:
        return false;
    L22:
        if ((r100 instanceof Reply) == false) goto L42;
        AtKnowledgeReplyQueryState r101 = ((Reply) this).getReply();
        AtKnowledgeReplyQueryState r102 = ((Reply) r100).getReply();
        Intrinsics.checkNotNullParameter(r101, "<this>");
        Intrinsics.checkNotNullParameter(r102, "other");
        if (Intrinsics.areEqual(r101, r102) == false) goto L27;
        return true;
    L27:
        if (r101.getQueryId() == r102.getQueryId()) goto L30;
    L28:
        return false;
    L30:
        if (r101.getSeqId() != r102.getSeqId()) goto L28;
        if (r101.getQueryCreateTime() != r102.getQueryCreateTime()) goto L28;
        if (Intrinsics.areEqual(r101.getSource(), r102.getSource()) == false) goto L28;
        if (r101.getTriggerScene() != r102.getTriggerScene()) goto L28;
        return true;
    }
}
