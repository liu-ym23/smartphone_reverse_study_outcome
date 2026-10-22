package com.obric.matrix.platform.sdk.ones.region;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes33.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0003\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003¨\u0006\u0004"}, d2 = {"Lcom/obric/matrix/platform/sdk/ones/region/Region;", "", "HK", "CN", "sdk_platform_ones_release"}, k = 1, mv = {1, 6, 0})
public final enum Region extends Enum<Region> {
    public static final Region CN = null;
    public static final Region HK = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ Region[] f397006a = null;

    public static Region valueOf(String r100) {
        return (Region) a.a(Region.class, r100);
    }

    public static Region[] values() {
        return (Region[]) f397006a.clone();
    }

    static {
        Region r100 = new Region("HK", 0);
        HK = r100;
        Region r101 = new Region("CN", 1);
        CN = r101;
        f397006a = new Region[]{r100, r101};
    }

    public Region(String r100, int r101) {
        super(r100, r101);
    }
}
