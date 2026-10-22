package com.bytedance.lark.pb.im.v1;

import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.WireEnum;
import com.ss.android.ugc.effectmanager.common.EffectConstants;
import r27.a;

/* JADX INFO: loaded from: classes20.dex */
public final enum HongbaoType extends Enum<HongbaoType> implements WireEnum {
    private static final /* synthetic */ HongbaoType[] $VALUES = null;
    public static final ProtoAdapter<HongbaoType> ADAPTER = null;
    public static final HongbaoType COMMERCIAL = null;
    public static final HongbaoType NORMAL = null;
    public static final HongbaoType UNKNOWN = null;
    private final int value;

    static {
        HongbaoType r100 = new HongbaoType("UNKNOWN", 0, 0);
        UNKNOWN = r100;
        HongbaoType r101 = new HongbaoType(EffectConstants.NORMAL, 1, 1);
        NORMAL = r101;
        HongbaoType r102 = new HongbaoType("COMMERCIAL", 2, 2);
        COMMERCIAL = r102;
        $VALUES = new HongbaoType[]{r100, r101, r102};
        ADAPTER = ProtoAdapter.newEnumAdapter(HongbaoType.class);
    }

    public static HongbaoType[] values() {
        return (HongbaoType[]) $VALUES.clone();
    }

    @Override // com.squareup.wire.WireEnum
    public final int getValue() {
        return this.value;
    }

    public static HongbaoType fromValue(int r100) {
        if (r100 == 0) goto L14;
        if (r100 == 1) goto L12;
        if (r100 == 2) goto L10;
        return null;
    L10:
        return COMMERCIAL;
    L12:
        return NORMAL;
    L14:
        return UNKNOWN;
    }

    public static HongbaoType valueOf(String r100) {
        return (HongbaoType) a.a(HongbaoType.class, r100);
    }

    private HongbaoType(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
