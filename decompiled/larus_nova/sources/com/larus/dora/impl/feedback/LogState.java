package com.larus.dora.impl.feedback;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes27.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u000e\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000e¨\u0006\u000f"}, d2 = {"Lcom/larus/dora/impl/feedback/LogState;", "", "<init>", "(Ljava/lang/String;I)V", "IDLE", "ON_BUILDING_P2P_CONNECTION", "P2P_CONNECTION_SUCCESS", "P2P_CONNECTION_FAILED", "ON_FETCHING_LOGS", "LOG_FETCH_SUCCESS", "LOG_FETCH_FAILED", "ON_UPLOADING_LOGS", "LOG_UPLOAD_SUCCESS", "LOG_UPLOAD_FAILED", "READY", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum LogState extends Enum<LogState> {
    public static final LogState IDLE = null;
    public static final LogState LOG_FETCH_FAILED = null;
    public static final LogState LOG_FETCH_SUCCESS = null;
    public static final LogState LOG_UPLOAD_FAILED = null;
    public static final LogState LOG_UPLOAD_SUCCESS = null;
    public static final LogState ON_BUILDING_P2P_CONNECTION = null;
    public static final LogState ON_FETCHING_LOGS = null;
    public static final LogState ON_UPLOADING_LOGS = null;
    public static final LogState P2P_CONNECTION_FAILED = null;
    public static final LogState P2P_CONNECTION_SUCCESS = null;
    public static final LogState READY = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ LogState[] f335599a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f335600b = null;

    public static EnumEntries<LogState> getEntries() {
        return f335600b;
    }

    static {
        LogState r100 = new LogState("IDLE", 0);
        IDLE = r100;
        LogState r101 = new LogState("ON_BUILDING_P2P_CONNECTION", 1);
        ON_BUILDING_P2P_CONNECTION = r101;
        LogState r102 = new LogState("P2P_CONNECTION_SUCCESS", 2);
        P2P_CONNECTION_SUCCESS = r102;
        LogState r103 = new LogState("P2P_CONNECTION_FAILED", 3);
        P2P_CONNECTION_FAILED = r103;
        LogState r104 = new LogState("ON_FETCHING_LOGS", 4);
        ON_FETCHING_LOGS = r104;
        LogState r105 = new LogState("LOG_FETCH_SUCCESS", 5);
        LOG_FETCH_SUCCESS = r105;
        LogState r110 = new LogState("LOG_FETCH_FAILED", 6);
        LOG_FETCH_FAILED = r110;
        LogState r111 = new LogState("ON_UPLOADING_LOGS", 7);
        ON_UPLOADING_LOGS = r111;
        LogState r112 = new LogState("LOG_UPLOAD_SUCCESS", 8);
        LOG_UPLOAD_SUCCESS = r112;
        LogState r113 = new LogState("LOG_UPLOAD_FAILED", 9);
        LOG_UPLOAD_FAILED = r113;
        LogState r114 = new LogState("READY", 10);
        READY = r114;
        LogState[] r115 = {r100, r101, r102, r103, r104, r105, r110, r111, r112, r113, r114};
        f335599a = r115;
        f335600b = EnumEntriesKt.enumEntries(r115);
    }

    public static LogState[] values() {
        return (LogState[]) f335599a.clone();
    }

    public static LogState valueOf(String r100) {
        return (LogState) r27.a.a(LogState.class, r100);
    }

    public LogState(String r100, int r101) {
        super(r100, r101);
    }
}
