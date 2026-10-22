package com.ss.android.lark.pb.security_event;

import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.WireEnum;
import r27.a;

/* JADX INFO: loaded from: classes37.dex */
public final enum ContainerType extends Enum<ContainerType> implements WireEnum {
    private static final /* synthetic */ ContainerType[] $VALUES = null;
    public static final ProtoAdapter<ContainerType> ADAPTER = null;
    public static final ContainerType ContainerTypeUnknown = null;
    public static final ContainerType Wiki = null;
    private final int value;

    static {
        ContainerType r100 = new ContainerType("ContainerTypeUnknown", 0, 0);
        ContainerTypeUnknown = r100;
        ContainerType r101 = new ContainerType("Wiki", 1, 1);
        Wiki = r101;
        $VALUES = new ContainerType[]{r100, r101};
        ADAPTER = ProtoAdapter.newEnumAdapter(ContainerType.class);
    }

    public static ContainerType[] values() {
        return (ContainerType[]) $VALUES.clone();
    }

    @Override // com.squareup.wire.WireEnum
    public final int getValue() {
        return this.value;
    }

    public static ContainerType fromValue(int r100) {
        if (r100 == 0) goto L10;
        if (r100 == 1) goto L8;
        return null;
    L8:
        return Wiki;
    L10:
        return ContainerTypeUnknown;
    }

    public static ContainerType valueOf(String r100) {
        return (ContainerType) a.a(ContainerType.class, r100);
    }

    private ContainerType(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
