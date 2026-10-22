package qn5;

import android.animation.ValueAnimator;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import com.bytedance.ee.bear.sheet_core.inputbar.editor.SheetEditorLayout;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class o0 extends com.bytedance.ee.bear.widgets.t {
    public final /* synthetic */ SheetEditorLayout c;

    public o0(SheetEditorLayout r1) {
        this.c = r1;
    }

    @Override // com.bytedance.ee.bear.widgets.t
    public final void a(View r4) {
        this.c.v.b("enter_cell_expand");
        this.c.j();
        this.c.k();
        final SheetEditorLayout r5 = this.c;
        ValueAnimator r0 = ValueAnimator.ofInt(new int[]{r5.getRootView().getHeight() - r5.k.getHeight(), 0});
        r0.setDuration(350);
        r0.setInterpolator(new DecelerateInterpolator());
        r0.addUpdateListener(new g(r5));
        r0.addListener(new y(r5));
        r0.start();
    }
}
