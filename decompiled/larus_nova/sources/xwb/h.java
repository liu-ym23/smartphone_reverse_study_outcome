package xwb;

import com.ss.android.lark.chameleon.bridge.BridgeReport;
import com.ss.android.lark.officewebview.base.OfficeWebView;
import kotlin.jvm.internal.Intrinsics;
import ntb.o;

/* JADX INFO: loaded from: classes37.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f565310a = 0;

    static {
    }

    public static void a(OfficeWebView r100, int r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "webView");
        Intrinsics.checkNotNullParameter(BridgeReport.EVENT_BRIDGE_ERROR, "event");
        com.ss.android.lark.officesdk.utils.di.j.b("JSBridge", r102);
        o.c.f520561a.getClass();
        r100.m(BridgeReport.EVENT_BRIDGE_ERROR, new dxb.c.b(r101, o.c.a.f520565d)).b();
    }

    public static void b(OfficeWebView r100, int r101, String r102, String r103) {
        Intrinsics.checkNotNullParameter(r100, "webView");
        Intrinsics.checkNotNullParameter(BridgeReport.EVENT_BRIDGE_ERROR, "event");
        if (r102 != null) goto L5;
        r102 = "";
    L5:
        com.ss.android.lark.officesdk.utils.di.j.b("JSBridge", r102);
        o.c.f520561a.getClass();
        dxb.g r104 = r100.m(BridgeReport.EVENT_BRIDGE_ERROR, new dxb.c.b(r101, o.c.a.f520565d));
        r104.a("api_name", r103);
        r104.b();
    }
}
