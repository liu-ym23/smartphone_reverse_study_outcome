package com.ttnet.org.chromium.base.memory;

import android.os.Debug;
import com.ttnet.org.chromium.base.Log;
import java.io.IOException;

/* JADX INFO: loaded from: classes41.dex */
public final class JavaHeapDumpGenerator {
    private static final String TAG = "JavaHprofGenerator";

    private JavaHeapDumpGenerator() {
    }

    public static boolean generateHprof(String r100) {
        Debug.dumpHprofData(r100);     // Catch: IOException -> L5
        return true;
    L5:
        e = move-exception;
        Log.i(TAG, "Error writing to file " + r100 + ". Error: " + e.getMessage(), new Object[0]);
        return false;
    }
}
