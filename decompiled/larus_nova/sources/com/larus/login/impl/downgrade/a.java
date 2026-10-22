package com.larus.login.impl.downgrade;

import com.bytedance.apm.ApmAgent;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.larus.applog.api.IApplog;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes30.dex */
public final class a {
    public static final String a(int r100) {
        if (r100 != 0) goto L5;
        return "normal";
    L5:
        if (r100 != 1) goto L7;
        return "t1";
    L7:
        if (r100 != 2) goto L9;
        return "t2";
    L9:
        if (r100 != 3) goto L11;
        return "t3";
    L11:
        if (r100 != 4) goto L13;
        return "t4";
    L13:
        if (r100 != 5) goto L26;
        return "shutdown";
    L26:
        return "normal";
    }

    public static final void c(int r100, int r101) {
        IApplog.Companion r102 = IApplog.f287053a;
        JSONObject r103 = new JSONObject();
        r103.put("from", a(r100));
        r103.put(RemoteMessageConst.TO, a(r101));
        Unit r104 = Unit.INSTANCE;
        r102.reportEvent("login_shutdown", r103);
        JSONObject r105 = new JSONObject();
        r105.put("from", a(r100));
        r105.put(RemoteMessageConst.TO, a(r101));
        ApmAgent.monitorEvent("login_shutdown", r105, null, null);
    }

    public static final void b(boolean r100, Integer r101, long r102, String r110) {
        Intrinsics.checkNotNullParameter(r110, "errorMsg");
        IApplog.Companion r103 = IApplog.f287053a;
        JSONObject r104 = new JSONObject();
        r104.put("succeed", r100 ? 1 : 0);
        if (r101 == null) goto L5;
        r104.put("quota_state", r101.intValue());
    L5:
        r104.put("error_code", r102);
        r104.put("error_msg", r110);
        Unit r105 = Unit.INSTANCE;
        r103.reportEvent("login_quota_result", r104);
        JSONObject r106 = new JSONObject();
        r106.put("succeed", r100 ? 1 : 0);
        if (r101 == null) goto L8;
        r106.put("quota_state", r101.intValue());
    L8:
        r106.put("error_code", r102);
        r106.put("error_msg", r110);
        ApmAgent.monitorEvent("login_quota_result", r106, null, null);
    }
}
