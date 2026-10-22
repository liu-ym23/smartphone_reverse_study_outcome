package com.ss.android.lark.officesdk.minutes.ui.record.recording.ainote;

import android.animation.ValueAnimator;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import kotlin.NoWhenBranchMatchedException;

/* JADX INFO: loaded from: classes37.dex */
public final class m implements View.OnTouchListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ MmAINotePanelAnimator f436099a;

    public m(MmAINotePanelAnimator r100) {
        this.f436099a = r100;
    }

    @Override // android.view.View.OnTouchListener
    public final boolean onTouch(View r100, MotionEvent r101) {
        MmAINotePanelAnimator r102 = this.f436099a;
        VelocityTracker r103 = r102.F;
        if (r103 != null) goto L5;
        r103 = VelocityTracker.obtain();
        r102.F = r103;
    L5:
        r103.addMovement(r101);
        int r104 = r101.getActionMasked();
        boolean r105 = false;
        if (r104 == 0) goto L57;
        float r106 = 0.0f;
        if (r104 != 1) goto L10;
    L41:
        MmAINotePanelAnimator r107 = this.f436099a;
        if (r107.f435992y == false) goto L48;
        float r108 = r101.getRawY();
        MmAINotePanelAnimator r109 = this.f436099a;
        float r110 = r108 - r109.A;
        VelocityTracker r111 = r109.F;
        if (r111 == null) goto L47;
        r111.computeCurrentVelocity(1000);
        r106 = r111.getYVelocity();
    L47:
        r107.D(r110, r106);
    L48:
        MmAINotePanelAnimator r112 = this.f436099a;
        r112.f435992y = false;
        r112.B = false;
        if (r112.f435988u == 0) goto L51;
    L53:
        VelocityTracker r113 = r112.F;
        if (r113 == null) goto L56;
        r113.recycle();
    L56:
        r112.F = null;
    L58:
        return true;
    L51:
        if (r112.L == false) goto L53;
        r112.L = false;
        goto L53
    L10:
        if (r104 == 2) goto L13;
        if (r104 == 3) goto L41;
        return false;
    L13:
        float r114 = r101.getRawY();
        MmAINotePanelAnimator r115 = this.f436099a;
        float r116 = r114 - r115.A;
        if (r115.f435992y == true) goto L38;
        float r117 = Math.abs(r116);
        MmAINotePanelAnimator r118 = this.f436099a;
        if (r117 <= r118.f435979l) goto L38;
        MmAINoteSheetState r119 = r118.f435982o;
        int r120 = MmAINotePanelAnimator.e.f436000b[r119.ordinal()];
        if (r120 == 1) goto L26;
        if (r120 == 2) goto L24;
        if (r120 != 3) goto L23;
    L30:
        if (r105 == false) goto L38;
        ValueAnimator r121 = this.f436099a.f435984q;
        if (r121 == null) goto L34;
        r121.cancel();
    L34:
        ValueAnimator r122 = this.f436099a.f435985r;
        if (r122 == null) goto L37;
        r122.cancel();
    L37:
        this.f436099a.y("header");
        MmAINotePanelAnimator r123 = this.f436099a;
        r123.f435993z = r123.m();
        MmAINotePanelAnimator r124 = this.f436099a;
        r124.B(r124.f435993z);
        this.f436099a.i();
        this.f436099a.f435992y = true;
        goto L38
    L23:
        throw new NoWhenBranchMatchedException();
    L24:
        r105 = r118.B;
        goto L30
    L26:
        if (r118.B == false) goto L30;
        if (r116 <= 0.0f) goto L30;
        r105 = true;
    L38:
        MmAINotePanelAnimator r125 = this.f436099a;
        if (r125.f435992y == false) goto L58;
        r125.G(r116);
        goto L58
    L57:
        MmAINotePanelAnimator r126 = this.f436099a;
        r126.A = r101.getRawY();
        MmAINotePanelAnimator r127 = this.f436099a;
        r127.f435993z = r127.m();
        MmAINotePanelAnimator r128 = this.f436099a;
        r128.B(r128.f435993z);
        MmAINotePanelAnimator r129 = this.f436099a;
        r129.B = true;
        r129.f435992y = false;
        goto L58
    }
}
