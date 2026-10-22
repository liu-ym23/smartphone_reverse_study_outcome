package m5;

import android.os.Handler;
import com.bytedance.ai.monitor.AppletMonitorableEvent;
import com.bytedance.mt.protector.impl.JSONObjectProtectorUtils;
import com.obric.aiagent.assistant.idl.IFlowAppIntentIDL;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes43.dex */
public final class y0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final i1 f512051a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final g1 f512052b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Lazy f512053c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static com.bytedance.ai.widget.l f512054d;

    public static final class a implements k5.j {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ JSONObject f512055a;

        public a(JSONObject r100) {
            this.f512055a = r100;
        }

        @Override // k5.j
        public final void a(AppletMonitorableEvent r100) {
            Intrinsics.checkNotNullParameter(r100, "event");
            JSONObject r101 = this.f512055a.optJSONObject("category");
            if (r101 == null) goto L5;
            r100.f37148i = r101;
        L5:
            JSONObject r102 = this.f512055a.optJSONObject("metric");
            if (r102 == null) goto L9;
            r100.f37149j = r102;
            return;
        }
    }

    public y0() {
    }

    static {
        f512051a = new i1();
        f512052b = new g1();
        f512053c = LazyKt.lazy(new m5.a());
    }

    public static void c(final String r100) {
        Intrinsics.checkNotNullParameter(r100, "traceId");
        final long r101 = System.currentTimeMillis();
        r(new l(r100, r101));
    }

    public static void q(JSONObject r100) {
        if (r100 == null) goto L5;
        String r101 = JSONObjectProtectorUtils.getString(r100, "eventName");
        AtomicBoolean r102 = com.bytedance.ai.monitor.b.f37194a;
        Intrinsics.checkNotNull(r101);
        a r103 = new a(r100);
        Intrinsics.checkNotNullParameter(r101, "name");
        Intrinsics.checkNotNullParameter(r103, "builder");
        com.bytedance.ai.monitor.b.e(new k5.f(r101, r103, System.currentTimeMillis()));
        return;
    }

    public static void r(final Function0 r100) {
        ((Handler) f512053c.getValue()).post(new j0(r100));
    }

    public static void f(final String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "traceId");
        Intrinsics.checkNotNullParameter(r101, "eventType");
        final long r102 = System.currentTimeMillis();
        com.bytedance.ai.utils.g.f37637a.d("AppletEventMonitorManager", "onPageFinished: " + r100 + ", " + r101);
        if (Intrinsics.areEqual(r101, "applet_widget_timeline_full") == false) goto L6;
        r(new g(r100, r102));
        return;
    L6:
        if (Intrinsics.areEqual(r101, "applet_page_timeline_full") == false) goto L10;
        r(new h(r100, r102));
        return;
    }

    public static void g(final String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "traceId");
        Intrinsics.checkNotNullParameter(r101, "eventType");
        final long r102 = System.currentTimeMillis();
        com.bytedance.ai.utils.g.f37637a.d("AppletEventMonitorManager", "onPageStart: " + r100 + ", " + r101);
        if (Intrinsics.areEqual(r101, "applet_widget_timeline_full") == false) goto L6;
        r(new q(r100, r102));
        return;
    L6:
        if (Intrinsics.areEqual(r101, "applet_page_timeline_full") == false) goto L10;
        r(new r(r100, r102));
        return;
    }

    public static void h(final String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "traceId");
        Intrinsics.checkNotNullParameter(r101, "eventType");
        final long r102 = System.currentTimeMillis();
        com.bytedance.ai.utils.g.f37637a.d("AppletEventMonitorManager", "onPrepareComponentEnd: " + r100 + ", " + r101);
        if (Intrinsics.areEqual(r101, "applet_widget_timeline_full") == false) goto L6;
        r(new b0(r100, r102));
        return;
    L6:
        if (Intrinsics.areEqual(r101, "applet_page_timeline_full") == false) goto L10;
        r(new c0(r100, r102));
        return;
    }

    public static void i(final String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "traceId");
        Intrinsics.checkNotNullParameter(r101, "eventType");
        final long r102 = System.currentTimeMillis();
        com.bytedance.ai.utils.g.f37637a.d("AppletEventMonitorManager", "onPrepareComponentStart: " + r100 + ", " + r101);
        if (Intrinsics.areEqual(r101, "applet_widget_timeline_full") == false) goto L6;
        r(new x0(r100, r102));
        return;
    L6:
        if (Intrinsics.areEqual(r101, "applet_page_timeline_full") == false) goto L10;
        r(new b(r100, r102));
        return;
    }

    public static void j(final String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "traceId");
        Intrinsics.checkNotNullParameter(r101, "eventType");
        final long r102 = System.currentTimeMillis();
        com.bytedance.ai.utils.g.f37637a.d("AppletEventMonitorManager", "onRenderTemplateEnd: " + r100 + ", " + r101);
        if (Intrinsics.areEqual(r101, "applet_widget_timeline_full") == false) goto L6;
        r(new n(r100, r102));
        return;
    L6:
        if (Intrinsics.areEqual(r101, "applet_page_timeline_full") == false) goto L10;
        r(new o(r100, r102));
        return;
    }

    public static void m(final String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "traceId");
        Intrinsics.checkNotNullParameter(r101, "eventType");
        final long r102 = System.currentTimeMillis();
        com.bytedance.ai.utils.g.f37637a.d("AppletEventMonitorManager", "onRunAppletRuntimeStart: " + r100 + ", " + r101);
        if (Intrinsics.areEqual(r101, "applet_widget_timeline_full") == false) goto L6;
        r(new k(r100, r102));
        return;
    L6:
        if (Intrinsics.areEqual(r101, "applet_page_timeline_full") == false) goto L10;
        r(new m(r100, r102));
        return;
    }

    public static void o(final String r100, final String r101) {
        Intrinsics.checkNotNullParameter(r100, "traceId");
        Intrinsics.checkNotNullParameter(r101, "eventType");
        com.bytedance.ai.utils.g.f37637a.d("AppletEventMonitorManager", "removeEvent: " + r100 + ", " + r101);
        r(new t0(r101, r100));
    }

    public static String a(String r100, String r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "prefix");
        Intrinsics.checkNotNullParameter(r101, IFlowAppIntentIDL.PARAM_APPLET_ID);
        Intrinsics.checkNotNullParameter(r102, "pageId");
        return r100 + '_' + r101 + '_' + r102 + '_' + UUID.randomUUID();
    }

    public static void k(final String r100, String r101, final Map r102) {
        Intrinsics.checkNotNullParameter(r100, "traceId");
        Intrinsics.checkNotNullParameter(r101, "eventType");
        Intrinsics.checkNotNullParameter(r102, "eventInfo");
        final long r103 = System.currentTimeMillis();
        com.bytedance.ai.utils.g.f37637a.d("AppletEventMonitorManager", "onRenderTemplateStart: " + r100 + ", " + r101);
        if (Intrinsics.areEqual(r101, "applet_widget_timeline_full") == false) goto L6;
        r(new g0(r100, r103, r102));
        return;
    L6:
        if (Intrinsics.areEqual(r101, "applet_page_timeline_full") == false) goto L10;
        r(new i0(r100, r103, r102));
        return;
    }

    public static void l(final String r100, String r101, final Map r102) {
        Intrinsics.checkNotNullParameter(r100, "traceId");
        Intrinsics.checkNotNullParameter(r101, "eventType");
        Intrinsics.checkNotNullParameter(r102, "eventInfo");
        final long r103 = System.currentTimeMillis();
        com.bytedance.ai.utils.g.f37637a.d("AppletEventMonitorManager", "onRunAppletRuntimeEnd: " + r100 + ", " + r101);
        if (Intrinsics.areEqual(r101, "applet_widget_timeline_full") == false) goto L6;
        r(new e(r100, r103, r102));
        return;
    L6:
        if (Intrinsics.areEqual(r101, "applet_page_timeline_full") == false) goto L10;
        r(new f(r100, r103, r102));
        return;
    }

    public static void n(final String r100, final Map r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "traceId");
        Intrinsics.checkNotNullParameter(r102, "eventType");
        if (Intrinsics.areEqual(r102, "applet_widget_timeline_full") == false) goto L6;
        r(new c(r100, r101));
        return;
    L6:
        if (Intrinsics.areEqual(r102, "applet_page_timeline_full") == false) goto L10;
        r(new d(r100, r101));
        return;
    }

    public static void p(final String r100, final String r101, final boolean r102) {
        Intrinsics.checkNotNullParameter(r100, "traceId");
        Intrinsics.checkNotNullParameter(r101, "eventType");
        r(new p(r102, r101, r100));
    }

    public static void b(final String r100, final String r101, final int r102, String r103) {
        Intrinsics.checkNotNullParameter(r100, "traceId");
        Intrinsics.checkNotNullParameter(r101, "errorMessage");
        Intrinsics.checkNotNullParameter(r103, "eventType");
        com.bytedance.ai.utils.g.f37637a.d("AppletEventMonitorManager", "onError: " + r100 + ", " + r101 + ", " + r102 + ", " + r103);
        if (Intrinsics.areEqual(r103, "applet_widget_timeline_full") == false) goto L6;
        r(new h0(r100, r101, r102));
        return;
    L6:
        if (Intrinsics.areEqual(r103, "applet_page_timeline_full") == false) goto L10;
        r(new s0(r100, r101, r102));
        return;
    }

    public static /* synthetic */ void e(String r100, String r101, String r102, String r103) {
        d(r100, r101, r102, r103, null, "webview");
    }

    public static void d(final String r110, final String r111, final String r112, final String r113, final String r114, final String r115) {
        Intrinsics.checkNotNullParameter(r110, "traceId");
        Intrinsics.checkNotNullParameter(r111, "pageId");
        Intrinsics.checkNotNullParameter(r112, "pageType");
        Intrinsics.checkNotNullParameter(r113, "from");
        Intrinsics.checkNotNullParameter(r115, "renderType");
        final long r100 = System.currentTimeMillis();
        r(new u(r110, r111, r112, r113, r100, r114, r115));
    }
}
