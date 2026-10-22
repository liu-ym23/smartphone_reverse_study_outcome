package qs7;

import com.dtf.face.config.OSSConfig;
import com.dtf.face.log.RecordService;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: classes22.dex */
public final class d implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ c f534685a;

    public final void a() {
        c r100 = this.f534685a;
        if (r100.f534681d != null) goto L5;
        RecordService.getInstance().recordEvent(2, "VerifyTask", new String[]{"errMsg", "uploadOSSContentNull"});
        return;
    L5:
        os7.a.f526516l.b();
        List<os7.a.b> r101 = r100.f534681d.f534673a;
        if (r101 != null) goto L8;
    L25:
        r100.f534681d.getClass();
        os7.a r102 = os7.a.f526516l;
        e r103 = new e(r100);
        r102.f526523g = 0;
        r102.f526526j = false;
        Iterator<os7.a.b> r104 = r102.f526517a.iterator();
    L27:
        if (r104.hasNext() == false) goto L39;
        os7.a.b r105 = r104.next();
        OSSConfig r106 = r105.f526533e;
        String r107 = r105.f526531c;
        if (r107 == null) goto L36;
        String r108 = r106.chameleonFileNamePrefix;
        if (r108 == null) goto L36;
        if (r107.startsWith(r108) == false) goto L36;
        r102.f526518b.add(r105);
    L36:
        if (r105.f526534f == true) goto L37;
        r102.f526519c.add(r105);
        goto L27
    L37:
        r102.f526520d.add(r105);
        goto L27
    L39:
        r102.c(0, r102.f526527k, r103);
        return;
    L8:
        if (((CopyOnWriteArrayList) r101).size() <= 0) goto L25;
        Iterator r109 = ((CopyOnWriteArrayList) r100.f534681d.f534673a).iterator();
    L11:
        if (r109.hasNext() == false) goto L25;
        os7.a.b r110 = (os7.a.b) r109.next();
        os7.a r111 = os7.a.f526516l;
        if (r110 == null) goto L14;
        Object r112 = r111.f526522f;
        monitor-enter(r112);
        r111.f526517a.add(r110);     // Catch: Throwable -> L22
        monitor-exit(r112);     // Catch: Throwable -> L22
        if (r110.f526529a <= r111.f526521e.get()) goto L11;
        r111.f526521e.set(r110.f526529a + 1);
    L22:
        th = move-exception;
        throw th;
    L14:
        r111.getClass();
        goto L11
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
        this.f534685a = r100;
    }
}
