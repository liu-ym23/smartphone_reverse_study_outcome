package com.larus.im.internal.jni.bean;

import com.bytedance.android.livesdk.schema.AudienceGamePromoteDetailActionHandler;
import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import com.obric.sva.sdk.utils.InteractConst;
import com.ss.android.socialbase.appdownloader.util.parser.zip.UnixStat;
import de9.q1;
import de9.r1;
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
@Metadata(d1 = {"\u0000\u0080\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001d\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 I2\u00060\u0001j\u0002`\u0002:\u0002HIB\u0091\u0001\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0011\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0013\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0015\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u0017\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0019¢\u0006\u0004\b\u001a\u0010\u001bB\u0091\u0001\b\u0010\u0012\u0006\u0010\u001c\u001a\u00020\u001d\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\b\u0010\f\u001a\u0004\u0018\u00010\r\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013\u0012\u0006\u0010\u0014\u001a\u00020\u0015\u0012\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017\u0012\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019\u0012\b\u0010\u001e\u001a\u0004\u0018\u00010\u001f¢\u0006\u0004\b\u001a\u0010 J\t\u0010.\u001a\u00020\u0004HÆ\u0003J\u000b\u0010/\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u00100\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u00101\u001a\u0004\u0018\u00010\tHÆ\u0003J\u000b\u00102\u001a\u0004\u0018\u00010\u000bHÆ\u0003J\u000b\u00103\u001a\u0004\u0018\u00010\rHÆ\u0003J\u000b\u00104\u001a\u0004\u0018\u00010\u000fHÆ\u0003J\u000b\u00105\u001a\u0004\u0018\u00010\u0011HÆ\u0003J\u000b\u00106\u001a\u0004\u0018\u00010\u0013HÆ\u0003J\t\u00107\u001a\u00020\u0015HÆ\u0003J\t\u00108\u001a\u00020\u0017HÆ\u0003J\u000b\u00109\u001a\u0004\u0018\u00010\u0019HÆ\u0003J\u0093\u0001\u0010:\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00112\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00132\b\b\u0002\u0010\u0014\u001a\u00020\u00152\b\b\u0002\u0010\u0016\u001a\u00020\u00172\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0019HÆ\u0001J\u0013\u0010;\u001a\u00020\u00152\b\u0010<\u001a\u0004\u0018\u00010=HÖ\u0003J\t\u0010>\u001a\u00020\u001dHÖ\u0001J\t\u0010?\u001a\u00020\u0006HÖ\u0001J%\u0010@\u001a\u00020A2\u0006\u0010B\u001a\u00020\u00002\u0006\u0010C\u001a\u00020D2\u0006\u0010E\u001a\u00020FH\u0001¢\u0006\u0002\bGR\u0016\u0010\u0003\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u0012\u0004\b!\u0010\"R\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u0012\u0004\b#\u0010\"R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u0012\u0004\b$\u0010\"R\u0018\u0010\b\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u0012\u0004\b%\u0010\"R\u0018\u0010\n\u001a\u0004\u0018\u00010\u000b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u0012\u0004\b&\u0010\"R\u0018\u0010\f\u001a\u0004\u0018\u00010\r8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u0012\u0004\b'\u0010\"R\u0018\u0010\u000e\u001a\u0004\u0018\u00010\u000f8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u0012\u0004\b(\u0010\"R\u0018\u0010\u0010\u001a\u0004\u0018\u00010\u00118\u0006X\u0087\u0004¢\u0006\b\n\u0000\u0012\u0004\b)\u0010\"R\u0018\u0010\u0012\u001a\u0004\u0018\u00010\u00138\u0006X\u0087\u0004¢\u0006\b\n\u0000\u0012\u0004\b*\u0010\"R\u0016\u0010\u0014\u001a\u00020\u00158\u0006X\u0087\u0004¢\u0006\b\n\u0000\u0012\u0004\b+\u0010\"R\u0016\u0010\u0016\u001a\u00020\u00178\u0006X\u0087\u0004¢\u0006\b\n\u0000\u0012\u0004\b,\u0010\"R\u0018\u0010\u0018\u001a\u0004\u0018\u00010\u00198\u0006X\u0087\u0004¢\u0006\b\n\u0000\u0012\u0004\b-\u0010\"¨\u0006J"}, d2 = {"Lcom/larus/im/internal/jni/bean/OMNIAVSessionConfig;", "Ljava/io/Serializable;", "Lcom/flow/kmp/common/SerializableIO;", InteractConst.WAKEUP_SESSION_TYPE, "Lcom/larus/im/internal/jni/bean/OMNIAVSessionType;", "bizId", "", "streamApp", "quicConfig", "Lcom/larus/im/internal/jni/bean/OMNIAVSessionQuicConfig;", "audioConfig", "Lcom/larus/im/internal/jni/bean/OMNIAVSessionAudioConfig;", "videoConfig", "Lcom/larus/im/internal/jni/bean/OMNIAVSessionVideoConfig;", "dumpConfig", "Lcom/larus/im/internal/jni/bean/OMNIAVSessionDumpConfig;", "speechConfig", "Lcom/larus/im/internal/jni/bean/OMNIAVSessionSpeechConfig;", "rtcConfig", "Lcom/larus/im/internal/jni/bean/OMNIAVSessionRTCConfig;", "enableSenderPool", "", "sessionProfile", "Lcom/larus/im/internal/jni/bean/OMNIAVSessionProfile;", "mmtConfig", "Lcom/larus/im/internal/jni/bean/OMNIAVMMTInitConfig;", "<init>", "(Lcom/larus/im/internal/jni/bean/OMNIAVSessionType;Ljava/lang/String;Ljava/lang/String;Lcom/larus/im/internal/jni/bean/OMNIAVSessionQuicConfig;Lcom/larus/im/internal/jni/bean/OMNIAVSessionAudioConfig;Lcom/larus/im/internal/jni/bean/OMNIAVSessionVideoConfig;Lcom/larus/im/internal/jni/bean/OMNIAVSessionDumpConfig;Lcom/larus/im/internal/jni/bean/OMNIAVSessionSpeechConfig;Lcom/larus/im/internal/jni/bean/OMNIAVSessionRTCConfig;ZLcom/larus/im/internal/jni/bean/OMNIAVSessionProfile;Lcom/larus/im/internal/jni/bean/OMNIAVMMTInitConfig;)V", "seen0", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILcom/larus/im/internal/jni/bean/OMNIAVSessionType;Ljava/lang/String;Ljava/lang/String;Lcom/larus/im/internal/jni/bean/OMNIAVSessionQuicConfig;Lcom/larus/im/internal/jni/bean/OMNIAVSessionAudioConfig;Lcom/larus/im/internal/jni/bean/OMNIAVSessionVideoConfig;Lcom/larus/im/internal/jni/bean/OMNIAVSessionDumpConfig;Lcom/larus/im/internal/jni/bean/OMNIAVSessionSpeechConfig;Lcom/larus/im/internal/jni/bean/OMNIAVSessionRTCConfig;ZLcom/larus/im/internal/jni/bean/OMNIAVSessionProfile;Lcom/larus/im/internal/jni/bean/OMNIAVMMTInitConfig;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getSessionType$annotations", "()V", "getBizId$annotations", "getStreamApp$annotations", "getQuicConfig$annotations", "getAudioConfig$annotations", "getVideoConfig$annotations", "getDumpConfig$annotations", "getSpeechConfig$annotations", "getRtcConfig$annotations", "getEnableSenderPool$annotations", "getSessionProfile$annotations", "getMmtConfig$annotations", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "copy", "equals", "other", "", "hashCode", "toString", "write$Self", "", "self", BdpAppEventConstant.PARAMS_OUTPUT, "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$omnisdk_av_release", "$serializer", "Companion", "omnisdk-av_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
@Serializable
public final class OMNIAVSessionConfig implements java.io.Serializable {
    private static final Lazy<d<Object>>[] $childSerializers = null;
    public static final Companion Companion = null;
    public final OMNIAVSessionAudioConfig audioConfig;
    public final String bizId;
    public final OMNIAVSessionDumpConfig dumpConfig;
    public final boolean enableSenderPool;
    public final OMNIAVMMTInitConfig mmtConfig;
    public final OMNIAVSessionQuicConfig quicConfig;
    public final OMNIAVSessionRTCConfig rtcConfig;
    public final OMNIAVSessionProfile sessionProfile;
    public final OMNIAVSessionType sessionType;
    public final OMNIAVSessionSpeechConfig speechConfig;
    public final String streamApp;
    public final OMNIAVSessionVideoConfig videoConfig;

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lcom/larus/im/internal/jni/bean/OMNIAVSessionConfig$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/larus/im/internal/jni/bean/OMNIAVSessionConfig;", "omnisdk-av_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }

        public final d<OMNIAVSessionConfig> serializer() {
            return OMNIAVSessionConfig$$serializer.INSTANCE;
        }
    }

    public OMNIAVSessionConfig() {
        this(null, null, null, null, null, null, null, null, null, false, null, null, UnixStat.PERM_MASK, null);
    }

    private static final /* synthetic */ d _childSerializers$_anonymous_() {
        return OMNIAVSessionType.Companion.serializer();
    }

    private static final /* synthetic */ d _childSerializers$_anonymous_$0() {
        return OMNIAVSessionProfile.Companion.serializer();
    }

    public static /* synthetic */ d a() {
        return _childSerializers$_anonymous_();
    }

    public static /* synthetic */ d b() {
        return _childSerializers$_anonymous_$0();
    }

    public static /* synthetic */ OMNIAVSessionConfig copy$default(OMNIAVSessionConfig r110, OMNIAVSessionType r111, String r112, String r113, OMNIAVSessionQuicConfig r114, OMNIAVSessionAudioConfig r115, OMNIAVSessionVideoConfig r116, OMNIAVSessionDumpConfig r210, OMNIAVSessionSpeechConfig r211, OMNIAVSessionRTCConfig r212, boolean r213, OMNIAVSessionProfile r214, OMNIAVMMTInitConfig r215, int r216, Object r217) {
        if ((r216 & 1) == 0) goto L5;
        OMNIAVSessionType r100 = r110.sessionType;
    L7:
        if ((r216 & 2) == 0) goto L9;
        String r101 = r110.bizId;
    L11:
        if ((r216 & 4) == 0) goto L13;
        String r102 = r110.streamApp;
    L15:
        if ((r216 & 8) == 0) goto L17;
        OMNIAVSessionQuicConfig r103 = r110.quicConfig;
    L19:
        if ((r216 & 16) == 0) goto L21;
        OMNIAVSessionAudioConfig r104 = r110.audioConfig;
    L23:
        if ((r216 & 32) == 0) goto L25;
        OMNIAVSessionVideoConfig r105 = r110.videoConfig;
    L27:
        if ((r216 & 64) == 0) goto L29;
        OMNIAVSessionDumpConfig r106 = r110.dumpConfig;
    L31:
        if ((r216 & 128) == 0) goto L33;
        OMNIAVSessionSpeechConfig r107 = r110.speechConfig;
    L35:
        if ((r216 & 256) == 0) goto L37;
        OMNIAVSessionRTCConfig r117 = r110.rtcConfig;
    L39:
        if ((r216 & 512) == 0) goto L41;
        boolean r118 = r110.enableSenderPool;
    L43:
        if ((r216 & 1024) == 0) goto L45;
        OMNIAVSessionProfile r119 = r110.sessionProfile;
    L47:
        if ((r216 & 2048) == 0) goto L49;
        OMNIAVMMTInitConfig r108 = r110.mmtConfig;
    L51:
        return r110.copy(r100, r101, r102, r103, r104, r105, r106, r107, r117, r118, r119, r108);
    L49:
        r108 = r215;
        goto L51
    L45:
        r119 = r214;
        goto L47
    L41:
        r118 = r213;
        goto L43
    L37:
        r117 = r212;
        goto L39
    L33:
        r107 = r211;
        goto L35
    L29:
        r106 = r210;
        goto L31
    L25:
        r105 = r116;
        goto L27
    L21:
        r104 = r115;
        goto L23
    L17:
        r103 = r114;
        goto L19
    L13:
        r102 = r113;
        goto L15
    L9:
        r101 = r112;
        goto L11
    L5:
        r100 = r111;
        goto L7
    }

    @SerialName("audio_config")
    public static /* synthetic */ void getAudioConfig$annotations() {
    }

    @SerialName(AudienceGamePromoteDetailActionHandler.PARA_BIZ_ID)
    public static /* synthetic */ void getBizId$annotations() {
    }

    @SerialName("dump_config")
    public static /* synthetic */ void getDumpConfig$annotations() {
    }

    @SerialName("enable_sender_pool")
    public static /* synthetic */ void getEnableSenderPool$annotations() {
    }

    @SerialName("mmt_config")
    public static /* synthetic */ void getMmtConfig$annotations() {
    }

    @SerialName("quic_config")
    public static /* synthetic */ void getQuicConfig$annotations() {
    }

    @SerialName("rtc_config")
    public static /* synthetic */ void getRtcConfig$annotations() {
    }

    @SerialName("session_profile")
    public static /* synthetic */ void getSessionProfile$annotations() {
    }

    @SerialName("session_type")
    public static /* synthetic */ void getSessionType$annotations() {
    }

    @SerialName("speech_config")
    public static /* synthetic */ void getSpeechConfig$annotations() {
    }

    @SerialName("stream_app")
    public static /* synthetic */ void getStreamApp$annotations() {
    }

    @SerialName("video_config")
    public static /* synthetic */ void getVideoConfig$annotations() {
    }

    public final OMNIAVSessionType component1() {
        return this.sessionType;
    }

    public final boolean component10() {
        return this.enableSenderPool;
    }

    public final OMNIAVSessionProfile component11() {
        return this.sessionProfile;
    }

    public final OMNIAVMMTInitConfig component12() {
        return this.mmtConfig;
    }

    public final String component2() {
        return this.bizId;
    }

    public final String component3() {
        return this.streamApp;
    }

    public final OMNIAVSessionQuicConfig component4() {
        return this.quicConfig;
    }

    public final OMNIAVSessionAudioConfig component5() {
        return this.audioConfig;
    }

    public final OMNIAVSessionVideoConfig component6() {
        return this.videoConfig;
    }

    public final OMNIAVSessionDumpConfig component7() {
        return this.dumpConfig;
    }

    public final OMNIAVSessionSpeechConfig component8() {
        return this.speechConfig;
    }

    public final OMNIAVSessionRTCConfig component9() {
        return this.rtcConfig;
    }

    public final OMNIAVSessionConfig copy(OMNIAVSessionType r110, String r111, String r112, OMNIAVSessionQuicConfig r113, OMNIAVSessionAudioConfig r114, OMNIAVSessionVideoConfig r210, OMNIAVSessionDumpConfig r211, OMNIAVSessionSpeechConfig r212, OMNIAVSessionRTCConfig r213, boolean r214, OMNIAVSessionProfile r215, OMNIAVMMTInitConfig r216) {
        Intrinsics.checkNotNullParameter(r110, InteractConst.WAKEUP_SESSION_TYPE);
        Intrinsics.checkNotNullParameter(r215, "sessionProfile");
        return new OMNIAVSessionConfig(r110, r111, r112, r113, r114, r210, r211, r212, r213, r214, r215, r216);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof OMNIAVSessionConfig) == true) goto L8;
        return false;
    L8:
        OMNIAVSessionConfig r101 = (OMNIAVSessionConfig) r100;
        if (this.sessionType == r101.sessionType) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.bizId, r101.bizId) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.streamApp, r101.streamApp) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.quicConfig, r101.quicConfig) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.audioConfig, r101.audioConfig) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.videoConfig, r101.videoConfig) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.dumpConfig, r101.dumpConfig) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.speechConfig, r101.speechConfig) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.rtcConfig, r101.rtcConfig) == true) goto L36;
        return false;
    L36:
        if (this.enableSenderPool == r101.enableSenderPool) goto L39;
        return false;
    L39:
        if (this.sessionProfile == r101.sessionProfile) goto L42;
        return false;
    L42:
        if (Intrinsics.areEqual(this.mmtConfig, r101.mmtConfig) == true) goto L44;
        return false;
    L44:
        return true;
    }

    public int hashCode() {
        int r100 = this.sessionType.hashCode() * 31;
        String r101 = this.bizId;
        int r102 = 0;
        if (r101 != null) goto L5;
        int r103 = 0;
    L6:
        int r104 = (r100 + r103) * 31;
        String r105 = this.streamApp;
        if (r105 != null) goto L9;
        int r106 = 0;
    L10:
        int r107 = (r104 + r106) * 31;
        OMNIAVSessionQuicConfig r108 = this.quicConfig;
        if (r108 != null) goto L13;
        int r109 = 0;
    L14:
        int r110 = (r107 + r109) * 31;
        OMNIAVSessionAudioConfig r111 = this.audioConfig;
        if (r111 != null) goto L17;
        int r112 = 0;
    L18:
        int r113 = (r110 + r112) * 31;
        OMNIAVSessionVideoConfig r114 = this.videoConfig;
        if (r114 != null) goto L21;
        int r115 = 0;
    L22:
        int r116 = (r113 + r115) * 31;
        OMNIAVSessionDumpConfig r117 = this.dumpConfig;
        if (r117 != null) goto L25;
        int r118 = 0;
    L26:
        int r119 = (r116 + r118) * 31;
        OMNIAVSessionSpeechConfig r120 = this.speechConfig;
        if (r120 != null) goto L29;
        int r121 = 0;
    L30:
        int r122 = (r119 + r121) * 31;
        OMNIAVSessionRTCConfig r123 = this.rtcConfig;
        if (r123 != null) goto L33;
        int r124 = 0;
    L34:
        int r125 = (r122 + r124) * 31;
        if (this.enableSenderPool == false) goto L37;
        int r126 = 1231;
    L38:
        int r127 = (((r125 + r126) * 31) + this.sessionProfile.hashCode()) * 31;
        OMNIAVMMTInitConfig r128 = this.mmtConfig;
        if (r128 == null) goto L43;
        r102 = r128.hashCode();
    L43:
        return r127 + r102;
    L37:
        r126 = 1237;
        goto L38
    L33:
        r124 = r123.hashCode();
        goto L34
    L29:
        r121 = r120.hashCode();
        goto L30
    L25:
        r118 = r117.hashCode();
        goto L26
    L21:
        r115 = r114.hashCode();
        goto L22
    L17:
        r112 = r111.hashCode();
        goto L18
    L13:
        r109 = r108.hashCode();
        goto L14
    L9:
        r106 = r105.hashCode();
        goto L10
    L5:
        r103 = r101.hashCode();
        goto L6
    }

    public String toString() {
        return "OMNIAVSessionConfig(sessionType=" + this.sessionType + ", bizId=" + this.bizId + ", streamApp=" + this.streamApp + ", quicConfig=" + this.quicConfig + ", audioConfig=" + this.audioConfig + ", videoConfig=" + this.videoConfig + ", dumpConfig=" + this.dumpConfig + ", speechConfig=" + this.speechConfig + ", rtcConfig=" + this.rtcConfig + ", enableSenderPool=" + this.enableSenderPool + ", sessionProfile=" + this.sessionProfile + ", mmtConfig=" + this.mmtConfig + ')';
    }

    static {
        Companion = new Companion(null);
        LazyThreadSafetyMode r100 = LazyThreadSafetyMode.PUBLICATION;
        $childSerializers = new Lazy[]{LazyKt.lazy(r100, new q1()), null, null, null, null, null, null, null, null, null, LazyKt.lazy(r100, new r1()), null};
    }

    public static final /* synthetic */ Lazy[] access$get$childSerializers$cp() {
        return $childSerializers;
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$omnisdk_av_release(OMNIAVSessionConfig r100, muc.d r101, f r102) {
        Lazy<d<Object>>[] r103 = $childSerializers;
        boolean r104 = false;
        if (r101.shouldEncodeElementDefault(r102, 0) == false) goto L6;
    L4:
        boolean r105 = true;
    L9:
        if (r105 == false) goto L12;
        r101.encodeSerializableElement(r102, 0, r103[0].getValue(), r100.sessionType);
    L12:
        if (r101.shouldEncodeElementDefault(r102, 1) == false) goto L15;
    L13:
        boolean r106 = true;
    L18:
        if (r106 == false) goto L21;
        r101.encodeNullableSerializableElement(r102, 1, v2.f520790a, r100.bizId);
    L21:
        if (r101.shouldEncodeElementDefault(r102, 2) == false) goto L24;
    L22:
        boolean r107 = true;
    L27:
        if (r107 == false) goto L30;
        r101.encodeNullableSerializableElement(r102, 2, v2.f520790a, r100.streamApp);
    L30:
        if (r101.shouldEncodeElementDefault(r102, 3) == false) goto L33;
    L31:
        boolean r108 = true;
    L36:
        if (r108 == false) goto L39;
        r101.encodeNullableSerializableElement(r102, 3, OMNIAVSessionQuicConfig$$serializer.INSTANCE, r100.quicConfig);
    L39:
        if (r101.shouldEncodeElementDefault(r102, 4) == false) goto L42;
    L40:
        boolean r109 = true;
    L45:
        if (r109 == false) goto L48;
        r101.encodeNullableSerializableElement(r102, 4, OMNIAVSessionAudioConfig$$serializer.INSTANCE, r100.audioConfig);
    L48:
        if (r101.shouldEncodeElementDefault(r102, 5) == false) goto L51;
    L49:
        boolean r110 = true;
    L54:
        if (r110 == false) goto L57;
        r101.encodeNullableSerializableElement(r102, 5, OMNIAVSessionVideoConfig$$serializer.INSTANCE, r100.videoConfig);
    L57:
        if (r101.shouldEncodeElementDefault(r102, 6) == false) goto L60;
    L58:
        boolean r111 = true;
    L63:
        if (r111 == false) goto L66;
        r101.encodeNullableSerializableElement(r102, 6, OMNIAVSessionDumpConfig$$serializer.INSTANCE, r100.dumpConfig);
    L66:
        if (r101.shouldEncodeElementDefault(r102, 7) == false) goto L69;
    L67:
        boolean r112 = true;
    L72:
        if (r112 == false) goto L75;
        r101.encodeNullableSerializableElement(r102, 7, OMNIAVSessionSpeechConfig$$serializer.INSTANCE, r100.speechConfig);
    L75:
        if (r101.shouldEncodeElementDefault(r102, 8) == false) goto L78;
    L76:
        boolean r113 = true;
    L81:
        if (r113 == false) goto L84;
        r101.encodeNullableSerializableElement(r102, 8, OMNIAVSessionRTCConfig$$serializer.INSTANCE, r100.rtcConfig);
    L84:
        if (r101.shouldEncodeElementDefault(r102, 9) == false) goto L87;
    L85:
        boolean r114 = true;
    L90:
        if (r114 == false) goto L93;
        r101.encodeBooleanElement(r102, 9, r100.enableSenderPool);
    L93:
        if (r101.shouldEncodeElementDefault(r102, 10) == false) goto L96;
    L94:
        boolean r115 = true;
    L99:
        if (r115 == false) goto L102;
        r101.encodeSerializableElement(r102, 10, r103[10].getValue(), r100.sessionProfile);
    L102:
        if (r101.shouldEncodeElementDefault(r102, 11) == false) goto L105;
    L103:
        r104 = true;
    L107:
        if (r104 == false) goto L110;
        r101.encodeNullableSerializableElement(r102, 11, OMNIAVMMTInitConfig$$serializer.INSTANCE, r100.mmtConfig);
        return;
    L110:
        return;
    L105:
        if (r100.mmtConfig == null) goto L107;
    L96:
        if (r100.sessionProfile != OMNIAVSessionProfile.FULL_AV) goto L94;
        r115 = false;
        goto L99
    L87:
        if (r100.enableSenderPool == true) goto L85;
        r114 = false;
        goto L90
    L78:
        if (r100.rtcConfig != null) goto L76;
        r113 = false;
        goto L81
    L69:
        if (r100.speechConfig != null) goto L67;
        r112 = false;
        goto L72
    L60:
        if (r100.dumpConfig != null) goto L58;
        r111 = false;
        goto L63
    L51:
        if (r100.videoConfig != null) goto L49;
        r110 = false;
        goto L54
    L42:
        if (r100.audioConfig != null) goto L40;
        r109 = false;
        goto L45
    L33:
        if (r100.quicConfig != null) goto L31;
        r108 = false;
        goto L36
    L24:
        if (r100.streamApp != null) goto L22;
        r107 = false;
        goto L27
    L15:
        if (r100.bizId != null) goto L13;
        r106 = false;
        goto L18
    L6:
        if (r100.sessionType != OMNIAVSessionType.QUIC) goto L4;
        r105 = false;
        goto L9
    }

    public OMNIAVSessionConfig(OMNIAVSessionType r100, String r101, String r102, OMNIAVSessionQuicConfig r103, OMNIAVSessionAudioConfig r104, OMNIAVSessionVideoConfig r105, OMNIAVSessionDumpConfig r106, OMNIAVSessionSpeechConfig r107, OMNIAVSessionRTCConfig r110, boolean r111, OMNIAVSessionProfile r112, OMNIAVMMTInitConfig r113) {
        Intrinsics.checkNotNullParameter(r100, InteractConst.WAKEUP_SESSION_TYPE);
        Intrinsics.checkNotNullParameter(r112, "sessionProfile");
        this.sessionType = r100;
        this.bizId = r101;
        this.streamApp = r102;
        this.quicConfig = r103;
        this.audioConfig = r104;
        this.videoConfig = r105;
        this.dumpConfig = r106;
        this.speechConfig = r107;
        this.rtcConfig = r110;
        this.enableSenderPool = r111;
        this.sessionProfile = r112;
        this.mmtConfig = r113;
    }

    public /* synthetic */ OMNIAVSessionConfig(int r100, OMNIAVSessionType r101, String r102, String r103, OMNIAVSessionQuicConfig r110, OMNIAVSessionAudioConfig r111, OMNIAVSessionVideoConfig r112, OMNIAVSessionDumpConfig r113, OMNIAVSessionSpeechConfig r114, OMNIAVSessionRTCConfig r115, boolean r116, OMNIAVSessionProfile r117, OMNIAVMMTInitConfig r118, q2 r119) {
        if ((r100 & 0) == 0) goto L5;
        b2.b(r100, 0, OMNIAVSessionConfig$$serializer.INSTANCE.getDescriptor());
        throw null;
    L5:
        if ((r100 & 1) != 0) goto L7;
        OMNIAVSessionType r104 = OMNIAVSessionType.QUIC;
    L8:
        this.sessionType = r104;
        if ((r100 & 2) != 0) goto L11;
        this.bizId = null;
    L13:
        if ((r100 & 4) != 0) goto L15;
        this.streamApp = null;
    L17:
        if ((r100 & 8) != 0) goto L19;
        this.quicConfig = null;
    L21:
        if ((r100 & 16) != 0) goto L23;
        this.audioConfig = null;
    L25:
        if ((r100 & 32) != 0) goto L27;
        this.videoConfig = null;
    L29:
        if ((r100 & 64) != 0) goto L31;
        this.dumpConfig = null;
    L33:
        if ((r100 & 128) != 0) goto L35;
        this.speechConfig = null;
    L37:
        if ((r100 & 256) != 0) goto L39;
        this.rtcConfig = null;
    L41:
        if ((r100 & 512) != 0) goto L43;
        this.enableSenderPool = false;
    L45:
        if ((r100 & 1024) != 0) goto L47;
        OMNIAVSessionProfile r105 = OMNIAVSessionProfile.FULL_AV;
    L48:
        this.sessionProfile = r105;
        if ((r100 & 2048) != 0) goto L51;
        this.mmtConfig = null;
        return;
    L51:
        this.mmtConfig = r118;
        return;
    L47:
        r105 = r117;
        goto L48
    L43:
        this.enableSenderPool = r116;
        goto L45
    L39:
        this.rtcConfig = r115;
        goto L41
    L35:
        this.speechConfig = r114;
        goto L37
    L31:
        this.dumpConfig = r113;
        goto L33
    L27:
        this.videoConfig = r112;
        goto L29
    L23:
        this.audioConfig = r111;
        goto L25
    L19:
        this.quicConfig = r110;
        goto L21
    L15:
        this.streamApp = r103;
        goto L17
    L11:
        this.bizId = r102;
        goto L13
    L7:
        r104 = r101;
        goto L8
    }

    public /* synthetic */ OMNIAVSessionConfig(OMNIAVSessionType r110, String r111, String r112, OMNIAVSessionQuicConfig r113, OMNIAVSessionAudioConfig r114, OMNIAVSessionVideoConfig r115, OMNIAVSessionDumpConfig r210, OMNIAVSessionSpeechConfig r211, OMNIAVSessionRTCConfig r212, boolean r213, OMNIAVSessionProfile r214, OMNIAVMMTInitConfig r215, int r216, DefaultConstructorMarker r217) {
        if ((r216 & 1) == 0) goto L5;
        OMNIAVSessionType r100 = OMNIAVSessionType.QUIC;
    L6:
        OMNIAVMMTInitConfig r101 = null;
        if ((r216 & 2) == 0) goto L9;
        String r102 = null;
    L11:
        if ((r216 & 4) == 0) goto L13;
        String r103 = null;
    L15:
        if ((r216 & 8) == 0) goto L17;
        OMNIAVSessionQuicConfig r104 = null;
    L19:
        if ((r216 & 16) == 0) goto L21;
        OMNIAVSessionAudioConfig r105 = null;
    L23:
        if ((r216 & 32) == 0) goto L25;
        OMNIAVSessionVideoConfig r106 = null;
    L27:
        if ((r216 & 64) == 0) goto L29;
        OMNIAVSessionDumpConfig r107 = null;
    L31:
        if ((r216 & 128) == 0) goto L33;
        OMNIAVSessionSpeechConfig r108 = null;
    L35:
        if ((r216 & 256) == 0) goto L37;
        OMNIAVSessionRTCConfig r116 = null;
    L39:
        if ((r216 & 512) == 0) goto L41;
        boolean r117 = false;
    L43:
        if ((r216 & 1024) == 0) goto L45;
        OMNIAVSessionProfile r118 = OMNIAVSessionProfile.FULL_AV;
    L47:
        if ((r216 & 2048) != 0) goto L50;
        r101 = r215;
    L50:
        this(r100, r102, r103, r104, r105, r106, r107, r108, r116, r117, r118, r101);
        return;
    L45:
        r118 = r214;
        goto L47
    L41:
        r117 = r213;
        goto L43
    L37:
        r116 = r212;
        goto L39
    L33:
        r108 = r211;
        goto L35
    L29:
        r107 = r210;
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
        r100 = r110;
        goto L6
    }
}
