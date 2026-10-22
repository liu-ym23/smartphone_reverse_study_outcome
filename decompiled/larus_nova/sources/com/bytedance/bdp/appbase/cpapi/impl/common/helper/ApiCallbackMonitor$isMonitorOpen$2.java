package com.bytedance.bdp.appbase.cpapi.impl.common.helper;

import com.bytedance.bdp.bdpbase.manager.BdpManager;
import com.bytedance.bdp.serviceapi.hostimpl.setting.BdpHostSettingService;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import g94.b;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes11.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 1, 18})
final class ApiCallbackMonitor$isMonitorOpen$2 extends Lambda implements Function0<Boolean> {
    public static final ApiCallbackMonitor$isMonitorOpen$2 INSTANCE = null;

    static {
        INSTANCE = new ApiCallbackMonitor$isMonitorOpen$2();
    }

    public ApiCallbackMonitor$isMonitorOpen$2() {
        super(0);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final boolean invoke2() {
        JSONObject r100 = ((BdpHostSettingService) BdpManager.getInst().getService(BdpHostSettingService.class)).getSettingJson("bdp_enable_jsb_invocation_guarder");
        if (r100 != null) goto L5;
    L7:
        boolean r101 = false;
    L8:
        b.a("ApiCallbackMonitor", new Object[]{"isMonitorOpen: " + r101});
        return r101;
    L5:
        if (r100.optInt("enable_invocation_guarder", 0) != 1) goto L7;
        r101 = true;
        goto L8
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Boolean invoke() {
        return Boolean.valueOf(invoke2());
    }
}
