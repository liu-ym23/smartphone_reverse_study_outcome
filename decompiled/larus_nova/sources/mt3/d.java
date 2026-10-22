package mt3;

import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.larus.apm.impl.protector.RunnableProtector;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes14.dex */
public final class d extends cv3.a {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ c f515623d;

    public final void a() {
        if (xu3.a.a() == false) goto L6;
        List<String> r100 = a.f515607a;
        av3.b.a("APM-Slardar", "retryPriorityNow: flushing and reporting priority files");
    L6:
        if (this.f515623d.f515617e == null) goto L12;
        this.f515623d.f515617e.b();     // Catch: Throwable -> L9
    L9:
        th = move-exception;
        List<String> r101 = a.f515607a;
        av3.b.c("APM-Slardar", "retryPriorityNow flush error", th);
    L12:
        if (du3.a.o() == false) goto L15;
        this.f515623d.e();
    L15:
        if (du3.a.o() == false) goto L79;
        com.bytedance.apm6.consumer.slardar.send.f.b.f190740a.getClass();
        com.bytedance.apm6.consumer.slardar.send.c r102 = com.bytedance.apm6.consumer.slardar.send.c.a.f190708a;
        monitor-enter(r102);
        r102.c();     // Catch: Throwable -> L76
        PolarisFileWrapper r103 = r102.f190703c;     // Catch: Throwable -> L76
        if (r103 != null) goto L23;
        List r104 = Collections.emptyList();     // Catch: Throwable -> L76
        monitor-exit(r102);
    L38:
        if (r104.isEmpty() == false) goto L41;
        return;
    L41:
        if (xu3.a.a() == false) goto L43;
        List<String> r105 = a.f515607a;
        av3.b.a("APM-Slardar", "retryPriorityFiles: " + r104.size() + " files");
    L43:
        Iterator r106 = r104.iterator();
    L45:
        if (r106.hasNext() == false) goto L107;
        File r107 = (File) r106.next();
        if (r107.exists() == false) goto L48;
        byte[] r108 = xu3.b.b(r107);
        if (r108 == null) goto L75;
        if (r108.length == 0) goto L75;
        String r109 = r107.getName();
        int r110 = r109.lastIndexOf(".");
        if (r110 < 0) goto L57;
        String r111 = r109.substring(r110 + 1);
    L58:
        Iterator r112 = ((ArrayList) com.bytedance.apm6.consumer.slardar.send.i.f190757c).iterator();
    L60:
        if (r112.hasNext() == false) goto L64;
        com.bytedance.apm6.consumer.slardar.send.h r113 = (com.bytedance.apm6.consumer.slardar.send.h) r112.next();
        if (r113.getName().equals(r111) == false) goto L60;
    L65:
        if (r113 == null) goto L45;
        if (com.bytedance.apm6.consumer.slardar.send.g.e(r113).g(r108) == false) goto L73;
        com.bytedance.apm6.consumer.slardar.send.c.a.f190708a.b(r107);
        if (xu3.a.a() == false) goto L45;
        List<String> r114 = a.f515607a;
        av3.b.a("APM-Slardar", "retryPriorityFile success: ".concat(r109));
        goto L45
    L73:
        if (xu3.a.a() == false) goto L104;
        List<String> r115 = a.f515607a;
        av3.b.a("APM-Slardar", "retryPriorityFile failed: " + r109 + ", will retry later");
        return;
    L104:
        return;
    L64:
        r113 = null;
        goto L65
    L57:
        r111 = "";
    L75:
        com.bytedance.apm6.consumer.slardar.send.c.a.f190708a.b(r107);
        goto L45
    L48:
        com.bytedance.apm6.consumer.slardar.send.c.a.f190708a.b(r107);
        goto L45
    L107:
        return;
    L23:
        File[] r116 = r103.listFiles();     // Catch: Throwable -> L76
        if (r116 != null) goto L28;
        r104 = Collections.emptyList();     // Catch: Throwable -> L76
        monitor-exit(r102);
        goto L38
    L28:
        ArrayList r117 = new ArrayList();     // Catch: Throwable -> L76
        int r118 = r116.length;     // Catch: Throwable -> L76
        int r119 = 0;
    L29:
        if (r119 >= r118) goto L34;
        File r120 = r116[r119];     // Catch: Throwable -> L76
        if (r120.getName().startsWith("priority_") == false) goto L33;
        r117.add(r120);     // Catch: Throwable -> L76
    L33:
        r119 = r119 + 1;     // Catch: Throwable -> L76
        goto L29
    L34:
        Collections.sort(r117, new com.bytedance.apm6.consumer.slardar.send.b());     // Catch: Throwable -> L76
        monitor-exit(r102);
        r104 = r117;
    L76:
        th = move-exception;
        throw th;
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

    public d(c r100) {
        this.f515623d = r100;
        super(500);
    }
}
