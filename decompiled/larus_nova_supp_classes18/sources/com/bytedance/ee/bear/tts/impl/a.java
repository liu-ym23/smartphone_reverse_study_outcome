package com.bytedance.ee.bear.tts.impl;

import com.bytedance.ee.bear.tts.TtsResult;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class a implements mo5.b {
    public final /* synthetic */ TtsAlbumViewModel a;

    public a(TtsAlbumViewModel r1) {
        this.a = r1;
    }

    @Override // mo5.b
    public final void a(TtsResult r2) {
        Intrinsics.checkNotNullParameter(r2, "it");
        this.a.x(r2);
    }
}
