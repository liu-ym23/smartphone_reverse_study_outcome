package com.larus.dora.impl.device.settings.recordMinutes;

/* JADX INFO: loaded from: classes27.dex */
public abstract class b {

    public static final class a extends b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f334874a = null;

        static {
            f334874a = new a();
        }

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof a) == true) goto L9;
            return false;
        L9:
            a r101 = (a) r100;
            return true;
        }

        public final int hashCode() {
            return 1715514963;
        }

        public final String toString() {
            return "Idle";
        }

        public a() {
        }
    }

    /* JADX INFO: renamed from: com.larus.dora.impl.device.settings.recordMinutes.b$b, reason: collision with other inner class name */
    public static final class C4237b extends b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final boolean f334875a;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof C4237b) == true) goto L9;
            return false;
        L9:
            if (this.f334875a == ((C4237b) r100).f334875a) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            if (this.f334875a == false) goto L5;
            return 1231;
        L5:
            return 1237;
        }

        public final String toString() {
            return "Success(recordMinutesEnabled=" + this.f334875a + ')';
        }

        public C4237b(boolean r100) {
            this.f334875a = r100;
        }
    }

    public b() {
    }
}
