package mqc;

import android.text.TextUtils;
import com.volcengine.zeus.log.ZeusLogger;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static volatile boolean f514968a;

    static {
    }

    @JvmStatic
    public static final void a(String r100, Integer r101, String r102, long r103, JSONObject r110) {
        Intrinsics.checkNotNullParameter(r102, "stage");
        JSONObject r104 = new JSONObject();     // Catch: Exception -> L13
        if (r100 == null) goto L6;
        r104.put("plugin_id", r100);     // Catch: Exception -> L13
    L6:
        if (r101 == null) goto L8;
        r101.intValue();     // Catch: Exception -> L13
        r104.put("plugin_version_code", r101.intValue());     // Catch: Exception -> L13
    L8:
        r104.put("stage", r102);     // Catch: Exception -> L13
        r104.put("total_cost", r103);     // Catch: Exception -> L13
        if (r110 == null) goto L11;
        r104.put("virtual_property", r110.toString());     // Catch: Exception -> L13
    L11:
        ZeusLogger.d(ZeusLogger.TAG_REPORTER, "event is obric_zeus_stage_cost, stage is " + r104.opt("stage"));     // Catch: Exception -> L13
        fqc.b.c("obric_zeus_stage_cost", r104);     // Catch: Exception -> L13
        return;
    L13:
        e = move-exception;
        ZeusLogger.w(ZeusLogger.TAG_REPORTER, "report cost failed", e);
    }

    @JvmStatic
    public static final void b(String r100, int r101, String r102, String r103, Integer r104, String r110) {
        JSONObject r105 = new JSONObject();     // Catch: Exception -> L13
        r105.put("plugin_version_code", r101);     // Catch: Exception -> L13
        r105.put("plugin_id", r100);     // Catch: Exception -> L13
        r105.put("stage", r102);     // Catch: Exception -> L13
        r105.put("result", r103);     // Catch: Exception -> L13
        if (r104 == null) goto L9;
        if (r104.intValue() == 0) goto L9;
        r105.put("error_code", r104.intValue());     // Catch: Exception -> L13
    L9:
        if (TextUtils.isEmpty(r110) == true) goto L11;
        r105.put("error_msg", r110);     // Catch: Exception -> L13
    L11:
        ZeusLogger.d(ZeusLogger.TAG_REPORTER, "event is obric_zeus_stage_status, stage is " + r105.opt("stage"));     // Catch: Exception -> L13
        fqc.b.c("obric_zeus_stage_status", r105);     // Catch: Exception -> L13
        return;
    L13:
        e = move-exception;
        ZeusLogger.w(ZeusLogger.TAG_REPORTER, "report status failed", e);
    }
}
