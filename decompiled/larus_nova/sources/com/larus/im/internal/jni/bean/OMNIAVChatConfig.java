package com.larus.im.internal.jni.bean;

import com.byted.cast.common.auth.AuthConstants;
import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import com.huawei.hms.api.FailedBinderCallBack;
import de9.h0;
import java.util.Map;
import juc.d;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.SerialName;
import kotlinx.serialization.Serializable;
import luc.f;
import nuc.a1;
import nuc.b2;
import nuc.q2;
import nuc.v2;

/* JADX INFO: loaded from: classes29.dex */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010$\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001a\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 >2\u00060\u0001j\u0002`\u0002:\u0002=>B\u0097\u0001\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0004\u0012\u0016\b\u0002\u0010\f\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\r\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0010\u0010\u0011B\u0095\u0001\b\u0010\u0012\u0006\u0010\u0012\u001a\u00020\u0013\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0004\u0012\u0014\u0010\f\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\r\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015¢\u0006\u0004\b\u0010\u0010\u0016J\u000b\u0010#\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010$\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010%\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010&\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010'\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010(\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010)\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010*\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u0017\u0010+\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\rHÆ\u0003J\u000b\u0010,\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010-\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u0099\u0001\u0010.\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00042\u0016\b\u0002\u0010\f\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\r2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0004HÆ\u0001J\u0013\u0010/\u001a\u0002002\b\u00101\u001a\u0004\u0018\u000102HÖ\u0003J\t\u00103\u001a\u00020\u0013HÖ\u0001J\t\u00104\u001a\u00020\u0004HÖ\u0001J%\u00105\u001a\u0002062\u0006\u00107\u001a\u00020\u00002\u0006\u00108\u001a\u0002092\u0006\u0010:\u001a\u00020;H\u0001¢\u0006\u0002\b<R\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u0017\u0010\u0018R\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u0019\u0010\u0018R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u001a\u0010\u0018R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u001b\u0010\u0018R\u0018\u0010\b\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u001c\u0010\u0018R\u0018\u0010\t\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u001d\u0010\u0018R\u0018\u0010\n\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u001e\u0010\u0018R\u0018\u0010\u000b\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u001f\u0010\u0018R$\u0010\f\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\r8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u0012\u0004\b \u0010\u0018R\u0018\u0010\u000e\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u0012\u0004\b!\u0010\u0018R\u0018\u0010\u000f\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u0012\u0004\b\"\u0010\u0018¨\u0006?"}, d2 = {"Lcom/larus/im/internal/jni/bean/OMNIAVChatConfig;", "Ljava/io/Serializable;", "Lcom/flow/kmp/common/SerializableIO;", "uid", "", "conversationId", FailedBinderCallBack.CALLER_ID, "localCallId", "botId", "lastSectionId", "lastMessageIndex", "lastMessageCursor", "extra", "", "projectId", "agentTaskParams", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;Ljava/lang/String;Ljava/lang/String;)V", "seen0", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;Ljava/lang/String;Ljava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getUid$annotations", "()V", "getConversationId$annotations", "getCallId$annotations", "getLocalCallId$annotations", "getBotId$annotations", "getLastSectionId$annotations", "getLastMessageIndex$annotations", "getLastMessageCursor$annotations", "getExtra$annotations", "getProjectId$annotations", "getAgentTaskParams$annotations", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "copy", "equals", "", "other", "", "hashCode", "toString", "write$Self", "", "self", BdpAppEventConstant.PARAMS_OUTPUT, "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$omnisdk_av_release", "$serializer", "Companion", "omnisdk-av_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
@Serializable
public final class OMNIAVChatConfig implements java.io.Serializable {
    private static final Lazy<d<Object>>[] $childSerializers = null;
    public static final Companion Companion = null;
    public final String agentTaskParams;
    public final String botId;
    public final String callId;
    public final String conversationId;
    public final Map<String, String> extra;
    public final String lastMessageCursor;
    public final String lastMessageIndex;
    public final String lastSectionId;
    public final String localCallId;
    public final String projectId;
    public final String uid;

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lcom/larus/im/internal/jni/bean/OMNIAVChatConfig$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/larus/im/internal/jni/bean/OMNIAVChatConfig;", "omnisdk-av_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }

        public final d<OMNIAVChatConfig> serializer() {
            return OMNIAVChatConfig$$serializer.INSTANCE;
        }
    }

    public OMNIAVChatConfig() {
        this(null, null, null, null, null, null, null, null, null, null, null, 2047, null);
    }

    private static final /* synthetic */ d _childSerializers$_anonymous_() {
        v2 r100 = v2.f520790a;
        return new a1(r100, r100);
    }

    public static /* synthetic */ d a() {
        return _childSerializers$_anonymous_();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ OMNIAVChatConfig copy$default(OMNIAVChatConfig r110, String r111, String r112, String r113, String r114, String r115, String r116, String r117, String r210, Map r211, String r212, String r213, int r214, Object r215) {
        if ((r214 & 1) == 0) goto L5;
        String r100 = r110.uid;
    L7:
        if ((r214 & 2) == 0) goto L9;
        String r101 = r110.conversationId;
    L11:
        if ((r214 & 4) == 0) goto L13;
        String r102 = r110.callId;
    L15:
        if ((r214 & 8) == 0) goto L17;
        String r103 = r110.localCallId;
    L19:
        if ((r214 & 16) == 0) goto L21;
        String r104 = r110.botId;
    L23:
        if ((r214 & 32) == 0) goto L25;
        String r105 = r110.lastSectionId;
    L27:
        if ((r214 & 64) == 0) goto L29;
        String r106 = r110.lastMessageIndex;
    L31:
        if ((r214 & 128) == 0) goto L33;
        String r107 = r110.lastMessageCursor;
    L35:
        if ((r214 & 256) == 0) goto L37;
        Map r118 = r110.extra;
    L39:
        if ((r214 & 512) == 0) goto L41;
        String r119 = r110.projectId;
    L43:
        if ((r214 & 1024) == 0) goto L45;
        String r108 = r110.agentTaskParams;
    L47:
        return r110.copy(r100, r101, r102, r103, r104, r105, r106, r107, r118, r119, r108);
    L45:
        r108 = r213;
        goto L47
    L41:
        r119 = r212;
        goto L43
    L37:
        r118 = r211;
        goto L39
    L33:
        r107 = r210;
        goto L35
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

    @SerialName("agent_task_params")
    public static /* synthetic */ void getAgentTaskParams$annotations() {
    }

    @SerialName("bot_id")
    public static /* synthetic */ void getBotId$annotations() {
    }

    @SerialName("call_id")
    public static /* synthetic */ void getCallId$annotations() {
    }

    @SerialName("conversation_id")
    public static /* synthetic */ void getConversationId$annotations() {
    }

    @SerialName("extra")
    public static /* synthetic */ void getExtra$annotations() {
    }

    @SerialName("last_message_cursor")
    public static /* synthetic */ void getLastMessageCursor$annotations() {
    }

    @SerialName("last_message_index")
    public static /* synthetic */ void getLastMessageIndex$annotations() {
    }

    @SerialName("last_section_id")
    public static /* synthetic */ void getLastSectionId$annotations() {
    }

    @SerialName("local_call_id")
    public static /* synthetic */ void getLocalCallId$annotations() {
    }

    @SerialName(AuthConstants.PARAM_KEY_LICENSE_PROJECT_ID)
    public static /* synthetic */ void getProjectId$annotations() {
    }

    @SerialName("uid")
    public static /* synthetic */ void getUid$annotations() {
    }

    public final String component1() {
        return this.uid;
    }

    public final String component10() {
        return this.projectId;
    }

    public final String component11() {
        return this.agentTaskParams;
    }

    public final String component2() {
        return this.conversationId;
    }

    public final String component3() {
        return this.callId;
    }

    public final String component4() {
        return this.localCallId;
    }

    public final String component5() {
        return this.botId;
    }

    public final String component6() {
        return this.lastSectionId;
    }

    public final String component7() {
        return this.lastMessageIndex;
    }

    public final String component8() {
        return this.lastMessageCursor;
    }

    public final Map<String, String> component9() {
        return this.extra;
    }

    public final OMNIAVChatConfig copy(String r110, String r111, String r112, String r113, String r114, String r115, String r210, String r211, Map<String, String> r212, String r213, String r214) {
        return new OMNIAVChatConfig(r110, r111, r112, r113, r114, r115, r210, r211, r212, r213, r214);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof OMNIAVChatConfig) == true) goto L8;
        return false;
    L8:
        OMNIAVChatConfig r101 = (OMNIAVChatConfig) r100;
        if (Intrinsics.areEqual(this.uid, r101.uid) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.conversationId, r101.conversationId) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.callId, r101.callId) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.localCallId, r101.localCallId) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.botId, r101.botId) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.lastSectionId, r101.lastSectionId) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.lastMessageIndex, r101.lastMessageIndex) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.lastMessageCursor, r101.lastMessageCursor) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.extra, r101.extra) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.projectId, r101.projectId) == true) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.agentTaskParams, r101.agentTaskParams) == true) goto L41;
        return false;
    L41:
        return true;
    }

    public int hashCode() {
        String r100 = this.uid;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.conversationId;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.callId;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        String r110 = this.localCallId;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        String r113 = this.botId;
        if (r113 != null) goto L21;
        int r114 = 0;
    L22:
        int r115 = (r112 + r114) * 31;
        String r116 = this.lastSectionId;
        if (r116 != null) goto L25;
        int r117 = 0;
    L26:
        int r118 = (r115 + r117) * 31;
        String r119 = this.lastMessageIndex;
        if (r119 != null) goto L29;
        int r120 = 0;
    L30:
        int r121 = (r118 + r120) * 31;
        String r122 = this.lastMessageCursor;
        if (r122 != null) goto L33;
        int r123 = 0;
    L34:
        int r124 = (r121 + r123) * 31;
        Map<String, String> r125 = this.extra;
        if (r125 != null) goto L37;
        int r126 = 0;
    L38:
        int r127 = (r124 + r126) * 31;
        String r128 = this.projectId;
        if (r128 != null) goto L41;
        int r129 = 0;
    L42:
        int r130 = (r127 + r129) * 31;
        String r131 = this.agentTaskParams;
        if (r131 == null) goto L47;
        r101 = r131.hashCode();
    L47:
        return r130 + r101;
    L41:
        r129 = r128.hashCode();
        goto L42
    L37:
        r126 = r125.hashCode();
        goto L38
    L33:
        r123 = r122.hashCode();
        goto L34
    L29:
        r120 = r119.hashCode();
        goto L30
    L25:
        r117 = r116.hashCode();
        goto L26
    L21:
        r114 = r113.hashCode();
        goto L22
    L17:
        r111 = r110.hashCode();
        goto L18
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
        return "OMNIAVChatConfig(uid=" + this.uid + ", conversationId=" + this.conversationId + ", callId=" + this.callId + ", localCallId=" + this.localCallId + ", botId=" + this.botId + ", lastSectionId=" + this.lastSectionId + ", lastMessageIndex=" + this.lastMessageIndex + ", lastMessageCursor=" + this.lastMessageCursor + ", extra=" + this.extra + ", projectId=" + this.projectId + ", agentTaskParams=" + this.agentTaskParams + ')';
    }

    static {
        Companion = new Companion(null);
        $childSerializers = new Lazy[]{null, null, null, null, null, null, null, null, LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new h0()), null, null};
    }

    public static final /* synthetic */ Lazy[] access$get$childSerializers$cp() {
        return $childSerializers;
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$omnisdk_av_release(OMNIAVChatConfig r100, muc.d r101, f r102) {
        Lazy<d<Object>>[] r103 = $childSerializers;
        boolean r104 = false;
        if (r101.shouldEncodeElementDefault(r102, 0) == false) goto L6;
    L4:
        boolean r105 = true;
    L9:
        if (r105 == false) goto L12;
        r101.encodeNullableSerializableElement(r102, 0, v2.f520790a, r100.uid);
    L12:
        if (r101.shouldEncodeElementDefault(r102, 1) == false) goto L15;
    L13:
        boolean r106 = true;
    L18:
        if (r106 == false) goto L21;
        r101.encodeNullableSerializableElement(r102, 1, v2.f520790a, r100.conversationId);
    L21:
        if (r101.shouldEncodeElementDefault(r102, 2) == false) goto L24;
    L22:
        boolean r107 = true;
    L27:
        if (r107 == false) goto L30;
        r101.encodeNullableSerializableElement(r102, 2, v2.f520790a, r100.callId);
    L30:
        if (r101.shouldEncodeElementDefault(r102, 3) == false) goto L33;
    L31:
        boolean r108 = true;
    L36:
        if (r108 == false) goto L39;
        r101.encodeNullableSerializableElement(r102, 3, v2.f520790a, r100.localCallId);
    L39:
        if (r101.shouldEncodeElementDefault(r102, 4) == false) goto L42;
    L40:
        boolean r109 = true;
    L45:
        if (r109 == false) goto L48;
        r101.encodeNullableSerializableElement(r102, 4, v2.f520790a, r100.botId);
    L48:
        if (r101.shouldEncodeElementDefault(r102, 5) == false) goto L51;
    L49:
        boolean r110 = true;
    L54:
        if (r110 == false) goto L57;
        r101.encodeNullableSerializableElement(r102, 5, v2.f520790a, r100.lastSectionId);
    L57:
        if (r101.shouldEncodeElementDefault(r102, 6) == false) goto L60;
    L58:
        boolean r111 = true;
    L63:
        if (r111 == false) goto L66;
        r101.encodeNullableSerializableElement(r102, 6, v2.f520790a, r100.lastMessageIndex);
    L66:
        if (r101.shouldEncodeElementDefault(r102, 7) == false) goto L69;
    L67:
        boolean r112 = true;
    L72:
        if (r112 == false) goto L75;
        r101.encodeNullableSerializableElement(r102, 7, v2.f520790a, r100.lastMessageCursor);
    L75:
        if (r101.shouldEncodeElementDefault(r102, 8) == false) goto L78;
    L76:
        boolean r113 = true;
    L81:
        if (r113 == false) goto L84;
        r101.encodeNullableSerializableElement(r102, 8, r103[8].getValue(), r100.extra);
    L84:
        if (r101.shouldEncodeElementDefault(r102, 9) == false) goto L87;
    L85:
        boolean r114 = true;
    L90:
        if (r114 == false) goto L93;
        r101.encodeNullableSerializableElement(r102, 9, v2.f520790a, r100.projectId);
    L93:
        if (r101.shouldEncodeElementDefault(r102, 10) == false) goto L96;
    L94:
        r104 = true;
    L98:
        if (r104 == false) goto L101;
        r101.encodeNullableSerializableElement(r102, 10, v2.f520790a, r100.agentTaskParams);
        return;
    L101:
        return;
    L96:
        if (r100.agentTaskParams == null) goto L98;
    L87:
        if (r100.projectId != null) goto L85;
        r114 = false;
        goto L90
    L78:
        if (r100.extra != null) goto L76;
        r113 = false;
        goto L81
    L69:
        if (r100.lastMessageCursor != null) goto L67;
        r112 = false;
        goto L72
    L60:
        if (r100.lastMessageIndex != null) goto L58;
        r111 = false;
        goto L63
    L51:
        if (r100.lastSectionId != null) goto L49;
        r110 = false;
        goto L54
    L42:
        if (r100.botId != null) goto L40;
        r109 = false;
        goto L45
    L33:
        if (r100.localCallId != null) goto L31;
        r108 = false;
        goto L36
    L24:
        if (r100.callId != null) goto L22;
        r107 = false;
        goto L27
    L15:
        if (r100.conversationId != null) goto L13;
        r106 = false;
        goto L18
    L6:
        if (r100.uid != null) goto L4;
        r105 = false;
        goto L9
    }

    public OMNIAVChatConfig(String r100, String r101, String r102, String r103, String r104, String r105, String r106, String r107, Map<String, String> r108, String r110, String r111) {
        this.uid = r100;
        this.conversationId = r101;
        this.callId = r102;
        this.localCallId = r103;
        this.botId = r104;
        this.lastSectionId = r105;
        this.lastMessageIndex = r106;
        this.lastMessageCursor = r107;
        this.extra = r108;
        this.projectId = r110;
        this.agentTaskParams = r111;
    }

    public /* synthetic */ OMNIAVChatConfig(int r100, String r101, String r102, String r103, String r104, String r105, String r106, String r107, String r110, Map r111, String r112, String r113, q2 r114) {
        if ((r100 & 0) == 0) goto L5;
        b2.b(r100, 0, OMNIAVChatConfig$$serializer.INSTANCE.getDescriptor());
        throw null;
    L5:
        if ((r100 & 1) != 0) goto L7;
        this.uid = null;
    L9:
        if ((r100 & 2) != 0) goto L11;
        this.conversationId = null;
    L13:
        if ((r100 & 4) != 0) goto L15;
        this.callId = null;
    L17:
        if ((r100 & 8) != 0) goto L19;
        this.localCallId = null;
    L21:
        if ((r100 & 16) != 0) goto L23;
        this.botId = null;
    L25:
        if ((r100 & 32) != 0) goto L27;
        this.lastSectionId = null;
    L29:
        if ((r100 & 64) != 0) goto L31;
        this.lastMessageIndex = null;
    L33:
        if ((r100 & 128) != 0) goto L35;
        this.lastMessageCursor = null;
    L37:
        if ((r100 & 256) != 0) goto L39;
        this.extra = null;
    L41:
        if ((r100 & 512) != 0) goto L43;
        this.projectId = null;
    L45:
        if ((r100 & 1024) != 0) goto L47;
        this.agentTaskParams = null;
        return;
    L47:
        this.agentTaskParams = r113;
        return;
    L43:
        this.projectId = r112;
        goto L45
    L39:
        this.extra = r111;
        goto L41
    L35:
        this.lastMessageCursor = r110;
        goto L37
    L31:
        this.lastMessageIndex = r107;
        goto L33
    L27:
        this.lastSectionId = r106;
        goto L29
    L23:
        this.botId = r105;
        goto L25
    L19:
        this.localCallId = r104;
        goto L21
    L15:
        this.callId = r103;
        goto L17
    L11:
        this.conversationId = r102;
        goto L13
    L7:
        this.uid = r101;
        goto L9
    }

    public /* synthetic */ OMNIAVChatConfig(String r110, String r111, String r112, String r113, String r114, String r115, String r116, String r210, Map r211, String r212, String r213, int r214, DefaultConstructorMarker r215) {
        String r100 = null;
        if ((r214 & 1) == 0) goto L5;
        String r101 = null;
    L7:
        if ((r214 & 2) == 0) goto L9;
        String r102 = null;
    L11:
        if ((r214 & 4) == 0) goto L13;
        String r103 = null;
    L15:
        if ((r214 & 8) == 0) goto L17;
        String r104 = null;
    L19:
        if ((r214 & 16) == 0) goto L21;
        String r105 = null;
    L23:
        if ((r214 & 32) == 0) goto L25;
        String r106 = null;
    L27:
        if ((r214 & 64) == 0) goto L29;
        String r107 = null;
    L31:
        if ((r214 & 128) == 0) goto L33;
        String r108 = null;
    L35:
        if ((r214 & 256) == 0) goto L37;
        Map r117 = null;
    L39:
        if ((r214 & 512) == 0) goto L41;
        String r118 = null;
    L43:
        if ((r214 & 1024) != 0) goto L46;
        r100 = r213;
    L46:
        this(r101, r102, r103, r104, r105, r106, r107, r108, r117, r118, r100);
        return;
    L41:
        r118 = r212;
        goto L43
    L37:
        r117 = r211;
        goto L39
    L33:
        r108 = r210;
        goto L35
    L29:
        r107 = r116;
        goto L31
    L25:
        r106 = r115;
        goto L27
    L21:
        r105 = r114;
        goto L23
    L17:
        r104 = r113;
        goto L19
    L13:
        r103 = r112;
        goto L15
    L9:
        r102 = r111;
        goto L11
    L5:
        r101 = r110;
        goto L7
    }
}
