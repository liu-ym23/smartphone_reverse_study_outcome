package com.larus.instruction.impl.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes30.dex */
public final class LarusItemActionbarTextSelectorHolderBinding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final FrameLayout f351560a;

    @Override // androidx.viewbinding.ViewBinding
    public final View getRoot() {
        return this.f351560a;
    }

    public LarusItemActionbarTextSelectorHolderBinding(FrameLayout r100) {
        this.f351560a = r100;
    }

    public static LarusItemActionbarTextSelectorHolderBinding a(LayoutInflater r100, ViewGroup r101) {
        View r102 = r100.inflate(R.layout.larus_item_actionbar_text_selector_holder, r101, false);
        if (((AppCompatTextView) ViewBindings.findChildViewById(r102, R.id.tv_item_name)) == null) goto L7;
        return new LarusItemActionbarTextSelectorHolderBinding((FrameLayout) r102);
    L7:
        throw new NullPointerException("Missing required view with ID: ".concat(r102.getResources().getResourceName(R.id.tv_item_name)));
    }
}
