package r89;

import android.net.Uri;
import com.bytedance.mt.protector.impl.UriProtector;
import com.larus.common.apphost.AppHost;
import com.larus.e_commerce.impl.applet.PageState;
import com.larus.utils.y0;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import o89.q;

/* JADX INFO: loaded from: classes27.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f536667a = null;

    static {
        f536667a = new a();
    }

    public a() {
    }

    public static Map b() {
        Pair[] r100 = new Pair[3];
        AtomicBoolean r101 = q.f522409a;
        String r102 = "1";
        if (q.d() == false) goto L5;
        Object r103 = "1";
    L6:
        boolean r104 = false;
        r100[0] = TuplesKt.to("ec_applet_flag", r103);
        if (q.g() == false) goto L9;
        Object r105 = "1";
    L10:
        r100[1] = TuplesKt.to("ec_applet_landing_page", r105);
        if (q.f(AppHost.f326268a.a().getCurrentActivity()) == false) goto L14;
    L16:
        if (r104 == true) goto L19;
        r102 = "0";
    L19:
        r100[2] = TuplesKt.to("ec_applet_going_landing_page", r102);
        return MapsKt.mapOf(r100);
    L14:
        if (q.f522410b != PageState.GOING) goto L16;
        r104 = true;
        goto L16
    L9:
        r105 = "0";
        goto L10
    L5:
        r103 = "0";
        goto L6
    }

    public static String a(String r100) {
        Map r101 = b();
        Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L19
        Uri r103 = y0.h(r100);     // Catch: Throwable -> L19
        Iterator r104 = CollectionsKt.listOf(new String[]{"url", "surl"}).iterator();     // Catch: Throwable -> L19
    L5:
        if (r104.hasNext() == false) goto L13;
        String r105 = (String) r104.next();     // Catch: Throwable -> L19
        String r106 = UriProtector.getQueryParameter(r103, r105);     // Catch: Throwable -> L19
        if (r106 == null) goto L5;
        Uri.Builder r107 = y0.h(r106).buildUpon();     // Catch: Throwable -> L19
        Iterator r108 = r101.entrySet().iterator();     // Catch: Throwable -> L19
    L10:
        if (r108.hasNext() == false) goto L12;
        Map.Entry r109 = (Map.Entry) r108.next();     // Catch: Throwable -> L19
        r107.appendQueryParameter((String) r109.getKey(), (String) r109.getValue());     // Catch: Throwable -> L19
        goto L10
    L12:
        r103 = y0.g(r103, r105, r107.build().toString());     // Catch: Throwable -> L19
        goto L5
    L13:
        Uri.Builder r110 = r103.buildUpon();     // Catch: Throwable -> L19
        Iterator r111 = r101.entrySet().iterator();     // Catch: Throwable -> L19
    L15:
        if (r111.hasNext() == false) goto L17;
        Map.Entry r112 = (Map.Entry) r111.next();     // Catch: Throwable -> L19
        r110.appendQueryParameter((String) r112.getKey(), (String) r112.getValue());     // Catch: Throwable -> L19
        goto L15
    L17:
        Object r113 = Result.m9449constructorimpl(r110.build().toString());     // Catch: Throwable -> L19
    L21:
        Object r114 = r100;
        if (Result.m9455isFailureimpl(r113) == true) goto L26;
        r114 = r113;
    L26:
        return (String) r114;
    L19:
        th = move-exception;
        Result.Companion r115 = Result.Companion;
        r113 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L21
    }
}
