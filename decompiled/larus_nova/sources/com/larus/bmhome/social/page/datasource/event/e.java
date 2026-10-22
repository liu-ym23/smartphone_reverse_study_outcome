package com.larus.bmhome.social.page.datasource.event;

/* JADX INFO: loaded from: classes26.dex */
public abstract class e {

    public static abstract class a extends e {

        /* JADX INFO: renamed from: com.larus.bmhome.social.page.datasource.event.e$a$a, reason: collision with other inner class name */
        public static final class C4103a extends a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final C4103a f314038a = null;

            static {
                f314038a = new C4103a();
            }

            public final String toString() {
                return "operation:append";
            }

            public C4103a() {
            }
        }

        public static final class b extends a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final b f314039a = null;

            static {
                f314039a = new b();
            }

            public final String toString() {
                return "operation:prepend";
            }

            public b() {
            }
        }

        public a() {
        }
    }

    public static final class b extends e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final boolean f314040a;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof b) == true) goto L9;
            return false;
        L9:
            if (this.f314040a == ((b) r100).f314040a) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            if (this.f314040a == false) goto L5;
            return 1231;
        L5:
            return 1237;
        }

        public final String toString() {
            return "operation:refresh,retry:" + this.f314040a;
        }

        public b(boolean r100) {
            this.f314040a = r100;
        }
    }

    public e() {
    }
}
