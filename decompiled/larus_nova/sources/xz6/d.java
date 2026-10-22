package xz6;

import wz6.g;

/* JADX INFO: loaded from: classes21.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public float f565540a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public float f565541b;

    public static class a extends g<d> {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final a f565542b = null;

        @Override // wz6.g
        public final Object[] a() {
            return new d[3];
        }

        static {
            f565542b = new a();
        }

        public a() {
        }
    }

    public d() {
        this(1.0f, 1.0f);
    }

    public final String toString() {
        return this.f565540a + "x" + this.f565541b;
    }

    public d(float r100, float r101) {
        this.f565540a = r100;
        this.f565541b = r101;
    }
}
