package com.bytedance.tools.kcp.modelx.runtime.internal;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes22.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Class<?> f270958a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Class<?> f270959b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f270960c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f270961d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final com.bytedance.tools.kcp.modelx.runtime.internal.decode.a f270962e;

    public d(Class r100, Class r101, int r102, com.bytedance.tools.kcp.modelx.runtime.internal.decode.a r103) {
        Intrinsics.checkNotNullParameter(r100, "flexType");
        Intrinsics.checkNotNullParameter(r101, "extensionInterfaceType");
        Intrinsics.checkNotNullParameter(r103, "moduleProcessor");
        this.f270958a = r100;
        this.f270959b = r101;
        this.f270960c = r102;
        this.f270961d = false;
        this.f270962e = r103;
    }
}
