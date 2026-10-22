package com.google.common.base;

import org.bouncycastle.pqc.math.linearalgebra.Matrix;

/* JADX INFO: loaded from: classes23.dex */
@ElementTypesAreNonnullByDefault
public abstract class b implements n<Character> {

    public static final class a extends e {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final a f274708b = null;

        @Override // com.google.common.base.b
        public final boolean c(char r100) {
            if (r100 > 127) goto L5;
            return true;
        L5:
            return false;
        }

        static {
            f274708b = new a();
        }

        public a() {
            super("CharMatcher.ascii()");
        }
    }

    /* JADX INFO: renamed from: com.google.common.base.b$b, reason: collision with other inner class name */
    public static abstract class AbstractC3847b extends b {
        public AbstractC3847b() {
        }

        @Override // com.google.common.base.n
        public final boolean apply(Character r100) {
            return c(r100.charValue());
        }
    }

    public static final class c extends AbstractC3847b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final char f274709a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final char f274710b;

        public final String toString() {
            return "CharMatcher.inRange('" + b.a(this.f274709a) + "', '" + b.a(this.f274710b) + "')";
        }

        public c() {
            this.f274709a = 'A';
            this.f274710b = Matrix.MATRIX_TYPE_ZERO;
        }

        @Override // com.google.common.base.b
        public final boolean c(char r100) {
            if (this.f274709a <= r100) goto L5;
        L7:
            return false;
        L5:
            if (r100 > this.f274710b) goto L7;
            return true;
        }
    }

    public static final class d extends AbstractC3847b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final char f274711a;

        public final String toString() {
            return "CharMatcher.is('" + b.a(this.f274711a) + "')";
        }

        public d(char r100) {
            this.f274711a = r100;
        }

        @Override // com.google.common.base.b
        public final boolean c(char r100) {
            if (r100 != this.f274711a) goto L5;
            return true;
        L5:
            return false;
        }
    }

    public static abstract class e extends AbstractC3847b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f274712a;

        public final String toString() {
            return this.f274712a;
        }

        public e(String r100) {
            this.f274712a = r100;
        }
    }

    public static final class f extends e {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final f f274713b = null;

        @Override // com.google.common.base.b
        public final boolean c(char r100) {
            return false;
        }

        static {
            f274713b = new f();
        }

        public f() {
            super("CharMatcher.none()");
        }

        @Override // com.google.common.base.b
        public final int b(CharSequence r100, int r101) {
            m.m(r101, r100.length());
            return -1;
        }
    }

    public b() {
    }

    public abstract boolean c(char r100);

    public static String a(char r100) {
        char[] r101 = {'\\', 'u', 0, 0, 0, 0};
        int r102 = 0;
    L4:
        if (r102 >= 4) goto L7;
        r101[5 - r102] = "0123456789ABCDEF".charAt(r100 & 15);
        r100 = (char) (r100 >> 4);
        r102 = r102 + 1;
        goto L4
    L7:
        return String.copyValueOf(r101);
    }

    public int b(CharSequence r100, int r101) {
        int r102 = r100.length();
        m.m(r101, r102);
    L3:
        if (r101 >= r102) goto L8;
        if (c(r100.charAt(r101)) == true) goto L6;
        r101 = r101 + 1;
        goto L3
    L6:
        return r101;
    L8:
        return -1;
    }
}
