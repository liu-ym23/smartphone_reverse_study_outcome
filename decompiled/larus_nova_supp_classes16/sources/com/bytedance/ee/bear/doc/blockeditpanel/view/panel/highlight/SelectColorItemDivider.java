package com.bytedance.ee.bear.doc.blockeditpanel.view.panel.highlight;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.view.View;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.larksuite.component.universe_design.color.UDColorUtils;
import h18.d;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public class SelectColorItemDivider extends RecyclerView.ItemDecoration {
    public final a a;
    public int b;
    public int c;

    public static class a {
        public final Paint a;
        public final Paint b;
        public final float c;
        public final float d;
        public final float e;

        public a(Context r6) {
            float r0 = d.b(r6, 4);
            float r1 = d.b(r6, 3);
            this.e = d.a(r6, 1.5f);
            this.c = d.b(r6, 7);
            this.d = d.b(r6, 7);
            Paint r2 = new Paint(1);
            r2.setColor(UDColorUtils.getColor(r6, 2131100548));
            r2.setStrokeWidth(r0);
            r2.setStyle(Paint.Style.STROKE);
            this.a = r2;
            Paint r3 = new Paint(1);
            r3.setColor(UDColorUtils.getColor(r6, 2131105548));
            r3.setStrokeWidth(r1);
            r3.setStyle(Paint.Style.STROKE);
            this.b = r3;
        }
    }

    public SelectColorItemDivider(Context r2) {
        this.c = -1;
        this.a = new a(r2);
    }

    public final void onDrawOver(Canvas r6, RecyclerView r7, RecyclerView.State r8) {
        super.onDrawOver(r6, r7, r8);
        if (this.c == (-1)) goto L10;
        GridLayoutManager r9 = r7.getLayoutManager();
        if (r9 == null) goto L11;
        View r10 = r9.getChildAt(this.c);
        if (r10 == null) goto L12;
        int r11 = r10.getLeft();
        int r0 = r10.getTop();
        int r1 = r10.getRight();
        int r12 = r10.getBottom();
        a r2 = this.a;
        r2.getClass();
        float r13 = r11;
        float r3 = r0;
        float r4 = r1;
        float r14 = r12;
        RectF r5 = new RectF(r13, r3, r4, r14);
        float r16 = r2.c;
        r6.drawRoundRect(r5, r16, r16, r2.a);
        a r17 = this.a;
        r17.getClass();
        float r18 = r17.e;
        RectF r19 = new RectF(r13 - r18, r3 - r18, r4 + r18, r14 + r18);
        float r20 = r17.d;
        r6.drawRoundRect(r19, r20, r20, r17.b);
        return;
    L12:
        return;
    L11:
        return;
    }

    public final void getItemOffsets(Rect r1, View r2, RecyclerView r3, RecyclerView.State r4) {
        int r5 = this.b;
        r1.left = r5;
        r1.top = r5;
    }
}
