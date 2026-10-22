package com.ss.android.common.applog;

import android.content.Context;
import com.service.middleware.applog.ApplogService;
import com.ss.android.message.log.PushLog;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class ApplogServiceImpl implements ApplogService {
    public static final String TAG = null;
    public static volatile iqa.a cachedHeaderCustomTimelyCallback;
    public static volatile boolean isServicePrepared;

    public ApplogServiceImpl() {
    }

    static {
        TAG = "ApplogServiceImpl";
        isServicePrepared = false;
        cachedHeaderCustomTimelyCallback = null;
    }

    public static void handleCachedData() {
        if (isServicePrepared == true) goto L6;
        return;
    L6:
        if (cachedHeaderCustomTimelyCallback == null) goto L9;
        iqa.a r100 = cachedHeaderCustomTimelyCallback;
        AppLog.f408004g0.registerHeaderCustomCallback(r100);
        return;
    }

    @Override // com.service.middleware.applog.ApplogService
    public void registerHeaderCustomCallback(iqa.a r100) {
        if (isServicePrepared == false) goto L5;
        AppLog.f408004g0.registerHeaderCustomCallback(r100);
        return;
    L5:
        cachedHeaderCustomTimelyCallback = r100;
    }

    @Override // com.service.middleware.applog.ApplogService
    public void onEvent(Context r110, String r111) {
        if (isServicePrepared == false) goto L6;
        g0.b(r110, PushLog.CATEGORY, r111, null, 0, 0, false, null);
        return;
    }

    @Override // com.service.middleware.applog.ApplogService
    public void onEvent(Context r110, String r111, String r112) {
        if (isServicePrepared == false) goto L6;
        g0.b(r110, PushLog.CATEGORY, r111, r112, 0, 0, false, null);
        return;
    }

    @Override // com.service.middleware.applog.ApplogService
    public void onEvent(Context r110, String r111, String r112, String r113, long r114, long r115) {
        if (isServicePrepared == false) goto L6;
        g0.b(r110, r111, r112, r113, r114, r115, false, null);
        return;
    }

    @Override // com.service.middleware.applog.ApplogService
    public void onEvent(Context r110, String r111, String r112, String r113, long r114, long r115, JSONObject r210) {
        if (isServicePrepared == false) goto L6;
        g0.b(r110, r111, r112, r113, r114, r115, false, r210);
        return;
    }

    @Override // com.service.middleware.applog.ApplogService
    public void onEvent(Context r110, String r111, String r112, String r113, long r114, long r115, boolean r210) {
        if (isServicePrepared == false) goto L6;
        g0.b(r110, r111, r112, r113, r114, r115, r210, null);
        return;
    }

    @Override // com.service.middleware.applog.ApplogService
    public void onEvent(Context r100, String r101, String r102, String r103, long r104, long r105, boolean r110, JSONObject r111) {
        if (isServicePrepared == false) goto L6;
        g0.b(r100, r101, r102, r103, r104, r105, r110, r111);
        return;
    }
}
