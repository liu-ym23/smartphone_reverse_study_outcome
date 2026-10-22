package com.bytedance.bdp.appbase.network.wrapper;

import gb4.e;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import okio.BufferedSink;

/* JADX INFO: loaded from: classes11.dex */
public final class d extends RequestBody {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final e f200954a;

    @Override // okhttp3.RequestBody
    public final long contentLength() {
        return this.f200954a.b();
    }

    @Override // okhttp3.RequestBody
    public final MediaType contentType() {
        return MediaType.parse(this.f200954a.a());
    }

    public d(e r100) {
        this.f200954a = r100;
    }

    @Override // okhttp3.RequestBody
    public final void writeTo(BufferedSink r100) {
        this.f200954a.c(r100.outputStream());
    }
}
