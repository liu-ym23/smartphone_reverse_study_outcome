package com.ss.android.lark.pb.entities;

import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.WireEnum;
import r27.a;

/* JADX INFO: loaded from: classes37.dex */
public final enum ResCryptoType extends Enum<ResCryptoType> implements WireEnum {
    private static final /* synthetic */ ResCryptoType[] $VALUES = null;
    public static final ProtoAdapter<ResCryptoType> ADAPTER = null;
    public static final ResCryptoType BY_CLIENT = null;
    public static final ResCryptoType BY_FKMS = null;
    public static final ResCryptoType BY_SERVER = null;
    public static final ResCryptoType NOT = null;
    private final int value;

    static {
        ResCryptoType r100 = new ResCryptoType("NOT", 0, 0);
        NOT = r100;
        ResCryptoType r101 = new ResCryptoType("BY_CLIENT", 1, 1);
        BY_CLIENT = r101;
        ResCryptoType r102 = new ResCryptoType("BY_FKMS", 2, 2);
        BY_FKMS = r102;
        ResCryptoType r103 = new ResCryptoType("BY_SERVER", 3, 3);
        BY_SERVER = r103;
        $VALUES = new ResCryptoType[]{r100, r101, r102, r103};
        ADAPTER = ProtoAdapter.newEnumAdapter(ResCryptoType.class);
    }

    public static ResCryptoType[] values() {
        return (ResCryptoType[]) $VALUES.clone();
    }

    @Override // com.squareup.wire.WireEnum
    public final int getValue() {
        return this.value;
    }

    public static ResCryptoType fromValue(int r100) {
        if (r100 == 0) goto L18;
        if (r100 == 1) goto L16;
        if (r100 == 2) goto L14;
        if (r100 == 3) goto L12;
        return null;
    L12:
        return BY_SERVER;
    L14:
        return BY_FKMS;
    L16:
        return BY_CLIENT;
    L18:
        return NOT;
    }

    public static ResCryptoType valueOf(String r100) {
        return (ResCryptoType) a.a(ResCryptoType.class, r100);
    }

    private ResCryptoType(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
