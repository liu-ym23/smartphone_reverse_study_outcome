package com.larus.audio.asr.sami.quality;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes24.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/larus/audio/asr/sami/quality/AudioRecorderStatus;", "", "<init>", "(Ljava/lang/String;I)V", "STATE_IDLE", "STATE_RECORDING", "STATE_CANCEL", "STATE_STOP", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum AudioRecorderStatus extends Enum<AudioRecorderStatus> {
    public static final AudioRecorderStatus STATE_CANCEL = null;
    public static final AudioRecorderStatus STATE_IDLE = null;
    public static final AudioRecorderStatus STATE_RECORDING = null;
    public static final AudioRecorderStatus STATE_STOP = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ AudioRecorderStatus[] f288471a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f288472b = null;

    public static EnumEntries<AudioRecorderStatus> getEntries() {
        return f288472b;
    }

    static {
        AudioRecorderStatus r100 = new AudioRecorderStatus("STATE_IDLE", 0);
        STATE_IDLE = r100;
        AudioRecorderStatus r101 = new AudioRecorderStatus("STATE_RECORDING", 1);
        STATE_RECORDING = r101;
        AudioRecorderStatus r102 = new AudioRecorderStatus("STATE_CANCEL", 2);
        STATE_CANCEL = r102;
        AudioRecorderStatus r103 = new AudioRecorderStatus("STATE_STOP", 3);
        STATE_STOP = r103;
        AudioRecorderStatus[] r104 = {r100, r101, r102, r103};
        f288471a = r104;
        f288472b = EnumEntriesKt.enumEntries(r104);
    }

    public static AudioRecorderStatus[] values() {
        return (AudioRecorderStatus[]) f288471a.clone();
    }

    public static AudioRecorderStatus valueOf(String r100) {
        return (AudioRecorderStatus) a.a(AudioRecorderStatus.class, r100);
    }

    public AudioRecorderStatus(String r100, int r101) {
        super(r100, r101);
    }
}
