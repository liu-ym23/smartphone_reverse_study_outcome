package com.ttnet.org.chromium.base.compat;

import android.app.Activity;
import android.app.AlarmManager;
import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Icon;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkInfo;
import android.os.BatteryManager;
import android.os.PowerManager;
import android.os.Process;
import android.os.UserManager;
import android.security.NetworkSecurityPolicy;
import android.view.ActionMode;
import android.view.Display;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.bytedance.helios.statichook.config.ApiHookConfig;
import f06.b;
import f06.d;
import g06.a;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes5.dex */
public final class ApiHelperForM {
    private ApiHelperForM() {
    }

    public static int getPendingIntentImmutableFlag() {
        return 67108864;
    }

    public static void setAlarmManagerExactAndAllowWhileIdle(AlarmManager r100, int r101, long r102, PendingIntent r103) {
    }

    public static long getDefaultActionModeHideDuration() {
        return ViewConfiguration.getDefaultActionModeHideDuration();
    }

    public static boolean isCleartextTrafficPermitted() {
        return NetworkSecurityPolicy.getInstance().isCleartextTrafficPermitted();
    }

    public static boolean isProcess64Bit() {
        return Process.is64Bit();
    }

    public static Icon createIconWithBitmap(Bitmap r100) {
        return Icon.createWithBitmap(r100);
    }

    public static int getActionButton(MotionEvent r100) {
        return r100.getActionButton();
    }

    public static int getActionModeType(ActionMode r100) {
        return r100.getType();
    }

    public static Network getActiveNetwork(ConnectivityManager r100) {
        return r100.getActiveNetwork();
    }

    public static Network getBoundNetworkForProcess(ConnectivityManager r100) {
        return r100.getBoundNetworkForProcess();
    }

    public static Display.Mode getDisplayMode(Display r100) {
        return r100.getMode();
    }

    public static Display.Mode[] getDisplaySupportedModes(Display r100) {
        return r100.getSupportedModes();
    }

    public static int getModePhysicalHeight(Display.Mode r100) {
        return r100.getPhysicalHeight();
    }

    public static int getModePhysicalWidth(Display.Mode r100) {
        return r100.getPhysicalWidth();
    }

    public static long getNetworkHandle(Network r100) {
        if (r100 != null) goto L6;
        return 0;
    L6:
        return r100.getNetworkHandle();
    }

    public static void invalidateContentRectOnActionMode(ActionMode r100) {
        r100.invalidateContentRect();
    }

    public static boolean isCharging(BatteryManager r100) {
        return r100.isCharging();
    }

    public static boolean isDeviceIdleMode(PowerManager r100) {
        return r100.isDeviceIdleMode();
    }

    public static boolean isSystemUser(UserManager r100) {
        return r100.isSystemUser();
    }

    private static boolean com_ttnet_org_chromium_base_compat_ApiHelperForM_android_app_Activity_shouldShowRequestPermissionRationale(Activity r110, String r111) {
        ArrayList r100 = new ArrayList();
        Object[] r101 = {r111};
        b r112 = new b("auto_cert_com_ttnet_org_chromium_base_compat_ApiHelperForM_android_app_Activity_shouldShowRequestPermissionRationale");
        a r102 = ApiHookConfig.f245611b.get(102609);
        if (r102 == null) goto L5;
        f06.a[] r103 = r102.f479473i;
    L6:
        f06.a[] r113 = r103;
        int r104 = r113.length;
        int r105 = 0;
    L8:
        if (r105 >= r104) goto L15;
        f06.a r106 = r113[r105];
        int r114 = r105;
        int r115 = r104;
        d r107 = r106.preInvoke(102609, "android/app/Activity", "shouldShowRequestPermissionRationale", r110, r101, "boolean", r112);     // Catch: Exception -> L22
        if (r107.f474982a == true) goto L17;
        r100.add(r106);     // Catch: Exception -> L22
    L17:
        if (r107.f474982a == false) goto L21;
        return ((Boolean) r107.f474983b).booleanValue();
    L21:
        return r110.shouldShowRequestPermissionRationale(r111);
    L14:
        r105 = r114 + 1;
        r104 = r115;
        goto L8
    L15:
        r107 = new d(false, null);
        goto L17
    L5:
        r103 = ApiHookConfig.f245613d;
        goto L6
    }

    public static Icon createIconWithResource(Context r100, int r101) {
        return Icon.createWithResource(r100, r101);
    }

    public static NetworkInfo getNetworkInfo(ConnectivityManager r100, Network r101) {
        return r100.getNetworkInfo(r101);
    }

    public static <T> T getSystemService(Context r100, Class<T> r101) {
        return (T) r100.getSystemService(r101);
    }

    public static void hideActionMode(ActionMode r100, long r101) {
        r100.hide(r101);
    }

    public static boolean isPermissionRevokedByPolicy(Activity r100, String r101) {
        return r100.getPackageManager().isPermissionRevokedByPolicy(r101, r100.getPackageName());
    }

    public static void onWindowFocusChangedOnActionMode(ActionMode r100, boolean r101) {
        r100.onWindowFocusChanged(r101);
    }

    public static Notification.Builder setSmallIcon(Notification.Builder r100, Icon r101) {
        return r100.setSmallIcon(r101);
    }

    public static boolean shouldShowRequestPermissionRationale(Activity r100, String r101) {
        return com_ttnet_org_chromium_base_compat_ApiHelperForM_android_app_Activity_shouldShowRequestPermissionRationale(r100, r101);
    }

    public static Notification.Action.Builder newNotificationActionBuilder(Icon r100, CharSequence r101, PendingIntent r102) {
        return new Notification.Action.Builder(r100, r101, r102);
    }

    public static void onPageCommitVisible(WebViewClient r100, WebView r101, String r102) {
        r100.onPageCommitVisible(r101, r102);
    }

    public static void reportNetworkConnectivity(ConnectivityManager r100, Network r101, boolean r102) {
        r100.reportNetworkConnectivity(r101, r102);
    }

    public static void requestActivityPermissions(Activity r100, String[] r101, int r102) {
        r100.requestPermissions(r101, r102);
    }
}
