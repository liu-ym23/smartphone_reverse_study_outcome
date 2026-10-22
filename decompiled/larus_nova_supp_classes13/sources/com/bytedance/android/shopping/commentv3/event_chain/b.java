package com.bytedance.android.shopping.commentv3.event_chain;

import android.content.Context;
import com.bytedance.android.btm.api.model.PageFinder;
import com.bytedance.kmp.ec.yata.chain.event.EventContext;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;
import v96.h;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class b extends com.bytedance.kmp.ec.yata.chain.core.a {
    public final Lazy c;
    public final Lazy d;
    public final Lazy e;
    public final Context f;
    public final PageFinder g;
    public final ng3.a h;

    public final void g(com.bytedance.kmp.ec.yata.common.error.d r2, EventContext r3) {
        Intrinsics.checkNotNullParameter(r2, "errorCodeModel");
        Intrinsics.checkNotNullParameter(r3, "eventContext");
    }

    public final v96.e d() {
        return (c) this.c.getValue();
    }

    public final v96.g e() {
        return (d) this.d.getValue();
    }

    public final h f() {
        return (e) this.e.getValue();
    }

    public final com.bytedance.kmp.ec.yata.chain.trigger.a a(com.bytedance.kmp.ec.yata.chain.trigger.b r6) {
        Intrinsics.checkNotNullParameter(r6, "chainContext");
        com.bytedance.kmp.ec.yata.chain.trigger.a r0 = super.a(r6);
        Map r1 = r0.c;
        LinkedHashMap r2 = new LinkedHashMap();
        ng3.a r3 = this.h;
        if (r3 == null) goto L7;
        Map<String, Object> r4 = r3.b();
        if (r4 == null) goto L7;
        r2.put("__global", r4);
    L7:
        Object r7 = r6.a.a.e.get("slice-data");
        if ((r7 instanceof com.bytedance.android.ecom.arch.slice.g) == true) goto L10;
        r7 = null;
    L10:
        com.bytedance.android.ecom.arch.slice.g r8 = (com.bytedance.android.ecom.arch.slice.g) r7;
        if (r8 == null) goto L13;
        String r5 = r8.getSliceId();
        Map r9 = r8.getData();
        LinkedHashMap r10 = new LinkedHashMap();
        r10.put(r5, r9);
        r2.put("__data", r10);
    L13:
        r1.putAll(r2);
        return r0;
    }

    public b(Context r2, PageFinder r3, ng3.a r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "btmPageFinder");
        this.f = r2;
        this.g = r3;
        this.h = r4;
        this.c = LazyKt.lazy(new CommentChainServiceProvider$yataOpenSchemaAbility$2(this));
        this.d = LazyKt.lazy(new CommentChainServiceProvider$yataToastAbility$2(this));
        this.e = LazyKt.lazy(CommentChainServiceProvider$yataTrackerAbility$2.INSTANCE);
    }
}
