package com.larus.home.impl.reddot;

import com.larus.bmhome.chat.reddot.f;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes29.dex */
public final class c implements com.larus.platform.api.b {
    public c() {
    }

    @Override // com.larus.platform.api.b
    public final void a(com.larus.platform.api.c r100) {
        Intrinsics.checkNotNullParameter(r100, "event");
        int r101 = UpdateRedDotManager.f346019a;
        UpdateRedDotManager.b();
    }

    @Override // com.larus.platform.api.b
    public final void b(com.larus.platform.api.c r100) {
        Intrinsics.checkNotNullParameter(r100, "event");
        UpdateRedDotManager.f346019a = 0;
        f r101 = f.f308497a;
        f.e(UpdateRedDotManager.f346023e);
    }
}
