package com.bytedance.lark.pb.search.v2;

import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.WireEnum;
import r27.a;

/* JADX INFO: loaded from: classes20.dex */
public final enum ClusteringType extends Enum<ClusteringType> implements WireEnum {
    private static final /* synthetic */ ClusteringType[] $VALUES = null;
    public static final ProtoAdapter<ClusteringType> ADAPTER = null;
    public static final ClusteringType COMMON_ITEMS = null;
    public static final ClusteringType SECTION_ITEMS = null;
    private final int value;

    static {
        ClusteringType r100 = new ClusteringType("COMMON_ITEMS", 0, 1);
        COMMON_ITEMS = r100;
        ClusteringType r101 = new ClusteringType("SECTION_ITEMS", 1, 2);
        SECTION_ITEMS = r101;
        $VALUES = new ClusteringType[]{r100, r101};
        ADAPTER = ProtoAdapter.newEnumAdapter(ClusteringType.class);
    }

    public static ClusteringType[] values() {
        return (ClusteringType[]) $VALUES.clone();
    }

    @Override // com.squareup.wire.WireEnum
    public final int getValue() {
        return this.value;
    }

    public static ClusteringType fromValue(int r100) {
        if (r100 == 1) goto L11;
        if (r100 == 2) goto L9;
        return null;
    L9:
        return SECTION_ITEMS;
    L11:
        return COMMON_ITEMS;
    }

    public static ClusteringType valueOf(String r100) {
        return (ClusteringType) a.a(ClusteringType.class, r100);
    }

    private ClusteringType(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
