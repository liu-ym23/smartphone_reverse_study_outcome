package kp2;

import android.view.View;
import com.bytedance.android.live.browser.d0;
import com.bytedance.android.livesdkapi.service.IExternalLiveLynxCallback;
import com.lynx.tasm.LynxView;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public final class b extends d0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final IExternalLiveLynxCallback f505493a;

    @Override // com.bytedance.android.live.browser.d0
    public final void a() {
        IExternalLiveLynxCallback r100 = this.f505493a;
        if (r100 == null) goto L6;
        r100.onFallback();
        return;
    }

    public b(IExternalLiveLynxCallback r100) {
        this.f505493a = r100;
    }

    @Override // com.bytedance.android.live.browser.d0
    public final void b(LynxView r100) {
        Intrinsics.checkNotNullParameter(r100, "lynxView");
        IExternalLiveLynxCallback r101 = this.f505493a;
        if (r101 == null) goto L6;
        r101.onFirstScreen(r100);
        return;
    }

    @Override // com.bytedance.android.live.browser.d0
    public final void d(View r100) {
        Intrinsics.checkNotNullParameter(r100, "lynxView");
        IExternalLiveLynxCallback r101 = this.f505493a;
        if (r101 == null) goto L6;
        r101.onLoadSuccess(r100);
        return;
    }

    @Override // com.bytedance.android.live.browser.d0
    public final void g(View r100) {
        Intrinsics.checkNotNullParameter(r100, "lynxView");
        IExternalLiveLynxCallback r101 = this.f505493a;
        if (r101 == null) goto L6;
        r101.onRuntimeReady(r100);
        return;
    }

    @Override // com.bytedance.android.live.browser.d0
    public final void c(LynxView r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "lynxView");
        IExternalLiveLynxCallback r102 = this.f505493a;
        if (r102 == null) goto L6;
        r102.onLoadFailed(r100, r101);
        return;
    }

    @Override // com.bytedance.android.live.browser.d0
    public final void e(View r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "lynxView");
        IExternalLiveLynxCallback r102 = this.f505493a;
        if (r102 == null) goto L6;
        r102.onPageStart(r100, r101);
        return;
    }

    @Override // com.bytedance.android.live.browser.d0
    public final void f(View r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "lynxView");
        IExternalLiveLynxCallback r102 = this.f505493a;
        if (r102 == null) goto L6;
        r102.onReceivedError(r100, r101);
        return;
    }
}
