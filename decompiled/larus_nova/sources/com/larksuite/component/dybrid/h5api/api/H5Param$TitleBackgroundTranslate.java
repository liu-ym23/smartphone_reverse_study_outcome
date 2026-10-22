package com.larksuite.component.dybrid.h5api.api;

import com.obric.aivoice.core.data.NameKeys;
import r27.a;

/* JADX INFO: loaded from: classes24.dex */
public final enum H5Param$TitleBackgroundTranslate extends Enum<H5Param$TitleBackgroundTranslate> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ H5Param$TitleBackgroundTranslate[] f283991a = null;
    public static final H5Param$TitleBackgroundTranslate always = null;
    public static final H5Param$TitleBackgroundTranslate auto = null;

    static {
        H5Param$TitleBackgroundTranslate r100 = new H5Param$TitleBackgroundTranslate(NameKeys.LoadStrategy_Always, 0);
        always = r100;
        H5Param$TitleBackgroundTranslate r101 = new H5Param$TitleBackgroundTranslate("auto", 1);
        auto = r101;
        f283991a = new H5Param$TitleBackgroundTranslate[]{r100, r101};
    }

    public static H5Param$TitleBackgroundTranslate[] values() {
        return (H5Param$TitleBackgroundTranslate[]) f283991a.clone();
    }

    public static H5Param$TitleBackgroundTranslate valueOf(String r100) {
        return (H5Param$TitleBackgroundTranslate) a.a(H5Param$TitleBackgroundTranslate.class, r100);
    }

    public H5Param$TitleBackgroundTranslate(String r100, int r101) {
        super(r100, r101);
    }
}
