package com.larus.im.internal.jni.bean;

import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import de9.u9;
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
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 )2\u00060\u0001j\u0002`\u0002:\u0002()B1\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u000b\u0010\fB?\b\u0010\u0012\u0006\u0010\r\u001a\u00020\b\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f¢\u0006\u0004\b\u000b\u0010\u0010J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0018\u001a\u00020\bHÆ\u0003J\t\u0010\u0019\u001a\u00020\nHÆ\u0003J3\u0010\u001a\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\nHÆ\u0001J\u0013\u0010\u001b\u001a\u00020\n2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dHÖ\u0003J\t\u0010\u001e\u001a\u00020\bHÖ\u0001J\t\u0010\u001f\u001a\u00020\u0004HÖ\u0001J%\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020\u00002\u0006\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020&H\u0001¢\u0006\u0002\b'R\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0005\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u0013\u0010\u0012R\u0016\u0010\u0007\u001a\u00020\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u0014\u0010\u0012R\u0016\u0010\t\u001a\u00020\n8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u0015\u0010\u0012¨\u0006*"}, d2 = {"Lcom/larus/im/internal/jni/bean/OmniPinConversationRequest;", "Ljava/io/Serializable;", "Lcom/flow/kmp/common/SerializableIO;", "conversationId", "", "conversationType", "Lcom/larus/im/internal/jni/bean/OmniConversationType;", "cellType", "", "ifPin", "", "<init>", "(Ljava/lang/String;Lcom/larus/im/internal/jni/bean/OmniConversationType;IZ)V", "seen0", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Lcom/larus/im/internal/jni/bean/OmniConversationType;IZLkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getConversationId$annotations", "()V", "getConversationType$annotations", "getCellType$annotations", "getIfPin$annotations", "component1", "component2", "component3", "component4", "copy", "equals", "other", "", "hashCode", "toString", "write$Self", "", "self", BdpAppEventConstant.PARAMS_OUTPUT, "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$omnisdk_release", "$serializer", "Companion", "omnisdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
@Serializable
public final class OmniPinConversationRequest implements java.io.Serializable {
    private static final Lazy<d<Object>>[] $childSerializers = null;
    public static final Companion Companion = null;
    public final int cellType;
    public final String conversationId;
    public final OmniConversationType conversationType;
    public final boolean ifPin;

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lcom/larus/im/internal/jni/bean/OmniPinConversationRequest$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/larus/im/internal/jni/bean/OmniPinConversationRequest;", "omnisdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }

        public final d<OmniPinConversationRequest> serializer() {
            return OmniPinConversationRequest$$serializer.INSTANCE;
        }
    }

    public OmniPinConversationRequest() {
        this(null, null, 0, false, 15, null);
    }

    private static final /* synthetic */ d _childSerializers$_anonymous_() {
        return OmniConversationType.Companion.serializer();
    }

    public static /* synthetic */ d a() {
        return _childSerializers$_anonymous_();
    }

    public static /* synthetic */ OmniPinConversationRequest copy$default(OmniPinConversationRequest r100, String r101, OmniConversationType r102, int r103, boolean r104, int r105, Object r106) {
        if ((r105 & 1) == 0) goto L6;
        r101 = r100.conversationId;
    L6:
        if ((r105 & 2) == 0) goto L9;
        r102 = r100.conversationType;
    L9:
        if ((r105 & 4) == 0) goto L12;
        r103 = r100.cellType;
    L12:
        if ((r105 & 8) == 0) goto L15;
        r104 = r100.ifPin;
    L15:
        return r100.copy(r101, r102, r103, r104);
    }

    @SerialName("cell_type")
    public static /* synthetic */ void getCellType$annotations() {
    }

    @SerialName("conversation_id")
    public static /* synthetic */ void getConversationId$annotations() {
    }

    @SerialName("conversation_type")
    public static /* synthetic */ void getConversationType$annotations() {
    }

    @SerialName("if_pin")
    public static /* synthetic */ void getIfPin$annotations() {
    }

    public final String component1() {
        return this.conversationId;
    }

    public final OmniConversationType component2() {
        return this.conversationType;
    }

    public final int component3() {
        return this.cellType;
    }

    public final boolean component4() {
        return this.ifPin;
    }

    public final OmniPinConversationRequest copy(String r100, OmniConversationType r101, int r102, boolean r103) {
        Intrinsics.checkNotNullParameter(r101, "conversationType");
        return new OmniPinConversationRequest(r100, r101, r102, r103);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof OmniPinConversationRequest) == true) goto L8;
        return false;
    L8:
        OmniPinConversationRequest r101 = (OmniPinConversationRequest) r100;
        if (Intrinsics.areEqual(this.conversationId, r101.conversationId) == true) goto L12;
        return false;
    L12:
        if (this.conversationType == r101.conversationType) goto L15;
        return false;
    L15:
        if (this.cellType == r101.cellType) goto L18;
        return false;
    L18:
        if (this.ifPin == r101.ifPin) goto L20;
        return false;
    L20:
        return true;
    }

    public int hashCode() {
        String r100 = this.conversationId;
        if (r100 != null) goto L5;
        int r101 = 0;
    L6:
        int r102 = ((((r101 * 31) + this.conversationType.hashCode()) * 31) + this.cellType) * 31;
        if (this.ifPin == false) goto L9;
        int r103 = 1231;
    L11:
        return r102 + r103;
    L9:
        r103 = 1237;
        goto L11
    L5:
        r101 = r100.hashCode();
        goto L6
    }

    public String toString() {
        return "OmniPinConversationRequest(conversationId=" + this.conversationId + ", conversationType=" + this.conversationType + ", cellType=" + this.cellType + ", ifPin=" + this.ifPin + ')';
    }

    static {
        Companion = new Companion(null);
        $childSerializers = new Lazy[]{null, LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new u9()), null, null};
    }

    public static final /* synthetic */ Lazy[] access$get$childSerializers$cp() {
        return $childSerializers;
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$omnisdk_release(OmniPinConversationRequest r100, muc.d r101, f r102) {
        Lazy<d<Object>>[] r103 = $childSerializers;
        boolean r104 = false;
        if (r101.shouldEncodeElementDefault(r102, 0) == false) goto L6;
    L4:
        boolean r105 = true;
    L9:
        if (r105 == false) goto L12;
        r101.encodeNullableSerializableElement(r102, 0, v2.f520790a, r100.conversationId);
    L12:
        if (r101.shouldEncodeElementDefault(r102, 1) == false) goto L15;
    L13:
        boolean r106 = true;
    L18:
        if (r106 == false) goto L21;
        r101.encodeSerializableElement(r102, 1, r103[1].getValue(), r100.conversationType);
    L21:
        if (r101.shouldEncodeElementDefault(r102, 2) == false) goto L24;
    L22:
        boolean r107 = true;
    L27:
        if (r107 == false) goto L30;
        r101.encodeIntElement(r102, 2, r100.cellType);
    L30:
        if (r101.shouldEncodeElementDefault(r102, 3) == false) goto L33;
    L31:
        r104 = true;
    L35:
        if (r104 == false) goto L38;
        r101.encodeBooleanElement(r102, 3, r100.ifPin);
        return;
    L38:
        return;
    L33:
        if (r100.ifPin == false) goto L35;
    L24:
        if (r100.cellType != 0) goto L22;
        r107 = false;
        goto L27
    L15:
        if (r100.conversationType != OmniConversationType.CONVERSATION_TYPE_UNKNOWN) goto L13;
        r106 = false;
        goto L18
    L6:
        if (r100.conversationId != null) goto L4;
        r105 = false;
        goto L9
    }

    public OmniPinConversationRequest(String r100, OmniConversationType r101, int r102, boolean r103) {
        Intrinsics.checkNotNullParameter(r101, "conversationType");
        this.conversationId = r100;
        this.conversationType = r101;
        this.cellType = r102;
        this.ifPin = r103;
    }

    public /* synthetic */ OmniPinConversationRequest(int r100, String r101, OmniConversationType r102, int r103, boolean r104, q2 r105) {
        if ((r100 & 0) == 0) goto L5;
        b2.b(r100, 0, OmniPinConversationRequest$$serializer.INSTANCE.getDescriptor());
        throw null;
    L5:
        if ((r100 & 1) != 0) goto L7;
        this.conversationId = null;
    L9:
        if ((r100 & 2) != 0) goto L11;
        this.conversationType = OmniConversationType.CONVERSATION_TYPE_UNKNOWN;
    L13:
        if ((r100 & 4) != 0) goto L15;
        this.cellType = 0;
    L17:
        if ((r100 & 8) != 0) goto L19;
        this.ifPin = false;
        return;
    L19:
        this.ifPin = r104;
        return;
    L15:
        this.cellType = r103;
        goto L17
    L11:
        this.conversationType = r102;
        goto L13
    L7:
        this.conversationId = r101;
        goto L9
    }

    public /* synthetic */ OmniPinConversationRequest(String r100, OmniConversationType r101, int r102, boolean r103, int r104, DefaultConstructorMarker r105) {
        if ((r104 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r101 = OmniConversationType.CONVERSATION_TYPE_UNKNOWN;
    L9:
        if ((r104 & 4) == 0) goto L12;
        r102 = 0;
    L12:
        if ((r104 & 8) == 0) goto L14;
        r103 = false;
    L14:
        this(r100, r101, r102, r103);
    }
}
