package com.bytedance.ies.bullet.lynx.init;

import com.bytedance.framwork.core.sdkmonitor.SDKMonitor;
import com.larus.apm.impl.protector.RunnableProtector;
import com.lynx.tasm.LynxConfigInfo;
import com.lynx.tasm.ThreadStrategyForRendering;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes19.dex */
public final class m implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ LynxConfigInfo f247365a;

    public m(LynxConfigInfo r100) {
        this.f247365a = r100;
    }

    public final void a() {
        LynxConfigInfo r100 = this.f247365a;
        if (r100 == null) goto L12;
        SDKMonitor r101 = n.f247366a;
        SDKMonitor r102 = n.f247366a;
        if (r102 == null) goto L13;
        JSONObject r103 = new JSONObject();
        r103.put("pageVersion", r100.getPageVersion());
        r103.put("pageType", r100.getPageType());
        r103.put("cliVersion", r100.getCliVersion());
        r103.put("customData", r100.getCustomData());
        r103.put("templateUrl", r100.getTemplateUrl());
        r103.put("targetSdkVersion", r100.getTargetSdkVersion());
        r103.put("lepusVersion", r100.getLepusVersion());
        ThreadStrategyForRendering r104 = r100.getThreadStrategyForRendering();
        if (r104 == null) goto L9;
        Integer r105 = Integer.valueOf(r104.id());
    L10:
        r103.put("threadStrategyForRendering", r105);
        r103.put("isEnableLepusNG", r100.isEnableLepusNG());
        r103.put("radonMode", r100.getRadonMode());
        r102.monitorEvent("lynx_config_info", r103, null, null);
        return;
    L9:
        r105 = null;
        goto L10
    L13:
        return;
    }

    @Override // java.lang.Runnable
    public final void run() {
        a();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
