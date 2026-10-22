package vb4;

import com.bytedance.bdturing.livedetect.TuringLiveByteNNActivity;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes14.dex */
public final class n implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f554040a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ TuringLiveByteNNActivity f554041b;

    @Override // java.lang.Runnable
    public final void run() {
    L7:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L15;
        throw th;
    L15:
        return;
    L3:
        if (this.f554040a != 0) goto L5;
        this.f554041b.L1();     // Catch: Throwable -> L7
        this.f554041b.I1();     // Catch: Throwable -> L7
    L12:
        return;
    L5:
        this.f554041b.N1(new String[]{this.f554041b.getString(R.string.turing_bytenn_model_load_fail_title), this.f554041b.getString(R.string.turing_bytenn_init_error)});     // Catch: Throwable -> L7
        goto L12
    }

    public n(TuringLiveByteNNActivity r100, int r101) {
        this.f554041b = r100;
        this.f554040a = r101;
    }
}
