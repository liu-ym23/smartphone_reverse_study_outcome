package com.bytedance.ee.bear.tts.impl;

import com.bytedance.ee.bear.tts.TtsResult;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class b implements mo5.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ TtsAlbumViewModel f239537a;

    public b(TtsAlbumViewModel r100) {
        this.f239537a = r100;
    }

    @Override // mo5.b
    public final void a(TtsResult r100) {
        Intrinsics.checkNotNullParameter(r100, "it");
        this.f239537a.x(r100);
    }
}
