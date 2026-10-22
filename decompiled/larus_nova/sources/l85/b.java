package l85;

import androidx.fragment.app.FragmentActivity;
import com.bytedance.ee.bear.browser.plugin.t;
import com.bytedance.ee.bear.document.DocumentPluginHost;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
public final class b implements d {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ int f508043c = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final d f508044a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f508045b;

    public static final class a {
    }

    static {
    }

    public b(d r100) {
        this.f508044a = r100;
    }

    @Override // l85.d
    public final void a(DocumentPluginHost r100, t r101) {
        tt5.a.b("DriveRenderPlatformInitializer", "Initializer(" + hashCode() + ") onAttachToUIContainer");
        this.f508044a.a(r100, r101);
    }

    @Override // l85.d
    public final void b(FragmentActivity r100, pxb.a r101) {
        Intrinsics.checkNotNullParameter(r100, "activity");
        Intrinsics.checkNotNullParameter(r101, "webView");
        tt5.a.b("DriveRenderPlatformInitializer", "Initializer(" + hashCode() + ") registerNativeRender WebView:" + r101.hashCode());
        this.f508044a.b(r100, r101);
    }

    @Override // l85.d
    public final void c(DocumentPluginHost r100, t r101) {
        tt5.a.b("DriveRenderPlatformInitializer", "Initializer(" + hashCode() + ") onAttachToUIContainer");
        this.f508044a.c(r100, r101);
    }

    @Override // l85.d
    public final void d(FragmentActivity r100, pxb.a r101) {
        Intrinsics.checkNotNullParameter(r100, "activity");
        Intrinsics.checkNotNullParameter(r101, "webView");
        tt5.a.b("DriveRenderPlatformInitializer", "Initializer(" + hashCode() + ") unRegisterNativeRender WebView:" + r101.hashCode());
        this.f508044a.d(r100, r101);
    }
}
