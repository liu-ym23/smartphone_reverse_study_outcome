package com.obric.assistant;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0019\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001BW\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007\u0012\b\b\u0002\u0010\t\u001a\u00020\n\u0012\b\b\u0002\u0010\u000b\u001a\u00020\n\u0012\b\b\u0002\u0010\f\u001a\u00020\u0007¢\u0006\u0004\b\r\u0010\u000eJ\t\u0010\u001a\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0007HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0007HÆ\u0003J\t\u0010\u001f\u001a\u00020\nHÆ\u0003J\t\u0010 \u001a\u00020\nHÆ\u0003J\t\u0010!\u001a\u00020\u0007HÆ\u0003JY\u0010\"\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\n2\b\b\u0002\u0010\f\u001a\u00020\u0007HÆ\u0001J\u0013\u0010#\u001a\u00020$2\b\u0010%\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010&\u001a\u00020\u0007HÖ\u0001J\t\u0010'\u001a\u00020(HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010R\u0016\u0010\u0005\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0010R\u0016\u0010\u0006\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0016\u0010\b\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0014R\u0016\u0010\t\u001a\u00020\n8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0016\u0010\u000b\u001a\u00020\n8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0017R\u0016\u0010\f\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0014¨\u0006)"}, d2 = {"Lcom/obric/assistant/UpdateSettingsConfig;", "", "obricUpdateMainInstallDialogInterval", "", "obricUpdateBannerShowInterval", "obricUpdateCheckResultCacheTime", "obricUpdateScheduledCheckStartHour", "", "obricUpdateScheduledCheckEndHour", "obricUpdateTemperatureBlockThreshold", "", "obricUpdateTemperaturePauseThreshold", "obricUpdateTemperatureProgressThreshold", "<init>", "(JJJIIFFI)V", "getObricUpdateMainInstallDialogInterval", "()J", "getObricUpdateBannerShowInterval", "getObricUpdateCheckResultCacheTime", "getObricUpdateScheduledCheckStartHour", "()I", "getObricUpdateScheduledCheckEndHour", "getObricUpdateTemperatureBlockThreshold", "()F", "getObricUpdateTemperaturePauseThreshold", "getObricUpdateTemperatureProgressThreshold", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "equals", "", "other", "hashCode", "toString", "", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class UpdateSettingsConfig {

    @SerializedName("obric_update_banner_show_interval")
    private final long obricUpdateBannerShowInterval;

    @SerializedName("obric_update_check_result_cache_time")
    private final long obricUpdateCheckResultCacheTime;

    @SerializedName("obric_update_main_install_dialog_interval")
    private final long obricUpdateMainInstallDialogInterval;

    @SerializedName("obric_update_scheduled_check_end_hour")
    private final int obricUpdateScheduledCheckEndHour;

    @SerializedName("obric_update_scheduled_check_start_hour")
    private final int obricUpdateScheduledCheckStartHour;

    @SerializedName("obric_update_temperature_block_threshold")
    private final float obricUpdateTemperatureBlockThreshold;

    @SerializedName("obric_update_temperature_pause_threshold")
    private final float obricUpdateTemperaturePauseThreshold;

    @SerializedName("obric_update_temperature_progress_threshold")
    private final int obricUpdateTemperatureProgressThreshold;

    public UpdateSettingsConfig() {
        this(0, 0, 0, 0, 0, 0.0f, 0.0f, 0, 255, null);
    }

    public static /* synthetic */ UpdateSettingsConfig copy$default(UpdateSettingsConfig r110, long r111, long r112, long r113, int r114, int r210, float r211, float r212, int r213, int r214, Object r215) {
        if ((r214 & 1) == 0) goto L5;
        long r100 = r110.obricUpdateMainInstallDialogInterval;
    L7:
        if ((r214 & 2) == 0) goto L9;
        long r101 = r110.obricUpdateBannerShowInterval;
    L11:
        if ((r214 & 4) == 0) goto L13;
        long r102 = r110.obricUpdateCheckResultCacheTime;
    L15:
        if ((r214 & 8) == 0) goto L17;
        int r103 = r110.obricUpdateScheduledCheckStartHour;
    L19:
        if ((r214 & 16) == 0) goto L21;
        int r104 = r110.obricUpdateScheduledCheckEndHour;
    L23:
        if ((r214 & 32) == 0) goto L25;
        float r115 = r110.obricUpdateTemperatureBlockThreshold;
    L27:
        if ((r214 & 64) == 0) goto L29;
        float r116 = r110.obricUpdateTemperaturePauseThreshold;
    L31:
        if ((r214 & 128) == 0) goto L33;
        int r105 = r110.obricUpdateTemperatureProgressThreshold;
    L35:
        return r110.copy(r100, r101, r102, r103, r104, r115, r116, r105);
    L33:
        r105 = r213;
        goto L35
    L29:
        r116 = r212;
        goto L31
    L25:
        r115 = r211;
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

    public final long component1() {
        return this.obricUpdateMainInstallDialogInterval;
    }

    public final long component2() {
        return this.obricUpdateBannerShowInterval;
    }

    public final long component3() {
        return this.obricUpdateCheckResultCacheTime;
    }

    public final int component4() {
        return this.obricUpdateScheduledCheckStartHour;
    }

    public final int component5() {
        return this.obricUpdateScheduledCheckEndHour;
    }

    public final float component6() {
        return this.obricUpdateTemperatureBlockThreshold;
    }

    public final float component7() {
        return this.obricUpdateTemperaturePauseThreshold;
    }

    public final int component8() {
        return this.obricUpdateTemperatureProgressThreshold;
    }

    public final UpdateSettingsConfig copy(long r110, long r111, long r112, int r210, int r211, float r212, float r213, int r214) {
        return new UpdateSettingsConfig(r110, r111, r112, r210, r211, r212, r213, r214);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof UpdateSettingsConfig) == true) goto L8;
        return false;
    L8:
        UpdateSettingsConfig r101 = (UpdateSettingsConfig) r100;
        if (this.obricUpdateMainInstallDialogInterval == r101.obricUpdateMainInstallDialogInterval) goto L12;
        return false;
    L12:
        if (this.obricUpdateBannerShowInterval == r101.obricUpdateBannerShowInterval) goto L15;
        return false;
    L15:
        if (this.obricUpdateCheckResultCacheTime == r101.obricUpdateCheckResultCacheTime) goto L18;
        return false;
    L18:
        if (this.obricUpdateScheduledCheckStartHour == r101.obricUpdateScheduledCheckStartHour) goto L21;
        return false;
    L21:
        if (this.obricUpdateScheduledCheckEndHour == r101.obricUpdateScheduledCheckEndHour) goto L24;
        return false;
    L24:
        if (Float.compare(this.obricUpdateTemperatureBlockThreshold, r101.obricUpdateTemperatureBlockThreshold) == 0) goto L27;
        return false;
    L27:
        if (Float.compare(this.obricUpdateTemperaturePauseThreshold, r101.obricUpdateTemperaturePauseThreshold) == 0) goto L30;
        return false;
    L30:
        if (this.obricUpdateTemperatureProgressThreshold == r101.obricUpdateTemperatureProgressThreshold) goto L32;
        return false;
    L32:
        return true;
    }

    public int hashCode() {
        long r100 = this.obricUpdateMainInstallDialogInterval;
        int r101 = ((int) (r100 ^ (r100 >>> 32))) * 31;
        long r102 = this.obricUpdateBannerShowInterval;
        int r103 = (r101 + ((int) (r102 ^ (r102 >>> 32)))) * 31;
        long r104 = this.obricUpdateCheckResultCacheTime;
        return ((((((((((r103 + ((int) (r104 ^ (r104 >>> 32)))) * 31) + this.obricUpdateScheduledCheckStartHour) * 31) + this.obricUpdateScheduledCheckEndHour) * 31) + Float.floatToIntBits(this.obricUpdateTemperatureBlockThreshold)) * 31) + Float.floatToIntBits(this.obricUpdateTemperaturePauseThreshold)) * 31) + this.obricUpdateTemperatureProgressThreshold;
    }

    public String toString() {
        return "UpdateSettingsConfig(obricUpdateMainInstallDialogInterval=" + this.obricUpdateMainInstallDialogInterval + ", obricUpdateBannerShowInterval=" + this.obricUpdateBannerShowInterval + ", obricUpdateCheckResultCacheTime=" + this.obricUpdateCheckResultCacheTime + ", obricUpdateScheduledCheckStartHour=" + this.obricUpdateScheduledCheckStartHour + ", obricUpdateScheduledCheckEndHour=" + this.obricUpdateScheduledCheckEndHour + ", obricUpdateTemperatureBlockThreshold=" + this.obricUpdateTemperatureBlockThreshold + ", obricUpdateTemperaturePauseThreshold=" + this.obricUpdateTemperaturePauseThreshold + ", obricUpdateTemperatureProgressThreshold=" + this.obricUpdateTemperatureProgressThreshold + ')';
    }

    public final long getObricUpdateBannerShowInterval() {
        return this.obricUpdateBannerShowInterval;
    }

    public final long getObricUpdateCheckResultCacheTime() {
        return this.obricUpdateCheckResultCacheTime;
    }

    public final long getObricUpdateMainInstallDialogInterval() {
        return this.obricUpdateMainInstallDialogInterval;
    }

    public final int getObricUpdateScheduledCheckEndHour() {
        return this.obricUpdateScheduledCheckEndHour;
    }

    public final int getObricUpdateScheduledCheckStartHour() {
        return this.obricUpdateScheduledCheckStartHour;
    }

    public final float getObricUpdateTemperatureBlockThreshold() {
        return this.obricUpdateTemperatureBlockThreshold;
    }

    public final float getObricUpdateTemperaturePauseThreshold() {
        return this.obricUpdateTemperaturePauseThreshold;
    }

    public final int getObricUpdateTemperatureProgressThreshold() {
        return this.obricUpdateTemperatureProgressThreshold;
    }

    public UpdateSettingsConfig(long r100, long r101, long r102, int r103, int r104, float r105, float r110, int r111) {
        this.obricUpdateMainInstallDialogInterval = r100;
        this.obricUpdateBannerShowInterval = r101;
        this.obricUpdateCheckResultCacheTime = r102;
        this.obricUpdateScheduledCheckStartHour = r103;
        this.obricUpdateScheduledCheckEndHour = r104;
        this.obricUpdateTemperatureBlockThreshold = r105;
        this.obricUpdateTemperaturePauseThreshold = r110;
        this.obricUpdateTemperatureProgressThreshold = r111;
    }

    public /* synthetic */ UpdateSettingsConfig(long r110, long r111, long r112, int r113, int r114, float r210, float r211, int r212, int r213, DefaultConstructorMarker r214) {
        long r100 = 86400;
        if ((r213 & 1) == 0) goto L5;
        long r101 = 86400;
    L7:
        if ((r213 & 2) != 0) goto L11;
        r100 = r111;
    L11:
        if ((r213 & 4) == 0) goto L13;
        long r102 = 1800;
    L15:
        if ((r213 & 8) == 0) goto L17;
        int r103 = 19;
    L19:
        if ((r213 & 16) == 0) goto L21;
        int r104 = 22;
    L23:
        if ((r213 & 32) == 0) goto L25;
        float r105 = 36.0f;
    L27:
        if ((r213 & 64) == 0) goto L29;
        float r115 = 40.0f;
    L31:
        if ((r213 & 128) == 0) goto L33;
        int r106 = 70;
    L34:
        this(r101, r100, r102, r103, r104, r105, r115, r106);
        return;
    L33:
        r106 = r212;
        goto L34
    L29:
        r115 = r211;
        goto L31
    L25:
        r105 = r210;
        goto L27
    L21:
        r104 = r114;
        goto L23
    L17:
        r103 = r113;
        goto L19
    L13:
        r102 = r112;
        goto L15
    L5:
        r101 = r110;
        goto L7
    }
}
