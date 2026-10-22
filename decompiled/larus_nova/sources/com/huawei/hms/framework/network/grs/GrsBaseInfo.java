package com.huawei.hms.framework.network.grs;

import android.content.Context;
import android.text.TextUtils;
import com.byted.cast.linkcommon.cybergarage.xml.XML;
import com.huawei.hms.framework.common.ContainerUtils;
import com.huawei.hms.framework.common.Logger;
import java.net.URLEncoder;
import java.util.Locale;

/* JADX INFO: loaded from: classes23.dex */
public class GrsBaseInfo implements Cloneable {
    private static final String TAG = null;
    private String androidVersion;
    private String appName;
    private String countrySource;
    private String deviceModel;
    private String issueCountry;
    private int queryTimeout;
    private String regCountry;
    private String romVersion;
    private String serCountry;
    private String uid;
    private String versionName;

    public @interface CountryCodeSource {
        public static final String APP = "APP";
        public static final String LOCALE_INFO = "LOCALE_INFO";
        public static final String NETWORK_COUNTRY = "NETWORK_COUNTRY";
        public static final String SIM_COUNTRY = "SIM_COUNTRY";
        public static final String UNKNOWN = "UNKNOWN";
        public static final String VENDOR_COUNTRY = "VENDOR_COUNTRY";
    }

    static {
        TAG = "GrsBaseInfo";
    }

    public GrsBaseInfo() {
        this.queryTimeout = -1;
    }

    public GrsBaseInfo(Context r100) {
        this.queryTimeout = -1;
        this.issueCountry = GrsApp.getInstance().getIssueCountryCode(r100);
    }

    private static String getObjSummary(GrsBaseInfo r100) {
        if (r100 != null) goto L6;
        return "";
    L6:
        return "serCountry:" + r100.serCountry + "versionName:" + r100.versionName + "appName:" + r100.appName + "uid:" + r100.uid + "regCountry:" + r100.regCountry + "issueCountry:" + r100.issueCountry + "androidVersion:" + r100.androidVersion + "romVersion:" + r100.romVersion + "deviceModel:" + r100.deviceModel + "countrySource:" + r100.countrySource;
    }

    private StringBuffer getStringBuffer(StringBuffer r100, boolean r101, Context r102) {
        String r103 = getAndroidVersion();
        if (TextUtils.isEmpty(r103) == false) goto L5;
    L8:
        String r104 = getRomVersion();
        if (TextUtils.isEmpty(r104) == false) goto L11;
    L14:
        String r105 = getDeviceModel();
        if (TextUtils.isEmpty(r105) == false) goto L17;
    L20:
        String r106 = getCountrySource();
        if (TextUtils.isEmpty(r106) == true) goto L27;
        if (TextUtils.isEmpty(r100.toString()) == true) goto L25;
        r100.append("&");
    L25:
        r100.append("country_source");
        r100.append(ContainerUtils.KEY_VALUE_DELIMITER);
        r100.append(getUrlEncodedStr(r106));
    L27:
        if (TextUtils.isEmpty(r100.toString()) == true) goto L29;
        r100.append("&");
    L29:
        r100.append("package_name");
        r100.append(ContainerUtils.KEY_VALUE_DELIMITER);
        r100.append(getUrlEncodedStr(r102.getPackageName()));
        return r100;
    L17:
        if (TextUtils.isEmpty(r100.toString()) == true) goto L19;
        r100.append("&");
    L19:
        r100.append("device_model");
        r100.append(ContainerUtils.KEY_VALUE_DELIMITER);
        r100.append(getUrlEncodedStr(r105));
        goto L20
    L11:
        if (TextUtils.isEmpty(r100.toString()) == true) goto L13;
        r100.append("&");
    L13:
        r100.append("rom_version");
        r100.append(ContainerUtils.KEY_VALUE_DELIMITER);
        r100.append(getUrlEncodedStr(r104));
        goto L14
    L5:
        if (TextUtils.isEmpty(r100.toString()) == true) goto L7;
        r100.append("&");
    L7:
        r100.append("android_version");
        r100.append(ContainerUtils.KEY_VALUE_DELIMITER);
        r100.append(getUrlEncodedStr(r103));
        goto L8
    }

    public GrsBaseInfo clone() {
        return (GrsBaseInfo) super.clone();
    }

    /* JADX INFO: renamed from: clone, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m8535clone() {
        return clone();
    }

    public boolean compare(Object r100) {
        if (this != r100) goto L5;
        return true;
    L5:
        if (r100 != null) goto L7;
        return false;
    L7:
        if (GrsBaseInfo.class == r100.getClass()) goto L10;
        return false;
    L10:
        return getObjSummary(this).equals(getObjSummary((GrsBaseInfo) r100));
    }

    public GrsBaseInfo copy() {
        GrsBaseInfo r100 = new GrsBaseInfo();
        r100.setAppName(this.appName);
        r100.setSerCountry(this.serCountry);
        r100.setRegCountry(this.regCountry);
        r100.setIssueCountry(this.issueCountry);
        r100.setCountrySource(this.countrySource);
        r100.setAndroidVersion(this.androidVersion);
        r100.setDeviceModel(this.deviceModel);
        r100.setRomVersion(this.romVersion);
        r100.setUid(this.uid);
        r100.setVersionName(this.versionName);
        r100.setQueryTimeout(this.queryTimeout);
        return r100;
    }

    public String getAndroidVersion() {
        return this.androidVersion;
    }

    public String getAppName() {
        return this.appName;
    }

    public String getCountrySource() {
        return this.countrySource;
    }

    public String getDeviceModel() {
        return this.deviceModel;
    }

    public String getGrsParasKey(boolean r100, boolean r101, Context r102) {
        StringBuffer r103 = new StringBuffer();
        com.huawei.hms.framework.network.grs.f.b r104 = com.huawei.hms.framework.network.grs.f.b.a(r102.getPackageName());
        if (r104 == null) goto L5;
        com.huawei.hms.framework.network.grs.local.model.a r105 = r104.a();
    L6:
        if (r105 == null) goto L8;
        String r106 = r105.a();
    L9:
        String r107 = getGrsReqParamJoint(r100, r101, r106, r102);
        if (TextUtils.isEmpty(r107) == true) goto L16;
        if (TextUtils.isEmpty(r103.toString()) == true) goto L14;
        r103.append("&");
    L14:
        r103.append(r107);
    L16:
        return r103.toString();
    L8:
        r106 = "";
        goto L9
    L5:
        r105 = null;
        goto L6
    }

    public String getGrsReqParamJoint(boolean r100, boolean r101, String r102, Context r103) {
        StringBuffer r104 = new StringBuffer();
        if ("1.0".equals(r102) == false) goto L6;
        Logger.v(TAG, "1.0 interface has no query param appname");
    L12:
        String r105 = getVersionName();
        if (TextUtils.isEmpty(r105) == false) goto L15;
    L18:
        String r106 = getUid();
        if (TextUtils.isEmpty(r106) == false) goto L21;
    L30:
        String r107 = getRegCountry();
        if (TextUtils.isEmpty(r107) == false) goto L33;
    L38:
        String r108 = getSerCountry();
        if (TextUtils.isEmpty(r108) == false) goto L41;
    L46:
        String r109 = getIssueCountry();
        if (TextUtils.isEmpty(r109) == true) goto L55;
        if ("UNKNOWN".equals(r109) == true) goto L55;
        if (TextUtils.isEmpty(r104.toString()) == true) goto L53;
        r104.append("&");
    L53:
        r104.append("issue_country=");
        r104.append(getUrlEncodedStr(r109));
    L55:
        return getStringBuffer(r104, r101, r103).toString();
    L41:
        if ("UNKNOWN".equals(r108) == true) goto L46;
        if (TextUtils.isEmpty(r104.toString()) == true) goto L45;
        r104.append("&");
    L45:
        r104.append("ser_country=");
        r104.append(getUrlEncodedStr(r108));
        goto L46
    L33:
        if ("UNKNOWN".equals(r107) == true) goto L38;
        if (TextUtils.isEmpty(r104.toString()) == true) goto L37;
        r104.append("&");
    L37:
        r104.append("reg_country=");
        r104.append(getUrlEncodedStr(r107));
        goto L38
    L21:
        if (TextUtils.isEmpty(r104.toString()) == true) goto L23;
        r104.append("&");
    L23:
        r104.append("uid=");
        if (r100 == false) goto L27;
        String r110 = com.huawei.hms.framework.network.grs.h.b.b(r106);
    L26:
        r104.append(r110);
        goto L30
    L27:
        if (r101 == false) goto L29;
        r110 = com.huawei.hms.framework.network.grs.h.b.a(r106);
        goto L26
    L29:
        r104.append(r106);
        goto L30
    L15:
        if (TextUtils.isEmpty(r104.toString()) == true) goto L17;
        r104.append("&");
    L17:
        r104.append("app_version=");
        r104.append(getUrlEncodedStr(r105));
        goto L18
    L6:
        if (TextUtils.isEmpty(r102) == true) goto L10;
        r104.append("app_name=");
    L8:
        r104.append(getUrlEncodedStr(r102));
        goto L12
    L10:
        if (TextUtils.isEmpty(getAppName()) == true) goto L12;
        r104.append("app_name=");
        r102 = getAppName();
        goto L8
    }

    public String getIssueCountry() {
        return this.issueCountry;
    }

    public int getQueryTimeout() {
        return this.queryTimeout;
    }

    public String getRegCountry() {
        return this.regCountry;
    }

    public String getRomVersion() {
        return this.romVersion;
    }

    public String getSerCountry() {
        return this.serCountry;
    }

    public String getUid() {
        return this.uid;
    }

    public String getUrlEncodedStr(String r100) {
        return URLEncoder.encode(r100, XML.CHARSET_UTF8);
    L4:
        Logger.e(TAG, "UnsupportedEncodingException, Please check the params!");
        return "";
    }

    public String getVersionName() {
        return this.versionName;
    }

    public void setAndroidVersion(String r100) {
        this.androidVersion = r100;
    }

    public void setAppName(String r100) {
        this.appName = r100;
    }

    public void setCountrySource(String r100) {
        this.countrySource = r100;
    }

    public void setDeviceModel(String r100) {
        this.deviceModel = r100;
    }

    public void setIssueCountry(String r100) {
        if (r100 == null) goto L4;
        String r101 = r100.toUpperCase(Locale.ENGLISH);
    L5:
        this.issueCountry = r101;
        return;
    L4:
        r101 = "";
        goto L5
    }

    public void setQueryTimeout(int r100) {
        this.queryTimeout = r100;
    }

    public void setRegCountry(String r100) {
        if (r100 == null) goto L4;
        String r101 = r100.toUpperCase(Locale.ENGLISH);
    L5:
        this.regCountry = r101;
        return;
    L4:
        r101 = "";
        goto L5
    }

    public void setRomVersion(String r100) {
        this.romVersion = r100;
    }

    public void setSerCountry(String r100) {
        if (r100 == null) goto L4;
        String r101 = r100.toUpperCase(Locale.ENGLISH);
    L5:
        this.serCountry = r101;
        return;
    L4:
        r101 = "";
        goto L5
    }

    public void setUid(String r100) {
        this.uid = r100;
    }

    public void setVersionName(String r100) {
        this.versionName = r100;
    }

    public int uniqueCode() {
        return (this.appName + "#" + this.serCountry + "#" + this.regCountry + "#" + this.issueCountry).hashCode();
    }
}
