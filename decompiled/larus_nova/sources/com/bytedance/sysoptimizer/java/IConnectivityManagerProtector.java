package com.bytedance.sysoptimizer.java;

import android.content.Context;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: loaded from: classes22.dex */
public class IConnectivityManagerProtector {
    private static final List<String> PROTECTED_METHODS = null;
    private static boolean sIsInit;

    public IConnectivityManagerProtector() {
    }

    static {
        PROTECTED_METHODS = Arrays.asList(new String[]{"getNetworkCapabilities", "getAllNetworks", "getLinkProperties", "getLinkPropertiesForType"});
    }

    public static void install(Context r100) {
        if (sIsInit == true) goto L8;
        if (r100 == null) goto L9;
        sIsInit = BinderServiceWrapperProtector.install(r100.getApplicationContext(), "connectivity", PROTECTED_METHODS, "ICMP", new AnonymousClass1());
        return;
    L9:
        return;
    }
}
