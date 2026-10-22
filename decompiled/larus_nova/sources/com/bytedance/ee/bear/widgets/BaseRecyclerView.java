package com.bytedance.ee.bear.widgets;

import android.content.Context;
import android.util.AttributeSet;
import com.ss.android.lark.widget.recyclerview.CommonRecyclerView;

/* JADX INFO: loaded from: classes18.dex */
public class BaseRecyclerView extends CommonRecyclerView {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public a f240024k;

    public interface a {
        void T(int r100, int r101);

        void a0();
    }

    @Override // com.ss.android.lark.widget.recyclerview.CommonRecyclerView
    public String getSceneTag() {
        return "docs_" + super.getSceneTag();
    }

    public a getNestScrollListener() {
        return this.f240024k;
    }

    public BaseRecyclerView(Context r100) {
        super(r100);
    }

    public void setNestScrollListener(a r100) {
        this.f240024k = r100;
    }

    public BaseRecyclerView(Context r100, AttributeSet r101) {
        super(r100, r101);
    }

    public BaseRecyclerView(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
    }

    @Override // androidx.recyclerview.widget.RecyclerView, androidx.core.view.NestedScrollingChild2
    public final boolean dispatchNestedPreScroll(int r100, int r101, int[] r102, int[] r103, int r104) {
        a r105 = this.f240024k;
        if (r105 == null) goto L6;
        r105.T(r100, r101);
    L6:
        return super.dispatchNestedPreScroll(r100, r101, r102, r103, r104);
    }

    @Override // androidx.recyclerview.widget.RecyclerView, androidx.core.view.NestedScrollingChild2
    public final boolean dispatchNestedScroll(int r100, int r101, int r102, int r103, int[] r104, int r105) {
        a r106 = this.f240024k;
        if (r106 == null) goto L6;
        r106.a0();
    L6:
        return super.dispatchNestedScroll(r100, r101, r102, r103, r104, r105);
    }
}
