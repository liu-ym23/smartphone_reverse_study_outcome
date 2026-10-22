package xv8;

import com.bytedance.apm.ApmAgent;
import com.larus.applog.api.IApplog;
import com.larus.business.debug.base.DebugConstants$DebugTools$DebugToolsType;
import com.larus.common.larksso.api.ILarkSSOService;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes26.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f565188a = 0;

    static {
    }

    public static void a(DebugConstants$DebugTools$DebugToolsType r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "toolType");
        Intrinsics.checkNotNullParameter(r101, "toolName");
        JSONObject r102 = new JSONObject();
        r102.put("flow_tools_type", r100.getType());
        r102.put("flow_tools_name", r101);
        r102.put("flow_tools_did", IApplog.f287053a.getDeviceId());
        ILarkSSOService r103 = (ILarkSSOService) ServiceManager.get().getService(ILarkSSOService.class);
        if (r103 == null) goto L6;
        String r104 = Boolean.valueOf(r103.b()).toString();
        if (r104 == null) goto L6;
    L7:
        r102.put("flow_tools_lark_sso_authed", r104);
        ApmAgent.monitorEvent("flow_dev_tools_event", r102, new JSONObject(), new JSONObject());
        return;
    L6:
        r104 = "false";
        goto L7
    }
}
