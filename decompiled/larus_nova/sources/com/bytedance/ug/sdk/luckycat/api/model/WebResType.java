package com.bytedance.ug.sdk.luckycat.api.model;

import r27.a;

/* JADX INFO: loaded from: classes22.dex */
public final enum WebResType extends Enum<WebResType> {
    public static final WebResType BUILD_IN = null;
    public static final WebResType CDN = null;
    public static final WebResType GECKO = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ WebResType[] f271069a = null;

    static {
        WebResType r100 = new WebResType("CDN", 0);
        CDN = r100;
        WebResType r101 = new WebResType("GECKO", 1);
        GECKO = r101;
        WebResType r102 = new WebResType("BUILD_IN", 2);
        BUILD_IN = r102;
        f271069a = new WebResType[]{r100, r101, r102};
    }

    public static WebResType[] values() {
        return (WebResType[]) f271069a.clone();
    }

    public static WebResType valueOf(String r100) {
        return (WebResType) a.a(WebResType.class, r100);
    }

    public WebResType(String r100, int r101) {
        super(r100, r101);
    }
}
