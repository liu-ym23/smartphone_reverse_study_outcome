package com.bytedance.ies.xbridge.event.bridge;

import android.app.Activity;
import android.content.Context;
import android.view.Window;
import android.webkit.WebView;
import com.bytedance.ies.xbridge.XBridgeMethod;
import com.bytedance.ies.xbridge.XBridgePlatformType;
import com.bytedance.ies.xbridge.event.AppEvent;
import com.bytedance.ies.xbridge.event.EventCenter;
import com.bytedance.sdk.xbridge.cn.protocol.h;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public final class e extends x56.b implements h {
    private final Context getContext() {
        return (Context) provideContext(Context.class);
    }

    @Override // com.bytedance.ies.xbridge.bridgeInterfaces.XCoreBridgeMethod, com.bytedance.ies.xbridge.XBridgeMethod, com.bytedance.sdk.xbridge.cn.protocol.h
    public final void release() {
        super.release();
        p56.b r100 = (p56.b) provideContext(p56.b.class);
        if (r100 == null) goto L6;
        String r101 = r100.provideContainerID();
        if (r101 == null) goto L6;
    L7:
        EventCenter.release(r101);
        return;
    L6:
        r101 = "";
        goto L7
    }

    public e() {
    }

    @Override // x56.b
    public final void e(b66.b r110, x56.b.a r111, XBridgePlatformType r112) {
        Intrinsics.checkNotNullParameter(r110, "params");
        Intrinsics.checkNotNullParameter(r111, "callback");
        Intrinsics.checkNotNullParameter(r112, "type");
        p56.b r113 = (p56.b) provideContext(p56.b.class);
        if (r113 == null) goto L8;
        String r114 = r113.provideContainerID();
        if (r114 == null) goto L8;
        String r100 = r114;
    L9:
        String r115 = r110.f17856a;
        Window r101 = null;
        if (r115 != null) goto L13;
        Intrinsics.throwUninitializedPropertyAccessException("eventName");
        r115 = null;
    L13:
        long r102 = r110.f17857b;
        XBridgeMethod.b r103 = (XBridgeMethod.b) provideContext(XBridgeMethod.b.class);
        n56.a r116 = (n56.a) provideContext(n56.a.class);
        if (r116 == null) goto L16;
        WebView r104 = r116.f518017a;
    L17:
        AppEvent r117 = com.bytedance.ies.xbridge.event.a.a(r115);
        if (r117 == null) goto L21;
        r117.active();
    L21:
        if (Intrinsics.areEqual(r115, AppEvent.KeyboardStatusChange.getEventName()) == false) goto L33;
        Context r118 = getContext();
        Activity r105 = com.bytedance.ies.xbridge.utils.f.f249557a.getActivity(r118);
        AppEvent r106 = com.bytedance.ies.xbridge.event.a.a(r115);
        if (r106 == null) goto L27;
        boolean r107 = true;
        if (r106.isActive() != true) goto L27;
    L28:
        if (r107 == false) goto L33;
        int r108 = b.f249480a;
        if (r105 == null) goto L32;
        r101 = r105.getWindow();
    L32:
        b.b(r118, r101, new d());
    L27:
        r107 = false;
    L33:
        EventCenter.registerSubscriber(new com.bytedance.ies.xbridge.event.b(r100, r102, r103, r104), r115);
        r111.a(new i66.b(), "");
        return;
    L16:
        r104 = null;
    L8:
        r100 = "";
        goto L9
    }
}
