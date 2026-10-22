package com.google.common.math;

/* JADX INFO: loaded from: classes23.dex */
@ElementTypesAreNonnullByDefault
public abstract class d {

    public static final class a extends d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f275627a = null;

        public final String toString() {
            return "NaN";
        }

        static {
            f275627a = new a();
        }

        public a() {
        }
    }

    public static final class b extends d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final double f275628a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final double f275629b;

        public final String toString() {
            return String.format("y = %g * x + %g", new Object[]{Double.valueOf(this.f275628a), Double.valueOf(this.f275629b)});
        }

        public b(double r100, double r101) {
            this.f275628a = r100;
            this.f275629b = r101;
        }
    }

    public static final class c extends d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final double f275630a;

        public final String toString() {
            return String.format("x = %g", new Object[]{Double.valueOf(this.f275630a)});
        }

        public c(double r100) {
            this.f275630a = r100;
        }
    }

    public d() {
    }
}
