package com.bytedance.ies.web.jsbridge2;

import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes19.dex */
public abstract class f<P, R> extends d<P, R> {
    private CallContext callContext;
    private a callback;
    private boolean isValid;
    private z<R> proxy;

    public interface a {
    }

    public interface b {
        f a();
    }

    public final void finishWithFailure() {
        finishWithFailure(null);
    }

    public final void finishWithSuccess() {
        finishWithResult(null);
    }

    public abstract void invoke(P r100, CallContext r101) throws Exception;

    public void onDestroy() {
        this.isValid = false;
        this.callContext = null;
        this.proxy = null;
    }

    public abstract void onTerminate();

    private boolean checkInvalid() {
        if (this.isValid == true) goto L6;
        return false;
    L6:
        return true;
    }

    public final CallContext getCallContext() {
        z<R> r100 = this.proxy;
        if (r100 == null) goto L7;
        return r100.a();
    L7:
        return this.callContext;
    }

    public f() {
        this.isValid = true;
        this.proxy = null;
    }

    @Override // com.bytedance.ies.web.jsbridge2.d
    public /* bridge */ /* synthetic */ String getName() {
        return super.getName();
    }

    @Override // com.bytedance.ies.web.jsbridge2.d
    public /* bridge */ /* synthetic */ PermissionGroup getPermission() {
        return super.getPermission();
    }

    public void terminateActual() {
        onTerminate();
        onDestroy();
    }

    public void terminateActualProxy() {
        terminateActual();
    }

    public final void finishWithFailure(Throwable r100) {
        if (checkInvalid() == false) goto L13;
        z<R> r101 = this.proxy;
        if (r101 == null) goto L7;
        r101.getCallBack().onFailed(r100);
    L11:
        onDestroy();
        return;
    L7:
        i r102 = (i) this.callback;
        com.bytedance.ies.web.jsbridge2.b r103 = r102.f249360c.f249380i;
        if (r103 == null) goto L11;
        r103.e(n0.a(r100), r102.f249358a);
        r102.f249360c.f249377f.remove(r102.f249359b);
        goto L11
    }

    public final void finishWithRawResult(JSONObject r100) {
        if (checkInvalid() == false) goto L13;
        z<R> r101 = this.proxy;
        if (r101 == null) goto L7;
        r101.getCallBack().a(r100);
    L11:
        onDestroy();
        return;
    L7:
        i r102 = (i) this.callback;
        com.bytedance.ies.web.jsbridge2.b r103 = r102.f249360c.f249380i;
        if (r103 == null) goto L11;
        r103.f(r100, r102.f249358a);
        r102.f249360c.f249377f.remove(r102.f249359b);
        goto L11
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void finishWithResult(R r100) {
        if (checkInvalid() == false) goto L24;
        z<R> r101 = this.proxy;
        if (r101 == null) goto L7;
        r101.getCallBack().onSucceed(r100);
    L19:
        onDestroy();
        return;
    L7:
        i r102 = (i) this.callback;
        if (r102.f249360c.f249380i == null) goto L19;
        JSONObject r103 = null;
        if ((r100 instanceof JSONObject) == true) goto L22;
    L15:
        if (r103 == null) goto L17;
        r102.f249360c.f249380i.f(r103, r102.f249358a);
    L18:
        r102.f249360c.f249377f.remove(r102.f249359b);
        goto L19
    L17:
        k r104 = r102.f249360c;
        r104.f249380i.e(n0.b(r104.f249372a, r100), r102.f249358a);
        goto L18
    L22:
        ((JSONObject) r100).put("code", 1);     // Catch: JSONException -> L21
        r103 = (JSONObject) r100;     // Catch: JSONException -> L21
        goto L15
    }

    public void setProxy(z<R> r100) {
        this.proxy = r100;
    }

    public void invokeProxy(P r100, CallContext r101) throws Exception {
        invoke(r100, this.proxy.a());
    }

    public void invokeActual(P r100, CallContext r101, a r102) throws Exception {
        this.callContext = r101;
        this.callback = r102;
        invoke(r100, r101);
    }
}
