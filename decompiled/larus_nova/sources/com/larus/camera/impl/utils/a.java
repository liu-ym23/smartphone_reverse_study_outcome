package com.larus.camera.impl.utils;

/* JADX INFO: loaded from: classes26.dex */
public abstract class a {

    /* JADX INFO: renamed from: com.larus.camera.impl.utils.a$a, reason: collision with other inner class name */
    public static final class C4155a extends a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final long f322711a;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof C4155a) == true) goto L9;
            return false;
        L9:
            if (this.f322711a == ((C4155a) r100).f322711a) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            long r100 = this.f322711a;
            return (int) (r100 ^ (r100 >>> 32));
        }

        public final String toString() {
            return "Oversize(maxSize=" + this.f322711a + ')';
        }

        public C4155a(long r100) {
            this.f322711a = r100;
        }
    }

    public static final class b extends a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b f322712a = null;

        static {
            f322712a = new b();
        }

        public b() {
        }
    }

    public static final class c extends a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final c f322713a = null;

        static {
            f322713a = new c();
        }

        public c() {
        }
    }

    public a() {
    }
}
