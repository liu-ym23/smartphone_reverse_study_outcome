package com.bytedance.livesdk.ktvcommon.download.api;

import com.bytedance.android.ec.model.response.anchorv3.PromotionProductPrivilegesStruct;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes20.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static e f255931a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final f f255932b = null;

    public f() {
    }

    static {
        f255932b = new f();
    }

    public static e a() {
        e r100 = f255931a;
        if (r100 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException(PromotionProductPrivilegesStruct.SERVICES);
    L5:
        return r100;
    }
}
