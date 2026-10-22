package com.ss.android.lark.voiceinput.api.data.config.record;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes38.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/ss/android/lark/voiceinput/api/data/config/record/AudioChannel;", "", "<init>", "(Ljava/lang/String;I)V", "Mono", "Stereo", "voice-input-api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum AudioChannel extends Enum<AudioChannel> {
    public static final AudioChannel Mono = null;
    public static final AudioChannel Stereo = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ AudioChannel[] f445024a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f445025b = null;

    public static EnumEntries<AudioChannel> getEntries() {
        return f445025b;
    }

    static {
        AudioChannel r100 = new AudioChannel("Mono", 0);
        Mono = r100;
        AudioChannel r101 = new AudioChannel("Stereo", 1);
        Stereo = r101;
        AudioChannel[] r102 = {r100, r101};
        f445024a = r102;
        f445025b = EnumEntriesKt.enumEntries(r102);
    }

    public static AudioChannel[] values() {
        return (AudioChannel[]) f445024a.clone();
    }

    public static AudioChannel valueOf(String r100) {
        return (AudioChannel) a.a(AudioChannel.class, r100);
    }

    public AudioChannel(String r100, int r101) {
        super(r100, r101);
    }
}
