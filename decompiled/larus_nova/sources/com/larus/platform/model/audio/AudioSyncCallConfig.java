package com.larus.platform.model.audio;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B%\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J'\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\r\u001a\u00020\u00032\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\bR\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\bR\u0016\u0010\u0005\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\b¨\u0006\u0013"}, d2 = {"Lcom/larus/platform/model/audio/AudioSyncCallConfig;", "", "isEnableSyncAsrTts", "", "isEnableSyncDora", "isEnableSyncAsrTtsSpeechRate", "<init>", "(ZZZ)V", "()Z", "component1", "component2", "component3", "copy", "equals", "other", "hashCode", "", "toString", "", "platform_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AudioSyncCallConfig {

    @SerializedName("enable_sync_asr_tts")
    private final boolean isEnableSyncAsrTts;

    @SerializedName("enable_sync_asr_tts_speech_rate")
    private final boolean isEnableSyncAsrTtsSpeechRate;

    @SerializedName("enable_sync_dora")
    private final boolean isEnableSyncDora;

    public AudioSyncCallConfig() {
        this(false, false, false, 7, null);
    }

    public static /* synthetic */ AudioSyncCallConfig copy$default(AudioSyncCallConfig r100, boolean r101, boolean r102, boolean r103, int r104, Object r105) {
        if ((r104 & 1) == 0) goto L6;
        r101 = r100.isEnableSyncAsrTts;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r102 = r100.isEnableSyncDora;
    L9:
        if ((r104 & 4) == 0) goto L12;
        r103 = r100.isEnableSyncAsrTtsSpeechRate;
    L12:
        return r100.copy(r101, r102, r103);
    }

    public final boolean component1() {
        return this.isEnableSyncAsrTts;
    }

    public final boolean component2() {
        return this.isEnableSyncDora;
    }

    public final boolean component3() {
        return this.isEnableSyncAsrTtsSpeechRate;
    }

    public final AudioSyncCallConfig copy(boolean r100, boolean r101, boolean r102) {
        return new AudioSyncCallConfig(r100, r101, r102);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof AudioSyncCallConfig) == true) goto L8;
        return false;
    L8:
        AudioSyncCallConfig r101 = (AudioSyncCallConfig) r100;
        if (this.isEnableSyncAsrTts == r101.isEnableSyncAsrTts) goto L12;
        return false;
    L12:
        if (this.isEnableSyncDora == r101.isEnableSyncDora) goto L15;
        return false;
    L15:
        if (this.isEnableSyncAsrTtsSpeechRate == r101.isEnableSyncAsrTtsSpeechRate) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        int r100 = 1231;
        if (this.isEnableSyncAsrTts == false) goto L5;
        int r101 = 1231;
    L6:
        int r102 = r101 * 31;
        if (this.isEnableSyncDora == false) goto L9;
        int r103 = 1231;
    L10:
        int r104 = (r102 + r103) * 31;
        if (this.isEnableSyncAsrTtsSpeechRate == true) goto L15;
        r100 = 1237;
    L15:
        return r104 + r100;
    L9:
        r103 = 1237;
        goto L10
    L5:
        r101 = 1237;
        goto L6
    }

    public String toString() {
        return "AudioSyncCallConfig(isEnableSyncAsrTts=" + this.isEnableSyncAsrTts + ", isEnableSyncDora=" + this.isEnableSyncDora + ", isEnableSyncAsrTtsSpeechRate=" + this.isEnableSyncAsrTtsSpeechRate + ')';
    }

    public final boolean isEnableSyncAsrTts() {
        return this.isEnableSyncAsrTts;
    }

    public final boolean isEnableSyncAsrTtsSpeechRate() {
        return this.isEnableSyncAsrTtsSpeechRate;
    }

    public final boolean isEnableSyncDora() {
        return this.isEnableSyncDora;
    }

    public AudioSyncCallConfig(boolean r100, boolean r101, boolean r102) {
        this.isEnableSyncAsrTts = r100;
        this.isEnableSyncDora = r101;
        this.isEnableSyncAsrTtsSpeechRate = r102;
    }

    public /* synthetic */ AudioSyncCallConfig(boolean r100, boolean r101, boolean r102, int r103, DefaultConstructorMarker r104) {
        if ((r103 & 1) == 0) goto L6;
        r100 = false;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r101 = false;
    L9:
        if ((r103 & 4) == 0) goto L11;
        r102 = false;
    L11:
        this(r100, r101, r102);
    }
}
