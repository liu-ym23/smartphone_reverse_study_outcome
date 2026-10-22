package sga;

import android.view.View;
import android.view.ViewTreeObserver;

/* JADX INFO: loaded from: classes33.dex */
public final class d implements ViewTreeObserver.OnPreDrawListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ View f541891a;

    @Override // android.view.ViewTreeObserver.OnPreDrawListener
    public final boolean onPreDraw() {
        ViewTreeObserver r100 = this.f541891a.getViewTreeObserver();
        if (r100.isAlive() == false) goto L5;
        r100.removeOnPreDrawListener(this);
    L5:
        this.f541891a.post(new c());
        return true;
    }

    public d(View r100) {
        this.f541891a = r100;
    }
}
