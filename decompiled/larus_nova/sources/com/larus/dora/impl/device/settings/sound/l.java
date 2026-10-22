package com.larus.dora.impl.device.settings.sound;

/* JADX INFO: loaded from: classes27.dex */
public interface l {

    public static final class a implements l {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f334921a = null;

        static {
            f334921a = new a();
        }

        public a() {
        }
    }

    public static final class b implements l {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b f334922a = null;

        static {
            f334922a = new b();
        }

        public b() {
        }
    }

    public static final class c implements l {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final boolean f334923a;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof c) == true) goto L9;
            return false;
        L9:
            if (this.f334923a == ((c) r100).f334923a) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            if (this.f334923a == false) goto L5;
            return 1231;
        L5:
            return 1237;
        }

        public final String toString() {
            return "Success(isAmbientVolumeEnabled=" + this.f334923a + ')';
        }

        public c(boolean r100) {
            this.f334923a = r100;
        }
    }
}
