package com.bytedance.locallife.live.card;

/* JADX INFO: loaded from: classes21.dex */
public abstract class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final C3668b f259223a = null;

    public static final class a {
    }

    /* JADX INFO: renamed from: com.bytedance.locallife.live.card.b$b, reason: collision with other inner class name */
    public static final class C3668b extends b {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final C3668b f259224b = null;

        static {
            f259224b = new C3668b();
        }

        public C3668b() {
        }
    }

    public static final class c extends b {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final long f259225b;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof c) == true) goto L9;
            return false;
        L9:
            if (this.f259225b == ((c) r100).f259225b) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            long r100 = this.f259225b;
            return (int) (r100 ^ (r100 >>> 32));
        }

        public final String toString() {
            return "VISIBLE(showDurationMs=" + this.f259225b + ')';
        }

        public c() {
            this(0);
        }

        public c(long r100) {
            this.f259225b = r100;
        }
    }

    public b() {
    }

    static {
        f259223a = C3668b.f259224b;
    }
}
