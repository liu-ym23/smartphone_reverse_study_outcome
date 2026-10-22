package com.bytedance.locallife.bridge.groupon.method;

import android.view.View;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.bytedance.sdk.xbridge.cn.registry.core.IBDXBridgeContext;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.CompletionBlock;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseParamModel;
import com.ss.android.ugc.aweme.feed.model.nearby.NearbyPageType;
import java.util.Objects;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
@XBridgeMethod(name = "getGrouponTargetViewPosition", owner = "sunxinghang")
public final class GetGroupOnTargetViewPositionMethod extends qo6.b {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Lazy f257088d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Lazy f257089e;

    public static final class a {
    }

    static {
    }

    public GetGroupOnTargetViewPositionMethod() {
        this.f257088d = LazyKt.lazy(GetGroupOnTargetViewPositionMethod$diamondPositionCalculator$2.INSTANCE);
        this.f257089e = LazyKt.lazy(GetGroupOnTargetViewPositionMethod$lifeHeaderPositionCalculator$2.INSTANCE);
    }

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.bridgeInterfaces.XCoreIDLBridgeMethod
    public final void handle(IBDXBridgeContext r110, XBaseParamModel r111, CompletionBlock r112) {
        qo6.b.InterfaceC7374b r100 = (qo6.b.InterfaceC7374b) r111;
        Intrinsics.checkNotNullParameter(r110, "bridgeContext");
        Intrinsics.checkNotNullParameter(r100, "params");
        Intrinsics.checkNotNullParameter(r112, "callback");
        String r101 = r100.getModule();
        String r102 = r100.getEntranceName();
        String r103 = r100.getTargetView();
        Number r104 = r100.getCardType();
        if (r104 == null) goto L5;
        Integer r105 = Integer.valueOf(r104.intValue());
    L6:
        int r106 = r100.getPageType().intValue();
        NearbyPageType r107 = NearbyPageType.TAB_NEARBY;
        if (r106 == r107.getServerCode()) goto L16;
        r107 = NearbyPageType.PAGE_GROUP_BUY;
        if (r106 == r107.getServerCode()) goto L16;
        r107 = NearbyPageType.TAB_GROUP_BUY;
        if (r106 == r107.getServerCode()) goto L16;
        r107 = null;
    L16:
        if (r107 != null) goto L18;
        CompletionBlock.DefaultImpls.onFailure$default(r112, -300, "pageType must be 0,1,2", null, 4, null);
        return;
    L18:
        int r108 = com.bytedance.locallife.groupon.basic.utils.c.f258790a;
        wq6.a r109 = (wq6.a) com.bytedance.locallife.groupon.basic.utils.c.a(wq6.a.class);
        if (r109 == null) goto L23;
        r100.getArea();
        Intrinsics.checkNotNullParameter("", "default");
        if (r109.i() != true) goto L23;
        boolean r113 = true;
    L24:
        if (r113 == false) goto L28;
        if (r103 == null) goto L27;
        if (r105 != null) goto L28;
    L27:
        CompletionBlock.DefaultImpls.onFailure$default(r112, -200, "must set 'targetView' & 'cardType'", null, 4, null);
        return;
    L28:
        b0 r114 = new b0(r101, r102, r105, r103);
        if (r113 == false) goto L33;
        ((c) this.f257088d.getValue()).getClass();
        Intrinsics.checkNotNullParameter(r114, "viewInfo");
        Intrinsics.checkNotNullParameter(r107, "pageType");
        wq6.a r115 = (wq6.a) com.bytedance.locallife.groupon.basic.utils.c.a(wq6.a.class);
        if (r115 == null) goto L40;
        r115.j();
    L40:
        v r116 = null;
    L41:
        r114.toString();
        Objects.toString(r116);
        if (r116 != null) goto L44;
        CompletionBlock.DefaultImpls.onFailure$default(r112, -100, "entrance not exist", null, 4, null);
        return;
    L44:
        qo6.b.c r117 = (qo6.b.c) ne7.e.b(qo6.b.c.class);
        r117.setLeft(Integer.valueOf(r116.f257122b));
        r117.setTop(Integer.valueOf(r116.f257121a));
        r117.setWidth(Integer.valueOf(r116.f257123c));
        r117.setHeight(Integer.valueOf(r116.f257124d));
        CompletionBlock.DefaultImpls.onSuccess$default(r112, r117, null, 2, null);
        return;
    L33:
        ((m) this.f257089e.getValue()).getClass();
        Intrinsics.checkNotNullParameter(r114, "viewInfo");
        Intrinsics.checkNotNullParameter(r107, "pageType");
        wq6.a r118 = (wq6.a) com.bytedance.locallife.groupon.basic.utils.c.a(wq6.a.class);
        if (r118 == null) goto L40;
        View r119 = r118.k();
        if (r119 == null) goto L40;
        if (r119.getVisibility() != 0) goto L40;
        Intrinsics.checkNotNullParameter(r119, "<this>");
        int[] r120 = new int[2];
        r119.getLocationOnScreen(r120);
        r116 = new v(com.bytedance.locallife.dito.utils.e.d(Integer.valueOf(r120[1])), com.bytedance.locallife.dito.utils.e.d(Integer.valueOf(r120[0])), com.bytedance.locallife.dito.utils.e.d(Integer.valueOf(r119.getWidth())), com.bytedance.locallife.dito.utils.e.d(Integer.valueOf(r119.getHeight())));
        r116.toString();
    L23:
        r113 = false;
        goto L24
    L5:
        r105 = null;
        goto L6
    }
}
