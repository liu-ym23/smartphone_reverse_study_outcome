package i9c;

import android.view.View;
import com.ss.android.lark.ug.banner.ui.template.BannerTemplateView;
import com.ttnet.org.chromium.base.BaseSwitches;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public final class b implements View.OnAttachStateChangeListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ BannerTemplateView f488831a;

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewDetachedFromWindow(View r100) {
        Intrinsics.checkNotNullParameter(r100, BaseSwitches.V);
    }

    public b(BannerTemplateView r100) {
        this.f488831a = r100;
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewAttachedToWindow(View r100) {
        Intrinsics.checkNotNullParameter(r100, BaseSwitches.V);
        BannerTemplateView r101 = this.f488831a;
        f9c.a r102 = r101.f444394g;
        if (r102 == null) goto L5;
        r102.b(r101);
    L5:
        this.f488831a.removeOnAttachStateChangeListener(this);
    }
}
