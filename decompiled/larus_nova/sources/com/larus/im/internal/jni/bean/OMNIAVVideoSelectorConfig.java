package com.larus.im.internal.jni.bean;

import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import com.bytedance.speech.speechengine.SpeechEngineDefines;
import com.facebook.keyframes.model.KFImage;
import juc.d;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.serialization.SerialName;
import kotlinx.serialization.Serializable;
import luc.f;
import nuc.b2;
import nuc.q2;

/* JADX INFO: loaded from: classes29.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 +2\u00060\u0001j\u0002`\u0002:\u0002*+B9\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0004\u0012\b\b\u0002\u0010\b\u001a\u00020\u0004¢\u0006\u0004\b\t\u0010\nBC\b\u0010\u0012\u0006\u0010\u000b\u001a\u00020\u0004\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0004\u0012\u0006\u0010\b\u001a\u00020\u0004\u0012\b\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\u0004\b\t\u0010\u000eJ\t\u0010\u0015\u001a\u00020\u0004HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0004HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0004HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0004HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0004HÆ\u0003J;\u0010\u001a\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u00042\b\b\u0002\u0010\u0007\u001a\u00020\u00042\b\b\u0002\u0010\b\u001a\u00020\u0004HÆ\u0001J\u0013\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eHÖ\u0003J\t\u0010\u001f\u001a\u00020\u0004HÖ\u0001J\t\u0010 \u001a\u00020!HÖ\u0001J%\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020\u00002\u0006\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020(H\u0001¢\u0006\u0002\b)R\u0016\u0010\u0003\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0005\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u0011\u0010\u0010R\u0016\u0010\u0006\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u0012\u0010\u0010R\u0016\u0010\u0007\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u0013\u0010\u0010R\u0016\u0010\b\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u0014\u0010\u0010¨\u0006,"}, d2 = {"Lcom/larus/im/internal/jni/bean/OMNIAVVideoSelectorConfig;", "Ljava/io/Serializable;", "Lcom/flow/kmp/common/SerializableIO;", "sampleRate", "", "maxDelay", "minInterval", "downsampleRatio", "frameRate", "<init>", "(IIIII)V", "seen0", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(IIIIIILkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getSampleRate$annotations", "()V", "getMaxDelay$annotations", "getMinInterval$annotations", "getDownsampleRatio$annotations", "getFrameRate$annotations", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "", "hashCode", "toString", "", "write$Self", "", "self", BdpAppEventConstant.PARAMS_OUTPUT, "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$omnisdk_av_release", "$serializer", "Companion", "omnisdk-av_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
@Serializable
public final class OMNIAVVideoSelectorConfig implements java.io.Serializable {
    public static final Companion Companion = null;
    public final int downsampleRatio;
    public final int frameRate;
    public final int maxDelay;
    public final int minInterval;
    public final int sampleRate;

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lcom/larus/im/internal/jni/bean/OMNIAVVideoSelectorConfig$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/larus/im/internal/jni/bean/OMNIAVVideoSelectorConfig;", "omnisdk-av_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }

        public final d<OMNIAVVideoSelectorConfig> serializer() {
            return OMNIAVVideoSelectorConfig$$serializer.INSTANCE;
        }
    }

    static {
        Companion = new Companion(null);
    }

    public OMNIAVVideoSelectorConfig() {
        this(0, 0, 0, 0, 0, 31, null);
    }

    public static /* synthetic */ OMNIAVVideoSelectorConfig copy$default(OMNIAVVideoSelectorConfig r100, int r101, int r102, int r103, int r104, int r105, int r106, Object r110) {
        if ((r106 & 1) == 0) goto L6;
        r101 = r100.sampleRate;
    L6:
        if ((r106 & 2) == 0) goto L8;
        r102 = r100.maxDelay;
    L8:
        int r111 = r102;
        if ((r106 & 4) == 0) goto L11;
        r103 = r100.minInterval;
    L11:
        int r107 = r103;
        if ((r106 & 8) == 0) goto L14;
        r104 = r100.downsampleRatio;
    L14:
        int r108 = r104;
        if ((r106 & 16) == 0) goto L17;
        r105 = r100.frameRate;
    L17:
        int r109 = r101;
        return r100.copy(r109, r111, r107, r108, r105);
    }

    @SerialName("downsample_ratio")
    public static /* synthetic */ void getDownsampleRatio$annotations() {
    }

    @SerialName(KFImage.FRAME_RATE_JSON_FIELD)
    public static /* synthetic */ void getFrameRate$annotations() {
    }

    @SerialName("max_delay")
    public static /* synthetic */ void getMaxDelay$annotations() {
    }

    @SerialName("min_interval")
    public static /* synthetic */ void getMinInterval$annotations() {
    }

    @SerialName(SpeechEngineDefines.PARAMS_KEY_SAMPLE_RATE_INT)
    public static /* synthetic */ void getSampleRate$annotations() {
    }

    public final int component1() {
        return this.sampleRate;
    }

    public final int component2() {
        return this.maxDelay;
    }

    public final int component3() {
        return this.minInterval;
    }

    public final int component4() {
        return this.downsampleRatio;
    }

    public final int component5() {
        return this.frameRate;
    }

    public final OMNIAVVideoSelectorConfig copy(int r100, int r101, int r110, int r111, int r112) {
        return new OMNIAVVideoSelectorConfig(r100, r101, r110, r111, r112);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof OMNIAVVideoSelectorConfig) == true) goto L8;
        return false;
    L8:
        OMNIAVVideoSelectorConfig r101 = (OMNIAVVideoSelectorConfig) r100;
        if (this.sampleRate == r101.sampleRate) goto L12;
        return false;
    L12:
        if (this.maxDelay == r101.maxDelay) goto L15;
        return false;
    L15:
        if (this.minInterval == r101.minInterval) goto L18;
        return false;
    L18:
        if (this.downsampleRatio == r101.downsampleRatio) goto L21;
        return false;
    L21:
        if (this.frameRate == r101.frameRate) goto L23;
        return false;
    L23:
        return true;
    }

    public int hashCode() {
        return (((((((this.sampleRate * 31) + this.maxDelay) * 31) + this.minInterval) * 31) + this.downsampleRatio) * 31) + this.frameRate;
    }

    public String toString() {
        return "OMNIAVVideoSelectorConfig(sampleRate=" + this.sampleRate + ", maxDelay=" + this.maxDelay + ", minInterval=" + this.minInterval + ", downsampleRatio=" + this.downsampleRatio + ", frameRate=" + this.frameRate + ')';
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$omnisdk_av_release(OMNIAVVideoSelectorConfig r100, muc.d r101, f r102) {
        boolean r103 = false;
        if (r101.shouldEncodeElementDefault(r102, 0) == false) goto L6;
    L4:
        boolean r104 = true;
    L9:
        if (r104 == false) goto L12;
        r101.encodeIntElement(r102, 0, r100.sampleRate);
    L12:
        if (r101.shouldEncodeElementDefault(r102, 1) == false) goto L15;
    L13:
        boolean r105 = true;
    L18:
        if (r105 == false) goto L21;
        r101.encodeIntElement(r102, 1, r100.maxDelay);
    L21:
        if (r101.shouldEncodeElementDefault(r102, 2) == false) goto L24;
    L22:
        boolean r106 = true;
    L27:
        if (r106 == false) goto L30;
        r101.encodeIntElement(r102, 2, r100.minInterval);
    L30:
        if (r101.shouldEncodeElementDefault(r102, 3) == false) goto L33;
    L31:
        boolean r107 = true;
    L36:
        if (r107 == false) goto L39;
        r101.encodeIntElement(r102, 3, r100.downsampleRatio);
    L39:
        if (r101.shouldEncodeElementDefault(r102, 4) == false) goto L42;
    L40:
        r103 = true;
    L44:
        if (r103 == false) goto L47;
        r101.encodeIntElement(r102, 4, r100.frameRate);
        return;
    L47:
        return;
    L42:
        if (r100.frameRate == 0) goto L44;
    L33:
        if (r100.downsampleRatio != 0) goto L31;
        r107 = false;
        goto L36
    L24:
        if (r100.minInterval != 0) goto L22;
        r106 = false;
        goto L27
    L15:
        if (r100.maxDelay != 0) goto L13;
        r105 = false;
        goto L18
    L6:
        if (r100.sampleRate != 0) goto L4;
        r104 = false;
        goto L9
    }

    public OMNIAVVideoSelectorConfig(int r100, int r101, int r102, int r103, int r104) {
        this.sampleRate = r100;
        this.maxDelay = r101;
        this.minInterval = r102;
        this.downsampleRatio = r103;
        this.frameRate = r104;
    }

    public /* synthetic */ OMNIAVVideoSelectorConfig(int r100, int r101, int r102, int r103, int r104, int r105, q2 r106) {
        if ((r100 & 0) == 0) goto L5;
        b2.b(r100, 0, OMNIAVVideoSelectorConfig$$serializer.INSTANCE.getDescriptor());
        throw null;
    L5:
        if ((r100 & 1) != 0) goto L7;
        this.sampleRate = 0;
    L9:
        if ((r100 & 2) != 0) goto L11;
        this.maxDelay = 0;
    L13:
        if ((r100 & 4) != 0) goto L15;
        this.minInterval = 0;
    L17:
        if ((r100 & 8) != 0) goto L19;
        this.downsampleRatio = 0;
    L21:
        if ((r100 & 16) != 0) goto L23;
        this.frameRate = 0;
        return;
    L23:
        this.frameRate = r105;
        return;
    L19:
        this.downsampleRatio = r104;
        goto L21
    L15:
        this.minInterval = r103;
        goto L17
    L11:
        this.maxDelay = r102;
        goto L13
    L7:
        this.sampleRate = r101;
        goto L9
    }

    public /* synthetic */ OMNIAVVideoSelectorConfig(int r100, int r101, int r102, int r103, int r104, int r110, DefaultConstructorMarker r111) {
        if ((r110 & 1) == 0) goto L5;
        int r112 = 0;
    L7:
        if ((r110 & 2) == 0) goto L9;
        int r105 = 0;
    L11:
        if ((r110 & 4) == 0) goto L13;
        int r106 = 0;
    L15:
        if ((r110 & 8) == 0) goto L17;
        int r107 = 0;
    L19:
        if ((r110 & 16) == 0) goto L21;
        int r113 = 0;
    L22:
        this(r112, r105, r106, r107, r113);
        return;
    L21:
        r113 = r104;
        goto L22
    L17:
        r107 = r103;
        goto L19
    L13:
        r106 = r102;
        goto L15
    L9:
        r105 = r101;
        goto L11
    L5:
        r112 = r100;
        goto L7
    }
}
