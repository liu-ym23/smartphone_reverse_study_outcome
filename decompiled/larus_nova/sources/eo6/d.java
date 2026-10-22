package eo6;

import java.lang.ref.WeakReference;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ConcurrentHashMap<String, WeakReference<b>> f473324a = null;

    static {
        f473324a = new ConcurrentHashMap();
    }

    public static boolean a(a r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "cardInfo");
        if (r101 != null) goto L5;
        return false;
    L5:
        Intrinsics.checkNotNullParameter(r101, "key");
        WeakReference<b> r102 = f473324a.get(r101);
        if (r102 == null) goto L11;
        b r103 = r102.get();
        if (r103 != null) goto L10;
        return false;
    L10:
        return r103.b(r100);
    L11:
        return false;
    }
}
