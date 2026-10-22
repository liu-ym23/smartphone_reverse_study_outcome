package com.bytedance.locallife.biz.utils.rv;

import android.content.Context;
import android.view.ViewConfiguration;
import androidx.recyclerview.widget.RecyclerView;
import com.facebook.drawee.backends.pipeline.Fresco;

/* JADX INFO: loaded from: classes21.dex */
public class LifeFrescoRvScrollListener extends RecyclerView.OnScrollListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f256990a;

    public LifeFrescoRvScrollListener(Context r100) {
        if (r100 == null) goto L6;
        this.f256990a = ViewConfiguration.get(r100).getScaledTouchSlop();
        return;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
    public final void onScrollStateChanged(RecyclerView r100, int r101) {
        super.onScrollStateChanged(r100, r101);
        if (r101 != 0) goto L6;
        Fresco.getImagePipeline().resume();
        return;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
    public final void onScrolled(RecyclerView r100, int r101, int r102) {
        super.onScrolled(r100, r101, r102);
        int r103 = Math.abs(r102);
        if (r100.getScrollState() != 1) goto L8;
        if (r103 >= this.f256990a) goto L8;
        Fresco.getImagePipeline().resume();
        return;
    L8:
        if (r100.getScrollState() != 1) goto L13;
        if (r103 < this.f256990a) goto L13;
        Fresco.getImagePipeline().pause();
        return;
    L13:
        if (r100.getScrollState() != 2) goto L18;
        Fresco.getImagePipeline().pause();
        return;
    }
}
