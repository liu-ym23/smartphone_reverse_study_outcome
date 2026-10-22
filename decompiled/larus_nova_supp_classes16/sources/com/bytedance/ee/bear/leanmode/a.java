package com.bytedance.ee.bear.leanmode;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final /* synthetic */ class a implements Runnable {
    public final /* synthetic */ h a;

    public /* synthetic */ a(h r1) {
        this.a = r1;
    }

    @Override // java.lang.Runnable
    public final void run() {
        final h r0 = this.a;
        r0.a.observeForever(new b(r0));
        r0.b.observeForever(new c(r0));
    }
}
