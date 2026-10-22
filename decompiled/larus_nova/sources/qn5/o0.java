package qn5;

import android.animation.ValueAnimator;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import com.bytedance.ee.bear.sheet_core.inputbar.editor.SheetEditorLayout;

/* JADX INFO: loaded from: classes18.dex */
public final class o0 extends com.bytedance.ee.bear.widgets.t {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ SheetEditorLayout f534061c;

    public o0(SheetEditorLayout r100) {
        this.f534061c = r100;
    }

    @Override // com.bytedance.ee.bear.widgets.t
    public final void a(View r100) {
        this.f534061c.f238491v.b("enter_cell_expand");
        this.f534061c.j();
        this.f534061c.k();
        final SheetEditorLayout r101 = this.f534061c;
        ValueAnimator r102 = ValueAnimator.ofInt(new int[]{r101.getRootView().getHeight() - r101.f238478k.getHeight(), 0});
        r102.setDuration(350);
        r102.setInterpolator(new DecelerateInterpolator());
        r102.addUpdateListener(new g(r101));
        r102.addListener(new y(r101));
        r102.start();
    }
}
