package com.bytedance.ee.bear.widgets;

import android.content.Context;
import android.util.AttributeSet;
import com.ss.android.lark.widget.recyclerview.CommonRecyclerView;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public class BaseRecyclerView extends CommonRecyclerView {
    public a k;

    public interface a {
        void T(int r1, int r2);

        void a0();
    }

    public String getSceneTag() {
        return "docs_" + super.getSceneTag();
    }

    public a getNestScrollListener() {
        return this.k;
    }

    public BaseRecyclerView(Context r1) {
        super(r1);
    }

    public void setNestScrollListener(a r1) {
        this.k = r1;
    }

    public BaseRecyclerView(Context r1, AttributeSet r2) {
        super(r1, r2);
    }

    public BaseRecyclerView(Context r1, AttributeSet r2, int r3) {
        super(r1, r2, r3);
    }

    public final boolean dispatchNestedPreScroll(int r2, int r3, int[] r4, int[] r5, int r6) {
        a r0 = this.k;
        if (r0 == null) goto L6;
        r0.T(r2, r3);
    L6:
        return super/*androidx.recyclerview.widget.RecyclerView*/.dispatchNestedPreScroll(r2, r3, r4, r5, r6);
    }

    public final boolean dispatchNestedScroll(int r2, int r3, int r4, int r5, int[] r6, int r7) {
        a r0 = this.k;
        if (r0 == null) goto L6;
        r0.a0();
    L6:
        return super/*androidx.recyclerview.widget.RecyclerView*/.dispatchNestedScroll(r2, r3, r4, r5, r6, r7);
    }
}
