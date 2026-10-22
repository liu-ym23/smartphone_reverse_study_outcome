package com.bytedance.applet.impl;

import android.view.View;
import android.webkit.WebView;
import com.bytedance.ai.model.AppletRuntimeManager;
import com.bytedance.applet.jsb.AppletSendOutputMethod;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class b {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static void a(AppletSendOutputMethod r8, dx7.b r9) {
        Intrinsics.checkNotNullParameter(r8, "<this>");
        Intrinsics.checkNotNullParameter(r9, "params");
        h16.e r10 = (h16.e) r8.e(h16.e.class);
        if (r10 == null) goto L7;
        com.bytedance.ies.bullet.service.base.o r11 = r10.getKitView();
        if (r11 == null) goto L7;
        View r12 = r11.realView();
    L9:
        if ((r12 instanceof WebView) == false) goto L11;
        WebView r13 = (WebView) r12;
    L12:
        if (r13 != null) goto L14;
        return;
    L14:
        String r1 = r9.getString("message");
        AppletRuntimeManager.INSTANCE.getClass();
        k2.i r14 = AppletRuntimeManager.d(r13);
        if (Intrinsics.areEqual(r9.getString("type"), AppletSendOutputMethod.SupportedOutputType.Tips.getTypeName()) == false) goto L18;
        BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new AppletBridgeFlavorDelegate$sendOutput$1(r14, r1, null), 3, null);
        return;
    L18:
        return;
    L11:
        r13 = null;
    L7:
        r12 = null;
        goto L9
    }
}
