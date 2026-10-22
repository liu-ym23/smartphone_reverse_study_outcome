package u4c;

import com.bytedance.apm.ApmAgent;
import com.larksuite.framework.utils.z;
import com.ss.android.lark.security.compliance.infra.log.ScsLogger;
import com.ss.android.lark.utils.LarkContext;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import ncb.f;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes38.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f548750a = null;

    public a() {
    }

    static {
        int r100 = f.f518706a;
        z.e(LarkContext.getApplication());
        f548750a = gyb.a.a().getTracingID();
    }

    public static void a(String r100, Map r101, Map r102, Map r103, int r104, int r105) {
        JSONObject r106 = null;
        if ((r105 & 2) == 0) goto L6;
        r101 = null;
    L6:
        if ((r105 & 4) == 0) goto L9;
        r102 = null;
    L9:
        if ((r105 & 8) == 0) goto L12;
        r103 = null;
    L12:
        if ((r105 & 16) == 0) goto L14;
        r104 = 0;
    L14:
        Intrinsics.checkNotNullParameter(r100, "serviceName");
        if (r101 != null) goto L29;
        JSONObject r107 = null;
    L18:
        if (r102 != null) goto L20;
        JSONObject r108 = null;
    L21:
        if (r103 == null) goto L24;
        r106 = new JSONObject(r103);     // Catch: Exception -> L26
    L24:
        ApmAgent.monitorStatusAndEvent(r100, r104, r107, r108, r106);     // Catch: Exception -> L26
        return;
    L26:
        e = move-exception;
        int r109 = ScsLogger.f440428a;
        ScsLogger.d("MonitorUtil", "MonitorUtil.reportToSlardar exception :" + e);
        return;
    L20:
        r108 = new JSONObject(r102);     // Catch: Exception -> L26
        goto L21
    L29:
        r107 = new JSONObject(r101);     // Catch: Exception -> L26
        goto L18
    }
}
