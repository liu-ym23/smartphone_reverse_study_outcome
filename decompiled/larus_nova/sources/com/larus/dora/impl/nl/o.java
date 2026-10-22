package com.larus.dora.impl.nl;

/* JADX INFO: loaded from: classes27.dex */
public abstract class o {

    public static final class a extends o {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final boolean f336377a;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof a) == true) goto L9;
            return false;
        L9:
            if (this.f336377a == ((a) r100).f336377a) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            if (this.f336377a == false) goto L5;
            return 1231;
        L5:
            return 1237;
        }

        public final String toString() {
            return "ChangeSwitchState(state=" + this.f336377a + ')';
        }

        public a(boolean r100) {
            this.f336377a = r100;
        }
    }

    public static final class b extends o {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b f336378a = null;

        static {
            f336378a = new b();
        }

        public b() {
        }
    }

    public o() {
    }
}
