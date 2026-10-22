package com.ss.android.ttve.monitor;

import com.bytedance.ies.common.IESAppLogger;
import com.ss.android.vesdk.VEListener;
import com.ss.android.vesdk.runtime.VERuntime;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes38.dex */
public final class a implements IESAppLogger.IESAppLoggerCallback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ c.a f449932a;

    public a(c.a r100) {
        this.f449932a = r100;
    }

    @Override // com.bytedance.ies.common.IESAppLogger.IESAppLoggerCallback
    public final void onInternalEventV3(String r100, JSONObject r101, String r110) {
        c.a r102 = this.f449932a;
        if (r102 == null) goto L10;
        VERuntime.b r103 = (VERuntime.b) r102;
        if (VERuntime.access$100(r103.f455887a) != null) goto L7;
        return;
    L7:
        if (VERuntime.access$100(r103.f455887a).get() == null) goto L12;
        ((VEListener.VEApplogListener) VERuntime.access$100(r103.f455887a).get()).onInternalEventV3(r100, r101, null, null, r110);
        return;
    L12:
        return;
    }
}
