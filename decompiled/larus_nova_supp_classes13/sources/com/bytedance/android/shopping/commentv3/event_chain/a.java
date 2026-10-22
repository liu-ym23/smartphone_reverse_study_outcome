package com.bytedance.android.shopping.commentv3.event_chain;

import com.bytedance.kmp.ec.yata.chain.event.EventContext;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public abstract class a extends t96.a {
    public fc3.a c;

    public abstract void c(EventContext r1, fc3.a r2, fc3.c r3, Function1<? super com.bytedance.kmp.ec.yata.chain.event.b, Unit> r4);

    public a(String r2) {
        Intrinsics.checkNotNullParameter(r2, "name");
        super(r2);
    }

    public final void b(EventContext r7, Function1<? super com.bytedance.kmp.ec.yata.chain.event.b, Unit> r8) {
        Intrinsics.checkNotNullParameter(r7, "eventContext");
        Intrinsics.checkNotNullParameter(r8, "completion");
        Object r0 = r7.d().get("action_context");
        Object r2 = null;
        if ((r0 instanceof fc3.a) == true) goto L5;
        r0 = null;
    L5:
        fc3.a r1 = (fc3.a) r0;
        if (r1 != null) goto L9;
        int r9 = com.bytedance.kmp.ec.yata.chain.event.b.h;
        r8.invoke(com.bytedance.kmp.ec.yata.chain.event.b.a.a(false, false, "actionContext is null", null, null, 57));
        return;
    L9:
        this.c = r1;
        Object r3 = r7.d().get("handle_action_params");
        if ((r3 instanceof fc3.c) == false) goto L13;
        r2 = r3;
    L13:
        fc3.c r4 = (fc3.c) r2;
        if (r4 != null) goto L17;
        int r10 = com.bytedance.kmp.ec.yata.chain.event.b.h;
        r8.invoke(com.bytedance.kmp.ec.yata.chain.event.b.a.a(false, false, "handleActionParams is null", null, null, 57));
        return;
    L17:
        c(r7, r1, r4, r8);
    }
}
