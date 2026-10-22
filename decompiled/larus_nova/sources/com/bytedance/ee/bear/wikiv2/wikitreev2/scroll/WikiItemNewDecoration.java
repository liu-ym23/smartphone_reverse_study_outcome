package com.bytedance.ee.bear.wikiv2.wikitreev2.scroll;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.ee.bear.facade.common.widget.recyclerview.SwipeMenuLayout;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.view.WikItemLeafView;
import com.bytedance.ee.util.ui.l;
import com.bytedance.ee.util.ui.n;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes18.dex */
public class WikiItemNewDecoration extends RecyclerView.ItemDecoration {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Drawable f241657a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Drawable f241658b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f241659c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f241660d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f241661e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f241662f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f241663g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final a f241664h;

    public interface a {
        boolean a(WikItemLeafView r100, int r101);
    }

    public WikiItemNewDecoration(Context r100, Rect r101, a r102) {
        this.f241659c = 20;
        this.f241660d = 8;
        this.f241661e = 8;
        this.f241662f = 14;
        this.f241663g = 14;
        this.f241657a = l.a(r100, R.drawable.ud_icon_add_outlined, R.color.icon_n2);
        this.f241658b = new ColorDrawable(r100.getResources().getColor(R.color.bg_body));
        this.f241664h = r102;
        if (r101 == null) goto L5;
        this.f241661e = r101.left;
        this.f241662f = r101.top;
        this.f241660d = r101.right;
        this.f241663g = r101.bottom;
    L5:
        this.f241659c = 20;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public final void onDrawOver(Canvas r110, RecyclerView r111, RecyclerView.State r112) {
        r110.save();
        int r113 = r111.getChildCount();
        int r100 = 0;
    L3:
        if (r100 >= r113) goto L10;
        View r101 = r111.getChildAt(r100);
        int r102 = r111.getChildAdapterPosition(r101);
        if ((r101 instanceof WikItemLeafView) == false) goto L9;
        if (this.f241664h.a((WikItemLeafView) r101, r102) == false) goto L9;
        SwipeMenuLayout r103 = (SwipeMenuLayout) r101.findViewById(R.id.swipe_menu_layout);
        View r104 = (View) r111.getParent();
        int r105 = r104.getRight();
        int r106 = r104.getScrollX();
        this.f241658b.setBounds((((r105 - r103.getScrollX()) + r106) - n.d(this.f241659c)) - n.d(this.f241661e), r101.getTop(), (r105 - r103.getScrollX()) + r106, r101.getBottom());
        this.f241657a.setBounds((((r105 - r103.getScrollX()) + r106) - n.d(this.f241659c)) - n.d(this.f241660d), r101.getTop() + n.d(this.f241662f), ((r105 - r103.getScrollX()) + r106) - n.d(this.f241660d), r101.getBottom() - n.d(this.f241663g));
        this.f241658b.draw(r110);
        this.f241657a.draw(r110);
    L9:
        r100 = r100 + 1;
        goto L3
    L10:
        r110.restore();
    }
}
