package com.larus.im.internal.jni.bean;

import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import de9.y4;
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
import nuc.b2;
import nuc.q2;
import nuc.v2;

/* JADX INFO: loaded from: classes29.dex */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 -2\u00060\u0001j\u0002`\u0002:\u0002,-B?\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u000b\u0010\fBK\b\u0010\u0012\u0006\u0010\r\u001a\u00020\u000e\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010¢\u0006\u0004\b\u000b\u0010\u0011J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0007HÆ\u0003J\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\t\u0010\u001c\u001a\u00020\nHÆ\u0003JA\u0010\u001d\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00042\b\b\u0002\u0010\t\u001a\u00020\nHÆ\u0001J\u0013\u0010\u001e\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010!HÖ\u0003J\t\u0010\"\u001a\u00020\u000eHÖ\u0001J\t\u0010#\u001a\u00020\u0004HÖ\u0001J%\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020\u00002\u0006\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020*H\u0001¢\u0006\u0002\b+R\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u0012\u0010\u0013R\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u0014\u0010\u0013R\u0016\u0010\u0006\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u0015\u0010\u0013R\u0018\u0010\b\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u0016\u0010\u0013R\u0016\u0010\t\u001a\u00020\n8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u0017\u0010\u0013¨\u0006."}, d2 = {"Lcom/larus/im/internal/jni/bean/OmniChangeRegenMessageRequest;", "Ljava/io/Serializable;", "Lcom/flow/kmp/common/SerializableIO;", "conversationId", "", "regenRootId", "currentRegenIndex", "", "currentMessageId", "direction", "Lcom/larus/im/internal/jni/bean/OmniChangeRegenMessageDirection;", "<init>", "(Ljava/lang/String;Ljava/lang/String;JLjava/lang/String;Lcom/larus/im/internal/jni/bean/OmniChangeRegenMessageDirection;)V", "seen0", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Ljava/lang/String;JLjava/lang/String;Lcom/larus/im/internal/jni/bean/OmniChangeRegenMessageDirection;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getConversationId$annotations", "()V", "getRegenRootId$annotations", "getCurrentRegenIndex$annotations", "getCurrentMessageId$annotations", "getDirection$annotations", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "", "hashCode", "toString", "write$Self", "", "self", BdpAppEventConstant.PARAMS_OUTPUT, "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$omnisdk_release", "$serializer", "Companion", "omnisdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
@Serializable
public final class OmniChangeRegenMessageRequest implements java.io.Serializable {
    private static final Lazy<d<Object>>[] $childSerializers = null;
    public static final Companion Companion = null;
    public final String conversationId;
    public final String currentMessageId;
    public final long currentRegenIndex;
    public final OmniChangeRegenMessageDirection direction;
    public final String regenRootId;

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lcom/larus/im/internal/jni/bean/OmniChangeRegenMessageRequest$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/larus/im/internal/jni/bean/OmniChangeRegenMessageRequest;", "omnisdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }

        public final d<OmniChangeRegenMessageRequest> serializer() {
            return OmniChangeRegenMessageRequest$$serializer.INSTANCE;
        }
    }

    public OmniChangeRegenMessageRequest() {
        this(null, null, 0, null, null, 31, null);
    }

    private static final /* synthetic */ d _childSerializers$_anonymous_() {
        return OmniChangeRegenMessageDirection.Companion.serializer();
    }

    public static /* synthetic */ d a() {
        return _childSerializers$_anonymous_();
    }

    public static /* synthetic */ OmniChangeRegenMessageRequest copy$default(OmniChangeRegenMessageRequest r100, String r101, String r102, long r103, String r104, OmniChangeRegenMessageDirection r110, int r111, Object r112) {
        if ((r111 & 1) == 0) goto L6;
        r101 = r100.conversationId;
    L6:
        if ((r111 & 2) == 0) goto L8;
        r102 = r100.regenRootId;
    L8:
        String r113 = r102;
        if ((r111 & 4) == 0) goto L11;
        r103 = r100.currentRegenIndex;
    L11:
        long r105 = r103;
        if ((r111 & 8) == 0) goto L14;
        r104 = r100.currentMessageId;
    L14:
        String r106 = r104;
        if ((r111 & 16) == 0) goto L17;
        r110 = r100.direction;
    L17:
        String r107 = r101;
        return r100.copy(r107, r113, r105, r106, r110);
    }

    @SerialName("conversation_id")
    public static /* synthetic */ void getConversationId$annotations() {
    }

    @SerialName("current_message_id")
    public static /* synthetic */ void getCurrentMessageId$annotations() {
    }

    @SerialName("current_regen_index")
    public static /* synthetic */ void getCurrentRegenIndex$annotations() {
    }

    @SerialName("direction")
    public static /* synthetic */ void getDirection$annotations() {
    }

    @SerialName("regen_root_id")
    public static /* synthetic */ void getRegenRootId$annotations() {
    }

    public final String component1() {
        return this.conversationId;
    }

    public final String component2() {
        return this.regenRootId;
    }

    public final long component3() {
        return this.currentRegenIndex;
    }

    public final String component4() {
        return this.currentMessageId;
    }

    public final OmniChangeRegenMessageDirection component5() {
        return this.direction;
    }

    public final OmniChangeRegenMessageRequest copy(String r100, String r110, long r111, String r112, OmniChangeRegenMessageDirection r113) {
        Intrinsics.checkNotNullParameter(r113, "direction");
        return new OmniChangeRegenMessageRequest(r100, r110, r111, r112, r113);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof OmniChangeRegenMessageRequest) == true) goto L8;
        return false;
    L8:
        OmniChangeRegenMessageRequest r101 = (OmniChangeRegenMessageRequest) r100;
        if (Intrinsics.areEqual(this.conversationId, r101.conversationId) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.regenRootId, r101.regenRootId) == true) goto L15;
        return false;
    L15:
        if (this.currentRegenIndex == r101.currentRegenIndex) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.currentMessageId, r101.currentMessageId) == true) goto L21;
        return false;
    L21:
        if (this.direction == r101.direction) goto L23;
        return false;
    L23:
        return true;
    }

    public int hashCode() {
        String r100 = this.conversationId;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.regenRootId;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        long r107 = this.currentRegenIndex;
        int r108 = (r106 + ((int) (r107 ^ (r107 >>> 32)))) * 31;
        String r109 = this.currentMessageId;
        if (r109 == null) goto L15;
        r101 = r109.hashCode();
    L15:
        return ((r108 + r101) * 31) + this.direction.hashCode();
    L9:
        r105 = r104.hashCode();
        goto L10
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public String toString() {
        return "OmniChangeRegenMessageRequest(conversationId=" + this.conversationId + ", regenRootId=" + this.regenRootId + ", currentRegenIndex=" + this.currentRegenIndex + ", currentMessageId=" + this.currentMessageId + ", direction=" + this.direction + ')';
    }

    static {
        Companion = new Companion(null);
        $childSerializers = new Lazy[]{null, null, null, null, LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new y4())};
    }

    public static final /* synthetic */ Lazy[] access$get$childSerializers$cp() {
        return $childSerializers;
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$omnisdk_release(OmniChangeRegenMessageRequest r100, muc.d r110, f r111) {
        Lazy<d<Object>>[] r101 = $childSerializers;
        boolean r102 = false;
        if (r110.shouldEncodeElementDefault(r111, 0) == false) goto L6;
    L4:
        boolean r103 = true;
    L9:
        if (r103 == false) goto L12;
        r110.encodeNullableSerializableElement(r111, 0, v2.f520790a, r100.conversationId);
    L12:
        if (r110.shouldEncodeElementDefault(r111, 1) == false) goto L15;
    L13:
        boolean r104 = true;
    L18:
        if (r104 == false) goto L21;
        r110.encodeNullableSerializableElement(r111, 1, v2.f520790a, r100.regenRootId);
    L21:
        if (r110.shouldEncodeElementDefault(r111, 2) == false) goto L24;
    L22:
        boolean r105 = true;
    L27:
        if (r105 == false) goto L30;
        r110.encodeLongElement(r111, 2, r100.currentRegenIndex);
    L30:
        if (r110.shouldEncodeElementDefault(r111, 3) == false) goto L33;
    L31:
        boolean r106 = true;
    L36:
        if (r106 == false) goto L39;
        r110.encodeNullableSerializableElement(r111, 3, v2.f520790a, r100.currentMessageId);
    L39:
        if (r110.shouldEncodeElementDefault(r111, 4) == false) goto L42;
    L40:
        r102 = true;
    L44:
        if (r102 == false) goto L47;
        r110.encodeSerializableElement(r111, 4, r101[4].getValue(), r100.direction);
        return;
    L47:
        return;
    L42:
        if (r100.direction == OmniChangeRegenMessageDirection.OmniChangeRegenMessageDirection_PREVIOUS) goto L44;
    L33:
        if (r100.currentMessageId != null) goto L31;
        r106 = false;
        goto L36
    L24:
        if (r100.currentRegenIndex != 0) goto L22;
        r105 = false;
        goto L27
    L15:
        if (r100.regenRootId != null) goto L13;
        r104 = false;
        goto L18
    L6:
        if (r100.conversationId != null) goto L4;
        r103 = false;
        goto L9
    }

    public OmniChangeRegenMessageRequest(String r100, String r101, long r102, String r103, OmniChangeRegenMessageDirection r104) {
        Intrinsics.checkNotNullParameter(r104, "direction");
        this.conversationId = r100;
        this.regenRootId = r101;
        this.currentRegenIndex = r102;
        this.currentMessageId = r103;
        this.direction = r104;
    }

    public /* synthetic */ OmniChangeRegenMessageRequest(int r100, String r101, String r102, long r103, String r104, OmniChangeRegenMessageDirection r105, q2 r106) {
        if ((r100 & 0) == 0) goto L5;
        b2.b(r100, 0, OmniChangeRegenMessageRequest$$serializer.INSTANCE.getDescriptor());
        throw null;
    L5:
        if ((r100 & 1) != 0) goto L7;
        this.conversationId = null;
    L9:
        if ((r100 & 2) != 0) goto L11;
        this.regenRootId = null;
    L13:
        if ((r100 & 4) != 0) goto L15;
        this.currentRegenIndex = 0;
    L17:
        if ((r100 & 8) != 0) goto L19;
        this.currentMessageId = null;
    L21:
        if ((r100 & 16) != 0) goto L23;
        this.direction = OmniChangeRegenMessageDirection.OmniChangeRegenMessageDirection_PREVIOUS;
        return;
    L23:
        this.direction = r105;
        return;
    L19:
        this.currentMessageId = r104;
        goto L21
    L15:
        this.currentRegenIndex = r103;
        goto L17
    L11:
        this.regenRootId = r102;
        goto L13
    L7:
        this.conversationId = r101;
        goto L9
    }

    public /* synthetic */ OmniChangeRegenMessageRequest(String r100, String r101, long r102, String r103, OmniChangeRegenMessageDirection r110, int r111, DefaultConstructorMarker r112) {
        String r104 = null;
        if ((r111 & 1) == 0) goto L5;
        String r113 = null;
    L7:
        if ((r111 & 2) == 0) goto L9;
        String r105 = null;
    L11:
        if ((r111 & 4) == 0) goto L13;
        r102 = 0;
    L13:
        long r106 = r102;
        if ((r111 & 8) != 0) goto L18;
        r104 = r103;
    L18:
        if ((r111 & 16) == 0) goto L20;
        r110 = OmniChangeRegenMessageDirection.OmniChangeRegenMessageDirection_PREVIOUS;
    L20:
        this(r113, r105, r106, r104, r110);
        return;
    L9:
        r105 = r101;
        goto L11
    L5:
        r113 = r100;
        goto L7
    }
}
