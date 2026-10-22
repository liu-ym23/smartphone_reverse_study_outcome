package com.bytedance.applet.event;

import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final /* synthetic */ class j implements Function1 {
    public final /* synthetic */ IMAppAction a;

    public /* synthetic */ j(IMAppAction r1) {
        this.a = r1;
    }

    public final Object invoke(Object r21) {
        IMAppAction r1 = this.a;
        String r7 = (String) r21;
        jw3.c r2 = jw3.c.a;
        jw3.a r3 = jw3.c.a();
        if (r3 == null) goto L5;
        r3.i(r1.getMessageId());
    L5:
        ConcurrentHashMap r4 = (ConcurrentHashMap) EventDispatcher.c;
        if (r4.containsKey(r1.getMessageId()) == true) goto L8;
        boolean r5 = false;
    L42:
        return Boolean.valueOf(r5);
    L8:
        r4.remove(r1.getMessageId());
        LocalPluginService r6 = LocalPluginService.a;
        Integer r8 = null;
        AppAction r12 = new AppAction(r8, new IMAppAction(null, r1.getMessageId(), r1.getQuestionId(), null, r7, 2, null, 73, null), 1, r8);
        Intrinsics.checkNotNullParameter(r12, "appAction");
        IMAppAction r9 = r12.getAction();
        if (r9 == null) goto L11;
        Long r10 = r9.getMessageId();
    L12:
        jw3.e r11 = jw3.c.d.get();
        if (r11 == null) goto L15;
        com.bytedance.ai.utils.j.a r13 = r11.h(r10);
    L16:
        LocalPluginService.o.set(true);
        BuildersKt.launch$default(LocalPluginService.k, LocalPluginService.m, null, new LocalPluginService$singleRun$1(new LocalPluginService$sendAppAction$1(r12, r13, r11, r10, null), null), 2, null);
        jw3.a r14 = jw3.c.a();
        if (r14 == null) goto L40;
        Long r15 = r1.getQuestionId();
        String r16 = "";
        if (r15 == null) goto L22;
        String r17 = r15.toString();
        if (r17 == null) goto L22;
    L23:
        IMAppAction.b r18 = r1.getMpParam();
        if (r18 == null) goto L27;
        String r19 = r18.c();
        if (r19 == null) goto L27;
    L28:
        IMAppAction.b r20 = r1.getMpParam();
        if (r20 == null) goto L32;
        String r22 = r20.d();
        if (r22 == null) goto L32;
    L33:
        IMAppAction.b r23 = r1.getMpParam();
        if (r23 == null) goto L39;
        String r24 = r23.h();
        if (r24 == null) goto L39;
        r16 = r24;
    L39:
        r14.j(r17, r19, r22, r16);
    L32:
        r22 = "";
    L27:
        r19 = "";
    L22:
        r17 = "";
    L40:
        r5 = true;
        goto L42
    L15:
        r13 = null;
        goto L16
    L11:
        r10 = null;
        goto L12
    }
}
