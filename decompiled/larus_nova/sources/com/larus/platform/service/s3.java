package com.larus.platform.service;

import android.graphics.Bitmap;
import android.os.Build;
import com.bytedance.security.android.aopcheck.PolarisFileOutputStreamWrapper;
import com.facebook.imagepipeline.common.SimplayerImageStrategy;
import com.larus.platform.api.d4;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes31.dex */
public final class s3 implements d4 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final s3 f365803a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Lazy f365804b = null;

    public s3() {
    }

    static {
        f365803a = new s3();
        f365804b = LazyKt.lazy(new r3());
    }

    @Override // com.larus.platform.api.d4
    public final boolean a(Bitmap r100, int r101, PolarisFileOutputStreamWrapper r102, Integer r103) {
        Intrinsics.checkNotNullParameter(r100, SimplayerImageStrategy.RESULT_BITMAP);
        Intrinsics.checkNotNullParameter(r102, "outputStream");
        d4 r104 = (d4) f365804b.getValue();
        if (r104 == null) goto L7;
        return r104.a(r100, r101, r102, r103);
    L7:
        if (Build.VERSION.SDK_INT < 30) goto L9;
        Bitmap.CompressFormat r105 = Bitmap.CompressFormat.WEBP_LOSSY;
    L11:
        return r100.compress(r105, r101, r102);
    L9:
        r105 = Bitmap.CompressFormat.WEBP;
        goto L11
    }
}
