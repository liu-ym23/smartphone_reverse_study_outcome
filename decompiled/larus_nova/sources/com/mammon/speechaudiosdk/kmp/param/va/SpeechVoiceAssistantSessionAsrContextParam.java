package com.mammon.speechaudiosdk.kmp.param.va;

import com.autonavi.amap.mapcore.AMapEngineUtils;
import com.heytap.mcssdk.constant.b;
import com.larus.dora.obric.device_management.device_home.DoraObricDeviceHomeViewModel;
import com.mammon.speechaudiosdk.kmp.param.SpeechAudioConfigParam;
import com.mammon.speechaudiosdk.kmp.type.SpeechAudioTokenType;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes32.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\bK\b\u0086\b\u0018\u00002\u00020\u0001BÇ\u0002\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\r\u001a\u00020\u000e\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u000e\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u000e\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u000e\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u000e\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u000e\u0012\b\b\u0002\u0010\u0017\u001a\u00020\u0018\u0012\b\b\u0002\u0010\u0019\u001a\u00020\u000e\u0012\b\b\u0002\u0010\u001a\u001a\u00020\u000e\u0012\b\b\u0002\u0010\u001b\u001a\u00020\u000e\u0012\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u001d\u001a\u00020\u001e\u0012\b\b\u0002\u0010\u001f\u001a\u00020\u000e\u0012\b\b\u0002\u0010 \u001a\u00020\u000e\u0012\b\b\u0002\u0010!\u001a\u00020\u000e\u0012\u0010\b\u0002\u0010\"\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010#\u0012\b\b\u0002\u0010$\u001a\u00020\u000e\u0012\b\b\u0002\u0010%\u001a\u00020\u000e¢\u0006\u0004\b&\u0010'J\t\u0010L\u001a\u00020\u0003HÆ\u0003J\u000b\u0010M\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010N\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010O\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010P\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010Q\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010R\u001a\u0004\u0018\u00010\u000bHÆ\u0003J\u000b\u0010S\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010T\u001a\u00020\u000eHÆ\u0003J\u000b\u0010U\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010V\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010W\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010X\u001a\u00020\u000eHÆ\u0003J\t\u0010Y\u001a\u00020\u000eHÆ\u0003J\t\u0010Z\u001a\u00020\u000eHÆ\u0003J\t\u0010[\u001a\u00020\u000eHÆ\u0003J\t\u0010\\\u001a\u00020\u000eHÆ\u0003J\t\u0010]\u001a\u00020\u0018HÆ\u0003J\t\u0010^\u001a\u00020\u000eHÆ\u0003J\t\u0010_\u001a\u00020\u000eHÆ\u0003J\t\u0010`\u001a\u00020\u000eHÆ\u0003J\u000b\u0010a\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010b\u001a\u00020\u001eHÆ\u0003J\t\u0010c\u001a\u00020\u000eHÆ\u0003J\t\u0010d\u001a\u00020\u000eHÆ\u0003J\t\u0010e\u001a\u00020\u000eHÆ\u0003J\u0011\u0010f\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010#HÆ\u0003J\t\u0010g\u001a\u00020\u000eHÆ\u0003J\t\u0010h\u001a\u00020\u000eHÆ\u0003JÉ\u0002\u0010i\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\r\u001a\u00020\u000e2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0012\u001a\u00020\u000e2\b\b\u0002\u0010\u0013\u001a\u00020\u000e2\b\b\u0002\u0010\u0014\u001a\u00020\u000e2\b\b\u0002\u0010\u0015\u001a\u00020\u000e2\b\b\u0002\u0010\u0016\u001a\u00020\u000e2\b\b\u0002\u0010\u0017\u001a\u00020\u00182\b\b\u0002\u0010\u0019\u001a\u00020\u000e2\b\b\u0002\u0010\u001a\u001a\u00020\u000e2\b\b\u0002\u0010\u001b\u001a\u00020\u000e2\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u001d\u001a\u00020\u001e2\b\b\u0002\u0010\u001f\u001a\u00020\u000e2\b\b\u0002\u0010 \u001a\u00020\u000e2\b\b\u0002\u0010!\u001a\u00020\u000e2\u0010\b\u0002\u0010\"\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010#2\b\b\u0002\u0010$\u001a\u00020\u000e2\b\b\u0002\u0010%\u001a\u00020\u000eHÆ\u0001J\u0013\u0010j\u001a\u00020\u001e2\b\u0010k\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010l\u001a\u00020\u000eHÖ\u0001J\t\u0010m\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b(\u0010)R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b*\u0010+R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b,\u0010+R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b-\u0010+R\u0013\u0010\b\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b.\u0010+R\u0013\u0010\t\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b/\u0010+R\u0013\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\b\n\u0000\u001a\u0004\b0\u00101R\u0013\u0010\f\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b2\u0010+R\u0011\u0010\r\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b3\u00104R\u0013\u0010\u000f\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b5\u0010+R\u0013\u0010\u0010\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b6\u0010+R\u0013\u0010\u0011\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b7\u0010+R\u0011\u0010\u0012\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b8\u00104R\u0011\u0010\u0013\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b9\u00104R\u0011\u0010\u0014\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b:\u00104R\u0011\u0010\u0015\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b;\u00104R\u0011\u0010\u0016\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b<\u00104R\u0011\u0010\u0017\u001a\u00020\u0018¢\u0006\b\n\u0000\u001a\u0004\b=\u0010>R\u0011\u0010\u0019\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b?\u00104R\u0011\u0010\u001a\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b@\u00104R\u0011\u0010\u001b\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\bA\u00104R\u0013\u0010\u001c\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\bB\u0010+R\u0011\u0010\u001d\u001a\u00020\u001e¢\u0006\b\n\u0000\u001a\u0004\bC\u0010DR\u0011\u0010\u001f\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\bE\u00104R\u0011\u0010 \u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\bF\u00104R\u0011\u0010!\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\bG\u00104R\u0019\u0010\"\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010#¢\u0006\b\n\u0000\u001a\u0004\bH\u0010IR\u0011\u0010$\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\bJ\u00104R\u0011\u0010%\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\bK\u00104¨\u0006n"}, d2 = {"Lcom/mammon/speechaudiosdk/kmp/param/va/SpeechVoiceAssistantSessionAsrContextParam;", "", "audioConfig", "Lcom/mammon/speechaudiosdk/kmp/param/SpeechAudioConfigParam;", "url", "", b.f276376z, "header", DBDefinition.TASK_ID, "sessionId", "tokenType", "Lcom/mammon/speechaudiosdk/kmp/type/SpeechAudioTokenType;", "token", "connectTimeout", "", "language", "extra", DoraObricDeviceHomeViewModel.PARAM_PRODUCT_MODEL, "sosSilenceTimeout", "eosSilenceTimeout", "sentenceMaxTime", "enablePunctuation", "enableSpeakerDiarization", "timestamp", "", "enableAudioCache", "audioCacheSize", "enableRemoveFirstAudioData", "businessInfo", "enableSpeechRejection", "", "audioSrc", "retryMode", DBDefinition.RETRY_COUNT, "retryIntervalTimeMs", "", "maxBufferCount", "finishWaitTimeout", "<init>", "(Lcom/mammon/speechaudiosdk/kmp/param/SpeechAudioConfigParam;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/mammon/speechaudiosdk/kmp/type/SpeechAudioTokenType;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;IIIIIJIIILjava/lang/String;ZIIILjava/util/List;II)V", "getAudioConfig", "()Lcom/mammon/speechaudiosdk/kmp/param/SpeechAudioConfigParam;", "getUrl", "()Ljava/lang/String;", "getAppKey", "getHeader", "getTaskId", "getSessionId", "getTokenType", "()Lcom/mammon/speechaudiosdk/kmp/type/SpeechAudioTokenType;", "getToken", "getConnectTimeout", "()I", "getLanguage", "getExtra", "getModel", "getSosSilenceTimeout", "getEosSilenceTimeout", "getSentenceMaxTime", "getEnablePunctuation", "getEnableSpeakerDiarization", "getTimestamp", "()J", "getEnableAudioCache", "getAudioCacheSize", "getEnableRemoveFirstAudioData", "getBusinessInfo", "getEnableSpeechRejection", "()Z", "getAudioSrc", "getRetryMode", "getRetryCount", "getRetryIntervalTimeMs", "()Ljava/util/List;", "getMaxBufferCount", "getFinishWaitTimeout", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component20", "component21", "component22", "component23", "component24", "component25", "component26", "component27", "component28", "component29", "copy", "equals", "other", "hashCode", "toString", "speech_audiosdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class SpeechVoiceAssistantSessionAsrContextParam {
    private final String appKey;
    private final int audioCacheSize;
    private final SpeechAudioConfigParam audioConfig;
    private final int audioSrc;
    private final String businessInfo;
    private final int connectTimeout;
    private final int enableAudioCache;
    private final int enablePunctuation;
    private final int enableRemoveFirstAudioData;
    private final int enableSpeakerDiarization;
    private final boolean enableSpeechRejection;
    private final int eosSilenceTimeout;
    private final String extra;
    private final int finishWaitTimeout;
    private final String header;
    private final String language;
    private final int maxBufferCount;
    private final String model;
    private final int retryCount;
    private final List<Integer> retryIntervalTimeMs;
    private final int retryMode;
    private final int sentenceMaxTime;
    private final String sessionId;
    private final int sosSilenceTimeout;
    private final String taskId;
    private final long timestamp;
    private final String token;
    private final SpeechAudioTokenType tokenType;
    private final String url;

    public SpeechVoiceAssistantSessionAsrContextParam() {
        this(null, null, null, null, null, null, null, null, 0, null, null, null, 0, 0, 0, 0, 0, 0, 0, 0, 0, null, false, 0, 0, 0, null, 0, 0, 536870911, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ SpeechVoiceAssistantSessionAsrContextParam copy$default(SpeechVoiceAssistantSessionAsrContextParam r110, SpeechAudioConfigParam r111, String r112, String r210, String r211, String r212, String r213, SpeechAudioTokenType r214, String r215, int r216, String r217, String r218, String r219, int r310, int r311, int r312, int r313, int r314, long r315, int r316, int r317, int r318, String r410, boolean r411, int r412, int r413, int r414, List r415, int r416, int r417, int r418, Object r419) {
        if ((r418 & 1) == 0) goto L5;
        SpeechAudioConfigParam r100 = r110.audioConfig;
    L7:
        if ((r418 & 2) == 0) goto L9;
        String r101 = r110.url;
    L11:
        if ((r418 & 4) == 0) goto L13;
        String r102 = r110.appKey;
    L15:
        if ((r418 & 8) == 0) goto L17;
        String r103 = r110.header;
    L19:
        if ((r418 & 16) == 0) goto L21;
        String r104 = r110.taskId;
    L23:
        if ((r418 & 32) == 0) goto L25;
        String r105 = r110.sessionId;
    L27:
        if ((r418 & 64) == 0) goto L29;
        SpeechAudioTokenType r106 = r110.tokenType;
    L31:
        if ((r418 & 128) == 0) goto L33;
        String r107 = r110.token;
    L35:
        if ((r418 & 256) == 0) goto L37;
        int r113 = r110.connectTimeout;
    L39:
        if ((r418 & 512) == 0) goto L41;
        String r114 = r110.language;
    L43:
        if ((r418 & 1024) == 0) goto L45;
        String r115 = r110.extra;
    L47:
        if ((r418 & 2048) == 0) goto L49;
        String r116 = r110.model;
    L51:
        if ((r418 & 4096) == 0) goto L53;
        int r117 = r110.sosSilenceTimeout;
    L55:
        if ((r418 & 8192) == 0) goto L57;
        int r118 = r110.eosSilenceTimeout;
    L58:
        int r319 = r118;
        if ((r418 & 16384) == 0) goto L61;
        int r119 = r110.sentenceMaxTime;
    L62:
        int r320 = r119;
        if ((r418 & 32768) == 0) goto L65;
        int r120 = r110.enablePunctuation;
    L66:
        int r321 = r120;
        if ((r418 & 65536) == 0) goto L69;
        int r121 = r110.enableSpeakerDiarization;
    L70:
        int r322 = r117;
        int r323 = r121;
        if ((r418 & 131072) == 0) goto L73;
        long r122 = r110.timestamp;
    L74:
        long r324 = r122;
        if ((r418 & 262144) == 0) goto L77;
        int r123 = r110.enableAudioCache;
    L79:
        if ((524288 & r418) == 0) goto L81;
        int r124 = r110.audioCacheSize;
    L82:
        int r325 = r124;
        if ((r418 & 1048576) == 0) goto L85;
        int r125 = r110.enableRemoveFirstAudioData;
    L86:
        int r326 = r125;
        if ((r418 & 2097152) == 0) goto L89;
        String r126 = r110.businessInfo;
    L90:
        String r420 = r126;
        if ((r418 & 4194304) == 0) goto L93;
        boolean r127 = r110.enableSpeechRejection;
    L94:
        boolean r421 = r127;
        if ((r418 & 8388608) == 0) goto L97;
        int r128 = r110.audioSrc;
    L98:
        int r422 = r128;
        if ((r418 & 16777216) == 0) goto L101;
        int r129 = r110.retryMode;
    L102:
        int r423 = r129;
        if ((r418 & 33554432) == 0) goto L105;
        int r130 = r110.retryCount;
    L106:
        int r424 = r130;
        if ((r418 & 67108864) == 0) goto L109;
        List r131 = r110.retryIntervalTimeMs;
    L110:
        List r425 = r131;
        if ((r418 & AMapEngineUtils.HALF_MAX_P20_WIDTH) == 0) goto L113;
        int r132 = r110.maxBufferCount;
    L115:
        if ((r418 & 268435456) == 0) goto L117;
        int r108 = r110.finishWaitTimeout;
    L119:
        return r110.copy(r100, r101, r102, r103, r104, r105, r106, r107, r113, r114, r115, r116, r322, r319, r320, r321, r323, r324, r123, r325, r326, r420, r421, r422, r423, r424, r425, r132, r108);
    L117:
        r108 = r417;
        goto L119
    L113:
        r132 = r416;
        goto L115
    L109:
        r131 = r415;
        goto L110
    L105:
        r130 = r414;
        goto L106
    L101:
        r129 = r413;
        goto L102
    L97:
        r128 = r412;
        goto L98
    L93:
        r127 = r411;
        goto L94
    L89:
        r126 = r410;
        goto L90
    L85:
        r125 = r318;
        goto L86
    L81:
        r124 = r317;
        goto L82
    L77:
        r123 = r316;
        goto L79
    L73:
        r122 = r315;
        goto L74
    L69:
        r121 = r314;
        goto L70
    L65:
        r120 = r313;
        goto L66
    L61:
        r119 = r312;
        goto L62
    L57:
        r118 = r311;
        goto L58
    L53:
        r117 = r310;
        goto L55
    L49:
        r116 = r219;
        goto L51
    L45:
        r115 = r218;
        goto L47
    L41:
        r114 = r217;
        goto L43
    L37:
        r113 = r216;
        goto L39
    L33:
        r107 = r215;
        goto L35
    L29:
        r106 = r214;
        goto L31
    L25:
        r105 = r213;
        goto L27
    L21:
        r104 = r212;
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

    public final SpeechAudioConfigParam component1() {
        return this.audioConfig;
    }

    public final String component10() {
        return this.language;
    }

    public final String component11() {
        return this.extra;
    }

    public final String component12() {
        return this.model;
    }

    public final int component13() {
        return this.sosSilenceTimeout;
    }

    public final int component14() {
        return this.eosSilenceTimeout;
    }

    public final int component15() {
        return this.sentenceMaxTime;
    }

    public final int component16() {
        return this.enablePunctuation;
    }

    public final int component17() {
        return this.enableSpeakerDiarization;
    }

    public final long component18() {
        return this.timestamp;
    }

    public final int component19() {
        return this.enableAudioCache;
    }

    public final String component2() {
        return this.url;
    }

    public final int component20() {
        return this.audioCacheSize;
    }

    public final int component21() {
        return this.enableRemoveFirstAudioData;
    }

    public final String component22() {
        return this.businessInfo;
    }

    public final boolean component23() {
        return this.enableSpeechRejection;
    }

    public final int component24() {
        return this.audioSrc;
    }

    public final int component25() {
        return this.retryMode;
    }

    public final int component26() {
        return this.retryCount;
    }

    public final List<Integer> component27() {
        return this.retryIntervalTimeMs;
    }

    public final int component28() {
        return this.maxBufferCount;
    }

    public final int component29() {
        return this.finishWaitTimeout;
    }

    public final String component3() {
        return this.appKey;
    }

    public final String component4() {
        return this.header;
    }

    public final String component5() {
        return this.taskId;
    }

    public final String component6() {
        return this.sessionId;
    }

    public final SpeechAudioTokenType component7() {
        return this.tokenType;
    }

    public final String component8() {
        return this.token;
    }

    public final int component9() {
        return this.connectTimeout;
    }

    public final SpeechVoiceAssistantSessionAsrContextParam copy(SpeechAudioConfigParam r310, String r311, String r312, String r313, String r314, String r315, SpeechAudioTokenType r410, String r411, int r412, String r413, String r414, String r415, int r416, int r417, int r418, int r419, int r510, long r511, int r512, int r513, int r514, String r515, boolean r516, int r517, int r518, int r610, List<Integer> r611, int r612, int r613) {
        Intrinsics.checkNotNullParameter(r310, "audioConfig");
        return new SpeechVoiceAssistantSessionAsrContextParam(r310, r311, r312, r313, r314, r315, r410, r411, r412, r413, r414, r415, r416, r417, r418, r419, r510, r511, r512, r513, r514, r515, r516, r517, r518, r610, r611, r612, r613);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof SpeechVoiceAssistantSessionAsrContextParam) == true) goto L8;
        return false;
    L8:
        SpeechVoiceAssistantSessionAsrContextParam r101 = (SpeechVoiceAssistantSessionAsrContextParam) r100;
        if (Intrinsics.areEqual(this.audioConfig, r101.audioConfig) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.url, r101.url) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.appKey, r101.appKey) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.header, r101.header) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.taskId, r101.taskId) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.sessionId, r101.sessionId) == true) goto L27;
        return false;
    L27:
        if (this.tokenType == r101.tokenType) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.token, r101.token) == true) goto L33;
        return false;
    L33:
        if (this.connectTimeout == r101.connectTimeout) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.language, r101.language) == true) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.extra, r101.extra) == true) goto L42;
        return false;
    L42:
        if (Intrinsics.areEqual(this.model, r101.model) == true) goto L45;
        return false;
    L45:
        if (this.sosSilenceTimeout == r101.sosSilenceTimeout) goto L48;
        return false;
    L48:
        if (this.eosSilenceTimeout == r101.eosSilenceTimeout) goto L51;
        return false;
    L51:
        if (this.sentenceMaxTime == r101.sentenceMaxTime) goto L54;
        return false;
    L54:
        if (this.enablePunctuation == r101.enablePunctuation) goto L57;
        return false;
    L57:
        if (this.enableSpeakerDiarization == r101.enableSpeakerDiarization) goto L60;
        return false;
    L60:
        if (this.timestamp == r101.timestamp) goto L63;
        return false;
    L63:
        if (this.enableAudioCache == r101.enableAudioCache) goto L66;
        return false;
    L66:
        if (this.audioCacheSize == r101.audioCacheSize) goto L69;
        return false;
    L69:
        if (this.enableRemoveFirstAudioData == r101.enableRemoveFirstAudioData) goto L72;
        return false;
    L72:
        if (Intrinsics.areEqual(this.businessInfo, r101.businessInfo) == true) goto L75;
        return false;
    L75:
        if (this.enableSpeechRejection == r101.enableSpeechRejection) goto L78;
        return false;
    L78:
        if (this.audioSrc == r101.audioSrc) goto L81;
        return false;
    L81:
        if (this.retryMode == r101.retryMode) goto L84;
        return false;
    L84:
        if (this.retryCount == r101.retryCount) goto L87;
        return false;
    L87:
        if (Intrinsics.areEqual(this.retryIntervalTimeMs, r101.retryIntervalTimeMs) == true) goto L90;
        return false;
    L90:
        if (this.maxBufferCount == r101.maxBufferCount) goto L93;
        return false;
    L93:
        if (this.finishWaitTimeout == r101.finishWaitTimeout) goto L95;
        return false;
    L95:
        return true;
    }

    public int hashCode() {
        int r100 = this.audioConfig.hashCode() * 31;
        String r101 = this.url;
        int r102 = 0;
        if (r101 != null) goto L5;
        int r103 = 0;
    L6:
        int r104 = (r100 + r103) * 31;
        String r105 = this.appKey;
        if (r105 != null) goto L9;
        int r106 = 0;
    L10:
        int r107 = (r104 + r106) * 31;
        String r108 = this.header;
        if (r108 != null) goto L13;
        int r109 = 0;
    L14:
        int r110 = (r107 + r109) * 31;
        String r111 = this.taskId;
        if (r111 != null) goto L17;
        int r112 = 0;
    L18:
        int r113 = (r110 + r112) * 31;
        String r114 = this.sessionId;
        if (r114 != null) goto L21;
        int r115 = 0;
    L22:
        int r116 = (r113 + r115) * 31;
        SpeechAudioTokenType r117 = this.tokenType;
        if (r117 != null) goto L25;
        int r118 = 0;
    L26:
        int r119 = (r116 + r118) * 31;
        String r120 = this.token;
        if (r120 != null) goto L29;
        int r121 = 0;
    L30:
        int r122 = (((r119 + r121) * 31) + this.connectTimeout) * 31;
        String r123 = this.language;
        if (r123 != null) goto L33;
        int r124 = 0;
    L34:
        int r125 = (r122 + r124) * 31;
        String r126 = this.extra;
        if (r126 != null) goto L37;
        int r127 = 0;
    L38:
        int r128 = (r125 + r127) * 31;
        String r129 = this.model;
        if (r129 != null) goto L41;
        int r130 = 0;
    L42:
        int r131 = (((((((((((r128 + r130) * 31) + this.sosSilenceTimeout) * 31) + this.eosSilenceTimeout) * 31) + this.sentenceMaxTime) * 31) + this.enablePunctuation) * 31) + this.enableSpeakerDiarization) * 31;
        long r132 = this.timestamp;
        int r133 = (((((((r131 + ((int) (r132 ^ (r132 >>> 32)))) * 31) + this.enableAudioCache) * 31) + this.audioCacheSize) * 31) + this.enableRemoveFirstAudioData) * 31;
        String r134 = this.businessInfo;
        if (r134 != null) goto L45;
        int r135 = 0;
    L46:
        int r136 = (r133 + r135) * 31;
        if (this.enableSpeechRejection == false) goto L49;
        int r137 = 1231;
    L50:
        int r138 = (((((((r136 + r137) * 31) + this.audioSrc) * 31) + this.retryMode) * 31) + this.retryCount) * 31;
        List<Integer> r139 = this.retryIntervalTimeMs;
        if (r139 == null) goto L55;
        r102 = r139.hashCode();
    L55:
        return ((((r138 + r102) * 31) + this.maxBufferCount) * 31) + this.finishWaitTimeout;
    L49:
        r137 = 1237;
        goto L50
    L45:
        r135 = r134.hashCode();
        goto L46
    L41:
        r130 = r129.hashCode();
        goto L42
    L37:
        r127 = r126.hashCode();
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
        return "SpeechVoiceAssistantSessionAsrContextParam(audioConfig=" + this.audioConfig + ", url=" + this.url + ", appKey=" + this.appKey + ", header=" + this.header + ", taskId=" + this.taskId + ", sessionId=" + this.sessionId + ", tokenType=" + this.tokenType + ", token=" + this.token + ", connectTimeout=" + this.connectTimeout + ", language=" + this.language + ", extra=" + this.extra + ", model=" + this.model + ", sosSilenceTimeout=" + this.sosSilenceTimeout + ", eosSilenceTimeout=" + this.eosSilenceTimeout + ", sentenceMaxTime=" + this.sentenceMaxTime + ", enablePunctuation=" + this.enablePunctuation + ", enableSpeakerDiarization=" + this.enableSpeakerDiarization + ", timestamp=" + this.timestamp + ", enableAudioCache=" + this.enableAudioCache + ", audioCacheSize=" + this.audioCacheSize + ", enableRemoveFirstAudioData=" + this.enableRemoveFirstAudioData + ", businessInfo=" + this.businessInfo + ", enableSpeechRejection=" + this.enableSpeechRejection + ", audioSrc=" + this.audioSrc + ", retryMode=" + this.retryMode + ", retryCount=" + this.retryCount + ", retryIntervalTimeMs=" + this.retryIntervalTimeMs + ", maxBufferCount=" + this.maxBufferCount + ", finishWaitTimeout=" + this.finishWaitTimeout + ')';
    }

    public final String getAppKey() {
        return this.appKey;
    }

    public final int getAudioCacheSize() {
        return this.audioCacheSize;
    }

    public final SpeechAudioConfigParam getAudioConfig() {
        return this.audioConfig;
    }

    public final int getAudioSrc() {
        return this.audioSrc;
    }

    public final String getBusinessInfo() {
        return this.businessInfo;
    }

    public final int getConnectTimeout() {
        return this.connectTimeout;
    }

    public final int getEnableAudioCache() {
        return this.enableAudioCache;
    }

    public final int getEnablePunctuation() {
        return this.enablePunctuation;
    }

    public final int getEnableRemoveFirstAudioData() {
        return this.enableRemoveFirstAudioData;
    }

    public final int getEnableSpeakerDiarization() {
        return this.enableSpeakerDiarization;
    }

    public final boolean getEnableSpeechRejection() {
        return this.enableSpeechRejection;
    }

    public final int getEosSilenceTimeout() {
        return this.eosSilenceTimeout;
    }

    public final String getExtra() {
        return this.extra;
    }

    public final int getFinishWaitTimeout() {
        return this.finishWaitTimeout;
    }

    public final String getHeader() {
        return this.header;
    }

    public final String getLanguage() {
        return this.language;
    }

    public final int getMaxBufferCount() {
        return this.maxBufferCount;
    }

    public final String getModel() {
        return this.model;
    }

    public final int getRetryCount() {
        return this.retryCount;
    }

    public final List<Integer> getRetryIntervalTimeMs() {
        return this.retryIntervalTimeMs;
    }

    public final int getRetryMode() {
        return this.retryMode;
    }

    public final int getSentenceMaxTime() {
        return this.sentenceMaxTime;
    }

    public final String getSessionId() {
        return this.sessionId;
    }

    public final int getSosSilenceTimeout() {
        return this.sosSilenceTimeout;
    }

    public final String getTaskId() {
        return this.taskId;
    }

    public final long getTimestamp() {
        return this.timestamp;
    }

    public final String getToken() {
        return this.token;
    }

    public final SpeechAudioTokenType getTokenType() {
        return this.tokenType;
    }

    public final String getUrl() {
        return this.url;
    }

    public SpeechVoiceAssistantSessionAsrContextParam(SpeechAudioConfigParam r100, String r101, String r102, String r103, String r104, String r105, SpeechAudioTokenType r110, String r111, int r112, String r113, String r114, String r115, int r116, int r117, int r118, int r119, int r210, long r211, int r212, int r213, int r214, String r215, boolean r216, int r217, int r218, int r310, List<Integer> r311, int r312, int r313) {
        Intrinsics.checkNotNullParameter(r100, "audioConfig");
        this.audioConfig = r100;
        this.url = r101;
        this.appKey = r102;
        this.header = r103;
        this.taskId = r104;
        this.sessionId = r105;
        this.tokenType = r110;
        this.token = r111;
        this.connectTimeout = r112;
        this.language = r113;
        this.extra = r114;
        this.model = r115;
        this.sosSilenceTimeout = r116;
        this.eosSilenceTimeout = r117;
        this.sentenceMaxTime = r118;
        this.enablePunctuation = r119;
        this.enableSpeakerDiarization = r210;
        this.timestamp = r211;
        this.enableAudioCache = r212;
        this.audioCacheSize = r213;
        this.enableRemoveFirstAudioData = r214;
        this.businessInfo = r215;
        this.enableSpeechRejection = r216;
        this.audioSrc = r217;
        this.retryMode = r218;
        this.retryCount = r310;
        this.retryIntervalTimeMs = r311;
        this.maxBufferCount = r312;
        this.finishWaitTimeout = r313;
    }

    public /* synthetic */ SpeechVoiceAssistantSessionAsrContextParam(SpeechAudioConfigParam r310, String r311, String r312, String r313, String r314, String r315, SpeechAudioTokenType r316, String r317, int r410, String r411, String r412, String r413, int r414, int r415, int r416, int r417, int r418, long r419, int r510, int r511, int r512, String r513, boolean r514, int r515, int r516, int r517, List r518, int r610, int r611, int r612, DefaultConstructorMarker r613) {
        if ((r612 & 1) == 0) goto L5;
        SpeechAudioConfigParam r100 = new SpeechAudioConfigParam(null, 0, 0, 0, false, false, 63, null);
    L7:
        if ((r612 & 2) == 0) goto L9;
        String r101 = null;
    L11:
        if ((r612 & 4) == 0) goto L13;
        String r102 = null;
    L15:
        if ((r612 & 8) == 0) goto L17;
        String r103 = null;
    L19:
        if ((r612 & 16) == 0) goto L21;
        String r104 = null;
    L23:
        if ((r612 & 32) == 0) goto L25;
        String r105 = null;
    L27:
        if ((r612 & 64) == 0) goto L29;
        SpeechAudioTokenType r106 = null;
    L31:
        if ((r612 & 128) == 0) goto L33;
        String r107 = null;
    L35:
        if ((r612 & 256) == 0) goto L37;
        int r110 = 0;
    L39:
        if ((r612 & 512) == 0) goto L41;
        String r111 = null;
    L43:
        if ((r612 & 1024) == 0) goto L45;
        String r112 = null;
    L47:
        if ((r612 & 2048) == 0) goto L49;
        String r113 = null;
    L51:
        if ((r612 & 4096) == 0) goto L53;
        int r114 = 0;
    L55:
        if ((r612 & 8192) == 0) goto L57;
        int r108 = 0;
    L59:
        if ((r612 & 16384) == 0) goto L61;
        int r115 = 0;
    L63:
        if ((r612 & 32768) == 0) goto L65;
        int r116 = 0;
    L67:
        if ((r612 & 65536) == 0) goto L69;
        int r117 = 0;
    L71:
        if ((r612 & 131072) == 0) goto L73;
        long r118 = 0;
    L75:
        if ((r612 & 262144) == 0) goto L77;
        int r210 = 0;
    L79:
        if ((r612 & 524288) == 0) goto L81;
        int r211 = 0;
    L83:
        if ((r612 & 1048576) == 0) goto L85;
        int r212 = 0;
    L87:
        if ((r612 & 2097152) == 0) goto L89;
        String r213 = null;
    L91:
        if ((r612 & 4194304) == 0) goto L93;
        boolean r214 = false;
    L95:
        if ((r612 & 8388608) == 0) goto L97;
        int r215 = 0;
    L99:
        if ((r612 & 16777216) == 0) goto L101;
        int r216 = 0;
    L103:
        if ((r612 & 33554432) == 0) goto L105;
        int r217 = 0;
    L107:
        if ((r612 & 67108864) == 0) goto L109;
        List r218 = null;
    L111:
        if ((r612 & AMapEngineUtils.HALF_MAX_P20_WIDTH) == 0) goto L113;
        int r219 = 0;
    L115:
        if ((r612 & 268435456) == 0) goto L117;
        int r109 = 0;
    L118:
        this(r100, r101, r102, r103, r104, r105, r106, r107, r110, r111, r112, r113, r114, r108, r115, r116, r117, r118, r210, r211, r212, r213, r214, r215, r216, r217, r218, r219, r109);
        return;
    L117:
        r109 = r611;
        goto L118
    L113:
        r219 = r610;
        goto L115
    L109:
        r218 = r518;
        goto L111
    L105:
        r217 = r517;
        goto L107
    L101:
        r216 = r516;
        goto L103
    L97:
        r215 = r515;
        goto L99
    L93:
        r214 = r514;
        goto L95
    L89:
        r213 = r513;
        goto L91
    L85:
        r212 = r512;
        goto L87
    L81:
        r211 = r511;
        goto L83
    L77:
        r210 = r510;
        goto L79
    L73:
        r118 = r419;
        goto L75
    L69:
        r117 = r418;
        goto L71
    L65:
        r116 = r417;
        goto L67
    L61:
        r115 = r416;
        goto L63
    L57:
        r108 = r415;
        goto L59
    L53:
        r114 = r414;
        goto L55
    L49:
        r113 = r413;
        goto L51
    L45:
        r112 = r412;
        goto L47
    L41:
        r111 = r411;
        goto L43
    L37:
        r110 = r410;
        goto L39
    L33:
        r107 = r317;
        goto L35
    L29:
        r106 = r316;
        goto L31
    L25:
        r105 = r315;
        goto L27
    L21:
        r104 = r314;
        goto L23
    L17:
        r103 = r313;
        goto L19
    L13:
        r102 = r312;
        goto L15
    L9:
        r101 = r311;
        goto L11
    L5:
        r100 = r310;
        goto L7
    }
}
