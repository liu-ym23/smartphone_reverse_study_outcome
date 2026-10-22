package com.bytedance.android.shopping.deepfeed.data.repo;

import android.content.Context;
import android.os.Handler;
import com.bytedance.android.ec.sdk.helper.ECAppInfoService;
import com.bytedance.android.shopping.infeed.data.idl.InFeedProductResponse;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class c implements Runnable {
    public final /* synthetic */ DeepFeedBFFRequest a;
    public final /* synthetic */ InFeedProductResponse b;

    public c(DeepFeedBFFRequest r1, InFeedProductResponse r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void a() {
        DeepFeedBFFRequest r0 = this.a;
        InFeedProductResponse r1 = this.b;
        r0.getClass();
        List r2 = AbsDeepFeedRequest.i(r1);
        if (r2 != null) goto L5;
        return;
    L5:
        if ((!r2.isEmpty()) == true) goto L8;
        r2 = null;
    L8:
        if (r2 == null) goto L16;
        Context r3 = ECAppInfoService.e.getApplicationContext();
        if (r3 == null) goto L17;
        Handler r4 = fe3.b.a;
        Intrinsics.checkNotNullParameter("deep_feed_bff_video_pre_warm", "group");
        Handler r5 = fe3.b.a;
        r5.post(new fe3.d());
        h r6 = new h(r3, r2);
        Intrinsics.checkNotNullParameter(r6, "task");
        r5.post(new fe3.c(r6));
        return;
    L17:
        return;
    }

    @Override // java.lang.Runnable
    public final void run() {
        a();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
