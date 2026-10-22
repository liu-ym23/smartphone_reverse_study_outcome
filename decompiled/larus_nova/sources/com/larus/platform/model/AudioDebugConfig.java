package com.larus.platform.model;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0018\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001BW\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\t\u0012\b\b\u0002\u0010\u000b\u001a\u00020\t¢\u0006\u0004\b\f\u0010\rJ\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001d\u001a\u00020\tHÆ\u0003J\t\u0010\u001e\u001a\u00020\tHÆ\u0003J\t\u0010\u001f\u001a\u00020\tHÆ\u0003JY\u0010 \u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\t2\b\b\u0002\u0010\u000b\u001a\u00020\tHÆ\u0001J\u0013\u0010!\u001a\u00020\"2\b\u0010#\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010$\u001a\u00020\u0003HÖ\u0001J\t\u0010%\u001a\u00020&HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000fR\u0016\u0010\u0005\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000fR\u0016\u0010\u0006\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000fR\u0016\u0010\u0007\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u000fR\u0016\u0010\b\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0016\u0010\n\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0015R\u0016\u0010\u000b\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0015¨\u0006'"}, d2 = {"Lcom/larus/platform/model/AudioDebugConfig;", "", "imAsrDumpFileLimit", "", "imAecDumpFileLimit", "imTtsDumpFileLimit", "realtimeDumpTaskLimit", "realtimeDumpFileLimitInSingleTask", "imDumpFileSizeMB", "", "realtimeDumpFileSizeMB", "realtimeDumpTotalSizeMB", "<init>", "(IIIIIJJJ)V", "getImAsrDumpFileLimit", "()I", "getImAecDumpFileLimit", "getImTtsDumpFileLimit", "getRealtimeDumpTaskLimit", "getRealtimeDumpFileLimitInSingleTask", "getImDumpFileSizeMB", "()J", "getRealtimeDumpFileSizeMB", "getRealtimeDumpTotalSizeMB", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "equals", "", "other", "hashCode", "toString", "", "platform_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AudioDebugConfig {

    @SerializedName("im_aec_dump_file_limit")
    private final int imAecDumpFileLimit;

    @SerializedName("im_asr_dump_file_limit")
    private final int imAsrDumpFileLimit;

    @SerializedName("im_dump_file_size_MB")
    private final long imDumpFileSizeMB;

    @SerializedName("im_tts_dump_file_limit")
    private final int imTtsDumpFileLimit;

    @SerializedName("realtime_dump_limit_in_single_task")
    private final int realtimeDumpFileLimitInSingleTask;

    @SerializedName("realtime_dump_file_size_MB")
    private final long realtimeDumpFileSizeMB;

    @SerializedName("realtime_dump_task_limit")
    private final int realtimeDumpTaskLimit;

    @SerializedName("realtime_dump_total_size_MB")
    private final long realtimeDumpTotalSizeMB;

    public AudioDebugConfig() {
        this(0, 0, 0, 0, 0, 0, 0, 0, 255, null);
    }

    public static /* synthetic */ AudioDebugConfig copy$default(AudioDebugConfig r110, int r111, int r112, int r113, int r114, int r115, long r116, long r210, long r211, int r212, Object r213) {
        if ((r212 & 1) == 0) goto L5;
        int r100 = r110.imAsrDumpFileLimit;
    L7:
        if ((r212 & 2) == 0) goto L9;
        int r101 = r110.imAecDumpFileLimit;
    L11:
        if ((r212 & 4) == 0) goto L13;
        int r102 = r110.imTtsDumpFileLimit;
    L15:
        if ((r212 & 8) == 0) goto L17;
        int r103 = r110.realtimeDumpTaskLimit;
    L19:
        if ((r212 & 16) == 0) goto L21;
        int r104 = r110.realtimeDumpFileLimitInSingleTask;
    L23:
        if ((r212 & 32) == 0) goto L25;
        long r105 = r110.imDumpFileSizeMB;
    L27:
        if ((r212 & 64) == 0) goto L29;
        long r106 = r110.realtimeDumpFileSizeMB;
    L31:
        if ((r212 & 128) == 0) goto L33;
        long r117 = r110.realtimeDumpTotalSizeMB;
    L35:
        return r110.copy(r100, r101, r102, r103, r104, r105, r106, r117);
    L33:
        r117 = r211;
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

    public final int component1() {
        return this.imAsrDumpFileLimit;
    }

    public final int component2() {
        return this.imAecDumpFileLimit;
    }

    public final int component3() {
        return this.imTtsDumpFileLimit;
    }

    public final int component4() {
        return this.realtimeDumpTaskLimit;
    }

    public final int component5() {
        return this.realtimeDumpFileLimitInSingleTask;
    }

    public final long component6() {
        return this.imDumpFileSizeMB;
    }

    public final long component7() {
        return this.realtimeDumpFileSizeMB;
    }

    public final long component8() {
        return this.realtimeDumpTotalSizeMB;
    }

    public final AudioDebugConfig copy(int r110, int r111, int r112, int r113, int r114, long r115, long r210, long r211) {
        return new AudioDebugConfig(r110, r111, r112, r113, r114, r115, r210, r211);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof AudioDebugConfig) == true) goto L8;
        return false;
    L8:
        AudioDebugConfig r101 = (AudioDebugConfig) r100;
        if (this.imAsrDumpFileLimit == r101.imAsrDumpFileLimit) goto L12;
        return false;
    L12:
        if (this.imAecDumpFileLimit == r101.imAecDumpFileLimit) goto L15;
        return false;
    L15:
        if (this.imTtsDumpFileLimit == r101.imTtsDumpFileLimit) goto L18;
        return false;
    L18:
        if (this.realtimeDumpTaskLimit == r101.realtimeDumpTaskLimit) goto L21;
        return false;
    L21:
        if (this.realtimeDumpFileLimitInSingleTask == r101.realtimeDumpFileLimitInSingleTask) goto L24;
        return false;
    L24:
        if (this.imDumpFileSizeMB == r101.imDumpFileSizeMB) goto L27;
        return false;
    L27:
        if (this.realtimeDumpFileSizeMB == r101.realtimeDumpFileSizeMB) goto L30;
        return false;
    L30:
        if (this.realtimeDumpTotalSizeMB == r101.realtimeDumpTotalSizeMB) goto L32;
        return false;
    L32:
        return true;
    }

    public int hashCode() {
        int r100 = ((((((((this.imAsrDumpFileLimit * 31) + this.imAecDumpFileLimit) * 31) + this.imTtsDumpFileLimit) * 31) + this.realtimeDumpTaskLimit) * 31) + this.realtimeDumpFileLimitInSingleTask) * 31;
        long r101 = this.imDumpFileSizeMB;
        int r102 = (r100 + ((int) (r101 ^ (r101 >>> 32)))) * 31;
        long r103 = this.realtimeDumpFileSizeMB;
        int r104 = (r102 + ((int) (r103 ^ (r103 >>> 32)))) * 31;
        long r105 = this.realtimeDumpTotalSizeMB;
        return r104 + ((int) (r105 ^ (r105 >>> 32)));
    }

    public String toString() {
        return "AudioDebugConfig(imAsrDumpFileLimit=" + this.imAsrDumpFileLimit + ", imAecDumpFileLimit=" + this.imAecDumpFileLimit + ", imTtsDumpFileLimit=" + this.imTtsDumpFileLimit + ", realtimeDumpTaskLimit=" + this.realtimeDumpTaskLimit + ", realtimeDumpFileLimitInSingleTask=" + this.realtimeDumpFileLimitInSingleTask + ", imDumpFileSizeMB=" + this.imDumpFileSizeMB + ", realtimeDumpFileSizeMB=" + this.realtimeDumpFileSizeMB + ", realtimeDumpTotalSizeMB=" + this.realtimeDumpTotalSizeMB + ')';
    }

    public final int getImAecDumpFileLimit() {
        return this.imAecDumpFileLimit;
    }

    public final int getImAsrDumpFileLimit() {
        return this.imAsrDumpFileLimit;
    }

    public final long getImDumpFileSizeMB() {
        return this.imDumpFileSizeMB;
    }

    public final int getImTtsDumpFileLimit() {
        return this.imTtsDumpFileLimit;
    }

    public final int getRealtimeDumpFileLimitInSingleTask() {
        return this.realtimeDumpFileLimitInSingleTask;
    }

    public final long getRealtimeDumpFileSizeMB() {
        return this.realtimeDumpFileSizeMB;
    }

    public final int getRealtimeDumpTaskLimit() {
        return this.realtimeDumpTaskLimit;
    }

    public final long getRealtimeDumpTotalSizeMB() {
        return this.realtimeDumpTotalSizeMB;
    }

    public AudioDebugConfig(int r100, int r101, int r102, int r103, int r104, long r105, long r106, long r110) {
        this.imAsrDumpFileLimit = r100;
        this.imAecDumpFileLimit = r101;
        this.imTtsDumpFileLimit = r102;
        this.realtimeDumpTaskLimit = r103;
        this.realtimeDumpFileLimitInSingleTask = r104;
        this.imDumpFileSizeMB = r105;
        this.realtimeDumpFileSizeMB = r106;
        this.realtimeDumpTotalSizeMB = r110;
    }

    public /* synthetic */ AudioDebugConfig(int r110, int r111, int r112, int r113, int r114, long r115, long r210, long r211, int r212, DefaultConstructorMarker r213) {
        int r100 = 10;
        if ((r212 & 1) == 0) goto L5;
        int r101 = 10;
    L7:
        if ((r212 & 2) == 0) goto L9;
        int r102 = 18;
    L11:
        if ((r212 & 4) == 0) goto L13;
        int r103 = 15;
    L15:
        if ((r212 & 8) == 0) goto L17;
        int r104 = 3;
    L19:
        if ((r212 & 16) != 0) goto L22;
        r100 = r114;
    L22:
        long r105 = 1024;
        if ((r212 & 32) == 0) goto L25;
        long r106 = 1024;
    L27:
        if ((r212 & 64) != 0) goto L31;
        r105 = r210;
    L31:
        if ((r212 & 128) == 0) goto L33;
        long r116 = 512;
    L34:
        this(r101, r102, r103, r104, r100, r106, r105, r116);
        return;
    L33:
        r116 = r211;
        goto L34
    L25:
        r106 = r115;
        goto L27
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
