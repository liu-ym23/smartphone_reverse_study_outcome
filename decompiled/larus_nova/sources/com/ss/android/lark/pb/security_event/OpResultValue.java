package com.ss.android.lark.pb.security_event;

import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.WireEnum;
import r27.a;

/* JADX INFO: loaded from: classes37.dex */
public final enum OpResultValue extends Enum<OpResultValue> implements WireEnum {
    private static final /* synthetic */ OpResultValue[] $VALUES = null;
    public static final ProtoAdapter<OpResultValue> ADAPTER = null;
    public static final OpResultValue OpFailed = null;
    public static final OpResultValue OpSuccess = null;
    private final int value;

    static {
        OpResultValue r100 = new OpResultValue("OpSuccess", 0, 0);
        OpSuccess = r100;
        OpResultValue r101 = new OpResultValue("OpFailed", 1, 1);
        OpFailed = r101;
        $VALUES = new OpResultValue[]{r100, r101};
        ADAPTER = ProtoAdapter.newEnumAdapter(OpResultValue.class);
    }

    public static OpResultValue[] values() {
        return (OpResultValue[]) $VALUES.clone();
    }

    @Override // com.squareup.wire.WireEnum
    public final int getValue() {
        return this.value;
    }

    public static OpResultValue fromValue(int r100) {
        if (r100 == 0) goto L10;
        if (r100 == 1) goto L8;
        return null;
    L8:
        return OpFailed;
    L10:
        return OpSuccess;
    }

    public static OpResultValue valueOf(String r100) {
        return (OpResultValue) a.a(OpResultValue.class, r100);
    }

    private OpResultValue(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
