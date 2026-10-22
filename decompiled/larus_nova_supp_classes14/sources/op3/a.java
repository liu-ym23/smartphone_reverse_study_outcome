package op3;

import android.content.res.Resources;
import android.view.View;
import android.view.ViewGroup;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public class a<M> implements f<M> {
    public final View a;

    public a(View r2) {
        Intrinsics.checkNotNullParameter(r2, "view");
        this.a = r2;
    }

    @Override // op3.f
    public final void a(int r3) {
        ViewGroup.LayoutParams r0 = this.a.getLayoutParams();
        if ((r0 instanceof ViewGroup.MarginLayoutParams) == true) goto L5;
        r0 = null;
    L5:
        ViewGroup.MarginLayoutParams r1 = (ViewGroup.MarginLayoutParams) r0;
        if (r1 != null) goto L9;
        return;
    L9:
        if (r1.topMargin == r3) goto L12;
        r1.topMargin = r3;
        this.a.setLayoutParams(r1);
        return;
    }

    @Override // op3.f
    public final void b(int r3) {
        ViewGroup.LayoutParams r0 = this.a.getLayoutParams();
        if ((r0 instanceof ViewGroup.MarginLayoutParams) == true) goto L5;
        r0 = null;
    L5:
        ViewGroup.MarginLayoutParams r1 = (ViewGroup.MarginLayoutParams) r0;
        if (r1 != null) goto L9;
        return;
    L9:
        if (r1.bottomMargin == r3) goto L12;
        r1.bottomMargin = r3;
        this.a.setLayoutParams(r1);
        return;
    }

    @Override // op3.f
    public boolean c(com.bytedance.android.window.shop.repository.tab.entity.l r1) {
        if (this.a.getVisibility() != 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // op3.f
    public final int d(int r3) {
        Resources r0 = this.a.getResources();
        return (int) ((r3 * WindowDisplayMetricsOverride.apply(r0, r0.getDisplayMetrics()).density) + 0.5f);
    }
}
