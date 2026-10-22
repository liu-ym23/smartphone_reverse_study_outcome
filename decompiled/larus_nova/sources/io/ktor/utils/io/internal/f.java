package io.ktor.utils.io.internal;

import io.ktor.utils.io.pool.DefaultPool;
import java.nio.ByteBuffer;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes41.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f492075a = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final io.ktor.utils.io.pool.c f492076b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final b f492077c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final a f492078d = null;

    public static final class a extends io.ktor.utils.io.pool.d<h.c> {
        @Override // io.ktor.utils.io.pool.e
        public final Object Q5() {
            return new h.c(ByteBuffer.allocateDirect(f.f492075a));
        }

        public a() {
        }
    }

    public static final class b extends DefaultPool<h.c> {
        @Override // io.ktor.utils.io.pool.DefaultPool
        public final h.c f() {
            return new h.c(f.f492076b.Q5());
        }

        public b(int r100) {
            super(r100);
        }

        @Override // io.ktor.utils.io.pool.DefaultPool
        public final void e(h.c r100) {
            h.c r101 = r100;
            Intrinsics.checkNotNullParameter(r101, "instance");
            f.f492076b.Rl(r101.f492082a);
        }
    }

    static {
        int r100 = l.a("BufferSize", 4096);
        f492075a = r100;
        int r101 = l.a("BufferPoolSize", 2048);
        int r102 = l.a("BufferObjectPoolSize", 1024);
        f492076b = new io.ktor.utils.io.pool.c(r101, r100);
        f492077c = new b(r102);
        f492078d = new a();
    }
}
