package v0c;

import android.view.MotionEvent;

/* JADX INFO: loaded from: classes37.dex */
public final class d implements p.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ MotionEvent f552354a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ MotionEvent f552355b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ float f552356c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ float f552357d;

    @Override // v0c.p.a
    public final void a(o r100) {
        ((y0c.b) r100).onScroll(this.f552354a, this.f552355b, this.f552356c, this.f552357d);
    }

    public d(MotionEvent r100, MotionEvent r101, float r102, float r103) {
        this.f552354a = r100;
        this.f552355b = r101;
        this.f552356c = r102;
        this.f552357d = r103;
    }
}
