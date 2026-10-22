package o45;

import android.view.View;
import android.webkit.WebView;
import com.bytedance.ee.bear.document.webservice.SameRenderMode;
import com.bytedance.ee.bear.domain.BearUrl;
import com.ss.android.lark.chameleon.AbsChameleonService;
import com.ss.android.lark.component.appcontext.LarkAppContext;
import com.ss.android.lark.officewebview.base.OfficeWebView;
import com.ss.android.lark.officewebview.webview_api.adapter.OfficeWebViewAdapter;
import com.ss.android.lark.officewebview.webview_api.adapter.d;
import com.ss.android.lark.officewebview.webview_api.platform.PlatformPluginVersion;
import com.ss.android.lark.utils.LarkContext;
import com.ttnet.org.chromium.base.BaseSwitches;
import java.util.ArrayList;
import java.util.Map;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import vv4.k;

/* JADX INFO: loaded from: classes16.dex */
public final class a extends AbsChameleonService {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public BearUrl f521964a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public OfficeWebViewAdapter f521965b;

    /* JADX INFO: renamed from: o45.a$a, reason: collision with other inner class name */
    public static final class C7011a {
    }

    public /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f521966a = null;

        static {
            int[] r100 = new int[SameRenderMode.values().length];
            r100[SameRenderMode.EMBED.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L11:
            r100[SameRenderMode.SANDWICH.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L15:
            r100[SameRenderMode.DISABLED.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L6:
            f521966a = r100;
        }
    }

    public static final class c implements View.OnAttachStateChangeListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ k f521967a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ a f521968b;

        @Override // android.view.View.OnAttachStateChangeListener
        public final void onViewAttachedToWindow(View r100) {
            Intrinsics.checkNotNullParameter(r100, BaseSwitches.V);
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public final void onViewDetachedFromWindow(View r100) {
            Intrinsics.checkNotNullParameter(r100, BaseSwitches.V);
            tt5.a.h("WebViewExtendWebService", "onViewDetachedFromWindow()... mWebViewId=" + this.f521967a.getWebViewId());
            this.f521968b.f521964a = null;
        }

        public c(k r100, a r101) {
            this.f521967a = r100;
            this.f521968b = r101;
        }
    }

    static {
    }

    public a() {
    }

    @Override // com.ss.android.lark.chameleon.AbsChameleonService, vv4.a
    public final void onAttachToWeb(k r100) {
        Intrinsics.checkNotNullParameter(r100, "web");
        super.onAttachToWeb(r100);
        LarkAppContext.Companion.getClass();
        if (LarkAppContext.access$getInstance$cp().buildConfig().isOfficeSDK() == true) goto L39;
        WebView r101 = r100.getWebView();
        txb.a r102 = null;
        if ((r101 instanceof OfficeWebView) == false) goto L8;
        OfficeWebView r103 = (OfficeWebView) r101;
    L9:
        if (r103 == null) goto L39;
        OfficeWebViewAdapter r104 = d.a(r103);
        Intrinsics.checkNotNullParameter("debug_config", "name");
        com.ss.android.lark.storage.kv.repo.a r105 = ay4.b.b("debug_config", true, ay4.b.a("debug_config"));
        Intrinsics.checkNotNullParameter(r105, "repo");
        new ArrayList();
        Intrinsics.checkNotNullParameter("drive_same_render_emed_on", "key");
        boolean r106 = r105.getBoolean("drive_same_render_emed_on", true);
        boolean r107 = com.bytedance.ee.bear.appsetting.c.a.f206237a.f("spacekit.mobile.drive.embed_enable");
        txb.b r108 = r104.getServiceManager();
        if (r108 == null) goto L13;
        r102 = (txb.a) r108.getService(txb.a.class);
    L13:
        if (r102 == null) goto L17;
        Map<PlatformPluginVersion, Boolean> r109 = r102.x();
        if (r109 == null) goto L17;
        boolean r110 = Intrinsics.areEqual(r109.get(PlatformPluginVersion.EMBED), Boolean.TRUE);
    L18:
        boolean r111 = ku5.c.k(LarkContext.getApplication());
        if (r106 == true) goto L21;
        SameRenderMode r112 = SameRenderMode.DISABLED;
    L27:
        int r113 = b.f521966a[r112.ordinal()];
        if (r113 != 1) goto L30;
        int r114 = is5.a.f495618a;
        is5.a.b(new is5.a.C6355a(r104.f437564a.getContext(), r104, new o45.b()));
        this.f521965b = r104;
    L38:
        tt5.a.h("WebViewExtendWebService", "initSameRender mode=" + r112 + ", mWebViewId=" + r100.getWebViewId());
        goto L39
    L30:
        if (r113 != 2) goto L32;
        tr5.b.a.f547309a.getClass();
        tr5.b.b(r104);
        goto L38
    L32:
        if (r113 == 3) goto L38;
        throw new NoWhenBranchMatchedException();
    L21:
        if (r107 == false) goto L24;
        if (r110 == false) goto L24;
        r112 = SameRenderMode.EMBED;
    L24:
        if (r111 == false) goto L26;
        r112 = SameRenderMode.DISABLED;
        goto L27
    L26:
        r112 = SameRenderMode.SANDWICH;
    L17:
        r110 = false;
        goto L18
    L8:
        r103 = null;
    L39:
        r100.getWebView().addOnAttachStateChangeListener(new c(r100, this));
    }

    @Override // com.ss.android.lark.chameleon.AbsChameleonService, vv4.a, vv4.m
    public final void onDetachFromWeb(k r100) {
        OfficeWebViewAdapter r101 = this.f521965b;
        if (r101 == null) goto L5;
        is5.a.a(r101);
    L5:
        this.f521965b = null;
        super.onDetachFromWeb(r100);
    }
}
