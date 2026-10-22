package ei9;

import android.view.Choreographer;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

/* JADX INFO: loaded from: classes30.dex */
public final /* synthetic */ class a implements Choreographer.FrameCallback {
    public /* synthetic */ a() {
    }

    @Override // android.view.Choreographer.FrameCallback
    public final void doFrame(long r100) {
        Queue<Runnable> r101 = b.f472787b;
        Runnable r102 = (Runnable) ((ConcurrentLinkedQueue) r101).poll();
        if (r102 == null) goto L5;
        r102.run();
    L5:
        b r103 = b.f472786a;
        if ((!((ConcurrentLinkedQueue) r101).isEmpty()) == false) goto L9;
        Choreographer.getInstance().postFrameCallback(new a());
        return;
    }
}
