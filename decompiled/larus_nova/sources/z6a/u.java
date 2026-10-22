package z6a;

import android.graphics.Picture;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.Layout;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadHandlerThreadV2;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes32.dex */
public final class u extends PthreadHandlerThreadV2 {

    public static final class a extends Handler {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Picture f570616a;

        public a(Looper r100) {
            super(r100);
            Picture r101 = new Picture();     // Catch: RuntimeException -> L5
        L6:
            this.f570616a = r101;
            return;
        L5:
            r101 = null;
            goto L6
        }

        @Override // android.os.Handler
        public final void handleMessage(Message r100) {
            if (this.f570616a != null) goto L13;
            return;
        L13:
            if (r100.what != 0) goto L15;
            Layout r101 = (Layout) ((WeakReference) r100.obj).get();     // Catch: Exception -> L12
            if (r101 != null) goto L10;
            return;
        L10:
            r101.draw(this.f570616a.beginRecording(r101.getWidth(), r101.getHeight()));     // Catch: Exception -> L12
            this.f570616a.endRecording();     // Catch: Exception -> L12
            return;
        L15:
            return;
        }
    }

    public u() {
        super("TextLayoutWarmer", 10);
        ThreadMethodProxy.start(this);
    }

    @Override // android.os.HandlerThread
    public final void onLooperPrepared() {
        super.onLooperPrepared();
        new a(Looper.myLooper());
    }
}
