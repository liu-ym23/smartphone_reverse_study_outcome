package com.bytedance.android.shopping.commentv3.event_chain.costom_event;

import android.content.Context;
import com.bytedance.android.ecom.arch.slice.action.SlcCommonAction;
import com.bytedance.android.shopping.commentv3.action.ActionType;
import com.bytedance.kmp.ec.yata.chain.event.EventContext;
import java.util.Map;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class l extends com.bytedance.android.shopping.commentv3.event_chain.a {
    public static final /* synthetic */ int e = 0;
    public final com.bytedance.android.shopping.commentv3.data.b d;

    public static final class a {
        public static SlcCommonAction a(Map r3) {
            Intrinsics.checkNotNullParameter(r3, "incomeData");
            return new SlcCommonAction(ActionType.STORE_UPDATE.getType(), MapsKt.mapOf(TuplesKt.to("incoming_data", r3)));
        }
    }

    static {
    }

    public l(Context r2, com.bytedance.android.shopping.commentv3.data.b r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "viewModel");
        super(ActionType.STORE_UPDATE.getType());
        this.d = r3;
    }

    @Override // com.bytedance.android.shopping.commentv3.event_chain.a
    public final void c(EventContext r7, fc3.a r8, fc3.c r9, Function1<? super com.bytedance.kmp.ec.yata.chain.event.b, Unit> r10) {
        Intrinsics.checkNotNullParameter(r7, "eventContext");
        Intrinsics.checkNotNullParameter(r8, "actionContext");
        Intrinsics.checkNotNullParameter(r9, "handleActionParams");
        Intrinsics.checkNotNullParameter(r10, "completion");
        Map<?, ?> r11 = com.bytedance.android.shopping.commentv3.event_chain.g.a(r7);
        if (r11 != null) goto L5;
    L8:
        boolean r12 = true;
    L9:
        if (r12 == false) goto L12;
        int r13 = com.bytedance.kmp.ec.yata.chain.event.b.h;
        r10.invoke(com.bytedance.kmp.ec.yata.chain.event.b.a.a(false, false, "StoreUpdateEvent incomeData is empty", null, null, 57));
        return;
    L12:
        this.d.e.update(r11);
        int r14 = com.bytedance.kmp.ec.yata.chain.event.b.h;
        r10.invoke(com.bytedance.kmp.ec.yata.chain.event.b.a.c(false, null, null, 7));
        return;
    L5:
        if (r11.isEmpty() == true) goto L8;
        r12 = false;
        goto L9
    }
}
