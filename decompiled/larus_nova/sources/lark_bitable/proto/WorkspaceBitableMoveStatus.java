package lark_bitable.proto;

import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.WireEnum;
import r27.a;

/* JADX INFO: loaded from: classes42.dex */
public final enum WorkspaceBitableMoveStatus extends Enum<WorkspaceBitableMoveStatus> implements WireEnum {
    private static final /* synthetic */ WorkspaceBitableMoveStatus[] $VALUES = null;
    public static final ProtoAdapter<WorkspaceBitableMoveStatus> ADAPTER = null;
    public static final WorkspaceBitableMoveStatus VAR_WORKSPACE_BITABLE_MOVE_STATUS_FAIL = null;
    public static final WorkspaceBitableMoveStatus VAR_WORKSPACE_BITABLE_MOVE_STATUS_NOPERMISSION = null;
    public static final WorkspaceBitableMoveStatus VAR_WORKSPACE_BITABLE_MOVE_STATUS_SUCCESS = null;
    public static final WorkspaceBitableMoveStatus VAR_WORKSPACE_BITABLE_MOVE_STATUS_UNSUPPORTED = null;
    private final int value;

    static {
        WorkspaceBitableMoveStatus r100 = new WorkspaceBitableMoveStatus("VAR_WORKSPACE_BITABLE_MOVE_STATUS_UNSUPPORTED", 0, 0);
        VAR_WORKSPACE_BITABLE_MOVE_STATUS_UNSUPPORTED = r100;
        WorkspaceBitableMoveStatus r101 = new WorkspaceBitableMoveStatus("VAR_WORKSPACE_BITABLE_MOVE_STATUS_SUCCESS", 1, 1);
        VAR_WORKSPACE_BITABLE_MOVE_STATUS_SUCCESS = r101;
        WorkspaceBitableMoveStatus r102 = new WorkspaceBitableMoveStatus("VAR_WORKSPACE_BITABLE_MOVE_STATUS_FAIL", 2, 2);
        VAR_WORKSPACE_BITABLE_MOVE_STATUS_FAIL = r102;
        WorkspaceBitableMoveStatus r103 = new WorkspaceBitableMoveStatus("VAR_WORKSPACE_BITABLE_MOVE_STATUS_NOPERMISSION", 3, 3);
        VAR_WORKSPACE_BITABLE_MOVE_STATUS_NOPERMISSION = r103;
        $VALUES = new WorkspaceBitableMoveStatus[]{r100, r101, r102, r103};
        ADAPTER = ProtoAdapter.newEnumAdapter(WorkspaceBitableMoveStatus.class);
    }

    public static WorkspaceBitableMoveStatus[] values() {
        return (WorkspaceBitableMoveStatus[]) $VALUES.clone();
    }

    @Override // com.squareup.wire.WireEnum
    public final int getValue() {
        return this.value;
    }

    public static WorkspaceBitableMoveStatus fromValue(int r100) {
        if (r100 == 0) goto L18;
        if (r100 == 1) goto L16;
        if (r100 == 2) goto L14;
        if (r100 == 3) goto L12;
        return null;
    L12:
        return VAR_WORKSPACE_BITABLE_MOVE_STATUS_NOPERMISSION;
    L14:
        return VAR_WORKSPACE_BITABLE_MOVE_STATUS_FAIL;
    L16:
        return VAR_WORKSPACE_BITABLE_MOVE_STATUS_SUCCESS;
    L18:
        return VAR_WORKSPACE_BITABLE_MOVE_STATUS_UNSUPPORTED;
    }

    public static WorkspaceBitableMoveStatus valueOf(String r100) {
        return (WorkspaceBitableMoveStatus) a.a(WorkspaceBitableMoveStatus.class, r100);
    }

    private WorkspaceBitableMoveStatus(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
