package io.ktor.utils.io.pool;

/* JADX INFO: loaded from: classes41.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final C6314a f492133a = null;

    /* JADX INFO: renamed from: io.ktor.utils.io.pool.a$a, reason: collision with other inner class name */
    public static final class C6314a extends DefaultPool<byte[]> {
        @Override // io.ktor.utils.io.pool.DefaultPool
        public final byte[] f() {
            return new byte[4096];
        }

        public C6314a() {
            super(128);
        }
    }

    static {
        f492133a = new C6314a();
    }
}
