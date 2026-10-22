package com.ss.ttvideoengine.fetcher;

import android.os.Build;
import android.text.TextUtils;
import com.ss.ttvideoengine.AppInfo;
import com.ss.ttvideoengine.BaseAppInfo;
import com.ss.ttvideoengine.InfoWrapper;
import com.ss.ttvideoengine.TTVideoEngineInterface;
import com.ss.ttvideoengine.net.ChannelSelect;
import com.ss.ttvideoengine.utils.TTHelper;
import com.ss.ttvideoengine.utils.TTVideoEngineLog;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes34.dex */
public class FetcherApiHelper {
    private static final String TAG = "FetcherApiHelper";
    private int mApiVersion;
    private String mAuthorization;
    private final String mCodecType;
    private final boolean mDashEnable;
    private final boolean mEncryptEnable;
    private final boolean mHlsEnable;
    private HashMap<String, String> mParams;

    private String getHost() {
        if (TextUtils.isEmpty(BaseAppInfo.mOpenApiHostName) == true) goto L7;
        return BaseAppInfo.mOpenApiHostName;
    L7:
        if (InfoWrapper.getUseHostSelect() == false) goto L16;
        if (this.mApiVersion != 2) goto L11;
        ChannelSelect.getInstance().setHostList(2, InfoWrapper.getTopHostArray());
    L12:
        String r100 = ChannelSelect.getInstance().selectNext(this.mApiVersion, null);
        if (TextUtils.isEmpty(r100) == true) goto L16;
        return r100;
    L11:
        ChannelSelect.getInstance().setHostList(4, InfoWrapper.getTopHostArrayV2());
    L16:
        if (this.mApiVersion != 2) goto L25;
        JSONArray r101 = InfoWrapper.getTopHostArray();
        if (TTHelper.isEmpty(r101) == true) goto L24;
        Object r102 = r101.opt(0);
        if ((r102 instanceof String) == false) goto L24;
        return (String) r102;
    L24:
        return AppInfo.getDefaultVodTopHost();
    L25:
        JSONArray r103 = InfoWrapper.getTopHostArrayV2();
        if (TTHelper.isEmpty(r103) == true) goto L32;
        Object r104 = r103.opt(0);
        if ((r104 instanceof String) == false) goto L32;
        return (String) r104;
    L32:
        return AppInfo.getDefaultVodTopHostV2();
    }

    public String getAPIString() {
        if (TextUtils.isEmpty(this.mAuthorization) == false) goto L6;
        TTVideoEngineLog.d(TAG, "getAPIString null");
        return null;
    L6:
        String r100 = addParam(addHostToUrl(), this.mAuthorization);
        TTVideoEngineLog.d(TAG, "getAPIString " + r100);
        return r100;
    }

    private String addHostToUrl() {
        String r100 = getHost();
        TTVideoEngineLog.d(TAG, "getHost " + r100);
        if (TextUtils.isEmpty(r100) == false) goto L7;
        return this.mAuthorization;
    L7:
        if (this.mAuthorization.startsWith("http") == false) goto L13;
        String r101 = TTHelper.replaceHostInURL(this.mAuthorization, r100);
        if (TextUtils.isEmpty(r101) == true) goto L12;
        return r101;
    L12:
        return this.mAuthorization;
    L13:
        StringBuilder r102 = new StringBuilder();
        if (r100.startsWith("http") == false) goto L17;
        r102.append(r100);
        r102.append("?");
        r102.append(this.mAuthorization);
        return r102.toString();
    L17:
        r102.append("https://");
        r102.append(r100);
        r102.append("?");
        r102.append(this.mAuthorization);
        return r102.toString();
    }

    public int getApiVersion() {
        return this.mApiVersion;
    }

    public String getAuthorization() {
        return this.mAuthorization;
    }

    private String getAuthorization(String r100) {
        TTVideoEngineLog.d(TAG, "getAuthorization " + r100);
        String r101 = TTHelper.base64Decode(r100);
        if (TextUtils.isEmpty(r101) == false) goto L6;
        TTVideoEngineLog.d(TAG, "getAuthorization result null");
        return null;
    L6:
        String r102 = "";
        JSONObject r103 = new JSONObject(r101);     // Catch: JSONException -> L17
        String r104 = r103.optString("GetPlayInfoToken");     // Catch: JSONException -> L17
        if (TextUtils.isEmpty(r104) == true) goto L10;
        r101 = r104;
    L10:
        r102 = r103.optString("TokenVersion");     // Catch: JSONException -> L17
        if (TextUtils.isEmpty(r102) == false) goto L13;
    L15:
        this.mApiVersion = 2;     // Catch: JSONException -> L17
    L21:
    L19:
        TTVideoEngineLog.d(TAG, "getAuthorization result:" + r101 + ", version:" + r102);
        return r101;
    L13:
        if (r102.equals("V2") == false) goto L15;
        this.mApiVersion = 4;     // Catch: JSONException -> L17
    L17:
        e = move-exception;
        e.printStackTrace();
        goto L19
    }

    public void setParams(Map<String, String> r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        if (r100.isEmpty() == true) goto L9;
        HashMap<String, String> r101 = new HashMap();
        this.mParams = r101;
        r101.putAll(r100);
        return;
    }

    public FetcherApiHelper(String r100, String r110) {
        this(r100, null, 1, false, false, false, r110);
    }

    private String addParam(String r100, String r101) {
        HashMap<String, String> r102 = this.mParams;
        if (r102 != null) goto L5;
    L7:
        HashMap<String, String> r103 = new HashMap();
    L8:
        int r104 = this.mApiVersion;
        if (r104 != 2) goto L25;
        if (this.mHlsEnable == false) goto L14;
        r103.put("format_type", TTVideoEngineInterface.FORMAT_TYPE_HLS);
    L14:
        if (this.mDashEnable == false) goto L17;
        r103.put("format_type", "dash");
    L17:
        if (TextUtils.equals(this.mCodecType, "bytevc1") == false) goto L22;
        if (r101.contains(TTVideoEngineInterface.PLAY_API_KEY_CODEC) == true) goto L22;
        r103.put(TTVideoEngineInterface.PLAY_API_KEY_CODEC, "1");
    L22:
        if (this.mEncryptEnable == false) goto L34;
        r103.put("stream_type", "evideo");
    L34:
        r103.put("device_type", Build.MODEL);
        r103.put("device_platform", "android");
        r103.put("aid", InfoWrapper.getAppID());
        String r105 = InfoWrapper.getDeviceID();
        if (TextUtils.isEmpty(r105) == true) goto L38;
        r103.put("device_id", r105);
    L38:
        if (TextUtils.isEmpty(BaseAppInfo.mAppVersion) == true) goto L40;
        r103.put("version_code", BaseAppInfo.mAppVersion);
    L40:
        StringBuilder r106 = new StringBuilder(r100);
        Iterator<Map.Entry<String, String>> r107 = r103.entrySet().iterator();
    L42:
        if (r107.hasNext() == false) goto L45;
        Map.Entry<String, String> r108 = r107.next();
        r106.append(String.format("&%s=%s", new Object[]{r108.getKey(), r108.getValue()}));
        goto L42
    L45:
        return r106.toString();
    L25:
        if (r104 != 4) goto L34;
        if (r101.contains("Codec") == true) goto L34;
        if (TextUtils.equals(this.mCodecType, "bytevc1") == false) goto L32;
        r103.put("Codec", "bytevc1");
        goto L34
    L32:
        if (TextUtils.equals(this.mCodecType, "bytevc2") == false) goto L34;
        r103.put("Codec", "bytevc2");
        goto L34
    L5:
        if (r102.isEmpty() == true) goto L7;
        r103 = this.mParams;
        goto L8
    }

    public FetcherApiHelper(String r100, boolean r110, boolean r111, boolean r112, String r113) {
        this(r100, null, 1, r110, r111, r112, r113);
    }

    public FetcherApiHelper(String r100, int r110, boolean r111, boolean r112, boolean r113, String r114) {
        this(null, r100, r110, r111, r112, r113, r114);
    }

    public FetcherApiHelper(String r100, String r101, int r102, boolean r103, boolean r104, boolean r105, String r106) {
        this.mDashEnable = r103;
        this.mHlsEnable = r104;
        this.mEncryptEnable = r105;
        this.mCodecType = r106;
        this.mAuthorization = r101;
        this.mApiVersion = r102;
        if (TextUtils.isEmpty(r101) == false) goto L5;
        this.mAuthorization = getAuthorization(r100);
    L5:
        TTVideoEngineLog.d(TAG, "new FetcherApiHelper authorization " + this.mAuthorization + "， apiVersion " + this.mApiVersion + "， mCodecType " + r106);
    }
}
