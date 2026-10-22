package com.bytedance.android.ui.ec.widget.photodraweeview;

import android.graphics.Matrix;
import android.graphics.RectF;
import android.view.MotionEvent;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public interface ZoomableController {

    public interface Listener {
        void onTransformChanged(Matrix r1);
    }

    int computeHorizontalScrollExtent();

    int computeHorizontalScrollOffset();

    int computeHorizontalScrollRange();

    void computeScroll();

    int computeVerticalScrollExtent();

    int computeVerticalScrollOffset();

    int computeVerticalScrollRange();

    Matrix getActiveTransform();

    float getScaleFactor();

    boolean isEnabled();

    boolean isIdentity();

    boolean onTouchEvent(MotionEvent r1);

    void setEnabled(boolean r1);

    void setImageBounds(RectF r1);

    void setListener(Listener r1);

    void setViewBounds(RectF r1);
}
