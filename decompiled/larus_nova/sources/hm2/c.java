package hm2;

import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f485751a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String f485752b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String f485753c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final String f485754d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final String f485755e = null;

    static {
        f485751a = "/webcast/openapi/im/fetch/fuse/";
        f485752b = "/webcast/openapi/im/fetch/fuse/";
        a("history");
        f485753c = "/webcast/openapi/im/fetch/mini_widget_fuse/";
        f485754d = "/webcast/openapi/im/fetch/preview_fuse/";
        f485755e = "/webcast/im/push/preview_fuse/";
    }

    public static String a(String r100) {
        Intrinsics.checkNotNullParameter(r100, "scene");
        return f485751a + r100 + HTTP.URL_DEFAULT;
    }
}
