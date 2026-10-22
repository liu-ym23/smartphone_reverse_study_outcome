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
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0010\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b%\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 M2\u00060\u0001j\u0002`\u0002:\u0002LMB§\u0001\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0004\u0012\b\b\u0002\u0010\t\u001a\u00020\u0004\u0012\b\b\u0002\u0010\n\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0004\u0012\b\b\u0002\u0010\f\u001a\u00020\u0004\u0012\b\b\u0002\u0010\r\u001a\u00020\u0007\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0007\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0004¢\u0006\u0004\b\u0015\u0010\u0016B\u009b\u0001\b\u0010\u0012\u0006\u0010\u0017\u001a\u00020\u0018\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0004\u0012\u0006\u0010\t\u001a\u00020\u0004\u0012\u0006\u0010\n\u001a\u00020\u0004\u0012\u0006\u0010\u000b\u001a\u00020\u0004\u0012\u0006\u0010\f\u001a\u00020\u0004\u0012\u0006\u0010\r\u001a\u00020\u0007\u0012\u0006\u0010\u000e\u001a\u00020\u0004\u0012\u0006\u0010\u000f\u001a\u00020\u0004\u0012\u0006\u0010\u0010\u001a\u00020\u0004\u0012\u0006\u0010\u0011\u001a\u00020\u0007\u0012\u0006\u0010\u0012\u001a\u00020\u0004\u0012\u0006\u0010\u0013\u001a\u00020\u0004\u0012\u0006\u0010\u0014\u001a\u00020\u0004\u0012\b\u0010\u0019\u001a\u0004\u0018\u00010\u001a¢\u0006\u0004\b\u0015\u0010\u001bJ\t\u0010-\u001a\u00020\u0004HÆ\u0003J\t\u0010.\u001a\u00020\u0004HÆ\u0003J\t\u0010/\u001a\u00020\u0007HÆ\u0003J\t\u00100\u001a\u00020\u0004HÆ\u0003J\t\u00101\u001a\u00020\u0004HÆ\u0003J\t\u00102\u001a\u00020\u0004HÆ\u0003J\t\u00103\u001a\u00020\u0004HÆ\u0003J\t\u00104\u001a\u00020\u0004HÆ\u0003J\t\u00105\u001a\u00020\u0007HÆ\u0003J\t\u00106\u001a\u00020\u0004HÆ\u0003J\t\u00107\u001a\u00020\u0004HÆ\u0003J\t\u00108\u001a\u00020\u0004HÆ\u0003J\t\u00109\u001a\u00020\u0007HÆ\u0003J\t\u0010:\u001a\u00020\u0004HÆ\u0003J\t\u0010;\u001a\u00020\u0004HÆ\u0003J\t\u0010<\u001a\u00020\u0004HÆ\u0003J©\u0001\u0010=\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00042\b\b\u0002\u0010\t\u001a\u00020\u00042\b\b\u0002\u0010\n\u001a\u00020\u00042\b\b\u0002\u0010\u000b\u001a\u00020\u00042\b\b\u0002\u0010\f\u001a\u00020\u00042\b\b\u0002\u0010\r\u001a\u00020\u00072\b\b\u0002\u0010\u000e\u001a\u00020\u00042\b\b\u0002\u0010\u000f\u001a\u00020\u00042\b\b\u0002\u0010\u0010\u001a\u00020\u00042\b\b\u0002\u0010\u0011\u001a\u00020\u00072\b\b\u0002\u0010\u0012\u001a\u00020\u00042\b\b\u0002\u0010\u0013\u001a\u00020\u00042\b\b\u0002\u0010\u0014\u001a\u00020\u0004HÆ\u0001J\u0013\u0010>\u001a\u00020\u00072\b\u0010?\u001a\u0004\u0018\u00010@HÖ\u0003J\t\u0010A\u001a\u00020\u0018HÖ\u0001J\t\u0010B\u001a\u00020CHÖ\u0001J%\u0010D\u001a\u00020E2\u0006\u0010F\u001a\u00020\u00002\u0006\u0010G\u001a\u00020H2\u0006\u0010I\u001a\u00020JH\u0001¢\u0006\u0002\bKR\u0016\u0010\u0003\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u001c\u0010\u001dR\u0016\u0010\u0005\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u001e\u0010\u001dR\u0016\u0010\u0006\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u001f\u0010\u001dR\u0016\u0010\b\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u0012\u0004\b \u0010\u001dR\u0016\u0010\t\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u0012\u0004\b!\u0010\u001dR\u0016\u0010\n\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u0012\u0004\b\"\u0010\u001dR\u0016\u0010\u000b\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u0012\u0004\b#\u0010\u001dR\u0016\u0010\f\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u0012\u0004\b$\u0010\u001dR\u0016\u0010\r\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u0012\u0004\b%\u0010\u001dR\u0016\u0010\u000e\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u0012\u0004\b&\u0010\u001dR\u0016\u0010\u000f\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u0012\u0004\b'\u0010\u001dR\u0016\u0010\u0010\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u0012\u0004\b(\u0010\u001dR\u0016\u0010\u0011\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u0012\u0004\b)\u0010\u001dR\u0016\u0010\u0012\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u0012\u0004\b*\u0010\u001dR\u0016\u0010\u0013\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u0012\u0004\b+\u0010\u001dR\u0016\u0010\u0014\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u0012\u0004\b,\u0010\u001d¨\u0006N"}, d2 = {"Lcom/larus/im/internal/jni/bean/OMNIAVQueryEndEvent;", "Ljava/io/Serializable;", "Lcom/flow/kmp/common/SerializableIO;", "userDuration", "", "lastRespCostTime", "noContent", "", "comfortWaitTime", "taskRequestSeqId", "taskRequestTimestamp", "softVadTimestampMs", "hardVadTimestampMs", "isPreQuery", "prefetchBacktrackTime", "lastUserAudioTimestampMs", "clientLastUserAudioTimestampMs", "triggerBot", "clientSoftVadTimestampMs", "answerStartDuration", "asrDuration", "<init>", "(JJZJJJJJZJJJZJJJ)V", "seen0", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(IJJZJJJJJZJJJZJJJLkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getUserDuration$annotations", "()V", "getLastRespCostTime$annotations", "getNoContent$annotations", "getComfortWaitTime$annotations", "getTaskRequestSeqId$annotations", "getTaskRequestTimestamp$annotations", "getSoftVadTimestampMs$annotations", "getHardVadTimestampMs$annotations", "isPreQuery$annotations", "getPrefetchBacktrackTime$annotations", "getLastUserAudioTimestampMs$annotations", "getClientLastUserAudioTimestampMs$annotations", "getTriggerBot$annotations", "getClientSoftVadTimestampMs$annotations", "getAnswerStartDuration$annotations", "getAsrDuration$annotations", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "copy", "equals", "other", "", "hashCode", "toString", "", "write$Self", "", "self", BdpAppEventConstant.PARAMS_OUTPUT, "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$omnisdk_av_release", "$serializer", "Companion", "omnisdk-av_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
@Serializable
public final class OMNIAVQueryEndEvent implements java.io.Serializable {
    public static final Companion Companion = null;
    public final long answerStartDuration;
    public final long asrDuration;
    public final long clientLastUserAudioTimestampMs;
    public final long clientSoftVadTimestampMs;
    public final long comfortWaitTime;
    public final long hardVadTimestampMs;
    public final boolean isPreQuery;
    public final long lastRespCostTime;
    public final long lastUserAudioTimestampMs;
    public final boolean noContent;
    public final long prefetchBacktrackTime;
    public final long softVadTimestampMs;
    public final long taskRequestSeqId;
    public final long taskRequestTimestamp;
    public final boolean triggerBot;
    public final long userDuration;

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lcom/larus/im/internal/jni/bean/OMNIAVQueryEndEvent$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/larus/im/internal/jni/bean/OMNIAVQueryEndEvent;", "omnisdk-av_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }

        public final d<OMNIAVQueryEndEvent> serializer() {
            return OMNIAVQueryEndEvent$$serializer.INSTANCE;
        }
    }

    static {
        Companion = new Companion(null);
    }

    public OMNIAVQueryEndEvent() {
        this(0, 0, false, 0, 0, 0, 0, 0, false, 0, 0, 0, false, 0, 0, 0, 65535, null);
    }

    public static /* synthetic */ OMNIAVQueryEndEvent copy$default(OMNIAVQueryEndEvent r110, long r111, long r112, boolean r210, long r211, long r212, long r213, long r214, long r310, boolean r311, long r312, long r313, long r314, boolean r315, long r410, long r411, long r412, int r413, Object r414) {
        if ((r413 & 1) == 0) goto L5;
        long r100 = r110.userDuration;
    L7:
        if ((r413 & 2) == 0) goto L9;
        long r101 = r110.lastRespCostTime;
    L11:
        if ((r413 & 4) == 0) goto L13;
        boolean r102 = r110.noContent;
    L15:
        if ((r413 & 8) == 0) goto L17;
        long r103 = r110.comfortWaitTime;
    L19:
        if ((r413 & 16) == 0) goto L21;
        long r104 = r110.taskRequestSeqId;
    L23:
        if ((r413 & 32) == 0) goto L25;
        long r113 = r110.taskRequestTimestamp;
    L27:
        if ((r413 & 64) == 0) goto L29;
        long r114 = r110.softVadTimestampMs;
    L30:
        long r215 = r114;
        if ((r413 & 128) == 0) goto L33;
        long r115 = r110.hardVadTimestampMs;
    L35:
        if ((r413 & 256) == 0) goto L37;
        boolean r116 = r110.isPreQuery;
    L38:
        boolean r316 = r116;
        long r317 = r115;
        if ((r413 & 512) == 0) goto L41;
        long r117 = r110.prefetchBacktrackTime;
    L42:
        long r318 = r117;
        if ((r413 & 1024) == 0) goto L45;
        long r118 = r110.lastUserAudioTimestampMs;
    L46:
        long r319 = r118;
        if ((r413 & 2048) == 0) goto L49;
        long r119 = r110.clientLastUserAudioTimestampMs;
    L51:
        if ((r413 & 4096) == 0) goto L53;
        boolean r120 = r110.triggerBot;
    L54:
        boolean r320 = r120;
        long r321 = r119;
        if ((r413 & 8192) == 0) goto L57;
        long r121 = r110.clientSoftVadTimestampMs;
    L58:
        long r415 = r121;
        if ((r413 & 16384) == 0) goto L61;
        long r122 = r110.answerStartDuration;
    L62:
        long r416 = r122;
        if ((r413 & 32768) == 0) goto L65;
        long r123 = r110.asrDuration;
    L67:
        return r110.copy(r100, r101, r102, r103, r104, r113, r215, r317, r316, r318, r319, r321, r320, r415, r416, r123);
    L65:
        r123 = r412;
        goto L67
    L61:
        r122 = r411;
        goto L62
    L57:
        r121 = r410;
        goto L58
    L53:
        r120 = r315;
        goto L54
    L49:
        r119 = r314;
        goto L51
    L45:
        r118 = r313;
        goto L46
    L41:
        r117 = r312;
        goto L42
    L37:
        r116 = r311;
        goto L38
    L33:
        r115 = r310;
        goto L35
    L29:
        r114 = r214;
        goto L30
    L25:
        r113 = r213;
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

    @SerialName("answer_start_duration")
    public static /* synthetic */ void getAnswerStartDuration$annotations() {
    }

    @SerialName("asr_duration")
    public static /* synthetic */ void getAsrDuration$annotations() {
    }

    @SerialName("client_last_user_audio_timestamp_ms")
    public static /* synthetic */ void getClientLastUserAudioTimestampMs$annotations() {
    }

    @SerialName("client_soft_vad_timestamp_ms")
    public static /* synthetic */ void getClientSoftVadTimestampMs$annotations() {
    }

    @SerialName("comfort_wait_time")
    public static /* synthetic */ void getComfortWaitTime$annotations() {
    }

    @SerialName("hard_vad_timestamp_ms")
    public static /* synthetic */ void getHardVadTimestampMs$annotations() {
    }

    @SerialName("last_resp_cost_time")
    public static /* synthetic */ void getLastRespCostTime$annotations() {
    }

    @SerialName("last_user_audio_timestamp_ms")
    public static /* synthetic */ void getLastUserAudioTimestampMs$annotations() {
    }

    @SerialName("no_content")
    public static /* synthetic */ void getNoContent$annotations() {
    }

    @SerialName("prefetch_backtrack_time")
    public static /* synthetic */ void getPrefetchBacktrackTime$annotations() {
    }

    @SerialName("soft_vad_timestamp_ms")
    public static /* synthetic */ void getSoftVadTimestampMs$annotations() {
    }

    @SerialName("task_request_seq_id")
    public static /* synthetic */ void getTaskRequestSeqId$annotations() {
    }

    @SerialName("task_request_timestamp")
    public static /* synthetic */ void getTaskRequestTimestamp$annotations() {
    }

    @SerialName("trigger_bot")
    public static /* synthetic */ void getTriggerBot$annotations() {
    }

    @SerialName("user_duration")
    public static /* synthetic */ void getUserDuration$annotations() {
    }

    @SerialName("is_pre_query")
    public static /* synthetic */ void isPreQuery$annotations() {
    }

    public final long component1() {
        return this.userDuration;
    }

    public final long component10() {
        return this.prefetchBacktrackTime;
    }

    public final long component11() {
        return this.lastUserAudioTimestampMs;
    }

    public final long component12() {
        return this.clientLastUserAudioTimestampMs;
    }

    public final boolean component13() {
        return this.triggerBot;
    }

    public final long component14() {
        return this.clientSoftVadTimestampMs;
    }

    public final long component15() {
        return this.answerStartDuration;
    }

    public final long component16() {
        return this.asrDuration;
    }

    public final long component2() {
        return this.lastRespCostTime;
    }

    public final boolean component3() {
        return this.noContent;
    }

    public final long component4() {
        return this.comfortWaitTime;
    }

    public final long component5() {
        return this.taskRequestSeqId;
    }

    public final long component6() {
        return this.taskRequestTimestamp;
    }

    public final long component7() {
        return this.softVadTimestampMs;
    }

    public final long component8() {
        return this.hardVadTimestampMs;
    }

    public final boolean component9() {
        return this.isPreQuery;
    }

    public final OMNIAVQueryEndEvent copy(long r310, long r311, boolean r312, long r313, long r314, long r410, long r411, long r412, boolean r413, long r414, long r510, long r511, boolean r512, long r513, long r514, long r515) {
        return new OMNIAVQueryEndEvent(r310, r311, r312, r313, r314, r410, r411, r412, r413, r414, r510, r511, r512, r513, r514, r515);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof OMNIAVQueryEndEvent) == true) goto L8;
        return false;
    L8:
        OMNIAVQueryEndEvent r101 = (OMNIAVQueryEndEvent) r100;
        if (this.userDuration == r101.userDuration) goto L12;
        return false;
    L12:
        if (this.lastRespCostTime == r101.lastRespCostTime) goto L15;
        return false;
    L15:
        if (this.noContent == r101.noContent) goto L18;
        return false;
    L18:
        if (this.comfortWaitTime == r101.comfortWaitTime) goto L21;
        return false;
    L21:
        if (this.taskRequestSeqId == r101.taskRequestSeqId) goto L24;
        return false;
    L24:
        if (this.taskRequestTimestamp == r101.taskRequestTimestamp) goto L27;
        return false;
    L27:
        if (this.softVadTimestampMs == r101.softVadTimestampMs) goto L30;
        return false;
    L30:
        if (this.hardVadTimestampMs == r101.hardVadTimestampMs) goto L33;
        return false;
    L33:
        if (this.isPreQuery == r101.isPreQuery) goto L36;
        return false;
    L36:
        if (this.prefetchBacktrackTime == r101.prefetchBacktrackTime) goto L39;
        return false;
    L39:
        if (this.lastUserAudioTimestampMs == r101.lastUserAudioTimestampMs) goto L42;
        return false;
    L42:
        if (this.clientLastUserAudioTimestampMs == r101.clientLastUserAudioTimestampMs) goto L45;
        return false;
    L45:
        if (this.triggerBot == r101.triggerBot) goto L48;
        return false;
    L48:
        if (this.clientSoftVadTimestampMs == r101.clientSoftVadTimestampMs) goto L51;
        return false;
    L51:
        if (this.answerStartDuration == r101.answerStartDuration) goto L54;
        return false;
    L54:
        if (this.asrDuration == r101.asrDuration) goto L56;
        return false;
    L56:
        return true;
    }

    public int hashCode() {
        long r100 = this.userDuration;
        int r101 = ((int) (r100 ^ (r100 >>> 32))) * 31;
        long r102 = this.lastRespCostTime;
        int r103 = (r101 + ((int) (r102 ^ (r102 >>> 32)))) * 31;
        int r104 = 1231;
        if (this.noContent == false) goto L5;
        int r105 = 1231;
    L6:
        long r106 = this.comfortWaitTime;
        int r107 = (((r103 + r105) * 31) + ((int) (r106 ^ (r106 >>> 32)))) * 31;
        long r108 = this.taskRequestSeqId;
        int r109 = (r107 + ((int) (r108 ^ (r108 >>> 32)))) * 31;
        long r110 = this.taskRequestTimestamp;
        int r111 = (r109 + ((int) (r110 ^ (r110 >>> 32)))) * 31;
        long r112 = this.softVadTimestampMs;
        int r113 = (r111 + ((int) (r112 ^ (r112 >>> 32)))) * 31;
        long r114 = this.hardVadTimestampMs;
        int r115 = (r113 + ((int) (r114 ^ (r114 >>> 32)))) * 31;
        if (this.isPreQuery == false) goto L9;
        int r116 = 1231;
    L10:
        long r117 = this.prefetchBacktrackTime;
        int r118 = (((r115 + r116) * 31) + ((int) (r117 ^ (r117 >>> 32)))) * 31;
        long r119 = this.lastUserAudioTimestampMs;
        int r120 = (r118 + ((int) (r119 ^ (r119 >>> 32)))) * 31;
        long r121 = this.clientLastUserAudioTimestampMs;
        int r122 = (r120 + ((int) (r121 ^ (r121 >>> 32)))) * 31;
        if (this.triggerBot == true) goto L14;
        r104 = 1237;
    L14:
        int r123 = (r122 + r104) * 31;
        long r124 = this.clientSoftVadTimestampMs;
        int r125 = (r123 + ((int) (r124 ^ (r124 >>> 32)))) * 31;
        long r126 = this.answerStartDuration;
        int r127 = (r125 + ((int) (r126 ^ (r126 >>> 32)))) * 31;
        long r128 = this.asrDuration;
        return r127 + ((int) (r128 ^ (r128 >>> 32)));
    L9:
        r116 = 1237;
        goto L10
    L5:
        r105 = 1237;
        goto L6
    }

    public String toString() {
        return "OMNIAVQueryEndEvent(userDuration=" + this.userDuration + ", lastRespCostTime=" + this.lastRespCostTime + ", noContent=" + this.noContent + ", comfortWaitTime=" + this.comfortWaitTime + ", taskRequestSeqId=" + this.taskRequestSeqId + ", taskRequestTimestamp=" + this.taskRequestTimestamp + ", softVadTimestampMs=" + this.softVadTimestampMs + ", hardVadTimestampMs=" + this.hardVadTimestampMs + ", isPreQuery=" + this.isPreQuery + ", prefetchBacktrackTime=" + this.prefetchBacktrackTime + ", lastUserAudioTimestampMs=" + this.lastUserAudioTimestampMs + ", clientLastUserAudioTimestampMs=" + this.clientLastUserAudioTimestampMs + ", triggerBot=" + this.triggerBot + ", clientSoftVadTimestampMs=" + this.clientSoftVadTimestampMs + ", answerStartDuration=" + this.answerStartDuration + ", asrDuration=" + this.asrDuration + ')';
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$omnisdk_av_release(OMNIAVQueryEndEvent r100, muc.d r101, f r110) {
        boolean r102 = false;
        if (r101.shouldEncodeElementDefault(r110, 0) == false) goto L6;
    L4:
        boolean r103 = true;
    L9:
        if (r103 == false) goto L12;
        r101.encodeLongElement(r110, 0, r100.userDuration);
    L12:
        if (r101.shouldEncodeElementDefault(r110, 1) == false) goto L15;
    L13:
        boolean r104 = true;
    L18:
        if (r104 == false) goto L21;
        r101.encodeLongElement(r110, 1, r100.lastRespCostTime);
    L21:
        if (r101.shouldEncodeElementDefault(r110, 2) == false) goto L24;
    L22:
        boolean r105 = true;
    L27:
        if (r105 == false) goto L30;
        r101.encodeBooleanElement(r110, 2, r100.noContent);
    L30:
        if (r101.shouldEncodeElementDefault(r110, 3) == false) goto L33;
    L31:
        boolean r106 = true;
    L36:
        if (r106 == false) goto L39;
        r101.encodeLongElement(r110, 3, r100.comfortWaitTime);
    L39:
        if (r101.shouldEncodeElementDefault(r110, 4) == false) goto L42;
    L40:
        boolean r107 = true;
    L45:
        if (r107 == false) goto L48;
        r101.encodeLongElement(r110, 4, r100.taskRequestSeqId);
    L48:
        if (r101.shouldEncodeElementDefault(r110, 5) == false) goto L51;
    L49:
        boolean r108 = true;
    L54:
        if (r108 == false) goto L57;
        r101.encodeLongElement(r110, 5, r100.taskRequestTimestamp);
    L57:
        if (r101.shouldEncodeElementDefault(r110, 6) == false) goto L60;
    L58:
        boolean r109 = true;
    L63:
        if (r109 == false) goto L66;
        r101.encodeLongElement(r110, 6, r100.softVadTimestampMs);
    L66:
        if (r101.shouldEncodeElementDefault(r110, 7) == false) goto L69;
    L67:
        boolean r111 = true;
    L72:
        if (r111 == false) goto L75;
        r101.encodeLongElement(r110, 7, r100.hardVadTimestampMs);
    L75:
        if (r101.shouldEncodeElementDefault(r110, 8) == false) goto L78;
    L76:
        boolean r112 = true;
    L81:
        if (r112 == false) goto L84;
        r101.encodeBooleanElement(r110, 8, r100.isPreQuery);
    L84:
        if (r101.shouldEncodeElementDefault(r110, 9) == false) goto L87;
    L85:
        boolean r113 = true;
    L90:
        if (r113 == false) goto L93;
        r101.encodeLongElement(r110, 9, r100.prefetchBacktrackTime);
    L93:
        if (r101.shouldEncodeElementDefault(r110, 10) == false) goto L96;
    L94:
        boolean r114 = true;
    L99:
        if (r114 == false) goto L102;
        r101.encodeLongElement(r110, 10, r100.lastUserAudioTimestampMs);
    L102:
        if (r101.shouldEncodeElementDefault(r110, 11) == false) goto L105;
    L103:
        boolean r115 = true;
    L108:
        if (r115 == false) goto L111;
        r101.encodeLongElement(r110, 11, r100.clientLastUserAudioTimestampMs);
    L111:
        if (r101.shouldEncodeElementDefault(r110, 12) == false) goto L114;
    L112:
        boolean r116 = true;
    L117:
        if (r116 == false) goto L120;
        r101.encodeBooleanElement(r110, 12, r100.triggerBot);
    L120:
        if (r101.shouldEncodeElementDefault(r110, 13) == false) goto L123;
    L121:
        boolean r117 = true;
    L126:
        if (r117 == false) goto L129;
        r101.encodeLongElement(r110, 13, r100.clientSoftVadTimestampMs);
    L129:
        if (r101.shouldEncodeElementDefault(r110, 14) == false) goto L132;
    L130:
        boolean r118 = true;
    L135:
        if (r118 == false) goto L138;
        r101.encodeLongElement(r110, 14, r100.answerStartDuration);
    L138:
        if (r101.shouldEncodeElementDefault(r110, 15) == false) goto L141;
    L139:
        r102 = true;
    L143:
        if (r102 == false) goto L146;
        r101.encodeLongElement(r110, 15, r100.asrDuration);
        return;
    L146:
        return;
    L141:
        if (r100.asrDuration == 0) goto L143;
    L132:
        if (r100.answerStartDuration != 0) goto L130;
        r118 = false;
        goto L135
    L123:
        if (r100.clientSoftVadTimestampMs != 0) goto L121;
        r117 = false;
        goto L126
    L114:
        if (r100.triggerBot == true) goto L112;
        r116 = false;
        goto L117
    L105:
        if (r100.clientLastUserAudioTimestampMs != 0) goto L103;
        r115 = false;
        goto L108
    L96:
        if (r100.lastUserAudioTimestampMs != 0) goto L94;
        r114 = false;
        goto L99
    L87:
        if (r100.prefetchBacktrackTime != 0) goto L85;
        r113 = false;
        goto L90
    L78:
        if (r100.isPreQuery == true) goto L76;
        r112 = false;
        goto L81
    L69:
        if (r100.hardVadTimestampMs != 0) goto L67;
        r111 = false;
        goto L72
    L60:
        if (r100.softVadTimestampMs != 0) goto L58;
        r109 = false;
        goto L63
    L51:
        if (r100.taskRequestTimestamp != 0) goto L49;
        r108 = false;
        goto L54
    L42:
        if (r100.taskRequestSeqId != 0) goto L40;
        r107 = false;
        goto L45
    L33:
        if (r100.comfortWaitTime != 0) goto L31;
        r106 = false;
        goto L36
    L24:
        if (r100.noContent == true) goto L22;
        r105 = false;
        goto L27
    L15:
        if (r100.lastRespCostTime != 0) goto L13;
        r104 = false;
        goto L18
    L6:
        if (r100.userDuration != 0) goto L4;
        r103 = false;
        goto L9
    }

    public OMNIAVQueryEndEvent(long r100, long r101, boolean r102, long r103, long r110, long r111, long r112, long r113, boolean r114, long r210, long r211, long r212, boolean r213, long r214, long r215, long r310) {
        this.userDuration = r100;
        this.lastRespCostTime = r101;
        this.noContent = r102;
        this.comfortWaitTime = r103;
        this.taskRequestSeqId = r110;
        this.taskRequestTimestamp = r111;
        this.softVadTimestampMs = r112;
        this.hardVadTimestampMs = r113;
        this.isPreQuery = r114;
        this.prefetchBacktrackTime = r210;
        this.lastUserAudioTimestampMs = r211;
        this.clientLastUserAudioTimestampMs = r212;
        this.triggerBot = r213;
        this.clientSoftVadTimestampMs = r214;
        this.answerStartDuration = r215;
        this.asrDuration = r310;
    }

    public /* synthetic */ OMNIAVQueryEndEvent(int r100, long r110, long r111, boolean r112, long r113, long r114, long r115, long r210, long r211, boolean r212, long r213, long r214, long r310, boolean r311, long r312, long r313, long r314, q2 r315) {
        if ((r100 & 0) == 0) goto L5;
        b2.b(r100, 0, OMNIAVQueryEndEvent$$serializer.INSTANCE.getDescriptor());
        throw null;
    L5:
        if ((r100 & 1) != 0) goto L7;
        this.userDuration = 0;
    L9:
        if ((r100 & 2) != 0) goto L11;
        this.lastRespCostTime = 0;
    L13:
        if ((r100 & 4) != 0) goto L15;
        this.noContent = false;
    L17:
        if ((r100 & 8) != 0) goto L19;
        this.comfortWaitTime = 0;
    L21:
        if ((r100 & 16) != 0) goto L23;
        this.taskRequestSeqId = 0;
    L25:
        if ((r100 & 32) != 0) goto L27;
        this.taskRequestTimestamp = 0;
    L29:
        if ((r100 & 64) != 0) goto L31;
        this.softVadTimestampMs = 0;
    L33:
        if ((r100 & 128) != 0) goto L35;
        this.hardVadTimestampMs = 0;
    L37:
        if ((r100 & 256) != 0) goto L39;
        this.isPreQuery = false;
    L41:
        if ((r100 & 512) != 0) goto L43;
        this.prefetchBacktrackTime = 0;
    L45:
        if ((r100 & 1024) != 0) goto L47;
        this.lastUserAudioTimestampMs = 0;
    L49:
        if ((r100 & 2048) != 0) goto L51;
        this.clientLastUserAudioTimestampMs = 0;
    L53:
        if ((r100 & 4096) != 0) goto L55;
        this.triggerBot = false;
    L57:
        if ((r100 & 8192) != 0) goto L59;
        this.clientSoftVadTimestampMs = 0;
    L61:
        if ((r100 & 16384) != 0) goto L63;
        this.answerStartDuration = 0;
    L65:
        if ((r100 & 32768) != 0) goto L67;
        this.asrDuration = 0;
        return;
    L67:
        this.asrDuration = r314;
        return;
    L63:
        this.answerStartDuration = r313;
        goto L65
    L59:
        this.clientSoftVadTimestampMs = r312;
        goto L61
    L55:
        this.triggerBot = r311;
        goto L57
    L51:
        this.clientLastUserAudioTimestampMs = r310;
        goto L53
    L47:
        this.lastUserAudioTimestampMs = r214;
        goto L49
    L43:
        this.prefetchBacktrackTime = r213;
        goto L45
    L39:
        this.isPreQuery = r212;
        goto L41
    L35:
        this.hardVadTimestampMs = r211;
        goto L37
    L31:
        this.softVadTimestampMs = r210;
        goto L33
    L27:
        this.taskRequestTimestamp = r115;
        goto L29
    L23:
        this.taskRequestSeqId = r114;
        goto L25
    L19:
        this.comfortWaitTime = r113;
        goto L21
    L15:
        this.noContent = r112;
        goto L17
    L11:
        this.lastRespCostTime = r111;
        goto L13
    L7:
        this.userDuration = r110;
        goto L9
    }

    public /* synthetic */ OMNIAVQueryEndEvent(long r310, long r311, boolean r312, long r313, long r314, long r410, long r411, long r412, boolean r413, long r414, long r415, long r510, boolean r511, long r512, long r513, long r514, int r610, DefaultConstructorMarker r611) {
        if ((r610 & 1) == 0) goto L5;
        long r100 = 0;
    L7:
        if ((r610 & 2) == 0) goto L9;
        long r101 = 0;
    L11:
        if ((r610 & 4) == 0) goto L13;
        boolean r102 = false;
    L15:
        if ((r610 & 8) == 0) goto L17;
        long r103 = 0;
    L19:
        if ((r610 & 16) == 0) goto L21;
        long r110 = 0;
    L23:
        if ((r610 & 32) == 0) goto L25;
        long r111 = 0;
    L27:
        if ((r610 & 64) == 0) goto L29;
        long r112 = 0;
    L31:
        if ((r610 & 128) == 0) goto L33;
        long r104 = 0;
    L35:
        if ((r610 & 256) == 0) goto L37;
        boolean r105 = false;
    L38:
        boolean r612 = r105;
        if ((r610 & 512) == 0) goto L41;
        long r113 = 0;
    L43:
        if ((r610 & 1024) == 0) goto L45;
        long r210 = 0;
    L47:
        if ((r610 & 2048) == 0) goto L49;
        long r211 = 0;
    L51:
        if ((r610 & 4096) == 0) goto L53;
        boolean r106 = false;
    L54:
        boolean r212 = r106;
        if ((r610 & 8192) == 0) goto L57;
        long r213 = 0;
    L59:
        if ((r610 & 16384) == 0) goto L61;
        long r214 = 0;
    L63:
        if ((r610 & 32768) == 0) goto L65;
        long r114 = 0;
    L66:
        this(r100, r101, r102, r103, r110, r111, r112, r104, r612, r113, r210, r211, r212, r213, r214, r114);
        return;
    L65:
        r114 = r514;
        goto L66
    L61:
        r214 = r513;
        goto L63
    L57:
        r213 = r512;
        goto L59
    L53:
        r106 = r511;
        goto L54
    L49:
        r211 = r510;
        goto L51
    L45:
        r210 = r415;
        goto L47
    L41:
        r113 = r414;
        goto L43
    L37:
        r105 = r413;
        goto L38
    L33:
        r104 = r412;
        goto L35
    L29:
        r112 = r411;
        goto L31
    L25:
        r111 = r410;
        goto L27
    L21:
        r110 = r314;
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
