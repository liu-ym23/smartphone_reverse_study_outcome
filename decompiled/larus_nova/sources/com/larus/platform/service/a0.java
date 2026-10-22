package com.larus.platform.service;

import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class a0 implements com.larus.platform.api.w1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a0 f365715a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Lazy f365716b = null;

    public a0() {
    }

    static {
        f365715a = new a0();
        f365716b = LazyKt.lazy(new z());
    }

    @Override // com.larus.platform.api.w1
    public final void b() {
        Intrinsics.checkNotNullParameter("ZLink_Initialized", "scene");
        com.larus.platform.api.w1 r100 = (com.larus.platform.api.w1) f365716b.getValue();
        if (r100 == null) goto L6;
        r100.b();
        return;
    }

    @Override // com.larus.platform.api.w1
    public final void a(String r100) {
        Intrinsics.checkNotNullParameter("ZlinkSdkManager_dealWithClipboard", "scene");
        com.larus.platform.api.w1 r101 = (com.larus.platform.api.w1) f365716b.getValue();
        if (r101 == null) goto L6;
        r101.a(r100);
        return;
    }
}
