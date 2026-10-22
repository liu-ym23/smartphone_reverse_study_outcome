package com.larus.dora.impl.guide;

import android.content.DialogInterface;
import android.media.AudioManager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LifecycleCoroutineScope;
import androidx.lifecycle.LifecycleOwnerKt;
import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.larus.common.apphost.AppHost;
import com.larus.dora.api.IDoraGuideService;
import com.larus.dora.impl.DoraBuryPointManager;
import com.larus.dora.impl.databinding.LarusDoraGuideBindDeviceDialogBinding;
import com.larus.dora.impl.guide.common.DoraGuideMeta;
import com.larus.dora.impl.guide.service.GuideSession$setStateListener$1;
import com.larus.dora.impl.guide.strategy.BasicDoraDeviceCheckStrategy;
import com.larus.dora.impl.guide.strategy.FineDoraDeviceStrategy;
import com.larus.dora.impl.settings.DoraSetting;
import com.larus.nova.R;
import com.larus.platform.service.AccountService;
import com.larus.utils.e1;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.helpers.PopupOrDialogVisibilityTracker;
import com.obric.assistant.interaction.impl.window.landscape.childwindow.LandscapeChildDialogBoundsAdapter;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.MainCoroutineDispatcher;

/* JADX INFO: loaded from: classes27.dex */
public final class DoraBindGuide implements t39.l {

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final /* synthetic */ int f335873p = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f335874a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f335875b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f335876c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final List<String> f335877d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Lazy f335878e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Lazy f335879f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Lazy f335880g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Lazy f335881h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Lazy f335882i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public FineDoraDeviceStrategy f335883j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public BindBottomSheetDialogFragment f335884k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f335885l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public t39.m f335886m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public LifecycleCoroutineScope f335887n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public Job f335888o;

    @Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 %2\u00020\u0001:\u0002%&B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0011\u001a\u00020\u0012H\u0016J\u0006\u0010\u0013\u001a\u00020\u0014J&\u0010\u0015\u001a\u0004\u0018\u00010\u00162\u0006\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0016J\u001a\u0010\u001d\u001a\u00020\u00142\u0006\u0010\u001e\u001a\u00020\u00162\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0016J\b\u0010\u001f\u001a\u00020\u0014H\u0002J\u0010\u0010 \u001a\u00020\u00142\u0006\u0010!\u001a\u00020\"H\u0016J\u0010\u0010#\u001a\u00020\u00142\u0006\u0010!\u001a\u00020\"H\u0016J\b\u0010$\u001a\u00020\u0014H\u0016R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001e\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\u000b@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006'"}, d2 = {"Lcom/larus/dora/impl/guide/DoraBindGuide$BindBottomSheetDialogFragment;", "Lcom/google/android/material/bottomsheet/BottomSheetDialogFragment;", "<init>", "()V", "guide", "Lcom/larus/dora/impl/guide/DoraBindGuide;", "getGuide", "()Lcom/larus/dora/impl/guide/DoraBindGuide;", "setGuide", "(Lcom/larus/dora/impl/guide/DoraBindGuide;)V", "value", "Lcom/larus/dora/impl/guide/DoraBindGuide$BindBottomSheetDialogFragment$Phase;", "phase", "getPhase", "()Lcom/larus/dora/impl/guide/DoraBindGuide$BindBottomSheetDialogFragment$Phase;", "binding", "Lcom/larus/dora/impl/databinding/LarusDoraGuideBindDeviceDialogBinding;", "getTheme", "", "goBindFail", "", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", KtvSubElement.CONTAINER, "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "view", "setupView", "onCancel", "dialog", "Landroid/content/DialogInterface;", "onDismiss", "onDestroyView", "Companion", "Phase", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class BindBottomSheetDialogFragment extends BottomSheetDialogFragment {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public static final /* synthetic */ int f335889g = 0;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public DoraBindGuide f335890d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public Phase f335891e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public LarusDoraGuideBindDeviceDialogBinding f335892f;

        @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/larus/dora/impl/guide/DoraBindGuide$BindBottomSheetDialogFragment$Phase;", "", "value", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "BindGuide", "BindFail", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
        public static final enum Phase extends Enum<Phase> {
            public static final Phase BindFail = null;
            public static final Phase BindGuide = null;

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ Phase[] f335893a = null;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public static final /* synthetic */ EnumEntries f335894b = null;
            private final String value;

            public static EnumEntries<Phase> getEntries() {
                return f335894b;
            }

            static {
                Phase r100 = new Phase("BindGuide", 0, "bind_guide");
                BindGuide = r100;
                Phase r101 = new Phase("BindFail", 1, "bind_fail");
                BindFail = r101;
                Phase[] r102 = {r100, r101};
                f335893a = r102;
                f335894b = EnumEntriesKt.enumEntries(r102);
            }

            public static Phase[] values() {
                return (Phase[]) f335893a.clone();
            }

            public final String getValue() {
                return this.value;
            }

            public static Phase valueOf(String r100) {
                return (Phase) r27.a.a(Phase.class, r100);
            }

            public Phase(String r100, int r101, String r102) {
                super(r100, r101);
                this.value = r102;
            }
        }

        public static final class a {
        }

        public /* synthetic */ class b {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ int[] f335895a = null;

            static {
                int[] r100 = new int[Phase.values().length];
                r100[Phase.BindGuide.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
            L9:
                r100[Phase.BindFail.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
            L5:
                f335895a = r100;
            }
        }

        static {
        }

        @Override // androidx.fragment.app.DialogFragment
        public final int getTheme() {
            return R.style.BottomSheetTransparentDialog_Dora_Onboarding;
        }

        public BindBottomSheetDialogFragment() {
            this.f335891e = Phase.BindGuide;
        }

        @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
        public final void onDestroyView() {
            super.onDestroyView();
            this.f335892f = null;
        }

        @Override // androidx.fragment.app.DialogFragment, android.content.DialogInterface.OnCancelListener
        public final void onCancel(DialogInterface r100) {
            Intrinsics.checkNotNullParameter(r100, "dialog");
            super.onCancel(r100);
            DoraBindGuide r101 = this.f335890d;
            if (r101 == null) goto L6;
            DoraBindGuide.h(r101, this.f335891e);
            return;
        }

        @Override // androidx.fragment.app.DialogFragment, android.content.DialogInterface.OnDismissListener
        public final void onDismiss(DialogInterface r100) {
            Intrinsics.checkNotNullParameter(r100, "dialog");     // Catch: Throwable -> L8
            super.onDismiss(r100);     // Catch: Throwable -> L8
            DoraBindGuide r101 = this.f335890d;     // Catch: Throwable -> L8
            if (r101 == null) goto L5;
            int r102 = DoraBindGuide.f335873p;     // Catch: Throwable -> L8
            g49.d.d("DoraBindGuide", "onDialogClosed() from dialog");     // Catch: Throwable -> L8
            r101.i(3);     // Catch: Throwable -> L8
        L6:
            LandscapeChildDialogBoundsAdapter.onDialogDismissed(getDialog());
            PopupOrDialogVisibilityTracker.onDialogFragmentDismissed(this);
            LandscapeRestrictionGuard.clearAllowedDialogFragment(this);
            return;
        L5:
            g49.d.b("BindBottomSheetDialogFragment", "Guide reference is null on destroy view");     // Catch: Throwable -> L8
        L8:
            th = move-exception;
            LandscapeChildDialogBoundsAdapter.onDialogDismissed(getDialog());
            PopupOrDialogVisibilityTracker.onDialogFragmentDismissed(this);
            LandscapeRestrictionGuard.clearAllowedDialogFragment(this);
            throw th;
        }

        @Override // androidx.fragment.app.Fragment
        public final void onViewCreated(View r100, Bundle r101) {
            Intrinsics.checkNotNullParameter(r100, "view");
            super.onViewCreated(r100, r101);
            LarusDoraGuideBindDeviceDialogBinding r102 = this.f335892f;
            if (r102 == null) goto L7;
            FrameLayout r103 = r102.f332666a;
            if (r103 == null) goto L7;
            r103.post(new o(this));
        L7:
            LarusDoraGuideBindDeviceDialogBinding r104 = this.f335892f;
            if (r104 == null) goto L11;
            e1.d(r104.f332668c, new p(this));
            e1.d(r104.f332669d, new q(this));
            return;
        }

        @Override // androidx.fragment.app.Fragment
        public final View onCreateView(LayoutInflater r100, ViewGroup r101, Bundle r102) {
            Intrinsics.checkNotNullParameter(r100, "inflater");
            super.onCreateView(r100, r101, r102);
            LarusDoraGuideBindDeviceDialogBinding r103 = LarusDoraGuideBindDeviceDialogBinding.a(r100, r101);
            this.f335892f = r103;
            return r103.f332666a;
        }
    }

    public static final class a {
    }

    public /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f335896a = null;

        static {
            int[] r100 = new int[BindBottomSheetDialogFragment.Phase.values().length];
            r100[BindBottomSheetDialogFragment.Phase.BindGuide.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r100[BindBottomSheetDialogFragment.Phase.BindFail.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            f335896a = r100;
        }
    }

    static {
    }

    @Override // t39.l
    public final Unit a() {
        g49.d.d("DoraBindGuide", "startGuide() called");
        if (l() == true) goto L5;
        m(1);
        return Unit.INSTANCE;
    L5:
        return Unit.INSTANCE;
    }

    @Override // t39.l
    public final int f() {
        return DoraGuideMeta.DoraBindGuide.getGuideId();
    }

    public final BasicDoraDeviceCheckStrategy j() {
        return (BasicDoraDeviceCheckStrategy) this.f335879f.getValue();
    }

    public final boolean l() {
        IDoraGuideService r100 = (IDoraGuideService) ServiceManager.get().getService(IDoraGuideService.class);
        if (r100 == null) goto L5;
        boolean r101 = r100.b();
    L6:
        if (r101 == false) goto L8;
        g49.d.d("DoraBindGuide", "guide suppressed: dora guide is degraded");
    L8:
        return r101;
    L5:
        r101 = true;
        goto L6
    }

    public final String toString() {
        return "DoraBindGuide(state=" + this.f335885l + ')';
    }

    public static final void g(DoraBindGuide r100) {
        BindBottomSheetDialogFragment r101 = r100.f335884k;
        if (r101 != null) goto L6;
        g49.d.d("DoraBindGuide", "dismissDialogIfNeeded() no-op: dialog is null");
        return;
    L6:
        if (r101.isAdded() == false) goto L14;
        g49.d.d("DoraBindGuide", "Dismissing BindBottomSheetDialogFragment");
        r101.dismissAllowingStateLoss();     // Catch: Exception -> L10
    L10:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");
        Throwable r102 = DialogFragmentLancet.sLastShowStack;
        if (r102 == null) goto L14;
        com.bytedance.crash.d.d(r102, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
    L14:
        r100.f335884k = null;
        Job r103 = r100.f335888o;
        if (r103 == null) goto L17;
        Job.DefaultImpls.cancel$default(r103, null, 1, null);
    L17:
        r100.f335888o = null;
    }

    @Override // t39.l
    public final void b(GuideSession$setStateListener$1 r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        g49.d.d("DoraBindGuide", "setStateListener() called with " + r100);
        this.f335886m = r100;
    }

    @Override // t39.l
    public final Object c(Continuation<? super Boolean> r110) {
        if ((r110 instanceof DoraBindGuide$isGuideConditionMet$1) == false) goto L7;
        DoraBindGuide$isGuideConditionMet$1 r100 = (DoraBindGuide$isGuideConditionMet$1) r110;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        Object r102 = r100.result;
        Object r111 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r103 = r100.label;
        if (r103 == 0) goto L25;
        if (r103 == 1) goto L24;
        if (r103 == 2) goto L23;
        if (r103 == 3) goto L22;
        if (r103 == 4) goto L21;
        if (r103 != 5) goto L20;
        ResultKt.throwOnFailure(r102);     // Catch: Exception -> L17
        String r104 = "DoraBindGuide";
    L79:
        boolean r105 = ((Boolean) r102).booleanValue();     // Catch: Exception -> L81
    L83:
        if (r105 == true) goto L86;
        g49.d.d(r104, "Bind guide condition not met: no dora device found");
        return Boxing.boxBoolean(false);
    L86:
        g49.d.d(r104, "Bind guide condition met");
        return Boxing.boxBoolean(true);
    L81:
        Exception e100 = e;
    L82:
        g49.d.c(r104, "HasDoraDeviceStrategy check failed, error=" + e100.getMessage(), e100);
        r105 = false;
    L17:
        e100 = e;
        r104 = "DoraBindGuide";
        goto L82
    L20:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L21:
        ResultKt.throwOnFailure(r102);
        r104 = "DoraBindGuide";
    L73:
        if (((Boolean) r102).booleanValue() == true) goto L90;
        g49.d.d(r104, "Bind guide condition not met: channel and user strategy not met");
        return Boxing.boxBoolean(false);
    L90:
        BasicDoraDeviceCheckStrategy r106 = j();     // Catch: Exception -> L81
        r100.label = 5;     // Catch: Exception -> L81
        r102 = r106.b(r100);     // Catch: Exception -> L81
        if (r102 != r111) goto L79;
        return r111;
    L22:
        ResultKt.throwOnFailure(r102);
        r104 = "DoraBindGuide";
    L66:
        if (((Boolean) r102).booleanValue() == true) goto L69;
        g49.d.d(r104, "Bind guide condition not met: server strategy not met");
        return Boxing.boxBoolean(false);
    L69:
        r100.label = 4;
        r102 = k(r100);
        if (r102 != r111) goto L73;
        return r111;
    L23:
        ResultKt.throwOnFailure(r102);
        r104 = "DoraBindGuide";
        int r112 = 3;
    L48:
        if (((Boolean) r102).booleanValue() == true) goto L51;
        g49.d.d(r104, "Bind guide condition not met: bluetooth permission not granted");
        return Boxing.boxBoolean(false);
    L51:
        Object r107 = AppHost.f326268a.getApplication().getSystemService("audio");
        if ((r107 instanceof AudioManager) == false) goto L54;
        AudioManager r108 = (AudioManager) r107;
    L55:
        if (r108 != null) goto L59;
        g49.d.b(r104, "AudioManager is null, cannot determine A2DP state");
        return Boxing.boxBoolean(false);
    L59:
        if (r108.isBluetoothA2dpOn() == true) goto L62;
        g49.d.d(r104, "Bind guide condition not met: A2DP is off");
        return Boxing.boxBoolean(false);
    L62:
        com.larus.dora.impl.guide.strategy.f r109 = new com.larus.dora.impl.guide.strategy.f();
        r100.label = r112;
        r102 = r109.a();
        if (r102 != r111) goto L66;
        return r111;
    L54:
        r108 = null;
        goto L55
    L24:
        ResultKt.throwOnFailure(r102);
        Object r113 = r102;
        int r114 = 2;
        r112 = 3;
    L41:
        if (Intrinsics.areEqual((Boolean) r113, Boxing.boxBoolean(true)) == true) goto L44;
        g49.d.d("DoraBindGuide", "H device is not enabled");
        return Boxing.boxBoolean(false);
    L44:
        com.larus.dora.impl.guide.strategy.a r115 = (com.larus.dora.impl.guide.strategy.a) this.f335878e.getValue();
        r100.label = r114;
        r115.getClass();
        r102 = com.larus.dora.impl.guide.strategy.a.c();
        if (r102 != r111) goto L48;
        return r111;
    L25:
        ResultKt.throwOnFailure(r102);
        if (AccountService.f365697a.isLogin().booleanValue() == true) goto L30;
        g49.d.d("DoraBindGuide", "Bind guide condition not met: user not login");
        return Boxing.boxBoolean(false);
    L30:
        if (l() == false) goto L34;
        return Boxing.boxBoolean(false);
    L34:
        if (this.f335875b == true) goto L37;
        g49.d.d("DoraBindGuide", "Bind guide condition not met: main bot guide not enabled");
        return Boxing.boxBoolean(false);
    L37:
        DoraSetting r116 = DoraSetting.f338023a;
        Function0 r117 = new n();
        r100.label = 1;
        r114 = 2;
        r112 = 3;
        r113 = r116.b(5000, 100, "DoraBindGuide-updateConnectDeviceShouldShowState-isHDeviceEnabled", r117, r100);
        if (r113 != r111) goto L41;
        return r111;
    L7:
        r100 = new DoraBindGuide$isGuideConditionMet$1(this, r110);
        goto L8
    }

    public final void i(int r100) {
        if (this.f335885l == r100) goto L5;
    L9:
        m(r100);
    L10:
        g49.d.d("DoraBindGuide", "Notify ready to show next guide from state=" + r100);
        t39.m r101 = this.f335886m;
        if (r101 == null) goto L14;
        r101.a(this);
        return;
    L14:
        return;
    L5:
        if (r100 != 3) goto L7;
    L8:
        g49.d.d("DoraBindGuide", "completeWithState(" + r100 + ") ignored: already in final state");
        goto L10
    L7:
        if (r100 != 404) goto L9;
        goto L8
    }

    public final Object k(Continuation<? super Boolean> r100) {
        if ((r100 instanceof DoraBindGuide$isChannelOrUserStrategyHit$1) == false) goto L7;
        DoraBindGuide$isChannelOrUserStrategyHit$1 r101 = (DoraBindGuide$isChannelOrUserStrategyHit$1) r100;
        int r102 = r101.label;
        if ((r102 & Integer.MIN_VALUE) == 0) goto L7;
        r101.label = r102 - Integer.MIN_VALUE;
    L8:
        Object r103 = r101.result;
        Object r104 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r105 = r101.label;
        if (r105 == 0) goto L19;
        if (r105 == 1) goto L18;
        if (r105 == 2) goto L17;
        if (r105 != 3) goto L16;
        ResultKt.throwOnFailure(r103);     // Catch: Exception -> L38
    L36:
        boolean r106 = ((Boolean) r103).booleanValue();     // Catch: Exception -> L38
    L40:
        if (r106 == true) goto L43;
        g49.d.d("DoraBindGuide", "Bind guide condition not met: user is new or same-day first enter main bot page");
        return Boxing.boxBoolean(false);
    L43:
        g49.d.d("DoraBindGuide", "Bind guide channel or user strategy met");
        return Boxing.boxBoolean(true);
    L16:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L17:
        ResultKt.throwOnFailure(r103);
    L30:
        if (((Boolean) r103).booleanValue() == true) goto L33;
        g49.d.d("DoraBindGuide", "Bind guide condition not met: frequency interval not reached");
        return Boxing.boxBoolean(false);
    L33:
        com.larus.dora.impl.guide.strategy.d r107 = (com.larus.dora.impl.guide.strategy.d) this.f335880g.getValue();     // Catch: Exception -> L38
        r101.label = 3;     // Catch: Exception -> L38
        r107.getClass();     // Catch: Exception -> L38
        r103 = com.larus.dora.impl.guide.strategy.d.a();     // Catch: Exception -> L38
        if (r103 != r104) goto L36;
        return r104;
    L18:
        ResultKt.throwOnFailure(r103);
    L23:
        if (((Boolean) r103).booleanValue() == false) goto L26;
        g49.d.d("DoraBindGuide", "ChannelStrategy allows, short-circuit to true");
        return Boxing.boxBoolean(true);
    L26:
        g49.d.d("DoraBindGuide", "isGuideConditionMet(), checking user strategy");
        com.larus.dora.impl.guide.strategy.c r108 = (com.larus.dora.impl.guide.strategy.c) this.f335881h.getValue();
        r101.label = 2;
        r103 = r108.a();
        if (r103 != r104) goto L30;
        return r104;
    L19:
        ResultKt.throwOnFailure(r103);
        g49.d.d("DoraBindGuide", "isGuideConditionMet(), checking channel strategy");
        com.larus.dora.impl.guide.strategy.b r109 = (com.larus.dora.impl.guide.strategy.b) this.f335882i.getValue();
        r101.label = 1;
        r103 = r109.a();
        if (r103 != r104) goto L23;
        return r104;
    L38:
        e = move-exception;
        g49.d.c("DoraBindGuide", "NotNewUserStrategy check failed, error=" + e.getMessage(), e);
        r106 = false;
    L7:
        r101 = new DoraBindGuide$isChannelOrUserStrategyHit$1(this, r100);
        goto L8
    }

    public final void m(int r100) {
        int r101 = this.f335885l;
        if (r101 != r100) goto L5;
        return;
    L5:
        this.f335885l = r100;
        g49.d.d("DoraBindGuide", "Guide state changed: prev=" + r101 + ", new=" + r100);
        t39.m r102 = this.f335886m;
        if (r102 == null) goto L9;
        r102.b(this, r100, r101);
        return;
    }

    public static final void h(DoraBindGuide r100, BindBottomSheetDialogFragment.Phase r101) {
        DoraBuryPointManager r102 = DoraBuryPointManager.f331862a;
        boolean r103 = ((com.larus.dora.impl.guide.strategy.b) r100.f335882i.getValue()).f335989c;
        String r104 = r101.getValue();
        r102.getClass();
        Intrinsics.checkNotNullParameter(r104, "phase");
        g49.d.d(DoraBuryPointManager.f331863b, "reportBindGuideDismiss");
        r102.L("dora_bind_guide_dismiss_by_user", MapsKt.mapOf(new Pair[]{TuplesKt.to("hit_target_user_strategy", Boolean.valueOf(r103)), TuplesKt.to("bind_guide_phase", r104), TuplesKt.to("has_smart_audio", Boolean.valueOf(com.larus.dora.impl.util.h0.a()))}));
    }

    @Override // t39.l
    public final Object d(Fragment r100, View r101, Continuation<? super Unit> r102) {
        if ((r102 instanceof DoraBindGuide$dismissGuide$1) == false) goto L7;
        DoraBindGuide$dismissGuide$1 r103 = (DoraBindGuide$dismissGuide$1) r102;
        int r104 = r103.label;
        if ((r104 & Integer.MIN_VALUE) == 0) goto L7;
        r103.label = r104 - Integer.MIN_VALUE;
    L8:
        Object r105 = r103.result;
        Object r106 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r107 = r103.label;
        if (r107 == 0) goto L15;
        if (r107 != 1) goto L14;
        ResultKt.throwOnFailure(r105);     // Catch: Exception -> L19
    L23:
    L22:
        return Unit.INSTANCE;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        ResultKt.throwOnFailure(r105);
        g49.d.d("DoraBindGuide", "dismissGuide() called, fragment=" + r100 + ", anchorView=" + r101);
        MainCoroutineDispatcher r108 = Dispatchers.getMain();     // Catch: Exception -> L19
        DoraBindGuide$dismissGuide$2 r109 = new DoraBindGuide$dismissGuide$2(this, null);     // Catch: Exception -> L19
        r103.label = 1;     // Catch: Exception -> L19
        if (BuildersKt.withContext(r108, r109, r103) != r106) goto L23;
        return r106;
    L19:
        e = move-exception;
        g49.d.c("DoraBindGuide", "dismissGuide() failed with exception: " + e.getMessage(), e);
        i(404);
    L7:
        r103 = new DoraBindGuide$dismissGuide$1(this, r102);
        goto L8
    }

    @Override // t39.l
    public final Object e(Fragment r100, View r110, Continuation<? super Unit> r111) {
        if ((r111 instanceof DoraBindGuide$showGuide$1) == false) goto L7;
        DoraBindGuide$showGuide$1 r101 = (DoraBindGuide$showGuide$1) r111;
        int r102 = r101.label;
        if ((r102 & Integer.MIN_VALUE) == 0) goto L7;
        r101.label = r102 - Integer.MIN_VALUE;
    L8:
        Object r112 = r101.result;
        Object r103 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r104 = r101.label;
        if (r104 == 0) goto L19;
        if (r104 == 1) goto L16;
        if (r104 != 2) goto L15;
        ResultKt.throwOnFailure(r112);     // Catch: Exception -> L48
    L51:
        return Unit.INSTANCE;
    L15:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L16:
        r100 = (Fragment) r101.L$0;
        ResultKt.throwOnFailure(r112);     // Catch: Exception -> L48
    L45:
        MainCoroutineDispatcher r113 = Dispatchers.getMain();     // Catch: Exception -> L48
        DoraBindGuide$showGuide$2 r114 = new DoraBindGuide$showGuide$2(r100, this, null);     // Catch: Exception -> L48
        r101.L$0 = null;     // Catch: Exception -> L48
        r101.label = 2;     // Catch: Exception -> L48
        if (BuildersKt.withContext(r113, r114, r101) != r103) goto L51;
        return r103;
    L19:
        ResultKt.throwOnFailure(r112);
        g49.d.d("DoraBindGuide", "showGuide() called, fragment=" + r100 + ", anchorView=" + r110);
        if (l() == true) goto L22;
        if (r100 == null) goto L25;
        LifecycleCoroutineScope r115 = LifecycleOwnerKt.getLifecycleScope(r100);
    L26:
        this.f335887n = r115;
        if (r100 != null) goto L29;
    L52:
        g49.d.c("DoraBindGuide", "showGuide() skipped: fragment is null or detached", new IllegalArgumentException("fragment is null or detached"));
        i(404);
        return Unit.INSTANCE;
    L29:
        if (r100.isDetached() == true) goto L52;
        if (this.f335885l != 2) goto L42;
        BindBottomSheetDialogFragment r116 = this.f335884k;
        if (r116 != null) goto L36;
    L38:
        boolean r117 = false;
    L39:
        if (r117 == false) goto L42;
        g49.d.d("DoraBindGuide", "showGuide() ignored: guide already showing");
        return Unit.INSTANCE;
    L36:
        if (r116.isAdded() != true) goto L38;
        r117 = true;
    L42:
        ((com.larus.dora.impl.guide.strategy.c) this.f335881h.getValue()).b();     // Catch: Exception -> L48
        com.larus.dora.impl.guide.strategy.b r118 = (com.larus.dora.impl.guide.strategy.b) this.f335882i.getValue();     // Catch: Exception -> L48
        r101.L$0 = r100;     // Catch: Exception -> L48
        r101.label = 1;     // Catch: Exception -> L48
        if (r118.b() != r103) goto L45;
        return r103;
    L25:
        r115 = null;
        goto L26
    L22:
        return Unit.INSTANCE;
    L48:
        e = move-exception;
        g49.d.c("DoraBindGuide", "showGuide() failed with exception: " + e.getMessage(), e);
        i(404);
    L7:
        r101 = new DoraBindGuide$showGuide$1(this, r111);
        goto L8
    }

    public DoraBindGuide(String r100, boolean r101, long r102, List<String> r103) {
        Intrinsics.checkNotNullParameter(r100, "page");
        Intrinsics.checkNotNullParameter(r103, "targetChannels");
        this.f335874a = r100;
        this.f335875b = r101;
        this.f335876c = r102;
        this.f335877d = r103;
        this.f335878e = LazyKt.lazy(new i());
        this.f335879f = LazyKt.lazy(new j());
        this.f335880g = LazyKt.lazy(new k());
        this.f335881h = LazyKt.lazy(new l(this));
        this.f335882i = LazyKt.lazy(new m(this));
    }
}
