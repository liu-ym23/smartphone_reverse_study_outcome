package ne5;

import android.content.Context;
import com.bytedance.ee.docsdk.impl.document.plugins.offline.storage.ResourceData;
import com.bytedance.ies.xbridge.XBridgeMethod;
import com.bytedance.ies.xbridge.XBridgePlatformType;
import com.bytedance.ies.xbridge.XReadableMap;
import com.bytedance.ies.xbridge.bridgeInterfaces.XCoreBridgeMethod;
import com.bytedance.ies.xbridge.s;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class a extends XCoreBridgeMethod {
    public String a;
    public int b;
    public b c;
    public final String d;

    /* JADX INFO: renamed from: ne5.a$a, reason: collision with other inner class name */
    public static final class C0273a {
    }

    static {
    }

    public final void e() {
        tt5.a.h("CCMRegisterSecretChangeMethod", "(" + this + ") releaseSecretPush, secretPush: " + this.c + ", token: " + du5.b.k(this.a) + ", type: " + this.b);
        b r0 = this.c;
        if (r0 == null) goto L5;
        ((com.bytedance.ee.space.sync.b) org.koin.java.a.c(com.bytedance.ee.space.sync.b.class, null, null, 6)).Ye(r0);
    L5:
        this.c = null;
    }

    public a() {
        this.a = "";
        this.b = -1;
        this.d = "ccm.registerSecretChange";
    }

    public final void release() {
        super.release();
        e();
    }

    public final String getName() {
        return this.d;
    }

    public final void handle(XReadableMap r5, XBridgeMethod.Callback r6, XBridgePlatformType r7) {
        Intrinsics.checkNotNullParameter(r5, "params");
        Intrinsics.checkNotNullParameter(r6, "callback");
        Intrinsics.checkNotNullParameter(r7, "platformType");
        if (((Context) provideContext(Context.class)) != null) goto L6;
        tt5.a.d("CCMRegisterSecretChangeMethod", "handle, context is null");
        return;
    L6:
        boolean r0 = true;
        if (s.b(r5, "isRegister", true) == false) goto L28;
        String r8 = r5.getString("realToken");
        int r1 = r5.getInt("realType");
        if (r8.length() <= 0) goto L11;
        boolean r2 = true;
    L12:
        if (r2 == false) goto L15;
        if (r1 < 0) goto L15;
        this.a = r8;
        this.b = r1;
    L17:
        if (this.c != null) goto L32;
        tt5.a.h("CCMRegisterSecretChangeMethod", "(" + this + ") initSecretPush, token: " + du5.b.k(this.a) + ", type: " + this.b);
        if (this.a.length() == 0) goto L23;
        r0 = false;
    L23:
        if (r0 == false) goto L25;
        return;
    L25:
        if (this.b <= 0) goto L33;
        b r9 = new b(this);
        ((com.bytedance.ee.space.sync.b) org.koin.java.a.c(com.bytedance.ee.space.sync.b.class, null, null, 6)).d7(this.a, this.b, r9);
        this.c = r9;
        return;
    L33:
        return;
    L32:
        return;
    L15:
        this.a = r5.getString(ResourceData.KEY_TOKEN);
        this.b = r5.getInt(ResourceData.KEY_TYPE);
        goto L17
    L11:
        r2 = false;
        goto L12
    L28:
        e();
    }
}
