package com.larus.audio.asr.sami.bean;

import com.android.ttcjpaysdk.verify.constants.DyVerifyEventConstants;
import com.google.gson.annotations.SerializedName;
import com.larus.audio.asr.c0;
import com.ss.android.socialbase.appdownloader.util.parser.zip.UnixStat;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes24.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b+\b\u0087\b\u0018\u00002\u00020\u0001B\u0093\u0001\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\t\u001a\u00020\n\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0012\u0012\b\b\u0002\u0010\u0013\u001a\u00020\f¢\u0006\u0004\b\u0014\u0010\u0015J\u000b\u0010+\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010,\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010-\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010.\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010/\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u00100\u001a\u00020\nHÆ\u0003J\u0010\u00101\u001a\u0004\u0018\u00010\fHÆ\u0003¢\u0006\u0002\u0010 J\u000b\u00102\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u00103\u001a\u0004\u0018\u00010\u000fHÆ\u0003¢\u0006\u0002\u0010$J\u0010\u00104\u001a\u0004\u0018\u00010\fHÆ\u0003¢\u0006\u0002\u0010 J\u000b\u00105\u001a\u0004\u0018\u00010\u0012HÆ\u0003J\t\u00106\u001a\u00020\fHÆ\u0003J\u009a\u0001\u00107\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\t\u001a\u00020\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00122\b\b\u0002\u0010\u0013\u001a\u00020\fHÆ\u0001¢\u0006\u0002\u00108J\u0013\u00109\u001a\u00020\n2\b\u0010:\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010;\u001a\u00020\u000fHÖ\u0001J\t\u0010<\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0017R\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0017R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0018\u0010\b\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0017R\u0016\u0010\t\u001a\u00020\n8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u001a\u0010\u000b\u001a\u0004\u0018\u00010\f8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010!\u001a\u0004\b\u001f\u0010 R\u0018\u0010\r\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u0017R\u001a\u0010\u000e\u001a\u0004\u0018\u00010\u000f8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010%\u001a\u0004\b#\u0010$R\u001a\u0010\u0010\u001a\u0004\u0018\u00010\f8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010!\u001a\u0004\b&\u0010 R\u0018\u0010\u0011\u001a\u0004\u0018\u00010\u00128\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b'\u0010(R\u0016\u0010\u0013\u001a\u00020\f8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b)\u0010*¨\u0006="}, d2 = {"Lcom/larus/audio/asr/sami/bean/AsrTaskItem;", "", DBDefinition.TASK_ID, "", "conversationId", "asrFilePath", "asrExtraInfo", "Lcom/larus/audio/asr/sami/bean/AsrExtraInfo;", "botId", "saveAudioFile", "", "duration", "", "bizScene", "vuiId", "", "preStartTime", "traceInfo", "Lcom/larus/audio/asr/AsrTraceInfo;", "minRecordDurationMs", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/larus/audio/asr/sami/bean/AsrExtraInfo;Ljava/lang/String;ZLjava/lang/Long;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Long;Lcom/larus/audio/asr/AsrTraceInfo;J)V", "getTaskId", "()Ljava/lang/String;", "getConversationId", "getAsrFilePath", "getAsrExtraInfo", "()Lcom/larus/audio/asr/sami/bean/AsrExtraInfo;", "getBotId", "getSaveAudioFile", "()Z", "getDuration", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getBizScene", "getVuiId", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getPreStartTime", "getTraceInfo", "()Lcom/larus/audio/asr/AsrTraceInfo;", "getMinRecordDurationMs", "()J", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/larus/audio/asr/sami/bean/AsrExtraInfo;Ljava/lang/String;ZLjava/lang/Long;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Long;Lcom/larus/audio/asr/AsrTraceInfo;J)Lcom/larus/audio/asr/sami/bean/AsrTaskItem;", "equals", "other", "hashCode", "toString", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AsrTaskItem {

    @SerializedName("asr_extra_info")
    private final AsrExtraInfo asrExtraInfo;

    @SerializedName("asr_file_path")
    private final String asrFilePath;

    @SerializedName(DyVerifyEventConstants.EventParam.BIZ_SCENE)
    private final String bizScene;

    @SerializedName("bot_id")
    private final String botId;

    @SerializedName("conversation_id")
    private final String conversationId;

    @SerializedName("duration")
    private final Long duration;

    @SerializedName("min_record_duration_ms")
    private final long minRecordDurationMs;

    @SerializedName("pre_start_time")
    private final Long preStartTime;

    @SerializedName("save_audio_file")
    private final boolean saveAudioFile;

    @SerializedName("task_id")
    private final String taskId;

    @SerializedName("trace_info")
    private final c0 traceInfo;

    @SerializedName("vui_id")
    private final Integer vuiId;

    public AsrTaskItem() {
        this(null, null, null, null, null, false, null, null, null, null, null, 0, UnixStat.PERM_MASK, null);
    }

    public static /* synthetic */ AsrTaskItem copy$default(AsrTaskItem r110, String r111, String r112, String r113, AsrExtraInfo r114, String r210, boolean r211, Long r212, String r213, Integer r214, Long r215, c0 r216, long r217, int r218, Object r310) {
        if ((r218 & 1) == 0) goto L5;
        String r100 = r110.taskId;
    L7:
        if ((r218 & 2) == 0) goto L9;
        String r101 = r110.conversationId;
    L11:
        if ((r218 & 4) == 0) goto L13;
        String r102 = r110.asrFilePath;
    L15:
        if ((r218 & 8) == 0) goto L17;
        AsrExtraInfo r103 = r110.asrExtraInfo;
    L19:
        if ((r218 & 16) == 0) goto L21;
        String r104 = r110.botId;
    L23:
        if ((r218 & 32) == 0) goto L25;
        boolean r105 = r110.saveAudioFile;
    L27:
        if ((r218 & 64) == 0) goto L29;
        Long r106 = r110.duration;
    L31:
        if ((r218 & 128) == 0) goto L33;
        String r107 = r110.bizScene;
    L35:
        if ((r218 & 256) == 0) goto L37;
        Integer r115 = r110.vuiId;
    L39:
        if ((r218 & 512) == 0) goto L41;
        Long r116 = r110.preStartTime;
    L43:
        if ((r218 & 1024) == 0) goto L45;
        c0 r117 = r110.traceInfo;
    L47:
        if ((r218 & 2048) == 0) goto L49;
        long r118 = r110.minRecordDurationMs;
    L51:
        return r110.copy(r100, r101, r102, r103, r104, r105, r106, r107, r115, r116, r117, r118);
    L49:
        r118 = r217;
        goto L51
    L45:
        r117 = r216;
        goto L47
    L41:
        r116 = r215;
        goto L43
    L37:
        r115 = r214;
        goto L39
    L33:
        r107 = r213;
        goto L35
    L29:
        r106 = r212;
        goto L31
    L25:
        r105 = r211;
        goto L27
    L21:
        r104 = r210;
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

    public final String component1() {
        return this.taskId;
    }

    public final Long component10() {
        return this.preStartTime;
    }

    public final c0 component11() {
        return this.traceInfo;
    }

    public final long component12() {
        return this.minRecordDurationMs;
    }

    public final String component2() {
        return this.conversationId;
    }

    public final String component3() {
        return this.asrFilePath;
    }

    public final AsrExtraInfo component4() {
        return this.asrExtraInfo;
    }

    public final String component5() {
        return this.botId;
    }

    public final boolean component6() {
        return this.saveAudioFile;
    }

    public final Long component7() {
        return this.duration;
    }

    public final String component8() {
        return this.bizScene;
    }

    public final Integer component9() {
        return this.vuiId;
    }

    public final AsrTaskItem copy(String r110, String r111, String r112, AsrExtraInfo r113, String r210, boolean r211, Long r212, String r213, Integer r214, Long r215, c0 r216, long r217) {
        return new AsrTaskItem(r110, r111, r112, r113, r210, r211, r212, r213, r214, r215, r216, r217);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof AsrTaskItem) == true) goto L8;
        return false;
    L8:
        AsrTaskItem r101 = (AsrTaskItem) r100;
        if (Intrinsics.areEqual(this.taskId, r101.taskId) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.conversationId, r101.conversationId) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.asrFilePath, r101.asrFilePath) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.asrExtraInfo, r101.asrExtraInfo) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.botId, r101.botId) == true) goto L24;
        return false;
    L24:
        if (this.saveAudioFile == r101.saveAudioFile) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.duration, r101.duration) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.bizScene, r101.bizScene) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.vuiId, r101.vuiId) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.preStartTime, r101.preStartTime) == true) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.traceInfo, r101.traceInfo) == true) goto L42;
        return false;
    L42:
        if (this.minRecordDurationMs == r101.minRecordDurationMs) goto L44;
        return false;
    L44:
        return true;
    }

    public int hashCode() {
        String r100 = this.taskId;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.conversationId;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.asrFilePath;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        AsrExtraInfo r110 = this.asrExtraInfo;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        String r113 = this.botId;
        if (r113 != null) goto L21;
        int r114 = 0;
    L22:
        int r115 = (r112 + r114) * 31;
        if (this.saveAudioFile == false) goto L25;
        int r116 = 1231;
    L26:
        int r117 = (r115 + r116) * 31;
        Long r118 = this.duration;
        if (r118 != null) goto L29;
        int r119 = 0;
    L30:
        int r120 = (r117 + r119) * 31;
        String r121 = this.bizScene;
        if (r121 != null) goto L33;
        int r122 = 0;
    L34:
        int r123 = (r120 + r122) * 31;
        Integer r124 = this.vuiId;
        if (r124 != null) goto L37;
        int r125 = 0;
    L38:
        int r126 = (r123 + r125) * 31;
        Long r127 = this.preStartTime;
        if (r127 != null) goto L41;
        int r128 = 0;
    L42:
        int r129 = (r126 + r128) * 31;
        c0 r130 = this.traceInfo;
        if (r130 == null) goto L46;
        r101 = r130.hashCode();
    L46:
        int r131 = (r129 + r101) * 31;
        long r132 = this.minRecordDurationMs;
        return r131 + ((int) (r132 ^ (r132 >>> 32)));
    L41:
        r128 = r127.hashCode();
        goto L42
    L37:
        r125 = r124.hashCode();
        goto L38
    L33:
        r122 = r121.hashCode();
        goto L34
    L29:
        r119 = r118.hashCode();
        goto L30
    L25:
        r116 = 1237;
        goto L26
    L21:
        r114 = r113.hashCode();
        goto L22
    L17:
        r111 = r110.hashCode();
        goto L18
    L13:
        r108 = r107.hashCode();
        goto L14
    L9:
        r105 = r104.hashCode();
        goto L10
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public String toString() {
        return "AsrTaskItem(taskId=" + this.taskId + ", conversationId=" + this.conversationId + ", asrFilePath=" + this.asrFilePath + ", asrExtraInfo=" + this.asrExtraInfo + ", botId=" + this.botId + ", saveAudioFile=" + this.saveAudioFile + ", duration=" + this.duration + ", bizScene=" + this.bizScene + ", vuiId=" + this.vuiId + ", preStartTime=" + this.preStartTime + ", traceInfo=" + this.traceInfo + ", minRecordDurationMs=" + this.minRecordDurationMs + ')';
    }

    public final AsrExtraInfo getAsrExtraInfo() {
        return this.asrExtraInfo;
    }

    public final String getAsrFilePath() {
        return this.asrFilePath;
    }

    public final String getBizScene() {
        return this.bizScene;
    }

    public final String getBotId() {
        return this.botId;
    }

    public final String getConversationId() {
        return this.conversationId;
    }

    public final Long getDuration() {
        return this.duration;
    }

    public final long getMinRecordDurationMs() {
        return this.minRecordDurationMs;
    }

    public final Long getPreStartTime() {
        return this.preStartTime;
    }

    public final boolean getSaveAudioFile() {
        return this.saveAudioFile;
    }

    public final String getTaskId() {
        return this.taskId;
    }

    public final c0 getTraceInfo() {
        return this.traceInfo;
    }

    public final Integer getVuiId() {
        return this.vuiId;
    }

    public AsrTaskItem(String r100, String r101, String r102, AsrExtraInfo r103, String r104, boolean r105, Long r106, String r107, Integer r108, Long r110, c0 r111, long r112) {
        this.taskId = r100;
        this.conversationId = r101;
        this.asrFilePath = r102;
        this.asrExtraInfo = r103;
        this.botId = r104;
        this.saveAudioFile = r105;
        this.duration = r106;
        this.bizScene = r107;
        this.vuiId = r108;
        this.preStartTime = r110;
        this.traceInfo = r111;
        this.minRecordDurationMs = r112;
    }

    public /* synthetic */ AsrTaskItem(String r110, String r111, String r112, AsrExtraInfo r210, String r211, boolean r212, Long r213, String r214, Integer r215, Long r216, c0 r217, long r218, int r310, DefaultConstructorMarker r311) {
        String r100 = "";
        if ((r310 & 1) == 0) goto L5;
        String r101 = "";
    L7:
        if ((r310 & 2) == 0) goto L9;
        String r102 = "";
    L11:
        if ((r310 & 4) != 0) goto L15;
        r100 = r112;
    L15:
        if ((r310 & 8) == 0) goto L17;
        AsrExtraInfo r103 = null;
    L19:
        if ((r310 & 16) == 0) goto L21;
        String r104 = null;
    L23:
        if ((r310 & 32) == 0) goto L25;
        boolean r105 = false;
    L27:
        if ((r310 & 64) == 0) goto L29;
        Long r106 = null;
    L31:
        if ((r310 & 128) == 0) goto L33;
        String r113 = null;
    L35:
        if ((r310 & 256) == 0) goto L37;
        Integer r114 = null;
    L39:
        if ((r310 & 512) == 0) goto L41;
        Long r115 = null;
    L43:
        if ((r310 & 1024) == 0) goto L45;
        c0 r116 = new c0(null, null, 0, 255);
    L47:
        if ((r310 & 2048) == 0) goto L49;
        long r117 = 500;
    L50:
        this(r101, r102, r100, r103, r104, r105, r106, r113, r114, r115, r116, r117);
        return;
    L49:
        r117 = r218;
        goto L50
    L45:
        r116 = r217;
        goto L47
    L41:
        r115 = r216;
        goto L43
    L37:
        r114 = r215;
        goto L39
    L33:
        r113 = r214;
        goto L35
    L29:
        r106 = r213;
        goto L31
    L25:
        r105 = r212;
        goto L27
    L21:
        r104 = r211;
        goto L23
    L17:
        r103 = r210;
        goto L19
    L9:
        r102 = r111;
        goto L11
    L5:
        r101 = r110;
        goto L7
    }
}
