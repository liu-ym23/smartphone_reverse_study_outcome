package com.ss.android.lark.jsruntime.vmsdk.module;

import com.bytedance.vmsdk.net.Response;
import com.bytedance.vmsdk.worker.JsWorker;
import com.ss.android.lark.jsruntime.vmsdk.i;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public final class d implements com.ss.android.lark.jsruntime.vmsdk.b<i> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ com.bytedance.vmsdk.net.a<Response> f428198a;

    public d(JsWorker.b r100) {
        this.f428198a = r100;
    }

    @Override // com.ss.android.lark.jsruntime.vmsdk.b
    public final void a(i r100) {
        i r101 = r100;
        Intrinsics.checkNotNullParameter(r101, "params");
        rnb.c.c("VmSDKRequestDelegate", "execute() called }");
        com.bytedance.vmsdk.net.a<Response> r102 = this.f428198a;
        if (r102 == null) goto L6;
        r102.a(new Response(r101.f428169a, r101.f428170b, r101.f428171c, r101.f428172d, r101.f428173e));
        return;
    }
}
