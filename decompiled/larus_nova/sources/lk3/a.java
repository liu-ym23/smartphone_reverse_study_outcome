package lk3;

import com.bytedance.android.ec.sdk.helper.g;
import com.bytedance.android.livesdkapi.monitor.ILiveHybridMonitor;
import com.ss.android.lark.chameleon.container.webcontainer.report.ChameleonOpenTracker;
import java.util.Iterator;
import java.util.Map;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes14.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f509561a = 0;

    static {
    }

    public static void a(String r100, String r101, boolean r102) {
        Intrinsics.checkNotNullParameter(r100, "url");
        Intrinsics.checkNotNullParameter(r101, "type");
        g r103 = g.f48122a;
        JSONObject r104 = new JSONObject();
        Result.Companion r105 = Result.Companion;     // Catch: Throwable -> L9
        r104.putOpt("url", r100);     // Catch: Throwable -> L9
        r104.putOpt(ILiveHybridMonitor.BusinessParams.CONTAINER_TYPE, r101);     // Catch: Throwable -> L9
        if (r102 == false) goto L6;
        String r106 = "1";
    L7:
        Result.m9449constructorimpl(r104.putOpt("success", r106));     // Catch: Throwable -> L9
    L11:
        Unit r107 = Unit.INSTANCE;
        r103.logV3("ec_tabkit_create_hybrid_component", r104);
        return;
    L6:
        r106 = "0";
    L9:
        th = move-exception;
        Result.Companion r108 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L11
    }

    public static void b(String r100, String r101, boolean r102, Map r103) {
        g r104 = g.f48122a;
        JSONObject r105 = new JSONObject();
        Result.Companion r106 = Result.Companion;     // Catch: Throwable -> L20
        if (r100 != null) goto L6;
        r100 = "";
    L6:
        r105.putOpt("load_url", r100);     // Catch: Throwable -> L20
        r105.putOpt(ChameleonOpenTracker.ParamKey.LOAD_TYPE, r101);     // Catch: Throwable -> L20
        if (r102 == false) goto L9;
        String r107 = "1";
    L10:
        r105.putOpt("success", r107);     // Catch: Throwable -> L20
        if (r103 == null) goto L17;
        Iterator r108 = r103.entrySet().iterator();     // Catch: Throwable -> L20
    L14:
        if (r108.hasNext() == false) goto L16;
        Map.Entry r109 = (Map.Entry) r108.next();     // Catch: Throwable -> L20
        r105.putOpt((String) r109.getKey(), r109.getValue());     // Catch: Throwable -> L20
        goto L14
    L16:
        Unit r110 = Unit.INSTANCE;     // Catch: Throwable -> L20
    L18:
        Result.m9449constructorimpl(r110);     // Catch: Throwable -> L20
    L22:
        Unit r111 = Unit.INSTANCE;
        r104.logV3("ec_tabkit_anniex_lynx_load", r105);
        return;
    L17:
        r110 = null;
        goto L18
    L9:
        r107 = "0";
    L20:
        th = move-exception;
        Result.Companion r112 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L22
    }

    public static void c(String r100, String r101, String r102, boolean r103) {
        g r104 = g.f48122a;
        JSONObject r105 = new JSONObject();
        Result.Companion r106 = Result.Companion;     // Catch: Throwable -> L12
        if (r100 != null) goto L6;
        r100 = "";
    L6:
        r105.putOpt("load_url", r100);     // Catch: Throwable -> L12
        r105.putOpt(ChameleonOpenTracker.ParamKey.LOAD_TYPE, r101);     // Catch: Throwable -> L12
        r105.putOpt("stage", r102);     // Catch: Throwable -> L12
        if (r103 == false) goto L9;
        String r107 = "1";
    L10:
        Result.m9449constructorimpl(r105.putOpt("is_downgrade", r107));     // Catch: Throwable -> L12
    L14:
        Unit r108 = Unit.INSTANCE;
        r104.logV3("ec_tabkit_anniex_lynx_load_process", r105);
        return;
    L9:
        r107 = "0";
    L12:
        th = move-exception;
        Result.Companion r109 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L14
    }
}
