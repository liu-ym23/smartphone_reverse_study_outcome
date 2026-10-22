package com.ss.android.lark.audio.config;

import com.google.gson.annotations.SerializedName;
import com.ss.android.lark.appsetting.annotation.AppConfig;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes34.dex */
@AppConfig(key = "im_audio_sensor")
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0011\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u001f\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\bJ\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\bJ&\u0010\u0010\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010\u0011J\u0013\u0010\u0012\u001a\u00020\u00032\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001R\"\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u000b\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\"\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u000b\u001a\u0004\b\f\u0010\b\"\u0004\b\r\u0010\n¨\u0006\u0018"}, d2 = {"Lcom/ss/android/lark/audio/config/AudioSensorConfig;", "", "proximitySensorEnable", "", "screenOffWakeLockEnable", "<init>", "(Ljava/lang/Boolean;Ljava/lang/Boolean;)V", "getProximitySensorEnable", "()Ljava/lang/Boolean;", "setProximitySensorEnable", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "getScreenOffWakeLockEnable", "setScreenOffWakeLockEnable", "component1", "component2", "copy", "(Ljava/lang/Boolean;Ljava/lang/Boolean;)Lcom/ss/android/lark/audio/config/AudioSensorConfig;", "equals", "other", "hashCode", "", "toString", "", "audio_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AudioSensorConfig {

    @SerializedName("proximity_sensor")
    private Boolean proximitySensorEnable;

    @SerializedName("screen_off_wake_lock")
    private Boolean screenOffWakeLockEnable;

    public AudioSensorConfig() {
        this(null, null);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof AudioSensorConfig) == true) goto L8;
        return false;
    L8:
        AudioSensorConfig r101 = (AudioSensorConfig) r100;
        if (Intrinsics.areEqual(this.proximitySensorEnable, r101.proximitySensorEnable) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.screenOffWakeLockEnable, r101.screenOffWakeLockEnable) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        Boolean r100 = this.proximitySensorEnable;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        Boolean r104 = this.screenOffWakeLockEnable;
        if (r104 == null) goto L11;
        r101 = r104.hashCode();
    L11:
        return r103 + r101;
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "AudioSensorConfig(proximitySensorEnable=" + this.proximitySensorEnable + ", screenOffWakeLockEnable=" + this.screenOffWakeLockEnable + ')';
    }

    public final Boolean a() {
        return this.proximitySensorEnable;
    }

    public final Boolean b() {
        return this.screenOffWakeLockEnable;
    }

    public AudioSensorConfig(Boolean r100, Boolean r101) {
        this.proximitySensorEnable = r100;
        this.screenOffWakeLockEnable = r101;
    }
}
