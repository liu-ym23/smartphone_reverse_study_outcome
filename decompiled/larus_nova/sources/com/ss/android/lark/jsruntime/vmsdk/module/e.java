package com.ss.android.lark.jsruntime.vmsdk.module;

import com.bytedance.vmsdk.worker.JsWorker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public final class e implements com.ss.android.lark.jsruntime.vmsdk.b<Throwable> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ com.bytedance.vmsdk.net.a<Throwable> f428199a;

    public e(JsWorker.c r100) {
        this.f428199a = r100;
    }

    @Override // com.ss.android.lark.jsruntime.vmsdk.b
    public final void a(Throwable r100) {
        Throwable r101 = r100;
        Intrinsics.checkNotNullParameter(r101, "e");
        rnb.c.c("VmSDKRequestDelegate", "execute() called with: e = " + r101 + " reject:" + this.f428199a);
        com.bytedance.vmsdk.net.a<Throwable> r102 = this.f428199a;
        if (r102 == null) goto L6;
        r102.a(r101);
        return;
    }
}
