package nwa;

import com.bytedance.ee.bear.document.setting.DocumentSettingViewModel;
import com.ss.android.lark.audit.AuditManager;
import com.ss.android.lark.log.Log;
import gwa.g;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes34.dex */
public final class d {
    public static final void a(String r100) {
        Intrinsics.checkNotNullParameter(r100, "errorMsg");
        AuditManager.getInstance().getDependency().getSecurityComplianceDependency().c(MapsKt.mapOf(new Pair[]{TuplesKt.to("event", "data_process"), TuplesKt.to("error_code", 101), TuplesKt.to("error_msg", r100)}), null, null, 1);
    }

    public static final void b(long r100, int r101, String r102, String r103) {
        Intrinsics.checkNotNullParameter(r102, "errorMsg");
        AuditManager.getInstance().getDependency().getSecurityComplianceDependency().c(MapsKt.mapOf(new Pair[]{TuplesKt.to("event", "upload"), TuplesKt.to("error_code", Integer.valueOf(r101)), TuplesKt.to("error_msg", r102)}), MapsKt.mapOf(TuplesKt.to("duration", Long.valueOf(r100))), MapsKt.mapOf(TuplesKt.to("logId", r103)), 1);
    }

    public static final void c(int r100, int r101, String r102, String r103) {
        g r104 = AuditManager.getInstance().getDependency();     // Catch: Exception -> L9
        JSONObject r105 = new JSONObject();     // Catch: Exception -> L9
        r105.put(DocumentSettingViewModel.KEY_ACCESS_PERM_TYPE, r100);     // Catch: Exception -> L9
        r105.put("result", r101);     // Catch: Exception -> L9
        if (r102 == null) goto L5;
        r105.put("entityType", r102);     // Catch: Exception -> L9
    L5:
        if (r103 == null) goto L7;
        r105.put("entityId", r103);     // Catch: Exception -> L9
    L7:
        r104.getSecurityComplianceDependency().monitorEvent("scs_security_audit_auth_check", r105, null, null);     // Catch: Exception -> L9
        return;
    L9:
        e = move-exception;
        Log.e("audit", "monitorAuthCheck：exception is " + e);
    }
}
