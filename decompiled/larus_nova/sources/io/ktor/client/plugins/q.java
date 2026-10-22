package io.ktor.client.plugins;

import io.ktor.client.request.HttpRequestBuilder;
import io.ktor.util.KtorDsl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes41.dex */
public final class q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f491737a = 0;

    @KtorDsl
    public static final class a {
    }

    public static final class b {
        public b() {
            throw null;
        }
    }

    public static final class c {
        public c(HttpRequestBuilder r100) {
            Intrinsics.checkNotNullParameter(r100, "request");
        }
    }

    public static final class d {
        public d() {
            throw null;
        }
    }

    public static final class e {
        public e() {
        }
    }

    static {
        Intrinsics.checkNotNullParameter("RetryFeature", "name");
        new io.ktor.events.a();
    }
}
