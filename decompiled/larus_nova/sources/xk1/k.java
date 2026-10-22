package xk1;

import com.bytedance.android.live.core.utils.NetworkUtils;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes7.dex */
public final class k implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ i f564164a;

    public final void a() {
        if (this.f564164a.f564149e != null) goto L6;
        return;
    L6:
        if (NetworkUtils.f(jc1.a.b()) == true) goto L8;
        return;
    L8:
        b r100 = this.f564164a.f564147c;
        Iterator r101 = ((LinkedHashMap) r100.f564128b).entrySet().iterator();
    L10:
        if (r101.hasNext() == false) goto L29;
        o r102 = (o) ((Map.Entry) r101.next()).getValue();
        if (r102 == null) goto L10;
        int r103 = r102.f564175e;
        if (r103 == 7) goto L18;
        if (r103 != 6) goto L10;
    L18:
        r102.c(3);
        p r104 = r100.f564131e;
        if (r104 == null) goto L21;
        i.a r105 = (i.a) r104;
        r105.d(r102.a());
    L21:
        r100.f564129c.clear();
        Iterator r106 = ((LinkedHashMap) r100.f564128b).entrySet().iterator();
    L23:
        if (r106.hasNext() == false) goto L10;
        o r107 = (o) ((Map.Entry) r106.next()).getValue();
        if (r107 == null) goto L23;
        if (r107.f564175e != 3) goto L23;
        r100.f564129c.add(r107);
        goto L23
    L29:
        r100.b();
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

    public k(i r100) {
        this.f564164a = r100;
    }
}
