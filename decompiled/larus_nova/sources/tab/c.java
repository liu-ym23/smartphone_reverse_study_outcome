package tab;

import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.custom.repeat.widget.wheelview.WheelView;

/* JADX INFO: loaded from: classes35.dex */
public final class c implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final WheelView f545222a;

    @Override // java.lang.Runnable
    public final void run() {
        WheelView r100 = this.f545222a;     // Catch: Throwable -> L4
        r100.f420362c.onItemSelected(r100.getCurrentItem());     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }

    public c(WheelView r100) {
        this.f545222a = r100;
    }
}
