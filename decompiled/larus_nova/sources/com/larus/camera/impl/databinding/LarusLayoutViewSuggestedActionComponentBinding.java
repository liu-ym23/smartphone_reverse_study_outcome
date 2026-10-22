package com.larus.camera.impl.databinding;

import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.larus.common_ui.view.SuggestedActionBar;

/* JADX INFO: loaded from: classes26.dex */
public final class LarusLayoutViewSuggestedActionComponentBinding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ConstraintLayout f321537a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final SuggestedActionBar f321538b;

    @Override // androidx.viewbinding.ViewBinding
    public final View getRoot() {
        return this.f321537a;
    }

    public LarusLayoutViewSuggestedActionComponentBinding(ConstraintLayout r100, SuggestedActionBar r101) {
        this.f321537a = r100;
        this.f321538b = r101;
    }
}
