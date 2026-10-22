package com.bytedance.locallife.model.poi.resp;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\u0007\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/bytedance/locallife/model/poi/resp/PoiUgcFeedItemType;", "", "", "value", "I", "getValue", "()I", "POI_TAG_RATE", "POI_UGC_AWEME", "locallife-saas-model_release"}, k = 1, mv = {1, 4, 3})
public final enum PoiUgcFeedItemType extends Enum<PoiUgcFeedItemType> {
    public static final PoiUgcFeedItemType POI_TAG_RATE = null;
    public static final PoiUgcFeedItemType POI_UGC_AWEME = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ PoiUgcFeedItemType[] f260856a = null;
    private final int value;

    public static PoiUgcFeedItemType valueOf(String r100) {
        return (PoiUgcFeedItemType) r27.a.a(PoiUgcFeedItemType.class, r100);
    }

    public static PoiUgcFeedItemType[] values() {
        return (PoiUgcFeedItemType[]) f260856a.clone();
    }

    static {
        PoiUgcFeedItemType r100 = new PoiUgcFeedItemType("POI_TAG_RATE", 0, 1);
        POI_TAG_RATE = r100;
        PoiUgcFeedItemType r101 = new PoiUgcFeedItemType("POI_UGC_AWEME", 1, 2);
        POI_UGC_AWEME = r101;
        f260856a = new PoiUgcFeedItemType[]{r100, r101};
    }

    public final int getValue() {
        return this.value;
    }

    public PoiUgcFeedItemType(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
