package p8b;

import com.ss.android.lark.conditional.access.utils.NoPermissionType;
import com.ss.android.lark.picker.base.widget.reporter.PickerReporterConstants;
import com.ss.android.lark.security.compliance.infra.log.ScsLogger;
import com.ss.android.lark.statistics.Statistics;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes35.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f528276a = 0;

    static {
    }

    public static void a(String r100) {
        Intrinsics.checkNotNullParameter(r100, "click");
        JSONObject r101 = new JSONObject();
        r101.put("click", r100);     // Catch: Exception -> L5
        r101.put(PickerReporterConstants.KEY.TARGET, "none");     // Catch: Exception -> L5
    L7:
        d("scs_device_declare_click", r101);
        return;
    L5:
        e = move-exception;
        int r102 = ScsLogger.f440428a;
        ScsLogger.c("scs-tracker", "tracker exception:" + e.getMessage());
        goto L7
    }

    public static String c(int r100) {
        if (r100 != NoPermissionType.DEVICE_OWNER.getValue()) goto L6;
        return "device_ownership";
    L6:
        if (r100 != NoPermissionType.DEVICE_STATE.getValue()) goto L9;
        return "device_status";
    L9:
        if (r100 != NoPermissionType.MFA.getValue()) goto L12;
        return "multi_factor";
    L12:
        if (r100 != NoPermissionType.NETWORK.getValue()) goto L14;
        return "web_environment";
    L14:
        return "";
    }

    public static void b(String r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "click");
        JSONObject r102 = new JSONObject();
        r102.put("click", r100);     // Catch: Exception -> L5
        r102.put("reason", c(r101));     // Catch: Exception -> L5
        r102.put(PickerReporterConstants.KEY.TARGET, "none");     // Catch: Exception -> L5
    L7:
        d("scs_no_access_click", r102);
        return;
    L5:
        e = move-exception;
        int r103 = ScsLogger.f440428a;
        ScsLogger.c("scs-tracker", "tracker exception:" + e.getMessage());
        goto L7
    }

    public static void d(String r100, JSONObject r101) {
        int r102 = ScsLogger.f440428a;
        ScsLogger.d("scs-tracker", "eventName: " + r100 + ", params: " + r101);
        Statistics.sendEvent(r100, r101);
    }
}
