package com.suite.lark.platform.component.widget.floatingpanel.impl.view;

import android.view.View;
import com.ss.android.lark.statistics.Statistics;
import com.suite.lark.platform.component.widget.floatingpanel.impl.FloatPanelHitPoint;
import kotlin.jvm.internal.Intrinsics;
import z5c.b0;
import z5c.l2;

/* JADX INFO: loaded from: classes36.dex */
public final class c implements FloatingPanelScrollView.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ FloatingCardContainer f460783a;

    public c(FloatingCardContainer r100) {
        this.f460783a = r100;
    }

    @Override // com.suite.lark.platform.component.widget.floatingpanel.impl.view.FloatingPanelScrollView.a
    public final void a(FloatingPanelScrollView r100, int r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, "view");
        if (r100.getChildCount() == 0) goto L37;
        FloatingCardContainer r103 = this.f460783a;
        if (r103.f460731d == r103.getChildCount()) goto L40;
        int r104 = 0;
        int r105 = (r100.getChildAt(0).getHeight() - r100.getHeight()) - r101;
        if (r101 > r102) goto L10;
        return;
    L10:
        if (r105 < r100.getHeight()) goto L12;
        return;
    L12:
        if (this.f460783a.f460730c != 0) goto L14;
        int r106 = 15;
    L15:
        int r107 = this.f460783a.getChildCount();
        int r108 = 0;
        int r109 = 0;
    L16:
        if (r104 >= r107) goto L30;
        View r110 = this.f460783a.getChildAt(r104);
        if ((r110 instanceof d) == false) goto L20;
        d r111 = (d) r110;
    L21:
        if (r111 == null) goto L29;
        if (r111.b() == false) goto L28;
        r109 = r109 + 1;
        if (r109 < r106) goto L29;
    L28:
        r108 = r108 + 1;
    L29:
        r104 = r104 + 1;
        goto L16
    L20:
        r111 = null;
    L30:
        this.f460783a.f460731d = r108 + r109;
        Long r112 = FloatPanelHitPoint.f460654a;
        Statistics.sendEvent("im_floating_panel_scroll_load_more_click", s5c.d.b.b(b0.f570156c.a(String.valueOf(r108)), l2.f570244c.a(String.valueOf(r109))).toJson());
        return;
    L14:
        r106 = (int) Math.ceil((r100.getHeight() * 1.0f) / this.f460783a.f460730c);
        goto L15
    L40:
        return;
    }
}
