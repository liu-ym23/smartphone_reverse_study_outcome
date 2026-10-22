package com.ss.android.lark.contact.customized.common;

import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.larksuite.framework.callback.Entity.ErrorResult;
import com.obric.assistant.interaction.impl.essentialtask.ipc.EssentialTaskIPCProvider;
import com.ss.android.lark.statistics.Statistics;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes35.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f418963a = 0;

    static {
    }

    public static void a(String r100, long r101, boolean r102, ErrorResult r103, boolean r104, boolean r105) {
        Intrinsics.checkNotNullParameter(r100, "scene");
        JSONObject r106 = new JSONObject();
        r106.put("scene", r100);
        r106.put("duration", r101);
        r106.put(EssentialTaskIPCProvider.KEY_IS_SUCCEED, r102);
        r106.put(LocationMonitorConst.IS_CACHE, r104);
        r106.put("is_first_screen", r105);
        if (r102 == true) goto L11;
        if (r103 == null) goto L11;
        r106.put("err_code", r103.getCode());
        String r107 = r103.getMessage();
        if (r107 != null) goto L10;
        r107 = r103.getDebugMsg();
        if (r107 != null) goto L10;
        r107 = r103.getDisplayMsg();
    L10:
        r106.put(LocationMonitorConst.ERR_MSG, r107);
    L11:
        Statistics.sendEvent("flow_doc_dev_biz_comp_perf_event", r106);
    }
}
