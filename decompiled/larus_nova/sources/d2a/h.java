package d2a;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.view.animation.Interpolator;

/* JADX INFO: loaded from: classes31.dex */
public class h implements j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Animator f466566a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f466567b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Interpolator f466568c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final e f466569d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final e f466570e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final e f466571f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final e f466572g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final ObjectAnimator f466573h;

    public h(int r100) {
        this.f466566a = null;
        this.f466567b = 100;
        e r101 = g.f466565a;
        this.f466569d = r101;
        this.f466570e = r101;
        this.f466571f = r101;
        this.f466572g = r101;
        this.f466573h = new ObjectAnimator();
    }

    @Override // d2a.j
    public final void b(Interpolator r100) {
        this.f466568c = r100;
    }

    @Override // d2a.j
    public final void setDuration(long r100) {
        this.f466567b = r100;
    }
}
