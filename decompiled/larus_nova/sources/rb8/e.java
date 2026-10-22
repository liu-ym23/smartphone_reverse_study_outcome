package rb8;

import android.view.View;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.larus.bmhome.block.presentation.BlockDetailDialogFragment;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
public final class e extends BottomSheetBehavior.BottomSheetCallback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ BlockDetailDialogFragment f536981a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ BottomSheetBehavior<View> f536982b;

    public e(BlockDetailDialogFragment r100, BottomSheetBehavior<View> r101) {
        this.f536981a = r100;
        this.f536982b = r101;
    }

    @Override // com.google.android.material.bottomsheet.BottomSheetBehavior.BottomSheetCallback
    public final void onSlide(View r100, float r101) {
        Intrinsics.checkNotNullParameter(r100, "bottomSheet");
        if (this.f536981a.f296405f == true) goto L5;
    L10:
        this.f536981a.T90(r100);
        return;
    L5:
        if (r101 > 0.05f) goto L10;
        if (this.f536982b.getState() == 5) goto L10;
        this.f536982b.setState(5);
    }

    @Override // com.google.android.material.bottomsheet.BottomSheetBehavior.BottomSheetCallback
    public final void onStateChanged(View r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "bottomSheet");
        if (r101 != 3) goto L5;
        this.f536981a.f296405f = true;
        this.f536982b.setSkipCollapsed(true);
    L21:
        BlockDetailDialogFragment r102 = this.f536981a;
        int r103 = BlockDetailDialogFragment.f296402i;
        r102.T90(r100);
        return;
    L5:
        if (r101 == 4) goto L17;
        if (r101 != 5) goto L21;
        this.f536981a.dismissAllowingStateLoss();     // Catch: Exception -> L11
        return;
    L11:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");
        Throwable r104 = DialogFragmentLancet.sLastShowStack;
        if (r104 == null) goto L25;
        com.bytedance.crash.d.d(r104, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        return;
    L25:
        return;
    L17:
        if (this.f536981a.f296405f == false) goto L21;
        this.f536982b.setState(5);
    }
}
