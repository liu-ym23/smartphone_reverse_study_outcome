package com.larus.dora.impl.dynamic.quicknote;

/* JADX INFO: loaded from: classes27.dex */
public abstract class a {

    /* JADX INFO: renamed from: com.larus.dora.impl.dynamic.quicknote.a$a, reason: collision with other inner class name */
    public static final class C4250a extends a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f335251a;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof C4250a) == true) goto L9;
            return false;
        L9:
            if (this.f335251a == ((C4250a) r100).f335251a) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.f335251a;
        }

        public final String toString() {
            return "ClickItem(index=" + this.f335251a + ')';
        }

        public C4250a(int r100) {
            this.f335251a = r100;
        }
    }

    public static final class b extends a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b f335252a = null;

        static {
            f335252a = new b();
        }

        public b() {
        }
    }

    public static final class c extends a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final c f335253a = null;

        static {
            f335253a = new c();
        }

        public c() {
        }
    }

    public static final class d extends a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final d f335254a = null;

        static {
            f335254a = new d();
        }

        public d() {
        }
    }

    public a() {
    }
}
