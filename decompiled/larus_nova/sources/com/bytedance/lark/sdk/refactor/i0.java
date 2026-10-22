package com.bytedance.lark.sdk.refactor;

import com.ss.android.lark.log.Log;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes20.dex */
public final class i0 {
    public static void a(se6.f r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "message");
        Intrinsics.checkNotNullParameter("RustSDK", "tag");
        StringBuilder r102 = new StringBuilder("[rust_wrapper]");
        r102.append("[command:" + r100.f541569c.getName() + ']');
        r102.append("[context_id:" + r100.f541570d + ']');
        r102.append(r101);
        Log.i("RustSDK", r102.toString());
    }
}
