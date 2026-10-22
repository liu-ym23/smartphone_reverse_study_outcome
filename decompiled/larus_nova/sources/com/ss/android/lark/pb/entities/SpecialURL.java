package com.ss.android.lark.pb.entities;

import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.WireEnum;
import r27.a;

/* JADX INFO: loaded from: classes37.dex */
public final enum SpecialURL extends Enum<SpecialURL> implements WireEnum {
    private static final /* synthetic */ SpecialURL[] $VALUES = null;
    public static final ProtoAdapter<SpecialURL> ADAPTER = null;
    public static final SpecialURL BEAR = null;
    public static final SpecialURL ENTITY_NUM = null;
    public static final SpecialURL UNKNOWN_URL = null;
    private final int value;

    static {
        SpecialURL r100 = new SpecialURL("UNKNOWN_URL", 0, 0);
        UNKNOWN_URL = r100;
        SpecialURL r101 = new SpecialURL("BEAR", 1, 1);
        BEAR = r101;
        SpecialURL r102 = new SpecialURL("ENTITY_NUM", 2, 2);
        ENTITY_NUM = r102;
        $VALUES = new SpecialURL[]{r100, r101, r102};
        ADAPTER = ProtoAdapter.newEnumAdapter(SpecialURL.class);
    }

    public static SpecialURL[] values() {
        return (SpecialURL[]) $VALUES.clone();
    }

    @Override // com.squareup.wire.WireEnum
    public final int getValue() {
        return this.value;
    }

    public static SpecialURL fromValue(int r100) {
        if (r100 == 0) goto L14;
        if (r100 == 1) goto L12;
        if (r100 == 2) goto L10;
        return null;
    L10:
        return ENTITY_NUM;
    L12:
        return BEAR;
    L14:
        return UNKNOWN_URL;
    }

    public static SpecialURL valueOf(String r100) {
        return (SpecialURL) a.a(SpecialURL.class, r100);
    }

    private SpecialURL(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
