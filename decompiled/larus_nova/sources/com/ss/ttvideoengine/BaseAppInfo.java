package com.ss.ttvideoengine;

import android.content.Context;
import java.util.HashMap;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes34.dex */
public class BaseAppInfo {
    public static String mAppChannel = null;
    public static int mAppID = -1;
    public static String mAppName;
    public static String mAppVersion;
    public static Context mContext;
    public static String mDeviceId;
    public static String mOpenApiHostName;
    public static String mRegion;
    public static int mScreenHeight;
    public static int mScreenWidth;
    public static String mSmartUrlApiHostName;

    public BaseAppInfo() {
    }

    public static String toJsonString() {
        HashMap r100 = new HashMap();
        r100.put("app_id", Integer.valueOf(mAppID));
        r100.put("app_name", mAppName);
        r100.put("screen_width", Integer.valueOf(mScreenWidth));
        r100.put("screen_height", Integer.valueOf(mScreenHeight));
        String r101 = mDeviceId;
        if (r101 != null) goto L5;
    L7:
        String r102 = mAppVersion;
        if (r102 == null) goto L13;
        if (r102.isEmpty() == true) goto L13;
        r100.put("app_version", mAppVersion);
    L13:
        return new JSONObject(r100).toString();
    L5:
        if (r101.isEmpty() == true) goto L7;
        r100.put(com.bytedance.android.ec.core.event.a.KEY_DID, mDeviceId);
        goto L7
    }
}
