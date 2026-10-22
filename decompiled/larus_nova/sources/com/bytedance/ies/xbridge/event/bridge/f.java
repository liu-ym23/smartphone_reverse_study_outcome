package com.bytedance.ies.xbridge.event.bridge;

import android.content.Context;
import android.webkit.WebView;
import com.bytedance.ies.xbridge.XBridgeMethod;
import com.bytedance.ies.xbridge.XBridgePlatformType;
import com.bytedance.ies.xbridge.event.AppEvent;
import com.bytedance.ies.xbridge.event.EventCenter;
import com.bytedance.sdk.xbridge.cn.protocol.h;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public final class f extends x56.c implements h {
    private final Context getContext() {
        return (Context) provideContext(Context.class);
    }

    public f() {
    }

    @Override // x56.c
    public final void e(b66.c r100, x56.c.a r110, XBridgePlatformType r111) {
        Intrinsics.checkNotNullParameter(r100, "params");
        Intrinsics.checkNotNullParameter(r110, "callback");
        Intrinsics.checkNotNullParameter(r111, "type");
        String r101 = r100.f17860a;
        WebView r112 = null;
        if (r101 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("eventName");
        r101 = null;
    L6:
        p56.b r102 = (p56.b) provideContext(p56.b.class);
        if (r102 == null) goto L12;
        String r103 = r102.provideContainerID();
        if (r103 == null) goto L12;
        String r104 = r103;
    L13:
        long r105 = System.currentTimeMillis();
        XBridgeMethod.b r106 = (XBridgeMethod.b) provideContext(XBridgeMethod.b.class);
        if (r104.length() != 0) goto L16;
        boolean r107 = true;
    L17:
        if (r107 == false) goto L21;
        n56.a r108 = (n56.a) provideContext(n56.a.class);
        if (r108 == null) goto L21;
        r112 = r108.f518017a;
    L21:
        WebView r109 = r112;
        AppEvent r113 = com.bytedance.ies.xbridge.event.a.a(r101);
        if (r113 == null) goto L25;
        r113.unActive();
    L25:
        if (Intrinsics.areEqual(r101, AppEvent.KeyboardStatusChange.getEventName()) == false) goto L27;
        b.c(com.bytedance.ies.xbridge.utils.f.f249557a.getActivity(getContext()));
    L27:
        EventCenter.unregisterSubscriber(new com.bytedance.ies.xbridge.event.b(r104, r105, r106, r109), r101);
        r110.a(new i66.b(), "");
        return;
    L16:
        r107 = false;
    L12:
        r104 = "";
        goto L13
    }
}
