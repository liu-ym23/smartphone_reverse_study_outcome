package com.larus.office.card.urlpreview;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import androidx.core.os.ConfigurationCompat;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;

/* JADX INFO: loaded from: classes29.dex */
public final class OfficeUrlPreviewCardSizeCache {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final OfficeUrlPreviewCardSizeCache f361715a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final OfficeUrlPreviewCardSizeCache$memoryCache$1 f361716b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Lazy f361717c = null;

    public OfficeUrlPreviewCardSizeCache() {
    }

    static {
        f361715a = new OfficeUrlPreviewCardSizeCache();
        f361716b = new OfficeUrlPreviewCardSizeCache$memoryCache$1();
        f361717c = LazyKt.lazy(LazyThreadSafetyMode.SYNCHRONIZED, new t());
    }

    public static boolean b(Context r100, boolean r101, int r102) {
        if (r102 <= 0) goto L10;
        Resources r103 = r100.getResources();
        if (r102 > WindowDisplayMetricsOverride.apply(r103, r103.getDisplayMetrics()).heightPixels) goto L10;
        Resources r104 = r100.getResources();
        int r105 = (int) (WindowDisplayMetricsOverride.apply(r104, r104.getDisplayMetrics()).density * 136.0f);
        if (r101 == true) goto L9;
        if (r102 < r105) goto L10;
    L9:
        return true;
    L10:
        return false;
    }

    public static String a(Context r100, int r101, boolean r102, int r103) {
        Configuration r104 = r100.getResources().getConfiguration();
        return "v2_" + r101 + '_' + (r102 ? 1 : 0) + '_' + r103 + '_' + r104.densityDpi + '_' + Float.floatToIntBits(r104.fontScale) + '_' + ConfigurationCompat.getLocales(r104).toLanguageTags().hashCode() + '_' + Build.VERSION.SDK_INT;
    }

    public static void c(String r100, int r101, boolean r102, int r103, int r104) {
        FLogger.f375446a.i("OfficeUrlPreviewSDK", "[CLIENT][card_size_cache_hit] source=" + r100 + ", resourceType=" + r101 + ", compact=" + r102 + ", widthPx=" + r103 + ", heightPx=" + r104);
    }
}
