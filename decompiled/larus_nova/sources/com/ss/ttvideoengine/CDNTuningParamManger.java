package com.ss.ttvideoengine;

import android.os.Build;
import android.text.TextUtils;
import com.byted.cast.linkcommon.cybergarage.xml.XML;
import com.ss.ttvideoengine.setting.SettingsHelper;
import java.net.URLEncoder;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes34.dex */
public class CDNTuningParamManger {
    private static final String BITRATE_ENABLE = "bitrate_enable";
    public static final String CDN_PRAMS_HEADER_KEY = "x-ttsdk-qi";
    private static final String CDN_TUNING_ENABLE = "cdn_tuning_enable";
    private static final String CDN_TUNING_PARAM = "cdn_tuning_param";
    private static final int DEFAULT_VALUE = -1;
    private static final String DEVICEID_ENABLE = "deviceid_enable";
    private static final String DEVICE_MODEL_ENABLE = "device_model_enable";
    private static final int FEATURE_DISABLE = 0;
    private static final String FORMAT_ENABLE = "format_enable";
    private static final String NET_TYPE_ENABLE = "net_type_enable";
    private static final String OS_ANDROID = "1";
    private static final String OS_ENABLE = "os_enable";
    private static final String RANGE_ENABLE = "range_enable";
    private static final String SEPARATOR = ",";
    private static final String TRACEID_ENABLE = "traceid_enable";
    private int mBitrate;
    private boolean mBitrateEnable;
    private boolean mCdnTuningEnable;
    private boolean mDeviceIdEnable;
    private boolean mDeviceModelEnable;
    private String mFormat;
    private boolean mFormatEnable;
    private boolean mNetTypeEnable;
    private boolean mOSEnable;
    private boolean mRangeEnable;
    private boolean mTraceIdEnable;

    public String getParam() {
        return getEncodeParam(this.mFormatEnable, this.mFormat) + "," + getEncodeParam(this.mRangeEnable, "1") + "," + getEncodeParam(this.mNetTypeEnable, getParamNetType()) + "," + getEncodeParam(this.mOSEnable, "1") + "," + getEncodeParam(this.mBitrateEnable, String.valueOf(this.mBitrate)) + "," + getEncodeParam(this.mDeviceModelEnable, Build.MODEL) + "," + getEncodeParam(this.mTraceIdEnable, "1") + "," + getEncodeParam(this.mDeviceIdEnable, "1");
    }

    public CDNTuningParamManger() {
        this.mBitrate = -1;
        updateSettings();
    }

    private String getParamNetType() {
        int r100 = TTNetWorkListener.getInstance().getCurrentAccessType();
        int r101 = 1;
        if (r100 == 0) goto L17;
        if (r100 == 1) goto L15;
        r101 = 2;
        if (r100 == 2) goto L17;
        r101 = 3;
        if (r100 == 3) goto L17;
        if (r100 == 4) goto L14;
        r101 = 6;
        if (r100 == 6) goto L17;
        r101 = -1;
        goto L17
    L14:
        r101 = 5;
        goto L17
    L15:
        r101 = 4;
    L17:
        return String.valueOf(r101);
    }

    private void updateSettings() {
        boolean r100 = false;
        if (SettingsHelper.helper().getVodInt(CDN_TUNING_ENABLE, 0) != 1) goto L5;
        boolean r101 = true;
    L6:
        this.mCdnTuningEnable = r101;
        JSONObject r102 = SettingsHelper.helper().getVodJsonObject(CDN_TUNING_PARAM);
        if (r102 != null) goto L10;
        return;
    L10:
        if (r102.optInt(FORMAT_ENABLE) != 1) goto L12;
        boolean r103 = true;
    L13:
        this.mFormatEnable = r103;
        if (r102.optInt(RANGE_ENABLE) != 1) goto L16;
        boolean r104 = true;
    L17:
        this.mRangeEnable = r104;
        if (r102.optInt(NET_TYPE_ENABLE) != 1) goto L20;
        boolean r105 = true;
    L21:
        this.mNetTypeEnable = r105;
        if (r102.optInt(OS_ENABLE) != 1) goto L24;
        boolean r106 = true;
    L25:
        this.mOSEnable = r106;
        if (r102.optInt(BITRATE_ENABLE) != 1) goto L28;
        boolean r107 = true;
    L29:
        this.mBitrateEnable = r107;
        if (r102.optInt(DEVICE_MODEL_ENABLE) != 1) goto L32;
        boolean r108 = true;
    L33:
        this.mDeviceModelEnable = r108;
        if (r102.optInt(TRACEID_ENABLE) != 1) goto L36;
        boolean r109 = true;
    L37:
        this.mTraceIdEnable = r109;
        if (r102.optInt(DEVICEID_ENABLE) != 1) goto L40;
        r100 = true;
    L40:
        this.mDeviceIdEnable = r100;
        return;
    L36:
        r109 = false;
        goto L37
    L32:
        r108 = false;
        goto L33
    L28:
        r107 = false;
        goto L29
    L24:
        r106 = false;
        goto L25
    L20:
        r105 = false;
        goto L21
    L16:
        r104 = false;
        goto L17
    L12:
        r103 = false;
        goto L13
    L5:
        r101 = false;
        goto L6
    }

    public boolean isCdnTuningEnable() {
        return this.mCdnTuningEnable;
    }

    public void setBitrate(int r100) {
        this.mBitrate = r100;
    }

    public void setFormat(String r100) {
        this.mFormat = r100;
    }

    private String getEncodeParam(boolean r100, String r101) {
        if (r100 == true) goto L6;
        return String.valueOf(0);
    L6:
        if (TextUtils.isEmpty(r101) == true) goto L8;
        return URLEncoder.encode(r101, XML.CHARSET_UTF8);
    L12:
        return String.valueOf(-1);
    L8:
        return String.valueOf(-1);
    }
}
