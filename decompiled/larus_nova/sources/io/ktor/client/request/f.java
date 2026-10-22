package io.ktor.client.request;

import com.bytedance.kmp.ec.yata.view.render.controller.common.ContainerPosition;
import io.ktor.http.n;
import io.ktor.http.w;
import io.ktor.http.x;
import io.ktor.utils.io.ByteReadChannel;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes41.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final x f491778a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final hsc.a f491779b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final n f491780c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final w f491781d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Object f491782e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final CoroutineContext f491783f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final hsc.a f491784g;

    public final String toString() {
        return "HttpResponseData=(statusCode=" + this.f491778a + ')';
    }

    public f(x r100, hsc.a r101, n r102, w r103, ByteReadChannel r104, CoroutineContext r105) {
        Intrinsics.checkNotNullParameter(r100, "statusCode");
        Intrinsics.checkNotNullParameter(r101, "requestTime");
        Intrinsics.checkNotNullParameter(r102, "headers");
        Intrinsics.checkNotNullParameter(r103, "version");
        Intrinsics.checkNotNullParameter(r104, ContainerPosition.BODY);
        Intrinsics.checkNotNullParameter(r105, "callContext");
        this.f491778a = r100;
        this.f491779b = r101;
        this.f491780c = r102;
        this.f491781d = r103;
        this.f491782e = r104;
        this.f491783f = r105;
        this.f491784g = io.ktor.util.date.a.b(null);
    }
}
