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
import otb.n;

/* JADX INFO: loaded from: classes16.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f510961a = 0;

    static {
    }

    public static void a(Context r100, WebViewV2 r101) {
        if (r100 == null) goto L16;
        boolean r102 = f.a(r100);
        Lazy<n> r103 = TTWebViewUtil.f437209a;
        TTWebViewUtil.a.d(r101);
        tt5.a.h("DarkModeUtils", "updateDarkModeIfNeeded-" + r102 + "-false");
        if (Build.VERSION.SDK_INT < 33) goto L9;
        if (WebViewFeature.isFeatureSupported(WebViewFeature.ALGORITHMIC_DARKENING) == false) goto L17;
        WebSettingsCompat.setAlgorithmicDarkeningAllowed(r101.getSettings(), true);
        return;
    L17:
        return;
    L9:
        if (WebViewFeature.isFeatureSupported(WebViewFeature.FORCE_DARK) == false) goto L19;
        WebSettings r104 = r101.getSettings();
        if (r102 == false) goto L13;
        int r105 = 2;
    L14:
        WebSettingsCompat.setForceDark(r104, r105);
        return;
    L13:
        r105 = 0;
        goto L14
    L19:
        return;
    }
}
