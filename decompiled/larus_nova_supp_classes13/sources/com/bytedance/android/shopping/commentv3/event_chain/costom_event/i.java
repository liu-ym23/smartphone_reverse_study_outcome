package com.bytedance.android.shopping.commentv3.event_chain.costom_event;

import android.content.Context;
import com.bytedance.android.ec.sdk.helper.p;
import com.bytedance.android.shopping.commentv3.action.ActionType;
import com.bytedance.kmp.ec.yata.chain.event.EventContext;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class i extends com.bytedance.android.shopping.commentv3.event_chain.a {
    public final Context d;

    public i(Context r2, com.bytedance.android.shopping.commentv3.data.b r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "viewModel");
        super(ActionType.OPEN_SCHEMA.getType());
        this.d = r2;
    }

    @Override // com.bytedance.android.shopping.commentv3.event_chain.a
    public final void c(EventContext r7, fc3.a r8, fc3.c r9, Function1<? super com.bytedance.kmp.ec.yata.chain.event.b, Unit> r10) {
        Intrinsics.checkNotNullParameter(r7, "eventContext");
        Intrinsics.checkNotNullParameter(r8, "actionContext");
        Intrinsics.checkNotNullParameter(r9, "handleActionParams");
        Intrinsics.checkNotNullParameter(r10, "completion");
        Map r11 = r7.k;
        if (r11 != null) goto L5;
    L19:
        int r12 = com.bytedance.kmp.ec.yata.chain.event.b.h;
        r10.invoke(com.bytedance.kmp.ec.yata.chain.event.b.a.a(false, false, "OpenSchemaEvent don't have schema", null, null, 57));
        return;
    L5:
        if ((!r11.isEmpty()) == true) goto L8;
        r11 = null;
    L8:
        if (r11 == null) goto L19;
        Object r13 = r11.get("schema");
        if ((r13 instanceof String) == true) goto L13;
        r13 = null;
    L13:
        String r14 = (String) r13;
        if (r14 != null) goto L17;
        int r15 = com.bytedance.kmp.ec.yata.chain.event.b.h;
        r10.invoke(com.bytedance.kmp.ec.yata.chain.event.b.a.a(false, false, "OpenSchemaEvent schema is not String", null, null, 57));
        return;
    L17:
        p.a.openSchema(this.d, r14);
        int r16 = com.bytedance.kmp.ec.yata.chain.event.b.h;
        r10.invoke(com.bytedance.kmp.ec.yata.chain.event.b.a.c(false, null, null, 7));
    }
}
