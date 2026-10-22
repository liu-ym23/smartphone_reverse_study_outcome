package com.larus.livetutor.impl.typing.datasource;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes30.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0087\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/larus/livetutor/impl/typing/datasource/StreamStatus;", "", "<init>", "(Ljava/lang/String;I)V", "STREAMING", "OVERWRITE", "STOP", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum StreamStatus extends Enum<StreamStatus> {
    private static final /* synthetic */ EnumEntries $ENTRIES = null;
    private static final /* synthetic */ StreamStatus[] $VALUES = null;
    public static final StreamStatus OVERWRITE = null;
    public static final StreamStatus STOP = null;
    public static final StreamStatus STREAMING = null;

    private static final /* synthetic */ StreamStatus[] $values() {
        return new StreamStatus[]{STREAMING, OVERWRITE, STOP};
    }

    public static EnumEntries<StreamStatus> getEntries() {
        return $ENTRIES;
    }

    static {
        STREAMING = new StreamStatus("STREAMING", 0);
        OVERWRITE = new StreamStatus("OVERWRITE", 1);
        STOP = new StreamStatus("STOP", 2);
        StreamStatus[] r100 = $values();
        $VALUES = r100;
        $ENTRIES = EnumEntriesKt.enumEntries(r100);
    }

    public static StreamStatus[] values() {
        return (StreamStatus[]) $VALUES.clone();
    }

    public static StreamStatus valueOf(String r100) {
        return (StreamStatus) r27.a.a(StreamStatus.class, r100);
    }

    private StreamStatus(String r100, int r101) {
        super(r100, r101);
    }
}
