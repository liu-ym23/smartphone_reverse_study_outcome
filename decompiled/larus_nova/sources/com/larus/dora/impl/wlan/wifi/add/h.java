package com.larus.dora.impl.wlan.wifi.add;

/* JADX INFO: loaded from: classes27.dex */
public interface h {

    public static final class a implements h {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f338289a;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof a) == true) goto L9;
            return false;
        L9:
            if (this.f338289a == ((a) r100).f338289a) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.f338289a;
        }

        public final String toString() {
            return "ConnectFailed(errorCode=" + this.f338289a + ')';
        }

        public a(int r100) {
            this.f338289a = r100;
        }
    }

    public static final class b implements h {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b f338290a = null;

        static {
            f338290a = new b();
        }

        public b() {
        }
    }

    public static final class c implements h {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final c f338291a = null;

        static {
            f338291a = new c();
        }

        public c() {
        }
    }
}
