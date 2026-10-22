package com.bytedance.lark.pb.todo.v1;

import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.WireEnum;
import r27.a;

/* JADX INFO: loaded from: classes20.dex */
public final enum FilterPredicate extends Enum<FilterPredicate> implements WireEnum {
    private static final /* synthetic */ FilterPredicate[] $VALUES = null;
    public static final ProtoAdapter<FilterPredicate> ADAPTER = null;
    public static final FilterPredicate EMPTY = null;
    public static final FilterPredicate EQUAL = null;
    public static final FilterPredicate EXCLUDE = null;
    public static final FilterPredicate GREATER_THAN = null;
    public static final FilterPredicate GREATER_THAN_EQUAL = null;
    public static final FilterPredicate INCLUDE = null;
    public static final FilterPredicate LESS_THAN = null;
    public static final FilterPredicate LESS_THAN_EQUAL = null;
    public static final FilterPredicate NOT_EMPTY = null;
    public static final FilterPredicate NOT_EQUAL = null;
    public static final FilterPredicate RANGE = null;
    public static final FilterPredicate UNKNOWN_PREDICATE = null;
    private final int value;

    static {
        FilterPredicate r100 = new FilterPredicate("UNKNOWN_PREDICATE", 0, 0);
        UNKNOWN_PREDICATE = r100;
        FilterPredicate r101 = new FilterPredicate("EQUAL", 1, 1);
        EQUAL = r101;
        FilterPredicate r102 = new FilterPredicate("NOT_EQUAL", 2, 2);
        NOT_EQUAL = r102;
        FilterPredicate r103 = new FilterPredicate("EMPTY", 3, 3);
        EMPTY = r103;
        FilterPredicate r104 = new FilterPredicate("NOT_EMPTY", 4, 4);
        NOT_EMPTY = r104;
        FilterPredicate r105 = new FilterPredicate("INCLUDE", 5, 5);
        INCLUDE = r105;
        FilterPredicate r110 = new FilterPredicate("EXCLUDE", 6, 6);
        EXCLUDE = r110;
        FilterPredicate r111 = new FilterPredicate("GREATER_THAN", 7, 7);
        GREATER_THAN = r111;
        FilterPredicate r112 = new FilterPredicate("LESS_THAN", 8, 8);
        LESS_THAN = r112;
        FilterPredicate r113 = new FilterPredicate("GREATER_THAN_EQUAL", 9, 9);
        GREATER_THAN_EQUAL = r113;
        FilterPredicate r114 = new FilterPredicate("LESS_THAN_EQUAL", 10, 10);
        LESS_THAN_EQUAL = r114;
        FilterPredicate r115 = new FilterPredicate("RANGE", 11, 11);
        RANGE = r115;
        $VALUES = new FilterPredicate[]{r100, r101, r102, r103, r104, r105, r110, r111, r112, r113, r114, r115};
        ADAPTER = ProtoAdapter.newEnumAdapter(FilterPredicate.class);
    }

    public static FilterPredicate[] values() {
        return (FilterPredicate[]) $VALUES.clone();
    }

    @Override // com.squareup.wire.WireEnum
    public final int getValue() {
        return this.value;
    }

    public static FilterPredicate fromValue(int r100) {
        switch(r100) {
            case 0: goto L28;
            case 1: goto L26;
            case 2: goto L24;
            case 3: goto L22;
            case 4: goto L20;
            case 5: goto L18;
            case 6: goto L16;
            case 7: goto L14;
            case 8: goto L12;
            case 9: goto L10;
            case 10: goto L8;
            case 11: goto L6;
            default: goto L3;
        };
    L3:
        return null;
    L6:
        return RANGE;
    L8:
        return LESS_THAN_EQUAL;
    L10:
        return GREATER_THAN_EQUAL;
    L12:
        return LESS_THAN;
    L14:
        return GREATER_THAN;
    L16:
        return EXCLUDE;
    L18:
        return INCLUDE;
    L20:
        return NOT_EMPTY;
    L22:
        return EMPTY;
    L24:
        return NOT_EQUAL;
    L26:
        return EQUAL;
    L28:
        return UNKNOWN_PREDICATE;
    }

    public static FilterPredicate valueOf(String r100) {
        return (FilterPredicate) a.a(FilterPredicate.class, r100);
    }

    private FilterPredicate(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
