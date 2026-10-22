package com.ss.android.ttve.common;

import com.ss.android.ttve.nativePort.TECodecNativeLibsLoader;

/* JADX INFO: loaded from: classes38.dex */
public class TECloudCtrlInvoker {
    public TECloudCtrlInvoker() {
    }

    private native int nativeVerifyJson(byte[] r100, byte[] r101);

    static {
        TECodecNativeLibsLoader.d();
    }

    public final boolean a(String r100, String r101) {
        if (r100.isEmpty() == false) goto L5;
        return false;
    L5:
        if (r101.isEmpty() == false) goto L8;
        return false;
    L8:
        if (nativeVerifyJson(r100.getBytes(), r101.getBytes()) != 0) goto L12;
        return true;
    L12:
        return false;
    }
}
