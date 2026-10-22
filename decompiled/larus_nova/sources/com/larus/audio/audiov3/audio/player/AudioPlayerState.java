package com.larus.audio.audiov3.audio.player;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/larus/audio/audiov3/audio/player/AudioPlayerState;", "", "<init>", "(Ljava/lang/String;I)V", "STARTED", "PAUSED", "STOPPED", "audiosdkapi_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum AudioPlayerState extends Enum<AudioPlayerState> {
    public static final AudioPlayerState PAUSED = null;
    public static final AudioPlayerState STARTED = null;
    public static final AudioPlayerState STOPPED = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ AudioPlayerState[] f288500a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f288501b = null;

    public static EnumEntries<AudioPlayerState> getEntries() {
        return f288501b;
    }

    static {
        AudioPlayerState r100 = new AudioPlayerState("STARTED", 0);
        STARTED = r100;
        AudioPlayerState r101 = new AudioPlayerState("PAUSED", 1);
        PAUSED = r101;
        AudioPlayerState r102 = new AudioPlayerState("STOPPED", 2);
        STOPPED = r102;
        AudioPlayerState[] r103 = {r100, r101, r102};
        f288500a = r103;
        f288501b = EnumEntriesKt.enumEntries(r103);
    }

    public static AudioPlayerState[] values() {
        return (AudioPlayerState[]) f288500a.clone();
    }

    public static AudioPlayerState valueOf(String r100) {
        return (AudioPlayerState) a.a(AudioPlayerState.class, r100);
    }

    public AudioPlayerState(String r100, int r101) {
        super(r100, r101);
    }
}
