package com.bytedance.lark.rustclient.internal;

import com.ss.android.lark.log.Log;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes20.dex */
public final class z {
    public static void a(com.bytedance.lark.rustclient.api.d r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "message");
        Intrinsics.checkNotNullParameter("RustClient", "tag");
        StringBuilder r102 = new StringBuilder("[rust_client]");
        if (r100.f253896e == null) goto L5;
        r102.append("[server_command:" + r100.f253896e.getName() + ']');
    L6:
        r102.append("[context_id:" + r100.f253893b + ']');
        r102.append(r101);
        Log.i("RustClient", r102.toString());
        return;
    L5:
        r102.append("[command:" + r100.a().getName() + ']');
        goto L6
    }
}
