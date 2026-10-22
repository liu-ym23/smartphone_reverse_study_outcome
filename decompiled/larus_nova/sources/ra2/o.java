package ra2;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.graphics.drawable.Animatable;
import android.view.ViewGroup;
import com.alibaba.gaiax.template.GXTemplateKey;
import com.bytedance.android.live.core.anim.LiveDegradeFpsAnimator;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.livesdk.interactivity.publicscreen.topcontainer.match.ui.MatchHotMsgView;
import com.bytedance.android.livesdk.utils.q4;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.fresco.animation.drawable.AnimatedDrawable2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class o extends AnimatorListenerAdapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ MatchHotMsgView f536827a;

    public o(MatchHotMsgView r100) {
        this.f536827a = r100;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator r210) {
        Intrinsics.checkNotNullParameter(r210, GXTemplateKey.GAIAX_ANIMATION);
        MatchHotMsgView r100 = this.f536827a;
        if (r100.F == false) goto L97;
        ViewGroup r101 = r100.f140123e;
        if (r101 == null) goto L7;
        r101.setPivotX(0.0f);
    L7:
        ViewGroup r102 = this.f536827a.f140123e;
        if (r102 == null) goto L10;
        r102.setPivotY(r102.getHeight() / 2.0f);
    L10:
        ViewGroup r103 = this.f536827a.f140125g;
        if (r103 == null) goto L13;
        r103.setPivotX(0.0f);
    L13:
        ViewGroup r104 = this.f536827a.f140125g;
        if (r104 == null) goto L16;
        r104.setPivotY(r104.getHeight());
    L16:
        MatchHotMsgView r105 = this.f536827a;
        r105.getClass();
        if (m.a.a(r105) == true) goto L98;
        MatchHotMsgView r106 = this.f536827a;
        r106.getClass();
        r106.C = new AnimatorSet();
        AnimatorSet r107 = new AnimatorSet();
        Animator[] r108 = new Animator[2];
        int r109 = com.bytedance.android.livesdk.interactivity.textmessage.utils.a.f141225a;
        ViewGroup r110 = r106.f140123e;
        if (r110 == null) goto L100;
        r108[0] = com.bytedance.android.livesdk.interactivity.textmessage.utils.a.b(r110, LiveDegradeFpsAnimator.SCALE_X, 0.99f, 1.0f, 100, 0.0f, 0.0f, 0.58f, 1.0f);
        ViewGroup r111 = r106.f140123e;
        if (r111 == null) goto L101;
        Animator r112 = com.bytedance.android.livesdk.interactivity.textmessage.utils.a.b(r111, LiveDegradeFpsAnimator.SCALE_Y, 0.99f, 1.0f, 100, 0.0f, 0.0f, 0.58f, 1.0f);
        int r113 = 1;
        r108[1] = r112;
        r107.playTogether(r108);
        AnimatorSet r114 = new AnimatorSet();
        Animator[] r115 = new Animator[1];
        ViewGroup r116 = r106.f140123e;
        if (r116 == null) goto L102;
        r115[0] = com.bytedance.android.livesdk.interactivity.textmessage.utils.a.b(r116, LiveDegradeFpsAnimator.SCALE_X, 1.0f, 1.0f, 300, 0.0f, 0.0f, 0.58f, 1.0f);
        r114.playSequentially(r115);
        AnimatorSet r117 = new AnimatorSet();
        Animator[] r118 = new Animator[2];
        ViewGroup r119 = r106.f140123e;
        if (r119 == null) goto L103;
        r118[0] = com.bytedance.android.livesdk.interactivity.textmessage.utils.a.b(r119, LiveDegradeFpsAnimator.SCALE_X, 1.0f, 1.01f, 100, 0.0f, 0.0f, 0.58f, 1.0f);
        ViewGroup r120 = r106.f140123e;
        if (r120 == null) goto L104;
        r118[1] = com.bytedance.android.livesdk.interactivity.textmessage.utils.a.b(r120, LiveDegradeFpsAnimator.SCALE_Y, 1.0f, 1.01f, 100, 0.0f, 0.0f, 0.58f, 1.0f);
        r117.playTogether(r118);
        AnimatorSet r121 = new AnimatorSet();
        Animator[] r122 = new Animator[1];
        ViewGroup r123 = r106.f140123e;
        if (r123 == null) goto L105;
        r122[0] = com.bytedance.android.livesdk.interactivity.textmessage.utils.a.b(r123, LiveDegradeFpsAnimator.SCALE_X, 1.01f, 1.01f, 300, 0.0f, 0.0f, 0.58f, 1.0f);
        r121.playSequentially(r122);
        AnimatorSet r124 = new AnimatorSet();
        AnimatorSet r125 = new AnimatorSet();
        Animator[] r126 = new Animator[2];
        ViewGroup r127 = r106.f140123e;
        if (r127 == null) goto L106;
        r126[0] = com.bytedance.android.livesdk.interactivity.textmessage.utils.a.b(r127, LiveDegradeFpsAnimator.SCALE_X, 1.01f, 0.95f, 100, 0.26f, 0.0f, 0.6f, 0.2f);
        ViewGroup r128 = r106.f140123e;
        if (r128 == null) goto L107;
        r126[1] = com.bytedance.android.livesdk.interactivity.textmessage.utils.a.b(r128, LiveDegradeFpsAnimator.SCALE_Y, 1.01f, 0.95f, 100, 0.26f, 0.0f, 0.6f, 0.2f);
        r125.playTogether(r126);
        AnimatorSet r129 = new AnimatorSet();
        Animator[] r130 = new Animator[2];
        ViewGroup r131 = r106.f140123e;
        if (r131 == null) goto L108;
        r130[0] = com.bytedance.android.livesdk.interactivity.textmessage.utils.a.b(r131, LiveDegradeFpsAnimator.SCALE_X, 0.95f, 0.99f, 300, 0.4f, 0.8f, 0.74f, 1.0f);
        ViewGroup r132 = r106.f140123e;
        if (r132 == null) goto L109;
        r130[1] = com.bytedance.android.livesdk.interactivity.textmessage.utils.a.b(r132, LiveDegradeFpsAnimator.SCALE_Y, 0.95f, 0.99f, 300, 0.4f, 0.8f, 0.74f, 1.0f);
        r129.playTogether(r130);
        r124.playSequentially(new Animator[]{r125, r129});
        AnimatorSet r133 = new AnimatorSet();
        Animator[] r134 = new Animator[1];
        ViewGroup r135 = r106.f140123e;
        if (r135 == null) goto L110;
        Intrinsics.checkNotNullParameter(r135, "view");
        Intrinsics.checkNotNullParameter(LiveDegradeFpsAnimator.SCALE_X, "propertyName");
        q4.f159129j.getClass();
        ValueAnimator r136 = q4.a.b(r135, LiveDegradeFpsAnimator.SCALE_X, new float[]{0.99f, 0.99f});
        r136.setDuration(300);
        r134[0] = r136;
        r133.playTogether(r134);
        AnimatorSet r137 = r106.C;
        if (r137 == null) goto L54;
        r137.playSequentially(new Animator[]{r107, r114, r117, r121, r124, r133});
    L54:
        AnimatorSet r138 = r106.C;
        if (r138 == null) goto L57;
        r138.addListener(new w(r106));
    L57:
        AnimatorSet r139 = r106.C;
        if (r139 == null) goto L60;
        r139.start();
    L60:
        HSImageView r140 = r106.f140121c;
        Animatable r141 = null;
        if (r140 == null) goto L65;
        DraweeController r142 = r140.getController();
        if (r142 == null) goto L65;
        Animatable r143 = r142.getAnimatable();
    L67:
        if ((r143 instanceof AnimatedDrawable2) == true) goto L69;
        r143 = null;
    L69:
        r106.f140135q = (AnimatedDrawable2) r143;
        HSImageView r144 = r106.f140120b;
        if (r144 == null) goto L74;
        DraweeController r145 = r144.getController();
        if (r145 == null) goto L74;
        Animatable r146 = r145.getAnimatable();
    L76:
        if ((r146 instanceof AnimatedDrawable2) == false) goto L79;
        r141 = r146;
    L79:
        r106.f140136r = (AnimatedDrawable2) r141;
        AnimatedDrawable2 r147 = r106.f140135q;
        long r148 = 50;
        if (r147 == null) goto L86;
        long r149 = r147.getLoopDurationMs();
        AnimatedDrawable2 r150 = r106.f140135q;
        if (r150 == null) goto L84;
        int r151 = r150.getFrameCount();
    L85:
        long r152 = r149 / ((long) r151);
    L87:
        r106.f140137s = r152;
        AnimatedDrawable2 r153 = r106.f140136r;
        if (r153 == null) goto L93;
        long r154 = r153.getLoopDurationMs();
        AnimatedDrawable2 r155 = r106.f140136r;
        if (r155 == null) goto L92;
        r113 = r155.getFrameCount();
    L92:
        r148 = r154 / ((long) r113);
    L93:
        r106.f140138t = r148;
        r106.post(r106.f140133o);
        AnimatedDrawable2 r156 = r106.f140136r;
        if (r156 == null) goto L99;
        r156.start();
        return;
    L99:
        return;
    L84:
        r151 = 1;
        goto L85
    L86:
        r152 = 50;
    L74:
        r146 = null;
    L65:
        r143 = null;
        goto L67
    L110:
        return;
    L109:
        return;
    L108:
        return;
    L107:
        return;
    L106:
        return;
    L105:
        return;
    L104:
        return;
    L103:
        return;
    L102:
        return;
    L101:
        return;
    L100:
        return;
    L98:
        return;
    }
}
