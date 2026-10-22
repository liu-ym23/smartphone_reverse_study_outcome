package com.larus.im.internal.jni.bean;

import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import com.bytedance.common.wschannel.WsConstants;
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
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 &2\u00060\u0001j\u0002`\u0002:\u0002%&B)\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\t\u0010\nB7\b\u0010\u0012\u0006\u0010\u000b\u001a\u00020\u0006\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\b\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\u0004\b\t\u0010\u000eJ\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0006HÆ\u0003J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\bHÆ\u0003J+\u0010\u0016\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\bHÆ\u0001J\u0013\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aHÖ\u0003J\t\u0010\u001b\u001a\u00020\u0006HÖ\u0001J\t\u0010\u001c\u001a\u00020\u0004HÖ\u0001J%\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u00002\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020#H\u0001¢\u0006\u0002\b$R\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0005\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u0011\u0010\u0010R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u0012\u0010\u0010¨\u0006'"}, d2 = {"Lcom/larus/im/internal/jni/bean/OmniDispatchCommandRequest;", "Ljava/io/Serializable;", "Lcom/flow/kmp/common/SerializableIO;", "targetDeviceId", "", "targetAppId", "", WsConstants.KEY_PAYLOAD, "Lcom/larus/im/internal/jni/bean/DispatchCommandPayload;", "<init>", "(Ljava/lang/String;ILcom/larus/im/internal/jni/bean/DispatchCommandPayload;)V", "seen0", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;ILcom/larus/im/internal/jni/bean/DispatchCommandPayload;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getTargetDeviceId$annotations", "()V", "getTargetAppId$annotations", "getPayload$annotations", "component1", "component2", "component3", "copy", "equals", "", "other", "", "hashCode", "toString", "write$Self", "", "self", BdpAppEventConstant.PARAMS_OUTPUT, "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$omnisdk_release", "$serializer", "Companion", "omnisdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
@Serializable
public final class OmniDispatchCommandRequest implements java.io.Serializable {
    public static final Companion Companion = null;
    public final DispatchCommandPayload payload;
    public final int targetAppId;
    public final String targetDeviceId;

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lcom/larus/im/internal/jni/bean/OmniDispatchCommandRequest$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/larus/im/internal/jni/bean/OmniDispatchCommandRequest;", "omnisdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }

        public final d<OmniDispatchCommandRequest> serializer() {
            return OmniDispatchCommandRequest$$serializer.INSTANCE;
        }
    }

    static {
        Companion = new Companion(null);
    }

    public OmniDispatchCommandRequest() {
        this(null, 0, null, 7, null);
    }

    public static /* synthetic */ OmniDispatchCommandRequest copy$default(OmniDispatchCommandRequest r100, String r101, int r102, DispatchCommandPayload r103, int r104, Object r105) {
        if ((r104 & 1) == 0) goto L6;
        r101 = r100.targetDeviceId;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r102 = r100.targetAppId;
    L9:
        if ((r104 & 4) == 0) goto L12;
        r103 = r100.payload;
    L12:
        return r100.copy(r101, r102, r103);
    }

    @SerialName(WsConstants.KEY_PAYLOAD)
    public static /* synthetic */ void getPayload$annotations() {
    }

    @SerialName("target_app_id")
    public static /* synthetic */ void getTargetAppId$annotations() {
    }

    @SerialName("target_device_id")
    public static /* synthetic */ void getTargetDeviceId$annotations() {
    }

    public final String component1() {
        return this.targetDeviceId;
    }

    public final int component2() {
        return this.targetAppId;
    }

    public final DispatchCommandPayload component3() {
        return this.payload;
    }

    public final OmniDispatchCommandRequest copy(String r100, int r101, DispatchCommandPayload r102) {
        return new OmniDispatchCommandRequest(r100, r101, r102);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof OmniDispatchCommandRequest) == true) goto L8;
        return false;
    L8:
        OmniDispatchCommandRequest r101 = (OmniDispatchCommandRequest) r100;
        if (Intrinsics.areEqual(this.targetDeviceId, r101.targetDeviceId) == true) goto L12;
        return false;
    L12:
        if (this.targetAppId == r101.targetAppId) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.payload, r101.payload) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        String r100 = this.targetDeviceId;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = ((r102 * 31) + this.targetAppId) * 31;
        DispatchCommandPayload r104 = this.payload;
        if (r104 == null) goto L11;
        r101 = r104.hashCode();
    L11:
        return r103 + r101;
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public String toString() {
        return "OmniDispatchCommandRequest(targetDeviceId=" + this.targetDeviceId + ", targetAppId=" + this.targetAppId + ", payload=" + this.payload + ')';
    }

    public OmniDispatchCommandRequest(String r100, int r101, DispatchCommandPayload r102) {
        this.targetDeviceId = r100;
        this.targetAppId = r101;
        this.payload = r102;
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$omnisdk_release(OmniDispatchCommandRequest r100, muc.d r101, f r102) {
        boolean r103 = false;
        if (r101.shouldEncodeElementDefault(r102, 0) == false) goto L6;
    L4:
        boolean r104 = true;
    L9:
        if (r104 == false) goto L12;
        r101.encodeNullableSerializableElement(r102, 0, v2.f520790a, r100.targetDeviceId);
    L12:
        if (r101.shouldEncodeElementDefault(r102, 1) == false) goto L15;
    L13:
        boolean r105 = true;
    L18:
        if (r105 == false) goto L21;
        r101.encodeIntElement(r102, 1, r100.targetAppId);
    L21:
        if (r101.shouldEncodeElementDefault(r102, 2) == false) goto L24;
    L22:
        r103 = true;
    L26:
        if (r103 == false) goto L29;
        r101.encodeNullableSerializableElement(r102, 2, DispatchCommandPayload$$serializer.INSTANCE, r100.payload);
        return;
    L29:
        return;
    L24:
        if (r100.payload == null) goto L26;
    L15:
        if (r100.targetAppId != 0) goto L13;
        r105 = false;
        goto L18
    L6:
        if (r100.targetDeviceId != null) goto L4;
        r104 = false;
        goto L9
    }

    public /* synthetic */ OmniDispatchCommandRequest(int r100, String r101, int r102, DispatchCommandPayload r103, q2 r104) {
        if ((r100 & 0) == 0) goto L5;
        b2.b(r100, 0, OmniDispatchCommandRequest$$serializer.INSTANCE.getDescriptor());
        throw null;
    L5:
        if ((r100 & 1) != 0) goto L7;
        this.targetDeviceId = null;
    L9:
        if ((r100 & 2) != 0) goto L11;
        this.targetAppId = 0;
    L13:
        if ((r100 & 4) != 0) goto L15;
        this.payload = null;
        return;
    L15:
        this.payload = r103;
        return;
    L11:
        this.targetAppId = r102;
        goto L13
    L7:
        this.targetDeviceId = r101;
        goto L9
    }

    public /* synthetic */ OmniDispatchCommandRequest(String r100, int r101, DispatchCommandPayload r102, int r103, DefaultConstructorMarker r104) {
        if ((r103 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r101 = 0;
    L9:
        if ((r103 & 4) == 0) goto L11;
        r102 = null;
    L11:
        this(r100, r101, r102);
    }
}
