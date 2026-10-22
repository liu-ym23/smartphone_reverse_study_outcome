package v0c;

import android.view.MotionEvent;

/* JADX INFO: loaded from: classes37.dex */
public final class l implements p.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ MotionEvent f552368a;

    public l(MotionEvent r100) {
        this.f552368a = r100;
    }

    @Override // v0c.p.a
    public final void a(o r100) {
        ((y0c.b) r100).onSingleTapUp(this.f552368a);
    }
}
