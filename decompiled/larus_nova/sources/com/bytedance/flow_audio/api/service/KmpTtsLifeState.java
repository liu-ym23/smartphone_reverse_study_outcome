package com.bytedance.flow_audio.api.service;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\n\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/bytedance/flow_audio/api/service/KmpTtsLifeState;", "", "<init>", "(Ljava/lang/String;I)V", "TTS_START", "TTS_STOP", "TTS_ERROR", "TTS_PAUSE", "TTS_RESUME", "TTS_START_PLAYING", "TTS_FINISH_PLAYING", "flow_audio_api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum KmpTtsLifeState extends Enum<KmpTtsLifeState> {
    public static final KmpTtsLifeState TTS_ERROR = null;
    public static final KmpTtsLifeState TTS_FINISH_PLAYING = null;
    public static final KmpTtsLifeState TTS_PAUSE = null;
    public static final KmpTtsLifeState TTS_RESUME = null;
    public static final KmpTtsLifeState TTS_START = null;
    public static final KmpTtsLifeState TTS_START_PLAYING = null;
    public static final KmpTtsLifeState TTS_STOP = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ KmpTtsLifeState[] f243728a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f243729b = null;

    public static EnumEntries<KmpTtsLifeState> getEntries() {
        return f243729b;
    }

    static {
        KmpTtsLifeState r100 = new KmpTtsLifeState("TTS_START", 0);
        TTS_START = r100;
        KmpTtsLifeState r101 = new KmpTtsLifeState("TTS_STOP", 1);
        TTS_STOP = r101;
        KmpTtsLifeState r102 = new KmpTtsLifeState("TTS_ERROR", 2);
        TTS_ERROR = r102;
        KmpTtsLifeState r103 = new KmpTtsLifeState("TTS_PAUSE", 3);
        TTS_PAUSE = r103;
        KmpTtsLifeState r104 = new KmpTtsLifeState("TTS_RESUME", 4);
        TTS_RESUME = r104;
        KmpTtsLifeState r105 = new KmpTtsLifeState("TTS_START_PLAYING", 5);
        TTS_START_PLAYING = r105;
        KmpTtsLifeState r110 = new KmpTtsLifeState("TTS_FINISH_PLAYING", 6);
        TTS_FINISH_PLAYING = r110;
        KmpTtsLifeState[] r111 = {r100, r101, r102, r103, r104, r105, r110};
        f243728a = r111;
        f243729b = EnumEntriesKt.enumEntries(r111);
    }

    public static KmpTtsLifeState[] values() {
        return (KmpTtsLifeState[]) f243728a.clone();
    }

    public static KmpTtsLifeState valueOf(String r100) {
        return (KmpTtsLifeState) a.a(KmpTtsLifeState.class, r100);
    }

    public KmpTtsLifeState(String r100, int r101) {
        super(r100, r101);
    }
}
