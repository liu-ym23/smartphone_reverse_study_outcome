package lv4;

import android.content.Context;
import android.os.Build;
import android.webkit.WebSettings;
import androidx.webkit.WebSettingsCompat;
import androidx.webkit.WebViewFeature;
import com.bytedance.ee.bear.browser.WebViewV2;
import com.ss.android.lark.officesdk.utils.di.TTWebViewUtil;
import h18.f;
import kotlin.Lazy;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class a {
    public static final /* synthetic */ int a = 0;

    static {
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void a(Context r2, WebViewV2 r3) {
        if (r2 == null) goto L16;
        boolean r4 = f.a(r2);
        Lazy r0 = TTWebViewUtil.a;
        TTWebViewUtil.a.d(r3);
        tt5.a.h("DarkModeUtils", "updateDarkModeIfNeeded-" + r4 + "-false");
        if (Build.VERSION.SDK_INT < 33) goto L9;
        if (WebViewFeature.isFeatureSupported("ALGORITHMIC_DARKENING") == false) goto L17;
        WebSettingsCompat.setAlgorithmicDarkeningAllowed(r3.getSettings(), true);
        return;
    L17:
        return;
    L9:
        if (WebViewFeature.isFeatureSupported("FORCE_DARK") == false) goto L19;
        WebSettings r5 = r3.getSettings();
        if (r4 == false) goto L13;
        int r6 = 2;
    L14:
        WebSettingsCompat.setForceDark(r5, r6);
        return;
    L13:
        r6 = 0;
        goto L14
    L19:
        return;
    }
}
