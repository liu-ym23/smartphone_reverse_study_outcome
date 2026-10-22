package com.bytedance.ee.bear.lynx.impl.xbridge;

import android.view.View;
import com.bytedance.ies.xbridge.XBridgeMethod;
import com.bytedance.ies.xbridge.XReadableMap;
import com.lynx.react.bridge.JavaOnlyArray;
import com.lynx.tasm.LynxView;
import java.lang.ref.WeakReference;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class f implements XBridgeMethod.b {
    public final WeakReference<View> a;

    public f(View r2) {
        Intrinsics.checkNotNullParameter(r2, "view");
        this.a = new WeakReference(r2);
    }

    public final void sendJsEvent(String r3, XReadableMap r4) {
        Intrinsics.checkNotNullParameter(r3, "eventName");
        LynxView r0 = (View) this.a.get();
        if (r0 != null) goto L6;
        return;
    L6:
        if ((r0 instanceof LynxView) == false) goto L13;
        LynxView r1 = r0;
        if (r4 != null) goto L10;
        JavaOnlyArray r5 = new JavaOnlyArray();
    L11:
        r1.sendGlobalEvent(r3, r5);
        return;
    L10:
        r5 = JavaOnlyArray.from(CollectionsKt.toList(r4.toMap().values()));
        Intrinsics.checkNotNull(r5);
        goto L11
    }
}
