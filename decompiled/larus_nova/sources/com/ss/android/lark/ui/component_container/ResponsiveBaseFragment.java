package com.ss.android.lark.ui.component_container;

import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.activity.OnBackPressedDispatcher;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentTransaction;
import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import com.bytedance.ies.sdk.widgets.api.WidgetService;
import com.bytedance.speech.speechengine.SpeechEngineDefines;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.larksuite.framework.utils.UIUtils;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.nova.R;
import com.lynx.xelement.viewpager.childitem.LynxViewpagerItem;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import com.ss.android.lark.api.ui.i;
import com.ss.android.lark.base.fragment.BaseResponsiveComponentActivity;
import com.ss.android.lark.featuregating.FeatureGatingModule;
import com.ss.android.lark.forseti.widget.ForsetiStackChainBackgroundView;
import com.ss.android.lark.forseti.widget.ForsetiStackChainViewGroup;
import com.ss.android.lark.forseti.widget.ForsetiStackShadowLayout;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.utils.StatusBarUtil;
import com.ttnet.org.chromium.base.BaseSwitches;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
@Metadata(d1 = {"\u0000\u0095\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t*\u0001&\u0018\u0000 E2\u00020\u0001:\u0002EFB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010#\u001a\u00020$2\u0006\u0010!\u001a\u00020\"J&\u0010(\u001a\u0004\u0018\u00010)2\u0006\u0010*\u001a\u00020+2\b\u0010,\u001a\u0004\u0018\u00010-2\b\u0010.\u001a\u0004\u0018\u00010/H\u0016J\u0006\u00100\u001a\u00020\u000eJ\u001a\u00101\u001a\u00020$2\u0006\u00102\u001a\u00020)2\b\u0010.\u001a\u0004\u0018\u00010/H\u0016J\u0018\u00103\u001a\u00020$2\u0006\u00102\u001a\u00020)2\u0006\u00104\u001a\u000205H\u0002J\u0016\u00106\u001a\u00020\u000e2\f\u00107\u001a\b\u0012\u0004\u0012\u00020908H\u0002J \u0010:\u001a\u00020$2\u0006\u0010;\u001a\u00020\u00012\b\u0010<\u001a\u0004\u0018\u00010\f2\u0006\u0010=\u001a\u00020>J\b\u0010?\u001a\u00020$H\u0016J\u0012\u0010@\u001a\u00020$2\n\b\u0002\u0010A\u001a\u0004\u0018\u00010\u0013J\b\u0010B\u001a\u00020$H\u0002J\u0010\u0010C\u001a\u00020$2\u0006\u0010\r\u001a\u00020\u000eH\u0002J\u0006\u0010D\u001a\u00020\u001dR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0001X\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\r\u001a\u00020\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00050\u001bX\u0082.¢\u0006\u0002\n\u0000R\u001e\u0010\u001e\u001a\u00020\u001d2\u0006\u0010\u001c\u001a\u00020\u001d@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u0010\u0010!\u001a\u0004\u0018\u00010\"X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010%\u001a\u00020&X\u0082\u0004¢\u0006\u0004\n\u0002\u0010'¨\u0006G"}, d2 = {"Lcom/ss/android/lark/ui/component_container/ResponsiveBaseFragment;", "Landroidx/fragment/app/Fragment;", "<init>", "()V", "stackViewGroup", "Lcom/ss/android/lark/forseti/widget/ForsetiStackChainViewGroup;", "stackBackground", "Lcom/ss/android/lark/forseti/widget/ForsetiStackChainBackgroundView;", "shadowContainerChild", "Landroid/widget/FrameLayout;", "contentFragment", "fragmentTag", "", "isTransparent", "", "()Z", "setTransparent", "(Z)V", "contentIntent", "Landroid/content/Intent;", "insetsCompat", "swipeToDismissEnabled", "backgroundStrategy", "Lcom/ss/android/lark/ui/component_container/BackgroundStrategy;", "finishAnimation", "enableDynamicActivityBackground", "bottomSheetBehavior", "Lcom/google/android/material/bottomsheet/BottomSheetBehavior;", "value", "", "bottomSheetState", "getBottomSheetState", "()I", "interceptor", "Lcom/ss/android/lark/ui/component_container/ResponsiveBaseFragment$ActionInterceptor;", "setActionInterceptor", "", "fragmentLifecycleCallbacks", "com/ss/android/lark/ui/component_container/ResponsiveBaseFragment$fragmentLifecycleCallbacks$1", "Lcom/ss/android/lark/ui/component_container/ResponsiveBaseFragment$fragmentLifecycleCallbacks$1;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", KtvSubElement.CONTAINER, "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "isCModel", "onViewCreated", "view", "initBackGround", "shadowContainer", "Lcom/ss/android/lark/forseti/widget/ForsetiStackShadowLayout;", "tailTwoAreResponsive", SpeechEngineDefines.RECORDER_ENGINE, "", "Landroid/app/Activity;", LynxViewpagerItem.BIND_ON_ATTACH, WidgetService.PARAM_FRAGMENT, "tag", "options", "Lcom/ss/android/lark/ui/component_container/ResponsiveContainerOptions;", "onDestroyView", "onClose", "intent", "updateActivityTransparent", "changeActivityTransparent", "provideContainerId", "Companion", "ActionInterceptor", "widget_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ResponsiveBaseFragment extends Fragment {

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final /* synthetic */ int f444576r = 0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public ForsetiStackChainViewGroup f444577d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public ForsetiStackChainBackgroundView f444578e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public FrameLayout f444579f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Fragment f444580g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public String f444581h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f444582i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public Intent f444583j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f444584k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f444585l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public BackgroundStrategy f444586m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f444587n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public boolean f444588o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public BottomSheetBehavior<ForsetiStackChainViewGroup> f444589p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final ResponsiveBaseFragment$fragmentLifecycleCallbacks$1 f444590q;

    public static final class a {
    }

    public static final class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ResponsiveBaseFragment f444591a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Intent f444592b;

        public b(ResponsiveBaseFragment r100, Intent r101) {
            this.f444591a = r100;
            this.f444592b = r101;
        }

        @Override // java.lang.Runnable
        public final void run() {
            BottomSheetBehavior<ForsetiStackChainViewGroup> r100 = this.f444591a.f444589p;     // Catch: Throwable -> L7
            if (r100 != null) goto L5;
            Intrinsics.throwUninitializedPropertyAccessException("bottomSheetBehavior");     // Catch: Throwable -> L7
            r100 = null;
        L5:
            r100.setState(5);     // Catch: Throwable -> L7
            ResponsiveBaseFragment r101 = this.f444591a;     // Catch: Throwable -> L7
            r101.f444583j = this.f444592b;     // Catch: Throwable -> L7
            return;
        L7:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L11;
            return;
        L11:
            throw th;
        }
    }

    public static final class c implements OnApplyWindowInsetsListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ResponsiveBaseFragment f444593a;

        public c(ResponsiveBaseFragment r100) {
            this.f444593a = r100;
        }

        @Override // androidx.core.view.OnApplyWindowInsetsListener
        public final WindowInsetsCompat onApplyWindowInsets(View r100, WindowInsetsCompat r101) {
            Intrinsics.checkNotNullParameter(r100, BaseSwitches.V);
            Intrinsics.checkNotNullParameter(r101, "insets");
            int r102 = StatusBarUtil.getStatusBarHeight(this.f444593a.getContext());
            r100.setPadding(r100.getPaddingLeft(), r102, r100.getPaddingRight(), r100.getPaddingBottom());
            return r101;
        }
    }

    public static final class d implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final d f444594a = null;

        static {
            f444594a = new d();
        }

        public d() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
        }
    }

    public static final class e implements i {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ResponsiveBaseFragment f444595a;

        public e(ResponsiveBaseFragment r100) {
            this.f444595a = r100;
        }

        @Override // com.ss.android.lark.api.ui.i
        public final void a(boolean r100) {
            Log.i("ResponsiveBaseFragment", "onStyleModeChanged isCMode : " + r100);
            ResponsiveBaseFragment r101 = this.f444595a;
            if (r101.f444587n == true) goto L5;
            return;
        L5:
            if (r101.f444588o == true) goto L8;
            return;
        L8:
            if (Build.VERSION.SDK_INT < 30) goto L22;
            ForsetiStackChainViewGroup r102 = r101.f444577d;
            if (r102 != null) goto L13;
            Intrinsics.throwUninitializedPropertyAccessException("stackViewGroup");
            r102 = null;
        L13:
            if (r102.f424708d == false) goto L17;
            FragmentActivity r103 = r101.getActivity();
            if (r103 == null) goto L23;
            r103.setTranslucent(false);
            return;
        L23:
            return;
        L17:
            FragmentActivity r104 = r101.getActivity();
            if (r104 == null) goto L25;
            r104.setTranslucent(true);
            return;
        L25:
            return;
        }
    }

    public static final class f extends BottomSheetBehavior.BottomSheetCallback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ResponsiveBaseFragment f444596a;

        public static final class a implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ ResponsiveBaseFragment f444597a;

            public a(ResponsiveBaseFragment r100) {
                this.f444597a = r100;
            }

            @Override // java.lang.Runnable
            public final void run() {
                ResponsiveBaseFragment r100 = this.f444597a;     // Catch: Throwable -> L10
                if (r100.f444588o == true) goto L5;
                return;
            L5:
                if (Build.VERSION.SDK_INT < 30) goto L17;
                FragmentActivity r101 = r100.getActivity();     // Catch: Throwable -> L10
                if (r101 == null) goto L18;
                r101.setTranslucent(false);     // Catch: Throwable -> L10
                return;
            L18:
                return;
            L17:
                return;
            L10:
                th = move-exception;
                if (RunnableProtector.intercept(th) == true) goto L19;
                throw th;
            }
        }

        public f(ResponsiveBaseFragment r100) {
            this.f444596a = r100;
        }

        @Override // com.google.android.material.bottomsheet.BottomSheetBehavior.BottomSheetCallback
        public final void onSlide(View r100, float r101) {
            Intrinsics.checkNotNullParameter(r100, "p0");
            ResponsiveBaseFragment r102 = this.f444596a;
            if (r102.f444582i == true) goto L17;
            ForsetiStackChainBackgroundView r103 = r102.f444578e;
            BottomSheetBehavior<ForsetiStackChainViewGroup> r104 = null;
            if (r103 != null) goto L7;
            Intrinsics.throwUninitializedPropertyAccessException("stackBackground");
            r103 = null;
        L7:
            BottomSheetBehavior<ForsetiStackChainViewGroup> r105 = this.f444596a.f444589p;
            if (r105 != null) goto L10;
            Intrinsics.throwUninitializedPropertyAccessException("bottomSheetBehavior");
        L12:
            if (r104.getSkipCollapsed() == false) goto L14;
            float r106 = (r101 - 0) / 1;
        L15:
            r103.setAlpha(r106);
            return;
        L14:
            r106 = Math.min(1.0f, r101 - (-1));
            goto L15
        L10:
            r104 = r105;
            goto L12
        }

        @Override // com.google.android.material.bottomsheet.BottomSheetBehavior.BottomSheetCallback
        public final void onStateChanged(View r100, int r101) {
            Intrinsics.checkNotNullParameter(r100, "p0");
            if (r101 != 5) goto L19;
            ResponsiveBaseFragment r102 = this.f444596a;
            Intent r103 = r102.f444583j;
            if (r103 == null) goto L9;
            Log.i("ResponsiveBaseFragment", "contentIntent exists and setResult");
            FragmentActivity r104 = r102.getActivity();
            if (r104 == null) goto L9;
            r104.setResult(-1, r103);
        L9:
            StringBuilder r105 = new StringBuilder("finish activity : ");
            if (this.f444596a.getActivity() == null) goto L12;
            boolean r106 = true;
        L13:
            r105.append(r106);
            Log.i("ResponsiveBaseFragment", r105.toString());
            FragmentActivity r107 = this.f444596a.getActivity();
            if (r107 == null) goto L16;
            r107.finish();
        L16:
            FragmentActivity r108 = this.f444596a.getActivity();
            if (r108 == null) goto L19;
            r108.overridePendingTransition(0, 0);
            goto L19
        L12:
            r106 = false;
        L19:
            if (r101 == 1) goto L24;
            if (r101 == 2) goto L24;
            ResponsiveBaseFragment r109 = this.f444596a;
            int r110 = ResponsiveBaseFragment.f444576r;
            r109.getClass();
        L24:
            if (r101 != 3) goto L36;
            ResponsiveBaseFragment r111 = this.f444596a;
            r111.f444587n = true;
            ForsetiStackChainViewGroup r112 = r111.f444577d;
            ForsetiStackChainViewGroup r113 = null;
            if (r112 != null) goto L28;
            Intrinsics.throwUninitializedPropertyAccessException("stackViewGroup");
            r112 = null;
        L28:
            boolean r114 = r112.f424708d;
            Log.i("ResponsiveBaseFragment", "on animation finish isCMode : " + r114);
            if (r114 == false) goto L37;
            ForsetiStackChainViewGroup r115 = this.f444596a.f444577d;
            if (r115 != null) goto L33;
            Intrinsics.throwUninitializedPropertyAccessException("stackViewGroup");
        L34:
            r113.post(new a(this.f444596a));
            return;
        L33:
            r113 = r115;
            goto L34
        L37:
            return;
        }
    }

    static {
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [com.ss.android.lark.ui.component_container.ResponsiveBaseFragment$fragmentLifecycleCallbacks$1] */
    public ResponsiveBaseFragment() {
        this.f444584k = true;
        this.f444585l = true;
        this.f444586m = BackgroundStrategy.DEFAULT;
        this.f444590q = new ResponsiveBaseFragment$fragmentLifecycleCallbacks$1();
    }

    @Override // androidx.fragment.app.Fragment
    public final void onDestroyView() {
        super.onDestroyView();
        Log.i("ResponsiveBaseFragment", "onDestroyView");
        getChildFragmentManager().unregisterFragmentLifecycleCallbacks(this.f444590q);
    }

    public final void S90(Intent r100) {
        Log.i("ResponsiveBaseFragment", "close container by custom way");
        ForsetiStackChainViewGroup r101 = this.f444577d;
        ForsetiStackChainViewGroup r102 = null;
        if (r101 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("stackViewGroup");
        r101 = null;
    L6:
        if (r101.f424708d == true) goto L8;
    L23:
        ForsetiStackChainViewGroup r103 = this.f444577d;
        if (r103 != null) goto L26;
        Intrinsics.throwUninitializedPropertyAccessException("stackViewGroup");
    L27:
        r102.post(new b(this, r100));
        return;
    L26:
        r102 = r103;
        goto L27
    L8:
        if (this.f444588o == false) goto L23;
        Intent r104 = this.f444583j;
        if (r104 == null) goto L14;
        FragmentActivity r105 = getActivity();
        if (r105 == null) goto L14;
        r105.setResult(-1, r104);
    L14:
        FragmentActivity r106 = getActivity();
        if (r106 == null) goto L18;
        r106.finish();
    L18:
        if (FeatureGatingModule.getFeatureGatingService().isEnable("core.component.responsive_disable_activity_anim_finish") == true) goto L29;
        FragmentActivity r107 = getActivity();
        if (r107 == null) goto L30;
        r107.overridePendingTransition(0, R.anim.translate_to_bottom);
        return;
    L30:
        return;
    }

    @Override // androidx.fragment.app.Fragment
    public final void onViewCreated(View r100, Bundle r101) {
        Intrinsics.checkNotNullParameter(r100, "view");
        super.onViewCreated(r100, r101);
        StatusBarUtil.setTransparent(getActivity());
        FragmentActivity r102 = getActivity();
        if (r102 == null) goto L7;
        OnBackPressedDispatcher r103 = r102.getOnBackPressedDispatcher();
        if (r103 == null) goto L7;
        r103.addCallback(this, new AnonymousClass1(this));
    L7:
        ForsetiStackChainViewGroup r104 = (ForsetiStackChainViewGroup) r100.findViewById(R.id.stack_chain_view_group);
        this.f444577d = r104;
        BottomSheetBehavior<ForsetiStackChainViewGroup> r105 = null;
        if (this.f444584k == false) goto L15;
        if (r104 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("stackViewGroup");
        r104 = null;
    L11:
        ViewCompat.setOnApplyWindowInsetsListener(r104, new c(this));
        ForsetiStackChainViewGroup r106 = this.f444577d;
        if (r106 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("stackViewGroup");
        r106 = null;
    L14:
        ViewCompat.requestApplyInsets(r106);
    L15:
        ForsetiStackChainViewGroup r107 = this.f444577d;
        if (r107 != null) goto L18;
        Intrinsics.throwUninitializedPropertyAccessException("stackViewGroup");
        r107 = null;
    L18:
        View r108 = r107.getChildAt(0);
        Intrinsics.checkNotNull(r108, "null cannot be cast to non-null type com.ss.android.lark.forseti.widget.ForsetiStackShadowLayout");
        ForsetiStackShadowLayout r109 = (ForsetiStackShadowLayout) r108;
        FrameLayout r110 = new FrameLayout(r100.getContext());
        r110.setId(R.id.responsive_shadow_layout_child);
        r110.setOnClickListener(d.f444594a);
        this.f444579f = r110;
        r109.addView(r110);
        this.f444578e = (ForsetiStackChainBackgroundView) r100.findViewById(R.id.stack_chain_background);
        com.ss.android.lark.appcontext.applifecycle.c r111 = com.ss.android.lark.appcontext.applifecycle.c.a.f408832a;
        r111.getClass();
        Set r112 = Collections.unmodifiableSet(new LinkedHashSet(r111.f408828b));
        if (r112.size() < 2) goto L34;
        List r113 = CollectionsKt.takeLast(CollectionsKt.toList(r112), 2);
        if ((r113 instanceof Collection) == true) goto L23;
    L25:
        Iterator r114 = r113.iterator();
    L27:
        if (r114.hasNext() == false) goto L31;
        if ((((Activity) r114.next()) instanceof BaseResponsiveComponentActivity) == true) goto L27;
        boolean r115 = false;
    L32:
        if (r115 == false) goto L34;
        boolean r116 = true;
    L35:
        if (r116 == false) goto L39;
        if (this.f444586m != BackgroundStrategy.DEFAULT) goto L39;
    L40:
        boolean r117 = true;
    L42:
        this.f444582i = r117;
        Log.i("ResponsiveBaseFragment", "set backGround isTransparent : " + this.f444582i + ' ');
        if (this.f444582i == true) goto L51;
        ForsetiStackChainBackgroundView r118 = this.f444578e;
        if (r118 != null) goto L47;
        Intrinsics.throwUninitializedPropertyAccessException("stackBackground");
        r118 = null;
    L47:
        r118.setBackgroundResource(R.color.bg_mask);
        ForsetiStackChainBackgroundView r119 = this.f444578e;
        if (r119 != null) goto L50;
        Intrinsics.throwUninitializedPropertyAccessException("stackBackground");
        r119 = null;
    L50:
        r119.setAlpha(0.0f);
    L52:
        ForsetiStackChainBackgroundView r120 = this.f444578e;
        if (r120 != null) goto L55;
        Intrinsics.throwUninitializedPropertyAccessException("stackBackground");
        r120 = null;
    L55:
        r120.setOnClickListener(new x9c.a(this));
        ForsetiStackChainViewGroup r121 = this.f444577d;
        if (r121 != null) goto L58;
        Intrinsics.throwUninitializedPropertyAccessException("stackViewGroup");
        r121 = null;
    L58:
        this.f444589p = BottomSheetBehavior.from(r121);
        ForsetiStackChainViewGroup r122 = this.f444577d;
        if (r122 != null) goto L61;
        Intrinsics.throwUninitializedPropertyAccessException("stackViewGroup");
        r122 = null;
    L61:
        r122.setStyle(ForsetiStackChainViewGroup.Style.STACK);
        ForsetiStackChainViewGroup r123 = this.f444577d;
        if (r123 != null) goto L64;
        Intrinsics.throwUninitializedPropertyAccessException("stackViewGroup");
        r123 = null;
    L64:
        r123.setForsetiStackStyleChangeListener(new e(this));
        if (this.f444585l == true) goto L76;
        BottomSheetBehavior<ForsetiStackChainViewGroup> r124 = this.f444589p;
        if (r124 != null) goto L69;
        Intrinsics.throwUninitializedPropertyAccessException("bottomSheetBehavior");
        r124 = null;
    L69:
        r124.setDraggable(false);
        ForsetiStackChainViewGroup r125 = this.f444577d;
        if (r125 != null) goto L72;
        Intrinsics.throwUninitializedPropertyAccessException("stackViewGroup");
        r125 = null;
    L72:
        r125.setSwipeToDismissDisabled(true);
        ForsetiStackChainViewGroup r126 = this.f444577d;
        if (r126 != null) goto L75;
        Intrinsics.throwUninitializedPropertyAccessException("stackViewGroup");
        r126 = null;
    L75:
        r126.setSwipeToDismissDisabledV2(true);
    L76:
        FragmentTransaction r127 = getChildFragmentManager().beginTransaction();
        FrameLayout r128 = this.f444579f;
        if (r128 != null) goto L79;
        Intrinsics.throwUninitializedPropertyAccessException("shadowContainerChild");
        r128 = null;
    L79:
        int r129 = r128.getId();
        Fragment r130 = this.f444580g;
        if (r130 != null) goto L82;
        Intrinsics.throwUninitializedPropertyAccessException("contentFragment");
        r130 = null;
    L82:
        String r131 = this.f444581h;
        if (LandscapeRestrictionGuard.shouldBlockFragmentTransaction(r127, r130, LandscapeRestrictionOperation.FRAGMENT_TRANSACTION_ADD, r131, r129) == true) goto L86;
        r127.add(r129, r130, r131);
    L86:
        r127.commitNowAllowingStateLoss();
        getChildFragmentManager().registerFragmentLifecycleCallbacks(this.f444590q, false);
        BottomSheetBehavior<ForsetiStackChainViewGroup> r132 = this.f444589p;
        if (r132 != null) goto L89;
        Intrinsics.throwUninitializedPropertyAccessException("bottomSheetBehavior");
    L90:
        r105.addBottomSheetCallback(new f(this));
        return;
    L89:
        r105 = r132;
        goto L90
    L51:
        r109.setShadowColor(UIUtils.getColor(getContext(), R.color.transparent));
    L39:
        if (this.f444586m == BackgroundStrategy.FORCE_HIDE) goto L40;
        r117 = false;
    L31:
        r115 = true;
        goto L32
    L23:
        if (r113.isEmpty() == false) goto L25;
    L34:
        r116 = false;
        goto L35
    }

    @Override // androidx.fragment.app.Fragment
    public final View onCreateView(LayoutInflater r100, ViewGroup r101, Bundle r102) {
        Intrinsics.checkNotNullParameter(r100, "inflater");
        return r100.inflate(R.layout.stack_layout, r101, false);
    }
}
