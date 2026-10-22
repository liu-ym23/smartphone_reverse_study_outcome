package com.ss.android.lark.chatbase;

import q3b.o;

/* JADX INFO: loaded from: classes35.dex */
public final /* synthetic */ class e implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ BasePageStore f416862a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ f5b.b f416863b;

    public /* synthetic */ e(BasePageStore r100, f5b.b r101) {
        this.f416862a = r100;
        this.f416863b = r101;
    }

    @Override // java.lang.Runnable
    public final void run() {
        BasePageStore r100 = this.f416862a;
        f5b.b r101 = this.f416863b;
        r100.getClass();
        r100.m(s3b.c.a(new o(r101.getMessage()), new BasePageStore.a(r101)));
    }
}
