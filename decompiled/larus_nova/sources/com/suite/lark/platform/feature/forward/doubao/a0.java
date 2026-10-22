package com.suite.lark.platform.feature.forward.doubao;

import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes36.dex */
public final class a0 implements View.OnTouchListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ForwardDoubaoActivity f461276a;

    public a0(ForwardDoubaoActivity r100) {
        this.f461276a = r100;
    }

    @Override // android.view.View.OnTouchListener
    public final boolean onTouch(View r110, MotionEvent r111) {
        if (this.f461276a.f461253b == false) goto L5;
        return false;
    L5:
        int r112 = r111.getActionMasked();
        View r100 = null;
        if (r112 != 0) goto L8;
        ForwardDoubaoActivity r113 = this.f461276a;
        Intrinsics.checkNotNull(r111);
        r113.getClass();
        if (r111.getY() > r113.f461264m) goto L93;
        View r101 = r113.f461263l;
        if (r101 != null) goto L80;
        Intrinsics.throwUninitializedPropertyAccessException("bottomSheetContainer");
        r101 = null;
    L80:
        Integer r102 = Integer.valueOf(r101.getWidth());
        if (r102.intValue() <= 0) goto L83;
        boolean r103 = true;
    L84:
        if (r103 == true) goto L87;
        r102 = null;
    L87:
        if (r102 == null) goto L93;
        int r104 = r102.intValue();
        int r114 = r113.f461265n;
        float r105 = r114;
        float r115 = r104 - r114;
        float r106 = r111.getX();
        if (r105 > r106) goto L93;
        if (r106 > r115) goto L93;
        boolean r116 = true;
    L94:
        if (r116 == true) goto L97;
        this.f461276a.f461257f = false;
        return true;
    L97:
        ForwardDoubaoActivity r117 = this.f461276a;
        r117.f461257f = true;
        VelocityTracker r118 = r117.f461254c;
        if (r118 == null) goto L100;
        r118.recycle();
    L100:
        this.f461276a.f461254c = VelocityTracker.obtain();
        VelocityTracker r119 = this.f461276a.f461254c;
        if (r119 == null) goto L103;
        r119.addMovement(r111);
    L103:
        this.f461276a.f461255d = r111.getRawY();
        ForwardDoubaoActivity r120 = this.f461276a;
        View r121 = r120.f461263l;
        if (r121 != null) goto L106;
        Intrinsics.throwUninitializedPropertyAccessException("bottomSheetContainer");
        r121 = null;
    L106:
        r120.f461256e = r121.getTranslationY();
        ForwardDoubaoActivity r122 = this.f461276a;
        r122.f461258g = false;
        View r123 = r122.f461263l;
        if (r123 != null) goto L109;
        Intrinsics.throwUninitializedPropertyAccessException("bottomSheetContainer");
        r123 = null;
    L109:
        r123.animate().cancel();
        View r124 = this.f461276a.f461262k;
        if (r124 != null) goto L112;
        Intrinsics.throwUninitializedPropertyAccessException("bgMask");
    L113:
        r100.animate().cancel();
    L114:
        return true;
    L112:
        r100 = r124;
        goto L113
    L83:
        r103 = false;
    L93:
        r116 = false;
        goto L94
    L8:
        if (r112 != 1) goto L10;
        ForwardDoubaoActivity r125 = this.f461276a;
        if (r125.f461257f == true) goto L41;
        return true;
    L41:
        VelocityTracker r126 = r125.f461254c;
        if (r126 == null) goto L44;
        r126.addMovement(r111);
    L44:
        VelocityTracker r127 = this.f461276a.f461254c;
        if (r127 == null) goto L47;
        r127.computeCurrentVelocity(1000);
    L47:
        VelocityTracker r128 = this.f461276a.f461254c;
        if (r128 == null) goto L50;
        float r129 = r128.getYVelocity();
    L51:
        VelocityTracker r107 = this.f461276a.f461254c;
        if (r107 == null) goto L54;
        r107.recycle();
    L54:
        ForwardDoubaoActivity r108 = this.f461276a;
        r108.f461254c = null;
        View r109 = r108.f461263l;
        if (r109 != null) goto L57;
        Intrinsics.throwUninitializedPropertyAccessException("bottomSheetContainer");
        r109 = null;
    L57:
        float r130 = r109.getTranslationY();
        float r131 = r111.getRawY();
        ForwardDoubaoActivity r132 = this.f461276a;
        if ((r131 - r132.f461255d) < r132.f461260i) goto L60;
        boolean r133 = true;
    L62:
        if (r132.f461258g == false) goto L69;
        if (r133 == false) goto L69;
        if (r130 <= (r132.f461261j * 0.33f)) goto L67;
    L68:
        boolean r134 = true;
    L70:
        if (r134 == false) goto L72;
        r132.finish();
    L73:
        ForwardDoubaoActivity r135 = this.f461276a;
        r135.f461257f = false;
        r135.f461258g = false;
        goto L114
    L72:
        ForwardDoubaoActivity.A1(r132, 0.0f, 1.0f, null, 12);
        goto L73
    L67:
        if (r129 > 1500.0f) goto L68;
    L69:
        r134 = false;
        goto L70
    L60:
        r133 = false;
        goto L62
    L50:
        r129 = 0.0f;
        goto L51
    L10:
        if (r112 != 2) goto L12;
        ForwardDoubaoActivity r136 = this.f461276a;
        if (r136.f461257f == true) goto L21;
        return true;
    L21:
        VelocityTracker r137 = r136.f461254c;
        if (r137 == null) goto L24;
        r137.addMovement(r111);
    L24:
        float r138 = r111.getRawY();
        ForwardDoubaoActivity r139 = this.f461276a;
        float r140 = r138 - r139.f461255d;
        if (r139.f461258g == false) goto L27;
    L30:
        float r141 = RangesKt.coerceIn(r139.f461256e + r140, 0.0f, r139.f461261j);
        View r142 = this.f461276a.f461263l;
        if (r142 != null) goto L33;
        Intrinsics.throwUninitializedPropertyAccessException("bottomSheetContainer");
        r142 = null;
    L33:
        r142.setTranslationY(r141);
        float r143 = RangesKt.coerceIn(r141 / this.f461276a.f461261j, 0.0f, 1.0f);
        View r144 = this.f461276a.f461262k;
        if (r144 != null) goto L36;
        Intrinsics.throwUninitializedPropertyAccessException("bgMask");
    L37:
        r100.setAlpha(1.0f - r143);
        goto L114
    L36:
        r100 = r144;
        goto L37
    L27:
        if (r140 > r139.f461259h) goto L29;
        return true;
    L29:
        r139.f461258g = true;
        goto L30
    L12:
        if (r112 != 3) goto L116;
        VelocityTracker r145 = this.f461276a.f461254c;
        if (r145 == null) goto L17;
        r145.recycle();
    L17:
        ForwardDoubaoActivity r146 = this.f461276a;
        r146.f461254c = null;
        r146.f461257f = false;
        r146.f461258g = false;
        ForwardDoubaoActivity.A1(r146, 0.0f, 1.0f, null, 12);
        goto L114
    L116:
        return false;
    }
}
