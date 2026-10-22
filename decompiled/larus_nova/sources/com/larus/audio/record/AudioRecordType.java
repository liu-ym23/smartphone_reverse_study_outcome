package com.larus.audio.record;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes24.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/larus/audio/record/AudioRecordType;", "", "<init>", "(Ljava/lang/String;I)V", "AudioRecord", "BackTraceRecord", "audiosdkapi_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum AudioRecordType extends Enum<AudioRecordType> {
    public static final AudioRecordType AudioRecord = null;
    public static final AudioRecordType BackTraceRecord = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ AudioRecordType[] f289779a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f289780b = null;

    public static EnumEntries<AudioRecordType> getEntries() {
        return f289780b;
    }

    static {
        AudioRecordType r100 = new AudioRecordType("AudioRecord", 0);
        AudioRecord = r100;
        AudioRecordType r101 = new AudioRecordType("BackTraceRecord", 1);
        BackTraceRecord = r101;
        AudioRecordType[] r102 = {r100, r101};
        f289779a = r102;
        f289780b = EnumEntriesKt.enumEntries(r102);
    }

    public static AudioRecordType[] values() {
        return (AudioRecordType[]) f289779a.clone();
    }

    public static AudioRecordType valueOf(String r100) {
        return (AudioRecordType) a.a(AudioRecordType.class, r100);
    }

    public AudioRecordType(String r100, int r101) {
        super(r100, r101);
    }
}
