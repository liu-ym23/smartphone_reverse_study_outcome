package com.huawei.agconnect.config.impl;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.agconnect.AGConnectApp;
import com.huawei.agconnect.AGConnectInstance;
import com.huawei.agconnect.CustomAuthProvider;
import com.huawei.agconnect.CustomCredentialsProvider;
import com.huawei.agconnect.config.AGConnectServicesConfig;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes23.dex */
public class a extends AGConnectApp {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Map<String, AGConnectApp> f276695a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Object f276696b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static String f276697c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private AGConnectServicesConfig f276698d;

    static {
        f276695a = new HashMap();
        f276696b = new Object();
    }

    private a(Context r100, String r101) {
        this.f276698d = AGConnectServicesConfig.fromContext(r100, r101);
    }

    public static AGConnectApp a() {
        return a(f276697c);
    }

    public static AGConnectApp a(Context r100) {
        Context r101 = r100.getApplicationContext();
        if (r101 == null) goto L6;
        r100 = r101;
    L6:
        String r102 = r100.getPackageName();
        f276697c = r102;
        return a(r100, r102);
    }

    public static AGConnectApp a(Context r100, String r101) {
        if (TextUtils.isEmpty(r101) == true) goto L15;
        Object r102 = f276696b;
        monitor-enter(r102);
        Map<String, AGConnectApp> r103 = f276695a;     // Catch: Throwable -> L11
        AGConnectApp r104 = r103.get(r101);     // Catch: Throwable -> L11
        if (r104 != null) goto L9;
        r103.put(r101, new a(r100, r101));     // Catch: Throwable -> L11
    L9:
        monitor-exit(r102);     // Catch: Throwable -> L11
        return r104;
    L11:
        th = move-exception;
        throw th;
    L15:
        throw new IllegalArgumentException("packageName can not be empty");
    }

    public static AGConnectApp a(String r100) {
        Object r101 = f276696b;
        monitor-enter(r101);
        AGConnectApp r102 = f276695a.get(r100);     // Catch: Throwable -> L10
        if (r102 == null) goto L9;
        monitor-exit(r101);     // Catch: Throwable -> L10
        return r102;
    L9:
        throw new IllegalStateException("you should call AGConnectApp.initialize first");     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        throw th;
    }

    @Override // com.huawei.agconnect.AGConnectApp
    public void setApiKey(String r100) {
        this.f276698d.setParam("/client/api_key", r100);
    }

    @Override // com.huawei.agconnect.AGConnectApp
    public void setAppId(String r100) {
        this.f276698d.setParam("/client/app_id", r100);
    }

    @Override // com.huawei.agconnect.AGConnectApp
    public void setClientId(String r100) {
        this.f276698d.setParam("/client/client_id", r100);
    }

    @Override // com.huawei.agconnect.AGConnectApp
    public void setClientSecret(String r100) {
        this.f276698d.setParam("/client/client_secret", r100);
    }

    @Override // com.huawei.agconnect.AGConnectApp
    public void setCpId(String r100) {
        this.f276698d.setParam("/client/cp_id", r100);
    }

    @Override // com.huawei.agconnect.AGConnectApp
    public void setCustomAuthProvider(CustomAuthProvider r100) {
        ((com.huawei.agconnect.core.a.b) AGConnectInstance.getInstance()).a(r100);
    }

    @Override // com.huawei.agconnect.AGConnectApp
    public void setCustomCredentialsProvider(CustomCredentialsProvider r100) {
        ((com.huawei.agconnect.core.a.b) AGConnectInstance.getInstance()).a(r100);
    }

    @Override // com.huawei.agconnect.AGConnectApp
    public void setParam(String r100, String r101) {
        if (TextUtils.isEmpty(r100) == true) goto L7;
        this.f276698d.setParam(r100, r101);
        return;
    L7:
        throw new IllegalArgumentException("path can not be empty");
    }

    @Override // com.huawei.agconnect.AGConnectApp
    public void setProductId(String r100) {
        this.f276698d.setParam("/client/product_id", r100);
    }
}
