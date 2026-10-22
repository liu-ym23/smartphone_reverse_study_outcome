package com.larus.audioplayer.api.news;

import com.ss.ttvideoengine.log.VideoEventOneOutSync;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes24.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000e¨\u0006\u000f"}, d2 = {"Lcom/larus/audioplayer/api/news/UrlAudioPlayStatus;", "", "value", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "PREPARE", "PLAYING", "PAUSED", "STOPPED", "ERROR", "FINISH", "UNKNOWN", "api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum UrlAudioPlayStatus extends Enum<UrlAudioPlayStatus> {
    public static final UrlAudioPlayStatus ERROR = null;
    public static final UrlAudioPlayStatus FINISH = null;
    public static final UrlAudioPlayStatus PAUSED = null;
    public static final UrlAudioPlayStatus PLAYING = null;
    public static final UrlAudioPlayStatus PREPARE = null;
    public static final UrlAudioPlayStatus STOPPED = null;
    public static final UrlAudioPlayStatus UNKNOWN = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ UrlAudioPlayStatus[] f290187a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f290188b = null;
    private final String value;

    public static EnumEntries<UrlAudioPlayStatus> getEntries() {
        return f290188b;
    }

    static {
        UrlAudioPlayStatus r100 = new UrlAudioPlayStatus("PREPARE", 0, "prepare");
        PREPARE = r100;
        UrlAudioPlayStatus r101 = new UrlAudioPlayStatus("PLAYING", 1, "playing");
        PLAYING = r101;
        UrlAudioPlayStatus r102 = new UrlAudioPlayStatus("PAUSED", 2, "paused");
        PAUSED = r102;
        UrlAudioPlayStatus r103 = new UrlAudioPlayStatus("STOPPED", 3, "stopped");
        STOPPED = r103;
        UrlAudioPlayStatus r104 = new UrlAudioPlayStatus("ERROR", 4, "error");
        ERROR = r104;
        UrlAudioPlayStatus r105 = new UrlAudioPlayStatus("FINISH", 5, VideoEventOneOutSync.END_TYPE_FINISH);
        FINISH = r105;
        UrlAudioPlayStatus r110 = new UrlAudioPlayStatus("UNKNOWN", 6, "unknown");
        UNKNOWN = r110;
        UrlAudioPlayStatus[] r111 = {r100, r101, r102, r103, r104, r105, r110};
        f290187a = r111;
        f290188b = EnumEntriesKt.enumEntries(r111);
    }

    public static UrlAudioPlayStatus[] values() {
        return (UrlAudioPlayStatus[]) f290187a.clone();
    }

    public final String getValue() {
        return this.value;
    }

    public static UrlAudioPlayStatus valueOf(String r100) {
        return (UrlAudioPlayStatus) a.a(UrlAudioPlayStatus.class, r100);
    }

    public UrlAudioPlayStatus(String r100, int r101, String r102) {
        super(r100, r101);
        this.value = r102;
    }
}
