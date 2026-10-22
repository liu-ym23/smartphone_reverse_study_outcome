package com.bytedance.ies.xelement.defaultimpl.player.impl.plugin.mediasession.notification;

/* JADX INFO: loaded from: classes19.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f249989a = 0;

    public static final class a {
    }

    /* JADX INFO: renamed from: com.bytedance.ies.xelement.defaultimpl.player.impl.plugin.mediasession.notification.b$b, reason: collision with other inner class name */
    public static final class C3564b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f249990a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public boolean f249991b;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof C3564b) == true) goto L8;
            return false;
        L8:
            C3564b r101 = (C3564b) r100;
            if (this.f249990a == r101.f249990a) goto L12;
            return false;
        L12:
            if (this.f249991b == r101.f249991b) goto L14;
            return false;
        L14:
            return true;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v1, types: [int] */
        /* JADX WARN: Type inference failed for: r0v3, types: [int] */
        /* JADX WARN: Type inference failed for: r0v4 */
        /* JADX WARN: Type inference failed for: r0v5 */
        /* JADX WARN: Type inference failed for: r1v0 */
        /* JADX WARN: Type inference failed for: r1v1, types: [int] */
        /* JADX WARN: Type inference failed for: r1v2 */
        public final int hashCode() {
            boolean r100 = this.f249990a;
            ?? r101 = 1;
            ?? r102 = r100;
            if (r100 == false) goto L5;
            r102 = 1;
        L5:
            int r103 = r102 * 31;
            boolean r104 = this.f249991b;
            if (r104 == true) goto L10;
            r101 = r104;
        L10:
            return r103 + r101;
        }

        public final String toString() {
            return "NotificationContext(isActive=" + this.f249990a + ", isShown=" + this.f249991b + ')';
        }

        public C3564b() {
            this.f249990a = false;
            this.f249991b = false;
        }
    }

    static {
    }

    public final C3564b b() {
        throw null;
    }

    public final void c() {
        throw null;
    }

    public final void d(d r100) {
        throw null;
    }

    public static final void a(b r100, d r101) {
        r100.getClass();
        throw null;
    }
}
