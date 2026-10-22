package com.obric.matrix.proto;

import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.WireEnum;
import r27.a;

/* JADX INFO: loaded from: classes33.dex */
public final enum NETWORK_METHOD extends Enum<NETWORK_METHOD> implements WireEnum {
    private static final /* synthetic */ NETWORK_METHOD[] $VALUES = null;
    public static final ProtoAdapter<NETWORK_METHOD> ADAPTER = null;
    public static final NETWORK_METHOD METHOD_GET = null;
    public static final NETWORK_METHOD METHOD_POST = null;
    private final int value;

    static {
        NETWORK_METHOD r100 = new NETWORK_METHOD("METHOD_GET", 0, 0);
        METHOD_GET = r100;
        NETWORK_METHOD r101 = new NETWORK_METHOD("METHOD_POST", 1, 1);
        METHOD_POST = r101;
        $VALUES = new NETWORK_METHOD[]{r100, r101};
        ADAPTER = new ProtoAdapter_NETWORK_METHOD();
    }

    public static NETWORK_METHOD[] values() {
        return (NETWORK_METHOD[]) $VALUES.clone();
    }

    @Override // com.squareup.wire.WireEnum
    public int getValue() {
        return this.value;
    }

    public static NETWORK_METHOD fromValue(int r100) {
        if (r100 == 0) goto L10;
        if (r100 == 1) goto L8;
        return null;
    L8:
        return METHOD_POST;
    L10:
        return METHOD_GET;
    }

    public static NETWORK_METHOD valueOf(String r100) {
        return (NETWORK_METHOD) a.a(NETWORK_METHOD.class, r100);
    }

    private NETWORK_METHOD(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
