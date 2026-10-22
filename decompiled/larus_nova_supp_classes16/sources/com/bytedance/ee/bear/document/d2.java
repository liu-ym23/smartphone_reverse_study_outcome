package com.bytedance.ee.bear.document;

import android.os.Process;
import com.bytedance.ee.bear.document.imageviewer.diagram.DiagramData$RESULT;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.HashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class d2 implements Runnable {
    public final /* synthetic */ b2 a;
    public final /* synthetic */ String b;
    public final /* synthetic */ String c;
    public final /* synthetic */ String d;

    public d2(b2 r1, String r2, String r3, String r4) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
    }

    public final void a() {
        long r0 = b2.a(this.a);
        this.a.getClass();
        long r2 = eu5.g.b(Process.myPid());
        ((CopyOnWriteArrayList) this.a.b).add(Long.valueOf(r0));
        ((CopyOnWriteArrayList) this.a.c).add(Long.valueOf(r2));
        tt5.a.h("DocWebPerfMonitor", "onDetach... sandboxMemoryRss: " + r0 + ", mainMemoryRss: " + r2);
        HashMap r4 = new HashMap();
        r4.put("token", du5.b.g(this.b));
        String r5 = this.c;
        String r6 = "";
        if (r5 != null) goto L5;
        r5 = "";
    L5:
        r4.put("file_type", r5);
        String r7 = this.d;
        if (r7 == null) goto L9;
        r6 = r7;
    L9:
        r4.put("sub_type", r6);
        r4.put("record_count", String.valueOf(((CopyOnWriteArrayList) this.a.c).size()));
        r4.put("opening_doc_count", String.valueOf(b2.f));
        l7 r8 = y7.j;
        r4.put("webview_count", String.valueOf(y7.a.a.a.f()));
        String r9 = String.valueOf(CollectionsKt.averageOfLong(this.a.c));
        String r10 = DiagramData$RESULT.FAIL;
        if (r9 != null) goto L12;
        r9 = DiagramData$RESULT.FAIL;
    L12:
        r4.put("memory_main_average", r9);
        Long r11 = (Long) CollectionsKt.maxOrNull(this.a.c);
        if (r11 == null) goto L16;
        String r12 = r11.toString();
        if (r12 == null) goto L16;
    L17:
        r4.put("memory_main_max", r12);
        Long r13 = (Long) CollectionsKt.firstOrNull(this.a.c);
        if (r13 == null) goto L21;
        String r14 = r13.toString();
        if (r14 == null) goto L21;
    L22:
        r4.put("memory_main_start", r14);
        Long r16 = (Long) CollectionsKt.lastOrNull(this.a.c);
        if (r16 == null) goto L26;
        String r17 = r16.toString();
        if (r17 == null) goto L26;
    L27:
        r4.put("memory_main_end", r17);
        Long r18 = (Long) CollectionsKt.maxOrNull(this.a.c);
        long r19 = 0;
        if (r18 == null) goto L30;
        long r20 = r18.longValue();
    L31:
        Long r21 = (Long) CollectionsKt.minOrNull(this.a.c);
        if (r21 == null) goto L34;
        long r110 = r21.longValue();
    L35:
        String r22 = String.valueOf(r20 - r110);
        if (r22 != null) goto L38;
        r22 = DiagramData$RESULT.FAIL;
    L38:
        r4.put("memory_main_max_minus_min", r22);
        Long r23 = (Long) CollectionsKt.firstOrNull(this.a.c);
        if (r23 == null) goto L41;
        long r24 = r23.longValue();
    L42:
        String r3 = String.valueOf(r2 - r24);
        if (r3 != null) goto L45;
        r3 = DiagramData$RESULT.FAIL;
    L45:
        r4.put("memory_main_end_minus_start", r3);
        String r26 = String.valueOf(CollectionsKt.averageOfLong(this.a.b));
        if (r26 != null) goto L48;
        r26 = DiagramData$RESULT.FAIL;
    L48:
        r4.put("memory_sandbox_average", r26);
        Long r27 = (Long) CollectionsKt.maxOrNull(this.a.b);
        if (r27 == null) goto L52;
        String r28 = r27.toString();
        if (r28 == null) goto L52;
    L53:
        r4.put("memory_sandbox_max", r28);
        Long r29 = (Long) CollectionsKt.firstOrNull(this.a.b);
        if (r29 == null) goto L57;
        String r30 = r29.toString();
        if (r30 == null) goto L57;
    L58:
        r4.put("memory_sandbox_start", r30);
        Long r31 = (Long) CollectionsKt.lastOrNull(this.a.b);
        if (r31 == null) goto L62;
        String r32 = r31.toString();
        if (r32 == null) goto L62;
    L63:
        r4.put("memory_sandbox_end", r32);
        Long r33 = (Long) CollectionsKt.maxOrNull(this.a.b);
        if (r33 == null) goto L66;
        long r34 = r33.longValue();
    L67:
        Long r36 = (Long) CollectionsKt.minOrNull(this.a.b);
        if (r36 == null) goto L70;
        long r37 = r36.longValue();
    L71:
        String r38 = String.valueOf(r34 - r37);
        if (r38 != null) goto L74;
        r38 = DiagramData$RESULT.FAIL;
    L74:
        r4.put("memory_sandbox_max_minus_min", r38);
        Long r39 = (Long) CollectionsKt.firstOrNull(this.a.b);
        if (r39 == null) goto L77;
        r19 = r39.longValue();
    L77:
        String r1 = String.valueOf(r0 - r19);
        if (r1 == null) goto L81;
        r10 = r1;
    L81:
        r4.put("memory_sandbox_end_minus_start", r10);
        this.a.a.n("docs_power_log_monitor_event_dev", r4);
        b2.f--;
        return;
    L70:
        r37 = 0;
        goto L71
    L66:
        r34 = 0;
    L62:
        r32 = DiagramData$RESULT.FAIL;
    L57:
        r30 = DiagramData$RESULT.FAIL;
    L52:
        r28 = DiagramData$RESULT.FAIL;
        goto L53
    L41:
        r24 = 0;
        goto L42
    L34:
        r110 = 0;
        goto L35
    L30:
        r20 = 0;
    L26:
        r17 = DiagramData$RESULT.FAIL;
    L21:
        r14 = DiagramData$RESULT.FAIL;
    L16:
        r12 = DiagramData$RESULT.FAIL;
        goto L17
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
