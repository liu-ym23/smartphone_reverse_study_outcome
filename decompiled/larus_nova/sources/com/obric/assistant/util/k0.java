package com.obric.assistant.util;

import android.graphics.PointF;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.data.ObricFloatChatPageData;
import com.obric.assistant.data.ObricFloatChatPageState;
import com.obric.assistant.view.ObricSwipeGestureView;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes33.dex */
public final class k0 implements ObricSwipeGestureView.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ j0 f393755a;

    public k0(j0 r100) {
        this.f393755a = r100;
    }

    @Override // com.obric.assistant.view.ObricSwipeGestureView.c
    public final void E(float r100) {
        ObricFloatChatPageData.a r101 = ObricFloatChatPageData.Companion;
        ObricFloatChatPageState r102 = this.f393755a.g();
        r101.getClass();
        if ((r102 instanceof vda.d) == false) goto L5;
        return;
    L5:
        if ((this.f393755a.g() instanceof vda.b) == true) goto L17;
        j0 r103 = this.f393755a;
        if (r103.f393737k == false) goto L11;
        return;
    L11:
        if (r103.f393728b.UR("onSwipe") == false) goto L14;
        this.f393755a.h();
        return;
    L14:
        j0.a(this.f393755a, r100, 0.0f, false);
        return;
    }

    @Override // com.obric.assistant.view.ObricSwipeGestureView.c
    public final void F4(PointF r110) {
        Intrinsics.checkNotNullParameter(r110, "pointF");
        j0 r100 = this.f393755a;
        PointF r101 = new PointF(r110.x, r110.y);
        r100.getClass();
        FLogger.f375446a.i("AutoIncreaseUtils", "onClickTitleBar, downPoint = " + r101);
        ViewGroup r111 = r100.f393728b.getTitleContainer();
        if (r111 != null) goto L5;
    L10:
        boolean r112 = false;
    L11:
        if (r112 == false) goto L50;
        ViewGroup r113 = r100.f393728b.getTitleContainer();
        if (r113 == null) goto L43;
        int r102 = r113.getChildCount();
        int r103 = 0;
    L16:
        if (r103 >= r102) goto L51;
        View r104 = r113.getChildAt(r103);
        if (r104.getVisibility() != 0) goto L20;
        boolean r105 = true;
    L21:
        if (r105 == false) goto L42;
        if (r104.getAlpha() != 1.0f) goto L25;
        boolean r106 = true;
    L26:
        if (r106 == false) goto L42;
        float r107 = r104.getX();
        float r108 = r104.getX() + r104.getWidth();
        float r109 = r101.x;
        if (r107 <= r109) goto L30;
    L32:
        boolean r114 = false;
    L33:
        if (r114 == false) goto L42;
        float r115 = r104.getY();
        float r116 = r104.getY() + r104.getHeight();
        float r117 = r101.y;
        if (r115 <= r117) goto L37;
    L39:
        boolean r118 = false;
    L40:
        if (r118 == false) goto L42;
        r104.performClick();
        goto L42
    L37:
        if (r117 > r116) goto L39;
        r118 = true;
        goto L40
    L30:
        if (r109 > r108) goto L32;
        r114 = true;
        goto L33
    L25:
        r106 = false;
    L42:
        FLogger.f375446a.i("AutoIncreaseUtils", "onClickTitleBar, it is " + r104 + ", \nrect is " + r104.getX() + ", " + r104.getY() + ", " + (r104.getX() + r104.getWidth()) + ", " + (r104.getY() + r104.getHeight()));
        r103 = r103 + 1;
        goto L16
    L20:
        r105 = false;
        goto L21
    L51:
        return;
    L43:
        return;
    L50:
        return;
    L5:
        if (r111.getVisibility() != 0) goto L7;
        boolean r119 = true;
    L8:
        if (r119 != true) goto L10;
        r112 = true;
        goto L11
    L7:
        r119 = false;
        goto L8
    }

    @Override // com.obric.assistant.view.ObricSwipeGestureView.c
    public final void onDown(MotionEvent r100) {
        Intrinsics.checkNotNullParameter(r100, "e");
        j0 r101 = this.f393755a;
        r101.f393737k = false;
        if (r101.f393728b.G1() != this.f393755a.g().getHeight()) goto L6;
        j0 r102 = this.f393755a;
        r102.f393735i = r102.f393728b.G1();
        return;
    }

    @Override // com.obric.assistant.view.ObricSwipeGestureView.c
    public final void s5(float r100, float r101) {
        j0 r102 = this.f393755a;
        if (r102.f393737k == false) goto L6;
        return;
    L6:
        if (r102.f393728b.UR("onSwipeFinish") == false) goto L9;
        this.f393755a.h();
        return;
    L9:
        j0.a(this.f393755a, r100, r101, true);
    }
}
