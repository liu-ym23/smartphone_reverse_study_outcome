package com.larus.home.impl;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes29.dex */
public final class a implements com.larus.platform.api.b {
    public a() {
    }

    @Override // com.larus.platform.api.b
    public final void a(com.larus.platform.api.c r100) {
        Intrinsics.checkNotNullParameter(r100, "event");
    }

    @Override // com.larus.platform.api.b
    public final void b(com.larus.platform.api.c r100) {
        Intrinsics.checkNotNullParameter(r100, "event");
        AppInitReporter r101 = AppInitReporter.f344102a;
        AppInitReporter.f344119r = true;
    }
}
