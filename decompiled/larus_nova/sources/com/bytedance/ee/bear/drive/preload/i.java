package com.bytedance.ee.bear.drive.preload;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes16.dex */
public final class i implements Consumer<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ m.a f224524a;

    public i(m.a r100) {
        this.f224524a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Boolean r100) throws Exception {
        this.f224524a.c(r100.booleanValue());
    }
}
