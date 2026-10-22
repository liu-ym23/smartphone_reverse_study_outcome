package io.ktor.client.plugins.cache;

import java.util.List;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import xwc.e;

/* JADX INFO: loaded from: classes41.dex */
public final class HttpCacheKt {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final xwc.c f491672a = null;

    static {
        Intrinsics.checkNotNullParameter("io.ktor.client.plugins.HttpCache", "name");
        f491672a = e.c("io.ktor.client.plugins.HttpCache");
    }

    public static final Function1<String, String> a(final io.ktor.http.content.c r100, final Function1<? super String, String> r101, final Function1<? super String, ? extends List<String>> r102) {
        Intrinsics.checkNotNullParameter(r100, "content");
        Intrinsics.checkNotNullParameter(r101, "headerExtractor");
        Intrinsics.checkNotNullParameter(r102, "allHeadersExtractor");
        return new HttpCacheKt$mergedHeadersLookup$1(r100, r101, r102);
    }
}
