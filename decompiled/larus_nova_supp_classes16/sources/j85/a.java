package j85;

import com.ss.android.lark.officewebview.webview_api.bridge.Status;
import com.ss.android.lark.opmonitor.trace.OPTrace;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class a implements zr5.a {
    public a() {
    }

    public final void a(String r8, String r9, vr5.b r10, String r11, Status r12, OPTrace r13) {
        Intrinsics.checkNotNullParameter(r8, "handlerName");
        Intrinsics.checkNotNullParameter(r10, "nativeComponentCode");
        Intrinsics.checkNotNullParameter(r12, "status");
        Intrinsics.checkNotNullParameter(r13, "opTrace");
        if (Intrinsics.areEqual(r8, "insertNativeComponent") == false) goto L10;
        com.bytedance.ee.bear.drive.report.a r0 = o75.b.a().Tb();
        if (Intrinsics.areEqual(r10, vr5.b.d) == false) goto L7;
        String r14 = "DEC0";
    L8:
        r0.p("native_component_handler", r9, r11, r14, r10.c, null);
        return;
    L7:
        r14 = String.valueOf(r10.a);
        goto L8
    }
}
