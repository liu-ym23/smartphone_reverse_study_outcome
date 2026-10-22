package com.bytedance.salamander.anniex;

import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes20.dex */
public class i extends f {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public j f268103i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public i0 f268104j;

    public final j b() {
        j r100 = this.f268103i;
        if (r100 == null) goto L5;
        return r100;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("commonUISchema");
        return null;
    }

    public i(String r110, String r111, String r112, String r113, Map<String, Object> r114, j r115, i0 r116, t0 r117, g0 r210) {
        Intrinsics.checkNotNullParameter(r110, "schema");
        Intrinsics.checkNotNullParameter(r111, "sessionId");
        Intrinsics.checkNotNullParameter(r112, "containerId");
        Intrinsics.checkNotNullParameter(r113, "bid");
        Intrinsics.checkNotNullParameter(r114, "globalProps");
        Intrinsics.checkNotNullParameter(r115, "commonUISchema");
        Intrinsics.checkNotNullParameter(r116, "navBarModel");
        Intrinsics.checkNotNullParameter(r117, "platformContext");
        Intrinsics.checkNotNullParameter(r210, "lynxProps");
        super(r110, r111, r112, r113, r114, r117, r210);
        Intrinsics.checkNotNullParameter(r115, "<set-?>");
        this.f268103i = r115;
        Intrinsics.checkNotNullParameter(r116, "<set-?>");
        this.f268104j = r116;
    }
}
