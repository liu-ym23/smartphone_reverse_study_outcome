package qy;

import java.util.List;
import kotlin.collections.CollectionsKt;
import py.k;
import vh7.f;

/* JADX INFO: loaded from: classes45.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f535172a = 0;

    public static k c() {
        return (k) f.c(k.class);
    }

    static {
    }

    public static k a(String r100) {
        k r101 = (k) f.c(k.class);
        List<String> r102 = CollectionsKt.mutableListOf(new String[]{r100});
        if (r102 == null) goto L7;
        r101.setUrls(r102);
        return r101;
    L7:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.collections.List<kotlin.String>");
    }

    public static k b(String r100, List r101) {
        k r102 = (k) f.c(k.class);
        r102.setUri(r100);
        if (r101 == null) goto L5;
        r102.setUrls(r101);
    L5:
        return r102;
    }
}
