package com.larus.audio.audiov3.task.tts;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes24.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\n\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/larus/audio/audiov3/task/tts/TtsLifeState;", "", "<init>", "(Ljava/lang/String;I)V", "TTS_START", "TTS_STOP", "TTS_ERROR", "TTS_PAUSE", "TTS_RESUME", "TTS_START_PLAYING", "TTS_FINISH_PLAYING", "audiosdkapi_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum TtsLifeState extends Enum<TtsLifeState> {
    public static final TtsLifeState TTS_ERROR = null;
    public static final TtsLifeState TTS_FINISH_PLAYING = null;
    public static final TtsLifeState TTS_PAUSE = null;
    public static final TtsLifeState TTS_RESUME = null;
    public static final TtsLifeState TTS_START = null;
    public static final TtsLifeState TTS_START_PLAYING = null;
    public static final TtsLifeState TTS_STOP = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ TtsLifeState[] f288679a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f288680b = null;

    public static EnumEntries<TtsLifeState> getEntries() {
        return f288680b;
    }

    static {
        TtsLifeState r100 = new TtsLifeState("TTS_START", 0);
        TTS_START = r100;
        TtsLifeState r101 = new TtsLifeState("TTS_STOP", 1);
        TTS_STOP = r101;
        TtsLifeState r102 = new TtsLifeState("TTS_ERROR", 2);
        TTS_ERROR = r102;
        TtsLifeState r103 = new TtsLifeState("TTS_PAUSE", 3);
        TTS_PAUSE = r103;
        TtsLifeState r104 = new TtsLifeState("TTS_RESUME", 4);
        TTS_RESUME = r104;
        TtsLifeState r105 = new TtsLifeState("TTS_START_PLAYING", 5);
        TTS_START_PLAYING = r105;
        TtsLifeState r110 = new TtsLifeState("TTS_FINISH_PLAYING", 6);
        TTS_FINISH_PLAYING = r110;
        TtsLifeState[] r111 = {r100, r101, r102, r103, r104, r105, r110};
        f288679a = r111;
        f288680b = EnumEntriesKt.enumEntries(r111);
    }

    public static TtsLifeState[] values() {
        return (TtsLifeState[]) f288679a.clone();
    }

    public static TtsLifeState valueOf(String r100) {
        return (TtsLifeState) a.a(TtsLifeState.class, r100);
    }

    public TtsLifeState(String r100, int r101) {
        super(r100, r101);
    }
}
