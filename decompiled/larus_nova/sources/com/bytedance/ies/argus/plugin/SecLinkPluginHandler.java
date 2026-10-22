package com.bytedance.ies.argus.plugin;

import android.webkit.WebView;
import com.bytedance.ies.argus.api.params.WebLoadPageType;
import com.bytedance.ies.argus.api.params.WebLoadRiskTag;
import com.bytedance.ies.argus.api.params.WebLoadUrlParams;
import com.bytedance.ies.argus.api.params.WebLoadVerifySource;
import com.bytedance.ies.argus.api.params.e0;
import com.bytedance.ies.argus.aspect.eventCenter.i;
import com.bytedance.ies.argus.base.ArgusEnv;
import com.bytedance.ies.argus.bean.ArgusWebLoadVerifyReason;
import com.bytedance.ies.argus.bean.ArgusWebViewAspect;
import com.bytedance.ies.argus.bean.AspectContext;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes19.dex */
public final class SecLinkPluginHandler extends c {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final Lazy<String> f246075f = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Lazy f246076c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f246077d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Integer f246078e;

    public static final class a {
        public static boolean a(String r100) {
            Intrinsics.checkNotNullParameter(r100, "url");
            String r101 = SecLinkPluginHandler.f246075f.getValue();     // Catch: Exception -> L9
            if (r101 == null) goto L14;
            if (StringsKt.startsWith$default(r100, r101, false, 2, null) != true) goto L15;
            return true;
        L15:
            return false;
        L14:
            return false;
        L9:
            e = move-exception;
            int r102 = com.bytedance.ies.argus.base.d.f245942a;
            com.bytedance.ies.argus.base.d.b("SecLinkPlugin", "get seclink host error: " + e, null, 12);
            return false;
        }
    }

    static {
        f246075f = LazyKt.lazy(SecLinkPluginHandler$Companion$secLinkHost$2.INSTANCE);
    }

    public final f a() {
        return (f) this.f246076c.getValue();
    }

    public SecLinkPluginHandler(SecurePluginType r100, final String r101) {
        Intrinsics.checkNotNullParameter(r100, "type");
        super(r100);
        this.f246076c = LazyKt.lazy(new SecLinkPluginHandler$config$2(r101));
        this.f246077d = a().b();
        this.f246078e = a().a();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final String b(boolean r110, final String r210, i r211, AspectContext<WebLoadUrlParams, e0>.a r212) {
        Intrinsics.checkNotNullParameter(r210, "checkScene");
        Intrinsics.checkNotNullParameter(r211, "viewContext");
        Intrinsics.checkNotNullParameter(r212, "calculateContext");
        WebLoadUrlParams r111 = (WebLoadUrlParams) r212.f246005d.f245987b;
        Pair<? extends dr7.c, String> r100 = r211.f245879q;
        if (r100 != null) goto L5;
    L6:
        WebView r101 = r211.h();
        if (r101 == null) goto L9;
        r211.f245879q = new Pair(cr7.a.a(r101, r210), r210);
    L9:
        com.bytedance.ies.argus.bean.i<REWRITE_PAYLOAD> r112 = r212.f246003b;
        final String r113 = r111.a();
        final Ref.ObjectRef r114 = new Ref.ObjectRef();
        if (r110 == false) goto L12;
        com.bytedance.ies.argus.bean.i.k(r112, ArgusWebLoadVerifyReason.REWRITE_BY_SEC_LINK, "use sync", new SecLinkPluginHandler$verifyShouldReloadUrl$2(r114, this, r113, r210), 4);
    L44:
        return (String) r114.element;
    L12:
        Lazy<ArgusEnv> r102 = ArgusEnv.f245917d;
        r06.a.C7412a r103 = ArgusEnv.b.a().a();
        if (r103 == null) goto L16;
        String r104 = r103.f535470c;
        if (r104 == null) goto L16;
    L17:
        hr7.c r105 = ir7.c.b(r113, "", r210, 0, MapsKt.mapOf(TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_DID, r104)), true, "argus").get();
        e0 r106 = (e0) r112.b();
        if (r105.f486901g.equals("1") == false) goto L20;
        int r107 = com.bytedance.ies.argus.base.d.f245942a;
        com.bytedance.ies.argus.base.d.c("WebDomMonitorJsbInjectProvider", "url=" + r113 + ", enableWebDomStrategy report");
        r211.f245881s = true;
    L20:
        int r108 = -1;
        if (r105.f486897c == false) goto L24;
    L34:
        boolean r109 = true;
    L36:
        r112.a("seclink_result", MapsKt.mapOf(new Pair[]{TuplesKt.to("checkScene", r210), TuplesKt.to("intercept", Boolean.valueOf(r109)), TuplesKt.to("isNeedShowPage", Boolean.valueOf(r105.f486897c)), TuplesKt.to("level", Integer.valueOf(r105.f486896b)), TuplesKt.to("limitLevel", Integer.valueOf(r108))}));
        if (r109 == false) goto L42;
        com.bytedance.ies.argus.bean.i.k(r112, ArgusWebLoadVerifyReason.REWRITE_BY_SEC_LINK, "use async,needShow=" + r105.f486897c + ",limit=" + r108 + ",server=" + r105.f486896b, new SecLinkPluginHandler$verifyShouldReloadUrl$4(r114, this, r113, r210), 4);
        if (r105.f486896b != 9) goto L41;
        r111.i(WebLoadVerifySource.SecLink, WebLoadRiskTag.ShowRiskBlack, null);
        goto L44
    L41:
        r111.i(WebLoadVerifySource.SecLink, WebLoadRiskTag.ShowRiskGrey, WebLoadPageType.GREY_SEC_LINK);
        goto L44
    L42:
        com.bytedance.ies.argus.bean.i.i(r112, ArgusWebLoadVerifyReason.PASS_BY_SEC_LINK_SERVER, null, 6);
        r111.i(WebLoadVerifySource.SecLink, WebLoadRiskTag.PassPluginVerify, null);
        goto L44
    L24:
        if (r212.f246005d.f245986a != ArgusWebViewAspect.WEB_REDIRECT) goto L30;
        Integer r115 = a().e();
        if (r115 == null) goto L35;
        r108 = r115.intValue();
        if (r105.f486896b > r108) goto L34;
    L35:
        r109 = false;
        goto L36
    L30:
        Integer r116 = a().c();
        if (r116 == null) goto L35;
        r108 = r116.intValue();
        if (r105.f486896b <= r108) goto L35;
    L16:
        r104 = "";
        goto L17
    L5:
        if (Intrinsics.areEqual(r100.getSecond(), r210) == true) goto L9;
        goto L6
    }
}
