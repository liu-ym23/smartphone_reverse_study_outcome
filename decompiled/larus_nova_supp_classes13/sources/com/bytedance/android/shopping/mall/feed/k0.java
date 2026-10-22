package com.bytedance.android.shopping.mall.feed;

import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class k0 implements Runnable {
    public final /* synthetic */ ECMallFeed a;
    public final /* synthetic */ long b;
    public final /* synthetic */ long c;
    public final /* synthetic */ Ref.ObjectRef d;
    public final /* synthetic */ String e;
    public final /* synthetic */ int f;
    public final /* synthetic */ long g;

    public k0(ECMallFeed r1, long r2, long r4, Ref.ObjectRef r6, String r7, int r8, long r9) {
        this.a = r1;
        this.b = r2;
        this.c = r4;
        this.d = r6;
        this.e = r7;
        this.f = r8;
        this.g = r9;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.a.b0(1, this.b, Long.valueOf(this.c), (Integer) this.d.element, this.e, this.f, Long.valueOf(this.g));     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
