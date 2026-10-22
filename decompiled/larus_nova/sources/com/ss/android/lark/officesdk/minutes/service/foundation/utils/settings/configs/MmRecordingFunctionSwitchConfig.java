package com.ss.android.lark.officesdk.minutes.service.foundation.utils.settings.configs;

import com.google.gson.annotations.SerializedName;
import com.ss.android.lark.appsetting.annotation.AppConfig;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes37.dex */
@AppConfig(key = "vc_function_switch")
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0011\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B'\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\rJ.\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006HÆ\u0001¢\u0006\u0002\u0010\u0013J\u0013\u0010\u0014\u001a\u00020\u00032\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0006HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u001a\u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\f\u0010\r¨\u0006\u0019"}, d2 = {"Lcom/ss/android/lark/officesdk/minutes/service/foundation/utils/settings/configs/MmRecordingFunctionSwitchConfig;", "", "enableMinutesFishbonePreload", "", "hwDeleteLocalFile", "hwAudioDumpFileExpiredDays", "", "<init>", "(ZZLjava/lang/Integer;)V", "getEnableMinutesFishbonePreload", "()Z", "getHwDeleteLocalFile", "getHwAudioDumpFileExpiredDays", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "component1", "component2", "component3", "copy", "(ZZLjava/lang/Integer;)Lcom/ss/android/lark/officesdk/minutes/service/foundation/utils/settings/configs/MmRecordingFunctionSwitchConfig;", "equals", "other", "hashCode", "toString", "", "officesdk-minutes-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class MmRecordingFunctionSwitchConfig {

    @SerializedName("enableMinutesFishbonePreload")
    private final boolean enableMinutesFishbonePreload;

    @SerializedName("hwAudioDumpFileExpiredDays")
    private final Integer hwAudioDumpFileExpiredDays;

    @SerializedName("hwDeleteLocalFile")
    private final boolean hwDeleteLocalFile;

    public MmRecordingFunctionSwitchConfig() {
        this(0);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof MmRecordingFunctionSwitchConfig) == true) goto L8;
        return false;
    L8:
        MmRecordingFunctionSwitchConfig r101 = (MmRecordingFunctionSwitchConfig) r100;
        if (this.enableMinutesFishbonePreload == r101.enableMinutesFishbonePreload) goto L12;
        return false;
    L12:
        if (this.hwDeleteLocalFile == r101.hwDeleteLocalFile) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.hwAudioDumpFileExpiredDays, r101.hwAudioDumpFileExpiredDays) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        int r100 = 1231;
        if (this.enableMinutesFishbonePreload == false) goto L5;
        int r101 = 1231;
    L6:
        int r102 = r101 * 31;
        if (this.hwDeleteLocalFile == true) goto L10;
        r100 = 1237;
    L10:
        int r103 = (r102 + r100) * 31;
        Integer r104 = this.hwAudioDumpFileExpiredDays;
        if (r104 != null) goto L13;
        int r105 = 0;
    L15:
        return r103 + r105;
    L13:
        r105 = r104.hashCode();
        goto L15
    L5:
        r101 = 1237;
        goto L6
    }

    public final String toString() {
        return "MmRecordingFunctionSwitchConfig(enableMinutesFishbonePreload=" + this.enableMinutesFishbonePreload + ", hwDeleteLocalFile=" + this.hwDeleteLocalFile + ", hwAudioDumpFileExpiredDays=" + this.hwAudioDumpFileExpiredDays + ')';
    }

    public MmRecordingFunctionSwitchConfig(int r100) {
        this.enableMinutesFishbonePreload = false;
        this.hwDeleteLocalFile = true;
        this.hwAudioDumpFileExpiredDays = null;
    }
}
