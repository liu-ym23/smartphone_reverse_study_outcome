package com.larus.audio.audiov3.config.task.sami.asr;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes24.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/larus/audio/audiov3/config/task/sami/asr/ReportType;", "", "<init>", "(Ljava/lang/String;I)V", "ASR_ENDED", "UPLOAD_AUDIO_ENDED", "ASR_STREAM", "audiosdkapi_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum ReportType extends Enum<ReportType> {
    public static final ReportType ASR_ENDED = null;
    public static final ReportType ASR_STREAM = null;
    public static final ReportType UPLOAD_AUDIO_ENDED = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ReportType[] f288516a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f288517b = null;

    public static EnumEntries<ReportType> getEntries() {
        return f288517b;
    }

    static {
        ReportType r100 = new ReportType("ASR_ENDED", 0);
        ASR_ENDED = r100;
        ReportType r101 = new ReportType("UPLOAD_AUDIO_ENDED", 1);
        UPLOAD_AUDIO_ENDED = r101;
        ReportType r102 = new ReportType("ASR_STREAM", 2);
        ASR_STREAM = r102;
        ReportType[] r103 = {r100, r101, r102};
        f288516a = r103;
        f288517b = EnumEntriesKt.enumEntries(r103);
    }

    public static ReportType[] values() {
        return (ReportType[]) f288516a.clone();
    }

    public static ReportType valueOf(String r100) {
        return (ReportType) a.a(ReportType.class, r100);
    }

    public ReportType(String r100, int r101) {
        super(r100, r101);
    }
}
