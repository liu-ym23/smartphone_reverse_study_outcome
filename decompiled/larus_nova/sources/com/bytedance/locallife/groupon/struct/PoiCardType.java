package com.bytedance.locallife.groupon.struct;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/bytedance/locallife/groupon/struct/PoiCardType;", "", "", "value", "I", "getValue", "()I", "UNKNOWN", "POI_MAIL_CARD", "POI_SINGLE_DETAIL_CARD", "POI_MULTI_DETAIL_CARD", "locallife-groupon-api_release"}, k = 1, mv = {1, 4, 3})
public final enum PoiCardType extends Enum<PoiCardType> {
    public static final PoiCardType POI_MAIL_CARD = null;
    public static final PoiCardType POI_MULTI_DETAIL_CARD = null;
    public static final PoiCardType POI_SINGLE_DETAIL_CARD = null;
    public static final PoiCardType UNKNOWN = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ PoiCardType[] f258837a = null;
    private final int value;

    public static PoiCardType valueOf(String r100) {
        return (PoiCardType) r27.a.a(PoiCardType.class, r100);
    }

    public static PoiCardType[] values() {
        return (PoiCardType[]) f258837a.clone();
    }

    static {
        PoiCardType r100 = new PoiCardType("UNKNOWN", 0, 0);
        UNKNOWN = r100;
        PoiCardType r101 = new PoiCardType("POI_MAIL_CARD", 1, 1);
        POI_MAIL_CARD = r101;
        PoiCardType r102 = new PoiCardType("POI_SINGLE_DETAIL_CARD", 2, 2);
        POI_SINGLE_DETAIL_CARD = r102;
        PoiCardType r103 = new PoiCardType("POI_MULTI_DETAIL_CARD", 3, 3);
        POI_MULTI_DETAIL_CARD = r103;
        f258837a = new PoiCardType[]{r100, r101, r102, r103};
    }

    public final int getValue() {
        return this.value;
    }

    public PoiCardType(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
