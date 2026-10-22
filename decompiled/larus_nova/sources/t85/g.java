package t85;

import android.os.Looper;
import androidx.lifecycle.Observer;
import com.bytedance.ee.bear.drive.view.preview.wrapper.a0;
import com.bytedance.ee.util.ui.m;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;

/* JADX INFO: loaded from: classes16.dex */
public final class g<DATA> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Observer<DATA> f545049a;

    public g() {
    }

    public final void a(final a0 r100) {
        if (ThreadMethodProxy.currentThread() != ThreadMethodProxy.getLooperThread(Looper.getMainLooper())) goto L7;
        Observer<DATA> r101 = this.f545049a;
        if (r101 == null) goto L9;
        r101.onChanged(r100);
        return;
    L9:
        return;
    L7:
        m.a(new f(this, r100));
    }
}
