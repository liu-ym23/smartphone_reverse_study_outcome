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
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\"\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 D2\u00060\u0001j\u0002`\u0002:\u0002CDBe\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0004\u0012\b\b\u0002\u0010\b\u001a\u00020\u0004\u0012\b\b\u0002\u0010\t\u001a\u00020\u0004\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000b\u0012\b\b\u0002\u0010\r\u001a\u00020\u000e¢\u0006\u0004\b\u000f\u0010\u0010Bg\b\u0010\u0012\u0006\u0010\u0011\u001a\u00020\u000e\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0004\u0012\u0006\u0010\b\u001a\u00020\u0004\u0012\u0006\u0010\t\u001a\u00020\u0004\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u000b\u0012\u0006\u0010\r\u001a\u00020\u000e\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013¢\u0006\u0004\b\u000f\u0010\u0014J\t\u0010+\u001a\u00020\u0004HÆ\u0003J\t\u0010,\u001a\u00020\u0004HÆ\u0003J\t\u0010-\u001a\u00020\u0004HÆ\u0003J\t\u0010.\u001a\u00020\u0004HÆ\u0003J\t\u0010/\u001a\u00020\u0004HÆ\u0003J\t\u00100\u001a\u00020\u0004HÆ\u0003J\u000b\u00101\u001a\u0004\u0018\u00010\u000bHÆ\u0003J\u000b\u00102\u001a\u0004\u0018\u00010\u000bHÆ\u0003J\t\u00103\u001a\u00020\u000eHÆ\u0003Jg\u00104\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u00042\b\b\u0002\u0010\u0007\u001a\u00020\u00042\b\b\u0002\u0010\b\u001a\u00020\u00042\b\b\u0002\u0010\t\u001a\u00020\u00042\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000b2\b\b\u0002\u0010\r\u001a\u00020\u000eHÆ\u0001J\u0013\u00105\u001a\u0002062\b\u00107\u001a\u0004\u0018\u000108HÖ\u0003J\t\u00109\u001a\u00020\u000eHÖ\u0001J\t\u0010:\u001a\u00020\u000bHÖ\u0001J%\u0010;\u001a\u00020<2\u0006\u0010=\u001a\u00020\u00002\u0006\u0010>\u001a\u00020?2\u0006\u0010@\u001a\u00020AH\u0001¢\u0006\u0002\bBR\u001c\u0010\u0003\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u001c\u0010\u0005\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0019\u0010\u0016\u001a\u0004\b\u001a\u0010\u0018R\u001c\u0010\u0006\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u001b\u0010\u0016\u001a\u0004\b\u001c\u0010\u0018R\u001c\u0010\u0007\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u001d\u0010\u0016\u001a\u0004\b\u001e\u0010\u0018R\u001c\u0010\b\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u001f\u0010\u0016\u001a\u0004\b \u0010\u0018R\u001c\u0010\t\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b!\u0010\u0016\u001a\u0004\b\"\u0010\u0018R\u001e\u0010\n\u001a\u0004\u0018\u00010\u000b8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b#\u0010\u0016\u001a\u0004\b$\u0010%R\u001e\u0010\f\u001a\u0004\u0018\u00010\u000b8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b&\u0010\u0016\u001a\u0004\b'\u0010%R\u001c\u0010\r\u001a\u00020\u000e8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b(\u0010\u0016\u001a\u0004\b)\u0010*¨\u0006E"}, d2 = {"Lcom/larus/im/internal/jni/bean/OMNIAVSpeechAECConfig;", "Ljava/io/Serializable;", "Lcom/flow/kmp/common/SerializableIO;", "srcSampleRate", "", "srcNumberChannel", "srcDepth", "refSampleRate", "refNumberChannel", "refDepth", "audioDumpPath", "", "modelPath", "frameMs", "", "<init>", "(JJJJJJLjava/lang/String;Ljava/lang/String;I)V", "seen0", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(IJJJJJJLjava/lang/String;Ljava/lang/String;ILkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getSrcSampleRate$annotations", "()V", "getSrcSampleRate", "()J", "getSrcNumberChannel$annotations", "getSrcNumberChannel", "getSrcDepth$annotations", "getSrcDepth", "getRefSampleRate$annotations", "getRefSampleRate", "getRefNumberChannel$annotations", "getRefNumberChannel", "getRefDepth$annotations", "getRefDepth", "getAudioDumpPath$annotations", "getAudioDumpPath", "()Ljava/lang/String;", "getModelPath$annotations", "getModelPath", "getFrameMs$annotations", "getFrameMs", "()I", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "", "other", "", "hashCode", "toString", "write$Self", "", "self", BdpAppEventConstant.PARAMS_OUTPUT, "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$omnisdk_av_release", "$serializer", "Companion", "omnisdk-av_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
@Serializable
public final class OMNIAVSpeechAECConfig implements java.io.Serializable {
    public static final Companion Companion = null;
    private final String audioDumpPath;
    private final int frameMs;
    private final String modelPath;
    private final long refDepth;
    private final long refNumberChannel;
    private final long refSampleRate;
    private final long srcDepth;
    private final long srcNumberChannel;
    private final long srcSampleRate;

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lcom/larus/im/internal/jni/bean/OMNIAVSpeechAECConfig$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/larus/im/internal/jni/bean/OMNIAVSpeechAECConfig;", "omnisdk-av_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }

        public final d<OMNIAVSpeechAECConfig> serializer() {
            return OMNIAVSpeechAECConfig$$serializer.INSTANCE;
        }
    }

    static {
        Companion = new Companion(null);
    }

    public OMNIAVSpeechAECConfig() {
        this(0, 0, 0, 0, 0, 0, null, null, 0, 511, null);
    }

    public static /* synthetic */ OMNIAVSpeechAECConfig copy$default(OMNIAVSpeechAECConfig r110, long r111, long r112, long r210, long r211, long r212, long r213, String r214, String r310, int r311, int r312, Object r313) {
        if ((r312 & 1) == 0) goto L5;
        long r100 = r110.srcSampleRate;
    L7:
        if ((r312 & 2) == 0) goto L9;
        long r101 = r110.srcNumberChannel;
    L11:
        if ((r312 & 4) == 0) goto L13;
        long r102 = r110.srcDepth;
    L15:
        if ((r312 & 8) == 0) goto L17;
        long r103 = r110.refSampleRate;
    L19:
        if ((r312 & 16) == 0) goto L21;
        long r113 = r110.refNumberChannel;
    L23:
        if ((r312 & 32) == 0) goto L25;
        long r114 = r110.refDepth;
    L27:
        if ((r312 & 64) == 0) goto L29;
        String r115 = r110.audioDumpPath;
    L31:
        if ((r312 & 128) == 0) goto L33;
        String r116 = r110.modelPath;
    L35:
        if ((r312 & 256) == 0) goto L37;
        int r104 = r110.frameMs;
    L39:
        return r110.copy(r100, r101, r102, r103, r113, r114, r115, r116, r104);
    L37:
        r104 = r311;
        goto L39
    L33:
        r116 = r310;
        goto L35
    L29:
        r115 = r214;
        goto L31
    L25:
        r114 = r213;
        goto L27
    L21:
        r113 = r212;
        goto L23
    L17:
        r103 = r211;
        goto L19
    L13:
        r102 = r210;
        goto L15
    L9:
        r101 = r112;
        goto L11
    L5:
        r100 = r111;
        goto L7
    }

    @SerialName("audio_dump_path")
    public static /* synthetic */ void getAudioDumpPath$annotations() {
    }

    @SerialName("frame_ms")
    public static /* synthetic */ void getFrameMs$annotations() {
    }

    @SerialName("model_path")
    public static /* synthetic */ void getModelPath$annotations() {
    }

    @SerialName("ref_depth")
    public static /* synthetic */ void getRefDepth$annotations() {
    }

    @SerialName("ref_number_channel")
    public static /* synthetic */ void getRefNumberChannel$annotations() {
    }

    @SerialName("ref_sample_rate")
    public static /* synthetic */ void getRefSampleRate$annotations() {
    }

    @SerialName("src_depth")
    public static /* synthetic */ void getSrcDepth$annotations() {
    }

    @SerialName("src_number_channel")
    public static /* synthetic */ void getSrcNumberChannel$annotations() {
    }

    @SerialName("src_sample_rate")
    public static /* synthetic */ void getSrcSampleRate$annotations() {
    }

    public final long component1() {
        return this.srcSampleRate;
    }

    public final long component2() {
        return this.srcNumberChannel;
    }

    public final long component3() {
        return this.srcDepth;
    }

    public final long component4() {
        return this.refSampleRate;
    }

    public final long component5() {
        return this.refNumberChannel;
    }

    public final long component6() {
        return this.refDepth;
    }

    public final String component7() {
        return this.audioDumpPath;
    }

    public final String component8() {
        return this.modelPath;
    }

    public final int component9() {
        return this.frameMs;
    }

    public final OMNIAVSpeechAECConfig copy(long r110, long r210, long r211, long r212, long r213, long r214, String r310, String r311, int r312) {
        return new OMNIAVSpeechAECConfig(r110, r210, r211, r212, r213, r214, r310, r311, r312);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof OMNIAVSpeechAECConfig) == true) goto L8;
        return false;
    L8:
        OMNIAVSpeechAECConfig r101 = (OMNIAVSpeechAECConfig) r100;
        if (this.srcSampleRate == r101.srcSampleRate) goto L12;
        return false;
    L12:
        if (this.srcNumberChannel == r101.srcNumberChannel) goto L15;
        return false;
    L15:
        if (this.srcDepth == r101.srcDepth) goto L18;
        return false;
    L18:
        if (this.refSampleRate == r101.refSampleRate) goto L21;
        return false;
    L21:
        if (this.refNumberChannel == r101.refNumberChannel) goto L24;
        return false;
    L24:
        if (this.refDepth == r101.refDepth) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.audioDumpPath, r101.audioDumpPath) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.modelPath, r101.modelPath) == true) goto L33;
        return false;
    L33:
        if (this.frameMs == r101.frameMs) goto L35;
        return false;
    L35:
        return true;
    }

    public int hashCode() {
        long r100 = this.srcSampleRate;
        int r101 = ((int) (r100 ^ (r100 >>> 32))) * 31;
        long r102 = this.srcNumberChannel;
        int r103 = (r101 + ((int) (r102 ^ (r102 >>> 32)))) * 31;
        long r104 = this.srcDepth;
        int r105 = (r103 + ((int) (r104 ^ (r104 >>> 32)))) * 31;
        long r106 = this.refSampleRate;
        int r107 = (r105 + ((int) (r106 ^ (r106 >>> 32)))) * 31;
        long r108 = this.refNumberChannel;
        int r109 = (r107 + ((int) (r108 ^ (r108 >>> 32)))) * 31;
        long r110 = this.refDepth;
        int r111 = (r109 + ((int) (r110 ^ (r110 >>> 32)))) * 31;
        String r112 = this.audioDumpPath;
        int r113 = 0;
        if (r112 != null) goto L5;
        int r114 = 0;
    L6:
        int r115 = (r111 + r114) * 31;
        String r116 = this.modelPath;
        if (r116 == null) goto L11;
        r113 = r116.hashCode();
    L11:
        return ((r115 + r113) * 31) + this.frameMs;
    L5:
        r114 = r112.hashCode();
        goto L6
    }

    public String toString() {
        return "OMNIAVSpeechAECConfig(srcSampleRate=" + this.srcSampleRate + ", srcNumberChannel=" + this.srcNumberChannel + ", srcDepth=" + this.srcDepth + ", refSampleRate=" + this.refSampleRate + ", refNumberChannel=" + this.refNumberChannel + ", refDepth=" + this.refDepth + ", audioDumpPath=" + this.audioDumpPath + ", modelPath=" + this.modelPath + ", frameMs=" + this.frameMs + ')';
    }

    public final String getAudioDumpPath() {
        return this.audioDumpPath;
    }

    public final int getFrameMs() {
        return this.frameMs;
    }

    public final String getModelPath() {
        return this.modelPath;
    }

    public final long getRefDepth() {
        return this.refDepth;
    }

    public final long getRefNumberChannel() {
        return this.refNumberChannel;
    }

    public final long getRefSampleRate() {
        return this.refSampleRate;
    }

    public final long getSrcDepth() {
        return this.srcDepth;
    }

    public final long getSrcNumberChannel() {
        return this.srcNumberChannel;
    }

    public final long getSrcSampleRate() {
        return this.srcSampleRate;
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$omnisdk_av_release(OMNIAVSpeechAECConfig r100, muc.d r101, f r110) {
        boolean r102 = false;
        if (r101.shouldEncodeElementDefault(r110, 0) == false) goto L6;
    L4:
        boolean r103 = true;
    L9:
        if (r103 == false) goto L12;
        r101.encodeLongElement(r110, 0, r100.srcSampleRate);
    L12:
        if (r101.shouldEncodeElementDefault(r110, 1) == false) goto L15;
    L13:
        boolean r104 = true;
    L18:
        if (r104 == false) goto L21;
        r101.encodeLongElement(r110, 1, r100.srcNumberChannel);
    L21:
        if (r101.shouldEncodeElementDefault(r110, 2) == false) goto L24;
    L22:
        boolean r105 = true;
    L27:
        if (r105 == false) goto L30;
        r101.encodeLongElement(r110, 2, r100.srcDepth);
    L30:
        if (r101.shouldEncodeElementDefault(r110, 3) == false) goto L33;
    L31:
        boolean r106 = true;
    L36:
        if (r106 == false) goto L39;
        r101.encodeLongElement(r110, 3, r100.refSampleRate);
    L39:
        if (r101.shouldEncodeElementDefault(r110, 4) == false) goto L42;
    L40:
        boolean r107 = true;
    L45:
        if (r107 == false) goto L48;
        r101.encodeLongElement(r110, 4, r100.refNumberChannel);
    L48:
        if (r101.shouldEncodeElementDefault(r110, 5) == false) goto L51;
    L49:
        boolean r108 = true;
    L54:
        if (r108 == false) goto L57;
        r101.encodeLongElement(r110, 5, r100.refDepth);
    L57:
        if (r101.shouldEncodeElementDefault(r110, 6) == false) goto L60;
    L58:
        boolean r109 = true;
    L63:
        if (r109 == false) goto L66;
        r101.encodeNullableSerializableElement(r110, 6, v2.f520790a, r100.audioDumpPath);
    L66:
        if (r101.shouldEncodeElementDefault(r110, 7) == false) goto L69;
    L67:
        boolean r111 = true;
    L72:
        if (r111 == false) goto L75;
        r101.encodeNullableSerializableElement(r110, 7, v2.f520790a, r100.modelPath);
    L75:
        if (r101.shouldEncodeElementDefault(r110, 8) == false) goto L78;
    L76:
        r102 = true;
    L80:
        if (r102 == false) goto L83;
        r101.encodeIntElement(r110, 8, r100.frameMs);
        return;
    L83:
        return;
    L78:
        if (r100.frameMs == 0) goto L80;
    L69:
        if (r100.modelPath != null) goto L67;
        r111 = false;
        goto L72
    L60:
        if (r100.audioDumpPath != null) goto L58;
        r109 = false;
        goto L63
    L51:
        if (r100.refDepth != 0) goto L49;
        r108 = false;
        goto L54
    L42:
        if (r100.refNumberChannel != 0) goto L40;
        r107 = false;
        goto L45
    L33:
        if (r100.refSampleRate != 0) goto L31;
        r106 = false;
        goto L36
    L24:
        if (r100.srcDepth != 0) goto L22;
        r105 = false;
        goto L27
    L15:
        if (r100.srcNumberChannel != 0) goto L13;
        r104 = false;
        goto L18
    L6:
        if (r100.srcSampleRate != 0) goto L4;
        r103 = false;
        goto L9
    }

    public OMNIAVSpeechAECConfig(long r100, long r101, long r102, long r103, long r104, long r110, String r111, String r112, int r113) {
        this.srcSampleRate = r100;
        this.srcNumberChannel = r101;
        this.srcDepth = r102;
        this.refSampleRate = r103;
        this.refNumberChannel = r104;
        this.refDepth = r110;
        this.audioDumpPath = r111;
        this.modelPath = r112;
        this.frameMs = r113;
    }

    public /* synthetic */ OMNIAVSpeechAECConfig(int r110, long r111, long r112, long r113, long r114, long r115, long r210, String r211, String r212, int r213, q2 r214) {
        if ((r110 & 0) != 0) goto L41;
        long r100 = 0;
        if ((r110 & 1) != 0) goto L7;
        this.srcSampleRate = 0;
    L9:
        if ((r110 & 2) != 0) goto L11;
        this.srcNumberChannel = 0;
    L13:
        if ((r110 & 4) != 0) goto L15;
        this.srcDepth = 0;
    L17:
        if ((r110 & 8) != 0) goto L19;
        this.refSampleRate = 0;
    L21:
        if ((r110 & 16) != 0) goto L23;
        this.refNumberChannel = 0;
    L25:
        if ((r110 & 32) == 0) goto L28;
        r100 = r210;
    L28:
        this.refDepth = r100;
        if ((r110 & 64) != 0) goto L31;
        this.audioDumpPath = null;
    L33:
        if ((r110 & 128) != 0) goto L35;
        this.modelPath = null;
    L37:
        if ((r110 & 256) != 0) goto L39;
        this.frameMs = 0;
        return;
    L39:
        this.frameMs = r213;
        return;
    L35:
        this.modelPath = r212;
        goto L37
    L31:
        this.audioDumpPath = r211;
        goto L33
    L23:
        this.refNumberChannel = r115;
        goto L25
    L19:
        this.refSampleRate = r114;
        goto L21
    L15:
        this.srcDepth = r113;
        goto L17
    L11:
        this.srcNumberChannel = r112;
        goto L13
    L7:
        this.srcSampleRate = r111;
        goto L9
    L41:
        b2.b(r110, 0, OMNIAVSpeechAECConfig$$serializer.INSTANCE.getDescriptor());
        throw null;
    }

    public /* synthetic */ OMNIAVSpeechAECConfig(long r110, long r111, long r210, long r211, long r212, long r213, String r214, String r310, int r311, int r312, DefaultConstructorMarker r313) {
        long r100 = 0;
        if ((r312 & 1) == 0) goto L5;
        long r101 = 0;
    L7:
        if ((r312 & 2) == 0) goto L9;
        long r102 = 0;
    L11:
        if ((r312 & 4) == 0) goto L13;
        long r103 = 0;
    L15:
        if ((r312 & 8) == 0) goto L17;
        long r112 = 0;
    L19:
        if ((r312 & 16) == 0) goto L21;
        long r113 = 0;
    L23:
        if ((r312 & 32) != 0) goto L26;
        r100 = r213;
    L26:
        String r114 = null;
        if ((r312 & 64) == 0) goto L29;
        String r104 = null;
    L31:
        if ((r312 & 128) != 0) goto L35;
        r114 = r310;
    L35:
        if ((r312 & 256) == 0) goto L37;
        int r105 = 0;
    L38:
        this(r101, r102, r103, r112, r113, r100, r104, r114, r105);
        return;
    L37:
        r105 = r311;
        goto L38
    L29:
        r104 = r214;
        goto L31
    L21:
        r113 = r212;
        goto L23
    L17:
        r112 = r211;
        goto L19
    L13:
        r103 = r210;
        goto L15
    L9:
        r102 = r111;
        goto L11
    L5:
        r101 = r110;
        goto L7
    }
}
