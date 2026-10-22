package me7;

import com.bytedance.ies.bullet.core.BulletContext;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import io.reactivex.disposables.Disposable;

/* JADX INFO: loaded from: classes22.dex */
@XBridgeMethod(name = "x.preloadResource")
public final class s extends b implements com.bytedance.sdk.xbridge.cn.protocol.h {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Disposable f513558c;

    @Override // com.bytedance.ies.xbridge.bridgeInterfaces.XCoreBridgeMethod, com.bytedance.ies.xbridge.XBridgeMethod, com.bytedance.sdk.xbridge.cn.protocol.h
    public final void release() {
        Disposable r100 = this.f513558c;
        if (r100 == null) goto L6;
        r100.dispose();
        return;
    }

    public s() {
    }

    public static final String e(s r100) {
        g66.c r101 = r100.getContextProviderFactory();
        if (r101 == null) goto L8;
        BulletContext r102 = (BulletContext) r101.c(BulletContext.class);
        if (r102 == null) goto L8;
        String r103 = r102.getSessionId();
        if (r103 == null) goto L8;
        return r103;
    L8:
        return "";
    }

    public static void f(b.a r100, int r101, String r102) {
        if (r101 != 1) goto L5;
        r100.onSuccess(new i66.b(), r102);
        return;
    L5:
        r100.onFailure(r101, r102);
    }
}
