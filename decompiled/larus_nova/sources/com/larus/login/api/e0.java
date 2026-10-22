package com.larus.login.api;

import android.net.Uri;
import com.bytedance.android.livesdkapi.app.AppConstants;
import com.bytedance.android.livesdkapi.depend.constant.SchemaConstants;
import com.bytedance.router.SmartRouter;
import com.larus.common.apphost.AppHost;

/* JADX INFO: loaded from: classes30.dex */
public final class e0 {
    public static final void a() {
        Uri r100 = new Uri.Builder().scheme(AppConstants.SCHEME_SS_LOCAL).path(SchemaConstants.SCHEMA_WEBVIEW).appendQueryParameter("url", "https://z.douyin.com/RQYtn").build();
        SmartRouter.buildRoute(AppHost.f326268a.getApplication(), r100.toString()).d();
    }
}
