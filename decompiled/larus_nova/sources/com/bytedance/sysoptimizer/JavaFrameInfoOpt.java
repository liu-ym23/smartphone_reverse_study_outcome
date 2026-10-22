package com.bytedance.sysoptimizer;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Process;
import com.bytedance.shadowhook.ShadowHook;

/* JADX INFO: loaded from: classes22.dex */
public class JavaFrameInfoOpt {
    private static final String TAG = "JavaFrameInfoOpt";
    private static volatile boolean sInit;

    public static class ExceptionInfo {
        public String msg;
        public String type;

        public ExceptionInfo(String r100, String r101) {
            this.type = r100;
            this.msg = r101;
        }
    }

    public JavaFrameInfoOpt() {
    }

    private static native int nStart(ExceptionInfo[] r100, boolean r101, boolean r102, boolean r103, int r104);

    private static void mockCrash(boolean r100) {
        if (r100 == false) goto L5;
        new Handler(Looper.getMainLooper()).postDelayed(new AnonymousClass1(), 1000);
        return;
    }

    public static int start(Context r100, ExceptionInfo[] r101, boolean r102, boolean r103, boolean r104, boolean r105, int r106) {
        if (Process.is64Bit() == true) goto L7;
        System.out.println("JavaFrameInfoOpt only support 64 bits");
        return 0;
    L7:
        if (sInit == false) goto L10;
        return 1;
    L10:
        if (SysOptimizer.loadOptimizerLibrary(r100) == true) goto L12;
        return -1;
    L12:
        if (sInit == true) goto L17;
        ShadowHook.access$000();
        ShadowHook.access$100();
        int r107 = ShadowHook.Mode.SHARED.getValue();
        ShadowHook.b r108 = new ShadowHook.b();
        r108.f270294a = r107;
        r108.f270295b = true;
        r108.f270296c = false;
        r108.f270297d = false;
        ShadowHook.init(r108);
        int r109 = nStart(r101, r102, r103, r104, r106);
        sInit = true;
        mockCrash(r105);
        return r109;
    L17:
        return -1;
    }
}
