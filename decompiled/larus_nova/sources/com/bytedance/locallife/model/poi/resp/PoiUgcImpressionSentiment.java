package com.bytedance.locallife.model.poi.resp;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/bytedance/locallife/model/poi/resp/PoiUgcImpressionSentiment;", "", "", "value", "I", "getValue", "()I", "POI_UGC_IMPRESSION_SENTIMENT_UNKNOWN", "POI_UGC_IMPRESSION_SENTIMENT_POS", "POI_UGC_IMPRESSION_SENTIMENT_NEG", "POI_UGC_IMPRESSION_SENTIMENT_NEU", "locallife-saas-model_release"}, k = 1, mv = {1, 4, 3})
public final enum PoiUgcImpressionSentiment extends Enum<PoiUgcImpressionSentiment> {
    public static final PoiUgcImpressionSentiment POI_UGC_IMPRESSION_SENTIMENT_NEG = null;
    public static final PoiUgcImpressionSentiment POI_UGC_IMPRESSION_SENTIMENT_NEU = null;
    public static final PoiUgcImpressionSentiment POI_UGC_IMPRESSION_SENTIMENT_POS = null;
    public static final PoiUgcImpressionSentiment POI_UGC_IMPRESSION_SENTIMENT_UNKNOWN = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ PoiUgcImpressionSentiment[] f260858a = null;
    private final int value;

    public static PoiUgcImpressionSentiment valueOf(String r100) {
        return (PoiUgcImpressionSentiment) r27.a.a(PoiUgcImpressionSentiment.class, r100);
    }

    public static PoiUgcImpressionSentiment[] values() {
        return (PoiUgcImpressionSentiment[]) f260858a.clone();
    }

    static {
        PoiUgcImpressionSentiment r100 = new PoiUgcImpressionSentiment("POI_UGC_IMPRESSION_SENTIMENT_UNKNOWN", 0, 0);
        POI_UGC_IMPRESSION_SENTIMENT_UNKNOWN = r100;
        PoiUgcImpressionSentiment r101 = new PoiUgcImpressionSentiment("POI_UGC_IMPRESSION_SENTIMENT_POS", 1, 1);
        POI_UGC_IMPRESSION_SENTIMENT_POS = r101;
        PoiUgcImpressionSentiment r102 = new PoiUgcImpressionSentiment("POI_UGC_IMPRESSION_SENTIMENT_NEG", 2, 2);
        POI_UGC_IMPRESSION_SENTIMENT_NEG = r102;
        PoiUgcImpressionSentiment r103 = new PoiUgcImpressionSentiment("POI_UGC_IMPRESSION_SENTIMENT_NEU", 3, 3);
        POI_UGC_IMPRESSION_SENTIMENT_NEU = r103;
        f260858a = new PoiUgcImpressionSentiment[]{r100, r101, r102, r103};
    }

    public final int getValue() {
        return this.value;
    }

    public PoiUgcImpressionSentiment(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
