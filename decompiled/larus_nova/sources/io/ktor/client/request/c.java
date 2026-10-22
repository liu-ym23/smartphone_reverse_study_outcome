package io.ktor.client.request;

import com.bytedance.kmp.ec.yata.view.render.controller.common.ContainerPosition;
import io.ktor.http.Url;
import io.ktor.http.n;
import io.ktor.http.p;
import io.ktor.http.v;
import io.ktor.util.InternalAPI;
import java.util.Map;
import java.util.Set;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.Job;

/* JADX INFO: loaded from: classes41.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Url f491770a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final v f491771b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final n f491772c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final io.ktor.http.content.c f491773d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Job f491774e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final io.ktor.util.b f491775f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Set<io.ktor.client.engine.c<?>> f491776g;

    public final String toString() {
        return "HttpRequestData(url=" + this.f491770a + ", method=" + this.f491771b + ')';
    }

    @InternalAPI
    public c(Url r100, v r101, p r102, io.ktor.http.content.c r103, Job r104, io.ktor.util.c r105) {
        Intrinsics.checkNotNullParameter(r100, "url");
        Intrinsics.checkNotNullParameter(r101, com.alipay.sdk.m.p.e.f25671s);
        Intrinsics.checkNotNullParameter(r102, "headers");
        Intrinsics.checkNotNullParameter(r103, ContainerPosition.BODY);
        Intrinsics.checkNotNullParameter(r104, "executionContext");
        Intrinsics.checkNotNullParameter(r105, "attributes");
        this.f491770a = r100;
        this.f491771b = r101;
        this.f491772c = r102;
        this.f491773d = r103;
        this.f491774e = r104;
        this.f491775f = r105;
        Map r106 = (Map) r105.b(io.ktor.client.engine.d.f491644a);
        if (r106 == null) goto L6;
        Set<io.ktor.client.engine.c<?>> r107 = r106.keySet();
        if (r107 == null) goto L6;
    L7:
        this.f491776g = r107;
        return;
    L6:
        r107 = SetsKt.emptySet();
        goto L7
    }
}
