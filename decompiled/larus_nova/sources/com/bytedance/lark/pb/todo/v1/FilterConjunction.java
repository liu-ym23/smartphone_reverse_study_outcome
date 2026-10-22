package com.bytedance.lark.pb.todo.v1;

import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.WireEnum;
import r27.a;

/* JADX INFO: loaded from: classes20.dex */
public final enum FilterConjunction extends Enum<FilterConjunction> implements WireEnum {
    private static final /* synthetic */ FilterConjunction[] $VALUES = null;
    public static final ProtoAdapter<FilterConjunction> ADAPTER = null;
    public static final FilterConjunction AND = null;
    public static final FilterConjunction OR = null;
    private final int value;

    static {
        FilterConjunction r100 = new FilterConjunction("AND", 0, 1);
        AND = r100;
        FilterConjunction r101 = new FilterConjunction("OR", 1, 2);
        OR = r101;
        $VALUES = new FilterConjunction[]{r100, r101};
        ADAPTER = ProtoAdapter.newEnumAdapter(FilterConjunction.class);
    }

    public static FilterConjunction[] values() {
        return (FilterConjunction[]) $VALUES.clone();
    }

    @Override // com.squareup.wire.WireEnum
    public final int getValue() {
        return this.value;
    }

    public static FilterConjunction fromValue(int r100) {
        if (r100 == 1) goto L11;
        if (r100 == 2) goto L9;
        return null;
    L9:
        return OR;
    L11:
        return AND;
    }

    public static FilterConjunction valueOf(String r100) {
        return (FilterConjunction) a.a(FilterConjunction.class, r100);
    }

    private FilterConjunction(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
