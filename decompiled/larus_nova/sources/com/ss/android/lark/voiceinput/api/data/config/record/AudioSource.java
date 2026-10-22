package com.ss.android.lark.voiceinput.api.data.config.record;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes38.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/ss/android/lark/voiceinput/api/data/config/record/AudioSource;", "", "<init>", "(Ljava/lang/String;I)V", "Mic", "VoiceRecognition", "VoiceCommunication", "voice-input-api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum AudioSource extends Enum<AudioSource> {
    public static final AudioSource Mic = null;
    public static final AudioSource VoiceCommunication = null;
    public static final AudioSource VoiceRecognition = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ AudioSource[] f445026a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f445027b = null;

    public static EnumEntries<AudioSource> getEntries() {
        return f445027b;
    }

    static {
        AudioSource r100 = new AudioSource("Mic", 0);
        Mic = r100;
        AudioSource r101 = new AudioSource("VoiceRecognition", 1);
        VoiceRecognition = r101;
        AudioSource r102 = new AudioSource("VoiceCommunication", 2);
        VoiceCommunication = r102;
        AudioSource[] r103 = {r100, r101, r102};
        f445026a = r103;
        f445027b = EnumEntriesKt.enumEntries(r103);
    }

    public static AudioSource[] values() {
        return (AudioSource[]) f445026a.clone();
    }

    public static AudioSource valueOf(String r100) {
        return (AudioSource) a.a(AudioSource.class, r100);
    }

    public AudioSource(String r100, int r101) {
        super(r100, r101);
    }
}
