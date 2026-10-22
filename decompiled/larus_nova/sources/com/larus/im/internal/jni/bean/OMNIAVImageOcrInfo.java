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
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 )2\u00060\u0001j\u0002`\u0002:\u0002()B1\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\b¢\u0006\u0004\b\n\u0010\u000bB=\b\u0010\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\b\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f¢\u0006\u0004\b\n\u0010\u0010J\t\u0010\u0016\u001a\u00020\u0004HÆ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\t\u0010\u0018\u001a\u00020\bHÆ\u0003J\t\u0010\u0019\u001a\u00020\bHÆ\u0003J3\u0010\u001a\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\bHÆ\u0001J\u0013\u0010\u001b\u001a\u00020\u00042\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dHÖ\u0003J\t\u0010\u001e\u001a\u00020\rHÖ\u0001J\t\u0010\u001f\u001a\u00020\u0006HÖ\u0001J%\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020\u00002\u0006\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020&H\u0001¢\u0006\u0002\b'R\u0016\u0010\u0003\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u0011\u0010\u0012R\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u0013\u0010\u0012R\u0016\u0010\u0007\u001a\u00020\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u0014\u0010\u0012R\u0016\u0010\t\u001a\u00020\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u0015\u0010\u0012¨\u0006*"}, d2 = {"Lcom/larus/im/internal/jni/bean/OMNIAVImageOcrInfo;", "Ljava/io/Serializable;", "Lcom/flow/kmp/common/SerializableIO;", "hasOcrText", "", "ocrText", "", "timestamp", "", "videoFrameIndex", "<init>", "(ZLjava/lang/String;JJ)V", "seen0", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(IZLjava/lang/String;JJLkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getHasOcrText$annotations", "()V", "getOcrText$annotations", "getTimestamp$annotations", "getVideoFrameIndex$annotations", "component1", "component2", "component3", "component4", "copy", "equals", "other", "", "hashCode", "toString", "write$Self", "", "self", BdpAppEventConstant.PARAMS_OUTPUT, "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$omnisdk_av_release", "$serializer", "Companion", "omnisdk-av_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
@Serializable
public final class OMNIAVImageOcrInfo implements java.io.Serializable {
    public static final Companion Companion = null;
    public final boolean hasOcrText;
    public final String ocrText;
    public final long timestamp;
    public final long videoFrameIndex;

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lcom/larus/im/internal/jni/bean/OMNIAVImageOcrInfo$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/larus/im/internal/jni/bean/OMNIAVImageOcrInfo;", "omnisdk-av_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }

        public final d<OMNIAVImageOcrInfo> serializer() {
            return OMNIAVImageOcrInfo$$serializer.INSTANCE;
        }
    }

    static {
        Companion = new Companion(null);
    }

    public OMNIAVImageOcrInfo() {
        this(false, null, 0, 0, 15, null);
    }

    public static /* synthetic */ OMNIAVImageOcrInfo copy$default(OMNIAVImageOcrInfo r100, boolean r101, String r102, long r103, long r104, int r110, Object r111) {
        if ((r110 & 1) == 0) goto L6;
        r101 = r100.hasOcrText;
    L6:
        if ((r110 & 2) == 0) goto L8;
        r102 = r100.ocrText;
    L8:
        String r112 = r102;
        if ((r110 & 4) == 0) goto L11;
        r103 = r100.timestamp;
    L11:
        long r105 = r103;
        if ((r110 & 8) == 0) goto L14;
        r104 = r100.videoFrameIndex;
    L14:
        boolean r106 = r101;
        return r100.copy(r106, r112, r105, r104);
    }

    @SerialName("hasOcrText")
    public static /* synthetic */ void getHasOcrText$annotations() {
    }

    @SerialName("ocrText")
    public static /* synthetic */ void getOcrText$annotations() {
    }

    @SerialName("timestamp")
    public static /* synthetic */ void getTimestamp$annotations() {
    }

    @SerialName("videoFrameIndex")
    public static /* synthetic */ void getVideoFrameIndex$annotations() {
    }

    public final boolean component1() {
        return this.hasOcrText;
    }

    public final String component2() {
        return this.ocrText;
    }

    public final long component3() {
        return this.timestamp;
    }

    public final long component4() {
        return this.videoFrameIndex;
    }

    public final OMNIAVImageOcrInfo copy(boolean r100, String r110, long r111, long r112) {
        return new OMNIAVImageOcrInfo(r100, r110, r111, r112);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof OMNIAVImageOcrInfo) == true) goto L8;
        return false;
    L8:
        OMNIAVImageOcrInfo r101 = (OMNIAVImageOcrInfo) r100;
        if (this.hasOcrText == r101.hasOcrText) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.ocrText, r101.ocrText) == true) goto L15;
        return false;
    L15:
        if (this.timestamp == r101.timestamp) goto L18;
        return false;
    L18:
        if (this.videoFrameIndex == r101.videoFrameIndex) goto L20;
        return false;
    L20:
        return true;
    }

    public int hashCode() {
        if (this.hasOcrText == false) goto L5;
        int r100 = 1231;
    L6:
        int r101 = r100 * 31;
        String r102 = this.ocrText;
        if (r102 != null) goto L9;
        int r103 = 0;
    L10:
        int r104 = (r101 + r103) * 31;
        long r105 = this.timestamp;
        int r106 = (r104 + ((int) (r105 ^ (r105 >>> 32)))) * 31;
        long r107 = this.videoFrameIndex;
        return r106 + ((int) (r107 ^ (r107 >>> 32)));
    L9:
        r103 = r102.hashCode();
        goto L10
    L5:
        r100 = 1237;
        goto L6
    }

    public String toString() {
        return "OMNIAVImageOcrInfo(hasOcrText=" + this.hasOcrText + ", ocrText=" + this.ocrText + ", timestamp=" + this.timestamp + ", videoFrameIndex=" + this.videoFrameIndex + ')';
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$omnisdk_av_release(OMNIAVImageOcrInfo r100, muc.d r101, f r110) {
        boolean r102 = false;
        if (r101.shouldEncodeElementDefault(r110, 0) == false) goto L6;
    L4:
        boolean r103 = true;
    L9:
        if (r103 == false) goto L12;
        r101.encodeBooleanElement(r110, 0, r100.hasOcrText);
    L12:
        if (r101.shouldEncodeElementDefault(r110, 1) == false) goto L15;
    L13:
        boolean r104 = true;
    L18:
        if (r104 == false) goto L21;
        r101.encodeNullableSerializableElement(r110, 1, v2.f520790a, r100.ocrText);
    L21:
        if (r101.shouldEncodeElementDefault(r110, 2) == false) goto L24;
    L22:
        boolean r105 = true;
    L27:
        if (r105 == false) goto L30;
        r101.encodeLongElement(r110, 2, r100.timestamp);
    L30:
        if (r101.shouldEncodeElementDefault(r110, 3) == false) goto L33;
    L31:
        r102 = true;
    L35:
        if (r102 == false) goto L38;
        r101.encodeLongElement(r110, 3, r100.videoFrameIndex);
        return;
    L38:
        return;
    L33:
        if (r100.videoFrameIndex == 0) goto L35;
    L24:
        if (r100.timestamp != 0) goto L22;
        r105 = false;
        goto L27
    L15:
        if (r100.ocrText != null) goto L13;
        r104 = false;
        goto L18
    L6:
        if (r100.hasOcrText == true) goto L4;
        r103 = false;
        goto L9
    }

    public OMNIAVImageOcrInfo(boolean r100, String r101, long r102, long r103) {
        this.hasOcrText = r100;
        this.ocrText = r101;
        this.timestamp = r102;
        this.videoFrameIndex = r103;
    }

    public /* synthetic */ OMNIAVImageOcrInfo(int r100, boolean r101, String r102, long r103, long r104, q2 r110) {
        if ((r100 & 0) == 0) goto L5;
        b2.b(r100, 0, OMNIAVImageOcrInfo$$serializer.INSTANCE.getDescriptor());
        throw null;
    L5:
        if ((r100 & 1) != 0) goto L7;
        this.hasOcrText = false;
    L9:
        if ((r100 & 2) != 0) goto L11;
        this.ocrText = null;
    L13:
        if ((r100 & 4) != 0) goto L15;
        this.timestamp = 0;
    L17:
        if ((r100 & 8) != 0) goto L19;
        this.videoFrameIndex = 0;
        return;
    L19:
        this.videoFrameIndex = r104;
        return;
    L15:
        this.timestamp = r103;
        goto L17
    L11:
        this.ocrText = r102;
        goto L13
    L7:
        this.hasOcrText = r101;
        goto L9
    }

    public /* synthetic */ OMNIAVImageOcrInfo(boolean r100, String r101, long r102, long r103, int r110, DefaultConstructorMarker r111) {
        if ((r110 & 1) == 0) goto L6;
        r100 = false;
    L6:
        if ((r110 & 2) == 0) goto L8;
        r101 = null;
    L8:
        String r112 = r101;
        long r104 = 0;
        if ((r110 & 4) == 0) goto L11;
        long r105 = 0;
    L13:
        if ((r110 & 8) != 0) goto L16;
        r104 = r103;
    L16:
        this(r100, r112, r105, r104);
        return;
    L11:
        r105 = r102;
        goto L13
    }
}
