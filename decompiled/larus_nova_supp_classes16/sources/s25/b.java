package s25;

import com.ss.android.lark.monitor.callback.CpuCallbackManager;
import io.reactivex.Flowable;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class b implements CpuCallbackManager.a {
    public final /* synthetic */ a a;

    public b(a r1) {
        this.a = r1;
    }

    public final void b(float r3) {
        if (r3 > this.a.a.getDocx_ssr_preload_cpu_limit()) goto L8;
        a r4 = this.a;
        r4.getClass();
        Flowable.just(Boolean.TRUE).subscribeOn(fo5.d.c()).subscribe(new c(r4), d.a);
        CpuCallbackManager r5 = CpuCallbackManager.a();
        if (((CopyOnWriteArrayList) r5.a).contains(this) == false) goto L9;
        ((CopyOnWriteArrayList) r5.a).remove(this);
        return;
    L9:
        return;
    }
}
