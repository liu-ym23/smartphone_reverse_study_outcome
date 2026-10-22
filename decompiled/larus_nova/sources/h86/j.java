package h86;

import com.bytedance.ies.xelement.picker.view.WheelView;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes19.dex */
public final class j implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ WheelView f484225a;

    @Override // java.lang.Runnable
    public final void run() {
        WheelView r100 = this.f484225a;     // Catch: Throwable -> L4
        r100.f250237e.onItemSelected(r100.getCurrentItem());     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }

    public j(WheelView r100) {
        this.f484225a = r100;
    }
}
