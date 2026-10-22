package com.bytedance.sysoptimizer;

import android.os.Build;
import android.os.Process;
import android.text.TextUtils;
import com.bytedance.mira.plugin.hook.flipped.Flipped;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes22.dex */
public class ValidateSuperClassDescriptorsOpt {
    private static final String TAG = "ValidateSuperClassDescriptorsOpt";
    private static volatile ICallback sCallback;
    private static final AtomicBoolean sInit = null;

    public interface ICallback {
        int d(String r100, String r101);

        int e(String r100, String r101);

        int e(String r100, String r101, Throwable r102);
    }

    public ValidateSuperClassDescriptorsOpt() {
    }

    private static native int nStart();

    static {
        sInit = new AtomicBoolean(false);
        sCallback = null;
    }

    public static synchronized ICallback getCallback() {
        monitor-enter(ValidateSuperClassDescriptorsOpt.class);
        ICallback r100 = sCallback;     // Catch: Throwable -> L9
        if (r100 != null) goto L7;
        r100 = new AnonymousClass1();     // Catch: Throwable -> L9
        updateCallback(r100);     // Catch: Throwable -> L9
    L7:
        monitor-exit(ValidateSuperClassDescriptorsOpt.class);
        return r100;
    L9:
        th = move-exception;
        throw th;
    }

    public static boolean isEnable() {
        ICallback r100 = getCallback();
        int r101 = Build.VERSION.SDK_INT;
        if (r101 >= 27) goto L5;
    L23:
        r100.e(TAG, "NOT SUPPORT API LEVEL " + r101);
        return false;
    L5:
        if (r101 > 34) goto L23;
        if (Process.is64Bit() == true) goto L11;
        r100.e(TAG, "NOT SUPPORT 32Bit");
        return false;
    L11:
        String[] r102 = Build.SUPPORTED_ABIS;
        int r103 = r102.length;
        int r104 = 0;
    L12:
        if (r104 >= r103) goto L21;
        String r105 = r102[r104];
        if (TextUtils.isEmpty(r105) == true) goto L20;
        if (r105.startsWith("x86") == false) goto L20;
        r100.e(TAG, "ONLY SUPPORT arm64-v8a.But current are " + TextUtils.join(",", Build.SUPPORTED_ABIS));
        return false;
    L20:
        r104 = r104 + 1;
        goto L12
    L21:
        return true;
    }

    private static synchronized void updateCallback(ICallback r100) {
        monitor-enter(ValidateSuperClassDescriptorsOpt.class);
        sCallback = r100;     // Catch: Throwable -> L7
        monitor-exit(ValidateSuperClassDescriptorsOpt.class);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public static void start(boolean r100, boolean r101, ICallback r102) {
        if (sInit.getAndSet(true) == false) goto L7;
        getCallback().e(TAG, "Already init");
        return;
    L7:
        if (isEnable() == true) goto L9;
        return;
    L9:
        updateCallback(r102);
        if (r100 == false) goto L12;
        LogVerbosityUtil.open();
    L12:
        if (r101 == false) goto L15;
        Flipped.invokeHiddenApiRestrictions();
    L15:
        if (SysOptimizer.loadOptimizerLibrary(null) == false) goto L18;
        nStart();
        return;
    }
}
