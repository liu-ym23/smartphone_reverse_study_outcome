package com.google.android.gms.common;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.text.TextUtils;
import com.autonavi.amap.mapcore.AMapEngineUtils;
import com.bytedance.mt.protector.impl.UriProtector;
import com.google.android.gms.common.wrappers.Wrappers;
import com.google.errorprone.annotations.ResultIgnorabilityUnspecified;
import com.huawei.hms.support.api.entity.common.CommonConstant;

/* JADX INFO: loaded from: classes23.dex */
public class GoogleApiAvailabilityLight {
    public static final String GOOGLE_PLAY_SERVICES_PACKAGE = "com.google.android.gms";
    public static final int GOOGLE_PLAY_SERVICES_VERSION_CODE = 0;
    public static final String GOOGLE_PLAY_STORE_PACKAGE = "com.android.vending";
    static final String TRACKING_SOURCE_DIALOG = "d";
    static final String TRACKING_SOURCE_NOTIFICATION = "n";

    /* JADX INFO: renamed from: zza, reason: collision with root package name */
    private static final GoogleApiAvailabilityLight f274457zza = null;

    public GoogleApiAvailabilityLight() {
    }

    public static GoogleApiAvailabilityLight getInstance() {
        return f274457zza;
    }

    static {
        GOOGLE_PLAY_SERVICES_VERSION_CODE = GooglePlayServicesUtilLight.GOOGLE_PLAY_SERVICES_VERSION_CODE;
        f274457zza = new GoogleApiAvailabilityLight();
    }

    public void cancelAvailabilityErrorNotifications(Context r100) {
        GooglePlayServicesUtilLight.cancelAvailabilityErrorNotifications(r100);
    }

    public int getApkVersion(Context r100) {
        return GooglePlayServicesUtilLight.getApkVersion(r100);
    }

    public int getClientVersion(Context r100) {
        return GooglePlayServicesUtilLight.getClientVersion(r100);
    }

    public Intent getErrorResolutionIntent(int r100) {
        return getErrorResolutionIntent(null, r100, null);
    }

    public String getErrorString(int r100) {
        return GooglePlayServicesUtilLight.getErrorString(r100);
    }

    @ResultIgnorabilityUnspecified
    public int isGooglePlayServicesAvailable(Context r100) {
        return isGooglePlayServicesAvailable(r100, GOOGLE_PLAY_SERVICES_VERSION_CODE);
    }

    public boolean isUserResolvableError(int r100) {
        return GooglePlayServicesUtilLight.isUserRecoverableError(r100);
    }

    public int isGooglePlayServicesAvailable(Context r100, int r101) {
        int r102 = GooglePlayServicesUtilLight.isGooglePlayServicesAvailable(r100, r101);
        if (GooglePlayServicesUtilLight.isPlayServicesPossiblyUpdating(r100, r102) == false) goto L6;
        return 18;
    L6:
        return r102;
    }

    public boolean isPlayServicesPossiblyUpdating(Context r100, int r101) {
        return GooglePlayServicesUtilLight.isPlayServicesPossiblyUpdating(r100, r101);
    }

    public boolean isPlayStorePossiblyUpdating(Context r100, int r101) {
        return GooglePlayServicesUtilLight.isPlayStorePossiblyUpdating(r100, r101);
    }

    public boolean isUninstalledAppPossiblyUpdating(Context r100, String r101) {
        return GooglePlayServicesUtilLight.zza(r100, r101);
    }

    public void verifyGooglePlayServicesIsAvailable(Context r100, int r101) throws GooglePlayServicesRepairableException, GooglePlayServicesNotAvailableException {
        GooglePlayServicesUtilLight.ensurePlayServicesAvailable(r100, r101);
    }

    public Intent getErrorResolutionIntent(Context r100, int r101, String r102) {
        if (r101 != 1) goto L5;
    L11:
        if (r100 != null) goto L13;
    L17:
        StringBuilder r103 = new StringBuilder("gcore_");
        r103.append(GOOGLE_PLAY_SERVICES_VERSION_CODE);
        r103.append("-");
        if (TextUtils.isEmpty(r102) == true) goto L20;
        r103.append(r102);
    L20:
        r103.append("-");
        if (r100 == null) goto L23;
        r103.append(r100.getPackageName());
    L23:
        r103.append("-");
        if (r100 != null) goto L33;
    L28:
        String r104 = r103.toString();
        Intent r105 = new Intent(CommonConstant.ACTION.HWID_SCHEME_URL);
        Uri.Builder r106 = UriProtector.parse("market://details").buildUpon().appendQueryParameter("id", "com.google.android.gms");
        if (TextUtils.isEmpty(r104) == true) goto L31;
        r106.appendQueryParameter("pcampaignid", r104);
    L31:
        r105.setData(r106.build());
        r105.setPackage("com.android.vending");
        r105.addFlags(524288);
        return r105;
    L33:
        r103.append(Wrappers.packageManager(r100).getPackageInfo(r100.getPackageName(), 0).versionCode);     // Catch: PackageManager.NameNotFoundException -> L27
        goto L28
    L13:
        if (av7.b.a(r100) == false) goto L17;
        Intent r107 = new Intent("com.google.android.clockwork.home.UPDATE_ANDROID_WEAR_ACTION");
        r107.setPackage("com.google.android.wearable.app");
        return r107;
    L5:
        if (r101 == 2) goto L11;
        if (r101 == 3) goto L9;
        return null;
    L9:
        Uri r108 = Uri.fromParts("package", "com.google.android.gms", null);
        Intent r109 = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
        r109.setData(r108);
        return r109;
    }

    public PendingIntent getErrorResolutionPendingIntent(Context r100, int r101, int r102) {
        return getErrorResolutionPendingIntent(r100, r101, r102, null);
    }

    public PendingIntent getErrorResolutionPendingIntent(Context r100, int r101, int r102, String r103) {
        Intent r104 = getErrorResolutionIntent(r100, r101, r103);
        if (r104 != null) goto L7;
        return null;
    L7:
        return PendingIntent.getActivity(r100, r102, r104, com.google.android.gms.internal.common.i.f274648a | AMapEngineUtils.HALF_MAX_P20_WIDTH);
    }
}
