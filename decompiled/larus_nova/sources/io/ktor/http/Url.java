package io.ktor.http;

import com.bytedance.ies.sdk.widgets.api.WidgetService;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes41.dex */
public final class Url {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final j0 f491816a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f491817b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f491818c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final List<String> f491819d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final z f491820e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f491821f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f491822g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final String f491823h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Lazy f491824i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Lazy f491825j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final Lazy f491826k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final Lazy f491827l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final Lazy f491828m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final Lazy f491829n;

    public static final class a {
    }

    static {
    }

    public final String a() {
        return (String) this.f491824i.getValue();
    }

    public final int b() {
        Integer r100 = Integer.valueOf(this.f491818c);
        if (r100.intValue() != 0) goto L5;
        boolean r101 = true;
    L6:
        if (r101 == false) goto L9;
        r100 = null;
    L9:
        if (r100 == null) goto L12;
        return r100.intValue();
    L12:
        return this.f491816a.f491882b;
    L5:
        r101 = false;
        goto L6
    }

    public final int hashCode() {
        return this.f491823h.hashCode();
    }

    public final String toString() {
        return this.f491823h;
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if (r100 != null) goto L8;
    L14:
        return false;
    L8:
        if (Url.class != r100.getClass()) goto L14;
        if (Intrinsics.areEqual(this.f491823h, ((Url) r100).f491823h) == true) goto L13;
        return false;
    L13:
        return true;
    }

    public Url(j0 r100, String r101, int r102, List<String> r103, z r104, String r105, String r106, String r107, boolean r108, String r110) {
        Intrinsics.checkNotNullParameter(r100, "protocol");
        Intrinsics.checkNotNullParameter(r101, "host");
        Intrinsics.checkNotNullParameter(r103, "pathSegments");
        Intrinsics.checkNotNullParameter(r104, "parameters");
        Intrinsics.checkNotNullParameter(r105, WidgetService.PARAM_FRAGMENT);
        Intrinsics.checkNotNullParameter(r110, "urlString");
        this.f491816a = r100;
        this.f491817b = r101;
        this.f491818c = r102;
        this.f491819d = r103;
        this.f491820e = r104;
        this.f491821f = r106;
        this.f491822g = r107;
        this.f491823h = r110;
        boolean r109 = false;
        if (r102 >= 0) goto L5;
    L7:
        boolean r111 = false;
    L8:
        if (r111 == true) goto L10;
        if (r102 == 0) goto L10;
    L11:
        if (r109 == false) goto L15;
        this.f491824i = LazyKt.lazy(new Url$encodedPath$2(this));
        this.f491825j = LazyKt.lazy(new Url$encodedQuery$2(this));
        this.f491826k = LazyKt.lazy(new Url$encodedPathAndQuery$2(this));
        this.f491827l = LazyKt.lazy(new Url$encodedUser$2(this));
        this.f491828m = LazyKt.lazy(new Url$encodedPassword$2(this));
        this.f491829n = LazyKt.lazy(new Url$encodedFragment$2(this));
        return;
    L15:
        throw new IllegalArgumentException("port must be between 0 and 65535, or 0 if not set".toString());
    L10:
        r109 = true;
        goto L11
    L5:
        if (r102 >= 65536) goto L7;
        r111 = true;
        goto L8
    }
}
