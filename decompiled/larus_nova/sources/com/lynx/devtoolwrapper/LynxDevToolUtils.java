package com.lynx.devtoolwrapper;

import com.lynx.tasm.INativeLibraryLoader;
import com.lynx.tasm.base.LLog;
import com.lynx.tasm.service.ILynxDevToolService;
import i8a.n;

/* JADX INFO: loaded from: classes32.dex */
public class LynxDevToolUtils {
    private static final ILynxDevToolService DEVTOOL_SERVICE = null;
    private static final String TAG = "LynxDevToolUtils";

    public LynxDevToolUtils() {
    }

    static {
        DEVTOOL_SERVICE = (ILynxDevToolService) n.c().a(ILynxDevToolService.class);
    }

    public static void setDevToolLibraryLoader(INativeLibraryLoader r100) {
        ILynxDevToolService r101 = DEVTOOL_SERVICE;
        if (r101 == null) goto L5;
        r101.devtoolEnvSetDevToolLibraryLoader(r100);
        return;
    L5:
        LLog.e(TAG, "failed to get DevToolService");
    }
}
