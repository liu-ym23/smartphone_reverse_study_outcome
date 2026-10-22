package u;

import kotlin.NoWhenBranchMatchedException;

/* JADX INFO: loaded from: classes28.dex */
public abstract class a {

    /* JADX INFO: renamed from: u.a$a, reason: collision with other inner class name */
    public static final class C7810a extends a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final C7810a f548078a = null;

        static {
            f548078a = new C7810a();
        }

        public C7810a() {
        }
    }

    public static final class b extends a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final float f548079a;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof b) == true) goto L9;
            return false;
        L9:
            if (Float.compare(this.f548079a, ((b) r100).f548079a) == 0) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return Float.floatToIntBits(this.f548079a);
        }

        @Override // u.a
        public final String toString() {
            return "Percent(percentage=" + this.f548079a + ')';
        }

        public b(float r100) {
            this.f548079a = r100;
        }
    }

    public static final class c extends a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final float f548080a;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof c) == true) goto L9;
            return false;
        L9:
            if (Float.compare(this.f548080a, ((c) r100).f548080a) == 0) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return Float.floatToIntBits(this.f548080a);
        }

        @Override // u.a
        public final String toString() {
            return "Points(points=" + this.f548080a + ')';
        }

        public c(float r100) {
            this.f548080a = r100;
        }
    }

    public static final class d extends a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final d f548081a = null;

        static {
            f548081a = new d();
        }

        public d() {
        }
    }

    public a() {
    }

    public final float a() {
        if ((this instanceof c) == false) goto L6;
        return ((c) this).f548080a;
    L6:
        if ((this instanceof b) == false) goto L9;
        return ((b) this).f548079a;
    L9:
        if ((this instanceof d) == false) goto L12;
    L10:
        return 0.0f;
    L12:
        if ((this instanceof C7810a) == true) goto L10;
        throw new NoWhenBranchMatchedException();
    }

    public final int getType() {
        if ((this instanceof c) == false) goto L6;
        return 0;
    L6:
        if ((this instanceof b) == false) goto L9;
        return 1;
    L9:
        if ((this instanceof d) == false) goto L12;
        return 2;
    L12:
        if ((this instanceof C7810a) == false) goto L16;
        return 3;
    L16:
        throw new NoWhenBranchMatchedException();
    }

    public String toString() {
        if ((this instanceof c) == false) goto L6;
        return "Dimension.Points";
    L6:
        if ((this instanceof b) == false) goto L9;
        return "Dimension.Percent(value=" + a() + ')';
    L9:
        if ((this instanceof d) == false) goto L12;
        return "Dimension.Undefined";
    L12:
        if ((this instanceof C7810a) == false) goto L16;
        return "Dimension.Auto";
    L16:
        throw new NoWhenBranchMatchedException();
    }
}
