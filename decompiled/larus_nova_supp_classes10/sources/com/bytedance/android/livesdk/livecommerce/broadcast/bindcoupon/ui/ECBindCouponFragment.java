package com.bytedance.android.livesdk.livecommerce.broadcast.bindcoupon.ui;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.android.livesdk.livecommerce.base.ECBaseDialogFragment;
import com.bytedance.android.livesdk.livecommerce.dialog.ECBottomDialog;
import com.bytedance.android.livesdk.livecommerce.utils.ECDisplayUtils;
import com.bytedance.android.livesdk.livecommerce.utils.k;
import com.bytedance.android.livesdk.livecommerce.view.coupon.ECNewAddCouponLayout;
import com.bytedance.crash.d;
import com.larus.apm.impl.protector.RunnableProtector;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.helpers.PopupOrDialogVisibilityTracker;
import com.obric.assistant.interaction.impl.window.landscape.childwindow.LandscapeChildDialogBoundsAdapter;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import eh2.e;
import eh2.f;
import eh2.g;
import io.reactivex.android.schedulers.AndroidSchedulers;
import java.lang.ref.WeakReference;
import si2.p;
import vi2.h;
import vi2.j;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public class ECBindCouponFragment extends ECBaseDialogFragment<ECBindCouponViewModel> {
    public static final /* synthetic */ int y = 0;
    public ImageView i;
    public EditText j;
    public TextView k;
    public TextView l;
    public ViewGroup m;
    public ECNewAddCouponLayout n;
    public LinearLayout o;
    public String p;
    public String q;
    public View r;
    public RelativeLayout s;
    public String t;
    public String u;
    public ViewGroup v;
    public p w;
    public WeakReference<dh2.a.InterfaceC0136a> x;

    public class a implements c {
        public final /* synthetic */ ECBindCouponFragment a;

        public a(ECBindCouponFragment r1) {
            this.a = r1;
        }
    }

    public class b implements Runnable {
        public final /* synthetic */ ECBindCouponFragment a;

        @Override // java.lang.Runnable
        public final void run() {
            ECBindCouponFragment.ia0(this.a);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public b(ECBindCouponFragment r1) {
            this.a = r1;
        }
    }

    public interface c {
    }

    @Override // com.bytedance.android.livesdk.livecommerce.base.ECBaseDialogFragment
    public final int Y90() {
        return 3;
    }

    @Override // com.bytedance.android.livesdk.livecommerce.base.ECBaseDialogFragment
    public final void da0() {
    }

    @Override // com.bytedance.android.livesdk.livecommerce.base.ECBaseDialogFragment
    public final void ea0() {
    }

    @Override // com.bytedance.android.livesdk.livecommerce.base.ECBaseDialogFragment
    public final void fa0() {
    }

    @Override // com.bytedance.android.livesdk.livecommerce.base.ECBaseDialogFragment
    public final int getLayoutId() {
        return 2131560718;
    }

    @Override // com.bytedance.android.livesdk.livecommerce.base.ECBaseDialogFragment
    public final ViewGroup.MarginLayoutParams ba0() {
        FrameLayout.LayoutParams r1 = new FrameLayout.LayoutParams(-1, (int) (ECDisplayUtils.a(getContext()) * 0.73f));
        r1.gravity = 80;
        return r1;
    }

    @Override // com.bytedance.android.livesdk.livecommerce.base.ECBaseDialogFragment
    public final void dismiss() {
        if (getContext() == null) goto L15;
        Context r0 = getContext();
        EditText r1 = this.j;
        Handler r2 = k.a;
        if (r0 == null) goto L9;
        InputMethodManager r3 = (InputMethodManager) r0.getSystemService("input_method");
        if (r3 == null) goto L9;
        boolean r4 = r3.isActive(r1);
    L10:
        if (r4 == false) goto L15;
        Context r5 = getContext();
        EditText r6 = this.j;
        InputMethodManager r7 = (InputMethodManager) r5.getSystemService("input_method");
        if (r7 == null) goto L14;
        r7.hideSoftInputFromWindow(r6.getWindowToken(), 0);
        r6.clearFocus();
    L14:
        new Handler().postDelayed(new b(this), 200);
        return;
    L9:
        r4 = false;
    L15:
        ia0(this);
    }

    public ECBindCouponFragment() {
    }

    public static void ia0(ECBaseDialogFragment r1) {
        super.dismiss();     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        d.d(e, "DIALOG_FRAGMENT_DISMISS_EXCEPTION");
        Throwable r2 = DialogFragmentLancet.sLastShowStack;
        if (r2 == null) goto L11;
        d.d(r2, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        return;
    }

    @Override // com.bytedance.android.livesdk.livecommerce.base.ECBaseDialogFragment
    public final void aa0(Bundle r2) {
        if (r2 == null) goto L5;
        this.q = r2.getString("anchor_id");
        this.p = r2.getString("room_id");
        this.t = r2.getString("cipher_text");
        this.u = r2.getString("bind_notice");
        return;
    }

    @Override // com.bytedance.android.livesdk.livecommerce.base.ECBaseDialogFragment
    public final ECBottomDialog ca0(Bundle r1) {
        return super.ca0(r1);
    }

    @Override // com.bytedance.android.livesdk.livecommerce.base.ECBaseDialogFragment
    public final void onActivityCreated(Bundle r5) {
        super.onActivityCreated(r5);
        ((ECBindCouponViewModel) this.g).init(this.p);
        View r6 = getView();
        if (r6 != null) goto L6;
    L22:
        ((ECBindCouponViewModel) this.g).start();
        return;
    L6:
        if (getContext() == null) goto L22;
        View r0 = getView();
        View r1 = null;
        if (r0 == null) goto L11;
        View r2 = r0.findViewById(2131384682);
    L12:
        this.s = (RelativeLayout) r2;
        View r3 = getView();
        if (r3 == null) goto L15;
        r1 = r3.findViewById(2131390477);
    L15:
        this.r = r1;
        this.i = (ImageView) r6.findViewById(2131376031);
        EditText r4 = (EditText) r6.findViewById(2131371801);
        this.j = r4;
        String r7 = this.t;
        if (r7 == null) goto L18;
        r4.setHint(r7);
    L18:
        this.k = (TextView) r6.findViewById(2131390381);
        this.l = (TextView) r6.findViewById(2131391203);
        this.m = (ViewGroup) r6.findViewById(2131391001);
        ImageView r8 = (ImageView) r6.findViewById(2131370707);
        String r9 = this.u;
        if (r9 == null) goto L21;
        this.l.setText(r9);
    L21:
        this.o = (LinearLayout) r6.findViewById(2131378652);
        this.n = (ECNewAddCouponLayout) r6.findViewById(2131374208);
        this.k.setTextColor(th.a.a(getContext(), 2131101702));
        this.k.setEnabled(false);
        this.i.setOnClickListener(this);
        this.k.setOnClickListener(this);
        this.r.setOnClickListener(this);
        this.r.setVisibility(8);
        this.m.setVisibility(8);
        this.k.setTextSize(1, 16.0f);
        ViewGroup r10 = (ViewGroup) r6.findViewById(2131370722);
        this.v = r10;
        r10.setVisibility(0);
        this.j.addTextChangedListener(new e(this));
        this.j.setOnTouchListener(new f(this));
        this.j.postDelayed(new g(this), 300);
        goto L22
    L11:
        r2 = null;
        goto L12
    }

    @Override // com.bytedance.android.livesdk.livecommerce.base.ECBaseDialogFragment, android.view.View.OnClickListener
    public final void onClick(View r5) {
        super.onClick(r5);
        if (r5 != this.i) goto L11;
        dismiss();     // Catch: Exception -> L6
        return;
    L6:
        e = move-exception;
        d.d(e, "DIALOG_FRAGMENT_DISMISS_EXCEPTION");
        Throwable r6 = DialogFragmentLancet.sLastShowStack;
        if (r6 == null) goto L27;
        d.d(r6, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        return;
    L27:
        return;
    L11:
        if (r5 != this.k) goto L22;
        FragmentActivity r7 = getActivity();
        if (r7 == null) goto L29;
        String r0 = this.j.getEditableText().toString().replace(" ", "");
        if (TextUtils.isEmpty(r0) == false) goto L17;
        return;
    L17:
        final a r1 = new a(this);
        String r2 = h.a;
        String r3 = h.d(si2.g.s);
        h.e(null, null, r3, new j(r0, r3)).observeOn(AndroidSchedulers.mainThread()).subscribe(new eh2.a(this, r1), new eh2.b(this));
        this.v.setVisibility(8);
        EditText r4 = this.j;
        Handler r8 = k.a;
        InputMethodManager r9 = (InputMethodManager) r7.getSystemService("input_method");
        if (r9 == null) goto L20;
        r9.hideSoftInputFromWindow(r4.getWindowToken(), 0);
        r4.clearFocus();
    L20:
        this.s.requestFocus();
        return;
    L29:
        return;
    L22:
        if (r5 != this.r) goto L31;
        this.j.setText("");
        return;
    }

    @Override // com.bytedance.android.livesdk.livecommerce.base.ECBaseDialogFragment
    public final Dialog onCreateDialog(Bundle r1) {
        return super.ca0(r1);
    }

    @Override // com.bytedance.android.livesdk.livecommerce.base.ECBaseDialogFragment
    public final void onDismiss(DialogInterface r2) {
        super.onDismiss(r2);     // Catch: Throwable -> L5
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
}
