package com.bytedance.android.livesdk.livecommerce.base;

import android.R;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.FrameLayout;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProviders;
import bh2.d;
import bh2.f;
import bh2.g;
import bh2.h;
import bh2.i;
import bh2.j;
import bh2.k;
import bh2.l;
import bh2.m;
import bh2.n;
import bh2.o;
import bh2.p;
import bh2.q;
import bh2.r;
import bh2.s;
import bh2.t;
import bh2.u;
import bh2.v;
import com.bytedance.android.ec.adapter.api.IAdapterService;
import com.bytedance.android.ec.adapter.api.e;
import com.bytedance.android.ec.sdk.ECSdk;
import com.bytedance.android.livesdk.livecommerce.broadcast.bindcoupon.ui.ECBindCouponFragment;
import com.bytedance.android.livesdk.livecommerce.dialog.ECBottomDialog;
import com.bytedance.android.livesdk.livecommerce.room.controller.ControllerCenter;
import com.bytedance.android.livesdk.livecommerce.room.controller.RealRoomController;
import com.bytedance.android.livesdk.livecommerce.room.controller.z;
import com.bytedance.android.livesdk.livecommerce.utils.ECDisplayUtils;
import com.bytedance.android.livesdk.livecommerce.utils.EComABUtils;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.helpers.PopupOrDialogVisibilityTracker;
import com.obric.assistant.interaction.impl.window.landscape.childwindow.LandscapeChildDialogBoundsAdapter;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public abstract class ECBaseDialogFragment<VM extends ViewModel> extends DialogFragment implements View.OnClickListener, ECBottomDialog.b, z {
    public static final /* synthetic */ int h = 0;
    public View d;
    public FrameLayout e;
    public e f;
    public VM g;

    public class a implements Runnable {
        public final /* synthetic */ ECBaseDialogFragment a;

        @Override // java.lang.Runnable
        public final void run() {
            ECBaseDialogFragment.S90(this.a);     // Catch: Throwable -> L4 Exception -> L10
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L13;
            throw th;
        L13:
            return;
        }

        public a(ECBaseDialogFragment r1) {
            this.a = r1;
        }
    }

    public class b implements Animation.AnimationListener {
        public final /* synthetic */ Runnable a;

        @Override // android.view.animation.Animation.AnimationListener
        public final void onAnimationRepeat(Animation r1) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public final void onAnimationStart(Animation r1) {
        }

        public b(Runnable r1) {
            this.a = r1;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public final void onAnimationEnd(Animation r1) {
            Runnable r2 = this.a;
            if (r2 == null) goto L6;
            r2.run();
            return;
        }
    }

    public interface c<T> {
        void a(e r1);
    }

    public void X90() {
    }

    public int Y90() {
        return 2;
    }

    public void aa0(Bundle r1) {
    }

    public void da0() {
    }

    public void ea0() {
    }

    public void fa0() {
    }

    public void ga0(String r1) {
    }

    public abstract int getLayoutId();

    public boolean ha0() {
        return this instanceof ECBindCouponFragment;
    }

    public ViewGroup.MarginLayoutParams ba0() {
        FrameLayout.LayoutParams r0 = new FrameLayout.LayoutParams(-1, -1);
        r0.topMargin = (int) (ECDisplayUtils.a(getContext()) * 0.26999998f);
        return r0;
    }

    public final ECBottomDialog Z90() {
        return (ECBottomDialog) super.getDialog();
    }

    public void dismiss() {
        if (Z90() != null) goto L5;
    L7:
        boolean r0 = false;
    L8:
        if (r0 == true) goto L10;
        return;
    L10:
        U90(Y90(), new a(this));
        return;
    L5:
        if (Z90().isShowing() == false) goto L7;
        r0 = true;
        goto L8
    }

    public final /* bridge */ /* synthetic */ Dialog getDialog() {
        return Z90();
    }

    public final void onDestroy() {
        super/*androidx.fragment.app.Fragment*/.onDestroy();
        W90(new g(this));
        RealRoomController r0 = ControllerCenter.c(null, null);
        Intrinsics.checkNotNullParameter(this, "listener");
        if (EComABUtils.isLiveListMemoryLeakSwitch() == false) goto L6;
        ((ArrayList) r0.F).remove(this);
        return;
    }

    public void onDestroyView() {
        super.onDestroyView();
        W90(new f(this));
    }

    public final void onPause() {
        super/*androidx.fragment.app.Fragment*/.onPause();
        W90(new d(this));
    }

    public void onResume() {
        super/*androidx.fragment.app.Fragment*/.onResume();
        W90(new k(this));
    }

    public final void onStart() {
        PopupOrDialogVisibilityTracker.bindDialogFragment(this);
        LandscapeRestrictionGuard.bindDialogForAllowedDialogFragment(this);
        super.onStart();
        W90(new bh2.b(this));
    }

    public final void onStop() {
        super.onStop();
        W90(new j(this));
    }

    public ECBaseDialogFragment() {
    }

    public final void dismissAllowingStateLoss() {
        S90(this);     // Catch: Exception -> L4
        return;
    }

    @Override // com.bytedance.android.livesdk.livecommerce.room.controller.z
    public void onLiveEnd() {
        T90(this);
    }

    public static void S90(DialogFragment r1) {
        super.dismissAllowingStateLoss();     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");
        Throwable r2 = DialogFragmentLancet.sLastShowStack;
        if (r2 == null) goto L11;
        com.bytedance.crash.d.d(r2, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        return;
    }

    public static void T90(ECBaseDialogFragment r1) {
        r1.dismiss();     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_EXCEPTION");
        Throwable r2 = DialogFragmentLancet.sLastShowStack;
        if (r2 == null) goto L11;
        com.bytedance.crash.d.d(r2, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        return;
    }

    @Override // com.bytedance.android.livesdk.livecommerce.dialog.ECBottomDialog.b
    public void Nc(ECBottomDialog.a r3) {
        U90(Y90(), new n(r3));
    }

    public VM V90(Fragment r3) {
        Type r0 = r3.getClass().getGenericSuperclass();     // Catch: Throwable -> L6
        if ((r0 instanceof ParameterizedType) == false) goto L12;
        return (VM) ViewModelProviders.of(r3).get((Class) ((ParameterizedType) r0).getActualTypeArguments()[0]);
    L12:
        return null;
    L6:
        th = move-exception;
        th.printStackTrace();
        return null;
    }

    public final void W90(final c<e> r3) {
        e r0 = this.f;
        if (r0 == null) goto L5;
        r3.a(r0);
        return;
    L5:
        int r1 = ECSdk.a;
        ECSdk.b(IAdapterService.class, new bh2.c(this, r3));
    }

    public ECBottomDialog ca0(Bundle r3) {
        if (ha0() == false) goto L5;
        ECBottomDialog r0 = new ECBottomDialog(getActivity(), 2131952365);
    L6:
        r0.a = this;
        return r0;
    L5:
        r0 = new ECBottomDialog(getActivity(), 2131952347);
        goto L6
    }

    public void onActivityCreated(Bundle r12) {
        super.onActivityCreated(r12);
        aa0(getArguments());
        X90();
        ECBaseViewModel r13 = (VM) V90(this);
        this.g = r13;
        if (r13 == null) goto L8;
        if ((r13 instanceof ECBaseViewModel) == false) goto L8;
        ECBaseViewModel r14 = r13;
        r14.getToastString().observe(this, new o(this));
        r14.getToastInt().observe(this, new p(this));
        r14.getSuccessIconToast().observe(this, new q());
        r14.getFailedIconToast().observe(this, new r());
        r14.getLoadingData().observe(this, new s(this));
        r14.getLoadingFinishData().observe(this, new t(this));
        r14.getLoadingErrorData().observe(this, new u(this));
        r14.getPermissionDeniedData().observe(this, new v(this));
        r14.getFinishActivity().observe(this, new m(this));
    L8:
        if (this.g == null) goto L32;
        Window r15 = Z90().getWindow();
        if (r15 != null) goto L12;
    L19:
        Window r16 = Z90().getWindow();
        if (r16 == null) goto L22;
        r16.setSoftInputMode(48);
    L22:
        int r17 = Y90();
        if (r17 != 3) goto L26;
        TranslateAnimation r18 = new TranslateAnimation(1, 1.0f, 1, 0.0f, 1, 0.0f, 1, 0.0f);
    L29:
        if (r18 == null) goto L31;
        r18.setDuration(200);
        this.d.startAnimation(r18);
    L31:
        RealRoomController r19 = ControllerCenter.c(null, null);
        Intrinsics.checkNotNullParameter(this, "listener");
        ((ArrayList) r19.F).add(this);
        goto L32
    L26:
        if (r17 != 2) goto L28;
        r18 = new TranslateAnimation(1, 0.0f, 1, 0.0f, 1, 1.0f, 1, 0.0f);
        goto L29
    L28:
        r18 = null;
        goto L29
    L12:
        if (getContext() == null) goto L19;
        WindowManager.LayoutParams r0 = r15.getAttributes();
        r0.width = -1;
        r0.height = -1;
        r15.setAttributes(r0);
        r15.setGravity(80);
        View r1 = r15.getDecorView();
        if (com.larus.home.impl.utils.c.e == false) goto L18;
        FLogger.a.i("DecorViewLancet", "getDecorView");
        Thread r2 = ThreadMethodProxy.currentThread();
        if (r2 == com.larus.home.impl.utils.c.a) goto L18;
        com.larus.home.impl.utils.c.a(r2, "getDecorView");
    L18:
        r1.setPadding(0, 0, 0, 0);
        r15.setBackgroundDrawableResource(R.color.transparent);
        r15.setWindowAnimations(2131952325);
    L32:
        W90(new l(this));
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View r2) {
        if (r2 != this.e) goto L6;
        T90(this);
        return;
    }

    public final void onCreate(Bundle r1) {
        super.onCreate(r1);
        W90(new h(this));
    }

    public /* bridge */ /* synthetic */ Dialog onCreateDialog(Bundle r1) {
        return ca0(r1);
    }

    public void onDismiss(DialogInterface r2) {
        super.onDismiss(r2);     // Catch: Throwable -> L5
        W90(new i(this));     // Catch: Throwable -> L5
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

    public final void U90(int r11, Runnable r12) {
        if (r11 != 3) goto L6;
        TranslateAnimation r13 = new TranslateAnimation(1, 0.0f, 1, 1.0f, 1, 0.0f, 1, 0.0f);
    L9:
        if (r13 == null) goto L11;
        r13.setDuration(200);
        r13.setAnimationListener(new b(r12));
        r13.setFillAfter(true);
        this.d.startAnimation(r13);
        return;
    L11:
        r12.run();
        return;
    L6:
        if (r11 != 2) goto L8;
        r13 = new TranslateAnimation(1, 0.0f, 1, 0.0f, 1, 0.0f, 1, 1.0f);
        goto L9
    L8:
        r13 = null;
        goto L9
    }

    public void onViewCreated(View r1, Bundle r2) {
        super/*androidx.fragment.app.Fragment*/.onViewCreated(r1, r2);
        W90(new bh2.e(this));
    }

    public final void show(FragmentManager r2, String r3) {
        Fragment r0 = r2.findFragmentByTag(r3);     // Catch: Exception -> L12
        if (r0 == null) goto L6;
        r2.beginTransaction().remove(r0).commitAllowingStateLoss();     // Catch: Exception -> L12
        return;
    L6:
        LandscapeRestrictionOperation r1 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW;     // Catch: Exception -> L12
        LandscapeRestrictionGuard.markDialogFragmentIfAllowed(this, r3, r1);     // Catch: Exception -> L12
        if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r2, this, r1) == true) goto L19;
        DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L15
    L10:
        super.show(r2, r3);     // Catch: Exception -> L12
        return;
    L19:
        return;
    L12:
        e = move-exception;
        e.printStackTrace();
    }

    public final View onCreateView(LayoutInflater r2, ViewGroup r3, Bundle r4) {
        this.e = (FrameLayout) th.a.c(getActivity(), 2131560724, r3, false);
        View r5 = th.a.c(getActivity(), getLayoutId(), this.e, false);
        this.d = r5;
        r5.setClickable(true);
        View r6 = this.d;
        this.e.addView(r6, ba0());
        this.e.setOnClickListener(this);
        return this.e;
    }
}
