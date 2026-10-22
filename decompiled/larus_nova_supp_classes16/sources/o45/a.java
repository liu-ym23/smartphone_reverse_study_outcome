package o45;

import android.view.View;
import com.bytedance.ee.bear.document.webservice.SameRenderMode;
import com.bytedance.ee.bear.domain.BearUrl;
import com.ss.android.lark.chameleon.AbsChameleonService;
import com.ss.android.lark.component.appcontext.LarkAppContext;
import com.ss.android.lark.officewebview.base.OfficeWebView;
import com.ss.android.lark.officewebview.webview_api.adapter.OfficeWebViewAdapter;
import com.ss.android.lark.officewebview.webview_api.adapter.d;
import com.ss.android.lark.officewebview.webview_api.platform.PlatformPluginVersion;
import com.ss.android.lark.utils.LarkContext;
import java.util.ArrayList;
import java.util.Map;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import vv4.k;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class a extends AbsChameleonService {
    public BearUrl a;
    public OfficeWebViewAdapter b;

    /* JADX INFO: renamed from: o45.a$a, reason: collision with other inner class name */
    public static final class C0266a {
    }

    public /* synthetic */ class b {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[SameRenderMode.values().length];
            r0[SameRenderMode.EMBED.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L11:
            r0[SameRenderMode.SANDWICH.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L15:
            r0[SameRenderMode.DISABLED.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L6:
            a = r0;
        }
    }

    public static final class c implements View.OnAttachStateChangeListener {
        public final /* synthetic */ k a;
        public final /* synthetic */ a b;

        @Override // android.view.View.OnAttachStateChangeListener
        public final void onViewAttachedToWindow(View r2) {
            Intrinsics.checkNotNullParameter(r2, "v");
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public final void onViewDetachedFromWindow(View r2) {
            Intrinsics.checkNotNullParameter(r2, "v");
            tt5.a.h("WebViewExtendWebService", "onViewDetachedFromWindow()... mWebViewId=" + this.a.getWebViewId());
            this.b.a = null;
        }

        public c(k r1, a r2) {
            this.a = r1;
            this.b = r2;
        }
    }

    static {
    }

    public a() {
    }

    public final void onAttachToWeb(k r7) {
        Intrinsics.checkNotNullParameter(r7, "web");
        super.onAttachToWeb(r7);
        LarkAppContext.Companion.getClass();
        if (LarkAppContext.access$getInstance$cp().buildConfig().isOfficeSDK() == true) goto L39;
        OfficeWebView r0 = r7.getWebView();
        txb.a r2 = null;
        if ((r0 instanceof OfficeWebView) == false) goto L8;
        OfficeWebView r1 = r0;
    L9:
        if (r1 == null) goto L39;
        OfficeWebViewAdapter r3 = d.a(r1);
        Intrinsics.checkNotNullParameter("debug_config", "name");
        com.ss.android.lark.storage.kv.repo.a r4 = ay4.b.b("debug_config", true, ay4.b.a("debug_config"));
        Intrinsics.checkNotNullParameter(r4, "repo");
        new ArrayList();
        Intrinsics.checkNotNullParameter("drive_same_render_emed_on", "key");
        boolean r5 = r4.getBoolean("drive_same_render_emed_on", true);
        boolean r6 = com.bytedance.ee.bear.appsetting.c.a.a.f("spacekit.mobile.drive.embed_enable");
        txb.b r8 = r3.getServiceManager();
        if (r8 == null) goto L13;
        r2 = (txb.a) r8.getService(txb.a.class);
    L13:
        if (r2 == null) goto L17;
        Map r9 = r2.x();
        if (r9 == null) goto L17;
        boolean r10 = Intrinsics.areEqual(r9.get(PlatformPluginVersion.EMBED), Boolean.TRUE);
    L18:
        boolean r11 = ku5.c.k(LarkContext.getApplication());
        if (r5 == true) goto L21;
        SameRenderMode r12 = SameRenderMode.DISABLED;
    L27:
        int r13 = b.a[r12.ordinal()];
        if (r13 != 1) goto L30;
        int r14 = is5.a.a;
        is5.a.b(new is5.a.a(r3.a.getContext(), r3, new o45.b()));
        this.b = r3;
    L38:
        tt5.a.h("WebViewExtendWebService", "initSameRender mode=" + r12 + ", mWebViewId=" + r7.getWebViewId());
        goto L39
    L30:
        if (r13 != 2) goto L32;
        tr5.b.a.a.getClass();
        tr5.b.b(r3);
        goto L38
    L32:
        if (r13 == 3) goto L38;
        throw new NoWhenBranchMatchedException();
    L21:
        if (r6 == false) goto L24;
        if (r10 == false) goto L24;
        r12 = SameRenderMode.EMBED;
    L24:
        if (r11 == false) goto L26;
        r12 = SameRenderMode.DISABLED;
        goto L27
    L26:
        r12 = SameRenderMode.SANDWICH;
    L17:
        r10 = false;
        goto L18
    L8:
        r1 = null;
    L39:
        r7.getWebView().addOnAttachStateChangeListener(new c(r7, this));
    }

    public final void onDetachFromWeb(k r2) {
        OfficeWebViewAdapter r0 = this.b;
        if (r0 == null) goto L5;
        is5.a.a(r0);
    L5:
        this.b = null;
        super.onDetachFromWeb(r2);
    }
}
