package com.bytedance.ee.bear.bizwidget.shareview;

import android.app.Activity;
import android.content.Context;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.ee.util.ui.n;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes16.dex */
public class ShareItemDecoration extends RecyclerView.ItemDecoration {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f216531a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f216532b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Context f216533c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final RecyclerView.LayoutManager f216534d;

    public ShareItemDecoration(Context r100, RecyclerView.LayoutManager r101) {
        this.f216533c = r100;
        this.f216534d = r101;
        this.f216531a = n.d(12);
        this.f216532b = n.d(4);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public final void getItemOffsets(Rect r100, View r101, RecyclerView r102, RecyclerView.State r103) {
        if ((r102.getAdapter() instanceof ShareItemAdapter) == false) goto L27;
        Activity r104 = n.g(this.f216533c);
        if (n.D(r104) == false) goto L7;
        int r105 = n.a(n.getResources(r104)).widthPixels;
    L8:
        int r106 = r102.getChildAdapterPosition(r101);
        int r107 = this.f216533c.getResources().getDimensionPixelSize(R.dimen.external_share_item_width);
        RecyclerView.LayoutManager r108 = this.f216534d;
        int r109 = 0;
        if ((r108 instanceof GridLayoutManager) == false) goto L15;
        int r110 = ((GridLayoutManager) r108).getSpanCount();
        int r111 = (r105 - (r107 * r110)) / (r110 + 1);
        int r112 = r106 % r110;
        int r113 = ((r110 - r112) * r111) / r110;
        int r114 = ((r112 + 1) * r111) / r110;
        r101.measure(0, 0);
        int r115 = r101.getMeasuredWidth();
        int r116 = r111 + r107;
        if (r115 <= r107) goto L13;
        ViewGroup.LayoutParams r117 = r101.getLayoutParams();
        int r118 = Math.min(r115, r116);
        r117.width = r118;
        r109 = r118 - r107;
        r101.setLayoutParams(r117);
    L13:
        int r119 = r109 / 2;
        r100.left = r113 - r119;
        r100.right = r114 - r119;
        return;
    L15:
        if ((r108 instanceof LinearLayoutManager) == true) goto L17;
        return;
    L17:
        if (((LinearLayoutManager) r108).getOrientation() != 0) goto L30;
        int r120 = ((ShareItemAdapter) r102.getAdapter()).getItemCount();
        if (r106 != 0) goto L21;
        int r121 = this.f216531a;
    L22:
        r100.left = r121;
        if (r106 != (r120 - 1)) goto L25;
        r109 = this.f216531a;
    L25:
        r100.right = r109;
        return;
    L21:
        r121 = this.f216532b;
        goto L22
    L30:
        return;
    L7:
        r105 = n.v();
        goto L8
    }
}
