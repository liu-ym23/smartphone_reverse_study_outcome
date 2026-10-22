package e8;

import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ConcurrentHashMap<String, d8.b> f471282a = null;

    static {
        f471282a = new ConcurrentHashMap();
    }

    public static d8.b a(String r100) {
        Intrinsics.checkNotNullParameter(r100, "bizKey");
        ConcurrentHashMap<String, d8.b> r101 = f471282a;
        d8.b r102 = r101.get(r100);
        if (r102 != null) goto L6;
        d8.b r103 = r101.get("host");
        Intrinsics.checkNotNull(r103);
        return r103;
    L6:
        return r102;
    }
}
