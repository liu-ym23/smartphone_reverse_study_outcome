package com.bytedance.android.livesdk.ktvimpl.base.view;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.bytedance.android.live.core.utils.ContextUtil;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.ktv.common.util.o;
import com.bytedance.android.livesdk.LiveDialogFragment;
import com.bytedance.bdlocation.network.model.DeviceStatus$DiffDimension;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b&\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/livesdk/ktvimpl/base/view/KtvBaseBottomDialogFragment;", "Lcom/bytedance/android/livesdk/LiveDialogFragment;", "<init>", "()V", "livektv-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public abstract class KtvBaseBottomDialogFragment extends LiveDialogFragment {
    public View d;
    public View e;
    public View f;
    public String g;

    public KtvBaseBottomDialogFragment() {
        setNoTitleAndCancelOutside(true);
    }

    public final boolean onBackPressed() {
        Activity r0 = ContextUtil.contextToActivity(getContext());
        Object r1 = null;
        if (r0 == null) goto L5;
        Object r2 = r0.getSystemService("input_method");
    L7:
        if ((r2 instanceof InputMethodManager) == false) goto L10;
        r1 = r2;
    L10:
        InputMethodManager r3 = (InputMethodManager) r1;
        if (r3 != null) goto L13;
    L22:
        dismissAllowingStateLoss();     // Catch: Exception -> L17
        return true;
    L17:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");
        Throwable r4 = DialogFragmentLancet.sLastShowStack;
        if (r4 == null) goto L25;
        com.bytedance.crash.d.d(r4, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        return true;
    L25:
        return true;
    L13:
        if (r3.isActive() != true) goto L22;
        return false;
    L5:
        r2 = null;
        goto L7
    }

    public final void onActivityCreated(Bundle r4) {
        super.onActivityCreated(r4);
        Dialog r5 = getDialog();
        if (r5 == null) goto L8;
        Window r6 = r5.getWindow();
        if (r6 == null) goto L9;
        r6.setLayout(-1, -1);
        WindowManager.LayoutParams r0 = r6.getAttributes();
        r0.height = s1.w() - s1.A();
        r6.setAttributes(r0);
        r6.setGravity(80);
        r6.clearFlags(DeviceStatus$DiffDimension.DIFF_BLUETOOTH_PERMISSION);
        r6.setAttributes(r6.getAttributes());
        return;
    L9:
        return;
    }

    public final void onCancel(DialogInterface r3) {
        Intrinsics.checkNotNullParameter(r3, "dialog");
        super.onCancel(r3);
        Dialog r4 = getDialog();
        Context r0 = getContext();
        if (r4 == null) goto L18;
        if (r0 == null) goto L22;
        Dialog r5 = getDialog();
        if (r5 == null) goto L19;
        View r6 = r5.getCurrentFocus();
        if (r6 == null) goto L23;
        Object r1 = r0.getSystemService("input_method");
        if (r1 == null) goto L17;
        InputMethodManager r2 = (InputMethodManager) r1;
        if (r2.isActive() == false) goto L20;
        r2.hideSoftInputFromWindow(r6.getWindowToken(), 0);
        return;
    L20:
        return;
    L17:
        throw new NullPointerException("null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
    L23:
        return;
    L19:
        return;
    L22:
        return;
    }

    public void onCreate(Bundle r1) {
        super.onCreate(r1);
    }

    public View S90(LayoutInflater r2, ViewGroup r3) {
        Intrinsics.checkNotNullParameter(r2, "inflater");
        Intrinsics.checkNotNullParameter(r3, "container");
        return this.f;
    }

    public View onCreateView(LayoutInflater r7, ViewGroup r8, Bundle r9) {
        Intrinsics.checkNotNullParameter(r7, "inflater");
        View r10 = r7.inflate(2131566448, r8, false);
        ViewGroup r0 = (ViewGroup) r10.findViewById(2131376869);
        if (TextUtils.isEmpty(this.g) == true) goto L8;
        Context r1 = getContext();
        if (r1 == null) goto L8;
        FrameLayout r3 = new FrameLayout(r1);
        TextView r2 = new TextView(r3.getContext());
        r2.setText(this.g);
        r2.setTextColor(r2.getContext().getResources().getColor(2131109391));
        r3.addView(r2);
        r3.setLayoutParams(new ViewGroup.LayoutParams(-1, o.a(55.0f)));
        FrameLayout.LayoutParams r4 = new FrameLayout.LayoutParams(-2, -2);
        r4.gravity = 17;
        r2.setLayoutParams(r4);
        Unit r5 = Unit.INSTANCE;
        this.e = r3;
    L8:
        Intrinsics.checkNotNullParameter(r7, "inflater");
        View r11 = this.e;
        View r6 = null;
        if (r11 != null) goto L11;
        r11 = null;
    L15:
        this.e = r11;
        View r12 = new View(getContext());
        r12.setLayoutParams(new ViewGroup.LayoutParams(-1, o.a(0.5f)));
        r12.setBackgroundColor(ColorProtector.parseColor("#2bffffff"));
        Unit r13 = Unit.INSTANCE;
        r0.addView(r12);
        View r14 = S90(r7, r0);
        if (r14 != null) goto L18;
    L21:
        this.f = r6;
        this.d = r10;
        return r10;
    L18:
        if (r14.getParent() != null) goto L20;
        r0.addView(r14);
    L20:
        r6 = r14;
        goto L21
    L11:
        if (r11.getParent() != null) goto L13;
        r0.addView(r11);
    L13:
        Unit r15 = Unit.INSTANCE;
        goto L15
    }
}
