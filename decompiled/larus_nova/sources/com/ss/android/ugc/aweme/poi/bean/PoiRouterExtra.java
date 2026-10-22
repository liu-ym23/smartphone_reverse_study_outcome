package com.ss.android.ugc.aweme.poi.bean;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/ss/android/ugc/aweme/poi/bean/PoiRouterExtra;", "", "", "routerMode", "I", "DEFAULT", "BIZ_CODE_REQ", "locallife-saas-model_release"}, k = 1, mv = {1, 4, 3})
public final enum PoiRouterExtra extends Enum<PoiRouterExtra> {
    public static final PoiRouterExtra BIZ_CODE_REQ = null;
    public static final PoiRouterExtra DEFAULT = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ PoiRouterExtra[] f451314a = null;
    public final int routerMode;

    public static PoiRouterExtra valueOf(String r100) {
        return (PoiRouterExtra) a.a(PoiRouterExtra.class, r100);
    }

    public static PoiRouterExtra[] values() {
        return (PoiRouterExtra[]) f451314a.clone();
    }

    static {
        PoiRouterExtra r100 = new PoiRouterExtra("DEFAULT", 0, 0);
        DEFAULT = r100;
        PoiRouterExtra r101 = new PoiRouterExtra("BIZ_CODE_REQ", 1, 1);
        BIZ_CODE_REQ = r101;
        f451314a = new PoiRouterExtra[]{r100, r101};
    }

    public PoiRouterExtra(String r100, int r101, int r102) {
        super(r100, r101);
        this.routerMode = r102;
    }
}
