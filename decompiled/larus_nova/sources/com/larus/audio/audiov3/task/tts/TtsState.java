package com.larus.audio.audiov3.task.tts;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/larus/audio/audiov3/task/tts/TtsState;", "", "<init>", "(Ljava/lang/String;I)V", "TTS_STARTED", "TTS_STOPPED", "audiosdkapi_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum TtsState extends Enum<TtsState> {
    public static final TtsState TTS_STARTED = null;
    public static final TtsState TTS_STOPPED = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ TtsState[] f288681a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f288682b = null;

    public static EnumEntries<TtsState> getEntries() {
        return f288682b;
    }

    static {
        TtsState r100 = new TtsState("TTS_STARTED", 0);
        TTS_STARTED = r100;
        TtsState r101 = new TtsState("TTS_STOPPED", 1);
        TTS_STOPPED = r101;
        TtsState[] r102 = {r100, r101};
        f288681a = r102;
        f288682b = EnumEntriesKt.enumEntries(r102);
    }

    public static TtsState[] values() {
        return (TtsState[]) f288681a.clone();
    }

    public static TtsState valueOf(String r100) {
        return (TtsState) a.a(TtsState.class, r100);
    }

    public TtsState(String r100, int r101) {
        super(r100, r101);
    }
}
