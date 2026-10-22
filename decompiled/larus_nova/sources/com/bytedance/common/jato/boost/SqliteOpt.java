package com.bytedance.common.jato.boost;

import android.os.Process;
import com.bytedance.common.jato.JatoNativeLoader;

/* JADX INFO: loaded from: classes15.dex */
public class SqliteOpt {
    public SqliteOpt() {
    }

    private static native void unixFileControlOptInternal();

    public static void unixFileControlOpt() {
        if (Process.is64Bit() == true) goto L5;
        return;
    L5:
        unixFileControlOptInternal();
    }

    static {
        JatoNativeLoader.loadLibrary();
    }
}
