package com.larus.agents.impl.ui;

import android.app.Dialog;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.larus.bmhome.chat.component.util.PaneAwareBottomSheetController;
import com.larus.common_ui.dialog.RoundedBottomSheetDialogFragment;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

/* JADX INFO: loaded from: classes24.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b \u0018\u0000 \u001c2\u00020\u0001:\u0001\u001cB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0016J\u0010\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0013H\u0004J\b\u0010\u0015\u001a\u00020\u0016H\u0004J\u001e\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0018\u001a\u00020\u00132\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00130\u001aH\u0014J\b\u0010\u001b\u001a\u00020\u0016H\u0016R\u001b\u0010\u0004\u001a\u00020\u00058BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007R\u0014\u0010\n\u001a\u00020\u000b8TX\u0094\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\r¨\u0006\u001d"}, d2 = {"Lcom/larus/agents/impl/ui/ExpandedTaskBottomSheetFragment;", "Lcom/larus/common_ui/dialog/RoundedBottomSheetDialogFragment;", "<init>", "()V", "paneAwareController", "Lcom/larus/bmhome/chat/component/util/PaneAwareBottomSheetController;", "getPaneAwareController", "()Lcom/larus/bmhome/chat/component/util/PaneAwareBottomSheetController;", "paneAwareController$delegate", "Lkotlin/Lazy;", "roundedBottomSheetBackgroundRes", "", "getRoundedBottomSheetBackgroundRes", "()I", "onCreateDialog", "Landroid/app/Dialog;", "savedInstanceState", "Landroid/os/Bundle;", "wrapContent", "Landroid/view/View;", "content", "onSheetViewCreated", "", "onRoundedBottomSheetReady", "bottomSheet", "behavior", "Lcom/google/android/material/bottomsheet/BottomSheetBehavior;", "onDestroyView", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public abstract class ExpandedTaskBottomSheetFragment extends RoundedBottomSheetDialogFragment {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final /* synthetic */ int f286715e = 0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Lazy f286716d;

    public static final class a {
    }

    static {
    }

    @Override // com.larus.common_ui.dialog.RoundedBottomSheetDialogFragment
    public int S90() {
        return R.drawable.larus_bg_task_mode_bottom_sheet;
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        ((PaneAwareBottomSheetController) this.f286716d.getValue()).e();
        super.onDestroyView();
    }

    public ExpandedTaskBottomSheetFragment() {
        this.f286716d = LazyKt.lazy(new com.larus.agents.impl.ui.a(this));
    }

    public final View W90(View r100) {
        Intrinsics.checkNotNullParameter(r100, "content");
        return ((PaneAwareBottomSheetController) this.f286716d.getValue()).f(requireContext(), r100);
    }

    @Override // com.google.android.material.bottomsheet.BottomSheetDialogFragment, androidx.appcompat.app.AppCompatDialogFragment, androidx.fragment.app.DialogFragment
    public final Dialog onCreateDialog(Bundle r100) {
        return ((PaneAwareBottomSheetController) this.f286716d.getValue()).b();
    }

    @Override // com.larus.common_ui.dialog.RoundedBottomSheetDialogFragment
    public final void V90(View r100, BottomSheetBehavior<View> r101) {
        Intrinsics.checkNotNullParameter(r100, "bottomSheet");
        Intrinsics.checkNotNullParameter(r101, "behavior");
        Object r102 = r100.getParent();
        ViewGroup.LayoutParams r103 = null;
        if ((r102 instanceof View) == false) goto L5;
        View r104 = (View) r102;
    L7:
        if (r104 == null) goto L17;
        Integer r105 = Integer.valueOf(r104.getHeight());
        if (r105.intValue() <= 0) goto L11;
        boolean r106 = true;
    L12:
        if (r106 == true) goto L15;
        r105 = null;
    L15:
        if (r105 == null) goto L17;
        int r107 = r105.intValue();
    L18:
        int r108 = MathKt.roundToInt(r107 * 0.95f);
        ViewGroup.LayoutParams r109 = r100.getLayoutParams();
        if (r109 == null) goto L21;
        r109.height = r108;
        r103 = r109;
    L21:
        r100.setLayoutParams(r103);
        r100.requestLayout();
        r101.setPeekHeight(r108);
        r101.setSkipCollapsed(true);
        r101.setState(3);
        return;
    L11:
        r106 = false;
    L17:
        Resources r110 = getResources();
        r107 = WindowDisplayMetricsOverride.apply(r110, r110.getDisplayMetrics()).heightPixels;
        goto L18
    L5:
        r104 = null;
        goto L7
    }
}
