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
import com.bytedance.android.live.core.anim.LiveDegradeFpsAnimator;
import com.bytedance.ee.util.ui.n;
import com.larus.nova.R;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final FragmentActivity f215980a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Long f215981b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final InterfaceC3083b f215982c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final View f215983d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final View f215984e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final FrameLayout.LayoutParams f215985f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public fv4.b f215986g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public c f215987h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public Runnable f215988i;

    public static final class a {
    }

    /* JADX INFO: renamed from: com.bytedance.ee.bear.bitable.toast.b$b, reason: collision with other inner class name */
    public interface InterfaceC3083b {
        void a();

        void onTimeout();
    }

    static {
    }

    public static final void a(b r100) {
        ObjectAnimator r101 = ObjectAnimator.ofFloat(r100.f215983d, "alpha", new float[]{1.0f, 0.0f});
        ObjectAnimator r102 = ObjectAnimator.ofFloat(r100.f215983d, LiveDegradeFpsAnimator.TRANSLATION_Y, new float[]{0.0f, n.d(28)});
        r100.f215983d.getTranslationY();
        AnimatorSet r103 = new AnimatorSet();
        r103.setDuration(200);
        r103.addListener(new fv4.c(r100));
        r103.setInterpolator(new LinearInterpolator());
        r103.playTogether(new Animator[]{r101, r102});
        r103.start();
    }

    public b(FragmentActivity r100, Integer r101, String r102, String r103, Long r104, e r105) {
        Intrinsics.checkNotNullParameter(r100, "activity");
        Intrinsics.checkNotNullParameter(r102, "toastContent");
        this.f215980a = r100;
        this.f215981b = r104;
        this.f215982c = r105;
        View r106 = LayoutInflater.from(r100).inflate(R.layout.bitable_card_clickable_toast, null);
        this.f215983d = r106;
        TextView r107 = (TextView) r106.findViewById(R.id.tv_toast_content);
        TextView r108 = (TextView) r106.findViewById(R.id.tv_toast_action);
        ImageView r109 = (ImageView) r106.findViewById(R.id.iv_toast_icon);
        View r110 = r106.findViewById(R.id.toast_divider);
        this.f215984e = r110;
        r107.setText(r102);
        if (TextUtils.isEmpty(r103) == true) goto L5;
        r108.setText(r103);
        r108.setVisibility(0);
        r110.setVisibility(0);
        r108.setOnClickListener(new com.bytedance.ee.bear.bitable.toast.a(this));
    L5:
        ToastTypeEnum[] r111 = ToastTypeEnum.values();
        if (r101 == null) goto L8;
        int r112 = r101.intValue();
    L9:
        int r113 = r111[r112].getImageRes();
        if (r113 <= 0) goto L12;
        r109.setVisibility(0);
        r109.setImageResource(r113);
    L12:
        this.f215985f = new FrameLayout.LayoutParams(-1, -1, 81);
        this.f215986g = new fv4.b(this);
        this.f215987h = new c(this);
        return;
    L8:
        r112 = 0;
        goto L9
    }
}
