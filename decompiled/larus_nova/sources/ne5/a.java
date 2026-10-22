package ne5;

import android.content.Context;
import com.bytedance.ies.xbridge.XBridgeMethod;
import com.bytedance.ies.xbridge.XBridgePlatformType;
import com.bytedance.ies.xbridge.XReadableMap;
import com.bytedance.ies.xbridge.bridgeInterfaces.XCoreBridgeMethod;
import com.bytedance.ies.xbridge.s;
import com.tencent.qqmusic.third.api.contract.Keys;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class a extends XCoreBridgeMethod {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f518882a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f518883b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public b f518884c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f518885d;

    /* JADX INFO: renamed from: ne5.a$a, reason: collision with other inner class name */
    public static final class C6920a {
    }

    static {
    }

    public final void e() {
        tt5.a.h("CCMRegisterSecretChangeMethod", "(" + this + ") releaseSecretPush, secretPush: " + this.f518884c + ", token: " + du5.b.k(this.f518882a) + ", type: " + this.f518883b);
        b r100 = this.f518884c;
        if (r100 == null) goto L5;
        ((com.bytedance.ee.space.sync.b) org.koin.java.a.c(com.bytedance.ee.space.sync.b.class, null, null, 6)).Ye(r100);
    L5:
        this.f518884c = null;
    }

    public a() {
        this.f518882a = "";
        this.f518883b = -1;
        this.f518885d = "ccm.registerSecretChange";
    }

    @Override // com.bytedance.ies.xbridge.bridgeInterfaces.XCoreBridgeMethod, com.bytedance.ies.xbridge.XBridgeMethod, com.bytedance.sdk.xbridge.cn.protocol.h
    public final void release() {
        super.release();
        e();
    }

    @Override // com.bytedance.ies.xbridge.XBridgeMethod
    public final String getName() {
        return this.f518885d;
    }

    @Override // com.bytedance.ies.xbridge.XBridgeMethod
    public final void handle(XReadableMap r100, XBridgeMethod.Callback r101, XBridgePlatformType r102) {
        Intrinsics.checkNotNullParameter(r100, "params");
        Intrinsics.checkNotNullParameter(r101, "callback");
        Intrinsics.checkNotNullParameter(r102, Keys.API_PARAM_KEY_PLATFORM_TYPE);
        if (((Context) provideContext(Context.class)) != null) goto L6;
        tt5.a.d("CCMRegisterSecretChangeMethod", "handle, context is null");
        return;
    L6:
        boolean r103 = true;
        if (s.b(r100, "isRegister", true) == false) goto L28;
        String r104 = r100.getString("realToken");
        int r105 = r100.getInt("realType");
        if (r104.length() <= 0) goto L11;
        boolean r106 = true;
    L12:
        if (r106 == false) goto L15;
        if (r105 < 0) goto L15;
        this.f518882a = r104;
        this.f518883b = r105;
    L17:
        if (this.f518884c != null) goto L32;
        tt5.a.h("CCMRegisterSecretChangeMethod", "(" + this + ") initSecretPush, token: " + du5.b.k(this.f518882a) + ", type: " + this.f518883b);
        if (this.f518882a.length() == 0) goto L23;
        r103 = false;
    L23:
        if (r103 == false) goto L25;
        return;
    L25:
        if (this.f518883b <= 0) goto L33;
        b r107 = new b(this);
        ((com.bytedance.ee.space.sync.b) org.koin.java.a.c(com.bytedance.ee.space.sync.b.class, null, null, 6)).d7(this.f518882a, this.f518883b, r107);
        this.f518884c = r107;
        return;
    L33:
        return;
    L32:
        return;
    L15:
        this.f518882a = r100.getString("token");
        this.f518883b = r100.getInt("type");
        goto L17
    L11:
        r106 = false;
        goto L12
    L28:
        e();
    }
}
