package ix6;

import com.bytedance.locallife.pdp.headimage.view.point.MarqueePointView;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes21.dex */
public final class a implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ MarqueePointView f496376a;

    public a(MarqueePointView r100) {
        this.f496376a = r100;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f496376a.f261493a.showNext();     // Catch: Throwable -> L4
        MarqueePointView r100 = this.f496376a;     // Catch: Throwable -> L4
        r100.f261499g = r100.a(r100.f261499g + 1);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
