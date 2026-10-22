package com.bytedance.android.shopping.order;

import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModelProviders;
import com.bytedance.android.ec.core.monitor.ECExceptionMonitor;
import com.bytedance.android.ec.core.widget.ECStatusView;
import com.bytedance.android.ec.sdk.helper.o;
import com.bytedance.android.shopping.anchorv3.detail.widget.VideoHolder;
import com.bytedance.android.shopping.anchorv3.detail.widget.playerblock.PlayerBlock;
import com.bytedance.android.shopping.orderlist.common.freq.FreqActions;
import com.bytedance.common.utility.UIUtils;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.larus.apm.impl.protector.RunnableProtector;
import com.obric.assistant.interaction.impl.window.helpers.PopupOrDialogVisibilityTracker;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/shopping/order/PreviewPanelFragment;", "Lcom/google/android/material/bottomsheet/BottomSheetDialogFragment;", "<init>", "()V", "a", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class PreviewPanelFragment extends BottomSheetDialogFragment {
    public static final /* synthetic */ int y = 0;
    public com.bytedance.android.shopping.order.a d;
    public Function0<Unit> e;
    public String f;
    public List<String> g;
    public String h;
    public String i;
    public View j;
    public FrameLayout k;
    public Button l;
    public VideoHolder m;
    public TextView n;
    public TextView o;
    public float p;
    public ECStatusView q;
    public View r;
    public View s;
    public View t;
    public PreviewPanelViewModel u;
    public tl.a v;
    public cg3.g w;
    public Context x;

    public static final class a {
    }

    public static final class b implements Runnable {
        public final /* synthetic */ PreviewPanelFragment a;

        public b(PreviewPanelFragment r1) {
            this.a = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            Dialog r0 = this.a.getDialog();     // Catch: Throwable -> L8
            if (r0 == null) goto L11;
            Window r1 = r0.getWindow();     // Catch: Throwable -> L8
            if (r1 == null) goto L15;
            r1.setWindowAnimations(2131954184);     // Catch: Throwable -> L8
            return;
        L15:
            return;
        L11:
            return;
        L8:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L16;
            throw th;
        }
    }

    public static final class c implements View.OnClickListener {
        public final /* synthetic */ BottomSheetBehavior a;

        public c(BottomSheetBehavior r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r2) {
            this.a.setState(5);
        }
    }

    static {
    }

    public final void onDestroyView() {
        PreviewPanelViewModel r0 = this.u;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L5:
        Integer r1 = (Integer) r0.getPanelState().getValue();
        if (r1 != null) goto L9;
    L10:
        com.bytedance.android.shopping.order.a r2 = this.d;
        if (r2 == null) goto L13;
        r2.b();
    L13:
        ECStatusView r3 = this.q;
        if (r3 == null) goto L16;
        r3.a();
    L16:
        Function0<Unit> r4 = this.e;
        if (r4 == null) goto L19;
        Unit r5 = (Unit) r4.invoke();
    L19:
        this.e = null;
        PreviewPanelViewModel r6 = this.u;
        if (r6 != null) goto L22;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L22:
        r6.unbind();
        VideoHolder r7 = this.m;
        if (r7 == null) goto L27;
        PlayerBlock r8 = r7.g;
        if (r8 == null) goto L27;
        r8.B();
    L27:
        super/*androidx.fragment.app.DialogFragment*/.onDestroyView();
        return;
    L9:
        if (r1.intValue() == 1) goto L13;
        goto L10
    }

    public final void onPause() {
        VideoHolder r0 = this.m;
        if (r0 == null) goto L7;
        PlayerBlock r1 = r0.g;
        if (r1 == null) goto L7;
        int r2 = PlayerBlock.T;
        r1.C(false);
    L7:
        super/*androidx.fragment.app.Fragment*/.onPause();
    }

    public PreviewPanelFragment() {
        this.f = "";
        this.g = CollectionsKt.emptyList();
    }

    public final void onResume() {
        super/*androidx.fragment.app.Fragment*/.onResume();
        View r0 = getView();     // Catch: Exception -> L7
        if (r0 == null) goto L12;
        r0.postDelayed(new b(this), 300);     // Catch: Exception -> L7
        return;
    L12:
        return;
    L7:
        e = move-exception;
        ECExceptionMonitor.e(e);
    }

    public final void onStart() {
        PopupOrDialogVisibilityTracker.bindDialogFragment(this);
        LandscapeRestrictionGuard.bindDialogForAllowedDialogFragment(this);
        super/*androidx.fragment.app.DialogFragment*/.onStart();
        Dialog r0 = getDialog();
        ViewGroup.LayoutParams r2 = null;
        if ((r0 instanceof BottomSheetDialog) == true) goto L5;
        r0 = null;
    L5:
        BottomSheetDialog r1 = (BottomSheetDialog) r0;
        if (r1 == null) goto L12;
        Window r3 = r1.getWindow();
        if (r3 == null) goto L12;
        View r4 = r3.findViewById(2131368870);
        if (r4 == null) goto L12;
        r4.setBackgroundDrawable(new ColorDrawable(0));
    L12:
        if (r1 == null) goto L16;
        AppCompatDelegate r5 = r1.getDelegate();
        if (r5 == null) goto L16;
        FrameLayout r6 = (FrameLayout) r5.findViewById(2131368870);
    L17:
        if (r6 == null) goto L29;
        ViewGroup.LayoutParams r7 = r6.getLayoutParams();
        if ((r7 instanceof CoordinatorLayout.LayoutParams) == false) goto L22;
        r2 = r7;
    L22:
        CoordinatorLayout.LayoutParams r8 = (CoordinatorLayout.LayoutParams) r2;
        if (r8 == null) goto L25;
        ((ViewGroup.MarginLayoutParams) r8).height = (int) UIUtils.dip2Px(getContext(), 537.0f);
    L25:
        r6.setLayoutParams(r8);
        BottomSheetBehavior r9 = BottomSheetBehavior.from(r6);
        r9.setPeekHeight((int) UIUtils.dip2Px(getContext(), 537.0f));
        r9.setState(3);
        View r10 = this.j;
        if (r10 == null) goto L30;
        r10.setOnClickListener(new c(r9));
        return;
    L30:
        return;
    L29:
        return;
    L16:
        r6 = null;
        goto L17
    }

    public final void onCreate(Bundle r3) {
        Dialog r0 = getDialog();
        if (r0 == null) goto L5;
        r0.requestWindowFeature(1);
    L5:
        super/*androidx.fragment.app.DialogFragment*/.onCreate(r3);
    }

    public final Dialog onCreateDialog(Bundle r2) {
        Context r0 = getContext();
        Intrinsics.checkNotNull(r0);
        return new BottomSheetDialog(r0);
    }

    public final void onViewCreated(View r4, Bundle r5) {
        Intrinsics.checkNotNullParameter(r4, FreqActions.ACTION_VIEW);
        super/*androidx.fragment.app.Fragment*/.onViewCreated(r4, r5);
        FragmentActivity r6 = getActivity();
        Intrinsics.checkNotNull(r6);
        this.u = (PreviewPanelViewModel) ViewModelProviders.of(r6).get(PreviewPanelViewModel.class);
        if (r4 == null) goto L14;
        this.j = r4.findViewById(2131367003);
        this.k = (FrameLayout) r4.findViewById(2131382982);
        this.l = (Button) r4.findViewById(2131377393);
        this.n = (TextView) r4.findViewById(2131392400);
        this.o = (TextView) r4.findViewById(2131392285);
        this.q = r4.findViewById(2131378964);
        Context r0 = getContext();
        if (r0 == null) goto L10;
        ECStatusView r1 = this.q;
        if (r1 == null) goto L10;
        r1.b(r0, null, null);
    L10:
        this.r = r4.findViewById(2131379183);
        this.s = r4.findViewById(2131368744);
        this.t = r4.findViewById(2131367331);
        PreviewPanelViewModel r7 = this.u;
        if (r7 != null) goto L13;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L13:
        r7.init();
    L14:
        PreviewPanelViewModel r8 = this.u;
        if (r8 != null) goto L17;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L17:
        r8.getPanelState().observe(this, new d(this));
        PreviewPanelViewModel r9 = this.u;
        if (r9 != null) goto L20;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L20:
        r9.getShareInfoVOState().observe(this, new e(this));
        Button r10 = this.l;
        if (r10 == null) goto L23;
        r10.setOnClickListener(new PreviewPanelFragment$initSubscribe$3(this));
    L23:
        ECStatusView r11 = this.q;
        if (r11 == null) goto L26;
        r11.c();
    L26:
        this.e = o.a.a(getContext(), this.g, this.f, new AnonymousClass1(this));
    }

    public final View onCreateView(LayoutInflater r2, ViewGroup r3, Bundle r4) {
        Intrinsics.checkNotNullParameter(r2, "inflater");
        Context r5 = getContext();
        if (r5 != null) goto L7;
        return null;
    L7:
        return th.a.c(r5, 2131560462, r3, false);
    }
}
