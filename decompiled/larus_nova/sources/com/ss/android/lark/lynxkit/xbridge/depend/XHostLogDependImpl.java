package com.ss.android.lark.lynxkit.xbridge.depend;

import com.bytedance.ies.xbridge.XBridgePlatformType;
import com.bytedance.ies.xbridge.base.runtime.depend.IHostLogDepend;
import com.bytedance.ies.xbridge.base.runtime.depend.IReportADLogResultCallback;
import com.bytedance.ies.xbridge.utils.d;
import g66.c;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import s56.e;
import sva.a;

/* JADX INFO: loaded from: classes36.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J(\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0016\u0010\u000e\u001a\u0012\u0012\u0004\u0012\u00020\r\u0012\u0006\u0012\u0004\u0018\u00010\r\u0018\u00010\u000fH\u0016J$\u0010\u0010\u001a\u00020\u000b2\u0012\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\r0\u000f2\u0006\u0010\u0012\u001a\u00020\u0013H\u0016J2\u0010\u0014\u001a\u00020\u000b2\b\u0010\u0015\u001a\u0004\u0018\u00010\u00162\u0006\u0010\u0017\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001cH\u0016R\u001b\u0010\u0004\u001a\u00020\u00058BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u001d"}, d2 = {"Lcom/ss/android/lark/lynxkit/xbridge/depend/XHostLogDependImpl;", "Lcom/bytedance/ies/xbridge/base/runtime/depend/IHostLogDepend;", "<init>", "()V", "appLogProxy", "Lcom/ss/android/lark/applogbridgeapi/IAppLogProxy;", "getAppLogProxy", "()Lcom/ss/android/lark/applogbridgeapi/IAppLogProxy;", "appLogProxy$delegate", "Lkotlin/Lazy;", "onEventV3Map", "", "eventName", "", "map", "", "putCommonParams", "params", "isApi", "", "handleReportADLog", "contextProviderFactory", "Lcom/bytedance/ies/xbridge/model/context/XContextProviderFactory;", "name", "Lcom/bytedance/ies/xbridge/base/runtime/model/XReportADLogParams;", "callback", "Lcom/bytedance/ies/xbridge/base/runtime/depend/IReportADLogResultCallback;", "type", "Lcom/bytedance/ies/xbridge/XBridgePlatformType;", "lark-lynx-xbridge_chinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class XHostLogDependImpl implements IHostLogDepend {
    private final Lazy appLogProxy$delegate;

    @Override // com.bytedance.ies.xbridge.base.runtime.depend.IHostLogDepend
    public d getLogService() {
        return null;
    }

    @Override // com.bytedance.ies.xbridge.base.runtime.depend.IHostLogDepend
    public void handleReportADLog(c r100, String r101, e r102, IReportADLogResultCallback r103, XBridgePlatformType r104) {
        Intrinsics.checkNotNullParameter(r101, "name");
        Intrinsics.checkNotNullParameter(r102, "params");
        Intrinsics.checkNotNullParameter(r103, "callback");
        Intrinsics.checkNotNullParameter(r104, "type");
    }

    private final a getAppLogProxy() {
        return (a) this.appLogProxy$delegate.getValue();
    }

    public XHostLogDependImpl() {
        this.appLogProxy$delegate = LazyKt.lazy(XHostLogDependImpl$appLogProxy$2.INSTANCE);
    }

    @Override // com.bytedance.ies.xbridge.base.runtime.depend.IHostLogDepend
    public void onEventV3Map(String r100, Map<String, String> r101) {
        Intrinsics.checkNotNullParameter(r100, "eventName");
        a r102 = getAppLogProxy();
        if (r101 != null) goto L5;
        r101 = MapsKt.emptyMap();
    L5:
        r102.onEventV3(r100, new JSONObject(r101));
    }

    @Override // com.bytedance.ies.xbridge.base.runtime.depend.IHostLogDepend
    public void putCommonParams(Map<String, String> r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "params");
        getAppLogProxy().putCommonParams(r100, r101);
    }

    @Override // com.bytedance.ies.xbridge.base.runtime.depend.IHostLogDepend
    public Unit reportJSBError(c r100, Map<String, ? extends Object> r101) {
        Intrinsics.checkNotNullParameter(r101, "params");
        return null;
    }

    @Override // com.bytedance.ies.xbridge.base.runtime.depend.IHostLogDepend
    public Unit reportJSBFetchError(c r100, Map<String, ? extends Object> r101) {
        Intrinsics.checkNotNullParameter(r101, "params");
        return null;
    }
}
