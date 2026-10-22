package com.larus.mainbot.impl.databinding;

import android.view.View;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes30.dex */
public final class LarusPageDeepResearchErrorBinding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ConstraintLayout f358811a;

    @Override // androidx.viewbinding.ViewBinding
    public final View getRoot() {
        return this.f358811a;
    }

    public LarusPageDeepResearchErrorBinding(ConstraintLayout r100) {
        this.f358811a = r100;
    }

    public static LarusPageDeepResearchErrorBinding a(View r100) {
        int r101 = R.id.deep_research_error_icon;
        if (((AppCompatImageView) ViewBindings.findChildViewById(r100, R.id.deep_research_error_icon)) == null) goto L9;
        r101 = R.id.deep_research_error_text;
        if (((AppCompatTextView) ViewBindings.findChildViewById(r100, R.id.deep_research_error_text)) == null) goto L9;
        return new LarusPageDeepResearchErrorBinding((ConstraintLayout) r100);
    L9:
        throw new NullPointerException("Missing required view with ID: ".concat(r100.getResources().getResourceName(r101)));
    }
}
