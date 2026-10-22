package com.ss.ttvideoengine.log;

import android.content.Context;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes34.dex */
public class AppLogTOBVer2 implements IVideoEventUploader {
    public AppLogTOBVer2() {
    }

    public static String getDeviceID() {
        return "";
    }

    public static void init(Context r100, String r101, String r102, String r103) {
    }

    public static boolean isAppLogVer2Exist() {
        return false;
    }

    @Override // com.ss.ttvideoengine.log.IVideoEventUploader
    public void onUplaod(String r100, JSONObject r101) {
    }
}
