package com.bytedance.live.livelink.kmp.api.core.audio;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/live/livelink/kmp/api/core/audio/AudioMode;", "", "MODE_MIC", "MODE_VOICE_COMMUNICATION", "MODE_VOICE_CALL", "live-link-kmp-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final enum AudioMode extends Enum<AudioMode> {
    public static final AudioMode MODE_MIC = null;
    public static final AudioMode MODE_VOICE_CALL = null;
    public static final AudioMode MODE_VOICE_COMMUNICATION = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ AudioMode[] f255230a = null;

    static {
        AudioMode r100 = new AudioMode("MODE_MIC", 0);
        MODE_MIC = r100;
        AudioMode r101 = new AudioMode("MODE_VOICE_COMMUNICATION", 1);
        MODE_VOICE_COMMUNICATION = r101;
        AudioMode r102 = new AudioMode("MODE_VOICE_CALL", 2);
        MODE_VOICE_CALL = r102;
        f255230a = new AudioMode[]{r100, r101, r102};
    }

    public static AudioMode valueOf(String r100) {
        return (AudioMode) a.a(AudioMode.class, r100);
    }

    public static AudioMode[] values() {
        return (AudioMode[]) f255230a.clone();
    }

    public AudioMode(String r100, int r101) {
        super(r100, r101);
    }
}
