package io.ktor.client.plugins.cache.storage;

import com.bytedance.kmp.ec.yata.view.render.controller.common.ContainerPosition;
import io.ktor.http.Url;
import io.ktor.http.n;
import io.ktor.http.w;
import io.ktor.http.x;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes41.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Url f491698a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final x f491699b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final hsc.a f491700c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final hsc.a f491701d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final w f491702e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final hsc.a f491703f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final n f491704g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Map<String, String> f491705h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final byte[] f491706i;

    public final int hashCode() {
        return (this.f491698a.hashCode() * 31) + this.f491705h.hashCode();
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof b) == true) goto L8;
        return false;
    L8:
        b r101 = (b) r100;
        if (Intrinsics.areEqual(this.f491698a, r101.f491698a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f491705h, r101.f491705h) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public b(Url r100, x r101, hsc.a r102, hsc.a r103, w r104, hsc.a r105, n r106, Map<String, String> r107, byte[] r110) {
        Intrinsics.checkNotNullParameter(r100, "url");
        Intrinsics.checkNotNullParameter(r101, "statusCode");
        Intrinsics.checkNotNullParameter(r102, "requestTime");
        Intrinsics.checkNotNullParameter(r103, "responseTime");
        Intrinsics.checkNotNullParameter(r104, "version");
        Intrinsics.checkNotNullParameter(r105, "expires");
        Intrinsics.checkNotNullParameter(r106, "headers");
        Intrinsics.checkNotNullParameter(r107, "varyKeys");
        Intrinsics.checkNotNullParameter(r110, ContainerPosition.BODY);
        this.f491698a = r100;
        this.f491699b = r101;
        this.f491700c = r102;
        this.f491701d = r103;
        this.f491702e = r104;
        this.f491703f = r105;
        this.f491704g = r106;
        this.f491705h = r107;
        this.f491706i = r110;
    }
}
