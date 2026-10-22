package ht8;

import android.view.View;
import android.view.ViewTreeObserver;

/* JADX INFO: loaded from: classes26.dex */
public final class b implements ViewTreeObserver.OnPreDrawListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ View f487146a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Runnable f487147b;

    @Override // android.view.ViewTreeObserver.OnPreDrawListener
    public final boolean onPreDraw() {
        this.f487146a.getViewTreeObserver().removeOnPreDrawListener(this);
        this.f487147b.run();
        return false;
    }

    public b(View r100, Runnable r101) {
        this.f487146a = r100;
        this.f487147b = r101;
    }
}
