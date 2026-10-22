package h9c;

import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.ss.android.lark.ug.banner.ui.normal.BannerNormalView;
import com.ttnet.org.chromium.base.BaseSwitches;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public final class a implements View.OnAttachStateChangeListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ BannerNormalView f484355a;

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewDetachedFromWindow(View r100) {
        Intrinsics.checkNotNullParameter(r100, BaseSwitches.V);
    }

    public a(BannerNormalView r100) {
        this.f484355a = r100;
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewAttachedToWindow(View r100) {
        Intrinsics.checkNotNullParameter(r100, BaseSwitches.V);
        BannerNormalView r101 = this.f484355a;
        f9c.a r102 = r101.f444382i;
        if (r102 == null) goto L5;
        r102.b(r101);
    L5:
        ConstraintLayout r103 = this.f484355a.f444375b;
        if (r103 == null) goto L9;
        r103.removeOnAttachStateChangeListener(this);
        return;
    }
}
