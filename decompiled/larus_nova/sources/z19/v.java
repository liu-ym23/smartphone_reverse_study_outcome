package z19;

import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.common_ui.widget.SeparatedEditText;
import java.util.TimerTask;

/* JADX INFO: loaded from: classes27.dex */
public final class v extends TimerTask {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ SeparatedEditText f569710a;

    @Override // java.util.TimerTask, java.lang.Runnable
    public final void run() {
        SeparatedEditText r100 = this.f569710a;     // Catch: Throwable -> L4
        r100.D = !r100.D;     // Catch: Throwable -> L4
        r100.postInvalidate();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }

    public v(SeparatedEditText r100) {
        this.f569710a = r100;
    }
}
