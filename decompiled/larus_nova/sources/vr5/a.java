package vr5;

import com.ss.android.lark.log.Log;

/* JADX INFO: loaded from: classes19.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final pxb.a f556907a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final as5.b f556908b;

    public final void a(String r100) {
        pxb.a r101 = this.f556907a;
        if (r101 != null) goto L6;
        Log.e("NativeComponentBridge", "registerHandler, mWebView is null, handlerName = ".concat(r100));
        return;
    L6:
        as5.b r102 = this.f556908b;
        if (r102 != null) goto L10;
        Log.e("NativeComponentBridge", "registerHandler, mNativeComponentProvider is null, handlerName = ".concat(r100));
        return;
    L10:
        c r103 = new c(r101, r100, r102);
        r101.getBridge().a(r100, r103);
    }

    public a(pxb.a r100, as5.b r101) {
        this.f556907a = r100;
        this.f556908b = r101;
    }
}
