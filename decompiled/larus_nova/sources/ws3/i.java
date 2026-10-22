package ws3;

import com.bytedance.apm.util.n;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes14.dex */
public final class i implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f561003a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ boolean f561004b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ k f561005c;

    public final void a() {
        k r100 = this.f561005c;
        if (r100.f561022r != null) goto L5;
        r100.f561022r = new HashMap();
    L5:
        long r101 = System.currentTimeMillis();
        this.f561005c.f561022r.put(this.f561003a, new n(Long.valueOf(r101), Long.valueOf(this.f561005c.f561026v.a())));
        k r102 = this.f561005c;
        if (r102.f561023s != null) goto L8;
        r102.f561023s = new HashMap();
    L8:
        this.f561005c.f561023s.put(this.f561003a, new n(Long.valueOf(r101), Long.valueOf(this.f561005c.f561026v.f561029a.e())));
        k r103 = this.f561005c;
        if (r103.f561024t != null) goto L11;
        r103.f561024t = new HashMap();
    L11:
        this.f561005c.f561024t.put(this.f561003a, new n(Long.valueOf(r101), Long.valueOf(this.f561005c.f561026v.f561029a.g())));
        if (this.f561004b == false) goto L18;
        d r104 = d.b.f560968a;
        String r105 = this.f561003a;
        if (r104.f560962k != null) goto L16;
        r104.f560962k = new HashMap();
    L16:
        Map<String, Map<String, d.a>> r106 = r104.f560962k;
        HashMap r107 = (HashMap) r106;
        r107.put(r105, new HashMap());
        return;
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

    public i(k r100, String r101, boolean r102) {
        this.f561005c = r100;
        this.f561003a = r101;
        this.f561004b = r102;
    }
}
