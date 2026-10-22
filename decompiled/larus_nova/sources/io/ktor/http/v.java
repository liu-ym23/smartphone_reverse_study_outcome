package io.ktor.http;

import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes41.dex */
public final class v {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final v f491905b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final v f491906c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final List<v> f491907d = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f491908a;

    public static final class a {
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof v) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(this.f491908a, ((v) r100).f491908a) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public final int hashCode() {
        return this.f491908a.hashCode();
    }

    public final String toString() {
        return "HttpMethod(value=" + this.f491908a + ')';
    }

    static {
        v r100 = new v("GET");
        f491905b = r100;
        v r101 = new v("POST");
        v r102 = new v("PUT");
        v r103 = new v("PATCH");
        v r104 = new v("DELETE");
        v r105 = new v("HEAD");
        f491906c = r105;
        f491907d = CollectionsKt.listOf(new v[]{r100, r101, r102, r103, r104, r105, new v("OPTIONS")});
    }

    public v(String r100) {
        Intrinsics.checkNotNullParameter(r100, "value");
        this.f491908a = r100;
    }
}
