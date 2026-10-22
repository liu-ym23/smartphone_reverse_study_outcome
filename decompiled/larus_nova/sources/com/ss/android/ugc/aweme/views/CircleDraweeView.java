package com.ss.android.ugc.aweme.views;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import com.facebook.drawee.interfaces.DraweeController;
import com.ss.android.ugc.tools.utils.i;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes40.dex */
public class CircleDraweeView extends AnimateDraweeView {
    public final void j() {
    }

    public void setClipStyle(int r100) {
    }

    public void setRectFRadius(float r100) {
    }

    public void setScaleBitmap(float r100) {
    }

    public CircleDraweeView(Context r100) {
        super(r100);
        i.a(getContext(), 6.0f);
        new Paint();
        new RectF();
        new AnonymousClass1(this);
    }

    @Override // android.widget.ImageView, android.view.View
    public final void onDraw(Canvas r100) {
        super.onDraw(r100);
    }

    @Override // com.ss.android.ugc.aweme.views.AnimateDraweeView, com.facebook.drawee.view.DraweeView
    public void setController(@Nullable DraweeController r100) {
        super.setController(r100);
    }

    @Override // com.ss.android.ugc.aweme.views.AnimateDraweeView
    public void setEnableAnimation(boolean r100) {
        super.setEnableAnimation(r100);
    }

    public CircleDraweeView(Context r100, AttributeSet r101) {
        super(r100, r101);
        i.a(getContext(), 6.0f);
        new Paint();
        new RectF();
        new AnonymousClass1(this);
    }

    public CircleDraweeView(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
        i.a(getContext(), 6.0f);
        new Paint();
        new RectF();
        new AnonymousClass1(this);
    }

    @Override // android.view.View
    public final void onSizeChanged(int r100, int r101, int r102, int r103) {
        super.onSizeChanged(r100, r101, r102, r103);
        j();
    }
}
