package com.larus.dora.impl.device.settings.sound;

/* JADX INFO: loaded from: classes27.dex */
public interface m {

    public static final class a implements m {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f334924a = null;

        static {
            f334924a = new a();
        }

        public a() {
        }
    }

    public static final class b implements m {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b f334925a = null;

        static {
            f334925a = new b();
        }

        public b() {
        }
    }

    public static final class c implements m {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final byte f334926a;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof c) == true) goto L9;
            return false;
        L9:
            if (this.f334926a == ((c) r100).f334926a) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.f334926a;
        }

        public final String toString() {
            return "Success(vol=" + this.f334926a + ')';
        }

        public c(byte r100) {
            this.f334926a = r100;
        }
    }
}
