package com.bytedance.sysoptimizer.appcompact;

import android.app.Activity;
import android.view.KeyEvent;
import android.view.Window;

/* JADX INFO: loaded from: classes22.dex */
public class AppCompatFix {
    private static final String TAG = "AppCompactFix";

    public static final class AppCompatSafeWrapper extends WindowCallbackWrapper {
        public AppCompatSafeWrapper(Window.Callback r100) {
            super(r100);
        }

        @Override // com.bytedance.sysoptimizer.appcompact.WindowCallbackWrapper, android.view.Window.Callback
        public boolean dispatchKeyEvent(KeyEvent r100) {
            return super.dispatchKeyEvent(r100);
        L4:
            return false;
        }
    }

    public AppCompatFix() {
    }

    public static boolean applyOnActivity(Activity r100) {
        if (r100 != null) goto L12;
        return false;
    L12:
        Window r101 = r100.getWindow();     // Catch: Throwable -> L11
        Window.Callback r102 = r101.getCallback();     // Catch: Throwable -> L11
        if (r102.getClass().getName().equals("androidx.appcompat.app.AppCompatDelegateImpl$AppCompatWindowCallback") == false) goto L8;
    L8:
        r101.setCallback(new AppCompatSafeWrapper(r102));     // Catch: Throwable -> L11
        return true;
    L11:
        return false;
    }
}
