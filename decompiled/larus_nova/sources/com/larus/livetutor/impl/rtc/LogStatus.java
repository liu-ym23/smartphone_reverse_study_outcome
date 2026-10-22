package com.larus.livetutor.impl.rtc;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes30.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0087\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/larus/livetutor/impl/rtc/LogStatus;", "", "<init>", "(Ljava/lang/String;I)V", "Normal", "Success", "Error", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum LogStatus extends Enum<LogStatus> {
    private static final /* synthetic */ EnumEntries $ENTRIES = null;
    private static final /* synthetic */ LogStatus[] $VALUES = null;
    public static final LogStatus Error = null;
    public static final LogStatus Normal = null;
    public static final LogStatus Success = null;

    private static final /* synthetic */ LogStatus[] $values() {
        return new LogStatus[]{Normal, Success, Error};
    }

    public static EnumEntries<LogStatus> getEntries() {
        return $ENTRIES;
    }

    static {
        Normal = new LogStatus("Normal", 0);
        Success = new LogStatus("Success", 1);
        Error = new LogStatus("Error", 2);
        LogStatus[] r100 = $values();
        $VALUES = r100;
        $ENTRIES = EnumEntriesKt.enumEntries(r100);
    }

    public static LogStatus[] values() {
        return (LogStatus[]) $VALUES.clone();
    }

    public static LogStatus valueOf(String r100) {
        return (LogStatus) r27.a.a(LogStatus.class, r100);
    }

    private LogStatus(String r100, int r101) {
        super(r100, r101);
    }
}
