package com.larus.audio;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class c0 implements m58.a {
    public c0() {
    }

    @Override // m58.a
    public final void c() {
        Intrinsics.checkNotNullParameter("TTS_PLAY", "scene");
        com.larus.platform.service.g.f365738a.e("TTS_PLAY");
    }

    @Override // m58.a
    public final void d() {
        Intrinsics.checkNotNullParameter("TTS_PLAY", "scene");
        com.larus.platform.service.g.f365738a.g("TTS_PLAY");
    }

    @Override // m58.a
    public final void ensureNotReachHere(Throwable r100) {
        Intrinsics.checkNotNullParameter(r100, "t");
        com.larus.platform.service.g.f365738a.ensureNotReachHere(r100);
    }

    @Override // m58.a
    public final void ensureNotReachHere(Throwable r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "t");
        Intrinsics.checkNotNullParameter(r101, "msg");
        com.larus.platform.service.g.f365738a.ensureNotReachHere(r100, r101);
    }
}
