package com.larus.im.internal.audio;

import com.larus.im.internal.audio.session.v2.CommonV2MediaSession;
import com.larus.im.service.audio.x0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class c implements qf9.h {
    public c() {
    }

    @Override // qf9.f
    public final id9.d a(x0 r100) {
        Intrinsics.checkNotNullParameter(r100, "config");
        return new CommonV2MediaSession(r100);
    }
}
