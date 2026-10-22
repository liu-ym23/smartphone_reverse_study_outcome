package dxb;

import com.larus.apm.impl.protector.RunnableProtector;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes37.dex */
public final class s implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ cxb.a f470509a;

    public s(cxb.a r100, long r101) {
        this.f470509a = r100;
    }

    public final void a() {
        c.a r100 = c.f470456a;
        cxb.a r101 = this.f470509a;
        int r102 = com.ss.android.lark.officesdk.utils.di.l.f437227a;
        ntb.o r103 = com.ss.android.lark.officesdk.utils.di.l.a.a();
        if (r103 == null) goto L6;
        ntb.o.a r104 = r103.d();
        if (r104 == null) goto L6;
    L7:
        Intrinsics.checkNotNullParameter("duration", "key");
        r104.a("duration");
        if (r101 != null) goto L23;
        Map<String, Object> r105 = null;
    L13:
        if (r105 == null) goto L17;
        boolean r106 = true;
        if ((!r105.isEmpty()) != true) goto L17;
    L18:
        if (r106 == false) goto L20;
        r104.b();     // Catch: Throwable -> L10
    L20:
        r104.flush();     // Catch: Throwable -> L10
        return;
    L10:
        th = move-exception;
        throw th;
    L17:
        r106 = false;
        goto L18
    L23:
        r105 = r101.getCommonParams();     // Catch: Throwable -> L10
    L6:
        r104 = new com.ss.android.lark.officesdk.utils.di.k();
        goto L7
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
