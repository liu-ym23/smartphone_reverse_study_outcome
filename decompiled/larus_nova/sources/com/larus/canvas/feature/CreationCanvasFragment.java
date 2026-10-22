package com.larus.canvas.feature;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.FrameLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentManager;
import androidx.viewbinding.ViewBindings;
import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import com.bytedance.ies.sdk.widgets.perf.WidgetCostModule;
import com.larus.bmhome.chat.component.bottom.core.InputViewCreatorDelegate;
import com.larus.bmhome.view.ChatConstraintLayout;
import com.larus.canvas.feature.component.title.widget.CanvasTitleView;
import com.larus.canvas.feature.host.CanvasHostUiPolicy;
import com.larus.canvas.impl.databinding.LarusFragmentCreationCanvasBinding;
import com.larus.nova.R;
import com.larus.platform.spi.IAIChatUgcAIGCService;
import com.larus.trace.tracknode.TraceFragment;
import com.larus.ui.arch.component.internal.attach.FragmentAttachExtKt;
import com.larus.ui.arch.modulizer.di.ContainerFilter;
import com.larus.utils.FragmentExtKt$addOnBackPressed$callback$1;
import com.larus.utils.e1;
import com.larus.utils.i0;
import com.larus.utils.v;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.MutableSharedFlow;
import kotlinx.coroutines.flow.SharedFlowKt;
import kotlinx.coroutines.flow.a1;
import my8.q;
import v19.c7;
import v19.i5;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(d1 = {"\u0000\u0086\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019H\u0016J\u0012\u0010\u001a\u001a\u00020\u00172\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0016J&\u0010\u001d\u001a\u0004\u0018\u00010\u001e2\u0006\u0010\u001f\u001a\u00020 2\b\u0010!\u001a\u0004\u0018\u00010\"2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0016J\u001a\u0010#\u001a\u00020\u00172\u0006\u0010$\u001a\u00020\u001e2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0016J\b\u0010%\u001a\u00020\u0017H\u0016J\b\u0010&\u001a\u00020\u0017H\u0016J\b\u0010'\u001a\u00020\u000eH\u0016J\b\u0010(\u001a\u00020)H\u0016J\u0006\u0010*\u001a\u00020\u0017J\b\u0010+\u001a\u00020\u0017H\u0002J\b\u0010,\u001a\u00020\u000eH\u0002J\b\u0010-\u001a\u00020\u0017H\u0002J \u0010.\u001a\u00020\u00172\u0006\u0010/\u001a\u0002002\u0006\u00101\u001a\u0002002\b\u00102\u001a\u0004\u0018\u000103J\b\u00104\u001a\u00020\u0017H\u0002J\b\u00105\u001a\u00020\u0017H\u0002J\b\u00106\u001a\u00020\u0017H\u0002J\b\u00107\u001a\u00020\u0017H\u0002J\f\u00108\u001a\u00020\u0017*\u00020\u001eH\u0002J\f\u00109\u001a\u00020\u0017*\u00020:H\u0002R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00110\u0013X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015¨\u0006;"}, d2 = {"Lcom/larus/canvas/feature/CreationCanvasFragment;", "Lcom/larus/trace/tracknode/TraceFragment;", "Lcom/larus/canvas/feature/ability/CanvasContainerAbility;", "<init>", "()V", "binding", "Lcom/larus/canvas/impl/databinding/LarusFragmentCreationCanvasBinding;", "inputContainer", "Lcom/larus/ui/arch/component/external/api/receiver/Container;", "canvasArgumentData", "Lcom/larus/canvas/feature/data/CanvasArgumentData;", "backPressedCallback", "Landroidx/activity/OnBackPressedCallback;", "hasHostBackHandlingEntry", "", "_uiActionFlow", "Lkotlinx/coroutines/flow/MutableSharedFlow;", "Lcom/larus/canvas/feature/ability/CanvasContainerUIAction;", "uiActionFlow", "Lkotlinx/coroutines/flow/SharedFlow;", "getUiActionFlow", "()Lkotlinx/coroutines/flow/SharedFlow;", "onAttach", "", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", WidgetCostModule.TYPE_ON_CREATE, "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", KtvSubElement.CONTAINER, "Landroid/view/ViewGroup;", "onViewCreated", "view", "onResume", "onDestroyView", "autoLogEnterPage", "getCurrentPageName", "", "onBackPressed", "ensureBackPressedCallback", "shouldHandleCanvasBackPressed", "ensureRootSystemBackHandling", "onResult", "requestCode", "", "resultCode", "data", "Landroid/content/Intent;", "bindToVContext", "attachComponent", "initStatusBarArea", "adaptHostBottomPadding", "applyCanvasBackground", "addChatSpeakerView", "Landroidx/constraintlayout/widget/ConstraintLayout;", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CreationCanvasFragment extends TraceFragment implements fy8.b {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final /* synthetic */ int f323016k = 0;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public LarusFragmentCreationCanvasBinding f323017e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public q f323018f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public FragmentExtKt$addOnBackPressed$callback$1 f323019g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f323020h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final MutableSharedFlow<fy8.c> f323021i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final a1 f323022j;

    @Override // com.larus.trace.tracknode.TraceFragment
    public final boolean S90() {
        return false;
    }

    @Override // com.larus.trace.tracknode.a
    public final String k() {
        return "creation_canvas";
    }

    public CreationCanvasFragment() {
        MutableSharedFlow<fy8.c> r100 = SharedFlowKt.MutableSharedFlow$default(0, 0, null, 7, null);
        this.f323021i = r100;
        this.f323022j = kotlinx.coroutines.flow.e.a(r100);
    }

    @Override // androidx.fragment.app.Fragment
    public final void onDestroyView() {
        super.onDestroyView();
        FragmentExtKt$addOnBackPressed$callback$1 r100 = this.f323019g;
        if (r100 == null) goto L5;
        r100.remove();
    L5:
        this.f323019g = null;
        this.f323017e = null;
    }

    @Override // com.larus.trace.tracknode.TraceFragment, androidx.fragment.app.Fragment
    public final void onResume() {
        super.onResume();
        if (this.f323019g != null) goto L6;
        this.f323019g = v.a(this, new i(this));
    L6:
        int r100 = CanvasHostUiPolicy.f323739c;
        CanvasHostUiPolicy r101 = CanvasHostUiPolicy.a.a(this.f323018f);
        if (r101.f323740a == true) goto L9;
    L11:
        boolean r102 = false;
    L12:
        if (r102 == true) goto L14;
        return;
    L14:
        if (this.f323020h == true) goto L22;
        FragmentManager r103 = getParentFragmentManager();
        if (r103.getBackStackEntryCount() > 1) goto L23;
        r103.beginTransaction().addToBackStack(null).commitAllowingStateLoss();
        this.f323020h = true;
        return;
    L23:
        return;
    L22:
        return;
    L9:
        if (r101.f323741b == false) goto L11;
        r102 = true;
        goto L12
    }

    @Override // fy8.b
    public final a1 U4() {
        return this.f323022j;
    }

    @Override // androidx.fragment.app.Fragment
    public final void onAttach(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super.onAttach(r100);
        t1a.b r101 = s1a.a.g(this);
        de8.c r102 = de8.c.f468084s;
        r101.n(de8.c.a.a(getArguments()), de8.c.class);
        q r103 = new q(getArguments());
        s1a.a.g(this).n(r103, q.class);
        this.f323018f = r103;
        s1a.a.g(this).c(this, fy8.b.class);
    }

    @Override // com.larus.trace.tracknode.TraceFragment, androidx.fragment.app.Fragment
    public final void onCreate(Bundle r100) {
        super.onCreate(r100);
        FragmentAttachExtKt.b(this, ContainerFilter.INPUT_ONLY);
        k1a.b.a(this, new f(this));
    }

    @Override // androidx.fragment.app.Fragment
    public final void onViewCreated(View r100, Bundle r101) {
        Intrinsics.checkNotNullParameter(r100, "view");
        super.onViewCreated(r100, r101);
        int r102 = CanvasHostUiPolicy.f323739c;
        CanvasHostUiPolicy r103 = CanvasHostUiPolicy.a.a(this.f323018f);
        LarusFragmentCreationCanvasBinding r104 = this.f323017e;
        if (r104 == null) goto L11;
        View r105 = r104.f323772i;
        if (r105 == null) goto L11;
        ViewGroup.LayoutParams r106 = r105.getLayoutParams();
        if (r106 == null) goto L10;
        i0.f375410a.getClass();
        r106.height = i0.g();
        r105.setLayoutParams(r106);
        goto L11
    L10:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
    L11:
        LarusFragmentCreationCanvasBinding r107 = this.f323017e;
        if (r107 == null) goto L23;
        CanvasTitleView r108 = r107.f323773j;
        if (r108 == null) goto L23;
        ViewGroup.LayoutParams r109 = r108.getLayoutParams();
        if (r109 == null) goto L22;
        int r110 = i5.k0();
        int r111 = i5.c0();
        if (r103.f323740a == false) goto L20;
        r110 = r111;
    L20:
        r109.height = r110;
        r108.setLayoutParams(r109);
        goto L23
    L22:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
    L23:
        LarusFragmentCreationCanvasBinding r112 = this.f323017e;
        if (r112 == null) goto L30;
        final ChatConstraintLayout r113 = r112.f323771h;
        if (r113 == null) goto L31;
        final CanvasHostUiPolicy r114 = CanvasHostUiPolicy.a.a(this.f323018f);
        final int r115 = c7.b(16);
        final Function2<Integer, String, Boolean> r116 = r113.getInterruptBottomPaddingUpdate();
        r113.setInterruptBottomPaddingUpdate(new g(r113, r115, r114, r116));
        r113.post(new h(r113, r115, r114));
        return;
    L31:
        return;
    }

    @Override // androidx.fragment.app.Fragment
    public final View onCreateView(LayoutInflater r110, ViewGroup r111, Bundle r210) {
        Intrinsics.checkNotNullParameter(r110, "inflater");
        View r100 = r110.inflate(R.layout.larus_fragment_creation_canvas, r111, false);
        FrameLayout r101 = (FrameLayout) ViewBindings.findChildViewById(r100, R.id.chat_input);
        if (r101 == null) goto L43;
        ViewStub r102 = (ViewStub) ViewBindings.findChildViewById(r100, R.id.input_delegate);
        if (r102 == null) goto L42;
        View r103 = ViewBindings.findChildViewById(r100, R.id.input_touch_intercept_view);
        if (r103 == null) goto L41;
        FrameLayout r112 = (FrameLayout) ViewBindings.findChildViewById(r100, R.id.instruction_tab_container);
        if (r112 == null) goto L40;
        FrameLayout r113 = (FrameLayout) ViewBindings.findChildViewById(r100, R.id.instruction_tab_container_reference);
        if (r113 == null) goto L39;
        FrameLayout r114 = (FrameLayout) ViewBindings.findChildViewById(r100, R.id.result_container);
        if (r114 == null) goto L38;
        ChatConstraintLayout r115 = (ChatConstraintLayout) r100;
        View r116 = ViewBindings.findChildViewById(r100, R.id.status_bar_area);
        if (r116 == null) goto L37;
        CanvasTitleView r117 = (CanvasTitleView) ViewBindings.findChildViewById(r100, R.id.title);
        if (r117 == null) goto L36;
        this.f323017e = new LarusFragmentCreationCanvasBinding(r115, r101, r102, r103, r112, r113, r114, r115, r116, r117);
        if (r115 == null) goto L21;
        r115.setBackgroundColor(ContextCompat.getColor(r115.getContext(), v19.c.b(R.attr.larus_base_1_overlay, r115.getContext(), R.color.larus_base_1_overlay)));
    L21:
        LarusFragmentCreationCanvasBinding r104 = this.f323017e;
        if (r104 == null) goto L26;
        ViewStub r105 = r104.f323766c;
        if (r105 == null) goto L26;
        InputViewCreatorDelegate.f298409b.a(r105, Integer.valueOf(R.id.input_delegate));
    L26:
        LarusFragmentCreationCanvasBinding r106 = this.f323017e;
        if (r106 == null) goto L31;
        ConstraintLayout r107 = r106.f323771h;
        if (r107 == null) goto L31;
        View r108 = IAIChatUgcAIGCService.f365905a.K(r107.getContext());
        r108.setId(R.id.speaker);
        ConstraintLayout.LayoutParams r109 = new ConstraintLayout.LayoutParams(-1, 0);
        ((ViewGroup.MarginLayoutParams) r109).bottomMargin = i5.h();
        r108.setLayoutParams(r109);
        e1.o(r108);
        r107.addView(r108);
        ConstraintSet r118 = new ConstraintSet();
        r118.clone(r107);
        r118.connect(R.id.speaker, 4, R.id.chat_input, 4);
        r118.applyTo(r107);
    L31:
        LarusFragmentCreationCanvasBinding r119 = this.f323017e;
        if (r119 != null) goto L46;
        return null;
    L46:
        return r119.f323771h;
    L36:
        int r120 = R.id.title;
    L45:
        throw new NullPointerException("Missing required view with ID: ".concat(r100.getResources().getResourceName(r120)));
    L37:
        r120 = R.id.status_bar_area;
        goto L45
    L38:
        r120 = R.id.result_container;
        goto L45
    L39:
        r120 = R.id.instruction_tab_container_reference;
        goto L45
    L40:
        r120 = R.id.instruction_tab_container;
        goto L45
    L41:
        r120 = R.id.input_touch_intercept_view;
        goto L45
    L42:
        r120 = R.id.input_delegate;
        goto L45
    L43:
        r120 = R.id.chat_input;
        goto L45
    }
}
