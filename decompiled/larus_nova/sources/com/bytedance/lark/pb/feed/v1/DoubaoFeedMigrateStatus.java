package com.bytedance.lark.pb.feed.v1;

import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.WireEnum;
import r27.a;

/* JADX INFO: loaded from: classes20.dex */
public final enum DoubaoFeedMigrateStatus extends Enum<DoubaoFeedMigrateStatus> implements WireEnum {
    private static final /* synthetic */ DoubaoFeedMigrateStatus[] $VALUES = null;
    public static final ProtoAdapter<DoubaoFeedMigrateStatus> ADAPTER = null;
    public static final DoubaoFeedMigrateStatus MIGRATE_STATUS_FINISHED = null;
    public static final DoubaoFeedMigrateStatus MIGRATE_STATUS_PROCESSED_FIRST_SCREEN = null;
    public static final DoubaoFeedMigrateStatus MIGRATE_STATUS_UNKNOWN = null;
    public static final DoubaoFeedMigrateStatus MIGRATE_STATUS_WAIT_SYNC = null;
    private final int value;

    static {
        DoubaoFeedMigrateStatus r100 = new DoubaoFeedMigrateStatus("MIGRATE_STATUS_UNKNOWN", 0, 0);
        MIGRATE_STATUS_UNKNOWN = r100;
        DoubaoFeedMigrateStatus r101 = new DoubaoFeedMigrateStatus("MIGRATE_STATUS_WAIT_SYNC", 1, 1);
        MIGRATE_STATUS_WAIT_SYNC = r101;
        DoubaoFeedMigrateStatus r102 = new DoubaoFeedMigrateStatus("MIGRATE_STATUS_PROCESSED_FIRST_SCREEN", 2, 2);
        MIGRATE_STATUS_PROCESSED_FIRST_SCREEN = r102;
        DoubaoFeedMigrateStatus r103 = new DoubaoFeedMigrateStatus("MIGRATE_STATUS_FINISHED", 3, 3);
        MIGRATE_STATUS_FINISHED = r103;
        $VALUES = new DoubaoFeedMigrateStatus[]{r100, r101, r102, r103};
        ADAPTER = ProtoAdapter.newEnumAdapter(DoubaoFeedMigrateStatus.class);
    }

    public static DoubaoFeedMigrateStatus[] values() {
        return (DoubaoFeedMigrateStatus[]) $VALUES.clone();
    }

    @Override // com.squareup.wire.WireEnum
    public final int getValue() {
        return this.value;
    }

    public static DoubaoFeedMigrateStatus fromValue(int r100) {
        if (r100 == 0) goto L18;
        if (r100 == 1) goto L16;
        if (r100 == 2) goto L14;
        if (r100 == 3) goto L12;
        return null;
    L12:
        return MIGRATE_STATUS_FINISHED;
    L14:
        return MIGRATE_STATUS_PROCESSED_FIRST_SCREEN;
    L16:
        return MIGRATE_STATUS_WAIT_SYNC;
    L18:
        return MIGRATE_STATUS_UNKNOWN;
    }

    public static DoubaoFeedMigrateStatus valueOf(String r100) {
        return (DoubaoFeedMigrateStatus) a.a(DoubaoFeedMigrateStatus.class, r100);
    }

    private DoubaoFeedMigrateStatus(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
