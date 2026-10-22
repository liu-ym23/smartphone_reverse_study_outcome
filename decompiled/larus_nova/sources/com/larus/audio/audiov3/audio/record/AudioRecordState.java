package com.larus.audio.audiov3.audio.record;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes24.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/larus/audio/audiov3/audio/record/AudioRecordState;", "", "<init>", "(Ljava/lang/String;I)V", "UNINITIALIZED", "INITIALIZED", "STARTED", "STOPPED", "audiosdkapi_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum AudioRecordState extends Enum<AudioRecordState> {
    public static final AudioRecordState INITIALIZED = null;
    public static final AudioRecordState STARTED = null;
    public static final AudioRecordState STOPPED = null;
    public static final AudioRecordState UNINITIALIZED = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ AudioRecordState[] f288506a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f288507b = null;

    public static EnumEntries<AudioRecordState> getEntries() {
        return f288507b;
    }

    static {
        AudioRecordState r100 = new AudioRecordState("UNINITIALIZED", 0);
        UNINITIALIZED = r100;
        AudioRecordState r101 = new AudioRecordState("INITIALIZED", 1);
        INITIALIZED = r101;
        AudioRecordState r102 = new AudioRecordState("STARTED", 2);
        STARTED = r102;
        AudioRecordState r103 = new AudioRecordState("STOPPED", 3);
        STOPPED = r103;
        AudioRecordState[] r104 = {r100, r101, r102, r103};
        f288506a = r104;
        f288507b = EnumEntriesKt.enumEntries(r104);
    }

    public static AudioRecordState[] values() {
        return (AudioRecordState[]) f288506a.clone();
    }

    public static AudioRecordState valueOf(String r100) {
        return (AudioRecordState) a.a(AudioRecordState.class, r100);
    }

    public AudioRecordState(String r100, int r101) {
        super(r100, r101);
    }
}
