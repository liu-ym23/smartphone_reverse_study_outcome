package com.larus.music.qq.data;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes30.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/larus/music/qq/data/QQPlayStatus;", "", "value", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "PLAYING", "PAUSED", "STOPPED", "music_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum QQPlayStatus extends Enum<QQPlayStatus> {
    public static final QQPlayStatus PAUSED = null;
    public static final QQPlayStatus PLAYING = null;
    public static final QQPlayStatus STOPPED = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ QQPlayStatus[] f359531a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f359532b = null;
    private final String value;

    public static EnumEntries<QQPlayStatus> getEntries() {
        return f359532b;
    }

    static {
        QQPlayStatus r100 = new QQPlayStatus("PLAYING", 0, "playing");
        PLAYING = r100;
        QQPlayStatus r101 = new QQPlayStatus("PAUSED", 1, "paused");
        PAUSED = r101;
        QQPlayStatus r102 = new QQPlayStatus("STOPPED", 2, "stopped");
        STOPPED = r102;
        QQPlayStatus[] r103 = {r100, r101, r102};
        f359531a = r103;
        f359532b = EnumEntriesKt.enumEntries(r103);
    }

    public static QQPlayStatus[] values() {
        return (QQPlayStatus[]) f359531a.clone();
    }

    public final String getValue() {
        return this.value;
    }

    public static QQPlayStatus valueOf(String r100) {
        return (QQPlayStatus) a.a(QQPlayStatus.class, r100);
    }

    public QQPlayStatus(String r100, int r101, String r102) {
        super(r100, r101);
        this.value = r102;
    }
}
