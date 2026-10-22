package com.bytedance.flow_audio.api.foundation.record;

import androidx.core.app.NotificationCompat;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/bytedance/flow_audio/api/foundation/record/AudioEngineSceneType;", "", "rawValue", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getRawValue", "()Ljava/lang/String;", "CALL", "ASR", "TTS", "flow_audio_api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum AudioEngineSceneType extends Enum<AudioEngineSceneType> {
    public static final AudioEngineSceneType ASR = null;
    public static final AudioEngineSceneType CALL = null;
    public static final AudioEngineSceneType TTS = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ AudioEngineSceneType[] f243708a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f243709b = null;
    private final String rawValue;

    public static EnumEntries<AudioEngineSceneType> getEntries() {
        return f243709b;
    }

    static {
        AudioEngineSceneType r100 = new AudioEngineSceneType("CALL", 0, NotificationCompat.CATEGORY_CALL);
        CALL = r100;
        AudioEngineSceneType r101 = new AudioEngineSceneType("ASR", 1, "asr");
        ASR = r101;
        AudioEngineSceneType r102 = new AudioEngineSceneType("TTS", 2, "tts");
        TTS = r102;
        AudioEngineSceneType[] r103 = {r100, r101, r102};
        f243708a = r103;
        f243709b = EnumEntriesKt.enumEntries(r103);
    }

    public static AudioEngineSceneType[] values() {
        return (AudioEngineSceneType[]) f243708a.clone();
    }

    public final String getRawValue() {
        return this.rawValue;
    }

    public static AudioEngineSceneType valueOf(String r100) {
        return (AudioEngineSceneType) r27.a.a(AudioEngineSceneType.class, r100);
    }

    public AudioEngineSceneType(String r100, int r101, String r102) {
        super(r100, r101);
        this.rawValue = r102;
    }
}
