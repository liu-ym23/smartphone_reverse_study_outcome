package com.larus.im.internal.jni.bean;

import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import de9.r;
import de9.s;
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
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001b\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0081\b\u0018\u0000 :2\u00060\u0001j\u0002`\u0002:\u00029:BK\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\t\u001a\u00020\n\u0012\u0014\u0010\u000b\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u00010\f¢\u0006\u0004\b\r\u0010\u000eBa\b\u0010\u0012\u0006\u0010\u000f\u001a\u00020\u0010\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n\u0012\u0014\u0010\u000b\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u00010\f\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012¢\u0006\u0004\b\r\u0010\u0013J\t\u0010%\u001a\u00020\u0004HÆ\u0003J\t\u0010&\u001a\u00020\u0006HÆ\u0003J\u000b\u0010'\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010(\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\t\u0010)\u001a\u00020\nHÆ\u0003J\u0017\u0010*\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u00010\fHÆ\u0003JW\u0010+\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00062\b\b\u0002\u0010\t\u001a\u00020\n2\u0016\b\u0002\u0010\u000b\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u00010\fHÆ\u0001J\u0013\u0010,\u001a\u00020\u00042\b\u0010-\u001a\u0004\u0018\u00010.HÖ\u0003J\t\u0010/\u001a\u00020\u0010HÖ\u0001J\t\u00100\u001a\u00020\u0006HÖ\u0001J%\u00101\u001a\u0002022\u0006\u00103\u001a\u00020\u00002\u0006\u00104\u001a\u0002052\u0006\u00106\u001a\u000207H\u0001¢\u0006\u0002\b8R\u001c\u0010\u0003\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u001c\u0010\u0005\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0018\u0010\u0015\u001a\u0004\b\u0019\u0010\u001aR\u001e\u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u001b\u0010\u0015\u001a\u0004\b\u001c\u0010\u001aR\u001e\u0010\b\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u001d\u0010\u0015\u001a\u0004\b\u001e\u0010\u001aR\u001c\u0010\t\u001a\u00020\n8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u001f\u0010\u0015\u001a\u0004\b \u0010!R*\u0010\u000b\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u00010\f8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\"\u0010\u0015\u001a\u0004\b#\u0010$¨\u0006;"}, d2 = {"Lcom/larus/im/internal/jni/bean/NativeMessageInterruptRequest;", "Ljava/io/Serializable;", "Lcom/flow/kmp/common/SerializableIO;", "interruptServer", "", "conversationId", "", "lastSendMsgId", "lastSendMsgLocalId", "breakReason", "Lcom/larus/im/internal/jni/bean/OmniBreakReason;", "modifyAnswerMap", "", "<init>", "(ZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/larus/im/internal/jni/bean/OmniBreakReason;Ljava/util/Map;)V", "seen0", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(IZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/larus/im/internal/jni/bean/OmniBreakReason;Ljava/util/Map;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getInterruptServer$annotations", "()V", "getInterruptServer", "()Z", "getConversationId$annotations", "getConversationId", "()Ljava/lang/String;", "getLastSendMsgId$annotations", "getLastSendMsgId", "getLastSendMsgLocalId$annotations", "getLastSendMsgLocalId", "getBreakReason$annotations", "getBreakReason", "()Lcom/larus/im/internal/jni/bean/OmniBreakReason;", "getModifyAnswerMap$annotations", "getModifyAnswerMap", "()Ljava/util/Map;", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "other", "", "hashCode", "toString", "write$Self", "", "self", BdpAppEventConstant.PARAMS_OUTPUT, "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$omnisdk_release", "$serializer", "Companion", "omnisdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
@Serializable
public final class NativeMessageInterruptRequest implements java.io.Serializable {
    private static final Lazy<d<Object>>[] $childSerializers = null;
    public static final Companion Companion = null;
    private final OmniBreakReason breakReason;
    private final String conversationId;
    private final boolean interruptServer;
    private final String lastSendMsgId;
    private final String lastSendMsgLocalId;
    private final Map<String, String> modifyAnswerMap;

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lcom/larus/im/internal/jni/bean/NativeMessageInterruptRequest$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/larus/im/internal/jni/bean/NativeMessageInterruptRequest;", "omnisdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }

        public final d<NativeMessageInterruptRequest> serializer() {
            return NativeMessageInterruptRequest$$serializer.INSTANCE;
        }
    }

    private static final /* synthetic */ d _childSerializers$_anonymous_() {
        return OmniBreakReason.Companion.serializer();
    }

    private static final /* synthetic */ d _childSerializers$_anonymous_$0() {
        v2 r100 = v2.f520790a;
        return new a1(r100, r100);
    }

    public static /* synthetic */ d a() {
        return _childSerializers$_anonymous_$0();
    }

    public static /* synthetic */ d b() {
        return _childSerializers$_anonymous_();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ NativeMessageInterruptRequest copy$default(NativeMessageInterruptRequest r100, boolean r101, String r102, String r103, String r104, OmniBreakReason r105, Map r110, int r111, Object r112) {
        if ((r111 & 1) == 0) goto L6;
        r101 = r100.interruptServer;
    L6:
        if ((r111 & 2) == 0) goto L8;
        r102 = r100.conversationId;
    L8:
        String r113 = r102;
        if ((r111 & 4) == 0) goto L11;
        r103 = r100.lastSendMsgId;
    L11:
        String r106 = r103;
        if ((r111 & 8) == 0) goto L14;
        r104 = r100.lastSendMsgLocalId;
    L14:
        String r107 = r104;
        if ((r111 & 16) == 0) goto L17;
        r105 = r100.breakReason;
    L17:
        OmniBreakReason r108 = r105;
        if ((r111 & 32) == 0) goto L20;
        r110 = r100.modifyAnswerMap;
    L20:
        boolean r109 = r101;
        return r100.copy(r109, r113, r106, r107, r108, r110);
    }

    @SerialName("break_reason")
    public static /* synthetic */ void getBreakReason$annotations() {
    }

    @SerialName("conversation_id")
    public static /* synthetic */ void getConversationId$annotations() {
    }

    @SerialName("interrupt_server")
    public static /* synthetic */ void getInterruptServer$annotations() {
    }

    @SerialName("last_send_msg_id")
    public static /* synthetic */ void getLastSendMsgId$annotations() {
    }

    @SerialName("last_send_msg_local_id")
    public static /* synthetic */ void getLastSendMsgLocalId$annotations() {
    }

    @SerialName("modify_answer_map")
    public static /* synthetic */ void getModifyAnswerMap$annotations() {
    }

    public final boolean component1() {
        return this.interruptServer;
    }

    public final String component2() {
        return this.conversationId;
    }

    public final String component3() {
        return this.lastSendMsgId;
    }

    public final String component4() {
        return this.lastSendMsgLocalId;
    }

    public final OmniBreakReason component5() {
        return this.breakReason;
    }

    public final Map<String, String> component6() {
        return this.modifyAnswerMap;
    }

    public final NativeMessageInterruptRequest copy(boolean r100, String r110, String r111, String r112, OmniBreakReason r113, Map<String, String> r114) {
        Intrinsics.checkNotNullParameter(r110, "conversationId");
        Intrinsics.checkNotNullParameter(r113, "breakReason");
        return new NativeMessageInterruptRequest(r100, r110, r111, r112, r113, r114);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof NativeMessageInterruptRequest) == true) goto L8;
        return false;
    L8:
        NativeMessageInterruptRequest r101 = (NativeMessageInterruptRequest) r100;
        if (this.interruptServer == r101.interruptServer) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.conversationId, r101.conversationId) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.lastSendMsgId, r101.lastSendMsgId) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.lastSendMsgLocalId, r101.lastSendMsgLocalId) == true) goto L21;
        return false;
    L21:
        if (this.breakReason == r101.breakReason) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.modifyAnswerMap, r101.modifyAnswerMap) == true) goto L26;
        return false;
    L26:
        return true;
    }

    public int hashCode() {
        if (this.interruptServer == false) goto L5;
        int r100 = 1231;
    L6:
        int r101 = ((r100 * 31) + this.conversationId.hashCode()) * 31;
        String r102 = this.lastSendMsgId;
        int r103 = 0;
        if (r102 != null) goto L9;
        int r104 = 0;
    L10:
        int r105 = (r101 + r104) * 31;
        String r106 = this.lastSendMsgLocalId;
        if (r106 != null) goto L13;
        int r107 = 0;
    L14:
        int r108 = (((r105 + r107) * 31) + this.breakReason.hashCode()) * 31;
        Map<String, String> r109 = this.modifyAnswerMap;
        if (r109 == null) goto L19;
        r103 = r109.hashCode();
    L19:
        return r108 + r103;
    L13:
        r107 = r106.hashCode();
        goto L14
    L9:
        r104 = r102.hashCode();
        goto L10
    L5:
        r100 = 1237;
        goto L6
    }

    public String toString() {
        return "NativeMessageInterruptRequest(interruptServer=" + this.interruptServer + ", conversationId=" + this.conversationId + ", lastSendMsgId=" + this.lastSendMsgId + ", lastSendMsgLocalId=" + this.lastSendMsgLocalId + ", breakReason=" + this.breakReason + ", modifyAnswerMap=" + this.modifyAnswerMap + ')';
    }

    static {
        Companion = new Companion(null);
        LazyThreadSafetyMode r100 = LazyThreadSafetyMode.PUBLICATION;
        $childSerializers = new Lazy[]{null, null, null, null, LazyKt.lazy(r100, new r()), LazyKt.lazy(r100, new s())};
    }

    public static final /* synthetic */ Lazy[] access$get$childSerializers$cp() {
        return $childSerializers;
    }

    public final OmniBreakReason getBreakReason() {
        return this.breakReason;
    }

    public final String getConversationId() {
        return this.conversationId;
    }

    public final boolean getInterruptServer() {
        return this.interruptServer;
    }

    public final String getLastSendMsgId() {
        return this.lastSendMsgId;
    }

    public final String getLastSendMsgLocalId() {
        return this.lastSendMsgLocalId;
    }

    public final Map<String, String> getModifyAnswerMap() {
        return this.modifyAnswerMap;
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$omnisdk_release(NativeMessageInterruptRequest r100, muc.d r101, f r102) {
        Lazy<d<Object>>[] r103 = $childSerializers;
        boolean r104 = false;
        r101.encodeBooleanElement(r102, 0, r100.interruptServer);
        r101.encodeStringElement(r102, 1, r100.conversationId);
        v2 r105 = v2.f520790a;
        r101.encodeNullableSerializableElement(r102, 2, r105, r100.lastSendMsgId);
        r101.encodeNullableSerializableElement(r102, 3, r105, r100.lastSendMsgLocalId);
        if (r101.shouldEncodeElementDefault(r102, 4) == false) goto L6;
    L4:
        r104 = true;
    L8:
        if (r104 == false) goto L10;
        r101.encodeSerializableElement(r102, 4, r103[4].getValue(), r100.breakReason);
    L10:
        r101.encodeNullableSerializableElement(r102, 5, r103[5].getValue(), r100.modifyAnswerMap);
        return;
    L6:
        if (r100.breakReason == OmniBreakReason.OmniBreakReason_OTHER) goto L8;
        goto L8
    }

    public NativeMessageInterruptRequest(boolean r100, String r101, String r102, String r103, OmniBreakReason r104, Map<String, String> r105) {
        Intrinsics.checkNotNullParameter(r101, "conversationId");
        Intrinsics.checkNotNullParameter(r104, "breakReason");
        this.interruptServer = r100;
        this.conversationId = r101;
        this.lastSendMsgId = r102;
        this.lastSendMsgLocalId = r103;
        this.breakReason = r104;
        this.modifyAnswerMap = r105;
    }

    public /* synthetic */ NativeMessageInterruptRequest(int r100, boolean r101, String r102, String r103, String r104, OmniBreakReason r105, Map r106, q2 r107) {
        if (47 != (r100 & 47)) goto L10;
        this.interruptServer = r101;
        this.conversationId = r102;
        this.lastSendMsgId = r103;
        this.lastSendMsgLocalId = r104;
        if ((r100 & 16) != 0) goto L7;
        this.breakReason = OmniBreakReason.OmniBreakReason_OTHER;
    L8:
        this.modifyAnswerMap = r106;
        return;
    L7:
        this.breakReason = r105;
        goto L8
    L10:
        b2.b(r100, 47, NativeMessageInterruptRequest$$serializer.INSTANCE.getDescriptor());
        throw null;
    }

    public /* synthetic */ NativeMessageInterruptRequest(boolean r100, String r101, String r110, String r111, OmniBreakReason r112, Map r113, int r114, DefaultConstructorMarker r115) {
        if ((r114 & 16) == 0) goto L5;
        r112 = OmniBreakReason.OmniBreakReason_OTHER;
    L5:
        this(r100, r101, r110, r111, r112, r113);
    }
}
