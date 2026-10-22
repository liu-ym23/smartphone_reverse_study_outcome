package defpackage;

import android.content.Context;
import android.net.Uri;
import android.view.View;
import com.bytedance.android.anniex.ability.service.IAnnieXContextProvider;
import com.bytedance.android.anniex.assemble.a;
import com.bytedance.android.anniex.base.service.AnnieXServiceCenter;
import com.bytedance.android.anniex.lite.utils.AnnieXSettings;
import com.bytedance.android.anniex.web.AnnieXWebKit;
import com.bytedance.android.anniex.web.model.AnnieXWebModel;
import com.bytedance.ies.bullet.core.BulletContext;
import com.bytedance.ies.bullet.deprecate.fake.ContainerBidParam;
import com.bytedance.ies.bullet.kit.web.SSWebView;
import com.bytedance.ies.bullet.kit.web.impl.c;
import com.bytedance.ies.bullet.lynx.impl.DefaultLynxDelegate;
import com.bytedance.ies.bullet.service.base.h;
import com.bytedance.sdk.xbridge.cn.platform.lynx.LynxBDXBridge;
import com.bytedance.sdk.xbridge.cn.platform.web.WebBDXBridge;
import com.lynx.tasm.LynxView;
import kotlin.Lazy;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import m16.b;
import s26.d;

/* JADX INFO: loaded from: classes42.dex */
public final class x0 {
    public x0() {
    }

    public static void c(AnnieXWebModel r100, SSWebView r101, WebBDXBridge r102, b r110, final AnnieXWebKit r111) {
        Intrinsics.checkNotNullParameter(r100, "annieXWebModel");
        Intrinsics.checkNotNullParameter(r101, "view");
        Intrinsics.checkNotNullParameter(r110, "providerFactory");
        Intrinsics.checkNotNullParameter(r111, "annieXWebKit");
        a(r101, r102, r110, r100.f41469d, r100.f41468c, new WebcastContainerInitializer$initializeWithAnnieXWebModelInWeb$1(r111));
    }

    public final void d(BulletContext r100, final LynxView r101, LynxBDXBridge r110, b r111, final DefaultLynxDelegate.d r112) {
        Intrinsics.checkNotNullParameter(r101, "view");
        Intrinsics.checkNotNullParameter(r111, "providerFactory");
        Intrinsics.checkNotNullParameter(r112, "eventHandler");
        b(this, r100, r101, r110, r111, new WebcastContainerInitializer$initializeWithBulletContextInLynx$1(r112, r101));
    }

    public final void e(BulletContext r100, final View r101, WebBDXBridge r110, b r111, final c.d r112) {
        Intrinsics.checkNotNullParameter(r101, "view");
        Intrinsics.checkNotNullParameter(r111, "providerFactory");
        Intrinsics.checkNotNullParameter(r112, "eventHandler");
        b(this, r100, r101, r110, r111, new WebcastContainerInitializer$initializeWithBulletContextInWeb$1(r112, r101));
    }

    public static void a(View r100, Object r101, b r102, String r103, Uri r104, Function2 r105) {
        Intrinsics.checkNotNullParameter(r100, "view");
        Intrinsics.checkNotNullParameter(r102, "providerFactory");
        Intrinsics.checkNotNullParameter(r103, "sessionId");
        Intrinsics.checkNotNullParameter(r104, "uri");
        Intrinsics.checkNotNullParameter(r105, "sendEvent");
        d r106 = d.f540305c;
        k16.b r107 = (k16.b) d.f540305c.d("default_bid", k16.b.class);
        if (r107 != null) goto L5;
    L7:
        boolean r108 = r101 instanceof LynxBDXBridge;
        WebBDXBridge r109 = null;
        if (r108 == false) goto L10;
        LynxBDXBridge r110 = (LynxBDXBridge) r101;
    L11:
        if (r110 == null) goto L15;
        Context r111 = r110.getContext();
        if (r111 == null) goto L15;
    L23:
        w0 r112 = new w0(r111, r100, r104, r105);
        if (r108 == false) goto L26;
        LynxBDXBridge r113 = (LynxBDXBridge) r101;
    L27:
        if (r113 == null) goto L30;
        r113.x(ue7.c.class, r112);
    L30:
        if ((r101 instanceof WebBDXBridge) == false) goto L32;
        r109 = (WebBDXBridge) r101;
    L32:
        if (r109 == null) goto L34;
        r109.x(ue7.c.class, r112);
    L34:
        r102.g(ue7.c.class, r112);
        if (h.F() == false) goto L37;
        r102.d(ContainerBidParam.class, new ContainerBidParam("webcast"));
    L37:
        Lazy r114 = AnnieXSettings.f40951a;
        if (AnnieXSettings.a() == false) goto L40;
        AnnieXServiceCenter.f40313a.getClass();
        IAnnieXContextProvider r115 = (IAnnieXContextProvider) AnnieXServiceCenter.d("webcast", IAnnieXContextProvider.class);
    L43:
        if (r115 == null) goto L46;
        r115.A0();
        r115.m0();
        return;
    L46:
        return;
    L40:
        a r116 = a.f40251a;
        r115 = (IAnnieXContextProvider) a.g("webcast", IAnnieXContextProvider.class);
        if (r115 != null) goto L43;
        r115 = (IAnnieXContextProvider) d.f540305c.d("webcast", IAnnieXContextProvider.class);
        goto L43
    L26:
        r113 = null;
    L15:
        if ((r101 instanceof WebBDXBridge) == false) goto L17;
        WebBDXBridge r117 = (WebBDXBridge) r101;
    L18:
        if (r117 == null) goto L20;
        r111 = r117.getContext();
    L21:
        if (r111 != null) goto L23;
        r111 = r100.getContext();
        goto L23
    L20:
        r111 = null;
        goto L21
    L17:
        r117 = null;
        goto L18
    L10:
        r110 = null;
        goto L11
    L5:
        if ((r107 instanceof k16.a) == false) goto L7;
        k16.a r118 = (k16.a) r107;
        Intrinsics.checkNotNullParameter(r102, "providerFactory");
        goto L7
    }

    public static void b(x0 r100, BulletContext r101, View r102, Object r110, b r111, Function2 r112) {
        if (r101 == null) goto L4;
        String r103 = r101.getSessionId();
    L5:
        if (r103 != null) goto L7;
        r103 = "";
    L7:
        String r104 = r103;
        if (r101 == null) goto L13;
        t36.d r105 = r101.f246437e;
        if (r105 == null) goto L13;
        Uri r106 = r105.getOriginUrl();
        if (r106 == null) goto L13;
    L14:
        r100.getClass();
        a(r102, r110, r111, r104, r106, r112);
        return;
    L13:
        r106 = Uri.EMPTY;
        goto L14
    L4:
        r103 = null;
        goto L5
    }
}
