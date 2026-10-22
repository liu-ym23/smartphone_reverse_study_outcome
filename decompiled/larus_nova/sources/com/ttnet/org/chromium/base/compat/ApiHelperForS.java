package com.ttnet.org.chromium.base.compat;

import android.app.ForegroundServiceStartNotAllowedException;
import android.app.Notification;
import android.app.PictureInPictureParams;
import android.app.Service;
import android.content.ClipData;
import android.content.ClipDescription;
import android.content.Context;
import android.os.Bundle;
import android.os.Process;
import android.view.Display;
import android.view.textclassifier.TextClassification;
import android.view.textclassifier.TextLinks;
import android.view.textclassifier.TextSelection;
import com.ttnet.org.chromium.base.ApiCompatibilityUtils;
import com.ttnet.org.chromium.base.ContextUtils;
import com.ttnet.org.chromium.base.Log;

/* JADX INFO: loaded from: classes41.dex */
public final class ApiHelperForS {
    private static final String TAG = "ApiHelperForS";

    private ApiHelperForS() {
    }

    public static int getPendingIntentMutableFlag() {
        return 33554432;
    }

    public static boolean hasBluetoothConnectPermission() {
        if (ApiCompatibilityUtils.checkPermission(ContextUtils.getApplicationContext(), "android.permission.BLUETOOTH_CONNECT", Process.myPid(), Process.myUid()) != 0) goto L5;
        return true;
    L5:
        return false;
    }

    public static TextClassification getTextClassification(TextSelection r100) {
        return r100.getTextClassification();
    }

    public static TextLinks getTextLinks(ClipData.Item r100) {
        return r100.getTextLinks();
    }

    public static boolean isGetClassificationStatusIsComplete(ClipDescription r100) {
        if (r100.getClassificationStatus() != 3) goto L5;
        return true;
    L5:
        return false;
    }

    public static boolean isStyleText(ClipDescription r100) {
        return r100.isStyledText();
    }

    public static float getConfidenceScore(ClipDescription r100, String r101) {
        return r100.getConfidenceScore(r101);
    }

    public static void setAutoEnterEnabled(PictureInPictureParams.Builder r100, boolean r101) {
        r100.setAutoEnterEnabled(r101);
    }

    public static TextSelection.Request.Builder setIncludeTextClassification(TextSelection.Request.Builder r100, boolean r101) {
        return r100.setIncludeTextClassification(r101);
    }

    public static Context createWindowContext(Context r100, Display r101, int r102, Bundle r103) {
        return r100.createWindowContext(r101, r102, r103);
    }

    public static void startForeground(Service r100, int r101, Notification r102, int r103) {
        r100.startForeground(r101, r102, r103);     // Catch: ForegroundServiceStartNotAllowedException -> L4
        return;
    L4:
        e = move-exception;
        Log.e(TAG, "Cannot run service as foreground: " + e + " for notification channel " + r102.getChannelId() + " notification id " + r101, new Object[0]);
    }
}
