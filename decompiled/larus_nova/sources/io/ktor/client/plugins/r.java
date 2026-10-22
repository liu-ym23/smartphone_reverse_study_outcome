package io.ktor.client.plugins;

import io.ktor.client.request.HttpRequestBuilder;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes41.dex */
public final class r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final xwc.c f491738a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final io.ktor.util.a<Integer> f491739b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final io.ktor.util.a<Function3<q.e, io.ktor.client.request.b, io.ktor.client.statement.b, Boolean>> f491740c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final io.ktor.util.a<Function3<q.e, HttpRequestBuilder, Throwable, Boolean>> f491741d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final io.ktor.util.a<Function2<q.c, HttpRequestBuilder, Unit>> f491742e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final io.ktor.util.a<Function2<q.b, Integer, Long>> f491743f = null;

    static {
        Intrinsics.checkNotNullParameter("io.ktor.client.plugins.HttpRequestRetry", "name");
        f491738a = xwc.e.c("io.ktor.client.plugins.HttpRequestRetry");
        f491739b = new io.ktor.util.a("MaxRetriesPerRequestAttributeKey");
        f491740c = new io.ktor.util.a("ShouldRetryPerRequestAttributeKey");
        f491741d = new io.ktor.util.a("ShouldRetryOnExceptionPerRequestAttributeKey");
        f491742e = new io.ktor.util.a("ModifyRequestPerRequestAttributeKey");
        f491743f = new io.ktor.util.a("RetryDelayPerRequestAttributeKey");
    }
}
