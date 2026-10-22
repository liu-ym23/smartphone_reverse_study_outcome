package za;

import android.net.Uri;
import com.bytedance.android.anniex.scene.core.UrlUsageTracker;
import com.bytedance.android.anniex.utils.k;
import com.bytedance.android.livesdkapi.app.AppConstants;
import com.bytedance.ies.bullet.base.utils.logger.HybridLogger;
import com.bytedance.mt.protector.impl.UriProtector;
import com.larus.bmhome.share.panel.ShareChannel;
import com.lynx.devtoolwrapper.ScreenshotMode;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class c {
    public static final String a(String r110) {
        Intrinsics.checkNotNullParameter(r110, "url");
        long r100 = System.currentTimeMillis();     // Catch: Exception -> L43
        Uri r101 = UriProtector.parse(r110);     // Catch: Exception -> L43
        if (Intrinsics.areEqual(r101.getScheme(), "http") == false) goto L6;
    L40:
        r110 = r101.buildUpon().clearQuery().toString();     // Catch: Exception -> L43
    L41:
        HybridLogger r102 = HybridLogger.f246343a;     // Catch: Exception -> L43
        UrlUsageTracker r103 = UrlUsageTracker.f41107n;     // Catch: Exception -> L43
        HybridLogger.f("UrlUsageTracker", "getIdentifyUrl result:" + r110 + ", cost: " + (System.currentTimeMillis() - r100), null, 12);     // Catch: Exception -> L43
        return r110;
    L6:
        if (Intrinsics.areEqual(r101.getScheme(), "https") == true) goto L40;
        if (Intrinsics.areEqual(r101.getScheme(), AppConstants.SCHEME_SS_LOCAL) == false) goto L11;
    L19:
        String r111 = UriProtector.getQueryParameter(r101, "channel");     // Catch: Exception -> L43
        String r112 = UriProtector.getQueryParameter(r101, "bundle");     // Catch: Exception -> L43
        String r113 = k.c(r101);     // Catch: Exception -> L43
        if (r113 == null) goto L28;
        Uri r114 = UriProtector.parse(r113);     // Catch: Exception -> L43
        if (r114 == null) goto L28;
        Uri.Builder r115 = r114.buildUpon();     // Catch: Exception -> L43
        if (r115 == null) goto L28;
        Uri.Builder r116 = r115.clearQuery();     // Catch: Exception -> L43
        if (r116 == null) goto L28;
        String r117 = r116.toString();     // Catch: Exception -> L43
    L29:
        if (r111 == null) goto L39;
        if (r112 == null) goto L39;
        Uri.Builder r118 = new Uri.Builder().scheme(r101.getScheme());     // Catch: Exception -> L43
        if (r101.getAuthority() == null) goto L35;
        r118.authority(r101.getAuthority());     // Catch: Exception -> L43
    L35:
        Uri.Builder r119 = r118.appendQueryParameter("channel", r111).appendQueryParameter("bundle", r112);     // Catch: Exception -> L43
        if (r117 == null) goto L38;
        r119.appendQueryParameter("url", r117);     // Catch: Exception -> L43
    L38:
        r110 = r119.build().toString();     // Catch: Exception -> L43
    L39:
        r110 = r117;
    L28:
        r117 = null;
        goto L29
    L11:
        if (Intrinsics.areEqual(r101.getScheme(), ShareChannel.DOUYIN) == true) goto L19;
        if (Intrinsics.areEqual(r101.getScheme(), "hybrid") == true) goto L19;
        if (Intrinsics.areEqual(r101.getScheme(), ScreenshotMode.SCREEN_SHOT_MODE_LYNX_VIEW) == true) goto L41;
        r110 = r101.buildUpon().clearQuery().toString();     // Catch: Exception -> L43
    L43:
        e = move-exception;
        HybridLogger r104 = HybridLogger.f246343a;
        UrlUsageTracker r105 = UrlUsageTracker.f41107n;
        HybridLogger.i("UrlUsageTracker", "getIdentifyUrl error: " + e.getMessage(), null, 12);
        return null;
    }
}
