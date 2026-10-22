package com.bytedance.awemeopen.apps.framework.framework.bottomsheetdialog;

import android.R;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentTransaction;
import com.bytedance.awemeopen.apps.framework.framework.AosBaseFragment;
import com.bytedance.awemeopen.apps.framework.framework.bottomsheetdialog.AosBottomSheetViewModel;
import com.google.android.material.internal.AosBottomSheetBehavior;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b&\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\b\u0012\u0004\u0012\u00028\u00000\u00032\u00020\u0004B\u0007¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/bytedance/awemeopen/apps/framework/framework/bottomsheetdialog/AosBottomSheetFragment;", "Lcom/bytedance/awemeopen/apps/framework/framework/bottomsheetdialog/AosBottomSheetViewModel;", "VM", "Lcom/bytedance/awemeopen/apps/framework/framework/AosBaseFragment;", "Lcom/bytedance/awemeopen/apps/framework/framework/bottomsheetdialog/z;", "<init>", "()V", "ao_apps_framework_release"}, k = 1, mv = {1, 7, 1})
public abstract class AosBottomSheetFragment<VM extends AosBottomSheetViewModel> extends AosBaseFragment<VM> implements z {
    public final n g;
    public final Map<Integer, View> h;

    @Override // com.bytedance.awemeopen.apps.framework.framework.AosBaseFragment
    public void S90() {
        ((LinkedHashMap) this.h).clear();
    }

    @Override // com.bytedance.awemeopen.apps.framework.framework.AosBaseFragment
    public final void ba0(Bundle r1) {
    }

    public int getBottomSheetHeight() {
        return 0;
    }

    @Override // com.bytedance.awemeopen.apps.framework.framework.AosBaseFragment
    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        S90();
    }

    public void onShow() {
    }

    public AosBottomSheetFragment() {
        this.h = new LinkedHashMap();
        this.g = new n();
    }

    @Override // com.bytedance.awemeopen.apps.framework.framework.AosBaseFragment
    public final Boolean onBackPressed() {
        n r0 = this.g;
        boolean r2 = true;
        if (r0.g != 1) goto L5;
        boolean r1 = true;
    L6:
        if (r1 == false) goto L10;
        AosBaseFragment<?> r3 = r0.a;
        if (r3 == null) goto L12;
        r0.b(r3.getActivity(), r3);
    L12:
        return Boolean.valueOf(r2);
    L10:
        r2 = false;
        goto L12
    L5:
        r1 = false;
        goto L6
    }

    public final void ea0(FragmentActivity r7) {
        Intrinsics.checkNotNullParameter("MixAwemeListDialogFragment", "tag");
        final n r2 = this.g;
        r2.getClass();
        Intrinsics.checkNotNullParameter("MixAwemeListDialogFragment", "tag");
        Intrinsics.checkNotNullParameter(this, "aosBaseFragment");
        if (r7 != null) goto L5;
    L29:
        onShow();
        return;
    L5:
        if (r2.g == 1) goto L29;
        if (r7.getSupportFragmentManager().findFragmentByTag("MixAwemeListDialogFragment") == null) goto L10;
        boolean r1 = true;
    L12:
        if (r1 == false) goto L14;
        r2.g = 3;
    L14:
        int r3 = r2.g;
        if (r3 != 2) goto L17;
    L23:
        FragmentTransaction r8 = r7.getSupportFragmentManager().beginTransaction();
        if (LandscapeRestrictionGuard.shouldBlockFragmentTransaction(r8, this, LandscapeRestrictionOperation.FRAGMENT_TRANSACTION_ADD, "MixAwemeListDialogFragment", R.id.content) == true) goto L27;
        r8 = r8.add(R.id.content, this, "MixAwemeListDialogFragment");
    L27:
        r8.commitAllowingStateLoss();
    L28:
        r2.g = 1;
        goto L29
    L17:
        if (r3 == (-1)) goto L23;
        if (r3 != 3) goto L28;
        r7.getSupportFragmentManager().beginTransaction().show(this).commitAllowingStateLoss();
        FrameLayout r9 = r2.d;
        if (r9 == null) goto L28;
        r9.post(new m(r2));
        goto L28
    L10:
        r1 = false;
        goto L12
    }

    @Override // com.bytedance.awemeopen.apps.framework.framework.AosBaseFragment
    public final View onCreateView(LayoutInflater r6, ViewGroup r7, Bundle r8) {
        Intrinsics.checkNotNullParameter(r6, "inflater");
        View r9 = r6.inflate(X90(), r7, false);
        Intrinsics.checkNotNullParameter(r9, "<set-?>");
        this.e = r9;
        final n r10 = this.g;
        View r11 = V90();
        r10.getClass();
        Intrinsics.checkNotNullParameter(this, "aosBaseFragment");
        Intrinsics.checkNotNullParameter(r11, "view");
        View r2 = null;
        if (r10.c != null) goto L18;
        r10.a = this;
        View r0 = View.inflate(getContext(), 2131558617, null);
        Intrinsics.checkNotNull(r0, "null cannot be cast to non-null type android.widget.FrameLayout");
        FrameLayout r1 = (FrameLayout) r0;
        r10.c = r1;
        Intrinsics.checkNotNull(r1);
        Intrinsics.checkNotNull(r1.findViewById(2131367947), "null cannot be cast to non-null type androidx.coordinatorlayout.widget.CoordinatorLayout");
        FrameLayout r3 = r10.c;
        Intrinsics.checkNotNull(r3);
        View r4 = r3.findViewById(2131368870);
        Intrinsics.checkNotNull(r4, "null cannot be cast to non-null type android.widget.FrameLayout");
        FrameLayout r5 = (FrameLayout) r4;
        r10.d = r5;
        Intrinsics.checkNotNull(r5);
        CoordinatorLayout.LayoutParams r12 = r5.getLayoutParams();
        Intrinsics.checkNotNull(r12, "null cannot be cast to non-null type androidx.coordinatorlayout.widget.CoordinatorLayout.LayoutParams");
        CoordinatorLayout.LayoutParams r13 = r12;
        int r14 = getBottomSheetHeight();
        if (r14 <= 0) goto L7;
        ((ViewGroup.MarginLayoutParams) r13).height = r14;
    L7:
        FrameLayout r15 = r10.d;
        Intrinsics.checkNotNull(r15);
        AosBottomSheetBehavior<FrameLayout> r16 = AosBottomSheetBehavior.from(r15);
        r10.b = r16;
        if (r16 == null) goto L11;
        r16.setHideable(true);
    L11:
        AosBottomSheetBehavior<FrameLayout> r17 = r10.b;
        if (r17 == null) goto L15;
        r17.setState(3);
    L15:
        FrameLayout r18 = r10.d;
        if (r18 == null) goto L18;
        x54.b.b(r18);
    L18:
        FrameLayout r19 = r10.c;
        if (r19 == null) goto L21;
        r2 = r19.findViewById(2131367947);
    L21:
        FrameLayout r20 = r10.d;
        if (r20 == null) goto L24;
        r20.removeAllViews();
    L24:
        FrameLayout r21 = r10.d;
        if (r21 == null) goto L27;
        r21.addView(r11);
    L27:
        if (r2 == null) goto L31;
        View r22 = r2.findViewById(2131389274);
        if (r22 == null) goto L31;
        r22.setOnClickListener(new i(r10, this));
    L31:
        FrameLayout r23 = r10.d;
        if (r23 == null) goto L34;
        r23.setOnTouchListener(new j());
    L34:
        AosBottomSheetBehavior<FrameLayout> r24 = r10.b;
        if (r24 == null) goto L37;
        r24.addBottomSheetCallback(new p(r10, this));
    L37:
        FrameLayout r25 = r10.d;
        if (r25 == null) goto L40;
        r25.post(new k(r10));
    L40:
        FrameLayout r26 = r10.c;
        VM r27 = T90();
        Intrinsics.checkNotNullParameter(r27, "<set-?>");
        this.d = r27;
        initView();
        Y90();
        return r26;
    }
}
