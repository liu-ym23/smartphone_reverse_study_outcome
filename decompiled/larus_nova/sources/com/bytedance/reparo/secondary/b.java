package com.bytedance.reparo.secondary;

import android.app.Application;
import android.provider.Settings;
import android.text.TextUtils;
import com.bytedance.crash.Npth;
import com.bytedance.crash.a0;
import com.bytedance.reparo.IReparoConfig;

/* JADX INFO: loaded from: classes3.dex */
public final class b extends IReparoConfig {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final IReparoConfig f267471a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f267472b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f267473c;

    @Override // com.bytedance.reparo.IReparoConfig
    public final boolean enable() {
        return this.f267471a.enable();
    }

    @Override // com.bytedance.reparo.IReparoConfig
    public final String getAppId() {
        return this.f267471a.getAppId();
    }

    @Override // com.bytedance.reparo.IReparoConfig
    public final Application getApplication() {
        return this.f267471a.getApplication();
    }

    @Override // com.bytedance.reparo.IReparoConfig
    public final String getChannel() {
        if (this.f267473c != (-1)) goto L13;
    L11:
        this.f267473c = 0;
        goto L13
    L6:
        if (TextUtils.isEmpty(Settings.Global.getString(getApplication().getContentResolver(), "bytest_automation_info")) == false) goto L8;
        int r100 = 0;
    L9:
        this.f267473c = r100;     // Catch: Throwable -> L11
        goto L13
    L8:
        r100 = 1;
    L13:
        if (this.f267473c != 1) goto L16;
        return "reparo_test";
    L16:
        return this.f267471a.getChannel();
    }

    @Override // com.bytedance.reparo.IReparoConfig
    public final String getDeviceId() {
        if (a(this.f267472b) == true) goto L5;
        String r100 = this.f267471a.getDeviceId();
        this.f267472b = r100;
        if (a(r100) == true) goto L16;
        if (Npth.isInit() == false) goto L16;
        wh4.e r101 = a0.a();     // Catch: Throwable -> L13
        if (TextUtils.isEmpty(r101.f559656a) == false) goto L14;
        r101.f559656a = "0";     // Catch: Throwable -> L13
    L14:
        this.f267472b = r101.f559656a;     // Catch: Throwable -> L13
    L16:
        if (a(this.f267472b) == true) goto L22;
        return "1";
    L22:
        return this.f267472b;
    L5:
        return this.f267472b;
    }

    @Override // com.bytedance.reparo.IReparoConfig
    public final String getUpdateVersionCode() {
        return this.f267471a.getUpdateVersionCode();
    }

    @Override // com.bytedance.reparo.IReparoConfig
    public final boolean isMainProcess() {
        return this.f267471a.isMainProcess();
    }

    public b(IReparoConfig r100) {
        this.f267472b = null;
        this.f267473c = -1;
        this.f267471a = r100;
    }

    public static boolean a(String r100) {
        if (r100 != null) goto L4;
    L10:
        return false;
    L4:
        if (TextUtils.isEmpty(r100) == true) goto L10;
        if ("0".equals(r100) == true) goto L10;
        if ("1".equals(r100) == true) goto L10;
        return true;
    }

    @Override // com.bytedance.reparo.IReparoConfig
    public final c97.a getAbiHelper(Application r100) {
        return this.f267471a.getAbiHelper(r100);
    }

    @Override // com.bytedance.reparo.IReparoConfig
    public final String executePatchRequest(int r100, String r101, byte[] r102, String r103) throws Exception {
        return this.f267471a.executePatchRequest(r100, r101, r102, r103);
    }
}
