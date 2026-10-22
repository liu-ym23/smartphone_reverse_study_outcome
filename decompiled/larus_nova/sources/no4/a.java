package no4;

import com.bytedance.ies.xbridge.XBridgeMethod;
import com.bytedance.ies.xbridge.XBridgePlatformType;
import com.bytedance.ies.xbridge.XReadableMap;
import com.bytedance.ies.xbridge.bridgeInterfaces.XCoreBridgeMethod;
import com.ss.android.lark.lynxkit.bridge.LarkLynxBridgeCallContext;
import java.util.LinkedHashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
public final class a extends io4.a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f519901b;

    /* JADX INFO: renamed from: no4.a$a, reason: collision with other inner class name */
    public static final class C6949a {
    }

    static {
    }

    public a() {
        this.f519901b = "bitable.hideLoading";
    }

    @Override // io4.a, com.bytedance.ies.xbridge.bridgeInterfaces.XCoreBridgeMethod, com.bytedance.ies.xbridge.XBridgeMethod
    public final XBridgeMethod.Access getAccess() {
        return XBridgeMethod.Access.PRIVATE;
    }

    @Override // com.bytedance.ies.xbridge.XBridgeMethod
    public final String getName() {
        return this.f519901b;
    }

    @Override // com.bytedance.ies.xbridge.bridgeInterfaces.XCoreBridgeMethod, com.bytedance.ies.xbridge.XBridgeMethod
    public final Class<? extends com.bytedance.ies.xbridge.model.params.a> provideParamModel() {
        return com.bytedance.ies.xbridge.model.params.b.class;
    }

    @Override // com.bytedance.ies.xbridge.bridgeInterfaces.XCoreBridgeMethod, com.bytedance.ies.xbridge.XBridgeMethod
    public final Class<? extends i66.a> provideResultModel() {
        return i66.b.class;
    }

    @Override // com.bytedance.ies.xbridge.XBridgeMethod
    public final void handle(XReadableMap r100, XBridgeMethod.Callback r101, XBridgePlatformType r102) {
        Intrinsics.checkNotNullParameter(r100, "params");
        Intrinsics.checkNotNullParameter(r101, "callback");
        Intrinsics.checkNotNullParameter(r102, "type");
        StringBuilder r103 = new StringBuilder("BitableHideLoadingMethod handle");
        LarkLynxBridgeCallContext r104 = getBridgeContext();
        if (r104 == null) goto L5;
        String r105 = r104.getCallId();
    L6:
        r103.append(r105);
        tt5.a.h("BitableLynx: :BitableHideLoadingMethod", r103.toString());
        d r106 = (d) getBridgeService(d.class);
        if (r106 == null) goto L9;
        r106.hideLoading();
    L9:
        XCoreBridgeMethod.onSuccess$default(this, r101, new LinkedHashMap(), null, 4, null);
        return;
    L5:
        r105 = null;
        goto L6
    }
}
