package re2;

import android.animation.Animator;
import android.animation.ArgbEvaluator;
import android.animation.ObjectAnimator;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.view.View;
import android.widget.ImageView;
import com.bytedance.android.live.core.utils.s1;
import java.util.ArrayList;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class b extends com.bytedance.android.live.liveinteract.a {
    public final ImageView C;
    public final ObjectAnimator D;
    public final ObjectAnimator E;
    public final ObjectAnimator F;
    public final ObjectAnimator G;
    public final ObjectAnimator H;
    public final ObjectAnimator I;
    public final ObjectAnimator J;
    public final ObjectAnimator K;
    public final ObjectAnimator L;
    public final ObjectAnimator M;
    public ObjectAnimator N;

    public final void b() {
        this.C.setAlpha(1.0f);
        super.b();
    }

    public final void c() {
        if (((com.bytedance.android.live.liveinteract.a) this).j == true) goto L5;
        ((com.bytedance.android.live.liveinteract.a) this).w.playTogether(new Animator[]{this.D, ((com.bytedance.android.live.liveinteract.a) this).k, this.E, ((com.bytedance.android.live.liveinteract.a) this).l, this.F, this.G, this.H});
        ((com.bytedance.android.live.liveinteract.a) this).x.playTogether(new Animator[]{((com.bytedance.android.live.liveinteract.a) this).n, ((com.bytedance.android.live.liveinteract.a) this).o, this.I, this.J});
        ((com.bytedance.android.live.liveinteract.a) this).y.playTogether(new Animator[]{((com.bytedance.android.live.liveinteract.a) this).p, ((com.bytedance.android.live.liveinteract.a) this).q, this.L, this.K, ((com.bytedance.android.live.liveinteract.a) this).r});
        ((com.bytedance.android.live.liveinteract.a) this).z.playTogether(new Animator[]{((com.bytedance.android.live.liveinteract.a) this).s, ((com.bytedance.android.live.liveinteract.a) this).v, ((com.bytedance.android.live.liveinteract.a) this).u, ((com.bytedance.android.live.liveinteract.a) this).t, this.M});
        super.a();
        ((com.bytedance.android.live.liveinteract.a) this).z.addListener(new a(this));
        ((com.bytedance.android.live.liveinteract.a) this).j = true;
    L5:
        ((com.bytedance.android.live.liveinteract.a) this).A = true;
        ((com.bytedance.android.live.liveinteract.a) this).w.start();
    }

    public b(View r17) {
        Intrinsics.checkNotNullParameter(r17, "itemView");
        super(r17);
        ImageView r1 = (ImageView) r17.findViewById(2131389534);
        this.C = r1;
        ObjectAnimator r2 = ObjectAnimator.ofFloat(((com.bytedance.android.live.liveinteract.a) this).e, "translationY", new float[]{s1.f(36.0f), 0.0f});
        r2.setDuration(400);
        r2.setInterpolator(((com.bytedance.android.live.liveinteract.a) this).h);
        ((ArrayList) ((com.bytedance.android.live.liveinteract.a) this).i).add(r2);
        Unit r4 = Unit.INSTANCE;
        this.D = r2;
        ObjectAnimator r3 = ObjectAnimator.ofFloat(((com.bytedance.android.live.liveinteract.a) this).f, "translationY", new float[]{s1.f(4.0f), 0.0f});
        r3.setDuration(400);
        r3.setInterpolator(((com.bytedance.android.live.liveinteract.a) this).h);
        ((ArrayList) ((com.bytedance.android.live.liveinteract.a) this).i).add(r3);
        this.E = r3;
        ObjectAnimator r5 = ObjectAnimator.ofFloat(((com.bytedance.android.live.liveinteract.a) this).g, "translationY", new float[]{s1.f(4.0f), 0.0f});
        r5.setDuration(400);
        r5.setInterpolator(((com.bytedance.android.live.liveinteract.a) this).h);
        ((ArrayList) ((com.bytedance.android.live.liveinteract.a) this).i).add(r5);
        this.F = r5;
        Drawable r6 = ((com.bytedance.android.live.liveinteract.a) this).g.getBackground();
        if (r6 == null) goto L15;
        int r8 = (int) 3003121664L;
        ObjectAnimator r7 = ObjectAnimator.ofInt((GradientDrawable) r6, "color", new int[]{0, r8});
        r7.setDuration(400);
        r7.setEvaluator(new ArgbEvaluator());
        ((ArrayList) ((com.bytedance.android.live.liveinteract.a) this).i).add(r7);
        this.G = r7;
        ObjectAnimator r9 = ObjectAnimator.ofFloat(r1, "alpha", new float[]{1.0f, 0.0f});
        r9.setDuration(300);
        ((ArrayList) ((com.bytedance.android.live.liveinteract.a) this).i).add(r9);
        this.H = r9;
        ObjectAnimator r10 = ObjectAnimator.ofFloat(((com.bytedance.android.live.liveinteract.a) this).g, "scaleX", new float[]{1.0f, 0.81f});
        r10.setDuration(400);
        ((ArrayList) ((com.bytedance.android.live.liveinteract.a) this).i).add(r10);
        this.I = r10;
        Drawable r11 = ((com.bytedance.android.live.liveinteract.a) this).g.getBackground();
        if (r11 == null) goto L13;
        int r13 = (int) 4294967295L;
        ObjectAnimator r12 = ObjectAnimator.ofInt((GradientDrawable) r11, "color", new int[]{r8, r13});
        r12.setDuration(400);
        r12.setEvaluator(new ArgbEvaluator());
        ((ArrayList) ((com.bytedance.android.live.liveinteract.a) this).i).add(r12);
        this.J = r12;
        Drawable r14 = ((com.bytedance.android.live.liveinteract.a) this).g.getBackground();
        if (r14 == null) goto L11;
        ObjectAnimator r15 = ObjectAnimator.ofInt((GradientDrawable) r14, "color", new int[]{r13, r8});
        r15.setDuration(400);
        r15.setEvaluator(new ArgbEvaluator());
        ((ArrayList) ((com.bytedance.android.live.liveinteract.a) this).i).add(r15);
        this.K = r15;
        ObjectAnimator r16 = ObjectAnimator.ofFloat(((com.bytedance.android.live.liveinteract.a) this).g, "scaleX", new float[]{0.81f, 0.95f});
        r16.setDuration(400);
        ((ArrayList) ((com.bytedance.android.live.liveinteract.a) this).i).add(r16);
        this.L = r16;
        ObjectAnimator r18 = ObjectAnimator.ofFloat(r1, "alpha", new float[]{0.0f, 1.0f});
        r18.setDuration(300);
        ((ArrayList) ((com.bytedance.android.live.liveinteract.a) this).i).add(r18);
        this.M = r18;
        return;
    L11:
        throw new NullPointerException("null cannot be cast to non-null type android.graphics.drawable.GradientDrawable");
    L13:
        throw new NullPointerException("null cannot be cast to non-null type android.graphics.drawable.GradientDrawable");
    L15:
        throw new NullPointerException("null cannot be cast to non-null type android.graphics.drawable.GradientDrawable");
    }
}
