package com.lynx.tasm.behavior.ui.scroll.base;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import com.lynx.tasm.behavior.ui.IDrawChildHook;
import com.lynx.tasm.behavior.ui.scroll.LynxUIScrollViewInternal;

/* JADX INFO: loaded from: classes32.dex */
public class LynxBaseScrollView extends LynxBaseScrollViewNested implements IDrawChildHook.IDrawChildHookBinding {

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public IDrawChildHook f382946q;

    public class a implements View.OnTouchListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ LynxBaseScrollView f382947a;

        public a(LynxBaseScrollView r100) {
            this.f382947a = r100;
        }

        @Override // android.view.View.OnTouchListener
        public final boolean onTouch(View r100, MotionEvent r101) {
            return !this.f382947a.f382972f;
        }
    }

    public void setFooter(View r100) {
    }

    public void setHeader(View r100) {
    }

    public void setLayoutFromEnd(boolean r100) {
    }

    public LynxBaseScrollView(Context r100) {
        this(r100, null);
    }

    @Override // com.lynx.tasm.behavior.ui.IDrawChildHook.IDrawChildHookBinding
    public final void bindDrawChildHook(IDrawChildHook r100) {
        this.f382946q = r100;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void dispatchDraw(Canvas r100) {
        IDrawChildHook r101 = this.f382946q;
        if (r101 == null) goto L5;
        r101.beforeDispatchDraw(r100);
    L5:
        super.dispatchDraw(r100);
        IDrawChildHook r102 = this.f382946q;
        if (r102 == null) goto L9;
        r102.afterDispatchDraw(r100);
        return;
    }

    public void setBackwardNestedScrollMode(int r100) {
        this.f382966p = r100;
    }

    public void setForwardNestedScrollMode(int r100) {
        this.f382965o = r100;
    }

    public void setVertical(boolean r100) {
        this.f382969c = r100;
    }

    public LynxBaseScrollView(Context r100, AttributeSet r101) {
        this(r100, r101, 0);
    }

    @Override // android.widget.FrameLayout, android.view.View
    public final void onMeasure(int r100, int r101) {
        setMeasuredDimension(View.MeasureSpec.getSize(r100), View.MeasureSpec.getSize(r101));
        if (getRootView().isLayoutRequested() == true) goto L8;
        IDrawChildHook r102 = this.f382946q;
        if (r102 == null) goto L9;
        r102.performMeasureChildrenUI();
        return;
    L9:
        return;
    }

    public LynxBaseScrollView(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
        setNestedScrollingEnabled(true);
        setOnTouchListener(new a(this));
    }

    @Override // android.view.ViewGroup
    public final boolean drawChild(Canvas r100, View r101, long r102) {
        IDrawChildHook r103 = this.f382946q;
        if (r103 == null) goto L5;
        Rect r104 = r103.beforeDrawChild(r100, r101, r102);
    L6:
        if (r104 == null) goto L8;
        r100.save();
        r100.clipRect(r104);
        boolean r105 = super.drawChild(r100, r101, r102);
        r100.restore();
    L9:
        IDrawChildHook r106 = this.f382946q;
        if (r106 == null) goto L12;
        r106.afterDrawChild(r100, r101, r102);
    L12:
        return r105;
    L8:
        r105 = super.drawChild(r100, r101, r102);
        goto L9
    L5:
        r104 = null;
        goto L6
    }

    @Override // android.view.View
    public final void onScrollChanged(int r100, int r101, int r102, int r103) {
        super.onScrollChanged(r100, r101, r102, r103);
        ((LynxUIScrollViewInternal) this.f382975i).O();
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean r100, int r101, int r102, int r103, int r104) {
        if (getRootView().isLayoutRequested() == true) goto L8;
        IDrawChildHook r105 = this.f382946q;
        if (r105 == null) goto L9;
        r105.performLayoutChildrenUI();
        return;
    L9:
        return;
    }
}
