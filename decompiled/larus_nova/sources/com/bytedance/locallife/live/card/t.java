package com.bytedance.locallife.live.card;

import com.bytedance.ies.xbridge.XReadableMap;
import com.bytedance.ies.xbridge.event.Js2NativeEvent;
import com.bytedance.ies.xbridge.event.JsEventSubscriber;
import com.bytedance.ies.xbridge.v;
import com.bytedance.locallife.live.util.LiveLifeSaaSUtil;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
public final class t implements JsEventSubscriber {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ r f259340a;

    public t(r r100) {
        this.f259340a = r100;
    }

    @Override // com.bytedance.ies.xbridge.event.JsEventSubscriber
    public final void onReceiveJsEvent(Js2NativeEvent r100) {
        Intrinsics.checkNotNullParameter(r100, "jsEvent");
        if (Intrinsics.areEqual(r100.getEventName(), "POI_LIVE_ENTRY_COUPON_CHANGE_NOTIFICATION") == false) goto L16;
        XReadableMap r101 = r100.getParams();
        List<Object> r102 = null;
        if (r101 == null) goto L7;
        String r103 = r101.getString("from");
    L9:
        if (Intrinsics.areEqual(r103, "lynx") == false) goto L16;
        r r104 = this.f259340a;
        XReadableMap r105 = r100.getParams();
        if (r105 == null) goto L15;
        v r106 = r105.getArray("coupon_collected_list");
        if (r106 == null) goto L15;
        r102 = r106.toList();
    L15:
        r.a(r104, r102);
        goto L16
    L7:
        r103 = null;
    L16:
        LiveLifeSaaSUtil.t().i(this.f259340a.f259283d, r100.toString());
    }
}
