package com.bytedance.android.shopping.new_cart.hybrid;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.InflateException;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import androidx.fragment.app.DialogFragment;
import com.bytedance.android.ec.core.monitor.ECExceptionMonitor;
import com.bytedance.android.shopping.extensions.m;
import com.bytedance.android.shopping.new_cart.utils.f;
import com.bytedance.android.shopping.orderlist.common.freq.FreqActions;
import com.bytedance.android.shopping.yata.biz.popup.PopupLayer;
import com.bytedance.crash.d;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.helpers.PopupOrDialogVisibilityTracker;
import com.obric.assistant.interaction.impl.window.landscape.childwindow.LandscapeChildDialogBoundsAdapter;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import hl3.e;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002:\u0001\u0005B\u0007¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/shopping/new_cart/hybrid/CartHybridDialogFragment;", "Landroidx/fragment/app/DialogFragment;", "Landroid/content/DialogInterface$OnShowListener;", "<init>", "()V", "a", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class CartHybridDialogFragment extends DialogFragment implements DialogInterface.OnShowListener {
    public com.bytedance.android.shopping.new_cart.hybrid.a d;
    public final Lazy e;
    public PopupLayer f;

    public static final class a {
    }

    public static final class b implements DialogInterface.OnKeyListener {
        public final /* synthetic */ CartHybridDialogFragment a;

        public b(CartHybridDialogFragment r1) {
            this.a = r1;
        }

        @Override // android.content.DialogInterface.OnKeyListener
        public final boolean onKey(DialogInterface r1, int r2, KeyEvent r3) {
            if (r2 == 4) goto L5;
            return false;
        L5:
            if (r3.getAction() == 1) goto L15;
            return false;
        L15:
            this.a.dismissAllowingStateLoss();     // Catch: Exception -> L9
            return false;
        L9:
            e = move-exception;
            d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");
            Throwable r4 = DialogFragmentLancet.sLastShowStack;
            if (r4 == null) goto L19;
            d.d(r4, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
            return false;
        L19:
            return false;
        }
    }

    public static final class c implements e.a {
        public final /* synthetic */ CartHybridDialogFragment a;
        public final /* synthetic */ View b;

        public Context getContext() {
            return this.a.requireContext();
        }

        public final FrameLayout getHost() {
            return (FrameLayout) this.b.findViewById(2131384813);
        }

        public final FrameLayout.LayoutParams getLayoutParams() {
            return new FrameLayout.LayoutParams(-1, -1);
        }

        public c(CartHybridDialogFragment r1, View r2) {
            this.a = r1;
            this.b = r2;
        }
    }

    static {
    }

    @Override // android.content.DialogInterface.OnShowListener
    public final void onShow(DialogInterface r1) {
    }

    public CartHybridDialogFragment() {
        this.e = LazyKt.lazy(new CartHybridDialogFragment$params$2(this));
    }

    public final void onResume() {
        super/*androidx.fragment.app.Fragment*/.onResume();
        JSONObject r0 = new JSONObject();     // Catch: Exception -> L17
        r0.putOpt("visible", Boolean.TRUE);     // Catch: Exception -> L17
        r0.putOpt("timestamp", Long.valueOf(System.currentTimeMillis()));     // Catch: Exception -> L17
        PopupLayer r1 = this.f;     // Catch: Exception -> L17
        hl3.a r2 = null;
        if (r1 == null) goto L6;
        hl3.a r3 = r1.k();     // Catch: Exception -> L17
    L8:
        if ((r3 instanceof com.bytedance.android.shopping.yata.biz.popup.a) == false) goto L11;
        r2 = r3;
    L11:
        com.bytedance.android.shopping.yata.biz.popup.a r4 = (com.bytedance.android.shopping.yata.biz.popup.a) r2;     // Catch: Exception -> L17
        if (r4 == null) goto L22;
        hl3.d r5 = r4.a();     // Catch: Exception -> L17
        if (r5 == null) goto L23;
        r5.a(r0);     // Catch: Exception -> L17
        return;
    L23:
        return;
    L22:
        return;
    L6:
        r3 = null;
    L17:
        e = move-exception;
        ECExceptionMonitor.e(e);
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

    public final void onCreate(Bundle r2) {
        super.onCreate(r2);
        setStyle(1, 2131952006);
    }

    public final void onDismiss(DialogInterface r2) {
        Intrinsics.checkNotNullParameter(r2, "dialog");     // Catch: Throwable -> L16
        super.onDismiss(r2);     // Catch: Throwable -> L16
        com.bytedance.android.shopping.new_cart.hybrid.a r3 = this.d;     // Catch: Throwable -> L16
        if (r3 == null) goto L13;
        Dialog r0 = getDialog();     // Catch: Throwable -> L16
        if (r0 == null) goto L13;
        Window r1 = r0.getWindow();     // Catch: Throwable -> L16
        if (r1 == null) goto L13;
        View r4 = S90(r1);     // Catch: Throwable -> L16
        if (r4 == null) goto L13;
        ViewTreeObserver r5 = r4.getViewTreeObserver();     // Catch: Throwable -> L16
        if (r5 == null) goto L13;
        r5.removeOnPreDrawListener(r3);     // Catch: Throwable -> L16
    L13:
        this.d = null;     // Catch: Throwable -> L16
        LandscapeChildDialogBoundsAdapter.onDialogDismissed(getDialog());
        PopupOrDialogVisibilityTracker.onDialogFragmentDismissed(this);
        LandscapeRestrictionGuard.clearAllowedDialogFragment(this);
        return;
    L16:
        th = move-exception;
        LandscapeChildDialogBoundsAdapter.onDialogDismissed(getDialog());
        PopupOrDialogVisibilityTracker.onDialogFragmentDismissed(this);
        LandscapeRestrictionGuard.clearAllowedDialogFragment(this);
        throw th;
    }

    public final void onViewCreated(View r12, Bundle r13) {
        Intrinsics.checkNotNullParameter(r12, FreqActions.ACTION_VIEW);
        super/*androidx.fragment.app.Fragment*/.onViewCreated(r12, r13);
        PopupLayer r14 = new PopupLayer();
        this.f = r14;
        r14.j(new c(this, r12));
        final CartHybridDialogPrams r15 = (CartHybridDialogPrams) this.e.getValue();
        if (r15 == null) goto L37;
        int r16 = f.a;
        double r0 = (((double) (r15.getHeightPercent() * f.a(requireContext()))) * 0.01d) - ((double) r15.getBottomOffset());
        String r17 = String.valueOf(r15.getSchema());
        String r2 = r15.getMaskColor();
        if (r2 != null) goto L7;
    L10:
        boolean r3 = true;
    L11:
        if (r3 == true) goto L18;
        String r4 = r15.getMaskColor();
        if (r4 == null) goto L18;
        Integer r5 = StringsKt.toIntOrNull(r4);
        if (r5 == null) goto L18;
        int r6 = r5.intValue();
    L19:
        String r7 = r15.getPopupCode();
        if (r7 == null) goto L22;
        List r8 = StringsKt.split$default(r7, new String[]{","}, false, 0, 6, null);
    L23:
        String r9 = "same_shop";
        if (r8 == null) goto L27;
        String r10 = (String) CollectionsKt.firstOrNull(r8);
        if (r10 == null) goto L27;
    L28:
        if (r8 == null) goto L33;
        String r11 = (String) CollectionsKt.firstOrNull(r8);
        if (r11 == null) goto L33;
        r9 = r11;
    L33:
        Boolean r18 = Boolean.TRUE;
        il3.a r19 = new il3.a(r9, r10, MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("schema", r17), TuplesKt.to("is_hybrid", r18), TuplesKt.to("type", "popup"), TuplesKt.to("action_type", "bottom"), TuplesKt.to("enable_pull_up", Boolean.valueOf(r15.getEnablePullUp())), TuplesKt.to("height", Double.valueOf(r0)), TuplesKt.to("mask_color", Integer.valueOf(r6)), TuplesKt.to("has_mask", Boolean.valueOf(r15.getHasMask())), TuplesKt.to("allow_close_by_touch_mask", Boolean.valueOf(!r15.getMaskClickDisable())), TuplesKt.to("hide_able", r18), TuplesKt.to("disable_drag_down", r18), TuplesKt.to("render_safe_area", Boolean.FALSE)}));
        PopupLayer r110 = this.f;
        if (r110 == null) goto L38;
        r110.g(r19, new CartHybridDialogFragment$onViewCreated$$inlined$let$lambda$1(r15, this));
        return;
    L38:
        return;
    L27:
        r10 = "same_shop";
        goto L28
    L22:
        r8 = null;
    L18:
        r6 = 1711276032;
        goto L19
    L7:
        if (r2.length() == 0) goto L10;
        r3 = false;
        goto L11
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final View onCreateView(LayoutInflater r4, ViewGroup r5, Bundle r6) {
        Intrinsics.checkNotNullParameter(r4, "inflater");
        WindowManager.LayoutParams r7 = null;
        Context r0 = getContext();     // Catch: InflateException -> L7
        if (r0 == null) goto L9;
        View r8 = th.a.c(r0, 2131559266, r5, false);     // Catch: InflateException -> L7
    L10:
        Dialog r1 = getDialog();
        if (r1 == null) goto L15;
        Window r2 = r1.getWindow();
        if (r2 == null) goto L15;
        r2.setBackgroundDrawableResource(2131106784);
    L15:
        Dialog r3 = getDialog();
        if (r3 == null) goto L22;
        Window r9 = r3.getWindow();
        if (r9 == null) goto L22;
        View r10 = S90(r9);
        if (r10 == null) goto L22;
        r10.setPadding(0, 0, 0, 0);
    L22:
        Dialog r11 = getDialog();
        if (r11 == null) goto L25;
        r11.setOnDismissListener(this);
    L25:
        Dialog r12 = getDialog();
        if (r12 == null) goto L28;
        r12.setOnShowListener(this);
    L28:
        Dialog r13 = getDialog();
        if (r13 == null) goto L31;
        r13.setOnKeyListener(new b(this));
    L31:
        Dialog r14 = getDialog();
        if (r14 == null) goto L36;
        Window r15 = r14.getWindow();
        if (r15 == null) goto L36;
        Ref.ObjectRef r16 = new Ref.ObjectRef();
        r16.element = null;
        this.d = new com.bytedance.android.shopping.new_cart.hybrid.a(r15, r16);
        S90(r15).getViewTreeObserver().addOnPreDrawListener(this.d);
    L36:
        Dialog r17 = getDialog();
        if (r17 == null) goto L41;
        Window r18 = r17.getWindow();
        if (r18 == null) goto L41;
        m.a(r18, true);
    L41:
        Dialog r19 = getDialog();
        if (r19 == null) goto L46;
        Window r20 = r19.getWindow();
        if (r20 == null) goto L46;
        r7 = r20.getAttributes();
    L46:
        if (r7 == null) goto L48;
        r7.gravity = 48;
    L48:
        if (r7 == null) goto L50;
        r7.width = -1;
    L50:
        int r21 = f.a;
        int r22 = f.a(requireContext());
        CartHybridDialogPrams r23 = (CartHybridDialogPrams) this.e.getValue();
        if (r23 == null) goto L53;
        int r24 = r23.getBottomOffset();
    L54:
        int r25 = r22 - r24;
        if (r7 == null) goto L57;
        r7.height = r25;
    L57:
        Dialog r26 = getDialog();
        if (r26 == null) goto L62;
        Window r27 = r26.getWindow();
        if (r27 == null) goto L62;
        r27.setAttributes(r7);
    L62:
        Dialog r28 = getDialog();
        if (r28 == null) goto L67;
        Window r29 = r28.getWindow();
        if (r29 == null) goto L67;
        r29.addFlags(8);
    L67:
        Dialog r30 = getDialog();
        if (r30 == null) goto L70;
        r30.setCancelable(false);
    L70:
        Dialog r31 = getDialog();
        if (r31 == null) goto L73;
        r31.setCanceledOnTouchOutside(false);
    L73:
        return r8;
    L53:
        r24 = com.bytedance.android.shopping.extensions.b.b(75);
    L9:
        r8 = null;
    L7:
        e = move-exception;
        ECExceptionMonitor.e(e);
        goto L9
    }
}
