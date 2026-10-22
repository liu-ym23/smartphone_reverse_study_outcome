package com.ivy.ivykit.plugin.impl.utils;

import com.bytedance.ies.xbridge.XBridgeMethod;
import com.bytedance.ies.xbridge.XReadableMap;
import java.lang.ref.WeakReference;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes23.dex */
public final class t implements XBridgeMethod.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ WeakReference<d47.a> f278455a;

    public t(WeakReference<d47.a> r100) {
        this.f278455a = r100;
    }

    @Override // com.bytedance.ies.xbridge.XBridgeMethod.b
    public final void sendJsEvent(String r100, XReadableMap r101) {
        Intrinsics.checkNotNullParameter(r100, "eventName");
        d47.a r102 = this.f278455a.get();
        if (r102 == null) goto L9;
        if (r101 == null) goto L6;
        Map<String, Object> r103 = r101.toMap();
    L7:
        r102.a(r100, r103);
        return;
    L6:
        r103 = null;
        goto L7
    }
}
