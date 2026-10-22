package com.bytedance.awemeopen.bizmodels.feed.base;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"com/bytedance/awemeopen/bizmodels/feed/base/AppImageUri$Type", "", "Lcom/bytedance/awemeopen/bizmodels/feed/base/AppImageUri$Type;", "RES_ID", "URL", "URL_MODEL", "ao_biz_models_release"}, k = 1, mv = {1, 7, 1})
public final enum AppImageUri$Type extends Enum<AppImageUri$Type> {
    public static final AppImageUri$Type RES_ID = null;
    public static final AppImageUri$Type URL = null;
    public static final AppImageUri$Type URL_MODEL = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ AppImageUri$Type[] f198177a = null;

    public static AppImageUri$Type valueOf(String r100) {
        return (AppImageUri$Type) a.a(AppImageUri$Type.class, r100);
    }

    public static AppImageUri$Type[] values() {
        return (AppImageUri$Type[]) f198177a.clone();
    }

    static {
        AppImageUri$Type r100 = new AppImageUri$Type("RES_ID", 0);
        RES_ID = r100;
        AppImageUri$Type r101 = new AppImageUri$Type("URL", 1);
        URL = r101;
        AppImageUri$Type r102 = new AppImageUri$Type("URL_MODEL", 2);
        URL_MODEL = r102;
        f198177a = new AppImageUri$Type[]{r100, r101, r102};
    }

    public AppImageUri$Type(String r100, int r101) {
        super(r100, r101);
    }
}
