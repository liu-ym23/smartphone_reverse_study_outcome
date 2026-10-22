package com.bytedance.lighten.loader;

import com.facebook.cache.common.CacheEvent;
import com.facebook.cache.common.CacheEventListener;

/* JADX INFO: loaded from: classes20.dex */
public final class r implements CacheEventListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ hf6.b f254780a;

    @Override // com.facebook.cache.common.CacheEventListener
    public final void onCleared() {
        hf6.b r100 = this.f254780a;
        if (r100 == null) goto L6;
        r100.onCleared();
        return;
    }

    public r(hf6.b r100) {
        this.f254780a = r100;
    }

    @Override // com.facebook.cache.common.CacheEventListener
    public final void onEviction(CacheEvent r100) {
        hf6.b r101 = this.f254780a;
        if (r101 == null) goto L6;
        r101.f();
        return;
    }

    @Override // com.facebook.cache.common.CacheEventListener
    public final void onHit(CacheEvent r100) {
        hf6.b r101 = this.f254780a;
        if (r101 == null) goto L6;
        r101.b();
        return;
    }

    @Override // com.facebook.cache.common.CacheEventListener
    public final void onMiss(CacheEvent r100) {
        hf6.b r101 = this.f254780a;
        if (r101 == null) goto L6;
        r101.g();
        return;
    }

    @Override // com.facebook.cache.common.CacheEventListener
    public final void onReadException(CacheEvent r100) {
        hf6.b r101 = this.f254780a;
        if (r101 == null) goto L6;
        r101.e();
        return;
    }

    @Override // com.facebook.cache.common.CacheEventListener
    public final void onWriteAttempt(CacheEvent r100) {
        hf6.b r101 = this.f254780a;
        if (r101 == null) goto L6;
        r101.a();
        return;
    }

    @Override // com.facebook.cache.common.CacheEventListener
    public final void onWriteException(CacheEvent r100) {
        hf6.b r101 = this.f254780a;
        if (r101 == null) goto L6;
        r101.c();
        return;
    }

    @Override // com.facebook.cache.common.CacheEventListener
    public final void onWriteSuccess(CacheEvent r100) {
        hf6.b r101 = this.f254780a;
        if (r101 == null) goto L6;
        r101.d();
        return;
    }
}
