package hp;

import android.widget.LinearLayout;
import com.bytedance.android.ec.window.base.search.history.ECWindowHistoryChip;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes44.dex */
public final class b implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ECWindowHistoryChip f486351a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ LinearLayout.LayoutParams f486352b;

    public b(ECWindowHistoryChip r100, LinearLayout.LayoutParams r101) {
        this.f486351a = r100;
        this.f486352b = r101;
    }

    @Override // java.lang.Runnable
    public final void run() {
        ECWindowHistoryChip r100 = this.f486351a;     // Catch: Throwable -> L4
        r100.addView(r100.f49530b, this.f486352b);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
