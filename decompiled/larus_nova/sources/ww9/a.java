package ww9;

import com.ixigua.lib.track.TrackParams;
import com.larus.utils.logger.FLogger;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import tx9.u0;

/* JADX INFO: loaded from: classes31.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static long f561737a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ int f561738b = 0;

    static {
    }

    public a() {
    }

    public static void a(String r110, JSONObject r111) {
        Intrinsics.checkNotNullParameter(r111, "extParams");
        u0.h(false, null, null, null, null, null, r110, null, null, r111, 1854);
    }

    public static void b(String r110, String r111, JSONObject r112) {
        Intrinsics.checkNotNullParameter(r112, "extraParams");
        u0.h(true, null, null, null, null, null, r110, r111, null, r112, 1854);
    }

    public static void c(String r100, Long r101, JSONObject r102) {
        Intrinsics.checkNotNullParameter(r102, "commonParams");
        r102.put("leave_reason", r100);     // Catch: Exception -> L8
        if (r101 == null) goto L6;
        r102.put("duration", r101.longValue());     // Catch: Exception -> L8
    L6:
        TrackParams r103 = new TrackParams().merge(r102);     // Catch: Exception -> L8
        by7.a r104 = new by7.a("output_preview_exit");     // Catch: Exception -> L8
        r104.f21463a.merge(r103);     // Catch: Exception -> L8
        r104.b();     // Catch: Exception -> L8
        return;
    L8:
        e = move-exception;
        FLogger.f375446a.e("SlidesDetailTracer", "error in SlidesDetailTracer reportOutputPreviewExit: " + e.getLocalizedMessage());
    }
}
