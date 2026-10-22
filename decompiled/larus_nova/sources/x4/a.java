package x4;

import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ConcurrentHashMap<String, String> f562420a = null;

    static {
        f562420a = new ConcurrentHashMap();
    }

    public static String a(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        if (r100.length() != 0) goto L5;
        boolean r101 = true;
    L6:
        if (r101 == false) goto L9;
        return null;
    L9:
        return f562420a.get(r100);
    L5:
        r101 = false;
        goto L6
    }
}
