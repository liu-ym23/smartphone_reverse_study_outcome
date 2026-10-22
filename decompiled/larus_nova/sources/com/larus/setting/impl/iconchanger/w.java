package com.larus.setting.impl.iconchanger;

import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.Job;

/* JADX INFO: loaded from: classes31.dex */
public final class w implements com.larus.platform.api.b {
    public w() {
    }

    @Override // com.larus.platform.api.b
    public final void a(com.larus.platform.api.c r100) {
        Intrinsics.checkNotNullParameter(r100, "event");
        Job r101 = ChangeAppIconManager.f368334e;
        if (r101 == null) goto L5;
        Job.DefaultImpls.cancel$default(r101, null, 1, null);
    L5:
        ChangeAppIconManager.f368333d = true;
    }

    @Override // com.larus.platform.api.b
    public final void b(com.larus.platform.api.c r100) {
        Intrinsics.checkNotNullParameter(r100, "event");
        ChangeAppIconManager.f368333d = false;
    }
}
