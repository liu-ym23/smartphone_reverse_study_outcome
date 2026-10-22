package v0c;

import android.content.Context;
import android.view.View;

/* JADX INFO: loaded from: classes37.dex */
public abstract class a extends b implements View.OnAttachStateChangeListener {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final View f552348d;

    public void k() {
    }

    public void l() {
    }

    public abstract View m(Context r100);

    public final void o() {
        j(-66001, null);
    }

    public final void p() {
        j(-66007, null);
    }

    public final void n() {
        j(-66015, null);
    }

    public a(Context r100) {
        super(r100);
        View r101 = m(r100);
        this.f552348d = r101;
        r101.addOnAttachStateChangeListener(this);
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewAttachedToWindow(View r100) {
        k();
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewDetachedFromWindow(View r100) {
        l();
    }

    public final void q(int r100) {
        this.f552348d.setVisibility(r100);
    }
}
