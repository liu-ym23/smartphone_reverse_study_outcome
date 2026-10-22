package com.bytedance.sysoptimizer.java;

import android.content.Context;
import android.os.Build;
import java.util.Collections;

/* JADX INFO: loaded from: classes22.dex */
public class IAutofillManagerProtector {
    private static boolean sIsInit;

    public IAutofillManagerProtector() {
    }

    public static void install(Context r100) {
        if (Build.VERSION.SDK_INT < 26) goto L11;
        if (r100 != null) goto L7;
        return;
    L7:
        if (sIsInit == false) goto L9;
        return;
    L9:
        sIsInit = BinderServiceWrapperProtector.install(r100, "autofill", Collections.singletonList("startSession"), "IAMP", BinderServiceWrapperProtector.VOID_ADMIN_RESULT);
        return;
    }
}
