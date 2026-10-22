package com.bytedance.ee.bear.wikiv2.common.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import com.bytedance.ee.bear.widgets.BaseRecyclerView;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public class InterceptableRecyclerView extends BaseRecyclerView {

    public interface a {
    }

    public void setOnTouchListener(View.OnTouchListener r1) {
    }

    public void setTouchInterceptor(a r1) {
    }

    public InterceptableRecyclerView(Context r1) {
        super(r1);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final boolean dispatchTouchEvent(MotionEvent r1) {
        return super/*android.view.ViewGroup*/.dispatchTouchEvent(r1);
    }

    public final boolean onTouchEvent(MotionEvent r1) {
        return super/*androidx.recyclerview.widget.RecyclerView*/.onTouchEvent(r1);
    }

    public InterceptableRecyclerView(Context r1, AttributeSet r2) {
        super(r1, r2);
    }

    public InterceptableRecyclerView(Context r1, AttributeSet r2, int r3) {
        super(r1, r2, r3);
    }
}
