package sc5;

import android.view.View;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class h implements Runnable {
    public final /* synthetic */ c a;
    public final /* synthetic */ View b;

    public h(c r1, View r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void a() {
        if (com.bytedance.ee.util.ui.b.a(this.a.getActivity()) == true) goto L5;
        return;
    L5:
        c r0 = this.a;
        View r1 = this.b;
        r0.getClass();
        if (r1 != null) goto L8;
        tt5.a.d("HomeDriveOnBoarding", "show home drive onboarding failed, view == null");
        return;
    L8:
        f r2 = new f(r0, r1);
        ((sk5.b) org.koin.java.a.c(sk5.b.class, null, null, 6)).b().e().subscribe(new d(r2, r0), e.a);
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
