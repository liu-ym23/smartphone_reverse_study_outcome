package com.mammon.speechaudiosdk.kmp.param.va;

import com.mammon.speechaudiosdk.kmp.param.SpeechAudioConfigParam;
import com.ss.android.lark.officesdk.minutes.service.recording.common.repo.endwindow.MmEndWindowAvatar;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes32.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B3\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0005HÆ\u0003J7\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001J\t\u0010\u001a\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\r¨\u0006\u001b"}, d2 = {"Lcom/mammon/speechaudiosdk/kmp/param/va/SpeechVoiceAssistantSessionTtsContextParam;", "", "audioConfig", "Lcom/mammon/speechaudiosdk/kmp/param/SpeechAudioConfigParam;", MmEndWindowAvatar.TYPE_SPEAKER, "", "extra", "internalParam", "<init>", "(Lcom/mammon/speechaudiosdk/kmp/param/SpeechAudioConfigParam;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getAudioConfig", "()Lcom/mammon/speechaudiosdk/kmp/param/SpeechAudioConfigParam;", "getSpeaker", "()Ljava/lang/String;", "getExtra", "getInternalParam", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "speech_audiosdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class SpeechVoiceAssistantSessionTtsContextParam {
    private final SpeechAudioConfigParam audioConfig;
    private final String extra;
    private final String internalParam;
    private final String speaker;

    public static /* synthetic */ SpeechVoiceAssistantSessionTtsContextParam copy$default(SpeechVoiceAssistantSessionTtsContextParam r100, SpeechAudioConfigParam r101, String r102, String r103, String r104, int r105, Object r106) {
        if ((r105 & 1) == 0) goto L6;
        r101 = r100.audioConfig;
    L6:
        if ((r105 & 2) == 0) goto L9;
        r102 = r100.speaker;
    L9:
        if ((r105 & 4) == 0) goto L12;
        r103 = r100.extra;
    L12:
        if ((r105 & 8) == 0) goto L15;
        r104 = r100.internalParam;
    L15:
        return r100.copy(r101, r102, r103, r104);
    }

    public final SpeechAudioConfigParam component1() {
        return this.audioConfig;
    }

    public final String component2() {
        return this.speaker;
    }

    public final String component3() {
        return this.extra;
    }

    public final String component4() {
        return this.internalParam;
    }

    public final SpeechVoiceAssistantSessionTtsContextParam copy(SpeechAudioConfigParam r100, String r101, String r102, String r103) {
        Intrinsics.checkNotNullParameter(r100, "audioConfig");
        return new SpeechVoiceAssistantSessionTtsContextParam(r100, r101, r102, r103);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof SpeechVoiceAssistantSessionTtsContextParam) == true) goto L8;
        return false;
    L8:
        SpeechVoiceAssistantSessionTtsContextParam r101 = (SpeechVoiceAssistantSessionTtsContextParam) r100;
        if (Intrinsics.areEqual(this.audioConfig, r101.audioConfig) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.speaker, r101.speaker) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.extra, r101.extra) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.internalParam, r101.internalParam) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public int hashCode() {
        int r100 = this.audioConfig.hashCode() * 31;
        String r101 = this.speaker;
        int r102 = 0;
        if (r101 != null) goto L5;
        int r103 = 0;
    L6:
        int r104 = (r100 + r103) * 31;
        String r105 = this.extra;
        if (r105 != null) goto L9;
        int r106 = 0;
    L10:
        int r107 = (r104 + r106) * 31;
        String r108 = this.internalParam;
        if (r108 == null) goto L15;
        r102 = r108.hashCode();
    L15:
        return r107 + r102;
    L9:
        r106 = r105.hashCode();
        goto L10
    L5:
        r103 = r101.hashCode();
        goto L6
    }

    public String toString() {
        return "SpeechVoiceAssistantSessionTtsContextParam(audioConfig=" + this.audioConfig + ", speaker=" + this.speaker + ", extra=" + this.extra + ", internalParam=" + this.internalParam + ')';
    }

    public final SpeechAudioConfigParam getAudioConfig() {
        return this.audioConfig;
    }

    public final String getExtra() {
        return this.extra;
    }

    public final String getInternalParam() {
        return this.internalParam;
    }

    public final String getSpeaker() {
        return this.speaker;
    }

    public SpeechVoiceAssistantSessionTtsContextParam(SpeechAudioConfigParam r100, String r101, String r102, String r103) {
        Intrinsics.checkNotNullParameter(r100, "audioConfig");
        this.audioConfig = r100;
        this.speaker = r101;
        this.extra = r102;
        this.internalParam = r103;
    }

    public /* synthetic */ SpeechVoiceAssistantSessionTtsContextParam(SpeechAudioConfigParam r100, String r101, String r102, String r103, int r104, DefaultConstructorMarker r105) {
        if ((r104 & 2) == 0) goto L6;
        r101 = null;
    L6:
        if ((r104 & 4) == 0) goto L9;
        r102 = null;
    L9:
        if ((r104 & 8) == 0) goto L11;
        r103 = null;
    L11:
        this(r100, r101, r102, r103);
    }
}
