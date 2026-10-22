package com.bytedance.reparo;

import android.app.Application;
import android.content.pm.PackageInfo;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.reparo.secondary.Logger;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.RequestBody;

/* JADX INFO: loaded from: classes21.dex */
public abstract class ReparoConfigExternalAdapter extends IReparoConfig {
    private static final String META_KEY_MARS_APP_ID = "MARS_APP_ID";
    private static final String META_KEY_UPDATE_VERSION_CODE = "UPDATE_VERSION_CODE";
    private static final String TAG = "FrankieConfigExternalAdapter";
    private static final String UNKNOWN = "unknown";

    public abstract String getAppKey();

    public abstract String getAppSecretKey();

    @Override // com.bytedance.reparo.IReparoConfig
    public String getAppId() {
        Application r100 = getApplication();
        Bundle r101 = r100.getPackageManager().getApplicationInfo(r100.getPackageName(), 128).metaData;     // Catch: Throwable -> L13
        if (r101 == null) goto L12;
        String r102 = String.valueOf(r101.get(META_KEY_MARS_APP_ID));     // Catch: Throwable -> L13
        if (TextUtils.isEmpty(r102) == true) goto L10;
        return r102;
    L10:
        throw new IllegalStateException(String.format("app id is empty, need to set %s in meta-data in AndroidManifest.xml", new Object[]{META_KEY_MARS_APP_ID}));     // Catch: Throwable -> L13
    L12:
        throw new IllegalStateException(String.format("app id is empty, need to set %s in meta-data in AndroidManifest.xml", new Object[]{META_KEY_MARS_APP_ID}));     // Catch: Throwable -> L13
    L13:
        th = move-exception;
        Logger.b(TAG, "get app id failed. ", th);
        return "unknown";
    }

    @Override // com.bytedance.reparo.IReparoConfig
    public String getUpdateVersionCode() {
        Application r100 = getApplication();
        Bundle r101 = r100.getPackageManager().getApplicationInfo(r100.getPackageName(), 128).metaData;     // Catch: Throwable -> L13
        if (r101 == null) goto L12;
        String r102 = String.valueOf(r101.get(META_KEY_UPDATE_VERSION_CODE));     // Catch: Throwable -> L13
        if (TextUtils.isEmpty(r102) == true) goto L10;
        return r102;
    L10:
        throw new IllegalStateException(String.format("update version code is empty, need to set %s in meta-data in AndroidManifest.xml", new Object[]{META_KEY_UPDATE_VERSION_CODE}));     // Catch: Throwable -> L13
    L12:
        throw new IllegalStateException(String.format("update version code is empty, need to set %s in meta-data in AndroidManifest.xml", new Object[]{META_KEY_UPDATE_VERSION_CODE}));     // Catch: Throwable -> L13
    L13:
        th = move-exception;
        Logger.b(TAG, "get update version code failed. ", th);
        return "unknown";
    }

    public long getVersionCode() {
        Application r100 = getApplication();     // Catch: Throwable -> L7
        PackageInfo r101 = r100.getPackageManager().getPackageInfo(r100.getPackageName(), 0);     // Catch: Throwable -> L7
        if (Build.VERSION.SDK_INT < 28) goto L6;
        long r102 = r101.getLongVersionCode();     // Catch: Throwable -> L7
    L9:
        return r102;
    L6:
        r102 = r101.versionCode;     // Catch: Throwable -> L7
    L7:
        return -1;
    }

    public ReparoConfigExternalAdapter() {
    }

    private String buildUrlParameters(String r100) {
        Uri.Builder r101 = UriProtector.parse(r100).buildUpon();
        r101.appendQueryParameter("device_id", getDeviceId()).appendQueryParameter("channel", getChannel()).appendQueryParameter("aid", getAppId()).appendQueryParameter("device_platform", "android").appendQueryParameter("os_api", String.valueOf(Build.VERSION.SDK_INT)).appendQueryParameter("version_code", String.valueOf(getVersionCode())).appendQueryParameter("update_version_code", getUpdateVersionCode());
        String r102 = Build.VERSION.RELEASE;     // Catch: Exception -> L10
        if (r102 != null) goto L6;
    L8:
        r101.appendQueryParameter("os_version", r102);     // Catch: Exception -> L10
    L13:
        return r101.build().toString();
    L6:
        if (r102.length() <= 10) goto L8;
        r102 = r102.substring(0, 10);     // Catch: Exception -> L10
    L10:
        e = move-exception;
        Logger.b(TAG, e.getMessage(), e);
        goto L13
    }

    @Override // com.bytedance.reparo.IReparoConfig
    public final String executePatchRequest(int r100, String r101, byte[] r110, String r111) throws Exception {
        String r102 = buildUrlParameters(r101);
        MediaType r103 = MediaType.parse(r111);
        String r104 = new String(r110);
        Request.Builder r105 = new Request.Builder().url(r102);
        if (e97.e.f471517b == null) goto L5;
    L14:
        e97.e r112 = e97.e.f471517b;
        String r106 = getAppKey();
        String r107 = getAppSecretKey();
        r112.getClass();
        SimpleDateFormat r113 = new SimpleDateFormat("yyyyMMdd'T'HHmmss'Z'");
        r113.setTimeZone(TimeZone.getTimeZone("UTC"));
        String r114 = r113.format(new Date());
        String r108 = e97.d.a(r114, r107);
        r105.addHeader("Authorization", "HMAC-SHA256 Credential=" + r106 + ",SignedHeaders=" + ("X-Mars-Date".toLowerCase() + com.alipay.sdk.m.u.i.f25853b) + ",Signature=" + e97.d.a(("X-Mars-Date".toLowerCase() + ":" + r114.replaceAll("\\s", "") + "\n") + w87.a.b(r104), r108));
        r105.addHeader("X-mars-date", r114);
        return e97.e.a().f471518a.newCall(r105.addHeader("Content-Type", r111).post(RequestBody.create(r103, r104)).build()).execute().body().string();
    L5:
        monitor-enter(e97.e.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (e97.e.f471517b != null) goto L9;
        e97.e.f471517b = new e97.e();     // Catch: Throwable -> L11
    L9:
        monitor-exit(e97.e.class);     // Catch: Throwable -> L11
        goto L14
    }
}
