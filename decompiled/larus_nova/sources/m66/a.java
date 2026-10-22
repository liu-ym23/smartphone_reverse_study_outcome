package m66;

import com.bytedance.ies.xbridge.XBridgeMethod;
import com.bytedance.ies.xbridge.XBridgePlatformType;
import com.bytedance.ies.xbridge.XBridgeRegister;
import com.bytedance.ies.xbridge.n;
import com.bytedance.ies.xbridge.o;
import com.bytedance.ies.xbridge.platform.lynx.LynxBridgeModule;
import java.util.LinkedHashMap;
import kotlin.jvm.internal.Intrinsics;
import n66.d;

/* JADX INFO: loaded from: classes19.dex */
public final class a extends o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final XBridgePlatformType f512285a;

    public a() {
        this.f512285a = XBridgePlatformType.LYNX;
    }

    @Override // com.bytedance.ies.xbridge.o
    public XBridgePlatformType getType() {
        return this.f512285a;
    }

    public final void a(String r100, d r101, LynxBridgeModule.b.a r102, XBridgeRegister r103) {
        Intrinsics.checkNotNullParameter(r100, "name");
        Intrinsics.checkNotNullParameter(r101, "params");
        Intrinsics.checkNotNullParameter(r102, "callback");
        Intrinsics.checkNotNullParameter(r103, "xBridgeRegister");
        Intrinsics.checkNotNullParameter(r100, "name");
        Intrinsics.checkNotNullParameter(r101, "params");
        Intrinsics.checkNotNullParameter(r102, "callback");
        Intrinsics.checkNotNullParameter(r103, "xBridgeRegister");
        r103.getClass();
        Intrinsics.checkNotNullParameter(r100, "name");
        XBridgeRegister.a r104 = (XBridgeRegister.a) r103.f249438a.getValue();
        r104.getClass();
        Intrinsics.checkNotNullParameter(r100, "name");
        n r105 = (n) ((LinkedHashMap) r104.f249439a).get(r100);
        if (r105 == null) goto L8;
        XBridgeMethod r106 = r105.a();
        if (r106 == null) goto L9;
        r106.handle(r101, r102, getType());
        return;
    L9:
        return;
    }
}
