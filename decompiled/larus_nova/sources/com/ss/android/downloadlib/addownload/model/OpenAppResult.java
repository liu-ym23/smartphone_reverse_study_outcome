package com.ss.android.downloadlib.addownload.model;

import android.content.Intent;
import android.net.Uri;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes34.dex */
public class OpenAppResult {
    private JSONObject extJson;
    private Intent jumpIntent;
    private Uri jumpOpenUrl;
    private String marketPackageName;
    private int message;
    private String source;
    private int type;

    public @interface Message {
        public static final int DEFAULT_MARKET_UNINSTALLED = 15;
        public static final int DO_QUICK_APP_OPEN_FAILED = 41;
        public static final int INVALID_HW_APP_ID = 28;
        public static final int LAUNCH_INTENT_NOT_EXIST = 22;
        public static final int MARKET_INTENT_ERROR = 16;
        public static final int MARKET_UNINSTALLED = 13;
        public static final int NETWORK_ERROR = 31;
        public static final int NETWORK_RESPONSE_CODE_NOT_SUCCESS = 33;
        public static final int NONE = 0;
        public static final int NOT_INSTALLED_WHEN_APPLINK = 20;
        public static final int NO_HW_APP_ID_FROM_SERVER = 27;
        public static final int NO_MIUI_MARKET_DEEPLINK = 29;
        public static final int NO_NECCESSARY_DATA_FROM_SETTINGS = 26;
        public static final int NO_NETWORK_FACTORY = 34;
        public static final int NO_QUICK_APP_OPEN_URL = 40;
        public static final int NO_RESPONSE_FROM_SERVER = 30;
        public static final int OPEN_APP_BACKGROUND = 37;
        public static final int OPEN_URL_INVALID = 24;
        public static final int OPEN_URL_NOT_EXIST = 21;
        public static final int OPT_SCENE_ERROR = 35;
        public static final int OTHER_ERROR = 36;
        public static final int PACKAGE_NAME_EMPTY = 11;
        public static final int START_ACTIVITY_EXCEPTION = 23;
        public static final int START_EXCEPTION = 14;
        public static final int TEST_FAILED = 25;
        public static final int THROW_EXCEPTION_ERROR = 32;
        public static final int URI_ERROR = 12;
    }

    public @interface Source {
        public static final String AM_HR = "am_hr";
        public static final String AM_HR2 = "am_hr2";
        public static final String AM_HR3 = "am_hr3";
        public static final String AM_HW = "am_hw";
        public static final String AM_KLLK1 = "am_kllk1";
        public static final String AM_KLLK2 = "am_kllk2";
        public static final String AM_KLLK3 = "am_kllk3";
        public static final String AM_M1 = "am_m1";
        public static final String AM_M2 = "am_m2";
        public static final String AM_MI = "am_mi";
        public static final String AM_MIUI_NEW = "am_miui_new";
        public static final String AM_MIUI_NEW_WEB = "am_miui_new_web";
        public static final String AM_V1 = "am_v1";
        public static final String AM_V2 = "am_v2";
    }

    public @interface Type {
        public static final int FAILED_BY_PACKAGE = 4;
        public static final int FAILED_BY_PACKAGE_MARKET_APPLINK_OPT = 8;
        public static final int FAILED_BY_URL = 2;
        public static final int FAILED_BY_URL_MARKET_APPLINK_OPT = 9;
        public static final int FAILED_MARKET = 6;
        public static final int FAILED_MARKET_AM_OPT = 11;
        public static final int FAILED_QUICK_APP = 13;
        public static final int IGNORE_MARKET = 7;
        public static final int NONE = 0;
        public static final int SUCCESS_BY_PACKAGE = 3;
        public static final int SUCCESS_BY_URL = 1;
        public static final int SUCCESS_MARKET = 5;
        public static final int SUCCESS_MARKET_AM_OPT = 10;
        public static final int SUCCESS_QUICK_APP = 12;
    }

    public OpenAppResult() {
    }

    public JSONObject getExtJson() {
        return this.extJson;
    }

    public Intent getJumpIntent() {
        return this.jumpIntent;
    }

    public Uri getJumpOpenUrl() {
        return this.jumpOpenUrl;
    }

    public String getMarketPackageName() {
        return this.marketPackageName;
    }

    public int getMessage() {
        return this.message;
    }

    public String getSource() {
        return this.source;
    }

    public int getType() {
        return this.type;
    }

    public OpenAppResult(int r100) {
        this(r100, 0, null);
    }

    public void setExtJson(JSONObject r100) {
        this.extJson = r100;
    }

    public void setJumpIntent(Intent r100) {
        this.jumpIntent = r100;
    }

    public void setJumpOpenUrl(Uri r100) {
        this.jumpOpenUrl = r100;
    }

    public void setMarketPackageName(String r100) {
        this.marketPackageName = r100;
    }

    public void setMessage(int r100) {
        this.message = r100;
    }

    public void setSource(String r100) {
        this.source = r100;
    }

    public void setType(int r100) {
        this.type = r100;
    }

    public OpenAppResult(int r100, Intent r101) {
        this.type = r100;
        this.jumpIntent = r101;
    }

    public OpenAppResult(int r100, int r101) {
        this(r100, r101, null);
    }

    public OpenAppResult(int r100, String r101) {
        this(r100, 0, r101);
    }

    public OpenAppResult(int r100, int r101, String r102) {
        this.type = r100;
        this.message = r101;
        this.source = r102;
    }
}
