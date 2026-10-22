package com.ttnet.org.chromium.base.compat;

import android.app.Activity;
import android.app.Notification;
import android.app.job.JobInfo;
import android.app.job.JobScheduler;
import android.content.ClipData;
import android.content.ComponentName;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.media.MediaCodec;
import android.net.ConnectivityManager;
import android.os.Process;
import android.security.NetworkSecurityPolicy;
import android.view.MotionEvent;
import android.view.PointerIcon;
import android.view.View;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.RemoteViews;

/* JADX INFO: loaded from: classes41.dex */
public final class ApiHelperForN {
    private ApiHelperForN() {
    }

    public static long getStartUptimeMillis() {
        return Process.getStartUptimeMillis();
    }

    public static int getRestrictBackgroundStatus(ConnectivityManager r100) {
        return r100.getRestrictBackgroundStatus();
    }

    public static boolean isCleartextTrafficPermitted(String r100) {
        return NetworkSecurityPolicy.getInstance().isCleartextTrafficPermitted(r100);
    }

    public static JobInfo getPendingJob(JobScheduler r100, int r101) {
        return r100.getPendingJob(r101);
    }

    public static Notification.Builder setCustomBigContentView(Notification.Builder r100, RemoteViews r101) {
        return r100.setCustomBigContentView(r101);
    }

    public static Notification.Builder setCustomContentView(Notification.Builder r100, RemoteViews r101) {
        return r100.setCustomContentView(r101);
    }

    public static void setPointerIcon(View r100, PointerIcon r101) {
        r100.setPointerIcon(r101);
    }

    public static PointerIcon createPointerIcon(Bitmap r100, float r101, float r102) {
        return PointerIcon.create(r100, r101, r102);
    }

    public static PointerIcon onResolvePointerIcon(View r100, MotionEvent r101, int r102) {
        return r100.onResolvePointerIcon(r101, r102);
    }

    public static void setCryptoInfoPattern(MediaCodec.CryptoInfo r100, int r101, int r102) {
        r100.setPattern(new MediaCodec.CryptoInfo.Pattern(r101, r102));
    }

    public static void setVrModeEnabled(Activity r100, boolean r101, ComponentName r102) throws PackageManager.NameNotFoundException {
        r100.setVrModeEnabled(r101, r102);
    }

    public static boolean shouldOverrideUrlLoading(WebViewClient r100, WebView r101, WebResourceRequest r102) {
        return r100.shouldOverrideUrlLoading(r101, r102);
    }

    public static boolean startDragAndDrop(View r100, ClipData r101, View.DragShadowBuilder r102, Object r103, int r104) {
        return r100.startDragAndDrop(r101, r102, r103, r104);
    }
}
