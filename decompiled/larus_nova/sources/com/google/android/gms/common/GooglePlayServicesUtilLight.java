package com.google.android.gms.common;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageInstaller;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.os.Build;
import android.os.Bundle;
import android.os.UserManager;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.PlatformVersion;
import com.google.android.gms.common.util.UidVerifier;
import com.google.android.gms.common.wrappers.Wrappers;
import com.google.errorprone.annotations.ResultIgnorabilityUnspecified;
import com.larus.nova.R;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes23.dex */
public class GooglePlayServicesUtilLight {
    static final int GMS_AVAILABILITY_NOTIFICATION_ID = 10436;
    static final int GMS_GENERAL_ERROR_NOTIFICATION_ID = 39789;
    public static final String GOOGLE_PLAY_GAMES_PACKAGE = "com.google.android.play.games";
    public static final String GOOGLE_PLAY_SERVICES_PACKAGE = "com.google.android.gms";
    public static final int GOOGLE_PLAY_SERVICES_VERSION_CODE = 12451000;
    public static final String GOOGLE_PLAY_STORE_PACKAGE = "com.android.vending";
    static final AtomicBoolean sCanceledAvailabilityNotification = null;

    /* JADX INFO: renamed from: zza, reason: collision with root package name */
    static boolean f274460zza;

    /* JADX INFO: renamed from: zzb, reason: collision with root package name */
    private static boolean f274461zzb;
    private static final AtomicBoolean zzc = null;

    public GooglePlayServicesUtilLight() {
    }

    public static boolean isUserRecoverableError(int r100) {
        if (r100 != 1) goto L5;
    L12:
        return true;
    L5:
        if (r100 == 2) goto L12;
        if (r100 == 3) goto L12;
        if (r100 == 9) goto L12;
        return false;
    }

    static {
        sCanceledAvailabilityNotification = new AtomicBoolean();
        zzc = new AtomicBoolean();
    }

    public static void enableUsingApkIndependentContext() {
        zzc.set(true);
    }

    public static void cancelAvailabilityErrorNotifications(Context r100) {
        if (sCanceledAvailabilityNotification.getAndSet(true) == true) goto L13;
        NotificationManager r101 = (NotificationManager) r100.getSystemService("notification");     // Catch: SecurityException -> L9
        if (r101 == null) goto L12;
        r101.cancel(GMS_AVAILABILITY_NOTIFICATION_ID);     // Catch: SecurityException -> L9
        return;
    L12:
        return;
    L14:
        return;
    }

    public static int getApkVersion(Context r100) {
        return r100.getPackageManager().getPackageInfo("com.google.android.gms", 0).versionCode;
    L6:
        return 0;
    }

    public static int getClientVersion(Context r100) {
        Preconditions.checkState(true);
        String r101 = r100.getPackageName();
        PackageInfo r102 = Wrappers.packageManager(r100).getPackageInfo(r101, 128);     // Catch: PackageManager.NameNotFoundException -> L5
    L7:
        if (r102 == null) goto L17;
        ApplicationInfo r103 = r102.applicationInfo;
        if (r103 == null) goto L19;
        Bundle r104 = r103.metaData;
        if (r104 != null) goto L14;
        return -1;
    L14:
        return r104.getInt("com.google.android.gms.version", -1);
    L19:
        return -1;
    L17:
        return -1;
    L5:
        r102 = null;
        goto L7
    }

    public static String getErrorString(int r100) {
        return ConnectionResult.zza(r100);
    }

    public static Intent getGooglePlayServicesAvailabilityRecoveryIntent(int r100) {
        return GoogleApiAvailabilityLight.getInstance().getErrorResolutionIntent(null, r100, null);
    }

    public static Context getRemoteContext(Context r100) {
        return r100.createPackageContext("com.google.android.gms", 3);
    L4:
        return null;
    }

    public static Resources getRemoteResource(Context r100) {
        return r100.getPackageManager().getResourcesForApplication("com.google.android.gms");
    L4:
        return null;
    }

    public static boolean honorsDebugCertificates(Context r100) {
        if (f274460zza == true) goto L18;
        PackageInfo r101 = Wrappers.packageManager(r100).getPackageInfo("com.google.android.gms", 64);     // Catch: Throwable -> L13 PackageManager.NameNotFoundException -> L16
        GoogleSignatureVerifier.getInstance(r100);     // Catch: Throwable -> L13 PackageManager.NameNotFoundException -> L16
        if (r101 != null) goto L7;
    L11:
        f274461zzb = false;     // Catch: Throwable -> L13 PackageManager.NameNotFoundException -> L16
    L12:
        f274460zza = true;
        goto L18
    L7:
        if (GoogleSignatureVerifier.zzb(r101, false) == true) goto L11;
        if (GoogleSignatureVerifier.zzb(r101, true) == false) goto L11;
        f274461zzb = true;     // Catch: Throwable -> L13 PackageManager.NameNotFoundException -> L16
    L16:
        f274460zza = true;
    L13:
        th = move-exception;
        f274460zza = true;
        throw th;
    L18:
        if (f274461zzb == false) goto L20;
    L23:
        return true;
    L20:
        if ("user".equals(Build.TYPE) == false) goto L23;
        return false;
    }

    @ResultIgnorabilityUnspecified
    public static int isGooglePlayServicesAvailable(Context r100) {
        return isGooglePlayServicesAvailable(r100, GOOGLE_PLAY_SERVICES_VERSION_CODE);
    }

    public static boolean isRestrictedUserProfile(Context r100) {
        if (PlatformVersion.isAtLeastJellyBeanMR2() == false) goto L10;
        Object r101 = r100.getSystemService("user");
        Preconditions.checkNotNull(r101);
        Bundle r102 = ((UserManager) r101).getApplicationRestrictions(r100.getPackageName());
        if (r102 != null) goto L7;
        return false;
    L7:
        if ("true".equals(r102.getString("restricted_profile")) == false) goto L13;
        return true;
    L13:
        return false;
    L10:
        return false;
    }

    public static boolean isSidewinderDevice(Context r100) {
        return av7.b.b(r100);
    }

    public static void ensurePlayServicesAvailable(Context r100, int r101) throws GooglePlayServicesRepairableException, GooglePlayServicesNotAvailableException {
        int r102 = GoogleApiAvailabilityLight.getInstance().isGooglePlayServicesAvailable(r100, r101);
        if (r102 == 0) goto L10;
        Intent r103 = GoogleApiAvailabilityLight.getInstance().getErrorResolutionIntent(r100, r102, "e");
        if (r103 != null) goto L9;
        throw new GooglePlayServicesNotAvailableException(r102);
    L9:
        throw new GooglePlayServicesRepairableException(r102, "Google Play Services not available", r103);
    }

    public static int isGooglePlayServicesAvailable(Context r100, int r101) {
        r100.getResources().getString(R.string.common_google_play_services_unknown_issue);     // Catch: Throwable -> L4
    L6:
        if ("com.google.android.gms".equals(r100.getPackageName()) == true) goto L20;
        if (zzc.get() == true) goto L20;
        com.google.android.gms.common.internal.d.a(r100);
        int r102 = com.google.android.gms.common.internal.d.f274539d;
        if (r102 == 0) goto L18;
        if (r102 == GOOGLE_PLAY_SERVICES_VERSION_CODE) goto L20;
        throw new GooglePlayServicesIncorrectManifestValueException(r102);
    L18:
        throw new GooglePlayServicesMissingManifestValueException();
    L20:
        if (av7.b.a(r100) == false) goto L22;
    L34:
        boolean r103 = false;
    L35:
        if (r101 < 0) goto L37;
        boolean r104 = true;
    L38:
        Preconditions.checkArgument(r104);
        String r105 = r100.getPackageName();
        PackageManager r106 = r100.getPackageManager();
        if (r103 == true) goto L85;
        PackageInfo r107 = null;
    L79:
        PackageInfo r108 = r106.getPackageInfo("com.google.android.gms", 64);     // Catch: PackageManager.NameNotFoundException -> L77
        GoogleSignatureVerifier.getInstance(r100);
        if (GoogleSignatureVerifier.zzb(r108, true) == true) goto L49;
        String.valueOf(r105).concat(" requires Google Play services, but their signature is invalid.");
    L58:
        return 9;
    L49:
        if (r103 == false) goto L53;
        Preconditions.checkNotNull(r107);
        if (GoogleSignatureVerifier.zzb(r107, true) == true) goto L53;
        String.valueOf(r105).concat(" requires Google Play Store, but its signature is invalid.");
    L53:
        if (r103 == false) goto L59;
        if (r107 == null) goto L59;
        if (r107.signatures[0].equals(r108.signatures[0]) == true) goto L59;
        String.valueOf(r105).concat(" requires Google Play Store, but its signature doesn't match that of Google Play services.");
    L59:
        int r109 = r108.versionCode;
        int r110 = -1;
        if (r109 != (-1)) goto L62;
        int r111 = -1;
    L63:
        if (r101 == (-1)) goto L66;
        r110 = r101 / 1000;
    L66:
        if (r111 < r110) goto L88;
        ApplicationInfo r112 = r108.applicationInfo;
        if (r112 != null) goto L74;
        r112 = r106.getApplicationInfo("com.google.android.gms", 0);     // Catch: PackageManager.NameNotFoundException -> L72
    L72:
        String.valueOf(r105).concat(" requires Google Play services, but they're missing when getting application info.");
        return 1;
    L74:
        if (r112.enabled == true) goto L76;
        return 3;
    L76:
        return 0;
    L88:
        return 2;
    L62:
        r111 = r109 / 1000;
    L77:
        String.valueOf(r105).concat(" requires Google Play services, but they are missing.");
        return 1;
    L85:
        r107 = r106.getPackageInfo("com.android.vending", 8256);     // Catch: PackageManager.NameNotFoundException -> L42
    L42:
        String.valueOf(r105).concat(" requires the Google Play Store, but it is missing.");
        goto L58
    L37:
        r104 = false;
        goto L38
    L22:
        if (av7.b.f16385c != null) goto L32;
        if (r100.getPackageManager().hasSystemFeature("android.hardware.type.iot") == false) goto L26;
    L29:
        boolean r113 = true;
    L30:
        av7.b.f16385c = Boolean.valueOf(r113);
        goto L32
    L26:
        if (r100.getPackageManager().hasSystemFeature("android.hardware.type.embedded") == true) goto L29;
        r113 = false;
    L32:
        if (av7.b.f16385c.booleanValue() == true) goto L34;
        r103 = true;
        goto L35
    }

    public static boolean isGooglePlayServicesUid(Context r100, int r101) {
        return UidVerifier.isGooglePlayServicesUid(r100, r101);
    }

    public static boolean isPlayServicesPossiblyUpdating(Context r100, int r101) {
        if (r101 != 18) goto L5;
        return true;
    L5:
        if (r101 == 1) goto L7;
        return false;
    L7:
        return zza(r100, "com.google.android.gms");
    }

    public static boolean isPlayStorePossiblyUpdating(Context r100, int r101) {
        if (r101 == 9) goto L5;
        return false;
    L5:
        return zza(r100, "com.android.vending");
    }

    public static boolean zza(Context r100, String r101) {
        boolean r102 = r101.equals("com.google.android.gms");
        if (PlatformVersion.isAtLeastLollipop() == false) goto L24;
        Iterator<PackageInstaller.SessionInfo> r103 = r100.getPackageManager().getPackageInstaller().getAllSessions().iterator();
    L7:
        if (r103.hasNext() == false) goto L24;
        if (r101.equals(r103.next().getAppPackageName()) == false) goto L7;
        return true;
    L11:
        return false;
    L24:
        ApplicationInfo r104 = r100.getPackageManager().getApplicationInfo(r101, 8192);     // Catch: PackageManager.NameNotFoundException -> L23
        if (r102 == false) goto L18;
        return r104.enabled;
    L18:
        if (r104.enabled == false) goto L22;
        if (isRestrictedUserProfile(r100) == true) goto L22;
        return true;
    L22:
        return false;
    }

    public static PendingIntent getErrorPendingIntent(int r100, Context r101, int r102) {
        return GoogleApiAvailabilityLight.getInstance().getErrorResolutionPendingIntent(r101, r100, r102);
    }

    public static boolean uidHasPackageName(Context r100, int r101, String r102) {
        return UidVerifier.uidHasPackageName(r100, r101, r102);
    }
}
