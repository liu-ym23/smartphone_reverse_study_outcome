package com.bytedance.ee.bear.operation.view;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.crash.d;
import com.bytedance.ee.bear.bizwidget.dialogfragment.CompatLandscapeBottomSheetDialogFragment;
import com.bytedance.ee.bear.widgets.panel.CommonActionPanelLayout;
import com.bytedance.ee.bear.widgets.t;
import com.bytedance.ee.bear.widgets.universedesign.SpaceEmptyState;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.helpers.PopupOrDialogVisibilityTracker;
import com.obric.assistant.interaction.impl.window.landscape.childwindow.LandscapeChildDialogBoundsAdapter;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u00102\u00020\u0001:\u0001\u0010B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016J\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016¨\u0006\u0011"}, d2 = {"Lcom/bytedance/ee/bear/operation/view/OperationNotPermissionFragment;", "Lcom/bytedance/ee/bear/bizwidget/dialogfragment/CompatLandscapeBottomSheetDialogFragment;", "<init>", "()V", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onDismiss", "", "dialog", "Landroid/content/DialogInterface;", "Companion", "middleground-operation-impl_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class OperationNotPermissionFragment extends CompatLandscapeBottomSheetDialogFragment {
    public static final /* synthetic */ int k = 0;

    public static final class a {
    }

    public static final class b extends t {
        public final /* synthetic */ OperationNotPermissionFragment c;

        public b(OperationNotPermissionFragment r1) {
            this.c = r1;
        }

        @Override // com.bytedance.ee.bear.widgets.t
        public final void a(View r2) {
            this.c.dismissAllowingStateLoss();     // Catch: Exception -> L5
            return;
        L5:
            e = move-exception;
            d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");
            Throwable r3 = DialogFragmentLancet.sLastShowStack;
            if (r3 == null) goto L12;
            d.d(r3, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
            return;
        }
    }

    public static final class c extends CommonActionPanelLayout.b {
        public final /* synthetic */ OperationNotPermissionFragment a;

        @Override // com.bytedance.ee.bear.widgets.panel.CommonActionPanelLayout.b, com.bytedance.ee.bear.widgets.panel.CommonActionPanelLayout.a
        public final void b() {
            this.a.dismissAllowingStateLoss();     // Catch: Exception -> L5
            return;
        L5:
            e = move-exception;
            d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");
            Throwable r0 = DialogFragmentLancet.sLastShowStack;
            if (r0 == null) goto L12;
            d.d(r0, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
            return;
        }

        public c(OperationNotPermissionFragment r1) {
            this.a = r1;
        }
    }

    static {
    }

    public OperationNotPermissionFragment() {
    }

    public final void onDismiss(DialogInterface r2) {
        Intrinsics.checkNotNullParameter(r2, "dialog");     // Catch: Throwable -> L7
        super/*com.bytedance.ee.bear.bizwidget.dialogfragment.BaseBottomSheetDialogFragment*/.onDismiss(r2);     // Catch: Throwable -> L7
        FragmentActivity r3 = getActivity();     // Catch: Throwable -> L7
        if (r3 == null) goto L5;
        r3.finish();     // Catch: Throwable -> L7
    L5:
        LandscapeChildDialogBoundsAdapter.onDialogDismissed(getDialog());
        PopupOrDialogVisibilityTracker.onDialogFragmentDismissed(this);
        LandscapeRestrictionGuard.clearAllowedDialogFragment(this);
        return;
    L7:
        th = move-exception;
        LandscapeChildDialogBoundsAdapter.onDialogDismissed(getDialog());
        PopupOrDialogVisibilityTracker.onDialogFragmentDismissed(this);
        LandscapeRestrictionGuard.clearAllowedDialogFragment(this);
        throw th;
    }

    public final View onCreateView(LayoutInflater r2, ViewGroup r3, Bundle r4) {
        Intrinsics.checkNotNullParameter(r2, "inflater");
        View r5 = r2.inflate(2131558797, r3, false);
        SpaceEmptyState r6 = (SpaceEmptyState) r5.findViewById(2131391810);
        if (r6 == null) goto L5;
        r6.setImageRes(2131232545);
    L5:
        if (r6 == null) goto L7;
        r6.setTitle(getString(2131887114));
    L7:
        if (r6 == null) goto L9;
        r6.setDesc(getString(2131887113));
    L9:
        if (r6 == null) goto L11;
        r6.setPrimaryText(getString(2131887115));
    L11:
        if (r6 == null) goto L13;
        r6.setPrimaryClickListener(new b(this));
    L13:
        ((CommonActionPanelLayout) r5.findViewById(2131388889)).setOnActionListener(new c(this));
        return r5;
    }
}
