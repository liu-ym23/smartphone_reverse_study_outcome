package com.bytedance.flow_audio.api.foundation.player;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/bytedance/flow_audio/api/foundation/player/AudioPlayerStatus;", "", "<init>", "(Ljava/lang/String;I)V", "Initial", "Playing", "Paused", "Stopped", "flow_audio_api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum AudioPlayerStatus extends Enum<AudioPlayerStatus> {
    public static final AudioPlayerStatus Initial = null;
    public static final AudioPlayerStatus Paused = null;
    public static final AudioPlayerStatus Playing = null;
    public static final AudioPlayerStatus Stopped = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ AudioPlayerStatus[] f243704a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f243705b = null;

    public static EnumEntries<AudioPlayerStatus> getEntries() {
        return f243705b;
    }

    static {
        AudioPlayerStatus r100 = new AudioPlayerStatus("Initial", 0);
        Initial = r100;
        AudioPlayerStatus r101 = new AudioPlayerStatus("Playing", 1);
        Playing = r101;
        AudioPlayerStatus r102 = new AudioPlayerStatus("Paused", 2);
        Paused = r102;
        AudioPlayerStatus r103 = new AudioPlayerStatus("Stopped", 3);
        Stopped = r103;
        AudioPlayerStatus[] r104 = {r100, r101, r102, r103};
        f243704a = r104;
        f243705b = EnumEntriesKt.enumEntries(r104);
    }

    public static AudioPlayerStatus[] values() {
        return (AudioPlayerStatus[]) f243704a.clone();
    }

    public static AudioPlayerStatus valueOf(String r100) {
        return (AudioPlayerStatus) a.a(AudioPlayerStatus.class, r100);
    }

    public AudioPlayerStatus(String r100, int r101) {
        super(r100, r101);
    }
}
