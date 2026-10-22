package vdc;

import android.view.animation.Animation;
import android.view.animation.Transformation;

/* JADX INFO: loaded from: classes38.dex */
public final class b extends Animation {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ a.d f554314a;

    public b(a.d r100) {
        this.f554314a = r100;
    }

    @Override // android.view.animation.Animation
    public final void applyTransformation(float r100, Transformation r101) {
        float r102 = (float) (Math.floor(this.f554314a.f554305o / 0.8f) + 1.0d);
        a.d r103 = this.f554314a;
        float r104 = r103.f554303m;
        r103.f554296f = r104 + ((r103.f554304n - r104) * r100);
        r103.a();
        a.d r105 = this.f554314a;
        float r106 = r105.f554305o;
        r105.f554298h = r106 + ((r102 - r106) * r100);
        r105.a();
        a.d r107 = this.f554314a;
        float r108 = 1.0f - r100;
        if (r108 == r107.f554308r) goto L6;
        r107.f554308r = r108;
        r107.a();
        return;
    }
}
