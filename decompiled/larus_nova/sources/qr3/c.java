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

/* JADX INFO: loaded from: classes14.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AppExecutors f534584a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<pr3.b> f534585b;

    public c(AppExecutors r100) {
        this.f534585b = new CopyOnWriteArrayList();
        this.f534584a = r100;
    }

    public final void a(BDLocation r100) {
        Logger.i("ByteLocationListenerWrapper: handleLocationChanged() is executed.");
        Iterator r101 = ((CopyOnWriteArrayList) this.f534585b).iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        ((pr3.b) r101.next()).onLocationChanged(r100);
        goto L4
    }

    public final void b(BDLocationException r100) {
        Logger.i("ByteLocationListenerWrapper: handleLocationFailed()!");
        Iterator r101 = ((CopyOnWriteArrayList) this.f534585b).iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        ((pr3.b) r101.next()).onError(r100);
        goto L4
    }

    public final void c(final BDLocation r100) {
        if (ThreadMethodProxy.currentThread() != ThreadMethodProxy.getLooperThread(Looper.getMainLooper())) goto L5;
        boolean r101 = true;
    L6:
        if (r101 == false) goto L8;
        a(r100);
        return;
    L8:
        this.f534584a.mainThread().execute(new a(this, r100));
        return;
    L5:
        r101 = false;
        goto L6
    }

    public final void d(final BDLocationException r100) {
        if (ThreadMethodProxy.currentThread() != ThreadMethodProxy.getLooperThread(Looper.getMainLooper())) goto L5;
        boolean r101 = true;
    L6:
        if (r101 == false) goto L8;
        b(r100);
        return;
    L8:
        this.f534584a.mainThread().execute(new b(this, r100));
        return;
    L5:
        r101 = false;
        goto L6
    }
}
