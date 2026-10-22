package com.bytedance.android.shopping.prepurchase.business.pdp;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.Window;
import androidx.appcompat.app.AppCompatDialog;
import androidx.appcompat.app.AppCompatDialogFragment;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.bytedance.android.ec.core.utils.k1;
import com.bytedance.android.shopping.anchorv3.compat.CompatFrameLayout;
import com.bytedance.android.shopping.anchorv3.utils.b0;
import com.bytedance.android.shopping.anchorv4.helper.t;
import com.bytedance.android.shopping.anchorv4.helper.u;
import com.bytedance.android.shopping.anchorv4.params.AnchorV4Param;
import com.bytedance.android.shopping.orderlist.common.freq.FreqActions;
import com.bytedance.android.shopping.prepurchase.arch.container.component.ServiceRegistryImpl;
import com.bytedance.android.shopping.prepurchase.arch.container.lifecycle.Lifecycle;
import com.bytedance.android.shopping.prepurchase.arch.container.model.Biz;
import com.bytedance.android.shopping.prepurchase.business.pdp.repository.PdpDataStore;
import com.bytedance.android.shopping.track.TrackCatcher;
import com.bytedance.android.shopping.utils.y;
import com.gyf.barlibrary.ImmersionBar;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.helpers.PopupOrDialogVisibilityTracker;
import com.obric.assistant.interaction.impl.window.landscape.childwindow.LandscapeChildDialogBoundsAdapter;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.io.Serializable;
import java.util.LinkedHashMap;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import n83.m;
import vg3.i0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0016\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003:\u0001\u0006B\u0007¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0007"}, d2 = {"Lcom/bytedance/android/shopping/prepurchase/business/pdp/ProductDetailHalfFragmentV2;", "Landroidx/appcompat/app/AppCompatDialogFragment;", "Lcom/bytedance/android/shopping/anchorv4/containers/h;", "Lp83/g;", "<init>", "()V", "a", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public class ProductDetailHalfFragmentV2 extends AppCompatDialogFragment implements com.bytedance.android.shopping.anchorv4.containers.h, p83.g {
    public static final /* synthetic */ int m = 0;
    public m d;
    public Function0<Unit> e;
    public com.bytedance.android.shopping.prepurchase.arch.container.a<e, PdpDataStore> f;
    public ImmersionBar g;
    public boolean h;
    public i i;
    public PdpRecoveryCompat j;
    public com.bytedance.android.shopping.prepurchase.arch.container.intf.a k;
    public final b l;

    public final class a extends AppCompatDialog {
        public final /* synthetic */ ProductDetailHalfFragmentV2 a;

        public final void onCreate(Bundle r5) {
            DialogFragment r0 = this.a;
            int r1 = ProductDetailHalfFragmentV2.m;
            Window r2 = null;
            if (r0.getShowsDialog() == false) goto L19;
            Dialog r3 = r0.getDialog();
            if (r3 == null) goto L9;
            Window r4 = r3.getWindow();
            if (r4 == null) goto L9;
            r4.setBackgroundDrawableResource(2131101135);
        L9:
            Dialog r6 = r0.getDialog();
            if (r6 == null) goto L12;
            r6.setOnDismissListener(r0);
        L12:
            Dialog r7 = r0.getDialog();
            if (r7 == null) goto L15;
            r7.setOnKeyListener(new h(r0));
        L15:
            int r8 = b0.a;
            Dialog r9 = r0.getDialog();
            if (r9 == null) goto L18;
            r2 = r9.getWindow();
        L18:
            b0.a(r2);
        L23:
            r0.U90(true);
            super.onCreate(r5);
            return;
        L19:
            FragmentActivity r10 = r0.getActivity();
            if (r10 == null) goto L22;
            r2 = ImmersionBar.with(r10);
        L22:
            r0.g = r2;
            goto L23
        }

        public a(ProductDetailHalfFragmentV2 r2, FragmentActivity r3, int r4) {
            Intrinsics.checkNotNullParameter(r3, "context");
            this.a = r2;
            super(r3, r4);
        }
    }

    public static final class b implements com.bytedance.android.shopping.prepurchase.arch.container.intf.f {
        public FragmentActivity a;
        public final /* synthetic */ ProductDetailHalfFragmentV2 b;

        @Override // com.bytedance.android.shopping.prepurchase.arch.container.intf.f
        public final void H() {
            Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L11
            this.b.dismissAllowingStateLoss();     // Catch: Exception -> L5 Throwable -> L11
        L9:
            Object r1 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L11
        L13:
            Throwable r2 = Result.exceptionOrNull-impl(r1);
            if (r2 == null) goto L27;
            com.bytedance.android.shopping.prepurchase.arch.container.a<e, PdpDataStore> r3 = this.b.f;
            if (r3 == null) goto L28;
            com.bytedance.android.shopping.prepurchase.arch.container.f<STATE, PdpDataStore> r4 = r3.d;
            if (r4 == 0) goto L29;
            com.bytedance.android.shopping.prepurchase.arch.container.intf.i r5 = r4.d;
            if (r5 == null) goto L30;
            r5.ensureNotReachHere(r2);
            return;
        L30:
            return;
        L29:
            return;
        L28:
            return;
        L27:
            return;
        L5:
            e = move-exception;
            com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");     // Catch: Throwable -> L11
            Throwable r6 = DialogFragmentLancet.sLastShowStack;     // Catch: Throwable -> L11
            if (r6 == null) goto L9;
            com.bytedance.crash.d.d(r6, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");     // Catch: Throwable -> L11
        L11:
            th = move-exception;
            Result.Companion r7 = Result.Companion;
            r1 = Result.constructor-impl(ResultKt.createFailure(th));
            goto L13
        }

        @Override // com.bytedance.android.shopping.prepurchase.arch.container.intf.f
        public final Window f7() {
            Dialog r0 = this.b.getDialog();
            if (r0 != null) goto L7;
            return null;
        L7:
            return r0.getWindow();
        }

        @Override // com.bytedance.android.shopping.prepurchase.arch.container.intf.f
        public final FragmentManager g7() {
            return this.b.getChildFragmentManager();
        }

        @Override // com.bytedance.android.shopping.prepurchase.arch.container.intf.f
        public final ViewGroup getContainerView() {
            View r0 = this.b.getView();
            if (r0 == null) goto L7;
            return (ViewGroup) r0;
        L7:
            throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup");
        }

        @Override // com.bytedance.android.shopping.prepurchase.arch.container.intf.f
        /* JADX INFO: renamed from: getContext */
        public FragmentActivity mo2525getContext() {
            if (this.a != null) goto L9;
            Context r0 = this.b.getContext();
            if ((r0 instanceof FragmentActivity) == true) goto L7;
            r0 = null;
        L7:
            this.a = (FragmentActivity) r0;
        L9:
            return this.a;
        }

        @Override // com.bytedance.android.shopping.prepurchase.arch.container.intf.f
        public final com.bytedance.android.shopping.prepurchase.arch.container.intf.a i7() {
            ProductDetailHalfFragmentV2 r0 = this.b;
            if (r0.k != null) goto L16;
            com.bytedance.android.shopping.prepurchase.arch.container.a<e, PdpDataStore> r1 = r0.f;
            if (r1 == null) goto L14;
            com.bytedance.android.shopping.prepurchase.arch.container.d<STATE, PdpDataStore> r2 = r1.c;
            if (r2 != 0) goto L9;
            Intrinsics.throwUninitializedPropertyAccessException("context");
        L9:
            og3.b<STATE> r3 = r2.d;
            if (r3 == 0) goto L14;
            e r4 = (e) r3.b;
            if (r4 == null) goto L14;
            boolean r5 = r4.b.a;
        L15:
            int r6 = y.a;
            int r7 = y.e(null, Boolean.valueOf(r5), 1);
            int r8 = k1.j(this.b.getContext());
            int r9 = j56.a.b(this.b.getContext());
            int r10 = k1.g();
            ProductDetailHalfFragmentV2 r11 = this.b;
            r11.k = new com.bytedance.android.shopping.prepurchase.arch.container.intf.a(r7, r8, r9, r10);
        L14:
            r5 = false;
        L16:
            com.bytedance.android.shopping.prepurchase.arch.container.intf.a r12 = this.b.k;
            Intrinsics.checkNotNull(r12);
            return r12;
        }

        @Override // com.bytedance.android.shopping.prepurchase.arch.container.intf.f
        public final Object k7() {
            return this.b;
        }

        public b(ProductDetailHalfFragmentV2 r1) {
            this.b = r1;
        }

        @Override // com.bytedance.android.shopping.prepurchase.arch.container.intf.f
        public final void e(boolean r2) {
            this.b.U90(r2);
        }
    }

    public final void J1() {
        com.bytedance.android.shopping.prepurchase.arch.container.a<e, PdpDataStore> r0 = this.f;
        if (r0 == null) goto L12;
        ServiceRegistryImpl r1 = r0.b;
        if (r1 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("abilityRegistry");
    L7:
        if (r1 == null) goto L13;
        vg3.g r2 = (vg3.g) r1.getService(vg3.g.class);
        if (r2 == null) goto L14;
        r2.W0();
        return;
    L14:
        return;
    L13:
        return;
    }

    public final View N() {
        com.bytedance.android.shopping.prepurchase.arch.container.a<e, PdpDataStore> r0 = this.f;
        if (r0 == null) goto L11;
        ServiceRegistryImpl r1 = r0.b;
        if (r1 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("abilityRegistry");
    L7:
        if (r1 == null) goto L11;
        i0 r2 = (i0) r1.getService(i0.class);
        if (r2 == null) goto L11;
        return r2.N();
    L11:
        return null;
    }

    public final String getSessionId() {
        PdpRecoveryCompat r0 = this.j;
        if (r0 == null) goto L7;
        AnchorV4Param r1 = r0.a;
        if (r1 == null) goto L7;
        return r1.getSessionId();
    L7:
        return null;
    }

    public ProductDetailHalfFragmentV2() {
        this.l = new b(this);
    }

    public final void onDestroy() {
        super/*androidx.fragment.app.Fragment*/.onDestroy();
        ImmersionBar r0 = this.g;
        if (r0 == null) goto L6;
        r0.destroy();
    L6:
        if (this.h == false) goto L8;
        return;
    L8:
        com.bytedance.android.shopping.prepurchase.arch.container.a<e, PdpDataStore> r1 = this.f;
        if (r1 == null) goto L15;
        com.bytedance.android.shopping.prepurchase.arch.container.lifecycle.a r2 = r1.a;
        if (r2 != null) goto L13;
        Intrinsics.throwUninitializedPropertyAccessException("containerDelegate");
    L13:
        r2.c(Lifecycle.Event.ON_DESTROY);
        return;
    }

    public final void onPause() {
        super/*androidx.fragment.app.Fragment*/.onPause();
        com.bytedance.android.shopping.prepurchase.arch.container.a<e, PdpDataStore> r0 = this.f;
        if (r0 == null) goto L9;
        com.bytedance.android.shopping.prepurchase.arch.container.lifecycle.a r1 = r0.a;
        if (r1 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("containerDelegate");
    L7:
        r1.c(Lifecycle.Event.ON_PAUSE);
        return;
    }

    public final void onResume() {
        super/*androidx.fragment.app.Fragment*/.onResume();
        com.bytedance.android.shopping.prepurchase.arch.container.a<e, PdpDataStore> r0 = this.f;
        if (r0 == null) goto L9;
        com.bytedance.android.shopping.prepurchase.arch.container.lifecycle.a r1 = r0.a;
        if (r1 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("containerDelegate");
    L7:
        r1.c(Lifecycle.Event.ON_RESUME);
        return;
    }

    public final void onStart() {
        PopupOrDialogVisibilityTracker.bindDialogFragment(this);
        LandscapeRestrictionGuard.bindDialogForAllowedDialogFragment(this);
        super/*androidx.fragment.app.DialogFragment*/.onStart();
        com.bytedance.android.shopping.prepurchase.arch.container.a<e, PdpDataStore> r0 = this.f;
        if (r0 == null) goto L9;
        com.bytedance.android.shopping.prepurchase.arch.container.lifecycle.a r1 = r0.a;
        if (r1 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("containerDelegate");
    L7:
        r1.c(Lifecycle.Event.ON_START);
        return;
    }

    public final void onStop() {
        super/*androidx.fragment.app.DialogFragment*/.onStop();
        com.bytedance.android.shopping.prepurchase.arch.container.a<e, PdpDataStore> r0 = this.f;
        if (r0 == null) goto L9;
        com.bytedance.android.shopping.prepurchase.arch.container.lifecycle.a r1 = r0.a;
        if (r1 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("containerDelegate");
    L7:
        r1.c(Lifecycle.Event.ON_STOP);
        return;
    }

    public static View S90(Window r3) {
        View r4 = r3.getDecorView();
        if (com.larus.home.impl.utils.c.e == false) goto L7;
        FLogger.a.i("DecorViewLancet", "getDecorView");
        Thread r0 = ThreadMethodProxy.currentThread();
        if (r0 == com.larus.home.impl.utils.c.a) goto L7;
        com.larus.home.impl.utils.c.a(r0, "getDecorView");
    L7:
        return r4;
    }

    public static void T90(ProductDetailHalfFragmentV2 r1) {
        r1.dismissAllowingStateLoss();     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");
        Throwable r2 = DialogFragmentLancet.sLastShowStack;
        if (r2 == null) goto L11;
        com.bytedance.crash.d.d(r2, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        return;
    }

    public final void U90(boolean r2) {
        if (getShowsDialog() == false) goto L9;
        Dialog r0 = getDialog();
        if (r0 == null) goto L17;
        Window r1 = r0.getWindow();
        if (r1 == null) goto L18;
        com.bytedance.android.shopping.extensions.m.a(r1, r2);
        return;
    L18:
        return;
    L17:
        return;
    L9:
        ImmersionBar r3 = this.g;
        if (r3 == null) goto L20;
        ImmersionBar r4 = r3.reset();
        if (r4 == null) goto L21;
        ImmersionBar r5 = r4.statusBarDarkFont(r2);
        if (r5 == null) goto L22;
        r5.init();
        return;
    L22:
        return;
    L21:
        return;
    }

    public final void onConfigurationChanged(Configuration r2) {
        Intrinsics.checkNotNullParameter(r2, "newConfig");
        super/*androidx.fragment.app.Fragment*/.onConfigurationChanged(r2);
        this.k = null;
        com.bytedance.android.shopping.prepurchase.arch.container.a<e, PdpDataStore> r0 = this.f;
        if (r0 == null) goto L6;
        r0.b(r2);
        return;
    }

    public final void onCreate(Bundle r4) {
        super/*androidx.fragment.app.DialogFragment*/.onCreate(r4);
        Lazy r0 = TrackCatcher.a;
        if (TrackCatcher.a.a() == null) goto L5;
        TrackCatcher.a("product_detail");
    L5:
        Bundle r1 = getArguments();
        Serializable r2 = null;
        if (r1 == null) goto L8;
        Serializable r3 = r1.getSerializable("param_key");
    L10:
        if ((r3 instanceof AnchorV4Param) == false) goto L13;
        r2 = r3;
    L13:
        AnchorV4Param r5 = (AnchorV4Param) r2;
        if (r5 != null) goto L17;
        this.h = true;
        T90(this);
        return;
    L17:
        PdpRecoveryCompat r6 = new PdpRecoveryCompat(r5);
        if (r4 != null) goto L20;
    L23:
        Unit r7 = Unit.INSTANCE;
        this.j = r6;
        setStyle(0, 2131954509);
        return;
    L20:
        if (r6.a(r4) == true) goto L23;
        this.h = true;
        T90(this);
        return;
    L8:
        r3 = null;
        goto L10
    }

    public final Dialog onCreateDialog(Bundle r3) {
        return new a(this, requireActivity(), getTheme());
    }

    public final void onDismiss(DialogInterface r2) {
        Intrinsics.checkNotNullParameter(r2, "dialog");     // Catch: Throwable -> L18
        super/*androidx.fragment.app.DialogFragment*/.onDismiss(r2);     // Catch: Throwable -> L18
        i r3 = this.i;     // Catch: Throwable -> L18
        if (r3 == null) goto L13;
        Dialog r0 = getDialog();     // Catch: Throwable -> L18
        if (r0 == null) goto L13;
        Window r1 = r0.getWindow();     // Catch: Throwable -> L18
        if (r1 == null) goto L13;
        View r4 = S90(r1);     // Catch: Throwable -> L18
        if (r4 == null) goto L13;
        ViewTreeObserver r5 = r4.getViewTreeObserver();     // Catch: Throwable -> L18
        if (r5 == null) goto L13;
        r5.removeOnPreDrawListener(r3);     // Catch: Throwable -> L18
    L13:
        this.i = null;     // Catch: Throwable -> L18
        Function0<Unit> r6 = this.e;     // Catch: Throwable -> L18
        if (r6 == null) goto L16;
        Unit r7 = (Unit) r6.invoke();     // Catch: Throwable -> L18
    L16:
        LandscapeChildDialogBoundsAdapter.onDialogDismissed(getDialog());
        PopupOrDialogVisibilityTracker.onDialogFragmentDismissed(this);
        LandscapeRestrictionGuard.clearAllowedDialogFragment(this);
        return;
    L18:
        th = move-exception;
        LandscapeChildDialogBoundsAdapter.onDialogDismissed(getDialog());
        PopupOrDialogVisibilityTracker.onDialogFragmentDismissed(this);
        LandscapeRestrictionGuard.clearAllowedDialogFragment(this);
        throw th;
    }

    public final void onSaveInstanceState(Bundle r2) {
        Intrinsics.checkNotNullParameter(r2, "outState");
        super/*androidx.fragment.app.DialogFragment*/.onSaveInstanceState(r2);
        PdpRecoveryCompat r0 = this.j;
        if (r0 == null) goto L6;
        r0.b(r2);
        return;
    }

    public final void onViewCreated(View r10, Bundle r11) {
        Intrinsics.checkNotNullParameter(r10, FreqActions.ACTION_VIEW);
        super/*androidx.fragment.app.Fragment*/.onViewCreated(r10, r11);
        Bundle r12 = getArguments();
        if (r12 != null) goto L5;
        r12 = r11;
    L5:
        boolean r0 = false;
        if (r12 != null) goto L8;
    L10:
        boolean r4 = false;
    L11:
        PdpRecoveryCompat r13 = this.j;
        if (r13 != null) goto L14;
        this.h = true;
        T90(this);
        return;
    L14:
        AnchorV4Param r3 = r13.a;
        og3.c r14 = new og3.c(Biz.PDP, r3.getSessionId(), new og3.a(r3.getNativeParams().getSourceBtmToken()));
        LinkedHashMap r2 = t.a;
        String r5 = r3.getSessionId();
        Intrinsics.checkNotNullParameter(r5, "sessionId");
        u r6 = (u) t.a.remove(r5);
        com.bytedance.android.shopping.prepurchase.arch.container.b r8 = new com.bytedance.android.shopping.prepurchase.arch.container.b(r14);
        m r7 = this.d;
        if (r11 == null) goto L17;
        boolean r9 = true;
    L18:
        g r15 = new g(r3, r4, r6, r7, r9);
        Intrinsics.checkNotNullParameter(r15, "factory");
        r8.d = r15;
        b r16 = this.l;
        Intrinsics.checkNotNullParameter(r16, "delegate");
        r8.e = r16;
        if (r11 == null) goto L21;
        r0 = true;
    L21:
        d r17 = new d(r0);
        Intrinsics.checkNotNullParameter(r17, "service");
        r8.a = r17;
        com.bytedance.android.shopping.prepurchase.arch.container.a<e, PdpDataStore> r18 = new com.bytedance.android.shopping.prepurchase.arch.container.a(r8.a());
        this.f = r18;
        r18.c();
        return;
    L17:
        r9 = false;
        goto L18
    L8:
        if (r12.getBoolean("is_split_screen", false) != true) goto L10;
        r4 = true;
        goto L11
    }

    public final View onCreateView(LayoutInflater r3, ViewGroup r4, Bundle r5) {
        Intrinsics.checkNotNullParameter(r3, "inflater");
        CompatFrameLayout r6 = new CompatFrameLayout(r3.getContext(), null, 6, 0);
        r6.setId(2131384842);
        Dialog r7 = getDialog();
        if (r7 == null) goto L7;
        Window r8 = r7.getWindow();
        if (r8 == null) goto L7;
        Ref.ObjectRef r9 = new Ref.ObjectRef();
        r9.element = null;
        this.i = new i(r8, r9);
        S90(r8).getViewTreeObserver().addOnPreDrawListener(this.i);
    L7:
        return r6;
    }
}
