package io.ktor.client.plugins;

import java.util.Set;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes41.dex */
public final class o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Set<io.ktor.http.v> f491727a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final xwc.c f491728b = null;

    static {
        io.ktor.http.v r100 = io.ktor.http.v.f491905b;
        f491727a = SetsKt.setOf(new io.ktor.http.v[]{io.ktor.http.v.f491905b, io.ktor.http.v.f491906c});
        Intrinsics.checkNotNullParameter("io.ktor.client.plugins.HttpRedirect", "name");
        f491728b = xwc.e.c("io.ktor.client.plugins.HttpRedirect");
    }

    public static final boolean a(io.ktor.http.x r100) {
        int r101 = r100.f491927a;
        if (r101 != io.ktor.http.x.f491918e.f491927a) goto L6;
    L7:
        boolean r102 = true;
    L9:
        if (r102 == false) goto L12;
    L13:
        boolean r103 = true;
    L15:
        if (r103 == false) goto L18;
    L19:
        boolean r104 = true;
    L21:
        if (r104 == false) goto L24;
        return true;
    L24:
        if (r101 == io.ktor.http.x.f491920g.f491927a) goto L29;
        return false;
    L29:
        return true;
    L18:
        if (r101 == io.ktor.http.x.f491923j.f491927a) goto L19;
        r104 = false;
        goto L21
    L12:
        if (r101 == io.ktor.http.x.f491922i.f491927a) goto L13;
        r103 = false;
        goto L15
    L6:
        if (r101 == io.ktor.http.x.f491919f.f491927a) goto L7;
        r102 = false;
        goto L9
    }
}
