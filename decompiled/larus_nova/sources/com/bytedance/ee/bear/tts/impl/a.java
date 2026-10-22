package com.bytedance.ee.bear.tts.impl;

import com.bytedance.ee.bear.tts.TtsResult;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class a implements mo5.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ TtsAlbumViewModel f239536a;

    public a(TtsAlbumViewModel r100) {
        this.f239536a = r100;
    }

    @Override // mo5.b
    public final void a(TtsResult r100) {
        Intrinsics.checkNotNullParameter(r100, "it");
        this.f239536a.x(r100);
    }
}
