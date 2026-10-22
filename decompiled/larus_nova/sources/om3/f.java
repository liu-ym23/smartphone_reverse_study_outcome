package om3;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.view.animation.AccelerateDecelerateInterpolator;
import com.alibaba.gaiax.template.GXTemplateKey;
import com.bytedance.android.live.core.anim.LiveDegradeFpsAnimator;
import com.bytedance.android.uicomponent.popover.PopLayout;
import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public final class f implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ e f524285a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ PopLayout f524286b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ boolean f524287c;

    public static final class a extends AnimatorListenerAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ f f524288a;

        public a(f r100) {
            this.f524288a = r100;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator r100) {
            Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
            super.onAnimationEnd(r100);
            f r101 = this.f524288a;
            if (r101.f524287c == true) goto L9;
            r101.f524286b.setVisibility(8);
            e.c r102 = this.f524288a.f524285a.f524268l;
            if (r102 == null) goto L7;
            r102.bubbleDismiss();
        L7:
            this.f524288a.f524285a.c();
            return;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationStart(Animator r100) {
            Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
            super.onAnimationStart(r100);
            f r101 = this.f524288a;
            if (r101.f524287c == false) goto L6;
            e r102 = r101.f524285a;
            int r103 = e.f524256n;
            r102.getClass();
            this.f524288a.f524286b.setVisibility(0);
            return;
        }
    }

    public f(e r100, PopLayout r101, boolean r102) {
        this.f524285a = r100;
        this.f524286b = r101;
        this.f524287c = r102;
    }

    public final void a() {
        e r100 = this.f524285a;
        if (r100.f524266j != null) goto L5;
        return;
    L5:
        int r101 = r100.f524257a;
        if (r101 == 3) goto L23;
        if (r101 == 5) goto L19;
        if (r101 == 48) goto L15;
        if (r101 == 80) goto L11;
        int r102 = 0;
        int r103 = 0;
    L30:
        this.f524286b.setPivotY(r103);
        this.f524286b.setPivotX(r102);
        PopLayout r104 = this.f524286b;
        float[] r105 = new float[2];
        boolean r106 = this.f524287c;
        float r110 = 1.0f;
        if (r106 == false) goto L33;
        float r111 = 0.0f;
    L34:
        r105[0] = r111;
        if (r106 == false) goto L37;
        float r107 = 1.0f;
    L38:
        r105[1] = r107;
        ObjectAnimator r108 = ObjectAnimator.ofFloat(r104, LiveDegradeFpsAnimator.SCALE_X, r105);
        long r109 = 200;
        r108.setDuration(200);
        PopLayout r112 = this.f524286b;
        float[] r113 = new float[2];
        boolean r114 = this.f524287c;
        if (r114 == false) goto L41;
        float r115 = 0.0f;
    L42:
        r113[0] = r115;
        if (r114 == true) goto L46;
        r110 = 0.0f;
    L46:
        r113[1] = r110;
        ObjectAnimator r116 = ObjectAnimator.ofFloat(r112, LiveDegradeFpsAnimator.SCALE_Y, r113);
        r116.setDuration(200);
        ObjectAnimator r117 = ObjectAnimator.ofFloat(this.f524286b, LiveDegradeFpsAnimator.TRANSLATION_Y, new float[]{0.0f});
        if (this.f524287c == false) goto L49;
        r109 = 500;
    L49:
        r117.setDuration(r109);
        ObjectAnimator r118 = ObjectAnimator.ofFloat(this.f524286b, LiveDegradeFpsAnimator.TRANSLATION_Y, new float[]{0.0f});
        if (this.f524287c == false) goto L52;
        long r119 = 500;
    L53:
        r118.setDuration(r119);
        ObjectAnimator r120 = ObjectAnimator.ofFloat(this.f524286b, LiveDegradeFpsAnimator.TRANSLATION_X, new float[]{0.0f});
        if (this.f524287c == false) goto L56;
        long r121 = 500;
    L57:
        r120.setDuration(r121);
        ObjectAnimator r122 = ObjectAnimator.ofFloat(this.f524286b, LiveDegradeFpsAnimator.TRANSLATION_X, new float[]{0.0f});
        if (this.f524287c == false) goto L60;
        long r123 = 500;
    L61:
        r122.setDuration(r123);
        ObjectAnimator r124 = ObjectAnimator.ofFloat(this.f524286b, LiveDegradeFpsAnimator.TRANSLATION_Y, new float[]{0.0f, 10.0f});
        if (this.f524287c == false) goto L64;
        long r125 = 200;
    L65:
        r124.setDuration(r125);
        ObjectAnimator r126 = ObjectAnimator.ofFloat(this.f524286b, LiveDegradeFpsAnimator.TRANSLATION_Y, new float[]{0.0f, -10.0f});
        if (this.f524287c == false) goto L68;
        long r127 = 200;
    L69:
        r126.setDuration(r127);
        ObjectAnimator r128 = ObjectAnimator.ofFloat(this.f524286b, LiveDegradeFpsAnimator.TRANSLATION_X, new float[]{0.0f, -10.0f});
        if (this.f524287c == false) goto L72;
        long r129 = 200;
    L73:
        r128.setDuration(r129);
        ObjectAnimator r130 = ObjectAnimator.ofFloat(this.f524286b, LiveDegradeFpsAnimator.TRANSLATION_X, new float[]{0.0f, 10.0f});
        if (this.f524287c == false) goto L76;
        long r131 = 200;
    L77:
        r130.setDuration(r131);
        this.f524286b.setVisibility(0);
        if (this.f524287c == false) goto L124;
        int r132 = this.f524285a.f524257a;
        if (r132 != 3) goto L82;
        r128.setInterpolator(new d());
        r122.setInterpolator(new AccelerateDecelerateInterpolator());
        AnimatorSet r133 = this.f524285a.f524266j;
        if (r133 == null) goto L169;
        AnimatorSet.Builder r134 = r133.play(r108);
        if (r134 == null) goto L169;
        AnimatorSet.Builder r135 = r134.with(r116);
        if (r135 == null) goto L169;
        AnimatorSet.Builder r136 = r135.with(r128);
        if (r136 == null) goto L169;
        r136.before(r122);
    L169:
        AnimatorSet r137 = this.f524285a.f524266j;
        if (r137 == null) goto L172;
        r137.addListener(new a(this));
    L172:
        this.f524285a.getClass();
        AnimatorSet r138 = this.f524285a.f524266j;
        if (r138 == null) goto L176;
        r138.start();
        return;
    L176:
        return;
    L82:
        if (r132 != 5) goto L84;
        r130.setInterpolator(new d());
        r120.setInterpolator(new AccelerateDecelerateInterpolator());
        AnimatorSet r139 = this.f524285a.f524266j;
        if (r139 == null) goto L169;
        AnimatorSet.Builder r140 = r139.play(r108);
        if (r140 == null) goto L169;
        AnimatorSet.Builder r141 = r140.with(r116);
        if (r141 == null) goto L169;
        AnimatorSet.Builder r142 = r141.with(r130);
        if (r142 == null) goto L169;
        r142.before(r120);
        goto L169
    L84:
        if (r132 != 48) goto L86;
        r126.setInterpolator(new d());
        r117.setInterpolator(new AccelerateDecelerateInterpolator());
        AnimatorSet r143 = this.f524285a.f524266j;
        if (r143 == null) goto L169;
        AnimatorSet.Builder r144 = r143.play(r108);
        if (r144 == null) goto L169;
        AnimatorSet.Builder r145 = r144.with(r116);
        if (r145 == null) goto L169;
        AnimatorSet.Builder r146 = r145.with(r126);
        if (r146 == null) goto L169;
        r146.before(r117);
        goto L169
    L86:
        if (r132 != 80) goto L169;
        r124.setInterpolator(new d());
        r118.setInterpolator(new AccelerateDecelerateInterpolator());
        AnimatorSet r147 = this.f524285a.f524266j;
        if (r147 == null) goto L169;
        AnimatorSet.Builder r148 = r147.play(r108);
        if (r148 == null) goto L169;
        AnimatorSet.Builder r149 = r148.with(r116);
        if (r149 == null) goto L169;
        AnimatorSet.Builder r150 = r149.with(r124);
        if (r150 == null) goto L169;
        r150.before(r118);
        goto L169
    L124:
        int r151 = this.f524285a.f524257a;
        if (r151 != 3) goto L127;
        r122.setInterpolator(new b());
        r128.setInterpolator(new AccelerateDecelerateInterpolator());
        AnimatorSet r152 = this.f524285a.f524266j;
        if (r152 == null) goto L169;
        AnimatorSet.Builder r153 = r152.play(r108);
        if (r153 == null) goto L169;
        AnimatorSet.Builder r154 = r153.with(r116);
        if (r154 == null) goto L169;
        AnimatorSet.Builder r155 = r154.with(r122);
        if (r155 == null) goto L169;
        r155.after(r128);
        goto L169
    L127:
        if (r151 != 5) goto L129;
        r120.setInterpolator(new b());
        r130.setInterpolator(new AccelerateDecelerateInterpolator());
        AnimatorSet r156 = this.f524285a.f524266j;
        if (r156 == null) goto L169;
        AnimatorSet.Builder r157 = r156.play(r108);
        if (r157 == null) goto L169;
        AnimatorSet.Builder r158 = r157.with(r116);
        if (r158 == null) goto L169;
        AnimatorSet.Builder r159 = r158.with(r120);
        if (r159 == null) goto L169;
        r159.after(r130);
        goto L169
    L129:
        if (r151 != 48) goto L131;
        r117.setInterpolator(new b());
        r126.setInterpolator(new AccelerateDecelerateInterpolator());
        AnimatorSet r160 = this.f524285a.f524266j;
        if (r160 == null) goto L169;
        AnimatorSet.Builder r161 = r160.play(r108);
        if (r161 == null) goto L169;
        AnimatorSet.Builder r162 = r161.with(r116);
        if (r162 == null) goto L169;
        AnimatorSet.Builder r163 = r162.with(r117);
        if (r163 == null) goto L169;
        r163.after(r126);
        goto L169
    L131:
        if (r151 != 80) goto L169;
        r118.setInterpolator(new b());
        r124.setInterpolator(new AccelerateDecelerateInterpolator());
        AnimatorSet r164 = this.f524285a.f524266j;
        if (r164 == null) goto L169;
        AnimatorSet.Builder r165 = r164.play(r108);
        if (r165 == null) goto L169;
        AnimatorSet.Builder r166 = r165.with(r116);
        if (r166 == null) goto L169;
        AnimatorSet.Builder r167 = r166.with(r118);
        if (r167 == null) goto L169;
        r167.after(r124);
        goto L169
    L76:
        r131 = 150;
        goto L77
    L72:
        r129 = 150;
        goto L73
    L68:
        r127 = 150;
        goto L69
    L64:
        r125 = 150;
        goto L65
    L60:
        r123 = 200;
        goto L61
    L56:
        r121 = 200;
        goto L57
    L52:
        r119 = 200;
        goto L53
    L41:
        r115 = 1.0f;
        goto L42
    L37:
        r107 = 0.0f;
        goto L38
    L33:
        r111 = 1.0f;
        goto L34
    L11:
        float r168 = this.f524286b.getX();
        PopLayout r169 = this.f524285a.f524262f;
        if (r169 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("mLivePopLayout");
    L14:
        r102 = (int) (r168 + r169.getBubbleOffset());
        float r170 = this.f524286b.getY();
    L29:
        r103 = (int) r170;
        goto L30
    L15:
        float r171 = this.f524286b.getX();
        PopLayout r172 = this.f524285a.f524262f;
        if (r172 != null) goto L18;
        Intrinsics.throwUninitializedPropertyAccessException("mLivePopLayout");
    L18:
        r102 = (int) (r171 + r172.getBubbleOffset());
        float r173 = this.f524286b.getY();
        float r174 = this.f524286b.getMeasuredHeight();
    L28:
        r170 = r173 + r174;
        goto L29
    L19:
        r102 = (int) this.f524286b.getX();
        float r175 = this.f524286b.getY();
        PopLayout r176 = this.f524285a.f524262f;
        if (r176 != null) goto L22;
        Intrinsics.throwUninitializedPropertyAccessException("mLivePopLayout");
    L22:
        float r177 = r176.getBubbleOffset();
    L27:
        float r178 = r175;
        r174 = r177;
        r173 = r178;
        goto L28
    L23:
        r102 = (int) (this.f524286b.getX() + this.f524286b.getMeasuredWidth());
        r175 = this.f524286b.getY();
        PopLayout r179 = this.f524285a.f524262f;
        if (r179 != null) goto L26;
        Intrinsics.throwUninitializedPropertyAccessException("mLivePopLayout");
    L26:
        r177 = r179.getBubbleOffset();
        goto L27
    }

    @Override // java.lang.Runnable
    public final void run() {
        a();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
