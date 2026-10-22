package com.ivy.ivykit.plugin.impl.jsb;

import com.bytedance.ies.xbridge.XBridgeMethod;
import com.bytedance.ies.xbridge.XReadableMap;
import com.lynx.tasm.LynxView;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes23.dex */
public final class d implements XBridgeMethod.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ LynxView f278383a;

    public d(LynxView r100) {
        this.f278383a = r100;
    }

    @Override // com.bytedance.ies.xbridge.XBridgeMethod.b
    public final void sendJsEvent(String r100, XReadableMap r101) {
        Intrinsics.checkNotNullParameter(r100, "eventName");
        LynxView r102 = this.f278383a;
        if (r101 == null) goto L5;
        JSONObject r103 = com.bytedance.ies.xbridge.utils.j.d(r101);
    L6:
        o.a(r102, r100, r103);
        return;
    L5:
        r103 = new JSONObject();
        goto L6
    }
}
