package com.ss.android.lark.pb.usearch;

import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.WireEnum;
import r27.a;

/* JADX INFO: loaded from: classes37.dex */
public final enum BannerActionType extends Enum<BannerActionType> implements WireEnum {
    private static final /* synthetic */ BannerActionType[] $VALUES = null;
    public static final ProtoAdapter<BannerActionType> ADAPTER = null;
    public static final BannerActionType DisableFilterOption = null;
    public static final BannerActionType HighlightFilter = null;
    public static final BannerActionType NoAction = null;
    public static final BannerActionType ReSearch = null;
    public static final BannerActionType RouteTo = null;
    public static final BannerActionType SelectFilterOption = null;
    private final int value;

    static {
        BannerActionType r100 = new BannerActionType("NoAction", 0, 1);
        NoAction = r100;
        BannerActionType r101 = new BannerActionType("HighlightFilter", 1, 2);
        HighlightFilter = r101;
        BannerActionType r102 = new BannerActionType("SelectFilterOption", 2, 3);
        SelectFilterOption = r102;
        BannerActionType r103 = new BannerActionType("DisableFilterOption", 3, 4);
        DisableFilterOption = r103;
        BannerActionType r104 = new BannerActionType("ReSearch", 4, 5);
        ReSearch = r104;
        BannerActionType r110 = new BannerActionType("RouteTo", 5, 6);
        RouteTo = r110;
        $VALUES = new BannerActionType[]{r100, r101, r102, r103, r104, r110};
        ADAPTER = ProtoAdapter.newEnumAdapter(BannerActionType.class);
    }

    public static BannerActionType[] values() {
        return (BannerActionType[]) $VALUES.clone();
    }

    @Override // com.squareup.wire.WireEnum
    public final int getValue() {
        return this.value;
    }

    public static BannerActionType fromValue(int r100) {
        switch(r100) {
            case 1: goto L16;
            case 2: goto L14;
            case 3: goto L12;
            case 4: goto L10;
            case 5: goto L8;
            case 6: goto L6;
            default: goto L3;
        };
    L3:
        return null;
    L6:
        return RouteTo;
    L8:
        return ReSearch;
    L10:
        return DisableFilterOption;
    L12:
        return SelectFilterOption;
    L14:
        return HighlightFilter;
    L16:
        return NoAction;
    }

    public static BannerActionType valueOf(String r100) {
        return (BannerActionType) a.a(BannerActionType.class, r100);
    }

    private BannerActionType(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
