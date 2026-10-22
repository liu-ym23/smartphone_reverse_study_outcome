package vb4;

import com.bytedance.bdturing.livedetect.TuringLiveByteNNActivity;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class n implements Runnable {
    public final /* synthetic */ int a;
    public final /* synthetic */ TuringLiveByteNNActivity b;

    @Override // java.lang.Runnable
    public final void run() {
    L7:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L15;
        throw th;
    L15:
        return;
    L3:
        if (this.a != 0) goto L5;
        this.b.L1();     // Catch: Throwable -> L7
        this.b.I1();     // Catch: Throwable -> L7
    L12:
        return;
    L5:
        this.b.N1(new String[]{this.b.getString(2131923575), this.b.getString(2131923571)});     // Catch: Throwable -> L7
        goto L12
    }

    public n(TuringLiveByteNNActivity r1, int r2) {
        this.b = r1;
        this.a = r2;
    }
}
