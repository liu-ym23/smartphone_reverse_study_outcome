package vo6;

import com.bytedance.ies.xbridge.XBridgePlatformType;
import com.bytedance.ies.xbridge.model.idl.CompletionBlock;
import com.bytedance.ies.xbridge.model.idl.XBaseModel;
import com.bytedance.ies.xbridge.model.idl.XBaseParamModel;
import com.bytedance.ies.xbridge.model.idl.XBaseResultModel;
import com.bytedance.ies.xbridge.utils.g;
import com.bytedance.locallife.biz.monitor.param.KeyPageName;
import com.bytedance.locallife.biz.monitor.param.LifePageParamTraceManager;
import com.bytedance.locallife.biz.monitor.param.PageParamType;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import defpackage.d;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
@XBridgeMethod(name = "localLife.addPageParamMonitor")
public final class a extends d {
    public a() {
    }

    @Override // v56.c
    public final void e(XBaseParamModel r110, v56.a r111, XBridgePlatformType r112) {
        d.b r113 = (d.b) r110;
        Intrinsics.checkNotNullParameter(r113, "params");
        Intrinsics.checkNotNullParameter(r111, "callback");
        Intrinsics.checkNotNullParameter(r112, "type");
        String r114 = r113.getPageName();
        String r100 = r113.getPageSessionId();
        String r101 = r113.getPageParamType();
        String r115 = r113.getParamsJsonStr();
        if (r114.length() != 0) goto L5;
        boolean r102 = true;
    L7:
        if (r102 == false) goto L9;
        CompletionBlock.a.a(r111, 0, "pageName is empty", null, 4);
        return;
    L9:
        KeyPageName[] r103 = KeyPageName.values();
        int r104 = r103.length;
        int r105 = 0;
    L10:
        if (r105 >= r104) goto L15;
        KeyPageName r106 = r103[r105];
        if (Intrinsics.areEqual(r106.getValue(), r114) == true) goto L16;
        r105 = r105 + 1;
    L16:
        if (r106 != null) goto L19;
        CompletionBlock.a.a(r111, 0, "pageName is not supported", null, 4);
        return;
    L19:
        if (r100.length() != 0) goto L21;
        boolean r116 = true;
    L22:
        if (r116 == false) goto L25;
        CompletionBlock.a.a(r111, 0, "pageSessionId is empty", null, 4);
        return;
    L25:
        if (r106 != KeyPageName.CONFIRM_PAGE) goto L28;
        r100 = "confirm_".concat(r100);
    L28:
        if (r101.length() != 0) goto L30;
        boolean r117 = true;
    L31:
        if (r117 == false) goto L33;
        CompletionBlock.a.a(r111, 0, "pageParamType is empty", null, 4);
        return;
    L33:
        PageParamType[] r118 = PageParamType.values();
        int r107 = r118.length;
        int r108 = 0;
    L34:
        if (r108 >= r107) goto L39;
        PageParamType r109 = r118[r108];
        if (Intrinsics.areEqual(r109.getValue(), r101) == true) goto L40;
        r108 = r108 + 1;
    L40:
        if (r109 != null) goto L43;
        CompletionBlock.a.a(r111, 0, "pageParamType is not supported", null, 4);
        return;
    L43:
        if (r115.length() != 0) goto L45;
        boolean r119 = true;
    L46:
        if (r119 == false) goto L48;
        CompletionBlock.a.a(r111, 0, "paramsJsonStr is empty", null, 4);
        return;
    L48:
        boolean r120 = LifePageParamTraceManager.f256714a;
        LifePageParamTraceManager.e(r106, r100, r109, r115);
        Intrinsics.checkNotNullParameter(d.c.class, "<this>");
        XBaseModel r121 = g.c(d.c.class);
        ((d.c) r121).setSuccess(1);
        r111.onSuccess((XBaseResultModel) r121, "");
        return;
    L45:
        r119 = false;
        goto L46
    L39:
        r109 = null;
        goto L40
    L30:
        r117 = false;
        goto L31
    L21:
        r116 = false;
        goto L22
    L15:
        r106 = null;
        goto L16
    L5:
        r102 = false;
        goto L7
    }
}
