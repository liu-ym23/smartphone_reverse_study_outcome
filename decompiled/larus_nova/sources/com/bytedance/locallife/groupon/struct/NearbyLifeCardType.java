package com.bytedance.locallife.groupon.struct;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/bytedance/locallife/groupon/struct/NearbyLifeCardType;", "", "", "type", "I", "getType", "()I", "NOTHING", "LIFE_CARD_POI_RANK", "LIFE_CARD_POI_DETAIL", "LIFE_CARD_MULTI_POI_DETAIL", "locallife-groupon-api_release"}, k = 1, mv = {1, 4, 3})
public final enum NearbyLifeCardType extends Enum<NearbyLifeCardType> {
    public static final NearbyLifeCardType LIFE_CARD_MULTI_POI_DETAIL = null;
    public static final NearbyLifeCardType LIFE_CARD_POI_DETAIL = null;
    public static final NearbyLifeCardType LIFE_CARD_POI_RANK = null;
    public static final NearbyLifeCardType NOTHING = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ NearbyLifeCardType[] f258831a = null;
    private final int type;

    public static NearbyLifeCardType valueOf(String r100) {
        return (NearbyLifeCardType) r27.a.a(NearbyLifeCardType.class, r100);
    }

    public static NearbyLifeCardType[] values() {
        return (NearbyLifeCardType[]) f258831a.clone();
    }

    static {
        NearbyLifeCardType r100 = new NearbyLifeCardType("NOTHING", 0, 0);
        NOTHING = r100;
        NearbyLifeCardType r101 = new NearbyLifeCardType("LIFE_CARD_POI_RANK", 1, 1);
        LIFE_CARD_POI_RANK = r101;
        NearbyLifeCardType r102 = new NearbyLifeCardType("LIFE_CARD_POI_DETAIL", 2, 2);
        LIFE_CARD_POI_DETAIL = r102;
        NearbyLifeCardType r103 = new NearbyLifeCardType("LIFE_CARD_MULTI_POI_DETAIL", 3, 3);
        LIFE_CARD_MULTI_POI_DETAIL = r103;
        f258831a = new NearbyLifeCardType[]{r100, r101, r102, r103};
    }

    public final int getType() {
        return this.type;
    }

    public NearbyLifeCardType(String r100, int r101, int r102) {
        super(r100, r101);
        this.type = r102;
    }
}
