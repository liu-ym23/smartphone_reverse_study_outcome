package vs4;

import com.larus.apm.impl.protector.RunnableProtector;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes15.dex */
public final class v implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ t f557049a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ List<String> f557050b;

    public v(t r100, List<String> r101) {
        this.f557049a = r100;
        this.f557050b = r101;
    }

    public final void a() {
        if (((ArrayList) this.f557049a.f557042c).isEmpty() == false) goto L5;
        t r100 = this.f557049a;
        r100.f557044e.postDelayed(r100.f557045f, t.f557039g);
    L5:
        List<String> r101 = this.f557049a.f557042c;
        ArrayList r102 = (ArrayList) r101;
        r102.addAll(this.f557050b);
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
