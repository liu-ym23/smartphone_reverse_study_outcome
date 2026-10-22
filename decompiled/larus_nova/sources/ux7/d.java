package ux7;

import android.content.Context;
import com.bytedance.ies.xbridge.XBridgeMethod;
import com.bytedance.ies.xbridge.XReadableMap;
import com.bytedance.ies.xbridge.utils.j;
import com.bytedance.sdk.xbridge.cn.PlatformType;
import com.bytedance.sdk.xbridge.cn.registry.core.IBDXBridgeContext;
import com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod;
import com.ivy.ivykit.api.bridge.core.IvyBridgeMethod;
import com.ivy.ivykit.api.bridge.core.model.IvyBridgePlatformType;
import com.ivy.ivykit.plugin.impl.web.PluginWebView;
import h16.e;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes23.dex */
public class d implements IDLXBridgeMethod {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final IvyBridgeMethod f552016a;

    public static final class a {
    }

    public static final class b implements XBridgeMethod.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ PluginWebView f552017a;

        public b(PluginWebView r100) {
            this.f552017a = r100;
        }

        @Override // com.bytedance.ies.xbridge.XBridgeMethod.b
        public final void sendJsEvent(String r100, XReadableMap r101) {
            Intrinsics.checkNotNullParameter(r100, "eventName");
            PluginWebView r102 = this.f552017a;
            if (r101 == null) goto L5;
            JSONObject r103 = j.d(r101);
        L6:
            r102.h(r100, r103);
            return;
        L5:
            r103 = new JSONObject();
            goto L6
        }
    }

    public static final class c implements p56.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ e f552018a;

        @Override // p56.b
        public final String provideContainerID() {
            return this.f552018a.getSessionId();
        }

        public c(e r100) {
            this.f552018a = r100;
        }
    }

    /* JADX INFO: renamed from: ux7.d$d, reason: collision with other inner class name */
    public static final class C7943d implements IvyBridgeMethod.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ IDLXBridgeMethod.a f552019a;

        public C7943d(IDLXBridgeMethod.a r100) {
            this.f552019a = r100;
        }

        @Override // com.ivy.ivykit.api.bridge.core.IvyBridgeMethod.a
        public final void invoke(Map<String, Object> r100) {
            Intrinsics.checkNotNullParameter(r100, "data");
            this.f552019a.invoke(r100);
        }
    }

    static {
    }

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod
    public final boolean canRunInBackground() {
        return false;
    }

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod
    public final IDLXBridgeMethod.Access getAccess() {
        IvyBridgeMethod.Access r100 = this.f552016a.getAccess();
        Intrinsics.checkNotNullParameter(r100, "privilege");
        int r101 = ux7.c.f552015a[r100.ordinal()];
        if (r101 != 1) goto L5;
        IDLXBridgeMethod.Access r102 = IDLXBridgeMethod.Access.PUBLIC;
    L15:
        if (r102 == null) goto L17;
        return r102;
    L17:
        return IDLXBridgeMethod.Access.PRIVATE;
    L5:
        if (r101 != 2) goto L7;
        r102 = IDLXBridgeMethod.Access.PRIVATE;
        goto L15
    L7:
        if (r101 != 3) goto L9;
        r102 = IDLXBridgeMethod.Access.PROTECT;
        goto L15
    L9:
        if (r101 == 4) goto L11;
        r102 = null;
        goto L15
    L11:
        r102 = IDLXBridgeMethod.Access.SECURE;
        goto L15
    }

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod
    public final String getName() {
        return this.f552016a.getName();
    }

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod
    public final IDLXBridgeMethod.Compatibility getCompatibility() {
        return IDLXBridgeMethod.Compatibility.Compatible;
    }

    public d(IvyBridgeMethod r100) {
        Intrinsics.checkNotNullParameter(r100, com.alipay.sdk.m.p.e.f25671s);
        this.f552016a = r100;
    }

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod
    public final void realHandle(IBDXBridgeContext r100, Map<String, ? extends Object> r110, IDLXBridgeMethod.a r111) {
        Intrinsics.checkNotNullParameter(r100, "bridgeContext");
        Intrinsics.checkNotNullParameter(r110, "params");
        Intrinsics.checkNotNullParameter(r111, "callback");
        nx7.b r101 = nx7.a.f521062a;
        if (r101 == null) goto L5;
        JSONObject r102 = new JSONObject();
        r102.put("method_name", getName());
        r102.put("isOversea", false);
        r102.put("platform", r100.getPlatformType().name());
        Unit r103 = Unit.INSTANCE;
        r101.reportEvent("ivy_method_called", r102);
    L5:
        IvyBridgeMethod r104 = this.f552016a;
        ex7.d r105 = new ex7.d();
        Context r106 = vx7.a.getContext(r100);
        if (r106 == null) goto L8;
        Intrinsics.checkNotNullParameter(Context.class, "clazz");
        r105.b(Context.class, new ex7.e(r106));
    L8:
        PluginWebView r107 = (PluginWebView) vx7.a.a(r100, PluginWebView.class);
        if (r107 == null) goto L11;
        b r108 = new b(r107);
        Intrinsics.checkNotNullParameter(XBridgeMethod.b.class, "clazz");
        r105.b(XBridgeMethod.b.class, new ex7.e(r108));
    L11:
        e r109 = (e) vx7.a.a(r100, e.class);
        if (r109 == null) goto L14;
        c r112 = new c(r109);
        Intrinsics.checkNotNullParameter(p56.b.class, "clazz");
        r105.b(p56.b.class, new ex7.c(r112));
        Intrinsics.checkNotNullParameter(e.class, "clazz");
        r105.b(e.class, new ex7.c(r109));
    L14:
        r104.b(r105);
        C7943d r113 = new C7943d(r111);     // Catch: Throwable -> L24
        IvyBridgeMethod r114 = this.f552016a;     // Catch: Throwable -> L24
        dx7.b r115 = new dx7.b(ne7.a.c(r110));     // Catch: Throwable -> L24
        Intrinsics.checkNotNullParameter(r100, "bridgeContext");     // Catch: Throwable -> L24
        if (r100.getPlatformType() != PlatformType.LYNX) goto L19;
        IvyBridgePlatformType r116 = IvyBridgePlatformType.LYNX;     // Catch: Throwable -> L24
    L22:
        r114.a(r115, r113, r116);     // Catch: Throwable -> L24
        return;
    L19:
        if (r100.getPlatformType() != PlatformType.WEB) goto L21;
        r116 = IvyBridgePlatformType.WEB;     // Catch: Throwable -> L24
        goto L22
    L21:
        r116 = IvyBridgePlatformType.ALL;     // Catch: Throwable -> L24
    }
}
