package com.bytedance.xbridge.cn.gen;

import android.webkit.WebView;
import com.bytedance.android.live.browser.jsbridge.newmethods.t3;
import com.bytedance.ies.bullet.core.kit.bridge.j;
import kotlin.jvm.internal.Intrinsics;
import m16.b;

/* JADX INFO: loaded from: classes22.dex */
public class webcast_Creator_getAppInfo_webcast {
    public webcast_Creator_getAppInfo_webcast() {
    }

    public static j create(b r100) {
        Intrinsics.checkNotNullParameter(r100, "contextProviderFactory");
        WebView r101 = (WebView) r100.c(WebView.class);
        return com.bytedance.android.annie.xbridge.mix.j.a(new t3(), "getAppInfo", r100);
    }
}
