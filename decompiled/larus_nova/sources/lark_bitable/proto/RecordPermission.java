package lark_bitable.proto;

import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.WireEnum;
import r27.a;

/* JADX INFO: loaded from: classes42.dex */
public final enum RecordPermission extends Enum<RecordPermission> implements WireEnum {
    private static final /* synthetic */ RecordPermission[] $VALUES = null;
    public static final ProtoAdapter<RecordPermission> ADAPTER = null;
    public static final RecordPermission VAR_RECORD_PERMISSION_EDITABLE = null;
    public static final RecordPermission VAR_RECORD_PERMISSION_READABLE = null;
    private final int value;

    static {
        RecordPermission r100 = new RecordPermission("VAR_RECORD_PERMISSION_READABLE", 0, 0);
        VAR_RECORD_PERMISSION_READABLE = r100;
        RecordPermission r101 = new RecordPermission("VAR_RECORD_PERMISSION_EDITABLE", 1, 1);
        VAR_RECORD_PERMISSION_EDITABLE = r101;
        $VALUES = new RecordPermission[]{r100, r101};
        ADAPTER = ProtoAdapter.newEnumAdapter(RecordPermission.class);
    }

    public static RecordPermission[] values() {
        return (RecordPermission[]) $VALUES.clone();
    }

    @Override // com.squareup.wire.WireEnum
    public final int getValue() {
        return this.value;
    }

    public static RecordPermission fromValue(int r100) {
        if (r100 == 0) goto L10;
        if (r100 == 1) goto L8;
        return null;
    L8:
        return VAR_RECORD_PERMISSION_EDITABLE;
    L10:
        return VAR_RECORD_PERMISSION_READABLE;
    }

    public static RecordPermission valueOf(String r100) {
        return (RecordPermission) a.a(RecordPermission.class, r100);
    }

    private RecordPermission(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
