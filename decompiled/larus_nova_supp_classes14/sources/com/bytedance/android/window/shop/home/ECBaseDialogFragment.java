package com.bytedance.android.window.shop.home;

import android.app.Dialog;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.FrameLayout;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import com.bytedance.android.ec.adapter.api.IAdapterService;
import com.bytedance.android.ec.core.utils.s0;
import com.bytedance.android.ec.sdk.ECSdk;
import com.bytedance.android.ec.window.base.shop.ECStoreBottomDialog;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.helpers.PopupOrDialogVisibilityTracker;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.ss.android.ugc.aweme.kiwi.ui.QUIManager;
import com.ss.android.ugc.aweme.kiwi.ui.QUIModule;
import com.ss.android.ugc.aweme.kiwi.viewmodel.QViewModelOwner;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\b&\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\u00020\u00032\u00020\u0004J\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0007¨\u0006\t"}, d2 = {"Lcom/bytedance/android/window/shop/home/ECBaseDialogFragment;", "Landroidx/lifecycle/ViewModel;", "VM", "Landroidx/fragment/app/DialogFragment;", "Lcom/ss/android/ugc/aweme/kiwi/viewmodel/QViewModelOwner;", "Lr83/c;", "event", "", "onCloseProductFeedPageEvent", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public abstract class ECBaseDialogFragment<VM extends ViewModel> extends DialogFragment implements QViewModelOwner {
    public final com.bytedance.android.ec.core.arch.viewmodel.c d;
    public boolean e;
    public final QUIManager f;
    public Uri g;
    public final Lazy h;
    public boolean i;
    public QUIModule j;

    public abstract QUIModule S90(LayoutInflater r1, ViewGroup r2);

    public final VM T90() {
        return (VM) this.d.getValue();
    }

    public final ViewModelProvider.Factory o6() {
        return new ViewModelProvider.NewInstanceFactory();
    }

    public final void dismiss() {
        dismissAllowingStateLoss();     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");
        Throwable r0 = DialogFragmentLancet.sLastShowStack;
        if (r0 == null) goto L11;
        com.bytedance.crash.d.d(r0, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        return;
    }

    public void dismissAllowingStateLoss() {
        super.dismissAllowingStateLoss();     // Catch: Exception -> L4
    L8:
        this.e = false;
        return;
    L4:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");
        Throwable r0 = DialogFragmentLancet.sLastShowStack;
        if (r0 == null) goto L8;
        com.bytedance.crash.d.d(r0, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        goto L8
    }

    public void onDestroy() {
        super/*androidx.fragment.app.Fragment*/.onDestroy();
        s0.e(this);
        Intrinsics.checkNotNullParameter(this, "$this$hookOnDestroy");
        Intrinsics.checkNotNullParameter(this, "fragment");
        int r0 = ECSdk.a;
        IAdapterService r1 = (IAdapterService) ECSdk.a(IAdapterService.class);
        if (r1 == null) goto L8;
        com.bytedance.android.ec.adapter.api.e r2 = r1.getFragmentDispatcher();
        if (r2 == null) goto L9;
        r2.onDestroy(this);
        return;
    L9:
        return;
    }

    public final void onDestroyView() {
        super.onDestroyView();
        QUIModule r0 = this.j;
        if (r0 == null) goto L6;
        this.f.r(r0.getClass());
        return;
    }

    public final void onDetach() {
        super.onDetach();
        ConcurrentHashMap r0 = xn.a.a;
        FragmentActivity r1 = getActivity();
        if (r1 == null) goto L6;
        xn.a.a.remove(Integer.valueOf(r1.hashCode()));
    L6:
        FragmentActivity r2 = getActivity();
        if (r2 == null) goto L11;
        xn.a.b.remove(Integer.valueOf(r2.hashCode()));
        return;
    }

    public final void onPause() {
        super/*androidx.fragment.app.Fragment*/.onPause();
        View r0 = this.f.p();
        if (r0 == null) goto L11;
        FrameLayout r1 = (FrameLayout) r0;
        Intrinsics.checkNotNullParameter(this, "$this$hookOnPause");
        Intrinsics.checkNotNullParameter(this, "fragment");
        Intrinsics.checkNotNullParameter(r1, "rootView");
        int r2 = ECSdk.a;
        IAdapterService r3 = (IAdapterService) ECSdk.a(IAdapterService.class);
        if (r3 == null) goto L12;
        com.bytedance.android.ec.adapter.api.e r4 = r3.getFragmentDispatcher();
        if (r4 == null) goto L13;
        r4.onPause(this, r1);
        return;
    L13:
        return;
    L12:
        return;
    L11:
        throw new NullPointerException("null cannot be cast to non-null type android.widget.FrameLayout");
    }

    public final void onStart() {
        PopupOrDialogVisibilityTracker.bindDialogFragment(this);
        LandscapeRestrictionGuard.bindDialogForAllowedDialogFragment(this);
        Dialog r0 = getDialog();
        if (r0 == null) goto L11;
        Window r1 = r0.getWindow();
        if (r1 == null) goto L11;
        if (this.e == false) goto L9;
        int r2 = 2131954225;
    L10:
        r1.setWindowAnimations(r2);
        goto L11
    L9:
        r2 = 2131954223;
    L11:
        super.onStart();
        if (this.e == true) goto L15;
        this.e = true;
        return;
    }

    public final void onStop() {
        super.onStop();
        View r0 = this.f.p();
        if (r0 == null) goto L11;
        FrameLayout r1 = (FrameLayout) r0;
        Intrinsics.checkNotNullParameter(this, "$this$hookOnStop");
        Intrinsics.checkNotNullParameter(this, "fragment");
        Intrinsics.checkNotNullParameter(r1, "rootView");
        int r2 = ECSdk.a;
        IAdapterService r3 = (IAdapterService) ECSdk.a(IAdapterService.class);
        if (r3 == null) goto L12;
        com.bytedance.android.ec.adapter.api.e r4 = r3.getFragmentDispatcher();
        if (r4 == null) goto L13;
        r4.onStop(this, r1);
        return;
    L13:
        return;
    L12:
        return;
    L11:
        throw new NullPointerException("null cannot be cast to non-null type android.widget.FrameLayout");
    }

    public ECBaseDialogFragment(KClass<VM> r3) {
        Intrinsics.checkNotNullParameter(r3, "clazz");
        this.d = com.bytedance.android.ec.core.arch.viewmodel.b.a(this, r3, new ECBaseDialogFragment$viewModel$2(this), new ECBaseDialogFragment$viewModel$3(this));
        this.f = new QUIManager();
        this.h = LazyKt.lazy(new ECBaseDialogFragment$bindModuleForOnlyOnce$2(this));
    }

    public final void onAttach(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        super.onAttach(r4);
        ConcurrentHashMap r5 = xn.a.a;
        FragmentActivity r6 = getActivity();
        Bundle r0 = getArguments();
        String r1 = null;
        if (r0 == null) goto L5;
        String r2 = r0.getString("entrance_info");
    L6:
        JSONObject r3 = com.bytedance.android.shopping.extensions.k.w(r2);
        if (r3 == null) goto L12;
        if (r6 == null) goto L12;
        xn.a.a.put(Integer.valueOf(r6.hashCode()), r3);
    L12:
        FragmentActivity r7 = getActivity();
        Bundle r8 = getArguments();
        if (r8 == null) goto L15;
        r1 = r8.getString("ec_shop_inner_info");
    L15:
        JSONObject r9 = com.bytedance.android.shopping.extensions.k.w(r1);
        if (r9 == null) goto L22;
        if (r7 == null) goto L23;
        xn.a.b.put(Integer.valueOf(r7.hashCode()), r9);
        return;
    L23:
        return;
    L22:
        return;
    L5:
        r2 = null;
        goto L6
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public final void onCloseProductFeedPageEvent(r83.c r2) {
        Intrinsics.checkNotNullParameter(r2, "event");
        dismiss();     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_EXCEPTION");
        Throwable r3 = DialogFragmentLancet.sLastShowStack;
        if (r3 == null) goto L12;
        com.bytedance.crash.d.d(r3, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        return;
    }

    public void onCreate(Bundle r1) {
        super.onCreate(r1);
        s0.c(this);
    }

    public final Dialog onCreateDialog(Bundle r2) {
        return new ECStoreBottomDialog(requireContext());
    }

    public final void onViewCreated(View r2, Bundle r3) {
        Intrinsics.checkNotNullParameter(r2, "view");
        super/*androidx.fragment.app.Fragment*/.onViewCreated(r2, r3);
        Unit r4 = (Unit) this.h.getValue();
    }

    public final View onCreateView(LayoutInflater r1, ViewGroup r2, Bundle r3) {
        Intrinsics.checkNotNullParameter(r1, "inflater");
        if (this.i == true) goto L6;
        QUIManager r4 = this.f;
        QUIModule r5 = S90(r1, r2);
        this.j = r5;
        com.bytedance.android.ec.window.base.utils.quick.d.a(r4, r5, requireContext(), this);
        this.i = true;
    L6:
        return this.f.p();
    }
}
