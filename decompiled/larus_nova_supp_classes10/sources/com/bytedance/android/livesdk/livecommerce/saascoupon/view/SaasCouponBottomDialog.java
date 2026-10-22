package com.bytedance.android.livesdk.livecommerce.saascoupon.view;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.lifecycle.ViewModelProvider;
import bl2.e;
import bl2.g;
import com.bytedance.android.ec.sdk.helper.r;
import com.bytedance.android.livesdk.livecommerce.saascoupon.SaasCouponService;
import com.bytedance.android.livesdk.livecommerce.saascoupon.viewmodel.SaasCouponViewModel;
import com.bytedance.crash.d;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.helpers.PopupOrDialogVisibilityTracker;
import com.obric.assistant.interaction.impl.window.landscape.childwindow.LandscapeChildDialogBoundsAdapter;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.ss.android.ugc.aweme.kiwi.ui.QUIManager;
import com.ss.android.ugc.aweme.kiwi.viewmodel.QViewModelOwner;
import el2.k;
import el2.n;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002:\u0001\u0005B\u0007¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/livesdk/livecommerce/saascoupon/view/SaasCouponBottomDialog;", "Lcom/google/android/material/bottomsheet/BottomSheetDialogFragment;", "Lcom/ss/android/ugc/aweme/kiwi/viewmodel/QViewModelOwner;", "<init>", "()V", "a", "livecommerce_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class SaasCouponBottomDialog extends BottomSheetDialogFragment implements QViewModelOwner {
    public static final /* synthetic */ int l = 0;
    public final QUIManager d;
    public BottomSheetDialog e;
    public boolean f;
    public boolean g;
    public final SaasCouponViewModel h;
    public final n i;
    public final Lazy j;
    public final SaasCouponBottomDialog$factory$1 k;

    public static final class a {
    }

    public static final class b implements DialogInterface.OnKeyListener {
        public final /* synthetic */ SaasCouponBottomDialog a;

        public b(SaasCouponBottomDialog r1) {
            this.a = r1;
        }

        @Override // android.content.DialogInterface.OnKeyListener
        public final boolean onKey(DialogInterface r6, int r7, KeyEvent r8) {
            if (r7 != 4) goto L12;
            SaasCouponBottomDialog r9 = this.a;
            SaasCouponViewModel r0 = r9.h;
            if (r0 == null) goto L7;
            com.bytedance.android.ec.core.arch.event.c.d(r0, new com.bytedance.android.livesdk.livecommerce.saascoupon.viewmodel.a.g("livesdk_coupon_window_click", "back", null, 4));
        L7:
            SaasCouponViewModel r10 = r9.h;
            if (r10 == null) goto L10;
            com.bytedance.android.ec.core.arch.event.c.d(r10, com.bytedance.android.livesdk.livecommerce.saascoupon.viewmodel.a.e.a);
        L10:
            r9.f = false;
            r9.g = false;
            SaasCouponBottomDialog.S90(r9);
            return true;
        L12:
            return false;
        }
    }

    public static final class c implements DialogInterface.OnShowListener {
        public final /* synthetic */ SaasCouponBottomDialog a;

        public c(SaasCouponBottomDialog r1) {
            this.a = r1;
        }

        @Override // android.content.DialogInterface.OnShowListener
        public final void onShow(DialogInterface r3) {
            View r4 = this.a.getView();
            ViewParent r0 = null;
            if (r4 == null) goto L5;
            ViewParent r5 = r4.getParent();
        L7:
            if ((r5 instanceof ViewGroup) == false) goto L10;
            r0 = r5;
        L10:
            ViewGroup r1 = (ViewGroup) r0;
            if (r1 == null) goto L14;
            r1.setBackgroundColor(0);
            return;
        L14:
            return;
        L5:
            r5 = null;
            goto L7
        }
    }

    static {
    }

    /* JADX WARN: Type inference failed for: r0v4, types: [com.bytedance.android.livesdk.livecommerce.saascoupon.view.SaasCouponBottomDialog$factory$1] */
    public SaasCouponBottomDialog() {
        this.d = new QUIManager();
        this.g = true;
        this.j = LazyKt.lazy(SaasCouponBottomDialog$enableECLiveRoomCouponDialogNewStyle$2.INSTANCE);
        this.k = new SaasCouponBottomDialog$factory$1(this);
    }

    public final void onResume() {
        super/*androidx.fragment.app.Fragment*/.onResume();
        if (this.h != null) goto L6;
        S90(this);
        return;
    }

    public final ViewModelProvider.Factory o6() {
        return this.k;
    }

    public static void S90(SaasCouponBottomDialog r1) {
        r1.dismissAllowingStateLoss();     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");
        Throwable r2 = DialogFragmentLancet.sLastShowStack;
        if (r2 == null) goto L11;
        d.d(r2, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        return;
    }

    public final void T90(DialogInterface r6) {
        Intrinsics.checkNotNullParameter(r6, "dialog");
        super/*androidx.fragment.app.DialogFragment*/.onDismiss(r6);
        if (this.f == true) goto L8;
        n r7 = this.i;
        if (r7 == null) goto L8;
        r7.b(null, 1);
    L8:
        if (this.g == false) goto L16;
        SaasCouponViewModel r8 = this.h;
        if (r8 == null) goto L12;
        com.bytedance.android.ec.core.arch.event.c.d(r8, new com.bytedance.android.livesdk.livecommerce.saascoupon.viewmodel.a.g("livesdk_coupon_window_click", "blank", null, 4));
    L12:
        SaasCouponViewModel r9 = this.h;
        if (r9 == null) goto L17;
        com.bytedance.android.ec.core.arch.event.c.d(r9, com.bytedance.android.livesdk.livecommerce.saascoupon.viewmodel.a.e.a);
        return;
    L17:
        return;
    }

    public final void onActivityCreated(Bundle r1) {
        super/*androidx.fragment.app.DialogFragment*/.onActivityCreated(r1);
    }

    public final void onCreate(Bundle r2) {
        super/*androidx.fragment.app.DialogFragment*/.onCreate(r2);
        setStyle(0, 2131954513);
    }

    public final Dialog onCreateDialog(Bundle r3) {
        Context r0 = getContext();
        Intrinsics.checkNotNull(r0);
        BottomSheetDialog r4 = new BottomSheetDialog(r0, getTheme());
        r4.setOnKeyListener(new b(this));
        r4.setOnShowListener(new c(this));
        this.e = r4;
        return r4;
    }

    public final void onDismiss(DialogInterface r2) {
        T90(r2);     // Catch: Throwable -> L5
        LandscapeChildDialogBoundsAdapter.onDialogDismissed(getDialog());
        PopupOrDialogVisibilityTracker.onDialogFragmentDismissed(this);
        LandscapeRestrictionGuard.clearAllowedDialogFragment(this);
        return;
    L5:
        th = move-exception;
        LandscapeChildDialogBoundsAdapter.onDialogDismissed(getDialog());
        PopupOrDialogVisibilityTracker.onDialogFragmentDismissed(this);
        LandscapeRestrictionGuard.clearAllowedDialogFragment(this);
        throw th;
    }

    public final void onViewCreated(View r4, Bundle r5) {
        Intrinsics.checkNotNullParameter(r4, "view");
        if (this.h != null) goto L5;
    L8:
        SaasCouponViewModel r6 = this.h;
        if (r6 == null) goto L11;
        com.bytedance.android.ec.core.arch.event.c.c(r6, this, Reflection.getOrCreateKotlinClass(com.bytedance.android.livesdk.livecommerce.saascoupon.viewmodel.a.b.class), new AnonymousClass1(this));
    L11:
        SaasCouponViewModel r7 = this.h;
        if (r7 == null) goto L14;
        com.bytedance.android.ec.core.arch.event.c.c(r7, this, Reflection.getOrCreateKotlinClass(com.bytedance.android.livesdk.livecommerce.saascoupon.viewmodel.a.d.class), new AnonymousClass2(this));
    L14:
        SaasCouponViewModel r8 = this.h;
        if (r8 == null) goto L17;
        com.bytedance.android.ec.core.arch.event.c.d(r8, new com.bytedance.android.livesdk.livecommerce.saascoupon.viewmodel.a.g("livesdk_coupon_window_show", null, null, 6));
    L17:
        SaasCouponViewModel r9 = this.h;
        if (r9 == null) goto L21;
        com.bytedance.android.ec.core.arch.event.c.d(r9, com.bytedance.android.livesdk.livecommerce.saascoupon.viewmodel.a.C0127a.a);
        return;
    L21:
        return;
    L5:
        if (((Boolean) this.j.getValue()).booleanValue() == false) goto L7;
        this.d.c(cl2.b.class, null);
        goto L8
    L7:
        this.d.c(cl2.a.class, null);
        goto L8
    }

    public final View onCreateView(LayoutInflater r1, ViewGroup r2, Bundle r3) {
        Intrinsics.checkNotNullParameter(r1, "inflater");
        if (((Boolean) this.j.getValue()).booleanValue() == false) goto L5;
        this.d.k(new cl2.b(), requireContext(), this);
    L7:
        return this.d.p();
    L5:
        this.d.k(new cl2.a(), requireContext(), this);
        goto L7
    }

    public SaasCouponBottomDialog(g r6, e r7, SaasCouponService r8, k r9, boolean r10) {
        Intrinsics.checkNotNullParameter(r6, "requestParams");
        Intrinsics.checkNotNullParameter(r7, "newcomerTicketModel");
        Intrinsics.checkNotNullParameter(r8, "saasCouponService");
        Intrinsics.checkNotNullParameter(r9, "liveService");
        this();
        SaasCouponViewModel r0 = new SaasCouponViewModel(new com.bytedance.android.livesdk.livecommerce.saascoupon.viewmodel.c(r7, new com.bytedance.android.livesdk.livecommerce.saascoupon.viewmodel.b(r.a.isLogin(), 2)), r6, r9);
        this.h = r0;
        this.i = r8;
        if (Intrinsics.areEqual(r6.b, "preview_benefit_coupon_popup") == false) goto L16;
        if (r10 == true) goto L6;
    L8:
        boolean r11 = false;
    L10:
        if (r11 == true) goto L13;
        r0 = null;
    L13:
        if (r0 == null) goto L17;
        com.bytedance.android.ec.core.arch.event.c.d(r0, new com.bytedance.android.livesdk.livecommerce.saascoupon.viewmodel.a.g("livesdk_coupon_result", null, "success", 2));
        return;
    L17:
        return;
    L6:
        if (r6.k == false) goto L8;
        r11 = true;
        goto L10
    }
}
