package com.obric.assistant.interaction.impl.essentialtask.task.migration;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/obric/assistant/interaction/impl/essentialtask/task/migration/MigrationStatus;", "", "<init>", "(Ljava/lang/String;I)V", "IDLE", "IN_PROCESS", "FINISHED", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum MigrationStatus extends Enum<MigrationStatus> {
    private static final /* synthetic */ EnumEntries $ENTRIES = null;
    private static final /* synthetic */ MigrationStatus[] $VALUES = null;
    public static final MigrationStatus FINISHED = null;
    public static final MigrationStatus IDLE = null;
    public static final MigrationStatus IN_PROCESS = null;

    private static final /* synthetic */ MigrationStatus[] $values() {
        return new MigrationStatus[]{IDLE, IN_PROCESS, FINISHED};
    }

    public static EnumEntries<MigrationStatus> getEntries() {
        return $ENTRIES;
    }

    static {
        IDLE = new MigrationStatus("IDLE", 0);
        IN_PROCESS = new MigrationStatus("IN_PROCESS", 1);
        FINISHED = new MigrationStatus("FINISHED", 2);
        MigrationStatus[] r100 = $values();
        $VALUES = r100;
        $ENTRIES = EnumEntriesKt.enumEntries(r100);
    }

    public static MigrationStatus[] values() {
        return (MigrationStatus[]) $VALUES.clone();
    }

    public static MigrationStatus valueOf(String r100) {
        return (MigrationStatus) r27.a.a(MigrationStatus.class, r100);
    }

    private MigrationStatus(String r100, int r101) {
        super(r100, r101);
    }
}
