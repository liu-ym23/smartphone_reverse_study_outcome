package com.bytedance.android.shopping.collect.function.base;

import com.bytedance.android.shopping.collect.container.CollectYataFragment;
import com.bytedance.android.shopping.collect.monitor.error.CollectErrorMonitorType;
import com.bytedance.android.shopping.collect.repo.model.CollectParams;
import com.bytedance.android.shopping.collect.util.CollectCommonLog;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class h extends com.bytedance.kmp.ec.yata.event.common.a {
    public final CollectYataFragment a;

    public h(CollectYataFragment r2) {
        Intrinsics.checkNotNullParameter(r2, "fragment");
        this.a = r2;
    }

    public final void c(com.bytedance.kmp.ec.yata.event.core.a r9, Function1 r10) {
        Intrinsics.checkNotNullParameter(r9, "input");
        Intrinsics.checkNotNullParameter(r10, "chainNextCallback");
        CollectCommonLog.c("CollectSelfFun-selfToast", "selfToast");
        kb3.a r1 = this.a.n;
        CollectYataToastFunction$onExecuteAsync$1 r2 = CollectYataToastFunction$onExecuteAsync$1.INSTANCE;
        r1.getClass();
        Intrinsics.checkNotNullParameter(r9, "input");
        Intrinsics.checkNotNullParameter(r2, "toastAction");
        Map<String, pb3.a> r4 = pb3.a.h;
        CollectParams r3 = r1.b;
        if (r3 == null) goto L5;
        String r5 = r3.getMonitorId();
    L6:
        pb3.a r6 = (pb3.a) ((LinkedHashMap) pb3.a.h).get(r5);
        Intrinsics.checkNotNullParameter(r9, "input");
        Intrinsics.checkNotNullParameter(r2, "toastAction");
        Map r0 = ((com.bytedance.kmp.ec.yata.chain.trigger.a) r9.e).a;
        if (r0 == null) goto L9;
        Object r7 = r0.get("toast_message");
    L11:
        if ((r7 instanceof String) == true) goto L13;
        r7 = null;
    L13:
        String r8 = (String) r7;
        boolean r11 = true;
        if (r8 != null) goto L16;
    L19:
        boolean r12 = true;
    L20:
        if (r12 == false) goto L25;
        Object r13 = r9.p(Reflection.getOrCreateKotlinClass(String.class), "toast_message");
        if ((r13 instanceof String) == true) goto L24;
        r13 = null;
    L24:
        r8 = (String) r13;
    L25:
        if (r8 != null) goto L27;
    L30:
        if (r11 == false) goto L35;
        if (r6 == null) goto L35;
        com.bytedance.android.shopping.collect.monitor.error.a r14 = r6.c;
        if (r14 == null) goto L35;
        CollectErrorMonitorType r15 = CollectErrorMonitorType.SELF_FUN_ERROR;
        Map<String, com.bytedance.android.shopping.collect.monitor.error.a> r16 = com.bytedance.android.shopping.collect.monitor.error.a.b;
        r14.b(r15, "selfToast  toastMsg is null", null);
    L35:
        r2.invoke(r8);
        int r17 = com.bytedance.kmp.ec.yata.chain.event.b.h;
        r10.invoke(com.bytedance.kmp.ec.yata.chain.event.b.a.c(false, null, null, 7));
        return;
    L27:
        if (StringsKt.isBlank(r8) == true) goto L30;
        r11 = false;
        goto L30
    L16:
        if (StringsKt.isBlank(r8) == true) goto L19;
        r12 = false;
        goto L20
    L9:
        r7 = null;
        goto L11
    L5:
        r5 = null;
        goto L6
    }
}
