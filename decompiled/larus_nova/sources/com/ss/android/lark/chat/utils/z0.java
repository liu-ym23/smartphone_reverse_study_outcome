package com.ss.android.lark.chat.utils;

import android.app.Application;
import com.larksuite.component.ui.toast.LKUIToast;
import com.larksuite.framework.utils.DevEnvUtil;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.utils.LarkContext;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.util.Arrays;
import kotlin.jvm.JvmStatic;

/* JADX INFO: loaded from: classes35.dex */
public final class z0 {
    static {
    }

    @JvmStatic
    public static final void a() {
        Application r100 = LarkContext.getApplication();
        if (DevEnvUtil.isDebugMode(r100) == true) goto L5;
        return;
    L5:
        if (se6.u.a() == false) goto L9;
        StackTraceElement[] r101 = ThreadMethodProxy.currentThread().getStackTrace();
        LKUIToast.show(r100, "Find sync method call in main thread\n " + ((StackTraceElement[]) Arrays.copyOf(r101, r101.length))[3].getMethodName() + " \n  See more detail in Log...");
        Log.w("SDKSendUtils", new Exception());
        return;
    }
}
