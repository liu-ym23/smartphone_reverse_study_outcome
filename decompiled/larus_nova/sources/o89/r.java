package o89;

import com.bytedance.android.btm.api.BtmSDK;
import com.bytedance.android.btm.api.model.PageFinder;
import com.bytedance.android.ec.host.api.service.IECHostService;
import com.bytedance.android.ec.sdk.ECSdk;
import com.larus.common.apphost.AppHost;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes27.dex */
public final class r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final r f522422a = null;

    static {
        f522422a = new r();
    }

    public r() {
    }

    public static void a(String r100, JSONObject r101) {
        Intrinsics.checkNotNullParameter(r100, "name");
        if (r101 != null) goto L29;
        r101 = new JSONObject();
    L29:
        Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L21
        BtmSDK r103 = BtmSDK.INSTANCE;     // Catch: Throwable -> L21
        Object r104 = r103.getCurrentResumedPage();     // Catch: Throwable -> L21
        if (r104 != null) goto L10;
        r104 = r103.getLastCreatedPage();     // Catch: Throwable -> L21
        if (r104 != null) goto L10;
        r104 = AppHost.f326268a.a().getCurrentActivity();     // Catch: Throwable -> L21
    L10:
        PageFinder r105 = PageFinder.via(r104);     // Catch: Throwable -> L21
        com.bytedance.android.btm.api.model.e r106 = r103.getBtmPageInfo(r105);     // Catch: Throwable -> L21
        if (r106 == null) goto L14;
        String r107 = r106.f42026b;     // Catch: Throwable -> L21
        if (r107 == null) goto L14;
    L15:
        Intrinsics.checkNotNull(r105);     // Catch: Throwable -> L21
        Iterator<Map.Entry<String, Object>> r108 = r103.createReportParams(r107, r105).entrySet().iterator();     // Catch: Throwable -> L21
    L17:
        if (r108.hasNext() == false) goto L19;
        Map.Entry<String, Object> r109 = r108.next();     // Catch: Throwable -> L21
        r101.putOpt(r109.getKey(), r109.getValue());     // Catch: Throwable -> L21
        goto L17
    L19:
        r101.putOpt("app_name", "doubao_ecom");     // Catch: Throwable -> L21
        AtomicBoolean r110 = q.f522409a;     // Catch: Throwable -> L21
        Result.m9449constructorimpl(r101.putOpt("duration", Long.valueOf(System.currentTimeMillis() - q.f522412d)));     // Catch: Throwable -> L21
    L23:
        int r111 = ECSdk.f48106a;
        IECHostService r112 = (IECHostService) ECSdk.a(IECHostService.class);
        if (r112 == null) goto L32;
        xi.a r113 = r112.getIECHostLogService();
        if (r113 == null) goto L33;
        r113.logV3(r100, r101);
        return;
    L33:
        return;
    L32:
        return;
    L14:
        r107 = "c0.d0";
    L21:
        th = move-exception;
        Result.Companion r114 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L23
    }
}
