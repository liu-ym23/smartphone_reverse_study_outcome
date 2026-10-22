package com.larus.audioplayer.api.stream;

import com.ss.ttvideoengine.log.VideoEventOneOutSync;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes24.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000f¨\u0006\u0010"}, d2 = {"Lcom/larus/audioplayer/api/stream/StreamPlayerStatus;", "", "value", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "PREPARE", "PLAYING", "PAUSED", "STOPPED", "FINISH", "ERROR", "RESUME", "UNKNOWN", "api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum StreamPlayerStatus extends Enum<StreamPlayerStatus> {
    public static final StreamPlayerStatus ERROR = null;
    public static final StreamPlayerStatus FINISH = null;
    public static final StreamPlayerStatus PAUSED = null;
    public static final StreamPlayerStatus PLAYING = null;
    public static final StreamPlayerStatus PREPARE = null;
    public static final StreamPlayerStatus RESUME = null;
    public static final StreamPlayerStatus STOPPED = null;
    public static final StreamPlayerStatus UNKNOWN = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ StreamPlayerStatus[] f290196a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f290197b = null;
    private final String value;

    public static EnumEntries<StreamPlayerStatus> getEntries() {
        return f290197b;
    }

    static {
        StreamPlayerStatus r100 = new StreamPlayerStatus("PREPARE", 0, "prepare");
        PREPARE = r100;
        StreamPlayerStatus r101 = new StreamPlayerStatus("PLAYING", 1, "playing");
        PLAYING = r101;
        StreamPlayerStatus r102 = new StreamPlayerStatus("PAUSED", 2, "paused");
        PAUSED = r102;
        StreamPlayerStatus r103 = new StreamPlayerStatus("STOPPED", 3, "stopped");
        STOPPED = r103;
        StreamPlayerStatus r104 = new StreamPlayerStatus("FINISH", 4, VideoEventOneOutSync.END_TYPE_FINISH);
        FINISH = r104;
        StreamPlayerStatus r105 = new StreamPlayerStatus("ERROR", 5, "error");
        ERROR = r105;
        StreamPlayerStatus r110 = new StreamPlayerStatus("RESUME", 6, "resume");
        RESUME = r110;
        StreamPlayerStatus r111 = new StreamPlayerStatus("UNKNOWN", 7, "unknown");
        UNKNOWN = r111;
        StreamPlayerStatus[] r112 = {r100, r101, r102, r103, r104, r105, r110, r111};
        f290196a = r112;
        f290197b = EnumEntriesKt.enumEntries(r112);
    }

    public static StreamPlayerStatus[] values() {
        return (StreamPlayerStatus[]) f290196a.clone();
    }

    public final String getValue() {
        return this.value;
    }

    public static StreamPlayerStatus valueOf(String r100) {
        return (StreamPlayerStatus) a.a(StreamPlayerStatus.class, r100);
    }

    public StreamPlayerStatus(String r100, int r101, String r102) {
        super(r100, r101);
        this.value = r102;
    }
}
