package com.bytedance.anniex.bd.foundation.impl;

import com.bytedance.crash.AttachUserData;
import com.bytedance.crash.CrashType;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class j implements AttachUserData {
    public final Map<String, String> a;

    public j(Map<String, String> r2) {
        Intrinsics.checkNotNullParameter(r2, "data");
        this.a = r2;
    }

    public final Map<String, String> getUserData(CrashType r1) {
        Map<String, String> r2 = this.a;
        if (r2 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("data");
        return null;
    L6:
        return r2;
    }
}
