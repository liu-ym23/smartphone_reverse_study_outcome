package com.ss.android.common.app.permission;

import android.app.Activity;
import androidx.core.app.ActivityCompat;

/* JADX INFO: loaded from: classes34.dex */
public final class a {

    /* JADX INFO: renamed from: com.ss.android.common.app.permission.a$a, reason: collision with other inner class name */
    public interface InterfaceC4721a {
        void a();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void requestPermissions(Activity r100, String[] r101, int r102) {
        if ((r100 instanceof InterfaceC4721a) == false) goto L6;
        ((InterfaceC4721a) r100).a();
    L8:
        r100.requestPermissions(r101, r102);
        return;
    L6:
        if ((r100 instanceof ActivityCompat.RequestPermissionsRequestCodeValidator) == false) goto L8;
        ((ActivityCompat.RequestPermissionsRequestCodeValidator) r100).validateRequestPermissionsRequestCode(r102);
        goto L8
    }
}
