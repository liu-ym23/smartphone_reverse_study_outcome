package ma7;

import android.util.Property;

/* JADX INFO: loaded from: classes19.dex */
public abstract class a {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final b f512710c = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final float f512711a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public float f512712b;

    /* JADX INFO: renamed from: ma7.a$a, reason: collision with other inner class name */
    public static class C6789a extends a {
        @Override // ma7.a
        public final void a(float r100) {
        }
    }

    public static class b extends Property<a, Float> {
        public b(Class r100) {
            super(r100, "");
        }

        @Override // android.util.Property
        public final /* bridge */ /* synthetic */ Float get(a r100) {
            return null;
        }

        @Override // android.util.Property
        public final void set(a r100, Float r101) {
            r100.a(r101.floatValue());
        }
    }

    public a() {
        this(0);
    }

    public abstract void a(float r100);

    static {
        f512710c = new b(Float.class);
    }

    public a(int r100) {
        this.f512711a = 1.0f;
    }
}
