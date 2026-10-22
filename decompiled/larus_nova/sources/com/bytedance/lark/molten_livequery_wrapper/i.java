package com.bytedance.lark.molten_livequery_wrapper;

/* JADX INFO: loaded from: classes19.dex */
public final class i implements AutoCloseable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ m<Object> f253402a;

    public i(m<Object> r100) {
        this.f253402a = r100;
    }

    @Override // java.lang.AutoCloseable
    public final void close() {
        this.f253402a.release();
    }
}
