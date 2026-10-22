package com.bytedance.bdp.appbase.network.upload;

import gb4.e;
import java.io.IOException;
import java.io.OutputStream;

/* JADX INFO: loaded from: classes11.dex */
public final class b extends e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ a f200925a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ BdpUploadRequest f200926b;

    @Override // gb4.e
    public final String a() {
        return this.f200926b.getBody().a();
    }

    @Override // gb4.e
    public final long b() {
        return this.f200926b.getBody().b();
    }

    @Override // gb4.e
    public final void c(OutputStream r100) throws IOException {
        this.f200926b.getBody().c(new a.b(this.f200925a, r100));
    }

    public b(a r100, BdpUploadRequest r101) {
        this.f200925a = r100;
        this.f200926b = r101;
    }
}
