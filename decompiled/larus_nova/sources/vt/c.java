package vt;

import com.alibaba.gaiax.template.GXTemplateKey;
import com.bytedance.android.gamecp.common.utils.p0;
import com.bytedance.ee.bear.document.customheader.CustomHeaderConfig;
import com.bytedance.mt.protector.impl.UriProtector;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public final class c {
    public static final boolean a() {
        return !p0.a();
    }

    public static final String b(String r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$toSchemaUrl");
        if (a() == false) goto L5;
        Intrinsics.checkNotNullParameter(r100, "$this$toPortraitUrl");
        return UriProtector.parse("sslocal://webcast_webview").buildUpon().appendQueryParameter("type", "fullscreen").appendQueryParameter("web_bg_color", CustomHeaderConfig.COLOR_LIGHT).appendQueryParameter("url", r100).build().toString();
    L5:
        Intrinsics.checkNotNullParameter(r100, "$this$toLandscapeUrl");
        return UriProtector.parse("sslocal://webcast_webview").buildUpon().appendQueryParameter("type", "popup").appendQueryParameter(GXTemplateKey.GAIAX_LAYER_GRAVITY, "right").appendQueryParameter("landscape_custom_width", "1").appendQueryParameter("web_bg_color", CustomHeaderConfig.COLOR_LIGHT).appendQueryParameter("url", r100).build().toString();
    }
}
