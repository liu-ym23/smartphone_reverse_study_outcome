package com.ss.android.download.api.common;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import androidx.core.content.ContextCompat;
import com.ss.android.download.api.config.DownloadPermissionChecker;
import com.ss.android.download.api.config.IPermissionCallback;

/* JADX INFO: loaded from: classes34.dex */
public class DefaultPermissionChecker implements DownloadPermissionChecker {
    private IPermissionCallback mPermissionCallback;

    public DefaultPermissionChecker() {
    }

    @Override // com.ss.android.download.api.config.DownloadPermissionChecker
    public boolean hasPermission(Context r100, String r101) {
        if (r100 != null) goto L5;
        return false;
    L5:
        if (ContextCompat.checkSelfPermission(r100, r101) != 0) goto L9;
        return true;
    L9:
        return false;
    }

    @Override // com.ss.android.download.api.config.DownloadPermissionChecker
    public void requestPermission(Activity r100, String[] r101, IPermissionCallback r102) {
        if (Build.VERSION.SDK_INT < 23) goto L5;
        this.mPermissionCallback = r102;
        r100.requestPermissions(r101, 1);
        return;
    L5:
        if (r102 == null) goto L9;
        r102.onGranted();
        return;
    }

    @Override // com.ss.android.download.api.config.DownloadPermissionChecker
    public void onRequestPermissionsResult(Activity r100, int r101, String[] r102, int[] r103) {
        if (r103.length <= 0) goto L12;
        IPermissionCallback r104 = this.mPermissionCallback;
        if (r104 == null) goto L13;
        int r105 = r103[0];
        if (r105 != (-1)) goto L9;
        r104.onDenied(r102[0]);
        return;
    L9:
        if (r105 != 0) goto L15;
        r104.onGranted();
        return;
    L15:
        return;
    L13:
        return;
    }
}
