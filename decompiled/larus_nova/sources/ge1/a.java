package ge1;

import android.os.Looper;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.livesdk.app.dataholder.Observer;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes7.dex */
public abstract class a<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<WeakReference<Observer<T>>> f481008a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public T f481009b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f481010c;

    public a() {
        this.f481008a = new ArrayList();
        this.f481010c = true;
    }

    public final void c(Observer<T> r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        Iterator r101 = ((ArrayList) this.f481008a).iterator();
    L6:
        if (r101.hasNext() == false) goto L13;
        WeakReference r102 = (WeakReference) r101.next();
        if (r102.get() == null) goto L9;
        if (r102.get() != r100) goto L6;
        return;
    L9:
        r101.remove();
        goto L6
    L13:
        List<WeakReference<Observer<T>>> r103 = this.f481008a;
        ArrayList r104 = (ArrayList) r103;
        r104.add(new WeakReference(r100));
        if (this.f481010c == false) goto L24;
        r100.onChanged(this.f481009b);
        return;
    }

    public final void d(T r100) {
        if (r100 != this.f481009b) goto L5;
        return;
    L5:
        this.f481009b = r100;
        if (Looper.myLooper() == Looper.getMainLooper()) goto L8;
        ALogger.stacktrace(6, "ttlive_talk_room", ThreadMethodProxy.currentThread().getStackTrace());
    L8:
        Iterator r101 = ((ArrayList) this.f481008a).iterator();
    L10:
        if (r101.hasNext() == false) goto L14;
        if (((WeakReference) r101.next()).get() != null) goto L10;
        r101.remove();
        goto L10
    L14:
        Iterator r102 = new ArrayList(this.f481008a).iterator();
    L16:
        if (r102.hasNext() == false) goto L20;
        WeakReference r103 = (WeakReference) r102.next();
        if (r103.get() == null) goto L16;
        ((Observer) r103.get()).onChanged(this.f481009b);
        goto L16
    }

    public void e(Observer<T> r100) {
        if (Looper.myLooper() == Looper.getMainLooper()) goto L5;
        ALogger.stacktrace(6, "ttlive_talk_room", ThreadMethodProxy.currentThread().getStackTrace());
    L5:
        Iterator r101 = ((ArrayList) this.f481008a).iterator();
    L7:
        if (r101.hasNext() == false) goto L22;
        WeakReference r102 = (WeakReference) r101.next();
        if (r102.get() == null) goto L10;
        if (r102.get() != r100) goto L7;
        r101.remove();
        return;
    L10:
        r101.remove();
        goto L7
    }
}
