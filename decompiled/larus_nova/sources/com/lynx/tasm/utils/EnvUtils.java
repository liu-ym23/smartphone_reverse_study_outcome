package com.lynx.tasm.utils;

import android.content.Context;
import com.lynx.tasm.LynxEnv;

/* JADX INFO: loaded from: classes32.dex */
public class EnvUtils {
    public EnvUtils() {
    }

    public static String getCacheDir() {
        Context r100 = LynxEnv.inst().getAppContext();
        if (r100 != null) goto L5;
        return "";
    L5:
        return r100.getCacheDir().getAbsolutePath();
    }
}
