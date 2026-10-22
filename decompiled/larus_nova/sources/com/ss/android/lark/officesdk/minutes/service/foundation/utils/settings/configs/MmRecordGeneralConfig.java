package com.ss.android.lark.officesdk.minutes.service.foundation.utils.settings.configs;

import com.google.gson.annotations.SerializedName;
import com.ss.android.lark.appsetting.annotation.AppConfig;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes37.dex */
@AppConfig(key = "vc_minutes_recorder_config")
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0019\n\u0002\u0010\u000e\n\u0002\b\u000e\n\u0002\u0010\u0000\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001Bu\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0005\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\t\u001a\u00020\u0003\u0012\b\b\u0002\u0010\n\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\f\u001a\u00020\u0005\u0012\b\b\u0002\u0010\r\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0005¢\u0006\u0004\b\u000f\u0010\u0010J\b\u0010\u001e\u001a\u00020\u001fH\u0016J\t\u0010 \u001a\u00020\u0003HÆ\u0003J\t\u0010!\u001a\u00020\u0005HÆ\u0003J\t\u0010\"\u001a\u00020\u0003HÆ\u0003J\t\u0010#\u001a\u00020\u0005HÆ\u0003J\t\u0010$\u001a\u00020\u0003HÆ\u0003J\t\u0010%\u001a\u00020\u0003HÆ\u0003J\t\u0010&\u001a\u00020\u0003HÆ\u0003J\t\u0010'\u001a\u00020\u0003HÆ\u0003J\t\u0010(\u001a\u00020\u0005HÆ\u0003J\t\u0010)\u001a\u00020\u0003HÆ\u0003J\t\u0010*\u001a\u00020\u0005HÆ\u0003Jw\u0010+\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\u00032\b\b\u0002\u0010\f\u001a\u00020\u00052\b\b\u0002\u0010\r\u001a\u00020\u00032\b\b\u0002\u0010\u000e\u001a\u00020\u0005HÆ\u0001J\u0013\u0010,\u001a\u00020\u00052\b\u0010-\u001a\u0004\u0018\u00010.HÖ\u0003J\t\u0010/\u001a\u00020\u0003HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0006\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0012R\u0016\u0010\u0007\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0014R\u0016\u0010\b\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0012R\u0016\u0010\t\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0012R\u0016\u0010\n\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0012R\u0016\u0010\u000b\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0012R\u0016\u0010\f\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0014R\u0016\u0010\r\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0012R\u0016\u0010\u000e\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0014¨\u00060"}, d2 = {"Lcom/ss/android/lark/officesdk/minutes/service/foundation/utils/settings/configs/MmRecordGeneralConfig;", "Ljava/io/Serializable;", "sliceDurationInSec", "", "tosErrorIntervalRetry", "", "backgroundUploadMaxAliveTime", "adaptiveUploadEnable", "ssthresh", "maxThresh", "audioFileCacheMaxAgeDays", "audioFileCacheThresholdMb", "enableOptimizeDozeMode", "minutesTokenRetryMaxTimes", "enableClientOpenSubtitle", "<init>", "(IZIZIIIIZIZ)V", "getSliceDurationInSec", "()I", "getTosErrorIntervalRetry", "()Z", "getBackgroundUploadMaxAliveTime", "getAdaptiveUploadEnable", "getSsthresh", "getMaxThresh", "getAudioFileCacheMaxAgeDays", "getAudioFileCacheThresholdMb", "getEnableOptimizeDozeMode", "getMinutesTokenRetryMaxTimes", "getEnableClientOpenSubtitle", "toString", "", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "copy", "equals", "other", "", "hashCode", "officesdk-minutes-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class MmRecordGeneralConfig implements Serializable {

    @SerializedName("adaptive_upload_enable")
    private final boolean adaptiveUploadEnable;

    @SerializedName("external_file_cache_max_age_days")
    private final int audioFileCacheMaxAgeDays;

    @SerializedName("external_file_threshold_mb")
    private final int audioFileCacheThresholdMb;

    @SerializedName("background_max_alive_time")
    private final int backgroundUploadMaxAliveTime;

    @SerializedName("enable_client_open_subtitle")
    private final boolean enableClientOpenSubtitle;

    @SerializedName("enable_optimize_doze_mode")
    private final boolean enableOptimizeDozeMode;

    @SerializedName("max_thresh")
    private final int maxThresh;

    @SerializedName("minutes_token_retry_max_times")
    private final int minutesTokenRetryMaxTimes;

    @SerializedName("slice_duration_in_sec")
    private final int sliceDurationInSec;

    @SerializedName("ssthresh")
    private final int ssthresh;

    @SerializedName("tos_error_interval_retry")
    private final boolean tosErrorIntervalRetry;

    public MmRecordGeneralConfig() {
        this(0, false, 0, false, 0, 0, 0, 0, false, 0, false, 2047, null);
    }

    public static /* synthetic */ MmRecordGeneralConfig copy$default(MmRecordGeneralConfig r110, int r111, boolean r112, int r113, boolean r114, int r115, int r116, int r117, int r210, boolean r211, int r212, boolean r213, int r214, Object r215) {
        if ((r214 & 1) == 0) goto L5;
        int r100 = r110.sliceDurationInSec;
    L7:
        if ((r214 & 2) == 0) goto L9;
        boolean r101 = r110.tosErrorIntervalRetry;
    L11:
        if ((r214 & 4) == 0) goto L13;
        int r102 = r110.backgroundUploadMaxAliveTime;
    L15:
        if ((r214 & 8) == 0) goto L17;
        boolean r103 = r110.adaptiveUploadEnable;
    L19:
        if ((r214 & 16) == 0) goto L21;
        int r104 = r110.ssthresh;
    L23:
        if ((r214 & 32) == 0) goto L25;
        int r105 = r110.maxThresh;
    L27:
        if ((r214 & 64) == 0) goto L29;
        int r106 = r110.audioFileCacheMaxAgeDays;
    L31:
        if ((r214 & 128) == 0) goto L33;
        int r107 = r110.audioFileCacheThresholdMb;
    L35:
        if ((r214 & 256) == 0) goto L37;
        boolean r118 = r110.enableOptimizeDozeMode;
    L39:
        if ((r214 & 512) == 0) goto L41;
        int r119 = r110.minutesTokenRetryMaxTimes;
    L43:
        if ((r214 & 1024) == 0) goto L45;
        boolean r108 = r110.enableClientOpenSubtitle;
    L47:
        return r110.copy(r100, r101, r102, r103, r104, r105, r106, r107, r118, r119, r108);
    L45:
        r108 = r213;
        goto L47
    L41:
        r119 = r212;
        goto L43
    L37:
        r118 = r211;
        goto L39
    L33:
        r107 = r210;
        goto L35
    L29:
        r106 = r117;
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
        return this.sliceDurationInSec;
    }

    public final int component10() {
        return this.minutesTokenRetryMaxTimes;
    }

    public final boolean component11() {
        return this.enableClientOpenSubtitle;
    }

    public final boolean component2() {
        return this.tosErrorIntervalRetry;
    }

    public final int component3() {
        return this.backgroundUploadMaxAliveTime;
    }

    public final boolean component4() {
        return this.adaptiveUploadEnable;
    }

    public final int component5() {
        return this.ssthresh;
    }

    public final int component6() {
        return this.maxThresh;
    }

    public final int component7() {
        return this.audioFileCacheMaxAgeDays;
    }

    public final int component8() {
        return this.audioFileCacheThresholdMb;
    }

    public final boolean component9() {
        return this.enableOptimizeDozeMode;
    }

    public final MmRecordGeneralConfig copy(int r110, boolean r111, int r112, boolean r113, int r114, int r115, int r210, int r211, boolean r212, int r213, boolean r214) {
        return new MmRecordGeneralConfig(r110, r111, r112, r113, r114, r115, r210, r211, r212, r213, r214);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof MmRecordGeneralConfig) == true) goto L8;
        return false;
    L8:
        MmRecordGeneralConfig r101 = (MmRecordGeneralConfig) r100;
        if (this.sliceDurationInSec == r101.sliceDurationInSec) goto L12;
        return false;
    L12:
        if (this.tosErrorIntervalRetry == r101.tosErrorIntervalRetry) goto L15;
        return false;
    L15:
        if (this.backgroundUploadMaxAliveTime == r101.backgroundUploadMaxAliveTime) goto L18;
        return false;
    L18:
        if (this.adaptiveUploadEnable == r101.adaptiveUploadEnable) goto L21;
        return false;
    L21:
        if (this.ssthresh == r101.ssthresh) goto L24;
        return false;
    L24:
        if (this.maxThresh == r101.maxThresh) goto L27;
        return false;
    L27:
        if (this.audioFileCacheMaxAgeDays == r101.audioFileCacheMaxAgeDays) goto L30;
        return false;
    L30:
        if (this.audioFileCacheThresholdMb == r101.audioFileCacheThresholdMb) goto L33;
        return false;
    L33:
        if (this.enableOptimizeDozeMode == r101.enableOptimizeDozeMode) goto L36;
        return false;
    L36:
        if (this.minutesTokenRetryMaxTimes == r101.minutesTokenRetryMaxTimes) goto L39;
        return false;
    L39:
        if (this.enableClientOpenSubtitle == r101.enableClientOpenSubtitle) goto L41;
        return false;
    L41:
        return true;
    }

    public int hashCode() {
        int r100 = this.sliceDurationInSec * 31;
        int r101 = 1231;
        if (this.tosErrorIntervalRetry == false) goto L5;
        int r102 = 1231;
    L6:
        int r103 = (((r100 + r102) * 31) + this.backgroundUploadMaxAliveTime) * 31;
        if (this.adaptiveUploadEnable == false) goto L9;
        int r104 = 1231;
    L10:
        int r105 = (((((((((r103 + r104) * 31) + this.ssthresh) * 31) + this.maxThresh) * 31) + this.audioFileCacheMaxAgeDays) * 31) + this.audioFileCacheThresholdMb) * 31;
        if (this.enableOptimizeDozeMode == false) goto L13;
        int r106 = 1231;
    L14:
        int r107 = (((r105 + r106) * 31) + this.minutesTokenRetryMaxTimes) * 31;
        if (this.enableClientOpenSubtitle == true) goto L19;
        r101 = 1237;
    L19:
        return r107 + r101;
    L13:
        r106 = 1237;
        goto L14
    L9:
        r104 = 1237;
        goto L10
    L5:
        r102 = 1237;
        goto L6
    }

    public String toString() {
        return "MmRecordGeneralConfig(sliceDurationInSec=" + this.sliceDurationInSec + ", tosErrorIntervalRetry=" + this.tosErrorIntervalRetry + ", backgroundUploadMaxAliveTime=" + this.backgroundUploadMaxAliveTime + ", adaptiveUploadEnable=" + this.adaptiveUploadEnable + ", ssthresh=" + this.ssthresh + ", maxThresh=" + this.maxThresh + ", audioFileCacheMaxAgeDays=" + this.audioFileCacheMaxAgeDays + ", audioFileCacheThresholdMb=" + this.audioFileCacheThresholdMb + ", enableOptimizeDozeMode=" + this.enableOptimizeDozeMode + ", enableClientOpenSubtitle=" + this.enableClientOpenSubtitle + ')';
    }

    public final boolean getAdaptiveUploadEnable() {
        return this.adaptiveUploadEnable;
    }

    public final int getAudioFileCacheMaxAgeDays() {
        return this.audioFileCacheMaxAgeDays;
    }

    public final int getAudioFileCacheThresholdMb() {
        return this.audioFileCacheThresholdMb;
    }

    public final int getBackgroundUploadMaxAliveTime() {
        return this.backgroundUploadMaxAliveTime;
    }

    public final boolean getEnableClientOpenSubtitle() {
        return this.enableClientOpenSubtitle;
    }

    public final boolean getEnableOptimizeDozeMode() {
        return this.enableOptimizeDozeMode;
    }

    public final int getMaxThresh() {
        return this.maxThresh;
    }

    public final int getMinutesTokenRetryMaxTimes() {
        return this.minutesTokenRetryMaxTimes;
    }

    public final int getSliceDurationInSec() {
        return this.sliceDurationInSec;
    }

    public final int getSsthresh() {
        return this.ssthresh;
    }

    public final boolean getTosErrorIntervalRetry() {
        return this.tosErrorIntervalRetry;
    }

    public MmRecordGeneralConfig(int r100, boolean r101, int r102, boolean r103, int r104, int r105, int r106, int r107, boolean r108, int r110, boolean r111) {
        this.sliceDurationInSec = r100;
        this.tosErrorIntervalRetry = r101;
        this.backgroundUploadMaxAliveTime = r102;
        this.adaptiveUploadEnable = r103;
        this.ssthresh = r104;
        this.maxThresh = r105;
        this.audioFileCacheMaxAgeDays = r106;
        this.audioFileCacheThresholdMb = r107;
        this.enableOptimizeDozeMode = r108;
        this.minutesTokenRetryMaxTimes = r110;
        this.enableClientOpenSubtitle = r111;
    }

    public /* synthetic */ MmRecordGeneralConfig(int r110, boolean r111, int r112, boolean r113, int r114, int r115, int r116, int r117, boolean r210, int r211, boolean r212, int r213, DefaultConstructorMarker r214) {
        if ((r213 & 1) == 0) goto L5;
        int r100 = 3;
    L6:
        boolean r101 = false;
        if ((r213 & 2) == 0) goto L9;
        boolean r102 = false;
    L11:
        if ((r213 & 4) == 0) goto L13;
        int r103 = 1800;
    L15:
        if ((r213 & 8) == 0) goto L17;
        boolean r104 = false;
    L19:
        if ((r213 & 16) == 0) goto L21;
        int r105 = 16;
    L23:
        if ((r213 & 32) == 0) goto L25;
        int r106 = 24;
    L27:
        if ((r213 & 64) == 0) goto L29;
        int r107 = 7;
    L31:
        if ((r213 & 128) == 0) goto L33;
        int r108 = 300;
    L35:
        if ((r213 & 256) != 0) goto L39;
        r101 = r210;
    L39:
        if ((r213 & 512) == 0) goto L41;
        int r118 = 30;
    L43:
        if ((r213 & 1024) == 0) goto L45;
        boolean r109 = true;
    L46:
        this(r100, r102, r103, r104, r105, r106, r107, r108, r101, r118, r109);
        return;
    L45:
        r109 = r212;
        goto L46
    L41:
        r118 = r211;
        goto L43
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
        r100 = r110;
        goto L6
    }
}
