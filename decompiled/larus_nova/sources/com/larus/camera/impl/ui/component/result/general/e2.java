package com.larus.camera.impl.ui.component.result.general;

/* JADX INFO: loaded from: classes26.dex */
public abstract class e2 {

    public static final class a extends e2 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f322256a;

        public a() {
            this(0);
        }

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof a) == true) goto L9;
            return false;
        L9:
            if (this.f322256a == ((a) r100).f322256a) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.f322256a;
        }

        public final String toString() {
            return "BottomAlignFocusBottom(margin=" + this.f322256a + ')';
        }

        public a(int r100) {
            this.f322256a = 0;
        }
    }

    public static final class b extends e2 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f322257a;

        public b() {
            this(0);
        }

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof b) == true) goto L9;
            return false;
        L9:
            if (this.f322257a == ((b) r100).f322257a) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.f322257a;
        }

        public final String toString() {
            return "BottomAlignScreenBottom(margin=" + this.f322257a + ')';
        }

        public b(int r100) {
            this.f322257a = r100;
        }
    }

    public static final class c extends e2 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final c f322258a = null;

        static {
            f322258a = new c();
        }

        public c() {
        }
    }

    public e2() {
    }
}
