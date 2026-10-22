package com.bytedance.live.dynamicresource;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final th6.c f255105a;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public th6.c f255106a;

        public a() {
        }
    }

    public b(a r100) {
        Intrinsics.checkNotNullParameter(r100, "build");
        th6.c r101 = r100.f255106a;
        if (r101 != null) goto L5;
        r101 = new th6.b();
    L5:
        this.f255105a = r101;
    }
}
