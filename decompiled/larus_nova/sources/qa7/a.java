package qa7;

import android.view.View;

/* JADX INFO: loaded from: classes19.dex */
public final class a {

    /* JADX INFO: renamed from: qa7.a$a, reason: collision with other inner class name */
    public static class C7302a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final float f532261a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final float f532262b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final float f532263c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final float f532264d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final float f532265e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final float f532266f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final float f532267g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final float f532268h;

        public C7302a(float r100, float r101, float r102, float r103, float r104, float r105, float r106, float r107) {
            this.f532261a = r100;
            this.f532262b = r101;
            this.f532263c = r102;
            this.f532264d = r103;
            this.f532265e = r104;
            this.f532266f = r105;
            this.f532267g = r106;
            this.f532268h = r107;
        }
    }

    public static C7302a a(View r110) {
        return new C7302a(r110.getTranslationX(), r110.getTranslationY(), r110.getScaleX(), r110.getScaleY(), r110.getRotation(), r110.getRotationX(), r110.getRotationY(), r110.getAlpha());
    }

    public static void b(View r100) {
        r100.setTranslationX(0.0f);
        r100.setTranslationY(0.0f);
        r100.setScaleX(1.0f);
        r100.setScaleY(1.0f);
        r100.setRotation(0.0f);
        r100.setRotationX(0.0f);
        r100.setRotationY(0.0f);
        r100.setAlpha(1.0f);
        r100.clearAnimation();
    }

    public static void c(View r100, C7302a r101) {
        r100.setTranslationX(r101.f532261a);
        r100.setTranslationY(r101.f532262b);
        r100.setScaleX(r101.f532263c);
        r100.setScaleY(r101.f532264d);
        r100.setRotation(r101.f532265e);
        r100.setRotationX(r101.f532266f);
        r100.setRotationY(r101.f532267g);
        r100.setAlpha(r101.f532268h);
    }
}
