package com.bytedance.android.livesdk.link.model.bridge;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class i1 {
    public static final long a(h1 r2) {
        Intrinsics.checkNotNullParameter(r2, "$this$linkerIdExt");
        return r2.getLinkerId();
    }

    public static final long b(h1 r2) {
        Intrinsics.checkNotNullParameter(r2, "$this$sceneExt");
        return r2.getScene();
    }

    public static final long c(h1 r2) {
        Intrinsics.checkNotNullParameter(r2, "$this$typeExt");
        return r2.getType2();
    }
}
