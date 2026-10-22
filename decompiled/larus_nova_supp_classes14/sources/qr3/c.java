package qr3;

import android.os.Looper;
import com.bytedance.bdlocation.BDLocation;
import com.bytedance.bdlocation.exception.BDLocationException;
import com.bytedance.bdlocation.log.Logger;
import com.bytedance.bdlocation.thread.AppExecutors;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class c {
    public final AppExecutors a;
    public final List<pr3.b> b;

    public c(AppExecutors r2) {
        this.b = new CopyOnWriteArrayList();
        this.a = r2;
    }

    public final void a(BDLocation r3) {
        Logger.i("ByteLocationListenerWrapper: handleLocationChanged() is executed.");
        Iterator r0 = ((CopyOnWriteArrayList) this.b).iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((pr3.b) r0.next()).onLocationChanged(r3);
        goto L4
    }

    public final void b(BDLocationException r3) {
        Logger.i("ByteLocationListenerWrapper: handleLocationFailed()!");
        Iterator r0 = ((CopyOnWriteArrayList) this.b).iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((pr3.b) r0.next()).onError(r3);
        goto L4
    }

    public final void c(final BDLocation r3) {
        if (ThreadMethodProxy.currentThread() != ThreadMethodProxy.getLooperThread(Looper.getMainLooper())) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L8;
        a(r3);
        return;
    L8:
        this.a.mainThread().execute(new a(this, r3));
        return;
    L5:
        r0 = false;
        goto L6
    }

    public final void d(final BDLocationException r3) {
        if (ThreadMethodProxy.currentThread() != ThreadMethodProxy.getLooperThread(Looper.getMainLooper())) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L8;
        b(r3);
        return;
    L8:
        this.a.mainThread().execute(new b(this, r3));
        return;
    L5:
        r0 = false;
        goto L6
    }
}
