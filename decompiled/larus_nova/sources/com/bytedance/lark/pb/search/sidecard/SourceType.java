package com.bytedance.lark.pb.search.sidecard;

import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.WireEnum;
import r27.a;

/* JADX INFO: loaded from: classes20.dex */
public final enum SourceType extends Enum<SourceType> implements WireEnum {
    private static final /* synthetic */ SourceType[] $VALUES = null;
    public static final ProtoAdapter<SourceType> ADAPTER = null;
    public static final SourceType Exact = null;
    public static final SourceType Fuzzy = null;
    private final int value;

    static {
        SourceType r100 = new SourceType("Exact", 0, 1);
        Exact = r100;
        SourceType r101 = new SourceType("Fuzzy", 1, 2);
        Fuzzy = r101;
        $VALUES = new SourceType[]{r100, r101};
        ADAPTER = ProtoAdapter.newEnumAdapter(SourceType.class);
    }

    public static SourceType[] values() {
        return (SourceType[]) $VALUES.clone();
    }

    @Override // com.squareup.wire.WireEnum
    public final int getValue() {
        return this.value;
    }

    public static SourceType fromValue(int r100) {
        if (r100 == 1) goto L11;
        if (r100 == 2) goto L9;
        return null;
    L9:
        return Fuzzy;
    L11:
        return Exact;
    }

    public static SourceType valueOf(String r100) {
        return (SourceType) a.a(SourceType.class, r100);
    }

    private SourceType(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
