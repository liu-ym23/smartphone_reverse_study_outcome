package com.huawei.hms.framework.network.grs.local.model;

import android.content.Context;
import android.os.Build;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.huawei.hms.framework.common.EmuiUtil;
import com.huawei.hms.framework.common.Logger;
import com.huawei.hms.framework.common.SystemPropUtils;
import com.huawei.hms.framework.network.grs.GrsBaseInfo;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import java.util.Locale;

/* JADX INFO: loaded from: classes23.dex */
public class CountryCodeBean {
    private static final String ANDRIOD_SYSTEMPROP = "android.os.SystemProperties";
    private static final int ANDROID_9_API_LEVEL = 28;
    private static final int COUNTRYCODE_SIZE = 2;
    private static final String KEY_VERSION_EMUI = "ro.build.version.emui";
    private static final String LOCALE_COUNTRYSYSTEMPROP = "ro.product.locale";
    private static final String LOCALE_REGION_COUNTRYSYSTEMPROP = "ro.product.locale.region";
    private static final String SPECIAL_COUNTRYCODE_CN = "cn";
    private static final String SPECIAL_COUNTRYCODE_EU = "eu";
    private static final String SPECIAL_COUNTRYCODE_GB = "gb";
    private static final String SPECIAL_COUNTRYCODE_LA = "la";
    private static final String SPECIAL_COUNTRYCODE_UK = "uk";
    private static final String TAG = "CountryCodeBean";
    private static final String VENDORCOUNTRY_SYSTEMPROP = "ro.hw.country";
    private String countryCode;
    private String countrySource;

    public CountryCodeBean(Context r100, boolean r101) {
        this.countrySource = "UNKNOWN";
        this.countryCode = "UNKNOWN";
        init(r100, r101);
        this.countryCode = this.countryCode.toUpperCase(Locale.ENGLISH);
    }

    private void checkCodeLenth() {
        String r100 = this.countryCode;
        if (r100 != null) goto L5;
    L6:
        this.countryCode = "UNKNOWN";
        this.countrySource = "UNKNOWN";
        return;
    L5:
        if (r100.length() != 2) goto L6;
    }

    private void getLocaleCountryCode() {
        if (SystemPropUtils.getProperty(MonitorConstants.CONNECT_TYPE_GET, "ro.build.version.emui", ANDRIOD_SYSTEMPROP, "").isEmpty() == true) goto L9;
        if (EmuiUtil.isUpPVersion() == false) goto L7;
        getRegionSettingCountryCode();
        String r100 = TAG;
        String r101 = "EMUI 9.0 upper System, get countryCode form Locale.getDefault().getCountry()";
    L15:
        Logger.d(r100, r101);
        this.countrySource = GrsBaseInfo.CountryCodeSource.LOCALE_INFO;
        return;
    L7:
        getProductCountryCode();
        r100 = TAG;
        r101 = "EMUI 9.0 lower System, get countryCode form ro.product.locale.region or locale";
        goto L15
    L9:
        if (Build.VERSION.SDK_INT < 28) goto L11;
    L14:
        getRegionSettingCountryCode();
        r100 = TAG;
        r101 = "other Android 9.0 upper， get countryCode form Locale.getDefault().getCountry()";
        goto L15
    L11:
        if (Build.VERSION.RELEASE.charAt(0) >= '9') goto L14;
        getProductCountryCode();
        r100 = TAG;
        r101 = "other Android 9.0 lower, get countryCode form ro.product.locale.region or locale";
        goto L15
    }

    private void getProductCountryCode() {
        this.countryCode = SystemPropUtils.getProperty(MonitorConstants.CONNECT_TYPE_GET, LOCALE_REGION_COUNTRYSYSTEMPROP, ANDRIOD_SYSTEMPROP, "UNKNOWN");
        String r100 = TAG;
        Logger.d(r100, "countryCode by ro.product.locale.region is: " + this.countryCode);
        if (TextUtils.isEmpty(this.countryCode) == false) goto L5;
    L6:
        String r101 = SystemPropUtils.getProperty(MonitorConstants.CONNECT_TYPE_GET, LOCALE_COUNTRYSYSTEMPROP, ANDRIOD_SYSTEMPROP, "UNKNOWN");
        if (TextUtils.isEmpty(r101) == true) goto L12;
        int r102 = r101.lastIndexOf("-");
        if (r102 == (-1)) goto L12;
        this.countryCode = r101.substring(r102 + 1);
        Logger.d(r100, "countryCode by ro.product.locale is: " + this.countryCode);
    L12:
        if ("cn".equalsIgnoreCase(this.countryCode) == true) goto L15;
        this.countryCode = "UNKNOWN";
        return;
    L15:
        return;
    L5:
        if ("UNKNOWN".equals(this.countryCode) == false) goto L12;
        goto L6
    }

    private void getRegionSettingCountryCode() {
        this.countryCode = Locale.getDefault().getCountry();
        Logger.d(TAG, "countryCode by system's region setting is: " + this.countryCode);
        if (TextUtils.isEmpty(this.countryCode) == false) goto L6;
        this.countryCode = "UNKNOWN";
        return;
    }

    private void getSimCountryCode(Context r100) {
        getSimCountryCode(r100, false);
    }

    private void getSimCountryCode(Context r100, boolean r101) {
        TelephonyManager r102 = (TelephonyManager) r100.getApplicationContext().getSystemService("phone");
        if (r102 == null) goto L10;
        if (r101 == true) goto L6;
    L8:
        this.countryCode = r102.getSimCountryIso();
        this.countrySource = GrsBaseInfo.CountryCodeSource.SIM_COUNTRY;
        String r103 = TAG;
        StringBuilder r104 = new StringBuilder("countryCode by SimCountryIso is: ");
    L9:
        r104.append(this.countryCode);
        Logger.d(r103, r104.toString());
        goto L10
    L6:
        if (r102.getPhoneType() == 2) goto L8;
        this.countryCode = r102.getNetworkCountryIso();
        this.countrySource = GrsBaseInfo.CountryCodeSource.NETWORK_COUNTRY;
        r103 = TAG;
        r104 = new StringBuilder("countryCode by NetworkCountryIso is: ");
    L10:
        checkCodeLenth();
    }

    private void getVendorCountryCode() {
        this.countrySource = GrsBaseInfo.CountryCodeSource.VENDOR_COUNTRY;
        this.countryCode = SystemPropUtils.getProperty(MonitorConstants.CONNECT_TYPE_GET, VENDORCOUNTRY_SYSTEMPROP, ANDRIOD_SYSTEMPROP, "UNKNOWN");
        String r100 = TAG;
        Logger.d(r100, "countryCode by ro.hw.country is: " + this.countryCode);
        if (SPECIAL_COUNTRYCODE_EU.equalsIgnoreCase(this.countryCode) == false) goto L5;
    L11:
        this.countryCode = "UNKNOWN";
        this.countrySource = "UNKNOWN";
        return;
    L5:
        if (SPECIAL_COUNTRYCODE_LA.equalsIgnoreCase(this.countryCode) == true) goto L11;
        if (SPECIAL_COUNTRYCODE_UK.equalsIgnoreCase(this.countryCode) == false) goto L10;
        Logger.d(r100, "special country of UK to map GB.");
        this.countryCode = SPECIAL_COUNTRYCODE_GB;
        this.countrySource = GrsBaseInfo.CountryCodeSource.VENDOR_COUNTRY;
        return;
    L10:
        checkCodeLenth();
    }

    private void init(Context r100, boolean r101) {
        if (r100 == null) goto L18;
        getVendorCountryCode();     // Catch: Exception -> L15
        if (isCodeValidate() == false) goto L7;
        Logger.i(TAG, "get issue_country code from VENDOR_COUNTRY");     // Catch: Exception -> L15
        return;
    L7:
        getSimCountryCode(r100);     // Catch: Exception -> L15
        if (isCodeValidate() == false) goto L11;
        Logger.i(TAG, "get issue_country code from SIM_COUNTRY");     // Catch: Exception -> L15
        return;
    L11:
        getLocaleCountryCode();     // Catch: Exception -> L15
        if (isCodeValidate() == false) goto L20;
        Logger.i(TAG, "get issue_country code from LOCALE_INFO");     // Catch: Exception -> L15
        return;
    L20:
        return;
    L15:
        Logger.w(TAG, "get CountryCode error");
        return;
    L18:
        throw new NullPointerException("context must be not null.Please provide app's Context");
    }

    private boolean isCodeValidate() {
        return !"UNKNOWN".equals(this.countryCode);
    }

    public String getCountryCode() {
        return this.countryCode;
    }

    public String getCountrySource() {
        return this.countrySource;
    }
}
