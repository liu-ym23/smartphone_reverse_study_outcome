package com.larus.image.loader;

import android.graphics.Bitmap;
import com.bytedance.security.android.aopcheck.PolarisFileOutputStreamWrapper;
import com.facebook.imagepipeline.common.SimplayerImageStrategy;
import com.larus.platform.service.s3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes30.dex */
public final class v {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f350991a = 0;

    static {
    }

    public static boolean a(Bitmap r100, int r101, PolarisFileOutputStreamWrapper r102, Integer r103) {
        Intrinsics.checkNotNullParameter(r100, SimplayerImageStrategy.RESULT_BITMAP);
        Intrinsics.checkNotNullParameter(r102, "outputStream");
        return s3.f365803a.a(r100, r101, r102, r103);
    }
}
