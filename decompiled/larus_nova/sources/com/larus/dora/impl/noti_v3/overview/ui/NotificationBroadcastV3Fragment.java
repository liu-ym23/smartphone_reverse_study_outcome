package com.larus.dora.impl.noti_v3.overview.ui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ScrollView;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.viewbinding.ViewBindings;
import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import com.larus.avlink.api.DoraAVLinkDelegate;
import com.larus.bmhome.view.item.CustomSwitchCompat;
import com.larus.bmhome.view.item.ItemGroup;
import com.larus.bmhome.view.item.ItemTextArrow;
import com.larus.bmhome.view.item.ItemTextToggle;
import com.larus.common_ui.widget.UrlSpanTextView;
import com.larus.dora.impl.databinding.LarusDoraPageNotiV3Binding;
import com.larus.dora.impl.device.DoraBaseFragment;
import com.larus.dora.impl.nl.DoraUserSettingsManager;
import com.larus.dora.impl.nl.permission.CategoryWhenNotGranted;
import com.larus.dora.impl.nl.permission.ProactivePermission;
import com.larus.dora.impl.noti_v3.overview.viewmodel.NotificationBroadcastV3ViewModel;
import com.larus.dora.impl.noti_v3.social_message.dialog.NotificationBroadcastV3MessageModeBottomSheetDialogFragment;
import com.larus.dora.impl.settings.DoraPushSummaryConfig;
import com.larus.dora.impl.view.DoraItemTextArrowSubTitle;
import com.larus.dora.impl.view.DoraItemTextToggleSubTitle;
import com.larus.dora.impl.view.DoraNovaTitleBarEx;
import com.larus.dora.impl.view.DoraTextView;
import com.larus.nova.R;
import com.larus.utils.e1;
import com.larus.utils.j0;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import com.obric.assistant.spi.dora.IObricDoraService;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes27.dex */
@Metadata(d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u001b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 N2\u00020\u0001:\u0001NB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001cH\u0016J&\u0010\u001d\u001a\u0004\u0018\u00010\u001e2\u0006\u0010\u001f\u001a\u00020 2\b\u0010!\u001a\u0004\u0018\u00010\"2\b\u0010#\u001a\u0004\u0018\u00010$H\u0016J\u001a\u0010%\u001a\u00020\u001a2\u0006\u0010&\u001a\u00020\u001e2\b\u0010#\u001a\u0004\u0018\u00010$H\u0016J\b\u0010'\u001a\u00020\u001aH\u0002J\u0010\u0010(\u001a\u00020\u001a2\u0006\u0010)\u001a\u00020*H\u0002J\u0010\u0010+\u001a\u00020\u001a2\u0006\u0010)\u001a\u00020*H\u0002J\b\u0010,\u001a\u00020\u001aH\u0016J\b\u0010-\u001a\u00020\u001aH\u0016J\b\u0010.\u001a\u00020*H\u0016J\n\u0010/\u001a\u0004\u0018\u00010\u001eH\u0016J\n\u00100\u001a\u0004\u0018\u000101H\u0002J\u000f\u00102\u001a\u0004\u0018\u00010\u001aH\u0002¢\u0006\u0002\u00103J\b\u00104\u001a\u00020\u001aH\u0002J\b\u00105\u001a\u00020\u001aH\u0002J\b\u00106\u001a\u00020\u001aH\u0002J\b\u00107\u001a\u00020\u001aH\u0002J\b\u00108\u001a\u00020\u001aH\u0002J\u0017\u00109\u001a\u0004\u0018\u00010\u001a2\u0006\u0010:\u001a\u00020\u0007H\u0002¢\u0006\u0002\u0010;J\u0017\u0010<\u001a\u0004\u0018\u00010\u001a2\u0006\u0010=\u001a\u00020\u0007H\u0002¢\u0006\u0002\u0010;J\u001f\u0010>\u001a\u0004\u0018\u00010\u001a2\u0006\u0010=\u001a\u00020\u00072\u0006\u0010?\u001a\u00020\u0007H\u0002¢\u0006\u0002\u0010@J\u0010\u0010A\u001a\u00020\u001a2\u0006\u0010:\u001a\u00020\u0007H\u0002J\b\u0010B\u001a\u00020\u001aH\u0002J\b\u0010C\u001a\u00020\u001aH\u0002J\b\u0010D\u001a\u00020\u001aH\u0002J\u0018\u0010E\u001a\u00020\u001a2\u0006\u0010F\u001a\u00020\u00072\u0006\u0010G\u001a\u00020\u0007H\u0002J\u0018\u0010H\u001a\u00020\u001a2\u0006\u0010F\u001a\u00020\u00072\u0006\u0010G\u001a\u00020\u0007H\u0002J\b\u0010I\u001a\u00020\u001aH\u0002J\u0010\u0010J\u001a\u00020\u001a2\u0006\u0010:\u001a\u00020\u0007H\u0002J\u0016\u0010K\u001a\u00020\u001a2\f\u0010L\u001a\b\u0012\u0004\u0012\u00020\u001a0MH\u0002R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\b\u001a\u00020\t8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\n\u0010\u000bR\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\u0010\u001a\u00020\u00118BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0014\u0010\r\u001a\u0004\b\u0012\u0010\u0013R\u001c\u0010\u0015\u001a\u0010\u0012\f\u0012\n \u0018*\u0004\u0018\u00010\u00170\u00170\u0016X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006O"}, d2 = {"Lcom/larus/dora/impl/noti_v3/overview/ui/NotificationBroadcastV3Fragment;", "Lcom/larus/dora/impl/device/DoraBaseFragment;", "<init>", "()V", "binding", "Lcom/larus/dora/impl/databinding/LarusDoraPageNotiV3Binding;", "firstResume", "", "viewModel", "Lcom/larus/dora/impl/noti_v3/overview/viewmodel/NotificationBroadcastV3ViewModel;", "getViewModel", "()Lcom/larus/dora/impl/noti_v3/overview/viewmodel/NotificationBroadcastV3ViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "mainHandle", "Landroid/os/Handler;", "settings", "Lcom/larus/dora/impl/settings/DoraPushSummaryConfig;", "getSettings", "()Lcom/larus/dora/impl/settings/DoraPushSummaryConfig;", "settings$delegate", "headControlLauncher", "Landroidx/activity/result/ActivityResultLauncher;", "Landroid/content/Intent;", "kotlin.jvm.PlatformType", "onAttach", "", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", KtvSubElement.CONTAINER, "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "view", "observeFragmentResult", "handleConflictSelected", "mode", "", "handleRhythmSelected", "onResume", "onDestroyView", "getCurrentPageName", "getPageMaskView", "setupTitle", "Lcom/larus/dora/impl/view/DoraNovaTitleBarEx;", "setupActions", "()Lkotlin/Unit;", "openInvalidHelpPage", "observeNotificationState", "observeNotificationPrivacyState", "observeWearingRemindState", "observeUiState", "updateNotificationSectionState", "enabled", "(Z)Lkotlin/Unit;", "updateMoreGroupBackground", "showWearingRemind", "updateMoreSectionState", "showInvalidHelp", "(ZZ)Lkotlin/Unit;", "handleNotificationSwitchClick", "showNotificationPrivacyDialog", "checkPermissionAndEnableNotification", "checkPermissionOnFirstResume", "checkPermissionOnOther", "isProactiveNotificationEnabled", "isProactiveChatEnabled", "checkPermissionOnHonor", "updateHeadGestureControl", "updateHeadGestureControlState", "showHeadControlDisableDialog", "onConfirm", "Lkotlin/Function0;", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class NotificationBroadcastV3Fragment extends DoraBaseFragment {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final /* synthetic */ int f336411l = 0;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public LarusDoraPageNotiV3Binding f336412f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f336413g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Lazy f336414h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Handler f336415i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Lazy f336416j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final ActivityResultLauncher<Intent> f336417k;

    public static final class a {
    }

    /* JADX INFO: renamed from: com.larus.dora.impl.noti_v3.overview.ui.NotificationBroadcastV3Fragment$onAttach$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.dora.impl.noti_v3.overview.ui.NotificationBroadcastV3Fragment$onAttach$1", f = "NotificationBroadcastV3Fragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        public AnonymousClass1(Continuation<? super AnonymousClass1> r100) {
            super(2, r100);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
            return new AnonymousClass1(r101);
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
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L7;
            ResultKt.throwOnFailure(r100);
            DoraUserSettingsManager.f336185a.h("enterNotificationBroadcastV3");
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    static {
    }

    @Override // com.larus.trace.tracknode.a
    public final String k() {
        return "dora_broadcast_settings";
    }

    @Override // com.larus.dora.impl.device.DoraBaseFragment
    public final View U90() {
        LarusDoraPageNotiV3Binding r100 = this.f336412f;
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.f333083v;
    }

    public final void X90() {
        if (DoraAVLinkDelegate.f291640b.y() == false) goto L5;
        List r100 = CollectionsKt.listOf(new ProactivePermission[]{ProactivePermission.POST_NOTIFICATION, ProactivePermission.NOTIFICATION_LISTENER});
    L6:
        int r101 = p59.b.f527842a;
        p59.b.c(this, r100, CategoryWhenNotGranted.INTERRUPT, new g(this));
        return;
    L5:
        r100 = CollectionsKt.listOf(ProactivePermission.NOTIFICATION_LISTENER);
        goto L6
    }

    public final NotificationBroadcastV3ViewModel Y90() {
        return (NotificationBroadcastV3ViewModel) this.f336414h.getValue();
    }

    public NotificationBroadcastV3Fragment() {
        this.f336413g = true;
        final Function0<Fragment> r100 = new NotificationBroadcastV3Fragment$special$$inlined$viewModels$default$1(this);
        this.f336414h = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(NotificationBroadcastV3ViewModel.class), new NotificationBroadcastV3Fragment$special$$inlined$viewModels$default$2(r100), new NotificationBroadcastV3Fragment$special$$inlined$viewModels$default$3(r100, this));
        this.f336415i = new Handler(Looper.getMainLooper());
        this.f336416j = LazyKt.lazy(new m());
        this.f336417k = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new n(this));
    }

    @Override // androidx.fragment.app.Fragment
    public final void onDestroyView() {
        super.onDestroyView();
        this.f336412f = null;
    }

    @Override // com.larus.trace.tracknode.TraceFragment, androidx.fragment.app.Fragment
    public final void onResume() {
        super.onResume();
        if (this.f336413g == false) goto L29;
        this.f336413g = false;
        if (((DoraPushSummaryConfig) this.f336416j.getValue()).getNotificationSummary() == true) goto L7;
    L9:
        final boolean r100 = false;
    L11:
        if (((DoraPushSummaryConfig) this.f336416j.getValue()).getProactiveMessage() == true) goto L13;
    L15:
        final boolean r101 = false;
    L17:
        if (r101 == true) goto L21;
        if (r100 == true) goto L21;
        g49.d.d("NotificationBroadcastV3Fragment", "checkPermissionOnFirstResume: notification and proactive chat are both disabled");
    L21:
        if (DoraAVLinkDelegate.f291640b.y() == false) goto L23;
        this.f336415i.postDelayed(new u(this, r100, r101), 50);
        goto L29
    L23:
        g49.d.d("NotificationBroadcastV3Fragment", "checkPermissionOnOther: isProactiveNotificationEnabled=" + r100 + ", isProactiveChatEnabled=" + r101);
        if (r101 == true) goto L26;
        List r102 = CollectionsKt.listOf(ProactivePermission.NOTIFICATION_LISTENER);
    L27:
        int r103 = p59.b.f527842a;
        p59.b.c(this, r102, CategoryWhenNotGranted.NEXT, new com.larus.dora.impl.noti_v3.overview.ui.a(r101, r100));
        goto L29
    L26:
        r102 = CollectionsKt.listOf(new ProactivePermission[]{ProactivePermission.POST_NOTIFICATION, ProactivePermission.NOTIFICATION_LISTENER});
        goto L27
    L13:
        if (((Boolean) DoraUserSettingsManager.f336199o.getValue()).booleanValue() == false) goto L15;
        r101 = true;
        goto L17
    L7:
        if (((Boolean) DoraUserSettingsManager.f336191g.getValue()).booleanValue() == false) goto L9;
        r100 = true;
    L29:
        if (((DoraPushSummaryConfig) this.f336416j.getValue()).getNotificationSummary() == false) goto L32;
        Y90().syncSettings();
        return;
    }

    public final void Z90(boolean r100) {
        LarusDoraPageNotiV3Binding r101 = this.f336412f;
        if (r101 == null) goto L9;
        DoraItemTextToggleSubTitle r102 = r101.f333069h;
        if (r102 == null) goto L9;
        CustomSwitchCompat r103 = r102.getToggleView();
        if (r103 == null) goto L9;
        r103.setChecked(r100);
    L9:
        com.larus.dora.impl.util.b0.f338123a.getClass();
        com.larus.dora.impl.util.b0.K(r100);
    }

    public final Unit aa0(boolean r100) {
        if (this.f336412f != null) goto L7;
        return null;
    L7:
        return ba0(r100, ((Boolean) DoraUserSettingsManager.f336191g.getValue()).booleanValue());
    }

    @Override // androidx.fragment.app.Fragment
    public final void onAttach(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super.onAttach(r100);
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new AnonymousClass1(null), 3, null);
    }

    public static void W90(NotificationBroadcastV3MessageModeBottomSheetDialogFragment r100, FragmentManager r101) {
        LandscapeRestrictionOperation r102 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW;
        LandscapeRestrictionGuard.markDialogFragmentIfAllowed(r100, "NotificationBroadcastV3MessageModeBottomSheetDialogFragment", r102);
        if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r101, r100, r102) == false) goto L9;
        return;
    L9:
        DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L8
    L6:
        r100.show(r101, "NotificationBroadcastV3MessageModeBottomSheetDialogFragment");
    }

    public final Unit ba0(boolean r100, boolean r101) {
        LarusDoraPageNotiV3Binding r102 = this.f336412f;
        if (r102 == null) goto L19;
        if (r100 == true) goto L8;
        if (r101 == true) goto L8;
        boolean r103 = false;
    L9:
        if (r100 == false) goto L11;
        e1.x(r102.f333082u);
    L12:
        if (r101 == false) goto L14;
        e1.x(r102.f333071j);
    L15:
        if (r103 == false) goto L17;
        e1.x(r102.f333073l);
        e1.x(r102.f333074m);
    L18:
        r102.f333073l.c();
        return Unit.INSTANCE;
    L17:
        e1.o(r102.f333073l);
        e1.o(r102.f333074m);
        goto L18
    L14:
        e1.o(r102.f333071j);
        goto L15
    L11:
        e1.o(r102.f333082u);
    L8:
        r103 = true;
        goto L9
    L19:
        return null;
    }

    @Override // androidx.fragment.app.Fragment
    public final void onViewCreated(View r100, Bundle r101) {
        Intrinsics.checkNotNullParameter(r100, "view");
        super.onViewCreated(r100, r101);
        LarusDoraPageNotiV3Binding r102 = this.f336412f;
        if (r102 == null) goto L5;
        DoraNovaTitleBarEx r103 = r102.f333084w;
        int r104 = j0.f375426a;
        DoraNovaTitleBarEx.S5(r103, j0.d(R.string.larus_doubao_active_notification_entrance_cn));
        DoraNovaTitleBarEx.T5(r103, new o(this));
    L5:
        final LarusDoraPageNotiV3Binding r105 = this.f336412f;
        boolean r106 = true;
        if (r105 == null) goto L8;
        UrlSpanTextView r107 = r105.f333078q;
        StringBuilder r108 = new StringBuilder();
        int r109 = j0.f375426a;
        r108.append(j0.d(R.string.larus_dora_allow_broadcast_entrance_footer_cn));
        r108.append(' ');
        r107.setUrlSpannedText(r108.toString());
        r105.f333078q.setOnClickListener(new z(r105));
        r105.f333077p.getToggleView().f316954a = true;
        e1.d(r105.f333077p, new p(this));
        e1.d(r105.f333081t, new q(this));
        e1.d(r105.f333079r, new r(this));
        e1.d(r105.f333076o, new s(this));
        e1.d(r105.f333080s, new t(this));
        e1.d(r105.f333075n, new b(this));
        e1.d(r105.f333068g, new c(this));
        r105.f333082u.getToggleView().f316954a = true;
        e1.d(r105.f333082u, new d(r105));
        e1.d(r105.f333070i, new e(this));
        Unit r110 = Unit.INSTANCE;
    L8:
        IObricDoraService r111 = (IObricDoraService) ServiceManager.get().getService(IObricDoraService.class);
        if (r111 != null) goto L11;
    L13:
        r106 = false;
    L15:
        if (r106 == false) goto L22;
        LarusDoraPageNotiV3Binding r112 = this.f336412f;
        if (r112 == null) goto L21;
        DoraItemTextToggleSubTitle r113 = r112.f333082u;
        if (r113 == null) goto L21;
        e1.o(r113);
    L21:
        aa0(false);
    L24:
        if (((DoraPushSummaryConfig) this.f336416j.getValue()).getNotificationSummary() == false) goto L26;
        Lifecycle.State r114 = Lifecycle.State.STARTED;
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(getViewLifecycleOwner()), null, null, new NotificationBroadcastV3Fragment$observeNotificationState$$inlined$launchAndRepeatWithViewLifecycle$default$1(this, r114, null, this), 3, null);
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(getViewLifecycleOwner()), null, null, new NotificationBroadcastV3Fragment$observeNotificationPrivacyState$$inlined$launchAndRepeatWithViewLifecycle$default$1(this, r114, null, this), 3, null);
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(getViewLifecycleOwner()), null, null, new NotificationBroadcastV3Fragment$observeUiState$$inlined$launchAndRepeatWithViewLifecycle$default$1(this, r114, null, this), 3, null);
        getParentFragmentManager().setFragmentResultListener("request_key_message_mode_result", getViewLifecycleOwner(), new h(this));
        Y90().syncSettings();
        return;
    L26:
        LarusDoraPageNotiV3Binding r115 = this.f336412f;
        if (r115 == null) goto L34;
        e1.o(r115.f333072k);
        e1.o(r115.f333067f);
        e1.o(r115.f333066e);
        e1.o(r115.f333063b);
        e1.o(r115.f333065d);
        e1.o(r115.f333064c);
        DoraTextView r116 = r115.f333074m;
        ViewGroup.LayoutParams r117 = r116.getLayoutParams();
        if (r117 == null) goto L32;
        ViewGroup.MarginLayoutParams r118 = (ViewGroup.MarginLayoutParams) r117;
        int r119 = j0.f375426a;
        r118.topMargin = j0.b(v19.c.b(R.attr.larus_dp_12, null, R.dimen.larus_dp_12));
        r116.setLayoutParams(r118);
        return;
    L32:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
    L34:
        return;
    L22:
        Lifecycle.State r120 = Lifecycle.State.STARTED;
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(getViewLifecycleOwner()), null, null, new NotificationBroadcastV3Fragment$observeWearingRemindState$$inlined$launchAndRepeatWithViewLifecycle$default$1(this, r120, null, this), 3, null);
        goto L24
    L11:
        if (r111.t() != true) goto L13;
        goto L13
    }

    @Override // androidx.fragment.app.Fragment
    public final View onCreateView(LayoutInflater r210, ViewGroup r211, Bundle r310) {
        Intrinsics.checkNotNullParameter(r210, "inflater");
        View r100 = r210.inflate(R.layout.larus_dora_page_noti_v3, r211, false);
        int r101 = R.id.dora_noti_v3_app_management_group;
        ItemGroup r102 = (ItemGroup) ViewBindings.findChildViewById(r100, R.id.dora_noti_v3_app_management_group);
        if (r102 == null) goto L51;
        r101 = R.id.dora_noti_v3_behavior_group;
        ItemGroup r103 = (ItemGroup) ViewBindings.findChildViewById(r100, R.id.dora_noti_v3_behavior_group);
        if (r103 == null) goto L51;
        r101 = R.id.dora_noti_v3_behavior_title;
        DoraTextView r104 = (DoraTextView) ViewBindings.findChildViewById(r100, R.id.dora_noti_v3_behavior_title);
        if (r104 == null) goto L51;
        r101 = R.id.dora_noti_v3_content_group;
        ItemGroup r105 = (ItemGroup) ViewBindings.findChildViewById(r100, R.id.dora_noti_v3_content_group);
        if (r105 == null) goto L51;
        r101 = R.id.dora_noti_v3_content_title;
        DoraTextView r106 = (DoraTextView) ViewBindings.findChildViewById(r100, R.id.dora_noti_v3_content_title);
        if (r106 == null) goto L51;
        r101 = R.id.dora_noti_v3_custom_broadcast_rules_entrance;
        ItemTextArrow r110 = (ItemTextArrow) ViewBindings.findChildViewById(r100, R.id.dora_noti_v3_custom_broadcast_rules_entrance);
        if (r110 == null) goto L51;
        r101 = R.id.dora_noti_v3_head_gesture_control_switch;
        DoraItemTextToggleSubTitle r111 = (DoraItemTextToggleSubTitle) ViewBindings.findChildViewById(r100, R.id.dora_noti_v3_head_gesture_control_switch);
        if (r111 == null) goto L51;
        r101 = R.id.dora_noti_v3_invalid_help_entrance;
        DoraItemTextArrowSubTitle r112 = (DoraItemTextArrowSubTitle) ViewBindings.findChildViewById(r100, R.id.dora_noti_v3_invalid_help_entrance);
        if (r112 == null) goto L51;
        r101 = R.id.dora_noti_v3_invalid_help_group;
        ItemGroup r113 = (ItemGroup) ViewBindings.findChildViewById(r100, R.id.dora_noti_v3_invalid_help_group);
        if (r113 == null) goto L51;
        r101 = R.id.dora_noti_v3_master_group;
        ItemGroup r114 = (ItemGroup) ViewBindings.findChildViewById(r100, R.id.dora_noti_v3_master_group);
        if (r114 == null) goto L51;
        r101 = R.id.dora_noti_v3_more_group;
        ItemGroup r115 = (ItemGroup) ViewBindings.findChildViewById(r100, R.id.dora_noti_v3_more_group);
        if (r115 == null) goto L51;
        r101 = R.id.dora_noti_v3_more_title;
        DoraTextView r116 = (DoraTextView) ViewBindings.findChildViewById(r100, R.id.dora_noti_v3_more_title);
        if (r116 == null) goto L51;
        r101 = R.id.dora_noti_v3_notification_app_list_setting;
        ItemTextArrow r117 = (ItemTextArrow) ViewBindings.findChildViewById(r100, R.id.dora_noti_v3_notification_app_list_setting);
        if (r117 == null) goto L51;
        r101 = R.id.dora_noti_v3_notification_freq;
        ItemTextArrow r118 = (ItemTextArrow) ViewBindings.findChildViewById(r100, R.id.dora_noti_v3_notification_freq);
        if (r118 == null) goto L51;
        r101 = R.id.dora_noti_v3_notification_switch;
        ItemTextToggle r119 = (ItemTextToggle) ViewBindings.findChildViewById(r100, R.id.dora_noti_v3_notification_switch);
        if (r119 == null) goto L51;
        r101 = R.id.dora_noti_v3_notification_tips;
        UrlSpanTextView r212 = (UrlSpanTextView) ViewBindings.findChildViewById(r100, R.id.dora_noti_v3_notification_tips);
        if (r212 == null) goto L51;
        r101 = R.id.dora_noti_v3_priority;
        ItemTextArrow r213 = (ItemTextArrow) ViewBindings.findChildViewById(r100, R.id.dora_noti_v3_priority);
        if (r213 == null) goto L51;
        r101 = R.id.dora_noti_v3_service_notice;
        ItemTextArrow r214 = (ItemTextArrow) ViewBindings.findChildViewById(r100, R.id.dora_noti_v3_service_notice);
        if (r214 == null) goto L51;
        r101 = R.id.dora_noti_v3_social_message;
        ItemTextArrow r215 = (ItemTextArrow) ViewBindings.findChildViewById(r100, R.id.dora_noti_v3_social_message);
        if (r215 == null) goto L51;
        r101 = R.id.dora_noti_v3_wearing_remind;
        DoraItemTextToggleSubTitle r216 = (DoraItemTextToggleSubTitle) ViewBindings.findChildViewById(r100, R.id.dora_noti_v3_wearing_remind);
        if (r216 == null) goto L51;
        r101 = R.id.dora_page_mask;
        View r217 = ViewBindings.findChildViewById(r100, R.id.dora_page_mask);
        if (r217 == null) goto L51;
        r101 = R.id.scroll_view;
        if (((ScrollView) ViewBindings.findChildViewById(r100, R.id.scroll_view)) == null) goto L51;
        r101 = R.id.title;
        DoraNovaTitleBarEx r218 = (DoraNovaTitleBarEx) ViewBindings.findChildViewById(r100, R.id.title);
        if (r218 == null) goto L51;
        ConstraintLayout r107 = (ConstraintLayout) r100;
        this.f336412f = new LarusDoraPageNotiV3Binding(r107, r102, r103, r104, r105, r106, r110, r111, r112, r113, r114, r115, r116, r117, r118, r119, r212, r213, r214, r215, r216, r217, r218);
        return r107;
    L51:
        throw new NullPointerException("Missing required view with ID: ".concat(r100.getResources().getResourceName(r101)));
    }
}
