package com.miui.easygo.util;

import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import com.miui.easygo.callback.IEasyGoCallback;

/* JADX INFO: loaded from: classes32.dex */
public final class EasyGoUtil extends FunctionUtil {
    private static final String TAG = "EasyGoUtil";

    public EasyGoUtil() {
    }

    public static int getRomSupStatus(Context r100, String r101) {
        if (DatabaseUtil.isDbSupport(r100) == true) goto L7;
        return 505;
    L7:
        if (FunctionUtil.isLibSupprt(r101) == true) goto L10;
        return 504;
    L10:
        return 0;
    }

    public static void callbackMsg(IEasyGoCallback r100, int r101, Bundle r102) {
        if (r100 == null) goto L8;
        r100.callback(r101, r102);     // Catch: RemoteException -> L5
        return;
    L9:
        return;
    }
}
