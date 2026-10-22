package com.obric.oui.titlebar.behavior;

import android.view.View;
import androidx.core.view.accessibility.AccessibilityViewCommand;
import com.obric.oui.titlebar.OUnitedTitleBar;

/* JADX INFO: loaded from: classes34.dex */
public final class c implements AccessibilityViewCommand {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ OUnitedTitleBar f403527a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ boolean f403528b;

    public c(OUnitedTitleBar r100, boolean r101) {
        this.f403527a = r100;
        this.f403528b = r101;
    }

    @Override // androidx.core.view.accessibility.AccessibilityViewCommand
    public final boolean perform(View r100, AccessibilityViewCommand.CommandArguments r101) {
        this.f403527a.setExpanded(this.f403528b);
        return true;
    }
}
