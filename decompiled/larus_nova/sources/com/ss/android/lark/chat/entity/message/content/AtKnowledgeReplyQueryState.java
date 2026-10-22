package com.ss.android.lark.chat.entity.message.content;

import com.bytedance.lark.pb.basic.v1.CommonAIReply;
import com.bytedance.lark.pb.basic.v1.TriggerScene;
import com.ss.android.lark.widget.richtext.RichText;
import java.io.Serializable;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003:\u0006\u000b\f\r\u000e\u000f\u0010B\t\b\u0004¢\u0006\u0004\b\u0004\u0010\u0005J\u0006\u0010\u0006\u001a\u00020\u0007J\u0006\u0010\b\u001a\u00020\u0007J\u0006\u0010\t\u001a\u00020\u0007J\u0006\u0010\n\u001a\u00020\u0007\u0082\u0001\u0006\u0011\u0012\u0013\u0014\u0015\u0016¨\u0006\u0017"}, d2 = {"Lcom/ss/android/lark/chat/entity/message/content/AtKnowledgeReplyQueryState;", "Ljava/io/Serializable;", "Lcom/ss/android/lark/chat/entity/message/content/IReplyState;", "Lcom/ss/android/lark/chat/entity/message/content/IAtKnowledgeProperty;", "<init>", "()V", "isTransmitting", "", "isComplete", "isClose", "isEndState", "Closed", "NoAnswer", "Error", "Cot", "Transmitting", "Over", "Lcom/ss/android/lark/chat/entity/message/content/AtKnowledgeReplyQueryState$Closed;", "Lcom/ss/android/lark/chat/entity/message/content/AtKnowledgeReplyQueryState$Cot;", "Lcom/ss/android/lark/chat/entity/message/content/AtKnowledgeReplyQueryState$Error;", "Lcom/ss/android/lark/chat/entity/message/content/AtKnowledgeReplyQueryState$NoAnswer;", "Lcom/ss/android/lark/chat/entity/message/content/AtKnowledgeReplyQueryState$Over;", "Lcom/ss/android/lark/chat/entity/message/content/AtKnowledgeReplyQueryState$Transmitting;", "im-sdk-base_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public abstract class AtKnowledgeReplyQueryState implements Serializable {

    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0010\b\u0016\u0018\u00002\u00020\u0001BC\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u000e¢\u0006\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0004\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0012R\u0014\u0010\u0005\u001a\u00020\u0006X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0007\u001a\u00020\bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0014\u0010\t\u001a\u00020\nX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0016\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0016\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001d¨\u0006\u001e"}, d2 = {"Lcom/ss/android/lark/chat/entity/message/content/AtKnowledgeReplyQueryState$Closed;", "Lcom/ss/android/lark/chat/entity/message/content/AtKnowledgeReplyQueryState;", "queryId", "", "queryCreateTime", "seqId", "", "aiReplyId", "", "query", "Lcom/ss/android/lark/widget/richtext/RichText;", "source", "Lcom/ss/android/lark/chat/entity/message/content/AtAIKnowledgeSourceClient;", "triggerScene", "Lcom/bytedance/lark/pb/basic/v1/TriggerScene;", "<init>", "(JJILjava/lang/String;Lcom/ss/android/lark/widget/richtext/RichText;Lcom/ss/android/lark/chat/entity/message/content/AtAIKnowledgeSourceClient;Lcom/bytedance/lark/pb/basic/v1/TriggerScene;)V", "getQueryId", "()J", "getQueryCreateTime", "getSeqId", "()I", "getAiReplyId", "()Ljava/lang/String;", "getQuery", "()Lcom/ss/android/lark/widget/richtext/RichText;", "getSource", "()Lcom/ss/android/lark/chat/entity/message/content/AtAIKnowledgeSourceClient;", "getTriggerScene", "()Lcom/bytedance/lark/pb/basic/v1/TriggerScene;", "im-sdk-base_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static class Closed extends AtKnowledgeReplyQueryState {
        private final String aiReplyId;
        private final RichText query;
        private final long queryCreateTime;
        private final long queryId;
        private final int seqId;
        private final AtAIKnowledgeSourceClient source;
        private final TriggerScene triggerScene;

        @Override // com.ss.android.lark.chat.entity.message.content.AtKnowledgeReplyQueryState
        public String getAiReplyId() {
            return this.aiReplyId;
        }

        @Override // com.ss.android.lark.chat.entity.message.content.AtKnowledgeReplyQueryState
        public RichText getQuery() {
            return this.query;
        }

        @Override // com.ss.android.lark.chat.entity.message.content.AtKnowledgeReplyQueryState
        public long getQueryCreateTime() {
            return this.queryCreateTime;
        }

        @Override // com.ss.android.lark.chat.entity.message.content.AtKnowledgeReplyQueryState
        public long getQueryId() {
            return this.queryId;
        }

        @Override // com.ss.android.lark.chat.entity.message.content.AtKnowledgeReplyQueryState
        public int getSeqId() {
            return this.seqId;
        }

        @Override // com.ss.android.lark.chat.entity.message.content.AtKnowledgeReplyQueryState
        public AtAIKnowledgeSourceClient getSource() {
            return this.source;
        }

        @Override // com.ss.android.lark.chat.entity.message.content.AtKnowledgeReplyQueryState
        public TriggerScene getTriggerScene() {
            return this.triggerScene;
        }

        public Closed(long r100, long r101, int r102, String r103, RichText r104, AtAIKnowledgeSourceClient r105, TriggerScene r110) {
            Intrinsics.checkNotNullParameter(r103, "aiReplyId");
            Intrinsics.checkNotNullParameter(r104, "query");
            super(null);
            this.queryId = r100;
            this.queryCreateTime = r101;
            this.seqId = r102;
            this.aiReplyId = r103;
            this.query = r104;
            this.source = r105;
            this.triggerScene = r110;
        }
    }

    @Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001a\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001BK\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\b\u0012\b\u0010\f\u001a\u0004\u0018\u00010\r\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f¢\u0006\u0004\b\u0010\u0010\u0011J\t\u0010 \u001a\u00020\u0003HÆ\u0003J\t\u0010!\u001a\u00020\u0003HÆ\u0003J\t\u0010\"\u001a\u00020\u0006HÆ\u0003J\t\u0010#\u001a\u00020\bHÆ\u0003J\t\u0010$\u001a\u00020\nHÆ\u0003J\t\u0010%\u001a\u00020\bHÆ\u0003J\u000b\u0010&\u001a\u0004\u0018\u00010\rHÆ\u0003J\u000b\u0010'\u001a\u0004\u0018\u00010\u000fHÆ\u0003J]\u0010(\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000fHÆ\u0001J\u0013\u0010)\u001a\u00020*2\b\u0010+\u001a\u0004\u0018\u00010,HÖ\u0003J\t\u0010-\u001a\u00020\u0006HÖ\u0001J\t\u0010.\u001a\u00020\bHÖ\u0001R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0004\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0013R\u0014\u0010\u0005\u001a\u00020\u0006X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0014\u0010\u0007\u001a\u00020\bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0014\u0010\t\u001a\u00020\nX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0011\u0010\u000b\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0018R\u0016\u0010\f\u001a\u0004\u0018\u00010\rX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0016\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001f¨\u0006/"}, d2 = {"Lcom/ss/android/lark/chat/entity/message/content/AtKnowledgeReplyQueryState$Cot;", "Lcom/ss/android/lark/chat/entity/message/content/AtKnowledgeReplyQueryState;", "queryId", "", "queryCreateTime", "seqId", "", "aiReplyId", "", "query", "Lcom/ss/android/lark/widget/richtext/RichText;", "cotText", "source", "Lcom/ss/android/lark/chat/entity/message/content/AtAIKnowledgeSourceClient;", "triggerScene", "Lcom/bytedance/lark/pb/basic/v1/TriggerScene;", "<init>", "(JJILjava/lang/String;Lcom/ss/android/lark/widget/richtext/RichText;Ljava/lang/String;Lcom/ss/android/lark/chat/entity/message/content/AtAIKnowledgeSourceClient;Lcom/bytedance/lark/pb/basic/v1/TriggerScene;)V", "getQueryId", "()J", "getQueryCreateTime", "getSeqId", "()I", "getAiReplyId", "()Ljava/lang/String;", "getQuery", "()Lcom/ss/android/lark/widget/richtext/RichText;", "getCotText", "getSource", "()Lcom/ss/android/lark/chat/entity/message/content/AtAIKnowledgeSourceClient;", "getTriggerScene", "()Lcom/bytedance/lark/pb/basic/v1/TriggerScene;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "equals", "", "other", "", "hashCode", "toString", "im-sdk-base_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Cot extends AtKnowledgeReplyQueryState {
        private final String aiReplyId;
        private final String cotText;
        private final RichText query;
        private final long queryCreateTime;
        private final long queryId;
        private final int seqId;
        private final AtAIKnowledgeSourceClient source;
        private final TriggerScene triggerScene;

        public static /* synthetic */ Cot copy$default(Cot r110, long r111, long r112, int r113, String r114, RichText r115, String r116, AtAIKnowledgeSourceClient r210, TriggerScene r211, int r212, Object r213) {
            if ((r212 & 1) == 0) goto L5;
            long r100 = r110.queryId;
        L7:
            if ((r212 & 2) == 0) goto L9;
            long r101 = r110.queryCreateTime;
        L11:
            if ((r212 & 4) == 0) goto L13;
            int r102 = r110.seqId;
        L15:
            if ((r212 & 8) == 0) goto L17;
            String r103 = r110.aiReplyId;
        L19:
            if ((r212 & 16) == 0) goto L21;
            RichText r104 = r110.query;
        L23:
            if ((r212 & 32) == 0) goto L25;
            String r105 = r110.cotText;
        L27:
            if ((r212 & 64) == 0) goto L29;
            AtAIKnowledgeSourceClient r117 = r110.source;
        L31:
            if ((r212 & 128) == 0) goto L33;
            TriggerScene r106 = r110.triggerScene;
        L35:
            return r110.copy(r100, r101, r102, r103, r104, r105, r117, r106);
        L33:
            r106 = r211;
            goto L35
        L29:
            r117 = r210;
            goto L31
        L25:
            r105 = r116;
            goto L27
        L21:
            r104 = r115;
            goto L23
        L17:
            r103 = r114;
            goto L19
        L13:
            r102 = r113;
            goto L15
        L9:
            r101 = r112;
            goto L11
        L5:
            r100 = r111;
            goto L7
        }

        public final long component1() {
            return this.queryId;
        }

        public final long component2() {
            return this.queryCreateTime;
        }

        public final int component3() {
            return this.seqId;
        }

        public final String component4() {
            return this.aiReplyId;
        }

        public final RichText component5() {
            return this.query;
        }

        public final String component6() {
            return this.cotText;
        }

        public final AtAIKnowledgeSourceClient component7() {
            return this.source;
        }

        public final TriggerScene component8() {
            return this.triggerScene;
        }

        public final Cot copy(long r110, long r111, int r112, String r113, RichText r114, String r210, AtAIKnowledgeSourceClient r211, TriggerScene r212) {
            Intrinsics.checkNotNullParameter(r113, "aiReplyId");
            Intrinsics.checkNotNullParameter(r114, "query");
            Intrinsics.checkNotNullParameter(r210, "cotText");
            return new Cot(r110, r111, r112, r113, r114, r210, r211, r212);
        }

        public boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof Cot) == true) goto L8;
            return false;
        L8:
            Cot r101 = (Cot) r100;
            if (this.queryId == r101.queryId) goto L12;
            return false;
        L12:
            if (this.queryCreateTime == r101.queryCreateTime) goto L15;
            return false;
        L15:
            if (this.seqId == r101.seqId) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.aiReplyId, r101.aiReplyId) == true) goto L21;
            return false;
        L21:
            if (Intrinsics.areEqual(this.query, r101.query) == true) goto L24;
            return false;
        L24:
            if (Intrinsics.areEqual(this.cotText, r101.cotText) == true) goto L27;
            return false;
        L27:
            if (Intrinsics.areEqual(this.source, r101.source) == true) goto L30;
            return false;
        L30:
            if (this.triggerScene == r101.triggerScene) goto L32;
            return false;
        L32:
            return true;
        }

        public int hashCode() {
            long r100 = this.queryId;
            int r101 = ((int) (r100 ^ (r100 >>> 32))) * 31;
            long r102 = this.queryCreateTime;
            int r103 = (((((((((r101 + ((int) (r102 ^ (r102 >>> 32)))) * 31) + this.seqId) * 31) + this.aiReplyId.hashCode()) * 31) + this.query.hashCode()) * 31) + this.cotText.hashCode()) * 31;
            AtAIKnowledgeSourceClient r104 = this.source;
            int r105 = 0;
            if (r104 != null) goto L5;
            int r106 = 0;
        L6:
            int r107 = (r103 + r106) * 31;
            TriggerScene r108 = this.triggerScene;
            if (r108 == null) goto L11;
            r105 = r108.hashCode();
        L11:
            return r107 + r105;
        L5:
            r106 = r104.hashCode();
            goto L6
        }

        public String toString() {
            return "Cot(queryId=" + this.queryId + ", queryCreateTime=" + this.queryCreateTime + ", seqId=" + this.seqId + ", aiReplyId=" + this.aiReplyId + ", query=" + this.query + ", cotText=" + this.cotText + ", source=" + this.source + ", triggerScene=" + this.triggerScene + ')';
        }

        @Override // com.ss.android.lark.chat.entity.message.content.AtKnowledgeReplyQueryState
        public String getAiReplyId() {
            return this.aiReplyId;
        }

        public final String getCotText() {
            return this.cotText;
        }

        @Override // com.ss.android.lark.chat.entity.message.content.AtKnowledgeReplyQueryState
        public RichText getQuery() {
            return this.query;
        }

        @Override // com.ss.android.lark.chat.entity.message.content.AtKnowledgeReplyQueryState
        public long getQueryCreateTime() {
            return this.queryCreateTime;
        }

        @Override // com.ss.android.lark.chat.entity.message.content.AtKnowledgeReplyQueryState
        public long getQueryId() {
            return this.queryId;
        }

        @Override // com.ss.android.lark.chat.entity.message.content.AtKnowledgeReplyQueryState
        public int getSeqId() {
            return this.seqId;
        }

        @Override // com.ss.android.lark.chat.entity.message.content.AtKnowledgeReplyQueryState
        public AtAIKnowledgeSourceClient getSource() {
            return this.source;
        }

        @Override // com.ss.android.lark.chat.entity.message.content.AtKnowledgeReplyQueryState
        public TriggerScene getTriggerScene() {
            return this.triggerScene;
        }

        public Cot(long r100, long r101, int r102, String r103, RichText r104, String r105, AtAIKnowledgeSourceClient r110, TriggerScene r111) {
            Intrinsics.checkNotNullParameter(r103, "aiReplyId");
            Intrinsics.checkNotNullParameter(r104, "query");
            Intrinsics.checkNotNullParameter(r105, "cotText");
            super(null);
            this.queryId = r100;
            this.queryCreateTime = r101;
            this.seqId = r102;
            this.aiReplyId = r103;
            this.query = r104;
            this.cotText = r105;
            this.source = r110;
            this.triggerScene = r111;
        }
    }

    @Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0018\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001BG\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u000e¢\u0006\u0004\b\u000f\u0010\u0010J\t\u0010\u001e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001f\u001a\u00020\u0003HÆ\u0003J\t\u0010 \u001a\u00020\u0006HÆ\u0003J\t\u0010!\u001a\u00020\bHÆ\u0003J\t\u0010\"\u001a\u00020\nHÆ\u0003J\u000b\u0010#\u001a\u0004\u0018\u00010\fHÆ\u0003J\u000b\u0010$\u001a\u0004\u0018\u00010\u000eHÆ\u0003JS\u0010%\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000eHÆ\u0001J\u0013\u0010&\u001a\u00020'2\b\u0010(\u001a\u0004\u0018\u00010)HÖ\u0003J\t\u0010*\u001a\u00020\u0006HÖ\u0001J\t\u0010+\u001a\u00020\bHÖ\u0001R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0004\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0012R\u0014\u0010\u0005\u001a\u00020\u0006X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0007\u001a\u00020\bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0014\u0010\t\u001a\u00020\nX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0016\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0016\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001d¨\u0006,"}, d2 = {"Lcom/ss/android/lark/chat/entity/message/content/AtKnowledgeReplyQueryState$Error;", "Lcom/ss/android/lark/chat/entity/message/content/AtKnowledgeReplyQueryState;", "queryId", "", "queryCreateTime", "seqId", "", "aiReplyId", "", "query", "Lcom/ss/android/lark/widget/richtext/RichText;", "source", "Lcom/ss/android/lark/chat/entity/message/content/AtAIKnowledgeSourceClient;", "triggerScene", "Lcom/bytedance/lark/pb/basic/v1/TriggerScene;", "<init>", "(JJILjava/lang/String;Lcom/ss/android/lark/widget/richtext/RichText;Lcom/ss/android/lark/chat/entity/message/content/AtAIKnowledgeSourceClient;Lcom/bytedance/lark/pb/basic/v1/TriggerScene;)V", "getQueryId", "()J", "getQueryCreateTime", "getSeqId", "()I", "getAiReplyId", "()Ljava/lang/String;", "getQuery", "()Lcom/ss/android/lark/widget/richtext/RichText;", "getSource", "()Lcom/ss/android/lark/chat/entity/message/content/AtAIKnowledgeSourceClient;", "getTriggerScene", "()Lcom/bytedance/lark/pb/basic/v1/TriggerScene;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "", "other", "", "hashCode", "toString", "im-sdk-base_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Error extends AtKnowledgeReplyQueryState {
        private final String aiReplyId;
        private final RichText query;
        private final long queryCreateTime;
        private final long queryId;
        private final int seqId;
        private final AtAIKnowledgeSourceClient source;
        private final TriggerScene triggerScene;

        public static /* synthetic */ Error copy$default(Error r110, long r111, long r112, int r113, String r114, RichText r115, AtAIKnowledgeSourceClient r116, TriggerScene r117, int r210, Object r211) {
            if ((r210 & 1) == 0) goto L5;
            long r100 = r110.queryId;
        L7:
            if ((r210 & 2) == 0) goto L9;
            long r101 = r110.queryCreateTime;
        L11:
            if ((r210 & 4) == 0) goto L13;
            int r102 = r110.seqId;
        L15:
            if ((r210 & 8) == 0) goto L17;
            String r103 = r110.aiReplyId;
        L19:
            if ((r210 & 16) == 0) goto L21;
            RichText r104 = r110.query;
        L23:
            if ((r210 & 32) == 0) goto L25;
            AtAIKnowledgeSourceClient r105 = r110.source;
        L27:
            if ((r210 & 64) == 0) goto L29;
            TriggerScene r106 = r110.triggerScene;
        L31:
            return r110.copy(r100, r101, r102, r103, r104, r105, r106);
        L29:
            r106 = r117;
            goto L31
        L25:
            r105 = r116;
            goto L27
        L21:
            r104 = r115;
            goto L23
        L17:
            r103 = r114;
            goto L19
        L13:
            r102 = r113;
            goto L15
        L9:
            r101 = r112;
            goto L11
        L5:
            r100 = r111;
            goto L7
        }

        public final long component1() {
            return this.queryId;
        }

        public final long component2() {
            return this.queryCreateTime;
        }

        public final int component3() {
            return this.seqId;
        }

        public final String component4() {
            return this.aiReplyId;
        }

        public final RichText component5() {
            return this.query;
        }

        public final AtAIKnowledgeSourceClient component6() {
            return this.source;
        }

        public final TriggerScene component7() {
            return this.triggerScene;
        }

        public final Error copy(long r110, long r111, int r112, String r113, RichText r114, AtAIKnowledgeSourceClient r115, TriggerScene r210) {
            Intrinsics.checkNotNullParameter(r113, "aiReplyId");
            Intrinsics.checkNotNullParameter(r114, "query");
            return new Error(r110, r111, r112, r113, r114, r115, r210);
        }

        public boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof Error) == true) goto L8;
            return false;
        L8:
            Error r101 = (Error) r100;
            if (this.queryId == r101.queryId) goto L12;
            return false;
        L12:
            if (this.queryCreateTime == r101.queryCreateTime) goto L15;
            return false;
        L15:
            if (this.seqId == r101.seqId) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.aiReplyId, r101.aiReplyId) == true) goto L21;
            return false;
        L21:
            if (Intrinsics.areEqual(this.query, r101.query) == true) goto L24;
            return false;
        L24:
            if (Intrinsics.areEqual(this.source, r101.source) == true) goto L27;
            return false;
        L27:
            if (this.triggerScene == r101.triggerScene) goto L29;
            return false;
        L29:
            return true;
        }

        public int hashCode() {
            long r100 = this.queryId;
            int r101 = ((int) (r100 ^ (r100 >>> 32))) * 31;
            long r102 = this.queryCreateTime;
            int r103 = (((((((r101 + ((int) (r102 ^ (r102 >>> 32)))) * 31) + this.seqId) * 31) + this.aiReplyId.hashCode()) * 31) + this.query.hashCode()) * 31;
            AtAIKnowledgeSourceClient r104 = this.source;
            int r105 = 0;
            if (r104 != null) goto L5;
            int r106 = 0;
        L6:
            int r107 = (r103 + r106) * 31;
            TriggerScene r108 = this.triggerScene;
            if (r108 == null) goto L11;
            r105 = r108.hashCode();
        L11:
            return r107 + r105;
        L5:
            r106 = r104.hashCode();
            goto L6
        }

        public String toString() {
            return "Error(queryId=" + this.queryId + ", queryCreateTime=" + this.queryCreateTime + ", seqId=" + this.seqId + ", aiReplyId=" + this.aiReplyId + ", query=" + this.query + ", source=" + this.source + ", triggerScene=" + this.triggerScene + ')';
        }

        @Override // com.ss.android.lark.chat.entity.message.content.AtKnowledgeReplyQueryState
        public String getAiReplyId() {
            return this.aiReplyId;
        }

        @Override // com.ss.android.lark.chat.entity.message.content.AtKnowledgeReplyQueryState
        public RichText getQuery() {
            return this.query;
        }

        @Override // com.ss.android.lark.chat.entity.message.content.AtKnowledgeReplyQueryState
        public long getQueryCreateTime() {
            return this.queryCreateTime;
        }

        @Override // com.ss.android.lark.chat.entity.message.content.AtKnowledgeReplyQueryState
        public long getQueryId() {
            return this.queryId;
        }

        @Override // com.ss.android.lark.chat.entity.message.content.AtKnowledgeReplyQueryState
        public int getSeqId() {
            return this.seqId;
        }

        @Override // com.ss.android.lark.chat.entity.message.content.AtKnowledgeReplyQueryState
        public AtAIKnowledgeSourceClient getSource() {
            return this.source;
        }

        @Override // com.ss.android.lark.chat.entity.message.content.AtKnowledgeReplyQueryState
        public TriggerScene getTriggerScene() {
            return this.triggerScene;
        }

        public Error(long r100, long r101, int r102, String r103, RichText r104, AtAIKnowledgeSourceClient r105, TriggerScene r110) {
            Intrinsics.checkNotNullParameter(r103, "aiReplyId");
            Intrinsics.checkNotNullParameter(r104, "query");
            super(null);
            this.queryId = r100;
            this.queryCreateTime = r101;
            this.seqId = r102;
            this.aiReplyId = r103;
            this.query = r104;
            this.source = r105;
            this.triggerScene = r110;
        }

        public /* synthetic */ Error(long r110, long r111, int r112, String r113, RichText r114, AtAIKnowledgeSourceClient r115, TriggerScene r210, int r211, DefaultConstructorMarker r212) {
            if ((r211 & 4) == 0) goto L5;
            int r100 = -1;
        L7:
            if ((r211 & 8) == 0) goto L9;
            String r101 = "";
        L10:
            this(r110, r111, r100, r101, r114, r115, r210);
            return;
        L9:
            r101 = r113;
            goto L10
        L5:
            r100 = r112;
            goto L7
        }
    }

    @Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001c\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001BW\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\u0006\u0010\f\u001a\u00020\b\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u000e\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010¢\u0006\u0004\b\u0011\u0010\u0012J\t\u0010\"\u001a\u00020\u0003HÆ\u0003J\t\u0010#\u001a\u00020\u0003HÆ\u0003J\t\u0010$\u001a\u00020\u0006HÆ\u0003J\t\u0010%\u001a\u00020\bHÆ\u0003J\t\u0010&\u001a\u00020\nHÆ\u0003J\t\u0010'\u001a\u00020\nHÆ\u0003J\t\u0010(\u001a\u00020\bHÆ\u0003J\u000b\u0010)\u001a\u0004\u0018\u00010\u000eHÆ\u0003J\u000b\u0010*\u001a\u0004\u0018\u00010\u0010HÆ\u0003Jg\u0010+\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\n2\b\b\u0002\u0010\f\u001a\u00020\b2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0010HÆ\u0001J\u0013\u0010,\u001a\u00020-2\b\u0010.\u001a\u0004\u0018\u00010/HÖ\u0003J\t\u00100\u001a\u00020\u0006HÖ\u0001J\t\u00101\u001a\u00020\bHÖ\u0001R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0004\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0014R\u0014\u0010\u0005\u001a\u00020\u0006X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0014\u0010\u0007\u001a\u00020\bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0014\u0010\t\u001a\u00020\nX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0011\u0010\u000b\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001bR\u0011\u0010\f\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0019R\u0016\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u0016\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b \u0010!¨\u00062"}, d2 = {"Lcom/ss/android/lark/chat/entity/message/content/AtKnowledgeReplyQueryState$NoAnswer;", "Lcom/ss/android/lark/chat/entity/message/content/AtKnowledgeReplyQueryState;", "queryId", "", "queryCreateTime", "seqId", "", "aiReplyId", "", "query", "Lcom/ss/android/lark/widget/richtext/RichText;", "content", "textWithoutCitation", "source", "Lcom/ss/android/lark/chat/entity/message/content/AtAIKnowledgeSourceClient;", "triggerScene", "Lcom/bytedance/lark/pb/basic/v1/TriggerScene;", "<init>", "(JJILjava/lang/String;Lcom/ss/android/lark/widget/richtext/RichText;Lcom/ss/android/lark/widget/richtext/RichText;Ljava/lang/String;Lcom/ss/android/lark/chat/entity/message/content/AtAIKnowledgeSourceClient;Lcom/bytedance/lark/pb/basic/v1/TriggerScene;)V", "getQueryId", "()J", "getQueryCreateTime", "getSeqId", "()I", "getAiReplyId", "()Ljava/lang/String;", "getQuery", "()Lcom/ss/android/lark/widget/richtext/RichText;", "getContent", "getTextWithoutCitation", "getSource", "()Lcom/ss/android/lark/chat/entity/message/content/AtAIKnowledgeSourceClient;", "getTriggerScene", "()Lcom/bytedance/lark/pb/basic/v1/TriggerScene;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "", "other", "", "hashCode", "toString", "im-sdk-base_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class NoAnswer extends AtKnowledgeReplyQueryState {
        private final String aiReplyId;
        private final RichText content;
        private final RichText query;
        private final long queryCreateTime;
        private final long queryId;
        private final int seqId;
        private final AtAIKnowledgeSourceClient source;
        private final String textWithoutCitation;
        private final TriggerScene triggerScene;

        public static /* synthetic */ NoAnswer copy$default(NoAnswer r110, long r111, long r112, int r113, String r114, RichText r115, RichText r210, String r211, AtAIKnowledgeSourceClient r212, TriggerScene r213, int r214, Object r215) {
            if ((r214 & 1) == 0) goto L5;
            long r100 = r110.queryId;
        L7:
            if ((r214 & 2) == 0) goto L9;
            long r101 = r110.queryCreateTime;
        L11:
            if ((r214 & 4) == 0) goto L13;
            int r102 = r110.seqId;
        L15:
            if ((r214 & 8) == 0) goto L17;
            String r103 = r110.aiReplyId;
        L19:
            if ((r214 & 16) == 0) goto L21;
            RichText r104 = r110.query;
        L23:
            if ((r214 & 32) == 0) goto L25;
            RichText r105 = r110.content;
        L27:
            if ((r214 & 64) == 0) goto L29;
            String r116 = r110.textWithoutCitation;
        L31:
            if ((r214 & 128) == 0) goto L33;
            AtAIKnowledgeSourceClient r117 = r110.source;
        L35:
            if ((r214 & 256) == 0) goto L37;
            TriggerScene r106 = r110.triggerScene;
        L39:
            return r110.copy(r100, r101, r102, r103, r104, r105, r116, r117, r106);
        L37:
            r106 = r213;
            goto L39
        L33:
            r117 = r212;
            goto L35
        L29:
            r116 = r211;
            goto L31
        L25:
            r105 = r210;
            goto L27
        L21:
            r104 = r115;
            goto L23
        L17:
            r103 = r114;
            goto L19
        L13:
            r102 = r113;
            goto L15
        L9:
            r101 = r112;
            goto L11
        L5:
            r100 = r111;
            goto L7
        }

        public final long component1() {
            return this.queryId;
        }

        public final long component2() {
            return this.queryCreateTime;
        }

        public final int component3() {
            return this.seqId;
        }

        public final String component4() {
            return this.aiReplyId;
        }

        public final RichText component5() {
            return this.query;
        }

        public final RichText component6() {
            return this.content;
        }

        public final String component7() {
            return this.textWithoutCitation;
        }

        public final AtAIKnowledgeSourceClient component8() {
            return this.source;
        }

        public final TriggerScene component9() {
            return this.triggerScene;
        }

        public final NoAnswer copy(long r110, long r111, int r112, String r113, RichText r210, RichText r211, String r212, AtAIKnowledgeSourceClient r213, TriggerScene r214) {
            Intrinsics.checkNotNullParameter(r113, "aiReplyId");
            Intrinsics.checkNotNullParameter(r210, "query");
            Intrinsics.checkNotNullParameter(r211, "content");
            Intrinsics.checkNotNullParameter(r212, "textWithoutCitation");
            return new NoAnswer(r110, r111, r112, r113, r210, r211, r212, r213, r214);
        }

        public boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof NoAnswer) == true) goto L8;
            return false;
        L8:
            NoAnswer r101 = (NoAnswer) r100;
            if (this.queryId == r101.queryId) goto L12;
            return false;
        L12:
            if (this.queryCreateTime == r101.queryCreateTime) goto L15;
            return false;
        L15:
            if (this.seqId == r101.seqId) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.aiReplyId, r101.aiReplyId) == true) goto L21;
            return false;
        L21:
            if (Intrinsics.areEqual(this.query, r101.query) == true) goto L24;
            return false;
        L24:
            if (Intrinsics.areEqual(this.content, r101.content) == true) goto L27;
            return false;
        L27:
            if (Intrinsics.areEqual(this.textWithoutCitation, r101.textWithoutCitation) == true) goto L30;
            return false;
        L30:
            if (Intrinsics.areEqual(this.source, r101.source) == true) goto L33;
            return false;
        L33:
            if (this.triggerScene == r101.triggerScene) goto L35;
            return false;
        L35:
            return true;
        }

        public int hashCode() {
            long r100 = this.queryId;
            int r101 = ((int) (r100 ^ (r100 >>> 32))) * 31;
            long r102 = this.queryCreateTime;
            int r103 = (((((((((((r101 + ((int) (r102 ^ (r102 >>> 32)))) * 31) + this.seqId) * 31) + this.aiReplyId.hashCode()) * 31) + this.query.hashCode()) * 31) + this.content.hashCode()) * 31) + this.textWithoutCitation.hashCode()) * 31;
            AtAIKnowledgeSourceClient r104 = this.source;
            int r105 = 0;
            if (r104 != null) goto L5;
            int r106 = 0;
        L6:
            int r107 = (r103 + r106) * 31;
            TriggerScene r108 = this.triggerScene;
            if (r108 == null) goto L11;
            r105 = r108.hashCode();
        L11:
            return r107 + r105;
        L5:
            r106 = r104.hashCode();
            goto L6
        }

        public String toString() {
            return "NoAnswer(queryId=" + this.queryId + ", queryCreateTime=" + this.queryCreateTime + ", seqId=" + this.seqId + ", aiReplyId=" + this.aiReplyId + ", query=" + this.query + ", content=" + this.content + ", textWithoutCitation=" + this.textWithoutCitation + ", source=" + this.source + ", triggerScene=" + this.triggerScene + ')';
        }

        @Override // com.ss.android.lark.chat.entity.message.content.AtKnowledgeReplyQueryState
        public String getAiReplyId() {
            return this.aiReplyId;
        }

        public final RichText getContent() {
            return this.content;
        }

        @Override // com.ss.android.lark.chat.entity.message.content.AtKnowledgeReplyQueryState
        public RichText getQuery() {
            return this.query;
        }

        @Override // com.ss.android.lark.chat.entity.message.content.AtKnowledgeReplyQueryState
        public long getQueryCreateTime() {
            return this.queryCreateTime;
        }

        @Override // com.ss.android.lark.chat.entity.message.content.AtKnowledgeReplyQueryState
        public long getQueryId() {
            return this.queryId;
        }

        @Override // com.ss.android.lark.chat.entity.message.content.AtKnowledgeReplyQueryState
        public int getSeqId() {
            return this.seqId;
        }

        @Override // com.ss.android.lark.chat.entity.message.content.AtKnowledgeReplyQueryState
        public AtAIKnowledgeSourceClient getSource() {
            return this.source;
        }

        public final String getTextWithoutCitation() {
            return this.textWithoutCitation;
        }

        @Override // com.ss.android.lark.chat.entity.message.content.AtKnowledgeReplyQueryState
        public TriggerScene getTriggerScene() {
            return this.triggerScene;
        }

        public NoAnswer(long r100, long r101, int r102, String r103, RichText r104, RichText r105, String r110, AtAIKnowledgeSourceClient r111, TriggerScene r112) {
            Intrinsics.checkNotNullParameter(r103, "aiReplyId");
            Intrinsics.checkNotNullParameter(r104, "query");
            Intrinsics.checkNotNullParameter(r105, "content");
            Intrinsics.checkNotNullParameter(r110, "textWithoutCitation");
            super(null);
            this.queryId = r100;
            this.queryCreateTime = r101;
            this.seqId = r102;
            this.aiReplyId = r103;
            this.query = r104;
            this.content = r105;
            this.textWithoutCitation = r110;
            this.source = r111;
            this.triggerScene = r112;
        }

        public /* synthetic */ NoAnswer(long r110, long r111, int r112, String r113, RichText r210, RichText r211, String r212, AtAIKnowledgeSourceClient r213, TriggerScene r214, int r215, DefaultConstructorMarker r216) {
            if ((r215 & 4) == 0) goto L5;
            int r100 = -1;
        L7:
            if ((r215 & 8) == 0) goto L9;
            String r101 = "";
        L10:
            this(r110, r111, r100, r101, r210, r211, r212, r213, r214);
            return;
        L9:
            r101 = r113;
            goto L10
        L5:
            r100 = r112;
            goto L7
        }
    }

    @Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b!\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001Bs\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\u0006\u0010\f\u001a\u00020\n\u0012\u0016\u0010\r\u001a\u0012\u0012\u0004\u0012\u00020\u000f0\u000ej\b\u0012\u0004\u0012\u00020\u000f`\u0010\u0012\u0006\u0010\u0011\u001a\u00020\b\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015¢\u0006\u0004\b\u0016\u0010\u0017J\t\u0010*\u001a\u00020\u0003HÆ\u0003J\t\u0010+\u001a\u00020\u0003HÆ\u0003J\t\u0010,\u001a\u00020\u0006HÆ\u0003J\t\u0010-\u001a\u00020\bHÆ\u0003J\t\u0010.\u001a\u00020\nHÆ\u0003J\t\u0010/\u001a\u00020\nHÆ\u0003J\t\u00100\u001a\u00020\nHÆ\u0003J\u0019\u00101\u001a\u0012\u0012\u0004\u0012\u00020\u000f0\u000ej\b\u0012\u0004\u0012\u00020\u000f`\u0010HÆ\u0003J\t\u00102\u001a\u00020\bHÆ\u0003J\u000b\u00103\u001a\u0004\u0018\u00010\u0013HÆ\u0003J\u000b\u00104\u001a\u0004\u0018\u00010\u0015HÆ\u0003J\u008b\u0001\u00105\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\n2\b\b\u0002\u0010\f\u001a\u00020\n2\u0018\b\u0002\u0010\r\u001a\u0012\u0012\u0004\u0012\u00020\u000f0\u000ej\b\u0012\u0004\u0012\u00020\u000f`\u00102\b\b\u0002\u0010\u0011\u001a\u00020\b2\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00132\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0015HÆ\u0001J\u0013\u00106\u001a\u0002072\b\u00108\u001a\u0004\u0018\u000109HÖ\u0003J\t\u0010:\u001a\u00020\u0006HÖ\u0001J\t\u0010;\u001a\u00020\bHÖ\u0001R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0014\u0010\u0004\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0019R\u0014\u0010\u0005\u001a\u00020\u0006X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0014\u0010\u0007\u001a\u00020\bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u0014\u0010\t\u001a\u00020\nX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u0011\u0010\u000b\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b!\u0010 R\u0011\u0010\f\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010 R!\u0010\r\u001a\u0012\u0012\u0004\u0012\u00020\u000f0\u000ej\b\u0012\u0004\u0012\u00020\u000f`\u0010¢\u0006\b\n\u0000\u001a\u0004\b#\u0010$R\u0011\u0010\u0011\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b%\u0010\u001eR\u0016\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b&\u0010'R\u0016\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b(\u0010)¨\u0006<"}, d2 = {"Lcom/ss/android/lark/chat/entity/message/content/AtKnowledgeReplyQueryState$Over;", "Lcom/ss/android/lark/chat/entity/message/content/AtKnowledgeReplyQueryState;", "queryId", "", "queryCreateTime", "seqId", "", "aiReplyId", "", "query", "Lcom/ss/android/lark/widget/richtext/RichText;", "content", "reference", "referenceList", "Ljava/util/ArrayList;", "Lcom/bytedance/lark/pb/basic/v1/CommonAIReply$ReferenceItem;", "Lkotlin/collections/ArrayList;", "textWithoutCitation", "source", "Lcom/ss/android/lark/chat/entity/message/content/AtAIKnowledgeSourceClient;", "triggerScene", "Lcom/bytedance/lark/pb/basic/v1/TriggerScene;", "<init>", "(JJILjava/lang/String;Lcom/ss/android/lark/widget/richtext/RichText;Lcom/ss/android/lark/widget/richtext/RichText;Lcom/ss/android/lark/widget/richtext/RichText;Ljava/util/ArrayList;Ljava/lang/String;Lcom/ss/android/lark/chat/entity/message/content/AtAIKnowledgeSourceClient;Lcom/bytedance/lark/pb/basic/v1/TriggerScene;)V", "getQueryId", "()J", "getQueryCreateTime", "getSeqId", "()I", "getAiReplyId", "()Ljava/lang/String;", "getQuery", "()Lcom/ss/android/lark/widget/richtext/RichText;", "getContent", "getReference", "getReferenceList", "()Ljava/util/ArrayList;", "getTextWithoutCitation", "getSource", "()Lcom/ss/android/lark/chat/entity/message/content/AtAIKnowledgeSourceClient;", "getTriggerScene", "()Lcom/bytedance/lark/pb/basic/v1/TriggerScene;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "copy", "equals", "", "other", "", "hashCode", "toString", "im-sdk-base_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Over extends AtKnowledgeReplyQueryState {
        private final String aiReplyId;
        private final RichText content;
        private final RichText query;
        private final long queryCreateTime;
        private final long queryId;
        private final RichText reference;
        private final ArrayList<CommonAIReply.ReferenceItem> referenceList;
        private final int seqId;
        private final AtAIKnowledgeSourceClient source;
        private final String textWithoutCitation;
        private final TriggerScene triggerScene;

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ Over copy$default(Over r110, long r111, long r112, int r113, String r210, RichText r211, RichText r212, RichText r213, ArrayList r214, String r215, AtAIKnowledgeSourceClient r216, TriggerScene r217, int r218, Object r219) {
            if ((r218 & 1) == 0) goto L5;
            long r100 = r110.queryId;
        L7:
            if ((r218 & 2) == 0) goto L9;
            long r101 = r110.queryCreateTime;
        L11:
            if ((r218 & 4) == 0) goto L13;
            int r102 = r110.seqId;
        L15:
            if ((r218 & 8) == 0) goto L17;
            String r103 = r110.aiReplyId;
        L19:
            if ((r218 & 16) == 0) goto L21;
            RichText r104 = r110.query;
        L23:
            if ((r218 & 32) == 0) goto L25;
            RichText r105 = r110.content;
        L27:
            if ((r218 & 64) == 0) goto L29;
            RichText r114 = r110.reference;
        L31:
            if ((r218 & 128) == 0) goto L33;
            ArrayList r115 = r110.referenceList;
        L35:
            if ((r218 & 256) == 0) goto L37;
            String r116 = r110.textWithoutCitation;
        L39:
            if ((r218 & 512) == 0) goto L41;
            AtAIKnowledgeSourceClient r117 = r110.source;
        L43:
            if ((r218 & 1024) == 0) goto L45;
            TriggerScene r106 = r110.triggerScene;
        L47:
            return r110.copy(r100, r101, r102, r103, r104, r105, r114, r115, r116, r117, r106);
        L45:
            r106 = r217;
            goto L47
        L41:
            r117 = r216;
            goto L43
        L37:
            r116 = r215;
            goto L39
        L33:
            r115 = r214;
            goto L35
        L29:
            r114 = r213;
            goto L31
        L25:
            r105 = r212;
            goto L27
        L21:
            r104 = r211;
            goto L23
        L17:
            r103 = r210;
            goto L19
        L13:
            r102 = r113;
            goto L15
        L9:
            r101 = r112;
            goto L11
        L5:
            r100 = r111;
            goto L7
        }

        public final long component1() {
            return this.queryId;
        }

        public final AtAIKnowledgeSourceClient component10() {
            return this.source;
        }

        public final TriggerScene component11() {
            return this.triggerScene;
        }

        public final long component2() {
            return this.queryCreateTime;
        }

        public final int component3() {
            return this.seqId;
        }

        public final String component4() {
            return this.aiReplyId;
        }

        public final RichText component5() {
            return this.query;
        }

        public final RichText component6() {
            return this.content;
        }

        public final RichText component7() {
            return this.reference;
        }

        public final ArrayList<CommonAIReply.ReferenceItem> component8() {
            return this.referenceList;
        }

        public final String component9() {
            return this.textWithoutCitation;
        }

        public final Over copy(long r110, long r111, int r210, String r211, RichText r212, RichText r213, RichText r214, ArrayList<CommonAIReply.ReferenceItem> r215, String r216, AtAIKnowledgeSourceClient r217, TriggerScene r218) {
            Intrinsics.checkNotNullParameter(r211, "aiReplyId");
            Intrinsics.checkNotNullParameter(r212, "query");
            Intrinsics.checkNotNullParameter(r213, "content");
            Intrinsics.checkNotNullParameter(r214, "reference");
            Intrinsics.checkNotNullParameter(r215, "referenceList");
            Intrinsics.checkNotNullParameter(r216, "textWithoutCitation");
            return new Over(r110, r111, r210, r211, r212, r213, r214, r215, r216, r217, r218);
        }

        public boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof Over) == true) goto L8;
            return false;
        L8:
            Over r101 = (Over) r100;
            if (this.queryId == r101.queryId) goto L12;
            return false;
        L12:
            if (this.queryCreateTime == r101.queryCreateTime) goto L15;
            return false;
        L15:
            if (this.seqId == r101.seqId) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.aiReplyId, r101.aiReplyId) == true) goto L21;
            return false;
        L21:
            if (Intrinsics.areEqual(this.query, r101.query) == true) goto L24;
            return false;
        L24:
            if (Intrinsics.areEqual(this.content, r101.content) == true) goto L27;
            return false;
        L27:
            if (Intrinsics.areEqual(this.reference, r101.reference) == true) goto L30;
            return false;
        L30:
            if (Intrinsics.areEqual(this.referenceList, r101.referenceList) == true) goto L33;
            return false;
        L33:
            if (Intrinsics.areEqual(this.textWithoutCitation, r101.textWithoutCitation) == true) goto L36;
            return false;
        L36:
            if (Intrinsics.areEqual(this.source, r101.source) == true) goto L39;
            return false;
        L39:
            if (this.triggerScene == r101.triggerScene) goto L41;
            return false;
        L41:
            return true;
        }

        public int hashCode() {
            long r100 = this.queryId;
            int r101 = ((int) (r100 ^ (r100 >>> 32))) * 31;
            long r102 = this.queryCreateTime;
            int r103 = (((((((((((((((r101 + ((int) (r102 ^ (r102 >>> 32)))) * 31) + this.seqId) * 31) + this.aiReplyId.hashCode()) * 31) + this.query.hashCode()) * 31) + this.content.hashCode()) * 31) + this.reference.hashCode()) * 31) + this.referenceList.hashCode()) * 31) + this.textWithoutCitation.hashCode()) * 31;
            AtAIKnowledgeSourceClient r104 = this.source;
            int r105 = 0;
            if (r104 != null) goto L5;
            int r106 = 0;
        L6:
            int r107 = (r103 + r106) * 31;
            TriggerScene r108 = this.triggerScene;
            if (r108 == null) goto L11;
            r105 = r108.hashCode();
        L11:
            return r107 + r105;
        L5:
            r106 = r104.hashCode();
            goto L6
        }

        public String toString() {
            return "Over(queryId=" + this.queryId + ", queryCreateTime=" + this.queryCreateTime + ", seqId=" + this.seqId + ", aiReplyId=" + this.aiReplyId + ", query=" + this.query + ", content=" + this.content + ", reference=" + this.reference + ", referenceList=" + this.referenceList + ", textWithoutCitation=" + this.textWithoutCitation + ", source=" + this.source + ", triggerScene=" + this.triggerScene + ')';
        }

        @Override // com.ss.android.lark.chat.entity.message.content.AtKnowledgeReplyQueryState
        public String getAiReplyId() {
            return this.aiReplyId;
        }

        public final RichText getContent() {
            return this.content;
        }

        @Override // com.ss.android.lark.chat.entity.message.content.AtKnowledgeReplyQueryState
        public RichText getQuery() {
            return this.query;
        }

        @Override // com.ss.android.lark.chat.entity.message.content.AtKnowledgeReplyQueryState
        public long getQueryCreateTime() {
            return this.queryCreateTime;
        }

        @Override // com.ss.android.lark.chat.entity.message.content.AtKnowledgeReplyQueryState
        public long getQueryId() {
            return this.queryId;
        }

        public final RichText getReference() {
            return this.reference;
        }

        public final ArrayList<CommonAIReply.ReferenceItem> getReferenceList() {
            return this.referenceList;
        }

        @Override // com.ss.android.lark.chat.entity.message.content.AtKnowledgeReplyQueryState
        public int getSeqId() {
            return this.seqId;
        }

        @Override // com.ss.android.lark.chat.entity.message.content.AtKnowledgeReplyQueryState
        public AtAIKnowledgeSourceClient getSource() {
            return this.source;
        }

        public final String getTextWithoutCitation() {
            return this.textWithoutCitation;
        }

        @Override // com.ss.android.lark.chat.entity.message.content.AtKnowledgeReplyQueryState
        public TriggerScene getTriggerScene() {
            return this.triggerScene;
        }

        public Over(long r100, long r101, int r102, String r103, RichText r104, RichText r105, RichText r110, ArrayList<CommonAIReply.ReferenceItem> r111, String r112, AtAIKnowledgeSourceClient r113, TriggerScene r114) {
            Intrinsics.checkNotNullParameter(r103, "aiReplyId");
            Intrinsics.checkNotNullParameter(r104, "query");
            Intrinsics.checkNotNullParameter(r105, "content");
            Intrinsics.checkNotNullParameter(r110, "reference");
            Intrinsics.checkNotNullParameter(r111, "referenceList");
            Intrinsics.checkNotNullParameter(r112, "textWithoutCitation");
            super(null);
            this.queryId = r100;
            this.queryCreateTime = r101;
            this.seqId = r102;
            this.aiReplyId = r103;
            this.query = r104;
            this.content = r105;
            this.reference = r110;
            this.referenceList = r111;
            this.textWithoutCitation = r112;
            this.source = r113;
            this.triggerScene = r114;
        }
    }

    @Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001Bk\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\u0006\u0010\f\u001a\u00020\n\u0012\u0016\u0010\r\u001a\u0012\u0012\u0004\u0012\u00020\u000f0\u000ej\b\u0012\u0004\u0012\u00020\u000f`\u0010\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014¢\u0006\u0004\b\u0015\u0010\u0016J\t\u0010(\u001a\u00020\u0003HÆ\u0003J\t\u0010)\u001a\u00020\u0003HÆ\u0003J\t\u0010*\u001a\u00020\u0006HÆ\u0003J\t\u0010+\u001a\u00020\bHÆ\u0003J\t\u0010,\u001a\u00020\nHÆ\u0003J\t\u0010-\u001a\u00020\nHÆ\u0003J\t\u0010.\u001a\u00020\nHÆ\u0003J\u0019\u0010/\u001a\u0012\u0012\u0004\u0012\u00020\u000f0\u000ej\b\u0012\u0004\u0012\u00020\u000f`\u0010HÆ\u0003J\u000b\u00100\u001a\u0004\u0018\u00010\u0012HÆ\u0003J\u000b\u00101\u001a\u0004\u0018\u00010\u0014HÆ\u0003J\u0081\u0001\u00102\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\n2\b\b\u0002\u0010\f\u001a\u00020\n2\u0018\b\u0002\u0010\r\u001a\u0012\u0012\u0004\u0012\u00020\u000f0\u000ej\b\u0012\u0004\u0012\u00020\u000f`\u00102\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00122\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0014HÆ\u0001J\u0013\u00103\u001a\u0002042\b\u00105\u001a\u0004\u0018\u000106HÖ\u0003J\t\u00107\u001a\u00020\u0006HÖ\u0001J\t\u00108\u001a\u00020\bHÖ\u0001R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0014\u0010\u0004\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0018R\u0014\u0010\u0005\u001a\u00020\u0006X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0014\u0010\u0007\u001a\u00020\bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0014\u0010\t\u001a\u00020\nX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u0011\u0010\u000b\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u001fR\u0011\u0010\f\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u001fR!\u0010\r\u001a\u0012\u0012\u0004\u0012\u00020\u000f0\u000ej\b\u0012\u0004\u0012\u00020\u000f`\u0010¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010#R\u0016\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b$\u0010%R\u0016\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b&\u0010'¨\u00069"}, d2 = {"Lcom/ss/android/lark/chat/entity/message/content/AtKnowledgeReplyQueryState$Transmitting;", "Lcom/ss/android/lark/chat/entity/message/content/AtKnowledgeReplyQueryState;", "queryId", "", "queryCreateTime", "seqId", "", "aiReplyId", "", "query", "Lcom/ss/android/lark/widget/richtext/RichText;", "content", "reference", "referenceList", "Ljava/util/ArrayList;", "Lcom/bytedance/lark/pb/basic/v1/CommonAIReply$ReferenceItem;", "Lkotlin/collections/ArrayList;", "source", "Lcom/ss/android/lark/chat/entity/message/content/AtAIKnowledgeSourceClient;", "triggerScene", "Lcom/bytedance/lark/pb/basic/v1/TriggerScene;", "<init>", "(JJILjava/lang/String;Lcom/ss/android/lark/widget/richtext/RichText;Lcom/ss/android/lark/widget/richtext/RichText;Lcom/ss/android/lark/widget/richtext/RichText;Ljava/util/ArrayList;Lcom/ss/android/lark/chat/entity/message/content/AtAIKnowledgeSourceClient;Lcom/bytedance/lark/pb/basic/v1/TriggerScene;)V", "getQueryId", "()J", "getQueryCreateTime", "getSeqId", "()I", "getAiReplyId", "()Ljava/lang/String;", "getQuery", "()Lcom/ss/android/lark/widget/richtext/RichText;", "getContent", "getReference", "getReferenceList", "()Ljava/util/ArrayList;", "getSource", "()Lcom/ss/android/lark/chat/entity/message/content/AtAIKnowledgeSourceClient;", "getTriggerScene", "()Lcom/bytedance/lark/pb/basic/v1/TriggerScene;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "copy", "equals", "", "other", "", "hashCode", "toString", "im-sdk-base_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Transmitting extends AtKnowledgeReplyQueryState {
        private final String aiReplyId;
        private final RichText content;
        private final RichText query;
        private final long queryCreateTime;
        private final long queryId;
        private final RichText reference;
        private final ArrayList<CommonAIReply.ReferenceItem> referenceList;
        private final int seqId;
        private final AtAIKnowledgeSourceClient source;
        private final TriggerScene triggerScene;

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ Transmitting copy$default(Transmitting r110, long r111, long r112, int r113, String r114, RichText r210, RichText r211, RichText r212, ArrayList r213, AtAIKnowledgeSourceClient r214, TriggerScene r215, int r216, Object r217) {
            if ((r216 & 1) == 0) goto L5;
            long r100 = r110.queryId;
        L7:
            if ((r216 & 2) == 0) goto L9;
            long r101 = r110.queryCreateTime;
        L11:
            if ((r216 & 4) == 0) goto L13;
            int r102 = r110.seqId;
        L15:
            if ((r216 & 8) == 0) goto L17;
            String r103 = r110.aiReplyId;
        L19:
            if ((r216 & 16) == 0) goto L21;
            RichText r104 = r110.query;
        L23:
            if ((r216 & 32) == 0) goto L25;
            RichText r105 = r110.content;
        L27:
            if ((r216 & 64) == 0) goto L29;
            RichText r115 = r110.reference;
        L31:
            if ((r216 & 128) == 0) goto L33;
            ArrayList r116 = r110.referenceList;
        L35:
            if ((r216 & 256) == 0) goto L37;
            AtAIKnowledgeSourceClient r117 = r110.source;
        L39:
            if ((r216 & 512) == 0) goto L41;
            TriggerScene r106 = r110.triggerScene;
        L43:
            return r110.copy(r100, r101, r102, r103, r104, r105, r115, r116, r117, r106);
        L41:
            r106 = r215;
            goto L43
        L37:
            r117 = r214;
            goto L39
        L33:
            r116 = r213;
            goto L35
        L29:
            r115 = r212;
            goto L31
        L25:
            r105 = r211;
            goto L27
        L21:
            r104 = r210;
            goto L23
        L17:
            r103 = r114;
            goto L19
        L13:
            r102 = r113;
            goto L15
        L9:
            r101 = r112;
            goto L11
        L5:
            r100 = r111;
            goto L7
        }

        public final long component1() {
            return this.queryId;
        }

        public final TriggerScene component10() {
            return this.triggerScene;
        }

        public final long component2() {
            return this.queryCreateTime;
        }

        public final int component3() {
            return this.seqId;
        }

        public final String component4() {
            return this.aiReplyId;
        }

        public final RichText component5() {
            return this.query;
        }

        public final RichText component6() {
            return this.content;
        }

        public final RichText component7() {
            return this.reference;
        }

        public final ArrayList<CommonAIReply.ReferenceItem> component8() {
            return this.referenceList;
        }

        public final AtAIKnowledgeSourceClient component9() {
            return this.source;
        }

        public final Transmitting copy(long r110, long r111, int r112, String r210, RichText r211, RichText r212, RichText r213, ArrayList<CommonAIReply.ReferenceItem> r214, AtAIKnowledgeSourceClient r215, TriggerScene r216) {
            Intrinsics.checkNotNullParameter(r210, "aiReplyId");
            Intrinsics.checkNotNullParameter(r211, "query");
            Intrinsics.checkNotNullParameter(r212, "content");
            Intrinsics.checkNotNullParameter(r213, "reference");
            Intrinsics.checkNotNullParameter(r214, "referenceList");
            return new Transmitting(r110, r111, r112, r210, r211, r212, r213, r214, r215, r216);
        }

        public boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof Transmitting) == true) goto L8;
            return false;
        L8:
            Transmitting r101 = (Transmitting) r100;
            if (this.queryId == r101.queryId) goto L12;
            return false;
        L12:
            if (this.queryCreateTime == r101.queryCreateTime) goto L15;
            return false;
        L15:
            if (this.seqId == r101.seqId) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.aiReplyId, r101.aiReplyId) == true) goto L21;
            return false;
        L21:
            if (Intrinsics.areEqual(this.query, r101.query) == true) goto L24;
            return false;
        L24:
            if (Intrinsics.areEqual(this.content, r101.content) == true) goto L27;
            return false;
        L27:
            if (Intrinsics.areEqual(this.reference, r101.reference) == true) goto L30;
            return false;
        L30:
            if (Intrinsics.areEqual(this.referenceList, r101.referenceList) == true) goto L33;
            return false;
        L33:
            if (Intrinsics.areEqual(this.source, r101.source) == true) goto L36;
            return false;
        L36:
            if (this.triggerScene == r101.triggerScene) goto L38;
            return false;
        L38:
            return true;
        }

        public int hashCode() {
            long r100 = this.queryId;
            int r101 = ((int) (r100 ^ (r100 >>> 32))) * 31;
            long r102 = this.queryCreateTime;
            int r103 = (((((((((((((r101 + ((int) (r102 ^ (r102 >>> 32)))) * 31) + this.seqId) * 31) + this.aiReplyId.hashCode()) * 31) + this.query.hashCode()) * 31) + this.content.hashCode()) * 31) + this.reference.hashCode()) * 31) + this.referenceList.hashCode()) * 31;
            AtAIKnowledgeSourceClient r104 = this.source;
            int r105 = 0;
            if (r104 != null) goto L5;
            int r106 = 0;
        L6:
            int r107 = (r103 + r106) * 31;
            TriggerScene r108 = this.triggerScene;
            if (r108 == null) goto L11;
            r105 = r108.hashCode();
        L11:
            return r107 + r105;
        L5:
            r106 = r104.hashCode();
            goto L6
        }

        public String toString() {
            return "Transmitting(queryId=" + this.queryId + ", queryCreateTime=" + this.queryCreateTime + ", seqId=" + this.seqId + ", aiReplyId=" + this.aiReplyId + ", query=" + this.query + ", content=" + this.content + ", reference=" + this.reference + ", referenceList=" + this.referenceList + ", source=" + this.source + ", triggerScene=" + this.triggerScene + ')';
        }

        @Override // com.ss.android.lark.chat.entity.message.content.AtKnowledgeReplyQueryState
        public String getAiReplyId() {
            return this.aiReplyId;
        }

        public final RichText getContent() {
            return this.content;
        }

        @Override // com.ss.android.lark.chat.entity.message.content.AtKnowledgeReplyQueryState
        public RichText getQuery() {
            return this.query;
        }

        @Override // com.ss.android.lark.chat.entity.message.content.AtKnowledgeReplyQueryState
        public long getQueryCreateTime() {
            return this.queryCreateTime;
        }

        @Override // com.ss.android.lark.chat.entity.message.content.AtKnowledgeReplyQueryState
        public long getQueryId() {
            return this.queryId;
        }

        public final RichText getReference() {
            return this.reference;
        }

        public final ArrayList<CommonAIReply.ReferenceItem> getReferenceList() {
            return this.referenceList;
        }

        @Override // com.ss.android.lark.chat.entity.message.content.AtKnowledgeReplyQueryState
        public int getSeqId() {
            return this.seqId;
        }

        @Override // com.ss.android.lark.chat.entity.message.content.AtKnowledgeReplyQueryState
        public AtAIKnowledgeSourceClient getSource() {
            return this.source;
        }

        @Override // com.ss.android.lark.chat.entity.message.content.AtKnowledgeReplyQueryState
        public TriggerScene getTriggerScene() {
            return this.triggerScene;
        }

        public Transmitting(long r100, long r101, int r102, String r103, RichText r104, RichText r105, RichText r110, ArrayList<CommonAIReply.ReferenceItem> r111, AtAIKnowledgeSourceClient r112, TriggerScene r113) {
            Intrinsics.checkNotNullParameter(r103, "aiReplyId");
            Intrinsics.checkNotNullParameter(r104, "query");
            Intrinsics.checkNotNullParameter(r105, "content");
            Intrinsics.checkNotNullParameter(r110, "reference");
            Intrinsics.checkNotNullParameter(r111, "referenceList");
            super(null);
            this.queryId = r100;
            this.queryCreateTime = r101;
            this.seqId = r102;
            this.aiReplyId = r103;
            this.query = r104;
            this.content = r105;
            this.reference = r110;
            this.referenceList = r111;
            this.source = r112;
            this.triggerScene = r113;
        }
    }

    private AtKnowledgeReplyQueryState() {
    }

    public /* synthetic */ AtKnowledgeReplyQueryState(DefaultConstructorMarker r100) {
        this();
    }

    public abstract /* synthetic */ String getAiReplyId();

    public abstract /* synthetic */ RichText getQuery();

    public abstract /* synthetic */ long getQueryCreateTime();

    public abstract /* synthetic */ long getQueryId();

    public abstract /* synthetic */ int getSeqId();

    public abstract /* synthetic */ AtAIKnowledgeSourceClient getSource();

    public abstract /* synthetic */ TriggerScene getTriggerScene();

    public final boolean isEndState() {
        if ((this instanceof Over) == false) goto L5;
    L10:
        return true;
    L5:
        if ((this instanceof Error) == true) goto L10;
        if ((this instanceof NoAnswer) == true) goto L10;
        return false;
    }

    public final boolean isTransmitting() {
        if ((this instanceof Transmitting) == false) goto L5;
    L8:
        return true;
    L5:
        if ((this instanceof Cot) == true) goto L8;
        return false;
    }

    public final boolean isClose() {
        return this instanceof Closed;
    }

    public final boolean isComplete() {
        return this instanceof Over;
    }
}
