package com.larus.platform.exp;

import com.larus.im.FlowRuntime;
import com.larus.platform.IFlowSdkDepend;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class o {
    static {
    }

    public static boolean a() {
        return FlowRuntime.a().n();
    }

    public static boolean b(String r110) {
        Intrinsics.checkNotNullParameter(r110, "source");
        if (a() == true) goto L5;
        return false;
    L5:
        IFlowSdkDepend r100 = (IFlowSdkDepend) ServiceManager.get().getService(IFlowSdkDepend.class);
        if (r100 == null) goto L15;
        r100.r();
        if (mc9.a.f513246a.h() == false) goto L10;
        return false;
    L10:
        FLogger r101 = FLogger.f375446a;
        r101.d("MainConversationDowngrade", "main conversation request bypassed, source=".concat(r110));
        if (FlowRuntime.a().isDebug() == false) goto L16;
        r101.d("MainConversationDowngrade", "main conversation request call stack: " + ArraysKt.joinToString$default(new RuntimeException().getStackTrace(), "\n", null, null, 0, null, null, 62, null));
        return true;
    L16:
        return true;
    L15:
        return false;
    }
}
