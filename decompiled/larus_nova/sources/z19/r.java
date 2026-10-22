package z19;

import android.view.MotionEvent;

/* JADX INFO: loaded from: classes27.dex */
public final class r implements j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Float f569704a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Float f569705b;

    public r() {
    }

    @Override // z19.j
    public final Float getLastMotionX() {
        return this.f569704a;
    }

    @Override // z19.j
    public final Float getLastMotionY() {
        return this.f569705b;
    }

    public final void a(MotionEvent r100) {
        if (r100 == null) goto L5;
        this.f569704a = Float.valueOf(r100.getX());
        this.f569705b = Float.valueOf(r100.getY());
        return;
    }
}
