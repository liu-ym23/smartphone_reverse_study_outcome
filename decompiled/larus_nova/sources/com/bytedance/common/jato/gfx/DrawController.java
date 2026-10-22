package com.bytedance.common.jato.gfx;

import android.view.MotionEvent;
import androidx.appcompat.view.WindowCallbackWrapper;

/* JADX INFO: loaded from: classes15.dex */
public class DrawController {
    private static int inputThreshold = 3000;
    private static long lastInputTime;

    public static class CallbackWapper extends WindowCallbackWrapper {
        @Override // androidx.appcompat.view.WindowCallbackWrapper, android.view.Window.Callback
        public boolean dispatchTouchEvent(MotionEvent r100) {
            long r101 = System.currentTimeMillis();
            if ((r101 - DrawController.access$700()) <= DrawController.access$800()) goto L8;
            DrawController.access$702(r101);
            if (r100.getAction() != 0) goto L8;
            DrawController.access$900();
        L8:
            return super.dispatchTouchEvent(r100);
        }
    }

    public interface InputCallBack {
    }

    public static /* synthetic */ InputCallBack access$900() {
        return null;
    }

    public static /* synthetic */ long access$700() {
        return lastInputTime;
    }

    public static /* synthetic */ int access$800() {
        return inputThreshold;
    }

    public static /* synthetic */ long access$702(long r100) {
        lastInputTime = r100;
        return r100;
    }
}
