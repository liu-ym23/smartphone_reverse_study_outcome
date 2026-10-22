package com.ss.android.lark.flow.chat.creategroup.page;

import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.widget.EditText;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes36.dex */
public final class b implements View.OnTouchListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ FlowGroupCreateActivity f422097a;

    public b(FlowGroupCreateActivity r100) {
        this.f422097a = r100;
    }

    @Override // android.view.View.OnTouchListener
    public final boolean onTouch(View r110, MotionEvent r111) {
        boolean r100 = false;
        if (this.f422097a.f422067c == false) goto L5;
        return false;
    L5:
        int r112 = r111.getActionMasked();
        View r101 = null;
        if (r112 != 0) goto L8;
        float r113 = r111.getY();
        FlowGroupCreateActivity r102 = this.f422097a;
        if (r113 <= r102.f422075k) goto L67;
        return false;
    L67:
        VelocityTracker r114 = r102.f422068d;
        if (r114 == null) goto L70;
        r114.recycle();
    L70:
        this.f422097a.f422068d = VelocityTracker.obtain();
        VelocityTracker r115 = this.f422097a.f422068d;
        if (r115 == null) goto L73;
        r115.addMovement(r111);
    L73:
        this.f422097a.f422069e = r111.getRawY();
        FlowGroupCreateActivity r116 = this.f422097a;
        View r117 = r116.f422074j;
        if (r117 != null) goto L76;
        Intrinsics.throwUninitializedPropertyAccessException("bottomSheetContainer");
        r117 = null;
    L76:
        r116.f422070f = r117.getTranslationY();
        View r118 = this.f422097a.f422074j;
        if (r118 != null) goto L79;
        Intrinsics.throwUninitializedPropertyAccessException("bottomSheetContainer");
        r118 = null;
    L79:
        r118.animate().cancel();
        View r119 = this.f422097a.f422073i;
        if (r119 != null) goto L82;
        Intrinsics.throwUninitializedPropertyAccessException("bgMask");
    L83:
        r101.animate().cancel();
    L84:
        return true;
    L82:
        r101 = r119;
        goto L83
    L8:
        if (r112 != 1) goto L10;
    L40:
        VelocityTracker r120 = this.f422097a.f422068d;
        if (r120 == null) goto L43;
        r120.addMovement(r111);
    L43:
        VelocityTracker r121 = this.f422097a.f422068d;
        if (r121 == null) goto L46;
        r121.computeCurrentVelocity(1000);
    L46:
        VelocityTracker r122 = this.f422097a.f422068d;
        if (r122 == null) goto L49;
        float r123 = r122.getYVelocity();
    L50:
        VelocityTracker r124 = this.f422097a.f422068d;
        if (r124 == null) goto L53;
        r124.recycle();
    L53:
        FlowGroupCreateActivity r125 = this.f422097a;
        r125.f422068d = null;
        View r126 = r125.f422074j;
        if (r126 != null) goto L56;
        Intrinsics.throwUninitializedPropertyAccessException("bottomSheetContainer");
        r126 = null;
    L56:
        float r127 = r126.getTranslationY();
        FlowGroupCreateActivity r103 = this.f422097a;
        if (r127 <= (r103.f422072h * 0.33f)) goto L59;
    L60:
        r100 = true;
    L61:
        if (r100 == false) goto L63;
        FlowGroupCreateActivity.z1(r103);
        this.f422097a.finish();
        goto L84
    L63:
        r103.A1(0.0f, 1.0f, null);
        goto L84
    L59:
        if (r123 <= 1500.0f) goto L61;
    L49:
        r123 = 0.0f;
        goto L50
    L10:
        if (r112 != 2) goto L12;
        VelocityTracker r128 = this.f422097a.f422068d;
        if (r128 == null) goto L17;
        r128.addMovement(r111);
    L17:
        float r129 = r111.getRawY() - this.f422097a.f422069e;
        float r130 = Math.abs(r129);
        FlowGroupCreateActivity r104 = this.f422097a;
        if (r130 >= r104.f422071g) goto L28;
        View r131 = r104.f422074j;
        if (r131 != null) goto L23;
        Intrinsics.throwUninitializedPropertyAccessException("bottomSheetContainer");
        r131 = null;
    L23:
        if (r131.getTranslationY() != this.f422097a.f422070f) goto L25;
        boolean r132 = true;
    L26:
        if (r132 == false) goto L28;
        return false;
    L25:
        r132 = false;
    L28:
        FlowGroupCreateActivity r133 = this.f422097a;
        float r134 = RangesKt.coerceIn(r133.f422070f + r129, 0.0f, r133.f422072h);
        View r135 = this.f422097a.f422074j;
        if (r135 != null) goto L31;
        Intrinsics.throwUninitializedPropertyAccessException("bottomSheetContainer");
        r135 = null;
    L31:
        r135.setTranslationY(r134);
        float r136 = RangesKt.coerceIn(r134 / this.f422097a.f422072h, 0.0f, 1.0f);
        View r137 = this.f422097a.f422073i;
        if (r137 != null) goto L34;
        Intrinsics.throwUninitializedPropertyAccessException("bgMask");
    L35:
        r101.setAlpha(1.0f - r136);
        View r138 = this.f422097a.getCurrentFocus();
        if ((r138 instanceof EditText) == false) goto L84;
        EditText r139 = (EditText) r138;
        if (r139.isFocused() == false) goto L84;
        FlowGroupCreateActivity.z1(this.f422097a);
        r139.clearFocus();
        goto L84
    L34:
        r101 = r137;
        goto L35
    L12:
        if (r112 == 3) goto L40;
        return false;
    }
}
