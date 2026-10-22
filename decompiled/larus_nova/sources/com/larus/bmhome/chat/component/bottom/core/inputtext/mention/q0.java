package com.larus.bmhome.chat.component.bottom.core.inputtext.mention;

import android.content.Context;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.larus.bmhome.chat.component.bottom.core.inputtext.panel.InputPanelDragController;
import com.larus.nova.R;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import v19.c7;

/* JADX INFO: loaded from: classes25.dex */
public final class q0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final MentionPanelListView f298954a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final com.larus.bmhome.chat.component.bottom.core.inputtext.panel.n f298955b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final TextView f298956c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final InputPanelDragController f298957d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f298958e;

    public final void b() {
        MentionPanelListView r100 = this.f298954a;
        if (r100.f298823h != null) goto L31;
        Integer r101 = Integer.valueOf(r100.f298836u.getHeight());
        boolean r102 = false;
        if (r101.intValue() <= 0) goto L8;
        boolean r103 = true;
    L9:
        Integer r104 = null;
        if (r103 == true) goto L13;
        r101 = null;
    L13:
        if (r101 != null) goto L28;
        ViewGroup.LayoutParams r105 = r100.f298836u.getLayoutParams();
        if (r105 == null) goto L22;
        r101 = Integer.valueOf(r105.height);
        if (r101.intValue() <= 0) goto L19;
        boolean r106 = true;
    L20:
        if (r106 == false) goto L22;
    L23:
        if (r101 != null) goto L28;
        r101 = Integer.valueOf(r100.f298824i);
        if (r101.intValue() <= 0) goto L27;
        r102 = true;
    L27:
        if (r102 == true) goto L28;
    L29:
        r100.f298823h = r104;
        return;
    L19:
        r106 = false;
    L22:
        r101 = null;
    L28:
        r104 = r101;
        goto L29
    L8:
        r103 = false;
        goto L9
    }

    public final MentionPanelListView.f a(MentionPanelSection r110) {
        Intrinsics.checkNotNullParameter(r110, "section");
        MentionPanelListView r100 = this.f298954a;
        r100.getClass();
        Intrinsics.checkNotNullParameter(r110, "section");
        r100.f298836u.stopScroll();
        RecyclerView.LayoutManager r101 = r100.f298836u.getLayoutManager();
        if ((r101 instanceof LinearLayoutManager) == false) goto L5;
        LinearLayoutManager r102 = (LinearLayoutManager) r101;
    L6:
        if (r102 == null) goto L63;
        int r103 = r100.f298836u.getPaddingTop() + r100.f298820e;
        int r104 = r100.f298836u.getChildCount();
        int r105 = Integer.MAX_VALUE;
        MentionPanelListView.f r106 = null;
        int r107 = 0;
    L9:
        if (r107 >= r104) goto L53;
        View r108 = r100.f298836u.getChildAt(r107);
        int r111 = r102.getDecoratedTop(r108);
        if (r111 < r103) goto L51;
        if (r111 >= r100.f298836u.getHeight()) goto L51;
        if (r111 >= r105) goto L51;
        int r109 = r100.f298836u.getChildAdapterPosition(r108);
        Object r112 = CollectionsKt.getOrNull(r100.f298819d.f298837a, r109);
        if ((r112 instanceof y.d) == false) goto L19;
        y.d r113 = (y.d) r112;
    L20:
        if (r113 == null) goto L22;
        g0 r114 = r113.f298980c;
    L23:
        if (r114 == null) goto L51;
        boolean r115 = true;
        if (r114.f298918a != r110) goto L27;
        boolean r116 = true;
    L28:
        if (r116 == true) goto L31;
        r114 = null;
    L31:
        if (r114 == null) goto L51;
        MentionPanelListView.PanelAdapter r117 = r100.f298819d;
    L34:
        if ((-1) >= r109) goto L39;
        if ((CollectionsKt.getOrNull(r117.f298837a, r109) instanceof y.a) == true) goto L37;
        r109 = r109 - 1;
        goto L34
    L37:
        Integer r118 = Integer.valueOf(r109);
    L40:
        if (r118 == null) goto L42;
        View r119 = r102.findViewByPosition(r118.intValue());
    L43:
        int r120 = r111 - r100.f298836u.getPaddingTop();
        if (r118 == null) goto L49;
        if (r119 != null) goto L47;
    L50:
        r106 = new MentionPanelListView.f(r114, r120, r115);
        r105 = r111;
        goto L51
    L47:
        if (r119.getTop() <= r100.f298836u.getPaddingTop()) goto L50;
    L49:
        r115 = false;
        goto L50
    L42:
        r119 = null;
        goto L43
    L39:
        r117.getClass();
        r118 = null;
        goto L40
    L27:
        r116 = false;
        goto L28
    L22:
        r114 = null;
        goto L23
    L19:
        r113 = null;
    L51:
        r107 = r107 + 1;
        goto L9
    L53:
        return r106;
    L63:
        return null;
    L5:
        r102 = null;
        goto L6
    }

    public final void c(MentionPanelListView.f r100) {
        MentionPanelListView r101 = this.f298954a;
        r101.f(true);
        if (r100 != null) goto L5;
    L7:
        MentionPanelListView.f r102 = null;
    L8:
        r101.f298831p = r102;
        r101.d(r100);
        return;
    L5:
        if (r100.f298854c == false) goto L7;
        r102 = r100;
        goto L8
    }

    public q0(ViewGroup r110, final com.larus.bmhome.chat.component.bottom.core.inputtext.t0 r111) {
        Intrinsics.checkNotNullParameter(r110, "panelContainer");
        Intrinsics.checkNotNullParameter(r111, "onCloseClick");
        Context r100 = r110.getContext();
        MentionPanelListView r101 = new MentionPanelListView(r100, new MentionPanelView$listView$1(this));
        this.f298954a = r101;
        com.larus.bmhome.chat.component.bottom.core.inputtext.panel.n r102 = new com.larus.bmhome.chat.component.bottom.core.inputtext.panel.n(r100);
        r102.setVisibility(8);
        this.f298955b = r102;
        View r103 = LayoutInflater.from(r100).inflate(R.layout.larus_item_panel_header, r102, false);
        Intrinsics.checkNotNull(r103, "null cannot be cast to non-null type android.widget.TextView");
        TextView r104 = (TextView) r103;
        r104.setVisibility(8);
        r104.setTypeface(Typeface.create("sans-serif-medium", 0));
        r104.setPaddingRelative(r104.getPaddingStart(), r104.getPaddingTop() + r101.f298835t, r104.getPaddingEnd(), r104.getPaddingBottom());
        this.f298956c = r104;
        r102.addView(r101.f298836u, new FrameLayout.LayoutParams(-1, -1));
        ViewGroup.LayoutParams r105 = r104.getLayoutParams();
        Intrinsics.checkNotNull(r105, "null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
        FrameLayout.LayoutParams r106 = (FrameLayout.LayoutParams) r105;
        r106.topMargin = 0;
        r106.height += r101.f298835t;
        Unit r107 = Unit.INSTANCE;
        r102.addView(r104, r106);
        ImageView r108 = new ImageView(r100);
        r108.setImageResource(R.drawable.larus_ic_icon_reply_close);
        r108.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        r108.setContentDescription("关闭");
        FrameLayout.LayoutParams r109 = new FrameLayout.LayoutParams(c7.b(24), c7.b(24));
        r109.gravity = 8388661;
        r109.topMargin = c7.b(16);
        r109.setMarginEnd(c7.b(16));
        r108.setLayoutParams(r109);
        r108.setOnClickListener(new p0(r111));
        r102.addView(r108);
        r110.addView(r102, new FrameLayout.LayoutParams(-1, -2));
        this.f298957d = new InputPanelDragController(r102, r101.f298836u, new MentionPanelView$2(r101), r111, new o0(this), new MentionPanelView$3(r101));
    }
}
