package com.larus.platform.service;

import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes31.dex */
public final class c0 implements com.larus.platform.api.x1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final c0 f365721a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Lazy f365722b = null;

    public c0() {
    }

    static {
        f365721a = new c0();
        f365722b = LazyKt.lazy(new b0());
    }

    @Override // com.larus.platform.api.x1
    public final void a(String r100) {
        Intrinsics.checkNotNullParameter("ZlinkSdkManager_dealWithClipboard", "scene");
        com.larus.platform.api.x1 r101 = (com.larus.platform.api.x1) f365722b.getValue();
        if (r101 == null) goto L6;
        r101.a(r100);
        return;
    }
}
