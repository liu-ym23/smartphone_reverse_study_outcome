package com.ss.android.lark.contact.base.contact_list.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.larksuite.framework.utils.UIUtils;
import com.larus.nova.R;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes35.dex */
public class FloatingBarItemDecoration extends RecyclerView.ItemDecoration {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Paint f418617a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Paint f418618b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Paint f418619c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f418620d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f418621e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f418622f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f418623g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public Map<Integer, String> f418624h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public List<String> f418625i;

    private FloatingBarItemDecoration() {
    }

    public final String h(int r100) {
    L2:
        if (r100 < 0) goto L8;
        if (this.f418624h.containsKey(Integer.valueOf(r100)) == true) goto L6;
        r100 = r100 - 1;
        goto L2
    L6:
        return this.f418624h.get(Integer.valueOf(r100));
    L8:
        return null;
    }

    public FloatingBarItemDecoration(Context r100, Map<Integer, String> r101) {
        this.f418620d = UIUtils.dp2px(r100, 32.0f);
        Paint r102 = new Paint();
        this.f418617a = r102;
        r102.setColor(ContextCompat.getColor(r100, R.color.bg_body));
        Paint r103 = new Paint();
        this.f418619c = r103;
        r103.setColor(ContextCompat.getColor(r100, R.color.bg_base));
        Paint r104 = new Paint();
        this.f418618b = r104;
        r104.setColor(ContextCompat.getColor(r100, R.color.text_caption));
        r104.setTextSize(UIUtils.dp2px(r100, 14.0f));
        r104.setAntiAlias(true);
        Paint.FontMetrics r105 = r104.getFontMetrics();
        float r106 = r105.bottom;
        this.f418621e = (int) (r106 - r105.top);
        this.f418622f = (int) r106;
        this.f418623g = UIUtils.dp2px(r100, 16.0f);
        this.f418625i = new LinkedList(new LinkedHashSet(r101.values()));
        this.f418624h = r101;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public final void onDraw(Canvas r210, RecyclerView r211, RecyclerView.State r212) {
        super.onDraw(r210, r211, r212);
        int r100 = r211.getPaddingLeft();
        int r101 = r211.getWidth() - r211.getPaddingRight();
        int r102 = r211.getChildCount();
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L13;
        View r104 = r211.getChildAt(r103);
        RecyclerView.LayoutParams r105 = (RecyclerView.LayoutParams) r104.getLayoutParams();
        int r106 = r105.getViewAdapterPosition();
        if (this.f418624h.containsKey(Integer.valueOf(r106)) == false) goto L9;
        String r110 = this.f418624h.get(Integer.valueOf(r106));
        int r111 = r104.getTop() - ((ViewGroup.MarginLayoutParams) r105).topMargin;
        r210.drawRect(r100, r111 - this.f418620d, r101, r111, this.f418617a);
        r210.drawText(r110, r104.getPaddingLeft() + this.f418623g, (r111 - ((this.f418620d - this.f418621e) / 2)) - this.f418622f, this.f418618b);
    L9:
        if (this.f418624h.containsKey(Integer.valueOf(r106 + 1)) == false) goto L12;
        int r107 = r104.getBottom() + ((ViewGroup.MarginLayoutParams) r105).bottomMargin;
        r210.drawRect(r100, r107, r101, 0 + r107, this.f418619c);
    L12:
        r103 = r103 + 1;
        goto L3
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public final void onDrawOver(Canvas r110, RecyclerView r111, RecyclerView.State r112) {
        super.onDrawOver(r110, r111, r112);
        int r113 = ((LinearLayoutManager) r111.getLayoutManager()).findFirstVisibleItemPosition();
        if (r113 != (-1)) goto L5;
        return;
    L5:
        RecyclerView.ViewHolder r100 = r111.findViewHolderForAdapterPosition(r113);
        if (r100 != null) goto L8;
        return;
    L8:
        View r101 = r100.itemView;
        String r102 = h(r113);
        if (r102 != null) goto L11;
        return;
    L11:
        ((LinkedList) this.f418625i).indexOf(r102);
        boolean r103 = true;
        String r114 = h(r113 + 1);
        if (r114 != null) goto L14;
    L18:
        r103 = false;
    L19:
        r110.drawRect(r111.getPaddingLeft(), r111.getPaddingTop(), r111.getRight() - r111.getPaddingRight(), r111.getPaddingTop() + this.f418620d, this.f418617a);
        float r115 = r101.getPaddingLeft() + this.f418623g;
        int r116 = r111.getPaddingTop();
        int r104 = this.f418620d;
        r110.drawText(r102, r115, ((r116 + r104) - ((r104 - this.f418621e) / 2)) - this.f418622f, this.f418618b);
        if (r103 == false) goto L23;
        r110.restore();
        return;
    L23:
        return;
    L14:
        if (TextUtils.equals(r102, r114) == true) goto L18;
        if (((r101.getHeight() + r101.getTop()) + 0) >= this.f418620d) goto L18;
        r110.save();
        r110.translate(0.0f, ((r101.getHeight() + r101.getTop()) + 0) - this.f418620d);
        goto L19
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public final void getItemOffsets(Rect r100, View r101, RecyclerView r102, RecyclerView.State r103) {
        super.getItemOffsets(r100, r101, r102, r103);
        int r104 = ((RecyclerView.LayoutParams) r101.getLayoutParams()).getViewAdapterPosition();
        if (this.f418624h.containsKey(Integer.valueOf(r104)) == false) goto L5;
        int r105 = this.f418620d;
    L6:
        this.f418624h.containsKey(Integer.valueOf(r104 + 1));
        r100.set(0, r105, 0, 0);
        return;
    L5:
        r105 = 0;
        goto L6
    }
}
