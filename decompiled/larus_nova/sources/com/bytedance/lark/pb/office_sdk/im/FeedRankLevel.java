package com.bytedance.lark.pb.office_sdk.im;

import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.WireEnum;
import r27.a;

/* JADX INFO: loaded from: classes20.dex */
public final enum FeedRankLevel extends Enum<FeedRankLevel> implements WireEnum {
    private static final /* synthetic */ FeedRankLevel[] $VALUES = null;
    public static final ProtoAdapter<FeedRankLevel> ADAPTER = null;
    public static final FeedRankLevel HIGH_RANK = null;
    public static final FeedRankLevel LOWEST_RANK = null;
    public static final FeedRankLevel MEDIUM_RANK = null;
    private final int value;

    static {
        FeedRankLevel r100 = new FeedRankLevel("LOWEST_RANK", 0, 0);
        LOWEST_RANK = r100;
        FeedRankLevel r101 = new FeedRankLevel("MEDIUM_RANK", 1, 20);
        MEDIUM_RANK = r101;
        FeedRankLevel r102 = new FeedRankLevel("HIGH_RANK", 2, 30);
        HIGH_RANK = r102;
        $VALUES = new FeedRankLevel[]{r100, r101, r102};
        ADAPTER = ProtoAdapter.newEnumAdapter(FeedRankLevel.class);
    }

    public static FeedRankLevel[] values() {
        return (FeedRankLevel[]) $VALUES.clone();
    }

    @Override // com.squareup.wire.WireEnum
    public final int getValue() {
        return this.value;
    }

    public static FeedRankLevel fromValue(int r100) {
        if (r100 == 0) goto L14;
        if (r100 == 20) goto L12;
        if (r100 == 30) goto L10;
        return null;
    L10:
        return HIGH_RANK;
    L12:
        return MEDIUM_RANK;
    L14:
        return LOWEST_RANK;
    }

    public static FeedRankLevel valueOf(String r100) {
        return (FeedRankLevel) a.a(FeedRankLevel.class, r100);
    }

    private FeedRankLevel(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
