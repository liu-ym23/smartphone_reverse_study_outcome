package io.ktor.client.plugins.websocket;

import io.ktor.client.plugins.j;
import io.ktor.util.KtorDsl;
import java.util.ArrayList;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes41.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f491753a = null;

    @KtorDsl
    public static final class a {
        public a() {
            new ArrayList();
        }
    }

    public static final class b implements j<a, e> {
        public b() {
        }
    }

    static {
        f491753a = new b();
        Intrinsics.checkNotNullParameter("Websocket", "name");
    }
}
