package com.bytedance.ies.bullet.core.kit.bridge;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public final class d {
    public static final <INPUT, OUTPUT> void a(i<INPUT, OUTPUT> r100, Object r101, i.a<?> r102) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "params");
        Intrinsics.checkNotNullParameter(r102, "callback");
        if (r102 == null) goto L6;
        r100.yV();
        r100.CC();
        return;
    }
}
