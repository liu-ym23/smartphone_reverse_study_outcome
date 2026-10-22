package com.bytedance.locallife.model.poi.resp;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\u0007\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/bytedance/locallife/model/poi/resp/PoiDetailPageFeedsUIType;", "", "", "value", "I", "getValue", "()I", "AWEMES_ONLY", "AWEME_TAG_RATE_MIXED", "locallife-saas-model_release"}, k = 1, mv = {1, 4, 3})
public final enum PoiDetailPageFeedsUIType extends Enum<PoiDetailPageFeedsUIType> {
    public static final PoiDetailPageFeedsUIType AWEMES_ONLY = null;
    public static final PoiDetailPageFeedsUIType AWEME_TAG_RATE_MIXED = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ PoiDetailPageFeedsUIType[] f260855a = null;
    private final int value;

    public static PoiDetailPageFeedsUIType valueOf(String r100) {
        return (PoiDetailPageFeedsUIType) r27.a.a(PoiDetailPageFeedsUIType.class, r100);
    }

    public static PoiDetailPageFeedsUIType[] values() {
        return (PoiDetailPageFeedsUIType[]) f260855a.clone();
    }

    static {
        PoiDetailPageFeedsUIType r100 = new PoiDetailPageFeedsUIType("AWEMES_ONLY", 0, 0);
        AWEMES_ONLY = r100;
        PoiDetailPageFeedsUIType r101 = new PoiDetailPageFeedsUIType("AWEME_TAG_RATE_MIXED", 1, 1);
        AWEME_TAG_RATE_MIXED = r101;
        f260855a = new PoiDetailPageFeedsUIType[]{r100, r101};
    }

    public final int getValue() {
        return this.value;
    }

    public PoiDetailPageFeedsUIType(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
