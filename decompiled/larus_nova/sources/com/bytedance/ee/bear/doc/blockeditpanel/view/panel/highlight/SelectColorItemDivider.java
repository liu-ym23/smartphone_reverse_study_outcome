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
import com.larus.nova.R;
import h18.d;

/* JADX INFO: loaded from: classes16.dex */
public class SelectColorItemDivider extends RecyclerView.ItemDecoration {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final a f217711a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f217712b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f217713c;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Paint f217714a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Paint f217715b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final float f217716c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final float f217717d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final float f217718e;

        public a(Context r100) {
            float r101 = d.b(r100, 4);
            float r102 = d.b(r100, 3);
            this.f217718e = d.a(r100, 1.5f);
            this.f217716c = d.b(r100, 7);
            this.f217717d = d.b(r100, 7);
            Paint r103 = new Paint(1);
            r103.setColor(UDColorUtils.getColor(r100, R.color.bg_body));
            r103.setStrokeWidth(r101);
            r103.setStyle(Paint.Style.STROKE);
            this.f217714a = r103;
            Paint r104 = new Paint(1);
            r104.setColor(UDColorUtils.getColor(r100, R.color.primary_fill_default));
            r104.setStrokeWidth(r102);
            r104.setStyle(Paint.Style.STROKE);
            this.f217715b = r104;
        }
    }

    public SelectColorItemDivider(Context r100) {
        this.f217713c = -1;
        this.f217711a = new a(r100);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public final void onDrawOver(Canvas r100, RecyclerView r101, RecyclerView.State r102) {
        super.onDrawOver(r100, r101, r102);
        if (this.f217713c == (-1)) goto L10;
        GridLayoutManager r103 = (GridLayoutManager) r101.getLayoutManager();
        if (r103 == null) goto L11;
        View r104 = r103.getChildAt(this.f217713c);
        if (r104 == null) goto L12;
        int r105 = r104.getLeft();
        int r106 = r104.getTop();
        int r107 = r104.getRight();
        int r108 = r104.getBottom();
        a r109 = this.f217711a;
        r109.getClass();
        float r110 = r105;
        float r111 = r106;
        float r112 = r107;
        float r113 = r108;
        RectF r114 = new RectF(r110, r111, r112, r113);
        float r115 = r109.f217716c;
        r100.drawRoundRect(r114, r115, r115, r109.f217714a);
        a r116 = this.f217711a;
        r116.getClass();
        float r117 = r116.f217718e;
        RectF r118 = new RectF(r110 - r117, r111 - r117, r112 + r117, r113 + r117);
        float r119 = r116.f217717d;
        r100.drawRoundRect(r118, r119, r119, r116.f217715b);
        return;
    L12:
        return;
    L11:
        return;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public final void getItemOffsets(Rect r100, View r101, RecyclerView r102, RecyclerView.State r103) {
        int r104 = this.f217712b;
        r100.left = r104;
        r100.top = r104;
    }
}
