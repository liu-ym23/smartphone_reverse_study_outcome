package com.lynx.canvas;

import com.lynx.tasm.LynxView;
import com.lynx.tasm.base.LLog;
import com.lynx.tasm.behavior.LynxContext;
import com.lynx.tasm.behavior.ui.krypton.LynxKryptonHelper;
import com.lynx.tasm.behavior.ui.krypton.LynxKryptonModule;

/* JADX INFO: loaded from: classes32.dex */
public class LynxKryptonUtils {
    private static final String TAG = "LynxKryptonUtils";

    public LynxKryptonUtils() {
    }

    public static LynxKryptonHelper getLynxKryptonHelper(LynxView r100) {
        LynxContext r101 = r100.getLynxContext();
        if (r101 != null) goto L6;
        LLog.e(TAG, "context is null");
        return null;
    L6:
        LynxKryptonModule r102 = (LynxKryptonModule) r101.getExtensionModuleByKey(LynxKryptonModule.TAG);
        if (r102 != null) goto L11;
        LLog.e(TAG, "krypton module is null");
        return null;
    L11:
        return r102.getLynxKryptonHelper();
    }
}
