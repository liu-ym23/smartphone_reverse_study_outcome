package q8a;

import android.content.Context;
import android.graphics.Canvas;
import android.view.View;
import android.widget.LinearLayout;
import com.lynx.tasm.behavior.ui.IDrawChildHook;
import com.lynx.xelement.scroll.coordinator.childitem.ScrollCoordinatorNestedScrollView;

/* JADX INFO: loaded from: classes32.dex */
public final class c extends LinearLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ScrollCoordinatorNestedScrollView f532047a;

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean r100, int r101, int r102, int r103, int r104) {
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void dispatchDraw(Canvas r100) {
        IDrawChildHook r101 = this.f532047a.f384316l;
        if (r101 == null) goto L5;
        r101.beforeDispatchDraw(r100);
    L5:
        super.dispatchDraw(r100);
        IDrawChildHook r102 = this.f532047a.f384316l;
        if (r102 == null) goto L9;
        r102.afterDispatchDraw(r100);
        return;
    }

    public c(ScrollCoordinatorNestedScrollView r100, Context r101) {
        this.f532047a = r100;
        super(r101);
    }

    @Override // android.widget.LinearLayout, android.view.View
    public final void onMeasure(int r100, int r101) {
        ScrollCoordinatorNestedScrollView r102 = this.f532047a;
        setMeasuredDimension(r102.f384311g, r102.f384312h);
    }

    @Override // android.view.ViewGroup
    public final boolean drawChild(Canvas r100, View r101, long r102) {
        IDrawChildHook r103 = this.f532047a.f384316l;
        if (r103 == null) goto L5;
        r103.beforeDrawChild(r100, r101, r102);
    L5:
        boolean r104 = super.drawChild(r100, r101, r102);
        IDrawChildHook r105 = this.f532047a.f384316l;
        if (r105 == null) goto L8;
        r105.afterDrawChild(r100, r101, r102);
    L8:
        return r104;
    }
}
