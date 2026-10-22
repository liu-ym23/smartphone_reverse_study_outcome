package com.bytedance.android.livesdk.livecommerce.utils;

import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class j0 {
    public static final /* synthetic */ int a = 0;

    public j0() {
    }

    static {
    }

    public static Object a(String r4, Continuation r5) {
        return BuildersKt.withContext(Dispatchers.getIO(), new FileUtils$base64ToByteArray$2(r4, 0, null), r5);
    }

    public static Object b(PolarisFileWrapper r3, Continuation r4) {
        return BuildersKt.withContext(Dispatchers.getIO(), new FileUtils$encodeFileToBase64$2(r3, null), r4);
    }
}
