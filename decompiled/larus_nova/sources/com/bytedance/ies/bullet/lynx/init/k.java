package com.bytedance.ies.bullet.lynx.init;

import com.bytedance.framwork.core.sdkmonitor.SDKMonitor;
import java.util.HashMap;
import java.util.Map;
import kotlin.jvm.internal.Ref;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes19.dex */
public final class k implements SDKMonitor.IGetExtendParams {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ JSONObject f247362a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Ref.ObjectRef<o> f247363b;

    @Override // com.bytedance.framwork.core.sdkmonitor.SDKMonitor.IGetExtendParams
    public final String getSessionId() {
        return null;
    }

    @Override // com.bytedance.framwork.core.sdkmonitor.SDKMonitor.IGetExtendParams
    public final Map<String, String> getCommonParams() {
        HashMap r100 = new HashMap();
        r100.put("host_aid", this.f247362a.optString("host_aid"));
        if (this.f247363b.element.f247370b == false) goto L5;
        r100.put("oversea", "1");
    L5:
        return r100;
    }

    public k(JSONObject r100, Ref.ObjectRef<o> r101) {
        this.f247362a = r100;
        this.f247363b = r101;
    }
}
