package com.larus.im.internal.jni.bean;

import com.android.ttcjpaysdk.thirdparty.verify.view.VerifyPasswordFragment;
import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import de9.p7;
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
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 *2\u00060\u0001j\u0002`\u0002:\u0002)*B1\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u000b\u0010\fB?\b\u0010\u0012\u0006\u0010\r\u001a\u00020\b\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f¢\u0006\u0004\b\u000b\u0010\u0010J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0018\u001a\u00020\bHÆ\u0003J\t\u0010\u0019\u001a\u00020\nHÆ\u0003J3\u0010\u001a\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\nHÆ\u0001J\u0013\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eHÖ\u0003J\t\u0010\u001f\u001a\u00020\bHÖ\u0001J\t\u0010 \u001a\u00020\u0004HÖ\u0001J%\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020\u00002\u0006\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020'H\u0001¢\u0006\u0002\b(R\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0005\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u0013\u0010\u0012R\u0016\u0010\u0007\u001a\u00020\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u0014\u0010\u0012R\u0016\u0010\t\u001a\u00020\n8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u0015\u0010\u0012¨\u0006+"}, d2 = {"Lcom/larus/im/internal/jni/bean/OmniGetMessageListFromLocalRequest;", "Ljava/io/Serializable;", "Lcom/flow/kmp/common/SerializableIO;", "conversationId", "", "maxIndex", "", VerifyPasswordFragment.LYNX_OPEN_CREDIT_LIMIT, "", "type", "Lcom/larus/im/internal/jni/bean/OmniMessageListRequestType;", "<init>", "(Ljava/lang/String;JILcom/larus/im/internal/jni/bean/OmniMessageListRequestType;)V", "seen0", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;JILcom/larus/im/internal/jni/bean/OmniMessageListRequestType;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getConversationId$annotations", "()V", "getMaxIndex$annotations", "getLimit$annotations", "getType$annotations", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "", "hashCode", "toString", "write$Self", "", "self", BdpAppEventConstant.PARAMS_OUTPUT, "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$omnisdk_release", "$serializer", "Companion", "omnisdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
@Serializable
public final class OmniGetMessageListFromLocalRequest implements java.io.Serializable {
    private static final Lazy<d<Object>>[] $childSerializers = null;
    public static final Companion Companion = null;
    public final String conversationId;
    public final int limit;
    public final long maxIndex;
    public final OmniMessageListRequestType type;

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lcom/larus/im/internal/jni/bean/OmniGetMessageListFromLocalRequest$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/larus/im/internal/jni/bean/OmniGetMessageListFromLocalRequest;", "omnisdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }

        public final d<OmniGetMessageListFromLocalRequest> serializer() {
            return OmniGetMessageListFromLocalRequest$$serializer.INSTANCE;
        }
    }

    public OmniGetMessageListFromLocalRequest() {
        this(null, 0, 0, null, 15, null);
    }

    private static final /* synthetic */ d _childSerializers$_anonymous_() {
        return OmniMessageListRequestType.Companion.serializer();
    }

    public static /* synthetic */ d a() {
        return _childSerializers$_anonymous_();
    }

    public static /* synthetic */ OmniGetMessageListFromLocalRequest copy$default(OmniGetMessageListFromLocalRequest r100, String r101, long r102, int r103, OmniMessageListRequestType r104, int r105, Object r110) {
        if ((r105 & 1) == 0) goto L6;
        r101 = r100.conversationId;
    L6:
        if ((r105 & 2) == 0) goto L8;
        r102 = r100.maxIndex;
    L8:
        long r106 = r102;
        if ((r105 & 4) == 0) goto L11;
        r103 = r100.limit;
    L11:
        int r111 = r103;
        if ((r105 & 8) == 0) goto L14;
        r104 = r100.type;
    L14:
        String r107 = r101;
        return r100.copy(r107, r106, r111, r104);
    }

    @SerialName("conversation_id")
    public static /* synthetic */ void getConversationId$annotations() {
    }

    @SerialName(VerifyPasswordFragment.LYNX_OPEN_CREDIT_LIMIT)
    public static /* synthetic */ void getLimit$annotations() {
    }

    @SerialName("max_index")
    public static /* synthetic */ void getMaxIndex$annotations() {
    }

    @SerialName("type")
    public static /* synthetic */ void getType$annotations() {
    }

    public final String component1() {
        return this.conversationId;
    }

    public final long component2() {
        return this.maxIndex;
    }

    public final int component3() {
        return this.limit;
    }

    public final OmniMessageListRequestType component4() {
        return this.type;
    }

    public final OmniGetMessageListFromLocalRequest copy(String r100, long r101, int r110, OmniMessageListRequestType r111) {
        Intrinsics.checkNotNullParameter(r111, "type");
        return new OmniGetMessageListFromLocalRequest(r100, r101, r110, r111);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof OmniGetMessageListFromLocalRequest) == true) goto L8;
        return false;
    L8:
        OmniGetMessageListFromLocalRequest r101 = (OmniGetMessageListFromLocalRequest) r100;
        if (Intrinsics.areEqual(this.conversationId, r101.conversationId) == true) goto L12;
        return false;
    L12:
        if (this.maxIndex == r101.maxIndex) goto L15;
        return false;
    L15:
        if (this.limit == r101.limit) goto L18;
        return false;
    L18:
        if (this.type == r101.type) goto L20;
        return false;
    L20:
        return true;
    }

    public int hashCode() {
        String r100 = this.conversationId;
        if (r100 != null) goto L5;
        int r101 = 0;
    L6:
        long r102 = this.maxIndex;
        return (((((r101 * 31) + ((int) (r102 ^ (r102 >>> 32)))) * 31) + this.limit) * 31) + this.type.hashCode();
    L5:
        r101 = r100.hashCode();
        goto L6
    }

    public String toString() {
        return "OmniGetMessageListFromLocalRequest(conversationId=" + this.conversationId + ", maxIndex=" + this.maxIndex + ", limit=" + this.limit + ", type=" + this.type + ')';
    }

    static {
        Companion = new Companion(null);
        $childSerializers = new Lazy[]{null, null, null, LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new p7())};
    }

    public static final /* synthetic */ Lazy[] access$get$childSerializers$cp() {
        return $childSerializers;
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$omnisdk_release(OmniGetMessageListFromLocalRequest r100, muc.d r101, f r110) {
        Lazy<d<Object>>[] r102 = $childSerializers;
        boolean r103 = false;
        if (r101.shouldEncodeElementDefault(r110, 0) == false) goto L6;
    L4:
        boolean r104 = true;
    L9:
        if (r104 == false) goto L12;
        r101.encodeNullableSerializableElement(r110, 0, v2.f520790a, r100.conversationId);
    L12:
        if (r101.shouldEncodeElementDefault(r110, 1) == false) goto L15;
    L13:
        boolean r105 = true;
    L18:
        if (r105 == false) goto L21;
        r101.encodeLongElement(r110, 1, r100.maxIndex);
    L21:
        if (r101.shouldEncodeElementDefault(r110, 2) == false) goto L24;
    L22:
        boolean r106 = true;
    L27:
        if (r106 == false) goto L30;
        r101.encodeIntElement(r110, 2, r100.limit);
    L30:
        if (r101.shouldEncodeElementDefault(r110, 3) == false) goto L33;
    L31:
        r103 = true;
    L35:
        if (r103 == false) goto L38;
        r101.encodeSerializableElement(r110, 3, r102[3].getValue(), r100.type);
        return;
    L38:
        return;
    L33:
        if (r100.type == OmniMessageListRequestType.FROM_LATEST) goto L35;
    L24:
        if (r100.limit != 0) goto L22;
        r106 = false;
        goto L27
    L15:
        if (r100.maxIndex != 0) goto L13;
        r105 = false;
        goto L18
    L6:
        if (r100.conversationId != null) goto L4;
        r104 = false;
        goto L9
    }

    public OmniGetMessageListFromLocalRequest(String r100, long r101, int r102, OmniMessageListRequestType r103) {
        Intrinsics.checkNotNullParameter(r103, "type");
        this.conversationId = r100;
        this.maxIndex = r101;
        this.limit = r102;
        this.type = r103;
    }

    public /* synthetic */ OmniGetMessageListFromLocalRequest(int r100, String r101, long r102, int r103, OmniMessageListRequestType r104, q2 r105) {
        if ((r100 & 0) == 0) goto L5;
        b2.b(r100, 0, OmniGetMessageListFromLocalRequest$$serializer.INSTANCE.getDescriptor());
        throw null;
    L5:
        if ((r100 & 1) != 0) goto L7;
        this.conversationId = null;
    L9:
        if ((r100 & 2) != 0) goto L11;
        this.maxIndex = 0;
    L13:
        if ((r100 & 4) != 0) goto L15;
        this.limit = 0;
    L17:
        if ((r100 & 8) != 0) goto L19;
        this.type = OmniMessageListRequestType.FROM_LATEST;
        return;
    L19:
        this.type = r104;
        return;
    L15:
        this.limit = r103;
        goto L17
    L11:
        this.maxIndex = r102;
        goto L13
    L7:
        this.conversationId = r101;
        goto L9
    }

    public /* synthetic */ OmniGetMessageListFromLocalRequest(String r100, long r101, int r102, OmniMessageListRequestType r103, int r104, DefaultConstructorMarker r110) {
        if ((r104 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r104 & 2) == 0) goto L8;
        r101 = 0;
    L8:
        long r105 = r101;
        if ((r104 & 4) == 0) goto L11;
        int r111 = 0;
    L13:
        if ((r104 & 8) == 0) goto L15;
        r103 = OmniMessageListRequestType.FROM_LATEST;
    L15:
        String r106 = r100;
        int r107 = r111;
        this(r106, r105, r107, r103);
        return;
    L11:
        r111 = r102;
        goto L13
    }
}
