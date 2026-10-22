package lark_bitable.proto;

import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.WireEnum;
import r27.a;

/* JADX INFO: loaded from: classes42.dex */
public final enum BitableDocumentType extends Enum<BitableDocumentType> implements WireEnum {
    private static final /* synthetic */ BitableDocumentType[] $VALUES = null;
    public static final ProtoAdapter<BitableDocumentType> ADAPTER = null;
    public static final BitableDocumentType VAR_BITABLE_DOCUMENT_TYPE_ADD_RECORD = null;
    public static final BitableDocumentType VAR_BITABLE_DOCUMENT_TYPE_MAIN = null;
    public static final BitableDocumentType VAR_BITABLE_DOCUMENT_TYPE_RECORD = null;
    private final int value;

    static {
        BitableDocumentType r100 = new BitableDocumentType("VAR_BITABLE_DOCUMENT_TYPE_MAIN", 0, 1);
        VAR_BITABLE_DOCUMENT_TYPE_MAIN = r100;
        BitableDocumentType r101 = new BitableDocumentType("VAR_BITABLE_DOCUMENT_TYPE_RECORD", 1, 2);
        VAR_BITABLE_DOCUMENT_TYPE_RECORD = r101;
        BitableDocumentType r102 = new BitableDocumentType("VAR_BITABLE_DOCUMENT_TYPE_ADD_RECORD", 2, 3);
        VAR_BITABLE_DOCUMENT_TYPE_ADD_RECORD = r102;
        $VALUES = new BitableDocumentType[]{r100, r101, r102};
        ADAPTER = ProtoAdapter.newEnumAdapter(BitableDocumentType.class);
    }

    public static BitableDocumentType[] values() {
        return (BitableDocumentType[]) $VALUES.clone();
    }

    @Override // com.squareup.wire.WireEnum
    public final int getValue() {
        return this.value;
    }

    public static BitableDocumentType fromValue(int r100) {
        if (r100 == 1) goto L15;
        if (r100 == 2) goto L13;
        if (r100 == 3) goto L11;
        return null;
    L11:
        return VAR_BITABLE_DOCUMENT_TYPE_ADD_RECORD;
    L13:
        return VAR_BITABLE_DOCUMENT_TYPE_RECORD;
    L15:
        return VAR_BITABLE_DOCUMENT_TYPE_MAIN;
    }

    public static BitableDocumentType valueOf(String r100) {
        return (BitableDocumentType) a.a(BitableDocumentType.class, r100);
    }

    private BitableDocumentType(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
