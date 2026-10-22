package com.ss.android.lark.keyboard.classicinput.base;

import android.view.View;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.widget.slidingup.SlidingUpPanelLayout;

/* JADX INFO: loaded from: classes36.dex */
public final class g implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ SlidingUpPanelLayout f428695a;

    public g(SlidingUpPanelLayout r100) {
        this.f428695a = r100;
    }

    @Override // java.lang.Runnable
    public final void run() {
    L16:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L27;
        throw th;
    L27:
        return;
    L3:
        if (this.f428695a.isEnabled() == true) goto L5;
        return;
    L5:
        if (this.f428695a.getVisibility() == 8) goto L23;
        View r100 = this.f428695a.getDragView();     // Catch: Throwable -> L16
        if (r100 != null) goto L11;
        return;
    L11:
        if (r100.getVisibility() == 0) goto L13;
        return;
    L13:
        if (r100.getY() >= (this.f428695a.getHeight() - r100.getHeight())) goto L26;
        this.f428695a.setPanelState(SlidingUpPanelLayout.PanelState.COLLAPSED);     // Catch: Throwable -> L16
        return;
    L26:
        return;
    }
}
