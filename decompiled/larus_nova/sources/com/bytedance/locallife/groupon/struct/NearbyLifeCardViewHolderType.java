package com.bytedance.locallife.groupon.struct;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\u0007\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/bytedance/locallife/groupon/struct/NearbyLifeCardViewHolderType;", "", "", "type", "I", "getType", "()I", "VIEW_HOLDER_MUSIC", "VIEW_HOLDER_VIDEO", "locallife-groupon-api_release"}, k = 1, mv = {1, 4, 3})
public final enum NearbyLifeCardViewHolderType extends Enum<NearbyLifeCardViewHolderType> {
    public static final NearbyLifeCardViewHolderType VIEW_HOLDER_MUSIC = null;
    public static final NearbyLifeCardViewHolderType VIEW_HOLDER_VIDEO = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ NearbyLifeCardViewHolderType[] f258832a = null;
    private final int type;

    public static NearbyLifeCardViewHolderType valueOf(String r100) {
        return (NearbyLifeCardViewHolderType) r27.a.a(NearbyLifeCardViewHolderType.class, r100);
    }

    public static NearbyLifeCardViewHolderType[] values() {
        return (NearbyLifeCardViewHolderType[]) f258832a.clone();
    }

    static {
        NearbyLifeCardViewHolderType r100 = new NearbyLifeCardViewHolderType("VIEW_HOLDER_MUSIC", 0, 0);
        VIEW_HOLDER_MUSIC = r100;
        NearbyLifeCardViewHolderType r101 = new NearbyLifeCardViewHolderType("VIEW_HOLDER_VIDEO", 1, 1);
        VIEW_HOLDER_VIDEO = r101;
        f258832a = new NearbyLifeCardViewHolderType[]{r100, r101};
    }

    public final int getType() {
        return this.type;
    }

    public NearbyLifeCardViewHolderType(String r100, int r101, int r102) {
        super(r100, r101);
        this.type = r102;
    }
}
