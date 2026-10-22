package com.bytedance.common;

import android.app.Service;
import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import com.bytedance.common.support.PushCommonSupport;
import com.bytedance.push.utils.f;
import n67.c;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes15.dex */
public class MainProcessEventService extends Service {
    public static String KEY_EVENT_NAME = "event_name";
    public static String KEY_EVENT_PARAMS = "event_params";

    @Override // android.app.Service
    public int onStartCommand(Intent r100, int r101, int r102) {
        return 2;
    }

    public MainProcessEventService() {
    }

    @Override // android.app.Service
    public IBinder onBind(Intent r100) {
        f.b("MainProcessEventServiceTag", "onBind");
        Bundle r101 = r100.getExtras();
        if (r101 == null) goto L13;
        String r102 = r101.getString(KEY_EVENT_NAME);
        String r103 = r101.getString(KEY_EVENT_PARAMS);
        f.b("MainProcessEventServiceTag", "report " + r102 + HTTP.HEADER_LINE_DELIM + r103);     // Catch: JSONException -> L7
        ((c) PushCommonSupport.getInstance().getPushConfigurationService().getPushCommonConfiguration().mIPushCommonEventSender).b(r102, new JSONObject(r103));     // Catch: JSONException -> L7
        return null;
    L7:
        e = move-exception;
        e.printStackTrace();
        return null;
    L13:
        return null;
    }
}
