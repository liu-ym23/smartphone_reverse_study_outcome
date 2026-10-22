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
import nuc.v2;

/* JADX INFO: loaded from: classes29.dex */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 %2\u00060\u0001j\u0002`\u0002:\u0002$%B)\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tB7\b\u0010\u0012\u0006\u0010\n\u001a\u00020\u0007\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\u0004\b\b\u0010\rJ\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0007HÆ\u0003J+\u0010\u0015\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019HÖ\u0003J\t\u0010\u001a\u001a\u00020\u0007HÖ\u0001J\t\u0010\u001b\u001a\u00020\u0004HÖ\u0001J%\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u00002\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\"H\u0001¢\u0006\u0002\b#R\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u000e\u0010\u000fR\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u0010\u0010\u000fR\u0016\u0010\u0006\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u0011\u0010\u000f¨\u0006&"}, d2 = {"Lcom/larus/im/internal/jni/bean/OMNIAVRuntimeLoudnessParams;", "Ljava/io/Serializable;", "Lcom/flow/kmp/common/SerializableIO;", "metaData", "", "deviceAiData", "loudNormAlgoType", "", "<init>", "(Ljava/lang/String;Ljava/lang/String;I)V", "seen0", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Ljava/lang/String;ILkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getMetaData$annotations", "()V", "getDeviceAiData$annotations", "getLoudNormAlgoType$annotations", "component1", "component2", "component3", "copy", "equals", "", "other", "", "hashCode", "toString", "write$Self", "", "self", BdpAppEventConstant.PARAMS_OUTPUT, "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$omnisdk_av_release", "$serializer", "Companion", "omnisdk-av_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
@Serializable
public final class OMNIAVRuntimeLoudnessParams implements java.io.Serializable {
    public static final Companion Companion = null;
    public final String deviceAiData;
    public final int loudNormAlgoType;
    public final String metaData;

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lcom/larus/im/internal/jni/bean/OMNIAVRuntimeLoudnessParams$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/larus/im/internal/jni/bean/OMNIAVRuntimeLoudnessParams;", "omnisdk-av_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }

        public final d<OMNIAVRuntimeLoudnessParams> serializer() {
            return OMNIAVRuntimeLoudnessParams$$serializer.INSTANCE;
        }
    }

    static {
        Companion = new Companion(null);
    }

    public OMNIAVRuntimeLoudnessParams() {
        this(null, null, 0, 7, null);
    }

    public static /* synthetic */ OMNIAVRuntimeLoudnessParams copy$default(OMNIAVRuntimeLoudnessParams r100, String r101, String r102, int r103, int r104, Object r105) {
        if ((r104 & 1) == 0) goto L6;
        r101 = r100.metaData;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r102 = r100.deviceAiData;
    L9:
        if ((r104 & 4) == 0) goto L12;
        r103 = r100.loudNormAlgoType;
    L12:
        return r100.copy(r101, r102, r103);
    }

    @SerialName("deviceAiData")
    public static /* synthetic */ void getDeviceAiData$annotations() {
    }

    @SerialName("loudNormAlgoType")
    public static /* synthetic */ void getLoudNormAlgoType$annotations() {
    }

    @SerialName("metaData")
    public static /* synthetic */ void getMetaData$annotations() {
    }

    public final String component1() {
        return this.metaData;
    }

    public final String component2() {
        return this.deviceAiData;
    }

    public final int component3() {
        return this.loudNormAlgoType;
    }

    public final OMNIAVRuntimeLoudnessParams copy(String r100, String r101, int r102) {
        return new OMNIAVRuntimeLoudnessParams(r100, r101, r102);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof OMNIAVRuntimeLoudnessParams) == true) goto L8;
        return false;
    L8:
        OMNIAVRuntimeLoudnessParams r101 = (OMNIAVRuntimeLoudnessParams) r100;
        if (Intrinsics.areEqual(this.metaData, r101.metaData) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.deviceAiData, r101.deviceAiData) == true) goto L15;
        return false;
    L15:
        if (this.loudNormAlgoType == r101.loudNormAlgoType) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        String r100 = this.metaData;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.deviceAiData;
        if (r104 == null) goto L11;
        r101 = r104.hashCode();
    L11:
        return ((r103 + r101) * 31) + this.loudNormAlgoType;
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public String toString() {
        return "OMNIAVRuntimeLoudnessParams(metaData=" + this.metaData + ", deviceAiData=" + this.deviceAiData + ", loudNormAlgoType=" + this.loudNormAlgoType + ')';
    }

    public OMNIAVRuntimeLoudnessParams(String r100, String r101, int r102) {
        this.metaData = r100;
        this.deviceAiData = r101;
        this.loudNormAlgoType = r102;
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$omnisdk_av_release(OMNIAVRuntimeLoudnessParams r100, muc.d r101, f r102) {
        boolean r103 = false;
        if (r101.shouldEncodeElementDefault(r102, 0) == false) goto L6;
    L4:
        boolean r104 = true;
    L9:
        if (r104 == false) goto L12;
        r101.encodeNullableSerializableElement(r102, 0, v2.f520790a, r100.metaData);
    L12:
        if (r101.shouldEncodeElementDefault(r102, 1) == false) goto L15;
    L13:
        boolean r105 = true;
    L18:
        if (r105 == false) goto L21;
        r101.encodeNullableSerializableElement(r102, 1, v2.f520790a, r100.deviceAiData);
    L21:
        if (r101.shouldEncodeElementDefault(r102, 2) == false) goto L24;
    L22:
        r103 = true;
    L26:
        if (r103 == false) goto L29;
        r101.encodeIntElement(r102, 2, r100.loudNormAlgoType);
        return;
    L29:
        return;
    L24:
        if (r100.loudNormAlgoType == 0) goto L26;
    L15:
        if (r100.deviceAiData != null) goto L13;
        r105 = false;
        goto L18
    L6:
        if (r100.metaData != null) goto L4;
        r104 = false;
        goto L9
    }

    public /* synthetic */ OMNIAVRuntimeLoudnessParams(int r100, String r101, String r102, int r103, q2 r104) {
        if ((r100 & 0) == 0) goto L5;
        b2.b(r100, 0, OMNIAVRuntimeLoudnessParams$$serializer.INSTANCE.getDescriptor());
        throw null;
    L5:
        if ((r100 & 1) != 0) goto L7;
        this.metaData = null;
    L9:
        if ((r100 & 2) != 0) goto L11;
        this.deviceAiData = null;
    L13:
        if ((r100 & 4) != 0) goto L15;
        this.loudNormAlgoType = 0;
        return;
    L15:
        this.loudNormAlgoType = r103;
        return;
    L11:
        this.deviceAiData = r102;
        goto L13
    L7:
        this.metaData = r101;
        goto L9
    }

    public /* synthetic */ OMNIAVRuntimeLoudnessParams(String r100, String r101, int r102, int r103, DefaultConstructorMarker r104) {
        if ((r103 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r101 = null;
    L9:
        if ((r103 & 4) == 0) goto L11;
        r102 = 0;
    L11:
        this(r100, r101, r102);
    }
}
