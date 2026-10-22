package qe5;

import android.content.Context;
import com.bytedance.ies.xbridge.XBridgeMethod;
import com.bytedance.ies.xbridge.XBridgePlatformType;
import com.bytedance.ies.xbridge.XReadableMap;
import com.bytedance.ies.xbridge.bridgeInterfaces.XCoreBridgeMethod;
import com.bytedance.ies.xbridge.s;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class i extends XCoreBridgeMethod {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f532676a;

    public static final class a {
    }

    static {
    }

    public i() {
        this.f532676a = "ccm.permission.showRealNameAuthDialog";
    }

    @Override // com.bytedance.ies.xbridge.XBridgeMethod
    public final String getName() {
        return this.f532676a;
    }

    @Override // com.bytedance.ies.xbridge.XBridgeMethod
    public final void handle(XReadableMap r100, XBridgeMethod.Callback r101, XBridgePlatformType r102) {
        Intrinsics.checkNotNullParameter(r100, "params");
        Intrinsics.checkNotNullParameter(r101, "callback");
        Intrinsics.checkNotNullParameter(r102, "type");
        Context r103 = (Context) provideContext(Context.class);
        if (r103 != null) goto L6;
        tt5.a.d("ccm-lynx: CCMShowRealNameAuthDialogMethod", "handle()...context is null");
        return;
    L6:
        int r104 = r100.getInt("code");
        String r105 = s.f(r100, "token", "");
        int r106 = r100.getInt("type");
        ((cj5.c) org.koin.java.a.c(cj5.c.class, null, null, 6)).G8(r103, r105, r106, r104);
    }
}
