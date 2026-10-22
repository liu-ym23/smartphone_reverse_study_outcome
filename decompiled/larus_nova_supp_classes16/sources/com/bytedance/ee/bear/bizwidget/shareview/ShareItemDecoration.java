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

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public class ShareItemDecoration extends RecyclerView.ItemDecoration {
    public final int a;
    public final int b;
    public final Context c;
    public final RecyclerView.LayoutManager d;

    public ShareItemDecoration(Context r1, RecyclerView.LayoutManager r2) {
        this.c = r1;
        this.d = r2;
        this.a = n.d(12);
        this.b = n.d(4);
    }

    public final void getItemOffsets(Rect r6, View r7, RecyclerView r8, RecyclerView.State r9) {
        if ((r8.getAdapter() instanceof ShareItemAdapter) == false) goto L27;
        Activity r10 = n.g(this.c);
        if (n.D(r10) == false) goto L7;
        int r11 = n.a(n.getResources(r10)).widthPixels;
    L8:
        int r0 = r8.getChildAdapterPosition(r7);
        int r1 = this.c.getResources().getDimensionPixelSize(2131166496);
        GridLayoutManager r2 = this.d;
        int r4 = 0;
        if ((r2 instanceof GridLayoutManager) == false) goto L15;
        int r12 = r2.getSpanCount();
        int r13 = (r11 - (r1 * r12)) / (r12 + 1);
        int r3 = r0 % r12;
        int r5 = ((r12 - r3) * r13) / r12;
        int r14 = ((r3 + 1) * r13) / r12;
        r7.measure(0, 0);
        int r16 = r7.getMeasuredWidth();
        int r17 = r13 + r1;
        if (r16 <= r1) goto L13;
        ViewGroup.LayoutParams r18 = r7.getLayoutParams();
        int r19 = Math.min(r16, r17);
        r18.width = r19;
        r4 = r19 - r1;
        r7.setLayoutParams(r18);
    L13:
        int r20 = r4 / 2;
        r6.left = r5 - r20;
        r6.right = r14 - r20;
        return;
    L15:
        if ((r2 instanceof LinearLayoutManager) == true) goto L17;
        return;
    L17:
        if (((LinearLayoutManager) r2).getOrientation() != 0) goto L30;
        int r21 = ((ShareItemAdapter) r8.getAdapter()).getItemCount();
        if (r0 != 0) goto L21;
        int r22 = this.a;
    L22:
        r6.left = r22;
        if (r0 != (r21 - 1)) goto L25;
        r4 = this.a;
    L25:
        r6.right = r4;
        return;
    L21:
        r22 = this.b;
        goto L22
    L30:
        return;
    L7:
        r11 = n.v();
        goto L8
    }
}
