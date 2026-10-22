package com.larus.im.internal.jni.bean;

import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import com.bytedance.common.wschannel.WsConstants;
import de9.s6;
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

/* JADX INFO: loaded from: classes29.dex */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 $2\u00060\u0001j\u0002`\u0002:\u0002#$B\u001d\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u0007\u0010\bB/\b\u0010\u0012\u0006\u0010\t\u001a\u00020\n\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\u0004\b\u0007\u0010\rJ\t\u0010\u0011\u001a\u00020\u0004HÆ\u0003J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u001f\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017HÖ\u0003J\t\u0010\u0018\u001a\u00020\nHÖ\u0001J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001J%\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u00002\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!H\u0001¢\u0006\u0002\b\"R\u0016\u0010\u0003\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u000e\u0010\u000fR\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u0010\u0010\u000f¨\u0006%"}, d2 = {"Lcom/larus/im/internal/jni/bean/OmniDispatchCommandResponse;", "Ljava/io/Serializable;", "Lcom/flow/kmp/common/SerializableIO;", "from", "Lcom/larus/im/internal/jni/bean/OmniDispatchCommandFrom;", WsConstants.KEY_PAYLOAD, "Lcom/larus/im/internal/jni/bean/DispatchCommandPayload;", "<init>", "(Lcom/larus/im/internal/jni/bean/OmniDispatchCommandFrom;Lcom/larus/im/internal/jni/bean/DispatchCommandPayload;)V", "seen0", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILcom/larus/im/internal/jni/bean/OmniDispatchCommandFrom;Lcom/larus/im/internal/jni/bean/DispatchCommandPayload;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getFrom$annotations", "()V", "getPayload$annotations", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "toString", "", "write$Self", "", "self", BdpAppEventConstant.PARAMS_OUTPUT, "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$omnisdk_release", "$serializer", "Companion", "omnisdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
@Serializable
public final class OmniDispatchCommandResponse implements java.io.Serializable {
    private static final Lazy<d<Object>>[] $childSerializers = null;
    public static final Companion Companion = null;
    public final OmniDispatchCommandFrom from;
    public final DispatchCommandPayload payload;

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lcom/larus/im/internal/jni/bean/OmniDispatchCommandResponse$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/larus/im/internal/jni/bean/OmniDispatchCommandResponse;", "omnisdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }

        public final d<OmniDispatchCommandResponse> serializer() {
            return OmniDispatchCommandResponse$$serializer.INSTANCE;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public OmniDispatchCommandResponse() {
        Object[] r100 = 0 == true ? 1 : 0;
        this(null, r100, 3, 0 == true ? 1 : 0);
    }

    private static final /* synthetic */ d _childSerializers$_anonymous_() {
        return OmniDispatchCommandFrom.Companion.serializer();
    }

    public static /* synthetic */ d a() {
        return _childSerializers$_anonymous_();
    }

    public static /* synthetic */ OmniDispatchCommandResponse copy$default(OmniDispatchCommandResponse r100, OmniDispatchCommandFrom r101, DispatchCommandPayload r102, int r103, Object r104) {
        if ((r103 & 1) == 0) goto L6;
        r101 = r100.from;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r102 = r100.payload;
    L9:
        return r100.copy(r101, r102);
    }

    @SerialName("from")
    public static /* synthetic */ void getFrom$annotations() {
    }

    @SerialName(WsConstants.KEY_PAYLOAD)
    public static /* synthetic */ void getPayload$annotations() {
    }

    public final OmniDispatchCommandFrom component1() {
        return this.from;
    }

    public final DispatchCommandPayload component2() {
        return this.payload;
    }

    public final OmniDispatchCommandResponse copy(OmniDispatchCommandFrom r100, DispatchCommandPayload r101) {
        Intrinsics.checkNotNullParameter(r100, "from");
        return new OmniDispatchCommandResponse(r100, r101);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof OmniDispatchCommandResponse) == true) goto L8;
        return false;
    L8:
        OmniDispatchCommandResponse r101 = (OmniDispatchCommandResponse) r100;
        if (this.from == r101.from) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.payload, r101.payload) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        int r100 = this.from.hashCode() * 31;
        DispatchCommandPayload r101 = this.payload;
        if (r101 != null) goto L5;
        int r102 = 0;
    L7:
        return r100 + r102;
    L5:
        r102 = r101.hashCode();
        goto L7
    }

    public String toString() {
        return "OmniDispatchCommandResponse(from=" + this.from + ", payload=" + this.payload + ')';
    }

    static {
        Companion = new Companion(null);
        $childSerializers = new Lazy[]{LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new s6()), null};
    }

    public static final /* synthetic */ Lazy[] access$get$childSerializers$cp() {
        return $childSerializers;
    }

    public OmniDispatchCommandResponse(OmniDispatchCommandFrom r100, DispatchCommandPayload r101) {
        Intrinsics.checkNotNullParameter(r100, "from");
        this.from = r100;
        this.payload = r101;
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$omnisdk_release(OmniDispatchCommandResponse r100, muc.d r101, f r102) {
        Lazy<d<Object>>[] r103 = $childSerializers;
        boolean r104 = false;
        if (r101.shouldEncodeElementDefault(r102, 0) == false) goto L6;
    L4:
        boolean r105 = true;
    L9:
        if (r105 == false) goto L12;
        r101.encodeSerializableElement(r102, 0, r103[0].getValue(), r100.from);
    L12:
        if (r101.shouldEncodeElementDefault(r102, 1) == false) goto L15;
    L13:
        r104 = true;
    L17:
        if (r104 == false) goto L20;
        r101.encodeNullableSerializableElement(r102, 1, DispatchCommandPayload$$serializer.INSTANCE, r100.payload);
        return;
    L20:
        return;
    L15:
        if (r100.payload == null) goto L17;
    L6:
        if (r100.from != OmniDispatchCommandFrom.FROM_CALLBACK) goto L4;
        r105 = false;
        goto L9
    }

    public /* synthetic */ OmniDispatchCommandResponse(int r100, OmniDispatchCommandFrom r101, DispatchCommandPayload r102, q2 r103) {
        if ((r100 & 0) == 0) goto L5;
        b2.b(r100, 0, OmniDispatchCommandResponse$$serializer.INSTANCE.getDescriptor());
        throw null;
    L5:
        if ((r100 & 1) != 0) goto L7;
        r101 = OmniDispatchCommandFrom.FROM_CALLBACK;
    L7:
        this.from = r101;
        if ((r100 & 2) != 0) goto L10;
        this.payload = null;
        return;
    L10:
        this.payload = r102;
    }

    public /* synthetic */ OmniDispatchCommandResponse(OmniDispatchCommandFrom r100, DispatchCommandPayload r101, int r102, DefaultConstructorMarker r103) {
        if ((r102 & 1) == 0) goto L6;
        r100 = OmniDispatchCommandFrom.FROM_CALLBACK;
    L6:
        if ((r102 & 2) == 0) goto L8;
        r101 = null;
    L8:
        this(r100, r101);
    }
}
