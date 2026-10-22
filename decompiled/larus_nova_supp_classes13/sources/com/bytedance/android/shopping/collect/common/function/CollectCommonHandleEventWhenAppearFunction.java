package com.bytedance.android.shopping.collect.common.function;

import com.bytedance.android.shopping.collect.monitor.error.CollectErrorMonitorType;
import com.bytedance.android.shopping.collect.util.CollectCommonLog;
import com.bytedance.kmp.ec.yata.event.common.e;
import com.bytedance.kmp.ec.yata.store.node.c;
import java.util.Map;
import kotlin.Lazy;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.text.StringsKt;
import lb3.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class CollectCommonHandleEventWhenAppearFunction {
    public final a a;
    public final e b;
    public final pb3.a c;

    public final void a() {
        Object r0 = this.b.p(Reflection.getOrCreateKotlinClass(String.class), "event_name");
        if ((r0 instanceof String) == true) goto L5;
        r0 = null;
    L5:
        final String r1 = (String) r0;
        Object r2 = this.b.p(Reflection.getOrCreateKotlinClass(String.class), "opportunity");
        if ((r2 instanceof String) == true) goto L8;
        r2 = null;
    L8:
        final String r3 = (String) r2;
        Object r4 = this.b.p(Reflection.getOrCreateKotlinClass(Boolean.class), "need_hold");
        if ((r4 instanceof Boolean) == true) goto L11;
        r4 = null;
    L11:
        Boolean r5 = (Boolean) r4;
        boolean r6 = false;
        if (r5 == null) goto L14;
        boolean r7 = r5.booleanValue();
    L15:
        c r8 = this.b.j();
        if (r8 == null) goto L18;
        final String r9 = r8.getKey();
    L19:
        Lazy r10 = CollectCommonLog.a;
        StringBuilder r11 = new StringBuilder("doAction ");
        r11.append("eventName:" + r1 + ' ');
        r11.append("opportunity:" + r3 + ' ');
        r11.append("needHold:" + r7 + ' ');
        r11.append("renderNodeKey:" + r9 + ' ');
        Unit r12 = Unit.INSTANCE;
        CollectCommonLog.c("CollectCommonHandleEventWhenAppearFunction", r11.toString());
        if (r1 != null) goto L22;
    L25:
        boolean r13 = true;
    L26:
        if (r13 == true) goto L43;
        if (r3 != null) goto L29;
    L32:
        boolean r14 = true;
    L33:
        if (r14 == true) goto L43;
        if (r9 != null) goto L36;
    L39:
        boolean r15 = true;
    L40:
        if (r15 == true) goto L43;
        CollectCommonLog.a("CollectCommonHandleEventWhenAppearFunction", new CollectCommonHandleEventWhenAppearFunction$doAction$3(r1, r3, r9));
        a.C0215a r16 = new a.C0215a(r1, r3, r7, r9);
        a r17 = this.a;
        r17.getClass();
        Intrinsics.checkNotNullParameter(r16, "info");
        CollectCommonLog.c("CollectHandleEventController", "addHandleEventInfo  info:" + r16);
        r17.a.put(r16.b, r16);
        return;
    L36:
        if (StringsKt.isBlank(r9) == true) goto L39;
        r15 = false;
        goto L40
    L29:
        if (StringsKt.isBlank(r3) == true) goto L32;
        r14 = false;
    L43:
        pb3.a r18 = this.c;
        if (r18 == null) goto L55;
        com.bytedance.android.shopping.collect.monitor.error.a r19 = r18.c;
        if (r19 == null) goto L55;
        if (r9 != null) goto L49;
    L50:
        r6 = true;
    L51:
        if (r6 == false) goto L53;
        CollectErrorMonitorType r20 = CollectErrorMonitorType.SELF_FUN_ERROR;
    L54:
        StringBuilder r21 = new StringBuilder("selfHandleEventWhenAppear  ");
        r21.append("eventName:" + r1 + ' ');
        r21.append("opportunity:" + r3 + ' ');
        r21.append("needHold:" + r7 + ' ');
        r21.append("renderNodeKey:" + r9 + ' ');
        String r22 = r21.toString();
        Map<String, com.bytedance.android.shopping.collect.monitor.error.a> r23 = com.bytedance.android.shopping.collect.monitor.error.a.b;
        r19.b(r20, r22, null);
        goto L55
    L53:
        r20 = CollectErrorMonitorType.SERVER_BUSINESS_ERROR;
        goto L54
    L49:
        if (StringsKt.isBlank(r9) == false) goto L51;
    L55:
        CollectCommonLog.b("CollectCommonHandleEventWhenAppearFunction", "数据非法  eventName:" + r1 + "  opportunity:" + r3 + "  renderNodeKey:" + r9);
        return;
    L22:
        if (StringsKt.isBlank(r1) == true) goto L25;
        r13 = false;
        goto L26
    L18:
        r9 = null;
        goto L19
    L14:
        r7 = false;
        goto L15
    }

    public CollectCommonHandleEventWhenAppearFunction(a r2, com.bytedance.kmp.ec.yata.event.core.a r3, pb3.a r4) {
        Intrinsics.checkNotNullParameter(r2, "handleEventController");
        Intrinsics.checkNotNullParameter(r3, "input");
        this.a = r2;
        this.b = r3;
        this.c = r4;
    }
}
