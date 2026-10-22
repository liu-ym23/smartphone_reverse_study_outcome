package com.ss.android.download.api.config;

import android.app.Activity;
import android.content.Context;

/* JADX INFO: loaded from: classes34.dex */
public interface DownloadPermissionChecker {
    boolean hasPermission(Context r100, String r101);

    void onRequestPermissionsResult(Activity r100, int r101, String[] r102, int[] r103);

    void requestPermission(Activity r100, String[] r101, IPermissionCallback r102);
}
