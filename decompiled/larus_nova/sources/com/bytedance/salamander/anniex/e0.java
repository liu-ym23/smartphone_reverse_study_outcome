package com.bytedance.salamander.anniex;

import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes20.dex */
public final class e0 extends n {
    public e0(String r100, Map<String, Object> r101, t0 r102) {
        Intrinsics.checkNotNullParameter(r100, "schema");
        Intrinsics.checkNotNullParameter(r101, "globalProps");
        Intrinsics.checkNotNullParameter(r102, "platformContext");
        super(r100, r101, r102);
        AnnieXLynxSizeMode r103 = AnnieXLynxSizeMode.undefined;
    }
}
