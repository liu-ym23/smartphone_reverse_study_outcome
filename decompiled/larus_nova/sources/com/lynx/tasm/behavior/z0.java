package com.lynx.tasm.behavior;

import com.lynx.devtoolwrapper.CDPResultCallback;
import com.lynx.devtoolwrapper.LynxBaseInspectorOwner;
import com.lynx.tasm.base.LLog;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes32.dex */
public final class z0 implements CDPResultCallback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ JSONObject f383225a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ JSONObject f383226b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ LynxBaseInspectorOwner f383227c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ b1 f383228d;

    @Override // com.lynx.devtoolwrapper.CDPResultCallback
    public final void onResult(String r100) {
        b1.a(this.f383228d, this.f383225a, this.f383226b, this.f383227c, r100);     // Catch: JSONException -> L4
        return;
    L4:
        e = move-exception;
        LLog.e("LynxTouchEventDispatcher", "setAttributeByInvokeCDP error:" + e.toString());
    }

    public z0(b1 r100, JSONObject r101, JSONObject r102, LynxBaseInspectorOwner r103) {
        this.f383228d = r100;
        this.f383225a = r101;
        this.f383226b = r102;
        this.f383227c = r103;
    }
}
