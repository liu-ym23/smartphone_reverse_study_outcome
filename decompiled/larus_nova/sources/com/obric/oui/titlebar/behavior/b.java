package com.obric.oui.titlebar.behavior;

import android.view.View;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.accessibility.AccessibilityViewCommand;
import com.obric.oui.titlebar.OUnitedTitleBar;

/* JADX INFO: loaded from: classes34.dex */
public final class b implements AccessibilityViewCommand {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ CoordinatorLayout f403522a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ OUnitedTitleBar f403523b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ View f403524c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ int f403525d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ BaseBehavior f403526e;

    @Override // androidx.core.view.accessibility.AccessibilityViewCommand
    public final boolean perform(View r100, AccessibilityViewCommand.CommandArguments r101) {
        this.f403526e.e(this.f403522a, this.f403523b, this.f403525d, new int[]{0, 0});
        return true;
    }

    public b(BaseBehavior r100, CoordinatorLayout r101, OUnitedTitleBar r102, View r103, int r104) {
        this.f403526e = r100;
        this.f403522a = r101;
        this.f403523b = r102;
        this.f403524c = r103;
        this.f403525d = r104;
    }
}
