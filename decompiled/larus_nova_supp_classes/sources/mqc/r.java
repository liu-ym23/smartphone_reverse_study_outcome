package mqc;

import android.text.TextUtils;
import com.volcengine.zeus.log.ZeusLogger;
import fqc.b;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
public final class r {
    public static volatile boolean a;

    static {
    }

    @JvmStatic
    public static final void a(String r5, Integer r6, String r7, long r8, JSONObject r10) {
        Intrinsics.checkNotNullParameter(r7, "stage");
        JSONObject r3 = new JSONObject();     // Catch: Exception -> L13
        if (r5 == null) goto L6;
        r3.put("plugin_id", r5);     // Catch: Exception -> L13
    L6:
        if (r6 == null) goto L8;
        r6.intValue();     // Catch: Exception -> L13
        r3.put("plugin_version_code", r6.intValue());     // Catch: Exception -> L13
    L8:
        r3.put("stage", r7);     // Catch: Exception -> L13
        r3.put("total_cost", r8);     // Catch: Exception -> L13
        if (r10 == null) goto L11;
        r3.put("virtual_property", r10.toString());     // Catch: Exception -> L13
    L11:
        ZeusLogger.d(ZeusLogger.TAG_REPORTER, "event is obric_zeus_stage_cost, stage is " + r3.opt("stage"));     // Catch: Exception -> L13
        b.c("obric_zeus_stage_cost", r3);     // Catch: Exception -> L13
        return;
    L13:
        e = move-exception;
        ZeusLogger.w(ZeusLogger.TAG_REPORTER, "report cost failed", e);
    }

    @JvmStatic
    public static final void b(String r5, int r6, String r7, String r8, Integer r9, String r10) {
        JSONObject r3 = new JSONObject();     // Catch: Exception -> L13
        r3.put("plugin_version_code", r6);     // Catch: Exception -> L13
        r3.put("plugin_id", r5);     // Catch: Exception -> L13
        r3.put("stage", r7);     // Catch: Exception -> L13
        r3.put("result", r8);     // Catch: Exception -> L13
        if (r9 == null) goto L9;
        if (r9.intValue() == 0) goto L9;
        r3.put("error_code", r9.intValue());     // Catch: Exception -> L13
    L9:
        if (TextUtils.isEmpty(r10) == true) goto L11;
        r3.put("error_msg", r10);     // Catch: Exception -> L13
    L11:
        ZeusLogger.d(ZeusLogger.TAG_REPORTER, "event is obric_zeus_stage_status, stage is " + r3.opt("stage"));     // Catch: Exception -> L13
        b.c("obric_zeus_stage_status", r3);     // Catch: Exception -> L13
        return;
    L13:
        e = move-exception;
        ZeusLogger.w(ZeusLogger.TAG_REPORTER, "report status failed", e);
    }
}
