package com.ss.android.common.applog;

import android.content.Context;
import com.service.middleware.applog.ApplogService;
import iqa.a;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
public class ApplogServiceImpl implements ApplogService {
    public static final String TAG = null;
    public static volatile a cachedHeaderCustomTimelyCallback;
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
        a r0 = cachedHeaderCustomTimelyCallback;
        AppLog.g0.registerHeaderCustomCallback(r0);
        return;
    }

    @Override // com.service.middleware.applog.ApplogService
    public void registerHeaderCustomCallback(a r2) {
        if (isServicePrepared == false) goto L5;
        AppLog.g0.registerHeaderCustomCallback(r2);
        return;
    L5:
        cachedHeaderCustomTimelyCallback = r2;
    }

    @Override // com.service.middleware.applog.ApplogService
    public void onEvent(Context r12, String r13) {
        if (isServicePrepared == false) goto L6;
        g0.b(r12, "event_v1", r13, null, 0, 0, false, null);
        return;
    }

    @Override // com.service.middleware.applog.ApplogService
    public void onEvent(Context r12, String r13, String r14) {
        if (isServicePrepared == false) goto L6;
        g0.b(r12, "event_v1", r13, r14, 0, 0, false, null);
        return;
    }

    @Override // com.service.middleware.applog.ApplogService
    public void onEvent(Context r12, String r13, String r14, String r15, long r16, long r18) {
        if (isServicePrepared == false) goto L6;
        g0.b(r12, r13, r14, r15, r16, r18, false, null);
        return;
    }

    @Override // com.service.middleware.applog.ApplogService
    public void onEvent(Context r12, String r13, String r14, String r15, long r16, long r18, JSONObject r20) {
        if (isServicePrepared == false) goto L6;
        g0.b(r12, r13, r14, r15, r16, r18, false, r20);
        return;
    }

    @Override // com.service.middleware.applog.ApplogService
    public void onEvent(Context r12, String r13, String r14, String r15, long r16, long r18, boolean r20) {
        if (isServicePrepared == false) goto L6;
        g0.b(r12, r13, r14, r15, r16, r18, r20, null);
        return;
    }

    @Override // com.service.middleware.applog.ApplogService
    public void onEvent(Context r2, String r3, String r4, String r5, long r6, long r8, boolean r10, JSONObject r11) {
        if (isServicePrepared == false) goto L6;
        g0.b(r2, r3, r4, r5, r6, r8, r10, r11);
        return;
    }
}
