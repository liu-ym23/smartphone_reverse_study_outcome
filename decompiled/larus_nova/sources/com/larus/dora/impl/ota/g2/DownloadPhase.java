package com.larus.dora.impl.ota.g2;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u000b\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"Lcom/larus/dora/impl/ota/g2/DownloadPhase;", "", "<init>", "(Ljava/lang/String;I)V", "IDLE", "CHECKING", "QUEUED", "PREPARING", "RUNNING", "PAUSING", "PAUSED", "FAILED", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum DownloadPhase extends Enum<DownloadPhase> {
    private static final /* synthetic */ EnumEntries $ENTRIES = null;
    private static final /* synthetic */ DownloadPhase[] $VALUES = null;
    public static final DownloadPhase CHECKING = null;
    public static final DownloadPhase FAILED = null;
    public static final DownloadPhase IDLE = null;
    public static final DownloadPhase PAUSED = null;
    public static final DownloadPhase PAUSING = null;
    public static final DownloadPhase PREPARING = null;
    public static final DownloadPhase QUEUED = null;
    public static final DownloadPhase RUNNING = null;

    public static EnumEntries<DownloadPhase> getEntries() {
        return $ENTRIES;
    }

    static {
        DownloadPhase r100 = new DownloadPhase("IDLE", 0);
        IDLE = r100;
        DownloadPhase r101 = new DownloadPhase("CHECKING", 1);
        CHECKING = r101;
        DownloadPhase r102 = new DownloadPhase("QUEUED", 2);
        QUEUED = r102;
        DownloadPhase r103 = new DownloadPhase("PREPARING", 3);
        PREPARING = r103;
        DownloadPhase r104 = new DownloadPhase("RUNNING", 4);
        RUNNING = r104;
        DownloadPhase r105 = new DownloadPhase("PAUSING", 5);
        PAUSING = r105;
        DownloadPhase r110 = new DownloadPhase("PAUSED", 6);
        PAUSED = r110;
        DownloadPhase r111 = new DownloadPhase("FAILED", 7);
        FAILED = r111;
        DownloadPhase[] r112 = {r100, r101, r102, r103, r104, r105, r110, r111};
        $VALUES = r112;
        $ENTRIES = EnumEntriesKt.enumEntries(r112);
    }

    public static DownloadPhase[] values() {
        return (DownloadPhase[]) $VALUES.clone();
    }

    public static DownloadPhase valueOf(String r100) {
        return (DownloadPhase) r27.a.a(DownloadPhase.class, r100);
    }

    public DownloadPhase(String r100, int r101) {
        super(r100, r101);
    }
}
