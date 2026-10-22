package com.ss.android.lark.pb.security_event;

import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.WireEnum;
import r27.a;

/* JADX INFO: loaded from: classes37.dex */
public final enum FlagType extends Enum<FlagType> implements WireEnum {
    private static final /* synthetic */ FlagType[] $VALUES = null;
    public static final ProtoAdapter<FlagType> ADAPTER = null;
    public static final FlagType FlagNormal = null;
    public static final FlagType FlagStress = null;
    public static final FlagType FlagTest = null;
    private final int value;

    static {
        FlagType r100 = new FlagType("FlagNormal", 0, 0);
        FlagNormal = r100;
        FlagType r101 = new FlagType("FlagTest", 1, 1);
        FlagTest = r101;
        FlagType r102 = new FlagType("FlagStress", 2, 2);
        FlagStress = r102;
        $VALUES = new FlagType[]{r100, r101, r102};
        ADAPTER = ProtoAdapter.newEnumAdapter(FlagType.class);
    }

    public static FlagType[] values() {
        return (FlagType[]) $VALUES.clone();
    }

    @Override // com.squareup.wire.WireEnum
    public final int getValue() {
        return this.value;
    }

    public static FlagType fromValue(int r100) {
        if (r100 == 0) goto L14;
        if (r100 == 1) goto L12;
        if (r100 == 2) goto L10;
        return null;
    L10:
        return FlagStress;
    L12:
        return FlagTest;
    L14:
        return FlagNormal;
    }

    public static FlagType valueOf(String r100) {
        return (FlagType) a.a(FlagType.class, r100);
    }

    private FlagType(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
