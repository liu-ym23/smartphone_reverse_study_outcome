package com.larus.im.internal.audio.session.omni;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class i0 implements qf9.g {
    public i0() {
    }

    @Override // qf9.f
    public final id9.d a(com.larus.im.service.audio.x0 r100) {
        Intrinsics.checkNotNullParameter(r100, "config");
        return new OmniMediaSession(r100, false);
    }

    @Override // qf9.g
    public final OmniMediaSession b(com.larus.im.service.audio.x0 r100) {
        Intrinsics.checkNotNullParameter(r100, "config");
        return new OmniMediaSession(r100, true);
    }
}
