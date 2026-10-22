package com.bytedance.ee.bear.bitable.homepage.recommend.datasource;

import com.android.ttcjpaysdk.outer.pay.view.OuterPayLoginWrapper;
import com.bytedance.ee.bear.bitable.homepage.BitableHomePageConfig;
import com.ss.android.lark.appsetting.api.SettingManager;
import kotlin.jvm.JvmStatic;

/* JADX INFO: loaded from: classes15.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f213021a = 0;

    static {
    }

    @JvmStatic
    public static final String a() {
        BitableHomePageConfig r100 = (BitableHomePageConfig) SettingManager.getInstance().get(BitableHomePageConfig.class);
        if (r100 == null) goto L6;
        String r101 = r100.getRecommendListCacheVersion();
        if (r101 == null) goto L6;
    L7:
        tt5.a.h("BitableRecommendStorage", "cache data version is ".concat(r101));
        return r101;
    L6:
        r101 = OuterPayLoginWrapper.LOGIN_STYLE_V1;
        goto L7
    }
}
