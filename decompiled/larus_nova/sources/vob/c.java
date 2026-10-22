package vob;

import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;

/* JADX INFO: loaded from: classes36.dex */
public abstract class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f556532a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final a f556533b = null;

    public static class a extends c {
        @Override // vob.c
        public final float a(float r100) {
            return r100;
        }

        @Override // vob.c
        public final float b(float r100) {
            return r100;
        }

        public a() {
        }
    }

    public static class b extends c {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final Interpolator f556534c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final Interpolator f556535d;

        public b() {
            this.f556534c = new AccelerateInterpolator(3.0f);
            this.f556535d = new DecelerateInterpolator(3.0f);
        }

        @Override // vob.c
        public final float a(float r100) {
            return ((AccelerateInterpolator) this.f556534c).getInterpolation(r100);
        }

        @Override // vob.c
        public final float b(float r100) {
            return ((DecelerateInterpolator) this.f556535d).getInterpolation(r100);
        }

        @Override // vob.c
        public final float c(float r100) {
            return 1.0f / ((1.0f - a(r100)) + b(r100));
        }
    }

    public c() {
    }

    public abstract float a(float r100);

    public abstract float b(float r100);

    public float c(float r100) {
        return 1.0f;
    }

    static {
        f556532a = new b();
        f556533b = new a();
    }
}
