package com.bytedance.android.livesdk.livecommerce.utils;

import android.graphics.Bitmap;
import com.bytedance.security.android.aopcheck.PolarisFileOutputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import java.io.FileNotFoundException;
import java.io.IOException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class g0 {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static void a(String r2, Bitmap r3) {
        Intrinsics.checkNotNullParameter(r2, "path");
        Intrinsics.checkNotNullParameter(r3, "bitmap");
        PolarisFileWrapper r0 = new PolarisFileWrapper(r2);
        r0.getPath();     // Catch: IOException -> L5 FileNotFoundException -> L7
        PolarisFileOutputStreamWrapper r4 = new PolarisFileOutputStreamWrapper(r0);     // Catch: IOException -> L5 FileNotFoundException -> L7
        r3.compress(Bitmap.CompressFormat.JPEG, 80, r4);     // Catch: IOException -> L5 FileNotFoundException -> L7
        r4.flush();     // Catch: IOException -> L5 FileNotFoundException -> L7
        r4.close();     // Catch: IOException -> L5 FileNotFoundException -> L7
    L13:
        return;
    L7:
        e = move-exception;
        e.printStackTrace();
        return;
    L5:
        e = move-exception;
        e.printStackTrace();
    }
}
