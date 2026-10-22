package com.bytedance.lark.pb.basic.v1;

import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.WireEnum;
import r27.a;

/* JADX INFO: loaded from: classes20.dex */
public final enum ProxyType extends Enum<ProxyType> implements WireEnum {
    private static final /* synthetic */ ProxyType[] $VALUES = null;
    public static final ProtoAdapter<ProxyType> ADAPTER = null;
    public static final ProxyType Automatic = null;
    public static final ProxyType None = null;
    public static final ProxyType Specify = null;
    private final int value;

    static {
        ProxyType r100 = new ProxyType("None", 0, 1);
        None = r100;
        ProxyType r101 = new ProxyType("Specify", 1, 2);
        Specify = r101;
        ProxyType r102 = new ProxyType("Automatic", 2, 3);
        Automatic = r102;
        $VALUES = new ProxyType[]{r100, r101, r102};
        ADAPTER = ProtoAdapter.newEnumAdapter(ProxyType.class);
    }

    public static ProxyType[] values() {
        return (ProxyType[]) $VALUES.clone();
    }

    @Override // com.squareup.wire.WireEnum
    public final int getValue() {
        return this.value;
    }

    public static ProxyType fromValue(int r100) {
        if (r100 == 1) goto L15;
        if (r100 == 2) goto L13;
        if (r100 == 3) goto L11;
        return null;
    L11:
        return Automatic;
    L13:
        return Specify;
    L15:
        return None;
    }

    public static ProxyType valueOf(String r100) {
        return (ProxyType) a.a(ProxyType.class, r100);
    }

    private ProxyType(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
