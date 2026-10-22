package com.obric.assistant.component.task;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.transition.ChangeBounds;
import android.transition.Fade;
import android.transition.Transition;
import android.transition.TransitionManager;
import android.transition.TransitionSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleCoroutineScope;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import com.larus.nova.R;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.helpers.PopupWindowLancet;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Job;
import v19.c7;

/* JADX INFO: loaded from: classes33.dex */
public final class n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f388900a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final View f388901b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final LifecycleOwner f388902c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public TaskPanelView f388903d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public FrameLayout f388904e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public TaskPanelView f388905f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public PopupWindow f388906g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public Job f388907h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final ConstraintLayout f388908i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f388909j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f388910k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public List<com.obric.assistant.task.b> f388911l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f388912m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final int f388913n;

    public static final class a {
    }

    public static final class b implements Transition.TransitionListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Ref.BooleanRef f388914a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ n f388915b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ c f388916c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ View f388917d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ int f388918e;

        @Override // android.transition.Transition.TransitionListener
        public final void onTransitionPause(Transition r100) {
            Intrinsics.checkNotNullParameter(r100, "t");
        }

        @Override // android.transition.Transition.TransitionListener
        public final void onTransitionResume(Transition r100) {
            Intrinsics.checkNotNullParameter(r100, "t");
        }

        @Override // android.transition.Transition.TransitionListener
        public final void onTransitionCancel(Transition r100) {
            Intrinsics.checkNotNullParameter(r100, "t");
            n r101 = this.f388915b;
            int r102 = 0;
            r101.f388910k = false;
            r101.f388912m = false;
            TaskPanelView r103 = r101.f388903d;
            if (r103 != null) goto L5;
        L11:
            final n r104 = this.f388915b;
            TaskPanelView r105 = r104.f388903d;
            if (r105 == null) goto L15;
            final c r106 = this.f388916c;
            final View r107 = this.f388917d;
            final int r108 = this.f388918e;
            r105.post(new o(r104, r106, r107, r108));
            return;
        L15:
            return;
        L5:
            if (r101.f388909j == true) goto L7;
        L9:
            r102 = 8;
        L10:
            r103.setVisibility(r102);
            goto L11
        L7:
            if ((!r101.f388911l.isEmpty()) == false) goto L9;
            goto L9
        }

        @Override // android.transition.Transition.TransitionListener
        public final void onTransitionEnd(Transition r100) {
            Intrinsics.checkNotNullParameter(r100, "transition");
            n r101 = this.f388915b;
            int r102 = 0;
            if (r101.f388909j == false) goto L7;
            boolean r103 = true;
            if ((!r101.f388911l.isEmpty()) == false) goto L7;
        L8:
            FLogger r104 = FLogger.f375446a;
            if (r103 == false) goto L11;
            String r105 = "VISIBLE";
        L12:
            r104.i("TaskPanelController", "[TaskPanel-SM] collapseWithAnimation: END. Target CollapsedVisibility=".concat(r105));
            n r106 = this.f388915b;
            r106.f388910k = false;
            r106.f388912m = false;
            TaskPanelView r107 = r106.f388903d;
            if (r107 == null) goto L18;
            if (r103 == true) goto L17;
            r102 = 8;
        L17:
            r107.setVisibility(r102);
        L18:
            if (r103 == true) goto L22;
            TaskPanelView r108 = this.f388915b.f388905f;
            if (r108 == null) goto L22;
            r108.b(CollectionsKt.emptyList());
        L22:
            final n r109 = this.f388915b;
            TaskPanelView r110 = r109.f388903d;
            if (r110 == null) goto L26;
            final c r111 = this.f388916c;
            final View r112 = this.f388917d;
            final int r113 = this.f388918e;
            r110.post(new p(r109, r111, r112, r113));
            return;
        L26:
            return;
        L11:
            r105 = "GONE";
        L7:
            r103 = false;
            goto L8
        }

        @Override // android.transition.Transition.TransitionListener
        public final void onTransitionStart(Transition r100) {
            Intrinsics.checkNotNullParameter(r100, "t");
            this.f388914a.element = true;
        }

        public b(Ref.BooleanRef r100, n r101, c r102, View r103, int r104) {
            this.f388914a = r100;
            this.f388915b = r101;
            this.f388916c = r102;
            this.f388917d = r103;
            this.f388918e = r104;
        }
    }

    public static final class c implements ViewTreeObserver.OnPreDrawListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Ref.BooleanRef f388919a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ View f388920b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ n f388921c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ int f388922d;

        @Override // android.view.ViewTreeObserver.OnPreDrawListener
        public final boolean onPreDraw() {
            if (this.f388919a.element == true) goto L8;
            View r100 = this.f388920b;
            if (r100 == null) goto L7;
            r100.setTranslationX(0.0f);
        L7:
            return true;
        L8:
            TaskPanelView r101 = this.f388921c.f388905f;
            int r102 = 0;
            if (r101 == null) goto L11;
            int r103 = r101.getLeft();
        L12:
            View r104 = this.f388920b;
            if (r104 == null) goto L15;
            r102 = r104.getLeft();
        L15:
            View r105 = this.f388920b;
            if (r105 == null) goto L18;
            r105.setTranslationX((this.f388922d - r103) - r102);
        L18:
            return true;
        L11:
            r103 = 0;
            goto L12
        }

        public c(Ref.BooleanRef r100, View r101, n r102, int r103) {
            this.f388919a = r100;
            this.f388920b = r101;
            this.f388921c = r102;
            this.f388922d = r103;
        }
    }

    static {
    }

    public final void b() {
        this.f388909j = false;
        c();
        Job r100 = this.f388907h;
        if (r100 == null) goto L5;
        Job.DefaultImpls.cancel$default(r100, null, 1, null);
    L5:
        TaskPanelView r101 = this.f388903d;
        if (r101 == null) goto L10;
        ConstraintLayout r102 = this.f388908i;
        if (r102 == null) goto L10;
        r102.removeView(r101);
    L10:
        PopupWindow r103 = this.f388906g;
        if (r103 == null) goto L14;
        PopupWindowLancet.handleDismissBeforeOrigin(r103);
        r103.dismiss();
        return;
    }

    public final void a() {
        if (this.f388910k == true) goto L5;
        return;
    L5:
        if (this.f388912m == true) goto L51;
        FLogger.f375446a.i("TaskPanelController", "[TaskPanel-SM] collapseWithAnimation: START");
        this.f388912m = true;
        TaskPanelView r100 = this.f388903d;
        if (r100 != null) goto L10;
        return;
    L10:
        int r101 = r100.getWidth();
        int r102 = r100.getHeight();
        int[] r103 = new int[2];
        this.f388901b.getLocationInWindow(r103);
        int r110 = r103[0] + ((this.f388901b.getWidth() - r101) / 2);
        FrameLayout r104 = this.f388904e;
        if (r104 == null) goto L13;
        ViewGroup.LayoutParams r105 = r104.getLayoutParams();
        r105.height = r104.getHeight();
        r104.setLayoutParams(r105);
    L13:
        TaskPanelView r106 = this.f388905f;
        if (r106 == null) goto L16;
        View r107 = r106.findViewById(R.id.cl_collapsed);
    L17:
        if (r107 == null) goto L21;
        ViewGroup.LayoutParams r108 = r107.getLayoutParams();
        if (r108 == null) goto L21;
        int r109 = r108.width;
    L23:
        if (r107 == null) goto L33;
        ViewGroup.LayoutParams r111 = r107.getLayoutParams();
        if (r111 == null) goto L33;
        r111.width = r101;
        if ((r111 instanceof LinearLayout.LayoutParams) == false) goto L30;
        ((LinearLayout.LayoutParams) r111).gravity = 8388659;
    L32:
        r107.setLayoutParams(r111);
        goto L33
    L30:
        if ((r111 instanceof FrameLayout.LayoutParams) == false) goto L32;
        ((FrameLayout.LayoutParams) r111).gravity = 8388659;
    L33:
        Ref.BooleanRef r112 = new Ref.BooleanRef();
        c r113 = new c(r112, r107, this, r110);
        TaskPanelView r114 = this.f388905f;
        if (r114 == null) goto L38;
        ViewTreeObserver r115 = r114.getViewTreeObserver();
        if (r115 == null) goto L38;
        r115.addOnPreDrawListener(r113);
    L38:
        ChangeBounds r116 = new ChangeBounds();
        r116.excludeTarget(R.id.cl_collapsed, true);
        r116.excludeTarget(R.id.rv_expanded, true);
        TransitionSet r117 = new TransitionSet().addTransition(r116).addTransition(new Fade()).setDuration(250);
        r117.addListener(new b(r112, this, r113, r107, r109));
        TransitionManager.beginDelayedTransition(this.f388904e, r117);
        ObjectAnimator r118 = ObjectAnimator.ofFloat(this.f388905f, "panelCornerRadius", new float[]{c7.b(20), c7.b(100)});
        r118.setDuration(250);
        r118.start();
        TaskPanelView r119 = this.f388905f;
        if (r119 == null) goto L41;
        r119.setMode(TaskPanelView.State.COLLAPSED);
    L41:
        TaskPanelView r120 = this.f388905f;
        if (r120 == null) goto L44;
        ViewGroup.LayoutParams r121 = r120.getLayoutParams();
    L45:
        Intrinsics.checkNotNull(r121, "null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
        FrameLayout.LayoutParams r122 = (FrameLayout.LayoutParams) r121;
        r122.width = r101;
        r122.height = r102;
        r122.gravity = 8388659;
        r122.leftMargin = r110;
        int r123 = this.f388913n;
        r122.topMargin = r123;
        r122.bottomMargin = r123;
        TaskPanelView r124 = this.f388905f;
        if (r124 == null) goto L50;
        r124.setLayoutParams(r122);
        return;
    L50:
        return;
    L44:
        r121 = null;
    L21:
        r109 = -1;
        goto L23
    L16:
        r107 = null;
        goto L17
    }

    public final void c() {
        FLogger r100 = FLogger.f375446a;
        r100.i("TaskPanelController", "[TaskPanel-SM] updatePanelState triggered. tasksCount=" + this.f388911l.size() + ", isExpanded=" + this.f388910k);
        if (this.f388909j == true) goto L5;
    L23:
        r100.i("TaskPanelController", "[TaskPanel-SM] Action: Hide Panels & Trigger Collapse (Data Empty)");
        TaskPanelView r101 = this.f388903d;
        if (r101 == null) goto L26;
        r101.b(CollectionsKt.emptyList());
    L26:
        TaskPanelView r102 = this.f388903d;
        if (r102 == null) goto L29;
        r102.setVisibility(8);
    L29:
        a();
        return;
    L5:
        if ((!this.f388911l.isEmpty()) == false) goto L23;
        if (this.f388903d != null) goto L12;
        TaskPanelView r103 = new TaskPanelView(this.f388900a, null);
        r103.setId(R.id.obric_task_center_container);
        r103.setMode(TaskPanelView.State.COLLAPSED);
        r103.setOnPanelClickListener(new i(this));
        this.f388903d = r103;
        ConstraintLayout.LayoutParams r104 = new ConstraintLayout.LayoutParams(-2, -2);
        r104.startToStart = this.f388901b.getId();
        r104.endToEnd = this.f388901b.getId();
        r104.topToBottom = this.f388901b.getId();
        ((ViewGroup.MarginLayoutParams) r104).topMargin = c7.b(0);
        ConstraintLayout r105 = this.f388908i;
        if (r105 == null) goto L12;
        r105.addView(this.f388903d, r104);
    L12:
        TaskPanelView r106 = this.f388903d;
        if (r106 == null) goto L15;
        r106.b(this.f388911l);
    L15:
        TaskPanelView r107 = this.f388905f;
        if (r107 == null) goto L19;
        r107.b(this.f388911l);
    L19:
        if (this.f388910k == true) goto L31;
        r100.i("TaskPanelController", "[TaskPanel-SM] Action: Show Collapsed Panel");
        TaskPanelView r108 = this.f388903d;
        if (r108 == null) goto L32;
        r108.setVisibility(0);
        return;
    L32:
        return;
    }

    public n(FragmentActivity r100, View r110, FragmentActivity r111) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r110, "anchorView");
        this.f388900a = r100;
        this.f388901b = r110;
        this.f388902c = r111;
        this.f388911l = CollectionsKt.emptyList();
        this.f388913n = c7.b(16);
        ViewParent r101 = r110.getParent();
        Job r102 = null;
        if ((r101 instanceof ConstraintLayout) == false) goto L5;
        ConstraintLayout r103 = (ConstraintLayout) r101;
    L6:
        if (r103 == null) goto L17;
        this.f388908i = r103;
        if (r110.getId() != (-1)) goto L10;
        r110.setId(View.generateViewId());
    L10:
        if (r111 == null) goto L14;
        LifecycleCoroutineScope r104 = LifecycleOwnerKt.getLifecycleScope(r111);
        if (r104 == null) goto L14;
        r102 = BuildersKt.launch$default(r104, null, null, new TaskPanelController$startObserving$1(this, null), 3, null);
    L14:
        this.f388907h = r102;
        return;
    L17:
        throw new IllegalStateException("AnchorView must be inside a ConstraintLayout");
    L5:
        r103 = null;
        goto L6
    }
}
