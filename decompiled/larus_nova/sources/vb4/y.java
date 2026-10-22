package vb4;

import com.bytedance.bdturing.livedetect.TuringLiveDetectGuideActivity;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes14.dex */
public final class y implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ TuringLiveDetectGuideActivity f554051a;

    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ y f554052a;

        @Override // java.lang.Runnable
        public final void run() {
            this.f554052a.f554051a.f201871k.setVisibility(8);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public a(y r100) {
            this.f554052a = r100;
        }
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f554051a.f201871k.setVisibility(0);     // Catch: Throwable -> L4
        this.f554051a.f201871k.postDelayed(new a(this), 2000);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }

    public y(TuringLiveDetectGuideActivity r100) {
        this.f554051a = r100;
    }
}
