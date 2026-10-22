package yl0;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import com.bytedance.android.live.core.anim.LiveDegradeFpsAnimator;
import kotlin.TuplesKt;
import kotlin.Unit;

/* JADX INFO: loaded from: classes46.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f568302a = 0;

    static {
    }

    public static Animator a(Integer r110, boolean r111, View r112) {
        if (r110 != null) goto L6;
    L35:
        if (r110 != null) goto L38;
    L55:
        return null;
    L38:
        if (r110.intValue() != 1) goto L55;
        Float r113 = Float.valueOf(0.0f);
        if (r112 == null) goto L42;
        r112.setPivotX(0.0f);
    L42:
        if (r112 == null) goto L52;
        if (r112.getHeight() != 0) goto L49;
        ViewGroup.LayoutParams r100 = r112.getLayoutParams();
        if (r100 == null) goto L48;
        int r101 = r100.height;
    L50:
        r112.setPivotY(r101);
        goto L52
    L48:
        r101 = 0;
        goto L50
    L49:
        r101 = r112.getHeight();
    L52:
        if (r111 == false) goto L54;
        AnimatorSet r114 = new AnimatorSet();
        ObjectAnimator r115 = ObjectAnimator.ofFloat(r112, "alpha", new float[]{0.05f, 1.0f});
        r115.setDuration(250);
        Unit r116 = Unit.INSTANCE;
        r114.playTogether(new Animator[]{b.a(r112, 250, TuplesKt.to(r113, Float.valueOf(1.03f)), 140, TuplesKt.to(Float.valueOf(1.03f), Float.valueOf(1.0f))), r115});
        r114.setInterpolator(new AccelerateInterpolator());
        return r114;
    L54:
        Animator r117 = b.a(r112, 120, TuplesKt.to(Float.valueOf(1.0f), Float.valueOf(1.03f)), 160, TuplesKt.to(Float.valueOf(1.03f), r113));
        r117.setInterpolator(new AccelerateInterpolator());
        return r117;
    L6:
        if (r110.intValue() != 0) goto L35;
        if (r111 == false) goto L22;
        AnimatorSet r118 = new AnimatorSet();
        if (r112 == null) goto L12;
        r112.setPivotX(0.0f);
    L12:
        if (r112 != null) goto L14;
    L21:
        r118.playTogether(new Animator[]{ObjectAnimator.ofFloat(r112, LiveDegradeFpsAnimator.SCALE_X, new float[]{0.0f, 1.0f}), ObjectAnimator.ofFloat(r112, LiveDegradeFpsAnimator.SCALE_Y, new float[]{0.0f, 1.0f})});
        r118.setDuration(360);
        return r118;
    L14:
        if (r112.getHeight() != 0) goto L19;
        ViewGroup.LayoutParams r102 = r112.getLayoutParams();
        if (r102 == null) goto L18;
        int r103 = r102.height;
    L20:
        r112.setPivotY(r103 * 0.8f);
        goto L21
    L18:
        r103 = 0;
        goto L20
    L19:
        r103 = r112.getHeight();
        goto L20
    L22:
        AnimatorSet r119 = new AnimatorSet();
        if (r112 == null) goto L25;
        r112.setPivotX(0.0f);
    L25:
        if (r112 != null) goto L27;
    L34:
        r119.playTogether(new Animator[]{ObjectAnimator.ofFloat(r112, LiveDegradeFpsAnimator.SCALE_X, new float[]{1.0f, 0.0f}), ObjectAnimator.ofFloat(r112, LiveDegradeFpsAnimator.SCALE_Y, new float[]{1.0f, 0.0f})});
        r119.setDuration(440);
        return r119;
    L27:
        if (r112.getHeight() != 0) goto L32;
        ViewGroup.LayoutParams r104 = r112.getLayoutParams();
        if (r104 == null) goto L31;
        int r105 = r104.height;
    L33:
        r112.setPivotY(r105 * 0.8f);
        goto L34
    L31:
        r105 = 0;
        goto L33
    L32:
        r105 = r112.getHeight();
        goto L33
    }
}
