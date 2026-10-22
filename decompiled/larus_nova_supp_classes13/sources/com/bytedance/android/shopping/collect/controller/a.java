package com.bytedance.android.shopping.collect.controller;

import com.bytedance.android.shopping.collect.common.controller.CollectHandleEventOpportunity;
import com.bytedance.android.shopping.collect.util.CollectCommonLog;
import com.bytedance.kmp.ec.yata.AndroidYaTaInstance;
import com.bytedance.kmp.ec.yata.event.common.e;
import kotlin.Lazy;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class a implements nb3.b {
    public final /* synthetic */ b a;

    @Override // nb3.b
    public final void a() {
        kb3.a r0 = this.a.a.n;
        CollectHandleEventOpportunity r1 = CollectHandleEventOpportunity.RECEIVE_PRODUCTS_CLEAN_UP;
        r0.getClass();
        Intrinsics.checkNotNullParameter(r1, "opportunity");
        Function0<AndroidYaTaInstance> r3 = r0.a;
        if (r3 == null) goto L13;
        AndroidYaTaInstance r5 = (AndroidYaTaInstance) r3.invoke();
        if (r5 == null) goto L16;
        lb3.a r2 = r0.f;
        r2.getClass();
        Intrinsics.checkNotNullParameter(r1, "opportunity");
        Intrinsics.checkNotNullParameter(r5, "yataInstance");
        lb3.a.C0215a r4 = r2.a.get(r1.getValue());
        Lazy r6 = CollectCommonLog.a;
        CollectCommonLog.c("CollectHandleEventController", "handleEvent  opportunity:" + r1 + "    info:" + r4);
        if (r4 == null) goto L14;
        r5.k().d(e.a.a(r5, null, r4.d, r4.a, null, "CollectHandleEventController"));
        if (r4.c == true) goto L15;
        r2.a.remove(r1.getValue());
        return;
    L15:
        return;
    L14:
        return;
    L16:
        return;
    }

    public a(b r1) {
        this.a = r1;
    }
}
