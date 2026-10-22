package vdc;

import android.view.animation.Animation;
import android.view.animation.Transformation;

/* JADX INFO: loaded from: classes38.dex */
public final class d extends Animation {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ a.d f554317a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ a f554318b;

    public d(a r100, a.d r101) {
        this.f554318b = r100;
        this.f554317a = r101;
    }

    @Override // android.view.animation.Animation
    public final void applyTransformation(float r100, Transformation r101) {
        a.d r102 = this.f554317a;
        float r103 = (float) Math.toRadians(((double) r102.f554299i) / (r102.f554309s * 6.283185307179586d));
        a.d r104 = this.f554317a;
        float r105 = r104.f554304n;
        float r106 = r104.f554303m;
        float r107 = r104.f554305o;
        float r108 = r105 + ((0.8f - r103) * a.f554273n.getInterpolation(r100));
        a.d r109 = this.f554317a;
        r109.f554297g = r108;
        r109.a();
        float r110 = r106 + (a.f554272m.getInterpolation(r100) * 0.8f);
        a.d r111 = this.f554317a;
        r111.f554296f = r110;
        r111.a();
        float r112 = r107 + (0.25f * r100);
        a.d r113 = this.f554317a;
        r113.f554298h = r112;
        r113.a();
        a r114 = this.f554318b;
        r114.f554277c = (r100 * 144.0f) + ((r114.f554280f / 5.0f) * 720.0f);
        r114.invalidateSelf();
    }
}
