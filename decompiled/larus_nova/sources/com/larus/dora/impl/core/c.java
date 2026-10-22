package com.larus.dora.impl.core;

import java.util.concurrent.CopyOnWriteArraySet;
import kotlin.Result;

/* JADX INFO: loaded from: classes27.dex */
public final class c implements yj4.i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ yj4.h f332189a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ kotlinx.coroutines.i<yj4.b> f332190b;

    @Override // yj4.i
    public final /* synthetic */ void a() {
    }

    @Override // yj4.i
    public final /* synthetic */ void b(int r100) {
    }

    @Override // yj4.i
    public final /* synthetic */ void c() {
    }

    @Override // yj4.i
    public final /* synthetic */ void e() {
    }

    @Override // yj4.i
    public final /* synthetic */ void f(int r100) {
    }

    @Override // yj4.i
    public final /* synthetic */ void g(yj4.a r100) {
    }

    @Override // yj4.i
    public final /* synthetic */ void h(int r100) {
    }

    @Override // yj4.i
    public final /* synthetic */ void i(String r100, long r101, int r102) {
    }

    @Override // yj4.i
    public final void d(yj4.b r100) {
        g49.d.d("DoraAdapterExt", "onAlbumThumbnailData: imageUuid=" + Long.valueOf(r100.f568079a));
        ((yj4.f) this.f332189a).getClass();
        int r101 = yj4.g.f568093a;
        ((CopyOnWriteArraySet) yj4.h.D2).remove(this);
        this.f332190b.resumeWith(Result.m9449constructorimpl(r100));
    }

    public c(yj4.f r100, kotlinx.coroutines.j r101) {
        this.f332189a = r100;
        this.f332190b = r101;
    }
}
