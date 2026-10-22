package com.bytedance.lark.pb.todo.v1;

import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.WireEnum;
import r27.a;

/* JADX INFO: loaded from: classes20.dex */
public final enum DashboardStatus extends Enum<DashboardStatus> implements WireEnum {
    private static final /* synthetic */ DashboardStatus[] $VALUES = null;
    public static final ProtoAdapter<DashboardStatus> ADAPTER = null;
    public static final DashboardStatus CREATED = null;
    public static final DashboardStatus CREATING = null;
    public static final DashboardStatus DELETED = null;
    public static final DashboardStatus FAILED = null;
    public static final DashboardStatus NOT_CREATED = null;
    private final int value;

    static {
        DashboardStatus r100 = new DashboardStatus("NOT_CREATED", 0, 0);
        NOT_CREATED = r100;
        DashboardStatus r101 = new DashboardStatus("CREATING", 1, 1);
        CREATING = r101;
        DashboardStatus r102 = new DashboardStatus("CREATED", 2, 2);
        CREATED = r102;
        DashboardStatus r103 = new DashboardStatus("FAILED", 3, 3);
        FAILED = r103;
        DashboardStatus r104 = new DashboardStatus("DELETED", 4, 4);
        DELETED = r104;
        $VALUES = new DashboardStatus[]{r100, r101, r102, r103, r104};
        ADAPTER = ProtoAdapter.newEnumAdapter(DashboardStatus.class);
    }

    public static DashboardStatus[] values() {
        return (DashboardStatus[]) $VALUES.clone();
    }

    @Override // com.squareup.wire.WireEnum
    public final int getValue() {
        return this.value;
    }

    public static DashboardStatus fromValue(int r100) {
        if (r100 == 0) goto L22;
        if (r100 == 1) goto L20;
        if (r100 == 2) goto L18;
        if (r100 == 3) goto L16;
        if (r100 == 4) goto L14;
        return null;
    L14:
        return DELETED;
    L16:
        return FAILED;
    L18:
        return CREATED;
    L20:
        return CREATING;
    L22:
        return NOT_CREATED;
    }

    public static DashboardStatus valueOf(String r100) {
        return (DashboardStatus) a.a(DashboardStatus.class, r100);
    }

    private DashboardStatus(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
