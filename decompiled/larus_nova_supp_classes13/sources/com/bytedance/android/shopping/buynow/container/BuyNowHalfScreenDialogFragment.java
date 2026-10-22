package com.bytedance.android.shopping.buynow.container;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import androidx.appcompat.app.AppCompatDialogFragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.bytedance.android.ec.core.monitor.ECExceptionMonitor;
import com.bytedance.android.ec.model.live.LiveClearScreenMode;
import com.bytedance.android.ec.model.live.LiveScreenMoveMode;
import com.bytedance.android.ec.model.live.s;
import com.bytedance.android.shopping.api.ultimate.UltimateBuyParams;
import com.bytedance.android.shopping.api.ultimate.UltimateBuyStyleParams;
import com.bytedance.android.shopping.buynow.controller.q;
import com.bytedance.android.shopping.buynow.data.model.BuyNowOrderSchema;
import com.bytedance.android.shopping.buynow.tracker.BuyNowLog;
import com.bytedance.android.shopping.buynow.viewmodel.BuyNowViewModel;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.helpers.PopupOrDialogVisibilityTracker;
import com.obric.assistant.interaction.impl.window.landscape.childwindow.LandscapeChildDialogBoundsAdapter;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003:\u0001\u0006B\u0007¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0007"}, d2 = {"Lcom/bytedance/android/shopping/buynow/container/BuyNowHalfScreenDialogFragment;", "Landroidx/appcompat/app/AppCompatDialogFragment;", "Lcom/bytedance/android/shopping/buynow/container/o;", "Lcom/bytedance/android/ec/model/live/s;", "<init>", "()V", "a", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class BuyNowHalfScreenDialogFragment extends AppCompatDialogFragment implements o, s {
    public static final /* synthetic */ int f = 0;
    public BuyNowFragment d;
    public la3.e e;

    public static final class a {
        public a() {
        }

        public static void a(BuyNowHalfScreenDialogFragment r2, FragmentManager r3) {
            LandscapeRestrictionOperation r0 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW;
            LandscapeRestrictionGuard.markDialogFragmentIfAllowed(r2, "BuyNowHalfScreenDialog", r0);
            if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r3, r2, r0) == false) goto L9;
            return;
        L9:
            DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L8
        L6:
            r2.show(r3, "BuyNowHalfScreenDialog");
        }

        public static void b(Context r3, String r4, Uri r5, Float r6, BuyNowOrderSchema r7, float r8, String r9) {
            Intrinsics.checkNotNullParameter(r3, "context");
            Intrinsics.checkNotNullParameter(r4, "sessionId");
            BuyNowLog.d("BuyNowHalfScreenDialogFragment", "launch half screen");
            if ((r3 instanceof FragmentActivity) == true) goto L5;
            r3 = null;
        L5:
            FragmentActivity r10 = (FragmentActivity) r3;
            if (r10 == null) goto L15;
            FragmentManager r11 = r10.getSupportFragmentManager();
            if (r11 == null) goto L16;
            BuyNowHalfScreenDialogFragment r0 = new BuyNowHalfScreenDialogFragment();
            Bundle r1 = new Bundle();
            r1.putString("PrefetchSessionId", r4);
            r1.putParcelable("Schema", r5);
            r1.putParcelable("OrderSchema", r7);
            r1.putFloat("HeightPercent", r8);
            r1.putString("source_btm_token", r9);
            if (r6 == null) goto L12;
            float r12 = r6.floatValue();
        L13:
            r1.putFloat("MaskAlpha", r12);
            Unit r13 = Unit.INSTANCE;
            r0.setArguments(r1);
            a(r0, r11);
            return;
        L12:
            r12 = 0.0f;
            goto L13
        L16:
            return;
        }

        public static void c(Context r2, UltimateBuyParams r3, String r4, UltimateBuyStyleParams r5, la3.e r6, String r7, Uri r8, BuyNowOrderSchema r9, int r10, int r11) {
            int r0 = BuyNowHalfScreenDialogFragment.f;
            if ((r11 & 2) == 0) goto L6;
            r3 = null;
        L6:
            if ((r11 & 128) == 0) goto L9;
            r9 = null;
        L9:
            if ((r11 & 256) == 0) goto L11;
            r10 = 0;
        L11:
            Intrinsics.checkNotNullParameter(r2, "context");
            Intrinsics.checkNotNullParameter(r4, "sessionId");
            BuyNowLog.d("BuyNowHalfScreenDialogFragment", "launch half screen sku_buynow");
            if ((r2 instanceof FragmentActivity) == true) goto L14;
            r2 = null;
        L14:
            FragmentActivity r12 = (FragmentActivity) r2;
            if (r12 == null) goto L30;
            FragmentManager r13 = r12.getSupportFragmentManager();
            if (r13 == null) goto L31;
            BuyNowHalfScreenDialogFragment r14 = new BuyNowHalfScreenDialogFragment();
            Bundle r1 = new Bundle();
            r1.putString("PrefetchSessionId", r4);
            r1.putString("source_btm_token", r7);
            if (r5 == null) goto L21;
            float r15 = r5.getHeightPercent();
        L22:
            r1.putFloat("HeightPercent", r15 / 100.0f);
            if (r5 == null) goto L27;
            Float r16 = r5.getMaskAlpha();
            if (r16 == null) goto L27;
            float r17 = r16.floatValue();
        L28:
            r1.putFloat("MaskAlpha", r17);
            r1.putSerializable("ultimate_buy_params", r3);
            r1.putParcelable("Schema", r8);
            r1.putParcelable("OrderSchema", r9);
            r1.putInt("ultimate_buy_ab", r10);
            Unit r18 = Unit.INSTANCE;
            r14.setArguments(r1);
            r14.e = r6;
            a(r14, r13);
            return;
        L27:
            r17 = 0.5f;
            goto L28
        L21:
            r15 = 73.0f;
            goto L22
        L31:
            return;
        }
    }

    static {
        new a();
    }

    public final LiveScreenMoveMode AC() {
        BuyNowFragment r0 = this.d;
        if (r0 == null) goto L10;
        q r1 = r0.o;
        if (r1 == null) goto L10;
        if (r1.h != true) goto L10;
        return LiveScreenMoveMode.LIVE_SCREEN_MOVE_NONE;
    L10:
        return LiveScreenMoveMode.LIVE_SCREEN_MOVE_UP;
    }

    @Override // com.bytedance.android.shopping.buynow.container.o
    public final void close() {
        BuyNowFragment r0 = this.d;
        if (r0 == null) goto L7;
        BuyNowViewModel r1 = r0.W90();
        if (r1 == null) goto L7;
        com.bytedance.android.shopping.buynow.tracker.a r2 = r1.getTracker();
    L8:
        com.bytedance.android.shopping.buynow.monitor.error.a.f(r2, "runtime_error", "BuyNowHalfScreenDialogFragment-close", new AnonymousClass1(this));
        return;
    L7:
        r2 = null;
        goto L8
    }

    public final LiveClearScreenMode cy() {
        BuyNowFragment r0 = this.d;
        if (r0 == null) goto L10;
        q r1 = r0.o;
        if (r1 == null) goto L10;
        if (r1.h != true) goto L10;
        return LiveClearScreenMode.CLEAR_SCREEN_MODE_NONE;
    L10:
        return LiveClearScreenMode.CLEAR_SCREEN_MODE_FULL;
    }

    @Override // com.bytedance.android.shopping.buynow.container.o
    public final View G9() {
        FragmentActivity r0 = getActivity();
        if (r0 == null) goto L7;
        Window r1 = r0.getWindow();
        if (r1 == null) goto L7;
        return S90(r1);
    L7:
        return null;
    }

    @Override // com.bytedance.android.shopping.buynow.container.o
    public final Window Ou() {
        Dialog r0 = getDialog();
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getWindow();
    }

    @Override // com.bytedance.android.shopping.buynow.container.o
    public final Window TR() {
        Dialog r0 = getDialog();
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getWindow();
    }

    public final void onStart() {
        PopupOrDialogVisibilityTracker.bindDialogFragment(this);
        LandscapeRestrictionGuard.bindDialogForAllowedDialogFragment(this);
        super/*androidx.fragment.app.DialogFragment*/.onStart();
        Bundle r0 = getArguments();
        if (r0 == null) goto L5;
        float r1 = r0.getFloat("MaskAlpha");
    L6:
        float r2 = ul.g.a(r1);
        BuyNowFragment r3 = this.d;     // Catch: Exception -> L24
        if (r3 == null) goto L13;
        q r4 = r3.o;     // Catch: Exception -> L24
        if (r4 == null) goto L13;
        if (r4.h != true) goto L13;
        return;
    L13:
        Dialog r5 = getDialog();     // Catch: Exception -> L24
        if (r5 == null) goto L18;
        Window r6 = r5.getWindow();     // Catch: Exception -> L24
        if (r6 == null) goto L18;
        r6.addFlags(2);     // Catch: Exception -> L24
    L18:
        Dialog r7 = getDialog();     // Catch: Exception -> L24
        if (r7 == null) goto L30;
        Window r8 = r7.getWindow();     // Catch: Exception -> L24
        if (r8 == null) goto L31;
        r8.setDimAmount(r2);     // Catch: Exception -> L24
        return;
    L31:
        return;
    L30:
        return;
    L24:
        e = move-exception;
        ECExceptionMonitor.e(e);
        return;
    L5:
        r1 = 0.5f;
        goto L6
    }

    @Override // com.bytedance.android.shopping.buynow.container.o
    public final View s7() {
        Dialog r0 = getDialog();
        if (r0 == null) goto L7;
        Window r1 = r0.getWindow();
        if (r1 == null) goto L7;
        return S90(r1);
    L7:
        return null;
    }

    public BuyNowHalfScreenDialogFragment() {
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

    public final void onActivityCreated(Bundle r4) {
        super/*androidx.fragment.app.DialogFragment*/.onActivityCreated(r4);
        BuyNowFragment r5 = this.d;
        if (r5 == null) goto L7;
        BuyNowViewModel r6 = r5.W90();
        if (r6 == null) goto L7;
        com.bytedance.android.shopping.buynow.tracker.a r7 = r6.getTracker();
    L8:
        com.bytedance.android.shopping.buynow.monitor.error.a.f(r7, "runtime_error", "BuyNowHalfScreenDialogFragment-onActivityCreated", new C02521(this));
        return;
    L7:
        r7 = null;
        goto L8
    }

    public final void onCreate(final Bundle r4) {
        BuyNowFragment r0 = this.d;
        if (r0 == null) goto L7;
        BuyNowViewModel r1 = r0.W90();
        if (r1 == null) goto L7;
        com.bytedance.android.shopping.buynow.tracker.a r2 = r1.getTracker();
    L8:
        com.bytedance.android.shopping.buynow.monitor.error.a.f(r2, "runtime_error", "BuyNowHalfScreenDialogFragment-onCreate", new C02531(this, r4));
        return;
    L7:
        r2 = null;
        goto L8
    }

    public final Dialog onCreateDialog(Bundle r3) {
        return new BuyNowFullscreenDialog(requireContext(), getTheme());
    }

    public final void onDismiss(DialogInterface r2) {
        Intrinsics.checkNotNullParameter(r2, "dialog");     // Catch: Throwable -> L13
        super/*androidx.fragment.app.DialogFragment*/.onDismiss(r2);     // Catch: Throwable -> L13
        BuyNowFragment r3 = this.d;     // Catch: Throwable -> L13
        if (r3 == null) goto L11;
        int r0 = com.bytedance.android.shopping.buynow.utils.b.a;     // Catch: Throwable -> L13
        if (com.bytedance.android.shopping.buynow.utils.b.a(r3.W90()) == false) goto L7;
    L8:
        BuyNowFragment.b r4 = r3.y;     // Catch: Throwable -> L13
        if (r4 == null) goto L11;
        ul.b.a(r4);     // Catch: Throwable -> L13
        goto L11
    L7:
        if (r3.W90().getStaticState().c() == true) goto L8;
    L11:
        LandscapeChildDialogBoundsAdapter.onDialogDismissed(getDialog());
        PopupOrDialogVisibilityTracker.onDialogFragmentDismissed(this);
        LandscapeRestrictionGuard.clearAllowedDialogFragment(this);
        return;
    L13:
        th = move-exception;
        LandscapeChildDialogBoundsAdapter.onDialogDismissed(getDialog());
        PopupOrDialogVisibilityTracker.onDialogFragmentDismissed(this);
        LandscapeRestrictionGuard.clearAllowedDialogFragment(this);
        throw th;
    }

    public static final /* synthetic */ void T90(BuyNowHalfScreenDialogFragment r0, Bundle r1) {
        super/*androidx.fragment.app.DialogFragment*/.onCreate(r1);
    }

    public final void show(FragmentManager r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "manager");
        if (r2.isStateSaved() == true) goto L13;
        LandscapeRestrictionOperation r0 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW;
        LandscapeRestrictionGuard.markDialogFragmentIfAllowed(this, r3, r0);
        if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r2, this, r0) == true) goto L14;
        DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L10
    L8:
        super/*androidx.fragment.app.DialogFragment*/.show(r2, r3);
        return;
    L14:
        return;
    }

    public final View onCreateView(LayoutInflater r1, ViewGroup r2, Bundle r3) {
        Intrinsics.checkNotNullParameter(r1, "inflater");
        return r1.inflate(2131559216, r2);
    }
}
