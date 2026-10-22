package com.bytedance.ee.bear.list.preload;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import com.bytedance.ee.bear.widgets.BaseRecyclerView;

/* JADX INFO: loaded from: classes18.dex */
public class RecentListContainer extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public BaseRecyclerView f229182a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f229183b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public a f229184c;

    public interface a {
        void a();
    }

    public RecentListContainer(Context r100) {
        super(r100);
        this.f229183b = false;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void dispatchDraw(Canvas r100) {
        super.dispatchDraw(r100);
        if (this.f229183b == false) goto L5;
        return;
    L5:
        if (this.f229182a.getChildCount() <= 0) goto L7;
        boolean r101 = true;
    L8:
        if (r101 == false) goto L14;
        this.f229183b = true;
        a r102 = this.f229184c;
        if (r102 == null) goto L15;
        r102.a();
        return;
    L15:
        return;
    L14:
        return;
    L7:
        r101 = false;
        goto L8
    }

    public void setFirstPageViewListener(a r100) {
        this.f229184c = r100;
    }

    public RecentListContainer(Context r100, AttributeSet r101) {
        super(r100, r101);
        this.f229183b = false;
    }

    public RecentListContainer(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
        this.f229183b = false;
    }
}
