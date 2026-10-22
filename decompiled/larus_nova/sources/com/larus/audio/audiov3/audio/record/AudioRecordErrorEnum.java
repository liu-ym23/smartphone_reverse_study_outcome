package com.larus.audio.audiov3.audio.record;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes24.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0019\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000f¨\u0006\u0010"}, d2 = {"Lcom/larus/audio/audiov3/audio/record/AudioRecordErrorEnum;", "", "code", "", "massage", "", "<init>", "(Ljava/lang/String;IILjava/lang/String;)V", "getCode", "()I", "getMassage", "()Ljava/lang/String;", "PREPARE_ERROR", "START_ERROR", "RELEASE_ERROR", "UNKNOWN_ERROR", "audiosdkapi_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum AudioRecordErrorEnum extends Enum<AudioRecordErrorEnum> {
    public static final AudioRecordErrorEnum PREPARE_ERROR = null;
    public static final AudioRecordErrorEnum RELEASE_ERROR = null;
    public static final AudioRecordErrorEnum START_ERROR = null;
    public static final AudioRecordErrorEnum UNKNOWN_ERROR = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ AudioRecordErrorEnum[] f288504a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f288505b = null;
    private final int code;
    private final String massage;

    public static EnumEntries<AudioRecordErrorEnum> getEntries() {
        return f288505b;
    }

    static {
        AudioRecordErrorEnum r100 = new AudioRecordErrorEnum("PREPARE_ERROR", 0, 500, "AudioRecord prepare error");
        PREPARE_ERROR = r100;
        AudioRecordErrorEnum r101 = new AudioRecordErrorEnum("START_ERROR", 1, 501, "AudioRecord start error");
        START_ERROR = r101;
        AudioRecordErrorEnum r102 = new AudioRecordErrorEnum("RELEASE_ERROR", 2, 502, "AudioRecord release error");
        RELEASE_ERROR = r102;
        AudioRecordErrorEnum r103 = new AudioRecordErrorEnum("UNKNOWN_ERROR", 3, 10000, "AudioRecord unknown error");
        UNKNOWN_ERROR = r103;
        AudioRecordErrorEnum[] r104 = {r100, r101, r102, r103};
        f288504a = r104;
        f288505b = EnumEntriesKt.enumEntries(r104);
    }

    public static AudioRecordErrorEnum[] values() {
        return (AudioRecordErrorEnum[]) f288504a.clone();
    }

    public final int getCode() {
        return this.code;
    }

    public final String getMassage() {
        return this.massage;
    }

    public static AudioRecordErrorEnum valueOf(String r100) {
        return (AudioRecordErrorEnum) a.a(AudioRecordErrorEnum.class, r100);
    }

    public AudioRecordErrorEnum(String r100, int r101, int r102, String r103) {
        super(r100, r101);
        this.code = r102;
        this.massage = r103;
    }
}
