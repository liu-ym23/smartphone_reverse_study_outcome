package com.larus.avlink.gallery;

import android.os.Build;
import androidx.core.content.ContextCompat;
import com.larus.common.apphost.AppHost;

/* JADX INFO: loaded from: classes25.dex */
public final class g {
    static {
    }

    public static boolean a() {
        AppHost.Companion r100 = AppHost.f326268a;
        if (ContextCompat.checkSelfPermission(r100.getApplication(), "android.permission.ACCESS_FINE_LOCATION") != 0) goto L5;
        boolean r101 = true;
    L6:
        if (r101 == true) goto L9;
        return false;
    L9:
        if (Build.VERSION.SDK_INT >= 29) goto L11;
        return true;
    L11:
        if (ContextCompat.checkSelfPermission(r100.getApplication(), "android.permission.ACCESS_BACKGROUND_LOCATION") == 0) goto L16;
        return false;
    L16:
        return true;
    L5:
        r101 = false;
        goto L6
    }
}
