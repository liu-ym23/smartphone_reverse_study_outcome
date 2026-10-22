package com.bytedance.locallife.live.card;

import com.bytedance.ies.xbridge.XReadableMap;
import com.bytedance.ies.xbridge.event.Js2NativeEvent;
import com.bytedance.ies.xbridge.event.JsEventSubscriber;
import com.bytedance.ies.xbridge.v;
import com.bytedance.locallife.live.util.LiveLifeSaaSUtil;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
public final class s implements JsEventSubscriber {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ r f259291a;

    public s(r r100) {
        this.f259291a = r100;
    }

    @Override // com.bytedance.ies.xbridge.event.JsEventSubscriber
    public final void onReceiveJsEvent(Js2NativeEvent r100) {
        Intrinsics.checkNotNullParameter(r100, "jsEvent");
        if (Intrinsics.areEqual(r100.getEventName(), "POI_LIVE_ENTRY_COUPON_LIST_NOTIFICATION") == false) goto L16;
        r r101 = this.f259291a;
        XReadableMap r102 = r100.getParams();
        List<Object> r103 = null;
        if (r102 == null) goto L9;
        v r104 = r102.getArray("coupon_list");
        if (r104 == null) goto L9;
        List<Object> r105 = r104.toList();
    L10:
        r101.f259280a = (ArrayList) r105;
        XReadableMap r106 = r100.getParams();
        if (r106 == null) goto L15;
        v r107 = r106.getArray("invalid_coupon_list");
        if (r107 == null) goto L15;
        r103 = r107.toList();
    L15:
        r.a(this.f259291a, (ArrayList) r103);
    L9:
        r105 = null;
    L16:
        LiveLifeSaaSUtil.t().i(this.f259291a.f259283d, r100.toString());
    }
}
