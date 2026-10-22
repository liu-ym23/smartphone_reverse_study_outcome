package com.ss.android.lark.pb.security;

import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.WireEnum;
import r27.a;

/* JADX INFO: loaded from: classes37.dex */
public final enum EntityType extends Enum<EntityType> implements WireEnum {
    private static final /* synthetic */ EntityType[] $VALUES = null;
    public static final ProtoAdapter<EntityType> ADAPTER = null;
    public static final EntityType RESERVED = null;
    private final int value;

    static {
        EntityType r100 = new EntityType("RESERVED", 0, 0);
        RESERVED = r100;
        $VALUES = new EntityType[]{r100};
        ADAPTER = ProtoAdapter.newEnumAdapter(EntityType.class);
    }

    public static EntityType[] values() {
        return (EntityType[]) $VALUES.clone();
    }

    @Override // com.squareup.wire.WireEnum
    public final int getValue() {
        return this.value;
    }

    public static EntityType fromValue(int r100) {
        if (r100 == 0) goto L6;
        return null;
    L6:
        return RESERVED;
    }

    public static EntityType valueOf(String r100) {
        return (EntityType) a.a(EntityType.class, r100);
    }

    private EntityType(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
