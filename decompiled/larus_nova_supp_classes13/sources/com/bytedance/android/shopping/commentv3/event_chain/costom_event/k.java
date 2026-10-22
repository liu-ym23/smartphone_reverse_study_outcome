package com.bytedance.android.shopping.commentv3.event_chain.costom_event;

import android.content.Context;
import com.bytedance.android.shopping.commentv3.action.ActionType;
import com.bytedance.kmp.ec.yata.chain.event.EventContext;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class k extends com.bytedance.android.shopping.commentv3.event_chain.a {
    public final com.bytedance.android.shopping.commentv3.data.b d;

    public k(Context r2, com.bytedance.android.shopping.commentv3.data.b r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "viewModel");
        super(ActionType.REFRESH.getType());
        this.d = r3;
    }

    @Override // com.bytedance.android.shopping.commentv3.event_chain.a
    public final void c(EventContext r2, fc3.a r3, fc3.c r4, Function1<? super com.bytedance.kmp.ec.yata.chain.event.b, Unit> r5) {
        Intrinsics.checkNotNullParameter(r2, "eventContext");
        Intrinsics.checkNotNullParameter(r3, "actionContext");
        Intrinsics.checkNotNullParameter(r4, "handleActionParams");
        Intrinsics.checkNotNullParameter(r5, "completion");
        this.d.h.e(null);
        int r6 = com.bytedance.kmp.ec.yata.chain.event.b.h;
        r5.invoke(com.bytedance.kmp.ec.yata.chain.event.b.a.c(false, null, null, 7));
    }
}
