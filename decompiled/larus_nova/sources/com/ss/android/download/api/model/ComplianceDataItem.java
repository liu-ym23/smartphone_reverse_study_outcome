package com.ss.android.download.api.model;

import android.text.TextUtils;
import com.ss.android.downloadlib.addownload.GlobalInfo;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes34.dex */
public class ComplianceDataItem {
    private String KEY_APPSTORE_PERMIT;
    private String KEY_BIZ_TYPE;
    private String KEY_DOWNLOAD_UNIFORM;
    private String KEY_MARKET_ONLINE_STATUS;
    private String KEY_PACKAGE_NAME;
    private int mAppStorePermit;
    private String mBizType;
    private String mComplianceDataString;
    private int mDownloadUniform;
    private int mMarketOnlineStatus;
    private String mPackageName;
    private JSONObject mTypeJson;

    public int getAppStorePermit() {
        return this.mAppStorePermit;
    }

    public String getBizType() {
        return this.mBizType;
    }

    public String getComplianceDataString() {
        return this.mComplianceDataString;
    }

    public int getDownloadUniform() {
        return this.mDownloadUniform;
    }

    public int getMarketOnlineStatus() {
        return this.mMarketOnlineStatus;
    }

    public String getPackageName() {
        return this.mPackageName;
    }

    public JSONObject getTypeJson() {
        return this.mTypeJson;
    }

    public ComplianceDataItem(String r100) {
        this.mTypeJson = new JSONObject();
        this.mAppStorePermit = 0;
        this.mMarketOnlineStatus = 15;
        this.KEY_BIZ_TYPE = "biz_type";
        this.KEY_APPSTORE_PERMIT = "appstore_permit";
        this.KEY_DOWNLOAD_UNIFORM = "download_uniform";
        this.KEY_PACKAGE_NAME = "package_name";
        this.KEY_MARKET_ONLINE_STATUS = "market_online_status";
        this.mComplianceDataString = r100;
        parseComplianceData(r100);
    }

    public static ComplianceDataItem getComplianceDataItem(String r100) {
        return new ComplianceDataItem(r100);
    }

    public void parseComplianceData(String r100) {
        if (TextUtils.isEmpty(r100) == false) goto L15;
        return;
    L15:
        JSONObject r101 = new JSONObject(r100);     // Catch: JSONException -> L12
        String r102 = r101.optString(this.KEY_BIZ_TYPE);     // Catch: JSONException -> L12
        this.mBizType = r102;     // Catch: JSONException -> L12
        if (TextUtils.isEmpty(r102) == false) goto L9;
        return;
    L9:
        if (r101.optJSONObject(this.mBizType) == null) goto L18;
        JSONObject r103 = r101.optJSONObject(this.mBizType);     // Catch: JSONException -> L12
        this.mTypeJson = r103;     // Catch: JSONException -> L12
        this.mAppStorePermit = r103.optInt(this.KEY_APPSTORE_PERMIT, 0);     // Catch: JSONException -> L12
        this.mDownloadUniform = this.mTypeJson.optInt(this.KEY_DOWNLOAD_UNIFORM, 0);     // Catch: JSONException -> L12
        this.mPackageName = this.mTypeJson.optString(this.KEY_PACKAGE_NAME);     // Catch: JSONException -> L12
        this.mMarketOnlineStatus = this.mTypeJson.optInt(this.KEY_MARKET_ONLINE_STATUS, 15);     // Catch: JSONException -> L12
        return;
    L18:
        return;
    L12:
        e = move-exception;
        GlobalInfo.getTTMonitor().monitorException(false, false, e, "parseComplianceData");
    }

    public void setAppStorePermit(int r100) {
        this.mAppStorePermit = r100;
    }

    public void setMarketOnlineStatus(int r100) {
        this.mMarketOnlineStatus = r100;
    }
}
