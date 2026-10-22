package mt3;

import av3.b;
import com.bytedance.apm6.consumer.slardar.send.c;
import com.bytedance.apm6.consumer.slardar.send.f;
import com.bytedance.apm6.consumer.slardar.send.g;
import com.bytedance.apm6.consumer.slardar.send.h;
import com.bytedance.apm6.consumer.slardar.send.i;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.larus.apm.impl.protector.RunnableProtector;
import cv3.a;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class d extends a {
    public final /* synthetic */ c d;

    public final void a() {
        if (xu3.a.a() == false) goto L6;
        List r0 = a.a;
        b.a("APM-Slardar", "retryPriorityNow: flushing and reporting priority files");
    L6:
        if (this.d.e == null) goto L12;
        this.d.e.b();     // Catch: Throwable -> L9
    L9:
        th = move-exception;
        List r1 = a.a;
        b.c("APM-Slardar", "retryPriorityNow flush error", th);
    L12:
        if (du3.a.o() == false) goto L15;
        this.d.e();
    L15:
        if (du3.a.o() == false) goto L79;
        f.b.a.getClass();
        c r2 = c.a.a;
        monitor-enter(r2);
        r2.c();     // Catch: Throwable -> L76
        PolarisFileWrapper r3 = r2.c;     // Catch: Throwable -> L76
        if (r3 != null) goto L23;
        List r4 = Collections.emptyList();     // Catch: Throwable -> L76
        monitor-exit(r2);
    L38:
        if (r4.isEmpty() == false) goto L41;
        return;
    L41:
        if (xu3.a.a() == false) goto L43;
        List r5 = a.a;
        b.a("APM-Slardar", "retryPriorityFiles: " + r4.size() + " files");
    L43:
        Iterator r6 = r4.iterator();
    L45:
        if (r6.hasNext() == false) goto L107;
        File r7 = (File) r6.next();
        if (r7.exists() == false) goto L48;
        byte[] r8 = xu3.b.b(r7);
        if (r8 == null) goto L75;
        if (r8.length == 0) goto L75;
        String r9 = r7.getName();
        int r10 = r9.lastIndexOf(".");
        if (r10 < 0) goto L57;
        String r11 = r9.substring(r10 + 1);
    L58:
        Iterator r12 = ((ArrayList) i.c).iterator();
    L60:
        if (r12.hasNext() == false) goto L64;
        h r13 = (h) r12.next();
        if (r13.getName().equals(r11) == false) goto L60;
    L65:
        if (r13 == null) goto L45;
        if (g.e(r13).g(r8) == false) goto L73;
        c.a.a.b(r7);
        if (xu3.a.a() == false) goto L45;
        List r14 = a.a;
        b.a("APM-Slardar", "retryPriorityFile success: ".concat(r9));
        goto L45
    L73:
        if (xu3.a.a() == false) goto L104;
        List r15 = a.a;
        b.a("APM-Slardar", "retryPriorityFile failed: " + r9 + ", will retry later");
        return;
    L104:
        return;
    L64:
        r13 = null;
        goto L65
    L57:
        r11 = "";
    L75:
        c.a.a.b(r7);
        goto L45
    L48:
        c.a.a.b(r7);
        goto L45
    L107:
        return;
    L23:
        File[] r16 = r3.listFiles();     // Catch: Throwable -> L76
        if (r16 != null) goto L28;
        r4 = Collections.emptyList();     // Catch: Throwable -> L76
        monitor-exit(r2);
        goto L38
    L28:
        ArrayList r17 = new ArrayList();     // Catch: Throwable -> L76
        int r18 = r16.length;     // Catch: Throwable -> L76
        int r19 = 0;
    L29:
        if (r19 >= r18) goto L34;
        File r20 = r16[r19];     // Catch: Throwable -> L76
        if (r20.getName().startsWith("priority_") == false) goto L33;
        r17.add(r20);     // Catch: Throwable -> L76
    L33:
        r19 = r19 + 1;     // Catch: Throwable -> L76
        goto L29
    L34:
        Collections.sort(r17, new com.bytedance.apm6.consumer.slardar.send.b());     // Catch: Throwable -> L76
        monitor-exit(r2);
        r4 = r17;
    L76:
        th = move-exception;
        throw th;
    }

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

    public d(c r3) {
        this.d = r3;
        super(500);
    }
}
