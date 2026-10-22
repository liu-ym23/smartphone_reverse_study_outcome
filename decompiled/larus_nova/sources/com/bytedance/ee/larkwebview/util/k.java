package com.bytedance.ee.larkwebview.util;

import android.os.Build;
import com.ss.android.lark.log.Log;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes19.dex */
public final class k {
    public static Method a(Class<?> r100, String r101, Class... r102) {
    L8:
        th = move-exception;
        Log.e("WebViewPackageNotFound", th.getMessage() + ", getDeclaredMethodNew fail");
        return null;
    L3:
        if (Build.VERSION.SDK_INT >= 28) goto L7;
        return r100.getDeclaredMethod(r101, new Class[0]);
    L7:
        return (Method) Class.class.getDeclaredMethod("getDeclaredMethod", new Class[]{String.class, Class[].class}).invoke(r100, new Object[]{r101, r102});
    }
}
