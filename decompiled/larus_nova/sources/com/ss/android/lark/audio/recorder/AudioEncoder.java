package com.ss.android.lark.audio.recorder;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\u0002\u001a\u00020\tH&R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\b¨\u0006\n"}, d2 = {"Lcom/ss/android/lark/audio/recorder/AudioEncoder;", "", "encoder", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getEncoder", "()Ljava/lang/String;", "ENCODER_OPUS", "Lcom/ss/android/lark/audio/recorder/IAudioRecordEncoder;", "audio_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public abstract enum AudioEncoder extends Enum<AudioEncoder> {
    public static final AudioEncoder ENCODER_OPUS = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ AudioEncoder[] f409067a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f409068b = null;
    private final String encoder;

    public AudioEncoder() {
        throw null;
    }

    public static EnumEntries<AudioEncoder> getEntries() {
        return f409068b;
    }

    public abstract j encoder();

    static {
        final String r100 = "ENCODER_OPUS";
        final int r101 = 0;
        AudioEncoder r102 = new ENCODER_OPUS(r100, r101);
        ENCODER_OPUS = r102;
        AudioEncoder[] r103 = {r102};
        f409067a = r103;
        f409068b = EnumEntriesKt.enumEntries(r103);
    }

    public static AudioEncoder[] values() {
        return (AudioEncoder[]) f409067a.clone();
    }

    public final String getEncoder() {
        return this.encoder;
    }

    public static AudioEncoder valueOf(String r100) {
        return (AudioEncoder) r27.a.a(AudioEncoder.class, r100);
    }

    public AudioEncoder(String r100, int r101, String r102, DefaultConstructorMarker r103) {
        super(r100, r101);
        this.encoder = r102;
    }
}
