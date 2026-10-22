package com.bytedance.android.shopping.commentv3.event_chain.costom_event;

import android.content.Context;
import com.bytedance.android.shopping.commentv3.action.ActionType;
import com.bytedance.android.shopping.commentv3.data.FetchFrom;
import com.bytedance.android.shopping.commentv3.data.SortType;
import com.bytedance.kmp.ec.yata.chain.event.EventContext;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class g extends com.bytedance.android.shopping.commentv3.event_chain.a {
    public static final /* synthetic */ int e = 0;
    public final com.bytedance.android.shopping.commentv3.data.b d;

    public static final class a {
    }

    static {
    }

    public g(Context r2, com.bytedance.android.shopping.commentv3.data.b r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "viewModel");
        super(ActionType.FETCH_COMMENT.getType());
        this.d = r3;
    }

    @Override // com.bytedance.android.shopping.commentv3.event_chain.a
    public final void c(EventContext r4, fc3.a r5, fc3.c r6, Function1<? super com.bytedance.kmp.ec.yata.chain.event.b, Unit> r7) {
        Intrinsics.checkNotNullParameter(r4, "eventContext");
        Intrinsics.checkNotNullParameter(r5, "actionContext");
        Intrinsics.checkNotNullParameter(r6, "handleActionParams");
        Intrinsics.checkNotNullParameter(r7, "completion");
        Map r8 = r4.k;
        if (r8 == null) goto L5;
        int r9 = nc3.a.b(r8, "from", 0);
    L6:
        Map r10 = r4.k;
        if (r10 == null) goto L9;
        Boolean r11 = nc3.a.a(r10, "need_fetch_tab", null);
    L11:
        if (this.d.e.c.a() != SortType.LATEST) goto L13;
        boolean r1 = true;
    L14:
        FetchFrom.Companion.getClass();
        FetchFrom.a.a(r9).monitorInteractionStart(r1);
        this.d.e(FetchFrom.a.a(r9), r11);
        int r12 = com.bytedance.kmp.ec.yata.chain.event.b.h;
        r7.invoke(com.bytedance.kmp.ec.yata.chain.event.b.a.c(false, null, null, 7));
        return;
    L13:
        r1 = false;
        goto L14
    L9:
        r11 = null;
        goto L11
    L5:
        r9 = FetchFrom.OTHER.getFrom();
        goto L6
    }
}
