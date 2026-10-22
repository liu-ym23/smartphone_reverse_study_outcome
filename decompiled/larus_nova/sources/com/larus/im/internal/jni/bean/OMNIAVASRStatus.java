package com.larus.im.internal.jni.bean;

import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
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
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 42\u00060\u0001j\u0002`\u0002:\u000234BW\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0004\u0012\b\b\u0002\u0010\b\u001a\u00020\u0004\u0012\b\b\u0002\u0010\t\u001a\u00020\u0004\u0012\b\b\u0002\u0010\n\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0004¢\u0006\u0004\b\f\u0010\rB[\b\u0010\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0004\u0012\u0006\u0010\b\u001a\u00020\u0004\u0012\u0006\u0010\t\u001a\u00020\u0004\u0012\u0006\u0010\n\u001a\u00020\u0004\u0012\u0006\u0010\u000b\u001a\u00020\u0004\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011¢\u0006\u0004\b\f\u0010\u0012J\t\u0010\u001c\u001a\u00020\u0004HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0004HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0004HÆ\u0003J\t\u0010\u001f\u001a\u00020\u0004HÆ\u0003J\t\u0010 \u001a\u00020\u0004HÆ\u0003J\t\u0010!\u001a\u00020\u0004HÆ\u0003J\t\u0010\"\u001a\u00020\u0004HÆ\u0003J\t\u0010#\u001a\u00020\u0004HÆ\u0003JY\u0010$\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u00042\b\b\u0002\u0010\u0007\u001a\u00020\u00042\b\b\u0002\u0010\b\u001a\u00020\u00042\b\b\u0002\u0010\t\u001a\u00020\u00042\b\b\u0002\u0010\n\u001a\u00020\u00042\b\b\u0002\u0010\u000b\u001a\u00020\u0004HÆ\u0001J\u0013\u0010%\u001a\u00020\u00042\b\u0010&\u001a\u0004\u0018\u00010'HÖ\u0003J\t\u0010(\u001a\u00020\u000fHÖ\u0001J\t\u0010)\u001a\u00020*HÖ\u0001J%\u0010+\u001a\u00020,2\u0006\u0010-\u001a\u00020\u00002\u0006\u0010.\u001a\u00020/2\u0006\u00100\u001a\u000201H\u0001¢\u0006\u0002\b2R\u0016\u0010\u0003\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0005\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u0015\u0010\u0014R\u0016\u0010\u0006\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u0016\u0010\u0014R\u0016\u0010\u0007\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u0017\u0010\u0014R\u0016\u0010\b\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u0018\u0010\u0014R\u0016\u0010\t\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u0019\u0010\u0014R\u0016\u0010\n\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u001a\u0010\u0014R\u0016\u0010\u000b\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u001b\u0010\u0014¨\u00065"}, d2 = {"Lcom/larus/im/internal/jni/bean/OMNIAVASRStatus;", "Ljava/io/Serializable;", "Lcom/flow/kmp/common/SerializableIO;", "isDenoiseFeatureEnable", "", "isFeatLearningDone", "isFeatLearningEnable", "checkAudioSnr", "tooLongSv", "needEndAsr", "withImage", "withOcr", "<init>", "(ZZZZZZZZ)V", "seen0", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(IZZZZZZZZLkotlinx/serialization/internal/SerializationConstructorMarker;)V", "isDenoiseFeatureEnable$annotations", "()V", "isFeatLearningDone$annotations", "isFeatLearningEnable$annotations", "getCheckAudioSnr$annotations", "getTooLongSv$annotations", "getNeedEndAsr$annotations", "getWithImage$annotations", "getWithOcr$annotations", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "equals", "other", "", "hashCode", "toString", "", "write$Self", "", "self", BdpAppEventConstant.PARAMS_OUTPUT, "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$omnisdk_av_release", "$serializer", "Companion", "omnisdk-av_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
@Serializable
public final class OMNIAVASRStatus implements java.io.Serializable {
    public static final Companion Companion = null;
    public final boolean checkAudioSnr;
    public final boolean isDenoiseFeatureEnable;
    public final boolean isFeatLearningDone;
    public final boolean isFeatLearningEnable;
    public final boolean needEndAsr;
    public final boolean tooLongSv;
    public final boolean withImage;
    public final boolean withOcr;

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lcom/larus/im/internal/jni/bean/OMNIAVASRStatus$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/larus/im/internal/jni/bean/OMNIAVASRStatus;", "omnisdk-av_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }

        public final d<OMNIAVASRStatus> serializer() {
            return OMNIAVASRStatus$$serializer.INSTANCE;
        }
    }

    static {
        Companion = new Companion(null);
    }

    public OMNIAVASRStatus() {
        this(false, false, false, false, false, false, false, false, 255, null);
    }

    public static /* synthetic */ OMNIAVASRStatus copy$default(OMNIAVASRStatus r100, boolean r110, boolean r111, boolean r112, boolean r113, boolean r114, boolean r115, boolean r116, boolean r117, int r118, Object r119) {
        if ((r118 & 1) == 0) goto L5;
        boolean r101 = r100.isDenoiseFeatureEnable;
    L7:
        if ((r118 & 2) == 0) goto L9;
        boolean r102 = r100.isFeatLearningDone;
    L11:
        if ((r118 & 4) == 0) goto L13;
        boolean r103 = r100.isFeatLearningEnable;
    L15:
        if ((r118 & 8) == 0) goto L17;
        boolean r104 = r100.checkAudioSnr;
    L19:
        if ((r118 & 16) == 0) goto L21;
        boolean r105 = r100.tooLongSv;
    L23:
        if ((r118 & 32) == 0) goto L25;
        boolean r106 = r100.needEndAsr;
    L27:
        if ((r118 & 64) == 0) goto L29;
        boolean r107 = r100.withImage;
    L31:
        if ((r118 & 128) == 0) goto L33;
        boolean r108 = r100.withOcr;
    L35:
        return r100.copy(r101, r102, r103, r104, r105, r106, r107, r108);
    L33:
        r108 = r117;
        goto L35
    L29:
        r107 = r116;
        goto L31
    L25:
        r106 = r115;
        goto L27
    L21:
        r105 = r114;
        goto L23
    L17:
        r104 = r113;
        goto L19
    L13:
        r103 = r112;
        goto L15
    L9:
        r102 = r111;
        goto L11
    L5:
        r101 = r110;
        goto L7
    }

    @SerialName("check_audio_snr")
    public static /* synthetic */ void getCheckAudioSnr$annotations() {
    }

    @SerialName("need_end_asr")
    public static /* synthetic */ void getNeedEndAsr$annotations() {
    }

    @SerialName("too_long_sv")
    public static /* synthetic */ void getTooLongSv$annotations() {
    }

    @SerialName("with_image")
    public static /* synthetic */ void getWithImage$annotations() {
    }

    @SerialName("with_ocr")
    public static /* synthetic */ void getWithOcr$annotations() {
    }

    @SerialName("is_denoise_feature_enable")
    public static /* synthetic */ void isDenoiseFeatureEnable$annotations() {
    }

    @SerialName("is_feat_learning_done")
    public static /* synthetic */ void isFeatLearningDone$annotations() {
    }

    @SerialName("is_feat_learning_enable")
    public static /* synthetic */ void isFeatLearningEnable$annotations() {
    }

    public final boolean component1() {
        return this.isDenoiseFeatureEnable;
    }

    public final boolean component2() {
        return this.isFeatLearningDone;
    }

    public final boolean component3() {
        return this.isFeatLearningEnable;
    }

    public final boolean component4() {
        return this.checkAudioSnr;
    }

    public final boolean component5() {
        return this.tooLongSv;
    }

    public final boolean component6() {
        return this.needEndAsr;
    }

    public final boolean component7() {
        return this.withImage;
    }

    public final boolean component8() {
        return this.withOcr;
    }

    public final OMNIAVASRStatus copy(boolean r110, boolean r111, boolean r112, boolean r113, boolean r114, boolean r115, boolean r116, boolean r117) {
        return new OMNIAVASRStatus(r110, r111, r112, r113, r114, r115, r116, r117);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof OMNIAVASRStatus) == true) goto L8;
        return false;
    L8:
        OMNIAVASRStatus r101 = (OMNIAVASRStatus) r100;
        if (this.isDenoiseFeatureEnable == r101.isDenoiseFeatureEnable) goto L12;
        return false;
    L12:
        if (this.isFeatLearningDone == r101.isFeatLearningDone) goto L15;
        return false;
    L15:
        if (this.isFeatLearningEnable == r101.isFeatLearningEnable) goto L18;
        return false;
    L18:
        if (this.checkAudioSnr == r101.checkAudioSnr) goto L21;
        return false;
    L21:
        if (this.tooLongSv == r101.tooLongSv) goto L24;
        return false;
    L24:
        if (this.needEndAsr == r101.needEndAsr) goto L27;
        return false;
    L27:
        if (this.withImage == r101.withImage) goto L30;
        return false;
    L30:
        if (this.withOcr == r101.withOcr) goto L32;
        return false;
    L32:
        return true;
    }

    public int hashCode() {
        int r100 = 1231;
        if (this.isDenoiseFeatureEnable == false) goto L5;
        int r101 = 1231;
    L6:
        int r102 = r101 * 31;
        if (this.isFeatLearningDone == false) goto L9;
        int r103 = 1231;
    L10:
        int r104 = (r102 + r103) * 31;
        if (this.isFeatLearningEnable == false) goto L13;
        int r105 = 1231;
    L14:
        int r106 = (r104 + r105) * 31;
        if (this.checkAudioSnr == false) goto L17;
        int r107 = 1231;
    L18:
        int r108 = (r106 + r107) * 31;
        if (this.tooLongSv == false) goto L21;
        int r109 = 1231;
    L22:
        int r110 = (r108 + r109) * 31;
        if (this.needEndAsr == false) goto L25;
        int r111 = 1231;
    L26:
        int r112 = (r110 + r111) * 31;
        if (this.withImage == false) goto L29;
        int r113 = 1231;
    L30:
        int r114 = (r112 + r113) * 31;
        if (this.withOcr == true) goto L35;
        r100 = 1237;
    L35:
        return r114 + r100;
    L29:
        r113 = 1237;
        goto L30
    L25:
        r111 = 1237;
        goto L26
    L21:
        r109 = 1237;
        goto L22
    L17:
        r107 = 1237;
        goto L18
    L13:
        r105 = 1237;
        goto L14
    L9:
        r103 = 1237;
        goto L10
    L5:
        r101 = 1237;
        goto L6
    }

    public String toString() {
        return "OMNIAVASRStatus(isDenoiseFeatureEnable=" + this.isDenoiseFeatureEnable + ", isFeatLearningDone=" + this.isFeatLearningDone + ", isFeatLearningEnable=" + this.isFeatLearningEnable + ", checkAudioSnr=" + this.checkAudioSnr + ", tooLongSv=" + this.tooLongSv + ", needEndAsr=" + this.needEndAsr + ", withImage=" + this.withImage + ", withOcr=" + this.withOcr + ')';
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$omnisdk_av_release(OMNIAVASRStatus r100, muc.d r101, f r102) {
        boolean r103 = false;
        if (r101.shouldEncodeElementDefault(r102, 0) == false) goto L6;
    L4:
        boolean r104 = true;
    L9:
        if (r104 == false) goto L12;
        r101.encodeBooleanElement(r102, 0, r100.isDenoiseFeatureEnable);
    L12:
        if (r101.shouldEncodeElementDefault(r102, 1) == false) goto L15;
    L13:
        boolean r105 = true;
    L18:
        if (r105 == false) goto L21;
        r101.encodeBooleanElement(r102, 1, r100.isFeatLearningDone);
    L21:
        if (r101.shouldEncodeElementDefault(r102, 2) == false) goto L24;
    L22:
        boolean r106 = true;
    L27:
        if (r106 == false) goto L30;
        r101.encodeBooleanElement(r102, 2, r100.isFeatLearningEnable);
    L30:
        if (r101.shouldEncodeElementDefault(r102, 3) == false) goto L33;
    L31:
        boolean r107 = true;
    L36:
        if (r107 == false) goto L39;
        r101.encodeBooleanElement(r102, 3, r100.checkAudioSnr);
    L39:
        if (r101.shouldEncodeElementDefault(r102, 4) == false) goto L42;
    L40:
        boolean r108 = true;
    L45:
        if (r108 == false) goto L48;
        r101.encodeBooleanElement(r102, 4, r100.tooLongSv);
    L48:
        if (r101.shouldEncodeElementDefault(r102, 5) == false) goto L51;
    L49:
        boolean r109 = true;
    L54:
        if (r109 == false) goto L57;
        r101.encodeBooleanElement(r102, 5, r100.needEndAsr);
    L57:
        if (r101.shouldEncodeElementDefault(r102, 6) == false) goto L60;
    L58:
        boolean r110 = true;
    L63:
        if (r110 == false) goto L66;
        r101.encodeBooleanElement(r102, 6, r100.withImage);
    L66:
        if (r101.shouldEncodeElementDefault(r102, 7) == false) goto L69;
    L67:
        r103 = true;
    L71:
        if (r103 == false) goto L74;
        r101.encodeBooleanElement(r102, 7, r100.withOcr);
        return;
    L74:
        return;
    L69:
        if (r100.withOcr == false) goto L71;
    L60:
        if (r100.withImage == true) goto L58;
        r110 = false;
        goto L63
    L51:
        if (r100.needEndAsr == true) goto L49;
        r109 = false;
        goto L54
    L42:
        if (r100.tooLongSv == true) goto L40;
        r108 = false;
        goto L45
    L33:
        if (r100.checkAudioSnr == true) goto L31;
        r107 = false;
        goto L36
    L24:
        if (r100.isFeatLearningEnable == true) goto L22;
        r106 = false;
        goto L27
    L15:
        if (r100.isFeatLearningDone == true) goto L13;
        r105 = false;
        goto L18
    L6:
        if (r100.isDenoiseFeatureEnable == true) goto L4;
        r104 = false;
        goto L9
    }

    public OMNIAVASRStatus(boolean r100, boolean r101, boolean r102, boolean r103, boolean r104, boolean r105, boolean r106, boolean r107) {
        this.isDenoiseFeatureEnable = r100;
        this.isFeatLearningDone = r101;
        this.isFeatLearningEnable = r102;
        this.checkAudioSnr = r103;
        this.tooLongSv = r104;
        this.needEndAsr = r105;
        this.withImage = r106;
        this.withOcr = r107;
    }

    public /* synthetic */ OMNIAVASRStatus(int r100, boolean r101, boolean r102, boolean r103, boolean r104, boolean r105, boolean r106, boolean r107, boolean r110, q2 r111) {
        if ((r100 & 0) == 0) goto L5;
        b2.b(r100, 0, OMNIAVASRStatus$$serializer.INSTANCE.getDescriptor());
        throw null;
    L5:
        if ((r100 & 1) != 0) goto L7;
        this.isDenoiseFeatureEnable = false;
    L9:
        if ((r100 & 2) != 0) goto L11;
        this.isFeatLearningDone = false;
    L13:
        if ((r100 & 4) != 0) goto L15;
        this.isFeatLearningEnable = false;
    L17:
        if ((r100 & 8) != 0) goto L19;
        this.checkAudioSnr = false;
    L21:
        if ((r100 & 16) != 0) goto L23;
        this.tooLongSv = false;
    L25:
        if ((r100 & 32) != 0) goto L27;
        this.needEndAsr = false;
    L29:
        if ((r100 & 64) != 0) goto L31;
        this.withImage = false;
    L33:
        if ((r100 & 128) != 0) goto L35;
        this.withOcr = false;
        return;
    L35:
        this.withOcr = r110;
        return;
    L31:
        this.withImage = r107;
        goto L33
    L27:
        this.needEndAsr = r106;
        goto L29
    L23:
        this.tooLongSv = r105;
        goto L25
    L19:
        this.checkAudioSnr = r104;
        goto L21
    L15:
        this.isFeatLearningEnable = r103;
        goto L17
    L11:
        this.isFeatLearningDone = r102;
        goto L13
    L7:
        this.isDenoiseFeatureEnable = r101;
        goto L9
    }

    public /* synthetic */ OMNIAVASRStatus(boolean r110, boolean r111, boolean r112, boolean r113, boolean r114, boolean r115, boolean r116, boolean r117, int r118, DefaultConstructorMarker r119) {
        boolean r100 = false;
        if ((r118 & 1) == 0) goto L5;
        boolean r101 = false;
    L7:
        if ((r118 & 2) == 0) goto L9;
        boolean r102 = false;
    L11:
        if ((r118 & 4) == 0) goto L13;
        boolean r103 = false;
    L15:
        if ((r118 & 8) == 0) goto L17;
        boolean r104 = false;
    L19:
        if ((r118 & 16) == 0) goto L21;
        boolean r105 = false;
    L23:
        if ((r118 & 32) == 0) goto L25;
        boolean r106 = false;
    L27:
        if ((r118 & 64) == 0) goto L29;
        boolean r107 = false;
    L31:
        if ((r118 & 128) != 0) goto L34;
        r100 = r117;
    L34:
        this(r101, r102, r103, r104, r105, r106, r107, r100);
        return;
    L29:
        r107 = r116;
        goto L31
    L25:
        r106 = r115;
        goto L27
    L21:
        r105 = r114;
        goto L23
    L17:
        r104 = r113;
        goto L19
    L13:
        r103 = r112;
        goto L15
    L9:
        r102 = r111;
        goto L11
    L5:
        r101 = r110;
        goto L7
    }
}
