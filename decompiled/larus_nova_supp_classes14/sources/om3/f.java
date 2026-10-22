package om3;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.view.animation.AccelerateDecelerateInterpolator;
import com.bytedance.android.uicomponent.popover.PopLayout;
import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class f implements Runnable {
    public final /* synthetic */ e a;
    public final /* synthetic */ PopLayout b;
    public final /* synthetic */ boolean c;

    public static final class a extends AnimatorListenerAdapter {
        public final /* synthetic */ f a;

        public a(f r1) {
            this.a = r1;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator r2) {
            Intrinsics.checkNotNullParameter(r2, "animation");
            super.onAnimationEnd(r2);
            f r3 = this.a;
            if (r3.c == true) goto L9;
            r3.b.setVisibility(8);
            e.c r4 = this.a.a.l;
            if (r4 == null) goto L7;
            r4.bubbleDismiss();
        L7:
            this.a.a.c();
            return;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationStart(Animator r2) {
            Intrinsics.checkNotNullParameter(r2, "animation");
            super.onAnimationStart(r2);
            f r3 = this.a;
            if (r3.c == false) goto L6;
            e r4 = r3.a;
            int r0 = e.n;
            r4.getClass();
            this.a.b.setVisibility(0);
            return;
        }
    }

    public f(e r1, PopLayout r2, boolean r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    public final void a() {
        e r1 = this.a;
        if (r1.j != null) goto L5;
        return;
    L5:
        int r2 = r1.a;
        if (r2 == 3) goto L23;
        if (r2 == 5) goto L19;
        if (r2 == 48) goto L15;
        if (r2 == 80) goto L11;
        int r3 = 0;
        int r7 = 0;
    L30:
        this.b.setPivotY(r7);
        this.b.setPivotX(r3);
        PopLayout r4 = this.b;
        float[] r8 = new float[2];
        boolean r9 = this.c;
        float r10 = 1.0f;
        if (r9 == false) goto L33;
        float r12 = 0.0f;
    L34:
        r8[0] = r12;
        if (r9 == false) goto L37;
        float r11 = 1.0f;
    L38:
        r8[1] = r11;
        ObjectAnimator r5 = ObjectAnimator.ofFloat(r4, "scaleX", r8);
        long r13 = 200;
        r5.setDuration(200);
        PopLayout r14 = this.b;
        float[] r15 = new float[2];
        boolean r16 = this.c;
        if (r16 == false) goto L41;
        float r17 = 0.0f;
    L42:
        r15[0] = r17;
        if (r16 == true) goto L46;
        r10 = 0.0f;
    L46:
        r15[1] = r10;
        ObjectAnimator r18 = ObjectAnimator.ofFloat(r14, "scaleY", r15);
        r18.setDuration(200);
        ObjectAnimator r19 = ObjectAnimator.ofFloat(this.b, "translationY", new float[]{0.0f});
        if (this.c == false) goto L49;
        r13 = 500;
    L49:
        r19.setDuration(r13);
        ObjectAnimator r20 = ObjectAnimator.ofFloat(this.b, "translationY", new float[]{0.0f});
        if (this.c == false) goto L52;
        long r6 = 500;
    L53:
        r20.setDuration(r6);
        ObjectAnimator r21 = ObjectAnimator.ofFloat(this.b, "translationX", new float[]{0.0f});
        if (this.c == false) goto L56;
        long r22 = 500;
    L57:
        r21.setDuration(r22);
        ObjectAnimator r23 = ObjectAnimator.ofFloat(this.b, "translationX", new float[]{0.0f});
        if (this.c == false) goto L60;
        long r110 = 500;
    L61:
        r23.setDuration(r110);
        ObjectAnimator r24 = ObjectAnimator.ofFloat(this.b, "translationY", new float[]{0.0f, 10.0f});
        if (this.c == false) goto L64;
        long r111 = 200;
    L65:
        r24.setDuration(r111);
        ObjectAnimator r112 = ObjectAnimator.ofFloat(this.b, "translationY", new float[]{0.0f, -10.0f});
        if (this.c == false) goto L68;
        long r113 = 200;
    L69:
        r112.setDuration(r113);
        ObjectAnimator r114 = ObjectAnimator.ofFloat(this.b, "translationX", new float[]{0.0f, -10.0f});
        if (this.c == false) goto L72;
        long r115 = 200;
    L73:
        r114.setDuration(r115);
        ObjectAnimator r25 = ObjectAnimator.ofFloat(this.b, "translationX", new float[]{0.0f, 10.0f});
        if (this.c == false) goto L76;
        long r116 = 200;
    L77:
        r25.setDuration(r116);
        this.b.setVisibility(0);
        if (this.c == false) goto L124;
        int r26 = this.a.a;
        if (r26 != 3) goto L82;
        r114.setInterpolator(new d());
        r23.setInterpolator(new AccelerateDecelerateInterpolator());
        AnimatorSet r27 = this.a.j;
        if (r27 == null) goto L169;
        AnimatorSet.Builder r28 = r27.play(r5);
        if (r28 == null) goto L169;
        AnimatorSet.Builder r29 = r28.with(r18);
        if (r29 == null) goto L169;
        AnimatorSet.Builder r30 = r29.with(r114);
        if (r30 == null) goto L169;
        r30.before(r23);
    L169:
        AnimatorSet r31 = this.a.j;
        if (r31 == null) goto L172;
        r31.addListener(new a(this));
    L172:
        this.a.getClass();
        AnimatorSet r32 = this.a.j;
        if (r32 == null) goto L176;
        r32.start();
        return;
    L176:
        return;
    L82:
        if (r26 != 5) goto L84;
        r25.setInterpolator(new d());
        r21.setInterpolator(new AccelerateDecelerateInterpolator());
        AnimatorSet r33 = this.a.j;
        if (r33 == null) goto L169;
        AnimatorSet.Builder r34 = r33.play(r5);
        if (r34 == null) goto L169;
        AnimatorSet.Builder r35 = r34.with(r18);
        if (r35 == null) goto L169;
        AnimatorSet.Builder r36 = r35.with(r25);
        if (r36 == null) goto L169;
        r36.before(r21);
        goto L169
    L84:
        if (r26 != 48) goto L86;
        r112.setInterpolator(new d());
        r19.setInterpolator(new AccelerateDecelerateInterpolator());
        AnimatorSet r37 = this.a.j;
        if (r37 == null) goto L169;
        AnimatorSet.Builder r38 = r37.play(r5);
        if (r38 == null) goto L169;
        AnimatorSet.Builder r39 = r38.with(r18);
        if (r39 == null) goto L169;
        AnimatorSet.Builder r40 = r39.with(r112);
        if (r40 == null) goto L169;
        r40.before(r19);
        goto L169
    L86:
        if (r26 != 80) goto L169;
        r24.setInterpolator(new d());
        r20.setInterpolator(new AccelerateDecelerateInterpolator());
        AnimatorSet r41 = this.a.j;
        if (r41 == null) goto L169;
        AnimatorSet.Builder r42 = r41.play(r5);
        if (r42 == null) goto L169;
        AnimatorSet.Builder r43 = r42.with(r18);
        if (r43 == null) goto L169;
        AnimatorSet.Builder r44 = r43.with(r24);
        if (r44 == null) goto L169;
        r44.before(r20);
        goto L169
    L124:
        int r45 = this.a.a;
        if (r45 != 3) goto L127;
        r23.setInterpolator(new b());
        r114.setInterpolator(new AccelerateDecelerateInterpolator());
        AnimatorSet r46 = this.a.j;
        if (r46 == null) goto L169;
        AnimatorSet.Builder r47 = r46.play(r5);
        if (r47 == null) goto L169;
        AnimatorSet.Builder r48 = r47.with(r18);
        if (r48 == null) goto L169;
        AnimatorSet.Builder r49 = r48.with(r23);
        if (r49 == null) goto L169;
        r49.after(r114);
        goto L169
    L127:
        if (r45 != 5) goto L129;
        r21.setInterpolator(new b());
        r25.setInterpolator(new AccelerateDecelerateInterpolator());
        AnimatorSet r50 = this.a.j;
        if (r50 == null) goto L169;
        AnimatorSet.Builder r51 = r50.play(r5);
        if (r51 == null) goto L169;
        AnimatorSet.Builder r52 = r51.with(r18);
        if (r52 == null) goto L169;
        AnimatorSet.Builder r53 = r52.with(r21);
        if (r53 == null) goto L169;
        r53.after(r25);
        goto L169
    L129:
        if (r45 != 48) goto L131;
        r19.setInterpolator(new b());
        r112.setInterpolator(new AccelerateDecelerateInterpolator());
        AnimatorSet r54 = this.a.j;
        if (r54 == null) goto L169;
        AnimatorSet.Builder r55 = r54.play(r5);
        if (r55 == null) goto L169;
        AnimatorSet.Builder r56 = r55.with(r18);
        if (r56 == null) goto L169;
        AnimatorSet.Builder r57 = r56.with(r19);
        if (r57 == null) goto L169;
        r57.after(r112);
        goto L169
    L131:
        if (r45 != 80) goto L169;
        r20.setInterpolator(new b());
        r24.setInterpolator(new AccelerateDecelerateInterpolator());
        AnimatorSet r58 = this.a.j;
        if (r58 == null) goto L169;
        AnimatorSet.Builder r59 = r58.play(r5);
        if (r59 == null) goto L169;
        AnimatorSet.Builder r60 = r59.with(r18);
        if (r60 == null) goto L169;
        AnimatorSet.Builder r61 = r60.with(r20);
        if (r61 == null) goto L169;
        r61.after(r24);
        goto L169
    L76:
        r116 = 150;
        goto L77
    L72:
        r115 = 150;
        goto L73
    L68:
        r113 = 150;
        goto L69
    L64:
        r111 = 150;
        goto L65
    L60:
        r110 = 200;
        goto L61
    L56:
        r22 = 200;
        goto L57
    L52:
        r6 = 200;
        goto L53
    L41:
        r17 = 1.0f;
        goto L42
    L37:
        r11 = 0.0f;
        goto L38
    L33:
        r12 = 1.0f;
        goto L34
    L11:
        float r62 = this.b.getX();
        PopLayout r63 = this.a.f;
        if (r63 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("mLivePopLayout");
    L14:
        r3 = (int) (r62 + r63.getBubbleOffset());
        float r64 = this.b.getY();
    L29:
        r7 = (int) r64;
        goto L30
    L15:
        float r65 = this.b.getX();
        PopLayout r66 = this.a.f;
        if (r66 != null) goto L18;
        Intrinsics.throwUninitializedPropertyAccessException("mLivePopLayout");
    L18:
        r3 = (int) (r65 + r66.getBubbleOffset());
        float r67 = this.b.getY();
        float r68 = this.b.getMeasuredHeight();
    L28:
        r64 = r67 + r68;
        goto L29
    L19:
        r3 = (int) this.b.getX();
        float r69 = this.b.getY();
        PopLayout r70 = this.a.f;
        if (r70 != null) goto L22;
        Intrinsics.throwUninitializedPropertyAccessException("mLivePopLayout");
    L22:
        float r71 = r70.getBubbleOffset();
    L27:
        float r117 = r69;
        r68 = r71;
        r67 = r117;
        goto L28
    L23:
        r3 = (int) (this.b.getX() + this.b.getMeasuredWidth());
        r69 = this.b.getY();
        PopLayout r72 = this.a.f;
        if (r72 != null) goto L26;
        Intrinsics.throwUninitializedPropertyAccessException("mLivePopLayout");
    L26:
        r71 = r72.getBubbleOffset();
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
