package op3;

import android.content.res.Resources;
import android.view.View;
import android.view.ViewGroup;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public class a<M> implements f<M> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final View f524698a;

    public a(View r100) {
        Intrinsics.checkNotNullParameter(r100, "view");
        this.f524698a = r100;
    }

    @Override // op3.f
    public final void a(int r100) {
        ViewGroup.LayoutParams r101 = this.f524698a.getLayoutParams();
        if ((r101 instanceof ViewGroup.MarginLayoutParams) == true) goto L5;
        r101 = null;
    L5:
        ViewGroup.MarginLayoutParams r102 = (ViewGroup.MarginLayoutParams) r101;
        if (r102 != null) goto L9;
        return;
    L9:
        if (r102.topMargin == r100) goto L12;
        r102.topMargin = r100;
        this.f524698a.setLayoutParams(r102);
        return;
    }

    @Override // op3.f
    public final void b(int r100) {
        ViewGroup.LayoutParams r101 = this.f524698a.getLayoutParams();
        if ((r101 instanceof ViewGroup.MarginLayoutParams) == true) goto L5;
        r101 = null;
    L5:
        ViewGroup.MarginLayoutParams r102 = (ViewGroup.MarginLayoutParams) r101;
        if (r102 != null) goto L9;
        return;
    L9:
        if (r102.bottomMargin == r100) goto L12;
        r102.bottomMargin = r100;
        this.f524698a.setLayoutParams(r102);
        return;
    }

    @Override // op3.f
    public boolean c(com.bytedance.android.window.shop.repository.tab.entity.l r100) {
        if (this.f524698a.getVisibility() != 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // op3.f
    public final int d(int r100) {
        Resources r101 = this.f524698a.getResources();
        return (int) ((r100 * WindowDisplayMetricsOverride.apply(r101, r101.getDisplayMetrics()).density) + 0.5f);
    }
}
