package io.opentelemetry.sdk.metrics.internal.debug;

import io.opentelemetry.api.internal.c;
import io.opentelemetry.api.internal.d;
import io.opentelemetry.api.internal.e;
import io.opentelemetry.api.internal.f;
import java.util.Locale;

/* JADX INFO: loaded from: classes41.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f492726a = 0;

    static {
        final String r100 = "otel.experimental.sdk.metrics.debug".toLowerCase(Locale.ROOT).replace("-", ".");
        String r101 = (String) System.getProperties().entrySet().stream().filter(new c(r100)).map(new d()).findFirst().orElse(null);
        if (r101 != null) goto L6;
        r101 = (String) System.getenv().entrySet().stream().filter(new e(r100)).map(new f()).findFirst().orElse("false");
    L6:
        Boolean.parseBoolean(r101);
    }
}
