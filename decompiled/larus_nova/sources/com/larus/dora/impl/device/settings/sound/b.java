package com.larus.dora.impl.device.settings.sound;

/* JADX INFO: loaded from: classes27.dex */
public interface b {

    public static final class a implements b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f334909a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f334910b;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof a) == true) goto L8;
            return false;
        L8:
            a r101 = (a) r100;
            if (this.f334909a == r101.f334909a) goto L12;
            return false;
        L12:
            if (this.f334910b == r101.f334910b) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            return (this.f334909a * 31) + this.f334910b;
        }

        public final String toString() {
            return "FAILED(targetState=" + this.f334909a + ", reason=" + this.f334910b + ')';
        }

        public a(int r100, int r101) {
            this.f334909a = r100;
            this.f334910b = r101;
        }
    }

    /* JADX INFO: renamed from: com.larus.dora.impl.device.settings.sound.b$b, reason: collision with other inner class name */
    public static final class C4240b implements b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f334911a;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof C4240b) == true) goto L9;
            return false;
        L9:
            if (this.f334911a == ((C4240b) r100).f334911a) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.f334911a;
        }

        public final String toString() {
            return "SUCCESS(targetState=" + this.f334911a + ')';
        }

        public C4240b(int r100) {
            this.f334911a = r100;
        }
    }
}
