package com.bytedance.ee.bear.bitable.toast;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.LinearInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.ee.util.ui.n;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class b {
    public final FragmentActivity a;
    public final Long b;
    public final InterfaceC0027b c;
    public final View d;
    public final View e;
    public final FrameLayout.LayoutParams f;
    public fv4.b g;
    public c h;
    public Runnable i;

    public static final class a {
    }

    /* JADX INFO: renamed from: com.bytedance.ee.bear.bitable.toast.b$b, reason: collision with other inner class name */
    public interface InterfaceC0027b {
        void a();

        void onTimeout();
    }

    static {
    }

    public static final void a(b r9) {
        ObjectAnimator r0 = ObjectAnimator.ofFloat(r9.d, "alpha", new float[]{1.0f, 0.0f});
        ObjectAnimator r2 = ObjectAnimator.ofFloat(r9.d, "translationY", new float[]{0.0f, n.d(28)});
        r9.d.getTranslationY();
        AnimatorSet r3 = new AnimatorSet();
        r3.setDuration(200);
        r3.addListener(new fv4.c(r9));
        r3.setInterpolator(new LinearInterpolator());
        r3.playTogether(new Animator[]{r0, r2});
        r3.start();
    }

    public b(FragmentActivity r3, Integer r4, String r5, String r6, Long r7, e r8) {
        Intrinsics.checkNotNullParameter(r3, "activity");
        Intrinsics.checkNotNullParameter(r5, "toastContent");
        this.a = r3;
        this.b = r7;
        this.c = r8;
        View r9 = LayoutInflater.from(r3).inflate(2131558839, null);
        this.d = r9;
        TextView r10 = (TextView) r9.findViewById(2131391634);
        TextView r11 = (TextView) r9.findViewById(2131391633);
        ImageView r0 = (ImageView) r9.findViewById(2131376690);
        View r12 = r9.findViewById(2131388946);
        this.e = r12;
        r10.setText(r5);
        if (TextUtils.isEmpty(r6) == true) goto L5;
        r11.setText(r6);
        r11.setVisibility(0);
        r12.setVisibility(0);
        r11.setOnClickListener(new com.bytedance.ee.bear.bitable.toast.a(this));
    L5:
        ToastTypeEnum[] r13 = ToastTypeEnum.values();
        if (r4 == null) goto L8;
        int r14 = r4.intValue();
    L9:
        int r16 = r13[r14].getImageRes();
        if (r16 <= 0) goto L12;
        r0.setVisibility(0);
        r0.setImageResource(r16);
    L12:
        this.f = new FrameLayout.LayoutParams(-1, -1, 81);
        this.g = new fv4.b(this);
        this.h = new c(this);
        return;
    L8:
        r14 = 0;
        goto L9
    }
}
