package z76;

import com.airbnb.lottie.LottieListener;
import com.airbnb.lottie.l;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: classes19.dex */
public final class c implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ d f570670a;

    /* JADX WARN: Multi-variable type inference failed */
    public final void a() {
        if (this.f570670a.f570677g != null) goto L5;
        return;
    L5:
        if (this.f570670a.f570676f.isCancelled() == true) goto L23;
        l<T> r100 = this.f570670a.f570677g;
        V r101 = r100.f24812a;
        if (r101 == 0) goto L13;
        d r102 = this.f570670a;
        r102.getClass();
        Iterator r103 = new ArrayList(r102.f570673c).iterator();
    L11:
        if (r103.hasNext() == false) goto L25;
        ((LottieListener) r103.next()).onResult(r101);
        goto L11
    L25:
        return;
    L13:
        d r104 = this.f570670a;
        Throwable r105 = r100.f24813b;
        r104.getClass();
        ArrayList r106 = new ArrayList(r104.f570674d);
        if (r106.isEmpty() == true) goto L24;
        Iterator r107 = r106.iterator();
    L18:
        if (r107.hasNext() == false) goto L26;
        ((LottieListener) r107.next()).onResult(r105);
        goto L18
    L26:
        return;
    L24:
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

    public c(d r100) {
        this.f570670a = r100;
    }
}
