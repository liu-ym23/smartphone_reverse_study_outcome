package com.bytedance.livesdk.ktvcommon.midi.view.midihitanim;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.ImageView;
import com.alibaba.gaiax.template.GXTemplateKey;
import com.bytedance.livesdk.ktvcommon.midi.view.LiveDegradeFpsAnimator;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes20.dex */
public final class f extends AnimatorListenerAdapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ d f256131a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ WeakReference f256132b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ boolean f256133c;

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator r100) {
        Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
        super.onAnimationEnd(r100);
        ((ArrayList) this.f256131a.f256118b).remove(r100);
        ImageView r101 = (ImageView) this.f256132b.get();
        if (r101 == null) goto L15;
        d r102 = this.f256131a;
        boolean r103 = this.f256133c;
        r102.getClass();
        r101.setVisibility(4);
        r101.setLayerType(0, null);
        ViewParent r104 = r101.getParent();
        if ((r104 instanceof ViewGroup) == true) goto L7;
        r104 = null;
    L7:
        ViewGroup r105 = (ViewGroup) r104;
        if (r105 == null) goto L11;
        r105.removeView(r101);
    L11:
        if (r103 == false) goto L13;
        a r106 = r102.f256128l;
        r106.getClass();
        Intrinsics.checkNotNullParameter(r101, "view");
        r106.f256097b.c(r101);
        goto L15
    L13:
        a r107 = r102.f256128l;
        r107.getClass();
        Intrinsics.checkNotNullParameter(r101, "view");
        r107.f256096a.c(r101);
    L15:
        if ((r100 instanceof AnimatorSet) == true) goto L17;
        r100 = null;
    L17:
        AnimatorSet r108 = (AnimatorSet) r100;
        if (r108 == null) goto L58;
        ArrayList<Animator> r109 = r108.getChildAnimations();
        if (r109 == null) goto L88;
        Iterator<T> r110 = r109.iterator();
    L23:
        if (r110.hasNext() == false) goto L89;
        Animator r111 = (Animator) r110.next();
        if ((r111 instanceof AnimatorSet) == true) goto L27;
        r111 = null;
    L27:
        AnimatorSet r112 = (AnimatorSet) r111;
        if (r112 == null) goto L23;
        ArrayList<Animator> r113 = r112.getChildAnimations();
        if (r113 == null) goto L23;
        Iterator<T> r114 = r113.iterator();
    L33:
        if (r114.hasNext() == false) goto L23;
        Animator r115 = (Animator) r114.next();
        if ((r115 instanceof LiveDegradeFpsAnimator) == true) goto L37;
        r115 = null;
    L37:
        LiveDegradeFpsAnimator r116 = (LiveDegradeFpsAnimator) r115;
        if (r116 == null) goto L33;
        String r117 = r116.f256060a;
        if (r117 == null) goto L57;
        switch(r117.hashCode()) {
            case -908189618: goto L55;
            case -908189617: goto L52;
            case -40300674: goto L49;
            case 92909918: goto L46;
            default: goto L57;
        };
    L49:
        if (r117.equals("rotation") == false) goto L57;
        this.f256131a.f256120d.b(r116);
        goto L33
    L52:
        if (r117.equals(com.bytedance.android.live.core.anim.LiveDegradeFpsAnimator.SCALE_Y) == false) goto L57;
        this.f256131a.f256123g.b(r116);
        goto L33
    L55:
        if (r117.equals(com.bytedance.android.live.core.anim.LiveDegradeFpsAnimator.SCALE_X) == false) goto L57;
        this.f256131a.f256122f.b(r116);
        goto L33
    L46:
        if (r117.equals("alpha") == false) goto L57;
        this.f256131a.f256121e.b(r116);
    L57:
        this.f256131a.f256119c.b(r116);
        goto L33
    L89:
        return;
    L88:
        return;
    }

    public f(d r100, WeakReference r101, boolean r102) {
        this.f256131a = r100;
        this.f256132b = r101;
        this.f256133c = r102;
    }
}
