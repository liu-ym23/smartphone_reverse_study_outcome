package com.ss.android.lark.app.glide.diskcache;

import com.bumptech.glide.load.engine.cache.CacheSink;
import java.io.IOException;
import java.io.OutputStream;
import kotlin.jvm.internal.Intrinsics;
import znc.m;

/* JADX INFO: loaded from: classes34.dex */
public final class a implements CacheSink {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final m.b f408724a;

    @Override // com.bumptech.glide.load.engine.cache.CacheSink
    public final OutputStream openOutputStream() throws IOException {
        return this.f408724a.newOutputStream();
    }

    public a(m.c r100) {
        Intrinsics.checkNotNullParameter(r100, "editor");
        this.f408724a = r100;
    }
}
