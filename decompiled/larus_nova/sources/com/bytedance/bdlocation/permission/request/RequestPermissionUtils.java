package com.bytedance.bdlocation.permission.request;

import android.app.Activity;
import android.content.Context;
import androidx.core.content.ContextCompat;
import com.bytedance.permissions.annotation.PermissionsRequest;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes10.dex */
public class RequestPermissionUtils {

    public interface OnPermissionListener {
        void onPermissionDenied();

        void onPermissionGranted();
    }

    public RequestPermissionUtils() {
    }

    public static /* synthetic */ boolean access$000(int[] r100) {
        return verifyPermissions(r100);
    }

    private static boolean verifyPermissions(int[] r100) {
        int r101 = r100.length;
        int r102 = 0;
    L3:
        if (r102 >= r101) goto L8;
        if (r100[r102] != 0) goto L6;
        r102 = r102 + 1;
        goto L3
    L6:
        return false;
    L8:
        return true;
    }

    private static List<String> getDeniedPermissions(Context r100, String... r101) {
        if (r100 != null) goto L5;
        return null;
    L5:
        ArrayList r102 = new ArrayList();
        int r103 = r101.length;
        int r104 = 0;
    L6:
        if (r104 >= r103) goto L11;
        String r105 = r101[r104];
        if (ContextCompat.checkSelfPermission(r100, r105) != (-1)) goto L10;
        r102.add(r105);
    L10:
        r104 = r104 + 1;
        goto L6
    L11:
        return r102;
    }

    @PermissionsRequest(forceAllPermissionsRequest = false, scene = "bdlocation_RequestPermissionUtils")
    public static void requestPermissionsLimited(Activity r100, String[] r101, final OnPermissionListener r102) {
        if (r100 == null) goto L11;
        List<String> r103 = getDeniedPermissions(r100, r101);
        if (r103 != null) goto L6;
    L8:
        if (r102 == null) goto L13;
        r102.onPermissionGranted();
        return;
    L13:
        return;
    L6:
        if (r103.isEmpty() == true) goto L8;
        Permissions.requestPermissions(r100, r101, new AnonymousClass1(r102));
        return;
    }
}
