package com.bytedance.ee.bear.bitable.app;

import android.animation.ObjectAnimator;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.widget.FrameLayout;
import com.bytedance.android.live.core.anim.LiveDegradeFpsAnimator;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes15.dex */
public final class b implements View.OnTouchListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ BitableAppDrawerManager f206862a;

    public b(BitableAppDrawerManager r100) {
        this.f206862a = r100;
    }

    @Override // android.view.View.OnTouchListener
    public final boolean onTouch(View r110, MotionEvent r111) {
        BitableAppDrawerManager r100 = this.f206862a;
        FrameLayout r101 = r100.f206810i;
        if (r101 != null) goto L5;
        return false;
    L5:
        View r102 = r100.f206811j;
        if (r102 != null) goto L8;
        return false;
    L8:
        View r103 = r100.f206813l;
        int r104 = r111.getActionMasked();
        if (r104 != 0) goto L11;
        this.f206862a.f206817p = r111.getRawX();
        this.f206862a.f206818q = r111.getRawY();
        this.f206862a.f206819r = false;
        return true;
    L11:
        if (r104 == 1) goto L29;
        if (r104 == 2) goto L15;
        if (r104 == 3) goto L29;
        return true;
    L15:
        float r112 = r111.getRawX() - this.f206862a.f206817p;
        float r113 = r111.getRawY();
        BitableAppDrawerManager r105 = this.f206862a;
        float r114 = r113 - r105.f206818q;
        if (r105.f206819r == false) goto L18;
    L22:
        BitableAppDrawerManager r115 = this.f206862a;
        if (r115.f206819r == true) goto L25;
        return true;
    L25:
        float r116 = RangesKt.coerceIn(r112, -r115.f206814m, 0.0f);
        r101.setTranslationX(r116);
        float r117 = this.f206862a.f206814m;
        float r118 = RangesKt.coerceIn(r116 + r117, 0.0f, r117);
        r102.setTranslationX(r118);
        if (r103 == null) goto L28;
        r103.setTranslationX(r118);
    L28:
        return true;
    L18:
        if (Math.abs(r112) <= ((Number) this.f206862a.f206816o.getValue()).intValue()) goto L20;
    L21:
        this.f206862a.f206819r = true;
        goto L22
    L20:
        if (Math.abs(r114) <= ((Number) this.f206862a.f206816o.getValue()).intValue()) goto L22;
    L29:
        float r119 = r111.getRawX();
        BitableAppDrawerManager r106 = this.f206862a;
        float r120 = r119 - r106.f206817p;
        if (r106.f206819r == true) goto L33;
        r106.f206822u.onClick(r110);
        return true;
    L33:
        float r121 = Math.abs(r120);
        BitableAppDrawerManager r107 = this.f206862a;
        if (r121 > (r107.f206814m / 2.0f)) goto L36;
    L38:
        boolean r122 = false;
    L39:
        if (r122 == false) goto L41;
        r107.y();
    L49:
        return true;
    L41:
        ObjectAnimator r123 = ObjectAnimator.ofFloat(r101, LiveDegradeFpsAnimator.TRANSLATION_X, new float[]{r101.getTranslationX(), 0.0f});
        ObjectAnimator r108 = ObjectAnimator.ofFloat(r102, LiveDegradeFpsAnimator.TRANSLATION_X, new float[]{r102.getTranslationX(), this.f206862a.f206814m});
        if (r103 == null) goto L44;
        ObjectAnimator r124 = ObjectAnimator.ofFloat(r103, LiveDegradeFpsAnimator.TRANSLATION_X, new float[]{r103.getTranslationX(), this.f206862a.f206814m});
    L45:
        List r125 = CollectionsKt.listOfNotNull(new ObjectAnimator[]{r123, r108, r124});
        BitableAppDrawerManager r126 = this.f206862a;
        Iterator r127 = r125.iterator();
    L47:
        if (r127.hasNext() == false) goto L49;
        ObjectAnimator r109 = (ObjectAnimator) r127.next();
        r109.setDuration(250);
        r109.setInterpolator(new AccelerateInterpolator());
        r126.g(r109);
        goto L47
    L44:
        r124 = null;
        goto L45
    L36:
        if (r120 >= 0.0f) goto L38;
        r122 = true;
        goto L39
    }
}
