package com.larus.livetutor.impl.view;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.graphics.Insets;
import androidx.core.view.WindowInsetsCompat;
import androidx.core.view.WindowInsetsControllerCompat;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.viewbinding.ViewBindings;
import com.larus.common_ui.venus.ShapeLinearLayout;
import com.larus.livetutor.api.idl.WaitButtonConfig;
import com.larus.livetutor.api.idl.WaitButtonConfigStrategy;
import com.larus.livetutor.impl.databinding.LiveTutorTeachLayoutBinding;
import com.larus.livetutor.impl.home.LiveTutorInputFragment;
import com.larus.livetutor.impl.repository.viewmodel.LiveTutorViewModel;
import com.larus.livetutor.impl.tutor.data.LiveTutorPauseEvent;
import com.larus.livetutor.impl.utils.UtilsKt;
import com.larus.livetutor.impl.utils.track.LiveTutorTrackerService;
import com.larus.nova.R;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.List;
import kotlin.Function;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import v19.c7;
import v19.i5;
import v19.l5;

/* JADX INFO: loaded from: classes30.dex */
@Metadata(d1 = {"\u0000\u0094\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 X2\u00020\u0001:\u0001XB'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\b\u0010=\u001a\u00020>H\u0002J\b\u0010?\u001a\u00020>H\u0002J\b\u0010@\u001a\u00020>H\u0002J\u0010\u0010A\u001a\u00020>2\u0006\u0010B\u001a\u00020CH\u0002J\b\u0010D\u001a\u00020&H\u0002J\b\u0010E\u001a\u00020&H\u0002J\b\u0010F\u001a\u000205H\u0002J\b\u0010G\u001a\u00020>H\u0002J\b\u0010H\u001a\u00020>H\u0002J\b\u0010I\u001a\u00020>H\u0002J\u0010\u0010J\u001a\u00020>2\u0006\u0010K\u001a\u00020LH\u0002J\b\u0010M\u001a\u00020>H\u0002J\b\u0010N\u001a\u00020>H\u0002J\b\u0010O\u001a\u00020;H\u0002J\u0010\u0010P\u001a\u00020/2\u0006\u0010Q\u001a\u00020RH\u0016J\u0010\u0010S\u001a\u00020/2\u0006\u0010Q\u001a\u00020RH\u0002J\b\u0010T\u001a\u00020\u0007H\u0002J\u0006\u0010U\u001a\u00020\u0007J\f\u0010V\u001a\u00020>*\u00020\u001fH\u0002J\b\u0010W\u001a\u00020>H\u0014R(\u0010\f\u001a\u0004\u0018\u00010\u000b2\b\u0010\n\u001a\u0004\u0018\u00010\u000b@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\u0013\u001a\u00020\u00148FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0015\u0010\u0016R\u001b\u0010\u0019\u001a\u00020\u001a8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u001d\u0010\u0018\u001a\u0004\b\u001b\u0010\u001cR\u001b\u0010\u001e\u001a\u00020\u001f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\"\u0010\u0018\u001a\u0004\b \u0010!R\u0010\u0010#\u001a\u0004\u0018\u00010$X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010%\u001a\u00020&8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b)\u0010\u0018\u001a\u0004\b'\u0010(R\u001b\u0010*\u001a\u00020&8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b,\u0010\u0018\u001a\u0004\b+\u0010(R\u0010\u0010-\u001a\u0004\u0018\u00010&X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010.\u001a\u00020/X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00100\u001a\u000201X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u00102\u001a\u000203X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u00104\u001a\u0002058BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b8\u0010\u0018\u001a\u0004\b6\u00107R\u000e\u00109\u001a\u00020/X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010:\u001a\u0004\u0018\u00010;X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010<\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006Y"}, d2 = {"Lcom/larus/livetutor/impl/view/LiveTutorTeachView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "value", "Lcom/larus/livetutor/impl/repository/viewmodel/LiveTutorViewModel;", "viewModel", "getViewModel", "()Lcom/larus/livetutor/impl/repository/viewmodel/LiveTutorViewModel;", "setViewModel", "(Lcom/larus/livetutor/impl/repository/viewmodel/LiveTutorViewModel;)V", "binding", "Lcom/larus/livetutor/impl/databinding/LiveTutorTeachLayoutBinding;", "bulletContainerView", "Landroid/view/ViewGroup;", "getBulletContainerView", "()Landroid/view/ViewGroup;", "bulletContainerView$delegate", "Lkotlin/Lazy;", "voiceOperationView", "Lcom/larus/livetutor/impl/view/LiveTutorVoiceView;", "getVoiceOperationView", "()Lcom/larus/livetutor/impl/view/LiveTutorVoiceView;", "voiceOperationView$delegate", "inputFragmentContainer", "Landroid/view/View;", "getInputFragmentContainer", "()Landroid/view/View;", "inputFragmentContainer$delegate", "continueBtn", "Lcom/larus/livetutor/impl/view/LiveTutorContinueButton;", "liveTutorPauseContainerHideAnim", "Landroid/animation/Animator;", "getLiveTutorPauseContainerHideAnim", "()Landroid/animation/Animator;", "liveTutorPauseContainerHideAnim$delegate", "liveTutorPauseContainerShowAnim", "getLiveTutorPauseContainerShowAnim", "liveTutorPauseContainerShowAnim$delegate", "pauseClickAnim", "isLongPressing", "", "longPressRunnable", "Ljava/lang/Runnable;", "pressStartTime", "", "inputFragment", "Lcom/larus/livetutor/impl/home/LiveTutorInputFragment;", "getInputFragment", "()Lcom/larus/livetutor/impl/home/LiveTutorInputFragment;", "inputFragment$delegate", "isKeyboardShown", "inputBackgroundDrawable", "Landroid/graphics/drawable/Drawable;", "navigationBarHeightCache", "initView", "", "updateMargin", "initObservers", "createAndShowContinueBtn", "waitButtonConfig", "Lcom/larus/livetutor/api/idl/WaitButtonConfig;", "createLiveTutorPauseContainerHideAnim", "createLiveTutorPauseContainerShowAnim", "createInputFragment", "setInputContainer", "onAsrStart", "onAsrEnd", "onAsrSucceed", "text", "", "onAsrCancel", "watchOnIme", "getInputBackground", "dispatchTouchEvent", "event", "Landroid/view/MotionEvent;", "isInInput", "getInputFragmentBottomMargin", "getInputFragmentHeight", "toggleWithAnim", "onDetachedFromWindow", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class LiveTutorTeachView extends ConstraintLayout {

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final /* synthetic */ int f356736q = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public LiveTutorViewModel f356737a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final LiveTutorTeachLayoutBinding f356738b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Lazy f356739c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Lazy f356740d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Lazy f356741e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public LiveTutorContinueButton f356742f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Lazy f356743g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Lazy f356744h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public Animator f356745i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f356746j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final h1 f356747k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public long f356748l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final Lazy f356749m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f356750n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public com.larus.livetutor.impl.utils.f f356751o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final int f356752p;

    public static final class a {
    }

    public static final class b implements Observer, FunctionAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function1 f356753a;

        public b(Function1 r100) {
            Intrinsics.checkNotNullParameter(r100, "function");
            this.f356753a = r100;
        }

        public final boolean equals(Object r100) {
            if ((r100 instanceof Observer) == true) goto L5;
            return false;
        L5:
            if ((r100 instanceof FunctionAdapter) == true) goto L7;
            return false;
        L7:
            return Intrinsics.areEqual(getFunctionDelegate(), ((FunctionAdapter) r100).getFunctionDelegate());
        }

        @Override // kotlin.jvm.internal.FunctionAdapter
        public final Function<?> getFunctionDelegate() {
            return this.f356753a;
        }

        public final int hashCode() {
            return getFunctionDelegate().hashCode();
        }

        @Override // androidx.lifecycle.Observer
        public final /* synthetic */ void onChanged(Object r100) {
            this.f356753a.invoke(r100);
        }
    }

    static {
    }

    public LiveTutorTeachView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public LiveTutorTeachView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 4, 0);
    }

    private final Drawable getInputBackground() {
        com.larus.livetutor.impl.utils.f r100 = this.f356751o;
        if (r100 != null) goto L9;
        int[] r101 = {0, -1, -1};
        float[] r102 = {0.0f, 0.5f, 1.0f};
        Point r103 = new Point(0, 0);
        View r104 = getInputFragment().f356115d;
        if (r104 == null) goto L7;
        int r105 = r104.getHeight();
    L8:
        r100 = new com.larus.livetutor.impl.utils.f(r101, r102, r103, new Point(0, r105));
        this.f356751o = r100;
        goto L9
    L7:
        r105 = ((Number) i5.f552514j0.getValue()).intValue();
    L9:
        return r100;
    }

    private final LiveTutorInputFragment getInputFragment() {
        return (LiveTutorInputFragment) this.f356749m.getValue();
    }

    private final int getInputFragmentBottomMargin() {
        int r100 = this.f356752p;
        if (r100 <= 0) goto L6;
        return r100;
    L6:
        return i5.h();
    }

    private final View getInputFragmentContainer() {
        return (View) this.f356741e.getValue();
    }

    private final Animator getLiveTutorPauseContainerHideAnim() {
        return (Animator) this.f356743g.getValue();
    }

    private final Animator getLiveTutorPauseContainerShowAnim() {
        return (Animator) this.f356744h.getValue();
    }

    public final ViewGroup getBulletContainerView() {
        return (ViewGroup) this.f356739c.getValue();
    }

    public final int getInputFragmentHeight() {
        return this.f356738b.f355994e.getMeasuredHeight();
    }

    public final LiveTutorVoiceView getVoiceOperationView() {
        return (LiveTutorVoiceView) this.f356740d.getValue();
    }

    public final void o6() {
        com.larus.platform.service.e2 r100 = com.larus.platform.service.e2.f365734a;
        if (r100.isPad() == true) goto L5;
    L7:
        Number r101 = Integer.valueOf(i5.o());
    L8:
        int r102 = r101.intValue();
        int r103 = getInputFragmentBottomMargin();
        if (r100.isPad() == false) goto L11;
        int r104 = r102 - i5.h();
    L12:
        LiveTutorInputFragment.T90(getInputFragment(), Integer.valueOf(r104), Integer.valueOf(r104), Integer.valueOf(r103));
        int r105 = this.f356738b.f355994e.getMeasuredHeight() + i5.e0();
        UtilsKt.g(getVoiceOperationView(), Integer.valueOf(r102), null, Integer.valueOf(r102), Integer.valueOf(r105), 2);
        UtilsKt.g(this.f356738b.f355992c, null, null, null, Integer.valueOf(r105 - i5.r0()), 7);
        LiveTutorContinueButton r110 = this.f356742f;
        if (r110 == null) goto L16;
        UtilsKt.g(r110, null, null, Integer.valueOf(r104), null, 11);
        return;
    L16:
        return;
    L11:
        r104 = 0;
        goto L12
    L5:
        if (getContext().getResources().getConfiguration().orientation != 2) goto L7;
        r101 = Float.valueOf(com.larus.utils.i.d(getContext()) * 0.125f);
        goto L8
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        Animator r100 = this.f356745i;
        if (r100 == null) goto L5;
        r100.cancel();
    L5:
        this.f356745i = null;
    }

    public final LiveTutorViewModel getViewModel() {
        return this.f356737a;
    }

    public static Unit U5(LiveTutorTeachView r100) {
        boolean r101 = com.larus.utils.e1.s(r100);
        boolean r102 = kj9.b.f503724a;
        kj9.b.a("[LiveTutorTeachView] watchOnImeInsetsAnimation onStart, imeShow = " + r101);
        if (r101 == r100.f356750n) goto L7;
        r100.f356750n = r101;
        LiveTutorViewModel r103 = r100.f356737a;
        if (r103 == null) goto L7;
        r103.updateKeyboardShowing(r101);
    L7:
        LiveTutorInputFragment r104 = r100.getInputFragment();
        if (r101 == false) goto L10;
        Drawable r105 = r100.getInputBackground();
    L11:
        View r106 = r104.S90();
        if (r106 == null) goto L15;
        r106.setBackground(r105);
    L15:
        if (r100.getInputFragment().isAdded() == false) goto L22;
        LiveTutorInputFragment r107 = r100.getInputFragment();
        if (r101 == false) goto L19;
        Context r108 = UtilsKt.c();
        int r109 = R.string.larus_tutor_text_enter_keyboard_cn;
    L20:
        String r110 = r108.getString(r109);
        Intrinsics.checkNotNull(r110);
        r107.S6(r110);
        goto L22
    L19:
        r108 = UtilsKt.c();
        r109 = R.string.larus_tutor_text_enter_cn;
    L22:
        return Unit.INSTANCE;
    L10:
        r105 = new ColorDrawable(0);
        goto L11
    }

    public static void V5(LiveTutorTeachView r100) {
        FragmentActivity r101 = com.larus.utils.i.a(r100.getContext());
        if (r101 == null) goto L12;
        FragmentManager r102 = r101.getSupportFragmentManager();
        if (r102 == null) goto L13;
        FragmentTransaction r103 = r102.beginTransaction();
        LiveTutorInputFragment r104 = r100.getInputFragment();
        if (LandscapeRestrictionGuard.shouldBlockFragmentTransaction(r103, r104, LandscapeRestrictionOperation.FRAGMENT_TRANSACTION_REPLACE, null, R.id.voice_btn_container) == true) goto L10;
        r103.replace(R.id.voice_btn_container, r104);
    L10:
        r103.commitNowAllowingStateLoss();
        return;
    L13:
        return;
    }

    public static Unit Y5(LiveTutorTeachView r100) {
        r100.o6();
        r100.getInputFragment().hideKeyboard();
        return Unit.INSTANCE;
    }

    public static final /* synthetic */ LiveTutorInputFragment i6(LiveTutorTeachView r100) {
        return r100.getInputFragment();
    }

    public static final /* synthetic */ int k6(LiveTutorTeachView r100) {
        return r100.getInputFragmentBottomMargin();
    }

    public static final /* synthetic */ Animator n6(LiveTutorTeachView r100) {
        return r100.getLiveTutorPauseContainerShowAnim();
    }

    @Override // android.view.ViewGroup, android.view.View
    public final boolean dispatchTouchEvent(MotionEvent r100) {
        Intrinsics.checkNotNullParameter(r100, "event");
        if (r100.getAction() != 0) goto L11;
        if (this.f356750n == false) goto L11;
        Rect r101 = new Rect();
        getInputFragmentContainer().getGlobalVisibleRect(r101);
        if (r101.contains((int) r100.getRawX(), (int) r100.getRawY()) == true) goto L11;
        getInputFragment().hideKeyboard();
        return true;
    L11:
        return super.dispatchTouchEvent(r100);
    }

    public final void setViewModel(LiveTutorViewModel r100) {
        this.f356737a = r100;
        if (r100 == null) goto L26;
        LifecycleOwner r101 = r100.getLifecycleOwner();
        if (r101 == null) goto L29;
        UtilsKt.w(this, new LiveTutorTeachView$initObservers$1(this, null));
        LiveTutorViewModel r102 = this.f356737a;
        if (r102 == null) goto L10;
        r102.setLocalVolumeListener(new r0(this));
    L10:
        LiveTutorViewModel r103 = this.f356737a;
        if (r103 == null) goto L15;
        MutableLiveData<Boolean> r104 = r103.getKeyboardEvent();
        if (r104 == null) goto L15;
        r104.observe(r101, new b(new z0(this)));
    L15:
        LiveTutorViewModel r105 = this.f356737a;
        if (r105 == null) goto L20;
        MutableLiveData<Configuration> r106 = r105.getActivityConfiguration();
        if (r106 == null) goto L20;
        r106.observe(r101, new b(new a1(this)));
    L20:
        LiveTutorViewModel r107 = this.f356737a;
        if (r107 == null) goto L27;
        LiveData<LiveTutorPauseEvent> r108 = r107.getPauseRtc();
        if (r108 == null) goto L28;
        r108.observe(r101, new b(new b1(this)));
        return;
    L28:
        return;
    L27:
        return;
    L29:
        return;
    }

    public static Unit R5(LiveTutorTeachView r100, View r101) {
        boolean r102 = com.larus.utils.e1.s(r100);
        boolean r103 = kj9.b.f503724a;
        kj9.b.a("[LiveTutorTeachView] watchOnImeInsetsAnimation onEnd, imeShow = " + r102);
        if (r102 == true) goto L14;
        View r104 = r100.getInputFragment().f356115d;
        if (r104 == null) goto L7;
        View r105 = r104.findViewById(R.id.input_text);
    L8:
        if (r105 == null) goto L11;
        r105.clearFocus();
    L11:
        if (r101.getPaddingBottom() == 0) goto L14;
        r101.setPadding(0, 0, 0, 0);
        goto L14
    L7:
        r105 = null;
    L14:
        return Unit.INSTANCE;
    }

    public static Unit T5(LiveTutorTeachView r100, int r101) {
        LiveTutorInputFragment r102 = r100.getInputFragment();
        if (r102.isAdded() == false) goto L9;
        FLogger.f375446a.e("LiveTutorInputFragment", "setVolume: " + r101);
        va8.i0 r103 = (va8.i0) s1a.a.g(r102).getAbility(va8.i0.class);
        if (r103 == null) goto L9;
        r103.ea(r101 / 255.0f);
    L9:
        return Unit.INSTANCE;
    }

    public static Unit Z5(LiveTutorTeachView r100, Boolean r101) {
        if (r101.booleanValue() == false) goto L24;
        View r102 = r100.getInputFragment().f356115d;
        InputMethodManager r103 = null;
        if (r102 == null) goto L7;
        View r104 = r102.findViewById(R.id.input_text);
    L8:
        if (r104 == null) goto L26;
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r104, "view");
        Context r105 = r100.getContext();
        if ((r105 instanceof Activity) == false) goto L12;
        Activity r106 = (Activity) r105;
    L13:
        if (r106 == null) goto L26;
        Window r107 = r106.getWindow();
        if (r107 == null) goto L26;
        if (Build.VERSION.SDK_INT < 30) goto L19;
        new WindowInsetsControllerCompat(r107, r104).show(WindowInsetsCompat.Type.ime());
        goto L26
    L19:
        Object r108 = r100.getContext().getSystemService("input_method");
        if ((r108 instanceof InputMethodManager) == false) goto L22;
        r103 = (InputMethodManager) r108;
    L22:
        if (r103 == null) goto L26;
        r103.showSoftInput(r104, 0);
        goto L26
    L12:
        r106 = null;
    L26:
        return Unit.INSTANCE;
    L7:
        r104 = null;
        goto L8
    L24:
        r100.getInputFragment().hideKeyboard();
        goto L26
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final void c6(final LiveTutorTeachView r100, WaitButtonConfig r101) {
        r100.getClass();
        List<WaitButtonConfigStrategy> r102 = r101.getWaitButtons();
        boolean r103 = true;
        int r104 = 0;
        if (r102 != null) goto L5;
    L8:
        boolean r105 = true;
    L9:
        if (r105 == true) goto L60;
        List<WaitButtonConfigStrategy> r106 = r101.getWaitButtons();
        if (r106 == null) goto L58;
        final WaitButtonConfigStrategy r107 = (WaitButtonConfigStrategy) CollectionsKt.firstOrNull(r106);
        if (r107 == null) goto L61;
        Integer r108 = null;
        if (r100.f356742f != null) goto L26;
        LiveTutorContinueButton r109 = new LiveTutorContinueButton(r100.getContext(), null == true ? 1 : 0, 6, r104);
        ConstraintLayout.LayoutParams r110 = new ConstraintLayout.LayoutParams(c7.b(151), c7.b(122));
        ViewGroup.LayoutParams r111 = r100.f356738b.f355992c.getLayoutParams();
        if ((r111 instanceof ViewGroup.MarginLayoutParams) == false) goto L21;
        ViewGroup.MarginLayoutParams r112 = (ViewGroup.MarginLayoutParams) r111;
    L22:
        if (r112 == null) goto L24;
        int r113 = r112.bottomMargin;
    L25:
        ((ViewGroup.MarginLayoutParams) r110).bottomMargin = r113 - i5.J();
        r110.bottomToBottom = 0;
        r110.rightToRight = 0;
        com.larus.utils.e1.o(r109);
        r100.addView(r109, r110);
        r100.f356742f = r109;
        goto L26
    L24:
        r113 = 0;
        goto L25
    L21:
        r112 = null;
    L26:
        final LiveTutorContinueButton r114 = r100.f356742f;
        if (r114 == null) goto L54;
        kj9.b.a("[LiveTutorTeachView] show continueBtn");
        String r115 = r107.getButtonText();
        if (r115 != null) goto L31;
        r115 = "";
    L31:
        Intrinsics.checkNotNullParameter(r115, "text");
        r114.f356709d = r115;
        r114.f356706a.f355937b.setText(r115);
        r114.setOnClick(new t0(r100, r107, r114));
        Animator r116 = r100.getLiveTutorPauseContainerHideAnim();
        Intrinsics.checkNotNullParameter(r116, "pauseAnim");
        if (r114.f356707b != null) goto L46;
        ObjectAnimator r117 = ObjectAnimator.ofFloat(r114.f356706a.f355936a, View.ALPHA, new float[]{0.0f, 1.0f});
        Intrinsics.checkNotNull(r117);
        r117.addListener(new r(r114));
        ViewGroup.LayoutParams r118 = r114.f356706a.f355937b.getLayoutParams();
        if (r118 == null) goto L43;
        Integer r119 = Integer.valueOf(r118.width);
        if (r119.intValue() <= 0) goto L38;
        boolean r120 = true;
    L39:
        if (r120 == false) goto L41;
        r108 = r119;
    L41:
        if (r108 == null) goto L43;
        int r121 = r108.intValue();
    L44:
        ValueAnimator r122 = ValueAnimator.ofInt(new int[]{c7.b(40), r121});
        r122.addUpdateListener(new q(r114));
        Intrinsics.checkNotNull(r122);
        r122.addListener(new t(r114));
        r122.addListener(new s(r114));
        AnimatorSet r123 = new AnimatorSet();
        r123.play(r117).with(r122).after(r116);
        r123.setInterpolator(new l5());
        r123.setDuration(150);
        r114.f356707b = r123;
        goto L46
    L38:
        r120 = false;
    L43:
        r121 = c7.b(86);
    L46:
        if (r114.getVisibility() == 0) goto L49;
        r103 = false;
    L49:
        if (r103 == true) goto L53;
        AnimatorSet r124 = r114.f356707b;
        if (r124 == null) goto L54;
        r124.start();
        goto L54
    L53:
        com.larus.utils.e1.x(r114);
        r116.end();
    L54:
        LiveTutorTrackerService r125 = kj9.b.c();
        if (r125 == null) goto L59;
        com.larus.livetutor.impl.utils.track.a.b(r125, "go_on", null, null, null, null, null, 62);
        return;
    L59:
        return;
    L61:
        return;
    L58:
        return;
    L60:
        return;
    L5:
        if (r102.isEmpty() == true) goto L8;
        r105 = false;
        goto L9
    }

    /* JADX WARN: Type inference failed for: r0v17, types: [com.larus.livetutor.impl.view.h1] */
    public LiveTutorTeachView(Context r100, AttributeSet r110, int r111) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r110, r111);
        LayoutInflater.from(r100).inflate(R.layout.live_tutor_teach_layout, this);
        int r112 = R.id.hybrid_container;
        FrameLayout r101 = (FrameLayout) ViewBindings.findChildViewById(this, R.id.hybrid_container);
        if (r101 == null) goto L17;
        r112 = R.id.live_tutor_pause_container;
        ShapeLinearLayout r113 = (ShapeLinearLayout) ViewBindings.findChildViewById(this, R.id.live_tutor_pause_container);
        if (r113 == null) goto L17;
        r112 = R.id.live_tutor_pause_icon;
        ImageView r102 = (ImageView) ViewBindings.findChildViewById(this, R.id.live_tutor_pause_icon);
        if (r102 == null) goto L17;
        r112 = R.id.state_anim;
        if (((ImageView) ViewBindings.findChildViewById(this, R.id.state_anim)) == null) goto L17;
        r112 = R.id.voice_btn_container;
        FrameLayout r103 = (FrameLayout) ViewBindings.findChildViewById(this, R.id.voice_btn_container);
        if (r103 == null) goto L17;
        r112 = R.id.voice_operation_view;
        LiveTutorVoiceView r104 = (LiveTutorVoiceView) ViewBindings.findChildViewById(this, R.id.voice_operation_view);
        if (r104 == null) goto L17;
        this.f356738b = new LiveTutorTeachLayoutBinding(this, r101, r113, r102, r103, r104);
        LazyThreadSafetyMode r114 = LazyThreadSafetyMode.NONE;
        this.f356739c = LazyKt.lazy(r114, new c1(this));
        this.f356740d = LazyKt.lazy(r114, new d1(this));
        this.f356741e = LazyKt.lazy(r114, new e1(this));
        this.f356743g = LazyKt.lazy(r114, new f1(this));
        this.f356744h = LazyKt.lazy(r114, new g1(this));
        this.f356747k = new h1(this);
        this.f356749m = LazyKt.lazy(r114, new s0(this));
        this.f356752p = com.larus.utils.u.b(com.larus.utils.i.a(r100));
        setClipChildren(false);
        post(new x0(this));
        UtilsKt.h(r113, new y0(this));
        r102.setSelected(true);
        return;
    L17:
        throw new NullPointerException("Missing required view with ID: ".concat(getResources().getResourceName(r112)));
    }

    public static Unit S5(LiveTutorTeachView r100, View r101, Insets r102) {
        Intrinsics.checkNotNullParameter(r102, "insets");
        View r103 = r100.getInputFragment().S90();
        if (r103 == null) goto L5;
        int r104 = r103.getPaddingBottom();
    L6:
        View r105 = r100.getInputFragment().S90();
        if (r105 == null) goto L15;
        ViewGroup.LayoutParams r106 = r105.getLayoutParams();
        if ((r106 instanceof ViewGroup.MarginLayoutParams) == false) goto L11;
        ViewGroup.MarginLayoutParams r107 = (ViewGroup.MarginLayoutParams) r106;
    L12:
        if (r107 == null) goto L14;
        int r108 = r107.bottomMargin;
    L16:
        r101.setPadding(0, 0, 0, RangesKt.coerceAtLeast((r102.bottom - r108) - r104, 0));
        return Unit.INSTANCE;
    L14:
        r108 = 0;
        goto L16
    L11:
        r107 = null;
        goto L12
    L15:
        r108 = r100.getInputFragmentBottomMargin();
        goto L16
    L5:
        r104 = 0;
        goto L6
    }

    public static Unit b6(LiveTutorTeachView r100, WaitButtonConfigStrategy r101, LiveTutorContinueButton r102) {
        LiveTutorViewModel r103 = r100.f356737a;
        if (r103 == null) goto L5;
        r103.handleContinueAction(r101.getAction());
    L5:
        r102.a(true, r100.getLiveTutorPauseContainerShowAnim());
        return Unit.INSTANCE;
    }

    public /* synthetic */ LiveTutorTeachView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
