package yk9;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes30.dex */
public interface a {

    /* JADX INFO: renamed from: yk9.a$a, reason: collision with other inner class name */
    public static final class C8349a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f568265a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f568266b;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof C8349a) == true) goto L8;
            return false;
        L8:
            C8349a r101 = (C8349a) r100;
            if (this.f568265a == r101.f568265a) goto L12;
            return false;
        L12:
            if (this.f568266b == r101.f568266b) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            return (this.f568265a * 31) + this.f568266b;
        }

        public final String toString() {
            return "AudioFormatRequest(sampleRate=" + this.f568265a + ", channel=" + this.f568266b + ')';
        }

        public C8349a(int r100, int r101) {
            this.f568265a = r100;
            this.f568266b = r101;
        }
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final boolean f568267a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f568268b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final String f568269c;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof b) == true) goto L8;
            return false;
        L8:
            b r101 = (b) r100;
            if (this.f568267a == r101.f568267a) goto L12;
            return false;
        L12:
            if (this.f568268b == r101.f568268b) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.f568269c, r101.f568269c) == true) goto L17;
            return false;
        L17:
            return true;
        }

        public final int hashCode() {
            if (this.f568267a == false) goto L5;
            int r100 = 1231;
        L6:
            int r101 = ((r100 * 31) + this.f568268b) * 31;
            String r102 = this.f568269c;
            if (r102 != null) goto L9;
            int r103 = 0;
        L11:
            return r101 + r103;
        L9:
            r103 = r102.hashCode();
            goto L11
        L5:
            r100 = 1237;
            goto L6
        }

        public final String toString() {
            return "InitResult(success=" + this.f568267a + ", bufferSize=" + this.f568268b + ", errorMessage=" + this.f568269c + ')';
        }

        public b(boolean r100, int r101, String r102) {
            this.f568267a = r100;
            this.f568268b = r101;
            this.f568269c = r102;
        }
    }

    public static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final boolean f568270a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f568271b;

        public /* synthetic */ c() {
            this(true, null);
        }

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof c) == true) goto L8;
            return false;
        L8:
            c r101 = (c) r100;
            if (this.f568270a == r101.f568270a) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f568271b, r101.f568271b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            if (this.f568270a == false) goto L5;
            int r100 = 1231;
        L6:
            int r101 = r100 * 31;
            String r102 = this.f568271b;
            if (r102 != null) goto L9;
            int r103 = 0;
        L11:
            return r101 + r103;
        L9:
            r103 = r102.hashCode();
            goto L11
        L5:
            r100 = 1237;
            goto L6
        }

        public final String toString() {
            return "StartResult(success=" + this.f568270a + ", errorMessage=" + this.f568271b + ')';
        }

        public c(boolean r100, String r101) {
            this.f568270a = r100;
            this.f568271b = r101;
        }
    }

    b a(C8349a r100);

    void close();

    void pause();

    int read(byte[] r100, int r101);

    c startCapture();
}
