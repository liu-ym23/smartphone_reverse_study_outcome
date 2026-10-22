package l85;

import android.webkit.WebView;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.bytedance.ee.bear.browser.WebFragment;
import com.bytedance.ee.bear.browser.plugin.t;
import com.bytedance.ee.bear.document.DocumentPluginHost;
import java.util.ArrayList;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import vv4.k;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class a implements d {
    public final List<js5.d> a;

    /* JADX INFO: renamed from: l85.a$a, reason: collision with other inner class name */
    public static final class C0249a {
    }

    static {
    }

    public a() {
        this.a = new ArrayList();
    }

    @Override // l85.d
    public final void a(DocumentPluginHost r2, t r3) {
        if (r2 == null) goto L13;
        k r4 = r2.getWeb();
        if (r4 == null) goto L14;
        WebView r5 = r4.getWebView();
        if (r5 == null) goto L15;
        WebFragment r6 = r2.c();
        if (r6 == null) goto L10;
        FragmentManager r7 = r6.getChildFragmentManager();
    L11:
        r5.setTag(2131370303, r7);
        return;
    L10:
        r7 = null;
        goto L11
    L15:
        return;
    L14:
        return;
    }

    @Override // l85.d
    public final void b(FragmentActivity r5, pxb.a r6) {
        Intrinsics.checkNotNullParameter(r5, "activity");
        Intrinsics.checkNotNullParameter(r6, "webView");
        List<js5.d> r0 = this.a;
        monitor-enter(r0);
        ArrayList r1 = (ArrayList) this.a;     // Catch: Throwable -> L17
        ArrayList r3 = null;
        if (r1.isEmpty() == true) goto L8;
        r1 = null;
    L8:
        if (r1 == null) goto L10;
        ((ArrayList) this.a).add(new com.bytedance.ee.bear.drive.module.nativepreview.component.embed.c(r5, r6));     // Catch: Throwable -> L17
    L10:
        monitor-exit(r0);
        tt5.a.h("DriveEmbedRenderPlatform", "registerNativeRender, activity: " + r5 + ", webView: " + r6 + ", factoryList: " + this.a);
        ArrayList r7 = (ArrayList) this.a;
        if ((!r7.isEmpty()) == false) goto L14;
        r3 = r7;
    L14:
        if (r3 == null) goto L22;
        is5.a.c(r6, r3);
        return;
    L22:
        return;
    L17:
        th = move-exception;
        throw th;
    }

    @Override // l85.d
    public final void c(DocumentPluginHost r2, t r3) {
        if (r2 == null) goto L9;
        k r4 = r2.getWeb();
        if (r4 == null) goto L10;
        WebView r5 = r4.getWebView();
        if (r5 == null) goto L11;
        r5.setTag(2131370303, null);
        return;
    L11:
        return;
    L10:
        return;
    }

    @Override // l85.d
    public final void d(FragmentActivity r4, pxb.a r5) {
        Intrinsics.checkNotNullParameter(r4, "activity");
        Intrinsics.checkNotNullParameter(r5, "webView");
        tt5.a.h("DriveEmbedRenderPlatform", "unRegisterNativeRender, activity: " + r4 + ", webView: " + r5 + ", factoryList: " + this.a);
        List<js5.d> r6 = this.a;
        monitor-enter(r6);
        int r0 = is5.a.a;     // Catch: Throwable -> L7
        is5.a.d(r5, this.a);     // Catch: Throwable -> L7
        ((ArrayList) this.a).clear();     // Catch: Throwable -> L7
        Unit r7 = Unit.INSTANCE;     // Catch: Throwable -> L7
        monitor-exit(r6);
        return;
    L7:
        th = move-exception;
        throw th;
    }
}
