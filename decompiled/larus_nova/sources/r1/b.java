package r1;

import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import java.io.File;

/* JADX INFO: loaded from: classes39.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static long f535546a = -30000;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static PolarisFileWrapper f535547b;

    public static File b() {
        if (f535547b != null) goto L6;
        long r100 = System.currentTimeMillis();
        f535547b = new PolarisFileWrapper(com.apm.lite.k.n.g(com.apm.lite.e.f29909a), "apmlite/TrackInfo/" + ((r100 - (r100 % 86400000)) / 86400000) + HTTP.URL_DEFAULT + com.apm.lite.e.f());
    L6:
        return f535547b;
    }

    public static String a(long r100, String r110) {
        return com.apm.lite.k.h.a(new PolarisFileWrapper(com.apm.lite.k.n.g(com.apm.lite.e.f29909a), "apmlite/TrackInfo/" + ((r100 - (r100 % 86400000)) / 86400000) + HTTP.URL_DEFAULT + r110));
    L5:
        th = move-exception;
        return th.getMessage();
    }
}
