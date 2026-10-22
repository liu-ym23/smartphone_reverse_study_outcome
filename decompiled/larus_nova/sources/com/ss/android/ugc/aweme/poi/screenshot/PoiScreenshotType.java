package com.ss.android.ugc.aweme.poi.screenshot;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\u000b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\r"}, d2 = {"Lcom/ss/android/ugc/aweme/poi/screenshot/PoiScreenshotType;", "", "", "value", "I", "getValue", "()I", "POI", "TRADE", "UGC_RATE", "MAP", "FEED", "LIVE", "locallife-saas-model_release"}, k = 1, mv = {1, 4, 3})
public final enum PoiScreenshotType extends Enum<PoiScreenshotType> {
    public static final PoiScreenshotType FEED = null;
    public static final PoiScreenshotType LIVE = null;
    public static final PoiScreenshotType MAP = null;
    public static final PoiScreenshotType POI = null;
    public static final PoiScreenshotType TRADE = null;
    public static final PoiScreenshotType UGC_RATE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ PoiScreenshotType[] f451359a = null;
    private final int value;

    public static PoiScreenshotType valueOf(String r100) {
        return (PoiScreenshotType) a.a(PoiScreenshotType.class, r100);
    }

    public static PoiScreenshotType[] values() {
        return (PoiScreenshotType[]) f451359a.clone();
    }

    static {
        PoiScreenshotType r100 = new PoiScreenshotType("POI", 0, 1);
        POI = r100;
        PoiScreenshotType r101 = new PoiScreenshotType("TRADE", 1, 2);
        TRADE = r101;
        PoiScreenshotType r102 = new PoiScreenshotType("UGC_RATE", 2, 3);
        UGC_RATE = r102;
        PoiScreenshotType r103 = new PoiScreenshotType("MAP", 3, 4);
        MAP = r103;
        PoiScreenshotType r104 = new PoiScreenshotType("FEED", 4, 5);
        FEED = r104;
        PoiScreenshotType r110 = new PoiScreenshotType("LIVE", 5, 6);
        LIVE = r110;
        f451359a = new PoiScreenshotType[]{r100, r101, r102, r103, r104, r110};
    }

    public final int getValue() {
        return this.value;
    }

    public PoiScreenshotType(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
