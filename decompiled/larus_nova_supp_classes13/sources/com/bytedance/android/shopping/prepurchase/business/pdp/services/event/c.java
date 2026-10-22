package com.bytedance.android.shopping.prepurchase.business.pdp.services.event;

import com.bytedance.android.ec.core.monitor.ECExceptionMonitor;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class c implements Runnable {
    public final /* synthetic */ LocalTestEventRecorder a;
    public final /* synthetic */ Map b;
    public final /* synthetic */ StackTraceElement[] c;
    public final /* synthetic */ String d;

    public c(LocalTestEventRecorder r1, Map r2, StackTraceElement[] r3, String r4) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
    }

    public final void a() {
        ArrayList r2 = new ArrayList();
        Map r0 = this.b;
        if (r0 == null) goto L8;
        Iterator r1 = r0.entrySet().iterator();
    L6:
        if (r1.hasNext() == false) goto L8;
        r2.add(((Map.Entry) r1.next()).getKey());
    L8:
        ArrayList r3 = new ArrayList();
        StackTraceElement[] r4 = this.c;
        int r5 = r4.length;
        int r6 = 0;
        int r7 = 0;
    L9:
        Object r9 = null;
        if (r7 >= r5) goto L37;
        StackTraceElement r10 = r4[r7];
        int r11 = r6 + 1;
        if (r3.size() > 10) goto L36;
        if (r6 < 4) goto L36;
        if (r10 == null) goto L36;
        if (r10.getFileName() == null) goto L36;
        StringBuilder r8 = new StringBuilder();     // Catch: Exception -> L34
        String r12 = (String) CollectionsKt.getOrNull(StringsKt.split$default(r10.getFileName(), new String[]{"."}, false, 0, 6, null), 0);     // Catch: Exception -> L34
        if (r12 != null) goto L22;
        r12 = "";
    L22:
        r8.append(r12);     // Catch: Exception -> L34
        r8.append(".");     // Catch: Exception -> L34
        r8.append(r10.getMethodName());     // Catch: Exception -> L34
        String r13 = r8.toString();     // Catch: Exception -> L34
        String r14 = (String) CollectionsKt.getOrNull(StringsKt.split$default(r10.getFileName(), new String[]{"."}, false, 0, 6, null), 0);     // Catch: Exception -> L34
        if (r14 != null) goto L25;
        r14 = "";
    L25:
        String r15 = (String) CollectionsKt.lastOrNull(r3);     // Catch: Exception -> L34
        if (r15 == null) goto L31;
        List r16 = StringsKt.split$default(r15, new String[]{"."}, false, 0, 6, null);     // Catch: Exception -> L34
        if (r16 == null) goto L31;
        r9 = (String) CollectionsKt.getOrNull(r16, 0);     // Catch: Exception -> L34
    L31:
        if ((true ^ Intrinsics.areEqual(r14, r9)) == false) goto L36;
        r3.add(r13);     // Catch: Exception -> L34
    L34:
        e = move-exception;
        ECExceptionMonitor.e(e);
    L36:
        r7 = r7 + 1;
        r6 = r11;
        goto L9
    L37:
        Map r17 = this.b;
        if (r17 == null) goto L40;
        Object r18 = r17.get("btm");
    L42:
        if ((r18 instanceof String) == false) goto L45;
        r9 = r18;
    L45:
        String r19 = (String) r9;
        if (r19 != null) goto L49;
        r19 = "";
    L49:
        if (r19.length() != 0) goto L51;
        boolean r20 = true;
    L52:
        if (r20 == false) goto L54;
        return;
    L54:
        List r21 = (List) this.a.a.getValue();
        com.bytedance.android.shopping.anchorv4.tracker.b r22 = new com.bytedance.android.shopping.anchorv4.tracker.b(this.d, r19, r2, r3);
        monitor-enter(r21);
        Iterator r23 = r21.iterator();     // Catch: Throwable -> L69
        boolean r24 = false;
    L58:
        if (r23.hasNext() == false) goto L64;
        com.bytedance.android.shopping.anchorv4.tracker.b r25 = (com.bytedance.android.shopping.anchorv4.tracker.b) r23.next();     // Catch: Throwable -> L69
        String r26 = (String) CollectionsKt.getOrNull(StringsKt.split$default(r22.a(), new String[]{"_i"}, false, 0, 6, null), 0);     // Catch: Throwable -> L69
        String r27 = (String) CollectionsKt.getOrNull(StringsKt.split$default(r25.a(), new String[]{"_i"}, false, 0, 6, null), 0);     // Catch: Throwable -> L69
        if (Intrinsics.areEqual(r25.b(), r22.b()) == false) goto L58;
        if (Intrinsics.areEqual(r26, r27) == false) goto L58;
        r24 = true;
        goto L58
    L64:
        if (r24 == true) goto L66;
        r21.add(r22);     // Catch: Throwable -> L69
    L66:
        Unit r28 = Unit.INSTANCE;     // Catch: Throwable -> L69
        monitor-exit(r21);
        return;
    L69:
        th = move-exception;
        throw th;
    L51:
        r20 = false;
        goto L52
    L40:
        r18 = null;
        goto L42
    }

    @Override // java.lang.Runnable
    public final void run() {
        a();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
