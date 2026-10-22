package vfc;

import android.view.View;
import android.widget.RelativeLayout;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes38.dex */
public final class j implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ View f554649a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ o f554650b;

    public final void a() {
        o r100 = this.f554650b;
        View r101 = this.f554649a;
        r100.getClass();
        int r102 = ((RelativeLayout) r101.getParent()).getHeight() - (r101.getHeight() * 2);
        r100.f554658c.setRepeatMode(1);
        r100.f554658c.setRepeatCount(-1);
        r100.f554658c.addUpdateListener(new n(r101, r102));
        r100.f554658c.start();
    }

    @Override // java.lang.Runnable
    public final void run() {
        a();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }

    public j(o r100, View r101) {
        this.f554650b = r100;
        this.f554649a = r101;
    }
}
