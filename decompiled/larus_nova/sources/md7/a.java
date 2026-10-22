package md7;

import android.util.LruCache;
import java.util.List;
import java.util.Map;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;

/* JADX INFO: loaded from: classes22.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Map<String, ? extends List<ld7.b>> f513419a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final LruCache<String, b> f513420b;

    /* JADX INFO: renamed from: md7.a$a, reason: collision with other inner class name */
    public static final class C6803a {
    }

    static {
    }

    public static String a(String r100) {
        if (r100 != null) goto L5;
        return null;
    L5:
        Object[] r101 = new Regex("[.]").split(r100, 0).toArray(new String[0]);
        if (r101 == null) goto L15;
        String[] r102 = (String[]) r101;
        int r103 = r102.length;
        if (r103 >= 2) goto L10;
        return null;
    L10:
        if (r103 != 2) goto L13;
        return r100;
    L13:
        return r102[r103 - 2] + '.' + r102[r103 - 1];
    L15:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
    }

    public final void update(Map<String, ? extends List<ld7.b>> r100) {
        Intrinsics.checkNotNullParameter(r100, "config");
        this.f513419a = r100;
    }

    public a(String r100, int r101, Map<String, ? extends List<ld7.b>> r102) {
        Intrinsics.checkNotNullParameter(r100, "namespace");
        Intrinsics.checkNotNullParameter(r102, "configMap");
        this.f513419a = MapsKt.emptyMap();
        if (r101 > 0) goto L5;
        r101 = 32;
    L5:
        this.f513420b = new LruCache(r101);
        this.f513419a = r102;
    }
}
