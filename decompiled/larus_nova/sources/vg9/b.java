package vg9;

import android.content.Context;
import com.bytedance.mt.protector.impl.string2number.CastDoubleProtector;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.bytedance.sdk.xbridge.cn.registry.core.IBDXBridgeContext;
import com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod;
import com.bytedance.sdk.xbridge.cn.registry.core.annotation.XBridgeMethodName;
import com.bytedance.sdk.xbridge.cn.registry.core.annotation.XBridgeModelExtension;
import com.bytedance.sdk.xbridge.cn.registry.core.annotation.XBridgeParamField;
import com.bytedance.sdk.xbridge.cn.registry.core.annotation.XBridgeParamModel;
import com.bytedance.sdk.xbridge.cn.registry.core.annotation.XBridgePermission;
import com.bytedance.sdk.xbridge.cn.registry.core.bridgeInterfaces.XCoreIDLBridgeMethod;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.CompletionBlock;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseParamModel;
import com.larus.platform.spi.IAIChatService;
import java.util.Map;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes30.dex */
@XBridgeMethod(name = "flow.openMapSelectPanel")
public final class b extends XCoreIDLBridgeMethod<InterfaceC8004b, Object> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @XBridgeModelExtension
    public static final Map<String, Object> f554771c = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @XBridgeMethodName(name = "flow.openMapSelectPanel", params = {"commonProps", "poiName", "lon", "lat"})
    public final String f554772a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @XBridgePermission(permission = IDLXBridgeMethod.Access.PRIVATE)
    public final IDLXBridgeMethod.Access f554773b;

    public static final class a {
    }

    /* JADX INFO: renamed from: vg9.b$b, reason: collision with other inner class name */
    @XBridgeParamModel
    public interface InterfaceC8004b extends XBaseParamModel {
        @XBridgeParamField(isGetter = true, keyPath = "commonProps", required = true)
        Map<String, Object> getCommonProps();

        @XBridgeParamField(isGetter = true, keyPath = "lat", required = true)
        String getLat();

        @XBridgeParamField(isGetter = true, keyPath = "lon", required = true)
        String getLon();

        @XBridgeParamField(isGetter = true, keyPath = "poiName", required = true)
        String getPoiName();
    }

    static {
        f554771c = MapsKt.mapOf(TuplesKt.to("TicketID", "31243"));
    }

    public b() {
        this.f554772a = "flow.openMapSelectPanel";
        this.f554773b = IDLXBridgeMethod.Access.PRIVATE;
    }

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.bridgeInterfaces.XCoreIDLBridgeMethod, com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod
    public final IDLXBridgeMethod.Access getAccess() {
        return this.f554773b;
    }

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod
    public final String getName() {
        return this.f554772a;
    }

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.bridgeInterfaces.XCoreIDLBridgeMethod
    public final void handle(IBDXBridgeContext r110, XBaseParamModel r111, CompletionBlock r112) {
        InterfaceC8004b r113 = (InterfaceC8004b) r111;
        Intrinsics.checkNotNullParameter(r110, "bridgeContext");
        Intrinsics.checkNotNullParameter(r113, "params");
        Intrinsics.checkNotNullParameter(r112, "callback");
        final Object r114 = r113.getCommonProps().get("botId");
        final Object r100 = r113.getCommonProps().get("messageId");
        final Object r101 = r113.getCommonProps().get("conversationId");
        Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L9
        Context r103 = vx7.a.getContext(r110);     // Catch: Throwable -> L9
        if (r103 == null) goto L6;
        IAIChatService.f365899a.y7(r103, CastDoubleProtector.parseDouble(r113.getLat()), CastDoubleProtector.parseDouble(r113.getLon()), r113.getPoiName(), new vg9.a(r114, r100, r101));     // Catch: Throwable -> L9
        Unit r115 = Unit.INSTANCE;     // Catch: Throwable -> L9
    L7:
        Result.m9449constructorimpl(r115);     // Catch: Throwable -> L9
        return;
    L6:
        r115 = null;
    L9:
        th = move-exception;
        Result.Companion r116 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
    }
}
