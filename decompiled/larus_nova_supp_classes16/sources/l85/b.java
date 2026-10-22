package l85;

import androidx.fragment.app.FragmentActivity;
import com.bytedance.ee.bear.browser.plugin.t;
import com.bytedance.ee.bear.document.DocumentPluginHost;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class b implements d {
    public static final /* synthetic */ int c = 0;
    public final d a;
    public boolean b;

    public static final class a {
    }

    static {
    }

    public b(d r1) {
        this.a = r1;
    }

    @Override // l85.d
    public final void a(DocumentPluginHost r3, t r4) {
        tt5.a.b("DriveRenderPlatformInitializer", "Initializer(" + hashCode() + ") onAttachToUIContainer");
        this.a.a(r3, r4);
    }

    @Override // l85.d
    public final void b(FragmentActivity r3, pxb.a r4) {
        Intrinsics.checkNotNullParameter(r3, "activity");
        Intrinsics.checkNotNullParameter(r4, "webView");
        tt5.a.b("DriveRenderPlatformInitializer", "Initializer(" + hashCode() + ") registerNativeRender WebView:" + r4.hashCode());
        this.a.b(r3, r4);
    }

    @Override // l85.d
    public final void c(DocumentPluginHost r3, t r4) {
        tt5.a.b("DriveRenderPlatformInitializer", "Initializer(" + hashCode() + ") onAttachToUIContainer");
        this.a.c(r3, r4);
    }

    @Override // l85.d
    public final void d(FragmentActivity r3, pxb.a r4) {
        Intrinsics.checkNotNullParameter(r3, "activity");
        Intrinsics.checkNotNullParameter(r4, "webView");
        tt5.a.b("DriveRenderPlatformInitializer", "Initializer(" + hashCode() + ") unRegisterNativeRender WebView:" + r4.hashCode());
        this.a.d(r3, r4);
    }
}
