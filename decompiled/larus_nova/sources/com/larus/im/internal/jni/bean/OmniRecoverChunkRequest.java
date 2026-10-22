package com.larus.im.internal.jni.bean;

import com.bytedance.android.ec.core.event.a;
import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import com.huawei.hms.framework.common.hianalytics.CrashHianalyticsData;
import juc.d;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.SerialName;
import kotlinx.serialization.Serializable;
import luc.f;
import nuc.b2;
import nuc.q2;
import nuc.v2;

/* JADX INFO: loaded from: classes29.dex */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 .2\u00060\u0001j\u0002`\u0002:\u0002-.BK\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b¢\u0006\u0004\b\f\u0010\rBS\b\u0010\u0012\u0006\u0010\u000e\u001a\u00020\u000b\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0004\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010¢\u0006\u0004\b\f\u0010\u0011J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010\u001c\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\t\u0010\u001d\u001a\u00020\tHÆ\u0003J\t\u0010\u001e\u001a\u00020\u000bHÆ\u0003JM\u0010\u001f\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00042\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000bHÆ\u0001J\u0013\u0010 \u001a\u00020\t2\b\u0010!\u001a\u0004\u0018\u00010\"HÖ\u0003J\t\u0010#\u001a\u00020\u000bHÖ\u0001J\t\u0010$\u001a\u00020\u0004HÖ\u0001J%\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020\u00002\u0006\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020+H\u0001¢\u0006\u0002\b,R\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u0012\u0010\u0013R\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u0014\u0010\u0013R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u0015\u0010\u0013R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u0016\u0010\u0013R\u0016\u0010\b\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u0017\u0010\u0013R\u0016\u0010\n\u001a\u00020\u000b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u0018\u0010\u0013¨\u0006/"}, d2 = {"Lcom/larus/im/internal/jni/bean/OmniRecoverChunkRequest;", "Ljava/io/Serializable;", "Lcom/flow/kmp/common/SerializableIO;", "replyUniqueKey", "", "questionId", "conversationId", "threadId", "isAsyncChunk", "", "appendScene", "", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZI)V", "seen0", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZILkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getReplyUniqueKey$annotations", "()V", "getQuestionId$annotations", "getConversationId$annotations", "getThreadId$annotations", "isAsyncChunk$annotations", "getAppendScene$annotations", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "other", "", "hashCode", "toString", "write$Self", "", "self", BdpAppEventConstant.PARAMS_OUTPUT, "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$omnisdk_release", "$serializer", "Companion", "omnisdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
@Serializable
public final class OmniRecoverChunkRequest implements java.io.Serializable {
    public static final Companion Companion = null;
    public final int appendScene;
    public final String conversationId;
    public final boolean isAsyncChunk;
    public final String questionId;
    public final String replyUniqueKey;
    public final String threadId;

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lcom/larus/im/internal/jni/bean/OmniRecoverChunkRequest$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/larus/im/internal/jni/bean/OmniRecoverChunkRequest;", "omnisdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }

        public final d<OmniRecoverChunkRequest> serializer() {
            return OmniRecoverChunkRequest$$serializer.INSTANCE;
        }
    }

    static {
        Companion = new Companion(null);
    }

    public OmniRecoverChunkRequest() {
        this(null, null, null, null, false, 0, 63, null);
    }

    public static /* synthetic */ OmniRecoverChunkRequest copy$default(OmniRecoverChunkRequest r100, String r101, String r102, String r103, String r104, boolean r105, int r110, int r111, Object r112) {
        if ((r111 & 1) == 0) goto L6;
        r101 = r100.replyUniqueKey;
    L6:
        if ((r111 & 2) == 0) goto L8;
        r102 = r100.questionId;
    L8:
        String r113 = r102;
        if ((r111 & 4) == 0) goto L11;
        r103 = r100.conversationId;
    L11:
        String r106 = r103;
        if ((r111 & 8) == 0) goto L14;
        r104 = r100.threadId;
    L14:
        String r107 = r104;
        if ((r111 & 16) == 0) goto L17;
        r105 = r100.isAsyncChunk;
    L17:
        boolean r108 = r105;
        if ((r111 & 32) == 0) goto L20;
        r110 = r100.appendScene;
    L20:
        String r109 = r101;
        return r100.copy(r109, r113, r106, r107, r108, r110);
    }

    @SerialName("append_scene")
    public static /* synthetic */ void getAppendScene$annotations() {
    }

    @SerialName("conversation_id")
    public static /* synthetic */ void getConversationId$annotations() {
    }

    @SerialName(a.KEY_QUESTION_ID)
    public static /* synthetic */ void getQuestionId$annotations() {
    }

    @SerialName("reply_unique_key")
    public static /* synthetic */ void getReplyUniqueKey$annotations() {
    }

    @SerialName(CrashHianalyticsData.THREAD_ID)
    public static /* synthetic */ void getThreadId$annotations() {
    }

    @SerialName("is_async_chunk")
    public static /* synthetic */ void isAsyncChunk$annotations() {
    }

    public final String component1() {
        return this.replyUniqueKey;
    }

    public final String component2() {
        return this.questionId;
    }

    public final String component3() {
        return this.conversationId;
    }

    public final String component4() {
        return this.threadId;
    }

    public final boolean component5() {
        return this.isAsyncChunk;
    }

    public final int component6() {
        return this.appendScene;
    }

    public final OmniRecoverChunkRequest copy(String r100, String r110, String r111, String r112, boolean r113, int r114) {
        return new OmniRecoverChunkRequest(r100, r110, r111, r112, r113, r114);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof OmniRecoverChunkRequest) == true) goto L8;
        return false;
    L8:
        OmniRecoverChunkRequest r101 = (OmniRecoverChunkRequest) r100;
        if (Intrinsics.areEqual(this.replyUniqueKey, r101.replyUniqueKey) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.questionId, r101.questionId) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.conversationId, r101.conversationId) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.threadId, r101.threadId) == true) goto L21;
        return false;
    L21:
        if (this.isAsyncChunk == r101.isAsyncChunk) goto L24;
        return false;
    L24:
        if (this.appendScene == r101.appendScene) goto L26;
        return false;
    L26:
        return true;
    }

    public int hashCode() {
        String r100 = this.replyUniqueKey;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.questionId;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.conversationId;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        String r110 = this.threadId;
        if (r110 == null) goto L18;
        r101 = r110.hashCode();
    L18:
        int r111 = (r109 + r101) * 31;
        if (this.isAsyncChunk == false) goto L21;
        int r112 = 1231;
    L23:
        return ((r111 + r112) * 31) + this.appendScene;
    L21:
        r112 = 1237;
        goto L23
    L13:
        r108 = r107.hashCode();
        goto L14
    L9:
        r105 = r104.hashCode();
        goto L10
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public String toString() {
        return "OmniRecoverChunkRequest(replyUniqueKey=" + this.replyUniqueKey + ", questionId=" + this.questionId + ", conversationId=" + this.conversationId + ", threadId=" + this.threadId + ", isAsyncChunk=" + this.isAsyncChunk + ", appendScene=" + this.appendScene + ')';
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$omnisdk_release(OmniRecoverChunkRequest r100, muc.d r101, f r102) {
        boolean r103 = false;
        if (r101.shouldEncodeElementDefault(r102, 0) == false) goto L6;
    L4:
        boolean r104 = true;
    L9:
        if (r104 == false) goto L12;
        r101.encodeNullableSerializableElement(r102, 0, v2.f520790a, r100.replyUniqueKey);
    L12:
        if (r101.shouldEncodeElementDefault(r102, 1) == false) goto L15;
    L13:
        boolean r105 = true;
    L18:
        if (r105 == false) goto L21;
        r101.encodeNullableSerializableElement(r102, 1, v2.f520790a, r100.questionId);
    L21:
        if (r101.shouldEncodeElementDefault(r102, 2) == false) goto L24;
    L22:
        boolean r106 = true;
    L27:
        if (r106 == false) goto L30;
        r101.encodeNullableSerializableElement(r102, 2, v2.f520790a, r100.conversationId);
    L30:
        if (r101.shouldEncodeElementDefault(r102, 3) == false) goto L33;
    L31:
        boolean r107 = true;
    L36:
        if (r107 == false) goto L39;
        r101.encodeNullableSerializableElement(r102, 3, v2.f520790a, r100.threadId);
    L39:
        if (r101.shouldEncodeElementDefault(r102, 4) == false) goto L42;
    L40:
        boolean r108 = true;
    L45:
        if (r108 == false) goto L48;
        r101.encodeBooleanElement(r102, 4, r100.isAsyncChunk);
    L48:
        if (r101.shouldEncodeElementDefault(r102, 5) == false) goto L51;
    L49:
        r103 = true;
    L53:
        if (r103 == false) goto L56;
        r101.encodeIntElement(r102, 5, r100.appendScene);
        return;
    L56:
        return;
    L51:
        if (r100.appendScene == 0) goto L53;
    L42:
        if (r100.isAsyncChunk == true) goto L40;
        r108 = false;
        goto L45
    L33:
        if (r100.threadId != null) goto L31;
        r107 = false;
        goto L36
    L24:
        if (r100.conversationId != null) goto L22;
        r106 = false;
        goto L27
    L15:
        if (r100.questionId != null) goto L13;
        r105 = false;
        goto L18
    L6:
        if (r100.replyUniqueKey != null) goto L4;
        r104 = false;
        goto L9
    }

    public OmniRecoverChunkRequest(String r100, String r101, String r102, String r103, boolean r104, int r105) {
        this.replyUniqueKey = r100;
        this.questionId = r101;
        this.conversationId = r102;
        this.threadId = r103;
        this.isAsyncChunk = r104;
        this.appendScene = r105;
    }

    public /* synthetic */ OmniRecoverChunkRequest(int r100, String r101, String r102, String r103, String r104, boolean r105, int r106, q2 r110) {
        if ((r100 & 0) == 0) goto L5;
        b2.b(r100, 0, OmniRecoverChunkRequest$$serializer.INSTANCE.getDescriptor());
        throw null;
    L5:
        if ((r100 & 1) != 0) goto L7;
        this.replyUniqueKey = null;
    L9:
        if ((r100 & 2) != 0) goto L11;
        this.questionId = null;
    L13:
        if ((r100 & 4) != 0) goto L15;
        this.conversationId = null;
    L17:
        if ((r100 & 8) != 0) goto L19;
        this.threadId = null;
    L21:
        if ((r100 & 16) != 0) goto L23;
        this.isAsyncChunk = false;
    L25:
        if ((r100 & 32) != 0) goto L27;
        this.appendScene = 0;
        return;
    L27:
        this.appendScene = r106;
        return;
    L23:
        this.isAsyncChunk = r105;
        goto L25
    L19:
        this.threadId = r104;
        goto L21
    L15:
        this.conversationId = r103;
        goto L17
    L11:
        this.questionId = r102;
        goto L13
    L7:
        this.replyUniqueKey = r101;
        goto L9
    }

    public /* synthetic */ OmniRecoverChunkRequest(String r100, String r101, String r102, String r103, boolean r104, int r110, int r111, DefaultConstructorMarker r112) {
        String r105 = null;
        if ((r111 & 1) == 0) goto L5;
        String r113 = null;
    L7:
        if ((r111 & 2) == 0) goto L9;
        String r106 = null;
    L11:
        if ((r111 & 4) == 0) goto L13;
        String r107 = null;
    L15:
        if ((r111 & 8) != 0) goto L19;
        r105 = r103;
    L19:
        if ((r111 & 16) == 0) goto L21;
        boolean r108 = false;
    L23:
        if ((r111 & 32) == 0) goto L25;
        int r114 = 0;
    L26:
        this(r113, r106, r107, r105, r108, r114);
        return;
    L25:
        r114 = r110;
        goto L26
    L21:
        r108 = r104;
        goto L23
    L13:
        r107 = r102;
        goto L15
    L9:
        r106 = r101;
        goto L11
    L5:
        r113 = r100;
        goto L7
    }
}
