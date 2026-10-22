package com.bytedance.android.livesdk.livecommerce.room.controller;

import com.bytedance.android.ec.sdk.helper.ECAppInfoService;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class d {
    public static final /* synthetic */ int a = 0;

    public d() {
    }

    static {
    }

    public static void a(String r1) {
        Intrinsics.checkNotNullParameter(r1, "msg");
        b(null);
    }

    public static void b(String r9) {
        if (ECAppInfoService.e.isDebug() == true) goto L7;
        return;
    L7:
        if (r9 != null) goto L9;
    L12:
        boolean r10 = true;
    L13:
        if (r10 == false) goto L18;
        StackTraceElement[] r11 = ThreadMethodProxy.currentThread().getStackTrace();
        if (r11.length < 5) goto L19;
        List r1 = StringsKt.split$default(r11[5].getClassName(), new String[]{"."}, false, 0, 6, null);
        String r0 = (String) ListProtector.get(r1, r1.size() - 1);
        r11[5].getMethodName();
        return;
    L19:
        return;
    L18:
        return;
    L9:
        if (StringsKt.isBlank(r9) == true) goto L12;
        r10 = false;
        goto L13
    }
}
