package com.lark.kmp.rustclient;

import com.lark.kmp.logger.LarkLogger;
import com.lark.kmp.rustclient.api.model.c;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes24.dex */
public final class a {
    public static void a(c r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "message");
        Intrinsics.checkNotNullParameter("RustClient", "tag");
        StringBuilder r102 = new StringBuilder("[rust_client]");
        if (r100.f282468d == null) goto L5;
        r102.append("[server_command:" + r100.f282468d.getValue() + ']');
    L6:
        r102.append("[context_id:" + r100.f282466b + ']');
        r102.append(r101);
        LarkLogger r103 = LarkLogger.f278603a;
        LarkLogger.c("RustClient", r102.toString());
        return;
    L5:
        r102.append("[command:" + r100.a().getValue() + ']');
        goto L6
    }
}
