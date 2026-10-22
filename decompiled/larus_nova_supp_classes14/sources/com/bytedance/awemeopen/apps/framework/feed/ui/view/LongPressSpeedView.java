package com.bytedance.awemeopen.apps.framework.feed.ui.view;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.SharedPreferences;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import android.widget.FrameLayout;
import android.widget.TextView;
import c04.d;
import c04.g;
import com.bytedance.awemeopen.apps.framework.utils.d0;
import java.util.Arrays;
import java.util.LinkedHashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import r14.c;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001:\u0001'B'\b\u0007\u0012\u0006\u0010!\u001a\u00020 \u0012\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\"\u0012\b\b\u0002\u0010$\u001a\u00020\u0002¢\u0006\u0004\b%\u0010&J\b\u0010\u0003\u001a\u00020\u0002H\u0002R\u001d\u0010\t\u001a\u0004\u0018\u00010\u00048BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\bR\u001d\u0010\f\u001a\u0004\u0018\u00010\u00048BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u0006\u001a\u0004\b\u000b\u0010\bR\u001b\u0010\u0011\u001a\u00020\r8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000e\u0010\u0006\u001a\u0004\b\u000f\u0010\u0010R\u001b\u0010\u0014\u001a\u00020\u00048BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0012\u0010\u0006\u001a\u0004\b\u0013\u0010\bR\u001b\u0010\u0017\u001a\u00020\u00048BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0015\u0010\u0006\u001a\u0004\b\u0016\u0010\bR\u001b\u0010\u001c\u001a\u00020\u00188BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0019\u0010\u0006\u001a\u0004\b\u001a\u0010\u001bR\u001b\u0010\u001f\u001a\u00020\u00188BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001d\u0010\u0006\u001a\u0004\b\u001e\u0010\u001b¨\u0006("}, d2 = {"Lcom/bytedance/awemeopen/apps/framework/feed/ui/view/LongPressSpeedView;", "Landroid/widget/FrameLayout;", "", "getLayoutId", "Landroid/view/View;", "b", "Lkotlin/Lazy;", "getMSpeedTextContainer", "()Landroid/view/View;", "mSpeedTextContainer", "c", "getMSpeedImageView", "mSpeedImageView", "Landroid/widget/TextView;", "d", "getMSpeedText", "()Landroid/widget/TextView;", "mSpeedText", "e", "getMPreTriangle", "mPreTriangle", "f", "getMNextTriangle", "mNextTriangle", "Lcom/bytedance/awemeopen/apps/framework/feed/ui/view/PinchRippleContainer;", "g", "getMLeftRipple", "()Lcom/bytedance/awemeopen/apps/framework/feed/ui/view/PinchRippleContainer;", "mLeftRipple", "h", "getMRightRipple", "mRightRipple", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "a", "ao_apps_framework_release"}, k = 1, mv = {1, 7, 1})
public final class LongPressSpeedView extends FrameLayout {
    public static final /* synthetic */ int m = 0;
    public final View a;
    public final Lazy b;
    public final Lazy c;
    public final Lazy d;
    public final Lazy e;
    public final Lazy f;
    public final Lazy g;
    public final Lazy h;
    public ObjectAnimator i;
    public ObjectAnimator j;
    public c k;
    public boolean l;

    public static final class a {
    }

    public static final class b extends AnimatorListenerAdapter {
        public final /* synthetic */ LongPressSpeedView a;
        public final /* synthetic */ View b;
        public final /* synthetic */ float c;
        public final /* synthetic */ float d;

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator r5) {
            Intrinsics.checkNotNullParameter(r5, "animation");
            LongPressSpeedView r6 = this.a;
            View r0 = this.b;
            float r1 = this.c;
            float r2 = this.d;
            int r3 = LongPressSpeedView.m;
            r6.c(r0, false, r1, r2);
        }

        public b(LongPressSpeedView r1, View r2, float r3, float r4) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
        }
    }

    static {
    }

    public LongPressSpeedView(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public LongPressSpeedView(Context r3, AttributeSet r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        this(r3, r4, 4, 0);
    }

    private final int getLayoutId() {
        return 2131561093;
    }

    @Override // android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent r1) {
        return true;
    }

    private final PinchRippleContainer getMLeftRipple() {
        return (PinchRippleContainer) this.g.getValue();
    }

    private final View getMNextTriangle() {
        return (View) this.f.getValue();
    }

    private final View getMPreTriangle() {
        return (View) this.e.getValue();
    }

    private final PinchRippleContainer getMRightRipple() {
        return (PinchRippleContainer) this.h.getValue();
    }

    private final View getMSpeedImageView() {
        return (View) this.c.getValue();
    }

    private final TextView getMSpeedText() {
        return (TextView) this.d.getValue();
    }

    private final View getMSpeedTextContainer() {
        return (View) this.b.getValue();
    }

    public final void d() {
        View r0 = getMNextTriangle();
        if (r0 == null) goto L5;
        r0.clearAnimation();
    L5:
        View r1 = getMNextTriangle();
        if (r1 == null) goto L10;
        ViewPropertyAnimator r2 = r1.animate();
        if (r2 == null) goto L10;
        r2.cancel();
    L10:
        ObjectAnimator r3 = this.j;
        if (r3 == null) goto L13;
        r3.cancel();
    L13:
        View r4 = getMPreTriangle();
        if (r4 == null) goto L16;
        r4.clearAnimation();
    L16:
        View r5 = getMPreTriangle();
        if (r5 == null) goto L21;
        ViewPropertyAnimator r6 = r5.animate();
        if (r6 == null) goto L21;
        r6.cancel();
    L21:
        ObjectAnimator r7 = this.i;
        if (r7 == null) goto L24;
        r7.cancel();
    L24:
        animate().cancel();
        clearAnimation();
    }

    public static final /* synthetic */ View a(LongPressSpeedView r0) {
        return r0.getMNextTriangle();
    }

    public static final /* synthetic */ View b(LongPressSpeedView r0) {
        return r0.getMPreTriangle();
    }

    public final void e(c r10) {
        this.k = r10;
        ViewGroup.LayoutParams r11 = getMLeftRipple().getLayoutParams();
        ViewGroup.MarginLayoutParams r1 = null;
        if ((r11 instanceof ViewGroup.MarginLayoutParams) == false) goto L5;
        ViewGroup.MarginLayoutParams r12 = (ViewGroup.MarginLayoutParams) r11;
    L6:
        ViewGroup.LayoutParams r0 = getMRightRipple().getLayoutParams();
        if ((r0 instanceof ViewGroup.MarginLayoutParams) == false) goto L9;
        r1 = (ViewGroup.MarginLayoutParams) r0;
    L9:
        getMLeftRipple().setLayoutParams(r12);
        getMRightRipple().setLayoutParams(r1);
        d();
        setAlpha(1.0f);
        setVisibility(0);
        getMPreTriangle().setAlpha(0.0f);
        getMNextTriangle().setAlpha(0.0f);
        getMLeftRipple().setAlpha(0.0f);
        getMRightRipple().setAlpha(0.0f);
        int r2 = (int) (d0.d(getContext()) * 0.19f);
        getMLeftRipple().getLayoutParams().width = r2;
        getMRightRipple().getLayoutParams().width = r2;
        getMLeftRipple().invalidate();
        getMRightRipple().invalidate();
        int r3 = g.a;
        if (g.a(this.k) == false) goto L24;
        View r4 = getMSpeedImageView();
        if (r4 == null) goto L15;
        r4.setVisibility(0);
    L15:
        View r5 = getMPreTriangle();
        if (r5 == null) goto L19;
        r5.setVisibility(0);
    L19:
        View r6 = getMNextTriangle();
        if (r6 == null) goto L23;
        r6.setVisibility(0);
    L23:
        getMSpeedText().setText(getResources().getString(2131894192));
    L58:
        SharedPreferences r7 = d.b;
        if (r7.getInt("long_press_highlight_show_times", 0) >= 3) goto L61;
        boolean r8 = true;
    L62:
        if (r8 == false) goto L67;
        if (this.l == true) goto L67;
        c(getMLeftRipple(), true, -10.0f, 0.0f);
        c(getMRightRipple(), true, 10.0f, 0.0f);
        r7.edit().putInt("long_press_highlight_show_times", r7.getInt("long_press_highlight_show_times", 0) + 1).apply();
    L67:
        if (g.a(this.k) == false) goto L87;
        getMPreTriangle().setVisibility(0);
        getMNextTriangle().setVisibility(0);
        View r9 = getMSpeedImageView();
        if (r9 == null) goto L72;
        r9.setVisibility(0);
    L72:
        ObjectAnimator r13 = ObjectAnimator.ofFloat(getMNextTriangle(), "alpha", new float[]{0.5f, 0.2f});
        r13.setDuration(400);
        r13.addListener(new com.bytedance.awemeopen.apps.framework.feed.ui.view.a(this));
        r13.start();
        ObjectAnimator r14 = ObjectAnimator.ofFloat(getMNextTriangle(), "alpha", new float[]{1.0f, 0.5f, 0.2f});
        this.j = r14;
        if (r14 == null) goto L76;
        r14.setDuration(800);
    L76:
        ObjectAnimator r15 = this.j;
        if (r15 == null) goto L80;
        r15.setRepeatCount(-1);
    L80:
        ObjectAnimator r16 = this.j;
        if (r16 == null) goto L84;
        r16.setRepeatMode(2);
    L84:
        ObjectAnimator r17 = this.j;
        if (r17 == null) goto L91;
        r17.start();
    L91:
        this.l = true;
        return;
    L87:
        getMPreTriangle().setVisibility(8);
        getMNextTriangle().setVisibility(8);
        View r18 = getMSpeedImageView();
        if (r18 == null) goto L91;
        r18.setVisibility(8);
        goto L91
    L61:
        r8 = false;
        goto L62
    L24:
        View r19 = getMSpeedImageView();
        if (r19 == null) goto L28;
        r19.setVisibility(8);
    L28:
        View r20 = getMPreTriangle();
        if (r20 == null) goto L32;
        r20.setVisibility(8);
    L32:
        View r21 = getMNextTriangle();
        if (r21 == null) goto L36;
        r21.setVisibility(8);
    L36:
        c r22 = this.k;
        if (r22 != null) goto L39;
    L41:
        boolean r23 = false;
    L42:
        if (r23 == true) goto L52;
        c r24 = this.k;
        if (r24 != null) goto L46;
    L48:
        boolean r25 = false;
    L49:
        if (r25 == true) goto L52;
        boolean r26 = false;
    L53:
        TextView r27 = getMSpeedText();
        StringCompanionObject r28 = StringCompanionObject.INSTANCE;
        String r29 = getResources().getString(2131896995);
        Object[] r30 = new Object[1];
        if (r26 == false) goto L56;
        String r31 = "图文";
    L57:
        r30[0] = r31;
        r27.setText(String.format(r29, Arrays.copyOf(r30, 1)));
        goto L58
    L56:
        r31 = "视频";
        goto L57
    L46:
        if (r24.i() != 2) goto L48;
        r25 = true;
    L52:
        r26 = true;
        goto L53
    L39:
        if (r22.i() != 68) goto L41;
        r23 = true;
        goto L42
    L5:
        r12 = null;
        goto L6
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent r1) {
        return super.onTouchEvent(r1);
    }

    public LongPressSpeedView(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        new LinkedHashMap();
        super(r2, r3, r4);
        this.a = LayoutInflater.from(r2).inflate(getLayoutId(), this);
        this.b = LazyKt.lazy(new LongPressSpeedView$mSpeedTextContainer$2(this));
        this.c = LazyKt.lazy(new LongPressSpeedView$mSpeedImageView$2(this));
        this.d = LazyKt.lazy(new LongPressSpeedView$mSpeedText$2(this));
        this.e = LazyKt.lazy(new LongPressSpeedView$mPreTriangle$2(this));
        this.f = LazyKt.lazy(new LongPressSpeedView$mNextTriangle$2(this));
        this.g = LazyKt.lazy(new LongPressSpeedView$mLeftRipple$2(this));
        this.h = LazyKt.lazy(new LongPressSpeedView$mRightRipple$2(this));
    }

    public /* synthetic */ LongPressSpeedView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }

    public final void c(View r8, boolean r9, float r10, float r11) {
        r8.setVisibility(0);
        AnimatorSet r1 = new AnimatorSet();
        float[] r3 = new float[2];
        float r4 = 1.0f;
        if (r9 == false) goto L5;
        float r6 = 0.0f;
    L6:
        r3[0] = r6;
        if (r9 == true) goto L10;
        r4 = 0.0f;
    L10:
        r3[1] = r4;
        r1.playTogether(new Animator[]{ObjectAnimator.ofFloat(r8, "alpha", r3), ObjectAnimator.ofFloat(r8, "translationX", new float[]{r10, r11})});
        r1.setDuration(1600);
        r1.setInterpolator(new c04.b());
        if (r9 == false) goto L13;
        r1.addListener(new b(this, r8, r11, r10));
    L13:
        r1.start();
        return;
    L5:
        r6 = 1.0f;
        goto L6
    }
}
