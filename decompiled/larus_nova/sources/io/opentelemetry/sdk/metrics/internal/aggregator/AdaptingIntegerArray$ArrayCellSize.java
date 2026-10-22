package io.opentelemetry.sdk.metrics.internal.aggregator;

import r27.a;

/* JADX INFO: loaded from: classes41.dex */
final enum AdaptingIntegerArray$ArrayCellSize extends Enum<AdaptingIntegerArray$ArrayCellSize> {
    public static final AdaptingIntegerArray$ArrayCellSize BYTE = null;
    public static final AdaptingIntegerArray$ArrayCellSize INT = null;
    public static final AdaptingIntegerArray$ArrayCellSize LONG = null;
    public static final AdaptingIntegerArray$ArrayCellSize SHORT = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ AdaptingIntegerArray$ArrayCellSize[] f492724a = null;

    static {
        AdaptingIntegerArray$ArrayCellSize r100 = new AdaptingIntegerArray$ArrayCellSize("BYTE", 0);
        BYTE = r100;
        AdaptingIntegerArray$ArrayCellSize r101 = new AdaptingIntegerArray$ArrayCellSize("SHORT", 1);
        SHORT = r101;
        AdaptingIntegerArray$ArrayCellSize r102 = new AdaptingIntegerArray$ArrayCellSize("INT", 2);
        INT = r102;
        AdaptingIntegerArray$ArrayCellSize r103 = new AdaptingIntegerArray$ArrayCellSize("LONG", 3);
        LONG = r103;
        f492724a = new AdaptingIntegerArray$ArrayCellSize[]{r100, r101, r102, r103};
    }

    public static AdaptingIntegerArray$ArrayCellSize[] values() {
        return (AdaptingIntegerArray$ArrayCellSize[]) f492724a.clone();
    }

    public static AdaptingIntegerArray$ArrayCellSize valueOf(String r100) {
        return (AdaptingIntegerArray$ArrayCellSize) a.a(AdaptingIntegerArray$ArrayCellSize.class, r100);
    }

    public AdaptingIntegerArray$ArrayCellSize(String r100, int r101) {
        super(r100, r101);
    }
}
