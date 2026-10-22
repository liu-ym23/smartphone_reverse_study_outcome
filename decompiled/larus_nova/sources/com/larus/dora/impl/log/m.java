package com.larus.dora.impl.log;

import kotlin.jvm.internal.Intrinsics;
import t39.w;

/* JADX INFO: loaded from: classes27.dex */
public final class m implements w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f336138a;

    public m(String r100) {
        this.f336138a = r100;
    }

    @Override // t39.w
    public final void a(boolean r100, String r101) {
        Intrinsics.checkNotNullParameter(r101, "msg");
        g49.d.d("DoraLogManager", "upload log " + this.f336138a + ". success: " + r100 + ", msg: " + r101);
    }
}
