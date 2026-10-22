package com.relax.relaxframework;

/* JADX INFO: loaded from: classes34.dex */
public abstract class s0 {

    public static final class a extends s0 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final double f405259a;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof a) == true) goto L9;
            return false;
        L9:
            if (Double.compare(this.f405259a, ((a) r100).f405259a) == 0) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            long r100 = Double.doubleToLongBits(this.f405259a);
            return (int) (r100 ^ (r100 >>> 32));
        }

        public final String toString() {
            return "DoubleValue(value=" + this.f405259a + ')';
        }

        public a(double r100) {
            this.f405259a = r100;
        }
    }

    public static final class b extends s0 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f405260a;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof b) == true) goto L9;
            return false;
        L9:
            if (this.f405260a == ((b) r100).f405260a) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.f405260a;
        }

        public final String toString() {
            return "IntValue(value=" + this.f405260a + ')';
        }

        public b(int r100) {
            this.f405260a = r100;
        }
    }

    public static final class c extends s0 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final long f405261a;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof c) == true) goto L9;
            return false;
        L9:
            if (this.f405261a == ((c) r100).f405261a) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            long r100 = this.f405261a;
            return (int) (r100 ^ (r100 >>> 32));
        }

        public final String toString() {
            return "LongValue(value=" + this.f405261a + ')';
        }

        public c(long r100) {
            this.f405261a = r100;
        }
    }

    public s0() {
    }

    public final double a() {
        if ((this instanceof a) == false) goto L6;
        return ((a) this).f405259a;
    L6:
        if ((this instanceof b) == false) goto L9;
        return ((b) this).f405260a;
    L9:
        if ((this instanceof c) == false) goto L13;
        return ((c) this).f405261a;
    L13:
        throw new Error("Illegal conversion");
    }
}
