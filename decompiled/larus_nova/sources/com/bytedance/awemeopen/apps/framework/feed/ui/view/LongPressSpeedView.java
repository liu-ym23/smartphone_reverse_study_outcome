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
import com.alibaba.gaiax.template.GXTemplateKey;
import com.amap.api.col.s.ce;
import com.bytedance.android.live.core.anim.LiveDegradeFpsAnimator;
import com.bytedance.awemeopen.apps.framework.utils.d0;
import com.larus.nova.R;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.Arrays;
import java.util.LinkedHashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import r14.c;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001:\u0001'B'\b\u0007\u0012\u0006\u0010!\u001a\u00020 \u0012\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\"\u0012\b\b\u0002\u0010$\u001a\u00020\u0002¢\u0006\u0004\b%\u0010&J\b\u0010\u0003\u001a\u00020\u0002H\u0002R\u001d\u0010\t\u001a\u0004\u0018\u00010\u00048BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\bR\u001d\u0010\f\u001a\u0004\u0018\u00010\u00048BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u0006\u001a\u0004\b\u000b\u0010\bR\u001b\u0010\u0011\u001a\u00020\r8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000e\u0010\u0006\u001a\u0004\b\u000f\u0010\u0010R\u001b\u0010\u0014\u001a\u00020\u00048BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0012\u0010\u0006\u001a\u0004\b\u0013\u0010\bR\u001b\u0010\u0017\u001a\u00020\u00048BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0015\u0010\u0006\u001a\u0004\b\u0016\u0010\bR\u001b\u0010\u001c\u001a\u00020\u00188BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0019\u0010\u0006\u001a\u0004\b\u001a\u0010\u001bR\u001b\u0010\u001f\u001a\u00020\u00188BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001d\u0010\u0006\u001a\u0004\b\u001e\u0010\u001b¨\u0006("}, d2 = {"Lcom/bytedance/awemeopen/apps/framework/feed/ui/view/LongPressSpeedView;", "Landroid/widget/FrameLayout;", "", "getLayoutId", "Landroid/view/View;", "b", "Lkotlin/Lazy;", "getMSpeedTextContainer", "()Landroid/view/View;", "mSpeedTextContainer", "c", "getMSpeedImageView", "mSpeedImageView", "Landroid/widget/TextView;", "d", "getMSpeedText", "()Landroid/widget/TextView;", "mSpeedText", "e", "getMPreTriangle", "mPreTriangle", "f", "getMNextTriangle", "mNextTriangle", "Lcom/bytedance/awemeopen/apps/framework/feed/ui/view/PinchRippleContainer;", ce.f26391f, "getMLeftRipple", "()Lcom/bytedance/awemeopen/apps/framework/feed/ui/view/PinchRippleContainer;", "mLeftRipple", "h", "getMRightRipple", "mRightRipple", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "ao_apps_framework_release"}, k = 1, mv = {1, 7, 1})
public final class LongPressSpeedView extends FrameLayout {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final /* synthetic */ int f196807m = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final View f196808a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Lazy f196809b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Lazy f196810c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Lazy f196811d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Lazy f196812e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Lazy f196813f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Lazy f196814g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Lazy f196815h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public ObjectAnimator f196816i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public ObjectAnimator f196817j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public c f196818k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f196819l;

    public static final class a {
    }

    public static final class b extends AnimatorListenerAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ LongPressSpeedView f196820a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ View f196821b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ float f196822c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ float f196823d;

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator r100) {
            Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
            LongPressSpeedView r101 = this.f196820a;
            View r102 = this.f196821b;
            float r103 = this.f196822c;
            float r104 = this.f196823d;
            int r105 = LongPressSpeedView.f196807m;
            r101.c(r102, false, r103, r104);
        }

        public b(LongPressSpeedView r100, View r101, float r102, float r103) {
            this.f196820a = r100;
            this.f196821b = r101;
            this.f196822c = r102;
            this.f196823d = r103;
        }
    }

    static {
    }

    public LongPressSpeedView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public LongPressSpeedView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 4, 0);
    }

    private final int getLayoutId() {
        return R.layout.familiar_speed_long_press_fast_speed;
    }

    @Override // android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent r100) {
        return true;
    }

    private final PinchRippleContainer getMLeftRipple() {
        return (PinchRippleContainer) this.f196814g.getValue();
    }

    private final View getMNextTriangle() {
        return (View) this.f196813f.getValue();
    }

    private final View getMPreTriangle() {
        return (View) this.f196812e.getValue();
    }

    private final PinchRippleContainer getMRightRipple() {
        return (PinchRippleContainer) this.f196815h.getValue();
    }

    private final View getMSpeedImageView() {
        return (View) this.f196810c.getValue();
    }

    private final TextView getMSpeedText() {
        return (TextView) this.f196811d.getValue();
    }

    private final View getMSpeedTextContainer() {
        return (View) this.f196809b.getValue();
    }

    public final void d() {
        View r100 = getMNextTriangle();
        if (r100 == null) goto L5;
        r100.clearAnimation();
    L5:
        View r101 = getMNextTriangle();
        if (r101 == null) goto L10;
        ViewPropertyAnimator r102 = r101.animate();
        if (r102 == null) goto L10;
        r102.cancel();
    L10:
        ObjectAnimator r103 = this.f196817j;
        if (r103 == null) goto L13;
        r103.cancel();
    L13:
        View r104 = getMPreTriangle();
        if (r104 == null) goto L16;
        r104.clearAnimation();
    L16:
        View r105 = getMPreTriangle();
        if (r105 == null) goto L21;
        ViewPropertyAnimator r106 = r105.animate();
        if (r106 == null) goto L21;
        r106.cancel();
    L21:
        ObjectAnimator r107 = this.f196816i;
        if (r107 == null) goto L24;
        r107.cancel();
    L24:
        animate().cancel();
        clearAnimation();
    }

    public static final /* synthetic */ View a(LongPressSpeedView r100) {
        return r100.getMNextTriangle();
    }

    public static final /* synthetic */ View b(LongPressSpeedView r100) {
        return r100.getMPreTriangle();
    }

    public final void e(c r110) {
        this.f196818k = r110;
        ViewGroup.LayoutParams r111 = getMLeftRipple().getLayoutParams();
        ViewGroup.MarginLayoutParams r100 = null;
        if ((r111 instanceof ViewGroup.MarginLayoutParams) == false) goto L5;
        ViewGroup.MarginLayoutParams r112 = (ViewGroup.MarginLayoutParams) r111;
    L6:
        ViewGroup.LayoutParams r101 = getMRightRipple().getLayoutParams();
        if ((r101 instanceof ViewGroup.MarginLayoutParams) == false) goto L9;
        r100 = (ViewGroup.MarginLayoutParams) r101;
    L9:
        getMLeftRipple().setLayoutParams(r112);
        getMRightRipple().setLayoutParams(r100);
        d();
        setAlpha(1.0f);
        setVisibility(0);
        getMPreTriangle().setAlpha(0.0f);
        getMNextTriangle().setAlpha(0.0f);
        getMLeftRipple().setAlpha(0.0f);
        getMRightRipple().setAlpha(0.0f);
        int r102 = (int) (d0.d(getContext()) * 0.19f);
        getMLeftRipple().getLayoutParams().width = r102;
        getMRightRipple().getLayoutParams().width = r102;
        getMLeftRipple().invalidate();
        getMRightRipple().invalidate();
        int r103 = g.f21925a;
        if (g.a(this.f196818k) == false) goto L24;
        View r104 = getMSpeedImageView();
        if (r104 == null) goto L15;
        r104.setVisibility(0);
    L15:
        View r105 = getMPreTriangle();
        if (r105 == null) goto L19;
        r105.setVisibility(0);
    L19:
        View r106 = getMNextTriangle();
        if (r106 == null) goto L23;
        r106.setVisibility(0);
    L23:
        getMSpeedText().setText(getResources().getString(R.string.aos_familiar_long_press_speed_text));
    L58:
        SharedPreferences r107 = d.f21916b;
        if (r107.getInt("long_press_highlight_show_times", 0) >= 3) goto L61;
        boolean r108 = true;
    L62:
        if (r108 == false) goto L67;
        if (this.f196819l == true) goto L67;
        c(getMLeftRipple(), true, -10.0f, 0.0f);
        c(getMRightRipple(), true, 10.0f, 0.0f);
        r107.edit().putInt("long_press_highlight_show_times", r107.getInt("long_press_highlight_show_times", 0) + 1).apply();
    L67:
        if (g.a(this.f196818k) == false) goto L87;
        getMPreTriangle().setVisibility(0);
        getMNextTriangle().setVisibility(0);
        View r109 = getMSpeedImageView();
        if (r109 == null) goto L72;
        r109.setVisibility(0);
    L72:
        ObjectAnimator r113 = ObjectAnimator.ofFloat(getMNextTriangle(), "alpha", new float[]{0.5f, 0.2f});
        r113.setDuration(400);
        r113.addListener(new com.bytedance.awemeopen.apps.framework.feed.ui.view.a(this));
        r113.start();
        ObjectAnimator r114 = ObjectAnimator.ofFloat(getMNextTriangle(), "alpha", new float[]{1.0f, 0.5f, 0.2f});
        this.f196817j = r114;
        if (r114 == null) goto L76;
        r114.setDuration(800);
    L76:
        ObjectAnimator r115 = this.f196817j;
        if (r115 == null) goto L80;
        r115.setRepeatCount(-1);
    L80:
        ObjectAnimator r116 = this.f196817j;
        if (r116 == null) goto L84;
        r116.setRepeatMode(2);
    L84:
        ObjectAnimator r117 = this.f196817j;
        if (r117 == null) goto L91;
        r117.start();
    L91:
        this.f196819l = true;
        return;
    L87:
        getMPreTriangle().setVisibility(8);
        getMNextTriangle().setVisibility(8);
        View r118 = getMSpeedImageView();
        if (r118 == null) goto L91;
        r118.setVisibility(8);
        goto L91
    L61:
        r108 = false;
        goto L62
    L24:
        View r119 = getMSpeedImageView();
        if (r119 == null) goto L28;
        r119.setVisibility(8);
    L28:
        View r120 = getMPreTriangle();
        if (r120 == null) goto L32;
        r120.setVisibility(8);
    L32:
        View r121 = getMNextTriangle();
        if (r121 == null) goto L36;
        r121.setVisibility(8);
    L36:
        c r122 = this.f196818k;
        if (r122 != null) goto L39;
    L41:
        boolean r123 = false;
    L42:
        if (r123 == true) goto L52;
        c r124 = this.f196818k;
        if (r124 != null) goto L46;
    L48:
        boolean r125 = false;
    L49:
        if (r125 == true) goto L52;
        boolean r126 = false;
    L53:
        TextView r127 = getMSpeedText();
        StringCompanionObject r128 = StringCompanionObject.INSTANCE;
        String r129 = getResources().getString(R.string.familiar_long_press_disable_tips);
        Object[] r130 = new Object[1];
        if (r126 == false) goto L56;
        String r131 = "图文";
    L57:
        r130[0] = r131;
        r127.setText(String.format(r129, Arrays.copyOf(r130, 1)));
        goto L58
    L56:
        r131 = "视频";
        goto L57
    L46:
        if (r124.i() != 2) goto L48;
        r125 = true;
    L52:
        r126 = true;
        goto L53
    L39:
        if (r122.i() != 68) goto L41;
        r123 = true;
        goto L42
    L5:
        r112 = null;
        goto L6
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent r100) {
        return super.onTouchEvent(r100);
    }

    public LongPressSpeedView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        new LinkedHashMap();
        super(r100, r101, r102);
        this.f196808a = LayoutInflater.from(r100).inflate(getLayoutId(), this);
        this.f196809b = LazyKt.lazy(new LongPressSpeedView$mSpeedTextContainer$2(this));
        this.f196810c = LazyKt.lazy(new LongPressSpeedView$mSpeedImageView$2(this));
        this.f196811d = LazyKt.lazy(new LongPressSpeedView$mSpeedText$2(this));
        this.f196812e = LazyKt.lazy(new LongPressSpeedView$mPreTriangle$2(this));
        this.f196813f = LazyKt.lazy(new LongPressSpeedView$mNextTriangle$2(this));
        this.f196814g = LazyKt.lazy(new LongPressSpeedView$mLeftRipple$2(this));
        this.f196815h = LazyKt.lazy(new LongPressSpeedView$mRightRipple$2(this));
    }

    public /* synthetic */ LongPressSpeedView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }

    public final void c(View r100, boolean r101, float r110, float r111) {
        r100.setVisibility(0);
        AnimatorSet r102 = new AnimatorSet();
        float[] r103 = new float[2];
        float r104 = 1.0f;
        if (r101 == false) goto L5;
        float r105 = 0.0f;
    L6:
        r103[0] = r105;
        if (r101 == true) goto L10;
        r104 = 0.0f;
    L10:
        r103[1] = r104;
        r102.playTogether(new Animator[]{ObjectAnimator.ofFloat(r100, "alpha", r103), ObjectAnimator.ofFloat(r100, LiveDegradeFpsAnimator.TRANSLATION_X, new float[]{r110, r111})});
        r102.setDuration(1600);
        r102.setInterpolator(new c04.b());
        if (r101 == false) goto L13;
        r102.addListener(new b(this, r100, r111, r110));
    L13:
        r102.start();
        return;
    L5:
        r105 = 1.0f;
        goto L6
    }
}
