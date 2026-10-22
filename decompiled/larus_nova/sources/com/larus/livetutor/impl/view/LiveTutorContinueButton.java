package com.larus.livetutor.impl.view;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import androidx.viewbinding.ViewBindings;
import com.bytedance.ee.bear.lynx.impl.xbridge.method.view.SendEventContainerMethodParamModel;
import com.larus.common_ui.venus.ShapeButton;
import com.larus.livetutor.impl.databinding.LiveTutorActionContinueBtnLayoutBinding;
import com.larus.livetutor.impl.utils.UtilsKt;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import v19.c7;
import v19.l5;

/* JADX INFO: loaded from: classes30.dex */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u000e\u0010\u0018\u001a\u00020\u00132\u0006\u0010\u0019\u001a\u00020\u0010J\u0016\u0010\u001a\u001a\u00020\u00132\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001eJ\u0016\u0010\u001f\u001a\u00020\u00132\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001eR\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\"\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u0012X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017¨\u0006 "}, d2 = {"Lcom/larus/livetutor/impl/view/LiveTutorContinueButton;", "Landroid/widget/FrameLayout;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "binding", "Lcom/larus/livetutor/impl/databinding/LiveTutorActionContinueBtnLayoutBinding;", "continueShowAnim", "Landroid/animation/AnimatorSet;", "continueHideAnim", "data", "", SendEventContainerMethodParamModel.EventKinds.onClick, "Lkotlin/Function0;", "", "getOnClick", "()Lkotlin/jvm/functions/Function0;", "setOnClick", "(Lkotlin/jvm/functions/Function0;)V", "updateBtnText", "text", "showContinueBtn", "needAnim", "", "pauseAnim", "Landroid/animation/Animator;", "hideContinueBtn", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class LiveTutorContinueButton extends FrameLayout {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final /* synthetic */ int f356705f = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LiveTutorActionContinueBtnLayoutBinding f356706a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public AnimatorSet f356707b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public AnimatorSet f356708c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f356709d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Function0<Unit> f356710e;

    public static final class a implements Animator.AnimatorListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ LiveTutorContinueButton f356711a;

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationCancel(Animator r100) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationRepeat(Animator r100) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationStart(Animator r100) {
        }

        public a(LiveTutorContinueButton r100) {
            this.f356711a = r100;
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator r100) {
            com.larus.utils.e1.o(this.f356711a);
        }
    }

    public static final class b implements Animator.AnimatorListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ LiveTutorContinueButton f356712a;

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationCancel(Animator r100) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator r100) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationRepeat(Animator r100) {
        }

        public b(LiveTutorContinueButton r100) {
            this.f356712a = r100;
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationStart(Animator r100) {
            this.f356712a.f356706a.f355937b.setText("");
        }
    }

    public LiveTutorContinueButton(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public LiveTutorContinueButton(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 4, 0);
    }

    public final Function0<Unit> getOnClick() {
        return this.f356710e;
    }

    public final void setOnClick(Function0<Unit> r100) {
        this.f356710e = r100;
    }

    public final void a(boolean r100, Animator r101) {
        Intrinsics.checkNotNullParameter(r101, "pauseAnim");
        boolean r102 = true;
        if (this.f356708c != null) goto L15;
        ObjectAnimator r103 = ObjectAnimator.ofFloat(this.f356706a.f355936a, View.ALPHA, new float[]{1.0f, 0.0f});
        Integer r104 = Integer.valueOf(this.f356706a.f355937b.getMeasuredWidth());
        if (r104.intValue() <= 0) goto L7;
        boolean r105 = true;
    L8:
        if (r105 == true) goto L11;
        r104 = null;
    L11:
        if (r104 == null) goto L13;
        int r106 = r104.intValue();
    L14:
        ValueAnimator r107 = ValueAnimator.ofInt(new int[]{r106, c7.b(40)});
        r107.addUpdateListener(new o(this));
        AnimatorSet r108 = new AnimatorSet();
        r108.play(r103).with(r107).before(r101);
        r108.setDuration(150);
        r108.setInterpolator(new l5());
        r108.addListener(new b(this));
        r108.addListener(new a(this));
        this.f356708c = r108;
        goto L15
    L13:
        r106 = c7.b(86);
        goto L14
    L7:
        r105 = false;
    L15:
        if (r100 == true) goto L17;
    L24:
        com.larus.utils.e1.o(this);
        r101.end();
        return;
    L17:
        if (getVisibility() == 0) goto L20;
        r102 = false;
    L20:
        if (r102 == false) goto L24;
        AnimatorSet r109 = this.f356708c;
        if (r109 == null) goto L26;
        r109.start();
        return;
    }

    public LiveTutorContinueButton(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        LayoutInflater.from(r100).inflate(R.layout.live_tutor_action_continue_btn_layout, this);
        int r103 = R.id.continue_button;
        ShapeButton r104 = (ShapeButton) ViewBindings.findChildViewById(this, R.id.continue_button);
        if (r104 == null) goto L9;
        r103 = R.id.mask;
        View r105 = ViewBindings.findChildViewById(this, R.id.mask);
        if (r105 == null) goto L9;
        this.f356706a = new LiveTutorActionContinueBtnLayoutBinding(this, r104, r105);
        this.f356709d = "";
        UtilsKt.h(r104, new p(this));
        return;
    L9:
        throw new NullPointerException("Missing required view with ID: ".concat(getResources().getResourceName(r103)));
    }

    public /* synthetic */ LiveTutorContinueButton(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
