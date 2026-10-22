package vb4;

import com.bytedance.bdturing.livedetect.TuringLiveDetectGuideActivity;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class y implements Runnable {
    public final /* synthetic */ TuringLiveDetectGuideActivity a;

    public class a implements Runnable {
        public final /* synthetic */ y a;

        @Override // java.lang.Runnable
        public final void run() {
            this.a.a.k.setVisibility(8);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public a(y r1) {
            this.a = r1;
        }
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.a.k.setVisibility(0);     // Catch: Throwable -> L4
        this.a.k.postDelayed(new a(this), 2000);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }

    public y(TuringLiveDetectGuideActivity r1) {
        this.a = r1;
    }
}
