package lark_bitable.proto;

import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.WireEnum;
import r27.a;

/* JADX INFO: loaded from: classes42.dex */
public final enum FieldInputType extends Enum<FieldInputType> implements WireEnum {
    private static final /* synthetic */ FieldInputType[] $VALUES = null;
    public static final ProtoAdapter<FieldInputType> ADAPTER = null;
    public static final FieldInputType VAR_FIELD_INPUT_TYPE_MOBILE = null;
    public static final FieldInputType VAR_FIELD_INPUT_TYPE_NO_LIMIT = null;
    private final int value;

    static {
        FieldInputType r100 = new FieldInputType("VAR_FIELD_INPUT_TYPE_NO_LIMIT", 0, 0);
        VAR_FIELD_INPUT_TYPE_NO_LIMIT = r100;
        FieldInputType r101 = new FieldInputType("VAR_FIELD_INPUT_TYPE_MOBILE", 1, 1);
        VAR_FIELD_INPUT_TYPE_MOBILE = r101;
        $VALUES = new FieldInputType[]{r100, r101};
        ADAPTER = ProtoAdapter.newEnumAdapter(FieldInputType.class);
    }

    public static FieldInputType[] values() {
        return (FieldInputType[]) $VALUES.clone();
    }

    @Override // com.squareup.wire.WireEnum
    public final int getValue() {
        return this.value;
    }

    public static FieldInputType fromValue(int r100) {
        if (r100 == 0) goto L10;
        if (r100 == 1) goto L8;
        return null;
    L8:
        return VAR_FIELD_INPUT_TYPE_MOBILE;
    L10:
        return VAR_FIELD_INPUT_TYPE_NO_LIMIT;
    }

    public static FieldInputType valueOf(String r100) {
        return (FieldInputType) a.a(FieldInputType.class, r100);
    }

    private FieldInputType(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
