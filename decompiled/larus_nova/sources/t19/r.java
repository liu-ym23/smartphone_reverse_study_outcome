package t19;

import com.larus.utils.logger.FLogger;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes27.dex */
public final /* synthetic */ class r implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ s.a f544206a;

    public /* synthetic */ r(s.a r100) {
        this.f544206a = r100;
    }

    @Override // java.lang.Runnable
    public final void run() {
        s.a r100 = this.f544206a;
        AtomicReference<u19.f> r101 = s.f544208b;
        if (r101.get() != r100.f544209a) goto L5;
        FLogger.f375446a.d("ToastLogger", "clear toast holder by handle dismiss");
        r101.set(null);
    L5:
        r100.f544209a.dismiss();
    }
}
