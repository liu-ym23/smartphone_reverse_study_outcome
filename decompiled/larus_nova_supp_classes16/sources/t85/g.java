package t85;

import android.os.Looper;
import androidx.lifecycle.Observer;
import com.bytedance.ee.bear.drive.view.preview.wrapper.a0;
import com.bytedance.ee.util.ui.m;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class g<DATA> {
    public Observer<DATA> a;

    public g() {
    }

    public final void a(final a0 r3) {
        if (ThreadMethodProxy.currentThread() != ThreadMethodProxy.getLooperThread(Looper.getMainLooper())) goto L7;
        Observer<DATA> r0 = this.a;
        if (r0 == null) goto L9;
        r0.onChanged(r3);
        return;
    L9:
        return;
    L7:
        m.a(new f(this, r3));
    }
}
