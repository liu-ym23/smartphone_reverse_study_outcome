package io.ktor.client.plugins;

import io.ktor.http.g0;
import io.ktor.util.KtorDsl;

/* JADX INFO: loaded from: classes41.dex */
public final class b {

    @KtorDsl
    public static final class a implements io.ktor.http.t {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final io.ktor.http.o f491668a;

        public a() {
            this.f491668a = new io.ktor.http.o(0);
            new g0(null);
            new io.ktor.util.h();
        }

        @Override // io.ktor.http.t
        public final io.ktor.http.o getHeaders() {
            return this.f491668a;
        }
    }
}
