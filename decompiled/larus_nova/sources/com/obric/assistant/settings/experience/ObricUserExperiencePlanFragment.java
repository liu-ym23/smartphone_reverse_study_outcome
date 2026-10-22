package com.obric.assistant.settings.experience;

import android.os.Bundle;
import android.os.Handler;
import android.text.Spanned;
import android.text.method.LinkMovementMethod;
import android.text.method.MovementMethod;
import android.text.style.ClickableSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.RepeatOnLifecycleKt;
import androidx.viewbinding.ViewBindings;
import com.baidu.platform.comapi.map.MapController;
import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import com.larus.bmhome.view.NovaTitleBarEx;
import com.larus.nova.R;
import com.larus.trace.tracknode.TraceFragment;
import com.obric.assistant.impl.databinding.ObricFragmentUserExperiencePlanBinding;
import com.obric.assistant.settings.p0;
import com.obric.assistant.settings.t;
import com.obric.oui.lisitem.OCardListItem;
import com.obric.oui.oswitch.OSwitch;
import com.obric.oui.sectiontitlebar.OSectionTitleBar;
import com.obric.oui.text.OTextView;
import com.obric.oui.titlebar.OFloatingTitleBar;
import com.ss.android.lark.chameleon.container.webcontainer.report.ChameleonOpenTracker;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Function;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.AdaptedFunctionReference;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.StateFlowImpl;

/* JADX INFO: loaded from: classes33.dex */
@Metadata(d1 = {"\u0000\u0086\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\r\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 F2\u00020\u00012\u00020\u0002:\u0001FB\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\b\u0010\u0014\u001a\u00020\u0013H\u0016J\b\u0010\u0015\u001a\u00020\u0011H\u0016J\n\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0016J$\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0016J\u001a\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020\u00192\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0016J\b\u0010#\u001a\u00020!H\u0016J\b\u0010$\u001a\u00020!H\u0016J\b\u0010%\u001a\u00020!H\u0002J\u0017\u0010&\u001a\u00020!2\b\u0010'\u001a\u0004\u0018\u00010\u001fH\u0000¢\u0006\u0002\b(J\b\u0010)\u001a\u00020!H\u0002J\b\u0010*\u001a\u00020!H\u0002J$\u0010+\u001a\u00020!2\u0006\u0010,\u001a\u00020-2\u0012\u0010.\u001a\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020!0/H\u0002J \u00100\u001a\u00020!2\u0006\u0010,\u001a\u00020-2\u0006\u00101\u001a\u00020\u000e2\u0006\u00102\u001a\u00020\u000eH\u0002J \u00100\u001a\u00020!2\u0006\u0010,\u001a\u00020-2\u0006\u00101\u001a\u00020\u000e2\u0006\u00103\u001a\u000204H\u0002J\b\u00105\u001a\u000204H\u0002J\u0010\u00106\u001a\u00020!2\u0006\u00107\u001a\u00020\u0013H\u0002J\u0010\u00108\u001a\u00020!2\u0006\u00107\u001a\u00020\u0013H\u0002J\u0010\u00109\u001a\u00020!2\u0006\u00107\u001a\u00020\u0013H\u0002J\u0010\u0010:\u001a\u00020!2\u0006\u0010;\u001a\u00020<H\u0002J4\u0010=\u001a\u00020!2\u0006\u0010,\u001a\u00020-2\u0006\u0010>\u001a\u00020\u00132\u0006\u00107\u001a\u00020\u00132\u0012\u0010.\u001a\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020!0/H\u0002J\u001a\u0010?\u001a\u00020!2\b\u0010@\u001a\u0004\u0018\u00010\u000b2\u0006\u0010>\u001a\u00020\u0013H\u0002J\b\u0010A\u001a\u00020!H\u0002J\b\u0010B\u001a\u00020!H\u0002J\u0010\u0010C\u001a\u00020!2\u0006\u0010D\u001a\u00020\u000eH\u0002J\f\u0010E\u001a\u00020\u0013*\u000204H\u0002R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f0\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000f0\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006G"}, d2 = {"Lcom/obric/assistant/settings/experience/ObricUserExperiencePlanFragment;", "Lcom/larus/trace/tracknode/TraceFragment;", "Lcom/obric/assistant/settings/ObricFloatingTitleBarProvider;", "<init>", "()V", "binding", "Lcom/obric/assistant/impl/databinding/ObricFragmentUserExperiencePlanBinding;", "doubaoTitleBar", "Lcom/larus/bmhome/view/NovaTitleBarEx;", "switchListeners", "", "Lcom/obric/oui/oswitch/OSwitch;", "Landroid/widget/CompoundButton$OnCheckedChangeListener;", "lastDisabledToastTime", "", "", "pendingHighlightItemId", "", "isObricOS", "", "autoLogEnterPage", "getCurrentPageName", "getFloatingTitleBar", "Lcom/obric/oui/titlebar/OFloatingTitleBar;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", KtvSubElement.CONTAINER, "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "", "view", "onResume", "onDestroyView", "initTopBar", "updateNavigationRequest", "extras", "updateNavigationRequest$impl_mainlandRelease", "scheduleHighlightIfNeeded", "bindSwitches", "bindSwitchClick", MapController.ITEM_LAYER_TAG, "Lcom/obric/oui/lisitem/OCardListItem;", "update", "Lkotlin/Function1;", "bindItem", "titleRes", "subtitleRes", "subtitle", "", "buildPlanSummary", "updateAll", "enabled", "updateVoice", "updateModel", ChameleonOpenTracker.Stage.RENDER, "state", "Lcom/obric/assistant/settings/experience/ObricUserExperiencePlanManager$State;", "renderChildSwitch", "checked", "updateSwitch", "switch", "showNetworkError", "showEnableMasterFirst", "performDisabledFeedbackAndToast", "itemId", "hasClickableSpan", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ObricUserExperiencePlanFragment extends TraceFragment implements t {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final /* synthetic */ int f392026j = 0;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public ObricFragmentUserExperiencePlanBinding f392027e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Map<OSwitch, CompoundButton.OnCheckedChangeListener> f392028f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Map<Integer, Long> f392029g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public String f392030h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final boolean f392031i;

    public static final class a {
    }

    /* JADX INFO: renamed from: com.obric.assistant.settings.experience.ObricUserExperiencePlanFragment$onResume$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.obric.assistant.settings.experience.ObricUserExperiencePlanFragment$onResume$1", f = "ObricUserExperiencePlanFragment.kt", i = {}, l = {90}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        Object L$0;
        int label;
        final /* synthetic */ ObricUserExperiencePlanFragment this$0;

        public AnonymousClass1(ObricUserExperiencePlanFragment r100, Continuation<? super AnonymousClass1> r101) {
            this.this$0 = r100;
            super(2, r101);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
            return new AnonymousClass1(this.this$0, r101);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
            return invoke2(r100, r101);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
            return ((AnonymousClass1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r100) {
            Object r101 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r102 = this.label;
            if (r102 == 0) goto L8;
            if (r102 != 1) goto L7;
            ObricUserExperiencePlanFragment r103 = (ObricUserExperiencePlanFragment) this.L$0;
            ResultKt.throwOnFailure(r100);
        L12:
            int r104 = ObricUserExperiencePlanFragment.f392026j;
            r103.X90((ObricUserExperiencePlanManager.a) r100);
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r100);
            ObricUserExperiencePlanFragment r105 = this.this$0;
            ObricUserExperiencePlanManager r106 = ObricUserExperiencePlanManager.f392033a;
            this.L$0 = r105;
            this.label = 1;
            Object r107 = r106.f(this);
            if (r107 != r101) goto L11;
            return r101;
        L11:
            r103 = r105;
            r100 = r107;
            goto L12
        }
    }

    /* JADX INFO: renamed from: com.obric.assistant.settings.experience.ObricUserExperiencePlanFragment$onViewCreated$2, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.obric.assistant.settings.experience.ObricUserExperiencePlanFragment$onViewCreated$2", f = "ObricUserExperiencePlanFragment.kt", i = {}, l = {81}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ ObricUserExperiencePlanFragment this$0;

        /* JADX INFO: renamed from: com.obric.assistant.settings.experience.ObricUserExperiencePlanFragment$onViewCreated$2$1, reason: invalid class name */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
        @DebugMetadata(c = "com.obric.assistant.settings.experience.ObricUserExperiencePlanFragment$onViewCreated$2$1", f = "ObricUserExperiencePlanFragment.kt", i = {}, l = {82}, m = "invokeSuspend", n = {}, s = {})
        public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            int label;
            final /* synthetic */ ObricUserExperiencePlanFragment this$0;

            /* JADX INFO: renamed from: com.obric.assistant.settings.experience.ObricUserExperiencePlanFragment$onViewCreated$2$1$a */
            public /* synthetic */ class a implements FlowCollector, FunctionAdapter {

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                public final /* synthetic */ ObricUserExperiencePlanFragment f392032a;

                public a(ObricUserExperiencePlanFragment r100) {
                    this.f392032a = r100;
                }

                public final boolean equals(Object r100) {
                    if ((r100 instanceof FlowCollector) == true) goto L5;
                    return false;
                L5:
                    if ((r100 instanceof FunctionAdapter) == true) goto L7;
                    return false;
                L7:
                    return Intrinsics.areEqual(getFunctionDelegate(), ((FunctionAdapter) r100).getFunctionDelegate());
                }

                @Override // kotlin.jvm.internal.FunctionAdapter
                public final Function<?> getFunctionDelegate() {
                    return new AdaptedFunctionReference(2, this.f392032a, ObricUserExperiencePlanFragment.class, ChameleonOpenTracker.Stage.RENDER, "render(Lcom/obric/assistant/settings/experience/ObricUserExperiencePlanManager$State;)V", 4);
                }

                public final int hashCode() {
                    return getFunctionDelegate().hashCode();
                }

                @Override // kotlinx.coroutines.flow.FlowCollector
                public final Object emit(Object r100, Continuation r101) {
                    ObricUserExperiencePlanFragment r102 = this.f392032a;
                    Object r103 = AnonymousClass1.access$invokeSuspend$render(r102, (ObricUserExperiencePlanManager.a) r100, r101);
                    if (r103 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
                    return r103;
                L6:
                    return Unit.INSTANCE;
                }
            }

            public AnonymousClass1(ObricUserExperiencePlanFragment r100, Continuation<? super AnonymousClass1> r101) {
                this.this$0 = r100;
                super(2, r101);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
                return new AnonymousClass1(this.this$0, r101);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
                return invoke2(r100, r101);
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
                return ((AnonymousClass1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object r100) {
                Object r101 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int r102 = this.label;
                if (r102 == 0) goto L8;
                if (r102 != 1) goto L6;
                ResultKt.throwOnFailure(r100);
            L12:
                throw new KotlinNothingValueException();
            L6:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            L8:
                ResultKt.throwOnFailure(r100);
                StateFlowImpl r103 = ObricUserExperiencePlanManager.f392037e;
                a r104 = new a(this.this$0);
                this.label = 1;
                if (r103.collect(r104, this) != r101) goto L12;
                return r101;
            }

            public static final /* synthetic */ Object access$invokeSuspend$render(ObricUserExperiencePlanFragment r100, ObricUserExperiencePlanManager.a r101, Continuation r102) {
                int r103 = ObricUserExperiencePlanFragment.f392026j;
                r100.X90(r101);
                return Unit.INSTANCE;
            }
        }

        public AnonymousClass2(ObricUserExperiencePlanFragment r100, Continuation<? super AnonymousClass2> r101) {
            this.this$0 = r100;
            super(2, r101);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
            return new AnonymousClass2(this.this$0, r101);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
            return invoke2(r100, r101);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
            return ((AnonymousClass2) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r100) {
            Object r101 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r102 = this.label;
            if (r102 == 0) goto L8;
            if (r102 != 1) goto L7;
            ResultKt.throwOnFailure(r100);
        L12:
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r100);
            LifecycleOwner r103 = this.this$0.getViewLifecycleOwner();
            Lifecycle.State r104 = Lifecycle.State.STARTED;
            AnonymousClass1 r105 = new AnonymousClass1(this.this$0, null);
            this.label = 1;
            if (RepeatOnLifecycleKt.repeatOnLifecycle(r103, r104, r105, this) != r101) goto L12;
            return r101;
        }
    }

    static {
    }

    @Override // com.larus.trace.tracknode.TraceFragment
    public final boolean S90() {
        return true;
    }

    @Override // com.larus.trace.tracknode.a
    public final String k() {
        return "obric_user_experience_plan";
    }

    @Override // com.obric.assistant.settings.t
    public final OFloatingTitleBar gW() {
        if (this.f392031i == true) goto L5;
        return null;
    L5:
        ObricFragmentUserExperiencePlanBinding r100 = this.f392027e;
        if (r100 != null) goto L8;
        return null;
    L8:
        return r100.f389537e;
    }

    @Override // androidx.fragment.app.Fragment
    public final void onDestroyView() {
        ((LinkedHashMap) this.f392028f).clear();
        this.f392027e = null;
        super.onDestroyView();
    }

    public ObricUserExperiencePlanFragment() {
        this.f392028f = new LinkedHashMap();
        this.f392029g = new LinkedHashMap();
        this.f392031i = t9a.b.a().b();
    }

    @Override // com.larus.trace.tracknode.TraceFragment, androidx.fragment.app.Fragment
    public final void onResume() {
        super.onResume();
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(getViewLifecycleOwner()), null, null, new AnonymousClass1(this, null), 3, null);
    }

    public static final void U90(ObricUserExperiencePlanFragment r100) {
        FragmentActivity r101 = r100.getActivity();
        if (r101 == null) goto L7;
        Handler r102 = com.obric.oui.toast.f.f403695n;
        com.obric.oui.toast.f.a.a(r101, r100.getString(R.string.larus_network_error));
        return;
    }

    public final void X90(ObricUserExperiencePlanManager.a r100) {
        ObricFragmentUserExperiencePlanBinding r101 = this.f392027e;
        if (r101 != null) goto L5;
        return;
    L5:
        aa0(r101.f389535c.getEndSwitch(), r100.b());
        Y90(r101.f389538f, r100.f392040a, r100.b(), new ObricUserExperiencePlanFragment$render$1(this));
        Y90(r101.f389536d, r100.f392041b, r100.b(), new ObricUserExperiencePlanFragment$render$2(this));
    }

    public final void Z90(Bundle r100) {
        if (r100 == null) goto L5;
        String r101 = r100.getString("extra_highlight_item_id");
    L6:
        this.f392030h = r101;
        if (getView() != null) goto L9;
        return;
    L9:
        if (Intrinsics.areEqual(this.f392030h, "voice_wakeup_audio_upload") == false) goto L32;
        ObricFragmentUserExperiencePlanBinding r102 = this.f392027e;
        if (r102 == null) goto L28;
        OCardListItem r103 = r102.f389538f;
        if (r103 != null) goto L16;
        return;
    L16:
        if (r103.isLaidOut() == true) goto L18;
    L25:
        r103.addOnLayoutChangeListener(new f(this));
        return;
    L18:
        if (r103.isLayoutRequested() == true) goto L25;
        ObricFragmentUserExperiencePlanBinding r104 = this.f392027e;
        if (r104 == null) goto L30;
        OCardListItem r105 = r104.f389538f;
        if (r105 == null) goto L33;
        this.f392030h = null;
        p0.d(r105);
        return;
    L33:
        return;
    L30:
        return;
    L28:
        return;
    L32:
        return;
    L5:
        r101 = null;
        goto L6
    }

    /* JADX WARN: Type inference failed for: r2v0, types: [T, com.obric.assistant.settings.experience.b, java.lang.Object] */
    /* JADX WARN: Type inference incomplete: some casts might be missing */
    public final void W90(OCardListItem r100, final Function1<? super Boolean, Unit> r101) {
        final OSwitch r102 = r100.getEndSwitch();
        if (r102 != null) goto L5;
        return;
    L5:
        final Ref.LongRef r103 = new Ref.LongRef();
        final Ref.ObjectRef r104 = new Ref.ObjectRef();
        ?? r105 = new b(r103, r102, r104, r101);
        r104.element = r105;
        this.f392028f.put(r102, (CompoundButton.OnCheckedChangeListener) r105);
        r102.setOnCheckedChangeListener((CompoundButton.OnCheckedChangeListener) r104.element);
    }

    public final void aa0(OSwitch r100, boolean r101) {
        if (r100 != null) goto L4;
        return;
    L4:
        if (r100.isChecked() == r101) goto L9;
        CompoundButton.OnCheckedChangeListener r102 = (CompoundButton.OnCheckedChangeListener) ((LinkedHashMap) this.f392028f).get(r100);
        r100.setOnCheckedChangeListener(null);
        r100.setCheckedNoAnim(r101);
        r100.setOnCheckedChangeListener(r102);
        return;
    }

    @Override // androidx.fragment.app.Fragment
    public final void onViewCreated(View r110, Bundle r111) {
        Intrinsics.checkNotNullParameter(r110, "view");
        super.onViewCreated(r110, r111);
        ObricFragmentUserExperiencePlanBinding r112 = this.f392027e;
        if (r112 == null) goto L11;
        OFloatingTitleBar r113 = r112.f389537e;
        if (r113 == null) goto L11;
        if (this.f392031i == false) goto L10;
        r113.setCenterTitle(R.string.obric_user_experience_plan_title);
        OFloatingTitleBar.k(r113, new c(this), 2);
        goto L11
    L10:
        NovaTitleBarEx r100 = rda.a.b(r113);
        NovaTitleBarEx.Y5(r100, getString(R.string.obric_user_experience_plan_title), null, null, 6);
        NovaTitleBarEx.b6(r100, R.drawable.larus_ic_left_back, false, null, null, new d(this), 14);
    L11:
        ObricFragmentUserExperiencePlanBinding r114 = this.f392027e;
        if (r114 == null) goto L16;
        OSectionTitleBar r115 = r114.f389534b;
        if (r115 == null) goto L16;
        r115.setTitleText(getString(R.string.obric_user_experience_plan_function_section));
        r115.setTitleTextSize(12.0f);
        r115.setTitleTextColor(ContextCompat.getColor(requireContext(), R.color.oui_basic_text_3b));
        r115.a(false);
        r115.b(false);
    L16:
        ObricFragmentUserExperiencePlanBinding r116 = this.f392027e;
        if (r116 == null) goto L19;
        V90(r116.f389535c, R.string.obric_user_experience_plan_join, com.obric.assistant.settings.experience.a.a(requireContext(), R.string.obric_user_experience_plan_summary, R.color.oui_functional_blue_6));
        V90(r116.f389538f, R.string.obric_setting_improve_voice_wakeup, getString(R.string.obric_user_experience_plan_voice_summary));
        V90(r116.f389536d, R.string.obric_user_experience_plan_model, getString(R.string.obric_user_experience_plan_model_summary));
        OCardListItem.h(r116.f389535c, 0);
        OCardListItem.h(r116.f389538f, 1);
        OCardListItem.h(r116.f389536d, 3);
        W90(r116.f389535c, new ObricUserExperiencePlanFragment$bindSwitches$1$1(this));
    L19:
        Z90(getArguments());
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(getViewLifecycleOwner()), null, null, new AnonymousClass2(this, null), 3, null);
    }

    public final void V90(OCardListItem r100, int r101, CharSequence r102) {
        r100.setCardType(0);
        r100.p(false);
        r100.setTitle(getString(r101));
        r100.s(true);
        r100.setSubTitle(r102);
        r100.q(true);
        r100.getSubTitleView().setMaxLines(6);
        r100.getSubTitleView().setHighlightColor(0);
        OTextView r103 = r100.getSubTitleView();
        MovementMethod r104 = null;
        if ((r102 instanceof Spanned) == false) goto L5;
        Spanned r105 = (Spanned) r102;
    L6:
        if (r105 == null) goto L16;
        ClickableSpan[] r106 = (ClickableSpan[]) r105.getSpans(0, r102.length(), ClickableSpan.class);
        if (r106 == null) goto L16;
        if (r106.length != 0) goto L12;
        boolean r107 = true;
    L14:
        if ((!r107) != true) goto L16;
        boolean r108 = true;
    L17:
        if (r108 == false) goto L19;
        r104 = LinkMovementMethod.getInstance();
    L19:
        r103.setMovementMethod(r104);
        r100.setDefaultCustomEndView(1);
        r100.m(true);
        r100.r(false);
        return;
    L12:
        r107 = false;
    L16:
        r108 = false;
        goto L17
    L5:
        r105 = null;
        goto L6
    }

    @Override // androidx.fragment.app.Fragment
    public final View onCreateView(LayoutInflater r100, ViewGroup r101, Bundle r110) {
        Intrinsics.checkNotNullParameter(r100, "inflater");
        View r102 = r100.inflate(R.layout.obric_fragment_user_experience_plan, r101, false);
        int r103 = R.id.function_section_title;
        OSectionTitleBar r104 = (OSectionTitleBar) ViewBindings.findChildViewById(r102, R.id.function_section_title);
        if (r104 == null) goto L15;
        r103 = R.id.master_switch;
        OCardListItem r105 = (OCardListItem) ViewBindings.findChildViewById(r102, R.id.master_switch);
        if (r105 == null) goto L15;
        r103 = R.id.model_switch;
        OCardListItem r106 = (OCardListItem) ViewBindings.findChildViewById(r102, R.id.model_switch);
        if (r106 == null) goto L15;
        r103 = R.id.top_bar;
        OFloatingTitleBar r107 = (OFloatingTitleBar) ViewBindings.findChildViewById(r102, R.id.top_bar);
        if (r107 == null) goto L15;
        r103 = R.id.voice_switch;
        OCardListItem r108 = (OCardListItem) ViewBindings.findChildViewById(r102, R.id.voice_switch);
        if (r108 == null) goto L15;
        ConstraintLayout r109 = (ConstraintLayout) r102;
        this.f392027e = new ObricFragmentUserExperiencePlanBinding(r109, r104, r105, r106, r107, r108);
        return r109;
    L15:
        throw new NullPointerException("Missing required view with ID: ".concat(r102.getResources().getResourceName(r103)));
    }

    public final void Y90(final OCardListItem r100, boolean r101, boolean r102, Function1<? super Boolean, Unit> r103) {
        OSwitch r104 = (OSwitch) r100.findViewById(R.id.disabled_switch);
        if (r102 == false) goto L13;
        if (r104 == null) goto L6;
        r100.setDefaultCustomEndView(1);
        r100.m(true);
    L6:
        OSwitch r105 = r100.getEndSwitch();
        if (r105 != null) goto L9;
    L11:
        aa0(r105, r101);
    L24:
        if (r102 == false) goto L26;
        float r106 = 1.0f;
    L27:
        r100.getTitleView().setAlpha(r106);
        r100.getSubTitleView().setAlpha(r106);
        return;
    L26:
        r106 = 0.3f;
        goto L27
    L9:
        if (((LinkedHashMap) this.f392028f).get(r105) != null) goto L11;
        W90(r100, r103);
        goto L11
    L13:
        if (r104 != null) goto L18;
        OSwitch r107 = r100.getEndSwitch();
        if (r107 == null) goto L17;
        r107.setOnCheckedChangeListener(null);
        CompoundButton.OnCheckedChangeListener r108 = this.f392028f.remove(r107);
    L17:
        r100.setCustomEndView(R.layout.item_obric_setting_disabled_switch);
        r100.m(true);
    L18:
        OSwitch r109 = (OSwitch) r100.findViewById(R.id.disabled_switch);
        if (r109 == null) goto L21;
        r109.setOnCheckedChangeListener(null);
        r109.setChecked(r101);
        r109.setEnabled(false);
    L21:
        View r110 = r100.findViewById(R.id.disabled_switch_container);
        if (r110 == null) goto L24;
        r110.setOnClickListener(new e(this, r100));
        goto L24
    }
}
