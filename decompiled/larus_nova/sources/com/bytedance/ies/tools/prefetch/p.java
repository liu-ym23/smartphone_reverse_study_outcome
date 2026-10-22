package com.bytedance.ies.tools.prefetch;

/* JADX INFO: loaded from: classes19.dex */
public final class p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static k f248826a;

    public static final class a implements k {
        public a() {
        }

        @Override // com.bytedance.ies.tools.prefetch.k
        public final void a() {
        }

        @Override // com.bytedance.ies.tools.prefetch.k
        public final void b(Throwable r100) {
            r100.printStackTrace();
        }
    }

    static {
        f248826a = new a();
    }

    public static void a(String r100) {
        f248826a.a();
    }

    public static void b(String r100) {
        f248826a.a();
    }

    public static void c(String r100, Throwable r101) {
        if (r101 != null) goto L4;
        f248826a.a();
        return;
    L4:
        f248826a.b(r101);
    }
}
