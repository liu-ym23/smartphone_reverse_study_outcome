package rs5;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.ee.lark.nativecomponent.core.debug.BridgeDebug;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import js5.g;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public final class d implements ts5.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final HashMap<String, ks5.a> f539112a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final BridgeDebug f539113b;

    public static final class a {
    }

    static {
    }

    @Override // ts5.d
    public final void w() {
    }

    @Override // ts5.d
    public final List<ks5.a> k() {
        return new ArrayList(this.f539112a.values());
    }

    public d() {
        this.f539112a = new HashMap();
        this.f539113b = new BridgeDebug();
    }

    @Override // ts5.d
    public final BridgeDebug o() {
        return this.f539113b;
    }

    @Override // ts5.d
    public final ks5.a getComponent(String r100) {
        Intrinsics.checkNotNullParameter(r100, "componentId");
        return this.f539112a.get(r100);
    }

    @Override // ts5.d
    public final void i(ks5.a r100) {
        Intrinsics.checkNotNullParameter(r100, "nativeComponentContext");
        rxb.c r101 = r100.getLogger();
        String r102 = r100.getViewId();
        r101.b("NativeComponentManager", r102, "add INativeComponentContext");
        if (this.f539112a.containsKey(r102) == false) goto L5;
        r101.a("NativeComponentManager", r102, "viewId already added");
    L6:
        u(r100.getWebView(), r100.getViewId(), r100.getContainer());
        return;
    L5:
        this.f539112a.put(r102, r100);
        goto L6
    }

    public static void B(pxb.a r100, String r101) {
        txb.a r102 = ms5.a.a(r100);
        if (r102 == null) goto L19;
        Intrinsics.checkNotNullParameter(r102, "<this>");
        rxb.c r103 = r102.getLogger();
        if (r103 == null) goto L21;
        r103.b("NativeComponentManager", r101, "unRegisterPlatformView");
        if (TextUtils.isEmpty(r101) == false) goto L11;
        r103.a("NativeComponentManager", r101, "unRegisterPlatformView err, viewId is empty");
        return;
    L11:
        Intrinsics.checkNotNullParameter(r100, "<this>");
        txb.b r104 = r100.getServiceManager();
        if (r104 == null) goto L14;
        txb.a r105 = (txb.a) r104.getService(txb.a.class);
    L15:
        if (r105 == null) goto L17;
        r105.h(r101);
        return;
    L17:
        r103.a("NativeComponentManager", r101, "unRegisterPlatformView err, renderInWebViewService is null");
        return;
    L14:
        r105 = null;
        goto L15
    L21:
        return;
    }

    @Override // ts5.d
    public final void m(pxb.a r100, ks5.a r101) {
        Intrinsics.checkNotNullParameter(r100, "webView");
        Intrinsics.checkNotNullParameter(r101, "nativeComponentContext");
        txb.a r102 = ms5.a.a(r100);
        if (r102 == null) goto L14;
        Intrinsics.checkNotNullParameter(r102, "<this>");
        rxb.c r103 = r102.getLogger();
        if (r103 == null) goto L16;
        Map<String, g> r104 = r101.a();
        if (r104 != null) goto L10;
        return;
    L10:
        r103.b("NativeComponentManager", r101.getViewId(), "removeSubComponent");
        Iterator<Map.Entry<String, g>> r105 = r104.entrySet().iterator();
    L12:
        if (r105.hasNext() == false) goto L17;
        String r106 = r105.next().getKey();
        this.f539112a.remove(r106);
        B(r100, r106);
        goto L12
    L17:
        return;
    L16:
        return;
    }

    @Override // ts5.d
    public final void q(Context r100, ks5.a r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "nativeComponentContext");
        rxb.c r102 = r101.getLogger();
        Map<String, g> r103 = r101.a();
        if (r103 == null) goto L12;
        Iterator<Map.Entry<String, g>> r104 = r103.entrySet().iterator();
    L6:
        if (r104.hasNext() == false) goto L16;
        String r105 = r104.next().getKey();
        if (this.f539112a.containsKey(r105) == false) goto L10;
        r102.a("NativeComponentManager", r105, "viewId already added");
    L11:
        qs5.b r106 = new qs5.b(r100, r102, r105, this);
        u(r101.getWebView(), r105, r106);
        goto L6
    L10:
        this.f539112a.put(r105, r101);
        goto L11
    L16:
        return;
    }

    @Override // ts5.d
    public final void y(pxb.a r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "webView");
        Intrinsics.checkNotNullParameter(r101, "viewId");
        txb.a r102 = ms5.a.a(r100);
        if (r102 == null) goto L13;
        Intrinsics.checkNotNullParameter(r102, "<this>");
        rxb.c r103 = r102.getLogger();
        if (r103 == null) goto L14;
        r103.b("NativeComponentManager", r101, "remove INativeComponentContext");
        ks5.a r104 = this.f539112a.get(r101);
        if (r104 != null) goto L11;
        r103.a("NativeComponentManager", r101, "remove INativeComponentContext, but could not find view.");
        return;
    L11:
        this.f539112a.remove(r101);
        B(r104.getWebView(), r101);
        return;
    L14:
        return;
    }

    @Override // ts5.d
    public final void u(pxb.a r100, String r101, qs5.c r102) {
        Intrinsics.checkNotNullParameter(r100, "webView");
        Intrinsics.checkNotNullParameter(r101, "viewId");
        txb.a r103 = ms5.a.a(r100);
        if (r103 == null) goto L23;
        Intrinsics.checkNotNullParameter(r103, "<this>");
        rxb.c r104 = r103.getLogger();
        if (r104 == null) goto L24;
        r104.b("NativeComponentManager", r101, "registerPlatformView");
        if (r102 != null) goto L10;
    L20:
        r104.a("NativeComponentManager", r101, "registerPlatformView err, view or viewId is null");
        return;
    L10:
        if (TextUtils.isEmpty(r101) == true) goto L20;
        ns5.a r105 = new ns5.a(r101, r102);
        Intrinsics.checkNotNullParameter(r100, "<this>");
        txb.b r106 = r100.getServiceManager();
        if (r106 == null) goto L15;
        txb.a r107 = (txb.a) r106.getService(txb.a.class);
    L16:
        if (r107 == null) goto L18;
        r107.j(r105);
        return;
    L18:
        r104.a("NativeComponentManager", r101, "registerPlatformView err, renderInWebViewService is null");
        return;
    L15:
        r107 = null;
        goto L16
    L24:
        return;
    }
}
