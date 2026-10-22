package com.ss.ttvideoengine.model;

import android.text.TextUtils;
import com.bytedance.mt.protector.impl.JSONObjectProtectorUtils;
import com.ss.ttvideoengine.utils.TTVideoEngineLog;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes34.dex */
public class VideoThumbInfo {
    public static final String KEY_DURATION = "duration";
    public static final String KEY_FEXT = "fext";
    public static final String KEY_IMG_NUM = "img_num";
    public static final String KEY_IMG_URI = "img_uri";
    public static final String KEY_IMG_URL = "img_url";
    public static final String KEY_IMG_URLS = "img_urls";
    public static final String KEY_IMG_X_LEN = "img_x_len";
    public static final String KEY_IMG_X_SIZE = "img_x_size";
    public static final String KEY_IMG_Y_LEN = "img_y_len";
    public static final String KEY_IMG_Y_SIZE = "img_y_size";
    public static final String KEY_INTERVAL = "interval";
    public static final String KEY_URI = "uri";
    private static final String KEY_VER2_DURATION = "Duration";
    private static final String KEY_VER2_FEXT = "Fext";
    private static final String KEY_VER2_IMG_NUM = "ImgNum";
    private static final String KEY_VER2_IMG_URL = "ImgUrl";
    private static final String KEY_VER2_IMG_X_LEN = "ImgXLen";
    private static final String KEY_VER2_IMG_X_SIZE = "ImgXSize";
    private static final String KEY_VER2_IMG_Y_LEN = "ImgYLen";
    private static final String KEY_VER2_IMG_Y_SIZE = "ImgYSize";
    private static final String KEY_VER2_INTERVAL = "Interval";
    private static final String KEY_VER2_URI = "Uri";
    private static final String KEY_VER4_CAPTURE_NUM = "CaptureNum";
    private static final String KEY_VER4_CELL_HEIGHT = "CellHeight";
    private static final String KEY_VER4_CELL_WIDTH = "CellWidth";
    private static final String KEY_VER4_FORMAT = "Format";
    private static final String KEY_VER4_IMG_X_LEN = "ImgXLen";
    private static final String KEY_VER4_IMG_Y_LEN = "ImgYLen";
    private static final String KEY_VER4_INTERVAL = "Interval";
    private static final String KEY_VER4_STORE_URLS = "StoreUrls";
    public static final int VALUE_VIDEO_THUMB_INFO_CAPTURE_NUM = 0;
    public static final int VALUE_VIDEO_THUMB_INFO_CELL_HEIGHT = 4;
    public static final int VALUE_VIDEO_THUMB_INFO_CELL_WIDTH = 3;
    public static final int VALUE_VIDEO_THUMB_INFO_DURATION = 7;
    public static final int VALUE_VIDEO_THUMB_INFO_FEXT = 9;
    public static final int VALUE_VIDEO_THUMB_INFO_FORMAT = 9;
    public static final int VALUE_VIDEO_THUMB_INFO_IMG_NUM = 0;
    public static final int VALUE_VIDEO_THUMB_INFO_IMG_URL = 2;
    public static final int VALUE_VIDEO_THUMB_INFO_IMG_X_LEN = 5;
    public static final int VALUE_VIDEO_THUMB_INFO_IMG_X_SIZE = 3;
    public static final int VALUE_VIDEO_THUMB_INFO_IMG_Y_LEN = 6;
    public static final int VALUE_VIDEO_THUMB_INFO_IMG_Y_SIZE = 4;
    public static final int VALUE_VIDEO_THUMB_INFO_INTERVAL = 8;
    public static final int VALUE_VIDEO_THUMB_INFO_URI = 1;
    private int mCaptureNumVer4;
    private int mCellHeightVer4;
    private int mCellWidthVer4;
    public double mDuration;
    private double mDurationVer2;
    public String mFext;
    private String mFextVer2;
    private String mFormatVer4;
    public int mImgNum;
    private int mImgNumVer2;
    public String mImgUrl;
    public ArrayList<String> mImgUrlList;
    private String mImgUrlVer2;
    private int mImgXLenVer4;
    public int mImgXlen;
    private int mImgXlenVer2;
    public int mImgXsize;
    private int mImgXsizeVer2;
    private int mImgYLenVer4;
    public int mImgYlen;
    private int mImgYlenVer2;
    public int mImgYsize;
    private int mImgYsizeVer2;
    public double mInterval;
    private double mIntervalVer2;
    private double mIntervalVer4;
    private ArrayList<String> mStoreUrlsVer4;
    public String mUri;
    private String mUriVer2;
    private int mVersion;

    public void parseFromPb(VideoModelPb.BigThumb r100) {
    }

    public List<String> getUrls() {
        if (this.mVersion == 4) goto L5;
        return null;
    L5:
        if (this.mStoreUrlsVer4 != null) goto L7;
        return null;
    L7:
        return new ArrayList(this.mStoreUrlsVer4);
    }

    public VideoThumbInfo() {
        this.mVersion = 1;
    }

    public void extractFields(JSONObject r100) {
        if (r100 != null) goto L5;
        return;
    L5:
        if (r100.has(KEY_IMG_NUM) == false) goto L10;
        if (this.mVersion == 3) goto L12;
        this.mVersion = 1;
    L12:
        int r101 = this.mVersion;
        int r102 = 0;
        if (r101 == 1) goto L48;
        if (r101 == 3) goto L48;
        if (r101 != 2) goto L23;
        this.mImgNumVer2 = JSONObjectProtectorUtils.getInt(r100, KEY_VER2_IMG_NUM);     // Catch: JSONException -> L20
        this.mUriVer2 = r100.optString(KEY_VER2_URI);     // Catch: JSONException -> L20
        this.mImgUrlVer2 = r100.optString(KEY_VER2_IMG_URL);     // Catch: JSONException -> L20
        this.mImgXsizeVer2 = r100.optInt(KEY_VER2_IMG_X_SIZE);     // Catch: JSONException -> L20
        this.mImgYsizeVer2 = r100.optInt(KEY_VER2_IMG_Y_SIZE);     // Catch: JSONException -> L20
        this.mImgXlenVer2 = r100.optInt("ImgXLen");     // Catch: JSONException -> L20
        this.mImgYlenVer2 = r100.optInt("ImgYLen");     // Catch: JSONException -> L20
        this.mDurationVer2 = r100.optDouble(KEY_VER2_DURATION);     // Catch: JSONException -> L20
        this.mIntervalVer2 = r100.optDouble("Interval");     // Catch: JSONException -> L20
        this.mFextVer2 = r100.optString(KEY_VER2_FEXT);     // Catch: JSONException -> L20
        return;
    L20:
        e = move-exception;
        TTVideoEngineLog.d(e);
        return;
    L23:
        if (r101 != 4) goto L55;
        this.mCaptureNumVer4 = r100.optInt(KEY_VER4_CAPTURE_NUM);
        JSONArray r103 = r100.optJSONArray(KEY_VER4_STORE_URLS);
        if (r103 != null) goto L27;
    L32:
        this.mCellWidthVer4 = r100.optInt(KEY_VER4_CELL_WIDTH);
        this.mCellHeightVer4 = r100.optInt(KEY_VER4_CELL_HEIGHT);
        this.mImgXLenVer4 = r100.optInt("ImgXLen");
        this.mImgYLenVer4 = r100.optInt("ImgYLen");
        this.mIntervalVer4 = r100.optDouble("Interval");
        this.mFormatVer4 = r100.optString(KEY_VER4_FORMAT);
        return;
    L27:
        if (r103.length() <= 0) goto L32;
        this.mStoreUrlsVer4 = new ArrayList();
    L30:
        if (r102 >= r103.length()) goto L32;
        this.mStoreUrlsVer4.add(r103.optString(r102));
        r102 = r102 + 1;
        goto L30
    L55:
        return;
    L48:
        this.mImgNum = JSONObjectProtectorUtils.getInt(r100, KEY_IMG_NUM);     // Catch: JSONException -> L45
        String r104 = r100.optString("uri");     // Catch: JSONException -> L45
        this.mUri = r104;     // Catch: JSONException -> L45
        if (TextUtils.isEmpty(r104) == false) goto L36;
        this.mUri = r100.optString(KEY_IMG_URI);     // Catch: JSONException -> L45
    L36:
        this.mImgUrl = r100.optString(KEY_IMG_URL);     // Catch: JSONException -> L45
        this.mImgXsize = r100.optInt(KEY_IMG_X_SIZE);     // Catch: JSONException -> L45
        this.mImgYsize = r100.optInt(KEY_IMG_Y_SIZE);     // Catch: JSONException -> L45
        this.mImgXlen = r100.optInt(KEY_IMG_X_LEN);     // Catch: JSONException -> L45
        this.mImgYlen = r100.optInt(KEY_IMG_Y_LEN);     // Catch: JSONException -> L45
        this.mDuration = r100.optDouble("duration");     // Catch: JSONException -> L45
        this.mInterval = r100.optDouble(KEY_INTERVAL);     // Catch: JSONException -> L45
        this.mFext = r100.optString(KEY_FEXT);     // Catch: JSONException -> L45
        JSONArray r105 = r100.optJSONArray(KEY_IMG_URLS);     // Catch: JSONException -> L45
        if (r105 != null) goto L39;
        return;
    L39:
        if (r105.length() <= 0) goto L58;
        this.mImgUrlList = new ArrayList();     // Catch: JSONException -> L45
    L41:
        if (r102 >= r105.length()) goto L60;
        this.mImgUrlList.add(r105.optString(r102));     // Catch: JSONException -> L45
        r102 = r102 + 1;
        goto L41
    L60:
        return;
    L58:
        return;
    L45:
        e = move-exception;
        TTVideoEngineLog.d(e);
        return;
    L10:
        if (r100.has(KEY_VER2_IMG_URL) == false) goto L12;
        this.mVersion = 2;
        goto L12
    }

    public double getValueDouble(int r100) {
        int r101 = this.mVersion;
        if (r101 != 2) goto L12;
        if (r100 == 7) goto L10;
        if (r100 == 8) goto L8;
        return -1.0d;
    L8:
        return this.mIntervalVer2;
    L10:
        return this.mDurationVer2;
    L12:
        if (r101 != 4) goto L17;
        if (r100 == 8) goto L16;
        return -1.0d;
    L16:
        return this.mIntervalVer4;
    L17:
        if (r100 == 7) goto L23;
        if (r100 == 8) goto L21;
        return -1.0d;
    L21:
        return this.mInterval;
    L23:
        return this.mDuration;
    }

    public int getValueInt(int r100) {
        int r101 = this.mVersion;
        if (r101 != 2) goto L20;
        if (r100 == 0) goto L19;
        if (r100 == 3) goto L17;
        if (r100 == 4) goto L15;
        if (r100 == 5) goto L13;
        if (r100 == 6) goto L11;
        return -1;
    L11:
        return this.mImgYlenVer2;
    L13:
        return this.mImgXlenVer2;
    L15:
        return this.mImgYsizeVer2;
    L17:
        return this.mImgXsizeVer2;
    L19:
        return this.mImgNumVer2;
    L20:
        if (r101 != 4) goto L37;
        if (r100 == 0) goto L36;
        if (r100 == 3) goto L34;
        if (r100 == 4) goto L32;
        if (r100 == 5) goto L30;
        if (r100 == 6) goto L28;
        return -1;
    L28:
        return this.mImgYLenVer4;
    L30:
        return this.mImgXLenVer4;
    L32:
        return this.mCellHeightVer4;
    L34:
        return this.mCellWidthVer4;
    L36:
        return this.mCaptureNumVer4;
    L37:
        if (r100 == 0) goto L52;
        if (r100 == 3) goto L50;
        if (r100 == 4) goto L48;
        if (r100 == 5) goto L46;
        if (r100 == 6) goto L44;
        return -1;
    L44:
        return this.mImgYlen;
    L46:
        return this.mImgXlen;
    L48:
        return this.mImgYsize;
    L50:
        return this.mImgXsize;
    L52:
        return this.mImgNum;
    }

    public String getValueStr(int r100) {
        int r101 = this.mVersion;
        if (r101 != 2) goto L15;
        if (r100 == 1) goto L13;
        if (r100 == 2) goto L11;
        if (r100 == 9) goto L9;
        return "";
    L9:
        return this.mFextVer2;
    L11:
        return this.mImgUrlVer2;
    L13:
        return this.mUriVer2;
    L15:
        if (r101 != 4) goto L20;
        if (r100 == 9) goto L19;
        return "";
    L19:
        return this.mFormatVer4;
    L20:
        if (r100 == 1) goto L29;
        if (r100 == 2) goto L27;
        if (r100 == 9) goto L25;
        return "";
    L25:
        return this.mFext;
    L27:
        return this.mImgUrl;
    L29:
        return this.mUri;
    }

    public void setVersion(int r100) {
        this.mVersion = r100;
    }
}
