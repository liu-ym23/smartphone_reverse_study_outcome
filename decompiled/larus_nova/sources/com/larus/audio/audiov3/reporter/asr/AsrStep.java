package com.larus.audio.audiov3.reporter.asr;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes24.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000f¨\u0006\u0010"}, d2 = {"Lcom/larus/audio/audiov3/reporter/asr/AsrStep;", "", "traceName", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getTraceName", "()Ljava/lang/String;", "ASR_CREATE_AUDIO", "ASR_DATA_TRANSMISSION", "ASR_RECOGNITION_DELAY", "ASR_AUDIO_RECORD", "ASR_AUDIO_UPLOAD", "ASR_AUDIO_RECORD_LEAK", "ASR_AUDIO_RECORD_BIG_FILE", "ASR_STREAM_TO_FINAL", "audiosdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum AsrStep extends Enum<AsrStep> {
    public static final AsrStep ASR_AUDIO_RECORD = null;
    public static final AsrStep ASR_AUDIO_RECORD_BIG_FILE = null;
    public static final AsrStep ASR_AUDIO_RECORD_LEAK = null;
    public static final AsrStep ASR_AUDIO_UPLOAD = null;
    public static final AsrStep ASR_CREATE_AUDIO = null;
    public static final AsrStep ASR_DATA_TRANSMISSION = null;
    public static final AsrStep ASR_RECOGNITION_DELAY = null;
    public static final AsrStep ASR_STREAM_TO_FINAL = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ AsrStep[] f288520a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f288521b = null;
    private final String traceName;

    public static EnumEntries<AsrStep> getEntries() {
        return f288521b;
    }

    static {
        AsrStep r100 = new AsrStep("ASR_CREATE_AUDIO", 0, "asr_create_default_audio");
        ASR_CREATE_AUDIO = r100;
        AsrStep r101 = new AsrStep("ASR_DATA_TRANSMISSION", 1, "asr_data_transmission");
        ASR_DATA_TRANSMISSION = r101;
        AsrStep r102 = new AsrStep("ASR_RECOGNITION_DELAY", 2, "asr_recognition_delay");
        ASR_RECOGNITION_DELAY = r102;
        AsrStep r103 = new AsrStep("ASR_AUDIO_RECORD", 3, "asr_audio_record");
        ASR_AUDIO_RECORD = r103;
        AsrStep r104 = new AsrStep("ASR_AUDIO_UPLOAD", 4, "asr_audio_upload");
        ASR_AUDIO_UPLOAD = r104;
        AsrStep r105 = new AsrStep("ASR_AUDIO_RECORD_LEAK", 5, "asr_audio_record_leak");
        ASR_AUDIO_RECORD_LEAK = r105;
        AsrStep r110 = new AsrStep("ASR_AUDIO_RECORD_BIG_FILE", 6, "asr_audio_record_big_file");
        ASR_AUDIO_RECORD_BIG_FILE = r110;
        AsrStep r111 = new AsrStep("ASR_STREAM_TO_FINAL", 7, "asr_stream_to_final");
        ASR_STREAM_TO_FINAL = r111;
        AsrStep[] r112 = {r100, r101, r102, r103, r104, r105, r110, r111};
        f288520a = r112;
        f288521b = EnumEntriesKt.enumEntries(r112);
    }

    public static AsrStep[] values() {
        return (AsrStep[]) f288520a.clone();
    }

    public final String getTraceName() {
        return this.traceName;
    }

    public static AsrStep valueOf(String r100) {
        return (AsrStep) a.a(AsrStep.class, r100);
    }

    public AsrStep(String r100, int r101, String r102) {
        super(r100, r101);
        this.traceName = r102;
    }
}
