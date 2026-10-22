package com.larus.im.internal.jni.bean;

import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
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

/* JADX INFO: loaded from: classes29.dex */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 #2\u00060\u0001j\u0002`\u0002:\u0002\"#B\u001d\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u0007\u0010\bB-\b\u0010\u0012\u0006\u0010\t\u001a\u00020\u0004\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b\u0007\u0010\fJ\t\u0010\u0010\u001a\u00020\u0004HÆ\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u001f\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0004HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001J%\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u00002\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 H\u0001¢\u0006\u0002\b!R\u0016\u0010\u0003\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u0012\u0004\b\r\u0010\u000eR\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u000f\u0010\u000e¨\u0006$"}, d2 = {"Lcom/larus/im/internal/jni/bean/OmniDispatchCommandAcceptedResponse;", "Ljava/io/Serializable;", "Lcom/flow/kmp/common/SerializableIO;", "errorCode", "", "roomMeta", "Lcom/larus/im/internal/jni/bean/RoomMeta;", "<init>", "(ILcom/larus/im/internal/jni/bean/RoomMeta;)V", "seen0", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(IILcom/larus/im/internal/jni/bean/RoomMeta;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getErrorCode$annotations", "()V", "getRoomMeta$annotations", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "toString", "", "write$Self", "", "self", BdpAppEventConstant.PARAMS_OUTPUT, "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$omnisdk_release", "$serializer", "Companion", "omnisdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
@Serializable
public final class OmniDispatchCommandAcceptedResponse implements java.io.Serializable {
    public static final Companion Companion = null;
    public final int errorCode;
    public final RoomMeta roomMeta;

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lcom/larus/im/internal/jni/bean/OmniDispatchCommandAcceptedResponse$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/larus/im/internal/jni/bean/OmniDispatchCommandAcceptedResponse;", "omnisdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }

        public final d<OmniDispatchCommandAcceptedResponse> serializer() {
            return OmniDispatchCommandAcceptedResponse$$serializer.INSTANCE;
        }
    }

    static {
        Companion = new Companion(null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public OmniDispatchCommandAcceptedResponse() {
        int r100 = 0;
        this(r100, null, 3, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ OmniDispatchCommandAcceptedResponse copy$default(OmniDispatchCommandAcceptedResponse r100, int r101, RoomMeta r102, int r103, Object r104) {
        if ((r103 & 1) == 0) goto L6;
        r101 = r100.errorCode;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r102 = r100.roomMeta;
    L9:
        return r100.copy(r101, r102);
    }

    @SerialName("error_code")
    public static /* synthetic */ void getErrorCode$annotations() {
    }

    @SerialName("room_meta")
    public static /* synthetic */ void getRoomMeta$annotations() {
    }

    public final int component1() {
        return this.errorCode;
    }

    public final RoomMeta component2() {
        return this.roomMeta;
    }

    public final OmniDispatchCommandAcceptedResponse copy(int r100, RoomMeta r101) {
        return new OmniDispatchCommandAcceptedResponse(r100, r101);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof OmniDispatchCommandAcceptedResponse) == true) goto L8;
        return false;
    L8:
        OmniDispatchCommandAcceptedResponse r101 = (OmniDispatchCommandAcceptedResponse) r100;
        if (this.errorCode == r101.errorCode) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.roomMeta, r101.roomMeta) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        int r100 = this.errorCode * 31;
        RoomMeta r101 = this.roomMeta;
        if (r101 != null) goto L5;
        int r102 = 0;
    L7:
        return r100 + r102;
    L5:
        r102 = r101.hashCode();
        goto L7
    }

    public String toString() {
        return "OmniDispatchCommandAcceptedResponse(errorCode=" + this.errorCode + ", roomMeta=" + this.roomMeta + ')';
    }

    public OmniDispatchCommandAcceptedResponse(int r100, RoomMeta r101) {
        this.errorCode = r100;
        this.roomMeta = r101;
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$omnisdk_release(OmniDispatchCommandAcceptedResponse r100, muc.d r101, f r102) {
        boolean r103 = false;
        if (r101.shouldEncodeElementDefault(r102, 0) == false) goto L6;
    L4:
        boolean r104 = true;
    L9:
        if (r104 == false) goto L12;
        r101.encodeIntElement(r102, 0, r100.errorCode);
    L12:
        if (r101.shouldEncodeElementDefault(r102, 1) == false) goto L15;
    L13:
        r103 = true;
    L17:
        if (r103 == false) goto L20;
        r101.encodeNullableSerializableElement(r102, 1, RoomMeta$$serializer.INSTANCE, r100.roomMeta);
        return;
    L20:
        return;
    L15:
        if (r100.roomMeta == null) goto L17;
    L6:
        if (r100.errorCode != 0) goto L4;
        r104 = false;
        goto L9
    }

    public /* synthetic */ OmniDispatchCommandAcceptedResponse(int r100, int r101, RoomMeta r102, q2 r103) {
        if ((r100 & 0) == 0) goto L5;
        b2.b(r100, 0, OmniDispatchCommandAcceptedResponse$$serializer.INSTANCE.getDescriptor());
        throw null;
    L5:
        if ((r100 & 1) != 0) goto L7;
        this.errorCode = 0;
    L9:
        if ((r100 & 2) != 0) goto L11;
        this.roomMeta = null;
        return;
    L11:
        this.roomMeta = r102;
        return;
    L7:
        this.errorCode = r101;
        goto L9
    }

    public /* synthetic */ OmniDispatchCommandAcceptedResponse(int r100, RoomMeta r101, int r102, DefaultConstructorMarker r103) {
        if ((r102 & 1) == 0) goto L6;
        r100 = 0;
    L6:
        if ((r102 & 2) == 0) goto L8;
        r101 = null;
    L8:
        this(r100, r101);
    }
}
