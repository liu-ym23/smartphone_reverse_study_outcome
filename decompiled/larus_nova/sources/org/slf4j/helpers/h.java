package org.slf4j.helpers;

/* JADX INFO: loaded from: classes42.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static a f526235a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static boolean f526236b;

    public static final class a extends SecurityManager {
        @Override // java.lang.SecurityManager
        public final Class<?>[] getClassContext() {
            return super.getClassContext();
        }

        public a() {
        }
    }

    public h() {
    }

    public static final void a(String r100) {
        System.err.println("SLF4J: " + r100);
    }
}
