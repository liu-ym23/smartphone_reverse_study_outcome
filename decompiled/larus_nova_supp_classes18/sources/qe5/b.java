package qe5;

import android.content.Context;
import com.bytedance.ee.docsdk.impl.document.plugins.offline.storage.ResourceData;
import com.bytedance.ies.xbridge.XBridgeMethod;
import com.bytedance.ies.xbridge.XBridgePlatformType;
import com.bytedance.ies.xbridge.XReadableMap;
import com.bytedance.ies.xbridge.bridgeInterfaces.XCoreBridgeMethod;
import com.bytedance.ies.xbridge.s;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class b extends XCoreBridgeMethod {
    public String a;
    public int b;
    public c c;
    public boolean d;
    public final String e;

    public static final class a {
    }

    static {
    }

    public b() {
        this.a = "";
        this.b = -1;
        this.e = "ccm.registerPermissionChange";
    }

    public final void release() {
        super.release();
        tt5.a.h("CCMRegisterLinkShareChangeMethod", "(" + this + ") destroyLinkShareChangePush, secretPush: " + this.c + ", token: " + du5.b.k(this.a) + ", type: " + this.b);
        c r0 = this.c;
        if (r0 == null) goto L5;
        ((com.bytedance.ee.space.sync.b) org.koin.java.a.c(com.bytedance.ee.space.sync.b.class, null, null, 6)).Lc(r0);
    L5:
        this.c = null;
        this.d = false;
    }

    public final String getName() {
        return this.e;
    }

    public final void handle(XReadableMap r10, XBridgeMethod.Callback r11, XBridgePlatformType r12) {
        Intrinsics.checkNotNullParameter(r10, "params");
        Intrinsics.checkNotNullParameter(r11, "callback");
        Intrinsics.checkNotNullParameter(r12, "platformType");
        if (((Context) provideContext(Context.class)) != null) goto L7;
        tt5.a.d("CCMRegisterLinkShareChangeMethod", "handle, context is null");
        return;
    L7:
        if (s.b(r10, "isRegister", true) == false) goto L28;
        String r13 = r10.getString("realToken");
        int r6 = r10.getInt("realType");
        boolean r8 = false;
        if (r13.length() <= 0) goto L11;
        boolean r7 = true;
    L12:
        if (r7 == false) goto L15;
        if (r6 < 0) goto L15;
        this.a = r13;
        this.b = r6;
    L17:
        if (this.d == true) goto L24;
        tt5.a.h("CCMRegisterLinkShareChangeMethod", "(" + this + ") initLinkShareChangePush, token: " + du5.b.k(this.a) + ", type: " + this.b);
        if (this.a.length() <= 0) goto L22;
        r8 = true;
    L22:
        if (r8 == false) goto L24;
        this.d = true;
    L24:
        tt5.a.h("CCMRegisterLinkShareChangeMethod", "(" + this + ") registerLinkShareChangePush, secretPush: " + this.c + ", token: " + du5.b.k(this.a) + ", type: " + this.b);
        if (this.d == false) goto L34;
        c r14 = new c(this);
        this.c = r14;
        ((com.bytedance.ee.space.sync.b) org.koin.java.a.c(com.bytedance.ee.space.sync.b.class, null, null, 6)).i4(this.a, this.b, r14);
        return;
    L34:
        return;
    L15:
        this.a = r10.getString(ResourceData.KEY_TOKEN);
        this.b = r10.getInt(ResourceData.KEY_TYPE);
        goto L17
    L11:
        r7 = false;
        goto L12
    L28:
        tt5.a.h("CCMRegisterLinkShareChangeMethod", "(" + this + ") unregisterLinkShareChangePush, secretPush: " + this.c + ", token: " + du5.b.k(this.a) + ", type: " + this.b);
        c r15 = this.c;
        if (r15 == null) goto L33;
        ((com.bytedance.ee.space.sync.b) org.koin.java.a.c(com.bytedance.ee.space.sync.b.class, null, null, 6)).Lc(r15);
        return;
    }
}
