package com.bytedance.lark.pb.basic.v1;

import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.WireEnum;
import r27.a;

/* JADX INFO: loaded from: classes20.dex */
public final enum ContactOperation extends Enum<ContactOperation> implements WireEnum {
    private static final /* synthetic */ ContactOperation[] $VALUES = null;
    public static final ProtoAdapter<ContactOperation> ADAPTER = null;
    public static final ContactOperation OPERATION_ADD = null;
    public static final ContactOperation OPERATION_DELETE = null;
    public static final ContactOperation OPERATION_UNKNOWN = null;
    public static final ContactOperation OPERATION_UPDATE = null;
    private final int value;

    static {
        ContactOperation r100 = new ContactOperation("OPERATION_UNKNOWN", 0, 0);
        OPERATION_UNKNOWN = r100;
        ContactOperation r101 = new ContactOperation("OPERATION_ADD", 1, 1);
        OPERATION_ADD = r101;
        ContactOperation r102 = new ContactOperation("OPERATION_DELETE", 2, 2);
        OPERATION_DELETE = r102;
        ContactOperation r103 = new ContactOperation("OPERATION_UPDATE", 3, 3);
        OPERATION_UPDATE = r103;
        $VALUES = new ContactOperation[]{r100, r101, r102, r103};
        ADAPTER = ProtoAdapter.newEnumAdapter(ContactOperation.class);
    }

    public static ContactOperation[] values() {
        return (ContactOperation[]) $VALUES.clone();
    }

    @Override // com.squareup.wire.WireEnum
    public final int getValue() {
        return this.value;
    }

    public static ContactOperation fromValue(int r100) {
        if (r100 == 0) goto L18;
        if (r100 == 1) goto L16;
        if (r100 == 2) goto L14;
        if (r100 == 3) goto L12;
        return null;
    L12:
        return OPERATION_UPDATE;
    L14:
        return OPERATION_DELETE;
    L16:
        return OPERATION_ADD;
    L18:
        return OPERATION_UNKNOWN;
    }

    public static ContactOperation valueOf(String r100) {
        return (ContactOperation) a.a(ContactOperation.class, r100);
    }

    private ContactOperation(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
