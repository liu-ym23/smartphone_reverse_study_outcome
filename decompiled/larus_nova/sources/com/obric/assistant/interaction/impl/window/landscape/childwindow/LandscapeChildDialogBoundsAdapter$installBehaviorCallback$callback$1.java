package com.obric.assistant.interaction.impl.window.landscape.childwindow;

import android.view.View;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes33.dex */
@Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0018\u0010\b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\nH\u0016¨\u0006\u000b"}, d2 = {"com/obric/assistant/interaction/impl/window/landscape/childwindow/LandscapeChildDialogBoundsAdapter$installBehaviorCallback$callback$1", "Lcom/google/android/material/bottomsheet/BottomSheetBehavior$BottomSheetCallback;", "onStateChanged", "", "bottomSheet", "Landroid/view/View;", "newState", "", "onSlide", "slideOffset", "", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class LandscapeChildDialogBoundsAdapter$installBehaviorCallback$callback$1 extends BottomSheetBehavior.BottomSheetCallback {
    final /* synthetic */ LandscapeChildDialogBoundsAdapter.BoundsState $state;

    public static /* synthetic */ void a(LandscapeChildDialogBoundsAdapter.BoundsState r100, int r101) {
        onStateChanged$lambda$0(r100, r101);
    }

    public static /* synthetic */ void b(LandscapeChildDialogBoundsAdapter.BoundsState r100) {
        onSlide$lambda$1(r100);
    }

    public LandscapeChildDialogBoundsAdapter$installBehaviorCallback$callback$1(LandscapeChildDialogBoundsAdapter.BoundsState r100) {
        this.$state = r100;
    }

    private static final void onSlide$lambda$1(LandscapeChildDialogBoundsAdapter.BoundsState r100) {
        LandscapeChildDialogBoundsAdapter.access$restoreStableBounds(LandscapeChildDialogBoundsAdapter.INSTANCE, r100, "slide");
    }

    private static final void onStateChanged$lambda$0(LandscapeChildDialogBoundsAdapter.BoundsState r100, int r101) {
        LandscapeChildDialogBoundsAdapter.access$restoreStableBounds(LandscapeChildDialogBoundsAdapter.INSTANCE, r100, "state:" + r101);
    }

    @Override // com.google.android.material.bottomsheet.BottomSheetBehavior.BottomSheetCallback
    public void onSlide(View r100, float r101) {
        Intrinsics.checkNotNullParameter(r100, "bottomSheet");
        if (this.$state.isHidden() == false) goto L5;
        return;
    L5:
        final LandscapeChildDialogBoundsAdapter.BoundsState r102 = this.$state;
        r100.post(new k(r102));
    }

    @Override // com.google.android.material.bottomsheet.BottomSheetBehavior.BottomSheetCallback
    public void onStateChanged(View r100, final int r101) {
        Intrinsics.checkNotNullParameter(r100, "bottomSheet");
        this.$state.setCurrentBehaviorState(Integer.valueOf(r101));
        if (r101 != 5) goto L6;
        this.$state.setHidden(true);
        return;
    L6:
        this.$state.setHidden(false);
        final LandscapeChildDialogBoundsAdapter.BoundsState r102 = this.$state;
        r100.post(new j(r102, r101));
    }
}
