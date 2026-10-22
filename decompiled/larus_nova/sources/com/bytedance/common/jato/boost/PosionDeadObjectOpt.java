package com.bytedance.common.jato.boost;

import android.os.Build;
import com.bytedance.common.jato.JatoNativeLoader;

/* JADX INFO: loaded from: classes3.dex */
public class PosionDeadObjectOpt {
    private static volatile boolean sBypassPoisonDeadObjectsInited;

    public PosionDeadObjectOpt() {
    }

    private static native int nBypassPoisonDeadObjects();

    public static int bypassPoisonDeadObjects() {
        int r100 = Build.VERSION.SDK_INT;
        int r101 = -1;
        if (r100 >= 29) goto L5;
        return -1;
    L5:
        if (r100 <= 33) goto L8;
        return -1;
    L8:
        if (sBypassPoisonDeadObjectsInited == false) goto L17;
        return -1;
    L17:
        r101 = nBypassPoisonDeadObjects();     // Catch: NoSuchMethodError -> L12 UnsatisfiedLinkError -> L14
        sBypassPoisonDeadObjectsInited = true;     // Catch: NoSuchMethodError -> L12 UnsatisfiedLinkError -> L14
    L22:
        return r101;
    L12:
        e = move-exception;
        e.printStackTrace();
        return r101;
    L14:
        e = move-exception;
        e.printStackTrace();
        return r101;
    }

    static {
        JatoNativeLoader.loadLibrary();
    }
}
