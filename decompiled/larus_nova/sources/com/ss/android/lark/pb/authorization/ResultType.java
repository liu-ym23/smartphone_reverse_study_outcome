package com.ss.android.lark.pb.authorization;

import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.WireEnum;
import r27.a;

/* JADX INFO: loaded from: classes37.dex */
public final enum ResultType extends Enum<ResultType> implements WireEnum {
    private static final /* synthetic */ ResultType[] $VALUES = null;
    public static final ProtoAdapter<ResultType> ADAPTER = null;
    public static final ResultType Allow = null;
    public static final ResultType Deny = null;
    public static final ResultType Null = null;
    public static final ResultType RESULT_TYPE_UNKNOWN = null;
    private final int value;

    static {
        ResultType r100 = new ResultType("RESULT_TYPE_UNKNOWN", 0, 0);
        RESULT_TYPE_UNKNOWN = r100;
        ResultType r101 = new ResultType("Deny", 1, 1);
        Deny = r101;
        ResultType r102 = new ResultType("Allow", 2, 2);
        Allow = r102;
        ResultType r103 = new ResultType("Null", 3, 3);
        Null = r103;
        $VALUES = new ResultType[]{r100, r101, r102, r103};
        ADAPTER = ProtoAdapter.newEnumAdapter(ResultType.class);
    }

    public static ResultType[] values() {
        return (ResultType[]) $VALUES.clone();
    }

    @Override // com.squareup.wire.WireEnum
    public final int getValue() {
        return this.value;
    }

    public static ResultType fromValue(int r100) {
        if (r100 == 0) goto L18;
        if (r100 == 1) goto L16;
        if (r100 == 2) goto L14;
        if (r100 == 3) goto L12;
        return null;
    L12:
        return Null;
    L14:
        return Allow;
    L16:
        return Deny;
    L18:
        return RESULT_TYPE_UNKNOWN;
    }

    public static ResultType valueOf(String r100) {
        return (ResultType) a.a(ResultType.class, r100);
    }

    private ResultType(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
