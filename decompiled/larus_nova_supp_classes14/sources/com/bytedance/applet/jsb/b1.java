package com.bytedance.applet.jsb;

import com.ivy.ivykit.api.bridge.core.IvyBridgeMethod;
import com.ivy.ivykit.api.bridge.core.model.IvyBridgePlatformType;
import com.larus.utils.logger.FLogger;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class b1 extends bx7.c {
    public static final /* synthetic */ int b = 0;

    public static final class a {
    }

    static {
    }

    public final String getName() {
        return "applet.updateWidgetData";
    }

    public b1() {
    }

    public final void a(dx7.b r13, ux7.d.d r14, IvyBridgePlatformType r15) {
        Intrinsics.checkNotNullParameter(r13, "params");
        Intrinsics.checkNotNullParameter(r14, "callback");
        Intrinsics.checkNotNullParameter(r15, "type");
        FLogger r16 = FLogger.a;
        r16.i("AppletUpdateWidgetDataMethod", "handle id=" + r13.getString("id") + " data=" + r13.getString("data"));
        String r0 = r13.getString("type");
        if (Intrinsics.areEqual(r0, "msg") == false) goto L11;
        String r7 = r13.getString("id");
        if (r7.length() != 0) goto L7;
        boolean r1 = true;
    L8:
        if (r1 == false) goto L10;
        r16.e("AppletUpdateWidgetDataMethod", "invalid messageId=".concat(r7));
        f(r14, -3, "invalid messageId", false);
        return;
    L10:
        BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new AppletUpdateWidgetDataMethod$updateMessageContent$1(r7, this, r14, r13, null), 3, null);
        return;
    L7:
        r1 = false;
        goto L8
    L11:
        r16.e("AppletUpdateWidgetDataMethod", "handle unknown widgetType " + r0);
        f(r14, -3, "invalid type", false);
    }

    public static void f(IvyBridgeMethod.a r2, int r3, String r4, boolean r5) {
        r2.invoke(MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("code", Integer.valueOf(r3)), TuplesKt.to("msg", r4), TuplesKt.to("data", MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("success", Boolean.valueOf(r5))}))}));
    }
}
