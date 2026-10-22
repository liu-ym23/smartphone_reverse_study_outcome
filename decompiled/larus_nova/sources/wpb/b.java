package wpb;

import android.graphics.Bitmap;
import com.larus.apm.impl.protector.RunnableProtector;
import io.reactivex.FlowableEmitter;

/* JADX INFO: loaded from: classes36.dex */
public final class b implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ FlowableEmitter<Bitmap> f560660a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Bitmap f560661b;

    public b(FlowableEmitter<Bitmap> r100, Bitmap r101) {
        this.f560660a = r100;
        this.f560661b = r101;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f560660a.onNext(this.f560661b);     // Catch: Throwable -> L4
        this.f560660a.onComplete();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
