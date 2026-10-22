package com.ss.android.lark.integrator.ccm.dependency.di;

import com.bytedance.apm.ApmAgent;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes36.dex */
public final class m0 implements zw4.a {
    public m0() {
    }

    @Override // zw4.a
    public final void a(String r100, float r101) {
        JSONObject r102 = new JSONObject();     // Catch: Exception -> L4
        r102.put(r100, r101);     // Catch: Exception -> L4
        ApmAgent.monitorPerformance("start", r100, r102, null, null);     // Catch: Exception -> L4
        return;
    }
}
