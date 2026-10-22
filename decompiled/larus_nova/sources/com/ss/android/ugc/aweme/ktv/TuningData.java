package com.ss.android.ugc.aweme.ktv;

import com.ss.android.vesdk.VERecordData;
import com.tencent.connect.share.QzonePublish;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\bY\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0087\b\u0018\u00002\u00020\u0001B\u0089\u0002\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t\u0012\u000e\b\u0002\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00070\t\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\n\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0007\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0012\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0007\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\n\u0012\u0018\b\u0002\u0010\u0017\u001a\u0012\u0012\u0004\u0012\u00020\u00050\u0018j\b\u0012\u0004\u0012\u00020\u0005`\u0019\u0012\b\b\u0002\u0010\u001a\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u0012\u0012\b\b\u0002\u0010\u001e\u001a\u00020\u0007¢\u0006\u0002\u0010\u001fJ\u000b\u0010Z\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010[\u001a\u00020\u0007HÆ\u0003J\u000b\u0010\\\u001a\u0004\u0018\u00010\u0012HÆ\u0003J\t\u0010]\u001a\u00020\u0005HÆ\u0003J\t\u0010^\u001a\u00020\u0007HÆ\u0003J\t\u0010_\u001a\u00020\u0005HÆ\u0003J\u000b\u0010`\u001a\u0004\u0018\u00010\nHÆ\u0003J\u0019\u0010a\u001a\u0012\u0012\u0004\u0012\u00020\u00050\u0018j\b\u0012\u0004\u0012\u00020\u0005`\u0019HÆ\u0003J\t\u0010b\u001a\u00020\u0005HÆ\u0003J\u000b\u0010c\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010d\u001a\u0004\u0018\u00010\nHÆ\u0003J\t\u0010e\u001a\u00020\u0005HÆ\u0003J\u000b\u0010f\u001a\u0004\u0018\u00010\u0012HÆ\u0003J\t\u0010g\u001a\u00020\u0007HÆ\u0003J\u0010\u0010h\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010>J\u000f\u0010i\u001a\b\u0012\u0004\u0012\u00020\n0\tHÆ\u0003J\u000f\u0010j\u001a\b\u0012\u0004\u0012\u00020\u00070\tHÆ\u0003J\u000b\u0010k\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010l\u001a\u0004\u0018\u00010\nHÆ\u0003J\u000b\u0010m\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010n\u001a\u0004\u0018\u00010\nHÆ\u0003J\u0092\u0002\u0010o\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t2\u000e\b\u0002\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00070\t2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\n2\b\b\u0002\u0010\u0010\u001a\u00020\u00072\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00122\b\b\u0002\u0010\u0013\u001a\u00020\u00052\b\b\u0002\u0010\u0014\u001a\u00020\u00072\b\b\u0002\u0010\u0015\u001a\u00020\u00052\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\n2\u0018\b\u0002\u0010\u0017\u001a\u0012\u0012\u0004\u0012\u00020\u00050\u0018j\b\u0012\u0004\u0012\u00020\u0005`\u00192\b\b\u0002\u0010\u001a\u001a\u00020\u00052\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u00122\b\b\u0002\u0010\u001e\u001a\u00020\u0007HÆ\u0001¢\u0006\u0002\u0010pJ\u0013\u0010q\u001a\u00020\u00052\b\u0010r\u001a\u0004\u0018\u00010sHÖ\u0003J\t\u0010t\u001a\u00020\u0007HÖ\u0001J\t\u0010u\u001a\u00020\nHÖ\u0001R \u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00070\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R \u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010!\"\u0004\b%\u0010#R\u001a\u0010\u001e\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R\u001a\u0010\u0014\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010'\"\u0004\b+\u0010)R*\u0010\u0017\u001a\u0012\u0012\u0004\u0012\u00020\u00050\u0018j\b\u0012\u0004\u0012\u00020\u0005`\u0019X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010-\"\u0004\b.\u0010/R\u001a\u0010\u0015\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u00100\"\u0004\b1\u00102R\u001c\u0010\f\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b3\u00104\"\u0004\b5\u00106R\u001c\u0010\r\u001a\u0004\u0018\u00010\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b7\u00108\"\u0004\b9\u0010:R\u001a\u0010\u001a\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b;\u00100\"\u0004\b<\u00102R\u001e\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u0010\n\u0002\u0010A\u001a\u0004\b=\u0010>\"\u0004\b?\u0010@R\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bB\u0010C\"\u0004\bD\u0010ER\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bF\u00104\"\u0004\bG\u00106R\u001c\u0010\u000f\u001a\u0004\u0018\u00010\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bH\u00108\"\u0004\bI\u0010:R\u001c\u0010\u001c\u001a\u0004\u0018\u00010\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bJ\u00108\"\u0004\bK\u0010:R\u001c\u0010\u001b\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bL\u00104\"\u0004\bM\u00106R\u001c\u0010\u0016\u001a\u0004\u0018\u00010\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bN\u00108\"\u0004\bO\u0010:R\u001c\u0010\u001d\u001a\u0004\u0018\u00010\u0012X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bP\u0010C\"\u0004\bQ\u0010ER\u001a\u0010\u0013\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bR\u00100\"\u0004\bS\u00102R\u001a\u0010\u0010\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bT\u0010'\"\u0004\bU\u0010)R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bV\u00104\"\u0004\bW\u00106R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bX\u00100\"\u0004\bY\u00102¨\u0006v"}, d2 = {"Lcom/ss/android/ugc/aweme/ktv/TuningData;", "Ljava/io/Serializable;", "voiceTrack", "Lcom/ss/android/ugc/aweme/ktv/KtvAudioParam;", "wiredHeadset", "", "recordBGMDelay", "", VERecordData.AUDIOPATHS, "", "", "audioDurations", "originTrack", "originTrackPath", "subTrack", "subTrackPath", QzonePublish.PUBLISH_TO_QZONE_VIDEO_DURATION, "reverberation", "Lcom/ss/android/ugc/aweme/ktv/ReverberationData;", "useRecommendVolume", "delayByUser", "isDuetSing", "tuningMidiPath", "globalWiredHeadset", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "processTuningSuccess", "tuningAudioTrack", "tuningAudioOutputPath", "tuningReverberation", "audioTrackStartTimeOffset", "(Lcom/ss/android/ugc/aweme/ktv/KtvAudioParam;ZLjava/lang/Integer;Ljava/util/List;Ljava/util/List;Lcom/ss/android/ugc/aweme/ktv/KtvAudioParam;Ljava/lang/String;Lcom/ss/android/ugc/aweme/ktv/KtvAudioParam;Ljava/lang/String;ILcom/ss/android/ugc/aweme/ktv/ReverberationData;ZIZLjava/lang/String;Ljava/util/ArrayList;ZLcom/ss/android/ugc/aweme/ktv/KtvAudioParam;Ljava/lang/String;Lcom/ss/android/ugc/aweme/ktv/ReverberationData;I)V", "getAudioDurations", "()Ljava/util/List;", "setAudioDurations", "(Ljava/util/List;)V", "getAudioPaths", "setAudioPaths", "getAudioTrackStartTimeOffset", "()I", "setAudioTrackStartTimeOffset", "(I)V", "getDelayByUser", "setDelayByUser", "getGlobalWiredHeadset", "()Ljava/util/ArrayList;", "setGlobalWiredHeadset", "(Ljava/util/ArrayList;)V", "()Z", "setDuetSing", "(Z)V", "getOriginTrack", "()Lcom/ss/android/ugc/aweme/ktv/KtvAudioParam;", "setOriginTrack", "(Lcom/ss/android/ugc/aweme/ktv/KtvAudioParam;)V", "getOriginTrackPath", "()Ljava/lang/String;", "setOriginTrackPath", "(Ljava/lang/String;)V", "getProcessTuningSuccess", "setProcessTuningSuccess", "getRecordBGMDelay", "()Ljava/lang/Integer;", "setRecordBGMDelay", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getReverberation", "()Lcom/ss/android/ugc/aweme/ktv/ReverberationData;", "setReverberation", "(Lcom/ss/android/ugc/aweme/ktv/ReverberationData;)V", "getSubTrack", "setSubTrack", "getSubTrackPath", "setSubTrackPath", "getTuningAudioOutputPath", "setTuningAudioOutputPath", "getTuningAudioTrack", "setTuningAudioTrack", "getTuningMidiPath", "setTuningMidiPath", "getTuningReverberation", "setTuningReverberation", "getUseRecommendVolume", "setUseRecommendVolume", "getVideoDuration", "setVideoDuration", "getVoiceTrack", "setVoiceTrack", "getWiredHeadset", "setWiredHeadset", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component2", "component20", "component21", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Lcom/ss/android/ugc/aweme/ktv/KtvAudioParam;ZLjava/lang/Integer;Ljava/util/List;Ljava/util/List;Lcom/ss/android/ugc/aweme/ktv/KtvAudioParam;Ljava/lang/String;Lcom/ss/android/ugc/aweme/ktv/KtvAudioParam;Ljava/lang/String;ILcom/ss/android/ugc/aweme/ktv/ReverberationData;ZIZLjava/lang/String;Ljava/util/ArrayList;ZLcom/ss/android/ugc/aweme/ktv/KtvAudioParam;Ljava/lang/String;Lcom/ss/android/ugc/aweme/ktv/ReverberationData;I)Lcom/ss/android/ugc/aweme/ktv/TuningData;", "equals", "other", "", "hashCode", "toString", "lib-api_release"}, k = 1, mv = {1, 4, 1})
public final class TuningData implements Serializable {
    private List<Integer> audioDurations;
    private List<String> audioPaths;
    private int audioTrackStartTimeOffset;
    private int delayByUser;
    private ArrayList<Boolean> globalWiredHeadset;
    private boolean isDuetSing;
    private KtvAudioParam originTrack;
    private String originTrackPath;
    private boolean processTuningSuccess;
    private Integer recordBGMDelay;
    private ReverberationData reverberation;
    private KtvAudioParam subTrack;
    private String subTrackPath;
    private String tuningAudioOutputPath;
    private KtvAudioParam tuningAudioTrack;
    private String tuningMidiPath;
    private ReverberationData tuningReverberation;
    private boolean useRecommendVolume;
    private int videoDuration;
    private KtvAudioParam voiceTrack;
    private boolean wiredHeadset;

    public TuningData() {
        this(null, false, null, null, null, null, null, null, null, 0, null, false, 0, false, null, null, false, null, null, null, 0, 2097151, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ TuningData copy$default(TuningData r110, KtvAudioParam r111, boolean r112, Integer r210, List r211, List r212, KtvAudioParam r213, String r214, KtvAudioParam r215, String r216, int r217, ReverberationData r218, boolean r219, int r310, boolean r311, String r312, ArrayList r313, boolean r314, KtvAudioParam r315, String r316, ReverberationData r317, int r318, int r319, Object r410) {
        if ((r319 & 1) == 0) goto L5;
        KtvAudioParam r100 = r110.voiceTrack;
    L7:
        if ((r319 & 2) == 0) goto L9;
        boolean r101 = r110.wiredHeadset;
    L11:
        if ((r319 & 4) == 0) goto L13;
        Integer r102 = r110.recordBGMDelay;
    L15:
        if ((r319 & 8) == 0) goto L17;
        List r103 = r110.audioPaths;
    L19:
        if ((r319 & 16) == 0) goto L21;
        List r104 = r110.audioDurations;
    L23:
        if ((r319 & 32) == 0) goto L25;
        KtvAudioParam r105 = r110.originTrack;
    L27:
        if ((r319 & 64) == 0) goto L29;
        String r106 = r110.originTrackPath;
    L31:
        if ((r319 & 128) == 0) goto L33;
        KtvAudioParam r107 = r110.subTrack;
    L35:
        if ((r319 & 256) == 0) goto L37;
        String r113 = r110.subTrackPath;
    L39:
        if ((r319 & 512) == 0) goto L41;
        int r114 = r110.videoDuration;
    L43:
        if ((r319 & 1024) == 0) goto L45;
        ReverberationData r115 = r110.reverberation;
    L47:
        if ((r319 & 2048) == 0) goto L49;
        boolean r116 = r110.useRecommendVolume;
    L51:
        if ((r319 & 4096) == 0) goto L53;
        int r117 = r110.delayByUser;
    L55:
        if ((r319 & 8192) == 0) goto L57;
        boolean r118 = r110.isDuetSing;
    L58:
        boolean r320 = r118;
        if ((r319 & 16384) == 0) goto L61;
        String r119 = r110.tuningMidiPath;
    L62:
        String r321 = r119;
        if ((r319 & 32768) == 0) goto L65;
        ArrayList r120 = r110.globalWiredHeadset;
    L66:
        ArrayList r322 = r120;
        if ((r319 & 65536) == 0) goto L69;
        boolean r121 = r110.processTuningSuccess;
    L70:
        boolean r323 = r121;
        if ((r319 & 131072) == 0) goto L73;
        KtvAudioParam r122 = r110.tuningAudioTrack;
    L74:
        KtvAudioParam r324 = r122;
        if ((r319 & 262144) == 0) goto L77;
        String r123 = r110.tuningAudioOutputPath;
    L78:
        String r325 = r123;
        if ((r319 & 524288) == 0) goto L81;
        ReverberationData r124 = r110.tuningReverberation;
    L83:
        if ((r319 & 1048576) == 0) goto L85;
        int r108 = r110.audioTrackStartTimeOffset;
    L87:
        return r110.copy(r100, r101, r102, r103, r104, r105, r106, r107, r113, r114, r115, r116, r117, r320, r321, r322, r323, r324, r325, r124, r108);
    L85:
        r108 = r318;
        goto L87
    L81:
        r124 = r317;
        goto L83
    L77:
        r123 = r316;
        goto L78
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

    public final KtvAudioParam component1() {
        return this.voiceTrack;
    }

    public final int component10() {
        return this.videoDuration;
    }

    public final ReverberationData component11() {
        return this.reverberation;
    }

    public final boolean component12() {
        return this.useRecommendVolume;
    }

    public final int component13() {
        return this.delayByUser;
    }

    public final boolean component14() {
        return this.isDuetSing;
    }

    public final String component15() {
        return this.tuningMidiPath;
    }

    public final ArrayList<Boolean> component16() {
        return this.globalWiredHeadset;
    }

    public final boolean component17() {
        return this.processTuningSuccess;
    }

    public final KtvAudioParam component18() {
        return this.tuningAudioTrack;
    }

    public final String component19() {
        return this.tuningAudioOutputPath;
    }

    public final boolean component2() {
        return this.wiredHeadset;
    }

    public final ReverberationData component20() {
        return this.tuningReverberation;
    }

    public final int component21() {
        return this.audioTrackStartTimeOffset;
    }

    public final Integer component3() {
        return this.recordBGMDelay;
    }

    public final List<String> component4() {
        return this.audioPaths;
    }

    public final List<Integer> component5() {
        return this.audioDurations;
    }

    public final KtvAudioParam component6() {
        return this.originTrack;
    }

    public final String component7() {
        return this.originTrackPath;
    }

    public final KtvAudioParam component8() {
        return this.subTrack;
    }

    public final String component9() {
        return this.subTrackPath;
    }

    public final TuningData copy(KtvAudioParam r210, boolean r211, Integer r212, List<String> r213, List<Integer> r214, KtvAudioParam r215, String r310, KtvAudioParam r311, String r312, int r313, ReverberationData r314, boolean r315, int r316, boolean r317, String r318, ArrayList<Boolean> r319, boolean r410, KtvAudioParam r411, String r412, ReverberationData r413, int r414) {
        Intrinsics.checkNotNullParameter(r213, VERecordData.AUDIOPATHS);
        Intrinsics.checkNotNullParameter(r214, "audioDurations");
        Intrinsics.checkNotNullParameter(r319, "globalWiredHeadset");
        return new TuningData(r210, r211, r212, r213, r214, r215, r310, r311, r312, r313, r314, r315, r316, r317, r318, r319, r410, r411, r412, r413, r414);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof TuningData) == false) goto L48;
        TuningData r101 = (TuningData) r100;
        if (Intrinsics.areEqual(this.voiceTrack, r101.voiceTrack) == true) goto L8;
        return false;
    L8:
        if (this.wiredHeadset == r101.wiredHeadset) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.recordBGMDelay, r101.recordBGMDelay) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.audioPaths, r101.audioPaths) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.audioDurations, r101.audioDurations) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.originTrack, r101.originTrack) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.originTrackPath, r101.originTrackPath) == true) goto L20;
        return false;
    L20:
        if (Intrinsics.areEqual(this.subTrack, r101.subTrack) == true) goto L22;
        return false;
    L22:
        if (Intrinsics.areEqual(this.subTrackPath, r101.subTrackPath) == true) goto L24;
        return false;
    L24:
        if (this.videoDuration == r101.videoDuration) goto L26;
        return false;
    L26:
        if (Intrinsics.areEqual(this.reverberation, r101.reverberation) == true) goto L28;
        return false;
    L28:
        if (this.useRecommendVolume == r101.useRecommendVolume) goto L30;
        return false;
    L30:
        if (this.delayByUser == r101.delayByUser) goto L32;
        return false;
    L32:
        if (this.isDuetSing == r101.isDuetSing) goto L34;
        return false;
    L34:
        if (Intrinsics.areEqual(this.tuningMidiPath, r101.tuningMidiPath) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.globalWiredHeadset, r101.globalWiredHeadset) == true) goto L38;
        return false;
    L38:
        if (this.processTuningSuccess == r101.processTuningSuccess) goto L40;
        return false;
    L40:
        if (Intrinsics.areEqual(this.tuningAudioTrack, r101.tuningAudioTrack) == true) goto L42;
        return false;
    L42:
        if (Intrinsics.areEqual(this.tuningAudioOutputPath, r101.tuningAudioOutputPath) == true) goto L44;
        return false;
    L44:
        if (Intrinsics.areEqual(this.tuningReverberation, r101.tuningReverberation) == true) goto L46;
        return false;
    L46:
        if (this.audioTrackStartTimeOffset == r101.audioTrackStartTimeOffset) goto L73;
        return false;
    L73:
        return true;
    L48:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v4, types: [int] */
    /* JADX WARN: Type inference failed for: r2v1, types: [int] */
    /* JADX WARN: Type inference failed for: r2v28, types: [int] */
    /* JADX WARN: Type inference failed for: r2v31, types: [int] */
    /* JADX WARN: Type inference failed for: r2v50 */
    /* JADX WARN: Type inference failed for: r2v51 */
    /* JADX WARN: Type inference failed for: r2v60 */
    /* JADX WARN: Type inference failed for: r2v61 */
    /* JADX WARN: Type inference failed for: r2v62 */
    /* JADX WARN: Type inference failed for: r2v63 */
    /* JADX WARN: Type inference failed for: r3v0 */
    /* JADX WARN: Type inference failed for: r3v1, types: [int] */
    /* JADX WARN: Type inference failed for: r3v2 */
    public int hashCode() {
        KtvAudioParam r100 = this.voiceTrack;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        boolean r104 = this.wiredHeadset;
        ?? r105 = 1;
        ?? r106 = r104;
        if (r104 == false) goto L9;
        r106 = 1;
    L9:
        int r107 = (r103 + r106) * 31;
        Integer r108 = this.recordBGMDelay;
        if (r108 == null) goto L12;
        int r109 = r108.hashCode();
    L13:
        int r110 = (r107 + r109) * 31;
        List<String> r111 = this.audioPaths;
        if (r111 == null) goto L16;
        int r112 = r111.hashCode();
    L17:
        int r113 = (r110 + r112) * 31;
        List<Integer> r114 = this.audioDurations;
        if (r114 == null) goto L20;
        int r115 = r114.hashCode();
    L21:
        int r116 = (r113 + r115) * 31;
        KtvAudioParam r117 = this.originTrack;
        if (r117 == null) goto L24;
        int r118 = r117.hashCode();
    L25:
        int r119 = (r116 + r118) * 31;
        String r120 = this.originTrackPath;
        if (r120 == null) goto L28;
        int r121 = r120.hashCode();
    L29:
        int r122 = (r119 + r121) * 31;
        KtvAudioParam r123 = this.subTrack;
        if (r123 == null) goto L32;
        int r124 = r123.hashCode();
    L33:
        int r125 = (r122 + r124) * 31;
        String r126 = this.subTrackPath;
        if (r126 == null) goto L36;
        int r127 = r126.hashCode();
    L37:
        int r128 = (((r125 + r127) * 31) + this.videoDuration) * 31;
        ReverberationData r129 = this.reverberation;
        if (r129 == null) goto L40;
        int r130 = r129.hashCode();
    L41:
        int r131 = (r128 + r130) * 31;
        boolean r132 = this.useRecommendVolume;
        ?? r133 = r132;
        if (r132 == false) goto L44;
        r133 = 1;
    L44:
        int r134 = (((r131 + r133) * 31) + this.delayByUser) * 31;
        boolean r135 = this.isDuetSing;
        ?? r136 = r135;
        if (r135 == false) goto L47;
        r136 = 1;
    L47:
        int r137 = (r134 + r136) * 31;
        String r138 = this.tuningMidiPath;
        if (r138 == null) goto L50;
        int r139 = r138.hashCode();
    L51:
        int r140 = (r137 + r139) * 31;
        ArrayList<Boolean> r141 = this.globalWiredHeadset;
        if (r141 == null) goto L54;
        int r142 = r141.hashCode();
    L55:
        int r143 = (r140 + r142) * 31;
        boolean r144 = this.processTuningSuccess;
        if (r144 == true) goto L59;
        r105 = r144;
    L59:
        int r145 = (r143 + r105) * 31;
        KtvAudioParam r146 = this.tuningAudioTrack;
        if (r146 == null) goto L62;
        int r147 = r146.hashCode();
    L63:
        int r148 = (r145 + r147) * 31;
        String r149 = this.tuningAudioOutputPath;
        if (r149 == null) goto L66;
        int r150 = r149.hashCode();
    L67:
        int r151 = (r148 + r150) * 31;
        ReverberationData r152 = this.tuningReverberation;
        if (r152 == null) goto L71;
        r101 = r152.hashCode();
    L71:
        return ((r151 + r101) * 31) + this.audioTrackStartTimeOffset;
    L66:
        r150 = 0;
        goto L67
    L62:
        r147 = 0;
        goto L63
    L54:
        r142 = 0;
        goto L55
    L50:
        r139 = 0;
        goto L51
    L40:
        r130 = 0;
        goto L41
    L36:
        r127 = 0;
        goto L37
    L32:
        r124 = 0;
        goto L33
    L28:
        r121 = 0;
        goto L29
    L24:
        r118 = 0;
        goto L25
    L20:
        r115 = 0;
        goto L21
    L16:
        r112 = 0;
        goto L17
    L12:
        r109 = 0;
        goto L13
    L5:
        r102 = 0;
        goto L6
    }

    public String toString() {
        return "TuningData(voiceTrack=" + this.voiceTrack + ", wiredHeadset=" + this.wiredHeadset + ", recordBGMDelay=" + this.recordBGMDelay + ", audioPaths=" + this.audioPaths + ", audioDurations=" + this.audioDurations + ", originTrack=" + this.originTrack + ", originTrackPath=" + this.originTrackPath + ", subTrack=" + this.subTrack + ", subTrackPath=" + this.subTrackPath + ", videoDuration=" + this.videoDuration + ", reverberation=" + this.reverberation + ", useRecommendVolume=" + this.useRecommendVolume + ", delayByUser=" + this.delayByUser + ", isDuetSing=" + this.isDuetSing + ", tuningMidiPath=" + this.tuningMidiPath + ", globalWiredHeadset=" + this.globalWiredHeadset + ", processTuningSuccess=" + this.processTuningSuccess + ", tuningAudioTrack=" + this.tuningAudioTrack + ", tuningAudioOutputPath=" + this.tuningAudioOutputPath + ", tuningReverberation=" + this.tuningReverberation + ", audioTrackStartTimeOffset=" + this.audioTrackStartTimeOffset + ")";
    }

    public final List<Integer> getAudioDurations() {
        return this.audioDurations;
    }

    public final List<String> getAudioPaths() {
        return this.audioPaths;
    }

    public final int getAudioTrackStartTimeOffset() {
        return this.audioTrackStartTimeOffset;
    }

    public final int getDelayByUser() {
        return this.delayByUser;
    }

    public final ArrayList<Boolean> getGlobalWiredHeadset() {
        return this.globalWiredHeadset;
    }

    public final KtvAudioParam getOriginTrack() {
        return this.originTrack;
    }

    public final String getOriginTrackPath() {
        return this.originTrackPath;
    }

    public final boolean getProcessTuningSuccess() {
        return this.processTuningSuccess;
    }

    public final Integer getRecordBGMDelay() {
        return this.recordBGMDelay;
    }

    public final ReverberationData getReverberation() {
        return this.reverberation;
    }

    public final KtvAudioParam getSubTrack() {
        return this.subTrack;
    }

    public final String getSubTrackPath() {
        return this.subTrackPath;
    }

    public final String getTuningAudioOutputPath() {
        return this.tuningAudioOutputPath;
    }

    public final KtvAudioParam getTuningAudioTrack() {
        return this.tuningAudioTrack;
    }

    public final String getTuningMidiPath() {
        return this.tuningMidiPath;
    }

    public final ReverberationData getTuningReverberation() {
        return this.tuningReverberation;
    }

    public final boolean getUseRecommendVolume() {
        return this.useRecommendVolume;
    }

    public final int getVideoDuration() {
        return this.videoDuration;
    }

    public final KtvAudioParam getVoiceTrack() {
        return this.voiceTrack;
    }

    public final boolean getWiredHeadset() {
        return this.wiredHeadset;
    }

    public final boolean isDuetSing() {
        return this.isDuetSing;
    }

    public final void setAudioDurations(List<Integer> r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.audioDurations = r100;
    }

    public final void setAudioPaths(List<String> r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.audioPaths = r100;
    }

    public final void setAudioTrackStartTimeOffset(int r100) {
        this.audioTrackStartTimeOffset = r100;
    }

    public final void setDelayByUser(int r100) {
        this.delayByUser = r100;
    }

    public final void setDuetSing(boolean r100) {
        this.isDuetSing = r100;
    }

    public final void setGlobalWiredHeadset(ArrayList<Boolean> r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.globalWiredHeadset = r100;
    }

    public final void setOriginTrack(KtvAudioParam r100) {
        this.originTrack = r100;
    }

    public final void setOriginTrackPath(String r100) {
        this.originTrackPath = r100;
    }

    public final void setProcessTuningSuccess(boolean r100) {
        this.processTuningSuccess = r100;
    }

    public final void setRecordBGMDelay(Integer r100) {
        this.recordBGMDelay = r100;
    }

    public final void setReverberation(ReverberationData r100) {
        this.reverberation = r100;
    }

    public final void setSubTrack(KtvAudioParam r100) {
        this.subTrack = r100;
    }

    public final void setSubTrackPath(String r100) {
        this.subTrackPath = r100;
    }

    public final void setTuningAudioOutputPath(String r100) {
        this.tuningAudioOutputPath = r100;
    }

    public final void setTuningAudioTrack(KtvAudioParam r100) {
        this.tuningAudioTrack = r100;
    }

    public final void setTuningMidiPath(String r100) {
        this.tuningMidiPath = r100;
    }

    public final void setTuningReverberation(ReverberationData r100) {
        this.tuningReverberation = r100;
    }

    public final void setUseRecommendVolume(boolean r100) {
        this.useRecommendVolume = r100;
    }

    public final void setVideoDuration(int r100) {
        this.videoDuration = r100;
    }

    public final void setVoiceTrack(KtvAudioParam r100) {
        this.voiceTrack = r100;
    }

    public final void setWiredHeadset(boolean r100) {
        this.wiredHeadset = r100;
    }

    public TuningData(KtvAudioParam r100, boolean r101, Integer r102, List<String> r103, List<Integer> r110, KtvAudioParam r111, String r112, KtvAudioParam r113, String r114, int r115, ReverberationData r116, boolean r117, int r118, boolean r119, String r210, ArrayList<Boolean> r211, boolean r212, KtvAudioParam r213, String r214, ReverberationData r215, int r216) {
        Intrinsics.checkNotNullParameter(r103, VERecordData.AUDIOPATHS);
        Intrinsics.checkNotNullParameter(r110, "audioDurations");
        Intrinsics.checkNotNullParameter(r211, "globalWiredHeadset");
        this.voiceTrack = r100;
        this.wiredHeadset = r101;
        this.recordBGMDelay = r102;
        this.audioPaths = r103;
        this.audioDurations = r110;
        this.originTrack = r111;
        this.originTrackPath = r112;
        this.subTrack = r113;
        this.subTrackPath = r114;
        this.videoDuration = r115;
        this.reverberation = r116;
        this.useRecommendVolume = r117;
        this.delayByUser = r118;
        this.isDuetSing = r119;
        this.tuningMidiPath = r210;
        this.globalWiredHeadset = r211;
        this.processTuningSuccess = r212;
        this.tuningAudioTrack = r213;
        this.tuningAudioOutputPath = r214;
        this.tuningReverberation = r215;
        this.audioTrackStartTimeOffset = r216;
    }

    public /* synthetic */ TuningData(KtvAudioParam r210, boolean r211, Integer r212, List r213, List r214, KtvAudioParam r215, String r216, KtvAudioParam r310, String r311, int r312, ReverberationData r313, boolean r314, int r315, boolean r316, String r317, ArrayList r318, boolean r319, KtvAudioParam r410, String r411, ReverberationData r412, int r413, int r414, DefaultConstructorMarker r415) {
        if ((r414 & 1) == 0) goto L5;
        KtvAudioParam r100 = null;
    L7:
        if ((r414 & 2) == 0) goto L9;
        boolean r101 = false;
    L11:
        if ((r414 & 4) == 0) goto L13;
        Integer r102 = null;
    L15:
        if ((r414 & 8) == 0) goto L17;
        List r103 = new ArrayList();
    L19:
        if ((r414 & 16) == 0) goto L21;
        List r104 = new ArrayList();
    L23:
        if ((r414 & 32) == 0) goto L25;
        KtvAudioParam r105 = null;
    L27:
        if ((r414 & 64) == 0) goto L29;
        String r106 = null;
    L31:
        if ((r414 & 128) == 0) goto L33;
        KtvAudioParam r110 = null;
    L35:
        if ((r414 & 256) == 0) goto L37;
        String r111 = null;
    L39:
        if ((r414 & 512) == 0) goto L41;
        int r112 = 0;
    L43:
        if ((r414 & 1024) == 0) goto L45;
        ReverberationData r113 = null;
    L47:
        if ((r414 & 2048) == 0) goto L49;
        boolean r114 = true;
    L51:
        if ((r414 & 4096) == 0) goto L53;
        int r115 = 0;
    L55:
        if ((r414 & 8192) == 0) goto L57;
        boolean r107 = false;
    L59:
        if ((r414 & 16384) == 0) goto L61;
        String r108 = null;
    L63:
        if ((r414 & 32768) == 0) goto L65;
        ArrayList r116 = new ArrayList();
    L67:
        if ((r414 & 65536) == 0) goto L69;
        boolean r117 = false;
    L71:
        if ((r414 & 131072) == 0) goto L73;
        KtvAudioParam r118 = null;
    L75:
        if ((r414 & 262144) == 0) goto L77;
        String r119 = null;
    L79:
        if ((r414 & 524288) == 0) goto L81;
        ReverberationData r217 = null;
    L83:
        if ((r414 & 1048576) == 0) goto L85;
        int r109 = 0;
    L86:
        this(r100, r101, r102, r103, r104, r105, r106, r110, r111, r112, r113, r114, r115, r107, r108, r116, r117, r118, r119, r217, r109);
        return;
    L85:
        r109 = r413;
        goto L86
    L81:
        r217 = r412;
        goto L83
    L77:
        r119 = r411;
        goto L79
    L73:
        r118 = r410;
        goto L75
    L69:
        r117 = r319;
        goto L71
    L65:
        r116 = r318;
        goto L67
    L61:
        r108 = r317;
        goto L63
    L57:
        r107 = r316;
        goto L59
    L53:
        r115 = r315;
        goto L55
    L49:
        r114 = r314;
        goto L51
    L45:
        r113 = r313;
        goto L47
    L41:
        r112 = r312;
        goto L43
    L37:
        r111 = r311;
        goto L39
    L33:
        r110 = r310;
        goto L35
    L29:
        r106 = r216;
        goto L31
    L25:
        r105 = r215;
        goto L27
    L21:
        r104 = r214;
        goto L23
    L17:
        r103 = r213;
        goto L19
    L13:
        r102 = r212;
        goto L15
    L9:
        r101 = r211;
        goto L11
    L5:
        r100 = r210;
        goto L7
    }
}
