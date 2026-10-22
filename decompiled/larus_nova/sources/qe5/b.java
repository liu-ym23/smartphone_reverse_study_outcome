package qe5;

import android.content.Context;
import com.bytedance.ies.xbridge.XBridgeMethod;
import com.bytedance.ies.xbridge.XBridgePlatformType;
import com.bytedance.ies.xbridge.XReadableMap;
import com.bytedance.ies.xbridge.bridgeInterfaces.XCoreBridgeMethod;
import com.bytedance.ies.xbridge.s;
import com.tencent.qqmusic.third.api.contract.Keys;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class b extends XCoreBridgeMethod {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f532642a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f532643b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public c f532644c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f532645d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f532646e;

    public static final class a {
    }

    static {
    }

    public b() {
        this.f532642a = "";
        this.f532643b = -1;
        this.f532646e = "ccm.registerPermissionChange";
    }

    @Override // com.bytedance.ies.xbridge.bridgeInterfaces.XCoreBridgeMethod, com.bytedance.ies.xbridge.XBridgeMethod, com.bytedance.sdk.xbridge.cn.protocol.h
    public final void release() {
        super.release();
        tt5.a.h("CCMRegisterLinkShareChangeMethod", "(" + this + ") destroyLinkShareChangePush, secretPush: " + this.f532644c + ", token: " + du5.b.k(this.f532642a) + ", type: " + this.f532643b);
        c r100 = this.f532644c;
        if (r100 == null) goto L5;
        ((com.bytedance.ee.space.sync.b) org.koin.java.a.c(com.bytedance.ee.space.sync.b.class, null, null, 6)).Lc(r100);
    L5:
        this.f532644c = null;
        this.f532645d = false;
    }

    @Override // com.bytedance.ies.xbridge.XBridgeMethod
    public final String getName() {
        return this.f532646e;
    }

    @Override // com.bytedance.ies.xbridge.XBridgeMethod
    public final void handle(XReadableMap r110, XBridgeMethod.Callback r111, XBridgePlatformType r112) {
        Intrinsics.checkNotNullParameter(r110, "params");
        Intrinsics.checkNotNullParameter(r111, "callback");
        Intrinsics.checkNotNullParameter(r112, Keys.API_PARAM_KEY_PLATFORM_TYPE);
        if (((Context) provideContext(Context.class)) != null) goto L7;
        tt5.a.d("CCMRegisterLinkShareChangeMethod", "handle, context is null");
        return;
    L7:
        if (s.b(r110, "isRegister", true) == false) goto L28;
        String r113 = r110.getString("realToken");
        int r100 = r110.getInt("realType");
        boolean r101 = false;
        if (r113.length() <= 0) goto L11;
        boolean r102 = true;
    L12:
        if (r102 == false) goto L15;
        if (r100 < 0) goto L15;
        this.f532642a = r113;
        this.f532643b = r100;
    L17:
        if (this.f532645d == true) goto L24;
        tt5.a.h("CCMRegisterLinkShareChangeMethod", "(" + this + ") initLinkShareChangePush, token: " + du5.b.k(this.f532642a) + ", type: " + this.f532643b);
        if (this.f532642a.length() <= 0) goto L22;
        r101 = true;
    L22:
        if (r101 == false) goto L24;
        this.f532645d = true;
    L24:
        tt5.a.h("CCMRegisterLinkShareChangeMethod", "(" + this + ") registerLinkShareChangePush, secretPush: " + this.f532644c + ", token: " + du5.b.k(this.f532642a) + ", type: " + this.f532643b);
        if (this.f532645d == false) goto L34;
        c r114 = new c(this);
        this.f532644c = r114;
        ((com.bytedance.ee.space.sync.b) org.koin.java.a.c(com.bytedance.ee.space.sync.b.class, null, null, 6)).i4(this.f532642a, this.f532643b, r114);
        return;
    L34:
        return;
    L15:
        this.f532642a = r110.getString("token");
        this.f532643b = r110.getInt("type");
        goto L17
    L11:
        r102 = false;
        goto L12
    L28:
        tt5.a.h("CCMRegisterLinkShareChangeMethod", "(" + this + ") unregisterLinkShareChangePush, secretPush: " + this.f532644c + ", token: " + du5.b.k(this.f532642a) + ", type: " + this.f532643b);
        c r115 = this.f532644c;
        if (r115 == null) goto L33;
        ((com.bytedance.ee.space.sync.b) org.koin.java.a.c(com.bytedance.ee.space.sync.b.class, null, null, 6)).Lc(r115);
        return;
    }
}
