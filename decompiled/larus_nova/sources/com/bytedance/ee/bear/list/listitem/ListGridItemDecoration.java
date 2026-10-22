package com.bytedance.ee.bear.list.listitem;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.larus.nova.R;
import ku5.c;

/* JADX INFO: loaded from: classes18.dex */
public class ListGridItemDecoration extends RecyclerView.ItemDecoration {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f228608a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f228609b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f228610c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f228611d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f228612e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f228613f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f228614g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final int f228615h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final int f228616i;

    public ListGridItemDecoration(Context r100) {
        this.f228612e = false;
        this.f228612e = c.k(r100);
        Resources r101 = r100.getResources();
        this.f228613f = r101.getDimensionPixelSize(R.dimen.list_grid_horizontal_edge_padding);
        this.f228614g = r101.getDimensionPixelSize(R.dimen.list_grid_horizontal_space_padding);
        this.f228615h = r101.getDimensionPixelSize(R.dimen.list_grid_vertical_padding);
        this.f228616i = r101.getDimensionPixelSize(R.dimen.list_edit_sort_dialog_menu_height);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public final void getItemOffsets(Rect r100, View r101, RecyclerView r110, RecyclerView.State r111) {
        super.getItemOffsets(r100, r101, r110, r111);
        if ((r110.getAdapter() instanceof BaseQuickAdapter) == false) goto L5;
        int r112 = ((BaseQuickAdapter) r110.getAdapter()).getHeaderLayoutCount();
        this.f228610c = r112;
        this.f228608a = r112;
    L5:
        int r102 = r110.getChildAdapterPosition(r101);
        if (r110.getAdapter().getItemViewType(r102) != 22) goto L8;
    L102:
        this.f228609b = r102;
        return;
    L8:
        if (r110.getAdapter().getItemViewType(r102) == 33) goto L102;
        if (r110.getAdapter().getItemViewType(r102) != 273) goto L14;
        return;
    L14:
        if ((r110.getLayoutManager() instanceof GridLayoutManager) == false) goto L104;
        GridLayoutManager r113 = (GridLayoutManager) r110.getLayoutManager();
        boolean r103 = true;
        int r104 = 0;
        if (this.f228612e == false) goto L51;
        int r114 = r113.getSpanCount();
        int r115 = r110.getAdapter().getItemCount() - this.f228610c;
        int r105 = r115 % r114;
        if (r105 != 0) goto L20;
        int r106 = r115 - r114;
    L21:
        int r107 = this.f228608a;
        if (((r102 - r107) % r114) != 0) goto L24;
        boolean r108 = true;
    L25:
        int r109 = (r102 + 1) - r107;
        if ((r109 % r114) != 0) goto L28;
        boolean r116 = true;
    L30:
        if (r102 >= (r114 + r107)) goto L32;
        boolean r117 = true;
    L33:
        if (r109 <= r106) goto L36;
        if (r109 > r115) goto L36;
    L37:
        if (r108 == false) goto L39;
        int r118 = this.f228613f;
    L40:
        if (r117 == false) goto L42;
        r104 = this.f228615h;
    L42:
        if (r116 == false) goto L44;
        int r119 = this.f228613f;
    L45:
        if (r103 == true) goto L47;
    L49:
        int r120 = this.f228615h;
    L50:
        r100.set(r118, r104, r119, r120);
        return;
    L47:
        if (this.f228611d == true) goto L49;
        r120 = this.f228616i;
        goto L50
    L44:
        r119 = this.f228614g / 2;
        goto L45
    L39:
        r118 = this.f228614g / 2;
    L36:
        r103 = false;
        goto L37
    L32:
        r117 = false;
        goto L33
    L28:
        r116 = false;
        goto L30
    L24:
        r108 = false;
        goto L25
    L20:
        r106 = r115 - r105;
        goto L21
    L51:
        int r121 = r113.getSpanCount();
        int r122 = r110.getAdapter().getItemCount() - this.f228610c;
        int r123 = this.f228609b;
        if (r123 == 0) goto L70;
        if (r102 <= r123) goto L70;
        int r124 = r102 - r123;
        if (((r124 - 1) % r121) != 0) goto L58;
        boolean r125 = true;
    L60:
        if ((r124 % r121) != 0) goto L62;
        boolean r126 = true;
    L64:
        if ((r102 - 1) >= (r123 + r121)) goto L66;
        boolean r127 = true;
    L68:
        if (((r102 + r121) - (((r122 - r123) - 1) % r121)) >= r122) goto L87;
    L86:
        r103 = false;
    L87:
        if (r125 == false) goto L89;
        int r128 = this.f228613f;
    L90:
        if (r127 == false) goto L92;
        r104 = this.f228615h;
    L92:
        if (r126 == false) goto L94;
        int r129 = this.f228613f;
    L95:
        if (r103 == true) goto L97;
    L99:
        int r130 = this.f228615h;
    L100:
        r100.set(r128, r104, r129, r130);
        return;
    L97:
        if (this.f228611d == true) goto L99;
        r130 = this.f228616i;
        goto L100
    L94:
        r129 = this.f228614g / 2;
        goto L95
    L89:
        r128 = this.f228614g / 2;
        goto L90
    L66:
        r127 = false;
        goto L68
    L62:
        r126 = false;
        goto L64
    L58:
        r125 = false;
    L70:
        int r131 = this.f228608a;
        int r132 = r102 - r131;
        if ((r132 % r121) != 0) goto L73;
        r125 = true;
    L75:
        if ((((r102 + 1) - r131) % r121) != 0) goto L77;
        boolean r133 = true;
    L79:
        if (r102 >= (r131 + r121)) goto L81;
        boolean r134 = true;
    L83:
        if (r132 < ((r122 - r121) + (r122 % r121))) goto L85;
        r126 = r133;
        r127 = r134;
        goto L87
    L85:
        r126 = r133;
        r127 = r134;
        goto L86
    L81:
        r134 = false;
        goto L83
    L77:
        r133 = false;
        goto L79
    L73:
        r125 = false;
        goto L75
    }
}
