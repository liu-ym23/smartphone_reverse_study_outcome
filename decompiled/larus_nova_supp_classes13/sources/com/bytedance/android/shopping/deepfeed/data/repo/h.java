package com.bytedance.android.shopping.deepfeed.data.repo;

import android.content.Context;
import com.bytedance.android.shopping.deepfeed.slice.view.video.DeepFeedSliceVideoEarlyWarmCenter;
import com.bytedance.android.shopping.infeed.data.idl.InFeedProductV2;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class h extends fe3.a {
    public final /* synthetic */ Context c;
    public final /* synthetic */ List d;

    public final void a() {
        ConcurrentHashMap<String, DeepFeedSliceVideoEarlyWarmCenter.a> r0 = DeepFeedSliceVideoEarlyWarmCenter.a;
        Context r1 = this.c;
        List r2 = this.d;
        Intrinsics.checkNotNullParameter(r1, "context");
        Intrinsics.checkNotNullParameter(r2, "products");
        tc3.c r3 = tc3.d.a;
        if (r3.a() == true) goto L6;
        r3 = null;
    L6:
        if (r3 != null) goto L9;
        return;
    L9:
        if (r3.b() != null) goto L11;
        return;
    L11:
        if (r3.b().longValue() <= 0) goto L44;
        int r4 = 0;
        int r5 = RangesKt.coerceAtLeast(r3.c(), 0);
        if (r5 == 0) goto L45;
        Iterator r6 = r2.iterator();
    L18:
        if (r6.hasNext() == false) goto L46;
        Object r7 = r6.next();
        int r8 = r4 + 1;
        if (r4 >= 0) goto L22;
        CollectionsKt.throwIndexOverflow();
    L22:
        InFeedProductV2 r9 = (InFeedProductV2) r7;
        if (r4 <= (-1)) goto L34;
        if (r4 > ((-1) + r5)) goto L34;
        if (r9.isSkeletonData() == true) goto L34;
        com.bytedance.android.shopping.deepfeed.slice.view.video.c r10 = DeepFeedSliceVideoEarlyWarmCenter.c(r9);
        if (r10 == null) goto L34;
        DeepFeedSliceVideoEarlyWarmCenter.e(r1, r10, r3.f());
        if (r3.e() == false) goto L34;
        DeepFeedSliceVideoEarlyWarmCenter.f(r1, r10);
    L34:
        r4 = r8;
        goto L18
    L46:
        return;
    L45:
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

    public h(Context r1, List r2) {
        this.c = r1;
        this.d = r2;
    }
}
