package com.ss.android.lark.officesdk.minutes.service.foundation.utils.settings.configs;

import com.google.gson.annotations.SerializedName;
import com.ss.android.lark.appsetting.annotation.AppConfig;
import com.ss.android.lark.officesdk.minutes.service.recording.common.core.service.adudio.rtc.MmAnsMode;
import java.io.Serializable;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes37.dex */
@AppConfig(key = "vc_remote_audio_setting")
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0017\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0087\b\u0018\u00002\u00020\u0001BU\b\u0007\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\u0016\b\u0002\u0010\t\u001a\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\b\u0018\u00010\n¢\u0006\u0004\b\f\u0010\rJ\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0011J\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001d\u001a\u00020\bHÆ\u0003J\u0017\u0010\u001e\u001a\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\b\u0018\u00010\nHÆ\u0003JZ\u0010\u001f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\b2\u0016\b\u0002\u0010\t\u001a\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\b\u0018\u00010\nHÆ\u0001¢\u0006\u0002\u0010 J\u0013\u0010!\u001a\u00020\b2\b\u0010\"\u001a\u0004\u0018\u00010#HÖ\u0003J\t\u0010$\u001a\u00020\u0003HÖ\u0001J\t\u0010%\u001a\u00020\u000bHÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0005\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u000fR\u0016\u0010\u0006\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u000fR\u0016\u0010\u0007\u001a\u00020\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R$\u0010\t\u001a\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\b\u0018\u00010\n8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018¨\u0006&"}, d2 = {"Lcom/ss/android/lark/officesdk/minutes/service/foundation/utils/settings/configs/MmRecordingRemoteAudioSetting;", "Ljava/io/Serializable;", "mmAnsLevel", "", "mmAecOption", "mmAudioChannel", "mmAudioSampleRate", "enableMMAudioMode", "", "mmAudioFg", "", "", "<init>", "(ILjava/lang/Integer;IIZLjava/util/Map;)V", "getMmAnsLevel", "()I", "getMmAecOption", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getMmAudioChannel", "getMmAudioSampleRate", "getEnableMMAudioMode", "()Z", "getMmAudioFg", "()Ljava/util/Map;", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "(ILjava/lang/Integer;IIZLjava/util/Map;)Lcom/ss/android/lark/officesdk/minutes/service/foundation/utils/settings/configs/MmRecordingRemoteAudioSetting;", "equals", "other", "", "hashCode", "toString", "officesdk-minutes-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class MmRecordingRemoteAudioSetting implements Serializable {

    @SerializedName("enableMMAudioMode")
    private final boolean enableMMAudioMode;

    @SerializedName("mmAecOption")
    private final Integer mmAecOption;

    @SerializedName("mmAnsLevel")
    private final int mmAnsLevel;

    @SerializedName("mmAudioChannel")
    private final int mmAudioChannel;

    @SerializedName("mmAudioFg")
    private final Map<String, Boolean> mmAudioFg;

    @SerializedName("mmAudioSampleRate")
    private final int mmAudioSampleRate;

    public MmRecordingRemoteAudioSetting() {
        this(0, null, 0, 0, false, null, 63, null);
    }

    public MmRecordingRemoteAudioSetting(int r110) {
        this(r110, null, 0, 0, false, null, 62, null);
    }

    public MmRecordingRemoteAudioSetting(int r110, Integer r111) {
        this(r110, r111, 0, 0, false, null, 60, null);
    }

    public MmRecordingRemoteAudioSetting(int r110, Integer r111, int r112) {
        this(r110, r111, r112, 0, false, null, 56, null);
    }

    public MmRecordingRemoteAudioSetting(int r110, Integer r111, int r112, int r113) {
        this(r110, r111, r112, r113, false, null, 48, null);
    }

    public MmRecordingRemoteAudioSetting(int r110, Integer r111, int r112, int r113, boolean r114) {
        this(r110, r111, r112, r113, r114, null, 32, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ MmRecordingRemoteAudioSetting copy$default(MmRecordingRemoteAudioSetting r100, int r101, Integer r102, int r103, int r104, boolean r105, Map r110, int r111, Object r112) {
        if ((r111 & 1) == 0) goto L6;
        r101 = r100.mmAnsLevel;
    L6:
        if ((r111 & 2) == 0) goto L8;
        r102 = r100.mmAecOption;
    L8:
        Integer r113 = r102;
        if ((r111 & 4) == 0) goto L11;
        r103 = r100.mmAudioChannel;
    L11:
        int r106 = r103;
        if ((r111 & 8) == 0) goto L14;
        r104 = r100.mmAudioSampleRate;
    L14:
        int r107 = r104;
        if ((r111 & 16) == 0) goto L17;
        r105 = r100.enableMMAudioMode;
    L17:
        boolean r108 = r105;
        if ((r111 & 32) == 0) goto L20;
        r110 = r100.mmAudioFg;
    L20:
        int r109 = r101;
        return r100.copy(r109, r113, r106, r107, r108, r110);
    }

    public final int component1() {
        return this.mmAnsLevel;
    }

    public final Integer component2() {
        return this.mmAecOption;
    }

    public final int component3() {
        return this.mmAudioChannel;
    }

    public final int component4() {
        return this.mmAudioSampleRate;
    }

    public final boolean component5() {
        return this.enableMMAudioMode;
    }

    public final Map<String, Boolean> component6() {
        return this.mmAudioFg;
    }

    public final MmRecordingRemoteAudioSetting copy(int r100, Integer r110, int r111, int r112, boolean r113, Map<String, Boolean> r114) {
        return new MmRecordingRemoteAudioSetting(r100, r110, r111, r112, r113, r114);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof MmRecordingRemoteAudioSetting) == true) goto L8;
        return false;
    L8:
        MmRecordingRemoteAudioSetting r101 = (MmRecordingRemoteAudioSetting) r100;
        if (this.mmAnsLevel == r101.mmAnsLevel) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.mmAecOption, r101.mmAecOption) == true) goto L15;
        return false;
    L15:
        if (this.mmAudioChannel == r101.mmAudioChannel) goto L18;
        return false;
    L18:
        if (this.mmAudioSampleRate == r101.mmAudioSampleRate) goto L21;
        return false;
    L21:
        if (this.enableMMAudioMode == r101.enableMMAudioMode) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.mmAudioFg, r101.mmAudioFg) == true) goto L26;
        return false;
    L26:
        return true;
    }

    public int hashCode() {
        int r100 = this.mmAnsLevel * 31;
        Integer r101 = this.mmAecOption;
        int r102 = 0;
        if (r101 != null) goto L5;
        int r103 = 0;
    L6:
        int r104 = (((((r100 + r103) * 31) + this.mmAudioChannel) * 31) + this.mmAudioSampleRate) * 31;
        if (this.enableMMAudioMode == false) goto L9;
        int r105 = 1231;
    L10:
        int r106 = (r104 + r105) * 31;
        Map<String, Boolean> r107 = this.mmAudioFg;
        if (r107 == null) goto L15;
        r102 = r107.hashCode();
    L15:
        return r106 + r102;
    L9:
        r105 = 1237;
        goto L10
    L5:
        r103 = r101.hashCode();
        goto L6
    }

    public String toString() {
        return "MmRecordingRemoteAudioSetting(mmAnsLevel=" + this.mmAnsLevel + ", mmAecOption=" + this.mmAecOption + ", mmAudioChannel=" + this.mmAudioChannel + ", mmAudioSampleRate=" + this.mmAudioSampleRate + ", enableMMAudioMode=" + this.enableMMAudioMode + ", mmAudioFg=" + this.mmAudioFg + ')';
    }

    public final boolean getEnableMMAudioMode() {
        return this.enableMMAudioMode;
    }

    public final Integer getMmAecOption() {
        return this.mmAecOption;
    }

    public final int getMmAnsLevel() {
        return this.mmAnsLevel;
    }

    public final int getMmAudioChannel() {
        return this.mmAudioChannel;
    }

    public final Map<String, Boolean> getMmAudioFg() {
        return this.mmAudioFg;
    }

    public final int getMmAudioSampleRate() {
        return this.mmAudioSampleRate;
    }

    public MmRecordingRemoteAudioSetting(int r100, Integer r101, int r102, int r103, boolean r104, Map<String, Boolean> r105) {
        this.mmAnsLevel = r100;
        this.mmAecOption = r101;
        this.mmAudioChannel = r102;
        this.mmAudioSampleRate = r103;
        this.enableMMAudioMode = r104;
        this.mmAudioFg = r105;
    }

    public /* synthetic */ MmRecordingRemoteAudioSetting(int r100, Integer r101, int r102, int r103, boolean r104, Map r110, int r111, DefaultConstructorMarker r112) {
        if ((r111 & 1) == 0) goto L5;
        r100 = MmAnsMode.ANS_MODE_LOW.getValue();
    L5:
        Map r105 = null;
        if ((r111 & 2) == 0) goto L8;
        Integer r113 = null;
    L10:
        if ((r111 & 4) == 0) goto L12;
        int r106 = 2;
    L14:
        if ((r111 & 8) == 0) goto L16;
        int r107 = 16000;
    L18:
        if ((r111 & 16) == 0) goto L20;
        boolean r108 = true;
    L22:
        if ((r111 & 32) != 0) goto L25;
        r105 = r110;
    L25:
        this(r100, r113, r106, r107, r108, r105);
        return;
    L20:
        r108 = r104;
        goto L22
    L16:
        r107 = r103;
        goto L18
    L12:
        r106 = r102;
        goto L14
    L8:
        r113 = r101;
        goto L10
    }
}
