package fka;

import android.util.Log;
import com.obric.matrix.proto.Response;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes33.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f477673a = 0;

    static {
    }

    public static void a(int r100, Response r101) {
        Intrinsics.checkNotNullParameter(r101, "response");
        JSONObject r102 = new JSONObject();     // Catch: Exception -> L5
        r102.put("status", "status_receiver_result");     // Catch: Exception -> L5
        r102.put("cmd", r100);     // Catch: Exception -> L5
        r102.put("way", 1);     // Catch: Exception -> L5
        r102.put("package_name", "");     // Catch: Exception -> L5
        r102.put("error_code", r101.statusCode.intValue());     // Catch: Exception -> L5
        r102.put("error_message", r101.errorMsg);     // Catch: Exception -> L5
        JSONObject r103 = new JSONObject();     // Catch: Exception -> L5
        int r104 = b.f477674a;     // Catch: Exception -> L5
        b.a("event_send_cmd_result", r102, r103, new JSONObject());     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        gka.b.a("ReportMonitorHelper", "report exception " + Log.getStackTraceString(e));
    }
}
