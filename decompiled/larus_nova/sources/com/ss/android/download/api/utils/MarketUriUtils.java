package com.ss.android.download.api.utils;

import android.net.Uri;
import android.text.TextUtils;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.ss.android.download.api.constant.BaseConstants;
import com.ss.android.download.api.runtime.IAdSDKSettingsProvider;
import com.ss.android.download.api.settings.TTDownloadSettingsAdapter;
import com.ss.android.download.api.settings.TTDownloadSettingsModel;
import com.ss.android.downloadlib.addownload.DownloadAdRuntimeProvider;
import com.ss.android.downloadlib.constants.DownloadSettingKeys;
import com.ss.android.socialbase.appdownloader.util.RomUtils;
import java.util.List;

/* JADX INFO: loaded from: classes34.dex */
public class MarketUriUtils {
    public MarketUriUtils() {
    }

    public static Uri getOptSchemeUri(String r100) {
        String r101 = RomUtils.getName();
        TTDownloadSettingsModel r102 = TTDownloadSettingsAdapter.INSTANCE.get();
        byte r103 = 0;
        if (r102 != null) goto L5;
    L7:
        boolean r104 = false;
    L8:
        Uri.Builder r105 = new Uri.Builder();
        if (RomUtils.isOppo() == false) goto L11;
    L43:
        if (r104 == false) goto L46;
        return r105.scheme(BaseConstants.MARKET_SCHEME_OPPO).authority("details").appendQueryParameter("packagename", r100).build();
    L46:
        return UriProtector.parse(BaseConstants.MARKET_PREFIX + r100);
    L11:
        if (RomUtils.isOnePlus() == true) goto L43;
        r101.getClass();
        switch(r101.hashCode()) {
            case 2132284: goto L25;
            case 2634924: goto L21;
            case 1547013345: goto L17;
            default: goto L15;
        };
    L15:
        r103 = -1;
    L28:
        switch(r103) {
            case 0: goto L39;
            case 1: goto L35;
            case 2: goto L31;
            default: goto L30;
        };
    L31:
        if (r104 == false) goto L34;
        return r105.scheme(BaseConstants.MARKET_SCHEME_HONOR).authority("details").appendQueryParameter("id", r100).build();
    L34:
        return UriProtector.parse(BaseConstants.MARKET_PREFIX + r100);
    L35:
        if (r104 == false) goto L38;
        return r105.scheme(BaseConstants.MARKET_SCHEME_VIVO).authority("details").appendQueryParameter("id", r100).build();
    L38:
        return UriProtector.parse(BaseConstants.MARKET_PREFIX + r100);
    L39:
        if (r104 == false) goto L42;
        return r105.scheme(BaseConstants.MARKET_SCHEME_HUAWEI).authority("details").appendQueryParameter("id", r100).build();
    L42:
        return UriProtector.parse(BaseConstants.MARKET_PREFIX + r100);
    L30:
        return UriProtector.parse(BaseConstants.MARKET_PREFIX + r100);
    L17:
        if (r101.equals(RomUtils.ROM_MAGICUI) == false) goto L15;
        r103 = 2;
        goto L28
    L21:
        if (r101.equals("VIVO") == false) goto L15;
        r103 = 1;
        goto L28
    L25:
        if (r101.equals("EMUI") == true) goto L28;
    L5:
        if (r102.getEnableDownloadSchemeOpt() != 1) goto L7;
        r104 = true;
        goto L8
    }

    public static String getPackageNameFromUri(Uri r100) {
        String r101 = r100.getScheme();
        List<String> r102 = r100.getPathSegments();
        IAdSDKSettingsProvider r103 = (IAdSDKSettingsProvider) DownloadAdRuntimeProvider.getInnerService(IAdSDKSettingsProvider.class);
        TTDownloadSettingsModel r104 = TTDownloadSettingsAdapter.INSTANCE.get();
        if (r104 != null) goto L5;
    L7:
        boolean r105 = false;
    L8:
        if (r103 == null) goto L22;
        if (r103.getTTDownloaderAdSettings().optInt(DownloadSettingKeys.MARKET_SCHEME_OPT) == 1) goto L13;
        if (r105 == false) goto L22;
    L13:
        if (RomUtils.isSamsung() == false) goto L22;
        if (BaseConstants.MARKET_SCHEME_SAMSUNG.equals(r101) == false) goto L22;
        if (r102 == null) goto L22;
        if (r102.size() != 1) goto L22;
        return (String) ListProtector.get(r102, 0);
    L22:
        return ToolUtils.getNotEmptyStr(new String[]{UriProtector.getQueryParameter(r100, "id"), UriProtector.getQueryParameter(r100, "packagename"), UriProtector.getQueryParameter(r100, "pkg"), UriProtector.getQueryParameter(r100, "package_name"), UriProtector.getQueryParameter(r100, "appId")});
    L5:
        if (r104.getFixSamsungMarketPackage() != 1) goto L7;
        r105 = true;
        goto L8
    }

    public static boolean isMarketUri(Uri r100) {
        if (r100 != null) goto L5;
        return false;
    L5:
        IAdSDKSettingsProvider r101 = (IAdSDKSettingsProvider) DownloadAdRuntimeProvider.getInnerService(IAdSDKSettingsProvider.class);
        String r102 = r100.getScheme();
        if (TextUtils.isEmpty(r102) == false) goto L9;
        return false;
    L9:
        if (r101 == null) goto L15;
        if (r101.getTTDownloaderAdSettings().optInt("market_url_opt", 1) != 0) goto L15;
        return "market".equals(r102);
    L15:
        if ("market".equalsIgnoreCase(r102) == false) goto L17;
    L36:
        return true;
    L17:
        if (BaseConstants.MARKET_SCHEME_HUAWEI.equalsIgnoreCase(r102) == true) goto L36;
        if (BaseConstants.MARKET_SCHEME_OPPO.equalsIgnoreCase(r102) == true) goto L36;
        if (BaseConstants.MARKET_SCHEME_OPPO_1.equalsIgnoreCase(r102) == true) goto L36;
        if (BaseConstants.MARKET_SCHEME_XIAOMI.equalsIgnoreCase(r102) == true) goto L36;
        if (BaseConstants.MARKET_SCHEME_VIVO.equalsIgnoreCase(r102) == true) goto L36;
        if (BaseConstants.MARKET_SCHEME_VIVO_1.equalsIgnoreCase(r102) == true) goto L36;
        if (BaseConstants.MARKET_SCHEME_MEIZU.equalsIgnoreCase(r102) == true) goto L36;
        if (BaseConstants.MARKET_SCHEME_SAMSUNG.equalsIgnoreCase(r102) == true) goto L36;
        if (BaseConstants.MARKET_SCHEME_HONOR.equalsIgnoreCase(r102) == true) goto L36;
        return false;
    }
}
