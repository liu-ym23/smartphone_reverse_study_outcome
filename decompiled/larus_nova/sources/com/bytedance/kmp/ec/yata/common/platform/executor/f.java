package com.bytedance.kmp.ec.yata.common.platform.executor;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public abstract class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public g f251522a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f251523b;

    public abstract void a();

    public f(String r100) {
        Intrinsics.checkNotNullParameter(r100, "name");
        this.f251523b = -1;
    }
}
