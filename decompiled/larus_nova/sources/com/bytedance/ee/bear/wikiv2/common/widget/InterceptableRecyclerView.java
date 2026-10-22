package com.bytedance.ee.bear.wikiv2.common.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import com.bytedance.ee.bear.widgets.BaseRecyclerView;

/* JADX INFO: loaded from: classes18.dex */
public class InterceptableRecyclerView extends BaseRecyclerView {

    public interface a {
    }

    @Override // android.view.View
    public void setOnTouchListener(View.OnTouchListener r100) {
    }

    public void setTouchInterceptor(a r100) {
    }

    public InterceptableRecyclerView(Context r100) {
        super(r100);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final boolean dispatchTouchEvent(MotionEvent r100) {
        return super.dispatchTouchEvent(r100);
    }

    @Override // androidx.recyclerview.widget.RecyclerView, android.view.View
    public final boolean onTouchEvent(MotionEvent r100) {
        return super.onTouchEvent(r100);
    }

    public InterceptableRecyclerView(Context r100, AttributeSet r101) {
        super(r100, r101);
    }

    public InterceptableRecyclerView(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
    }
}
