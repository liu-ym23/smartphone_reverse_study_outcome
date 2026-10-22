package com.larus.audio.audiov3.tts;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes24.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000e¨\u0006\u000f"}, d2 = {"Lcom/larus/audio/audiov3/tts/TtsStep;", "", "traceName", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getTraceName", "()Ljava/lang/String;", "STEP_TTS_CREATE_HANDLER", "STEP_TTS_TIMEOUT", "STEP_TTS_TO_AUDIO_PLAY", "STEP_TTS_PRE_SUB_TO_TEXT_SHOW", "STEP_TTS_GET_FIRST_AUDIO_DATA", "STEP_TTS_PLAYER_PLAY_TIME", "STEP_TTS_LAG_EVENT", "audiosdkapi_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum TtsStep extends Enum<TtsStep> {
    public static final TtsStep STEP_TTS_CREATE_HANDLER = null;
    public static final TtsStep STEP_TTS_GET_FIRST_AUDIO_DATA = null;
    public static final TtsStep STEP_TTS_LAG_EVENT = null;
    public static final TtsStep STEP_TTS_PLAYER_PLAY_TIME = null;
    public static final TtsStep STEP_TTS_PRE_SUB_TO_TEXT_SHOW = null;
    public static final TtsStep STEP_TTS_TIMEOUT = null;
    public static final TtsStep STEP_TTS_TO_AUDIO_PLAY = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ TtsStep[] f288689a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f288690b = null;
    private final String traceName;

    public static EnumEntries<TtsStep> getEntries() {
        return f288690b;
    }

    static {
        TtsStep r100 = new TtsStep("STEP_TTS_CREATE_HANDLER", 0, "tts_create_handler");
        STEP_TTS_CREATE_HANDLER = r100;
        TtsStep r101 = new TtsStep("STEP_TTS_TIMEOUT", 1, "step_tts_timeout");
        STEP_TTS_TIMEOUT = r101;
        TtsStep r102 = new TtsStep("STEP_TTS_TO_AUDIO_PLAY", 2, "tts_to_audio_play");
        STEP_TTS_TO_AUDIO_PLAY = r102;
        TtsStep r103 = new TtsStep("STEP_TTS_PRE_SUB_TO_TEXT_SHOW", 3, "step_tts_pre_sub_to_text_show");
        STEP_TTS_PRE_SUB_TO_TEXT_SHOW = r103;
        TtsStep r104 = new TtsStep("STEP_TTS_GET_FIRST_AUDIO_DATA", 4, "step_tts_get_first_audio_data");
        STEP_TTS_GET_FIRST_AUDIO_DATA = r104;
        TtsStep r105 = new TtsStep("STEP_TTS_PLAYER_PLAY_TIME", 5, "step_tts_player_play_time");
        STEP_TTS_PLAYER_PLAY_TIME = r105;
        TtsStep r110 = new TtsStep("STEP_TTS_LAG_EVENT", 6, "tts_player_lag_event");
        STEP_TTS_LAG_EVENT = r110;
        TtsStep[] r111 = {r100, r101, r102, r103, r104, r105, r110};
        f288689a = r111;
        f288690b = EnumEntriesKt.enumEntries(r111);
    }

    public static TtsStep[] values() {
        return (TtsStep[]) f288689a.clone();
    }

    public final String getTraceName() {
        return this.traceName;
    }

    public static TtsStep valueOf(String r100) {
        return (TtsStep) a.a(TtsStep.class, r100);
    }

    public TtsStep(String r100, int r101, String r102) {
        super(r100, r101);
        this.traceName = r102;
    }
}
