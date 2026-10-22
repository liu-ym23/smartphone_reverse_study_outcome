package com.ss.android.lark.chat.entity.message;

import com.bytedance.lark.pb.im.v1.AIRecommendQuestionsType;
import com.ss.android.lark.chat.entity.message.content.UnreadAIReplyQueryState;
import im.v1.QuestionItem;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import y28.b;

/* JADX INFO: loaded from: classes35.dex */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b&\n\u0002\u0010\u0000\n\u0002\b\u0011\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u00012\u00020\u0002Bi\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t\u0012\u0006\u0010\u000b\u001a\u00020\u0004\u0012\b\b\u0002\u0010\f\u001a\u00020\r\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u000f\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0011\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0014¢\u0006\u0004\b\u0015\u0010\u0016J\u0012\u00106\u001a\u00020\r2\b\u00107\u001a\u0004\u0018\u00010\u0000H\u0016J\u0012\u00108\u001a\u00020\r2\b\u00107\u001a\u0004\u0018\u00010\u0000H\u0016J\u0013\u00109\u001a\u00020\r2\b\u0010:\u001a\u0004\u0018\u00010;H\u0096\u0002J\u0010\u0010<\u001a\u00020\r2\b\u0010=\u001a\u0004\u0018\u00010\u0000J\u0006\u0010>\u001a\u00020\rJ\t\u0010?\u001a\u00020\u0004HÆ\u0003J\t\u0010@\u001a\u00020\u0006HÆ\u0003J\t\u0010A\u001a\u00020\u0006HÆ\u0003J\u000f\u0010B\u001a\b\u0012\u0004\u0012\u00020\n0\tHÆ\u0003J\t\u0010C\u001a\u00020\u0004HÆ\u0003J\t\u0010D\u001a\u00020\rHÆ\u0003J\t\u0010E\u001a\u00020\u000fHÆ\u0003J\t\u0010F\u001a\u00020\u0011HÆ\u0003J\u0010\u0010G\u001a\u0004\u0018\u00010\u0004HÆ\u0003¢\u0006\u0002\u0010.J\u000b\u0010H\u001a\u0004\u0018\u00010\u0014HÆ\u0003J|\u0010I\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00062\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t2\b\b\u0002\u0010\u000b\u001a\u00020\u00042\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0014HÆ\u0001¢\u0006\u0002\u0010JJ\t\u0010K\u001a\u00020\u0006HÖ\u0001J\t\u0010L\u001a\u00020MHÖ\u0001R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u001a\u0010\u0007\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001a\"\u0004\b\u001e\u0010\u001cR\u0017\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u0011\u0010\u000b\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u0018R\u001a\u0010\f\u001a\u00020\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\"\"\u0004\b#\u0010$R\u001a\u0010\u000e\u001a\u00020\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R\u001a\u0010\u0010\u001a\u00020\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,R\u001e\u0010\u0012\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u0010\n\u0002\u00101\u001a\u0004\b-\u0010.\"\u0004\b/\u00100R\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b2\u00103\"\u0004\b4\u00105¨\u0006N"}, d2 = {"Lcom/ss/android/lark/chat/entity/message/AIRecommendQuestions;", "Lcom/larksuite/framework/utils/diff/Diffable;", "Ljava/io/Serializable;", "chatId", "", "startPos", "", "endPos", "questions", "", "Lim/v1/QuestionItem;", "generateTimestamp", "isShowBottom", "", "spaceType", "Lcom/ss/android/lark/chat/entity/message/AIRecommendQuestionViewSpace;", "type", "Lcom/bytedance/lark/pb/im/v1/AIRecommendQuestionsType;", "queryId", "aiReply", "Lcom/ss/android/lark/chat/entity/message/content/UnreadAIReplyQueryState;", "<init>", "(JIILjava/util/List;JZLcom/ss/android/lark/chat/entity/message/AIRecommendQuestionViewSpace;Lcom/bytedance/lark/pb/im/v1/AIRecommendQuestionsType;Ljava/lang/Long;Lcom/ss/android/lark/chat/entity/message/content/UnreadAIReplyQueryState;)V", "getChatId", "()J", "getStartPos", "()I", "setStartPos", "(I)V", "getEndPos", "setEndPos", "getQuestions", "()Ljava/util/List;", "getGenerateTimestamp", "()Z", "setShowBottom", "(Z)V", "getSpaceType", "()Lcom/ss/android/lark/chat/entity/message/AIRecommendQuestionViewSpace;", "setSpaceType", "(Lcom/ss/android/lark/chat/entity/message/AIRecommendQuestionViewSpace;)V", "getType", "()Lcom/bytedance/lark/pb/im/v1/AIRecommendQuestionsType;", "setType", "(Lcom/bytedance/lark/pb/im/v1/AIRecommendQuestionsType;)V", "getQueryId", "()Ljava/lang/Long;", "setQueryId", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", "getAiReply", "()Lcom/ss/android/lark/chat/entity/message/content/UnreadAIReplyQueryState;", "setAiReply", "(Lcom/ss/android/lark/chat/entity/message/content/UnreadAIReplyQueryState;)V", "isItemSame", "diffable", "isContentSame", "equals", "other", "", "isNeedScrollToBottom", "oldRecommend", "isShowAnswer", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "copy", "(JIILjava/util/List;JZLcom/ss/android/lark/chat/entity/message/AIRecommendQuestionViewSpace;Lcom/bytedance/lark/pb/im/v1/AIRecommendQuestionsType;Ljava/lang/Long;Lcom/ss/android/lark/chat/entity/message/content/UnreadAIReplyQueryState;)Lcom/ss/android/lark/chat/entity/message/AIRecommendQuestions;", "hashCode", "toString", "", "im-sdk-base_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AIRecommendQuestions implements b<AIRecommendQuestions>, Serializable {
    private UnreadAIReplyQueryState aiReply;
    private final long chatId;
    private int endPos;
    private final long generateTimestamp;
    private boolean isShowBottom;
    private Long queryId;
    private final List<QuestionItem> questions;
    private AIRecommendQuestionViewSpace spaceType;
    private int startPos;
    private AIRecommendQuestionsType type;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ AIRecommendQuestions copy$default(AIRecommendQuestions r110, long r111, int r112, int r113, List r114, long r115, boolean r210, AIRecommendQuestionViewSpace r211, AIRecommendQuestionsType r212, Long r213, UnreadAIReplyQueryState r214, int r215, Object r216) {
        if ((r215 & 1) == 0) goto L5;
        long r100 = r110.chatId;
    L7:
        if ((r215 & 2) == 0) goto L9;
        int r101 = r110.startPos;
    L11:
        if ((r215 & 4) == 0) goto L13;
        int r102 = r110.endPos;
    L15:
        if ((r215 & 8) == 0) goto L17;
        List r103 = r110.questions;
    L19:
        if ((r215 & 16) == 0) goto L21;
        long r104 = r110.generateTimestamp;
    L23:
        if ((r215 & 32) == 0) goto L25;
        boolean r105 = r110.isShowBottom;
    L27:
        if ((r215 & 64) == 0) goto L29;
        AIRecommendQuestionViewSpace r116 = r110.spaceType;
    L31:
        if ((r215 & 128) == 0) goto L33;
        AIRecommendQuestionsType r117 = r110.type;
    L35:
        if ((r215 & 256) == 0) goto L37;
        Long r118 = r110.queryId;
    L39:
        if ((r215 & 512) == 0) goto L41;
        UnreadAIReplyQueryState r106 = r110.aiReply;
    L43:
        return r110.copy(r100, r101, r102, r103, r104, r105, r116, r117, r118, r106);
    L41:
        r106 = r214;
        goto L43
    L37:
        r118 = r213;
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
        return this.chatId;
    }

    public final UnreadAIReplyQueryState component10() {
        return this.aiReply;
    }

    public final int component2() {
        return this.startPos;
    }

    public final int component3() {
        return this.endPos;
    }

    public final List<QuestionItem> component4() {
        return this.questions;
    }

    public final long component5() {
        return this.generateTimestamp;
    }

    public final boolean component6() {
        return this.isShowBottom;
    }

    public final AIRecommendQuestionViewSpace component7() {
        return this.spaceType;
    }

    public final AIRecommendQuestionsType component8() {
        return this.type;
    }

    public final Long component9() {
        return this.queryId;
    }

    public final AIRecommendQuestions copy(long r110, int r111, int r112, List<QuestionItem> r113, long r210, boolean r211, AIRecommendQuestionViewSpace r212, AIRecommendQuestionsType r213, Long r214, UnreadAIReplyQueryState r215) {
        Intrinsics.checkNotNullParameter(r113, "questions");
        Intrinsics.checkNotNullParameter(r212, "spaceType");
        Intrinsics.checkNotNullParameter(r213, "type");
        return new AIRecommendQuestions(r110, r111, r112, r113, r210, r211, r212, r213, r214, r215);
    }

    public int hashCode() {
        long r100 = this.chatId;
        int r101 = ((((((((int) (r100 ^ (r100 >>> 32))) * 31) + this.startPos) * 31) + this.endPos) * 31) + this.questions.hashCode()) * 31;
        long r102 = this.generateTimestamp;
        int r103 = (r101 + ((int) (r102 ^ (r102 >>> 32)))) * 31;
        if (this.isShowBottom == false) goto L5;
        int r104 = 1231;
    L6:
        int r105 = (((((r103 + r104) * 31) + this.spaceType.hashCode()) * 31) + this.type.hashCode()) * 31;
        Long r106 = this.queryId;
        int r107 = 0;
        if (r106 != null) goto L9;
        int r108 = 0;
    L10:
        int r109 = (r105 + r108) * 31;
        UnreadAIReplyQueryState r110 = this.aiReply;
        if (r110 == null) goto L15;
        r107 = r110.hashCode();
    L15:
        return r109 + r107;
    L9:
        r108 = r106.hashCode();
        goto L10
    L5:
        r104 = 1237;
        goto L6
    }

    public String toString() {
        return "AIRecommendQuestions(chatId=" + this.chatId + ", startPos=" + this.startPos + ", endPos=" + this.endPos + ", questions=" + this.questions + ", generateTimestamp=" + this.generateTimestamp + ", isShowBottom=" + this.isShowBottom + ", spaceType=" + this.spaceType + ", type=" + this.type + ", queryId=" + this.queryId + ", aiReply=" + this.aiReply + ')';
    }

    public final boolean isShowAnswer() {
        UnreadAIReplyQueryState r100 = this.aiReply;
        if ((r100 instanceof UnreadAIReplyQueryState.Reply) == false) goto L5;
        UnreadAIReplyQueryState.Reply r101 = (UnreadAIReplyQueryState.Reply) r100;
    L7:
        if (r101 != null) goto L10;
        return false;
    L10:
        if (r101.getReply().isComplete() == false) goto L12;
    L13:
        return true;
    L12:
        if (r101.getReply().isTransmitting() == true) goto L13;
        return false;
    L5:
        r101 = null;
        goto L7
    }

    public final UnreadAIReplyQueryState getAiReply() {
        return this.aiReply;
    }

    public final long getChatId() {
        return this.chatId;
    }

    public final int getEndPos() {
        return this.endPos;
    }

    public final long getGenerateTimestamp() {
        return this.generateTimestamp;
    }

    public final Long getQueryId() {
        return this.queryId;
    }

    public final List<QuestionItem> getQuestions() {
        return this.questions;
    }

    public final AIRecommendQuestionViewSpace getSpaceType() {
        return this.spaceType;
    }

    public final int getStartPos() {
        return this.startPos;
    }

    public final AIRecommendQuestionsType getType() {
        return this.type;
    }

    public final boolean isShowBottom() {
        return this.isShowBottom;
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof AIRecommendQuestions) == true) goto L10;
        return false;
    L10:
        return isContentSame((AIRecommendQuestions) r100);
    }

    public boolean isContentSame(AIRecommendQuestions r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if (r100 == null) goto L8;
        Class<AIRecommendQuestions> r101 = AIRecommendQuestions.class;
    L10:
        if (Intrinsics.areEqual(AIRecommendQuestions.class, r101) == true) goto L13;
        return false;
    L13:
        if (this.chatId == r100.chatId) goto L16;
        return false;
    L16:
        if (this.startPos == r100.startPos) goto L19;
        return false;
    L19:
        if (this.endPos == r100.endPos) goto L22;
        return false;
    L22:
        if (this.generateTimestamp == r100.generateTimestamp) goto L25;
        return false;
    L25:
        if (this.isShowBottom == r100.isShowBottom) goto L28;
        return false;
    L28:
        if (this.spaceType == r100.spaceType) goto L31;
        return false;
    L31:
        if (this.type == r100.type) goto L34;
        return false;
    L34:
        if (Intrinsics.areEqual(this.queryId, r100.queryId) == true) goto L36;
        return false;
    L36:
        UnreadAIReplyQueryState r102 = this.aiReply;
        UnreadAIReplyQueryState r103 = r100.aiReply;
        if (r102 == null) goto L43;
        if (r103 == null) goto L43;
        if (r102.differ(r103) == true) goto L45;
        return false;
    L45:
        List<QuestionItem> r104 = this.questions;
        ArrayList r105 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r104, 10));
        Iterator<T> r106 = r104.iterator();
    L47:
        if (r106.hasNext() == false) goto L49;
        r105.add(((QuestionItem) r106.next()).f490427id);
        goto L47
    L49:
        Set r107 = CollectionsKt.toSet(r105);
        List<QuestionItem> r108 = r100.questions;
        ArrayList r109 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r108, 10));
        Iterator<T> r110 = r108.iterator();
    L51:
        if (r110.hasNext() == false) goto L54;
        r109.add(((QuestionItem) r110.next()).f490427id);
        goto L51
    L54:
        return Intrinsics.areEqual(r107, CollectionsKt.toSet(r109));
    L43:
        if (Intrinsics.areEqual(r102, r103) == true) goto L45;
        return false;
    L8:
        r101 = null;
        goto L10
    }

    public boolean isItemSame(AIRecommendQuestions r100) {
        if (r100 != null) goto L5;
    L7:
        boolean r101 = false;
    L8:
        if (r101 == true) goto L10;
    L12:
        return false;
    L10:
        if (this.generateTimestamp != r100.generateTimestamp) goto L12;
        return true;
    L5:
        if (this.chatId != r100.chatId) goto L7;
        r101 = true;
        goto L8
    }

    public final boolean isNeedScrollToBottom(AIRecommendQuestions r100) {
        if (r100 != null) goto L5;
    L7:
        boolean r101 = false;
    L8:
        if (r101 == false) goto L11;
        return false;
    L11:
        if (isShowAnswer() == false) goto L13;
        return true;
    L13:
        return false;
    L5:
        if (r100.isShowAnswer() != true) goto L7;
        r101 = true;
        goto L8
    }

    public final void setAiReply(UnreadAIReplyQueryState r100) {
        this.aiReply = r100;
    }

    public final void setEndPos(int r100) {
        this.endPos = r100;
    }

    public final void setQueryId(Long r100) {
        this.queryId = r100;
    }

    public final void setShowBottom(boolean r100) {
        this.isShowBottom = r100;
    }

    public final void setSpaceType(AIRecommendQuestionViewSpace r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.spaceType = r100;
    }

    public final void setStartPos(int r100) {
        this.startPos = r100;
    }

    public final void setType(AIRecommendQuestionsType r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.type = r100;
    }

    @Override // y28.b
    public /* bridge */ /* synthetic */ boolean isContentSame(b r100) {
        return isContentSame((AIRecommendQuestions) r100);
    }

    @Override // y28.b
    public /* bridge */ /* synthetic */ boolean isItemSame(b r100) {
        return isItemSame((AIRecommendQuestions) r100);
    }

    public AIRecommendQuestions(long r100, int r101, int r102, List<QuestionItem> r103, long r104, boolean r105, AIRecommendQuestionViewSpace r110, AIRecommendQuestionsType r111, Long r112, UnreadAIReplyQueryState r113) {
        Intrinsics.checkNotNullParameter(r103, "questions");
        Intrinsics.checkNotNullParameter(r110, "spaceType");
        Intrinsics.checkNotNullParameter(r111, "type");
        this.chatId = r100;
        this.startPos = r101;
        this.endPos = r102;
        this.questions = r103;
        this.generateTimestamp = r104;
        this.isShowBottom = r105;
        this.spaceType = r110;
        this.type = r111;
        this.queryId = r112;
        this.aiReply = r113;
    }

    public /* synthetic */ AIRecommendQuestions(long r110, int r111, int r112, List r210, long r211, boolean r212, AIRecommendQuestionViewSpace r213, AIRecommendQuestionsType r214, Long r215, UnreadAIReplyQueryState r216, int r217, DefaultConstructorMarker r218) {
        if ((r217 & 32) == 0) goto L5;
        boolean r113 = true;
    L7:
        if ((r217 & 64) == 0) goto L9;
        AIRecommendQuestionViewSpace r114 = AIRecommendQuestionViewSpace.Normal;
    L11:
        if ((r217 & 128) == 0) goto L13;
        AIRecommendQuestionsType r115 = AIRecommendQuestionsType.UnreadSammary;
    L15:
        if ((r217 & 512) == 0) goto L17;
        UnreadAIReplyQueryState r116 = null;
    L18:
        this(r110, r111, r112, r210, r211, r113, r114, r115, r215, r116);
        return;
    L17:
        r116 = r216;
        goto L18
    L13:
        r115 = r214;
        goto L15
    L9:
        r114 = r213;
        goto L11
    L5:
        r113 = r212;
        goto L7
    }
}
