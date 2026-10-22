package com.bytedance.lark.pb.basic.v1;

import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.WireEnum;
import r27.a;

/* JADX INFO: loaded from: classes20.dex */
public final enum FavoritesType extends Enum<FavoritesType> implements WireEnum {
    private static final /* synthetic */ FavoritesType[] $VALUES = null;
    public static final ProtoAdapter<FavoritesType> ADAPTER = null;
    public static final FavoritesType FAVORITES_MERGE_FAVORITE = null;
    public static final FavoritesType FAVORITES_MESSAGE = null;
    public static final FavoritesType FAVORITES_UNKNOWN = null;
    private final int value;

    static {
        FavoritesType r100 = new FavoritesType("FAVORITES_UNKNOWN", 0, 0);
        FAVORITES_UNKNOWN = r100;
        FavoritesType r101 = new FavoritesType("FAVORITES_MESSAGE", 1, 1);
        FAVORITES_MESSAGE = r101;
        FavoritesType r102 = new FavoritesType("FAVORITES_MERGE_FAVORITE", 2, 2);
        FAVORITES_MERGE_FAVORITE = r102;
        $VALUES = new FavoritesType[]{r100, r101, r102};
        ADAPTER = ProtoAdapter.newEnumAdapter(FavoritesType.class);
    }

    public static FavoritesType[] values() {
        return (FavoritesType[]) $VALUES.clone();
    }

    @Override // com.squareup.wire.WireEnum
    public final int getValue() {
        return this.value;
    }

    public static FavoritesType fromValue(int r100) {
        if (r100 == 0) goto L14;
        if (r100 == 1) goto L12;
        if (r100 == 2) goto L10;
        return null;
    L10:
        return FAVORITES_MERGE_FAVORITE;
    L12:
        return FAVORITES_MESSAGE;
    L14:
        return FAVORITES_UNKNOWN;
    }

    public static FavoritesType valueOf(String r100) {
        return (FavoritesType) a.a(FavoritesType.class, r100);
    }

    private FavoritesType(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
