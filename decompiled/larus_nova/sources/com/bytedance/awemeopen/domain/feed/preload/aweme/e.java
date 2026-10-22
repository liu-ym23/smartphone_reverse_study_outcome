package com.bytedance.awemeopen.domain.feed.preload.aweme;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public final class e extends w34.b<r14.c> {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final e f198344f = null;

    static {
        f198344f = new e();
    }

    public e() {
    }

    @Override // w34.b
    public final void c(String r100, w34.a<r14.c> r101) {
        Intrinsics.checkNotNullParameter(r100, "key");
        Intrinsics.checkNotNullParameter(r101, "value");
        if (Intrinsics.areEqual(r101.f558144a.r().f535653e, Boolean.TRUE) == false) goto L5;
        return;
    L5:
        super.c(r100, r101);
    }
}
