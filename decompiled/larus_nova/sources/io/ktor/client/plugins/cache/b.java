package io.ktor.client.plugins.cache;

import com.bytedance.kmp.ec.yata.view.render.controller.common.ContainerPosition;
import io.ktor.http.n;
import io.ktor.http.o;
import io.ktor.http.p;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes41.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final hsc.a f491679a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map<String, String> f491680b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final io.ktor.client.statement.b f491681c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final byte[] f491682d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final p f491683e;

    public final io.ktor.client.statement.b a() {
        return new io.ktor.client.call.a(this.f491681c.a80().f491622a, this.f491681c.a80().c(), this.f491681c, this.f491682d).d();
    }

    public final int hashCode() {
        return this.f491680b.hashCode();
    }

    public final boolean equals(Object r100) {
        if (r100 != null) goto L4;
        return false;
    L4:
        if ((r100 instanceof b) == false) goto L13;
        if (r100 != this) goto L10;
        return true;
    L10:
        return Intrinsics.areEqual(this.f491680b, ((b) r100).f491680b);
    L13:
        return false;
    }

    public b(hsc.a r100, Map<String, String> r101, io.ktor.client.statement.b r102, byte[] r103) {
        Intrinsics.checkNotNullParameter(r100, "expires");
        Intrinsics.checkNotNullParameter(r101, "varyKeys");
        Intrinsics.checkNotNullParameter(r102, "response");
        Intrinsics.checkNotNullParameter(r103, ContainerPosition.BODY);
        this.f491679a = r100;
        this.f491680b = r101;
        this.f491681c = r102;
        this.f491682d = r103;
        n.a r104 = n.f491892a;
        o r105 = new o(0);
        r105.f(r102.getHeaders());
        this.f491683e = r105.l();
    }
}
