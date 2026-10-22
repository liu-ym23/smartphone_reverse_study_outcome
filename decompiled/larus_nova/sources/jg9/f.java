package jg9;

import android.os.Bundle;
import com.larus.apm.api.IApmTrace;
import com.larus.applog.api.IApplog;
import com.larus.platform.service.g;
import com.larus.utils.logger.FLogger;
import java.util.Iterator;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes30.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f499056a = 0;

    static {
    }

    public static JSONObject a(Bundle r100) {
        JSONObject r101 = null;
    L14:
        th = th;
    L15:
        FLogger.f375446a.e("UrgentCmdV2Reporter", "parse bundle params failed, " + th);
        return r101;
    L4:
        if (r100.isEmpty() == true) goto L23;
        JSONObject r102 = new JSONObject();     // Catch: Throwable -> L14
        Iterator<String> r103 = r100.keySet().iterator();     // Catch: Throwable -> L12
    L8:
        if (r103.hasNext() == false) goto L24;
        String r104 = r103.next();     // Catch: Throwable -> L12
        Intrinsics.checkNotNull(r104, "null cannot be cast to non-null type kotlin.String");     // Catch: Throwable -> L12
        String r105 = r104;     // Catch: Throwable -> L12
        r102.put(r105, r100.get(r105));     // Catch: Throwable -> L12
        goto L8
    L24:
        return r102;
    L12:
        th = th;
        r101 = r102;
        goto L15
    L23:
        return null;
    }

    public static void b(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "errorType");
        Intrinsics.checkNotNullParameter(r101, "errorMsg");
        FLogger.f375446a.i("UrgentCmdV2Reporter", "reportErrorEvent key:urgent_cmd_executed_error errorType:" + r100 + " error_msg:" + r101);     // Catch: Exception -> L8
        Bundle r102 = com.larus.utils.f.c(new Pair[]{TuplesKt.to("error_type", r100), TuplesKt.to("error_msg", r101)});     // Catch: Exception -> L8
        IApplog.f287053a.b("urgent_cmd_executed_error", r102);     // Catch: Exception -> L8
        IApmTrace.Companion r103 = IApmTrace.f286937a;     // Catch: Exception -> L8
        JSONObject r104 = a(r102);     // Catch: Exception -> L8
        if (r104 != null) goto L6;
        r104 = new JSONObject();     // Catch: Exception -> L8
    L6:
        r103.f("urgent_cmd_executed_error", r104, null, null);     // Catch: Exception -> L8
        return;
    L8:
        e = move-exception;
        FLogger.f375446a.e("UrgentCmdV2Reporter", "reportUrgentCmdExecutedErrorEvent error: " + e.getMessage(), e);
        g.f365738a.ensureNotReachHere(e, "UrgentCmd Error: reportUrgentCmdExecutedErrorEvent");
    }
}
