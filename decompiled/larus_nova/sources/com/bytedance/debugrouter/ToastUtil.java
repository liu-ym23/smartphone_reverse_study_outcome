package com.bytedance.debugrouter;

import android.app.Application;
import com.bytedance.debugrouter.report.Utils;
import com.lynx.debugrouter.base.UIThreadUtils;

/* JADX INFO: loaded from: classes15.dex */
public class ToastUtil {
    private static final String TAG = "ToastUtil";

    public ToastUtil() {
    }

    public static void toast(final String r100, final int r101) {
        final Application r102 = Utils.getApplicationContext();
        if (r102 != null) goto L5;
        return;
    L5:
        UIThreadUtils.runOnUiThreadImmediately(new AnonymousClass1(r102, r100, r101));
    }
}
