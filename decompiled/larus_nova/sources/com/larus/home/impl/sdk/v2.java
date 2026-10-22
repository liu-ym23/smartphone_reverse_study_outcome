package com.larus.home.impl.sdk;

import android.graphics.Bitmap;
import com.bytedance.security.android.aopcheck.PolarisFileOutputStreamWrapper;
import com.facebook.imagepipeline.common.SimplayerImageStrategy;
import com.facebook.webpsupport.WebPEncoder;
import com.larus.platform.api.d4;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes29.dex */
public final class v2 implements d4 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final v2 f346254a = null;

    static {
        f346254a = new v2();
    }

    public v2() {
    }

    @Override // com.larus.platform.api.d4
    public final boolean a(Bitmap r100, int r101, PolarisFileOutputStreamWrapper r102, Integer r103) {
        Intrinsics.checkNotNullParameter(r100, SimplayerImageStrategy.RESULT_BITMAP);
        Intrinsics.checkNotNullParameter(r102, "outputStream");
        if (r103 == null) goto L5;
        int r104 = r103.intValue();
    L7:
        return WebPEncoder.encodeBitmapToWebPWithSpeed(r100, r101, r104, r102);
    L5:
        r104 = 3;
        goto L7
    }
}
