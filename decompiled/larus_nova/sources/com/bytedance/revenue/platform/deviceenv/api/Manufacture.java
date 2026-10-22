package com.bytedance.revenue.platform.deviceenv.api;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0087\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/revenue/platform/deviceenv/api/Manufacture;", "", "MANUFACTURE_HUAWEI", "MANUFACTURE_HONOR", "MANUFACTURE_SAMSUNG", "UNKNOWN", "revenue-host-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final enum Manufacture extends Enum<Manufacture> {
    public static final Manufacture MANUFACTURE_HONOR = null;
    public static final Manufacture MANUFACTURE_HUAWEI = null;
    public static final Manufacture MANUFACTURE_SAMSUNG = null;
    public static final Manufacture UNKNOWN = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ Manufacture[] f267524a = null;

    static {
        Manufacture r100 = new Manufacture("MANUFACTURE_HUAWEI", 0);
        MANUFACTURE_HUAWEI = r100;
        Manufacture r101 = new Manufacture("MANUFACTURE_HONOR", 1);
        MANUFACTURE_HONOR = r101;
        Manufacture r102 = new Manufacture("MANUFACTURE_SAMSUNG", 2);
        MANUFACTURE_SAMSUNG = r102;
        Manufacture r103 = new Manufacture("UNKNOWN", 3);
        UNKNOWN = r103;
        f267524a = new Manufacture[]{r100, r101, r102, r103};
    }

    public static Manufacture valueOf(String r100) {
        return (Manufacture) a.a(Manufacture.class, r100);
    }

    public static Manufacture[] values() {
        return (Manufacture[]) f267524a.clone();
    }

    public Manufacture(String r100, int r101) {
        super(r100, r101);
    }
}
